package d.b;

import d.h.b.o;

/* JADX INFO: compiled from: _ComparisonsJvm.kt */
/* JADX INFO: loaded from: classes4.dex */
class c extends b {
    public static final long a(long r4, long... r6) {
        o.e(r6, "other");
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r4 = Math.max(r4, r6[r1]);
        r1 = r1 + 1;
        goto L3
    L5:
        return r4;
    }
}
