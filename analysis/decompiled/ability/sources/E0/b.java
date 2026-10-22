package E0;

/* loaded from: classes2.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f450a;
    public final /* synthetic */ c b;

    public b(c cVar, boolean z10) {
        this.b = cVar;
        this.f450a = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.e();
        this.b.i = !this.f450a;
    }
}
