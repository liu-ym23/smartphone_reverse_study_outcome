package com.stepos.motionkit.fx.material.capability;

import androidx.core.view.ViewCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.fx.material.MaterialParams;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/stepos/motionkit/fx/material/capability/BlurParams;", "Lcom/stepos/motionkit/fx/material/MaterialParams;", AppAgent.CONSTRUCT, "()V", "radius", "", "getRadius", "()F", "setRadius", "(F)V", "tintColor", "", "getTintColor", "()I", "setTintColor", "(I)V", "blendColor", "getBlendColor", "setBlendColor", "frost", "getFrost", "setFrost", "overlay", "", "getOverlay", "()Z", "setOverlay", "(Z)V", "useAospBlur", "getUseAospBlur", "setUseAospBlur", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public class BlurParams extends MaterialParams {
    private float frost;
    private boolean overlay;
    private float radius;
    private boolean useAospBlur;
    private int tintColor = ViewCompat.MEASURED_SIZE_MASK;
    private float blendColor = 0.1f;

    public final float getBlendColor() {
        return this.blendColor;
    }

    public final float getFrost() {
        return this.frost;
    }

    public final boolean getOverlay() {
        return this.overlay;
    }

    public final float getRadius() {
        return this.radius;
    }

    public final int getTintColor() {
        return this.tintColor;
    }

    public final boolean getUseAospBlur() {
        return this.useAospBlur;
    }

    public final void setBlendColor(float f) {
        this.blendColor = f;
    }

    public final void setFrost(float f) {
        this.frost = f;
    }

    public final void setOverlay(boolean z10) {
        this.overlay = z10;
    }

    public final void setRadius(float f) {
        this.radius = f;
    }

    public final void setTintColor(int i) {
        this.tintColor = i;
    }

    public final void setUseAospBlur(boolean z10) {
        this.useAospBlur = z10;
    }
}
