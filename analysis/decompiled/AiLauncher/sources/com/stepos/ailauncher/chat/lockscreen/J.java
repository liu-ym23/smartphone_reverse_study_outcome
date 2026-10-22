package com.stepos.ailauncher.chat.lockscreen;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\n\u001aI\u0010\b\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"", "incomingIsLockScreenEntry", "stillInLockScreenMode", "keyguardShowing", "alreadyRelaunched", "currentWasWake", "incomingIsWake", "hostFinishing", Const.INTENT_KEY_APIKEY, "(ZZZZZZZ)Z", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class J {
    public static final boolean a(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        if (!z10 || !z12 || z13) {
            return false;
        }
        if (z16 || !z11) {
            return true;
        }
        return z14 && !z15;
    }
}
