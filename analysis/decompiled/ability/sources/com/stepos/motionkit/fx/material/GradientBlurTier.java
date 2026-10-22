package com.stepos.motionkit.fx.material;

import H4.o;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.fx.material.capability.BlurGradient;
import com.stepos.motionkit.fx.material.capability.GradientBlurParams;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0000\u0018\u0000 %2\u00020\u0001:\u0001%BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001e\u0010\u001dR\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010\u001b\u001a\u0004\b \u0010\u001dR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b$\u0010\u001a¨\u0006&"}, d2 = {"Lcom/stepos/motionkit/fx/material/GradientBlurTier;", "", "", "id", "Lcom/stepos/motionkit/fx/material/capability/BlurGradient;", "direction", "", "gradientScale", "startColor", "middleColor", "endColor", "", "colorMidpoint", "colorDirection", AppAgent.CONSTRUCT, "(Ljava/lang/String;Lcom/stepos/motionkit/fx/material/capability/BlurGradient;IIIIFLcom/stepos/motionkit/fx/material/capability/BlurGradient;)V", "Lcom/stepos/motionkit/fx/material/capability/GradientBlurParams;", "params", "LC7/r;", "applyTo", "(Lcom/stepos/motionkit/fx/material/capability/GradientBlurParams;)V", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "Lcom/stepos/motionkit/fx/material/capability/BlurGradient;", "getDirection", "()Lcom/stepos/motionkit/fx/material/capability/BlurGradient;", "I", "getGradientScale", "()I", "getStartColor", "getMiddleColor", "getEndColor", "F", "getColorMidpoint", "()F", "getColorDirection", "Companion", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GradientBlurTier {
    private static final GradientBlurTier BOTTOM_SHORT;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final GradientBlurTier TOP_SHORT;
    private static final GradientBlurTier TOP_TALL;
    private static final List<GradientBlurTier> all;
    private final BlurGradient colorDirection;
    private final float colorMidpoint;
    private final BlurGradient direction;
    private final int endColor;
    private final int gradientScale;
    private final String id;
    private final int middleColor;
    private final int startColor;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/stepos/motionkit/fx/material/GradientBlurTier$Companion;", "", AppAgent.CONSTRUCT, "()V", "TOP_SHORT", "Lcom/stepos/motionkit/fx/material/GradientBlurTier;", "getTOP_SHORT", "()Lcom/stepos/motionkit/fx/material/GradientBlurTier;", "BOTTOM_SHORT", "getBOTTOM_SHORT", "TOP_TALL", "getTOP_TALL", "all", "", "getAll", "()Ljava/util/List;", "nativeMode", "Lcom/stepos/motionkit/fx/material/capability/BlurGradient;", "mode", "", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final BlurGradient nativeMode(int mode) {
            for (BlurGradient blurGradient : BlurGradient.values()) {
                if (blurGradient.getMode() == mode) {
                    return blurGradient;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }

        public final List<GradientBlurTier> getAll() {
            return GradientBlurTier.all;
        }

        public final GradientBlurTier getBOTTOM_SHORT() {
            return GradientBlurTier.BOTTOM_SHORT;
        }

        public final GradientBlurTier getTOP_SHORT() {
            return GradientBlurTier.TOP_SHORT;
        }

        public final GradientBlurTier getTOP_TALL() {
            return GradientBlurTier.TOP_TALL;
        }

        private Companion() {
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        GradientBlurTier gradientBlurTier = new GradientBlurTier("top_short", companion.nativeMode(2), 0, GradientBlurTierKt.argbPct(1710618, 100), GradientBlurTierKt.argbPct(1710618, 60), GradientBlurTierKt.argbPct(1710618, 0), 0.5f, companion.nativeMode(1));
        TOP_SHORT = gradientBlurTier;
        GradientBlurTier gradientBlurTier2 = new GradientBlurTier("bottom_short", companion.nativeMode(1), 1, GradientBlurTierKt.argbPct(1710618, 0), GradientBlurTierKt.argbPct(1710618, 65), GradientBlurTierKt.argbPct(986895, 100), 0.43f, companion.nativeMode(1));
        BOTTOM_SHORT = gradientBlurTier2;
        GradientBlurTier gradientBlurTier3 = new GradientBlurTier("top_tall", companion.nativeMode(2), 0, GradientBlurTierKt.argbPct(0, 80), GradientBlurTierKt.argbPct(0, 60), GradientBlurTierKt.argbPct(0, 0), 0.57f, companion.nativeMode(1));
        TOP_TALL = gradientBlurTier3;
        all = o.N(gradientBlurTier, gradientBlurTier2, gradientBlurTier3);
    }

    public GradientBlurTier(String id, BlurGradient direction, int i, int i6, int i10, int i11, float f, BlurGradient colorDirection) {
        k.f(id, "id");
        k.f(direction, "direction");
        k.f(colorDirection, "colorDirection");
        this.id = id;
        this.direction = direction;
        this.gradientScale = i;
        this.startColor = i6;
        this.middleColor = i10;
        this.endColor = i11;
        this.colorMidpoint = f;
        this.colorDirection = colorDirection;
    }

    public final void applyTo(GradientBlurParams params) {
        k.f(params, "params");
        params.setDirection(this.direction);
        params.setGradientScale(this.gradientScale);
        params.setStartColor(this.startColor);
        params.setMiddleColor(this.middleColor);
        params.setEndColor(this.endColor);
        params.setColorMidpoint(this.colorMidpoint);
        params.setColorDirection(this.colorDirection);
    }

    public final BlurGradient getColorDirection() {
        return this.colorDirection;
    }

    public final float getColorMidpoint() {
        return this.colorMidpoint;
    }

    public final BlurGradient getDirection() {
        return this.direction;
    }

    public final int getEndColor() {
        return this.endColor;
    }

    public final int getGradientScale() {
        return this.gradientScale;
    }

    public final String getId() {
        return this.id;
    }

    public final int getMiddleColor() {
        return this.middleColor;
    }

    public final int getStartColor() {
        return this.startColor;
    }
}
