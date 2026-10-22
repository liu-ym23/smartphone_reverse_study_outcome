package com.stepos.ailauncher.task.space;

import Ua.C1056g;
import Z8.C1172u;
import com.stepos.ailauncher.oobe.api.BotMsgApi;
import com.stepos.ailauncher.oobe.api.RestoreWorkspaceMdParams;
import com.stepos.ailauncher.oobe.api.RestoreWorkspaceMdResponse;
import com.stepos.net.HttpManager;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.space.AgentFileEditActivity$restoreDefault$1", f = "AgentFileEditActivity.kt", l = {236}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentFileEditActivity$restoreDefault$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $fileName;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AgentFileEditActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentFileEditActivity$restoreDefault$1(String str, AgentFileEditActivity agentFileEditActivity, InterfaceC4014c<? super AgentFileEditActivity$restoreDefault$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$fileName = str;
        this.this$0 = agentFileEditActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentFileEditActivity$restoreDefault$1(this.$fileName, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentFileEditActivity$restoreDefault$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objJ;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            try {
                if (i10 == 0) {
                    C4849c.b(obj);
                    BotMsgApi botMsgApi = (BotMsgApi) HttpManager.INSTANCE.create(BotMsgApi.class, "botMsg");
                    RestoreWorkspaceMdParams restoreWorkspaceMdParams = new RestoreWorkspaceMdParams(C1172u.e(this.$fileName));
                    kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
                    String str = String.format("RestoreWorkspaceMd request: files=%s", Arrays.copyOf(new Object[]{restoreWorkspaceMdParams.getFiles()}, 1));
                    kotlin.jvm.internal.p.h(str, "format(...)");
                    C4148a.d("AILauncher-FileEdit", str, false, 4, null);
                    Ua.I iB = Ua.Y.b();
                    AgentFileEditActivity$restoreDefault$1$response$1 agentFileEditActivity$restoreDefault$1$response$1 = new AgentFileEditActivity$restoreDefault$1$response$1(botMsgApi, restoreWorkspaceMdParams, null);
                    this.L$0 = g9.h.a(botMsgApi);
                    this.L$1 = g9.h.a(restoreWorkspaceMdParams);
                    this.label = 1;
                    objJ = C1056g.j(iB, agentFileEditActivity$restoreDefault$1$response$1, this);
                    if (objJ == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C4849c.b(obj);
                    objJ = obj;
                }
                RestoreWorkspaceMdResponse restoreWorkspaceMdResponse = (RestoreWorkspaceMdResponse) objJ;
                kotlin.jvm.internal.y yVar2 = kotlin.jvm.internal.y.f34840a;
                Integer numF = C4109a.f(restoreWorkspaceMdResponse.getBiz_code());
                String status = restoreWorkspaceMdResponse.getStatus();
                String str2 = "";
                if (status == null) {
                    status = "";
                }
                String message = restoreWorkspaceMdResponse.getMessage();
                if (message == null) {
                    message = "";
                }
                String trace_id = restoreWorkspaceMdResponse.getTrace_id();
                if (trace_id == null) {
                    trace_id = "";
                }
                String str3 = String.format("RestoreWorkspaceMd response: biz_code=%d, status=%s, message=%s, trace_id=%s", Arrays.copyOf(new Object[]{numF, status, message, trace_id}, 4));
                kotlin.jvm.internal.p.h(str3, "format(...)");
                C4148a.d("AILauncher-FileEdit", str3, false, 4, null);
                if (restoreWorkspaceMdResponse.isSuccess()) {
                    String status2 = restoreWorkspaceMdResponse.getStatus();
                    if (status2 == null) {
                        this.this$0.n0("已恢复默认");
                    } else {
                        int iHashCode = status2.hashCode();
                        if (iHashCode != -1926625232) {
                            if (iHashCode != -1212540263) {
                                if (iHashCode == -793235331 && status2.equals("applied")) {
                                    this.this$0.V();
                                    this.this$0.n0("已恢复默认");
                                } else {
                                    this.this$0.n0("已恢复默认");
                                }
                            } else if (status2.equals("dispatched")) {
                                this.this$0.n0("文件恢复已下发，请稍后刷新查看");
                            } else {
                                this.this$0.n0("已恢复默认");
                            }
                        } else if (status2.equals("persona_failed")) {
                            this.this$0.V();
                            AgentFileEditActivity agentFileEditActivity = this.this$0;
                            String message2 = restoreWorkspaceMdResponse.getMessage();
                            if (message2 != null) {
                                str2 = message2;
                            }
                            agentFileEditActivity.n0("文件已恢复；" + str2);
                        } else {
                            this.this$0.n0("已恢复默认");
                        }
                    }
                } else {
                    String str4 = String.format("RestoreWorkspaceMd biz error: biz_code=%d, msg=%s", Arrays.copyOf(new Object[]{C4109a.f(restoreWorkspaceMdResponse.getBiz_code()), restoreWorkspaceMdResponse.getMessage()}, 2));
                    kotlin.jvm.internal.p.h(str4, "format(...)");
                    C4148a.u("AILauncher-FileEdit", str4, false, 4, null);
                    AgentFileEditActivity agentFileEditActivity2 = this.this$0;
                    String message3 = restoreWorkspaceMdResponse.getMessage();
                    if (message3 == null) {
                        message3 = "恢复默认失败";
                    }
                    agentFileEditActivity2.n0(message3);
                }
            } catch (CancellationException e10) {
                C4148a.d("AILauncher-FileEdit", "RestoreWorkspaceMd cancelled", false, 4, null);
                throw e10;
            } catch (Exception e11) {
                C4148a.g("AILauncher-FileEdit", "RestoreWorkspaceMd exception", e11, false, 8, null);
                this.this$0.n0("恢复默认失败");
            }
            return Y8.t.f7040a;
        } finally {
            this.this$0.c0(false);
        }
    }
}
