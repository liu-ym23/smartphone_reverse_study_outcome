package com.stepos.ailauncher.task.detail.download;

import La.H;
import Ua.M;
import Y8.t;
import android.widget.Toast;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import com.stepos.ailauncher.task.R$string;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import java.io.IOException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.detail.download.ArtifactDownloadController$runDownload$1$ok$1", f = "ArtifactDownloadController.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ArtifactDownloadController$runDownload$1$ok$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ SessionArtifact $artifact;
    final /* synthetic */ Exception $e;
    final /* synthetic */ InterfaceC5063a<t> $onFailure;
    int label;
    final /* synthetic */ ArtifactDownloadController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactDownloadController$runDownload$1$ok$1(ArtifactDownloadController artifactDownloadController, InterfaceC5063a<t> interfaceC5063a, SessionArtifact sessionArtifact, Exception exc, InterfaceC4014c<? super ArtifactDownloadController$runDownload$1$ok$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = artifactDownloadController;
        this.$onFailure = interfaceC5063a;
        this.$artifact = sessionArtifact;
        this.$e = exc;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ArtifactDownloadController$runDownload$1$ok$1(this.this$0, this.$onFailure, this.$artifact, this.$e, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((ArtifactDownloadController$runDownload$1$ok$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String message;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        if (!this.this$0.fragment.isAdded()) {
            return t.f7040a;
        }
        this.this$0.onDownloadingChanged.invoke(C4109a.a(false));
        this.$onFailure.invoke();
        M5.c cVar = M5.c.INSTANCE;
        SessionArtifact sessionArtifact = this.$artifact;
        String sessionId = sessionArtifact.getSessionId();
        M5.c.o(cVar, sessionArtifact, (sessionId == null || sessionId.length() <= 0) ? null : sessionId, "failed", this.this$0.C(this.$e), null, 16, null);
        Exception exc = this.$e;
        Toast.makeText(this.this$0.F(), ((exc instanceof IOException) && (message = exc.getMessage()) != null && H.g0(message, "ENOSPC", false, 2, null)) ? R$string.task_detail_storage_insufficient : R$string.task_detail_download_failed, 0).show();
        return t.f7040a;
    }
}
