package com.stepos.ailauncher.agent.aispace.skill.feishu;

import android.widget.Toast;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectActivity;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.Arrays;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectActivity$goCreateBot$1", f = "FeishuConnectActivity.kt", l = {418}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class FeishuConnectActivity$goCreateBot$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    int label;
    final /* synthetic */ FeishuConnectActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeishuConnectActivity$goCreateBot$1(FeishuConnectActivity feishuConnectActivity, InterfaceC4014c<? super FeishuConnectActivity$goCreateBot$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = feishuConnectActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new FeishuConnectActivity$goCreateBot$1(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((FeishuConnectActivity$goCreateBot$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            h0 h0VarN0 = this.this$0.n0();
            this.label = 1;
            obj = h0VarN0.h(this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        CreateBotLaunch createBotLaunch = (CreateBotLaunch) obj;
        if (createBotLaunch == null || La.H.x0(createBotLaunch.getUrl())) {
            C4148a.u("AILauncher-FeishuConn", "create-bot url not ready, fallback to local progress", false, 4, null);
            this.this$0.n1();
            return Y8.t.f7040a;
        }
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("launch create-bot url=%s", Arrays.copyOf(new Object[]{createBotLaunch.getUrl()}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.d("AILauncher-FeishuConn", str, false, 4, null);
        this.this$0.h1(FeishuConnectActivity.PendingReturn.CREATE_BOT);
        if (!this.this$0.s0(createBotLaunch.getUrl())) {
            this.this$0.h1(FeishuConnectActivity.PendingReturn.NONE);
            C4148a.h("AILauncher-FeishuConn", "open create-bot url failed (no handler)", false, 4, null);
            FeishuConnectActivity feishuConnectActivity = this.this$0;
            Toast.makeText(feishuConnectActivity, feishuConnectActivity.getString(R$string.feishu_cli_toast_open_feishu_failed), 0).show();
        }
        return Y8.t.f7040a;
    }
}
