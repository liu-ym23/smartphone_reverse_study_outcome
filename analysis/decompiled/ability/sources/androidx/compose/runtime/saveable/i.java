package androidx.compose.runtime.saveable;

/* loaded from: classes.dex */
public final /* synthetic */ class i implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1809a;

    public /* synthetic */ i(int i) {
        this.f1809a = i;
    }

    @Override // S7.a
    public final Object invoke() {
        switch (this.f1809a) {
            case 0:
                return SaveableStateHolderKt.rememberSaveableStateHolder$lambda$1$lambda$0();
            default:
                return SaveableStateRegistryKt.LocalSaveableStateRegistry$lambda$0();
        }
    }
}
