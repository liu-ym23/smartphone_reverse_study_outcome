package com.stepos.motionkit.fx;

import androidx.autofill.HintConstants;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.motionkit.AnimationDefinition;
import com.stepos.motionkit.BackendHint;
import com.stepos.motionkit.EffectDefinition;
import com.stepos.motionkit.UniformSpec;
import com.stepos.motionkit.fx.anim.AnimationDslKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0005J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0005J\u001d\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J-\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0015J5\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J!\u0010$\u001a\u00020\u00072\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00070!¢\u0006\u0004\b$\u0010%J\u000f\u0010)\u001a\u00020&H\u0000¢\u0006\u0004\b'\u0010(R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010*R\u0018\u0010+\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010*R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010*R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00100\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u0010$\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u00103¨\u00064"}, d2 = {"Lcom/stepos/motionkit/fx/EffectBuilder;", "", "", HintConstants.AUTOFILL_HINT_NAME, AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", AgentBusWakeContract.EXTRA_SOURCE, "LC7/r;", "shader", SingleFileBundle.KEY_PATH, "shaderAsset", "", "default", "uniform", "(Ljava/lang/String;F)V", "x", "y", "uniform2", "(Ljava/lang/String;FF)V", "z", "uniform3", "(Ljava/lang/String;FFF)V", "w", "uniform4", "(Ljava/lang/String;FFFF)V", "", TypedValues.Custom.S_COLOR, "colorUniform", "(Ljava/lang/String;I)V", "Lcom/stepos/motionkit/BackendHint;", "hint", "backend", "(Lcom/stepos/motionkit/BackendHint;)V", "Lkotlin/Function1;", "Lcom/stepos/motionkit/fx/anim/AnimationBuilder;", "block", "animation", "(LS7/k;)V", "Lcom/stepos/motionkit/EffectDefinition;", "build$motionkit_fx_release", "()Lcom/stepos/motionkit/EffectDefinition;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Ljava/lang/String;", "shaderSource", "", "Lcom/stepos/motionkit/UniformSpec;", "uniforms", "Ljava/util/List;", "backendHint", "Lcom/stepos/motionkit/BackendHint;", "Lcom/stepos/motionkit/AnimationDefinition;", "Lcom/stepos/motionkit/AnimationDefinition;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EffectBuilder {
    private AnimationDefinition animation;
    private BackendHint backendHint;
    private final String name;
    private String shaderAsset;
    private String shaderSource;
    private List<UniformSpec> uniforms;

    public EffectBuilder(String name) {
        k.f(name, "name");
        this.name = name;
        this.uniforms = new ArrayList();
        this.backendHint = BackendHint.AUTO;
    }

    public final void animation(S7.k block) {
        k.f(block, "block");
        this.animation = AnimationDslKt.animation(block);
    }

    public final void backend(BackendHint hint) {
        k.f(hint, "hint");
        this.backendHint = hint;
    }

    public final EffectDefinition build$motionkit_fx_release() {
        return new EffectDefinition(this.name, this.shaderAsset, this.shaderSource, this.uniforms, this.backendHint, false, this.animation, 32, null);
    }

    public final void colorUniform(String name, int color) {
        k.f(name, "name");
        this.uniforms.add(new UniformSpec.Color(name, color, null, 4, null));
    }

    public final void shader(String source) {
        k.f(source, "source");
        this.shaderSource = source;
    }

    public final void shaderAsset(String path) {
        k.f(path, "path");
        this.shaderAsset = path;
    }

    public final void uniform(String name, float f) {
        k.f(name, "name");
        this.uniforms.add(new UniformSpec.Float1(name, f, null, null, 12, null));
    }

    public final void uniform2(String name, float x10, float y) {
        k.f(name, "name");
        this.uniforms.add(new UniformSpec.Float2(name, x10, y, null, 8, null));
    }

    public final void uniform3(String name, float x10, float y, float z10) {
        k.f(name, "name");
        this.uniforms.add(new UniformSpec.Float3(name, x10, y, z10, null, 16, null));
    }

    public final void uniform4(String name, float x10, float y, float z10, float w8) {
        k.f(name, "name");
        this.uniforms.add(new UniformSpec.Float4(name, x10, y, z10, w8, null, 32, null));
    }
}
