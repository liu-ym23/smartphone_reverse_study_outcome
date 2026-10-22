package dagger.hilt.android.internal.modules;

import android.app.Application;
import y7.InterfaceC2137b;

/* loaded from: classes2.dex */
public final class ApplicationContextModule_ProvideApplicationFactory implements InterfaceC2137b {
    private final ApplicationContextModule module;

    private ApplicationContextModule_ProvideApplicationFactory(ApplicationContextModule applicationContextModule) {
        this.module = applicationContextModule;
    }

    public static ApplicationContextModule_ProvideApplicationFactory create(ApplicationContextModule applicationContextModule) {
        return new ApplicationContextModule_ProvideApplicationFactory(applicationContextModule);
    }

    public static Application provideApplication(ApplicationContextModule applicationContextModule) {
        Application applicationProvideApplication = applicationContextModule.provideApplication();
        if (applicationProvideApplication != null) {
            return applicationProvideApplication;
        }
        throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public Application get() {
        return provideApplication(this.module);
    }
}
