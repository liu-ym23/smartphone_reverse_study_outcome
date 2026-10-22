package d8;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class w3 extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public x1 f2198f;

    /* renamed from: g, reason: collision with root package name */
    public Instant f2199g;

    /* renamed from: h, reason: collision with root package name */
    public Instant f2200h;

    /* renamed from: j, reason: collision with root package name */
    public int f2201j;

    /* renamed from: k, reason: collision with root package name */
    public int f2202k;

    /* renamed from: l, reason: collision with root package name */
    public byte[] f2203l;

    /* renamed from: m, reason: collision with root package name */
    public byte[] f2204m;

    @Override // d8.w2
    public final void j(u uVar) throws l4 {
        this.f2198f = new x1(uVar);
        this.f2199g = Instant.ofEpochSecond(uVar.e());
        this.f2200h = Instant.ofEpochSecond(uVar.e());
        this.f2201j = uVar.d();
        this.f2202k = uVar.d();
        int iD = uVar.d();
        if (iD > 0) {
            this.f2203l = uVar.b(iD);
        } else {
            this.f2203l = null;
        }
        int iD2 = uVar.d();
        if (iD2 > 0) {
            this.f2204m = uVar.b(iD2);
        } else {
            this.f2204m = null;
        }
    }

    @Override // d8.w2
    public final String k() {
        String strD;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2198f);
        sb.append(" ");
        if (p2.a()) {
            sb.append("(\n\t");
        }
        Instant instant = this.f2199g;
        DateTimeFormatter dateTimeFormatter = o0.f2100a;
        sb.append(dateTimeFormatter.format(instant));
        sb.append(" ");
        sb.append(dateTimeFormatter.format(this.f2200h));
        sb.append(" ");
        int i8 = this.f2201j;
        sb.append(i8 != 1 ? i8 != 2 ? i8 != 3 ? i8 != 4 ? i8 != 5 ? Integer.toString(i8) : "DELETE" : "RESOLVERASSIGNED" : "GSSAPI" : "DIFFIEHELLMAN" : "SERVERASSIGNED");
        sb.append(" ");
        int i9 = this.f2202k;
        if (i9 == 16) {
            l1 l1Var = v2.f2185a;
            strD = "BADSIG";
        } else {
            strD = v2.f2185a.d(i9);
        }
        sb.append(strD);
        if (p2.a()) {
            sb.append("\n");
            byte[] bArr = this.f2203l;
            if (bArr != null) {
                sb.append(a.a.H(bArr, false));
                sb.append("\n");
            }
            byte[] bArr2 = this.f2204m;
            if (bArr2 != null) {
                sb.append(a.a.H(bArr2, false));
            }
            sb.append(" )");
        } else {
            sb.append(" ");
            byte[] bArr3 = this.f2203l;
            if (bArr3 != null) {
                sb.append(a.a.f0(bArr3));
                sb.append(" ");
            }
            byte[] bArr4 = this.f2204m;
            if (bArr4 != null) {
                sb.append(a.a.f0(bArr4));
            }
        }
        return sb.toString();
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        this.f2198f.j(jVar, null, z);
        jVar.l(this.f2199g.getEpochSecond());
        jVar.l(this.f2200h.getEpochSecond());
        jVar.j(this.f2201j);
        jVar.j(this.f2202k);
        byte[] bArr = this.f2203l;
        if (bArr != null) {
            jVar.j(bArr.length);
            jVar.h(this.f2203l);
        } else {
            jVar.j(0);
        }
        byte[] bArr2 = this.f2204m;
        if (bArr2 == null) {
            jVar.j(0);
        } else {
            jVar.j(bArr2.length);
            jVar.h(this.f2204m);
        }
    }
}
