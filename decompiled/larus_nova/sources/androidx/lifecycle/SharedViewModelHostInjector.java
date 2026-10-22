package androidx.lifecycle;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/lifecycle/SharedViewModelHostInjector;", "", "()V", "optimiseLifecycle", "", "getOptimiseLifecycle", "()Z", "setOptimiseLifecycle", "(Z)V", "SharedViewModel_release"}, k = 1, mv = {1, 1, 16})
public final class SharedViewModelHostInjector {
    public static final SharedViewModelHostInjector INSTANCE = null;
    private static boolean optimiseLifecycle;

    private SharedViewModelHostInjector() {
    }

    static {
        INSTANCE = new SharedViewModelHostInjector();
    }

    public final boolean getOptimiseLifecycle() {
        return optimiseLifecycle;
    }

    public final void setOptimiseLifecycle(boolean r100) {
        optimiseLifecycle = r100;
    }
}
