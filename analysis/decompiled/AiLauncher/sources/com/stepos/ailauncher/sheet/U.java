package com.stepos.ailauncher.sheet;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a%\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "visibleHeightPx", "endHeightPx", "remainingOffsetPx", "", Const.INTENT_KEY_APIKEY, "(FFF)Z", "sheet_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class U {
    public static final boolean a(float f10, float f11, float f12) {
        if (f11 <= 0.0f || f10 < 0.0f) {
            return false;
        }
        float f13 = f11 * 4.0f;
        return f10 <= f13 && Math.abs(f12) <= f13;
    }
}
