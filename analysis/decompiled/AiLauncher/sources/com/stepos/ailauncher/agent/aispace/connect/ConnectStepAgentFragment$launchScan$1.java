package com.stepos.ailauncher.agent.aispace.connect;

import android.content.Intent;
import com.stepos.agentframework.adapter.agentbus.bff.ExternalAgent;
import com.stepos.ailauncher.agent.R$string;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import i6.C4171a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.connect.ConnectStepAgentFragment$launchScan$1", f = "ConnectStepAgentFragment.kt", l = {60}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ConnectStepAgentFragment$launchScan$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $token;
    int label;
    final /* synthetic */ ConnectStepAgentFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectStepAgentFragment$launchScan$1(ConnectStepAgentFragment connectStepAgentFragment, String str, InterfaceC4014c<? super ConnectStepAgentFragment$launchScan$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = connectStepAgentFragment;
        this.$token = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ConnectStepAgentFragment$launchScan$1(this.this$0, this.$token, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ConnectStepAgentFragment$launchScan$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String stringExtra;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.o<C4171a.RelayResult> oVarB = C4171a.INSTANCE.b();
            ConnectStepAgentFragment$launchScan$1$result$1 connectStepAgentFragment$launchScan$1$result$1 = new ConnectStepAgentFragment$launchScan$1$result$1(this.$token, null);
            this.label = 1;
            obj = Xa.d.z(oVarB, connectStepAgentFragment$launchScan$1$result$1, this);
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
        if (!this.this$0.isAdded() || relayResult.getResultCode() != -1) {
            return Y8.t.f7040a;
        }
        Intent data = relayResult.getData();
        boolean z10 = data != null && data.getBooleanExtra(ScanQrActivity.EXTRA_ALREADY_CONFIRMED, false);
        Intent data2 = relayResult.getData();
        String stringExtra2 = data2 != null ? data2.getStringExtra(ScanQrActivity.EXTRA_DEVICE_NAME) : null;
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        if (!z10) {
            Intent data3 = relayResult.getData();
            stringExtra = data3 != null ? data3.getStringExtra(ScanQrActivity.EXTRA_DEVICE_TOKEN) : null;
            String str = stringExtra != null ? stringExtra : "";
            if (str.length() > 0) {
                this.this$0.P(str);
            }
            return Y8.t.f7040a;
        }
        ConnectStepAgentFragment connectStepAgentFragment = this.this$0;
        String string = connectStepAgentFragment.getString(R$string.connect_bind_success_toast, La.H.x0(stringExtra2) ? "阶跃 AI" : stringExtra2);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        connectStepAgentFragment.j0(string);
        Intent data4 = relayResult.getData();
        stringExtra = data4 != null ? data4.getStringExtra(ScanQrActivity.EXTRA_DEVICE_ID) : null;
        this.this$0.b0(stringExtra != null ? stringExtra : "", ExternalAgent.STEPAI.getId(), stringExtra2);
        return Y8.t.f7040a;
    }
}
