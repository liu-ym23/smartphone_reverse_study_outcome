package bytedance.jvm.time.temporal;

/* JADX INFO: loaded from: classes28.dex */
public final /* synthetic */ class a {
    public static /* bridge */ /* synthetic */ Object b(b r100, l r101) {
        return c.b(r100, r101);
    }

    public static b a(b r100, long r101, m r102) {
        if (r101 != Long.MIN_VALUE) goto L5;
        r100 = r100.plus(Long.MAX_VALUE, r102);
        long r103 = 1;
    L7:
        return r100.plus(r103, r102);
    L5:
        r103 = -r101;
        goto L7
    }
}
