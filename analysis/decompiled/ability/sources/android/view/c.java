package android.view;

import S7.a;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1656a;
    public final /* synthetic */ ComponentActivity b;

    public /* synthetic */ c(ComponentActivity componentActivity, int i) {
        this.f1656a = i;
        this.b = componentActivity;
    }

    @Override // S7.a
    public final Object invoke() {
        int i = this.f1656a;
        ComponentActivity componentActivity = this.b;
        switch (i) {
            case 0:
                return ComponentActivity.fullyDrawnReporter_delegate$lambda$2$lambda$1(componentActivity);
            case 1:
                return ComponentActivity.fullyDrawnReporter_delegate$lambda$2(componentActivity);
            case 2:
                return ComponentActivity.defaultViewModelProviderFactory_delegate$lambda$9(componentActivity);
            default:
                return ComponentActivity.onBackPressedDispatcher_delegate$lambda$13(componentActivity);
        }
    }
}
