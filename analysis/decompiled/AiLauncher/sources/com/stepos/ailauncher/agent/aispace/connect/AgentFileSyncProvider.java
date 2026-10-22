package com.stepos.ailauncher.agent.aispace.connect;

import Ua.C1056g;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.AgentFileSyncBridge;
import e9.InterfaceC4014c;
import h8.C4148a;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;
import tb.AbstractC5531D;
import tb.C5528A;
import tb.C5530C;
import tb.z;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\b\u0010\tJ1\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\u0011\u0010\tJ\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001b\u0010%\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/AgentFileSyncProvider;", "", "<init>", "()V", "LY8/t;", "m", "", "fileId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "Lcom/stepos/agentframework/chatui/AgentFileSyncBridge$a;", "result", "sessionId", "l", "(Landroid/content/Context;Lcom/stepos/agentframework/chatui/AgentFileSyncBridge$a;Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "url", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)Ljava/lang/String;", "TAG", "Ljava/lang/String;", "", "MAX_ATTEMPTS", "I", "", "POLL_INTERVAL_MS", "J", "Ljava/util/concurrent/ConcurrentHashMap;", "textCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Ltb/z;", "http$delegate", "LY8/h;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Ltb/z;", "http", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentFileSyncProvider {
    private static final int MAX_ATTEMPTS = 8;
    private static final long POLL_INTERVAL_MS = 1500;
    private static final String TAG = "AgentFileSyncProvider";
    public static final AgentFileSyncProvider INSTANCE = new AgentFileSyncProvider();
    private static final ConcurrentHashMap<String, String> textCache = new ConcurrentHashMap<>();

    /* renamed from: http$delegate, reason: from kotlin metadata */
    private static final Y8.h http = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.connect.m
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return AgentFileSyncProvider.k();
        }
    });

    public static final tb.z k() {
        z.a aVar = new z.a();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return aVar.g(10L, timeUnit).T(20L, timeUnit).d();
    }

    public static final Y8.t n(Context context, AgentFileSyncBridge.Result result, String fileId, String str) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(result, "result");
        kotlin.jvm.internal.p.i(fileId, "fileId");
        INSTANCE.l(context, result, fileId, str);
        return Y8.t.f7040a;
    }

    public final String g(String url) {
        Object objB;
        AbstractC5531D body;
        try {
            Result.Companion companion = Result.INSTANCE;
            C5530C c5530cExecute = j().a(new C5528A.a().t(url).e().b()).execute();
            try {
                String strA = (c5530cExecute.getIsSuccessful() && (body = c5530cExecute.getBody()) != null) ? body.A() : null;
                l9.b.a(c5530cExecute, null);
                objB = Result.b(strA);
            } finally {
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "downloadText failed", thE, false, 8, null);
        }
        return (String) (Result.g(objB) ? null : objB);
    }

    public final Object h(String str, InterfaceC4014c<? super AgentFileSyncBridge.Result> interfaceC4014c) {
        return C1056g.j(Ua.Y.b(), new AgentFileSyncProvider$fetch$2(str, null), interfaceC4014c);
    }

    public final Object i(String str, InterfaceC4014c<? super String> interfaceC4014c) {
        return C1056g.j(Ua.Y.b(), new AgentFileSyncProvider$fetchUrl$2(str, null), interfaceC4014c);
    }

    public final tb.z j() {
        return (tb.z) http.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001e A[PHI: r0
      0x001e: PHI (r0v12 java.lang.String) = (r0v3 java.lang.String), (r0v13 java.lang.String) binds: [B:15:0x0024, B:11:0x001b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(android.content.Context r22, com.stepos.agentframework.chatui.AgentFileSyncBridge.Result r23, java.lang.String r24, java.lang.String r25) {
        /*
            r21 = this;
            java.lang.String r0 = r23.getFileName()
            if (r0 != 0) goto L8
            java.lang.String r0 = ""
        L8:
            r3 = r0
            long r5 = java.lang.System.currentTimeMillis()
            java.lang.String r0 = r23.getTosFileId()
            if (r0 == 0) goto L20
            boolean r1 = La.H.x0(r0)
            if (r1 != 0) goto L1a
            goto L1b
        L1a:
            r0 = 0
        L1b:
            if (r0 != 0) goto L1e
            goto L20
        L1e:
            r7 = r0
            goto L28
        L20:
            java.lang.String r0 = r23.getFileId()
            if (r0 != 0) goto L1e
            r7 = r24
        L28:
            java.lang.String r9 = r23.getUrl()
            java.lang.String r10 = r23.getMime()
            java.lang.String r11 = r23.getFileName()
            java.lang.String r12 = r23.getFileName()
            java.lang.Long r13 = r23.getSize()
            java.lang.String r14 = r23.getPreviewUrl()
            com.stepos.ailauncher.contract.model.SessionArtifact r16 = new com.stepos.ailauncher.contract.model.SessionArtifact
            java.lang.String r2 = ""
            r4 = 0
            r8 = r25
            r1 = r16
            r1.<init>(r2, r3, r4, r5, r7, r8, r9, r10, r11, r12, r13, r14)
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L62
            r19 = 4
            r20 = 0
            r17 = 0
            r15 = r22
            r18 = r25
            com.stepos.ailauncher.foundation.task.a.b(r15, r16, r17, r18, r19, r20)     // Catch: java.lang.Throwable -> L62
            Y8.t r0 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L62
            java.lang.Object r0 = kotlin.Result.b(r0)     // Catch: java.lang.Throwable -> L62
            goto L6d
        L62:
            r0 = move-exception
            kotlin.Result$a r1 = kotlin.Result.INSTANCE
            java.lang.Object r0 = kotlin.C4849c.a(r0)
            java.lang.Object r0 = kotlin.Result.b(r0)
        L6d:
            java.lang.Throwable r3 = kotlin.Result.e(r0)
            if (r3 == 0) goto L9a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "open artifact preview failed fileId="
            r0.append(r1)
            r1 = r24
            r0.append(r1)
            java.lang.String r1 = " sid="
            r0.append(r1)
            r8 = r25
            r0.append(r8)
            java.lang.String r2 = r0.toString()
            r5 = 8
            r6 = 0
            java.lang.String r1 = "AgentFileSyncProvider"
            r4 = 0
            h8.C4148a.t(r1, r2, r3, r4, r5, r6)
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.connect.AgentFileSyncProvider.l(android.content.Context, com.stepos.agentframework.chatui.AgentFileSyncBridge$a, java.lang.String, java.lang.String):void");
    }

    public final void m() {
        AgentFileSyncBridge.e(new AgentFileSyncProvider$register$1(null));
        AgentFileSyncBridge.h(new AgentFileSyncProvider$register$2(null));
        AgentFileSyncBridge.g(new p9.r() { // from class: com.stepos.ailauncher.agent.aispace.connect.n
            @Override // p9.r
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return AgentFileSyncProvider.n((Context) obj, (AgentFileSyncBridge.Result) obj2, (String) obj3, (String) obj4);
            }
        });
    }
}
