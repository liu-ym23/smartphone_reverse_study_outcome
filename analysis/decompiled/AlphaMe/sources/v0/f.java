package v0;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15688a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f15689b;

    public /* synthetic */ f(g gVar, int i4) {
        this.f15688a = i4;
        this.f15689b = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f15688a;
        g gVar = this.f15689b;
        switch (i4) {
            case 0:
                g.a(gVar);
                break;
            case 1:
                g.c(gVar);
                break;
            case 2:
                g.c(gVar);
                break;
            case 3:
                g.a(gVar);
                break;
            default:
                g.a(gVar);
                break;
        }
    }
}
