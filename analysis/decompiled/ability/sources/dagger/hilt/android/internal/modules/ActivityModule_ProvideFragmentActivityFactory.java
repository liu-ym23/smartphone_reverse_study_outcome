package dagger.hilt.android.internal.modules;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import y7.InterfaceC2137b;

/* loaded from: classes2.dex */
public final class ActivityModule_ProvideFragmentActivityFactory implements InterfaceC2137b {
    private final InterfaceC2137b activityProvider;

    private ActivityModule_ProvideFragmentActivityFactory(InterfaceC2137b interfaceC2137b) {
        this.activityProvider = interfaceC2137b;
    }

    public static ActivityModule_ProvideFragmentActivityFactory create(InterfaceC2137b interfaceC2137b) {
        return new ActivityModule_ProvideFragmentActivityFactory(interfaceC2137b);
    }

    public static FragmentActivity provideFragmentActivity(Activity activity) {
        FragmentActivity fragmentActivityProvideFragmentActivity = ActivityModule.provideFragmentActivity(activity);
        if (fragmentActivityProvideFragmentActivity != null) {
            return fragmentActivityProvideFragmentActivity;
        }
        throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public FragmentActivity get() {
        return provideFragmentActivity((Activity) this.activityProvider.get());
    }
}
