package com.stepos.core.common.ota;

import android.util.Log;
import com.stepos.base.model.InferenceConfig;
import gc.a;
import gc.o;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.g;
import org.json.JSONObject;
import wb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class FrameworkStringBuilder {
    public static final FrameworkStringBuilder INSTANCE = new FrameworkStringBuilder();
    private static final String TAG = "FrameworkStringBuilder";
    private static final int VER_GGML = 1;
    private static final int VER_LLAMA = 20250616;
    private static final int VER_MNN = 20900;

    private FrameworkStringBuilder() {
    }

    private final int detectQnnVersion() {
        File[] fileArrListFiles;
        File file = new File("/system/lib64/qnn");
        if (!file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return 2031000;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                File file3 = new File(file2, "config.json");
                if (file3.isFile()) {
                    try {
                        int iOptInt = new JSONObject(d.Z(file3, a.f9106b)).optInt("version_code", 0);
                        if (iOptInt > 0) {
                            return iOptInt;
                        }
                    } catch (Exception unused) {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
        return 2031000;
    }

    public final String build(Set<InferenceConfig.a> backends) {
        boolean z;
        boolean z3;
        g.f(backends, "backends");
        Set<InferenceConfig.a> set = backends;
        boolean z10 = set instanceof Collection;
        boolean z11 = true;
        if (z10 && set.isEmpty()) {
            z = false;
        } else {
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                if (o.k0(((InferenceConfig.a) it.next()).f6279a, "QNN_", false)) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        if (z10 && set.isEmpty()) {
            z3 = false;
        } else {
            Iterator<T> it2 = set.iterator();
            while (it2.hasNext()) {
                String str = ((InferenceConfig.a) it2.next()).f6279a;
                if (g.b(str, "MNN") || o.k0(str, "MNN_", false)) {
                    z3 = true;
                    break;
                }
            }
            z3 = false;
        }
        if (!backends.contains(new InferenceConfig.a("LLAMA_CPP"))) {
            if (z10 && set.isEmpty()) {
                z11 = false;
            } else {
                Iterator<T> it3 = set.iterator();
                while (it3.hasNext()) {
                    if (o.k0(((InferenceConfig.a) it3.next()).f6279a, "LLAMA_", false)) {
                        break;
                    }
                }
                z11 = false;
            }
        }
        boolean zContains = backends.contains(new InferenceConfig.a("AUTO"));
        int iDetectQnnVersion = z ? detectQnnVersion() : 0;
        ArrayList arrayList = new ArrayList();
        if (iDetectQnnVersion > 0) {
            arrayList.add("qnn:" + iDetectQnnVersion);
        }
        if (z3 || zContains) {
            arrayList.add("mnn:20900");
        }
        if (z11) {
            arrayList.add("llama:20250616");
        }
        arrayList.add("ggml:1");
        String strZ0 = kotlin.collections.a.z0(arrayList, "|", null, null, null, 62);
        Log.i(TAG, "build: " + strZ0 + " (backends=" + backends + ")");
        return strZ0;
    }
}
