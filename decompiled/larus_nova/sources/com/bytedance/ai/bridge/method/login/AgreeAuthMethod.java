package com.bytedance.ai.bridge.method.login;

import com.bytedance.ai.applet.granting.GrantingAction;
import com.bytedance.ai.applet.login.LoginProcessor;
import com.bytedance.ai.applet.login.OperationType;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.privacySetting.AbsAgreePrivacyAuthorizationMethodIDL;
import com.bytedance.ai.bridge.remote.UserAuthService;
import d3.a0;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/login/AgreeAuthMethod;", "Lcom/bytedance/ai/bridge/privacySetting/AbsAgreePrivacyAuthorizationMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/privacySetting/AbsAgreePrivacyAuthorizationMethodIDL$EmptyMessageModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/privacySetting/AbsAgreePrivacyAuthorizationMethodIDL$AgreePrivacyResultModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AgreeAuthMethod extends AbsAgreePrivacyAuthorizationMethodIDL {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f35536b = 0;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.login.AgreeAuthMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.login.AgreeAuthMethod$handle$1", f = "AgreeAuthMethod.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appletId;
        final /* synthetic */ f3.h<AbsAgreePrivacyAuthorizationMethodIDL.a> $callback;
        int label;

        public AnonymousClass1(String r100, f3.h<AbsAgreePrivacyAuthorizationMethodIDL.a> r101, Continuation<? super AnonymousClass1> r102) {
            this.$appletId = r100;
            this.$callback = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$appletId, this.$callback, r101);
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
            ResultKt.throwOnFailure(r100);     // Catch: Exception -> L15
            ((Result) r100).m9458unboximpl();     // Catch: Exception -> L15
        L13:
            LoginProcessor r103 = LoginProcessor.f34725a;     // Catch: Exception -> L15
            String r104 = this.$appletId;     // Catch: Exception -> L15
            GrantingAction r105 = GrantingAction.AGREED;     // Catch: Exception -> L15
            OperationType r106 = OperationType.PRIVACY;     // Catch: Exception -> L15
            r103.getClass();     // Catch: Exception -> L15
            LoginProcessor.i(r104, r105, r106);     // Catch: Exception -> L15
            com.bytedance.ai.utils.g.f37637a.d("AgreeAuthMethod", "privacy authorization agreed");     // Catch: Exception -> L15
            f3.h<AbsAgreePrivacyAuthorizationMethodIDL.a> r107 = this.$callback;     // Catch: Exception -> L15
            Intrinsics.checkNotNullParameter(AbsAgreePrivacyAuthorizationMethodIDL.a.class, "<this>");     // Catch: Exception -> L15
            BaseModel r108 = k3.c.a(AbsAgreePrivacyAuthorizationMethodIDL.a.class);     // Catch: Exception -> L15
            ((AbsAgreePrivacyAuthorizationMethodIDL.a) r108).setResult(true);     // Catch: Exception -> L15
            f3.h.a.b(r107, (ResultModel) r108);     // Catch: Exception -> L15
        L18:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r100);
            UserAuthService r109 = UserAuthService.f36075a;     // Catch: Exception -> L15
            String r110 = this.$appletId;     // Catch: Exception -> L15
            this.label = 1;     // Catch: Exception -> L15
            if (r109.a(r110, null, this) != r101) goto L13;
            return r101;
        L15:
            e = move-exception;
            com.bytedance.ai.utils.g.f37637a.e("AgreeAuthMethod", "agree privacy authorization failed", e);
            f3.h.a.a(this.$callback, "Error: " + e.getMessage(), null, null, 14);
            goto L18
        }
    }

    static {
    }

    public AgreeAuthMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r110, ParamModel r111, final f3.h r112) {
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsAgreePrivacyAuthorizationMethodIDL.b) r111, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        a0 r113 = r110.getContainerContext();
        a0 r100 = r110.getContainerContext();
        if (r100 == null) goto L5;
        String r101 = r100.getAppId();
    L6:
        a0 r114 = r110.getContainerContext();
        if (r114 == null) goto L9;
        final String r115 = r114.getAppletId();
    L10:
        if (r115 != null) goto L12;
    L15:
        boolean r102 = true;
    L17:
        if (r102 == false) goto L19;
        com.bytedance.ai.utils.g.f37637a.e("AgreeAuthMethod", "appletId is null or empty");
        f3.h.a.a(r112, "Error: appletId is null or empty", null, null, 14);
        return;
    L19:
        com.bytedance.ai.utils.g r103 = com.bytedance.ai.utils.g.f37637a;
        r103.i("AgreeAuthMethod", "handle app: " + r101 + ", applet: " + r115 + " agreePrivacyAuthorization");
        com.bytedance.ai.applet.moa.k r104 = com.bytedance.ai.applet.moa.k.f34855a;
        if (r113 == null) goto L22;
        String r105 = r113.getConversationId();
    L23:
        if (r113 == null) goto L25;
        String r106 = r113.getUrl();
    L26:
        Function1 r107 = new com.bytedance.ai.bridge.method.login.a(r115, r112);
        Function0 r108 = new b(r112);
        r104.getClass();
        if (com.bytedance.ai.applet.moa.k.d(r105, r106, r115, "privacy agreement", r107, r108) == false) goto L29;
        r103.i("AgreeAuthMethod", "MOA consumed callback, skip normal privacy agreement flow: applet=".concat(r115));
        return;
    L29:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(r115, r112, null), 3, null);
        return;
    L25:
        r106 = null;
        goto L26
    L22:
        r105 = null;
        goto L23
    L12:
        if (r115.length() == 0) goto L15;
        r102 = false;
        goto L17
    L9:
        r115 = null;
        goto L10
    L5:
        r101 = null;
        goto L6
    }
}
