package bytekn.foundation.encryption;

/* JADX INFO: loaded from: classes6.dex */
public final class MD5 extends c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f21749i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int[] f21750j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Companion f21751k = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f21752f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f21753g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f21754h;

    public static final class Companion extends HasherFactory {
        public Companion() {
            super(AnonymousClass1.INSTANCE);
        }
    }

    static {
        f21751k = new Companion();
        f21749i = new int[]{7, 12, 17, 22, 5, 9, 14, 20, 4, 11, 16, 23, 6, 10, 15, 21};
        int[] r100 = new int[64];
        int r101 = 0;
    L3:
        if (r101 >= 64) goto L5;
        r100[r101] = (int) (4294967296L * Math.abs(Math.sin(((double) r101) + 1.0d)));
        r101 = r101 + 1;
        goto L3
    L5:
        f21750j = r100;
    }

    @Override // bytekn.foundation.encryption.c
    public final void c() {
        int[] r100 = this.f21752f;
        r100[0] = 1732584193;
        r100[1] = (int) 4023233417L;
        r100[2] = (int) 2562383102L;
        r100[3] = 271733878;
    }

    public MD5() {
        this.f21752f = new int[4];
        this.f21753g = new int[4];
        this.f21754h = new int[16];
        c();
    }

    @Override // bytekn.foundation.encryption.c
    public final void a(byte[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= 16) goto L6;
        r100[r101] = (byte) (this.f21752f[r101 / 4] >>> ((r101 % 4) * 8));
        r101 = r101 + 1;
        goto L4
    }

    @Override // bytekn.foundation.encryption.c
    public final byte[] b(long r100) {
        long r101 = 8;
        int r102 = this.f21778d;
        long r103 = ((r100 + r101) / ((long) r102)) + 1;
        long r104 = r101 * r100;
        int r105 = (int) ((r103 * ((long) r102)) - r100);
        byte[] r110 = new byte[r105];
        int r106 = 0;
        r110[0] = (byte) 128;
    L3:
        if (r106 >= 8) goto L5;
        r110[(r105 - 8) + r106] = (byte) (r104 >>> (r106 * 8));
        r106 = r106 + 1;
        goto L3
    L5:
        return r110;
    }

    @Override // bytekn.foundation.encryption.c
    public final void d(byte[] r110) {
        int r100 = 0;
        int r101 = 0;
    L4:
        if (r101 >= 64) goto L6;
        int[] r102 = this.f21754h;
        int r103 = r101 >>> 2;
        r102[r103] = (r110[r101] << 24) | (r102[r103] >>> 8);
        r101 = r101 + 1;
        goto L4
    L6:
        int r111 = 0;
    L8:
        if (r111 >= 4) goto L10;
        this.f21753g[r111] = this.f21752f[r111];
        r111 = r111 + 1;
        goto L8
    L10:
        int r112 = 0;
    L11:
        if (r112 >= 64) goto L34;
        int r104 = r112 / 16;
        if (r104 == 0) goto L22;
        if (r104 == 1) goto L21;
        if (r104 == 2) goto L19;
        if (r104 == 3) goto L18;
        int r105 = 0;
    L23:
        if (r104 == 0) goto L32;
        if (r104 == 1) goto L30;
        if (r104 == 2) goto L29;
        if (r104 == 3) goto L28;
        int r106 = 0;
    L33:
        int[] r107 = this.f21752f;
        int r113 = r107[1];
        int r114 = ((r107[0] + r105) + this.f21754h[r106]) + f21750j[r112];
        int r108 = f21749i[(r104 << 2) | (r112 & 3)];
        int r109 = r114 << r108;
        int r115 = ((r114 >>> (32 - r108)) | r109) + r113;
        r107[0] = r107[3];
        r107[3] = r107[2];
        r107[2] = r113;
        r107[1] = r115;
        r112 = r112 + 1;
        goto L11
    L28:
        int r116 = r112 * 7;
    L31:
        r106 = r116 & 15;
        goto L33
    L29:
        r116 = (r112 * 3) + 5;
        goto L31
    L30:
        r116 = (r112 * 5) + 1;
        goto L31
    L32:
        r106 = r112;
        goto L33
    L18:
        int[] r117 = this.f21752f;
        int r118 = r117[2];
        int r119 = r117[1];
        int r120 = (~r117[3]) | r119;
    L20:
        r105 = r120 ^ r118;
        goto L23
    L19:
        int[] r121 = this.f21752f;
        r118 = r121[1] ^ r121[2];
        r120 = r121[3];
        goto L20
    L21:
        int[] r122 = this.f21752f;
        int r123 = r122[1];
        int r124 = r122[3];
        int r125 = r123 & r124;
        r105 = (r122[2] & (~r124)) | r125;
        goto L23
    L22:
        int[] r126 = this.f21752f;
        int r127 = r126[1];
        int r128 = r126[2] & r127;
        int r129 = ~r127;
        r105 = (r126[3] & r129) | r128;
    L34:
        if (r100 >= 4) goto L36;
        int[] r130 = this.f21752f;
        r130[r100] = r130[r100] + this.f21753g[r100];
        r100 = r100 + 1;
        goto L34
    }
}
