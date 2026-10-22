package com.stepos.ailauncher.sheet;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0015\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007\u001a7\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000¢\u0006\u0004\b\u000e\u0010\u000f\"\u0014\u0010\u0010\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"", "resumed", Const.INTENT_KEY_PKGNAME, "(Z)Z", "c", "", Const.INTENT_KEY_APIKEY, "()F", "notFocusable", "notTouchable", "keepUntouchable", "maskPassthrough", "finishing", "Lcom/stepos/ailauncher/sheet/x0;", Const.INTENT_KEY_UMID, "(ZZZZZ)Lcom/stepos/ailauncher/sheet/x0;", "PEEK_STAY_MAPPED_WINDOW_ALPHA", "F", "sheet_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class V {
    public static final float PEEK_STAY_MAPPED_WINDOW_ALPHA = 0.003921569f;

    public static final float a() {
        return 0.003921569f;
    }

    public static final boolean b(boolean z10) {
        return !z10;
    }

    public static final boolean c(boolean z10) {
        return !z10;
    }

    public static final WindowFocusRestoreAction d(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        if (z14) {
            return null;
        }
        boolean z15 = false;
        boolean z16 = z11 && !z12;
        if (!z10 && !z16) {
            return null;
        }
        if (z16 && !z13) {
            z15 = true;
        }
        return new WindowFocusRestoreAction(z10, z16, z15);
    }
}
