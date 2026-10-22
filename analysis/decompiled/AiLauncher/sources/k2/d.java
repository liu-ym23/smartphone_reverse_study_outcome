package k2;

/* loaded from: classes2.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final i f34595a;

    /* renamed from: b, reason: collision with root package name */
    public final e2.m f34596b;

    /* renamed from: c, reason: collision with root package name */
    public final int f34597c;

    /* renamed from: d, reason: collision with root package name */
    public final Runnable f34598d;

    public d(i iVar, e2.m mVar, int i10, Runnable runnable) {
        this.f34595a = iVar;
        this.f34596b = mVar;
        this.f34597c = i10;
        this.f34598d = runnable;
    }

    public static Runnable a(i iVar, e2.m mVar, int i10, Runnable runnable) {
        return new d(iVar, mVar, i10, runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        i.e(this.f34595a, this.f34596b, this.f34597c, this.f34598d);
    }
}
