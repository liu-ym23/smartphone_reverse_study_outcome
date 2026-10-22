package l0;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: l0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0751e extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public final EnumC0752f f13429a;

    /* renamed from: b, reason: collision with root package name */
    public final Throwable f13430b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0751e(EnumC0752f callbackName, Throwable cause) {
        super(cause);
        Intrinsics.checkNotNullParameter(callbackName, "callbackName");
        Intrinsics.checkNotNullParameter(cause, "cause");
        this.f13429a = callbackName;
        this.f13430b = cause;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.f13430b;
    }
}
