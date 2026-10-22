package com.stepos.motionkit.fx.material.capability;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"colorGradMode", "", "Lcom/stepos/motionkit/fx/material/capability/GradientBlurParams;", "motionkit-fx_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BlurCapabilityKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int colorGradMode(GradientBlurParams gradientBlurParams) {
        if ((gradientBlurParams.getStartColor() >>> 24) == 0 && (gradientBlurParams.getMiddleColor() >>> 24) == 0 && (gradientBlurParams.getEndColor() >>> 24) == 0) {
            return 0;
        }
        BlurGradient colorDirection = gradientBlurParams.getColorDirection();
        if (colorDirection == null) {
            colorDirection = gradientBlurParams.getDirection();
        }
        return colorDirection.getMode();
    }
}
