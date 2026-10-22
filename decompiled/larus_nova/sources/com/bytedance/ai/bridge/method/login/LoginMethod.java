package com.bytedance.ai.bridge.method.login;

import com.bytedance.ai.applet.granting.GrantingAction;
import com.bytedance.ai.applet.login.CustomLoginNavigator;
import com.bytedance.ai.applet.login.LoginProcessor;
import com.bytedance.ai.applet.login.OperationType;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.login.AbsLoginMethodIDL;
import com.bytedance.ai.bridge.remote.RemoteApiException;
import com.bytedance.ai.bridge.remote.UserAuthService;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import d3.a0;
import java.security.SecureRandom;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\"\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0082@¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ai/bridge/method/login/LoginMethod;", "Lcom/bytedance/ai/bridge/login/AbsLoginMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/login/AbsLoginMethodIDL$LoginRequestModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/login/AbsLoginMethodIDL$LoginResultModel;", "mapLoginFailure", "Lcom/bytedance/ai/monitor/auth/AppletAuthTaskMonitor$FinishInfo;", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errNo", "Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", "defaultScene", "", IFlowAppIntentIDL.PARAM_APPLET_ID, "fetchLoginCode", "timeout", "Lkotlin/time/Duration;", "fetchLoginCode-Kx4hsE0", "(Ljava/lang/String;Lkotlin/time/Duration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoginMethod extends AbsLoginMethodIDL {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f35539b = 0;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.login.LoginMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.login.LoginMethod$handle$1", f = "LoginMethod.kt", i = {0, 0, 1, 1}, l = {100, 104}, m = "invokeSuspend", n = {"activeAuthTaskSession", "standaloneAuthTaskSession", "activeAuthTaskSession", "standaloneAuthTaskSession"}, s = {"L$0", "L$1", "L$0", "L$1"})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appletId;
        final /* synthetic */ e3.d $bridgeContext;
        final /* synthetic */ f3.h<AbsLoginMethodIDL.b> $callback;
        final /* synthetic */ AbsLoginMethodIDL.a $params;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ LoginMethod this$0;

        public AnonymousClass1(String r100, e3.d r101, LoginMethod r102, AbsLoginMethodIDL.a r103, f3.h<AbsLoginMethodIDL.b> r104, Continuation<? super AnonymousClass1> r105) {
            this.$appletId = r100;
            this.$bridgeContext = r101;
            this.this$0 = r102;
            this.$params = r103;
            this.$callback = r104;
            super(2, r105);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$appletId, this.$bridgeContext, this.this$0, this.$params, this.$callback, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v5 */
        /* JADX WARN: Type inference failed for: r10v6, types: [com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor$Session] */
        /* JADX WARN: Type inference failed for: r10v8 */
        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v15 */
        /* JADX WARN: Type inference failed for: r2v16 */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor$Session] */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Type inference failed for: r3v0, types: [int] */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v10 */
        /* JADX WARN: Type inference failed for: r3v11 */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v23 */
        /* JADX WARN: Type inference failed for: r3v24 */
        /* JADX WARN: Type inference failed for: r3v25 */
        /* JADX WARN: Type inference failed for: r3v3, types: [com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor$Session] */
        /* JADX WARN: Type inference failed for: r3v30 */
        /* JADX WARN: Type inference failed for: r3v31 */
        /* JADX WARN: Type inference failed for: r3v32 */
        /* JADX WARN: Type inference failed for: r3v33 */
        /* JADX WARN: Type inference failed for: r3v34 */
        /* JADX WARN: Type inference failed for: r3v8 */
        /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v0 */
        /* JADX WARN: Type inference failed for: r9v1 */
        /* JADX WARN: Type inference failed for: r9v13 */
        /* JADX WARN: Type inference failed for: r9v5 */
        /* JADX WARN: Type inference failed for: r9v6, types: [java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r310) {
            ?? r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r101 = this.label;
            boolean r102 = true;
            if (r101 == 0) goto L16;
            if (r101 == 1) goto L11;
            if (r101 != 2) goto L10;
            AppletAuthTaskMonitor.Session r103 = (AppletAuthTaskMonitor.Session) this.L$1;
            AppletAuthTaskMonitor.Session r104 = (AppletAuthTaskMonitor.Session) this.L$0;
            ResultKt.throwOnFailure(r310);     // Catch: Exception -> L14
            Object r105 = r310;
            ?? r106 = r103;
            ?? r107 = r104;
        L49:
            String r108 = (String) r105;     // Catch: Exception -> L14
            r100 = r106;
            r101 = r107;
        L50:
            LoginProcessor r109 = LoginProcessor.f34725a;     // Catch: Exception -> L14
            String r110 = this.$appletId;     // Catch: Exception -> L14
            GrantingAction r111 = GrantingAction.AGREED;     // Catch: Exception -> L14
            OperationType r112 = OperationType.LOGIN;     // Catch: Exception -> L14
            r109.getClass();     // Catch: Exception -> L14
            LoginProcessor.i(r110, r111, r112);     // Catch: Exception -> L14
            com.bytedance.ai.utils.g r113 = com.bytedance.ai.utils.g.f37637a;     // Catch: Exception -> L14
            StringBuilder r114 = new StringBuilder("call success, applet=");     // Catch: Exception -> L14
            r114.append(this.$appletId);     // Catch: Exception -> L14
            r114.append(", hasCode=");     // Catch: Exception -> L14
            if (r108.length() <= 0) goto L53;
            boolean r115 = true;
        L54:
            r114.append(r115);     // Catch: Exception -> L14
            r113.i("AISDK_JSB_LoginMethod", r114.toString());     // Catch: Exception -> L14
            f3.h<AbsLoginMethodIDL.b> r116 = this.$callback;     // Catch: Exception -> L14
            Intrinsics.checkNotNullParameter(AbsLoginMethodIDL.b.class, "<this>");     // Catch: Exception -> L14
            BaseModel r117 = k3.c.a(AbsLoginMethodIDL.b.class);     // Catch: Exception -> L14
            ((AbsLoginMethodIDL.b) r117).setCode(r108);     // Catch: Exception -> L14
            f3.h.a.b(r116, (ResultModel) r117);     // Catch: Exception -> L14
            if (r100 == 0) goto L75;
            r100.d(new AppletAuthTaskMonitor.a("success", "doubao.login.callback", null, null, null, null, null, null, 508));     // Catch: Exception -> L14
        L75:
            return Unit.INSTANCE;
        L53:
            r115 = false;
            goto L54
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            AppletAuthTaskMonitor.Session r118 = (AppletAuthTaskMonitor.Session) this.L$1;
            AppletAuthTaskMonitor.Session r119 = (AppletAuthTaskMonitor.Session) this.L$0;
            ResultKt.throwOnFailure(r310);     // Catch: Exception -> L14
            Object r120 = r310;
            ?? r121 = r118;
            ?? r122 = r119;
        L39:
            r108 = (String) r120;     // Catch: Exception -> L14
            r100 = r121;
            r101 = r122;
            goto L50
        L16:
            ResultKt.throwOnFailure(r310);
            LoginProcessor r123 = LoginProcessor.f34725a;
            String r124 = this.$appletId;
            r123.getClass();
            Intrinsics.checkNotNullParameter(r124, IFlowAppIntentIDL.PARAM_APPLET_ID);
            com.bytedance.ai.applet.login.j r125 = (com.bytedance.ai.applet.login.j) ((LinkedHashMap) LoginProcessor.f34727c).get(r124);
            if (r125 == null) goto L19;
            ?? r126 = r125.f34769h;
        L20:
            if (r126 != 0) goto L30;
            SecureRandom r127 = AppletAuthTaskMonitor.f37154a;
            e3.d r128 = this.$bridgeContext;
            LoginMethod r129 = this.this$0;
            String r130 = this.$appletId;
            int r131 = LoginMethod.f35539b;
            r129.getClass();
            CustomLoginNavigator r132 = CustomLoginNavigator.f34707a;
            Intrinsics.checkNotNullParameter(r130, IFlowAppIntentIDL.PARAM_APPLET_ID);
            CustomLoginNavigator.a r133 = CustomLoginNavigator.f34708b.get(r130);
            if (r133 == null) goto L24;
            CustomLoginNavigator.LaunchSource r134 = r133.f34717d;
        L26:
            if (r134 != CustomLoginNavigator.LaunchSource.CHAT) goto L28;
            String r135 = "mcp";
        L29:
            ?? r136 = AppletAuthTaskMonitor.g(AppletAuthTaskMonitor.c(r128, r135, "normal_login", "doubao.login.call", this.$appletId));
        L31:
            if (r126 != 0) goto L33;
            ?? r137 = r136;
        L78:
            if (r137 == 0) goto L41;
            LoginMethod$handle$1$loginCode$1 r138 = new LoginMethod$handle$1$loginCode$1(this.this$0, this.$appletId, this.$params, null);     // Catch: Exception -> L59
            this.L$0 = r126;     // Catch: Exception -> L59
            this.L$1 = r136;     // Catch: Exception -> L59
            this.label = 1;     // Catch: Exception -> L59
            r120 = r137.f(r138, this);     // Catch: Exception -> L59
            if (r120 != r100) goto L38;
            return r100;
        L38:
            r121 = r136;
            r122 = r126;
            goto L39
        L41:
            LoginMethod r139 = this.this$0;     // Catch: Exception -> L59
            String r140 = this.$appletId;     // Catch: Exception -> L59
            Integer r141 = this.$params.getTimeout();     // Catch: Exception -> L59
            if (r141 == null) goto L44;
            Duration.Companion r142 = Duration.Companion;     // Catch: Exception -> L59
            Duration r143 = Duration.m10791boximpl(DurationKt.toDuration(r141.intValue(), DurationUnit.MILLISECONDS));     // Catch: Exception -> L59
        L45:
            this.L$0 = r126;     // Catch: Exception -> L59
            this.L$1 = r136;     // Catch: Exception -> L59
            this.label = 2;     // Catch: Exception -> L59
            r105 = LoginMethod.b(r139, r140, r143, this);     // Catch: Exception -> L59
            if (r105 != r100) goto L48;
            return r100;
        L48:
            r106 = r136;
            r107 = r126;
            goto L49
        L44:
            r143 = null;
        L59:
            e = e;
        L60:
            f3.a r144 = d.a(e);
            com.bytedance.ai.utils.g.f37637a.e("AISDK_JSB_LoginMethod", "call failed, errNo=" + r144.f475285a + ", msg=" + e.getMessage(), e);
            LoginMethod r145 = this.this$0;
            int r146 = LoginMethod.f35539b;
            r145.getClass();
            if (Intrinsics.areEqual(r144, f3.a.f475275p) == false) goto L63;
        L66:
            if (r102 == false) goto L68;
            AppletAuthTaskMonitor.a r147 = new AppletAuthTaskMonitor.a("timeout", "doubao.login.callback", "exchange_code", AppletAuthTaskMonitor.ErrorCode.TIMEOUT, e.getMessage(), null, null, null, 480);
        L69:
            if (r126 == 0) goto L71;
            LoginProcessor r148 = LoginProcessor.f34725a;
            String r149 = this.$appletId;
            r148.getClass();
            LoginProcessor.j(r149, false, r147);
        L73:
            f3.h.a.a(this.$callback, "Error: " + e.getMessage(), r144, null, 10);
            goto L75
        L71:
            if (r136 == 0) goto L73;
            r136.d(r147);
            goto L73
        L68:
            r147 = new AppletAuthTaskMonitor.a("failed", "doubao.login.callback", "exchange_code", AppletAuthTaskMonitor.ErrorCode.API_FAILED, e.getMessage(), null, null, null, 480);
            goto L69
        L63:
            if (Intrinsics.areEqual(r144, f3.a.f475282w) == true) goto L66;
            r102 = false;
            goto L66
        L33:
            r137 = r126;
            goto L78
        L28:
            r135 = PrefetchTiming.JSB;
            goto L29
        L24:
            r134 = null;
            goto L26
        L30:
            r136 = 0;
            goto L31
        L19:
            r126 = 0;
        L14:
            e = e;
            r126 = r101;
            r136 = r100;
            goto L60
        }
    }

    static {
    }

    public LoginMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r110, ParamModel r111, final f3.h r112) {
        final AbsLoginMethodIDL.a r100 = (AbsLoginMethodIDL.a) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        a0 r113 = r110.getContainerContext();
        a0 r101 = r110.getContainerContext();
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getAppId();
    L6:
        a0 r104 = r110.getContainerContext();
        if (r104 == null) goto L9;
        final String r105 = r104.getAppletId();
    L10:
        if (r105 != null) goto L12;
    L15:
        boolean r106 = true;
    L17:
        if (r106 == false) goto L19;
        com.bytedance.ai.utils.g r114 = com.bytedance.ai.utils.g.f37637a;
        StringBuilder r115 = new StringBuilder("call failed, errNo=");
        f3.a r107 = f3.a.f475265f;
        r115.append(r107.f475285a);
        r115.append(", msg=appletId is null or empty");
        r114.e("AISDK_JSB_LoginMethod", r115.toString());
        f3.h.a.a(r112, "Error: appletId is null or empty", r107, null, 10);
        return;
    L19:
        com.bytedance.ai.utils.g r108 = com.bytedance.ai.utils.g.f37637a;
        r108.i("AISDK_JSB_LoginMethod", "call start, app=" + r103 + ", applet=" + r105 + ", timeout=" + r100.getTimeout());
        com.bytedance.ai.applet.moa.k r109 = com.bytedance.ai.applet.moa.k.f34855a;
        if (r113 == null) goto L22;
        String r116 = r113.getConversationId();
    L23:
        if (r113 == null) goto L25;
        r102 = r113.getUrl();
    L25:
        Function1 r117 = new g(r105, r100, r112);
        Function0 r118 = new h(r112);
        r109.getClass();
        if (com.bytedance.ai.applet.moa.k.d(r116, r102, r105, "login flow", r117, r118) == false) goto L28;
        r108.i("AISDK_JSB_LoginMethod", "MOA consumed callback, skip normal login flow: applet=".concat(r105));
        return;
    L28:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(r105, r110, this, r100, r112, null), 3, null);
        return;
    L22:
        r116 = null;
        goto L23
    L12:
        if (r105.length() == 0) goto L15;
        r106 = false;
        goto L17
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public static final Object b(LoginMethod r100, String r101, Duration r102, Continuation r110) {
        r100.getClass();
        if ((r110 instanceof LoginMethod$fetchLoginCode$1) == false) goto L7;
        LoginMethod$fetchLoginCode$1 r103 = (LoginMethod$fetchLoginCode$1) r110;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        Object r107 = null;
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        ResultKt.throwOnFailure(r105);
        Object r108 = ((Result) r105).m9458unboximpl();
    L30:
        if (Result.m9455isFailureimpl(r108) == true) goto L33;
        r107 = r108;
    L33:
        r111 = (String) r107;
        if (r111 != null) goto L39;
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L38;
        throw r109;
    L38:
        throw new RemoteApiException.InvalidResponse("login code is missing");
    L39:
        return r111;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r102 = (Duration) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L21:
        Result r112 = (Result) r105;
        if (r112 == null) goto L25;
        r108 = r112.m9458unboximpl();
        goto L30
    L25:
        throw new LoginOperationTimeoutException("Login request timed out after " + r102);
    L16:
        ResultKt.throwOnFailure(r105);
        if (r102 == null) goto L26;
        long r113 = r102.m10848unboximpl();
        LoginMethod$fetchLoginCode$result$1 r114 = new LoginMethod$fetchLoginCode$result$1(r101, null);
        r103.L$0 = r102;
        r103.label = 1;
        r105 = TimeoutKt.c(DelayKt.m10957toDelayMillisLRDsOJo(r113), r114, r103);
        if (r105 != r111) goto L21;
    L26:
        UserAuthService r115 = UserAuthService.f36075a;
        r103.label = 2;
        r108 = UserAuthService.k(r101, null, null, r103, 30);
        if (r108 != r111) goto L30;
    L7:
        r103 = new LoginMethod$fetchLoginCode$1(r100, r110);
        goto L8
    }
}
