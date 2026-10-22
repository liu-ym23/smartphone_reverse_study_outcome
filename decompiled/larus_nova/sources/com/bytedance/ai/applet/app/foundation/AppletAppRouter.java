package com.bytedance.ai.applet.app.foundation;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.app.AppletFullScreenActivity;
import com.bytedance.ai.applet.app.AppletShowMode;
import com.bytedance.ai.applet.app.base.ApplicationRouter;
import com.bytedance.ai.applet.app.base.RouteOptions;
import com.bytedance.ai.applet.app.foundation.performance.AppletPerformanceNavigationType;
import com.bytedance.ai.applet.app.view.AppletThemeMode;
import com.bytedance.ai.bridge.service.DialogBuilder;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

/* JADX INFO: loaded from: classes43.dex */
public final class AppletAppRouter implements ApplicationRouter, w {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f34180e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppletApplication f34181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Long, String> f34182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f34183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AppletAppRouter$ensureBackCallbackInstalled$callback$1 f34184d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void d() {
    }

    @Override // com.bytedance.ai.applet.app.base.ApplicationRouter
    public final Object f() {
        AppletAppActivity r100 = this.f34181a.f34085d;
        if (r100 == null) goto L5;
        Result.Companion r101 = Result.Companion;
        return Result.m9449constructorimpl(SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence(r100.getSupportFragmentManager().getFragments()), new com.bytedance.ai.applet.app.f()), new com.bytedance.ai.applet.app.g())));
    L5:
        Result.Companion r102 = Result.Companion;
        return Result.m9449constructorimpl(CollectionsKt.emptyList());
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void onDestroy() {
        this.f34182b.clear();
        this.f34183c = null;
        AppletAppRouter$ensureBackCallbackInstalled$callback$1 r100 = this.f34184d;
        if (r100 == null) goto L5;
        r100.remove();
    L5:
        this.f34184d = null;
    }

    public AppletAppRouter(AppletApplication r100) {
        Intrinsics.checkNotNullParameter(r100, "app");
        this.f34181a = r100;
        this.f34182b = new ConcurrentHashMap();
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AppletAppRouter$ensureBackCallbackInstalled$callback$1 r101 = this.f34184d;
        if (r101 == null) goto L5;
        r101.remove();
    L5:
        this.f34184d = null;
        this.f34183c = null;
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.ai.applet.app.base.ApplicationRouter
    public final void k(long r100) {
        this.f34182b.remove(Long.valueOf(r100));
        com.bytedance.ai.applet.base.log.b r101 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("AISDK_AlertBeforeUnload", "disable, traceId=" + r100 + ", total=" + this.f34182b.size());
    }

    @Override // com.bytedance.ai.applet.app.base.ApplicationRouter
    public final Object l(Continuation<? super Result<Unit>> r100) {
        if ((r100 instanceof AppletAppRouter$launch$1) == false) goto L7;
        AppletAppRouter$launch$1 r101 = (AppletAppRouter$launch$1) r100;
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
        return ((Result) r103).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        r101.label = 1;
        Object r106 = j(null, r101);
        if (r106 != r104) goto L18;
        return r104;
    L18:
        return r106;
    L7:
        r101 = new AppletAppRouter$launch$1(this, r100);
        goto L8
    }

    @Override // com.bytedance.ai.applet.app.base.ApplicationRouter
    public final Object m(final int r100) {
        final AppletAppActivity r101 = this.f34181a.f34085d;
        if (r101 != null) goto L6;
        Result.Companion r102 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("App Activity is null")));
    L6:
        if (r100 <= 0) goto L16;
        if (r101.getSupportFragmentManager().getBackStackEntryCount() <= 0) goto L16;
        Long r103 = r101.C1();
        if (r103 == null) goto L16;
        if (o(r101, r103.longValue(), new d(r101, r100)) == false) goto L16;
        com.bytedance.ai.applet.base.log.b r104 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("AISDK_AlertBeforeUnload", "navigateBack intercepted, traceId=" + r103 + ", delta=" + r100);
        Result.Companion r105 = Result.Companion;
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L16:
        return r101.Q1(r100);
    }

    @Override // com.bytedance.ai.applet.app.base.ApplicationRouter
    public final Object j(RouteOptions r100, Continuation<? super Result<Unit>> r101) {
        if ((r101 instanceof AppletAppRouter$launch$2) == false) goto L7;
        AppletAppRouter$launch$2 r102 = (AppletAppRouter$launch$2) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
        return ((Result) r104).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        RouteAction r107 = new RouteAction.Launch(r100);
        r102.label = 1;
        Object r108 = p(r107, r102);
        if (r108 != r105) goto L18;
        return r105;
    L18:
        return r108;
    L7:
        r102 = new AppletAppRouter$launch$2(this, r101);
        goto L8
    }

    @Override // com.bytedance.ai.applet.app.base.ApplicationRouter
    public final void n(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "message");
        this.f34182b.put(Long.valueOf(r100), r101);
        com.bytedance.ai.applet.base.log.b r102 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("AISDK_AlertBeforeUnload", "enable, traceId=" + r100 + ", messageLen=" + r101.length() + ", total=" + this.f34182b.size());
        AppletAppActivity r103 = this.f34181a.f34085d;
        if (r103 != null) goto L5;
        return;
    L5:
        if (this.f34184d != null) goto L10;
        AppletAppRouter$ensureBackCallbackInstalled$callback$1 r104 = new AppletAppRouter$ensureBackCallbackInstalled$callback$1(r103, this);
        r103.getOnBackPressedDispatcher().addCallback(r103, r104);
        this.f34184d = r104;
        return;
    }

    public final Object p(RouteAction r210, Continuation<? super Result<Unit>> r211) {
        if ((r211 instanceof AppletAppRouter$launchActivity$1) == false) goto L7;
        AppletAppRouter$launchActivity$1 r100 = (AppletAppRouter$launchActivity$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L149:
        return ((Result) r102).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        if (this.f34181a.f34085d != null) goto L17;
        boolean r105 = true;
    L19:
        if (r105 == false) goto L21;
        com.bytedance.ai.applet.base.log.a.c("AppletAppRouter", "App Activity is null, it will be launched now");
    L21:
        RouteOptions r106 = r210.a();
        String r107 = null;
        if (r106 == null) goto L24;
        Long r108 = r106.f34165b;
    L25:
        if (r108 != null) goto L85;
        long r110 = System.currentTimeMillis();
        com.bytedance.ai.applet.app.foundation.performance.c r109 = this.f34181a.h().c();
        boolean r111 = r210 instanceof RouteAction.Launch;
        if (r111 == false) goto L34;
        String r112 = this.f34181a.j().O;
        if (StringsKt.isBlank(r112) == false) goto L31;
        r112 = "index";
    L31:
        String r113 = t2.c.a(r112);
    L32:
        String r114 = r113;
        if (r111 == false) goto L48;
        AppletPerformanceNavigationType r115 = null;
    L60:
        com.bytedance.ai.applet.app.foundation.performance.r r116 = r109.b(new com.bytedance.ai.applet.app.foundation.performance.p(r110, r114, r115, 24));
        RouteOptions r117 = r210.a();
        if (r117 != null) goto L63;
        r117 = new RouteOptions(null, 3);
    L63:
        RouteOptions r118 = new RouteOptions(r117.f34164a, Boxing.boxLong(r116.f34341c));
        if (r111 == false) goto L67;
        RouteAction.Launch r119 = (RouteAction.Launch) r210;
        RouteAction r120 = new RouteAction.Launch(r118);
    L86:
        AppletAppActivity r121 = this.f34181a.f34085d;
        if (r121 != null) goto L89;
    L92:
        if (r105 == false) goto L102;
        RouteOptions r122 = r120.a();
        if (r122 == null) goto L98;
        Long r123 = r122.f34165b;
        if (r123 == null) goto L98;
        com.bytedance.ai.applet.app.foundation.performance.r r124 = this.f34181a.h().c().f(r123.longValue());
    L99:
        if (r124 != null) goto L101;
        com.bytedance.ai.applet.base.log.a.b("AppletAppRouter", "PagePerformanceTracker not found for cold launch", null);
        goto L102
    L101:
        Boxing.boxBoolean(this.f34181a.h().c().l(r124.f34372v.f34366a));
    L98:
        r124 = null;
    L102:
        final CompletableDeferred r125 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        Application r126 = o2.a.a();
        Function1 r127 = new b(r125);
        Intrinsics.checkNotNullParameter(r127, "onResult");
        AppletAppRouterKt$createResultReceiver$1 r128 = new AppletAppRouterKt$createResultReceiver$1(r127, new Handler(Looper.getMainLooper()));
        AppletAppActivity r129 = this.f34181a.f34085d;
        if (r129 == null) goto L105;
        Integer r130 = Boxing.boxInt(r129.getTaskId());
    L106:
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r131 = AppletRuntimeManager.f36749d;
        if (r131 == null) goto L126;
        Activity r132 = r131.currentActivity();
        if (r132 != null) goto L121;
        r132 = r131.O();
        if (r132 == null) goto L126;
        int r133 = r132.getTaskId();
        if (r130 != null) goto L116;
    L118:
        boolean r134 = false;
    L119:
        if (r134 == true) goto L126;
    L127:
        if (r132 == null) goto L129;
        Integer r135 = Boxing.boxInt(r132.getTaskId());
    L131:
        if (this.f34181a.j().X == false) goto L133;
        AppletThemeMode r136 = AppletThemeMode.FOLLOW_SYSTEM;
    L134:
        com.bytedance.ai.applet.base.log.b r137 = com.bytedance.ai.applet.base.log.a.f34518a;
        StringBuilder r138 = new StringBuilder("AppletFullScreenActivity is launching for action: ");
        r138.append(r210);
        r138.append(", sourceActivity=");
        if (r132 == null) goto L137;
        r107 = r132.getClass().getSimpleName();
    L137:
        r138.append(r107);
        r138.append(", sourceTaskId=");
        r138.append(r135);
        r138.append(", launchThemeMode=");
        r138.append(r136);
        com.bytedance.ai.applet.base.log.a.c("AppletAppRouter", r138.toString());
        Intent r139 = new Intent(r126, AppletFullScreenActivity.class);
        r139.addFlags(268959744);
        r139.setData(UriProtector.parse(this.f34181a.getAppId()));
        Intrinsics.checkNotNullParameter(r139, "<this>");
        r139.putExtra("route_action", r120);
        Intrinsics.checkNotNullParameter(r139, "<this>");
        r139.putExtra("route_result_receiver", r128);
        Intrinsics.checkNotNullParameter(r139, "<this>");
        if (r135 != null) goto L140;
        r139.removeExtra("launch_source_task_id");
    L141:
        Intrinsics.checkNotNullParameter(r139, "<this>");
        if (r136 != null) goto L144;
        r139.removeExtra("launch_applet_theme_mode");
    L145:
        r126.startActivity(r139);
        r100.label = 1;
        r102 = r125.await(r100);
        if (r102 != r103) goto L149;
        return r103;
    L144:
        Intrinsics.checkNotNull(r139.putExtra("launch_applet_theme_mode", r136.name()));
        goto L145
    L140:
        Intrinsics.checkNotNull(r139.putExtra("launch_source_task_id", r135.intValue()));
        goto L141
    L133:
        r136 = AppletThemeMode.LIGHT;
        goto L134
    L129:
        r135 = null;
        goto L131
    L116:
        if (r133 != r130.intValue()) goto L118;
        r134 = true;
        goto L119
    L121:
        int r140 = r132.getTaskId();
        if (r130 == null) goto L127;
        if (r140 != r130.intValue()) goto L127;
    L126:
        r132 = null;
        goto L127
    L105:
        r130 = null;
        goto L106
    L89:
        if (r121.L1() != AppletShowMode.EIGHT_SCREEN) goto L92;
        com.bytedance.ai.applet.base.log.b r141 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("AppletAppRouter", "perform route in current eight-screen activity: " + r120);
        return r121.U1(r120, null);
    L67:
        if ((r210 instanceof RouteAction.NavigateTo) == false) goto L71;
        String r142 = ((RouteAction.NavigateTo) r210).f34191a;
        Parcelable.Creator<RouteAction.NavigateTo> r143 = RouteAction.NavigateTo.CREATOR;
        Intrinsics.checkNotNullParameter(r142, "url");
        RouteAction r144 = new RouteAction.NavigateTo(r142, r118);
    L69:
        r120 = r144;
        goto L86
    L71:
        if ((r210 instanceof RouteAction.RedirectTo) == false) goto L74;
        String r145 = ((RouteAction.RedirectTo) r210).f34198a;
        Parcelable.Creator<RouteAction.RedirectTo> r146 = RouteAction.RedirectTo.CREATOR;
        Intrinsics.checkNotNullParameter(r145, "url");
        r144 = new RouteAction.RedirectTo(r145, r118);
        goto L69
    L74:
        if ((r210 instanceof RouteAction.ReLaunch) == false) goto L77;
        String r147 = ((RouteAction.ReLaunch) r210).f34196a;
        Parcelable.Creator<RouteAction.ReLaunch> r148 = RouteAction.ReLaunch.CREATOR;
        Intrinsics.checkNotNullParameter(r147, "url");
        r144 = new RouteAction.ReLaunch(r147, r118);
        goto L69
    L77:
        if ((r210 instanceof RouteAction.OpenPage) == false) goto L80;
        RouteAction.OpenPage r149 = (RouteAction.OpenPage) r210;
        String r150 = r149.f34193a;
        ApplicationRouter.OpenPageMode r151 = r149.f34194b;
        Parcelable.Creator<RouteAction.OpenPage> r152 = RouteAction.OpenPage.CREATOR;
        Intrinsics.checkNotNullParameter(r150, "url");
        Intrinsics.checkNotNullParameter(r151, "mode");
        r144 = new RouteAction.OpenPage(r150, r151, r118);
        goto L69
    L80:
        throw new NoWhenBranchMatchedException();
    L48:
        if ((r210 instanceof RouteAction.NavigateTo) == false) goto L51;
        AppletPerformanceNavigationType r153 = AppletPerformanceNavigationType.NAVIGATE_TO;
    L59:
        r115 = r153;
        goto L60
    L51:
        if ((r210 instanceof RouteAction.RedirectTo) == false) goto L54;
        r153 = AppletPerformanceNavigationType.REDIRECT_TO;
        goto L59
    L54:
        if ((r210 instanceof RouteAction.ReLaunch) == false) goto L57;
        r153 = AppletPerformanceNavigationType.RE_LAUNCH;
        goto L59
    L57:
        if ((r210 instanceof RouteAction.OpenPage) == false) goto L82;
        r153 = AppletPerformanceNavigationType.OPEN_PAGE;
        goto L59
    L82:
        throw new NoWhenBranchMatchedException();
    L34:
        if ((r210 instanceof RouteAction.NavigateTo) == false) goto L37;
        r113 = t2.c.a(((RouteAction.NavigateTo) r210).f34191a);
        goto L32
    L37:
        if ((r210 instanceof RouteAction.RedirectTo) == false) goto L40;
        r113 = t2.c.a(((RouteAction.RedirectTo) r210).f34198a);
        goto L32
    L40:
        if ((r210 instanceof RouteAction.ReLaunch) == false) goto L43;
        r113 = t2.c.a(((RouteAction.ReLaunch) r210).f34196a);
        goto L32
    L43:
        if ((r210 instanceof RouteAction.OpenPage) == false) goto L84;
        r113 = t2.c.a(((RouteAction.OpenPage) r210).f34193a);
        goto L32
    L84:
        throw new NoWhenBranchMatchedException();
    L85:
        r120 = r210;
        goto L86
    L24:
        r108 = null;
        goto L25
    L17:
        r105 = false;
    L7:
        r100 = new AppletAppRouter$launchActivity$1(this, r211);
        goto L8
    }

    @Override // com.bytedance.ai.applet.app.base.ApplicationRouter
    public final Object c(String r100, RouteOptions r101, Continuation<? super Result<Unit>> r102) {
        if ((r102 instanceof AppletAppRouter$redirectTo$1) == false) goto L7;
        AppletAppRouter$redirectTo$1 r103 = (AppletAppRouter$redirectTo$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
        return ((Result) r105).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        RouteAction r108 = new RouteAction.RedirectTo(r100, r101);
        r103.label = 1;
        Object r109 = p(r108, r103);
        if (r109 != r106) goto L18;
        return r106;
    L18:
        return r109;
    L7:
        r103 = new AppletAppRouter$redirectTo$1(this, r102);
        goto L8
    }

    @Override // com.bytedance.ai.applet.app.base.ApplicationRouter
    public final Object e(String r100, RouteOptions r101, Continuation<? super Result<Unit>> r102) {
        if ((r102 instanceof AppletAppRouter$navigateTo$1) == false) goto L7;
        AppletAppRouter$navigateTo$1 r103 = (AppletAppRouter$navigateTo$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
        return ((Result) r105).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        RouteAction r108 = new RouteAction.NavigateTo(r100, r101);
        r103.label = 1;
        Object r109 = p(r108, r103);
        if (r109 != r106) goto L18;
        return r106;
    L18:
        return r109;
    L7:
        r103 = new AppletAppRouter$navigateTo$1(this, r102);
        goto L8
    }

    @Override // com.bytedance.ai.applet.app.base.ApplicationRouter
    public final Object i(String r100, RouteOptions r101, Continuation<? super Result<Unit>> r102) {
        if ((r102 instanceof AppletAppRouter$reLaunch$1) == false) goto L7;
        AppletAppRouter$reLaunch$1 r103 = (AppletAppRouter$reLaunch$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
        return ((Result) r105).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        RouteAction r108 = new RouteAction.ReLaunch(r100, r101);
        r103.label = 1;
        Object r109 = p(r108, r103);
        if (r109 != r106) goto L18;
        return r106;
    L18:
        return r109;
    L7:
        r103 = new AppletAppRouter$reLaunch$1(this, r102);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.ai.applet.app.foundation.c] */
    public final boolean o(AppletAppActivity r210, final long r211, final Function0<Unit> r212) {
        String r100 = this.f34182b.get(Long.valueOf(r211));
        if (r100 != null) goto L5;
        return false;
    L5:
        Long r101 = this.f34183c;
        if (r101 != null) goto L9;
    L12:
        final ?? r102 = new c(this, r211, r212);
        DialogBuilder r103 = new DialogBuilder(r210, null, r100, "确认", new e(r102), null, null, "取消", new f(r102), null, new g(r102), false, false, null, 12898, null);
        IHostStyleUIDepend r104 = r4.a.f535978e;     // Catch: Exception -> L17
        if (r104 == null) goto L19;
        boolean r105 = Intrinsics.areEqual(r104.showDialog(r103), Boolean.TRUE);     // Catch: Exception -> L17
        String r106 = "AISDK_AlertBeforeUnload";
    L22:
        if (r105 == false) goto L37;
        com.bytedance.ai.applet.base.log.b r107 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c(r106, "show alert before unload dialog by host, traceId=" + r211);
        boolean r108 = true;
    L30:
        if (r108 == true) goto L33;
        com.bytedance.ai.applet.base.log.a.b(r106, "failed to show alert dialog, allow back to proceed", null);
        return false;
    L33:
        this.f34183c = Long.valueOf(r211);
        return true;
    L37:
        r108 = Intrinsics.areEqual(new i4.c().showDialog(r103), Boolean.TRUE);     // Catch: Exception -> L28
        if (r108 == false) goto L30;
        com.bytedance.ai.applet.base.log.b r109 = com.bytedance.ai.applet.base.log.a.f34518a;     // Catch: Exception -> L28
        com.bytedance.ai.applet.base.log.a.c(r106, "show alert before unload dialog by default, traceId=" + r211);     // Catch: Exception -> L28
    L28:
        e = move-exception;
        com.bytedance.ai.applet.base.log.b r110 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.b(r106, "default showDialog threw ".concat(e.getClass().getSimpleName()), null);
        r108 = false;
        goto L30
    L19:
        r106 = "AISDK_AlertBeforeUnload";
    L21:
        r105 = false;
    L17:
        e = move-exception;
        com.bytedance.ai.applet.base.log.b r111 = com.bytedance.ai.applet.base.log.a.f34518a;
        r106 = "AISDK_AlertBeforeUnload";
        com.bytedance.ai.applet.base.log.a.b(r106, "host showDialog threw ".concat(e.getClass().getSimpleName()), null);
        goto L21
    L9:
        if (r101.longValue() != r211) goto L12;
        com.bytedance.ai.applet.base.log.b r112 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("AISDK_AlertBeforeUnload", "back intercepted, dialog already showing, traceId=" + r211);
        return true;
    }

    @Override // com.bytedance.ai.applet.app.base.ApplicationRouter
    public final Object b(String r100, ApplicationRouter.OpenPageMode r101, RouteOptions r102, Continuation<? super Result<Unit>> r103) {
        if ((r103 instanceof AppletAppRouter$openPage$1) == false) goto L7;
        AppletAppRouter$openPage$1 r104 = (AppletAppRouter$openPage$1) r103;
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
        RouteAction r109 = new RouteAction.OpenPage(r100, r101, r102);
        r104.label = 1;
        Object r110 = p(r109, r104);
        if (r110 != r107) goto L18;
        return r107;
    L18:
        return r110;
    L7:
        r104 = new AppletAppRouter$openPage$1(this, r103);
        goto L8
    }
}
