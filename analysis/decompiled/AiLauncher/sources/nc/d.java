package nc;

/* loaded from: classes5.dex */
public class d extends g implements b {

    /* renamed from: c, reason: collision with root package name */
    public String f37297c = "*";

    @Override // nc.a
    public String d() {
        return this.f37297c;
    }

    @Override // nc.b
    public void g(String str) {
        if (str == null) {
            throw new IllegalArgumentException("http resource descriptor must not be null");
        }
        this.f37297c = str;
    }
}
