package com.stepos.motionkit.fx;

import D7.A;
import S0.b;
import android.content.Context;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.BackendHint;
import com.stepos.motionkit.BackendSelector;
import com.stepos.motionkit.CompiledShader;
import com.stepos.motionkit.EffectDefinition;
import com.stepos.motionkit.ErrorLevel;
import com.stepos.motionkit.FxBackend;
import com.stepos.motionkit.FxConfig;
import com.stepos.motionkit.FxInstance;
import com.stepos.motionkit.FxModule;
import com.stepos.motionkit.MotionHost;
import com.stepos.motionkit.MotionKit;
import com.stepos.motionkit.MotionKitError;
import com.stepos.motionkit.MotionModule;
import com.stepos.motionkit.SurfaceRendererType;
import com.stepos.motionkit.fx.backend.RuntimeShaderBackend;
import com.stepos.motionkit.fx.backend.SfBackend;
import com.stepos.motionkit.fx.backend.SurfaceBackend;
import com.stepos.taskrobot.llmapi.stepfun.g;
import j9.AbstractC1607a;
import j9.t;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.k;
import m5.a;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ3\u0010!\u001a\u0004\u0018\u00010\r2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u001f2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\rH\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u000bH\u0016¢\u0006\u0004\b*\u0010+R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010,R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020.0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00101\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00103\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00102R\u0018\u00104\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00102R\u0016\u00105\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106¨\u00067"}, d2 = {"Lcom/stepos/motionkit/fx/FxModuleImpl;", "Lcom/stepos/motionkit/FxModule;", "Lcom/stepos/motionkit/MotionModule;", "Lcom/stepos/motionkit/MotionHost;", "host", AppAgent.CONSTRUCT, "(Lcom/stepos/motionkit/MotionHost;)V", "Lcom/stepos/motionkit/EffectDefinition;", "effect", "Lkotlin/Function1;", "Lcom/stepos/motionkit/FxConfig;", "LC7/r;", "config", "Lcom/stepos/motionkit/FxInstance;", "playSingle", "(Lcom/stepos/motionkit/EffectDefinition;LS7/k;)Lcom/stepos/motionkit/FxInstance;", "Lcom/stepos/motionkit/BackendHint;", "hint", "Lcom/stepos/motionkit/FxBackend;", "getOrCreateBackend", "(Lcom/stepos/motionkit/BackendHint;)Lcom/stepos/motionkit/FxBackend;", "createRuntimeShaderBackend", "()Lcom/stepos/motionkit/FxBackend;", "createSurfaceBackend", "", "resolveShaderSource", "(Lcom/stepos/motionkit/EffectDefinition;Lcom/stepos/motionkit/FxConfig;)Ljava/lang/String;", "", "fps", "setFrameRate", "(I)V", "", "effects", "play", "(Ljava/util/List;LS7/k;)Lcom/stepos/motionkit/FxInstance;", "instance", "stop", "(Lcom/stepos/motionkit/FxInstance;)V", "", "dt", "tick", "(F)V", "release", "()V", "Lcom/stepos/motionkit/MotionHost;", "", "Lcom/stepos/motionkit/fx/FxInstanceImpl;", "instances", "Ljava/util/List;", "runtimeShaderBackend", "Lcom/stepos/motionkit/FxBackend;", "surfaceBackend", "sfBackend", "defaultFrameRate", "I", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FxModuleImpl implements FxModule, MotionModule {
    private int defaultFrameRate;
    private final MotionHost host;
    private final List<FxInstanceImpl> instances;
    private FxBackend runtimeShaderBackend;
    private FxBackend sfBackend;
    private FxBackend surfaceBackend;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BackendHint.values().length];
            try {
                iArr[BackendHint.RUNTIME_SHADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BackendHint.AUTO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BackendHint.SURFACE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BackendHint.SF.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FxModuleImpl(MotionHost host) {
        k.f(host, "host");
        this.host = host;
        this.instances = new ArrayList();
    }

    private final FxBackend createRuntimeShaderBackend() {
        return new RuntimeShaderBackend();
    }

    private final FxBackend createSurfaceBackend() {
        return new SurfaceBackend();
    }

    private final FxBackend getOrCreateBackend(BackendHint hint) {
        int i = WhenMappings.$EnumSwitchMapping$0[hint.ordinal()];
        if (i == 1 || i == 2) {
            FxBackend fxBackend = this.runtimeShaderBackend;
            if (fxBackend != null) {
                return fxBackend;
            }
            FxBackend fxBackendCreateRuntimeShaderBackend = createRuntimeShaderBackend();
            this.runtimeShaderBackend = fxBackendCreateRuntimeShaderBackend;
            return fxBackendCreateRuntimeShaderBackend;
        }
        if (i == 3) {
            FxBackend fxBackend2 = this.surfaceBackend;
            if (fxBackend2 != null) {
                return fxBackend2;
            }
            FxBackend fxBackendCreateSurfaceBackend = createSurfaceBackend();
            this.surfaceBackend = fxBackendCreateSurfaceBackend;
            return fxBackendCreateSurfaceBackend;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        FxBackend fxBackend3 = this.sfBackend;
        if (fxBackend3 != null) {
            return fxBackend3;
        }
        SfBackend sfBackend = new SfBackend();
        this.sfBackend = sfBackend;
        return sfBackend;
    }

    private final FxInstance playSingle(EffectDefinition effect, S7.k config) {
        MotionKit motionKit = MotionKit.INSTANCE;
        try {
            FxConfig fxConfig = new FxConfig();
            config.invoke(fxConfig);
            BackendSelector backendSelector = BackendSelector.INSTANCE;
            Context context = this.host.getView().getContext();
            k.e(context, "getContext(...)");
            BackendHint backendHintSelect = backendSelector.select(effect, fxConfig, context);
            FxBackend orCreateBackend = getOrCreateBackend(backendHintSelect);
            CompiledShader compiledShader = new CompiledShader(resolveShaderSource(effect, fxConfig), backendHintSelect, null, 4, null);
            MotionHost motionHost = this.host;
            FxInstance fxInstanceCreateInstance = orCreateBackend.createInstance(motionHost, motionHost.getView(), compiledShader, fxConfig, effect);
            k.d(fxInstanceCreateInstance, "null cannot be cast to non-null type com.stepos.motionkit.fx.FxInstanceImpl");
            FxInstanceImpl fxInstanceImpl = (FxInstanceImpl) fxInstanceCreateInstance;
            fxInstanceImpl.setEffectName(effect.getName());
            fxInstanceImpl.applyPlayback(fxConfig.getPlayMode(), fxConfig.getDurationMs(), fxConfig.getEndBehavior(), fxConfig.getOnComplete());
            this.instances.add(fxInstanceImpl);
            return fxInstanceImpl;
        } catch (Exception e) {
            motionKit.handleError(new MotionKitError(ErrorLevel.DEGRADED, "FX operation failed", e));
            return null;
        }
    }

    private final String resolveShaderSource(EffectDefinition effect, FxConfig config) throws IOException {
        String shaderSource = effect.getShaderSource();
        if (shaderSource != null) {
            return shaderSource;
        }
        String shaderAsset = effect.getShaderAsset();
        if (shaderAsset == null) {
            return "";
        }
        try {
            InputStream inputStreamOpen = this.host.getView().getContext().getAssets().open("motionkit/shaders/".concat(config.getSurfaceRenderer() == SurfaceRendererType.GLES ? t.c0(shaderAsset, ".agsl", ".glsl") : shaderAsset));
            k.e(inputStreamOpen, "open(...)");
            return b.o1(new BufferedReader(new InputStreamReader(inputStreamOpen, AbstractC1607a.f4778a), 8192));
        } catch (Exception unused) {
            InputStream inputStreamOpen2 = this.host.getView().getContext().getAssets().open("motionkit/shaders/".concat(shaderAsset));
            k.e(inputStreamOpen2, "open(...)");
            return b.o1(new BufferedReader(new InputStreamReader(inputStreamOpen2, AbstractC1607a.f4778a), 8192));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean stop$lambda$1(FxInstanceImpl it) {
        k.f(it, "it");
        return !it.getIsActive();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean stop$lambda$2(FxInstance fxInstance, FxInstanceImpl it) {
        k.f(it, "it");
        return it.getId() == fxInstance.getId();
    }

    @Override // com.stepos.motionkit.FxModule
    public FxInstance play(List<EffectDefinition> effects, S7.k config) {
        k.f(effects, "effects");
        k.f(config, "config");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = effects.iterator();
        while (it.hasNext()) {
            FxInstance fxInstancePlaySingle = playSingle((EffectDefinition) it.next(), config);
            if (fxInstancePlaySingle != null) {
                arrayList.add(fxInstancePlaySingle);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList.size() == 1 ? (FxInstance) arrayList.get(0) : new CompositeFxInstance(arrayList);
    }

    @Override // com.stepos.motionkit.MotionModule
    public void release() {
        Iterator<T> it = this.instances.iterator();
        while (it.hasNext()) {
            ((FxInstanceImpl) it.next()).release();
        }
        this.instances.clear();
        FxBackend fxBackend = this.runtimeShaderBackend;
        if (fxBackend != null) {
            fxBackend.release();
        }
        FxBackend fxBackend2 = this.surfaceBackend;
        if (fxBackend2 != null) {
            fxBackend2.release();
        }
        FxBackend fxBackend3 = this.sfBackend;
        if (fxBackend3 != null) {
            fxBackend3.release();
        }
        this.runtimeShaderBackend = null;
        this.surfaceBackend = null;
        this.sfBackend = null;
    }

    @Override // com.stepos.motionkit.FxModule
    public void setFrameRate(int fps) {
        this.defaultFrameRate = fps;
        this.host.getFrameLoop().setTargetFps(fps);
    }

    @Override // com.stepos.motionkit.FxModule
    public void stop(FxInstance instance) {
        k.f(instance, "instance");
        instance.release();
        if (instance instanceof CompositeFxInstance) {
            A.n0(new a(11), this.instances);
        } else {
            A.n0(new g(instance, 8), this.instances);
        }
    }

    @Override // com.stepos.motionkit.MotionModule
    public void tick(float dt) {
        Iterator<FxInstanceImpl> it = this.instances.iterator();
        while (it.hasNext()) {
            FxInstanceImpl next = it.next();
            if (next.getIsActive()) {
                Float fAccumulateFrame = next.accumulateFrame(dt, this.defaultFrameRate);
                if (fAccumulateFrame != null) {
                    float fFloatValue = fAccumulateFrame.floatValue();
                    next.onFrame(next.getLocalElapsedMs(), fFloatValue);
                    if (!next.advance(fFloatValue)) {
                        it.remove();
                    }
                }
            } else {
                it.remove();
            }
        }
    }
}
