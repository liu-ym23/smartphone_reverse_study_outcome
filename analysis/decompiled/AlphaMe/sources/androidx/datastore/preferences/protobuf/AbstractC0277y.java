package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0277y extends AbstractC0245a {

    /* renamed from: a, reason: collision with root package name */
    public final A f3551a;

    /* renamed from: b, reason: collision with root package name */
    public A f3552b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3553c = false;

    public AbstractC0277y(A a4) {
        this.f3551a = a4;
        this.f3552b = (A) a4.d(4);
    }

    public static void d(A a4, A a5) {
        C0254e0 c0254e0 = C0254e0.f3467c;
        c0254e0.getClass();
        c0254e0.a(a4.getClass()).b(a4, a5);
    }

    public final A a() {
        A aB = b();
        if (aB.g()) {
            return aB;
        }
        throw new p0();
    }

    public final A b() {
        if (this.f3553c) {
            return this.f3552b;
        }
        A a4 = this.f3552b;
        a4.getClass();
        C0254e0 c0254e0 = C0254e0.f3467c;
        c0254e0.getClass();
        c0254e0.a(a4.getClass()).d(a4);
        this.f3553c = true;
        return this.f3552b;
    }

    public final void c() {
        if (this.f3553c) {
            A a4 = (A) this.f3552b.d(4);
            d(a4, this.f3552b);
            this.f3552b = a4;
            this.f3553c = false;
        }
    }

    public final Object clone() {
        AbstractC0277y abstractC0277y = (AbstractC0277y) this.f3551a.d(5);
        A aB = b();
        abstractC0277y.c();
        d(abstractC0277y.f3552b, aB);
        return abstractC0277y;
    }
}
