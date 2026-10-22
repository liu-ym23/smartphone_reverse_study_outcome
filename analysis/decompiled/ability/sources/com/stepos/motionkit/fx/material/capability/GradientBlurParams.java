package com.stepos.motionkit.fx.material.capability;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\t¨\u0006#"}, d2 = {"Lcom/stepos/motionkit/fx/material/capability/GradientBlurParams;", "Lcom/stepos/motionkit/fx/material/capability/BlurParams;", AppAgent.CONSTRUCT, "()V", "direction", "Lcom/stepos/motionkit/fx/material/capability/BlurGradient;", "getDirection", "()Lcom/stepos/motionkit/fx/material/capability/BlurGradient;", "setDirection", "(Lcom/stepos/motionkit/fx/material/capability/BlurGradient;)V", "gradientScale", "", "getGradientScale", "()I", "setGradientScale", "(I)V", "startColor", "getStartColor", "setStartColor", "middleColor", "getMiddleColor", "setMiddleColor", "endColor", "getEndColor", "setEndColor", "colorMidpoint", "", "getColorMidpoint", "()F", "setColorMidpoint", "(F)V", "colorDirection", "getColorDirection", "setColorDirection", "Companion", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GradientBlurParams extends BlurParams {
    public static final float DEFAULT_COLOR_MIDPOINT = 0.5f;
    public static final int DEFAULT_GRADIENT_SCALE = 0;
    public static final float DEFAULT_RADIUS = 40.0f;
    private BlurGradient colorDirection;
    private float colorMidpoint;
    private BlurGradient direction;
    private int endColor;
    private int gradientScale;
    private int middleColor;
    private int startColor;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final BlurGradient DEFAULT_DIRECTION = BlurGradient.BOTTOM_TO_TOP;
    private static final BlurGradient DEFAULT_COLOR_DIRECTION = BlurGradient.TOP_TO_BOTTOM;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stepos/motionkit/fx/material/capability/GradientBlurParams$Companion;", "", AppAgent.CONSTRUCT, "()V", "DEFAULT_RADIUS", "", "DEFAULT_DIRECTION", "Lcom/stepos/motionkit/fx/material/capability/BlurGradient;", "getDEFAULT_DIRECTION", "()Lcom/stepos/motionkit/fx/material/capability/BlurGradient;", "DEFAULT_COLOR_DIRECTION", "getDEFAULT_COLOR_DIRECTION", "DEFAULT_GRADIENT_SCALE", "", "DEFAULT_COLOR_MIDPOINT", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final BlurGradient getDEFAULT_COLOR_DIRECTION() {
            return GradientBlurParams.DEFAULT_COLOR_DIRECTION;
        }

        public final BlurGradient getDEFAULT_DIRECTION() {
            return GradientBlurParams.DEFAULT_DIRECTION;
        }

        private Companion() {
        }
    }

    public GradientBlurParams() {
        setRadius(40.0f);
        setBlendColor(0.0f);
        this.direction = DEFAULT_DIRECTION;
        this.colorMidpoint = 0.5f;
        this.colorDirection = DEFAULT_COLOR_DIRECTION;
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

    public final int getMiddleColor() {
        return this.middleColor;
    }

    public final int getStartColor() {
        return this.startColor;
    }

    public final void setColorDirection(BlurGradient blurGradient) {
        this.colorDirection = blurGradient;
    }

    public final void setColorMidpoint(float f) {
        this.colorMidpoint = f;
    }

    public final void setDirection(BlurGradient blurGradient) {
        k.f(blurGradient, "<set-?>");
        this.direction = blurGradient;
    }

    public final void setEndColor(int i) {
        this.endColor = i;
    }

    public final void setGradientScale(int i) {
        this.gradientScale = i;
    }

    public final void setMiddleColor(int i) {
        this.middleColor = i;
    }

    public final void setStartColor(int i) {
        this.startColor = i;
    }
}
