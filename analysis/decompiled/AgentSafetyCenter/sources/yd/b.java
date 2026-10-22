package yd;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class b extends c {

    /* renamed from: c, reason: collision with root package name */
    public final String f16123c;

    /* renamed from: f, reason: collision with root package name */
    public final a f16124f;

    /* renamed from: g, reason: collision with root package name */
    public final String f16125g;

    /* renamed from: h, reason: collision with root package name */
    public final a f16126h;

    public b(String str, a aVar, String str2, a aVar2) {
        super(str + "; " + str2 + "; " + aVar2, null);
        this.f16123c = str;
        this.f16124f = aVar;
        this.f16125g = str2;
        this.f16126h = aVar2;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return toString();
    }

    @Override // java.lang.Throwable
    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        String str = this.f16123c;
        if (str != null) {
            sb2.append(str);
            sb2.append("\n");
        }
        a aVar = this.f16124f;
        if (aVar != null) {
            sb2.append(aVar);
            sb2.append("\n");
        }
        String str2 = this.f16125g;
        if (str2 != null) {
            sb2.append(str2);
            sb2.append("\n");
        }
        a aVar2 = this.f16126h;
        if (aVar2 != null) {
            sb2.append(aVar2);
            sb2.append("\n");
        }
        return sb2.toString();
    }
}
