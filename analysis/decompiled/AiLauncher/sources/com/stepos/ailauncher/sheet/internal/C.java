package com.stepos.ailauncher.sheet.internal;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\fR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0016\u0010\u000e\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/sheet/internal/C;", "", "", "start", "target", "<init>", "(FF)V", UxipConstants.f30680s, "velocity", "", Const.INTENT_KEY_APIKEY, "(FF)Z", "F", "direction", "overshot", "Z", "dispatched", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class C {
    private final float direction;
    private boolean dispatched;
    private boolean overshot;
    private final float target;

    public C(float f10, float f11) {
        this.target = f11;
        this.direction = Math.signum(f11 - f10);
    }

    public final boolean a(float value, float velocity) {
        if (!this.dispatched) {
            float f10 = this.direction;
            if (f10 != 0.0f) {
                if ((value - this.target) * f10 > 0.0f) {
                    this.overshot = true;
                }
                if (this.overshot && velocity * f10 < 0.0f) {
                    this.dispatched = true;
                    return true;
                }
            }
        }
        return false;
    }
}
