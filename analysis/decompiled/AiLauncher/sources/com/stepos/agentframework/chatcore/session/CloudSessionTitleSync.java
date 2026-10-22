package com.stepos.agentframework.chatcore.session;

import Ua.C1060i;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.adapter.netcore.SessionUpdate;
import com.stepos.agentframework.adapter.netcore.w;
import kotlin.Metadata;
import kotlinx.coroutines.JobKt__JobKt;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0082@¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/CloudSessionTitleSync;", "", "Lx4/e;", "repository", "Lkotlin/Function1;", "Lw4/e;", "LY8/t;", "onTitleApplied", "<init>", "(Lx4/e;Lp9/l;)V", Const.INTENT_KEY_UMID, "()V", "f", "Lcom/stepos/agentframework/adapter/netcore/v;", "event", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/agentframework/adapter/netcore/v;)V", "", "sessionId", "label", "c", "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Lx4/e;", "Lp9/l;", "LUa/M;", "scope", "LUa/M;", "Companion", Const.INTENT_KEY_APIKEY, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CloudSessionTitleSync {
    private static final a Companion = new a(null);

    @Deprecated
    public static final int MAX_ATTEMPTS = 4;

    @Deprecated
    public static final long RETRY_DELAY_MS = 500;

    @Deprecated
    public static final String TAG = "CloudSessionTitleSync";
    private final InterfaceC5074l<w4.e, Y8.t> onTitleApplied;
    private final x4.e repository;
    private final Ua.M scope;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/CloudSessionTitleSync$a;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "", "MAX_ATTEMPTS", "I", "", "RETRY_DELAY_MS", "J", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CloudSessionTitleSync(x4.e repository, InterfaceC5074l<? super w4.e, Y8.t> onTitleApplied) {
        kotlin.jvm.internal.p.i(repository, "repository");
        kotlin.jvm.internal.p.i(onTitleApplied, "onTitleApplied");
        this.repository = repository;
        this.onTitleApplied = onTitleApplied;
        this.scope = kotlinx.coroutines.d.a(Ua.L0.b(null, 1, null).plus(Ua.Y.b()));
    }

    public static final void e(CloudSessionTitleSync cloudSessionTitleSync, SessionUpdate it) {
        kotlin.jvm.internal.p.i(it, "it");
        cloudSessionTitleSync.g(it);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0050 -> B:45:0x0073). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0069 -> B:21:0x006e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(java.lang.String r13, java.lang.String r14, e9.InterfaceC4014c<? super Y8.t> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.CloudSessionTitleSync.c(java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    public final void d() {
        com.stepos.agentframework.adapter.netcore.w.b(this, new w.a() { // from class: com.stepos.agentframework.chatcore.session.L
            @Override // com.stepos.agentframework.adapter.netcore.w.a
            public final void a(SessionUpdate sessionUpdate) {
                CloudSessionTitleSync.e(this.f22468a, sessionUpdate);
            }
        });
    }

    public final void f() {
        com.stepos.agentframework.adapter.netcore.w.c(this);
        JobKt__JobKt.j(this.scope.getCoroutineContext(), null, 1, null);
    }

    public final void g(SessionUpdate event) {
        String string = La.H.D1(event.getSessionId()).toString();
        String string2 = La.H.D1(event.getLabel()).toString();
        if (string.length() == 0 || string2.length() == 0) {
            return;
        }
        C1060i.d(this.scope, null, null, new CloudSessionTitleSync$onSessionUpdate$1(this, string, string2, null), 3, null);
    }
}
