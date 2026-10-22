package Yb;

/* loaded from: classes5.dex */
public class o extends u {

    /* renamed from: f, reason: collision with root package name */
    public String f7069f;

    /* renamed from: g, reason: collision with root package name */
    public String f7070g;

    public o() {
    }

    @Override // Yb.u
    public void a(B b10) {
        b10.A(this);
    }

    @Override // Yb.u
    public String k() {
        return "destination=" + this.f7069f + ", title=" + this.f7070g;
    }

    public String m() {
        return this.f7069f;
    }

    public String n() {
        return this.f7070g;
    }

    public o(String str, String str2) {
        this.f7069f = str;
        this.f7070g = str2;
    }
}
