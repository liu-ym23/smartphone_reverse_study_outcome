package com.stepos.ailauncher.task.detail.download;

import Ua.M;
import Y8.t;
import com.stepos.ailauncher.task.detail.DownloadOption;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import i6.C4171a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.detail.download.ArtifactDownloadController$pickDirThenWrite$1", f = "ArtifactDownloadController.kt", l = {199}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ArtifactDownloadController$pickDirThenWrite$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ String $token;
    int label;
    final /* synthetic */ ArtifactDownloadController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactDownloadController$pickDirThenWrite$1(ArtifactDownloadController artifactDownloadController, String str, InterfaceC4014c<? super ArtifactDownloadController$pickDirThenWrite$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = artifactDownloadController;
        this.$token = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ArtifactDownloadController$pickDirThenWrite$1(this.this$0, this.$token, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((ArtifactDownloadController$pickDirThenWrite$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.o<C4171a.RelayResult> oVarB = C4171a.INSTANCE.b();
            ArtifactDownloadController$pickDirThenWrite$1$result$1 artifactDownloadController$pickDirThenWrite$1$result$1 = new ArtifactDownloadController$pickDirThenWrite$1$result$1(this.$token, null);
            this.label = 1;
            obj = Xa.d.z(oVarB, artifactDownloadController$pickDirThenWrite$1$result$1, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        C4171a.RelayResult relayResult = (C4171a.RelayResult) obj;
        DownloadOption downloadOption = this.this$0.pendingOption;
        if (downloadOption == null) {
            return t.f7040a;
        }
        this.this$0.pendingOption = null;
        if (this.this$0.fragment.isAdded()) {
            this.this$0.S(relayResult.getResultCode(), relayResult.getData(), downloadOption);
        }
        return t.f7040a;
    }
}
