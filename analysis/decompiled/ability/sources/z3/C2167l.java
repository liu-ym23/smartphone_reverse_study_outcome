package z3;

/* renamed from: z3.l, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2167l {

    /* renamed from: a, reason: collision with root package name */
    public String f6949a;
    public String b;
    public String c;
    public boolean d;
    public String e;

    public final boolean a(String str) {
        int iLastIndexOf;
        String str2 = this.c;
        if (str2 == null) {
            return false;
        }
        if (this.d && str.equals(str2)) {
            this.e = str;
            return true;
        }
        if (this.d) {
            return false;
        }
        boolean zEquals = (str2.startsWith(".") || (iLastIndexOf = str.lastIndexOf(47)) == -1) ? str.equals(str2) : str.substring(iLastIndexOf + 1).equals(str2);
        if (!zEquals) {
            return false;
        }
        this.e = str;
        return true;
    }
}
