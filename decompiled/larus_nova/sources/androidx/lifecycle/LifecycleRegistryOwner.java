package androidx.lifecycle;

/* JADX INFO: loaded from: classes17.dex */
public interface LifecycleRegistryOwner extends LifecycleOwner {

    /* JADX INFO: renamed from: androidx.lifecycle.LifecycleRegistryOwner$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* bridge */ /* synthetic */ Lifecycle $default$getLifecycle(LifecycleRegistryOwner r100) {
            return r100.getLifecycle();
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    /* bridge */ /* synthetic */ Lifecycle getLifecycle();

    @Override // androidx.lifecycle.LifecycleOwner
    LifecycleRegistry getLifecycle();
}
