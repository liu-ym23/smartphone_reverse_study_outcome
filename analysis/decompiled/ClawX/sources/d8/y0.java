package d8;

import org.bouncycastle.crypto.digests.Blake2xsDigest;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class y0 extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public int f2222f;

    /* renamed from: g, reason: collision with root package name */
    public int f2223g;

    /* renamed from: h, reason: collision with root package name */
    public int f2224h;

    /* renamed from: j, reason: collision with root package name */
    public byte[] f2225j;

    /* renamed from: k, reason: collision with root package name */
    public int f2226k = -1;

    @Override // d8.w2
    public final void j(u uVar) {
        this.f2222f = uVar.d();
        this.f2223g = uVar.f();
        this.f2224h = uVar.f();
        if (uVar.f2171a.remaining() > 0) {
            this.f2225j = uVar.a();
        }
    }

    @Override // d8.w2
    public final String k() {
        int i8;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2222f);
        sb.append(" ");
        sb.append(this.f2223g);
        sb.append(" ");
        sb.append(this.f2224h);
        if (this.f2225j != null) {
            if (p2.a()) {
                sb.append(" (\n");
                sb.append(a.a.H(this.f2225j, true));
                sb.append(" ; key_tag = ");
                int i9 = this.f2226k;
                if (i9 < 0) {
                    b0.j jVar = new b0.j(2);
                    int i10 = 0;
                    l(jVar, null, false);
                    byte[] bArrF = jVar.f();
                    if (this.f2224h == 1) {
                        i8 = ((bArrF[bArrF.length - 3] & 255) << 8) + (bArrF[bArrF.length - 2] & 255);
                    } else {
                        int i11 = 0;
                        while (i10 < bArrF.length - 1) {
                            i11 += ((bArrF[i10] & 255) << 8) + (bArrF[i10 + 1] & 255);
                            i10 += 2;
                        }
                        if (i10 < bArrF.length) {
                            i11 += (bArrF[i10] & 255) << 8;
                        }
                        i8 = i11 + ((i11 >> 16) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH);
                    }
                    i9 = i8 & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH;
                    this.f2226k = i9;
                }
                sb.append(i9);
            } else {
                sb.append(" ");
                sb.append(a.a.f0(this.f2225j));
            }
        }
        return sb.toString();
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        jVar.j(this.f2222f);
        jVar.m(this.f2223g);
        jVar.m(this.f2224h);
        byte[] bArr = this.f2225j;
        if (bArr != null) {
            jVar.g(0, bArr.length, bArr);
        }
    }
}
