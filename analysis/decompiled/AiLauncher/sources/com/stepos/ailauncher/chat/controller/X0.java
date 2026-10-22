package com.stepos.ailauncher.chat.controller;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.list.SessionChatActivitySnapshot;
import com.stepos.agentframework.chatcore.session.list.SessionChatPhase;
import com.stepos.ailauncher.contract.model.search.SessionActivityState;
import com.stepos.ailauncher.contract.model.search.SidebarSession;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000(\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\u001a+\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0000*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\t\u001a7\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0013\u0010\u0012\u001a\u00020\u0006*\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"", "", "Lcom/stepos/agentframework/chatcore/session/list/a;", "Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/util/Map;)Ljava/util/Map;", "Lcom/stepos/ailauncher/contract/model/search/SidebarSession;", "", "e", "(Lcom/stepos/ailauncher/contract/model/search/SidebarSession;)Z", "sessionMissing", "hasUnread", "", "updatedAt", "readAt", "pageVisible", "f", "(ZZJJZ)Z", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/contract/model/search/SidebarSession;)Lcom/stepos/ailauncher/contract/model/search/SidebarSession;", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class X0 {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SessionChatPhase.values().length];
            try {
                iArr[SessionChatPhase.REPLYING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SessionChatPhase.WAITING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SessionChatPhase.REPLIED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SessionChatPhase.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final SidebarSession d(SidebarSession sidebarSession) {
        SessionActivityState activityState = sidebarSession.getActivityState();
        if (activityState == SessionActivityState.COMPLETED_UNREAD || activityState == SessionActivityState.FAILED || activityState == SessionActivityState.WAITING_FOR_USER) {
            activityState = null;
        }
        return sidebarSession.copy((1279 & 1) != 0 ? sidebarSession.sessionId : null, (1279 & 2) != 0 ? sidebarSession.agentId : null, (1279 & 4) != 0 ? sidebarSession.deviceId : null, (1279 & 8) != 0 ? sidebarSession.title : null, (1279 & 16) != 0 ? sidebarSession.agentLabel : null, (1279 & 32) != 0 ? sidebarSession.isExternalAgent : false, (1279 & 64) != 0 ? sidebarSession.createdAt : 0L, (1279 & 128) != 0 ? sidebarSession.updatedAt : 0L, (1279 & 256) != 0 ? sidebarSession.isRead : true, (1279 & 512) != 0 ? sidebarSession.sendFailed : false, (1279 & 1024) != 0 ? sidebarSession.sessionKind : null, (1279 & 2048) != 0 ? sidebarSession.activityState : activityState);
    }

    public static final boolean e(SidebarSession sidebarSession) {
        return sidebarSession.getSendFailed() || sidebarSession.getActivityState() == SessionActivityState.FAILED || sidebarSession.getActivityState() == SessionActivityState.WAITING_FOR_USER || sidebarSession.getActivityState() == SessionActivityState.COMPLETED_UNREAD || !sidebarSession.isRead();
    }

    public static final boolean f(boolean z10, boolean z11, long j10, long j11, boolean z12) {
        if (z10 || !z11) {
            return true;
        }
        return !z12 && j10 > j11;
    }

    public static final Map<String, SessionActivityState> g(Map<String, SessionChatActivitySnapshot> map) {
        SessionActivityState sessionActivityState;
        LinkedHashMap linkedHashMap = new LinkedHashMap(Z8.Q.e(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            int i10 = a.$EnumSwitchMapping$0[((SessionChatActivitySnapshot) entry.getValue()).getPhase().ordinal()];
            if (i10 == 1) {
                sessionActivityState = SessionActivityState.RUNNING;
            } else if (i10 == 2) {
                sessionActivityState = SessionActivityState.WAITING_FOR_USER;
            } else if (i10 == 3) {
                sessionActivityState = SessionActivityState.COMPLETED_UNREAD;
            } else {
                if (i10 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                sessionActivityState = SessionActivityState.FAILED;
            }
            linkedHashMap.put(key, sessionActivityState);
        }
        return linkedHashMap;
    }
}
