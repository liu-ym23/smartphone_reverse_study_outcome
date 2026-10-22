package com.stepos.motionkit.fx.material.capability;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¨\u0006\u0004"}, d2 = {"refractStrengthPx", "", "v", "refractWidthPx", "motionkit-fx_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RefractionCapabilityKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final float refractStrengthPx(float f) {
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float refractWidthPx(float f) {
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }
}
