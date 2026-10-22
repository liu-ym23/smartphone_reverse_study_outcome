package com.bytedance.applog.sampling.a;

/* JADX INFO: compiled from: TeaHashSamplingUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static boolean a(String r6, long r7, long r9) {
        if (r9 > 0) goto L5;
        return true;
    L5:
        if (r9 <= r7) goto L8;
        return true;
    L8:
        if (((a.a(r6).longValue() >>> 32) % (r7 / r9)) == 0) goto L14;
        return false;
    L14:
        return true;
    }
}
