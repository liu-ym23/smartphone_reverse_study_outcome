package com.stepos.ailauncher.chat.lockscreen;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a=\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", "keyguardShowing", "deviceLocked", "isInternal", "skipKeyguardRoute", "fromLockScreenWake", "Lcom/stepos/ailauncher/chat/lockscreen/ChatMainLockRoute;", Const.INTENT_KEY_APIKEY, "(ZZZZZ)Lcom/stepos/ailauncher/chat/lockscreen/ChatMainLockRoute;", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class D {
    public static final ChatMainLockRoute a(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        return (z12 && z13) ? ChatMainLockRoute.CONTINUE : (z12 && z14 && z10) ? ChatMainLockRoute.LOCKED_FULL_CHAT : (z10 || z11) ? ChatMainLockRoute.REDIRECT_TO_LOCK_SCREEN_CHAT : ChatMainLockRoute.CONTINUE;
    }
}
