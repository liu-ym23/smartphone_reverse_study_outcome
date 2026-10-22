package Yb;

/* loaded from: classes5.dex */
public class q extends u {

    /* renamed from: f, reason: collision with root package name */
    public String f7072f;

    /* renamed from: g, reason: collision with root package name */
    public String f7073g;

    public q() {
    }

    @Override // Yb.u
    public void a(B b10) {
        b10.J(this);
    }

    @Override // Yb.u
    public String k() {
        return "destination=" + this.f7072f + ", title=" + this.f7073g;
    }

    public String m() {
        return this.f7072f;
    }

    public String n() {
        return this.f7073g;
    }

    public q(String str, String str2) {
        this.f7072f = str;
        this.f7073g = str2;
    }
}
