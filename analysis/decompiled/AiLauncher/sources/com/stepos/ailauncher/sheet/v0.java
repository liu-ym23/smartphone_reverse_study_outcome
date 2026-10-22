package com.stepos.ailauncher.sheet;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\u001a7\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", "stiffness", "dampingRatio", "startValue", "endValue", "startVelocity", "", Const.INTENT_KEY_APIKEY, "(FFFFF)J", "sheet_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class v0 {
    public static final long a(float f10, float f11, float f12, float f13, float f14) {
        double dAbs = Math.abs(0.75f) * 62.5d;
        long j10 = 0;
        if (Math.abs(f12 - f13) < 0.75f && Math.abs(f14) < dAbs) {
            return 0L;
        }
        w0 w0Var = new w0(f10, f11, f12, f13, f14);
        while (j10 < 10000) {
            j10 += 16;
            Pair<Float, Float> pairA = w0Var.a(j10);
            float fFloatValue = pairA.a().floatValue();
            float fFloatValue2 = pairA.b().floatValue();
            if (Math.abs(fFloatValue - f13) < 0.75f && Math.abs(fFloatValue2) < dAbs) {
                return j10;
            }
        }
        return 10000L;
    }

    public static /* synthetic */ long b(float f10, float f11, float f12, float f13, float f14, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            f14 = 0.0f;
        }
        return a(f10, f11, f12, f13, f14);
    }
}
