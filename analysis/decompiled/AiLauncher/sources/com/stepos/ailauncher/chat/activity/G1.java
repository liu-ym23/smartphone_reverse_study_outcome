package com.stepos.ailauncher.chat.activity;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/G1;", "", "<init>", "()V", "", "showRequested", "lockScreenMode", "absorbHoldListen", "circleSelectActive", "minifyListening", "allowExpandedHomeChatInteraction", Const.INTENT_KEY_APIKEY, "(ZZZZZZ)Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class G1 {
    public static final G1 INSTANCE = new G1();

    public final boolean a(boolean showRequested, boolean lockScreenMode, boolean absorbHoldListen, boolean circleSelectActive, boolean minifyListening, boolean allowExpandedHomeChatInteraction) {
        if (circleSelectActive || !showRequested) {
            return false;
        }
        if (lockScreenMode || !allowExpandedHomeChatInteraction) {
            return lockScreenMode || absorbHoldListen || minifyListening;
        }
        return false;
    }
}
