package com.stepos.ailauncher.foundation.appui.card.provider.alipay;

import N5.CardEnvelope;
import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import o6.C5009a;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\u000b\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000e\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000e\u0010\fJ\u0015\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010!\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b!\u0010\u0016R\u0014\u0010\"\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010#R \u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000f0$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/O;", "", "<init>", "()V", "", "status", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/Integer;)I", "incoming", "existing", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/Integer;Ljava/lang/Integer;)Z", "stored", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "LN5/i;", "envelope", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LN5/i;)Z", "", "taskId", "c", "(Ljava/lang/String;)LN5/i;", "e", "(LN5/i;)LN5/i;", "incomingStatus", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/Integer;)Z", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Z", "LY8/t;", "f", "(Ljava/lang/String;LN5/i;)V", Const.INTENT_KEY_UMID, "MMKV_ID", "Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "memory", "Ljava/util/concurrent/ConcurrentHashMap;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class O {
    private static final String MMKV_ID = "alipay_xui_terminal";
    public static final O INSTANCE = new O();
    private static final ConcurrentHashMap<String, CardEnvelope> memory = new ConcurrentHashMap<>();

    public final boolean a(String taskId, Integer incomingStatus) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        CardEnvelope cardEnvelopeC = c(taskId);
        if (cardEnvelopeC == null) {
            return false;
        }
        return i(incomingStatus, cardEnvelopeC.getTaskStatus());
    }

    public final boolean b(String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        CardEnvelope cardEnvelopeC = c(taskId);
        return h(cardEnvelopeC != null ? cardEnvelopeC.getTaskStatus() : null) > 0;
    }

    public final CardEnvelope c(String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        if (taskId.length() == 0) {
            return null;
        }
        ConcurrentHashMap<String, CardEnvelope> concurrentHashMap = memory;
        CardEnvelope cardEnvelope = concurrentHashMap.get(taskId);
        if (cardEnvelope != null) {
            return cardEnvelope;
        }
        CardEnvelope cardEnvelopeD = d(taskId);
        if (cardEnvelopeD == null) {
            return null;
        }
        concurrentHashMap.put(taskId, cardEnvelopeD);
        return cardEnvelopeD;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0037 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final N5.CardEnvelope d(java.lang.String r8) {
        /*
            r7 = this;
            r7 = 0
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L1f
            o6.a r1 = o6.C5009a.INSTANCE     // Catch: java.lang.Throwable -> L1f
            java.lang.String r2 = "alipay_xui_terminal"
            r5 = 4
            r6 = 0
            r4 = 0
            r3 = r8
            java.lang.String r8 = o6.C5009a.v(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L1c
            int r0 = r8.length()     // Catch: java.lang.Throwable -> L1c
            if (r0 <= 0) goto L16
            goto L17
        L16:
            r8 = r7
        L17:
            java.lang.Object r8 = kotlin.Result.b(r8)     // Catch: java.lang.Throwable -> L1c
            goto L2c
        L1c:
            r0 = move-exception
        L1d:
            r8 = r0
            goto L22
        L1f:
            r0 = move-exception
            r3 = r8
            goto L1d
        L22:
            kotlin.Result$a r0 = kotlin.Result.INSTANCE
            java.lang.Object r8 = kotlin.C4849c.a(r8)
            java.lang.Object r8 = kotlin.Result.b(r8)
        L2c:
            boolean r0 = kotlin.Result.g(r8)
            if (r0 == 0) goto L33
            r8 = r7
        L33:
            java.lang.String r8 = (java.lang.String) r8
            if (r8 != 0) goto L38
            return r7
        L38:
            N5.k r0 = N5.k.INSTANCE     // Catch: java.lang.Throwable -> L4b
            com.google.gson.Gson r0 = r0.b()     // Catch: java.lang.Throwable -> L4b
            java.lang.Class<N5.i> r1 = N5.CardEnvelope.class
            java.lang.Object r8 = r0.fromJson(r8, r1)     // Catch: java.lang.Throwable -> L4b
            N5.i r8 = (N5.CardEnvelope) r8     // Catch: java.lang.Throwable -> L4b
            java.lang.Object r8 = kotlin.Result.b(r8)     // Catch: java.lang.Throwable -> L4b
            goto L57
        L4b:
            r0 = move-exception
            r8 = r0
            kotlin.Result$a r0 = kotlin.Result.INSTANCE
            java.lang.Object r8 = kotlin.C4849c.a(r8)
            java.lang.Object r8 = kotlin.Result.b(r8)
        L57:
            java.lang.Throwable r0 = kotlin.Result.e(r8)
            if (r0 == 0) goto L87
            R5.b r1 = R5.b.INSTANCE
            java.lang.String r2 = "taskId"
            kotlin.Pair r2 = Y8.j.a(r2, r3)
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            java.lang.String r4 = "exception"
            kotlin.Pair r3 = Y8.j.a(r4, r3)
            java.lang.String r4 = "message"
            java.lang.String r0 = r0.getMessage()
            kotlin.Pair r0 = Y8.j.a(r4, r0)
            kotlin.Pair[] r0 = new kotlin.Pair[]{r2, r3, r0}
            java.lang.String r2 = "alipay.terminal.load.fail"
            r1.h(r2, r0)
        L87:
            boolean r0 = kotlin.Result.g(r8)
            if (r0 == 0) goto L8e
            goto L8f
        L8e:
            r7 = r8
        L8f:
            N5.i r7 = (N5.CardEnvelope) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.alipay.O.d(java.lang.String):N5.i");
    }

    public final CardEnvelope e(CardEnvelope incoming) {
        kotlin.jvm.internal.p.i(incoming, "incoming");
        CardEnvelope cardEnvelopeC = c(incoming.getTaskId());
        if (cardEnvelopeC == null || !i(incoming.getTaskStatus(), cardEnvelopeC.getTaskStatus())) {
            return incoming;
        }
        R5.b bVar = R5.b.INSTANCE;
        String taskId = incoming.getTaskId();
        if (taskId.length() == 0) {
            taskId = "null";
        }
        bVar.c("alipay.terminal.overlay", Y8.j.a("taskId", taskId), Y8.j.a("from", incoming.getTaskStatus()), Y8.j.a("to", cardEnvelopeC.getTaskStatus()));
        return cardEnvelopeC;
    }

    public final void f(String taskId, CardEnvelope envelope) {
        Object objB;
        Object objB2;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(N5.k.INSTANCE.b().toJson(envelope));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str = (String) objB;
        if (str == null || str.length() == 0) {
            R5.b.INSTANCE.h("alipay.terminal.persist.fail", Y8.j.a("taskId", taskId), Y8.j.a("reason", "json"));
            return;
        }
        try {
            objB2 = Result.b(Boolean.valueOf(C5009a.INSTANCE.H(MMKV_ID, taskId, str)));
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB2)) {
            objB2 = bool;
        }
        if (((Boolean) objB2).booleanValue()) {
            return;
        }
        R5.b.INSTANCE.h("alipay.terminal.persist.fail", Y8.j.a("taskId", taskId), Y8.j.a("reason", "mmkv"));
    }

    public final boolean g(CardEnvelope envelope) {
        kotlin.jvm.internal.p.i(envelope, "envelope");
        String taskId = envelope.getTaskId();
        if (taskId.length() == 0) {
            return false;
        }
        CardEnvelope cardEnvelopeC = c(taskId);
        if (!j(envelope.getTaskStatus(), cardEnvelopeC != null ? cardEnvelopeC.getTaskStatus() : null)) {
            R5.b.INSTANCE.c("alipay.terminal.skip", Y8.j.a("taskId", taskId), Y8.j.a("incoming", envelope.getTaskStatus()), Y8.j.a("stored", cardEnvelopeC != null ? cardEnvelopeC.getTaskStatus() : null));
            return false;
        }
        memory.put(taskId, envelope);
        f(taskId, envelope);
        R5.b.INSTANCE.c("alipay.terminal.put", Y8.j.a("taskId", taskId), Y8.j.a(D6.a.KEY_TASK_STATUS, envelope.getTaskStatus()), Y8.j.a("hadStored", Boolean.valueOf(cardEnvelopeC != null)));
        return true;
    }

    public final int h(Integer status) {
        if (status != null && status.intValue() == 3) {
            return 1;
        }
        if (status != null && status.intValue() == 7) {
            return 1;
        }
        if (status != null && status.intValue() == 4) {
            return 2;
        }
        if (status != null && status.intValue() == 5) {
            return 2;
        }
        return (status != null && status.intValue() == 6) ? 2 : 0;
    }

    public final boolean i(Integer incoming, Integer stored) {
        return h(stored) > h(incoming);
    }

    public final boolean j(Integer incoming, Integer existing) {
        int iH = h(incoming);
        return iH != 0 && iH >= h(existing);
    }
}
