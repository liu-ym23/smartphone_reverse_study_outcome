package com.stepos.ailauncher.agent.aispace.skill.feishu;

import Z8.C1173v;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectActivity$renderConnected$1", f = "FeishuConnectActivity.kt", l = {1091}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class FeishuConnectActivity$renderConnected$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ FeishuConnectActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeishuConnectActivity$renderConnected$1(FeishuConnectActivity feishuConnectActivity, InterfaceC4014c<? super FeishuConnectActivity$renderConnected$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = feishuConnectActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        FeishuConnectActivity$renderConnected$1 feishuConnectActivity$renderConnected$1 = new FeishuConnectActivity$renderConnected$1(this.this$0, interfaceC4014c);
        feishuConnectActivity$renderConnected$1.L$0 = obj;
        return feishuConnectActivity$renderConnected$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((FeishuConnectActivity$renderConnected$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        Ua.M m10 = (Ua.M) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                FeishuConnectActivity feishuConnectActivity = this.this$0;
                Result.Companion companion = Result.INSTANCE;
                h0 h0VarN0 = feishuConnectActivity.n0();
                this.L$0 = g9.h.a(m10);
                this.L$1 = g9.h.a(m10);
                this.I$0 = 0;
                this.label = 1;
                obj = h0VarN0.d(this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            objB = Result.b((List) obj);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        List listM = C1173v.m();
        if (Result.g(objB)) {
            objB = listM;
        }
        this.this$0.recommendedAdapter.f((List) objB);
        return Y8.t.f7040a;
    }
}
