package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAnchorServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService;
import com.bytedance.android.livehostapi.business.depend.livead.ILiveMiniAppService;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0005\u0006B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/explaincardsetting/ExplainCardSettingDialog;", "Landroidx/fragment/app/FragmentActivity;", "", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExplainCardSettingDialog extends FragmentActivity {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f84385k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f84386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f84387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f84388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.live.openplatform.impl.base.utils.h f84389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f84390e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f84391f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f84392g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public so0.a f84393h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f84394i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.openplatform.impl.base.utils.a f84395j;

    public static final class a {
        public a() {
        }
    }

    public static final class b {
    }

    public static final class c implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExplainCardSettingDialog f84396a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
        }

        public c(ExplainCardSettingDialog r100) {
            this.f84396a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            com.bytedance.android.live.openplatform.impl.base.utils.m.e(this.f84396a._$_findCachedViewById(R.id.root), Boolean.FALSE);
            ExplainCardSettingDialog r101 = this.f84396a;
            r101.f84394i = false;
            ExplainCardSettingDialog.y1(r101);
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f84397a = null;

        static {
            f84397a = new d();
        }

        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }
    }

    public static final class e implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f84398a = null;

        static {
            f84398a = new e();
        }

        public e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            r100.dismiss();
        }
    }

    public static final class f implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExplainCardSettingDialog f84399a;

        public f(ExplainCardSettingDialog r100) {
            this.f84399a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            r100.dismiss();
            ExplainCardSettingDialog r102 = this.f84399a;
            int r103 = ExplainCardSettingDialog.f84385k;
            if (r102.z1().isTalentMount() == false) goto L5;
            this.f84399a.z1().clearTalentPayload();
        L5:
            this.f84399a.finish();
        }
    }

    static {
    }

    public final ExplainCardSettingViewModel z1() {
        return (ExplainCardSettingViewModel) this.f84390e.getValue();
    }

    public final void A1() {
        this.f84389d = new com.bytedance.android.live.openplatform.impl.base.utils.h(this, this.f84387b, this.f84388c, new ExplainCardSettingDialog$jumpToGallery$1(this));
        com.bytedance.android.live.core.utils.q.o(this, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        if (this.f84391f == true) goto L15;
        this.f84391f = true;
        if (z1().isShelf() == true) goto L11;
        ILiveMiniAppService r100 = (ILiveMiniAppService) jc1.k.f(ILiveMiniAppService.class);
        if (r100 == null) goto L11;
        r100.setMiniAppActivityStatue(false);
    L11:
        if (this.f84394i == false) goto L13;
        xs2.b.a().post(new zp0.a());
    L13:
        LinearLayout r101 = (LinearLayout) _$_findCachedViewById(R.id.root);
        Animation r102 = AnimationUtils.loadAnimation(this, R.anim.slide_out_bottom);
        r102.setAnimationListener(new c(this));
        Unit r103 = Unit.INSTANCE;
        r101.startAnimation(r102);
    L15:
        if ((this instanceof ChatWindowActivity) == true) goto L68;
        FLogger r104 = FLogger.f375446a;
        r104.i("ActivityLancet", "finish ".concat(ExplainCardSettingDialog.class.getName()));
        long r105 = SystemClock.uptimeMillis();
        Map<Activity, Long> r106 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r106);
        Long r107 = r106.get(this);     // Catch: Throwable -> L57
        if (r107 != null) goto L22;
    L25:
        r106.put(this, Long.valueOf(r105));     // Catch: Throwable -> L57
        monitor-exit(r106);     // Catch: Throwable -> L57
    L54:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L65:
        return;
    L28:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L31;
        r104.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L54
    L60:
        goto L65
    L31:
        if (isFinishing() == true) goto L34;
        r104.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L54
        goto L60
    L34:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L37;
        r104.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L54
        goto L60
    L37:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L40;
        r104.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L54
        goto L60
    L40:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L43;
        r104.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L54
        goto L60
    L43:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L45;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L54
        goto L60
    L45:
        Intent r108 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L54
        if (r108 == null) goto L60;
        r108.addFlags(268435456);     // Catch: Throwable -> L54
        r108.addFlags(2097152);     // Catch: Throwable -> L54
        r104.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L54
        startActivity(r108);     // Catch: Throwable -> L51
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L54
        goto L60
    L22:
        if ((r105 - r107.longValue()) >= 800) goto L25;
        monitor-exit(r106);     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        throw th;
    }

    public ExplainCardSettingDialog() {
        this.f84395j = new com.bytedance.android.live.openplatform.impl.base.utils.a();
        this.f84386a = new LinkedHashMap();
        this.f84387b = 750;
        this.f84388c = 751;
        this.f84390e = LazyKt.lazy(new ExplainCardSettingDialog$viewModel$2(this));
        this.f84392g = LazyKt.lazy(new ExplainCardSettingDialog$processDialog$2(this));
    }

    public final void B1() {
        if (z1().isEdit() == true) goto L5;
    L8:
        z1().reportGiveUpRemainder();
        if (z1().isShelf() == true) goto L11;
    L13:
        so0.a r100 = this.f84393h;
        if (r100 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L16:
        OpenPlatformContext r101 = r100.a();
        if (r101 == null) goto L23;
        AnchorShelfContextService r102 = (AnchorShelfContextService) r101.getService(AnchorShelfContextService.class);
        if (r102 == null) goto L23;
        if (r102.isMounted() != true) goto L23;
        int r103 = R.string.ttlive_miniapp_card_give_up_mount;
    L24:
        x0.b r104 = new x0.b(this, 4);
        r104.f162238a.f162245d = getString(r103);
        r104.j(1, getString(R.string.ttlive_miniapp_card_btn_cancel_mount), e.f84398a);
        r104.j(0, getString(R.string.ttlive_miniapp_card_btn_give_up_mount), new f(this));
        r104.k(0, true);
        r104.n();
        return;
    L23:
        r103 = R.string.ttlive_miniapp_card_give_up_mount2;
        goto L24
    L11:
        if (z1().isEdit() == true) goto L13;
        r103 = R.string.ttlive_miniapp_card_give_up_mount_for_shelf;
        goto L24
    L5:
        if (z1().isCardChanged() == true) goto L8;
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        this.f84395j.b();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r100 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r101 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r101 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r101, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r100.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        B1();
    }

    public static final /* synthetic */ void y1(ExplainCardSettingDialog r100) {
        super.finish();
    }

    public final View _$_findCachedViewById(int r100) {
        if (this.f84386a != null) goto L5;
        this.f84386a = new LinkedHashMap();
    L5:
        View r101 = this.f84386a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f84386a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L44
    L6:
        if (v19.f.f(this) == false) goto L8;
        v19.f.c(getTheme());     // Catch: Throwable -> L44
    L8:
        super.onCreate(r100);
        OpenPlatformAnchorServiceImpl.Companion.getClass();
        so0.a r101 = ((po0.a.b) OpenPlatformAnchorServiceImpl.access$getDiComponent$cp()).a().f530019a.f530021b.get();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f84393h = r101;
        setContentView(R.layout.ttlive_dialog_explain_card_setting);
        getWindow().setGravity(80);
        getWindow().setLayout(-1, -2);
        overridePendingTransition(R.anim.slide_in_bottom, 0);
        ExplainCardSettingsInfo r102 = (ExplainCardSettingsInfo) getIntent().getParcelableExtra("explain_card_info");
        if (r102 == null) goto L12;
        z1().initData(r102);
    L12:
        ((ImageView) _$_findCachedViewById(R.id.back_btn)).setOnClickListener(new com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting.f(this));
        ((ImageView) _$_findCachedViewById(R.id.close_btn)).setOnClickListener(new g(this));
        z1().getFinish().a(this, new ExplainCardSettingDialog$initView$3(this));
        z1().getExplainCardInfo().a(this, new ExplainCardSettingDialog$initView$4(this));
        z1().getLoadingStatus().a(this, new ExplainCardSettingDialog$initView$5(this));
        ((RelativeLayout) _$_findCachedViewById(R.id.snapshot_upload_failed_container)).setOnClickListener(new h(this));
        z1().getCustomCover().a(this, new ExplainCardSettingDialog$initView$7(this));
        ((RelativeLayout) _$_findCachedViewById(R.id.cover_settings_layout)).setOnClickListener(new i(this));
        z1().getChangeCoverEvent().a(this, new ExplainCardSettingDialog$initView$9(this));
        z1().getCustomTitle().a(this, new ExplainCardSettingDialog$initView$10(this));
        ((RelativeLayout) _$_findCachedViewById(R.id.title_settings_layout)).setOnClickListener(new com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting.c(this));
        if (z1().isShelf() == false) goto L15;
        ((RelativeLayout) _$_findCachedViewById(R.id.show_explain_card_switch_layout)).setVisibility(8);
    L15:
        so0.a r103 = this.f84393h;
        if (r103 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L18:
        int r104 = r103.getCoexistComponent();
        if (r104 == 0) goto L21;
        ((RelativeLayout) _$_findCachedViewById(R.id.show_explain_card_switch_layout)).setAlpha(0.4f);
        ((RelativeLayout) _$_findCachedViewById(R.id.show_explain_card_switch_layout)).setOnClickListener(new com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting.a(r104));
        ((LiveSwitchButton) _$_findCachedViewById(R.id.display_switch)).setEnabled(false);
    L21:
        z1().isIntroducing().a(this, new ExplainCardSettingDialog$initShowExplainCardLayout$2(this));
        LiveSwitchButton r105 = (LiveSwitchButton) _$_findCachedViewById(R.id.display_switch);
        if (r105 == null) goto L24;
        r105.setOnCheckedChangeListener(new com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting.b(this));
    L24:
        ((TextView) _$_findCachedViewById(R.id.btn_save)).setOnClickListener(new com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting.d(this));
        ((LinearLayout) _$_findCachedViewById(R.id.root)).post(new com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting.e(this));
        HashMap<String, zo0.f> r106 = zo0.g.f573094a;
        zo0.f r107 = zo0.h.b(PerformanceScene.EXPLAIN_CARD_SETTING_DIALOG);
        int r108 = zo0.f.f573090d;
        r107.l("view_created", null);
        z1().observerData();
        ((LinearLayout) _$_findCachedViewById(R.id.root)).setOnClickListener(d.f84397a);
        so0.a r109 = this.f84393h;
        if (r109 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L27:
        OpenPlatformContext r110 = r109.a();
        if (r110 == null) goto L32;
        AnchorMiniAppAppLogContextService r111 = (AnchorMiniAppAppLogContextService) r110.getService(AnchorMiniAppAppLogContextService.class);
        if (r111 == null) goto L32;
        r111.reportExplainCardSettingShow();
    L32:
        so0.a r112 = this.f84393h;
        if (r112 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L35:
        OpenPlatformContext r113 = r112.a();
        if (r113 == null) goto L47;
        AnchorMiniAppAppLogContextService r114 = (AnchorMiniAppAppLogContextService) r113.getService(AnchorMiniAppAppLogContextService.class);
        if (r114 == null) goto L48;
        String r115 = z1().getAppId();
        if (r115 != null) goto L42;
        r115 = "";
    L42:
        r114.reportAnchorExplainCardSettingsShow(r115);
        return;
    L48:
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent r100) {
        if (r100 == null) goto L7;
        ExplainCardSettingsInfo r101 = (ExplainCardSettingsInfo) r100.getParcelableExtra("explain_card_info");
        if (r101 == null) goto L7;
        z1().initData(r101);
    L7:
        super.onNewIntent(r100);
    }

    @Override // android.app.Activity
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100 != null) goto L5;
    L7:
        return true;
    L5:
        if (r100.getAction() != 1) goto L7;
        B1();
        goto L7
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        com.bytedance.android.live.openplatform.impl.base.utils.h r103 = this.f84389d;
        if (r103 != null) goto L5;
        return;
    L5:
        if (r100 != 40003) goto L16;
        if (r101 != 0) goto L10;
        com.bytedance.android.live.openplatform.impl.base.utils.e r104 = r103.f84058d;
        if (r104 == null) goto L106;
        r104.onCanceled();
        return;
    L106:
        return;
    L10:
        if (r102 != null) goto L14;
        com.bytedance.android.live.openplatform.impl.base.utils.e r105 = r103.f84058d;
        if (r105 == null) goto L108;
        r105.onCanceled();
        return;
    L108:
        return;
    L14:
        r103.e(r102.getData(), false);
        return;
    L16:
        if (r100 != 40004) goto L24;
        if (r101 != 0) goto L87;
        com.bytedance.android.live.openplatform.impl.base.utils.e r106 = r103.f84058d;
        if (r106 == null) goto L111;
        r106.onCanceled();
        return;
    L111:
        return;
    L87:
        r103.e(r103.b(), true);     // Catch: Exception -> L82
        return;
    L119:
        return;
    L24:
        if (r100 != 40002) goto L113;
        if (r101 != 0) goto L29;
        com.bytedance.android.live.openplatform.impl.base.utils.e r107 = r103.f84058d;
        if (r107 == null) goto L114;
        r107.onCanceled();
        return;
    L114:
        return;
    L29:
        IHostApp r108 = (IHostApp) jc1.k.f(IHostApp.class);
        if (r108 != null) goto L32;
    L74:
        PolarisFileWrapper r109 = new PolarisFileWrapper(r103.f84056b + HTTP.URL_DEFAULT + r103.c());
        if (r109.exists() == false) goto L116;
        String r110 = r109.getAbsolutePath();
        com.bytedance.android.live.openplatform.impl.base.utils.e r111 = r103.f84058d;
        if (r111 == null) goto L117;
        r111.a(r110);
        return;
    L117:
        return;
    L116:
        return;
    L32:
        if (r108.shouldUseScopedStorage() == false) goto L74;
        if (r103.f84061g == null) goto L74;
        FileInputStream r112 = null;
        FileInputStream r113 = (FileInputStream) ContentResolverWrapper.openInputStream(r103.f84055a.getContentResolver(), r103.f84061g);     // Catch: Throwable -> L52 Exception -> L54
        PolarisFileOutputStreamWrapper r114 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(com.bytedance.android.live.openplatform.impl.base.utils.c.a(r103.f84055a), r103.c()));     // Catch: Throwable -> L48 Exception -> L50
    L83:
        byte[] r115 = new byte[4096];     // Catch: Exception -> L46 Throwable -> L65
    L40:
        int r116 = r113.read(r115);     // Catch: Exception -> L46 Throwable -> L65
        if (r116 == (-1)) goto L96;
        r114.write(r115, 0, r116);     // Catch: Exception -> L46 Throwable -> L65
        goto L40
    L96:
        r113.close();     // Catch: Exception -> L80
    L92:
        r114.close();     // Catch: Exception -> L64
    L46:
        Exception e100 = e;
    L56:
        e100.printStackTrace();     // Catch: Throwable -> L65
        if (r113 != null) goto L85;
    L61:
        if (r114 == null) goto L74;
    L85:
        r113.close();     // Catch: Exception -> L60
    L65:
        th = move-exception;
        FileInputStream r117 = r113;
        Throwable r118 = th;
        r112 = r117;
    L67:
        if (r112 != null) goto L94;
    L71:
        if (r114 == null) goto L103;
        r114.close();     // Catch: Exception -> L81
        throw r118;
    L104:
        throw r118;
    L103:
        throw r118;
    L94:
        r112.close();     // Catch: Exception -> L70
    L50:
        e = move-exception;
        r114 = null;
        e100 = e;
    L48:
        th = move-exception;
        r114 = null;
        r112 = r113;
        r118 = th;
        goto L67
    L54:
        e = move-exception;
        r114 = null;
        e100 = e;
        r113 = null;
    L52:
        th = move-exception;
        r118 = th;
        r114 = null;
        goto L67
    }
}
