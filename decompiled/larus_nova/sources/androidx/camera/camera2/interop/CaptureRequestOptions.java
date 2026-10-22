package androidx.camera.camera2.interop;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.core.ExtendableBuilder;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.ReadableConfig;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class CaptureRequestOptions implements ReadableConfig {
    private final Config mConfig;

    public static final class Builder implements ExtendableBuilder<CaptureRequestOptions> {
        private final MutableOptionsBundle mMutableOptionsBundle;

        public static /* synthetic */ boolean a(Builder r100, Config r101, Config.Option r102) {
            return lambda$from$0(r100, r101, r102);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.ExtendableBuilder
        public CaptureRequestOptions build() {
            return new CaptureRequestOptions(OptionsBundle.from(this.mMutableOptionsBundle));
        }

        public Builder() {
            this.mMutableOptionsBundle = MutableOptionsBundle.create();
        }

        @Override // androidx.camera.core.ExtendableBuilder
        public MutableConfig getMutableConfig() {
            return this.mMutableOptionsBundle;
        }

        @Override // androidx.camera.core.ExtendableBuilder
        public /* bridge */ /* synthetic */ CaptureRequestOptions build() {
            return build();
        }

        public static Builder from(final Config r100) {
            final Builder r101 = new Builder();
            r100.findOptions(Camera2ImplConfig.CAPTURE_REQUEST_ID_STEM, new i(r101, r100));
            return r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <ValueT> Builder clearCaptureRequestOption(CaptureRequest.Key<ValueT> r100) {
            Config.Option<Object> r101 = Camera2ImplConfig.createCaptureRequestOption(r100);
            this.mMutableOptionsBundle.removeOption(r101);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <ValueT> Builder setCaptureRequestOption(CaptureRequest.Key<ValueT> r100, ValueT r101) {
            Config.Option<Object> r102 = Camera2ImplConfig.createCaptureRequestOption(r100);
            this.mMutableOptionsBundle.insertOption(r102, r101);
            return this;
        }

        private static /* synthetic */ boolean lambda$from$0(Builder r100, Config r101, Config.Option r102) {
            r100.getMutableConfig().insertOption(r102, r101.getOptionPriority(r102), r101.retrieveOption(r102));
            return true;
        }
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

    @Override // androidx.camera.core.impl.ReadableConfig
    public Config getConfig() {
        return this.mConfig;
    }

    public CaptureRequestOptions(Config r100) {
        this.mConfig = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <ValueT> ValueT getCaptureRequestOption(CaptureRequest.Key<ValueT> r100) {
        Config.Option<Object> r101 = Camera2ImplConfig.createCaptureRequestOption(r100);
        return (ValueT) this.mConfig.retrieveOption(r101, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <ValueT> ValueT getCaptureRequestOption(CaptureRequest.Key<ValueT> r100, ValueT r101) {
        Config.Option<Object> r102 = Camera2ImplConfig.createCaptureRequestOption(r100);
        return (ValueT) this.mConfig.retrieveOption(r102, r101);
    }
}
