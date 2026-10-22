package com.stepos.ailauncher.taskstore.livenotification;

import Z8.C1173v;
import Z8.C1174w;
import android.app.Application;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.ConversationSessionIds;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.contract.api.livenotification.IRiskLiveNotificationService;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0005\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JM\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J1\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u001e\"\u00020\u0004H\u0016¢\u0006\u0004\b \u0010!J\u001b\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040#0\"H\u0016¢\u0006\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/stepos/ailauncher/taskstore/livenotification/p;", "Lcom/stepos/ailauncher/contract/api/livenotification/IRiskLiveNotificationService;", "<init>", "()V", "", "sessionId", "requestId", "title", "body", "riskLevel", "", "Lcom/stepos/ailauncher/contract/api/livenotification/RiskLiveButton;", "buttons", "", "timeoutMs", "", "showSessionRiskCard", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;J)Z", "forHandoff", "skipAfterglow", "LY8/t;", "dismissSessionRiskCard", "(Ljava/lang/String;ZLjava/lang/String;Z)V", "markRiskAlreadySeen", "(Ljava/lang/String;)V", "fallback", "setRiskIslandFallback", "(Ljava/lang/String;Z)V", "sessionTasksAllTerminal", "(Ljava/lang/String;)Z", "", "sessionIds", "pendingRiskRequestIds", "([Ljava/lang/String;)Ljava/util/List;", "LXa/t;", "", "pendingRiskSessions", "()LXa/t;", "Companion", Const.INTENT_KEY_APIKEY, "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.livenotification.p, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3728p implements IRiskLiveNotificationService {
    private static final a Companion = new a(null);

    @Deprecated
    public static final long DEFAULT_TIMEOUT_MS = 600000;

    @Deprecated
    public static final String TAG = "RiskLiveNotifService";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/taskstore/livenotification/p$a;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "", "DEFAULT_TIMEOUT_MS", "J", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.livenotification.p$a */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    @Override // com.stepos.ailauncher.contract.api.livenotification.IRiskLiveNotificationService
    public void dismissSessionRiskCard(String sessionId, boolean forHandoff, String requestId, boolean skipAfterglow) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (La.H.x0(sessionId)) {
            return;
        }
        String strM = ConversationSessionIds.INSTANCE.m(sessionId);
        Application applicationA = C3197a.INSTANCE.a();
        if (skipAfterglow) {
            C4148a.k(TAG, "dismissSessionRiskCard | sessionId=" + strM + " skipAfterglow=true → drop now", false, 4, null);
            TaskLiveNotificationDispatcher.INSTANCE.Z(applicationA, strM, sessionId, requestId);
            return;
        }
        if (forHandoff) {
            if (x.INSTANCE.b(new String[]{sessionId, strM}, requestId)) {
                C4148a.k(TAG, "dismissSessionRiskCard | sessionId=" + strM + " forHandoff=true keep store", false, 4, null);
                TaskLiveNotificationDispatcher.INSTANCE.z0(applicationA, strM);
                return;
            }
            C4148a.d(TAG, "dismissSessionRiskCard(handoff): nothing pending sessionId=" + sessionId + " requestId=" + requestId, false, 4, null);
            return;
        }
        if (x.INSTANCE.b(new String[]{sessionId, strM}, requestId)) {
            C4148a.k(TAG, "dismissSessionRiskCard | sessionId=" + strM + " forHandoff=false → deferred transition", false, 4, null);
            TaskLiveNotificationDispatcher.INSTANCE.A0(applicationA, strM, sessionId, requestId);
            return;
        }
        C4148a.d(TAG, "dismissSessionRiskCard: nothing pending sessionId=" + sessionId + " requestId=" + requestId, false, 4, null);
    }

    @Override // com.stepos.ailauncher.contract.api.livenotification.IRiskLiveNotificationService
    public void markRiskAlreadySeen(String requestId) {
        kotlin.jvm.internal.p.i(requestId, "requestId");
        if (La.H.x0(requestId)) {
            return;
        }
        x xVar = x.INSTANCE;
        boolean zE = xVar.e(requestId);
        xVar.h(requestId);
        if (zE) {
            return;
        }
        C4148a.k(TAG, "markRiskAlreadySeen | req=" + requestId + " (exposed, later island capsule only)", false, 4, null);
    }

    @Override // com.stepos.ailauncher.contract.api.livenotification.IRiskLiveNotificationService
    public List<String> pendingRiskRequestIds(String... sessionIds) {
        kotlin.jvm.internal.p.i(sessionIds, "sessionIds");
        if (sessionIds.length == 0) {
            return C1173v.m();
        }
        ArrayList arrayList = new ArrayList();
        for (String str : sessionIds) {
            Z8.A.E(arrayList, C1173v.p(str, ConversationSessionIds.INSTANCE.m(str)));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!La.H.x0((String) obj)) {
                arrayList2.add(obj);
            }
        }
        Set setR1 = Z8.F.r1(arrayList2);
        Map mapQ = x.q(x.INSTANCE, 0L, 1, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapQ.entrySet()) {
            if (setR1.contains((String) entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Collection collectionValues = linkedHashMap.values();
        ArrayList arrayList3 = new ArrayList(C1174w.x(collectionValues, 10));
        Iterator it = collectionValues.iterator();
        while (it.hasNext()) {
            arrayList3.add(((PendingRisk) it.next()).getRequestId());
        }
        return Z8.F.g0(arrayList3);
    }

    @Override // com.stepos.ailauncher.contract.api.livenotification.IRiskLiveNotificationService
    public Xa.t<Set<String>> pendingRiskSessions() {
        return x.INSTANCE.d();
    }

    @Override // com.stepos.ailauncher.contract.api.livenotification.IRiskLiveNotificationService
    public boolean sessionTasksAllTerminal(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        return TaskLiveNotificationDispatcher.INSTANCE.a1(sessionId);
    }

    @Override // com.stepos.ailauncher.contract.api.livenotification.IRiskLiveNotificationService
    public void setRiskIslandFallback(String requestId, boolean fallback) {
        String str;
        kotlin.jvm.internal.p.i(requestId, "requestId");
        if (La.H.x0(requestId)) {
            return;
        }
        x xVar = x.INSTANCE;
        boolean zF = xVar.f(requestId);
        xVar.o(requestId, fallback);
        if (zF == fallback) {
            return;
        }
        Object obj = null;
        C4148a.k(TAG, "setRiskIslandFallback | req=" + requestId + " fallback=" + fallback, false, 4, null);
        Iterator it = x.q(xVar, 0L, 1, null).entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (kotlin.jvm.internal.p.d(((PendingRisk) ((Map.Entry) next).getValue()).getRequestId(), requestId)) {
                obj = next;
                break;
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry == null || (str = (String) entry.getKey()) == null) {
            return;
        }
        TaskLiveNotificationDispatcher.INSTANCE.z0(C3197a.INSTANCE.a(), str);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x01b2  */
    @Override // com.stepos.ailauncher.contract.api.livenotification.IRiskLiveNotificationService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean showSessionRiskCard(java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.util.List<com.stepos.ailauncher.contract.api.livenotification.RiskLiveButton> r31, long r32) {
        /*
            Method dump skipped, instructions count: 522
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.livenotification.C3728p.showSessionRiskCard(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, long):boolean");
    }
}
