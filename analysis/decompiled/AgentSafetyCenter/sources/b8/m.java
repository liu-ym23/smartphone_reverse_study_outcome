package b8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public String f1982a;

    /* renamed from: b, reason: collision with root package name */
    public String f1983b;

    /* renamed from: c, reason: collision with root package name */
    public String f1984c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1985d;

    /* renamed from: e, reason: collision with root package name */
    public String f1986e;

    public final boolean a(String str) {
        int iLastIndexOf;
        String str2 = this.f1984c;
        if (str2 == null) {
            return false;
        }
        if (this.f1985d && str.equals(str2)) {
            this.f1986e = str;
            return true;
        }
        if (this.f1985d) {
            return false;
        }
        boolean zEquals = (str2.startsWith(".") || (iLastIndexOf = str.lastIndexOf(47)) == -1) ? str.equals(str2) : str.substring(iLastIndexOf + 1).equals(str2);
        if (!zEquals) {
            return false;
        }
        this.f1986e = str;
        return true;
    }
}
