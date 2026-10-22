package com.stepos.agentframework.chatcore.session.list;

import La.H;
import Ua.C1056g;
import Ua.Y;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJF\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015RT\u0010\u0018\u001aB\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00060\u0006 \u0017* \u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00160\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/list/SessionPendingActionStore;", "", "<init>", "()V", "", "requestId", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Z", "sessionId", "agentId", "Lcom/stepos/agentframework/chatcore/session/list/SessionPendingActionKind;", "kind", "", "createdAt", "expiresAt", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/list/SessionPendingActionKind;JLjava/lang/Long;Le9/c;)Ljava/lang/Object;", "c", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "kotlin.jvm.PlatformType", "runtimeActiveRequestIds", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SessionPendingActionStore {
    private static final String TAG = "SessionPendingAction";
    public static final SessionPendingActionStore INSTANCE = new SessionPendingActionStore();
    private static final ConcurrentHashMap.KeySetView<String, Boolean> runtimeActiveRequestIds = ConcurrentHashMap.newKeySet();

    public final boolean a(String requestId) {
        p.i(requestId, "requestId");
        return runtimeActiveRequestIds.contains(H.D1(requestId).toString());
    }

    public final Object b(String str, String str2, String str3, SessionPendingActionKind sessionPendingActionKind, long j10, Long l10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C1056g.j(Y.b(), new SessionPendingActionStore$markPending$2(str, str2, str3, sessionPendingActionKind, j10, l10, null), interfaceC4014c);
    }

    public final Object c(String str, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C1056g.j(Y.b(), new SessionPendingActionStore$resolve$2(str, null), interfaceC4014c);
    }
}
