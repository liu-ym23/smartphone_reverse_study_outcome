package com.stepos.ailauncher.chat.sheet;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a1\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001f\u0010\t\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"", "overlayOpen", "", "minusOneSheetCount", "launcherInForeground", "embeddedTookOver", "", Const.INTENT_KEY_APIKEY, "(ZIZZ)Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "(ZI)Z", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class g0 {
    public static final String a(boolean z10, int i10, boolean z11, boolean z12) {
        if (z12) {
            return "home_embedded";
        }
        if ((z10 || i10 > 0) && z11 && i10 > 0) {
            return "minus_one_covered_cold";
        }
        return null;
    }

    public static final boolean b(boolean z10, int i10) {
        return z10 || i10 > 0;
    }
}
