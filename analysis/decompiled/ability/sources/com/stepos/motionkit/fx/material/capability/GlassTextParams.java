package com.stepos.motionkit.fx.material.capability;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.fx.material.MaterialParams;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/stepos/motionkit/fx/material/capability/GlassTextParams;", "Lcom/stepos/motionkit/fx/material/MaterialParams;", AppAgent.CONSTRUCT, "()V", "sdfScale", "", "getSdfScale", "()F", "setSdfScale", "(F)V", "erode", "getErode", "setErode", "useTextMask", "", "getUseTextMask$motionkit_fx_release", "()Z", "setUseTextMask$motionkit_fx_release", "(Z)V", "hasBackdropBlur", "getHasBackdropBlur$motionkit_fx_release", "setHasBackdropBlur$motionkit_fx_release", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GlassTextParams extends MaterialParams {
    private float erode;
    private boolean hasBackdropBlur;
    private float sdfScale = 64.0f;
    private boolean useTextMask;

    public final float getErode() {
        return this.erode;
    }

    /* renamed from: getHasBackdropBlur$motionkit_fx_release, reason: from getter */
    public final boolean getHasBackdropBlur() {
        return this.hasBackdropBlur;
    }

    public final float getSdfScale() {
        return this.sdfScale;
    }

    /* renamed from: getUseTextMask$motionkit_fx_release, reason: from getter */
    public final boolean getUseTextMask() {
        return this.useTextMask;
    }

    public final void setErode(float f) {
        this.erode = f;
    }

    public final void setHasBackdropBlur$motionkit_fx_release(boolean z10) {
        this.hasBackdropBlur = z10;
    }

    public final void setSdfScale(float f) {
        this.sdfScale = f;
    }

    public final void setUseTextMask$motionkit_fx_release(boolean z10) {
        this.useTextMask = z10;
    }
}
