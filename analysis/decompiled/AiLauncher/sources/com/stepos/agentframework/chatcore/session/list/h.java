package com.stepos.agentframework.chatcore.session.list;

import La.D;
import La.H;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"", "Lcom/stepos/agentframework/chatcore/session/list/g;", "Lcom/stepos/agentframework/chatcore/session/list/SessionAuthorizationState;", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)Lcom/stepos/agentframework/chatcore/session/list/SessionAuthorizationState;", "", "level", "Lcom/stepos/agentframework/chatcore/session/list/SessionPendingActionKind;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Lcom/stepos/agentframework/chatcore/session/list/SessionPendingActionKind;", "chatcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class h {
    public static final SessionAuthorizationState a(List<SessionPendingAction> list) {
        p.i(list, "<this>");
        List<SessionPendingAction> list2 = list;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                if (((SessionPendingAction) it.next()).getKind() == SessionPendingActionKind.MAIN_AGENT_HIGH_RISK_CONFIRMATION) {
                    return SessionAuthorizationState.HIGH_RISK_CONFIRMATION;
                }
            }
        }
        return !list.isEmpty() ? SessionAuthorizationState.REQUIRED : SessionAuthorizationState.NONE;
    }

    public static final SessionPendingActionKind b(String str) {
        String string;
        return (str == null || (string = H.D1(str).toString()) == null || !D.L(string, "high", true)) ? SessionPendingActionKind.MAIN_AGENT_AUTHORIZATION : SessionPendingActionKind.MAIN_AGENT_HIGH_RISK_CONFIRMATION;
    }
}
