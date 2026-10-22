package androidx.compose.ui.platform;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1887a;
    public final /* synthetic */ Object b;

    public /* synthetic */ d(Object obj, int i) {
        this.f1887a = i;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f1887a;
        Object obj = this.b;
        switch (i) {
            case 0:
                AndroidComposeView.sendHoverExitEvent$lambda$10((AndroidComposeView) obj);
                break;
            default:
                AndroidComposeViewAccessibilityDelegateCompat.semanticsChangeChecker$lambda$50((AndroidComposeViewAccessibilityDelegateCompat) obj);
                break;
        }
    }
}
