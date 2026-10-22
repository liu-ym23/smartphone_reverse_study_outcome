package com.stepos.motionkit;

import androidx.appfunctions.metadata.a;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\fHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000eHÆ\u0003J[\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010%\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006*"}, d2 = {"Lcom/stepos/motionkit/EffectDefinition;", "", HintConstants.AUTOFILL_HINT_NAME, "", "shaderAsset", "shaderSource", "uniforms", "", "Lcom/stepos/motionkit/UniformSpec;", "backendHint", "Lcom/stepos/motionkit/BackendHint;", "requiresBackground", "", "animation", "Lcom/stepos/motionkit/AnimationDefinition;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/stepos/motionkit/BackendHint;ZLcom/stepos/motionkit/AnimationDefinition;)V", "getName", "()Ljava/lang/String;", "getShaderAsset", "getShaderSource", "getUniforms", "()Ljava/util/List;", "getBackendHint", "()Lcom/stepos/motionkit/BackendHint;", "getRequiresBackground", "()Z", "getAnimation", "()Lcom/stepos/motionkit/AnimationDefinition;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class EffectDefinition {
    private final AnimationDefinition animation;
    private final BackendHint backendHint;
    private final String name;
    private final boolean requiresBackground;
    private final String shaderAsset;
    private final String shaderSource;
    private final List<UniformSpec> uniforms;

    /* JADX WARN: Multi-variable type inference failed */
    public EffectDefinition(String name, String str, String str2, List<? extends UniformSpec> uniforms, BackendHint backendHint, boolean z10, AnimationDefinition animationDefinition) {
        k.f(name, "name");
        k.f(uniforms, "uniforms");
        k.f(backendHint, "backendHint");
        this.name = name;
        this.shaderAsset = str;
        this.shaderSource = str2;
        this.uniforms = uniforms;
        this.backendHint = backendHint;
        this.requiresBackground = z10;
        this.animation = animationDefinition;
    }

    public static /* synthetic */ EffectDefinition copy$default(EffectDefinition effectDefinition, String str, String str2, String str3, List list, BackendHint backendHint, boolean z10, AnimationDefinition animationDefinition, int i, Object obj) {
        if ((i & 1) != 0) {
            str = effectDefinition.name;
        }
        if ((i & 2) != 0) {
            str2 = effectDefinition.shaderAsset;
        }
        if ((i & 4) != 0) {
            str3 = effectDefinition.shaderSource;
        }
        if ((i & 8) != 0) {
            list = effectDefinition.uniforms;
        }
        if ((i & 16) != 0) {
            backendHint = effectDefinition.backendHint;
        }
        if ((i & 32) != 0) {
            z10 = effectDefinition.requiresBackground;
        }
        if ((i & 64) != 0) {
            animationDefinition = effectDefinition.animation;
        }
        boolean z11 = z10;
        AnimationDefinition animationDefinition2 = animationDefinition;
        BackendHint backendHint2 = backendHint;
        String str4 = str3;
        return effectDefinition.copy(str, str2, str4, list, backendHint2, z11, animationDefinition2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getShaderAsset() {
        return this.shaderAsset;
    }

    /* renamed from: component3, reason: from getter */
    public final String getShaderSource() {
        return this.shaderSource;
    }

    public final List<UniformSpec> component4() {
        return this.uniforms;
    }

    /* renamed from: component5, reason: from getter */
    public final BackendHint getBackendHint() {
        return this.backendHint;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getRequiresBackground() {
        return this.requiresBackground;
    }

    /* renamed from: component7, reason: from getter */
    public final AnimationDefinition getAnimation() {
        return this.animation;
    }

    public final EffectDefinition copy(String name, String shaderAsset, String shaderSource, List<? extends UniformSpec> uniforms, BackendHint backendHint, boolean requiresBackground, AnimationDefinition animation) {
        k.f(name, "name");
        k.f(uniforms, "uniforms");
        k.f(backendHint, "backendHint");
        return new EffectDefinition(name, shaderAsset, shaderSource, uniforms, backendHint, requiresBackground, animation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EffectDefinition)) {
            return false;
        }
        EffectDefinition effectDefinition = (EffectDefinition) other;
        return k.b(this.name, effectDefinition.name) && k.b(this.shaderAsset, effectDefinition.shaderAsset) && k.b(this.shaderSource, effectDefinition.shaderSource) && k.b(this.uniforms, effectDefinition.uniforms) && this.backendHint == effectDefinition.backendHint && this.requiresBackground == effectDefinition.requiresBackground && k.b(this.animation, effectDefinition.animation);
    }

    public final AnimationDefinition getAnimation() {
        return this.animation;
    }

    public final BackendHint getBackendHint() {
        return this.backendHint;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getRequiresBackground() {
        return this.requiresBackground;
    }

    public final String getShaderAsset() {
        return this.shaderAsset;
    }

    public final String getShaderSource() {
        return this.shaderSource;
    }

    public final List<UniformSpec> getUniforms() {
        return this.uniforms;
    }

    public int hashCode() {
        int iHashCode = this.name.hashCode() * 31;
        String str = this.shaderAsset;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.shaderSource;
        int iD = a.d((this.backendHint.hashCode() + a.e(this.uniforms, (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31, 31)) * 31, 31, this.requiresBackground);
        AnimationDefinition animationDefinition = this.animation;
        return iD + (animationDefinition != null ? animationDefinition.hashCode() : 0);
    }

    public String toString() {
        String str = this.name;
        String str2 = this.shaderAsset;
        String str3 = this.shaderSource;
        List<UniformSpec> list = this.uniforms;
        BackendHint backendHint = this.backendHint;
        boolean z10 = this.requiresBackground;
        AnimationDefinition animationDefinition = this.animation;
        StringBuilder sbW = B7.a.w("EffectDefinition(name=", str, ", shaderAsset=", str2, ", shaderSource=");
        sbW.append(str3);
        sbW.append(", uniforms=");
        sbW.append(list);
        sbW.append(", backendHint=");
        sbW.append(backendHint);
        sbW.append(", requiresBackground=");
        sbW.append(z10);
        sbW.append(", animation=");
        sbW.append(animationDefinition);
        sbW.append(")");
        return sbW.toString();
    }

    public EffectDefinition(String str, String str2, String str3, List list, BackendHint backendHint, boolean z10, AnimationDefinition animationDefinition, int i, e eVar) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? EmptyList.f4893a : list, (i & 16) != 0 ? BackendHint.AUTO : backendHint, (i & 32) != 0 ? false : z10, (i & 64) != 0 ? null : animationDefinition);
    }
}
