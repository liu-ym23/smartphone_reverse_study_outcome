package com.stepos.config.dag.cloud;

import android.util.Log;
import com.stepos.config.dag.ConfigBean;
import com.stepos.config.dag.JsonConfigInitializer;
import com.stepos.config.dag.cloud.CloudConfigSource;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class CloudAwareJsonConfigInitializer<T extends ConfigBean> extends JsonConfigInitializer<T> {
    private static final int BUFFER_SIZE = 8192;
    private static final String DEFAULT_CLOUD_DIR = "/data/system/perf";

    protected abstract String getCloudFileName();

    protected abstract String getCloudKey();

    protected String getCloudDir() {
        return DEFAULT_CLOUD_DIR;
    }

    protected String getVersionFieldName() {
        return "version";
    }

    protected String getCurrentVersion() {
        T cfg = getConfig();
        if (cfg == null) {
            return "";
        }
        try {
            Object v = cfg.getClass().getMethod("getVersion", new Class[0]).invoke(cfg, new Object[0]);
            return v == null ? "" : v.toString();
        } catch (NoSuchMethodException e) {
            return "";
        } catch (Throwable t) {
            Log.w(getLogTag(), "getCurrentVersion via reflection failed", t);
            return "";
        }
    }

    protected boolean isDowngrade(String current, String incoming) {
        return (current == null || current.isEmpty() || incoming.compareTo(current) >= 0) ? false : true;
    }

    public void enableCloudUpdates() {
        CloudConfigBridge.subscribe(getCloudKey(), new CloudConfigSource.Callback() { // from class: com.stepos.config.dag.cloud.CloudAwareJsonConfigInitializer$$ExternalSyntheticLambda0
            @Override // com.stepos.config.dag.cloud.CloudConfigSource.Callback
            public final CloudConfigResult apply(String str, InputStream inputStream) {
                return this.f$0.onCloudPushed(str, inputStream);
            }
        });
        Log.i(getLogTag(), "cloud subscription requested, key=" + getCloudKey());
    }

    public void disableCloudUpdates() {
        CloudConfigBridge.unsubscribe(getCloudKey());
    }

    protected CloudConfigResult onCloudPushed(String key, InputStream in) {
        String curVer;
        String tag = getLogTag();
        String fileName = getCloudFileName();
        try {
            byte[] payload = drain(in);
            if (payload.length == 0) {
                Log.w(tag, "empty payload, file=" + fileName);
                return CloudConfigResult.VALUE_EMPTY;
            }
            try {
                JSONObject root = new JSONObject(new String(payload, StandardCharsets.UTF_8));
                String newVer = root.optString(getVersionFieldName(), "");
                if (newVer.isEmpty()) {
                    Log.w(tag, "missing version field '" + getVersionFieldName() + "', file=" + fileName);
                    return CloudConfigResult.VALUE_FORMAT_ERROR;
                }
                try {
                    curVer = getCurrentVersion();
                    if (curVer == null) {
                        curVer = "";
                    }
                } catch (Throwable t) {
                    Log.w(tag, "getCurrentVersion threw, treat as empty", t);
                    curVer = "";
                }
                if (isDowngrade(curVer, newVer)) {
                    Log.w(tag, "downgrade rejected, file=" + fileName + ", current=" + curVer + ", incoming=" + newVer);
                    return CloudConfigResult.VERSION_DOWNGRADE;
                }
                try {
                    writeAtomically(payload);
                    try {
                        applyReload();
                        Log.i(tag, "cloud config applied, file=" + fileName + ", version=" + newVer);
                        return CloudConfigResult.SUCCESS;
                    } catch (Throwable t2) {
                        Log.e(tag, "reload failed, file=" + fileName, t2);
                        return CloudConfigResult.INNER_ERROR;
                    }
                } catch (IOException e) {
                    Log.e(tag, "persist failed, file=" + fileName, e);
                    return CloudConfigResult.FILE_IO_ERROR;
                }
            } catch (Throwable t3) {
                Log.w(tag, "parse JSON failed, file=" + fileName, t3);
                return CloudConfigResult.VALUE_FORMAT_ERROR;
            }
        } catch (IOException e2) {
            Log.e(tag, "drain failed, file=" + fileName, e2);
            return CloudConfigResult.FILE_IO_ERROR;
        }
    }

    protected void applyReload() {
        reloadConfig();
    }

    private void writeAtomically(byte[] payload) throws IOException {
        File dir = new File(getCloudDir());
        if (!dir.exists() && !dir.mkdirs()) {
            throw new IOException("mkdirs failed: " + dir.getPath());
        }
        File target = new File(dir, getCloudFileName());
        File tmp = new File(dir, getCloudFileName() + ".tmp");
        FileOutputStream out = new FileOutputStream(tmp);
        try {
            out.write(payload);
            out.getFD().sync();
            out.close();
            if (!tmp.renameTo(target)) {
                tmp.delete();
                throw new IOException("rename failed: " + tmp.getPath() + " -> " + target.getPath());
            }
        } catch (Throwable th) {
            try {
                out.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static byte[] drain(InputStream in) throws IOException {
        if (in == null) {
            return new byte[0];
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[8192];
        while (true) {
            int n = in.read(buf);
            if (n > 0) {
                out.write(buf, 0, n);
            } else {
                return out.toByteArray();
            }
        }
    }
}
