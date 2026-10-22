package bytedance.jvm.time;

/* JADX INFO: loaded from: classes28.dex */
public final /* synthetic */ class a {
    public static /* synthetic */ long a(long r100, int r110) {
        long r101 = r110;
        int r111 = ((Long.numberOfLeadingZeros(r100) + Long.numberOfLeadingZeros(~r100)) + Long.numberOfLeadingZeros(r101)) + Long.numberOfLeadingZeros(~r101);
        if (r111 <= 65) goto L6;
        return r100 * r101;
    L6:
        if (r111 < 64) goto L23;
        boolean r112 = false;
        if (r100 < 0) goto L10;
        boolean r102 = true;
    L12:
        if (r101 == Long.MIN_VALUE) goto L15;
        r112 = true;
    L15:
        if ((r112 | r102) == false) goto L23;
        long r103 = r100 * r101;
        if (r100 == 0) goto L21;
        if ((r103 / r100) != r101) goto L23;
    L21:
        return r103;
    L10:
        r102 = false;
    L23:
        throw new ArithmeticException();
    }
}
