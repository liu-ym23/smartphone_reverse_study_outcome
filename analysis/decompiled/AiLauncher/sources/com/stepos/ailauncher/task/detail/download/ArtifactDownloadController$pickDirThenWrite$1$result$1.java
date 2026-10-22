package com.stepos.ailauncher.task.detail.download;

import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import i6.C4171a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Li6/a$a;", "it", "", "<anonymous>", "(Li6/a$a;)Z"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.detail.download.ArtifactDownloadController$pickDirThenWrite$1$result$1", f = "ArtifactDownloadController.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ArtifactDownloadController$pickDirThenWrite$1$result$1 extends SuspendLambda implements p9.p<C4171a.RelayResult, InterfaceC4014c<? super Boolean>, Object> {
    final /* synthetic */ String $token;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactDownloadController$pickDirThenWrite$1$result$1(String str, InterfaceC4014c<? super ArtifactDownloadController$pickDirThenWrite$1$result$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$token = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ArtifactDownloadController$pickDirThenWrite$1$result$1 artifactDownloadController$pickDirThenWrite$1$result$1 = new ArtifactDownloadController$pickDirThenWrite$1$result$1(this.$token, interfaceC4014c);
        artifactDownloadController$pickDirThenWrite$1$result$1.L$0 = obj;
        return artifactDownloadController$pickDirThenWrite$1$result$1;
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(C4171a.RelayResult relayResult, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((ArtifactDownloadController$pickDirThenWrite$1$result$1) create(relayResult, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4171a.RelayResult relayResult = (C4171a.RelayResult) this.L$0;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        return C4109a.a(kotlin.jvm.internal.p.d(relayResult.getToken(), this.$token));
    }
}
