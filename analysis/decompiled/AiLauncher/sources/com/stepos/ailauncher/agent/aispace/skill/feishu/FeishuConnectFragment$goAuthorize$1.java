package com.stepos.ailauncher.agent.aispace.skill.feishu;

import android.widget.Toast;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectFragment;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.Arrays;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectFragment$goAuthorize$1", f = "FeishuConnectFragment.kt", l = {502}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class FeishuConnectFragment$goAuthorize$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ FeishuConnectFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeishuConnectFragment$goAuthorize$1(FeishuConnectFragment feishuConnectFragment, InterfaceC4014c<? super FeishuConnectFragment$goAuthorize$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = feishuConnectFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        FeishuConnectFragment$goAuthorize$1 feishuConnectFragment$goAuthorize$1 = new FeishuConnectFragment$goAuthorize$1(this.this$0, interfaceC4014c);
        feishuConnectFragment$goAuthorize$1.L$0 = obj;
        return feishuConnectFragment$goAuthorize$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((FeishuConnectFragment$goAuthorize$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
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
                FeishuConnectFragment feishuConnectFragment = this.this$0;
                Result.Companion companion = Result.INSTANCE;
                h0 h0VarV0 = feishuConnectFragment.v0();
                this.L$0 = g9.h.a(m10);
                this.L$1 = g9.h.a(m10);
                this.I$0 = 0;
                this.label = 1;
                obj = h0VarV0.b(this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            objB = Result.b((AuthorizeLaunch) obj);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        AuthorizeLaunch authorizeLaunch = (AuthorizeLaunch) objB;
        if (authorizeLaunch == null || La.H.x0(authorizeLaunch.getUrl())) {
            C4148a.u("AILauncher-FeishuConn", "authorize url not ready, fallback to local poll", false, 4, null);
            this.this$0.s1();
            return Y8.t.f7040a;
        }
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("launch authorize url=%s", Arrays.copyOf(new Object[]{authorizeLaunch.getUrl()}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d("AILauncher-FeishuConn", str, false, 4, null);
        this.this$0.p1(FeishuConnectFragment.PendingReturn.AUTHORIZE);
        if (this.this$0.B0(authorizeLaunch.getUrl())) {
            return Y8.t.f7040a;
        }
        this.this$0.p1(FeishuConnectFragment.PendingReturn.NONE);
        C4148a.h("AILauncher-FeishuConn", "open authorize url failed (no handler)", false, 4, null);
        Toast.makeText(this.this$0.requireContext(), this.this$0.getString(R$string.feishu_cli_toast_open_authorize_failed), 0).show();
        return Y8.t.f7040a;
    }
}
