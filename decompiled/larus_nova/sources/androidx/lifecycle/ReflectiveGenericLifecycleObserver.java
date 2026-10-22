package androidx.lifecycle;

/* JADX INFO: loaded from: classes3.dex */
class ReflectiveGenericLifecycleObserver implements LifecycleEventObserver {
    private final ClassesInfoCache.CallbackInfo mInfo;
    private final Object mWrapped;

    public ReflectiveGenericLifecycleObserver(Object r100) {
        this.mWrapped = r100;
        this.mInfo = ClassesInfoCache.sInstance.getInfo(r100.getClass());
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        this.mInfo.invokeCallbacks(r100, r101, this.mWrapped);
    }
}
