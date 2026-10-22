package android.view;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1654a;
    public final /* synthetic */ ComponentActivity b;

    public /* synthetic */ a(ComponentActivity componentActivity, int i) {
        this.f1654a = i;
        this.b = componentActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f1654a;
        ComponentActivity componentActivity = this.b;
        switch (i) {
            case 0:
                componentActivity.invalidateMenu();
                break;
            default:
                ComponentActivity.onBackPressedDispatcher_delegate$lambda$13$lambda$10(componentActivity);
                break;
        }
    }
}
