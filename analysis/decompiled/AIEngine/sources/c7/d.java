package c7;

import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final String f3303a;

    /* renamed from: b, reason: collision with root package name */
    public final zb.a<n> f3304b;

    public d(String path, zb.a<n> aVar) {
        g.f(path, "path");
        this.f3303a = path;
        this.f3304b = aVar;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        try {
            this.f3304b.invoke();
            n nVar = n.f10413a;
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
    }
}
