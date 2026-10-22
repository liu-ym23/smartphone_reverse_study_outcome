package d8;

import java.io.ByteArrayOutputStream;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class r1 extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public int f2130f;

    /* renamed from: g, reason: collision with root package name */
    public int f2131g;

    /* renamed from: h, reason: collision with root package name */
    public int f2132h;

    /* renamed from: j, reason: collision with root package name */
    public byte[] f2133j;

    /* renamed from: k, reason: collision with root package name */
    public byte[] f2134k;

    /* renamed from: l, reason: collision with root package name */
    public g4 f2135l;

    @Override // d8.w2
    public final void j(u uVar) throws l4 {
        this.f2130f = uVar.f();
        this.f2131g = uVar.f();
        this.f2132h = uVar.d();
        int iF = uVar.f();
        if (iF > 0) {
            this.f2133j = uVar.b(iF);
        } else {
            this.f2133j = null;
        }
        this.f2134k = uVar.b(uVar.f());
        this.f2135l = new g4(uVar);
    }

    @Override // d8.w2
    public final String k() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2130f);
        sb.append(' ');
        sb.append(this.f2131g);
        sb.append(' ');
        sb.append(this.f2132h);
        sb.append(' ');
        byte[] bArr = this.f2133j;
        if (bArr == null) {
            sb.append('-');
        } else {
            sb.append(b8.h.O(bArr));
        }
        sb.append(' ');
        byte[] bArr2 = this.f2134k;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        short s8 = 0;
        int i8 = 0;
        while (i8 < (bArr2.length + 4) / 5) {
            short[] sArr = new short[5];
            int i9 = 5;
            for (int i10 = s8; i10 < 5; i10++) {
                int i11 = (i8 * 5) + i10;
                if (i11 < bArr2.length) {
                    sArr[i10] = (short) (bArr2[i11] & 255);
                } else {
                    sArr[i10] = s8;
                    i9--;
                }
            }
            short s9 = i9 != 1 ? i9 != 2 ? i9 != 3 ? i9 != 4 ? i9 != 5 ? (short) -1 : s8 : (short) 1 : (short) 3 : (short) 4 : (short) 6;
            short s10 = sArr[s8];
            short s11 = sArr[1];
            short s12 = sArr[2];
            short s13 = sArr[3];
            short s14 = sArr[4];
            int[] iArr = {(byte) ((s10 >> 3) & 31), (byte) (((s10 & 7) << 2) | ((s11 >> 6) & 3)), (byte) ((s11 >> 1) & 31), (byte) (((s11 & 1) << 4) | ((s12 >> 4) & 15)), (byte) (((s12 & 15) << 1) | ((s13 >> 7) & 1)), (byte) ((s13 >> 2) & 31), (byte) (((s14 >> 5) & 7) | ((s13 & 3) << 3)), (byte) (s14 & 31)};
            for (int i12 = 0; i12 < 8 - s9; i12++) {
                byteArrayOutputStream.write("0123456789ABCDEFGHIJKLMNOPQRSTUV=".charAt(iArr[i12]));
            }
            i8++;
            s8 = 0;
        }
        sb.append(byteArrayOutputStream.toString());
        if (!this.f2135l.f2008a.isEmpty()) {
            sb.append(' ');
            sb.append(this.f2135l.toString());
        }
        return sb.toString();
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        jVar.m(this.f2130f);
        jVar.m(this.f2131g);
        jVar.j(this.f2132h);
        byte[] bArr = this.f2133j;
        if (bArr != null) {
            jVar.m(bArr.length);
            jVar.h(this.f2133j);
        } else {
            jVar.m(0);
        }
        jVar.m(this.f2134k.length);
        jVar.h(this.f2134k);
        this.f2135l.b(jVar);
    }
}
