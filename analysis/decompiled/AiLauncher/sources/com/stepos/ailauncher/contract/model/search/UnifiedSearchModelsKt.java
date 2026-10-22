package com.stepos.ailauncher.contract.model.search;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¨\u0006\u0006"}, d2 = {"overlayChatOnRunningTask", "Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;", "chatState", "conversationRead", "", "orInFlightChat", "contract_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UnifiedSearchModelsKt {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SessionActivityState.values().length];
            try {
                iArr[SessionActivityState.WAITING_FOR_USER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SessionActivityState.FAILED.ordinal()] = 2;
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

    public static final SessionActivityState orInFlightChat(SessionActivityState sessionActivityState, SessionActivityState sessionActivityState2) {
        if (sessionActivityState != null) {
            return sessionActivityState;
        }
        int i10 = sessionActivityState2 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[sessionActivityState2.ordinal()];
        if (i10 == 1 || i10 == 2 || i10 == 4) {
            return sessionActivityState2;
        }
        return null;
    }

    public static final SessionActivityState overlayChatOnRunningTask(SessionActivityState sessionActivityState, SessionActivityState sessionActivityState2, boolean z10) {
        if (sessionActivityState == SessionActivityState.RUNNING) {
            int i10 = sessionActivityState2 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[sessionActivityState2.ordinal()];
            if (i10 != 1 && i10 != 2) {
                if (i10 == 3) {
                    if (z10) {
                        return null;
                    }
                }
            }
            return sessionActivityState2;
        }
        return sessionActivityState;
    }

    public static /* synthetic */ SessionActivityState overlayChatOnRunningTask$default(SessionActivityState sessionActivityState, SessionActivityState sessionActivityState2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return overlayChatOnRunningTask(sessionActivityState, sessionActivityState2, z10);
    }
}
