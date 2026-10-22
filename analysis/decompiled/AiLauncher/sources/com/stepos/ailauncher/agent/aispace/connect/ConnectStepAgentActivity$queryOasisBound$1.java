package com.stepos.ailauncher.agent.aispace.connect;

import Ua.C1056g;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.aispace.connect.ConnectStepAgentActivity$queryOasisBound$1;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import org.json.JSONObject;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.connect.ConnectStepAgentActivity$queryOasisBound$1", f = "ConnectStepAgentActivity.kt", l = {170}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ConnectStepAgentActivity$queryOasisBound$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ InterfaceC5074l<Boolean, Y8.t> $onBound;
    final /* synthetic */ p9.p<Integer, String, Y8.t> $onError;
    int label;
    final /* synthetic */ ConnectStepAgentActivity this$0;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/stepos/ailauncher/agent/aispace/connect/ConnectStepAgentActivity$queryOasisBound$1$a", "Lcom/stepos/ailauncher/foundation/account/k;", "Lorg/json/JSONObject;", "result", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lorg/json/JSONObject;)V", "", "code", "", C3081a.ERROR_MSG, "onFailed", "(ILjava/lang/String;)V", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements com.stepos.ailauncher.foundation.account.k {
        final /* synthetic */ InterfaceC5074l<Boolean, Y8.t> $onBound;
        final /* synthetic */ p9.p<Integer, String, Y8.t> $onError;
        final /* synthetic */ ConnectStepAgentActivity this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public a(ConnectStepAgentActivity connectStepAgentActivity, InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l, p9.p<? super Integer, ? super String, Y8.t> pVar) {
            this.this$0 = connectStepAgentActivity;
            this.$onBound = interfaceC5074l;
            this.$onError = pVar;
        }

        public static final void d(ConnectStepAgentActivity connectStepAgentActivity, p9.p pVar, int i10, String str) {
            if (connectStepAgentActivity.isFinishing() || connectStepAgentActivity.isDestroyed() || pVar == null) {
                return;
            }
            pVar.invoke(Integer.valueOf(i10), str);
        }

        public static final void e(ConnectStepAgentActivity connectStepAgentActivity, InterfaceC5074l interfaceC5074l, JSONObject jSONObject) {
            if (connectStepAgentActivity.isFinishing() || connectStepAgentActivity.isDestroyed()) {
                return;
            }
            interfaceC5074l.invoke(Boolean.valueOf(com.stepos.ailauncher.foundation.account.h.f(jSONObject)));
        }

        @Override // com.stepos.ailauncher.foundation.account.k
        public void a(final JSONObject result) {
            final ConnectStepAgentActivity connectStepAgentActivity = this.this$0;
            final InterfaceC5074l<Boolean, Y8.t> interfaceC5074l = this.$onBound;
            connectStepAgentActivity.runOnUiThread(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.connect.Y
                @Override // java.lang.Runnable
                public final void run() {
                    ConnectStepAgentActivity$queryOasisBound$1.a.e(connectStepAgentActivity, interfaceC5074l, result);
                }
            });
        }

        @Override // com.stepos.ailauncher.foundation.account.k
        public void onFailed(final int code, final String errorMsg) {
            final ConnectStepAgentActivity connectStepAgentActivity = this.this$0;
            final p9.p<Integer, String, Y8.t> pVar = this.$onError;
            connectStepAgentActivity.runOnUiThread(new Runnable() { // from class: com.stepos.ailauncher.agent.aispace.connect.X
                @Override // java.lang.Runnable
                public final void run() {
                    ConnectStepAgentActivity$queryOasisBound$1.a.d(connectStepAgentActivity, pVar, code, errorMsg);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ConnectStepAgentActivity$queryOasisBound$1(p9.p<? super Integer, ? super String, Y8.t> pVar, ConnectStepAgentActivity connectStepAgentActivity, InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l, InterfaceC4014c<? super ConnectStepAgentActivity$queryOasisBound$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$onError = pVar;
        this.this$0 = connectStepAgentActivity;
        this.$onBound = interfaceC5074l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ConnectStepAgentActivity$queryOasisBound$1(this.$onError, this.this$0, this.$onBound, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ConnectStepAgentActivity$queryOasisBound$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Ua.I iB = Ua.Y.b();
            ConnectStepAgentActivity$queryOasisBound$1$token$1 connectStepAgentActivity$queryOasisBound$1$token$1 = new ConnectStepAgentActivity$queryOasisBound$1$token$1(null);
            this.label = 1;
            obj = C1056g.j(iB, connectStepAgentActivity$queryOasisBound$1$token$1, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        String str = (String) obj;
        if (str != null && str.length() != 0) {
            com.stepos.ailauncher.foundation.account.f.INSTANCE.r(str, new a(this.this$0, this.$onBound, this.$onError));
            return Y8.t.f7040a;
        }
        p9.p<Integer, String, Y8.t> pVar = this.$onError;
        if (pVar != null) {
            pVar.invoke(C4109a.f(-1), "no token");
        }
        return Y8.t.f7040a;
    }
}
