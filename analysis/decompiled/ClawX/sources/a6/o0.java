package a6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class o0 extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f201a;

    public o0(Throwable th, b0 b0Var, f5.h hVar) {
        super("Coroutine dispatcher " + b0Var + " threw an exception, context = " + hVar, th);
        this.f201a = th;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.f201a;
    }
}
