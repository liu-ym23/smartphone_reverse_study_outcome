package androidx.camera.core;

import android.os.Handler;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.QuirkSettings;
import androidx.camera.core.impl.ReadableConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.internal.TargetConfig;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class CameraXConfig implements TargetConfig<CameraX> {
    static final long DEFAULT_OPTION_CAMERA_OPEN_RETRY_MAX_TIMEOUT_IN_MILLIS_WHILE_RESUMING = -1;
    static final Config.Option<CameraSelector> OPTION_AVAILABLE_CAMERAS_LIMITER = null;
    static final Config.Option<Executor> OPTION_CAMERA_EXECUTOR = null;
    static final Config.Option<CameraFactory.Provider> OPTION_CAMERA_FACTORY_PROVIDER = null;
    static final Config.Option<Long> OPTION_CAMERA_OPEN_RETRY_MAX_TIMEOUT_IN_MILLIS_WHILE_RESUMING = null;
    static final Config.Option<RetryPolicy> OPTION_CAMERA_PROVIDER_INIT_RETRY_POLICY = null;
    static final Config.Option<CameraDeviceSurfaceManager.Provider> OPTION_DEVICE_SURFACE_MANAGER_PROVIDER = null;
    static final Config.Option<Integer> OPTION_MIN_LOGGING_LEVEL = null;
    static final Config.Option<QuirkSettings> OPTION_QUIRK_SETTINGS = null;
    static final Config.Option<Handler> OPTION_SCHEDULER_HANDLER = null;
    static final Config.Option<UseCaseConfigFactory.Provider> OPTION_USECASE_CONFIG_FACTORY_PROVIDER = null;
    private final OptionsBundle mConfig;

    public static final class Builder implements TargetConfig.Builder<CameraX, Builder> {
        private final MutableOptionsBundle mMutableConfig;

        public CameraXConfig build() {
            return new CameraXConfig(OptionsBundle.from(this.mMutableConfig));
        }

        public Builder() {
            this(MutableOptionsBundle.create());
        }

        private MutableConfig getMutableConfig() {
            return this.mMutableConfig;
        }

        private Builder(MutableOptionsBundle r100) {
            this.mMutableConfig = r100;
            Class r101 = (Class) r100.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
            if (r101 != null) goto L5;
        L9:
            setTargetClass(CameraX.class);
            return;
        L5:
            if (r101.equals(CameraX.class) == true) goto L9;
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + r101);
        }

        public static Builder fromConfig(CameraXConfig r100) {
            return new Builder(MutableOptionsBundle.from(r100));
        }

        public Builder setAvailableCamerasLimiter(CameraSelector r100) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_AVAILABLE_CAMERAS_LIMITER, r100);
            return this;
        }

        public Builder setCameraExecutor(Executor r100) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_CAMERA_EXECUTOR, r100);
            return this;
        }

        public Builder setCameraFactoryProvider(CameraFactory.Provider r100) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_CAMERA_FACTORY_PROVIDER, r100);
            return this;
        }

        public Builder setCameraOpenRetryMaxTimeoutInMillisWhileResuming(long r100) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_CAMERA_OPEN_RETRY_MAX_TIMEOUT_IN_MILLIS_WHILE_RESUMING, Long.valueOf(r100));
            return this;
        }

        public Builder setCameraProviderInitRetryPolicy(RetryPolicy r100) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_CAMERA_PROVIDER_INIT_RETRY_POLICY, r100);
            return this;
        }

        public Builder setDeviceSurfaceManagerProvider(CameraDeviceSurfaceManager.Provider r100) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_DEVICE_SURFACE_MANAGER_PROVIDER, r100);
            return this;
        }

        public Builder setMinimumLoggingLevel(int r100) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_MIN_LOGGING_LEVEL, Integer.valueOf(r100));
            return this;
        }

        public Builder setQuirkSettings(QuirkSettings r100) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_QUIRK_SETTINGS, r100);
            return this;
        }

        public Builder setSchedulerHandler(Handler r100) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_SCHEDULER_HANDLER, r100);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.internal.TargetConfig.Builder
        public Builder setTargetClass(Class<CameraX> r100) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_CLASS, r100);
            if (getMutableConfig().retrieveOption(TargetConfig.OPTION_TARGET_NAME, null) != null) goto L5;
            setTargetName(r100.getCanonicalName() + "-" + UUID.randomUUID());
        L5:
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.internal.TargetConfig.Builder
        public Builder setTargetName(String r100) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_NAME, r100);
            return this;
        }

        public Builder setUseCaseConfigFactoryProvider(UseCaseConfigFactory.Provider r100) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_USECASE_CONFIG_FACTORY_PROVIDER, r100);
            return this;
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        public /* bridge */ /* synthetic */ Builder setTargetClass(Class<CameraX> r100) {
            return setTargetClass(r100);
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        public /* bridge */ /* synthetic */ Builder setTargetName(String r100) {
            return setTargetName(r100);
        }
    }

    public interface Provider {
        CameraXConfig getCameraXConfig();
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ boolean containsOption(Config.Option r100) {
        return ReadableConfig.CC.$default$containsOption(this, r100);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ void findOptions(String r100, Config.OptionMatcher r101) {
        ReadableConfig.CC.$default$findOptions(this, r100, r101);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ Config.OptionPriority getOptionPriority(Config.Option r100) {
        return ReadableConfig.CC.$default$getOptionPriority(this, r100);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ Set getPriorities(Config.Option r100) {
        return ReadableConfig.CC.$default$getPriorities(this, r100);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    public final /* synthetic */ Class<CameraX> getTargetClass() {
        return TargetConfig.CC.$default$getTargetClass(this);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    public final /* synthetic */ Class<CameraX> getTargetClass(Class<CameraX> r100) {
        return TargetConfig.CC.$default$getTargetClass(this, r100);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    public final /* synthetic */ String getTargetName() {
        return TargetConfig.CC.$default$getTargetName(this);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    public final /* synthetic */ String getTargetName(String r100) {
        return TargetConfig.CC.$default$getTargetName(this, r100);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ Set listOptions() {
        return ReadableConfig.CC.$default$listOptions(this);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ Object retrieveOption(Config.Option r100) {
        return ReadableConfig.CC.$default$retrieveOption(this, r100);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ Object retrieveOption(Config.Option r100, Object r101) {
        return ReadableConfig.CC.$default$retrieveOption(this, r100, r101);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ Object retrieveOptionWithPriority(Config.Option r100, Config.OptionPriority r101) {
        return ReadableConfig.CC.$default$retrieveOptionWithPriority(this, r100, r101);
    }

    static {
        OPTION_CAMERA_FACTORY_PROVIDER = Config.Option.create("camerax.core.appConfig.cameraFactoryProvider", CameraFactory.Provider.class);
        OPTION_DEVICE_SURFACE_MANAGER_PROVIDER = Config.Option.create("camerax.core.appConfig.deviceSurfaceManagerProvider", CameraDeviceSurfaceManager.Provider.class);
        OPTION_USECASE_CONFIG_FACTORY_PROVIDER = Config.Option.create("camerax.core.appConfig.useCaseConfigFactoryProvider", UseCaseConfigFactory.Provider.class);
        OPTION_CAMERA_EXECUTOR = Config.Option.create("camerax.core.appConfig.cameraExecutor", Executor.class);
        OPTION_SCHEDULER_HANDLER = Config.Option.create("camerax.core.appConfig.schedulerHandler", Handler.class);
        OPTION_MIN_LOGGING_LEVEL = Config.Option.create("camerax.core.appConfig.minimumLoggingLevel", Integer.TYPE);
        OPTION_AVAILABLE_CAMERAS_LIMITER = Config.Option.create("camerax.core.appConfig.availableCamerasLimiter", CameraSelector.class);
        OPTION_CAMERA_OPEN_RETRY_MAX_TIMEOUT_IN_MILLIS_WHILE_RESUMING = Config.Option.create("camerax.core.appConfig.cameraOpenRetryMaxTimeoutInMillisWhileResuming", Long.TYPE);
        OPTION_CAMERA_PROVIDER_INIT_RETRY_POLICY = Config.Option.create("camerax.core.appConfig.cameraProviderInitRetryPolicy", RetryPolicy.class);
        OPTION_QUIRK_SETTINGS = Config.Option.create("camerax.core.appConfig.quirksSettings", QuirkSettings.class);
    }

    public long getCameraOpenRetryMaxTimeoutInMillisWhileResuming() {
        return ((Long) this.mConfig.retrieveOption(OPTION_CAMERA_OPEN_RETRY_MAX_TIMEOUT_IN_MILLIS_WHILE_RESUMING, -1L)).longValue();
    }

    public RetryPolicy getCameraProviderInitRetryPolicy() {
        RetryPolicy r100 = (RetryPolicy) this.mConfig.retrieveOption(OPTION_CAMERA_PROVIDER_INIT_RETRY_POLICY, RetryPolicy.DEFAULT);
        Objects.requireNonNull(r100);
        return r100;
    }

    public int getMinimumLoggingLevel() {
        return ((Integer) this.mConfig.retrieveOption(OPTION_MIN_LOGGING_LEVEL, 3)).intValue();
    }

    public QuirkSettings getQuirkSettings() {
        return (QuirkSettings) this.mConfig.retrieveOption(OPTION_QUIRK_SETTINGS, null);
    }

    @Override // androidx.camera.core.impl.ReadableConfig
    public Config getConfig() {
        return this.mConfig;
    }

    public CameraXConfig(OptionsBundle r100) {
        this.mConfig = r100;
    }

    public CameraSelector getAvailableCamerasLimiter(CameraSelector r100) {
        return (CameraSelector) this.mConfig.retrieveOption(OPTION_AVAILABLE_CAMERAS_LIMITER, r100);
    }

    public Executor getCameraExecutor(Executor r100) {
        return (Executor) this.mConfig.retrieveOption(OPTION_CAMERA_EXECUTOR, r100);
    }

    public CameraFactory.Provider getCameraFactoryProvider(CameraFactory.Provider r100) {
        return (CameraFactory.Provider) this.mConfig.retrieveOption(OPTION_CAMERA_FACTORY_PROVIDER, r100);
    }

    public CameraDeviceSurfaceManager.Provider getDeviceSurfaceManagerProvider(CameraDeviceSurfaceManager.Provider r100) {
        return (CameraDeviceSurfaceManager.Provider) this.mConfig.retrieveOption(OPTION_DEVICE_SURFACE_MANAGER_PROVIDER, r100);
    }

    public Handler getSchedulerHandler(Handler r100) {
        return (Handler) this.mConfig.retrieveOption(OPTION_SCHEDULER_HANDLER, r100);
    }

    public UseCaseConfigFactory.Provider getUseCaseConfigFactoryProvider(UseCaseConfigFactory.Provider r100) {
        return (UseCaseConfigFactory.Provider) this.mConfig.retrieveOption(OPTION_USECASE_CONFIG_FACTORY_PROVIDER, r100);
    }
}
