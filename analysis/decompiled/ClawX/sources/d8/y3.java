package d8;

import java.time.Duration;
import java.time.Instant;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class y3 extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public x1 f2231f;

    /* renamed from: g, reason: collision with root package name */
    public Instant f2232g;

    /* renamed from: h, reason: collision with root package name */
    public Duration f2233h;

    /* renamed from: j, reason: collision with root package name */
    public byte[] f2234j;

    /* renamed from: k, reason: collision with root package name */
    public int f2235k;

    /* renamed from: l, reason: collision with root package name */
    public int f2236l;

    /* renamed from: m, reason: collision with root package name */
    public byte[] f2237m;

    @Override // d8.w2
    public final void j(u uVar) throws l4 {
        this.f2231f = new x1(uVar);
        this.f2232g = Instant.ofEpochSecond((uVar.d() << 32) + uVar.e());
        this.f2233h = Duration.ofSeconds(uVar.d());
        this.f2234j = uVar.b(uVar.d());
        this.f2235k = uVar.d();
        this.f2236l = uVar.d();
        int iD = uVar.d();
        if (iD > 0) {
            this.f2237m = uVar.b(iD);
        } else {
            this.f2237m = null;
        }
    }

    @Override // d8.w2
    public final String k() {
        String strD;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2231f);
        sb.append(" ");
        if (p2.a()) {
            sb.append("(\n\t");
        }
        sb.append(this.f2232g.getEpochSecond());
        sb.append(" ");
        sb.append((int) this.f2233h.getSeconds());
        sb.append(" ");
        sb.append(this.f2234j.length);
        if (p2.a()) {
            sb.append("\n");
            sb.append(a.a.H(this.f2234j, false));
        } else {
            sb.append(" ");
            sb.append(a.a.f0(this.f2234j));
        }
        sb.append(" ");
        int i8 = this.f2236l;
        if (i8 == 16) {
            l1 l1Var = v2.f2185a;
            strD = "BADSIG";
        } else {
            strD = v2.f2185a.d(i8);
        }
        sb.append(strD);
        sb.append(" ");
        byte[] bArr = this.f2237m;
        if (bArr == null) {
            sb.append(0);
        } else {
            sb.append(bArr.length);
            if (p2.a()) {
                sb.append("\n\n\n\t");
            } else {
                sb.append(" ");
            }
            if (this.f2236l == 18) {
                if (this.f2237m.length != 6) {
                    sb.append("<invalid BADTIME other data>");
                } else {
                    sb.append("<server time: ");
                    sb.append(Instant.ofEpochSecond(((r8[0] & 255) << 40) + ((r8[1] & 255) << 32) + ((r8[2] & 255) << 24) + ((r8[3] & 255) << 16) + ((r8[4] & 255) << 8) + (r8[5] & 255)));
                    sb.append(">");
                }
            } else {
                sb.append("<");
                sb.append(a.a.f0(this.f2237m));
                sb.append(">");
            }
        }
        if (p2.a()) {
            sb.append(" )");
        }
        return sb.toString();
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        this.f2231f.j(jVar, null, z);
        long epochSecond = this.f2232g.getEpochSecond();
        jVar.j((int) (epochSecond >> 32));
        jVar.l(epochSecond & 4294967295L);
        jVar.j((int) this.f2233h.getSeconds());
        jVar.j(this.f2234j.length);
        jVar.h(this.f2234j);
        jVar.j(this.f2235k);
        jVar.j(this.f2236l);
        byte[] bArr = this.f2237m;
        if (bArr == null) {
            jVar.j(0);
        } else {
            jVar.j(bArr.length);
            jVar.h(this.f2237m);
        }
    }
}
