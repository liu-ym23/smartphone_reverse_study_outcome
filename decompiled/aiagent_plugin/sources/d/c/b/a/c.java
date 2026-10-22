package d.c.b.a;

/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c implements d.c.d<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f38409a = null;

    static {
        f38409a = new c();
    }

    public String toString() {
        return "This continuation is already complete";
    }

    private c() {
    }

    @Override // d.c.d
    public d.c.g getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // d.c.d
    public void resumeWith(Object r1) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }
}
