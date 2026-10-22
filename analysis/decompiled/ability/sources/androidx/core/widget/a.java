package androidx.core.widget;

/* loaded from: classes2.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1947a;
    public final /* synthetic */ ContentLoadingProgressBar b;

    public /* synthetic */ a(ContentLoadingProgressBar contentLoadingProgressBar, int i) {
        this.f1947a = i;
        this.b = contentLoadingProgressBar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f1947a;
        ContentLoadingProgressBar contentLoadingProgressBar = this.b;
        switch (i) {
            case 0:
                contentLoadingProgressBar.lambda$new$0();
                break;
            case 1:
                contentLoadingProgressBar.lambda$new$1();
                break;
            case 2:
                contentLoadingProgressBar.showOnUiThread();
                break;
            default:
                contentLoadingProgressBar.hideOnUiThread();
                break;
        }
    }
}
