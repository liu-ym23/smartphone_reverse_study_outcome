package com.bytedance.ai.bridge.method.login;

import com.bytedance.ai.applet.login.CustomLoginNavigator;
import com.bytedance.ai.applet.login.LoginProcessor;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.openLoginPage.AbsOpenLoginPageMethodIDL;
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
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/login/OpenLoginPageMethod;", "Lcom/bytedance/ai/bridge/openLoginPage/AbsOpenLoginPageMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/openLoginPage/AbsOpenLoginPageMethodIDL$OpenLoginPageRequestModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/openLoginPage/AbsOpenLoginPageMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenLoginPageMethod extends AbsOpenLoginPageMethodIDL {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f35542b = 0;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.login.OpenLoginPageMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.login.OpenLoginPageMethod$handle$1", f = "OpenLoginPageMethod.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appletId;
        final /* synthetic */ f3.h<AbsOpenLoginPageMethodIDL.a> $callback;
        final /* synthetic */ AbsOpenLoginPageMethodIDL.b $params;
        int label;

        public AnonymousClass1(String r100, AbsOpenLoginPageMethodIDL.b r101, f3.h<AbsOpenLoginPageMethodIDL.a> r102, Continuation<? super AnonymousClass1> r103) {
            this.$appletId = r100;
            this.$params = r101;
            this.$callback = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$appletId, this.$params, this.$callback, r101);
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
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ResultKt.throwOnFailure(r110);
            Object r111 = ((Result) r110).m9458unboximpl();
        L47:
            f3.h<AbsOpenLoginPageMethodIDL.a> r102 = this.$callback;
            if (Result.m9456isSuccessimpl(r111) == false) goto L50;
            Unit r103 = (Unit) r111;
            Intrinsics.checkNotNullParameter(AbsOpenLoginPageMethodIDL.a.class, "<this>");
            f3.h.a.b(r102, (ResultModel) k3.c.a(AbsOpenLoginPageMethodIDL.a.class));
        L50:
            f3.h<AbsOpenLoginPageMethodIDL.a> r104 = this.$callback;
            Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
            if (r112 == null) goto L57;
            com.bytedance.ai.utils.g.f37637a.e("OpenLoginPageMethod", "openLoginPage failed: " + r112.getMessage());
            String r113 = r112.getMessage();
            if (r113 != null) goto L55;
            r113 = "openLoginPage failed";
        L55:
            f3.h.a.a(r104, r113, null, null, 14);
        L57:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            LoginProcessor r114 = LoginProcessor.f34725a;
            String r105 = this.$appletId;
            r114.getClass();
            com.bytedance.ai.applet.login.j r115 = LoginProcessor.h(r105);
            if (r115 != null) goto L11;
            com.bytedance.ai.utils.g.f37637a.w("OpenLoginPageMethod", "open login page without loginContext: appletId=" + this.$appletId);
        L11:
            if (r115 == null) goto L13;
            String r106 = r115.f34767f;
        L14:
            CustomLoginNavigator r107 = CustomLoginNavigator.f34707a;
            String r108 = this.$appletId;
            if (r115 == null) goto L21;
            u2.c r109 = r115.f34762a;
            if (r109 == null) goto L21;
            u2.b r116 = r109.f548391f;
            if (r116 == null) goto L21;
            String r117 = r116.f548379a;
        L22:
            if (r115 == null) goto L28;
            u2.c r118 = r115.f34762a;
            if (r118 == null) goto L28;
            u2.b r119 = r118.f548391f;
            if (r119 == null) goto L28;
            String r120 = r119.f548382d;
        L29:
            if (r115 == null) goto L35;
            u2.c r121 = r115.f34762a;
            if (r121 == null) goto L35;
            u2.b r122 = r121.f548391f;
            if (r122 == null) goto L35;
            String r123 = r122.f548383e;
        L36:
            String r124 = this.$params.getUrl();
            CustomLoginNavigator.LaunchSource.Companion.getClass();
            if (Intrinsics.areEqual(r106, "chat") == false) goto L41;
            CustomLoginNavigator.LaunchSource r125 = CustomLoginNavigator.LaunchSource.CHAT;
        L39:
            CustomLoginNavigator.LaunchSource r126 = r125;
            CustomLoginNavigator.LaunchReason r127 = CustomLoginNavigator.LaunchReason.OTHER_LOGIN_METHOD;
            this.label = 1;
            r111 = r107.b(r108, r117, r120, r123, r124, r126, r127, this);
            if (r111 != r100) goto L47;
            return r100;
        L41:
            if (Intrinsics.areEqual(r106, "detail") == false) goto L43;
            r125 = CustomLoginNavigator.LaunchSource.FULL_PAGE;
            goto L39
        L43:
            r125 = CustomLoginNavigator.LaunchSource.UNKNOWN;
        L35:
            r123 = null;
        L28:
            r120 = null;
        L21:
            r117 = null;
            goto L22
        L13:
            r106 = null;
            goto L14
        }
    }

    static {
    }

    public OpenLoginPageMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r110, final f3.h r111) {
        final AbsOpenLoginPageMethodIDL.b r112 = (AbsOpenLoginPageMethodIDL.b) r110;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        a0 r101 = r100.getContainerContext();
        a0 r102 = r100.getContainerContext();
        if (r102 == null) goto L18;
        final String r103 = r102.getAppletId();
        if (r103 == null) goto L18;
        com.bytedance.ai.applet.moa.k r104 = com.bytedance.ai.applet.moa.k.f34855a;
        if (r101 == null) goto L10;
        String r105 = r101.getConversationId();
    L11:
        if (r101 == null) goto L13;
        String r106 = r101.getUrl();
    L14:
        Function1 r107 = new j(r103, r112, r111);
        Function0 r108 = new k(r111);
        r104.getClass();
        if (com.bytedance.ai.applet.moa.k.d(r105, r106, r103, "open-login flow", r107, r108) == false) goto L17;
        com.bytedance.ai.utils.g.f37637a.i("OpenLoginPageMethod", "MOA consumed callback, skip normal open-login-page flow: applet=".concat(r103));
        return;
    L17:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(r103, r112, r111, null), 3, null);
        return;
    L13:
        r106 = null;
        goto L14
    L10:
        r105 = null;
    L18:
        f3.h.a.a(r111, "appId is null", null, null, 14);
    }
}
