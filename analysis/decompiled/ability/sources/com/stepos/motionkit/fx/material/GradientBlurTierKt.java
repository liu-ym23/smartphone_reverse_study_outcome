package com.stepos.motionkit.fx.material;

import androidx.core.view.ViewCompat;
import com.stepos.motionkit.fx.material.capability.GradientBlurParams;
import g1.AbstractC1451a;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/motionkit/fx/material/capability/GradientBlurParams;", "Lcom/stepos/motionkit/fx/material/GradientBlurTier;", "tier", "LC7/r;", "preset", "(Lcom/stepos/motionkit/fx/material/capability/GradientBlurParams;Lcom/stepos/motionkit/fx/material/GradientBlurTier;)V", "", "rgb", "opacityPct", "argbPct", "(II)I", "motionkit-fx_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GradientBlurTierKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int argbPct(int i, int i6) {
        return (i & ViewCompat.MEASURED_SIZE_MASK) | ((((AbstractC1451a.u(i6, 0, 100) * 255) + 50) / 100) << 24);
    }

    public static final void preset(GradientBlurParams gradientBlurParams, GradientBlurTier tier) {
        k.f(gradientBlurParams, "<this>");
        k.f(tier, "tier");
        tier.applyTo(gradientBlurParams);
    }
}
