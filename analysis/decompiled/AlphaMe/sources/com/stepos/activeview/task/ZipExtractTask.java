package com.stepos.activeview.task;

import B0.g;
import android.content.Context;
import android.os.AsyncTask;
import com.stepos.activeview.listener.OnZipExtractListener;
import com.stepos.activeview.utils.ActiveUsageStatsUtils;
import com.stepos.activeview.utils.FileUtil;
import com.stepos.activeview.utils.LogUtil;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class ZipExtractTask extends AsyncTask<Void, Integer, Long> {
    private static final String LOG_TAG = "activeview.ZipExtractTask";
    private WeakReference<Context> mContext;
    private String mExtractedDir;
    private String mFilePath;
    private boolean mFromAssets;
    private OnZipExtractListener mListener;
    private File mOutput;
    private String mSpecifiedOutputPath;
    private boolean useSpecifiedPath;

    public ZipExtractTask(String str, Context context, OnZipExtractListener onZipExtractListener) {
        this.useSpecifiedPath = false;
        this.mSpecifiedOutputPath = null;
        this.mListener = onZipExtractListener;
        this.mFilePath = str;
        if (context != null) {
            this.mContext = new WeakReference<>(context);
        }
        this.mFromAssets = false;
    }

    private static void deleteZipFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            if (file.delete()) {
                LogUtil.i(LOG_TAG, "Delete file:" + file.toString() + " after extracted.");
                return;
            }
            LogUtil.i(LOG_TAG, "Can't delete file:" + file.toString() + " after extracted.");
        }
    }

    private void initOutput(String str) {
        File file = new File(str);
        this.mOutput = file;
        this.mExtractedDir = file.getAbsolutePath();
        LogUtil.i(LOG_TAG, "Extract mOutput file = " + this.mOutput.toString());
        if (this.mOutput.exists() || this.mOutput.mkdirs()) {
            return;
        }
        recordException("Failed to make directories:" + this.mOutput.getAbsolutePath(), this.mFilePath);
        OnZipExtractListener onZipExtractListener = this.mListener;
        if (onZipExtractListener != null) {
            onZipExtractListener.onExtractError("Failed to make directories:" + this.mOutput.getAbsolutePath());
        }
    }

    private static void recordException(String str, String str2) {
        ActiveUsageStatsUtils.recordException(str2, str);
    }

    public static boolean unzip(String str, String str2) {
        StringBuilder sbV = g.v(str2, "/");
        sbV.append(FileUtil.getDirNameByFile(str));
        File file = new File(sbV.toString());
        return (file.exists() || file.mkdirs()) && -1 != unzip(str, null, file, file.getAbsolutePath());
    }

    public void clearTask() {
        WeakReference<Context> weakReference = this.mContext;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.mContext = null;
        this.mListener = null;
    }

    public String doUnzipSync() {
        if (this.useSpecifiedPath) {
            initOutput(this.mSpecifiedOutputPath + "/" + FileUtil.getDirNameByFile(this.mFilePath));
        } else {
            StringBuilder sbV = g.v(FileUtil.getActiveViewCachesDir(this.mContext.get()), "/");
            sbV.append(FileUtil.getDirNameByFile(this.mFilePath));
            initOutput(sbV.toString());
        }
        if (unzip(this.mFilePath, this.mListener, this.mOutput, this.mExtractedDir) > 0) {
            return this.mExtractedDir;
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        super.onCancelled();
        clearTask();
    }

    public long unzipFromAssetsFile() {
        Context context;
        WeakReference<Context> weakReference = this.mContext;
        if (weakReference != null && (context = weakReference.get()) != null) {
            try {
                this.mExtractedDir = FileUtil.unZipFromInputStream(context.getAssets().open(this.mFilePath), this.mOutput.toString(), false);
                return 0L;
            } catch (IOException e4) {
                OnZipExtractListener onZipExtractListener = this.mListener;
                if (onZipExtractListener != null) {
                    onZipExtractListener.onExtractError("Extracted IOException:" + e4.toString());
                }
                recordException(e4.toString(), this.mFilePath);
            }
        }
        return -1L;
    }

    @Override // android.os.AsyncTask
    public Long doInBackground(Void... voidArr) {
        Context context = this.mContext.get();
        if (context == null) {
            return -1L;
        }
        if (this.useSpecifiedPath) {
            initOutput(this.mSpecifiedOutputPath + "/" + FileUtil.getDirNameByFile(this.mFilePath));
            return Long.valueOf(unzip(this.mFilePath, this.mListener, this.mOutput, this.mExtractedDir));
        }
        String activeViewCachesDir = FileUtil.getActiveViewCachesDir(context);
        LogUtil.d(LOG_TAG, "doInBackground outputDir:" + activeViewCachesDir);
        initOutput(activeViewCachesDir + "/" + FileUtil.getDirNameByFile(this.mFilePath));
        return this.mFromAssets ? Long.valueOf(unzipFromAssetsFile()) : Long.valueOf(unzip(this.mFilePath, this.mListener, this.mOutput, this.mExtractedDir));
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Long l4) {
        if (isCancelled()) {
            this.mListener = null;
            return;
        }
        if (this.mListener != null) {
            if (l4.longValue() != -1) {
                this.mListener.onExtractFinished(1, this.mExtractedDir);
                deleteZipFile(this.mFilePath);
            } else {
                this.mListener.onExtractFinished(0, "Extract File ERROR. File=" + this.mFilePath);
            }
            this.mListener = null;
        }
    }

    public ZipExtractTask(Context context, String str, boolean z4, OnZipExtractListener onZipExtractListener) {
        this.useSpecifiedPath = false;
        this.mSpecifiedOutputPath = null;
        this.mListener = onZipExtractListener;
        if (context != null) {
            this.mContext = new WeakReference<>(context);
        }
        this.mFromAssets = z4;
        this.mFilePath = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0178 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0157 A[Catch: all -> 0x014b, TRY_ENTER, TryCatch #5 {all -> 0x014b, blocks: (B:6:0x0022, B:58:0x0157, B:59:0x016f, B:73:0x01b4, B:74:0x01ce), top: B:95:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01b4 A[Catch: all -> 0x014b, TRY_ENTER, TryCatch #5 {all -> 0x014b, blocks: (B:6:0x0022, B:58:0x0157, B:59:0x016f, B:73:0x01b4, B:74:0x01ce), top: B:95:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x021c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static long unzip(java.lang.String r20, com.stepos.activeview.listener.OnZipExtractListener r21, java.io.File r22, java.lang.String r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 614
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.activeview.task.ZipExtractTask.unzip(java.lang.String, com.stepos.activeview.listener.OnZipExtractListener, java.io.File, java.lang.String):long");
    }

    public ZipExtractTask(Context context, String str, String str2, OnZipExtractListener onZipExtractListener) {
        this.useSpecifiedPath = false;
        this.mSpecifiedOutputPath = null;
        this.mListener = onZipExtractListener;
        this.mFilePath = str;
        if (context != null) {
            this.mContext = new WeakReference<>(context);
        }
        this.mFromAssets = false;
        this.useSpecifiedPath = true;
        this.mSpecifiedOutputPath = str2;
    }

    public ZipExtractTask(String str, Context context) {
        this(str, context, null);
        LogUtil.i(LOG_TAG, "Extract Destination dir = " + this.mExtractedDir);
    }
}
