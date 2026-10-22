package m3;

/* renamed from: m3.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1675b {

    /* renamed from: a, reason: collision with root package name */
    public final Object f5299a;
    public final Object b;
    public final Object c;

    public C1675b(Object obj, Object obj2, Object obj3) {
        this.f5299a = obj;
        this.b = obj2;
        this.c = obj3;
    }

    public final IllegalArgumentException a() {
        StringBuilder sb = new StringBuilder("Multiple entries with same key: ");
        Object obj = this.f5299a;
        sb.append(obj);
        sb.append("=");
        sb.append(this.b);
        sb.append(" and ");
        sb.append(obj);
        sb.append("=");
        sb.append(this.c);
        return new IllegalArgumentException(sb.toString());
    }
}
