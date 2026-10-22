package l5;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public int f10239a;

    /* renamed from: b, reason: collision with root package name */
    public int f10240b;

    /* renamed from: c, reason: collision with root package name */
    public int f10241c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f10242d;

    public static String a(int[] iArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('\"');
        for (int i10 : iArr) {
            j.b(sb2, i10);
        }
        sb2.append('\"');
        return sb2.toString();
    }

    public final String toString() {
        switch (this.f10239a) {
            case 1:
                return "alt -> " + this.f10240b + ", " + this.f10241c;
            case 2:
                return "altmatch -> " + this.f10240b + ", " + this.f10241c;
            case 3:
                return "cap " + this.f10241c + " -> " + this.f10240b;
            case 4:
                return "empty " + this.f10241c + " -> " + this.f10240b;
            case 5:
                return "fail";
            case 6:
                return "match";
            case 7:
                return "nop -> " + this.f10240b;
            case 8:
                if (this.f10242d == null) {
                    return "rune <null>";
                }
                StringBuilder sb2 = new StringBuilder("rune ");
                sb2.append(a(this.f10242d));
                sb2.append((this.f10241c & 1) != 0 ? "/i" : "");
                sb2.append(" -> ");
                sb2.append(this.f10240b);
                return sb2.toString();
            case 9:
                return "rune1 " + a(this.f10242d) + " -> " + this.f10240b;
            case 10:
                return "any -> " + this.f10240b;
            case 11:
                return "anynotnl -> " + this.f10240b;
            default:
                throw new IllegalStateException("unhandled case in Inst.toString");
        }
    }
}
