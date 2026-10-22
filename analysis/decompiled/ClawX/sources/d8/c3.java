package d8;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c3 extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public x1 f1966f;

    /* renamed from: g, reason: collision with root package name */
    public x1 f1967g;

    /* renamed from: h, reason: collision with root package name */
    public long f1968h;

    /* renamed from: j, reason: collision with root package name */
    public long f1969j;

    /* renamed from: k, reason: collision with root package name */
    public long f1970k;

    /* renamed from: l, reason: collision with root package name */
    public long f1971l;

    /* renamed from: m, reason: collision with root package name */
    public long f1972m;

    @Override // d8.w2
    public final void j(u uVar) {
        this.f1966f = new x1(uVar);
        this.f1967g = new x1(uVar);
        this.f1968h = uVar.e();
        this.f1969j = uVar.e();
        this.f1970k = uVar.e();
        this.f1971l = uVar.e();
        this.f1972m = uVar.e();
    }

    @Override // d8.w2
    public final String k() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1966f);
        sb.append(" ");
        sb.append(this.f1967g);
        if (p2.a()) {
            sb.append(" (\n\t\t\t\t\t");
            sb.append(this.f1968h);
            sb.append("\t; serial\n\t\t\t\t\t");
            sb.append(this.f1969j);
            sb.append("\t; refresh\n\t\t\t\t\t");
            sb.append(this.f1970k);
            sb.append("\t; retry\n\t\t\t\t\t");
            sb.append(this.f1971l);
            sb.append("\t; expire\n\t\t\t\t\t");
            sb.append(this.f1972m);
            sb.append(" )\t; minimum");
        } else {
            sb.append(" ");
            sb.append(this.f1968h);
            sb.append(" ");
            sb.append(this.f1969j);
            sb.append(" ");
            sb.append(this.f1970k);
            sb.append(" ");
            sb.append(this.f1971l);
            sb.append(" ");
            sb.append(this.f1972m);
        }
        return sb.toString();
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        this.f1966f.j(jVar, nVar, z);
        this.f1967g.j(jVar, nVar, z);
        jVar.l(this.f1968h);
        jVar.l(this.f1969j);
        jVar.l(this.f1970k);
        jVar.l(this.f1971l);
        jVar.l(this.f1972m);
    }
}
