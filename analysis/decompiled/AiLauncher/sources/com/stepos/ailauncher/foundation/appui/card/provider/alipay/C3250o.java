package com.stepos.ailauncher.foundation.appui.card.provider.alipay;

import N5.CardEnvelope;
import Z8.Y;
import android.os.Handler;
import android.os.Looper;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.api.taskstore.ILiveNotificationService;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIslandVisibility;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.H;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.o0;
import com.stepos.ame.sdk.SkillStoreKt;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\u000bJ!\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0016\u0010\u0015J)\u0010\u0017\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0017\u0010\u0015JI\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJI\u0010 \u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b \u0010\u001fJI\u0010\"\u001a\u00020!2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\"\u0010#JI\u0010$\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b$\u0010\u001fR\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000f0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010*¨\u0006,"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/o;", "", "<init>", "()V", "", "payload", "", "sessionId", "timestamp", "LY8/t;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;JJ)V", Const.INTENT_KEY_PKGNAME, "LN5/i;", "envelope", "", "status", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(LN5/i;Ljava/lang/Integer;)V", "taskId", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LN5/i;Ljava/lang/String;Ljava/lang/Integer;)V", "f", "k", "Lcom/stepos/ailauncher/contract/api/taskstore/ILiveNotificationService;", "live", "title", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$Phase;", "phase", "c", "(Lcom/stepos/ailauncher/contract/api/taskstore/ILiveNotificationService;LN5/i;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$Phase;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/ailauncher/contract/api/taskstore/ILiveNotificationService;LN5/i;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiIsland$Phase;)Z", "l", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "", "chatStatuses", "Ljava/util/Set;", "islandStatuses", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.alipay.o, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3250o {
    public static final C3250o INSTANCE = new C3250o();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static final Set<Integer> chatStatuses = Y.j(3, 7, 4, 5, 6);
    private static final Set<Integer> islandStatuses = AlipayXuiIsland.INSTANCE.e();

    public static final void e(String str, long j10, long j11) {
        INSTANCE.d(str, j10, j11);
    }

    public final void b(String payload, long sessionId, long timestamp) {
        if (La.H.x0(payload)) {
            R5.b.INSTANCE.h("binder.skip.empty", Y8.j.a("sessionId", Long.valueOf(sessionId)), Y8.j.a("timestamp", Long.valueOf(timestamp)));
            return;
        }
        CardEnvelope cardEnvelopeJ = AlipayXuiIsland.INSTANCE.j(payload);
        if (cardEnvelopeJ == null) {
            R5.b.INSTANCE.h("binder.skip.parse", Y8.j.a("sessionId", Long.valueOf(sessionId)), Y8.j.a("timestamp", Long.valueOf(timestamp)), Y8.j.a("payloadLen", Integer.valueOf(payload.length())));
            return;
        }
        String taskId = cardEnvelopeJ.getTaskId();
        Integer taskStatus = cardEnvelopeJ.getTaskStatus();
        R5.b bVar = R5.b.INSTANCE;
        bVar.c("binder.enter", Y8.j.a("taskId", taskId.length() == 0 ? "null" : taskId), Y8.j.a("templateType", cardEnvelopeJ.getTemplateType()), Y8.j.a(D6.a.KEY_TASK_STATUS, taskStatus), Y8.j.a("sessionId", Long.valueOf(sessionId)), Y8.j.a("timestamp", Long.valueOf(timestamp)));
        if (!kotlin.jvm.internal.p.d(cardEnvelopeJ.getTemplateType(), O5.c.ALIPAY_XUI)) {
            if (taskId.length() == 0) {
                taskId = "null";
            }
            bVar.h("binder.skip.tpl", Y8.j.a("taskId", taskId), Y8.j.a("templateType", cardEnvelopeJ.getTemplateType()));
        } else {
            if (taskId.length() == 0) {
                bVar.h("binder.skip.noTaskId", Y8.j.a(D6.a.KEY_TASK_STATUS, taskStatus), Y8.j.a("sessionId", Long.valueOf(sessionId)));
                return;
            }
            v vVar = v.INSTANCE;
            vVar.l(taskId, sessionId);
            h(cardEnvelopeJ, taskStatus);
            g(cardEnvelopeJ, taskId, taskStatus);
            f(cardEnvelopeJ, taskId, taskStatus);
            k(cardEnvelopeJ, taskId, taskStatus);
            vVar.k(taskId, taskStatus);
        }
    }

    public final void c(ILiveNotificationService live, CardEnvelope envelope, String taskId, Integer status, String title, String content, AlipayXuiIsland.Phase phase) {
        if (status != null) {
            int iIntValue = status.intValue();
            AlipayXuiIsland alipayXuiIsland = AlipayXuiIsland.INSTANCE;
            String strF = alipayXuiIsland.f(taskId, iIntValue);
            AlipayXuiIslandVisibility alipayXuiIslandVisibility = AlipayXuiIslandVisibility.INSTANCE;
            alipayXuiIslandVisibility.u(live, new AlipayXuiIslandVisibility.Card(strF, title, content, alipayXuiIsland.g(status), alipayXuiIsland.m(envelope), N5.j.INSTANCE.d(envelope.getSessionId()), taskId, iIntValue, alipayXuiIsland.h(phase), false));
            H.INSTANCE.g(taskId, iIntValue, title, content, strF);
            alipayXuiIslandVisibility.V(live);
            R5.b.INSTANCE.c("binder.island.hold", Y8.j.a("taskId", taskId), Y8.j.a("liveId", strF), Y8.j.a(D6.a.KEY_TASK_STATUS, status), Y8.j.a("phase", phase.getTraceName()), Y8.j.a("title", title), Y8.j.a(SkillStoreKt.SKILL_DOC_TYPE_CONTENT, content));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(final java.lang.String r8, final long r9, final long r11) {
        /*
            r7 = this;
            java.lang.String r0 = "payload"
            kotlin.jvm.internal.p.i(r8, r0)
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            boolean r0 = kotlin.jvm.internal.p.d(r0, r1)
            if (r0 != 0) goto L22
            android.os.Handler r7 = com.stepos.ailauncher.foundation.appui.card.provider.alipay.C3250o.mainHandler
            com.stepos.ailauncher.foundation.appui.card.provider.alipay.n r0 = new com.stepos.ailauncher.foundation.appui.card.provider.alipay.n
            r1 = r8
            r2 = r9
            r4 = r11
            r0.<init>()
            r7.post(r0)
            return
        L22:
            r1 = r8
            r2 = r9
            r4 = r11
            kotlin.Result$a r8 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L37
            r5 = r4
            r3 = r2
            r2 = r1
            r1 = r7
            r1.b(r2, r3, r5)     // Catch: java.lang.Throwable -> L3a
            r2 = r3
            r4 = r5
            Y8.t r7 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L37
            java.lang.Object r7 = kotlin.Result.b(r7)     // Catch: java.lang.Throwable -> L37
            goto L48
        L37:
            r0 = move-exception
        L38:
            r7 = r0
            goto L3e
        L3a:
            r0 = move-exception
            r2 = r3
            r4 = r5
            goto L38
        L3e:
            kotlin.Result$a r8 = kotlin.Result.INSTANCE
            java.lang.Object r7 = kotlin.C4849c.a(r7)
            java.lang.Object r7 = kotlin.Result.b(r7)
        L48:
            java.lang.Throwable r7 = kotlin.Result.e(r7)
            if (r7 == 0) goto L87
            R5.b r8 = R5.b.INSTANCE
            java.lang.String r9 = "sessionId"
            java.lang.Long r10 = java.lang.Long.valueOf(r2)
            kotlin.Pair r9 = Y8.j.a(r9, r10)
            java.lang.String r10 = "timestamp"
            java.lang.Long r11 = java.lang.Long.valueOf(r4)
            kotlin.Pair r10 = Y8.j.a(r10, r11)
            java.lang.Class r11 = r7.getClass()
            java.lang.String r11 = r11.getSimpleName()
            java.lang.String r12 = "exception"
            kotlin.Pair r11 = Y8.j.a(r12, r11)
            java.lang.String r12 = "message"
            java.lang.String r7 = r7.getMessage()
            kotlin.Pair r7 = Y8.j.a(r12, r7)
            kotlin.Pair[] r7 = new kotlin.Pair[]{r9, r10, r11, r7}
            java.lang.String r9 = "binder.apply.fail"
            r8.h(r9, r7)
        L87:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.alipay.C3250o.d(java.lang.String, long, long):void");
    }

    public final void f(CardEnvelope envelope, String taskId, Integer status) {
        Object objB;
        Object objB2;
        if (!Z8.F.f0(chatStatuses, status)) {
            R5.b.INSTANCE.c("binder.skip.status", Y8.j.a("taskId", taskId), Y8.j.a(D6.a.KEY_TASK_STATUS, status));
            return;
        }
        if (O.INSTANCE.a(taskId, status)) {
            R5.b.INSTANCE.c("binder.skip.status", Y8.j.a("taskId", taskId), Y8.j.a(D6.a.KEY_TASK_STATUS, status), Y8.j.a("reason", o0.TRACK_STATUS_TERMINAL));
            return;
        }
        N5.d dVarA = N5.z.INSTANCE.a(taskId);
        if (dVarA == null) {
            R5.b.INSTANCE.c("binder.skip.noView", Y8.j.a("taskId", taskId), Y8.j.a(D6.a.KEY_TASK_STATUS, status));
            return;
        }
        if (!(dVarA instanceof AlipayXuiCardView)) {
            R5.b.INSTANCE.h("binder.skip.wrongView", Y8.j.a("taskId", taskId), Y8.j.a("viewCls", dVarA.getClass().getSimpleName()));
            return;
        }
        N5.v vVarB = N5.g.INSTANCE.b(O5.c.ALIPAY_XUI);
        if (vVarB == null) {
            R5.b.INSTANCE.h("binder.skip.noProvider", Y8.j.a("taskId", taskId));
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(vVarB.b(envelope));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b.INSTANCE.h("binder.parse.fail", Y8.j.a("taskId", taskId), Y8.j.a("exception", thE.getClass().getSimpleName()), Y8.j.a("message", thE.getMessage()));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        try {
            ((AlipayXuiCardView) dVarA).h(envelope, (N5.n) objB);
            objB2 = Result.b(Y8.t.f7040a);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        Throwable thE2 = Result.e(objB2);
        if (thE2 != null) {
            R5.b.INSTANCE.h("binder.bind.fail", Y8.j.a("taskId", taskId), Y8.j.a("exception", thE2.getClass().getSimpleName()), Y8.j.a("message", thE2.getMessage()));
        }
        if (Result.h(objB2)) {
            R5.b.INSTANCE.c("binder.bind", Y8.j.a("taskId", taskId), Y8.j.a(D6.a.KEY_TASK_STATUS, status), Y8.j.a("viewCls", dVarA.getClass().getSimpleName()));
        }
    }

    public final void g(CardEnvelope envelope, String taskId, Integer status) {
        if (status != null && status.intValue() == 2) {
            if (O.INSTANCE.a(taskId, status)) {
                R5.b.INSTANCE.c("binder.subtitle.skip", Y8.j.a("taskId", taskId), Y8.j.a("reason", o0.TRACK_STATUS_TERMINAL));
                return;
            }
            String strE = AlipayXuiIsland.INSTANCE.l(envelope).e();
            C3239d c3239d = C3239d.INSTANCE;
            c3239d.b(taskId, strE);
            String strA = c3239d.a(taskId);
            R5.b bVar = R5.b.INSTANCE;
            bVar.c("binder.subtitle.cache", Y8.j.a("taskId", taskId), Y8.j.a("title", strA == null ? "null" : strA));
            N5.d dVarA = N5.z.INSTANCE.a(taskId);
            AlipayXuiCardView alipayXuiCardView = dVarA instanceof AlipayXuiCardView ? (AlipayXuiCardView) dVarA : null;
            if (alipayXuiCardView == null) {
                bVar.c("binder.subtitle.waitView", Y8.j.a("taskId", taskId));
                return;
            }
            if (!alipayXuiCardView.f0(strA)) {
                bVar.c("binder.subtitle.skip", Y8.j.a("taskId", taskId), Y8.j.a("reason", "notExecuting"));
                return;
            }
            Pair pairA = Y8.j.a("taskId", taskId);
            if (strA == null) {
                strA = "null";
            }
            bVar.c("binder.subtitle.patch", pairA, Y8.j.a("title", strA));
        }
    }

    public final void h(CardEnvelope envelope, Integer status) {
        O o10 = O.INSTANCE;
        if (o10.h(status) == 0) {
            return;
        }
        o10.g(envelope);
    }

    public final boolean i(ILiveNotificationService live, CardEnvelope envelope, String taskId, Integer status, String title, String content, AlipayXuiIsland.Phase phase) {
        if (status == null) {
            return false;
        }
        int iIntValue = status.intValue();
        AlipayXuiIsland alipayXuiIsland = AlipayXuiIsland.INSTANCE;
        String strF = alipayXuiIsland.f(taskId, iIntValue);
        if (!AlipayXuiIslandVisibility.INSTANCE.Q(taskId, live, new AlipayXuiIslandVisibility.Card(strF, title, content, alipayXuiIsland.g(status), alipayXuiIsland.m(envelope), N5.j.INSTANCE.d(envelope.getSessionId()), taskId, iIntValue, alipayXuiIsland.h(phase), false, 512, null))) {
            return false;
        }
        H.INSTANCE.g(taskId, iIntValue, title, content, strF);
        R5.b.INSTANCE.c("binder.island.text", Y8.j.a("taskId", taskId), Y8.j.a("liveId", strF), Y8.j.a(D6.a.KEY_TASK_STATUS, status), Y8.j.a("phase", phase.getTraceName()), Y8.j.a("title", title), Y8.j.a(SkillStoreKt.SKILL_DOC_TYPE_CONTENT, content));
        return true;
    }

    public final void j(ILiveNotificationService live, CardEnvelope envelope, String taskId, Integer status, String title, String content, AlipayXuiIsland.Phase phase) {
        if (status != null) {
            int iIntValue = status.intValue();
            AlipayXuiIsland alipayXuiIsland = AlipayXuiIsland.INSTANCE;
            String strF = alipayXuiIsland.f(taskId, iIntValue);
            String strM = alipayXuiIsland.m(envelope);
            String strD = N5.j.INSTANCE.d(envelope.getSessionId());
            boolean zD = alipayXuiIsland.d(phase);
            AlipayXuiIslandVisibility alipayXuiIslandVisibility = AlipayXuiIslandVisibility.INSTANCE;
            alipayXuiIslandVisibility.n(taskId, live);
            AlipayXuiIslandVisibility.I(alipayXuiIslandVisibility, live, new AlipayXuiIslandVisibility.Card(strF, title, content, alipayXuiIsland.g(status), strM, strD, taskId, iIntValue, alipayXuiIsland.h(phase), zD), 0L, null, 12, null);
            H.INSTANCE.g(taskId, iIntValue, title, content, strF);
            R5.b.INSTANCE.c("binder.island.show", Y8.j.a("taskId", taskId), Y8.j.a("liveId", strF), Y8.j.a(D6.a.KEY_TASK_STATUS, status), Y8.j.a("phase", phase.getTraceName()), Y8.j.a("title", title), Y8.j.a(SkillStoreKt.SKILL_DOC_TYPE_CONTENT, content), Y8.j.a("hasLink", Boolean.valueOf(strM != null)), Y8.j.a("hasSession", Boolean.valueOf(strD != null)), Y8.j.a("floatOverlay", Boolean.valueOf(zD)));
        }
    }

    public final void k(CardEnvelope envelope, String taskId, Integer status) {
        String str;
        Integer num = status;
        if (Z8.F.f0(islandStatuses, num)) {
            ILiveNotificationService iLiveNotificationService = (ILiveNotificationService) D5.a.INSTANCE.a(ILiveNotificationService.class);
            if (iLiveNotificationService == null) {
                R5.b.INSTANCE.h("binder.island.noService", Y8.j.a("taskId", taskId));
                return;
            }
            AlipayXuiIsland alipayXuiIsland = AlipayXuiIsland.INSTANCE;
            String strE = alipayXuiIsland.l(envelope).e();
            boolean zD = G.INSTANCE.d();
            AlipayXuiIslandVisibility alipayXuiIslandVisibility = AlipayXuiIslandVisibility.INSTANCE;
            if (alipayXuiIslandVisibility.C(zD)) {
                alipayXuiIslandVisibility.M(iLiveNotificationService);
            }
            boolean zV = alipayXuiIslandVisibility.v(taskId);
            H h10 = H.INSTANCE;
            H.Memory memoryD = h10.d(taskId);
            if (!zD && !zV && memoryD != null && !memoryD.getClosed() && alipayXuiIslandVisibility.B(iLiveNotificationService, memoryD.getLiveId()) && !alipayXuiIslandVisibility.v(taskId)) {
                h10.a(taskId);
                memoryD = h10.d(taskId);
            }
            if (zD && num != null && !alipayXuiIsland.n(num)) {
                int iIntValue = num.intValue();
                String strD = N5.j.INSTANCE.d(strE);
                if (strD == null) {
                    strD = memoryD != null ? memoryD.getTitle() : null;
                    if (strD == null) {
                        strD = "";
                    }
                }
                alipayXuiIslandVisibility.q(taskId, iIntValue, strD, alipayXuiIsland.b(num, strE), iLiveNotificationService);
                R5.b.INSTANCE.c("binder.island.skip", Y8.j.a("taskId", taskId), Y8.j.a(D6.a.KEY_TASK_STATUS, num), Y8.j.a("reason", "seeAlipay"));
                return;
            }
            AlipayXuiIsland.b bVarA = alipayXuiIsland.a(num, strE, memoryD);
            if (!(bVarA instanceof AlipayXuiIsland.b.Skip)) {
                if (!(bVarA instanceof AlipayXuiIsland.b.Update)) {
                    if (!(bVarA instanceof AlipayXuiIsland.b.Show)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (zD) {
                        AlipayXuiIsland.b.Show show = (AlipayXuiIsland.b.Show) bVarA;
                        c(iLiveNotificationService, envelope, taskId, status, show.getTitle(), show.getContent(), show.getPhase());
                        return;
                    } else {
                        AlipayXuiIsland.b.Show show2 = (AlipayXuiIsland.b.Show) bVarA;
                        j(iLiveNotificationService, envelope, taskId, status, show2.getTitle(), show2.getContent(), show2.getPhase());
                        return;
                    }
                }
                if (zD) {
                    AlipayXuiIsland.b.Update update = (AlipayXuiIsland.b.Update) bVarA;
                    c(iLiveNotificationService, envelope, taskId, status, update.getTitle(), update.getContent(), update.getPhase());
                    return;
                }
                if (zV) {
                    AlipayXuiIsland.b.Update update2 = (AlipayXuiIsland.b.Update) bVarA;
                    if (i(iLiveNotificationService, envelope, taskId, status, update2.getTitle(), update2.getContent(), update2.getPhase())) {
                        return;
                    }
                }
                AlipayXuiIsland.b.Update update3 = (AlipayXuiIsland.b.Update) bVarA;
                l(iLiveNotificationService, envelope, taskId, status, update3.getTitle(), update3.getContent(), update3.getPhase());
                return;
            }
            AlipayXuiIsland.b.Skip skip = (AlipayXuiIsland.b.Skip) bVarA;
            if (kotlin.jvm.internal.p.d(skip.getReason(), AlipayXuiIsland.REASON_ENDED)) {
                R5.b.INSTANCE.c("binder.island.skip", Y8.j.a("taskId", taskId), Y8.j.a(D6.a.KEY_TASK_STATUS, num), Y8.j.a("reason", skip.getReason()), Y8.j.a("seeingAlipay", Boolean.valueOf(zD)));
                return;
            }
            if (zD && kotlin.jvm.internal.p.d(skip.getReason(), AlipayXuiIsland.REASON_CLOSED) && alipayXuiIsland.n(num) && memoryD != null && alipayXuiIsland.n(Integer.valueOf(memoryD.getStatus()))) {
                AlipayXuiIsland.Phase phaseK = alipayXuiIsland.k(num);
                if (phaseK != null) {
                    String title = memoryD.getTitle();
                    String strD2 = N5.j.INSTANCE.d(strE);
                    if (strD2 == null) {
                        strD2 = memoryD.getContent();
                    }
                    c(iLiveNotificationService, envelope, taskId, num, title, strD2, phaseK);
                    num = num;
                }
            } else {
                if (!zD) {
                    if (zV) {
                        AlipayXuiIslandVisibility.R(alipayXuiIslandVisibility, taskId, iLiveNotificationService, null, 4, null);
                        str = taskId;
                    }
                    R5.b.INSTANCE.c("binder.island.skip", Y8.j.a("taskId", str), Y8.j.a(D6.a.KEY_TASK_STATUS, num), Y8.j.a("reason", skip.getReason()), Y8.j.a("seeingAlipay", Boolean.valueOf(zD)));
                }
                alipayXuiIslandVisibility.V(iLiveNotificationService);
            }
            str = taskId;
            R5.b.INSTANCE.c("binder.island.skip", Y8.j.a("taskId", str), Y8.j.a(D6.a.KEY_TASK_STATUS, num), Y8.j.a("reason", skip.getReason()), Y8.j.a("seeingAlipay", Boolean.valueOf(zD)));
        }
    }

    public final void l(ILiveNotificationService live, CardEnvelope envelope, String taskId, Integer status, String title, String content, AlipayXuiIsland.Phase phase) {
        if (status != null) {
            int iIntValue = status.intValue();
            AlipayXuiIsland alipayXuiIsland = AlipayXuiIsland.INSTANCE;
            String strF = alipayXuiIsland.f(taskId, iIntValue);
            if (AlipayXuiIslandVisibility.INSTANCE.X(live, new AlipayXuiIslandVisibility.Card(strF, title, content, alipayXuiIsland.g(status), alipayXuiIsland.m(envelope), N5.j.INSTANCE.d(envelope.getSessionId()), taskId, iIntValue, alipayXuiIsland.h(phase), false, 512, null))) {
                H.INSTANCE.g(taskId, iIntValue, title, content, strF);
                R5.b.INSTANCE.c("binder.island.text", Y8.j.a("taskId", taskId), Y8.j.a("liveId", strF), Y8.j.a(D6.a.KEY_TASK_STATUS, status), Y8.j.a("phase", phase.getTraceName()), Y8.j.a("title", title), Y8.j.a(SkillStoreKt.SKILL_DOC_TYPE_CONTENT, content));
            }
        }
    }
}
