package com.stepos.ailauncher.task.detail.version;

import La.H;
import Ua.C1060i;
import Ua.M;
import Y8.t;
import Z8.C1172u;
import Z8.C1173v;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import com.stepos.ailauncher.task.detail.RenderLoadingMode;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 =2\u00020\u0001:\u0001>B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0014J \u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u000bH\u0082@¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001bR0\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u00188\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R$\u0010!\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00118\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R6\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\b\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R*\u0010.\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R6\u00104\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\b\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010(\u001a\u0004\b5\u0010*\"\u0004\b6\u0010,R\u0013\u00109\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b7\u00108R\u0016\u0010<\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006?"}, d2 = {"Lcom/stepos/ailauncher/task/detail/version/ArtifactVersions;", "", "LUa/M;", "scope", "<init>", "(LUa/M;)V", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "seed", "LY8/t;", "q", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;)V", "", "seedFileId", "m", "(Ljava/lang/String;)V", "l", "()V", "", "delta", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(I)V", "index", "r", "fileId", "", "k", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "LUa/M;", UxipConstants.f30680s, "versions", "Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ljava/util/List;", "currentIndex", "I", "f", "()I", "Lkotlin/Function2;", "Lcom/stepos/ailauncher/task/detail/RenderLoadingMode;", "onCurrentChanged", "Lp9/p;", "getOnCurrentChanged", "()Lp9/p;", "n", "(Lp9/p;)V", "Lkotlin/Function0;", "onVersionsChanged", "Lp9/a;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Lp9/a;", "p", "(Lp9/a;)V", "onVersionNavigated", "getOnVersionNavigated", "o", "e", "()Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "current", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Ljava/lang/String;", "sessionId", "Companion", Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArtifactVersions {
    private static final String TAG = "ArtifactVersions";
    private int currentIndex;
    private p<? super SessionArtifact, ? super RenderLoadingMode, t> onCurrentChanged;
    private p<? super Integer, ? super Integer, t> onVersionNavigated;
    private InterfaceC5063a<t> onVersionsChanged;
    private final M scope;
    private List<SessionArtifact> versions;

    public ArtifactVersions(M scope) {
        kotlin.jvm.internal.p.i(scope, "scope");
        this.scope = scope;
        this.versions = C1173v.m();
    }

    public final SessionArtifact e() {
        return (SessionArtifact) F.t0(this.versions, this.currentIndex);
    }

    /* renamed from: f, reason: from getter */
    public final int getCurrentIndex() {
        return this.currentIndex;
    }

    public final InterfaceC5063a<t> g() {
        return this.onVersionsChanged;
    }

    public final String h() {
        String sessionId;
        SessionArtifact sessionArtifactE = e();
        if (sessionArtifactE == null || (sessionId = sessionArtifactE.getSessionId()) == null || sessionId.length() <= 0) {
            return null;
        }
        return sessionId;
    }

    public final List<SessionArtifact> i() {
        return this.versions;
    }

    public final void j(int delta) {
        int iN;
        int i10;
        if (this.versions.isEmpty() || (iN = C5685n.n(this.currentIndex + delta, 0, C1173v.o(this.versions))) == (i10 = this.currentIndex)) {
            return;
        }
        p<? super Integer, ? super Integer, t> pVar = this.onVersionNavigated;
        if (pVar != null) {
            pVar.invoke(Integer.valueOf(i10), Integer.valueOf(iN));
        }
        r(iN);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(java.lang.String r13, e9.InterfaceC4014c<? super java.util.List<com.stepos.ailauncher.contract.model.SessionArtifact>> r14) throws java.lang.Throwable {
        /*
            r12 = this;
            boolean r0 = r14 instanceof com.stepos.ailauncher.task.detail.version.ArtifactVersions$queryGroup$1
            if (r0 == 0) goto L13
            r0 = r14
            com.stepos.ailauncher.task.detail.version.ArtifactVersions$queryGroup$1 r0 = (com.stepos.ailauncher.task.detail.version.ArtifactVersions$queryGroup$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.task.detail.version.ArtifactVersions$queryGroup$1 r0 = new com.stepos.ailauncher.task.detail.version.ArtifactVersions$queryGroup$1
            r0.<init>(r12, r14)
        L18:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L41
            if (r2 != r3) goto L39
            java.lang.Object r12 = r0.L$2
            com.stepos.ailauncher.task.detail.version.ArtifactVersions r12 = (com.stepos.ailauncher.task.detail.version.ArtifactVersions) r12
            java.lang.Object r12 = r0.L$1
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r13 = r0.L$0
            java.lang.String r13 = (java.lang.String) r13
            kotlin.C4849c.b(r14)     // Catch: java.lang.Throwable -> L36
            goto L6c
        L36:
            r0 = move-exception
            r14 = r0
            goto L78
        L39:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L41:
            kotlin.C4849c.b(r14)
            java.lang.String r14 = r12.h()
            if (r14 != 0) goto L4b
            return r4
        L4b:
            kotlin.Result$a r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L73
            com.stepos.ailauncher.foundation.task.TaskModule r2 = com.stepos.ailauncher.foundation.task.TaskModule.INSTANCE     // Catch: java.lang.Throwable -> L73
            java.util.List r5 = Z8.C1172u.e(r14)     // Catch: java.lang.Throwable -> L73
            r0.L$0 = r13     // Catch: java.lang.Throwable -> L73
            r0.L$1 = r14     // Catch: java.lang.Throwable -> L73
            java.lang.Object r12 = g9.h.a(r12)     // Catch: java.lang.Throwable -> L73
            r0.L$2 = r12     // Catch: java.lang.Throwable -> L73
            r12 = 0
            r0.I$0 = r12     // Catch: java.lang.Throwable -> L73
            r0.label = r3     // Catch: java.lang.Throwable -> L73
            java.lang.Object r12 = r2.e(r5, r0)     // Catch: java.lang.Throwable -> L73
            if (r12 != r1) goto L69
            return r1
        L69:
            r11 = r14
            r14 = r12
            r12 = r11
        L6c:
            java.util.List r14 = (java.util.List) r14     // Catch: java.lang.Throwable -> L36
            java.lang.Object r14 = kotlin.Result.b(r14)     // Catch: java.lang.Throwable -> L36
            goto L82
        L73:
            r0 = move-exception
            r12 = r0
            r11 = r14
            r14 = r12
            r12 = r11
        L78:
            kotlin.Result$a r0 = kotlin.Result.INSTANCE
            java.lang.Object r14 = kotlin.C4849c.a(r14)
            java.lang.Object r14 = kotlin.Result.b(r14)
        L82:
            java.lang.Throwable r7 = kotlin.Result.e(r14)
            if (r7 == 0) goto La3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "queryGroup failed sessionId="
            r0.append(r1)
            r0.append(r12)
            java.lang.String r6 = r0.toString()
            r9 = 8
            r10 = 0
            java.lang.String r5 = "ArtifactVersions"
            r8 = 0
            h8.C4148a.t(r5, r6, r7, r8, r9, r10)
        La3:
            boolean r12 = kotlin.Result.g(r14)
            if (r12 == 0) goto Laa
            r14 = r4
        Laa:
            java.util.List r14 = (java.util.List) r14
            if (r14 == 0) goto Lb2
            java.util.List r4 = com.stepos.ailauncher.contract.model.SessionArtifactKt.versionGroupOf(r14, r13)
        Lb2:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.detail.version.ArtifactVersions.k(java.lang.String, e9.c):java.lang.Object");
    }

    public final void l() {
        String fileId;
        SessionArtifact sessionArtifactE = e();
        if (sessionArtifactE == null || (fileId = sessionArtifactE.getFileId()) == null) {
            return;
        }
        if (H.x0(fileId)) {
            fileId = null;
        }
        if (fileId == null) {
            return;
        }
        C1060i.d(this.scope, null, null, new ArtifactVersions$refreshAfterRound$1(this, fileId, null), 3, null);
    }

    public final void m(String seedFileId) {
        if (seedFileId != null) {
            if (H.x0(seedFileId)) {
                seedFileId = null;
            }
            if (seedFileId == null) {
                return;
            }
            C1060i.d(this.scope, null, null, new ArtifactVersions$resolveGroup$1(this, seedFileId, null), 3, null);
        }
    }

    public final void n(p<? super SessionArtifact, ? super RenderLoadingMode, t> pVar) {
        this.onCurrentChanged = pVar;
    }

    public final void o(p<? super Integer, ? super Integer, t> pVar) {
        this.onVersionNavigated = pVar;
    }

    public final void p(InterfaceC5063a<t> interfaceC5063a) {
        this.onVersionsChanged = interfaceC5063a;
    }

    public final void q(SessionArtifact seed) {
        kotlin.jvm.internal.p.i(seed, "seed");
        this.versions = C1172u.e(seed);
        this.currentIndex = 0;
        p<? super SessionArtifact, ? super RenderLoadingMode, t> pVar = this.onCurrentChanged;
        if (pVar != null) {
            pVar.invoke(seed, RenderLoadingMode.INITIAL);
        }
    }

    public final void r(int index) {
        p<? super SessionArtifact, ? super RenderLoadingMode, t> pVar;
        this.currentIndex = index;
        SessionArtifact sessionArtifact = (SessionArtifact) F.t0(this.versions, index);
        if (sessionArtifact == null || (pVar = this.onCurrentChanged) == null) {
            return;
        }
        pVar.invoke(sessionArtifact, RenderLoadingMode.VERSION_SWITCH);
    }
}
