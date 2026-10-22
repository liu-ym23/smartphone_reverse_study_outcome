package u0;

import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d<T> extends l5.a {

    /* renamed from: d, reason: collision with root package name */
    public final Object f13140d;

    public d() {
        super(12);
        this.f13140d = new Object();
    }

    @Override // l5.a, u0.c
    public final T acquire() {
        T t8;
        synchronized (this.f13140d) {
            t8 = (T) super.acquire();
        }
        return t8;
    }

    @Override // l5.a, u0.c
    public final boolean release(T instance) {
        boolean zRelease;
        g.f(instance, "instance");
        synchronized (this.f13140d) {
            zRelease = super.release(instance);
        }
        return zRelease;
    }
}
