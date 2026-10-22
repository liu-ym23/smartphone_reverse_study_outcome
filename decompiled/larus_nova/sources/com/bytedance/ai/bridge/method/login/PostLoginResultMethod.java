package com.bytedance.ai.bridge.method.login;

import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.login.CustomLoginNavigator;
import com.bytedance.ai.applet.login.LoginProcessor;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.postMcpLogin.AbsPostLoginResultMethodIDL;
import com.bytedance.ai.bridge.remote.UserAuthService;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import d3.a0;
import java.security.SecureRandom;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0010J&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0015J \u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ai/bridge/method/login/PostLoginResultMethod;", "Lcom/bytedance/ai/bridge/postMcpLogin/AbsPostLoginResultMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/postMcpLogin/AbsPostLoginResultMethodIDL$PostLoginResultRequestModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/postMcpLogin/AbsPostLoginResultMethodIDL$EmptyMessageModel;", "returnToChat", IFlowAppIntentIDL.PARAM_APPLET_ID, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postLoginCodeToOpenPlat", "", "code", "versionTag", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportDetachedResult", "finishInfo", "Lcom/bytedance/ai/monitor/auth/AppletAuthTaskMonitor$FinishInfo;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PostLoginResultMethod extends AbsPostLoginResultMethodIDL {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f35543b = 0;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.login.PostLoginResultMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.login.PostLoginResultMethod$handle$1", f = "PostLoginResultMethod.kt", i = {}, l = {124, 128, 175}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appletId;
        final /* synthetic */ e3.d $bridgeContext;
        final /* synthetic */ f3.h<AbsPostLoginResultMethodIDL.a> $callback;
        final /* synthetic */ String $loginCode;
        final /* synthetic */ String $versionTag;
        int label;
        final /* synthetic */ PostLoginResultMethod this$0;

        public AnonymousClass1(String r100, PostLoginResultMethod r101, String r102, String r103, e3.d r104, f3.h<AbsPostLoginResultMethodIDL.a> r105, Continuation<? super AnonymousClass1> r106) {
            this.$appletId = r100;
            this.this$0 = r101;
            this.$loginCode = r102;
            this.$versionTag = r103;
            this.$bridgeContext = r104;
            this.$callback = r105;
            super(2, r106);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r110) {
            return new AnonymousClass1(this.$appletId, this.this$0, this.$loginCode, this.$versionTag, this.$bridgeContext, this.$callback, r110);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r210) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L13;
            if (r101 == 1) goto L11;
            if (r101 == 2) goto L10;
            if (r101 != 3) goto L9;
            ResultKt.throwOnFailure(r210);
        L50:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r210);     // Catch: Exception -> L17
            Object r102 = r210;
        L28:
            ((Boolean) r102).booleanValue();     // Catch: Exception -> L17
        L29:
            CustomLoginNavigator r103 = CustomLoginNavigator.f34707a;     // Catch: Exception -> L17
            String r104 = this.$appletId;     // Catch: Exception -> L17
            Intrinsics.checkNotNullParameter(r104, IFlowAppIntentIDL.PARAM_APPLET_ID);     // Catch: Exception -> L17
            CustomLoginNavigator.a r105 = CustomLoginNavigator.f34708b.get(r104);     // Catch: Exception -> L17
            if (r105 == null) goto L32;
            CustomLoginNavigator.LaunchSource r106 = r105.f34717d;     // Catch: Exception -> L17
        L34:
            if (r106 != CustomLoginNavigator.LaunchSource.CHAT) goto L36;
            boolean r107 = true;
        L37:
            LoginProcessor r108 = LoginProcessor.f34725a;     // Catch: Exception -> L17
            String r110 = this.$appletId;     // Catch: Exception -> L17
            r108.getClass();     // Catch: Exception -> L17
            Intrinsics.checkNotNullParameter(r110, IFlowAppIntentIDL.PARAM_APPLET_ID);     // Catch: Exception -> L17
            if (LoginProcessor.f34727c.containsKey(r110) == false) goto L40;
            String r111 = this.$appletId;     // Catch: Exception -> L17
            r108.getClass();     // Catch: Exception -> L17
            Intrinsics.checkNotNullParameter(r111, IFlowAppIntentIDL.PARAM_APPLET_ID);     // Catch: Exception -> L17
            LoginProcessor.j(r111, true, null);     // Catch: Exception -> L17
        L41:
            com.bytedance.ai.utils.g.f37637a.i("AISDK_JSB_PostLoginResultMethod", "call success, applet=" + this.$appletId);     // Catch: Exception -> L17
            f3.h<AbsPostLoginResultMethodIDL.a> r109 = this.$callback;     // Catch: Exception -> L17
            Intrinsics.checkNotNullParameter(AbsPostLoginResultMethodIDL.a.class, "<this>");     // Catch: Exception -> L17
            f3.h.a.b(r109, (ResultModel) k3.c.a(AbsPostLoginResultMethodIDL.a.class));     // Catch: Exception -> L17
            if (r107 == false) goto L50;
            PostLoginResultMethod r112 = this.this$0;
            String r113 = this.$appletId;
            this.label = 3;
            int r114 = PostLoginResultMethod.f35543b;
            r112.getClass();
            Object r115 = BuildersKt.withContext(Dispatchers.getMain(), new PostLoginResultMethod$returnToChat$2(r113, null), this);
            if (r115 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L47;
            r115 = Unit.INSTANCE;
        L47:
            if (r115 != r100) goto L50;
            return r100;
        L40:
            PostLoginResultMethod r116 = this.this$0;     // Catch: Exception -> L17
            e3.d r117 = this.$bridgeContext;     // Catch: Exception -> L17
            String r118 = this.$appletId;     // Catch: Exception -> L17
            AppletAuthTaskMonitor.a r119 = new AppletAuthTaskMonitor.a("success", null, null, null, null, null, null, null, 510);     // Catch: Exception -> L17
            int r120 = PostLoginResultMethod.f35543b;     // Catch: Exception -> L17
            r116.getClass();     // Catch: Exception -> L17
            PostLoginResultMethod.c(r117, r118, r119);     // Catch: Exception -> L17
            goto L41
        L36:
            r107 = false;
            goto L37
        L32:
            r106 = null;
            goto L34
        L11:
            ResultKt.throwOnFailure(r210);     // Catch: Exception -> L17
            Object r121 = r210;
        L24:
            ((Boolean) r121).booleanValue();     // Catch: Exception -> L17
            goto L29
        L13:
            ResultKt.throwOnFailure(r210);
            LoginProcessor r122 = LoginProcessor.f34725a;     // Catch: Exception -> L17
            String r123 = this.$appletId;     // Catch: Exception -> L17
            r122.getClass();     // Catch: Exception -> L17
            Intrinsics.checkNotNullParameter(r123, IFlowAppIntentIDL.PARAM_APPLET_ID);     // Catch: Exception -> L17
            com.bytedance.ai.applet.login.j r124 = (com.bytedance.ai.applet.login.j) ((LinkedHashMap) LoginProcessor.f34727c).get(r123);     // Catch: Exception -> L17
            if (r124 == null) goto L19;
            AppletAuthTaskMonitor.Session r125 = r124.f34769h;     // Catch: Exception -> L17
        L20:
            if (r125 == null) goto L25;
            PostLoginResultMethod$handle$1$result$1 r126 = new PostLoginResultMethod$handle$1$result$1(this.this$0, this.$appletId, this.$loginCode, this.$versionTag, null);     // Catch: Exception -> L17
            this.label = 1;     // Catch: Exception -> L17
            r121 = r125.f(r126, this);     // Catch: Exception -> L17
            if (r121 != r100) goto L24;
            return r100;
        L25:
            PostLoginResultMethod r127 = this.this$0;     // Catch: Exception -> L17
            String r128 = this.$appletId;     // Catch: Exception -> L17
            String r129 = this.$loginCode;     // Catch: Exception -> L17
            String r130 = this.$versionTag;     // Catch: Exception -> L17
            this.label = 2;     // Catch: Exception -> L17
            r102 = PostLoginResultMethod.b(r127, r128, r129, r130, this);     // Catch: Exception -> L17
            if (r102 != r100) goto L28;
            return r100;
        L19:
            r125 = null;
        L17:
            e = move-exception;
            f3.a r131 = d.a(e);
            com.bytedance.ai.utils.g.f37637a.e("AISDK_JSB_PostLoginResultMethod", "call failed, errNo=" + r131.f475285a + ", msg=postLoginCode failed, applet=" + this.$appletId + ", " + e.getMessage(), e);
            AppletAuthTaskMonitor.a r132 = new AppletAuthTaskMonitor.a("failed", null, "exchange_code", AppletAuthTaskMonitor.ErrorCode.API_FAILED, e.getMessage(), null, null, null, 482);
            LoginProcessor r133 = LoginProcessor.f34725a;
            String r134 = this.$appletId;
            r133.getClass();
            Intrinsics.checkNotNullParameter(r134, IFlowAppIntentIDL.PARAM_APPLET_ID);
            if (LoginProcessor.f34727c.containsKey(r134) == false) goto L54;
            String r135 = this.$appletId;
            r133.getClass();
            LoginProcessor.j(r135, false, r132);
        L55:
            f3.h.a.a(this.$callback, "Error: postLoginCode failed, " + e.getMessage(), r131, null, 10);
            return Unit.INSTANCE;
        L54:
            PostLoginResultMethod r136 = this.this$0;
            e3.d r137 = this.$bridgeContext;
            String r138 = this.$appletId;
            int r139 = PostLoginResultMethod.f35543b;
            r136.getClass();
            PostLoginResultMethod.c(r137, r138, r132);
            goto L55
        }
    }

    static {
    }

    public PostLoginResultMethod() {
    }

    public static void c(e3.d r110, String r111, AppletAuthTaskMonitor.a r210) {
        SecureRandom r100 = AppletAuthTaskMonitor.f37154a;
        AppletAuthTaskMonitor.b r101 = AppletAuthTaskMonitor.c(r110, "detached", "normal_login", "doubao.postLoginResult.call", r111);
        Intrinsics.checkNotNullParameter(r101, "meta");
        Intrinsics.checkNotNullParameter(r210, "info");
        long r102 = System.currentTimeMillis();
        String r103 = r101.f37173a;
        String r104 = r101.f37175c;
        String r105 = r101.f37176d;
        String r112 = r101.f37177e;
        String r113 = r101.f37178f;
        String r114 = r101.f37179g;
        String r115 = r101.f37180h;
        String r116 = r101.f37181i;
        String r117 = r101.f37182j;
        String r106 = r101.f37183k;
        String r107 = r101.f37184l;
        Intrinsics.checkNotNullParameter(r103, "domain");
        Intrinsics.checkNotNullParameter("detached", "scene");
        Intrinsics.checkNotNullParameter(r104, "subType");
        Intrinsics.checkNotNullParameter(r105, "detail");
        Intrinsics.checkNotNullParameter(r112, IFlowAppIntentIDL.PARAM_APPLET_ID);
        Intrinsics.checkNotNullParameter(r113, "containerType");
        AppletAuthTaskMonitor.f(new AppletAuthTaskMonitor.Session(new AppletAuthTaskMonitor.b(r103, "detached", r104, r105, r112, r113, r114, r115, r116, r117, r106, r107), AppletAuthTaskMonitor.a(r102), r102), r210, r102, true);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r210, ParamModel r211, final f3.h r212) {
        final AbsPostLoginResultMethodIDL.b r100 = (AbsPostLoginResultMethodIDL.b) r211;
        Intrinsics.checkNotNullParameter(r210, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r212, "callback");
        a0 r101 = r210.getContainerContext();
        a0 r102 = r210.getContainerContext();
        if (r102 == null) goto L5;
        String r103 = r102.getAppId();
    L6:
        a0 r104 = r210.getContainerContext();
        if (r104 == null) goto L9;
        final String r105 = r104.getAppletId();
    L10:
        if (r105 != null) goto L12;
    L15:
        boolean r106 = true;
    L17:
        if (r106 == false) goto L19;
        com.bytedance.ai.utils.g r107 = com.bytedance.ai.utils.g.f37637a;
        StringBuilder r108 = new StringBuilder("call failed, errNo=");
        f3.a r109 = f3.a.f475265f;
        r108.append(r109.f475285a);
        r108.append(", msg=appletId is null or empty");
        r107.e("AISDK_JSB_PostLoginResultMethod", r108.toString());
        f3.h.a.a(r212, "Error: appletId is null or empty", r109, null, 10);
        return;
    L19:
        com.bytedance.ai.applet.moa.k r110 = com.bytedance.ai.applet.moa.k.f34855a;
        if (r101 == null) goto L22;
        String r111 = r101.getConversationId();
    L23:
        if (r101 == null) goto L25;
        String r112 = r101.getUrl();
    L26:
        Function1 r113 = new m(r105, r100, r212);
        Function0 r114 = new n(r212);
        r110.getClass();
        if (com.bytedance.ai.applet.moa.k.d(r111, r112, r105, "login result", r113, r114) == false) goto L29;
        com.bytedance.ai.utils.g.f37637a.i("AISDK_JSB_PostLoginResultMethod", "MOA consumed callback, skip normal post-login-result flow: applet=".concat(r105));
        return;
    L29:
        AppletAppManagerService.INSTANCE.getClass();
        OnlineAppletApplication r115 = AppletAppManagerService.b(r105);
        if (r115 != null) goto L32;
        com.bytedance.ai.utils.g r116 = com.bytedance.ai.utils.g.f37637a;
        StringBuilder r117 = new StringBuilder("call failed, errNo=");
        f3.a r118 = f3.a.f475265f;
        r117.append(r118.f475285a);
        r117.append(", msg=cannot find app for ");
        r117.append(r105);
        r116.e("AISDK_JSB_PostLoginResultMethod", r117.toString());
        f3.h.a.a(r212, "Error: cannot find app", r118, null, 10);
        return;
    L32:
        com.bytedance.ai.utils.g r119 = com.bytedance.ai.utils.g.f37637a;
        StringBuilder r120 = new StringBuilder("call start, app=");
        r120.append(r103);
        r120.append(", applet=");
        r120.append(r105);
        r120.append(", result=");
        r120.append(r100.getResult());
        r120.append(", hasCode=");
        String r121 = r100.getCode();
        if (r121 != null) goto L35;
    L38:
        boolean r122 = true;
        boolean r123 = true;
    L39:
        r120.append(!r123);
        r119.i("AISDK_JSB_PostLoginResultMethod", r120.toString());
        if (r100.getResult() == true) goto L46;
        r119.e("AISDK_JSB_PostLoginResultMethod", "login result is false, applet=".concat(r105));
        AppletAuthTaskMonitor.a r124 = new AppletAuthTaskMonitor.a("failed", null, "wait_post_login_result", AppletAuthTaskMonitor.ErrorCode.INVALID_RESPONSE, "postLoginResult result is false", null, null, null, 482);
        LoginProcessor r125 = LoginProcessor.f34725a;
        r125.getClass();
        Intrinsics.checkNotNullParameter(r105, IFlowAppIntentIDL.PARAM_APPLET_ID);
        if (LoginProcessor.f34727c.containsKey(r105) == false) goto L44;
        r125.getClass();
        LoginProcessor.j(r105, false, r124);
    L45:
        Intrinsics.checkNotNullParameter(AbsPostLoginResultMethodIDL.a.class, "<this>");
        r212.b((ResultModel) k3.c.a(AbsPostLoginResultMethodIDL.a.class), "");
        return;
    L44:
        c(r210, r105, r124);
        goto L45
    L46:
        String r126 = r100.getCode();
        if (r126 != null) goto L49;
    L52:
        if (r122 == false) goto L58;
        StringBuilder r127 = new StringBuilder("call failed, errNo=");
        f3.a r128 = f3.a.f475267h;
        r127.append(r128.f475285a);
        r127.append(", msg=login code is null or empty");
        r119.e("AISDK_JSB_PostLoginResultMethod", r127.toString());
        AppletAuthTaskMonitor.a r129 = new AppletAuthTaskMonitor.a("failed", null, "exchange_code", AppletAuthTaskMonitor.ErrorCode.EMPTY_LOGIN_CODE, null, null, null, null, TTVideoEngineInterface.PLAYER_OPTION_LAZY_SEEK);
        LoginProcessor r130 = LoginProcessor.f34725a;
        r130.getClass();
        Intrinsics.checkNotNullParameter(r105, IFlowAppIntentIDL.PARAM_APPLET_ID);
        if (LoginProcessor.f34727c.containsKey(r105) == false) goto L56;
        r130.getClass();
        LoginProcessor.j(r105, false, r129);
    L57:
        f3.h.a.a(r212, "Error: login code is null or empty", r128, null, 10);
        return;
    L56:
        c(r210, r105, r129);
        goto L57
    L58:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(r105, this, r126, r115.j().f36898e, r210, r212, null), 3, null);
        return;
    L49:
        if (r126.length() == 0) goto L52;
        r122 = false;
        goto L52
    L35:
        if (r121.length() == 0) goto L38;
        r122 = true;
        r123 = false;
        goto L39
    L25:
        r112 = null;
        goto L26
    L22:
        r111 = null;
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

    public static final Object b(PostLoginResultMethod r100, String r101, String r102, String r110, Continuation r111) {
        r100.getClass();
        if ((r111 instanceof PostLoginResultMethod$postLoginCodeToOpenPlat$1) == false) goto L7;
        PostLoginResultMethod$postLoginCodeToOpenPlat$1 r103 = (PostLoginResultMethod$postLoginCodeToOpenPlat$1) r111;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        PostLoginResultMethod$postLoginCodeToOpenPlat$1 r105 = r103;
        Object r106 = r105.result;
        Object r112 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r105.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r106);
        Object r108 = ((Result) r106).m9458unboximpl();
    L18:
        if (Result.m9455isFailureimpl(r108) == false) goto L20;
        Object r109 = null;
    L21:
        Boolean r113 = (Boolean) r109;
        if (r113 != null) goto L24;
        Throwable r114 = Result.m9452exceptionOrNullimpl(r108);
        if (r114 == null) goto L28;
        throw r114;
    L28:
        throw new IllegalStateException("exchange code result is missing");
    L24:
        return Boxing.boxBoolean(r113.booleanValue());
    L20:
        r109 = r108;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        UserAuthService r115 = UserAuthService.f36075a;
        r105.label = 1;
        r108 = UserAuthService.f36075a.f(r101, r102, r110, null, r105);
        if (r108 != r112) goto L18;
        return r112;
    L7:
        r103 = new PostLoginResultMethod$postLoginCodeToOpenPlat$1(r100, r111);
        goto L8
    }
}
