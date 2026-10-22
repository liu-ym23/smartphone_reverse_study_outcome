package com.stepos.ailauncher.chat.view;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "menuShowing", "anchorAvailable", "Lcom/stepos/ailauncher/chat/view/AttachMenuClickRoute;", Const.INTENT_KEY_APIKEY, "(ZZ)Lcom/stepos/ailauncher/chat/view/AttachMenuClickRoute;", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class W2 {
    public static final AttachMenuClickRoute a(boolean z10, boolean z11) {
        return (z10 || !z11) ? AttachMenuClickRoute.DISMISS : AttachMenuClickRoute.SHOW;
    }
}
