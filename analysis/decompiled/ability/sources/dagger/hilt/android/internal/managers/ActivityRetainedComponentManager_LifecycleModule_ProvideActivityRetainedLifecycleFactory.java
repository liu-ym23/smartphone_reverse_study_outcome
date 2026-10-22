package dagger.hilt.android.internal.managers;

import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager;
import y7.InterfaceC2137b;

/* loaded from: classes2.dex */
public final class ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory implements InterfaceC2137b {

    public static final class InstanceHolder {
        static final ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory INSTANCE = new ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory();

        private InstanceHolder() {
        }
    }

    public static ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ActivityRetainedLifecycle provideActivityRetainedLifecycle() {
        ActivityRetainedLifecycle activityRetainedLifecycleProvideActivityRetainedLifecycle = ActivityRetainedComponentManager.LifecycleModule.provideActivityRetainedLifecycle();
        if (activityRetainedLifecycleProvideActivityRetainedLifecycle != null) {
            return activityRetainedLifecycleProvideActivityRetainedLifecycle;
        }
        throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public ActivityRetainedLifecycle get() {
        return provideActivityRetainedLifecycle();
    }
}
