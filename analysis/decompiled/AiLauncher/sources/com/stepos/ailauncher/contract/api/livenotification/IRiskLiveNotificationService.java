package com.stepos.ailauncher.contract.api.livenotification;

import Xa.t;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JO\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\r2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0011\u001a\u00020\rH&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u001a\u0010\u001bJ)\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0012\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u001c\"\u00020\u0002H&¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020!0 H&¢\u0006\u0004\b\"\u0010#¨\u0006$À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/contract/api/livenotification/IRiskLiveNotificationService;", "", "", "sessionId", "requestId", "title", "body", "riskLevel", "", "Lcom/stepos/ailauncher/contract/api/livenotification/RiskLiveButton;", "buttons", "", "timeoutMs", "", "showSessionRiskCard", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;J)Z", "forHandoff", "skipAfterglow", "LY8/t;", "dismissSessionRiskCard", "(Ljava/lang/String;ZLjava/lang/String;Z)V", "markRiskAlreadySeen", "(Ljava/lang/String;)V", "fallback", "setRiskIslandFallback", "(Ljava/lang/String;Z)V", "sessionTasksAllTerminal", "(Ljava/lang/String;)Z", "", "sessionIds", "pendingRiskRequestIds", "([Ljava/lang/String;)Ljava/util/List;", "LXa/t;", "", "pendingRiskSessions", "()LXa/t;", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IRiskLiveNotificationService {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void setRiskIslandFallback(IRiskLiveNotificationService iRiskLiveNotificationService, String requestId, boolean z10) {
            p.i(requestId, "requestId");
            IRiskLiveNotificationService.super.setRiskIslandFallback(requestId, z10);
        }
    }

    static /* synthetic */ void dismissSessionRiskCard$default(IRiskLiveNotificationService iRiskLiveNotificationService, String str, boolean z10, String str2, boolean z11, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dismissSessionRiskCard");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            str2 = null;
        }
        if ((i10 & 8) != 0) {
            z11 = false;
        }
        iRiskLiveNotificationService.dismissSessionRiskCard(str, z10, str2, z11);
    }

    static /* synthetic */ boolean showSessionRiskCard$default(IRiskLiveNotificationService iRiskLiveNotificationService, String str, String str2, String str3, String str4, String str5, List list, long j10, int i10, Object obj) {
        if (obj == null) {
            return iRiskLiveNotificationService.showSessionRiskCard(str, str2, str3, str4, str5, list, (i10 & 64) != 0 ? 0L : j10);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showSessionRiskCard");
    }

    void dismissSessionRiskCard(String sessionId, boolean forHandoff, String requestId, boolean skipAfterglow);

    void markRiskAlreadySeen(String requestId);

    List<String> pendingRiskRequestIds(String... sessionIds);

    t<Set<String>> pendingRiskSessions();

    boolean sessionTasksAllTerminal(String sessionId);

    default void setRiskIslandFallback(String requestId, boolean fallback) {
        p.i(requestId, "requestId");
    }

    boolean showSessionRiskCard(String sessionId, String requestId, String title, String body, String riskLevel, List<RiskLiveButton> buttons, long timeoutMs);
}
