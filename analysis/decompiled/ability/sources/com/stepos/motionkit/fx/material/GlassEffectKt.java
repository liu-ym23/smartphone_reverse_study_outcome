package com.stepos.motionkit.fx.material;

import androidx.core.view.ViewCompat;
import g1.AbstractC1451a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002¨\u0006\u0004"}, d2 = {"argbPct", "", "rgb", "opacityPct", "motionkit-fx_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GlassEffectKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int argbPct(int i, int i6) {
        return (i & ViewCompat.MEASURED_SIZE_MASK) | ((((AbstractC1451a.u(i6, 0, 100) * 255) + 50) / 100) << 24);
    }
}
