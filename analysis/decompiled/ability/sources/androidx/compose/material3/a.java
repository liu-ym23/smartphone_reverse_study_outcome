package androidx.compose.material3;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements ScrolledOffset {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1743a;
    public final /* synthetic */ TopAppBarScrollBehavior b;

    public /* synthetic */ a(TopAppBarScrollBehavior topAppBarScrollBehavior, int i) {
        this.f1743a = i;
        this.b = topAppBarScrollBehavior;
    }

    @Override // androidx.compose.material3.ScrolledOffset
    public final float offset() {
        int i = this.f1743a;
        TopAppBarScrollBehavior topAppBarScrollBehavior = this.b;
        switch (i) {
            case 0:
                return AppBarKt$SingleRowTopAppBar$3.invoke$lambda$1$lambda$0(topAppBarScrollBehavior);
            default:
                return AppBarKt$TwoRowsTopAppBar$6.invoke$lambda$3$lambda$2$lambda$1(topAppBarScrollBehavior);
        }
    }
}
