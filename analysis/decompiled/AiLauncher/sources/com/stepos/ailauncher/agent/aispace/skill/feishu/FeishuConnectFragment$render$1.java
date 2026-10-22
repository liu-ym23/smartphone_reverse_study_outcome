package com.stepos.ailauncher.agent.aispace.skill.feishu;

import com.stepos.ailauncher.agent.aispace.skill.feishu.AbstractC2306b;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectFragment$render$1", f = "FeishuConnectFragment.kt", l = {703}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class FeishuConnectFragment$render$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ AbstractC2306b $targetConnected;
    int label;
    final /* synthetic */ FeishuConnectFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeishuConnectFragment$render$1(FeishuConnectFragment feishuConnectFragment, AbstractC2306b abstractC2306b, InterfaceC4014c<? super FeishuConnectFragment$render$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = feishuConnectFragment;
        this.$targetConnected = abstractC2306b;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new FeishuConnectFragment$render$1(this.this$0, this.$targetConnected, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((FeishuConnectFragment$render$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            this.label = 1;
            if (Ua.U.a(3000L, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        AbstractC2306b state = this.this$0.v0().getState();
        this.this$0.m1(state instanceof AbstractC2306b.Connected ? (AbstractC2306b.Connected) state : (AbstractC2306b.Connected) this.$targetConnected);
        return Y8.t.f7040a;
    }
}
