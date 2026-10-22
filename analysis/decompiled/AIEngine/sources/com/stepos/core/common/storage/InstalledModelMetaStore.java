package com.stepos.core.common.storage;

import a0.a;
import android.content.Context;
import android.util.Log;
import gc.q;
import java.io.File;
import java.io.IOException;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;
import lb.n;
import org.json.JSONObject;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class InstalledModelMetaStore {
    private static final String FILE = "installed_model_meta.json";
    private static final String KEY_DISPLAY_KEY = "displayKey";
    private static final String KEY_SIZE = "size";
    private static final String KEY_UPDATE_INFO = "updateInfo";
    private static final String KEY_UPDATE_TIME = "updateTime";
    private static final String LEGACY_SIZE_FILE = "installed_model_size.json";
    private static final String TAG = "InstalledModelMetaStore";
    public static final InstalledModelMetaStore INSTANCE = new InstalledModelMetaStore();
    private static final Object lock = new Object();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Meta {
        private final long sizeBytes;
        private final String updateInfo;
        private final long updateTimeMs;

        public Meta(long j10, String updateInfo, long j11) {
            g.f(updateInfo, "updateInfo");
            this.sizeBytes = j10;
            this.updateInfo = updateInfo;
            this.updateTimeMs = j11;
        }

        public static /* synthetic */ Meta copy$default(Meta meta, long j10, String str, long j11, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                j10 = meta.sizeBytes;
            }
            long j12 = j10;
            if ((i10 & 2) != 0) {
                str = meta.updateInfo;
            }
            String str2 = str;
            if ((i10 & 4) != 0) {
                j11 = meta.updateTimeMs;
            }
            return meta.copy(j12, str2, j11);
        }

        public final long component1() {
            return this.sizeBytes;
        }

        public final String component2() {
            return this.updateInfo;
        }

        public final long component3() {
            return this.updateTimeMs;
        }

        public final Meta copy(long j10, String updateInfo, long j11) {
            g.f(updateInfo, "updateInfo");
            return new Meta(j10, updateInfo, j11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Meta)) {
                return false;
            }
            Meta meta = (Meta) obj;
            return this.sizeBytes == meta.sizeBytes && g.b(this.updateInfo, meta.updateInfo) && this.updateTimeMs == meta.updateTimeMs;
        }

        public final long getSizeBytes() {
            return this.sizeBytes;
        }

        public final String getUpdateInfo() {
            return this.updateInfo;
        }

        public final long getUpdateTimeMs() {
            return this.updateTimeMs;
        }

        public int hashCode() {
            return Long.hashCode(this.updateTimeMs) + d.a(Long.hashCode(this.sizeBytes) * 31, 31, this.updateInfo);
        }

        public String toString() {
            return a.d(this.updateTimeMs, ", updateTimeMs=", ")", a.o("Meta(sizeBytes=", this.sizeBytes, ", updateInfo=", this.updateInfo));
        }
    }

    private InstalledModelMetaStore() {
    }

    private final Meta legacySizeMeta(Context context, String str) {
        Object objA;
        try {
            objA = Long.valueOf(readJsonLocked(context, LEGACY_SIZE_FILE).optLong(str));
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = 0L;
        }
        long jLongValue = ((Number) objA).longValue();
        if (jLongValue > 0) {
            return new Meta(jLongValue, "", 0L);
        }
        return null;
    }

    private final Meta parseEntry(JSONObject jSONObject, String str) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
        if (jSONObjectOptJSONObject == null) {
            return null;
        }
        long jOptLong = jSONObjectOptJSONObject.optLong(KEY_SIZE);
        String strOptString = jSONObjectOptJSONObject.optString("updateInfo");
        g.e(strOptString, "optString(...)");
        return new Meta(jOptLong, strOptString, jSONObjectOptJSONObject.optLong(KEY_UPDATE_TIME));
    }

    private final JSONObject readJsonLocked(Context context, String str) {
        Object objA;
        File file = new File(context.getFilesDir(), str);
        if (!file.isFile()) {
            return new JSONObject();
        }
        try {
            objA = new JSONObject(wb.d.Z(file, gc.a.f9106b));
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (Result.b(objA) != null) {
            objA = new JSONObject();
        }
        return (JSONObject) objA;
    }

    private final JSONObject readRootLocked(Context context) {
        return readJsonLocked(context, FILE);
    }

    private final void writeRootLocked(Context context, JSONObject jSONObject) throws IOException {
        File file = new File(context.getFilesDir(), FILE);
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        String string = jSONObject.toString();
        g.e(string, "toString(...)");
        wb.d.e0(file, string);
    }

    public final String getDisplayKey(Context context, String otaName) {
        Object objA;
        String str;
        g.f(context, "context");
        g.f(otaName, "otaName");
        Object obj = null;
        if (q.t0(otaName)) {
            return null;
        }
        synchronized (lock) {
            try {
                JSONObject jSONObjectOptJSONObject = INSTANCE.readRootLocked(context).optJSONObject(otaName);
                objA = (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has(KEY_DISPLAY_KEY)) ? jSONObjectOptJSONObject.optString(KEY_DISPLAY_KEY) : null;
            } catch (Throwable th) {
                objA = c.a(th);
            }
            if (!(objA instanceof Result.Failure)) {
                obj = objA;
            }
            str = (String) obj;
        }
        return str;
    }

    public final Meta getMeta(Context context, String otaName) {
        Object objA;
        Meta metaLegacySizeMeta;
        g.f(context, "context");
        g.f(otaName, "otaName");
        Object obj = null;
        if (q.t0(otaName)) {
            return null;
        }
        synchronized (lock) {
            InstalledModelMetaStore installedModelMetaStore = INSTANCE;
            try {
                objA = installedModelMetaStore.parseEntry(installedModelMetaStore.readRootLocked(context), otaName);
            } catch (Throwable th) {
                objA = c.a(th);
            }
            if (!(objA instanceof Result.Failure)) {
                obj = objA;
            }
            metaLegacySizeMeta = (Meta) obj;
            if (metaLegacySizeMeta == null) {
                metaLegacySizeMeta = INSTANCE.legacySizeMeta(context, otaName);
            }
        }
        return metaLegacySizeMeta;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0083 A[Catch: all -> 0x002d, PHI: r15
      0x0083: PHI (r15v12 java.lang.Long) = (r15v4 java.lang.Long), (r15v6 java.lang.Long) binds: [B:37:0x0081, B:44:0x0098] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {all -> 0x002d, blocks: (B:8:0x001e, B:10:0x0028, B:13:0x0031, B:18:0x0043, B:26:0x005d, B:29:0x0069, B:33:0x0073, B:38:0x0083, B:45:0x0099, B:47:0x00a4, B:49:0x00aa, B:50:0x00af, B:41:0x008c, B:21:0x004b, B:24:0x0057), top: B:69:0x001e, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a4 A[Catch: all -> 0x002d, TryCatch #1 {all -> 0x002d, blocks: (B:8:0x001e, B:10:0x0028, B:13:0x0031, B:18:0x0043, B:26:0x005d, B:29:0x0069, B:33:0x0073, B:38:0x0083, B:45:0x0099, B:47:0x00a4, B:49:0x00aa, B:50:0x00af, B:41:0x008c, B:21:0x004b, B:24:0x0057), top: B:69:0x001e, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00dd A[Catch: all -> 0x00e7, TryCatch #0 {all -> 0x00e7, blocks: (B:7:0x001c, B:53:0x00d7, B:55:0x00dd, B:58:0x00ea, B:62:0x00f0, B:52:0x00d3, B:8:0x001e, B:10:0x0028, B:13:0x0031, B:18:0x0043, B:26:0x005d, B:29:0x0069, B:33:0x0073, B:38:0x0083, B:45:0x0099, B:47:0x00a4, B:49:0x00aa, B:50:0x00af, B:41:0x008c, B:21:0x004b, B:24:0x0057), top: B:67:0x001c, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.core.common.storage.InstalledModelMetaStore.Meta mergeMeta(android.content.Context r13, java.lang.String r14, com.stepos.core.common.storage.InstalledModelMetaStore.Meta r15) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.common.storage.InstalledModelMetaStore.mergeMeta(android.content.Context, java.lang.String, com.stepos.core.common.storage.InstalledModelMetaStore$Meta):com.stepos.core.common.storage.InstalledModelMetaStore$Meta");
    }

    public final void putDisplayKey(Context context, String otaName, String key) {
        Object objA;
        g.f(context, "context");
        g.f(otaName, "otaName");
        g.f(key, "key");
        if (q.t0(otaName)) {
            return;
        }
        synchronized (lock) {
            InstalledModelMetaStore installedModelMetaStore = INSTANCE;
            try {
                JSONObject rootLocked = installedModelMetaStore.readRootLocked(context);
                JSONObject jSONObjectOptJSONObject = rootLocked.optJSONObject(otaName);
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                }
                if (!g.b(jSONObjectOptJSONObject.optString(KEY_DISPLAY_KEY), key) || !jSONObjectOptJSONObject.has(KEY_DISPLAY_KEY)) {
                    jSONObjectOptJSONObject.put(KEY_DISPLAY_KEY, key);
                    rootLocked.put(otaName, jSONObjectOptJSONObject);
                    installedModelMetaStore.writeRootLocked(context, rootLocked);
                }
                objA = n.f10413a;
            } catch (Throwable th) {
                objA = c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                Log.w(TAG, "putDisplayKey failed: ".concat(otaName), thB);
            }
        }
    }

    public final void remove(Context context, String otaName) {
        Object objA;
        g.f(context, "context");
        g.f(otaName, "otaName");
        if (q.t0(otaName)) {
            return;
        }
        synchronized (lock) {
            InstalledModelMetaStore installedModelMetaStore = INSTANCE;
            try {
                JSONObject rootLocked = installedModelMetaStore.readRootLocked(context);
                if (rootLocked.has(otaName)) {
                    rootLocked.remove(otaName);
                    installedModelMetaStore.writeRootLocked(context, rootLocked);
                }
                JSONObject jsonLocked = installedModelMetaStore.readJsonLocked(context, LEGACY_SIZE_FILE);
                if (jsonLocked.has(otaName)) {
                    jsonLocked.remove(otaName);
                    File file = new File(context.getFilesDir(), LEGACY_SIZE_FILE);
                    String string = jsonLocked.toString();
                    g.e(string, "toString(...)");
                    wb.d.e0(file, string);
                }
                objA = n.f10413a;
            } catch (Throwable th) {
                objA = c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                Log.w(TAG, "remove failed: ".concat(otaName), thB);
            }
        }
    }

    public final Meta replaceMeta(Context context, String otaName, Meta incoming) {
        Object objA;
        Meta meta;
        long j10;
        g.f(context, "context");
        g.f(otaName, "otaName");
        g.f(incoming, "incoming");
        Object obj = null;
        if (q.t0(otaName)) {
            return null;
        }
        synchronized (lock) {
            try {
                InstalledModelMetaStore installedModelMetaStore = INSTANCE;
                try {
                    long sizeBytes = incoming.getSizeBytes();
                    if (sizeBytes < 0) {
                        sizeBytes = 0;
                        j10 = 0;
                    } else {
                        j10 = 0;
                    }
                    String updateInfo = incoming.getUpdateInfo();
                    long updateTimeMs = incoming.getUpdateTimeMs();
                    if (updateTimeMs >= j10) {
                        j10 = updateTimeMs;
                    }
                    Meta meta2 = new Meta(sizeBytes, updateInfo, j10);
                    JSONObject rootLocked = installedModelMetaStore.readRootLocked(context);
                    JSONObject jSONObjectOptJSONObject = rootLocked.optJSONObject(otaName);
                    if (jSONObjectOptJSONObject == null) {
                        jSONObjectOptJSONObject = new JSONObject();
                    }
                    jSONObjectOptJSONObject.put(KEY_SIZE, meta2.getSizeBytes()).put("updateInfo", meta2.getUpdateInfo()).put(KEY_UPDATE_TIME, meta2.getUpdateTimeMs());
                    rootLocked.put(otaName, jSONObjectOptJSONObject);
                    installedModelMetaStore.writeRootLocked(context, rootLocked);
                    objA = meta2;
                } catch (Throwable th) {
                    objA = c.a(th);
                }
                Throwable thB = Result.b(objA);
                if (thB != null) {
                    Log.w(TAG, "replaceMeta failed: ".concat(otaName), thB);
                }
                if (!(objA instanceof Result.Failure)) {
                    obj = objA;
                }
                meta = (Meta) obj;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return meta;
    }
}
