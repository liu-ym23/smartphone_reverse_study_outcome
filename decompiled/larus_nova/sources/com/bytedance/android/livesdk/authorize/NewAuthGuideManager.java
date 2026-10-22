package com.bytedance.android.livesdk.authorize;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.g2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth;
import com.bytedance.android.livehostapi.platform.IOneKeyAuth;
import com.bytedance.android.livesdk.bottomguide.GuideBarResponseItem;
import com.bytedance.android.livesdk.log.filter.k0;
import com.bytedance.android.livesdk.utils.v5;
import com.bytedance.android.livesdkapi.auth.IAuthDialogCallback;
import com.bytedance.android.livesdkapi.auth.IAuthDialogSourceProvider;
import com.bytedance.android.livesdkapi.auth.IAuthGuideService;
import com.bytedance.android.livesdkapi.auth.INewAuthReport;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes7.dex */
public final class NewAuthGuideManager extends g2 implements IAuthGuideService {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f104166c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g2.a f104167d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g2.b f104168e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g2.b f104169f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final g2.b f104170g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final g2.a f104171h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final g2.b f104172i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final g2.a f104173j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final g2.b f104174k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final NewAuthGuideManager f104175l = null;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewAuthGuideManager$handleGuideBarConfig$1 f104176a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveWidget f104177b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.bottomguide.g f104178c;

        public a(NewAuthGuideManager$handleGuideBarConfig$1 r100, LiveWidget r101, com.bytedance.android.livesdk.bottomguide.g r102) {
            this.f104176a = r100;
            this.f104177b = r101;
            this.f104178c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            if (this.f104176a.invoke2() == false) goto L25;
            NewAuthGuideManager r102 = NewAuthGuideManager.f104175l;
            Context r103 = this.f104177b.context;
            com.bytedance.android.livesdk.bottomguide.g r104 = this.f104178c;
            r102.getClass();
            if (NewAuthConfirmDialog.f104152g == false) goto L8;
            boolean r105 = false;
        L19:
            if (r105 == false) goto L24;
            NewAuthGuideManager.f104175l.getClass();
            g2.a r106 = NewAuthGuideManager.f104167d;
            KProperty[] r107 = NewAuthGuideManager.f104166c;
            int r108 = ((Number) r106.b(r107[0])).intValue() + 1;
            r106.c(r107[0], Integer.valueOf(r108));
            g2.b r109 = NewAuthGuideManager.f104168e;
            int r110 = ((Number) r109.b(r107[1])).intValue() + 1;
            r109.c(r107[1], Integer.valueOf(r110));
            long r111 = System.currentTimeMillis();
            NewAuthGuideManager.f104169f.c(r107[2], Long.valueOf(r111));
            return;
        L24:
            return;
        L8:
            IHostTokenInjectionAuth r112 = TTLiveSDK.hostService().injectAccount();
            boolean r113 = r112 instanceof IOneKeyAuth;     // Catch: Throwable -> L11
        L12:
            if (r113 == false) goto L17;
            if (r112 == null) goto L16;
            ((IOneKeyAuth) r112).checkAuthFlowHasDialog(new o(r103));
        L18:
            r105 = true;
            goto L19
        L16:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livehostapi.platform.IOneKeyAuth");
        L17:
            r102.e(r103, r104);
        L11:
            r113 = false;
            goto L12
        }
    }

    public static final class b implements IAuthDialogCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveWidget f104179a;

        @Override // com.bytedance.android.livesdkapi.auth.IAuthDialogCallback
        public final void onConfirm() {
        }

        @Override // com.bytedance.android.livesdkapi.auth.IAuthDialogCallback
        public final void onExtraButtonClicked(String r100) {
            Intrinsics.checkNotNullParameter(r100, "buttonTag");
        }

        @Override // com.bytedance.android.livesdkapi.auth.IAuthDialogCallback
        public final void onCancel() {
            if (this.f104179a.context == null) goto L6;
            NewAuthGuideManager.f104175l.getClass();
            ((IRoomService) jc1.k.n(IRoomService.class)).getEnterConfigManager();
            return;
        }

        public b(LiveWidget r100, com.bytedance.android.livesdk.bottomguide.g r101) {
            this.f104179a = r100;
        }
    }

    public static final class c implements IAuthDialogCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f104180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.bottomguide.g f104181b;

        @Override // com.bytedance.android.livesdkapi.auth.IAuthDialogCallback
        public final void onExtraButtonClicked(String r100) {
            Intrinsics.checkNotNullParameter(r100, "buttonTag");
        }

        @Override // com.bytedance.android.livesdkapi.auth.IAuthDialogCallback
        public final void onCancel() {
            NewAuthGuideManager.f104175l.getClass();
            ((IRoomService) jc1.k.n(IRoomService.class)).getEnterConfigManager();
        }

        @Override // com.bytedance.android.livesdkapi.auth.IAuthDialogCallback
        public final void onConfirm() {
            NewAuthGuideManager.b(NewAuthGuideManager.f104175l, this.f104180a, this.f104181b);
        }

        public c(Context r100, com.bytedance.android.livesdk.bottomguide.g r101) {
            this.f104180a = r100;
            this.f104181b = r101;
        }
    }

    public NewAuthGuideManager() {
        super(null, null);
    }

    static {
        f104166c = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(NewAuthGuideManager.class, "todayShowCnt", "getTodayShowCnt()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(NewAuthGuideManager.class, "totalShowCnt", "getTotalShowCnt()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(NewAuthGuideManager.class, "lastShowTs", "getLastShowTs()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(NewAuthGuideManager.class, "firstInTime", "getFirstInTime()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(NewAuthGuideManager.class, "trustAuthDialogTodayShowCnt", "getTrustAuthDialogTodayShowCnt()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(NewAuthGuideManager.class, "trustAuthDialogTotalShowCnt", "getTrustAuthDialogTotalShowCnt()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(NewAuthGuideManager.class, "jumpDyBuyDialogTodayShowCnt", "getJumpDyBuyDialogTodayShowCnt()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(NewAuthGuideManager.class, "jumpDyBuyDialogTotalShowCnt", "getJumpDyBuyDialogTotalShowCnt()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(NewAuthGuideManager.class, "silentAuthDialogTodayShowCnt", "getSilentAuthDialogTodayShowCnt()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(NewAuthGuideManager.class, "silentAuthDialogTotalShowCnt", "getSilentAuthDialogTotalShowCnt()I", 0))};
        NewAuthGuideManager r100 = new NewAuthGuideManager();
        f104175l = r100;
        f104167d = new g2.a(r100, "new_auth_guide_today_show_cnt", 0);
        f104168e = new g2.b(r100, "new_auth_guide_total_show_cnt", 0);
        f104169f = new g2.b(r100, "new_auth_guide_last_show_ts", 0L);
        f104170g = new g2.b(r100, "new_auth_guide_first_app_in", 0L);
        new g2.a(r100, "trust_auth_guide_today_show_cnt", 0);
        new g2.b(r100, "trust_auth_guide_total_show_cnt", 0);
        f104171h = new g2.a(r100, "jump_dy_buy_guide_today_show_cnt", 0);
        f104172i = new g2.b(r100, "jump_dy_buy_guide_total_show_cnt", 0);
        f104173j = new g2.a(r100, "silent_auth_guide_today_show_cnt", 0);
        f104174k = new g2.b(r100, "silent_auth_total_show_cnt", 0);
        jc1.k.l(IAuthGuideService.class, r100);
    }

    @Override // com.bytedance.android.livesdkapi.auth.IAuthGuideService
    public final INewAuthReport report() {
        IHostTokenInjectionAuth r100 = TTLiveSDK.hostService().injectAccount();
        if ((r100 instanceof IOneKeyAuth) == false) goto L8;
        INewAuthReport r101 = ((IOneKeyAuth) r100).getAuthReporter();
        if (r101 == null) goto L10;
        return r101;
    L10:
        return p.f104220b;
    L8:
        return p.f104220b;
    }

    public final void e(Context r100, com.bytedance.android.livesdk.bottomguide.g r110) {
        ALogger.i("NewAuthGuide", "showDefaultAuthDialog");
        com.bytedance.android.livesdk.user.l.a r101 = new com.bytedance.android.livesdk.user.l.a();
        r101.f158688d = "guide";
        com.bytedance.android.livesdk.user.l r102 = new com.bytedance.android.livesdk.user.l(r101);
        com.bytedance.android.livesdk.log.filter.o r103 = com.bytedance.android.livesdk.log.u.l().c(com.bytedance.android.livesdk.user.k.class);
        if ((r103 instanceof k0) == true) goto L5;
        r103 = null;
    L5:
        k0 r104 = (k0) r103;
        if (r104 == null) goto L8;
        r104.J(r102);
    L8:
        showAuthGuideDialog(r100, null, new c(r100, r110), false, false);
    }

    public static final void b(NewAuthGuideManager r100, Context r101, com.bytedance.android.livesdk.bottomguide.g r102) {
        r100.getClass();
        com.bytedance.android.livesdk.user.f r103 = ((IUserService) jc1.k.n(IUserService.class)).user();
        if (r103.isLogin() == true) goto L6;
        com.bytedance.android.livesdk.user.l.a r104 = new com.bytedance.android.livesdk.user.l.a();
        r104.f158687c = -1;
        r104.f158688d = "guide";
        r103.login(r101, new com.bytedance.android.livesdk.user.l(r104)).subscribe(new m(r101), new n(r101, r102));
        return;
    }

    public final boolean c(LiveWidget r100, com.bytedance.android.livesdk.bottomguide.g r110, com.bytedance.android.livesdk.bottomguide.g r111) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        ALogger.i("NewAuthGuide", "handleGuideBar " + r110);
        g2.b r101 = f104170g;
        KProperty[] r102 = f104166c;
        if (((Number) r101.b(r102[3])).longValue() != 0) goto L5;
        r101.c(r102[3], Long.valueOf(System.currentTimeMillis()));
    L5:
        SharedPreferences.Editor r103 = v5.b().edit();
        if (r110 == null) goto L8;
        boolean r104 = true;
    L9:
        r103.putBoolean("live.pref.PREF_USE_NEW_ONE_KEY_AUTH", r104).apply();
        if (r110 != null) goto L12;
        return false;
    L12:
        NewAuthGuideManager$handleGuideBarConfig$1 r105 = new NewAuthGuideManager$handleGuideBarConfig$1(r110);
        if (r105.invoke2() == true) goto L15;
        return true;
    L15:
        ((ObservableSubscribeProxy) RxUtilKt.h(Observable.just(Boolean.TRUE).delay(r110.b(), TimeUnit.SECONDS)).as(r100.autoDispose())).subscribe(new a(r105, r100, r111));
        return true;
    L8:
        r104 = false;
        goto L9
    }

    public final boolean d(LiveWidget r100, GuideBarResponseItem r101, com.bytedance.android.livesdk.bottomguide.g r102) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        if (r101 != null) goto L5;
        return false;
    L5:
        final com.bytedance.android.livesdk.bottomguide.g r103 = r101.g();
        if (r103 != null) goto L9;
        return false;
    L9:
        if (new NewAuthGuideManager$handleSilentOauthGuideBarConfig$1(r103).invoke2() == true) goto L11;
        return false;
    L11:
        SilentAuthGuideDialog r104 = new SilentAuthGuideDialog(r100.context, new b(r100, r102), r101.c());
        if (DialogLancet.shouldBlockDialogShow(r104) == false) goto L19;
        DialogLancet.handleBlockedDialogShow(r104);
    L16:
        g2.a r105 = f104173j;
        KProperty[] r106 = f104166c;
        int r107 = ((Number) r105.b(r106[8])).intValue() + 1;
        r105.c(r106[8], Integer.valueOf(r107));
        g2.b r108 = f104174k;
        int r109 = ((Number) r108.b(r106[9])).intValue() + 1;
        r108.c(r106[9], Integer.valueOf(r109));
        return true;
    L19:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
    L15:
        DialogLancet.beforeDialogShow(r104);
        r104.show();
        DialogLancet.afterDialogShow(r104);
        goto L16
    }

    @Override // com.bytedance.android.livesdkapi.auth.IAuthGuideService
    public final Dialog showProtocolConfirmDialog(Context r100, IAuthDialogCallback r101, IAuthDialogSourceProvider r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "callback");
        if ((r100 instanceof Activity) == false) goto L10;
        Activity r103 = (Activity) r100;
        if (r103.isFinishing() == false) goto L7;
        return null;
    L7:
        if (r103.isDestroyed() == false) goto L10;
        return null;
    L10:
        ProtocolConfirmDialog r104 = new ProtocolConfirmDialog(r100, r101, r102);
        if (DialogLancet.shouldBlockDialogShow(r104) == false) goto L17;
        DialogLancet.handleBlockedDialogShow(r104);
    L15:
        return r104;
    L17:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L14:
        DialogLancet.beforeDialogShow(r104);
        r104.show();
        DialogLancet.afterDialogShow(r104);
        goto L15
    }

    @Override // com.bytedance.android.livesdkapi.auth.IAuthGuideService
    public final Dialog showAuthGuideDialog(Context r100, String r101, IAuthDialogCallback r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "callback");
        if ((r100 instanceof Activity) == false) goto L10;
        Activity r105 = (Activity) r100;
        if (r105.isFinishing() == false) goto L7;
        return null;
    L7:
        if (r105.isDestroyed() == false) goto L10;
        return null;
    L10:
        NewAuthConfirmDialog r106 = new NewAuthConfirmDialog(r100, r101, r102, r104);
        if (DialogLancet.shouldBlockDialogShow(r106) == false) goto L17;
        DialogLancet.handleBlockedDialogShow(r106);
    L15:
        return r106;
    L17:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L14:
        DialogLancet.beforeDialogShow(r106);
        r106.show();
        DialogLancet.afterDialogShow(r106);
        goto L15
    }
}
