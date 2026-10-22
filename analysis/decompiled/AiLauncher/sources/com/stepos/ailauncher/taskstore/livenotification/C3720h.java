package com.stepos.ailauncher.taskstore.livenotification;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.ConversationSessionIds;
import com.stepos.ailauncher.chat.sheet.C2739j;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.contract.api.taskstore.ILiveNotificationService;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiLiveClickReceiver;
import com.stepos.ame.sdk.SkillStoreKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J[\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0017\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u0016J\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/taskstore/livenotification/h;", "Lcom/stepos/ailauncher/contract/api/taskstore/ILiveNotificationService;", "<init>", "()V", "", "taskId", "title", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "status", AlipayXuiLiveClickReceiver.EXTRA_APP_LINK, "sessionId", "", "floatOverlay", "medium", "", "timeoutAfterMs", "LY8/t;", "showSmall", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZJ)V", "isPosted", "(Ljava/lang/String;)Z", "cancel", "(Ljava/lang/String;)V", "dismissFailedAfterView", "(Ljava/lang/String;Ljava/lang/String;)V", "openChatSession", "markTakeoverAlreadySeen", "raw", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.livenotification.h, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3720h implements ILiveNotificationService {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
    
        if (r0.equals("WAITING") == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
    
        if (r0.equals("PENDING") != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003f, code lost:
    
        return com.stepos.ailauncher.taskstore.entity.TaskInfoStatus.WAITING;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.taskstore.entity.TaskInfoStatus a(java.lang.String r1) {
        /*
            r0 = this;
            java.util.Locale r0 = java.util.Locale.ROOT
            java.lang.String r0 = r1.toUpperCase(r0)
            java.lang.String r1 = "toUpperCase(...)"
            kotlin.jvm.internal.p.h(r0, r1)
            int r1 = r0.hashCode()
            switch(r1) {
                case 35394935: goto L35;
                case 1383663147: goto L29;
                case 1834295853: goto L20;
                case 2066319421: goto L14;
                default: goto L13;
            }
        L13:
            goto L40
        L14:
            java.lang.String r1 = "FAILED"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L1d
            goto L40
        L1d:
            com.stepos.ailauncher.taskstore.entity.TaskInfoStatus r0 = com.stepos.ailauncher.taskstore.entity.TaskInfoStatus.FAILED
            return r0
        L20:
            java.lang.String r1 = "WAITING"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3d
            goto L40
        L29:
            java.lang.String r1 = "COMPLETED"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L32
            goto L40
        L32:
            com.stepos.ailauncher.taskstore.entity.TaskInfoStatus r0 = com.stepos.ailauncher.taskstore.entity.TaskInfoStatus.COMPLETED
            return r0
        L35:
            java.lang.String r1 = "PENDING"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L40
        L3d:
            com.stepos.ailauncher.taskstore.entity.TaskInfoStatus r0 = com.stepos.ailauncher.taskstore.entity.TaskInfoStatus.WAITING
            return r0
        L40:
            com.stepos.ailauncher.taskstore.entity.TaskInfoStatus r0 = com.stepos.ailauncher.taskstore.entity.TaskInfoStatus.RUNNING
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.livenotification.C3720h.a(java.lang.String):com.stepos.ailauncher.taskstore.entity.TaskInfoStatus");
    }

    @Override // com.stepos.ailauncher.contract.api.taskstore.ILiveNotificationService
    public void cancel(String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        A.INSTANCE.e(C3197a.INSTANCE.a(), taskId);
    }

    @Override // com.stepos.ailauncher.contract.api.taskstore.ILiveNotificationService
    public void dismissFailedAfterView(String sessionId, String taskId) {
        A.INSTANCE.h(C3197a.INSTANCE.a(), sessionId, taskId);
    }

    @Override // com.stepos.ailauncher.contract.api.taskstore.ILiveNotificationService
    public boolean isPosted(String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        return T.INSTANCE.C(C3197a.INSTANCE.a(), taskId);
    }

    @Override // com.stepos.ailauncher.contract.api.taskstore.ILiveNotificationService
    public void markTakeoverAlreadySeen(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        z.INSTANCE.f(sessionId);
    }

    @Override // com.stepos.ailauncher.contract.api.taskstore.ILiveNotificationService
    public void openChatSession(String sessionId) {
        if (sessionId != null) {
            if (La.H.x0(sessionId)) {
                sessionId = null;
            }
            if (sessionId == null) {
                return;
            }
            String strK = ConversationSessionIds.INSTANCE.k(sessionId);
            dismissFailedAfterView(sessionId, null);
            if (!kotlin.jvm.internal.p.d(strK, sessionId)) {
                dismissFailedAfterView(strK, null);
            }
            C2739j.v(C3197a.INSTANCE.a(), strK);
        }
    }

    @Override // com.stepos.ailauncher.contract.api.taskstore.ILiveNotificationService
    public void showSmall(String taskId, String title, String content, String status, String appLink, String sessionId, boolean floatOverlay, boolean medium, long timeoutAfterMs) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(content, "content");
        kotlin.jvm.internal.p.i(status, "status");
        A.INSTANCE.l(C3197a.INSTANCE.a(), taskId, title, content, a(status), appLink, sessionId, floatOverlay, medium, timeoutAfterMs);
    }
}
