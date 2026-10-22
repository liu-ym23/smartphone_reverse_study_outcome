package l2;

import android.content.Context;

/* loaded from: classes2.dex */
public final class I implements g2.b<H> {

    /* renamed from: a, reason: collision with root package name */
    public final X8.a<Context> f36900a;

    /* renamed from: b, reason: collision with root package name */
    public final X8.a<String> f36901b;

    /* renamed from: c, reason: collision with root package name */
    public final X8.a<Integer> f36902c;

    public I(X8.a<Context> aVar, X8.a<String> aVar2, X8.a<Integer> aVar3) {
        this.f36900a = aVar;
        this.f36901b = aVar2;
        this.f36902c = aVar3;
    }

    public static I a(X8.a<Context> aVar, X8.a<String> aVar2, X8.a<Integer> aVar3) {
        return new I(aVar, aVar2, aVar3);
    }

    public static H c(Context context, String str, int i10) {
        return new H(context, str, i10);
    }

    @Override // X8.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public H get() {
        return c(this.f36900a.get(), this.f36901b.get(), this.f36902c.get().intValue());
    }
}
