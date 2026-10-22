package D2;

/* loaded from: classes2.dex */
public final class x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f2237a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y f2238b;

    public x(y yVar, i iVar) {
        this.f2238b = yVar;
        this.f2237a = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f2238b.f2240b) {
            try {
                y yVar = this.f2238b;
                if (yVar.f2241c != null) {
                    yVar.f2241c.a(this.f2237a.i());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
