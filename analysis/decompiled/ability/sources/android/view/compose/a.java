package android.view.compose;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1657a;

    public /* synthetic */ a(int i) {
        this.f1657a = i;
    }

    @Override // S7.a
    public final Object invoke() {
        switch (this.f1657a) {
            case 0:
                return ActivityResultRegistryKt.rememberLauncherForActivityResult$lambda$1$lambda$0();
            case 1:
                return LocalActivityResultRegistryOwner.LocalComposition$lambda$0();
            case 2:
                return LocalFullyDrawnReporterOwner.LocalFullyDrawnReporterOwner$lambda$0();
            case 3:
                return LocalOnBackPressedDispatcherOwner.LocalOnBackPressedDispatcherOwner$lambda$0();
            default:
                return Boolean.valueOf(ReportDrawnKt.ReportDrawn$lambda$7$lambda$6());
        }
    }
}
