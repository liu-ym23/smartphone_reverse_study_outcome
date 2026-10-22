package y2;

/* renamed from: y2.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5923d {

    /* renamed from: a, reason: collision with root package name */
    public final Object f43822a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f43823b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f43824c;

    public C5923d(Object obj, Object obj2, Object obj3) {
        this.f43822a = obj;
        this.f43823b = obj2;
        this.f43824c = obj3;
    }

    public final IllegalArgumentException a() {
        Object obj = this.f43824c;
        Object obj2 = this.f43823b;
        Object obj3 = this.f43822a;
        return new IllegalArgumentException("Multiple entries with same key: " + String.valueOf(obj3) + "=" + String.valueOf(obj2) + " and " + String.valueOf(obj3) + "=" + String.valueOf(obj));
    }
}
