package dagger.hilt.android.internal.managers;

import android.view.SavedStateHandle;
import y7.InterfaceC2137b;

/* loaded from: classes2.dex */
public final class ActivitySavedStateHandleModule_ProvideSavedStateHandleFactory implements InterfaceC2137b {
    private final InterfaceC2137b savedStateHandleHolderProvider;

    private ActivitySavedStateHandleModule_ProvideSavedStateHandleFactory(InterfaceC2137b interfaceC2137b) {
        this.savedStateHandleHolderProvider = interfaceC2137b;
    }

    public static ActivitySavedStateHandleModule_ProvideSavedStateHandleFactory create(InterfaceC2137b interfaceC2137b) {
        return new ActivitySavedStateHandleModule_ProvideSavedStateHandleFactory(interfaceC2137b);
    }

    public static SavedStateHandle provideSavedStateHandle(SavedStateHandleHolder savedStateHandleHolder) {
        SavedStateHandle savedStateHandleProvideSavedStateHandle = ActivitySavedStateHandleModule.provideSavedStateHandle(savedStateHandleHolder);
        if (savedStateHandleProvideSavedStateHandle != null) {
            return savedStateHandleProvideSavedStateHandle;
        }
        throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public SavedStateHandle get() {
        return provideSavedStateHandle((SavedStateHandleHolder) this.savedStateHandleHolderProvider.get());
    }
}
