package C5;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f300a;
    public int b;
    public long c;
    public Object d;

    public String toString() {
        switch (this.f300a) {
            case 0:
                StringBuilder sb = new StringBuilder("ValueData{value='");
                sb.append((String) this.d);
                sb.append("', code=");
                sb.append(this.b);
                sb.append(", expired=");
                return B7.a.p(sb, this.c, '}');
            default:
                return super.toString();
        }
    }
}
