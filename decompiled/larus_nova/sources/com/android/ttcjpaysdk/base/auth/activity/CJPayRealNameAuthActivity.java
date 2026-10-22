package com.android.ttcjpaysdk.base.auth.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.android.ttcjpaysdk.base.auth.CJPayRealNameAuthService;
import com.android.ttcjpaysdk.base.auth.fragment.CJPayRealNameAuthFragment;
import com.android.ttcjpaysdk.base.auth.wrapper.CJPayAgreementListWrapper;
import com.android.ttcjpaysdk.base.framework.BaseActivity;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.router.CJPayRouterAPI;
import com.android.ttcjpaysdk.base.statusbar.CJPayImmersedStatusBarUtils;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayActivityUtils;
import com.android.ttcjpaysdk.base.utils.CJPayAnimationUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayRealNameAuthCallback;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import v19.f;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\bH\u0014J\b\u0010\u0011\u001a\u00020\bH\u0002J\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/base/auth/activity/CJPayRealNameAuthActivity;", "Lcom/android/ttcjpaysdk/base/framework/BaseActivity;", "()V", WidgetService.PARAM_FRAGMENT, "Lcom/android/ttcjpaysdk/base/auth/fragment/CJPayRealNameAuthFragment;", "rootLayout", "Landroid/view/ViewGroup;", VideoEventOneOutSync.END_TYPE_FINISH, "", "getLayout", "", "loadFragment", "onBackPressed", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", LiveCommonConstants.REASON_ON_DEDTROY, "releaseAll", "setRootLayoutBgColor", "color", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayRealNameAuthActivity extends BaseActivity {
    public static final String ACTIVITY_INFO = "activity_info";
    public static final Companion Companion = null;
    public static final String KEY_APP_ID = "key_app_id";
    public static final String KEY_EVENT_TRACK = "key_event_track";
    public static final String KEY_INFO = "key_info";
    public static final String KEY_IS_NOISE_REDUCE_STYLE = "is_noise_reduce_style";
    public static final String KEY_MERCHANT_ID = "key_merchant_id";
    public static final String KEY_SCENE = "key_scene";
    public static final String KEY_STYLE = "key_style";
    public static final String KEY_THEME = "key_theme";
    private CJPayRealNameAuthFragment fragment;
    private ViewGroup rootLayout;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J*\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/android/ttcjpaysdk/base/auth/activity/CJPayRealNameAuthActivity$Companion;", "", "()V", "ACTIVITY_INFO", "", "KEY_APP_ID", "KEY_EVENT_TRACK", "KEY_INFO", "KEY_IS_NOISE_REDUCE_STYLE", "KEY_MERCHANT_ID", "KEY_SCENE", "KEY_STYLE", "KEY_THEME", "start", "", "activity", "Landroid/content/Context;", "attributes", "eventTrack", "info", "activity_info", "Lorg/json/JSONArray;", "isNoiseReduceStyle", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final void start(Context r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "attributes");
            Intrinsics.checkNotNullParameter(r102, "eventTrack");
            Map r103 = MapsKt.mapOf(new Pair[]{TuplesKt.to("merchantId", CJPayRealNameAuthActivity.KEY_MERCHANT_ID), TuplesKt.to("appId", CJPayRealNameAuthActivity.KEY_APP_ID), TuplesKt.to("theme", CJPayRealNameAuthActivity.KEY_THEME), TuplesKt.to("scene", CJPayRealNameAuthActivity.KEY_SCENE), TuplesKt.to("style", CJPayRealNameAuthActivity.KEY_STYLE)});
            CJPayRouterAPI.Builder r104 = CJPayRouterAPI.getInstance().build(CJPayRealNameAuthActivity.class);
            if (TextUtils.isEmpty(r101) == false) goto L15;
        L13:
            r104.withString(CJPayRealNameAuthActivity.KEY_EVENT_TRACK, r102);
            r104.navigation(r100);
            return;
        L15:
            JSONObject r105 = new JSONObject(r101);     // Catch: Exception -> L11
            Iterator<String> r106 = r105.keys();     // Catch: Exception -> L11
        L6:
            if (r106.hasNext() == false) goto L13;
            String r107 = r106.next();     // Catch: Exception -> L11
            if (r103.keySet().contains(r107) == false) goto L6;
            r104.withString((String) r103.get(r107), r105.optString(r107));     // Catch: Exception -> L11
        L11:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("CJPayRealNameAuthActivity#start", e);
            CJBasicCommonUtils.logCatch("CJCatch", "CJPayRealNameAuthActivity#start", e);
            e.printStackTrace();
            goto L13
        }

        public final void start(Context r100, String r101, JSONArray r102, boolean r110) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "info");
            Map r103 = MapsKt.mapOf(new Pair[]{TuplesKt.to("merchantId", CJPayRealNameAuthActivity.KEY_MERCHANT_ID), TuplesKt.to("appId", CJPayRealNameAuthActivity.KEY_APP_ID)});
            CJPayRouterAPI.Builder r104 = CJPayRouterAPI.getInstance().build(CJPayRealNameAuthActivity.class);
            if (TextUtils.isEmpty(r101) == false) goto L19;
        L13:
            r104.withString(CJPayRealNameAuthActivity.KEY_THEME, "auth");
            r104.withString(CJPayRealNameAuthActivity.KEY_INFO, r101);
            if (r102 == null) goto L16;
            String r105 = r102.toString();
        L17:
            r104.withString("activity_info", r105);
            r104.withBoolean(CJPayRealNameAuthActivity.KEY_IS_NOISE_REDUCE_STYLE, r110);
            r104.navigation(r100);
            return;
        L16:
            r105 = null;
            goto L17
        L19:
            JSONObject r106 = new JSONObject(r101);     // Catch: Exception -> L11
            Iterator<String> r107 = r106.keys();     // Catch: Exception -> L11
        L6:
            if (r107.hasNext() == false) goto L13;
            String r108 = r107.next();     // Catch: Exception -> L11
            if (r103.keySet().contains(r108) == false) goto L6;
            r104.withString((String) r103.get(r108), r106.optString(r108));     // Catch: Exception -> L11
        L11:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("CJPayRealNameAuthActivity#start", e);
            CJBasicCommonUtils.logCatch("CJCatch", "CJPayRealNameAuthActivity#start", e);
            e.printStackTrace();
            goto L13
        }

        public static /* synthetic */ void start$default(Companion r100, Context r101, String r102, JSONArray r103, boolean r104, int r105, Object r106) {
            if ((r105 & 8) == 0) goto L5;
            r104 = false;
        L5:
            r100.start(r101, r102, r103, r104);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public void com_android_ttcjpaysdk_base_auth_activity_CJPayRealNameAuthActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        com_android_ttcjpaysdk_base_auth_activity_CJPayRealNameAuthActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseActivity
    public int getLayout() {
        return R.layout.cj_pay_activity_real_name_auth;
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r100) {
        com_android_ttcjpaysdk_base_auth_activity_CJPayRealNameAuthActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com_android_ttcjpaysdk_base_auth_activity_CJPayRealNameAuthActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(this);
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_ttcjpaysdk_base_auth_activity_CJPayRealNameAuthActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    private final void loadFragment() {
        this.fragment = new CJPayRealNameAuthFragment();
        FragmentTransaction r100 = getSupportFragmentManager().beginTransaction();
        CJPayRealNameAuthFragment r101 = this.fragment;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(WidgetService.PARAM_FRAGMENT);
        r101 = null;
    L5:
        INVOKEVIRTUAL_com_android_ttcjpaysdk_base_auth_activity_CJPayRealNameAuthActivity_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r100, R.id.cj_pay_fragment_container, r101).commitAllowingStateLoss();
    }

    private final void releaseAll() {
        CJPayRealNameAuthService.Companion r100 = CJPayRealNameAuthService.Companion;
        r100.setRealNameAuthCallback(null);
        r100.setExtParams(null);
    }

    public void com_android_ttcjpaysdk_base_auth_activity_CJPayRealNameAuthActivity__finish$___twin___() {
        super.finish();
        CJPayActivityUtils.executeActivityFadeInOrOutAnimation(getActivity());
    }

    public void com_android_ttcjpaysdk_base_auth_activity_CJPayRealNameAuthActivity__onDestroy$___twin___() {
        super.onDestroy();
        releaseAll();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (CJPayBasicUtils.isClickValid() == false) goto L23;
        CJPayRealNameAuthFragment r100 = this.fragment;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException(WidgetService.PARAM_FRAGMENT);
        r100 = null;
    L7:
        CJPayAgreementListWrapper r101 = r100.getRealNameAuthWrapper().getAgreementListWrapper();
        if (r101 == null) goto L15;
        View r102 = r101.getRootView();
        if (r102 == null) goto L15;
        if (r102.isShown() == false) goto L15;
        CJPayAnimationUtils.upAndDownAnimation(r102, false, CJPayBasicExtensionKt.dip2px(470.0f, getActivity()), null);
        return;
    L15:
        TTCJPayRealNameAuthCallback r103 = CJPayRealNameAuthService.Companion.getRealNameAuthCallback();
        if (r103 == null) goto L18;
        r103.onAuthResult(TTCJPayRealNameAuthCallback.AuthResult.AUTH_CANCEL);
    L18:
        CJPayRealNameAuthFragment r104 = this.fragment;
        if (r104 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException(WidgetService.PARAM_FRAGMENT);
        r104 = null;
    L21:
        CJPayRealNameAuthFragment.executeTranslateAnimation$default(r104, false, false, 2, null);
        return;
    }

    public CJPayRealNameAuthActivity() {
    }

    public static View INVOKEVIRTUAL_com_android_ttcjpaysdk_base_auth_activity_CJPayRealNameAuthActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void com_android_ttcjpaysdk_base_auth_activity_CJPayRealNameAuthActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(CJPayRealNameAuthActivity r100) {
        r100.com_android_ttcjpaysdk_base_auth_activity_CJPayRealNameAuthActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_android_ttcjpaysdk_base_auth_activity_CJPayRealNameAuthActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static void com_android_ttcjpaysdk_base_auth_activity_CJPayRealNameAuthActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(CJPayRealNameAuthActivity r110) {
        r110.com_android_ttcjpaysdk_base_auth_activity_CJPayRealNameAuthActivity__finish$___twin___();
        if ((r110 instanceof ChatWindowActivity) == false) goto L5;
        return;
    L5:
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(CJPayRealNameAuthActivity.class.getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(r110);     // Catch: Throwable -> L50
        if (r103 != null) goto L10;
    L13:
        r102.put(r110, Long.valueOf(r101));     // Catch: Throwable -> L50
        monitor-exit(r102);     // Catch: Throwable -> L50
    L47:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
        return;
    L16:
        if (r110.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L20;
        r100.i("ActivityLancet", "quit !resume, current state = " + r110.getLifecycle().getCurrentState());     // Catch: Throwable -> L47
        return;
    L20:
        if (r110.isFinishing() == true) goto L24;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L47
        return;
    L24:
        if (ActivityStartBehavior.isInternalActivityConsumed(r110) == true) goto L28;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L47
        return;
    L28:
        if (ActivityLancet.isOnlyActivityInTask(r110) == true) goto L32;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L47
        return;
    L32:
        if (ActivityLancet.isExcludedActivity(r110) == false) goto L36;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L47
        return;
    L36:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L38;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L47
        return;
    L38:
        Intent r104 = r110.getPackageManager().getLaunchIntentForPackage(r110.getPackageName());     // Catch: Throwable -> L47
        if (r104 != null) goto L41;
        return;
    L41:
        r104.addFlags(268435456);     // Catch: Throwable -> L47
        r104.addFlags(2097152);     // Catch: Throwable -> L47
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + r110);     // Catch: Throwable -> L47
        r110.startActivity(r104);     // Catch: Throwable -> L44
        r110.overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L44
    L58:
        return;
    L44:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L47
        return;
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L50
        return;
    L50:
        th = move-exception;
        throw th;
    }

    public static void com_android_ttcjpaysdk_base_auth_activity_CJPayRealNameAuthActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(CJPayRealNameAuthActivity r100) {
        if ((r100 instanceof FragmentActivity) == true) goto L5;
    L7:
        r100.com_android_ttcjpaysdk_base_auth_activity_CJPayRealNameAuthActivity__onDestroy$___twin___();
        return;
    L5:
        if (WindowUtils.INSTANCE.isMainBotActivity(r100) == false) goto L7;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(r100);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(r100.getClass().getName()));
        goto L7
    }

    public void com_android_ttcjpaysdk_base_auth_activity_CJPayRealNameAuthActivity__onCreate$___twin___(Bundle r100) {
        super.onCreate(r100);
        CJPayImmersedStatusBarUtils.adjustMaterialTheme(getActivity());
        this.rootLayout = (ViewGroup) findViewById(R.id.cj_pay_activity_root_view);
        AppCompatActivity r101 = getActivity();
        ViewGroup r102 = this.rootLayout;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
        r102 = null;
    L5:
        CJPayImmersedStatusBarUtils.adjustStatusBarLightMode(r101, r102);
        loadFragment();
    }

    public final void setRootLayoutBgColor(int r100) {
        ViewGroup r101 = this.rootLayout;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
        r101 = null;
    L5:
        r101.setBackgroundColor(r100);
    }

    public static void com_android_ttcjpaysdk_base_auth_activity_CJPayRealNameAuthActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(CJPayRealNameAuthActivity r100, Bundle r101) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(r100.getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(r100) == false) goto L8;
        f.c(r100.getTheme());     // Catch: Throwable -> L10
    L8:
        r100.com_android_ttcjpaysdk_base_auth_activity_CJPayRealNameAuthActivity__onCreate$___twin___(r101);
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_android_ttcjpaysdk_base_auth_activity_CJPayRealNameAuthActivity_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r100, int r101, Fragment r102) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r100, r102, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, r101) == false) goto L6;
        return r100;
    L6:
        return r100.add(r101, r102);
    }
}
