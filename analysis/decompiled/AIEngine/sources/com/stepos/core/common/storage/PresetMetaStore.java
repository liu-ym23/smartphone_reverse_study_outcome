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
import wb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PresetMetaStore {
    private static final String FILE = "preset_meta.json";
    private static final String TAG = "PresetMetaStore";
    public static final PresetMetaStore INSTANCE = new PresetMetaStore();
    private static final Object lock = new Object();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Meta {
        private final String description;
        private final long sizeBytes;

        public Meta(long j10, String description) {
            g.f(description, "description");
            this.sizeBytes = j10;
            this.description = description;
        }

        public static /* synthetic */ Meta copy$default(Meta meta, long j10, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                j10 = meta.sizeBytes;
            }
            if ((i10 & 2) != 0) {
                str = meta.description;
            }
            return meta.copy(j10, str);
        }

        public final long component1() {
            return this.sizeBytes;
        }

        public final String component2() {
            return this.description;
        }

        public final Meta copy(long j10, String description) {
            g.f(description, "description");
            return new Meta(j10, description);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Meta)) {
                return false;
            }
            Meta meta = (Meta) obj;
            return this.sizeBytes == meta.sizeBytes && g.b(this.description, meta.description);
        }

        public final String getDescription() {
            return this.description;
        }

        public final long getSizeBytes() {
            return this.sizeBytes;
        }

        public int hashCode() {
            return this.description.hashCode() + (Long.hashCode(this.sizeBytes) * 31);
        }

        public String toString() {
            StringBuilder sbO = a.o("Meta(sizeBytes=", this.sizeBytes, ", description=", this.description);
            sbO.append(")");
            return sbO.toString();
        }
    }

    private PresetMetaStore() {
    }

    private final JSONObject readRootLocked(Context context) {
        Object objA;
        File file = new File(context.getFilesDir(), FILE);
        if (!file.isFile()) {
            return new JSONObject();
        }
        try {
            objA = new JSONObject(d.Z(file, gc.a.f9106b));
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (Result.b(objA) != null) {
            objA = new JSONObject();
        }
        return (JSONObject) objA;
    }

    private final void writeRootLocked(Context context, JSONObject jSONObject) throws IOException {
        File file = new File(context.getFilesDir(), FILE);
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        String string = jSONObject.toString();
        g.e(string, "toString(...)");
        d.e0(file, string);
    }

    public final Meta getMeta(Context context, String modelType) {
        Object objA;
        Meta meta;
        g.f(context, "context");
        g.f(modelType, "modelType");
        Object obj = null;
        if (q.t0(modelType)) {
            return null;
        }
        synchronized (lock) {
            try {
                JSONObject jSONObjectOptJSONObject = INSTANCE.readRootLocked(context).optJSONObject(modelType);
                if (jSONObjectOptJSONObject == null) {
                    objA = null;
                } else {
                    long jOptLong = jSONObjectOptJSONObject.optLong("size");
                    String strOptString = jSONObjectOptJSONObject.optString("desc");
                    g.e(strOptString, "optString(...)");
                    objA = new Meta(jOptLong, strOptString);
                }
            } catch (Throwable th) {
                objA = c.a(th);
            }
            if (!(objA instanceof Result.Failure)) {
                obj = objA;
            }
            meta = (Meta) obj;
        }
        return meta;
    }

    public final void setMeta(Context context, String modelType, Meta meta) {
        Object objA;
        g.f(context, "context");
        g.f(modelType, "modelType");
        g.f(meta, "meta");
        if (q.t0(modelType)) {
            return;
        }
        synchronized (lock) {
            PresetMetaStore presetMetaStore = INSTANCE;
            try {
                JSONObject rootLocked = presetMetaStore.readRootLocked(context);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("size", meta.getSizeBytes());
                jSONObject.put("desc", meta.getDescription());
                n nVar = n.f10413a;
                rootLocked.put(modelType, jSONObject);
                presetMetaStore.writeRootLocked(context, rootLocked);
                objA = n.f10413a;
            } catch (Throwable th) {
                objA = c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                Log.w(TAG, "setMeta failed: ".concat(modelType), thB);
            }
        }
    }
}
