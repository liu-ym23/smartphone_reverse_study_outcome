package com.bytedance.ai.applet.moa;

import android.content.Context;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ai.applet.granting.GrantStatus;
import com.bytedance.ai.bridge.remote.UserAuthService;
import com.bytedance.ai.bridge.remote.model.AppletPermissionDetail;
import com.bytedance.ai.bridge.remote.model.ScopePermissionInfo;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class MoaPermissionGrantingStep implements n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f34827c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u2.f f34828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u2.k f34829b;

    public static final class a {
    }

    public static final class b implements Function1<Boolean, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<Boolean> f34830a;

        public b(kotlinx.coroutines.j r100) {
            this.f34830a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Boolean r100) {
            boolean r101 = r100.booleanValue();
            if (this.f34830a.isActive() == false) goto L6;
            Boolean r102 = Boolean.valueOf(r101);
            this.f34830a.resumeWith(Result.m9449constructorimpl(r102));
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

    public MoaPermissionGrantingStep(u2.f r100, u2.k r101) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "relatedData");
        this.f34828a = r100;
        this.f34829b = r101;
    }

    @Override // com.bytedance.ai.applet.moa.n
    public final Object c(o r100, Continuation<? super MoaStepResult> r101) {
        if ((r101 instanceof MoaPermissionGrantingStep$requestConfirmation$1) == false) goto L7;
        MoaPermissionGrantingStep$requestConfirmation$1 r102 = (MoaPermissionGrantingStep$requestConfirmation$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        g2.b r107 = (g2.b) r102.L$2;
        String r108 = (String) r102.L$1;
        o r109 = (o) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L39:
        if (((Boolean) r104).booleanValue() == false) goto L42;
        return MoaStepResult.CONTINUE;
    L42:
        if (this.f34828a.f() == false) goto L45;
        return MoaStepResult.REFUSED;
    L45:
        return MoaStepResult.CONTINUE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        String r110 = this.f34829b.c();
        if (r110 == null) goto L47;
        Context r111 = null;
        if ((!StringsKt.isBlank(r110)) == true) goto L20;
        r110 = null;
    L20:
        if (r110 == null) goto L47;
        String r112 = com.bytedance.ai.applet.permission.h.b(r110);
        if (r112 == null) goto L25;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r113 = AppletRuntimeManager.f36749d;
        if (r113 == null) goto L29;
        r102.L$0 = r100;
        r102.L$1 = r112;
        r102.L$2 = r113;
        r102.label = 1;
        kotlinx.coroutines.j r114 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r102), 1);
        r114.C();
        WeakReference<Context> r115 = r100.f34869d;
        if (r115 == null) goto L33;
        r111 = r115.get();
    L33:
        r113.y(r111, r112, new b(r114));
        r104 = r114.B();
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L36;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L36:
        if (r104 != r105) goto L39;
        return r105;
    L29:
        return MoaStepResult.FAILED;
    L25:
        return MoaStepResult.FAILED;
    L47:
        return MoaStepResult.FAILED;
    L7:
        r102 = new MoaPermissionGrantingStep$requestConfirmation$1(this, r101);
        goto L8
    }

    public final Object b(String r100, String r101, Continuation<? super Result<? extends GrantStatus>> r102) {
        if ((r102 instanceof MoaPermissionGrantingStep$fetchPermissionStatus$1) == false) goto L7;
        MoaPermissionGrantingStep$fetchPermissionStatus$1 r103 = (MoaPermissionGrantingStep$fetchPermissionStatus$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r101 = (String) r103.L$1;
        r100 = (String) r103.L$0;
        ResultKt.throwOnFailure(r105);
        Object r108 = ((Result) r105).m9458unboximpl();
    L18:
        if (Result.m9456isSuccessimpl(r108) == false) goto L40;
        Iterator r109 = ((List) r108).iterator();     // Catch: Throwable -> L37
    L21:
        if (r109.hasNext() == false) goto L25;
        Object r110 = r109.next();     // Catch: Throwable -> L37
        if (Intrinsics.areEqual(((AppletPermissionDetail) r110).getAppletId(), r100) == false) goto L21;
    L26:
        AppletPermissionDetail r111 = (AppletPermissionDetail) r110;     // Catch: Throwable -> L37
        if (r111 == null) goto L36;
        Map<String, ScopePermissionInfo> r112 = r111.getScopesStatus();     // Catch: Throwable -> L37
        if (r112 == null) goto L34;
        ScopePermissionInfo r113 = r112.get(r101);     // Catch: Throwable -> L37
        if (r113 == null) goto L34;
        GrantStatus.a r114 = GrantStatus.Companion;     // Catch: Throwable -> L37
        Integer r115 = r113.getGrantStatus();     // Catch: Throwable -> L37
        r114.getClass();     // Catch: Throwable -> L37
        return Result.m9449constructorimpl(GrantStatus.a.a(r115));
    L34:
        throw new IllegalStateException(("Permission status is missing for " + r101).toString());     // Catch: Throwable -> L37
    L36:
        throw new IllegalStateException(("Permission detail is missing for " + r100).toString());     // Catch: Throwable -> L37
    L25:
        r110 = null;
    L37:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(th));
    L40:
        return Result.m9449constructorimpl(r108);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        UserAuthService r117 = UserAuthService.f36075a;
        List r118 = CollectionsKt.listOf(r100);
        List r119 = CollectionsKt.listOf(r101);
        r103.L$0 = r100;
        r103.L$1 = r101;
        r103.label = 1;
        r108 = UserAuthService.p(r118, r119, r103);
        if (r108 != r106) goto L18;
        return r106;
    L7:
        r103 = new MoaPermissionGrantingStep$fetchPermissionStatus$1(this, r102);
        goto L8
    }

    @Override // com.bytedance.ai.applet.moa.n
    public final Object g(o r100, boolean r110, Continuation<? super MoaStepResult> r111) {
        if ((r111 instanceof MoaPermissionGrantingStep$handleAction$1) == false) goto L7;
        MoaPermissionGrantingStep$handleAction$1 r101 = (MoaPermissionGrantingStep$handleAction$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L18;
        if (r104 == 1) goto L17;
        if (r104 == 2) goto L16;
        if (r104 != 3) goto L15;
        ResultKt.throwOnFailure(r112);
        Object r105 = ((Result) r112).m9458unboximpl();
    L61:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r105);
        if (r113 == null) goto L64;
        com.bytedance.ai.utils.g.f37637a.e("MoaPermissionGrantingStep", "Failed to post granted permission status", r113);
        return MoaStepResult.FAILED;
    L64:
        if (((Boolean) r105).booleanValue() == true) goto L70;
        return MoaStepResult.FAILED;
    L70:
        return MoaStepResult.REQUIRES_CONFIRMATION;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r112);
        Object r106 = ((Result) r112).m9458unboximpl();
    L43:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r106);
        if (r114 == null) goto L46;
        com.bytedance.ai.utils.g.f37637a.e("MoaPermissionGrantingStep", "Failed to post denied permission status", r114);
        return MoaStepResult.FAILED;
    L46:
        if (((Boolean) r106).booleanValue() == true) goto L50;
        return MoaStepResult.FAILED;
    L50:
        if (this.f34828a.f() == false) goto L53;
        return MoaStepResult.REFUSED;
    L53:
        return MoaStepResult.CONTINUE;
    L17:
        r110 = r101.Z$0;
        String r107 = (String) r101.L$1;
        String r108 = (String) r101.L$0;
        ResultKt.throwOnFailure(r112);
        Object r115 = ((Result) r112).m9458unboximpl();
    L32:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r115);
        if (r109 != null) goto L71;
        GrantStatus r116 = (GrantStatus) r115;
        if (r110 == false) goto L37;
        GrantStatus r117 = GrantStatus.GRANTED;
        if (r116 == r117) goto L70;
        r101.L$0 = null;
        r101.L$1 = null;
        r101.label = 3;
        r105 = d(r107, r108, r117, r101);
        if (r105 != r103) goto L61;
        return r103;
    L37:
        if (r116 == GrantStatus.GRANTED) goto L39;
        GrantStatus r118 = GrantStatus.DENIED;
        r101.L$0 = null;
        r101.L$1 = null;
        r101.label = 2;
        r106 = d(r107, r108, r118, r101);
        if (r106 != r103) goto L43;
        return r103;
    L39:
        return MoaStepResult.REFUSED;
    L71:
        com.bytedance.ai.utils.g.f37637a.e("MoaPermissionGrantingStep", "Failed to query permission status", r109);
        return MoaStepResult.FAILED;
    L18:
        ResultKt.throwOnFailure(r112);
        String r119 = this.f34829b.c();
        if (r119 != null) goto L21;
    L73:
        com.bytedance.ai.utils.g.f37637a.e("MoaPermissionGrantingStep", "scopeName is empty");
        return MoaStepResult.FAILED;
    L21:
        if ((!StringsKt.isBlank(r119)) == false) goto L23;
        r108 = r119;
    L24:
        if (r108 == null) goto L73;
        r107 = r100.f34866a.d();
        if (r107 != null) goto L29;
        r107 = "";
    L29:
        r101.L$0 = r108;
        r101.L$1 = r107;
        r101.Z$0 = r110;
        r101.label = 1;
        r115 = b(r107, r108, r101);
        if (r115 != r103) goto L32;
        return r103;
    L23:
        r108 = null;
    L7:
        r101 = new MoaPermissionGrantingStep$handleAction$1(this, r111);
        goto L8
    }

    public final Object d(String r100, String r101, GrantStatus r102, Continuation<? super Result<Boolean>> r103) {
        if ((r103 instanceof MoaPermissionGrantingStep$postPermissionStatus$1) == false) goto L7;
        MoaPermissionGrantingStep$postPermissionStatus$1 r104 = (MoaPermissionGrantingStep$postPermissionStatus$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        ResultKt.throwOnFailure(r106);
        return ((Result) r106).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        UserAuthService r109 = UserAuthService.f36075a;
        Integer r110 = Boxing.boxInt(u2.g.a(r102));
        r104.label = 1;
        Object r111 = UserAuthService.r(r100, r101, r110, r104);
        if (r111 != r107) goto L18;
        return r107;
    L18:
        return r111;
    L7:
        r104 = new MoaPermissionGrantingStep$postPermissionStatus$1(this, r103);
        goto L8
    }
}
