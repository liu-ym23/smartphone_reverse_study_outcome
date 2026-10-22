package com.bytedance.ai.bridge.method.login;

import com.bytedance.ai.applet.login.LoginProcessor;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.privacySetting.AbsGetPrivacySettingMethodIDL;
import com.bytedance.ai.bridge.remote.UserAuthService;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import d3.a0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/bridge/method/login/GetPrivacySettingMethod;", "Lcom/bytedance/ai/bridge/privacySetting/AbsGetPrivacySettingMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/privacySetting/AbsGetPrivacySettingMethodIDL$EmptyMessageModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/privacySetting/AbsGetPrivacySettingMethodIDL$PrivacySettingResultModel;", "checkPrivacy", "", IFlowAppIntentIDL.PARAM_APPLET_ID, "", "versionTag", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetPrivacySettingMethod extends AbsGetPrivacySettingMethodIDL {

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.login.GetPrivacySettingMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.login.GetPrivacySettingMethod$handle$1", f = "GetPrivacySettingMethod.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appletId;
        final /* synthetic */ f3.h<AbsGetPrivacySettingMethodIDL.b> $callback;
        final /* synthetic */ String $versionTag;
        int label;
        final /* synthetic */ GetPrivacySettingMethod this$0;

        public AnonymousClass1(GetPrivacySettingMethod r100, String r101, String r102, f3.h<AbsGetPrivacySettingMethodIDL.b> r103, Continuation<? super AnonymousClass1> r104) {
            this.this$0 = r100;
            this.$appletId = r101;
            this.$versionTag = r102;
            this.$callback = r103;
            super(2, r104);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, this.$appletId, this.$versionTag, this.$callback, r101);
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
            boolean r103 = true;
            if (r102 == 0) goto L9;
            if (r102 != 1) goto L8;
            ResultKt.throwOnFailure(r100);     // Catch: Exception -> L23
        L13:
            boolean r104 = ((Boolean) r100).booleanValue();     // Catch: Exception -> L23
            com.bytedance.ai.utils.g r105 = com.bytedance.ai.utils.g.f37637a;     // Catch: Exception -> L23
            StringBuilder r106 = new StringBuilder("call success, needAuthorization=");     // Catch: Exception -> L23
            if (r104 == true) goto L16;
            boolean r107 = true;
        L17:
            r106.append(r107);     // Catch: Exception -> L23
            r105.i("AISDK_JSB_GetPrivacySettingMethod", r106.toString());     // Catch: Exception -> L23
            f3.h<AbsGetPrivacySettingMethodIDL.b> r108 = this.$callback;     // Catch: Exception -> L23
            Intrinsics.checkNotNullParameter(AbsGetPrivacySettingMethodIDL.b.class, "<this>");     // Catch: Exception -> L23
            BaseModel r109 = k3.c.a(AbsGetPrivacySettingMethodIDL.b.class);     // Catch: Exception -> L23
            AbsGetPrivacySettingMethodIDL.b r110 = (AbsGetPrivacySettingMethodIDL.b) r109;     // Catch: Exception -> L23
            if (r104 == false) goto L21;
            r103 = false;
        L21:
            r110.setNeedAuthorization(r103);     // Catch: Exception -> L23
            f3.h.a.b(r108, (ResultModel) r109);     // Catch: Exception -> L23
        L26:
            return Unit.INSTANCE;
        L16:
            r107 = false;
            goto L17
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r100);
            GetPrivacySettingMethod r111 = this.this$0;     // Catch: Exception -> L23
            String r112 = this.$appletId;     // Catch: Exception -> L23
            String r113 = this.$versionTag;     // Catch: Exception -> L23
            this.label = 1;     // Catch: Exception -> L23
            r100 = GetPrivacySettingMethod.b(r111, r112, r113, this);     // Catch: Exception -> L23
            if (r100 != r101) goto L13;
            return r101;
        L23:
            e = move-exception;
            com.bytedance.ai.utils.g r114 = com.bytedance.ai.utils.g.f37637a;
            StringBuilder r115 = new StringBuilder("call failed, errNo=");
            f3.a r116 = f3.a.f475265f;
            r115.append(r116.f475285a);
            r115.append(", msg=check privacy error");
            r114.e("AISDK_JSB_GetPrivacySettingMethod", r115.toString(), e);
            f3.h.a.a(this.$callback, "Error: " + e.getMessage(), r116, null, 10);
            goto L26
        }
    }

    static {
    }

    public GetPrivacySettingMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r110, ParamModel r111, f3.h r112) {
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetPrivacySettingMethodIDL.a) r111, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        a0 r113 = r110.getContainerContext();
        if (r113 == null) goto L5;
        String r114 = r113.getAppId();
    L6:
        a0 r115 = r110.getContainerContext();
        if (r115 == null) goto L9;
        String r100 = r115.getAppletId();
    L10:
        com.bytedance.ai.utils.g r116 = com.bytedance.ai.utils.g.f37637a;
        r116.i("AISDK_JSB_GetPrivacySettingMethod", "call start, appId=" + r114 + ", appletId=" + r100);
        if (r100 != null) goto L13;
    L16:
        boolean r117 = true;
    L17:
        if (r117 == false) goto L19;
        StringBuilder r118 = new StringBuilder("call failed, errNo=");
        f3.a r101 = f3.a.f475265f;
        r118.append(r101.f475285a);
        r118.append(", msg=Error: appletId is null or empty");
        r116.e("AISDK_JSB_GetPrivacySettingMethod", r118.toString());
        f3.h.a.a(r112, "Error: appletId is null or empty", r101, null, 10);
        return;
    L19:
        LoginProcessor.f34725a.getClass();
        com.bytedance.ai.applet.login.j r119 = LoginProcessor.h(r100);
        if (r119 == null) goto L25;
        u2.c r120 = r119.f34762a;
        if (r120 == null) goto L25;
        String r121 = r120.f548389d;
        if (r121 == null) goto L25;
    L26:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(this, r100, r121, r112, null), 3, null);
        return;
    L25:
        r121 = "null";
        goto L26
    L13:
        if (r100.length() == 0) goto L16;
        r117 = false;
        goto L17
    L9:
        r100 = null;
        goto L10
    L5:
        r114 = null;
        goto L6
    }

    public static final Object b(GetPrivacySettingMethod r100, String r101, String r102, Continuation r103) {
        r100.getClass();
        if ((r103 instanceof GetPrivacySettingMethod$checkPrivacy$1) == false) goto L7;
        GetPrivacySettingMethod$checkPrivacy$1 r104 = (GetPrivacySettingMethod$checkPrivacy$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L15;
        if (r108 != 1) goto L14;
        ResultKt.throwOnFailure(r106);     // Catch: Exception -> L30
        Object r109 = ((Result) r106).m9458unboximpl();     // Catch: Exception -> L30
    L20:
        if (Result.m9455isFailureimpl(r109) == false) goto L22;
        Object r110 = null;
    L23:
        Boolean r111 = (Boolean) r110;     // Catch: Exception -> L30
        if (r111 == null) goto L26;
        boolean r112 = r111.booleanValue();     // Catch: Exception -> L30
    L33:
        return Boxing.boxBoolean(r112);
    L26:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Exception -> L30
        if (r113 == null) goto L29;
        throw r113;     // Catch: Exception -> L30
    L29:
        throw new Exception("check result is null, but no error message");     // Catch: Exception -> L30
    L22:
        r110 = r109;
        goto L23
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r106);
        UserAuthService r114 = UserAuthService.f36075a;     // Catch: Exception -> L30
        r104.label = 1;     // Catch: Exception -> L30
        r109 = r114.d(r101, r102, r104);     // Catch: Exception -> L30
        if (r109 != r107) goto L20;
        return r107;
    L30:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.e("AISDK_JSB_GetPrivacySettingMethod", "checkPrivacy failed " + e.getMessage());
        r112 = false;
    L7:
        r104 = new GetPrivacySettingMethod$checkPrivacy$1(r100, r103);
        goto L8
    }
}
