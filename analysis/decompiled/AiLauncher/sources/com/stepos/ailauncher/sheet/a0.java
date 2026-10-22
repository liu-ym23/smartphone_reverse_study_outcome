package com.stepos.ailauncher.sheet;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\u001a\u0015\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a-\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\n\u001a\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"", "shapeDurationMs", Const.INTENT_KEY_APIKEY, "(J)J", "", "startBottom", "screenBottom", "gapPx", "progress", "c", "(FFFF)F", Const.INTENT_KEY_PKGNAME, "(F)F", "sheet_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a0 {
    public static final long a(long j10) {
        return C5685n.g(j10, 1L);
    }

    public static final float b(float f10) {
        return C5685n.m(1.0f - (f10 / 0.7f), 0.0f, 1.0f);
    }

    public static final float c(float f10, float f11, float f12, float f13) {
        float fE = f11 - C5685n.e(f12, 0.0f);
        float fMax = Math.max(f10, fE);
        float fM = C5685n.m(f13, 0.0f, 1.0f);
        return fMax + ((fE - fMax) * fM * fM * (3.0f - (fM * 2.0f)));
    }
}
