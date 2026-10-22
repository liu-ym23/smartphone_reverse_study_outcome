package com.stepos.ailauncher.contract.api.taskstore;

import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiLiveClickReceiver;
import com.stepos.ame.sdk.SkillStoreKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019Je\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0015\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0017\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\u0018\u0010\u0014¨\u0006\u001aÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/contract/api/taskstore/ILiveNotificationService;", "", "", "taskId", "title", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "status", AlipayXuiLiveClickReceiver.EXTRA_APP_LINK, "sessionId", "", "floatOverlay", "medium", "", "timeoutAfterMs", "LY8/t;", "showSmall", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZJ)V", "isPosted", "(Ljava/lang/String;)Z", "cancel", "(Ljava/lang/String;)V", "dismissFailedAfterView", "(Ljava/lang/String;Ljava/lang/String;)V", "openChatSession", "markTakeoverAlreadySeen", "Companion", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ILiveNotificationService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final long FOUR_HOURS_MS = 14400000;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/contract/api/taskstore/ILiveNotificationService$Companion;", "", "<init>", "()V", "FOUR_HOURS_MS", "", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final long FOUR_HOURS_MS = 14400000;

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ void dismissFailedAfterView$default(ILiveNotificationService iLiveNotificationService, String str, String str2, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dismissFailedAfterView");
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        iLiveNotificationService.dismissFailedAfterView(str, str2);
    }

    static /* synthetic */ void showSmall$default(ILiveNotificationService iLiveNotificationService, String str, String str2, String str3, String str4, String str5, String str6, boolean z10, boolean z11, long j10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showSmall");
        }
        if ((i10 & 16) != 0) {
            str5 = null;
        }
        if ((i10 & 32) != 0) {
            str6 = null;
        }
        if ((i10 & 64) != 0) {
            z10 = true;
        }
        if ((i10 & 128) != 0) {
            z11 = false;
        }
        if ((i10 & 256) != 0) {
            j10 = 14400000;
        }
        iLiveNotificationService.showSmall(str, str2, str3, str4, str5, str6, z10, z11, j10);
    }

    void cancel(String taskId);

    void dismissFailedAfterView(String sessionId, String taskId);

    boolean isPosted(String taskId);

    void markTakeoverAlreadySeen(String sessionId);

    void openChatSession(String sessionId);

    void showSmall(String taskId, String title, String content, String status, String appLink, String sessionId, boolean floatOverlay, boolean medium, long timeoutAfterMs);
}
