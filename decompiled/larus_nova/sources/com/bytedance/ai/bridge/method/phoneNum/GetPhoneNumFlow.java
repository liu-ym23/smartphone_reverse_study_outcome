package com.bytedance.ai.bridge.method.phoneNum;

import com.bytedance.ai.applet.granting.GrantingAction;
import com.bytedance.ai.applet.login.LoginProcessor;
import com.bytedance.ai.applet.login.OperationType;
import com.bytedance.ai.applet.moa.k;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.phoneNum.AbsGetPhoneNumberMethodIDL;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import com.bytedance.ai.utils.g;
import com.bytedance.ai.utils.l;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import d3.a0;
import e3.d;
import f3.h;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ai/bridge/method/phoneNum/GetPhoneNumFlow;", "Lcom/bytedance/ai/bridge/phoneNum/AbsGetPhoneNumberMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/phoneNum/AbsGetPhoneNumberMethodIDL$EmptyMessageModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/phoneNum/AbsGetPhoneNumberMethodIDL$GetPhoneNumberResultModel;", "getPhoneNumberFlow", "", "(Lcom/bytedance/ai/bridge/context/IAIBridgeContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchPhoneMask", "versionTag", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showGrantingDialogAndWait", "Lcom/bytedance/ai/applet/granting/GrantingAction;", "phoneMask", IFlowAppIntentIDL.PARAM_APPLET_ID, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postPhoneNumUsed", "fetchPhoneCode", "Companion", "GetPhoneNumException", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetPhoneNumFlow extends AbsGetPhoneNumberMethodIDL {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f35792b = 0;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ai/bridge/method/phoneNum/GetPhoneNumFlow$GetPhoneNumException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "code", "", "<init>", "(Ljava/lang/String;I)V", "getCode", "()I", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GetPhoneNumException extends Exception {
        private final int code;

        public final int getCode() {
            return this.code;
        }

        public GetPhoneNumException(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "message");
            super(r100);
            this.code = r101;
        }
    }

    public static final class a {
    }

    public static final class b implements Function1<GrantingAction, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i<GrantingAction> f35793a;

        public b(j r100) {
            this.f35793a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(GrantingAction r100) {
            GrantingAction r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "userAction");
            if (this.f35793a.isActive() == false) goto L6;
            this.f35793a.resumeWith(Result.m9449constructorimpl(r101));
        L6:
            return Unit.INSTANCE;
        }
    }

    public static final class c implements Function1<Throwable, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f35794a = null;

        static {
            f35794a = new c();
        }

        public c() {
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ Unit invoke(Throwable r100) {
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.phoneNum.GetPhoneNumFlow$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.phoneNum.GetPhoneNumFlow$handle$1", f = "GetPhoneNumFlow.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ d $bridgeContext;
        final /* synthetic */ h<AbsGetPhoneNumberMethodIDL.b> $callback;
        int label;
        final /* synthetic */ GetPhoneNumFlow this$0;

        public AnonymousClass1(GetPhoneNumFlow r100, d r101, h<AbsGetPhoneNumberMethodIDL.b> r102, Continuation<? super AnonymousClass1> r103) {
            this.this$0 = r100;
            this.$bridgeContext = r101;
            this.$callback = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, this.$bridgeContext, this.$callback, r101);
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
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L9;
            if (r102 != 1) goto L8;
            ResultKt.throwOnFailure(r100);     // Catch: Exception -> L15 GetPhoneNumException -> L17
        L13:
            h<AbsGetPhoneNumberMethodIDL.b> r103 = this.$callback;     // Catch: Exception -> L15 GetPhoneNumException -> L17
            Intrinsics.checkNotNullParameter(AbsGetPhoneNumberMethodIDL.b.class, "<this>");     // Catch: Exception -> L15 GetPhoneNumException -> L17
            BaseModel r104 = k3.c.a(AbsGetPhoneNumberMethodIDL.b.class);     // Catch: Exception -> L15 GetPhoneNumException -> L17
            AbsGetPhoneNumberMethodIDL.b r105 = (AbsGetPhoneNumberMethodIDL.b) r104;     // Catch: Exception -> L15 GetPhoneNumException -> L17
            r105.setCode((String) r100);     // Catch: Exception -> L15 GetPhoneNumException -> L17
            r105.setMessage("success");     // Catch: Exception -> L15 GetPhoneNumException -> L17
            h.a.b(r103, (ResultModel) r104);     // Catch: Exception -> L15 GetPhoneNumException -> L17
        L25:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r100);
            GetPhoneNumFlow r106 = this.this$0;     // Catch: Exception -> L15 GetPhoneNumException -> L17
            d r107 = this.$bridgeContext;     // Catch: Exception -> L15 GetPhoneNumException -> L17
            this.label = 1;     // Catch: Exception -> L15 GetPhoneNumException -> L17
            r100 = GetPhoneNumFlow.b(r106, r107, this);     // Catch: Exception -> L15 GetPhoneNumException -> L17
            if (r100 != r101) goto L13;
            return r101;
        L17:
            e = move-exception;
            g.f37637a.w("GetPhoneNumMethod", "Get phone number failed: " + e.getMessage());
            h<AbsGetPhoneNumberMethodIDL.b> r108 = this.$callback;
            String r109 = e.getMessage();
            if (r109 != null) goto L23;
            r109 = "Unknown error occurred";
        L23:
            h.a.a(r108, r109, null, null, 12);
        L15:
            e = move-exception;
            g.f37637a.e("GetPhoneNumMethod", "Unexpected error occurred during get phone number", e);
            h.a.a(this.$callback, "Error: " + e.getMessage(), null, null, 12);
            goto L25
        }
    }

    static {
    }

    public GetPhoneNumFlow() {
    }

    public static Object d(String r100, Continuation r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new GetPhoneNumFlow$fetchPhoneCode$2(r100, null), r101);
    }

    public static final Object b(GetPhoneNumFlow r110, d r111, Continuation r210) {
        r110.getClass();
        if ((r210 instanceof GetPhoneNumFlow$getPhoneNumberFlow$1) == false) goto L7;
        GetPhoneNumFlow$getPhoneNumberFlow$1 r100 = (GetPhoneNumFlow$getPhoneNumberFlow$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r100.label) {
            case 0: goto L22;
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L12;
            default: goto L11;
        };
    L12:
        String r104 = (String) r100.L$1;
        com.bytedance.ai.applet.login.j r105 = (com.bytedance.ai.applet.login.j) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r103 = r104;
    L95:
        if (r105 == null) goto L122;
        r105.f34765d = true;
    L122:
        return r103;
    L13:
        com.bytedance.ai.applet.login.j r106 = (com.bytedance.ai.applet.login.j) r100.L$1;
        String r107 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L90:
        String r108 = (String) r102;
    L91:
        CoroutineDispatcher r109 = Dispatchers.getDefault();
        GetPhoneNumFlow$getPhoneNumberFlow$3 r112 = new GetPhoneNumFlow$getPhoneNumberFlow$3(r106, r110, r107, null);
        r100.L$0 = r106;
        r100.L$1 = r108;
        r100.label = 10;
        if (BuildersKt.withContext(r109, r112, r100) == r103) goto L122;
        r103 = r108;
        r105 = r106;
        goto L95
    L14:
        r106 = (com.bytedance.ai.applet.login.j) r100.L$1;
        r107 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L85:
        r108 = (String) r102;
        if (r108 != null) goto L91;
    L87:
        r100.L$0 = r107;
        r100.L$1 = r106;
        r100.L$2 = null;
        r100.label = 9;
        r102 = d(r107, r100);
        if (r102 != r103) goto L90;
    L15:
        r106 = (com.bytedance.ai.applet.login.j) r100.L$1;
        r107 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L75:
        GrantingAction r113 = (GrantingAction) r102;
    L77:
        if (r113 != GrantingAction.AGREED) goto L97;
        LoginProcessor r114 = LoginProcessor.f34725a;
        GrantingAction r115 = GrantingAction.AGREED;
        OperationType r116 = OperationType.PHONE_NUM;
        r114.getClass();
        LoginProcessor.i(r107, r115, r116);
        if (r106 == null) goto L87;
        AppletAuthTaskMonitor.Session r117 = r106.f34769h;
        if (r117 == null) goto L87;
        GetPhoneNumFlow$getPhoneNumberFlow$phoneCode$2 r118 = new GetPhoneNumFlow$getPhoneNumberFlow$phoneCode$2(r110, r107, null);
        r100.L$0 = r107;
        r100.L$1 = r106;
        r100.L$2 = null;
        r100.label = 8;
        r102 = r117.f(r118, r100);
        if (r102 != r103) goto L85;
    L97:
        if (r106 == null) goto L99;
        r106.f34770i = new AppletAuthTaskMonitor.a("user_refused", null, "get_phone_number", AppletAuthTaskMonitor.ErrorCode.USER_REFUSED, null, null, null, null, TTVideoEngineInterface.PLAYER_OPTION_LAZY_SEEK);
    L99:
        LoginProcessor r119 = LoginProcessor.f34725a;
        GrantingAction r120 = GrantingAction.REJECTED;
        OperationType r121 = OperationType.PHONE_NUM;
        r119.getClass();
        LoginProcessor.i(r107, r120, r121);
        throw new GetPhoneNumException("Permission denied by user", -4);
    L16:
        String r122 = (String) r100.L$2;
        com.bytedance.ai.applet.login.j r123 = (com.bytedance.ai.applet.login.j) r100.L$1;
        String r124 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L67:
        r113 = (GrantingAction) r102;
        if (r113 == null) goto L71;
        r106 = r123;
        r107 = r124;
    L71:
        r100.L$0 = r124;
        r100.L$1 = r123;
        r100.L$2 = null;
        r100.label = 7;
        r102 = e(r122, r124, r100);
        if (r102 == r103) goto L122;
        r106 = r123;
        r107 = r124;
        goto L75
    L17:
        com.bytedance.ai.applet.login.j r125 = (com.bytedance.ai.applet.login.j) r100.L$1;
        String r126 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L60:
        String r127 = (String) r102;
        r124 = r126;
        r123 = r125;
    L55:
        r122 = r127;
        if (r123 == null) goto L71;
        AppletAuthTaskMonitor.Session r128 = r123.f34769h;
        if (r128 == null) goto L71;
        GetPhoneNumFlow$getPhoneNumberFlow$userAction$1 r129 = new GetPhoneNumFlow$getPhoneNumberFlow$userAction$1(r110, r122, r124, null);
        r100.L$0 = r124;
        r100.L$1 = r123;
        r100.L$2 = r122;
        r100.label = 6;
        r102 = r128.g(r129, r100);
        if (r102 != r103) goto L67;
    L18:
        String r130 = (String) r100.L$2;
        r123 = (com.bytedance.ai.applet.login.j) r100.L$1;
        r124 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L52:
        r127 = (String) r102;
        if (r127 != null) goto L55;
    L56:
        r100.L$0 = r124;
        r100.L$1 = r123;
        r100.L$2 = null;
        r100.label = 5;
        r102 = BuildersKt.withContext(Dispatchers.getIO(), new GetPhoneNumFlow$fetchPhoneMask$2(r130, null), r100);
        if (r102 == r103) goto L122;
        r125 = r123;
        r126 = r124;
        goto L60
    L19:
        String r131 = (String) r100.L$1;
        com.bytedance.ai.applet.login.j r132 = (com.bytedance.ai.applet.login.j) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r103 = r131;
    L120:
        if (r132 == null) goto L122;
        r132.f34765d = true;
        goto L122
    L20:
        com.bytedance.ai.applet.login.j r133 = (com.bytedance.ai.applet.login.j) r100.L$1;
        String r134 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L115:
        String r135 = (String) r102;
    L116:
        CoroutineDispatcher r136 = Dispatchers.getDefault();
        GetPhoneNumFlow$getPhoneNumberFlow$2 r137 = new GetPhoneNumFlow$getPhoneNumberFlow$2(r133, r110, r134, null);
        r100.L$0 = r133;
        r100.L$1 = r135;
        r100.label = 3;
        if (BuildersKt.withContext(r136, r137, r100) == r103) goto L122;
        r103 = r135;
        r132 = r133;
        goto L120
    L21:
        r133 = (com.bytedance.ai.applet.login.j) r100.L$1;
        r134 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L108:
        r135 = (String) r102;
        if (r135 != null) goto L116;
    L112:
        r100.L$0 = r134;
        r100.L$1 = r133;
        r100.label = 2;
        r102 = d(r134, r100);
        if (r102 != r103) goto L115;
    L22:
        ResultKt.throwOnFailure(r102);
        a0 r138 = r111.getContainerContext();
        if (r138 == null) goto L124;
        r124 = r138.getAppletId();
        if (r124 == null) goto L124;
        LoginProcessor.f34725a.getClass();
        r123 = LoginProcessor.h(r124);
        String r139 = "";
        if (r123 == null) goto L32;
        u2.c r140 = r123.f34762a;
        if (r140 == null) goto L32;
        r130 = r140.f548389d;
        if (r130 == null) goto L32;
    L33:
        if (r123 == null) goto L38;
        String r141 = r123.f34767f;
        if (r141 == null) goto L38;
        r139 = r141;
    L38:
        a0 r142 = r111.getContainerContext();
        if (r142 == null) goto L41;
        String r143 = r142.getAppId();
    L42:
        boolean r144 = Intrinsics.areEqual(r143, "mcp-privacy-login-card");
        g.f37637a.i("GetPhoneNumMethod", "handle applet: " + r124 + " get phone number from: " + r139);
        if (Intrinsics.areEqual(r139, "chat") == true) goto L101;
        if (r144 == true) goto L101;
        if (r123 == null) goto L56;
        AppletAuthTaskMonitor.Session r145 = r123.f34769h;
        if (r145 == null) goto L56;
        GetPhoneNumFlow$getPhoneNumberFlow$phoneMask$1 r146 = new GetPhoneNumFlow$getPhoneNumberFlow$phoneMask$1(r110, r130, null);
        r100.L$0 = r124;
        r100.L$1 = r123;
        r100.L$2 = r130;
        r100.label = 4;
        r102 = r145.f(r146, r100);
        if (r102 != r103) goto L52;
    L101:
        if (r123 == null) goto L111;
        AppletAuthTaskMonitor.Session r147 = r123.f34769h;
        if (r147 == null) goto L111;
        GetPhoneNumFlow$getPhoneNumberFlow$phoneCode$1 r148 = new GetPhoneNumFlow$getPhoneNumberFlow$phoneCode$1(r110, r124, null);
        r100.L$0 = r124;
        r100.L$1 = r123;
        r100.label = 1;
        r102 = r147.f(r148, r100);
        if (r102 == r103) goto L122;
        r133 = r123;
        r134 = r124;
    L111:
        r133 = r123;
        r134 = r124;
        goto L112
    L41:
        r143 = null;
    L32:
        r130 = "";
    L124:
        throw new GetPhoneNumException("Error: appletId is null or empty", -1);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r100 = new GetPhoneNumFlow$getPhoneNumberFlow$1(r110, r210);
        goto L8
    }

    public static final Object c(GetPhoneNumFlow r100, String r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof GetPhoneNumFlow$postPhoneNumUsed$1) == false) goto L7;
        GetPhoneNumFlow$postPhoneNumUsed$1 r103 = (GetPhoneNumFlow$postPhoneNumUsed$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L15;
        if (r107 != 1) goto L14;
        ResultKt.throwOnFailure(r105);     // Catch: Exception -> L19
    L23:
    L22:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r105);
        g.f37637a.i("GetPhoneNumMethod", "postPhoneNumUsed " + r101);
        CoroutineDispatcher r108 = Dispatchers.getIO();     // Catch: Exception -> L19
        GetPhoneNumFlow$postPhoneNumUsed$2 r109 = new GetPhoneNumFlow$postPhoneNumUsed$2(r101, null);     // Catch: Exception -> L19
        r103.label = 1;     // Catch: Exception -> L19
        if (BuildersKt.withContext(r108, r109, r103) != r106) goto L23;
        return r106;
    L19:
        e = move-exception;
        g.f37637a.e("GetPhoneNumMethod", "postPhoneNumUsed failed: " + e.getMessage(), e);
    L7:
        r103 = new GetPhoneNumFlow$postPhoneNumUsed$1(r100, r102);
        goto L8
    }

    public static Object e(String r110, String r111, Continuation r112) {
        j r100 = new j(IntrinsicsKt.intercepted(r112), 1);
        r100.C();
        LoginProcessor.f34725a.getClass();
        com.bytedance.ai.applet.login.j r101 = LoginProcessor.h(r111);
        String r102 = null;
        if (r101 == null) goto L5;
        u2.c r103 = r101.f34762a;
    L6:
        if (r103 == null) goto L11;
        String r104 = r103.f548387b;
        if (r104 == null) goto L11;
        String r105 = r104;
    L12:
        if (r103 == null) goto L14;
        r102 = r103.f548388c;
    L14:
        String r106 = r102;
        l r113 = l.f37675a;
        String r107 = l.e(r113, "larus_appEntry_bottomSheet_Title_phoneNo_cn");
        if (r107 != null) goto L17;
        r107 = "申请获取并验证你的手机号";
    L17:
        String r108 = r107;
        String r109 = l.e(r113, "larus_appEntry_bottomSheet_optionDesc_linkedNo_cn");
        if (r109 != null) goto L20;
        r109 = "豆包绑定号码";
    L20:
        String r114 = r109;
        String r115 = l.e(r113, "larus_cc_call_access_mic_popup_button_not_now");
        if (r115 != null) goto L23;
        r115 = "不允许";
    L23:
        u2.i r116 = new u2.i(Boxing.boxInt(0), r106, r105, r108, "用于登录或注册" + r105 + "账户", r110, r114, r115);
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r117 = AppletRuntimeManager.f36749d;
        if (r117 == null) goto L26;
        r117.F(r116, new b(r100));
    L26:
        r100.i(c.f35794a);
        Object r118 = r100.B();
        if (r118 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
        DebugProbesKt.probeCoroutineSuspended(r112);
    L29:
        return r118;
    L11:
        r105 = r111;
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r110, ParamModel r111, final h r112) {
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetPhoneNumberMethodIDL.a) r111, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        a0 r113 = r110.getContainerContext();
        if (r113 == null) goto L5;
        final String r100 = r113.getAppletId();
    L7:
        if (r100 != null) goto L9;
    L12:
        boolean r101 = true;
    L14:
        if (r101 == false) goto L16;
        g.f37637a.e("GetPhoneNumMethod", "call failed, msg=appletId is null or empty");
        h.a.a(r112, "Error: appletId is null or empty", null, null, 12);
        return;
    L16:
        k r102 = k.f34855a;
        if (r113 == null) goto L19;
        String r103 = r113.getConversationId();
    L20:
        if (r113 == null) goto L22;
        String r114 = r113.getUrl();
    L23:
        Function1 r104 = new com.bytedance.ai.bridge.method.phoneNum.a(r100, r112, this);
        Function0 r105 = new com.bytedance.ai.bridge.method.phoneNum.b(r112);
        r102.getClass();
        if (k.d(r103, r114, r100, "get-phone callback", r104, r105) == false) goto L26;
        g.f37637a.i("GetPhoneNumMethod", "MOA consumed callback, skip normal get-phone-number flow: applet=".concat(r100));
        return;
    L26:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null))), null, null, new AnonymousClass1(this, r110, r112, null), 3, null);
        return;
    L22:
        r114 = null;
        goto L23
    L19:
        r103 = null;
        goto L20
    L9:
        if (r100.length() == 0) goto L12;
        r101 = false;
        goto L14
    L5:
        r100 = null;
        goto L7
    }
}
