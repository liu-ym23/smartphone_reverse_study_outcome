package S6;

/* loaded from: classes3.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1176a = 0;
    public String b;
    public String c;
    public String d;

    public /* synthetic */ a() {
    }

    public a a() {
        String str = this.b;
        String str2 = this.c;
        String str3 = this.d;
        a aVar = new a();
        aVar.b = str;
        aVar.c = str2;
        aVar.d = str3;
        return aVar;
    }

    public String toString() {
        switch (this.f1176a) {
            case 0:
                StringBuilder sb = new StringBuilder("Credential{accessKeyId='");
                sb.append(this.b);
                sb.append("', accessKeySecret='");
                sb.append(this.c);
                sb.append("', securityToken='");
                return B7.a.q(sb, this.d, "'}");
            default:
                return super.toString();
        }
    }

    public a(String str, String str2) {
        this.b = str;
        this.c = str2;
    }
}
