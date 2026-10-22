package com.stepos.ailauncher.chat.controller;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "isExternalAgent", "", "deviceId", "isInstalledAgent", "Lcom/stepos/ailauncher/chat/controller/TopBarNewSessionTarget;", Const.INTENT_KEY_APIKEY, "(ZLjava/lang/String;Z)Lcom/stepos/ailauncher/chat/controller/TopBarNewSessionTarget;", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class J0 {
    public static final TopBarNewSessionTarget a(boolean z10, String str, boolean z11) {
        return z11 ? TopBarNewSessionTarget.CURRENT_INSTALLED : (!z10 || str == null || La.H.x0(str)) ? TopBarNewSessionTarget.AMOO : TopBarNewSessionTarget.CURRENT_EXTERNAL;
    }
}
