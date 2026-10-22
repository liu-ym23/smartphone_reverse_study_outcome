package d8;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class z2 extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public int f2240f;

    /* renamed from: g, reason: collision with root package name */
    public int f2241g;

    /* renamed from: h, reason: collision with root package name */
    public int f2242h;

    /* renamed from: j, reason: collision with root package name */
    public long f2243j;

    /* renamed from: k, reason: collision with root package name */
    public Instant f2244k;

    /* renamed from: l, reason: collision with root package name */
    public Instant f2245l;

    /* renamed from: m, reason: collision with root package name */
    public int f2246m;

    /* renamed from: n, reason: collision with root package name */
    public x1 f2247n;

    /* renamed from: o, reason: collision with root package name */
    public byte[] f2248o;

    @Override // d8.w2
    public final int g() {
        return this.f2240f;
    }

    @Override // d8.w2
    public final void j(u uVar) {
        this.f2240f = uVar.d();
        this.f2241g = uVar.f();
        this.f2242h = uVar.f();
        this.f2243j = uVar.e();
        this.f2244k = Instant.ofEpochSecond(uVar.e());
        this.f2245l = Instant.ofEpochSecond(uVar.e());
        this.f2246m = uVar.d();
        this.f2247n = new x1(uVar);
        this.f2248o = uVar.a();
    }

    @Override // d8.w2
    public final String k() {
        StringBuilder sb = new StringBuilder();
        sb.append(f4.f1995a.d(this.f2240f));
        sb.append(" ");
        sb.append(this.f2241g);
        sb.append(" ");
        sb.append(this.f2242h);
        sb.append(" ");
        sb.append(this.f2243j);
        sb.append(" ");
        if (p2.a()) {
            sb.append("(\n\t");
        }
        Instant instant = this.f2244k;
        DateTimeFormatter dateTimeFormatter = o0.f2100a;
        sb.append(dateTimeFormatter.format(instant));
        sb.append(" ");
        sb.append(dateTimeFormatter.format(this.f2245l));
        sb.append(" ");
        sb.append(this.f2246m);
        sb.append(" ");
        sb.append(this.f2247n);
        if (p2.a()) {
            sb.append("\n");
            sb.append(a.a.H(this.f2248o, true));
        } else {
            sb.append(" ");
            sb.append(a.a.f0(this.f2248o));
        }
        return sb.toString();
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        jVar.j(this.f2240f);
        jVar.m(this.f2241g);
        jVar.m(this.f2242h);
        jVar.l(this.f2243j);
        jVar.l(this.f2244k.getEpochSecond());
        jVar.l(this.f2245l.getEpochSecond());
        jVar.j(this.f2246m);
        this.f2247n.j(jVar, null, z);
        jVar.h(this.f2248o);
    }
}
