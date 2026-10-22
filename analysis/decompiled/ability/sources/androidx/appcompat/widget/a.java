package androidx.appcompat.widget;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1693a;
    public final /* synthetic */ Toolbar b;

    public /* synthetic */ a(Toolbar toolbar, int i) {
        this.f1693a = i;
        this.b = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f1693a;
        Toolbar toolbar = this.b;
        switch (i) {
            case 0:
                toolbar.collapseActionView();
                break;
            default:
                toolbar.invalidateMenu();
                break;
        }
    }
}
