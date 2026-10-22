package ge;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public final yd.a f4744a;

    /* renamed from: b, reason: collision with root package name */
    public final yd.a f4745b;

    public k(yd.a aVar, yd.a aVar2) {
        if (aVar == null || aVar2 == null) {
            throw new yd.c("Token requires marks.");
        }
        this.f4744a = aVar;
        this.f4745b = aVar2;
    }

    public abstract int a();
}
