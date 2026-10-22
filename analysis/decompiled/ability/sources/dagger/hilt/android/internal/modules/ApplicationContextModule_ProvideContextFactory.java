package dagger.hilt.android.internal.modules;

import android.content.Context;
import y7.InterfaceC2137b;

/* loaded from: classes2.dex */
public final class ApplicationContextModule_ProvideContextFactory implements InterfaceC2137b {
    private final ApplicationContextModule module;

    private ApplicationContextModule_ProvideContextFactory(ApplicationContextModule applicationContextModule) {
        this.module = applicationContextModule;
    }

    public static ApplicationContextModule_ProvideContextFactory create(ApplicationContextModule applicationContextModule) {
        return new ApplicationContextModule_ProvideContextFactory(applicationContextModule);
    }

    public static Context provideContext(ApplicationContextModule applicationContextModule) {
        Context contextProvideContext = applicationContextModule.provideContext();
        if (contextProvideContext != null) {
            return contextProvideContext;
        }
        throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public Context get() {
        return provideContext(this.module);
    }
}
