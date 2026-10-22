package kotlin.coroutines.jvm.internal;

/* loaded from: classes.dex */
public final class c implements Z3.e<Object> {

    /* renamed from: a, reason: collision with root package name */
    public static final c f17939a = new c();

    private c() {
    }

    @Override // Z3.e
    public Z3.i getContext() {
        throw new IllegalStateException("This continuation is already complete");
    }

    @Override // Z3.e
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete");
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
