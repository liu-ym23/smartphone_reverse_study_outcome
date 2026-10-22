package androidx.camera.core.impl;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class CameraConfigs {
    private static final CameraConfig DEFAULT_CAMERA_CONFIG = null;

    public static final class DefaultCameraConfig implements CameraConfig {
        private final Identifier mIdentifier;

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

        @Override // androidx.camera.core.impl.CameraConfig
        public final /* synthetic */ SessionProcessor getSessionProcessor() {
            return CameraConfig.CC.$default$getSessionProcessor(this);
        }

        @Override // androidx.camera.core.impl.CameraConfig
        public final /* synthetic */ SessionProcessor getSessionProcessor(SessionProcessor r100) {
            return CameraConfig.CC.$default$getSessionProcessor(this, r100);
        }

        @Override // androidx.camera.core.impl.CameraConfig
        public final /* synthetic */ int getUseCaseCombinationRequiredRule() {
            return CameraConfig.CC.$default$getUseCaseCombinationRequiredRule(this);
        }

        @Override // androidx.camera.core.impl.CameraConfig
        public final /* synthetic */ UseCaseConfigFactory getUseCaseConfigFactory() {
            return CameraConfig.CC.$default$getUseCaseConfigFactory(this);
        }

        @Override // androidx.camera.core.impl.CameraConfig
        public final /* synthetic */ boolean isCaptureProcessProgressSupported() {
            return CameraConfig.CC.$default$isCaptureProcessProgressSupported(this);
        }

        @Override // androidx.camera.core.impl.CameraConfig
        public final /* synthetic */ boolean isPostviewSupported() {
            return CameraConfig.CC.$default$isPostviewSupported(this);
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

        public DefaultCameraConfig() {
            this.mIdentifier = Identifier.create(new Object());
        }

        @Override // androidx.camera.core.impl.ReadableConfig
        public Config getConfig() {
            return OptionsBundle.emptyBundle();
        }

        @Override // androidx.camera.core.impl.CameraConfig
        public Identifier getCompatibilityId() {
            return this.mIdentifier;
        }
    }

    static {
        DEFAULT_CAMERA_CONFIG = new DefaultCameraConfig();
    }

    private CameraConfigs() {
    }

    public static CameraConfig defaultConfig() {
        return DEFAULT_CAMERA_CONFIG;
    }
}
