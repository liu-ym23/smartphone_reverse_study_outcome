package com.stepos.motionkit.fx.material;

import android.content.Context;
import android.view.View;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.fx.material.GradientBlurTier;
import com.stepos.motionkit.fx.material.Materials;
import com.stepos.motionkit.fx.material.capability.BlendCapability;
import com.stepos.motionkit.fx.material.capability.BlendParams;
import com.stepos.motionkit.fx.material.capability.BlurCapability;
import com.stepos.motionkit.fx.material.capability.BlurParams;
import com.stepos.motionkit.fx.material.capability.GlassTextCapability;
import com.stepos.motionkit.fx.material.capability.GlassTextParams;
import com.stepos.motionkit.fx.material.capability.GradientBlurCapability;
import com.stepos.motionkit.fx.material.capability.GradientBlurParams;
import com.stepos.motionkit.fx.material.capability.InnerShadowCapability;
import com.stepos.motionkit.fx.material.capability.InnerShadowParams;
import com.stepos.motionkit.fx.material.capability.RefractionCapability;
import com.stepos.motionkit.fx.material.capability.RefractionParams;
import com.stepos.motionkit.fx.material.capability.StrokeCapability;
import com.stepos.motionkit.fx.material.capability.StrokeParams;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/stepos/motionkit/fx/material/Materials;", "", AppAgent.CONSTRUCT, "()V", "Blur", "Lcom/stepos/motionkit/fx/material/MaterialCapability;", "Lcom/stepos/motionkit/fx/material/capability/BlurParams;", "getBlur", "()Lcom/stepos/motionkit/fx/material/MaterialCapability;", "Stroke", "Lcom/stepos/motionkit/fx/material/capability/StrokeParams;", "getStroke", "InnerShadow", "Lcom/stepos/motionkit/fx/material/capability/InnerShadowParams;", "getInnerShadow", "Refraction", "Lcom/stepos/motionkit/fx/material/capability/RefractionParams;", "getRefraction", "Blend", "Lcom/stepos/motionkit/fx/material/capability/BlendParams;", "getBlend", "GlassText", "Lcom/stepos/motionkit/fx/material/capability/GlassTextParams;", "getGlassText$motionkit_fx_release", "GradientBlur", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Materials {
    public static final Materials INSTANCE = new Materials();
    private static final MaterialCapability<BlurParams> Blur = new BlurCapability();
    private static final MaterialCapability<StrokeParams> Stroke = new StrokeCapability();
    private static final MaterialCapability<InnerShadowParams> InnerShadow = new InnerShadowCapability();
    private static final MaterialCapability<RefractionParams> Refraction = new RefractionCapability();
    private static final MaterialCapability<BlendParams> Blend = new BlendCapability();
    private static final MaterialCapability<GlassTextParams> GlassText = new GlassTextCapability();

    @Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u001d\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\u0015\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002¢\u0006\u0002\u0010 R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017¨\u0006!"}, d2 = {"Lcom/stepos/motionkit/fx/material/Materials$GradientBlur;", "Lcom/stepos/motionkit/fx/material/MaterialCapability;", "Lcom/stepos/motionkit/fx/material/capability/GradientBlurParams;", AppAgent.CONSTRUCT, "()V", "impl", "Lcom/stepos/motionkit/fx/material/capability/GradientBlurCapability;", "id", "", "getId", "()Ljava/lang/String;", "defaultParams", "isSupported", "", "context", "Landroid/content/Context;", "bind", "Lcom/stepos/motionkit/fx/material/MaterialBinding;", "view", "Landroid/view/View;", "params", "TOP_SHORT", "getTOP_SHORT", "()Lcom/stepos/motionkit/fx/material/MaterialCapability;", "BOTTOM_SHORT", "getBOTTOM_SHORT", "TOP_TALL", "getTOP_TALL", "withTier", "com/stepos/motionkit/fx/material/Materials$GradientBlur$withTier$1", "tier", "Lcom/stepos/motionkit/fx/material/GradientBlurTier;", "(Lcom/stepos/motionkit/fx/material/GradientBlurTier;)Lcom/stepos/motionkit/fx/material/Materials$GradientBlur$withTier$1;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class GradientBlur implements MaterialCapability<GradientBlurParams> {
        private static final MaterialCapability<GradientBlurParams> BOTTOM_SHORT;
        public static final GradientBlur INSTANCE;
        private static final MaterialCapability<GradientBlurParams> TOP_SHORT;
        private static final MaterialCapability<GradientBlurParams> TOP_TALL;
        private static final GradientBlurCapability impl;

        static {
            GradientBlur gradientBlur = new GradientBlur();
            INSTANCE = gradientBlur;
            impl = new GradientBlurCapability();
            GradientBlurTier.Companion companion = GradientBlurTier.INSTANCE;
            TOP_SHORT = gradientBlur.withTier(companion.getTOP_SHORT());
            BOTTOM_SHORT = gradientBlur.withTier(companion.getBOTTOM_SHORT());
            TOP_TALL = gradientBlur.withTier(companion.getTOP_TALL());
        }

        private GradientBlur() {
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [com.stepos.motionkit.fx.material.Materials$GradientBlur$withTier$1] */
        private final Materials$GradientBlur$withTier$1 withTier(final GradientBlurTier tier) {
            return new MaterialCapability<GradientBlurParams>() { // from class: com.stepos.motionkit.fx.material.Materials$GradientBlur$withTier$1
                @Override // com.stepos.motionkit.fx.material.MaterialCapability
                public String getId() {
                    return Materials.GradientBlur.impl.getId();
                }

                @Override // com.stepos.motionkit.fx.material.MaterialCapability
                public boolean isSupported(Context context) {
                    k.f(context, "context");
                    return Materials.GradientBlur.impl.isSupported(context);
                }

                @Override // com.stepos.motionkit.fx.material.MaterialCapability
                public MaterialBinding bind(View view, GradientBlurParams params) {
                    k.f(view, "view");
                    k.f(params, "params");
                    return Materials.GradientBlur.impl.bind(view, params);
                }

                @Override // com.stepos.motionkit.fx.material.MaterialCapability
                public GradientBlurParams defaultParams() {
                    GradientBlurParams gradientBlurParams = new GradientBlurParams();
                    GradientBlurTierKt.preset(gradientBlurParams, tier);
                    return gradientBlurParams;
                }
            };
        }

        public final MaterialCapability<GradientBlurParams> getBOTTOM_SHORT() {
            return BOTTOM_SHORT;
        }

        @Override // com.stepos.motionkit.fx.material.MaterialCapability
        public String getId() {
            return impl.getId();
        }

        public final MaterialCapability<GradientBlurParams> getTOP_SHORT() {
            return TOP_SHORT;
        }

        public final MaterialCapability<GradientBlurParams> getTOP_TALL() {
            return TOP_TALL;
        }

        @Override // com.stepos.motionkit.fx.material.MaterialCapability
        public boolean isSupported(Context context) {
            k.f(context, "context");
            return impl.isSupported(context);
        }

        @Override // com.stepos.motionkit.fx.material.MaterialCapability
        public MaterialBinding bind(View view, GradientBlurParams params) {
            k.f(view, "view");
            k.f(params, "params");
            return impl.bind(view, params);
        }

        @Override // com.stepos.motionkit.fx.material.MaterialCapability
        public GradientBlurParams defaultParams() {
            return impl.defaultParams();
        }
    }

    private Materials() {
    }

    public final MaterialCapability<BlendParams> getBlend() {
        return Blend;
    }

    public final MaterialCapability<BlurParams> getBlur() {
        return Blur;
    }

    public final MaterialCapability<GlassTextParams> getGlassText$motionkit_fx_release() {
        return GlassText;
    }

    public final MaterialCapability<InnerShadowParams> getInnerShadow() {
        return InnerShadow;
    }

    public final MaterialCapability<RefractionParams> getRefraction() {
        return Refraction;
    }

    public final MaterialCapability<StrokeParams> getStroke() {
        return Stroke;
    }
}
