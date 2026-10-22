package com.stepos.ailauncher.task.detail.download;

import Ua.M;
import Y8.t;
import android.widget.Toast;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import com.stepos.ailauncher.task.R$string;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.detail.download.ArtifactDownloadController$runDownload$1", f = "ArtifactDownloadController.kt", l = {404, 424}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ArtifactDownloadController$runDownload$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ SessionArtifact $artifact;
    final /* synthetic */ InterfaceC5063a<t> $onFailure;
    final /* synthetic */ InterfaceC5063a<t> $onSuccess;
    final /* synthetic */ boolean $silentSuccessToast;
    final /* synthetic */ InterfaceC5063a<t> $write;
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ ArtifactDownloadController this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.task.detail.download.ArtifactDownloadController$runDownload$1$1", f = "ArtifactDownloadController.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.task.detail.download.ArtifactDownloadController$runDownload$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ SessionArtifact $artifact;
        final /* synthetic */ InterfaceC5063a<t> $onSuccess;
        final /* synthetic */ boolean $silentSuccessToast;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ArtifactDownloadController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ArtifactDownloadController artifactDownloadController, SessionArtifact sessionArtifact, boolean z10, InterfaceC5063a<t> interfaceC5063a, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = artifactDownloadController;
            this.$artifact = sessionArtifact;
            this.$silentSuccessToast = z10;
            this.$onSuccess = interfaceC5063a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$artifact, this.$silentSuccessToast, this.$onSuccess, interfaceC4014c);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objB;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!this.this$0.fragment.isAdded()) {
                return t.f7040a;
            }
            this.this$0.onDownloadingChanged.invoke(C4109a.a(false));
            M5.c cVar = M5.c.INSTANCE;
            SessionArtifact sessionArtifact = this.$artifact;
            String sessionId = sessionArtifact.getSessionId();
            M5.c.o(cVar, sessionArtifact, (sessionId == null || sessionId.length() <= 0) ? null : sessionId, "success", null, null, 24, null);
            InterfaceC5063a<t> interfaceC5063a = this.$onSuccess;
            try {
                Result.Companion companion = Result.INSTANCE;
                interfaceC5063a.invoke();
                objB = Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.t("ArtifactDownload", "post-save UI failed", thE, false, 8, null);
            }
            if (!this.$silentSuccessToast) {
                Toast.makeText(this.this$0.F(), R$string.task_detail_download_complete, 0).show();
            }
            return t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactDownloadController$runDownload$1(InterfaceC5063a<t> interfaceC5063a, ArtifactDownloadController artifactDownloadController, InterfaceC5063a<t> interfaceC5063a2, SessionArtifact sessionArtifact, boolean z10, InterfaceC5063a<t> interfaceC5063a3, InterfaceC4014c<? super ArtifactDownloadController$runDownload$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$write = interfaceC5063a;
        this.this$0 = artifactDownloadController;
        this.$onFailure = interfaceC5063a2;
        this.$artifact = sessionArtifact;
        this.$silentSuccessToast = z10;
        this.$onSuccess = interfaceC5063a3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ArtifactDownloadController$runDownload$1(this.$write, this.this$0, this.$onFailure, this.$artifact, this.$silentSuccessToast, this.$onSuccess, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((ArtifactDownloadController$runDownload$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0089, code lost:
    
        if (Ua.C1056g.j(r13, r5, r12) == r1) goto L22;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            r12 = this;
            java.lang.Object r1 = f9.C4063a.g()
            int r0 = r12.label
            r2 = 0
            r3 = 0
            r4 = 2
            r5 = 1
            if (r0 == 0) goto L25
            if (r0 == r5) goto L1d
            if (r0 != r4) goto L15
            kotlin.C4849c.b(r13)
            goto L8c
        L15:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L1d:
            java.lang.Object r0 = r12.L$0
            java.lang.Exception r0 = (java.lang.Exception) r0
            kotlin.C4849c.b(r13)
            goto L68
        L25:
            kotlin.C4849c.b(r13)
            p9.a<Y8.t> r13 = r12.$write     // Catch: java.lang.Exception -> L2f
            r13.invoke()     // Catch: java.lang.Exception -> L2f
            r3 = r5
            goto L68
        L2f:
            r0 = move-exception
            r13 = r0
            r10 = r13
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = "download failed e="
            r13.append(r0)
            r13.append(r10)
            java.lang.String r13 = r13.toString()
            r0 = 4
            java.lang.String r6 = "ArtifactDownload"
            h8.C4148a.u(r6, r13, r3, r0, r2)
            Ua.A0 r13 = Ua.Y.c()
            com.stepos.ailauncher.task.detail.download.ArtifactDownloadController$runDownload$1$ok$1 r6 = new com.stepos.ailauncher.task.detail.download.ArtifactDownloadController$runDownload$1$ok$1
            com.stepos.ailauncher.task.detail.download.ArtifactDownloadController r7 = r12.this$0
            p9.a<Y8.t> r8 = r12.$onFailure
            com.stepos.ailauncher.contract.model.SessionArtifact r9 = r12.$artifact
            r11 = 0
            r6.<init>(r7, r8, r9, r10, r11)
            java.lang.Object r0 = g9.h.a(r10)
            r12.L$0 = r0
            r12.label = r5
            java.lang.Object r13 = Ua.C1056g.j(r13, r6, r12)
            if (r13 != r1) goto L68
            goto L8b
        L68:
            if (r3 != 0) goto L6d
            Y8.t r12 = Y8.t.f7040a
            return r12
        L6d:
            Ua.A0 r13 = Ua.Y.c()
            com.stepos.ailauncher.task.detail.download.ArtifactDownloadController$runDownload$1$1 r5 = new com.stepos.ailauncher.task.detail.download.ArtifactDownloadController$runDownload$1$1
            com.stepos.ailauncher.task.detail.download.ArtifactDownloadController r6 = r12.this$0
            com.stepos.ailauncher.contract.model.SessionArtifact r7 = r12.$artifact
            boolean r8 = r12.$silentSuccessToast
            p9.a<Y8.t> r9 = r12.$onSuccess
            r10 = 0
            r5.<init>(r6, r7, r8, r9, r10)
            r12.L$0 = r2
            r12.I$0 = r3
            r12.label = r4
            java.lang.Object r12 = Ua.C1056g.j(r13, r5, r12)
            if (r12 != r1) goto L8c
        L8b:
            return r1
        L8c:
            Y8.t r12 = Y8.t.f7040a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.detail.download.ArtifactDownloadController$runDownload$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
