package com.stepos.motionkit.fx.material.capability;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.fx.material.MaterialParams;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/stepos/motionkit/fx/material/capability/RefractionParams;", "Lcom/stepos/motionkit/fx/material/MaterialParams;", AppAgent.CONSTRUCT, "()V", "enabled", "", "getEnabled", "()Z", "setEnabled", "(Z)V", "strength", "", "getStrength", "()F", "setStrength", "(F)V", "width", "getWidth", "setWidth", "dispersion", "getDispersion", "setDispersion", "depthEffect", "getDepthEffect", "setDepthEffect", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RefractionParams extends MaterialParams {
    private float dispersion;
    private boolean enabled = true;
    private float strength = 20.0f;
    private float width = 40.0f;
    private float depthEffect = 0.4f;

    public final float getDepthEffect() {
        return this.depthEffect;
    }

    public final float getDispersion() {
        return this.dispersion;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final float getStrength() {
        return this.strength;
    }

    public final float getWidth() {
        return this.width;
    }

    public final void setDepthEffect(float f) {
        this.depthEffect = f;
    }

    public final void setDispersion(float f) {
        this.dispersion = f;
    }

    public final void setEnabled(boolean z10) {
        this.enabled = z10;
    }

    public final void setStrength(float f) {
        this.strength = f;
    }

    public final void setWidth(float f) {
        this.width = f;
    }
}
