package androidx.compose.runtime.saveable;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1803a;
    public final /* synthetic */ Object b;

    public /* synthetic */ c(Object obj, int i) {
        this.f1803a = i;
        this.b = obj;
    }

    @Override // S7.a
    public final Object invoke() {
        int i = this.f1803a;
        Object obj = this.b;
        switch (i) {
            case 0:
                return SaveableHolder.valueProvider$lambda$2((SaveableHolder) obj);
            default:
                return SaveableStateRegistryWrapper._init_$lambda$1((SaveableStateRegistryWrapper) obj);
        }
    }
}
