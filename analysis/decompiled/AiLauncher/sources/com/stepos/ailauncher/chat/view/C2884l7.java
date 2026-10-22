package com.stepos.ailauncher.chat.view;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0002\u001a\u00020\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a%\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\n\"\u0014\u0010\u000b\u001a\u00020\u00008\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\f\"\u0014\u0010\r\u001a\u00020\u00008\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"", "raw", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Long;)J", "graceWindowMs", "", "popupShowing", "manualPressActive", "Lcom/stepos/ailauncher/chat/view/PressToTalkReleaseAction;", Const.INTENT_KEY_PKGNAME, "(JZZ)Lcom/stepos/ailauncher/chat/view/PressToTalkReleaseAction;", "DEFAULT_RELEASE_GRACE_WINDOW_MS", "J", "MAX_RELEASE_GRACE_WINDOW_MS", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.l7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2884l7 {
    public static final long DEFAULT_RELEASE_GRACE_WINDOW_MS = 300;
    public static final long MAX_RELEASE_GRACE_WINDOW_MS = 1000;

    public static final long a(Long l10) {
        return C5685n.o(l10 != null ? l10.longValue() : 300L, 0L, 1000L);
    }

    public static final PressToTalkReleaseAction b(long j10, boolean z10, boolean z11) {
        if (j10 > 0 && z10 && z11) {
            return PressToTalkReleaseAction.ENTER_GRACE;
        }
        return PressToTalkReleaseAction.FINALIZE_NOW;
    }
}
