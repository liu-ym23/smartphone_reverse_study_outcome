package com.apm.insight.nativecrash;

import M0.i;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.b;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import z2.k;

/* loaded from: classes2.dex */
public class NativeCrashCollector {
    public static void a(String str) {
        Iterator it = ((CopyOnWriteArrayList) k.f.c).iterator();
        while (it.hasNext()) {
            try {
                ((ICrashCallback) it.next()).onCrash(CrashType.NATIVE, str, null);
            } catch (Throwable th) {
                int i = b.f2156a;
                i.k("NPTH_CATCH", th);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0160 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01a7 A[DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[DONT_GENERATE, FINALLY_INSNS, SYNTHETIC] */
    @androidx.annotation.Keep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void onNativeCrash(java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 455
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.nativecrash.NativeCrashCollector.onNativeCrash(java.lang.String):void");
    }
}
