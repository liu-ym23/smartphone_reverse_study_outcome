package com.stepos.ailauncher.chat.adapter;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.model.search.SessionActivityState;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0006\u001a\u00020\u00052\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;", "activityState", "", "isSendFailed", "isConversationUnread", "Lcom/stepos/ailauncher/chat/adapter/SessionIndicatorState;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;ZZ)Lcom/stepos/ailauncher/chat/adapter/SessionIndicatorState;", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class G {
    public static final SessionIndicatorState a(SessionActivityState sessionActivityState, boolean z10, boolean z11) {
        if (z10) {
            return SessionIndicatorState.SEND_FAILED;
        }
        if (sessionActivityState == SessionActivityState.FAILED) {
            return SessionIndicatorState.FAILED;
        }
        SessionActivityState sessionActivityState2 = SessionActivityState.WAITING_FOR_USER;
        return (sessionActivityState == sessionActivityState2 && z11) ? SessionIndicatorState.WAITING_FOR_USER : sessionActivityState == sessionActivityState2 ? SessionIndicatorState.NONE : sessionActivityState == SessionActivityState.RUNNING ? SessionIndicatorState.RUNNING : (sessionActivityState == SessionActivityState.COMPLETED_UNREAD || z11) ? SessionIndicatorState.COMPLETED_UNREAD : SessionIndicatorState.NONE;
    }
}
