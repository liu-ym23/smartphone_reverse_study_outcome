package com.ttnet.org.chromium.base.memory;

import android.os.Debug;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.j;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class JavaHeapDumpGenerator {
    @CalledByNative
    public static boolean generateHprof(String r10) {
        Debug.dumpHprofData(r10);     // Catch: IOException -> L5
        return true;
    L5:
        e = move-exception;
        j.d("JavaHprofGenerator", "Error writing to file " + r10 + ". Error: " + e.getMessage(), new Object[0]);
        return false;
    }
}
