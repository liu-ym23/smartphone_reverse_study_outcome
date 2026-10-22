package D2;

/* loaded from: classes2.dex */
public final class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f2223a;

    public r(s sVar) {
        this.f2223a = sVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f2223a.f2225b) {
            try {
                s sVar = this.f2223a;
                if (sVar.f2226c != null) {
                    sVar.f2226c.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
