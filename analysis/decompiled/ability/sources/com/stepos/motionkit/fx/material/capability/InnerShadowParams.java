package com.stepos.motionkit.fx.material.capability;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.fx.material.MaterialParams;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/stepos/motionkit/fx/material/capability/InnerShadowParams;", "Lcom/stepos/motionkit/fx/material/MaterialParams;", AppAgent.CONSTRUCT, "()V", "enabled", "", "getEnabled", "()Z", "setEnabled", "(Z)V", TypedValues.Custom.S_COLOR, "", "getColor", "()I", "setColor", "(I)V", "radius", "", "getRadius", "()F", "setRadius", "(F)V", "offsetX", "getOffsetX", "setOffsetX", "offsetY", "getOffsetY", "setOffsetY", "intensity", "getIntensity", "setIntensity", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InnerShadowParams extends MaterialParams {
    private float offsetX;
    private float offsetY;
    private boolean enabled = true;
    private int color = 1711276032;
    private float radius = 14.0f;
    private float intensity = 1.0f;

    public final int getColor() {
        return this.color;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final float getIntensity() {
        return this.intensity;
    }

    public final float getOffsetX() {
        return this.offsetX;
    }

    public final float getOffsetY() {
        return this.offsetY;
    }

    public final float getRadius() {
        return this.radius;
    }

    public final void setColor(int i) {
        this.color = i;
    }

    public final void setEnabled(boolean z10) {
        this.enabled = z10;
    }

    public final void setIntensity(float f) {
        this.intensity = f;
    }

    public final void setOffsetX(float f) {
        this.offsetX = f;
    }

    public final void setOffsetY(float f) {
        this.offsetY = f;
    }

    public final void setRadius(float f) {
        this.radius = f;
    }
}
