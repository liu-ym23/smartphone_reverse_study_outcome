package stepai.aios.guiagent.app;

import H7.c;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowStateInfo;
import j9.m;
import java.util.Map;
import kotlin.Metadata;
import kotlin.b;
import kotlin.collections.a;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.config.GuiAgentConfigKt;
import stepai.aios.guiagent.util.AppErrorType;
import stepai.aios.guiagent.util.AppException;
import stepai.aios.guiexecutor.api.GuiActionExecutor;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jd\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000eH\u0086@¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lstepai/aios/guiagent/app/AppAgentOps;", "", AppAgent.CONSTRUCT, "()V", "", "appOrPackageName", "", "delayMills", "Lstepai/aios/guiexecutor/api/GuiActionExecutor;", "guiActionExecutor", "Lstepai/aios/guiagent/app/AppLauncher;", "appLauncher", "", WindowStateInfo.KEY_DISPLAY_ID, "", "metadata", "Lkotlin/Result;", "launchApp-bMdYcbs", "(Ljava/lang/String;JLstepai/aios/guiexecutor/api/GuiActionExecutor;Lstepai/aios/guiagent/app/AppLauncher;Ljava/lang/Integer;Ljava/util/Map;LH7/c;)Ljava/lang/Object;", "launchApp", "Lstepai/aios/guiagent/app/GuiPathNode;", "node", "isOpenAppNode-IoAF18A", "(Lstepai/aios/guiagent/app/GuiPathNode;)Ljava/lang/Object;", "isOpenAppNode", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AppAgentOps {
    public static final AppAgentOps INSTANCE = new AppAgentOps();

    private AppAgentOps() {
    }

    /* renamed from: launchApp-bMdYcbs$default, reason: not valid java name */
    public static /* synthetic */ Object m7358launchAppbMdYcbs$default(AppAgentOps appAgentOps, String str, long j5, GuiActionExecutor guiActionExecutor, AppLauncher appLauncher, Integer num, Map map, c cVar, int i, Object obj) {
        if ((i & 2) != 0) {
            j5 = 2000;
        }
        return appAgentOps.m7360launchAppbMdYcbs(str, j5, (i & 4) != 0 ? null : guiActionExecutor, (i & 8) != 0 ? null : appLauncher, (i & 16) != 0 ? null : num, (i & 32) != 0 ? a.M() : map, cVar);
    }

    /* renamed from: isOpenAppNode-IoAF18A, reason: not valid java name */
    public final Object m7359isOpenAppNodeIoAF18A(GuiPathNode node) {
        k.f(node, "node");
        if (node.getOpDesc() == null) {
            return b.a(new AppException(AppErrorType.d, null, null, "节点opDesc为空，无法打开应用", 22));
        }
        if (!m.h0(node.getOpDesc(), "打开", false)) {
            return b.a(new AppException(AppErrorType.d, null, null, B7.a.k("节点opDesc不包含'打开'，无法执行打开应用操作: ", node.getOpDesc()), 22));
        }
        Map<String, Object> opParams = node.getOpParams();
        if (opParams == null || opParams.isEmpty()) {
            return b.a(new AppException(AppErrorType.d, null, null, "节点opParams为空，无法获取应用名称", 22));
        }
        String stringParam = PathDataKt.getStringParam(node.getOpParams(), GuiAgentConfigKt.META_KEY_APP_NAME);
        if (stringParam == null) {
            stringParam = PathDataKt.getStringParam(node.getOpParams(), "map_name");
        }
        return (stringParam == null || stringParam.length() == 0) ? b.a(new AppException(AppErrorType.d, null, null, "应用名称为空，无法打开应用", 22)) : stringParam;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: launchApp-bMdYcbs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m7360launchAppbMdYcbs(java.lang.String r5, long r6, stepai.aios.guiexecutor.api.GuiActionExecutor r8, stepai.aios.guiagent.app.AppLauncher r9, java.lang.Integer r10, java.util.Map<java.lang.String, ? extends java.lang.Object> r11, H7.c<? super kotlin.Result<java.lang.String>> r12) {
        /*
            r4 = this;
            boolean r0 = r12 instanceof stepai.aios.guiagent.app.AppAgentOps$launchApp$1
            if (r0 == 0) goto L13
            r0 = r12
            stepai.aios.guiagent.app.AppAgentOps$launchApp$1 r0 = (stepai.aios.guiagent.app.AppAgentOps$launchApp$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            stepai.aios.guiagent.app.AppAgentOps$launchApp$1 r0 = new stepai.aios.guiagent.app.AppAgentOps$launchApp$1
            r0.<init>(r4, r12)
        L18:
            java.lang.Object r4 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r12 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L4e
            if (r1 == r3) goto L26
            if (r1 != r2) goto L46
        L26:
            java.lang.Object r5 = r0.L$5
            stepai.aios.guiagent.app.AppLaunchRequest r5 = (stepai.aios.guiagent.app.AppLaunchRequest) r5
            java.lang.Object r5 = r0.L$4
            java.util.Map r5 = (java.util.Map) r5
            java.lang.Object r5 = r0.L$3
            java.lang.Integer r5 = (java.lang.Integer) r5
            java.lang.Object r5 = r0.L$2
            stepai.aios.guiagent.app.AppLauncher r5 = (stepai.aios.guiagent.app.AppLauncher) r5
            java.lang.Object r5 = r0.L$1
            stepai.aios.guiexecutor.api.GuiActionExecutor r5 = (stepai.aios.guiexecutor.api.GuiActionExecutor) r5
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.b.b(r4)
            kotlin.Result r4 = (kotlin.Result) r4
            java.lang.Object r4 = r4.f4887a
            return r4
        L46:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L4e:
            kotlin.b.b(r4)
            stepai.aios.guiagent.app.AppLaunchRequest r4 = new stepai.aios.guiagent.app.AppLaunchRequest
            r4.<init>(r5, r10, r11)
            r10 = 0
            if (r9 == 0) goto L71
            r0.L$0 = r10
            r0.L$1 = r10
            r0.L$2 = r10
            r0.L$3 = r10
            r0.L$4 = r10
            r0.L$5 = r10
            r0.J$0 = r6
            r0.label = r3
            java.lang.Object r4 = r9.mo7350launchgIAlus(r4, r0)
            if (r4 != r12) goto L70
            goto L8a
        L70:
            return r4
        L71:
            stepai.aios.guiagent.util.a r4 = stepai.aios.guiagent.util.a.f6177a
            r0.L$0 = r10
            r0.L$1 = r10
            r0.L$2 = r10
            r0.L$3 = r10
            r0.L$4 = r10
            r0.L$5 = r10
            r0.J$0 = r6
            r0.label = r2
            r9 = r0
            java.io.Serializable r4 = r4.b(r5, r6, r8, r9)
            if (r4 != r12) goto L8b
        L8a:
            return r12
        L8b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.app.AppAgentOps.m7360launchAppbMdYcbs(java.lang.String, long, stepai.aios.guiexecutor.api.GuiActionExecutor, stepai.aios.guiagent.app.AppLauncher, java.lang.Integer, java.util.Map, H7.c):java.lang.Object");
    }
}
