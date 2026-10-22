package g9;

/* loaded from: classes.dex */
public final class r extends t {
    public r() {
        super("HTML", 1);
    }

    @Override // g9.t
    public final String a(String str) {
        q7.k.e(str, "string");
        return ga.r.e0(ga.r.e0(str, "<", "&lt;"), ">", "&gt;");
    }
}
