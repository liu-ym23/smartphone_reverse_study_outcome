package com.stepos.ailauncher.chat.adapter;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.model.search.SessionActivityState;
import com.stepos.ailauncher.contract.model.search.UnifiedSearchModelsKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a9\u0010\u0006\u001a\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;", "storedState", "", "isFrameworkActive", "chatState", "conversationRead", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;ZLcom/stepos/ailauncher/contract/model/search/SessionActivityState;Z)Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class N {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SessionActivityState.values().length];
            try {
                iArr[SessionActivityState.FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SessionActivityState.WAITING_FOR_USER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SessionActivityState.COMPLETED_UNREAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SessionActivityState.RUNNING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final SessionActivityState a(SessionActivityState sessionActivityState, boolean z10, SessionActivityState sessionActivityState2, boolean z11) {
        SessionActivityState sessionActivityStateOverlayChatOnRunningTask = UnifiedSearchModelsKt.overlayChatOnRunningTask(sessionActivityState, sessionActivityState2, z11);
        if (sessionActivityStateOverlayChatOnRunningTask == null && sessionActivityState2 == SessionActivityState.RUNNING && z11 && !z10) {
            return null;
        }
        SessionActivityState sessionActivityStateOrInFlightChat = UnifiedSearchModelsKt.orInFlightChat(sessionActivityStateOverlayChatOnRunningTask, sessionActivityState2);
        int i10 = sessionActivityStateOrInFlightChat == null ? -1 : a.$EnumSwitchMapping$0[sessionActivityStateOrInFlightChat.ordinal()];
        if (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4) {
            return sessionActivityStateOrInFlightChat;
        }
        SessionActivityState sessionActivityState3 = SessionActivityState.RUNNING;
        if (z10) {
            return sessionActivityState3;
        }
        return null;
    }

    public static /* synthetic */ SessionActivityState b(SessionActivityState sessionActivityState, boolean z10, SessionActivityState sessionActivityState2, boolean z11, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            sessionActivityState2 = null;
        }
        if ((i10 & 8) != 0) {
            z11 = false;
        }
        return a(sessionActivityState, z10, sessionActivityState2, z11);
    }
}
