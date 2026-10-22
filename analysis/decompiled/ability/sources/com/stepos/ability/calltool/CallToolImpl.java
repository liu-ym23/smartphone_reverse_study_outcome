package com.stepos.ability.calltool;

import C7.f;
import L3.c;
import S7.k;
import android.content.Context;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.api.ability.calltool.CallToolRequest;
import com.stepos.ability.api.ability.calltool.ICallTool;
import com.stepos.ability.api.init.IInit;
import com.stepos.ability.appfunctions.JetpackAppFunctionsExt;
import com.stepos.ability.beaninternal.ability.FunctionCallResult;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.calltool.CallToolImpl;
import com.stepos.ability.calltool.handler.b;
import com.stepos.ability.commoninternal.Key;
import com.stepos.ability.commoninternal.SLAScene;
import com.stepos.ability.net.INet;
import com.stepos.ability.report.IReportManager;
import com.stepos.ability.report.event.CallType;
import com.stepos.ability.report.event.ToolCallRequestEvent;
import com.stepos.ability.report.event.ToolCallResponseEvent;
import com.stepos.ability.tracelogger.ITraceLogger;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Singleton
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 O2\u00020\u00012\u00020\u0002:\u0001PB!\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0014\u001a\u00020\u00132\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J?\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJC\u0010#\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001a2\n\u0010\"\u001a\u00060 j\u0002`!H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J2\u0010.\u001a\u00060 j\u0002`!2\u0006\u0010*\u001a\u00020)2\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u001d\u0018\u00010+H\u0096@¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b0\u0010(J\u000f\u00101\u001a\u00020\u001dH\u0016¢\u0006\u0004\b1\u00102R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u00103R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u00104R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u00105R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b&\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010(R\u001b\u0010?\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001b\u0010D\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010<\u001a\u0004\bB\u0010CR\u001b\u0010I\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010<\u001a\u0004\bG\u0010HR\u001b\u0010N\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010<\u001a\u0004\bL\u0010M¨\u0006Q"}, d2 = {"Lcom/stepos/ability/calltool/CallToolImpl;", "Lcom/stepos/ability/api/ability/calltool/ICallTool;", "Lcom/stepos/ability/api/init/IInit;", "Lcom/stepos/ability/net/INet;", "iNet", "Lcom/stepos/ability/report/IReportManager;", "iReportManager", "Lcom/stepos/ability/tracelogger/ITraceLogger;", "traceLogger", AppAgent.CONSTRUCT, "(Lcom/stepos/ability/net/INet;Lcom/stepos/ability/report/IReportManager;Lcom/stepos/ability/tracelogger/ITraceLogger;)V", "", SLAScene.SLA_SCENE, "", "getSlaScene", "(Ljava/lang/String;)I", "", "", "extra", "", "isJetpackAppFunctionExtra", "(Ljava/util/Map;)Z", AgentBusWakeContract.EXTRA_TRACE_ID, Key.KEY_TOOL_CALL_ID, "toolName", "sessionId", "Lcom/stepos/ability/report/event/CallType;", "callType", "input", "LC7/r;", "reportToolCallRequestEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ability/report/event/CallType;Ljava/lang/String;)V", "Lcom/stepos/ability/beaninternal/ability/FunctionCallResult;", "Lcom/stepos/ability/beaninternal/ability/CallToolExeResult;", "result", "reportToolCallResponseEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ability/report/event/CallType;Lcom/stepos/ability/beaninternal/ability/FunctionCallResult;)V", "Landroid/content/Context;", "context", "init", "(Landroid/content/Context;)V", "Lcom/stepos/ability/api/ability/calltool/CallToolRequest;", "request", "Lkotlin/Function1;", "Lcom/stepos/ability/beaninternal/ability/ProgressNotification;", GuiTaskProgressKt.GuiTaskProgress_VALUE_METHOD_ONPRGRESS, "call", "(Lcom/stepos/ability/api/ability/calltool/CallToolRequest;LS7/k;LH7/c;)Ljava/lang/Object;", "setup", "destroy", "()V", "Lcom/stepos/ability/net/INet;", "Lcom/stepos/ability/report/IReportManager;", "Lcom/stepos/ability/tracelogger/ITraceLogger;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "LM3/f;", "mcpCallToolHandler$delegate", "LC7/f;", "getMcpCallToolHandler", "()LM3/f;", "mcpCallToolHandler", "Lcom/stepos/ability/calltool/handler/a;", "appFunctionsCallToolHandler$delegate", "getAppFunctionsCallToolHandler", "()Lcom/stepos/ability/calltool/handler/a;", "appFunctionsCallToolHandler", "Lcom/stepos/ability/calltool/handler/c;", "jetpackAppFunctionsCallToolHandler$delegate", "getJetpackAppFunctionsCallToolHandler", "()Lcom/stepos/ability/calltool/handler/c;", "jetpackAppFunctionsCallToolHandler", "Lcom/stepos/ability/calltool/handler/b;", "cloudCallToolHandler$delegate", "getCloudCallToolHandler", "()Lcom/stepos/ability/calltool/handler/b;", "cloudCallToolHandler", "Companion", "L3/c", "calltool_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CallToolImpl implements ICallTool, IInit {
    public static final c Companion = new c();
    private static final String TAG = "CallToolImpl";

    /* renamed from: appFunctionsCallToolHandler$delegate, reason: from kotlin metadata */
    private final f appFunctionsCallToolHandler;

    /* renamed from: cloudCallToolHandler$delegate, reason: from kotlin metadata */
    private final f cloudCallToolHandler;
    public Context context;
    private final INet iNet;
    private final IReportManager iReportManager;

    /* renamed from: jetpackAppFunctionsCallToolHandler$delegate, reason: from kotlin metadata */
    private final f jetpackAppFunctionsCallToolHandler;

    /* renamed from: mcpCallToolHandler$delegate, reason: from kotlin metadata */
    private final f mcpCallToolHandler;
    private final ITraceLogger traceLogger;

    @J7.c(c = "com.stepos.ability.calltool.CallToolImpl", f = "CallToolImpl.kt", l = {115, 150, 155, 157, 162, 212}, m = "call", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ability.calltool.CallToolImpl$call$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public CallToolRequest f3062a;
        public k b;
        public String c;
        public String d;
        public CallType e;
        public FunctionCallResult f;
        public long g;
        public int h;
        public /* synthetic */ Object i;
        public int k;

        public AnonymousClass1(H7.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.i = obj;
            this.k |= Integer.MIN_VALUE;
            return CallToolImpl.this.call(null, null, this);
        }
    }

    @Inject
    public CallToolImpl(INet iNet, IReportManager iReportManager, ITraceLogger traceLogger) {
        kotlin.jvm.internal.k.f(iNet, "iNet");
        kotlin.jvm.internal.k.f(iReportManager, "iReportManager");
        kotlin.jvm.internal.k.f(traceLogger, "traceLogger");
        this.iNet = iNet;
        this.iReportManager = iReportManager;
        this.traceLogger = traceLogger;
        final int i = 0;
        this.mcpCallToolHandler = a.a(new S7.a(this) { // from class: L3.b
            public final /* synthetic */ CallToolImpl b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                int i6 = i;
                CallToolImpl callToolImpl = this.b;
                switch (i6) {
                    case 0:
                        return CallToolImpl.mcpCallToolHandler_delegate$lambda$0(callToolImpl);
                    case 1:
                        return CallToolImpl.appFunctionsCallToolHandler_delegate$lambda$0(callToolImpl);
                    case 2:
                        return CallToolImpl.jetpackAppFunctionsCallToolHandler_delegate$lambda$0(callToolImpl);
                    default:
                        return CallToolImpl.cloudCallToolHandler_delegate$lambda$0(callToolImpl);
                }
            }
        });
        final int i6 = 1;
        this.appFunctionsCallToolHandler = a.a(new S7.a(this) { // from class: L3.b
            public final /* synthetic */ CallToolImpl b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                int i62 = i6;
                CallToolImpl callToolImpl = this.b;
                switch (i62) {
                    case 0:
                        return CallToolImpl.mcpCallToolHandler_delegate$lambda$0(callToolImpl);
                    case 1:
                        return CallToolImpl.appFunctionsCallToolHandler_delegate$lambda$0(callToolImpl);
                    case 2:
                        return CallToolImpl.jetpackAppFunctionsCallToolHandler_delegate$lambda$0(callToolImpl);
                    default:
                        return CallToolImpl.cloudCallToolHandler_delegate$lambda$0(callToolImpl);
                }
            }
        });
        final int i10 = 2;
        this.jetpackAppFunctionsCallToolHandler = a.a(new S7.a(this) { // from class: L3.b
            public final /* synthetic */ CallToolImpl b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                int i62 = i10;
                CallToolImpl callToolImpl = this.b;
                switch (i62) {
                    case 0:
                        return CallToolImpl.mcpCallToolHandler_delegate$lambda$0(callToolImpl);
                    case 1:
                        return CallToolImpl.appFunctionsCallToolHandler_delegate$lambda$0(callToolImpl);
                    case 2:
                        return CallToolImpl.jetpackAppFunctionsCallToolHandler_delegate$lambda$0(callToolImpl);
                    default:
                        return CallToolImpl.cloudCallToolHandler_delegate$lambda$0(callToolImpl);
                }
            }
        });
        final int i11 = 3;
        this.cloudCallToolHandler = a.a(new S7.a(this) { // from class: L3.b
            public final /* synthetic */ CallToolImpl b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                int i62 = i11;
                CallToolImpl callToolImpl = this.b;
                switch (i62) {
                    case 0:
                        return CallToolImpl.mcpCallToolHandler_delegate$lambda$0(callToolImpl);
                    case 1:
                        return CallToolImpl.appFunctionsCallToolHandler_delegate$lambda$0(callToolImpl);
                    case 2:
                        return CallToolImpl.jetpackAppFunctionsCallToolHandler_delegate$lambda$0(callToolImpl);
                    default:
                        return CallToolImpl.cloudCallToolHandler_delegate$lambda$0(callToolImpl);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.stepos.ability.calltool.handler.a appFunctionsCallToolHandler_delegate$lambda$0(CallToolImpl callToolImpl) {
        return new com.stepos.ability.calltool.handler.a(callToolImpl.getContext(), callToolImpl.iReportManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b cloudCallToolHandler_delegate$lambda$0(CallToolImpl callToolImpl) {
        return new b(callToolImpl.iNet, callToolImpl.iReportManager);
    }

    private final com.stepos.ability.calltool.handler.a getAppFunctionsCallToolHandler() {
        return (com.stepos.ability.calltool.handler.a) this.appFunctionsCallToolHandler.getF4884a();
    }

    private final b getCloudCallToolHandler() {
        return (b) this.cloudCallToolHandler.getF4884a();
    }

    private final com.stepos.ability.calltool.handler.c getJetpackAppFunctionsCallToolHandler() {
        return (com.stepos.ability.calltool.handler.c) this.jetpackAppFunctionsCallToolHandler.getF4884a();
    }

    private final M3.f getMcpCallToolHandler() {
        return (M3.f) this.mcpCallToolHandler.getF4884a();
    }

    private final int getSlaScene(String slaScene) {
        if (slaScene == null) {
            return 0;
        }
        try {
            return Integer.parseInt(slaScene);
        } catch (Exception unused) {
            return 0;
        }
    }

    private final boolean isJetpackAppFunctionExtra(Map<String, ? extends Object> extra) {
        return extra != null && extra.containsKey(JetpackAppFunctionsExt.KEY_VERSION);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.stepos.ability.calltool.handler.c jetpackAppFunctionsCallToolHandler_delegate$lambda$0(CallToolImpl callToolImpl) {
        return new com.stepos.ability.calltool.handler.c(callToolImpl.getContext(), callToolImpl.iReportManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final M3.f mcpCallToolHandler_delegate$lambda$0(CallToolImpl callToolImpl) {
        return new M3.f(callToolImpl.getContext(), callToolImpl.iReportManager);
    }

    private final void reportToolCallRequestEvent(String traceId, String toolCallId, String toolName, String sessionId, CallType callType, String input) {
        this.iReportManager.reportToolCallRequestEvent(new ToolCallRequestEvent(traceId, toolCallId, toolName, toolName, callType, sessionId, input, 0, 128, null));
    }

    private final void reportToolCallResponseEvent(String traceId, String toolCallId, String toolName, String sessionId, CallType callType, FunctionCallResult result) {
        int iIntValue;
        if (result.getSuccess()) {
            iIntValue = 200;
        } else {
            int errorCode = result.getErrorCode();
            Integer numValueOf = Integer.valueOf(errorCode);
            if (errorCode == 0) {
                numValueOf = null;
            }
            iIntValue = numValueOf != null ? numValueOf.intValue() : 500;
        }
        int i = iIntValue;
        String strC = P3.a.c(result);
        if (strC == null) {
            strC = "{}";
        }
        this.iReportManager.reportToolCallResponseEvent(new ToolCallResponseEvent(traceId, toolCallId, toolName, toolName, callType, sessionId, strC, i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x049b  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x05c6  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0613  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x063c  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0672  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0692  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0695  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0698  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x06a4  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x06a7  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x06ce  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0723  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x072f  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0732  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0767  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0788  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0792  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x079c  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x079f  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x07a7  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x07b2  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:208:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0424  */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v21, types: [S7.k, com.stepos.ability.api.ability.calltool.CallToolRequest] */
    /* JADX WARN: Type inference failed for: r14v23 */
    /* JADX WARN: Type inference failed for: r14v24 */
    /* JADX WARN: Type inference failed for: r14v39 */
    @Override // com.stepos.ability.api.ability.calltool.ICallTool
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object call(com.stepos.ability.api.ability.calltool.CallToolRequest r55, S7.k r56, H7.c<? super com.stepos.ability.beaninternal.ability.FunctionCallResult> r57) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 2070
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.calltool.CallToolImpl.call(com.stepos.ability.api.ability.calltool.CallToolRequest, S7.k, H7.c):java.lang.Object");
    }

    @Override // com.stepos.ability.commoninternal.ability.IComponent
    public void destroy() {
    }

    public final Context getContext() {
        Context context = this.context;
        if (context != null) {
            return context;
        }
        kotlin.jvm.internal.k.n("context");
        throw null;
    }

    @Override // com.stepos.ability.api.init.IInit
    public void init(Context context) {
        kotlin.jvm.internal.k.f(context, "context");
        setContext(context);
    }

    public final void setContext(Context context) {
        kotlin.jvm.internal.k.f(context, "<set-?>");
        this.context = context;
    }

    @Override // com.stepos.ability.commoninternal.ability.IComponent
    public void setup(Context context) {
        kotlin.jvm.internal.k.f(context, "context");
    }
}
