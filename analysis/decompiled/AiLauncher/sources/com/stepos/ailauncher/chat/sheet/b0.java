package com.stepos.ailauncher.chat.sheet;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\u001a9\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\u000b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001f\u0010\u000f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000f\u0010\f\u001a\u001f\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0000¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"", "occludedByThirdParty", "pendingBringFront", "settlingOpenDesktop", "topIsThirdParty", "landedOnDesktop", "c", "(ZZZZZ)Z", "panel1Present", "", "leftoverDesktopSheetCount", Const.INTENT_KEY_APIKEY, "(ZI)Z", "overlayOpen", "minusOneSheetCount", Const.INTENT_KEY_UMID, "resolvedId", "cachedId", Const.INTENT_KEY_PKGNAME, "(II)I", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b0 {
    public static final boolean a(boolean z10, int i10) {
        return !z10 && i10 > 0;
    }

    public static final int b(int i10, int i11) {
        if (i10 > 0) {
            return i10;
        }
        if (i11 > 0) {
            return i11;
        }
        return -1;
    }

    public static final boolean c(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        if (z13) {
            return true;
        }
        if (z14) {
            return false;
        }
        return z10 || z11 || z12;
    }

    public static final boolean d(boolean z10, int i10) {
        return z10 || i10 > 0;
    }
}
