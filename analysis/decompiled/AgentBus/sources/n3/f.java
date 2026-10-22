package n3;

import m.x;

/* loaded from: classes.dex */
public final class f extends RuntimeException {

    /* renamed from: f, reason: collision with root package name */
    public final int f6821f;

    /* renamed from: g, reason: collision with root package name */
    public final Throwable f6822g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(int i2, Throwable th) {
        super(th);
        x.t(i2, "callbackName");
        this.f6821f = i2;
        this.f6822g = th;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.f6822g;
    }
}
