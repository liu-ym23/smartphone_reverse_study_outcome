package com.stepos.motionkit.fx.material;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/motionkit/fx/material/MaterialParams;", "", AppAgent.CONSTRUCT, "()V", "value", "", "crossWindow", "getCrossWindow", "()Z", "setCrossWindow$motionkit_fx_release", "(Z)V", "", "cornerRadius", "getCornerRadius", "()F", "setCornerRadius$motionkit_fx_release", "(F)V", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class MaterialParams {
    private float cornerRadius;
    private boolean crossWindow;

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final boolean getCrossWindow() {
        return this.crossWindow;
    }

    public final void setCornerRadius$motionkit_fx_release(float f) {
        this.cornerRadius = f;
    }

    public final void setCrossWindow$motionkit_fx_release(boolean z10) {
        this.crossWindow = z10;
    }
}
