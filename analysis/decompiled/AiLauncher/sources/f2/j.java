package f2;

import android.content.Context;

/* loaded from: classes2.dex */
public final class j implements g2.b<i> {

    /* renamed from: a, reason: collision with root package name */
    public final X8.a<Context> f32549a;

    /* renamed from: b, reason: collision with root package name */
    public final X8.a<g> f32550b;

    public j(X8.a<Context> aVar, X8.a<g> aVar2) {
        this.f32549a = aVar;
        this.f32550b = aVar2;
    }

    public static j a(X8.a<Context> aVar, X8.a<g> aVar2) {
        return new j(aVar, aVar2);
    }

    public static i c(Context context, Object obj) {
        return new i(context, (g) obj);
    }

    @Override // X8.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i get() {
        return c(this.f32549a.get(), this.f32550b.get());
    }
}
