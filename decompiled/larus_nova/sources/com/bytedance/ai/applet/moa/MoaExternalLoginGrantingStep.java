package com.bytedance.ai.applet.moa;

import com.bytedance.ai.applet.douyinAuth.DouyinGeneralAuthHelper;
import com.bytedance.ai.applet.granting.GrantingAction;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes43.dex */
public final class MoaExternalLoginGrantingStep implements n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f34789d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u2.f f34790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u2.d f34791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u2.l f34792c;

    public static final class a {
    }

    public static final class b implements Function1<GrantingAction, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<GrantingAction> f34793a;

        public b(kotlinx.coroutines.j r100) {
            this.f34793a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(GrantingAction r100) {
            GrantingAction r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "userAction");
            if (this.f34793a.isActive() == false) goto L6;
            this.f34793a.resumeWith(Result.m9449constructorimpl(r101));
        L6:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.bytedance.ai.applet.moa.n
    public final void a(o r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public final Object b(Continuation<? super Result<Boolean>> r110) {
        if ((r110 instanceof MoaExternalLoginGrantingStep$checkFirstPartyLogin$1) == false) goto L7;
        MoaExternalLoginGrantingStep$checkFirstPartyLogin$1 r100 = (MoaExternalLoginGrantingStep$checkFirstPartyLogin$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L49:
        com.bytedance.ai.applet.douyinAuth.e r112 = (com.bytedance.ai.applet.douyinAuth.e) r111;
        if (r112 != null) goto L54;
        Result.Companion r113 = Result.Companion;
        return Result.m9449constructorimpl(Boxing.boxBoolean(false));
    L54:
        if (r112.f34626b != null) goto L56;
        Result.Companion r104 = Result.Companion;
        return Result.m9449constructorimpl(Boxing.boxBoolean(r112.f34625a));
    L56:
        Result.Companion r105 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException(r112.f34626b)));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        u2.d r114 = this.f34791b;
        if (r114 != null) goto L18;
        Result.Companion r115 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("First-party data is missing")));
    L18:
        String r106 = r114.b();
        if (r106 != null) goto L21;
    L62:
        Result.Companion r116 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalArgumentException("authLink is empty")));
    L21:
        if ((!StringsKt.isBlank(r106)) == true) goto L24;
        r106 = null;
    L24:
        if (r106 == null) goto L62;
        com.bytedance.ai.applet.login.c r107 = com.bytedance.ai.applet.login.a.a(r106);
        String r108 = r107.f34740d;
        if (r108 != null) goto L29;
    L60:
        Result.Companion r117 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalArgumentException("client_key is empty")));
    L29:
        if ((!StringsKt.isBlank(r108)) == true) goto L32;
        r108 = null;
    L32:
        if (r108 == null) goto L60;
        String r109 = r107.f34742f;
        if (r109 != null) goto L37;
    L58:
        Result.Companion r118 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalArgumentException("scope is empty")));
    L37:
        if ((!StringsKt.isBlank(r109)) == true) goto L40;
        r109 = null;
    L40:
        if (r109 == null) goto L58;
        Integer r119 = r114.f();
        if (r119 == null) goto L45;
        long r120 = RangesKt.coerceAtLeast(r119.intValue(), 1);
    L46:
        MoaExternalLoginGrantingStep$checkFirstPartyLogin$status$1 r121 = new MoaExternalLoginGrantingStep$checkFirstPartyLogin$status$1(r108, r109, null);
        r100.label = 1;
        r111 = TimeoutKt.c(r120, r121, r100);
        if (r111 != r102) goto L49;
        return r102;
    L45:
        r120 = 1000;
    L7:
        r100 = new MoaExternalLoginGrantingStep$checkFirstPartyLogin$1(this, r110);
        goto L8
    }

    public final Object d(Continuation<? super Result<Boolean>> r100) {
        if ((r100 instanceof MoaExternalLoginGrantingStep$checkMusicLogin$1) == false) goto L7;
        MoaExternalLoginGrantingStep$checkMusicLogin$1 r101 = (MoaExternalLoginGrantingStep$checkMusicLogin$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L21:
        Result r106 = (Result) r103;
        if (r106 != null) goto L26;
        Result.Companion r107 = Result.Companion;
        return Result.m9449constructorimpl(Boxing.boxBoolean(false));
    L26:
        return r106.m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r108 = AppletRuntimeManager.f36749d;
        if (r108 != null) goto L18;
        Result.Companion r109 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("aiAbility is null")));
    L18:
        MoaExternalLoginGrantingStep$checkMusicLogin$status$1 r110 = new MoaExternalLoginGrantingStep$checkMusicLogin$status$1(r108, null);
        r101.label = 1;
        r103 = TimeoutKt.c(1000, r110, r101);
        if (r103 != r104) goto L21;
        return r104;
    L7:
        r101 = new MoaExternalLoginGrantingStep$checkMusicLogin$1(this, r100);
        goto L8
    }

    @Override // com.bytedance.ai.applet.moa.n
    public final Object c(o r100, Continuation<? super MoaStepResult> r101) {
        if (this.f34791b == null) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L10;
        return e(r100, r101);
    L10:
        return f(r100, r101);
    L5:
        r102 = false;
        goto L6
    }

    public final Object e(o r210, Continuation<? super MoaStepResult> r211) {
        if ((r211 instanceof MoaExternalLoginGrantingStep$requestFirstPartyLogin$1) == false) goto L7;
        MoaExternalLoginGrantingStep$requestFirstPartyLogin$1 r100 = (MoaExternalLoginGrantingStep$requestFirstPartyLogin$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        MoaExternalLoginGrantingStep$requestFirstPartyLogin$1 r110 = r100;
        Object r102 = r110.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r110.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L58:
        com.bytedance.ai.applet.douyinAuth.d r105 = (com.bytedance.ai.applet.douyinAuth.d) r102;
        if (r105.f34624b == null) goto L63;
        com.bytedance.ai.utils.g.f37637a.e("MoaExternalLoginStep", "First-party login failed: " + r105.f34624b);
        return MoaStepResult.FAILED;
    L63:
        return e.a(r105.f34623a, this.f34790a.f());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        u2.d r106 = this.f34791b;
        if (r106 == null) goto L17;
        String r107 = r106.b();
        if (r107 == null) goto L69;
        String r108 = null;
        if ((!StringsKt.isBlank(r107)) == true) goto L24;
        r107 = null;
    L24:
        if (r107 == null) goto L69;
        com.bytedance.ai.applet.login.c r109 = com.bytedance.ai.applet.login.a.a(r107);
        String r111 = r109.f34740d;
        if (r111 == null) goto L67;
        if ((!StringsKt.isBlank(r111)) == true) goto L32;
        r111 = null;
    L32:
        if (r111 == null) goto L67;
        String r112 = r109.f34742f;
        if (r112 == null) goto L65;
        if ((!StringsKt.isBlank(r112)) == false) goto L39;
        r108 = r112;
    L39:
        if (r108 == null) goto L65;
        u2.e r113 = r210.f34866a;
        HashMap r114 = new HashMap();
        r114.put("current_page", "chat");
        r114.put("source", "doubao_apps_auth_request");
        String r115 = r113.d();
        if (r115 != null) goto L44;
        r115 = "";
    L44:
        r114.put("app_key", r115);
        String r116 = r113.e();
        if (r116 != null) goto L47;
        r116 = "";
    L47:
        r114.put("app_name", r116);
        String r117 = r113.e();
        if (r117 != null) goto L50;
        String r118 = "";
    L51:
        String r119 = r106.d();
        if (r119 != null) goto L54;
        String r120 = "";
    L55:
        u2.i r121 = new u2.i(null, null, r118, "需绑定抖音账号", r120, "立即绑定抖音", "以后再说");
        DouyinGeneralAuthHelper r122 = DouyinGeneralAuthHelper.f34616a;
        r110.label = 1;
        r102 = r122.d(r111, r108, r114, r121, "chat", null, null, r110);
        if (r102 != r103) goto L58;
        return r103;
    L54:
        r120 = r119;
        goto L55
    L50:
        r118 = r117;
    L65:
        return MoaStepResult.FAILED;
    L67:
        return MoaStepResult.FAILED;
    L69:
        return MoaStepResult.FAILED;
    L17:
        return MoaStepResult.FAILED;
    L7:
        r100 = new MoaExternalLoginGrantingStep$requestFirstPartyLogin$1(this, r211);
        goto L8
    }

    public final Object f(o r110, Continuation<? super MoaStepResult> r111) {
        if ((r111 instanceof MoaExternalLoginGrantingStep$requestMusicLogin$1) == false) goto L7;
        MoaExternalLoginGrantingStep$requestMusicLogin$1 r100 = (MoaExternalLoginGrantingStep$requestMusicLogin$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        HashMap r113 = (HashMap) r100.L$4;
        g2.b r114 = (g2.b) r100.L$3;
        String r115 = (String) r100.L$2;
        String r116 = (String) r100.L$1;
        String r117 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L66:
        return e.a((GrantingAction) r112, this.f34790a.f());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        u2.l r118 = this.f34792c;
        if (r118 == null) goto L17;
        String r119 = r118.b();
        if (r119 == null) goto L74;
        String r104 = null;
        if ((!StringsKt.isBlank(r119)) == true) goto L24;
        r119 = null;
    L24:
        if (r119 == null) goto L74;
        com.bytedance.ai.applet.login.c r120 = com.bytedance.ai.applet.login.a.a(r119);
        String r105 = r120.f34740d;
        if (r105 == null) goto L72;
        if ((!StringsKt.isBlank(r105)) == true) goto L32;
        r105 = null;
    L32:
        if (r105 == null) goto L72;
        String r106 = r120.f34742f;
        if (r106 == null) goto L70;
        if ((!StringsKt.isBlank(r106)) == true) goto L40;
        r106 = null;
    L40:
        if (r106 == null) goto L70;
        String r121 = r120.f34739c;
        if (r121 == null) goto L68;
        if ((!StringsKt.isBlank(r121)) == false) goto L47;
        r104 = r121;
    L47:
        if (r104 == null) goto L68;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r122 = AppletRuntimeManager.f36749d;
        if (r122 == null) goto L52;
        u2.e r123 = r110.f34866a;
        HashMap r107 = new HashMap();
        r107.put("current_page", "chat");
        r107.put("source", "doubao_apps_auth_request");
        String r108 = r123.d();
        String r109 = "";
        if (r108 != null) goto L56;
        r108 = "";
    L56:
        r107.put("app_key", r108);
        String r124 = r123.e();
        if (r124 == null) goto L60;
        r109 = r124;
    L60:
        r107.put("app_name", r109);
        r100.L$0 = r105;
        r100.L$1 = r106;
        r100.L$2 = r104;
        r100.L$3 = r122;
        r100.L$4 = r107;
        r100.label = 1;
        kotlinx.coroutines.j r125 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r100), 1);
        r125.C();
        r122.H(new com.bytedance.ai.applet.login.i(r105, r106, r104, r107), new b(r125));
        r112 = r125.B();
        if (r112 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L63;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L63:
        if (r112 != r102) goto L66;
        return r102;
    L52:
        return MoaStepResult.FAILED;
    L68:
        return MoaStepResult.FAILED;
    L70:
        return MoaStepResult.FAILED;
    L72:
        return MoaStepResult.FAILED;
    L74:
        return MoaStepResult.FAILED;
    L17:
        return MoaStepResult.FAILED;
    L7:
        r100 = new MoaExternalLoginGrantingStep$requestMusicLogin$1(this, r111);
        goto L8
    }

    public MoaExternalLoginGrantingStep(u2.f r100, u2.d r101, u2.l r102) {
        this.f34790a = r100;
        this.f34791b = r101;
        this.f34792c = r102;
    }

    @Override // com.bytedance.ai.applet.moa.n
    public final Object g(o r100, boolean r101, Continuation<? super MoaStepResult> r102) {
        if ((r102 instanceof MoaExternalLoginGrantingStep$handleAction$1) == false) goto L7;
        MoaExternalLoginGrantingStep$handleAction$1 r103 = (MoaExternalLoginGrantingStep$handleAction$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 == 1) goto L15;
        if (r107 == 2) goto L15;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r101 = r103.Z$0;
        ResultKt.throwOnFailure(r105);
        Object r108 = ((Result) r105).m9458unboximpl();
    L27:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L30;
        com.bytedance.ai.utils.g.f37637a.e("MoaExternalLoginStep", "Failed to query external login status", r109);
        return MoaStepResult.FAILED;
    L30:
        if (((Boolean) r108).booleanValue() == true) goto L41;
        if (r101 == false) goto L34;
    L36:
        if (r101 == true) goto L44;
        return MoaStepResult.CONTINUE;
    L44:
        return MoaStepResult.REQUIRES_CONFIRMATION;
    L34:
        if (this.f34790a.f() == false) goto L36;
        return MoaStepResult.REFUSED;
    L41:
        return MoaStepResult.CONTINUE;
    L16:
        ResultKt.throwOnFailure(r105);
        if (this.f34791b == null) goto L19;
        boolean r110 = true;
    L20:
        if (r110 == false) goto L24;
        r103.Z$0 = r101;
        r103.label = 1;
        r108 = b(r103);
        if (r108 != r106) goto L27;
        return r106;
    L24:
        r103.Z$0 = r101;
        r103.label = 2;
        r108 = d(r103);
        if (r108 != r106) goto L27;
        return r106;
    L19:
        r110 = false;
    L7:
        r103 = new MoaExternalLoginGrantingStep$handleAction$1(this, r102);
        goto L8
    }
}
