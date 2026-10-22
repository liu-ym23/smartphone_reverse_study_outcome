package com.stepos.agentframework.chatcore.agents;

import Ua.M;
import com.stepos.agentframework.chatcore.file.FileInfo;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import n4.AbstractC4939a;
import t4.InterfaceC5507a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.agents.ThirdPartClient$uploadFile$2$1", f = "ThirdPartClient.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class ThirdPartClient$uploadFile$2$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ FileInfo $fileInfo;
    final /* synthetic */ InterfaceC5507a $listener;
    final /* synthetic */ AbstractC4939a $status;
    int label;
    final /* synthetic */ ThirdPartClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThirdPartClient$uploadFile$2$1(ThirdPartClient thirdPartClient, AbstractC4939a abstractC4939a, InterfaceC5507a interfaceC5507a, FileInfo fileInfo, InterfaceC4014c<? super ThirdPartClient$uploadFile$2$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = thirdPartClient;
        this.$status = abstractC4939a;
        this.$listener = interfaceC5507a;
        this.$fileInfo = fileInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ThirdPartClient$uploadFile$2$1(this.this$0, this.$status, this.$listener, this.$fileInfo, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ThirdPartClient$uploadFile$2$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        C4148a.d(this.this$0.getTAG(), "upload progress: " + ((AbstractC4939a.Progress) this.$status).getPercent(), false, 4, null);
        this.$listener.a(this.$fileInfo, ((AbstractC4939a.Progress) this.$status).getPercent());
        return Y8.t.f7040a;
    }
}
