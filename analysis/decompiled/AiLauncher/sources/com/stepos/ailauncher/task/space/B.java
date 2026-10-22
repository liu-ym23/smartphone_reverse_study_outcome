package com.stepos.ailauncher.task.space;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0007\n\u0002\b\b\u001a'\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0004\u001a\u001f\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0007¨\u0006\b"}, d2 = {"", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "t", "(FFF)F", "delta", "limit", "(FF)F", "task_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class B {
    public static final float a(float f10, float f11, float f12) {
        return f10 + ((f11 - f10) * f12);
    }

    public static final float b(float f10, float f11) {
        if (f11 <= 0.0f) {
            return 0.0f;
        }
        float fAbs = Math.abs(f10);
        return ((Math.signum(f10) * f11) * fAbs) / (f11 + fAbs);
    }
}
