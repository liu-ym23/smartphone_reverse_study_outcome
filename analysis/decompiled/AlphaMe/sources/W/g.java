package W;

/* loaded from: classes.dex */
public final class g extends I.h {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l f1950c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(l lVar) {
        super("FloatValueHolder", 1);
        this.f1950c = lVar;
    }

    @Override // I.h
    public final float e(Object obj) {
        return this.f1950c.f1953a;
    }

    @Override // I.h
    public final void g(Object obj, float f4) {
        this.f1950c.f1953a = f4;
    }
}
