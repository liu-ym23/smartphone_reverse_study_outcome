package k2;

/* loaded from: classes2.dex */
public final /* synthetic */ class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final m f34624a;

    public k(m mVar) {
        this.f34624a = mVar;
    }

    public static Runnable a(m mVar) {
        return new k(mVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        m mVar = this.f34624a;
        mVar.f34629d.b(l.a(mVar));
    }
}
