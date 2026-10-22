package y;

import androidx.compose.runtime.snapshots.SnapshotIdSet;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a extends b {

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f13920g = new int[0];

    /* renamed from: c, reason: collision with root package name */
    public final zb.l f13921c;

    /* renamed from: d, reason: collision with root package name */
    public final zb.l f13922d;

    /* renamed from: e, reason: collision with root package name */
    public int f13923e;

    /* renamed from: f, reason: collision with root package name */
    public p.k f13924f;

    public a(long j10, SnapshotIdSet snapshotIdSet, zb.l lVar, zb.l lVar2) {
        super(j10, snapshotIdSet);
        this.f13921c = lVar;
        this.f13922d = lVar2;
    }

    @Override // y.b
    public zb.l b() {
        return this.f13921c;
    }

    @Override // y.b
    public boolean c() {
        return false;
    }

    @Override // y.b
    public int e() {
        return this.f13923e;
    }

    @Override // y.b
    public zb.l f() {
        return this.f13922d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x007e, code lost:
    
        r19 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0089, code lost:
    
        if (((r9 & ((~r9) << 6)) & (-9187201950435737472L)) == 0) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x008b, code lost:
    
        r0 = r2.a(r5);
        r13 = 255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0093, code lost:
    
        if (r2.f11377e != 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a7, code lost:
    
        if (((r2.f972a[r0 >> 3] >> ((r0 & 7) << 3)) & 255) != 254) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a9, code lost:
    
        r22 = r11;
        r31 = 255;
        r17 = 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b3, code lost:
    
        r0 = r2.f974c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b5, code lost:
    
        if (r0 <= 8) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b7, code lost:
    
        r17 = 128;
        r10 = 8;
        r3 = 7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00cb, code lost:
    
        if (java.lang.Long.compareUnsigned(r2.f975d * 32, r0 * 25) > 0) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00cd, code lost:
    
        r0 = r2.f972a;
        r6 = r2.f974c;
        r7 = r2.f973b;
        r8 = (r6 + 7) >> 3;
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00d9, code lost:
    
        if (r9 >= r8) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00db, code lost:
    
        r25 = r3;
        r3 = r0[r9] & (-9187201950435737472L);
        r0[r9] = (-72340172838076674L) & ((~r3) + (r3 >>> r25));
        r9 = r9 + 1;
        r10 = r10;
        r11 = r11;
        r4 = r4;
        r3 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00fc, code lost:
    
        r24 = r4;
        r22 = r11;
        r12 = r10;
        r3 = mb.l.f0(r0);
        r4 = r3 - 1;
        r10 = 72057594037927935L;
        r0[r4] = (r0[r4] & 72057594037927935L) | (-72057594037927936L);
        r0[r3] = r0[0];
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x011c, code lost:
    
        if (r3 == r6) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x011e, code lost:
    
        r4 = r3 >> 3;
        r15 = (r3 & 7) << 3;
        r8 = (r0[r4] >> r15) & r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x012a, code lost:
    
        if (r8 != 128) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x012c, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0131, code lost:
    
        if (r8 == 254) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0134, code lost:
    
        r8 = r7[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0136, code lost:
    
        if (r8 == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0138, code lost:
    
        r8 = r8.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x013d, code lost:
    
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x013f, code lost:
    
        r8 = r8 * r24;
        r8 = r8 ^ (r8 << 16);
        r9 = r8 >>> 7;
        r16 = r2.a(r9);
        r9 = r9 & r6;
        r27 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0159, code lost:
    
        if ((((r16 - r9) & r6) / 8) != (((r3 - r9) & r6) / r12)) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x015b, code lost:
    
        r31 = r13;
        r0[r4] = ((r8 & 127) << r15) | (r0[r4] & (~(r31 << r15)));
        r0[r0.length - 1] = (r0[0] & r27) | Long.MIN_VALUE;
        r3 = r3 + 1;
        r12 = r12;
        r10 = r27;
        r13 = r31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x017e, code lost:
    
        r31 = r13;
        r14 = r12;
        r9 = r16 >> 3;
        r10 = r0[r9];
        r12 = (r16 & 7) << 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x018f, code lost:
    
        if (((r10 >> r12) & r31) != 128) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0191, code lost:
    
        r33 = r14;
        r0[r9] = (r10 & (~(r31 << r12))) | ((r8 & 127) << r12);
        r0[r4] = (r0[r4] & (~(r31 << r15))) | (128 << r15);
        r7[r16] = r7[r3];
        r7[r3] = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x01b7, code lost:
    
        r33 = r14;
        r13 = r8 & 127;
        r8 = r3;
        r0[r9] = ((~(r31 << r12)) & r10) | (r13 << r12);
        r3 = r7[r16];
        r7[r16] = r7[r8];
        r7[r8] = r3;
        r3 = r8 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x01d0, code lost:
    
        r0[r0.length - 1] = (r0[0] & r27) | Long.MIN_VALUE;
        r3 = r3 + 1;
        r10 = r27;
        r13 = r31;
        r12 = r33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x01e5, code lost:
    
        r31 = r13;
        r2.f11377e = p.m.a(r2.f974c) - r2.f975d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01f6, code lost:
    
        r22 = r11;
        r31 = 255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01fd, code lost:
    
        r17 = 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0202, code lost:
    
        r0 = p.m.b(r2.f974c);
        r3 = r2.f972a;
        r4 = r2.f973b;
        r6 = r2.f974c;
        r2.b(r0);
        r0 = r2.f972a;
        r7 = r2.f973b;
        r8 = r2.f974c;
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0219, code lost:
    
        if (r9 >= r6) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0228, code lost:
    
        if (((r3[r9 >> 3] >> ((r9 & 7) << 3)) & 255) >= r17) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x022a, code lost:
    
        r10 = r4[r9];
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x022c, code lost:
    
        if (r10 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x022e, code lost:
    
        r11 = r10.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0233, code lost:
    
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0235, code lost:
    
        r11 = r11 * (-862048943);
        r11 = r11 ^ (r11 << 16);
        r12 = r2.a(r11 >>> 7);
        r13 = r11 & 127;
        r11 = r12 >> 3;
        r15 = (r12 & 7) << 3;
        r16 = r0;
        r0 = (r0[r11] & (~(255 << r15))) | (r13 << r15);
        r16[r11] = r0;
        r16[(((r12 - 7) & r8) + (r8 & 7)) >> 3] = r0;
        r7[r12] = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0263, code lost:
    
        r16 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0265, code lost:
    
        r9 = r9 + 1;
        r0 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x026c, code lost:
    
        r0 = r2.a(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0270, code lost:
    
        r2.f975d++;
        r1 = r2.f11377e;
        r3 = r2.f972a;
        r4 = r0 >> 3;
        r5 = r3[r4];
        r7 = (r0 & 7) << 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0288, code lost:
    
        if (((r5 >> r7) & r31) != r17) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x028a, code lost:
    
        r19 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x028c, code lost:
    
        r2.f11377e = r1 - r19;
        r1 = r2.f974c;
        r5 = (r5 & (~(r31 << r7))) | (r22 << r7);
        r3[r4] = r5;
        r3[(((r0 - 7) & r1) + (r1 & 7)) >> 3] = r5;
        r17 = r0;
     */
    @Override // y.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(y.i r37) {
        /*
            Method dump skipped, instructions count: 698
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y.a.g(y.i):void");
    }

    @Override // y.b
    public void h(int i10) {
        this.f13923e = i10;
    }
}
