package com.android.ttcjpaysdk.thirdparty.agreement.activity;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.android.ttcjpaysdk.base.router.CJPayRouterAPI;
import com.android.ttcjpaysdk.base.ui.data.CJPayCardProtocolBean;
import com.android.ttcjpaysdk.base.utils.CJPayActivityUtils;
import com.android.ttcjpaysdk.base.utils.CJPayAnimationUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.base.utils.CJPayLargeScreenUtils;
import com.android.ttcjpaysdk.base.utils.CJWalletCashierBtmUtils;
import com.android.ttcjpaysdk.thirdparty.agreement.CJPayAgreementService;
import com.android.ttcjpaysdk.thirdparty.agreement.fragment.CJPayAgreementDetailFragment;
import com.android.ttcjpaysdk.thirdparty.agreement.fragment.CJPayAgreementFragment;
import com.android.ttcjpaysdk.thirdparty.base.CJPayBaseFragment;
import com.bytedance.caijing.sdk.infra.base.api.btm.CJPageFinder;
import com.bytedance.caijing.sdk.infra.base.event.CJBtmUtils;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import dc9.d;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import v19.f;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayAgreementActivity extends CJPayAgreementBaseActivity {
    public static final int CJ_PAY_FRAGMENT_SHOW_TYPE_AGREEMENT_DETAIL = 1;
    public static final int CJ_PAY_FRAGMENT_SHOW_TYPE_AGREEMENT_LIST = 0;
    public static final String CJ_PAY_KEY_AGREEMENT_DATA_PARAMS = "CJPayKeyAgreementDataParams";
    public static final String CJ_PAY_KEY_AGREEMENT_HEIGHT = "CJPayKeyAgreementHeight";
    public static final String CJ_PAY_KEY_AGREEMENT_IS_BACK_CLOSE_PARAMS = "CJPayKeyAgreementIsBackCloseParams";
    public static final String CJ_PAY_KEY_AGREEMENT_IS_CLICK_OUTSIDE_ENABLE_PARAMS = "CJPayKeyAgreementIsOutsideEnableParams";
    public static final String CJ_PAY_KEY_AGREEMENT_IS_SHOW_BG_MASK_PARAMS = "CJPayKeyAgreementIsShowBgMaskParams";
    public static final String CJ_PAY_KEY_AGREEMENT_TYPE_PARAMS = "CJPayKeyAgreementTypeParams";
    public static final String CJ_PAY_KEY_SHOW_NEXT_BTN_IN_DETAIL_PAGE_PARAMS = "CJPayKeyShowNextBtnInDetailPageParams";
    public static final String CJ_PAY_KEY_SHOW_NEXT_BTN_PARAMS = "CJPayKeyShowNextBtnParams";
    public static final String CJ_PAY_KEY_SHOW_WITH_ANIMATION_PARAMS = "CJPayKeyShowWithAnimationParams";
    private static final String TAG = "CJPayAgreementActivity";
    private CJPayAgreementDetailFragment mAgreementDetailFragment;
    private CJPayAgreementFragment mAgreementListFragment;
    private final CJPayLargeScreenUtils.ConfigurationBaseline mConfigurationBaseline;
    private ArrayList<CJPayCardProtocolBean> mData;
    private View mFragmentContainer;
    private int mFragmentType;
    private int mHeight;
    private volatile boolean mIsBackClose;
    private volatile boolean mIsClickOutsideEnable;
    private volatile boolean mIsInOrOutWithAnimation;
    private final View.OnLayoutChangeListener mRootLayoutChangeListener;
    private volatile boolean mShowBgMask;
    private volatile boolean mShowNextBtn;
    private volatile boolean mShowNextInDetailPageBtn;
    private String mTitle;
    private String mUrl;

    public static /* synthetic */ void access$001(CJPayAgreementBaseActivity r100, Configuration r101) {
        super.onConfigurationChanged(r101);
    }

    private void releaseAll() {
        CJPayAgreementService.agreementCallback = null;
        CJWalletCashierBtmUtils.INSTANCE.managerPageFinder(CJWalletCashierBtmUtils.BTM_TOKEN_WALLET_BIND_CARD_AGREEMENT, null);
    }

    public void com_android_ttcjpaysdk_thirdparty_agreement_activity_CJPayAgreementActivity__finish$___twin___() {
        super.finish();
    }

    public void com_android_ttcjpaysdk_thirdparty_agreement_activity_CJPayAgreementActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.ttcjpaysdk.thirdparty.agreement.activity.CJPayAgreementBaseActivity, com.android.ttcjpaysdk.thirdparty.base.CJPaySingleFragmentActivity, com.android.ttcjpaysdk.thirdparty.base.CJPayBaseActivity, com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        com_android_ttcjpaysdk_thirdparty_agreement_activity_CJPayAgreementActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    public void finishWithAgreementAgreed() {
        setResult(-1);
        finish();
    }

    @Override // com.android.ttcjpaysdk.thirdparty.agreement.activity.CJPayAgreementBaseActivity, com.android.ttcjpaysdk.thirdparty.base.CJPaySingleFragmentActivity, com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r100) {
        com_android_ttcjpaysdk_thirdparty_agreement_activity_CJPayAgreementActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r100);
    }

    @Override // com.android.ttcjpaysdk.thirdparty.agreement.activity.CJPayAgreementBaseActivity, com.android.ttcjpaysdk.thirdparty.base.CJPaySingleFragmentActivity, com.android.ttcjpaysdk.thirdparty.base.CJPayBaseActivity, com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com_android_ttcjpaysdk_thirdparty_agreement_activity_CJPayAgreementActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(this);
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_ttcjpaysdk_thirdparty_agreement_activity_CJPayAgreementActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    private void bindRootLayoutChangeListener() {
        View r100 = this.mRootView;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.removeOnLayoutChangeListener(this.mRootLayoutChangeListener);
        this.mRootView.addOnLayoutChangeListener(this.mRootLayoutChangeListener);
    }

    private JSONArray getAgreementList() {
        JSONArray r100 = new JSONArray();
        ArrayList<CJPayCardProtocolBean> r101 = this.mData;
        if (r101 != null) goto L5;
    L14:
        return r100;
    L5:
        if (r101.isEmpty() == true) goto L14;
        int r102 = 0;
    L9:
        if (r102 >= this.mData.size()) goto L14;
        if (ListProtector.get(this.mData, r102) == null) goto L13;
        r100.put(((CJPayCardProtocolBean) ListProtector.get(this.mData, r102)).name);
    L13:
        r102 = r102 + 1;
        goto L9
    }

    private JSONObject getTrackAgreementList() {
        JSONObject r100 = new JSONObject();
        r100.put("contract_list", getAgreementList());     // Catch: JSONException -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        CJLogger.b(TAG, e.getMessage());
        goto L7
    }

    private void reportModuleClickTrack() {
        CJWalletCashierBtmUtils.INSTANCE.reportModuleBTM("btm_module_click", CJWalletCashierBtmUtils.BTM_TOKEN_WALLET_BIND_CARD_AGREEMENT_CLOSE, getTrackAgreementList());
    }

    @Override // com.android.ttcjpaysdk.thirdparty.agreement.activity.CJPayAgreementBaseActivity
    public Fragment getFragment() {
        return getFragment(this.mIsInOrOutWithAnimation);
    }

    public int getFragmentCount() {
        if (this.mAgreementListFragment == null) goto L5;
        int r100 = 1;
    L7:
        if (this.mAgreementDetailFragment != null) goto L9;
        return r100;
    L9:
        return r100 + 1;
    L5:
        r100 = 0;
        goto L7
    }

    public CJPayAgreementActivity() {
        this.mFragmentType = 1;
        this.mIsInOrOutWithAnimation = true;
        this.mIsClickOutsideEnable = true;
        this.mIsBackClose = true;
        this.mShowBgMask = true;
        this.mData = new ArrayList();
        this.mHeight = 0;
        this.mConfigurationBaseline = new CJPayLargeScreenUtils.ConfigurationBaseline();
        this.mRootLayoutChangeListener = new AnonymousClass1(this);
    }

    private void initData() {
        if (getIntent() == null) goto L5;
        this.mFragmentType = getIntent().getIntExtra(CJ_PAY_KEY_AGREEMENT_TYPE_PARAMS, 1);
        this.mShowNextBtn = getIntent().getBooleanExtra(CJ_PAY_KEY_SHOW_NEXT_BTN_PARAMS, false);
        this.mShowNextInDetailPageBtn = getIntent().getBooleanExtra(CJ_PAY_KEY_SHOW_NEXT_BTN_IN_DETAIL_PAGE_PARAMS, false);
        this.mIsInOrOutWithAnimation = getIntent().getBooleanExtra(CJ_PAY_KEY_SHOW_WITH_ANIMATION_PARAMS, true);
        this.mIsClickOutsideEnable = getIntent().getBooleanExtra(CJ_PAY_KEY_AGREEMENT_IS_CLICK_OUTSIDE_ENABLE_PARAMS, true);
        this.mIsBackClose = getIntent().getBooleanExtra(CJ_PAY_KEY_AGREEMENT_IS_BACK_CLOSE_PARAMS, true);
        this.mShowBgMask = getIntent().getBooleanExtra(CJ_PAY_KEY_AGREEMENT_IS_SHOW_BG_MASK_PARAMS, true);
        this.mData = (ArrayList) getIntent().getSerializableExtra(CJ_PAY_KEY_AGREEMENT_DATA_PARAMS);
        this.mHeight = getIntent().getIntExtra(CJ_PAY_KEY_AGREEMENT_HEIGHT, 0);
    L5:
        ArrayList<CJPayCardProtocolBean> r100 = this.mData;
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.size() != 0) goto L11;
        return;
    L11:
        if (this.mFragmentType != 1) goto L15;
        this.mTitle = ((CJPayCardProtocolBean) ListProtector.get(this.mData, 0)).name;
        this.mUrl = ((CJPayCardProtocolBean) ListProtector.get(this.mData, 0)).template_url;
        return;
    }

    public void com_android_ttcjpaysdk_thirdparty_agreement_activity_CJPayAgreementActivity__onDestroy$___twin___() {
        super.onDestroy();
        View r100 = this.mRootView;
        if (r100 == null) goto L5;
        r100.removeOnLayoutChangeListener(this.mRootLayoutChangeListener);
    L5:
        releaseAll();
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseActivity
    public boolean isActivityPortrait() {
        boolean r100 = !CJPayLargeScreenUtils.isCashierLargeScreenAdaptEnabled();
        CJLogger.d(TAG, "isActivityPortrait shouldLockPortrait=" + r100);
        return r100;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (CJPayBasicUtils.isClickValid() == false) goto L14;
        int r100 = this.mFragmentType;
        if (r100 != 0) goto L8;
        reportModuleClickTrack();
        finishAfterAnimation(this.mAgreementListFragment);
        return;
    L8:
        if (r100 == 1) goto L10;
        return;
    L10:
        if (getFragmentCount() != 1) goto L12;
        reportModuleClickTrack();
        finishAfterAnimation(this.mAgreementDetailFragment);
        return;
    L12:
        showFragment(1, 0, true, false);
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        if (this.mAgreementListFragment == null) goto L10;
        ArrayList<CJPayCardProtocolBean> r100 = this.mData;
        if (r100 == null) goto L10;
        if (r100.size() <= 0) goto L10;
        this.mAgreementListFragment.setData(this.mData);
    L10:
        if (this.mIsClickOutsideEnable == false) goto L13;
        this.mRootView.setOnClickListener(new AnonymousClass2(this));
        return;
    }

    public static View INVOKEVIRTUAL_com_android_ttcjpaysdk_thirdparty_agreement_activity_CJPayAgreementActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static /* synthetic */ int access$100(CJPayAgreementActivity r100) {
        return r100.mFragmentType;
    }

    public static /* synthetic */ CJPayAgreementFragment access$200(CJPayAgreementActivity r100) {
        return r100.mAgreementListFragment;
    }

    public static /* synthetic */ CJPayAgreementDetailFragment access$300(CJPayAgreementActivity r100) {
        return r100.mAgreementDetailFragment;
    }

    public static /* synthetic */ boolean access$500(CJPayAgreementActivity r100) {
        return r100.mShowBgMask;
    }

    public static void com_android_ttcjpaysdk_thirdparty_agreement_activity_CJPayAgreementActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(CJPayAgreementActivity r100) {
        r100.com_android_ttcjpaysdk_thirdparty_agreement_activity_CJPayAgreementActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_android_ttcjpaysdk_thirdparty_agreement_activity_CJPayAgreementActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static void com_android_ttcjpaysdk_thirdparty_agreement_activity_CJPayAgreementActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(CJPayAgreementActivity r110) {
        r110.com_android_ttcjpaysdk_thirdparty_agreement_activity_CJPayAgreementActivity__finish$___twin___();
        if ((r110 instanceof ChatWindowActivity) == false) goto L5;
        return;
    L5:
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(r110.getClass().getName()));
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
        r110.overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L44
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

    public static void com_android_ttcjpaysdk_thirdparty_agreement_activity_CJPayAgreementActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(CJPayAgreementActivity r100) {
        if ((r100 instanceof FragmentActivity) == true) goto L5;
    L7:
        r100.com_android_ttcjpaysdk_thirdparty_agreement_activity_CJPayAgreementActivity__onDestroy$___twin___();
        return;
    L5:
        if (WindowUtils.INSTANCE.isMainBotActivity(r100) == false) goto L7;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(r100);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(r100.getClass().getName()));
        goto L7
    }

    private Fragment getFragment(boolean r110) {
        Bundle r100 = new Bundle();
        int r101 = this.mFragmentType;
        if (r101 != 0) goto L5;
        this.mAgreementListFragment = new CJPayAgreementFragment();
        r100.putBoolean("param_show_next_btn", this.mShowNextBtn);
        r100.putBoolean("params_show_with_animation", r110);
        r100.putInt("param_height", this.mHeight);
        r100.putBoolean("param_is_back_close", this.mIsBackClose);
        this.mAgreementListFragment.setArguments(r100);
        return this.mAgreementListFragment;
    L5:
        if (r101 == 1) goto L8;
        return null;
    L8:
        CJPayAgreementDetailFragment r102 = new CJPayAgreementDetailFragment();
        this.mAgreementDetailFragment = r102;
        r102.setAgreementInfo(this.mUrl, this.mTitle);
        r100.putBoolean("param_show_next_btn", this.mShowNextInDetailPageBtn);
        r100.putBoolean("params_show_with_animation", r110);
        r100.putInt("param_height", this.mHeight);
        if (getFragmentCount() <= 1) goto L11;
        r100.putBoolean("param_is_back_close", false);
    L12:
        this.mAgreementDetailFragment.setArguments(r100);
        return this.mAgreementDetailFragment;
    L11:
        r100.putBoolean("param_is_back_close", this.mIsBackClose);
        goto L12
    }

    private void recordConfigurationBaseline(String r100) {
        this.mConfigurationBaseline.record(this, this.mRootView);
        CJLogger.d(TAG, "record agreement configuration baseline, reason=" + r100 + ", width=" + this.mConfigurationBaseline.getWidthPx() + ", orientation=" + this.mConfigurationBaseline.getOrientation());
    }

    private void refreshAgreementClipHostLayout(String r100) {
        if (this.mFragmentContainer != null) goto L5;
        return;
    L5:
        int r101 = CJPayLargeScreenUtils.resolveWindowWidthPx(this, this.mRootView);
        if (r101 > 0) goto L9;
        CJLogger.e(TAG, "skip refresh agreement clip host: invalid rootWidth=" + r101 + ", reason=" + r100);
        return;
    L9:
        boolean r102 = CJPayLargeScreenUtils.isLargeScreen(this, r101);
        if (r102 == false) goto L12;
        int r103 = CJPayLargeScreenUtils.resolveCashierVisibleWidthPx(this, r101);
    L13:
        ViewGroup.LayoutParams r104 = this.mFragmentContainer.getLayoutParams();
        if (r104 == null) goto L19;
        r104.width = r103;
        if ((r104 instanceof LinearLayout.LayoutParams) == false) goto L18;
        ((LinearLayout.LayoutParams) r104).gravity = 1;
    L18:
        this.mFragmentContainer.setLayoutParams(r104);
    L19:
        View r105 = this.mFragmentContainer;
        if ((r105 instanceof ViewGroup) == false) goto L22;
        ((ViewGroup) r105).setClipChildren(true);
        ((ViewGroup) this.mFragmentContainer).setClipToPadding(true);
    L22:
        CJLogger.d(TAG, "refresh agreement clip host, reason=" + r100 + ", rootWidth=" + r101 + ", targetWidth=" + r103 + ", isLargeScreen=" + r102);
        return;
    L12:
        r103 = -1;
        goto L13
    }

    private void refreshLargeScreenLayoutAfterRootReady(final String r100) {
        if (this.mRootView != null) goto L6;
        return;
    L6:
        if (CJPayLargeScreenUtils.isCashierLargeScreenAdaptEnabled() == true) goto L9;
        CJLogger.d(TAG, "skip refresh agreement layout: experiment disabled, reason=" + r100);
        return;
    L9:
        this.mRootView.post(new AnonymousClass4(this, r100));
    }

    private void syncBackgroundMask(String r100) {
        View r101 = this.mRootView;
        if (r101 != null) goto L5;
        return;
    L5:
        boolean r102 = CJPayLargeScreenUtils.isLargeScreen(this, r101);
        if (r102 == false) goto L8;
        int r103 = CJPayLargeScreenUtils.LARGE_SCREEN_MASK_COLOR;
    L9:
        this.mRootView.setBackgroundColor(r103);
        CJLogger.d(TAG, "sync agreement mask, reason=" + r100 + ", isLargeScreen=" + r102);
        return;
    L8:
        r103 = ColorProtector.parseColor(CJPayAnimationUtils.CJ_PAY_BG_LAYER_COLOR);
        goto L9
    }

    public void com_android_ttcjpaysdk_thirdparty_agreement_activity_CJPayAgreementActivity__onCreate$___twin___(Bundle r100) {
        setHalfTranslucent();
        initData();
        super.onCreate(r100);
        this.mFragmentContainer = findViewById(com.larus.nova.R.id.fl_container);
        refreshAgreementClipHostLayout("on_create");
        if (this.mShowBgMask == false) goto L5;
        updateBackgroundMask(true, "on_create");
    L6:
        this.mRootView.setFitsSystemWindows(true);
        this.mSwipeToFinishView.setEnableSwipe(false);
        bindRootLayoutChangeListener();
        recordConfigurationBaseline("on_create");
        Lazy r101 = CJBtmUtils.f202293a;
        CJBtmUtils.g(this, CJWalletCashierBtmUtils.BTM_TOKEN_WALLET_BIND_CARD_AGREEMENT);
        CJWalletCashierBtmUtils r102 = CJWalletCashierBtmUtils.INSTANCE;
        r102.managerPageFinder(CJWalletCashierBtmUtils.BTM_TOKEN_WALLET_BIND_CARD_AGREEMENT, new CJPageFinder().via(this));
        r102.setBtmPageShowParams(CJWalletCashierBtmUtils.BTM_TOKEN_WALLET_BIND_CARD_AGREEMENT, new JSONObject[]{getTrackAgreementList()});
        return;
    L5:
        this.mRootView.setBackgroundColor(ColorProtector.parseColor("#00000000"));
        goto L6
    }

    public void finishAfterAnimation(CJPayBaseFragment r100) {
        if (r100 == null) goto L7;
        r100.inOrOutWithAnimation(true, false);
        if (this.mShowBgMask == false) goto L6;
        updateBackgroundMask(false, "finish_after_animation");
        goto L7
    L6:
        this.mRootView.setBackgroundColor(ColorProtector.parseColor("#00000000"));
    L7:
        new Handler(Looper.getMainLooper()).postDelayed(new AnonymousClass3(this), 300);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r100) {
        INVOKESPECIAL_com_android_ttcjpaysdk_thirdparty_agreement_activity_CJPayAgreementActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(this, r100);
        if (CJPayLargeScreenUtils.isCashierLargeScreenAdaptEnabled() == true) goto L6;
        CJLogger.d(TAG, "skip agreement large-screen relayout: experiment disabled");
        return;
    L6:
        int r101 = CJPayLargeScreenUtils.resolveWindowWidthPx(this, this.mRootView);
        boolean r102 = this.mConfigurationBaseline.isOrientationChanged(r100.orientation);
        boolean r103 = CJPayLargeScreenUtils.shouldRelayoutForWidthDelta(this.mConfigurationBaseline.getWidthPx(), r101, 0.25f);
        if (r102 == true) goto L11;
        if (r103 == true) goto L11;
        CJLogger.d(TAG, "skip agreement relayout after configuration changed, currentWidth=" + r101 + ", lastWidth=" + this.mConfigurationBaseline.getWidthPx() + ", orientationChanged=" + r102);
        recordConfigurationBaseline("configuration_changed_skip");
        return;
    L11:
        CJLogger.d(TAG, "trigger agreement relayout after configuration changed, currentWidth=" + r101 + ", lastWidth=" + this.mConfigurationBaseline.getWidthPx() + ", orientationChanged=" + r102 + ", widthChangedEnough=" + r103);
        recordConfigurationBaseline("configuration_changed");
        refreshLargeScreenLayoutAfterRootReady("configuration_changed");
    }

    public static void INVOKESPECIAL_com_android_ttcjpaysdk_thirdparty_agreement_activity_CJPayAgreementActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(CJPayAgreementBaseActivity r100, Configuration r101) {
        access$001(r100, r101);
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (d.a() == true) goto L22;
        int r102 = r100.getRequestedOrientation();     // Catch: Throwable -> L17
        if (r101 == null) goto L8;
        Integer r103 = Integer.valueOf(r101.orientation);     // Catch: Throwable -> L17
    L9:
        if (r103 != null) goto L12;
    L14:
        if (r102 != 3) goto L24;
        r100.setRequestedOrientation(1);     // Catch: Throwable -> L17
        FLogger.f375446a.i("PadLancet", "onConfigurationChanged, phone reset page:" + r100.getClass().getSimpleName() + " portrait");     // Catch: Throwable -> L17
        return;
    L24:
        return;
    L12:
        if (r103.intValue() != r102) goto L14;
        return;
    L8:
        r103 = null;
        goto L9
    L22:
        return;
    L17:
        th = move-exception;
        FLogger.f375446a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
    }

    public static /* synthetic */ void access$400(CJPayAgreementActivity r100, String r101) {
        r100.refreshAgreementClipHostLayout(r101);
    }

    public static /* synthetic */ void access$600(CJPayAgreementActivity r100, String r101) {
        r100.syncBackgroundMask(r101);
    }

    private void addFragmentToContainer(boolean r100, boolean r101) {
        int r102 = this.mFragmentType;
        if (r102 != 0) goto L5;
        CJPayAgreementFragment r103 = this.mAgreementListFragment;
        if (r103 != null) goto L14;
        addFragment(getFragment(this.mIsInOrOutWithAnimation), r100);
        return;
    L14:
        showFragment(r103, r100);
        return;
    L5:
        if (r102 != 1) goto L19;
        CJPayAgreementDetailFragment r104 = this.mAgreementDetailFragment;
        if (r104 != null) goto L10;
        addFragment(getFragment(r101), r100);
        return;
    L10:
        showFragment(r104, r100);
        return;
    }

    public static void com_android_ttcjpaysdk_thirdparty_agreement_activity_CJPayAgreementActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(CJPayAgreementActivity r100, Bundle r101) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(r100.getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(r100) == false) goto L8;
        f.c(r100.getTheme());     // Catch: Throwable -> L10
    L8:
        r100.com_android_ttcjpaysdk_thirdparty_agreement_activity_CJPayAgreementActivity__onCreate$___twin___(r101);
    }

    private void handleRootLayoutChanged(int r100, int r101) {
        if (r100 <= 0) goto L10;
        if (r100 != r101) goto L6;
        return;
    L6:
        if (CJPayLargeScreenUtils.shouldRelayoutForWidthDelta(this.mConfigurationBaseline.getWidthPx(), r100, 0.25f) == true) goto L8;
        return;
    L8:
        CJLogger.d(TAG, "trigger agreement relayout after root size changed, currentWidth=" + r100 + ", oldWidth=" + r101 + ", lastWidth=" + this.mConfigurationBaseline.getWidthPx());
        recordConfigurationBaseline("root_size_changed");
        refreshLargeScreenLayoutAfterRootReady("root_size_changed");
        return;
    }

    private void updateBackgroundMask(boolean r110, String r111) {
        View r100 = this.mRootView;
        if (r100 != null) goto L5;
        return;
    L5:
        boolean r101 = CJPayLargeScreenUtils.isLargeScreen(this, r100);
        int r102 = CJPayLargeScreenUtils.LARGE_SCREEN_MASK_COLOR;
        if (r110 == false) goto L12;
        int r103 = ColorProtector.parseColor("#00000000");
        if (r101 == true) goto L11;
        r102 = ColorProtector.parseColor(CJPayAnimationUtils.CJ_PAY_BG_LAYER_COLOR);
    L11:
        int r104 = r102;
        int r105 = r103;
    L16:
        CJPayAnimationUtils.viewColorAnimation(this.mRootView, r105, r104, 300, null);
        CJLogger.d(TAG, "update agreement mask, reason=" + r111 + ", isToDarken=" + r110 + ", isLargeScreen=" + r101);
        return;
    L12:
        if (r101 == true) goto L15;
        r102 = ColorProtector.parseColor(CJPayAnimationUtils.CJ_PAY_BG_LAYER_COLOR);
    L15:
        r105 = r102;
        r104 = ColorProtector.parseColor("#00000000");
        goto L16
    }

    public void addFragment(Fragment r100, boolean r101) {
        CJPayActivityUtils.addFragment(getActivity(), r100, com.larus.nova.R.id.fl_container, r101);
    }

    public void gotoAgreementDetail(String r100, String r101) {
        this.mTitle = r101;
        this.mUrl = r100;
        showFragment(-1, 1, true, false);
    }

    public void removeFragment(int r100, boolean r101) {
        if (r100 != 0) goto L5;
        removeFragment(this.mAgreementListFragment, r101);
        this.mAgreementListFragment = null;
        return;
    L5:
        if (r100 != 1) goto L11;
        removeFragment(this.mAgreementDetailFragment, r101);
        this.mAgreementDetailFragment = null;
        return;
    }

    public void showFragment(Fragment r100, boolean r101) {
        CJPayActivityUtils.showFragment(getActivity(), r100, r101);
    }

    public void removeFragment(Fragment r100, boolean r101) {
        CJPayActivityUtils.removeFragment(getActivity(), r100, r101);
    }

    public static /* synthetic */ void access$000(CJPayAgreementActivity r100, int r101, int r102) {
        r100.handleRootLayoutChanged(r101, r102);
    }

    public void showFragment(int r100, int r101, boolean r102, boolean r103) {
        if (this.mFragmentType != r101) goto L5;
        return;
    L5:
        removeFragment(r100, r102);
        this.mFragmentType = r101;
        addFragmentToContainer(r102, r103);
    }

    public static void start(Context r100, int r101, ArrayList<CJPayCardProtocolBean> r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r107) {
        CJPayRouterAPI.getInstance().build(CJPayAgreementActivity.class).withInt(CJ_PAY_KEY_AGREEMENT_TYPE_PARAMS, r101).withSerializable(CJ_PAY_KEY_AGREEMENT_DATA_PARAMS, r102).withBoolean(CJ_PAY_KEY_SHOW_NEXT_BTN_PARAMS, r103).withBoolean(CJ_PAY_KEY_SHOW_NEXT_BTN_IN_DETAIL_PAGE_PARAMS, r104).withBoolean(CJ_PAY_KEY_SHOW_WITH_ANIMATION_PARAMS, r105).withBoolean(CJ_PAY_KEY_AGREEMENT_IS_CLICK_OUTSIDE_ENABLE_PARAMS, r106).withBoolean(CJ_PAY_KEY_AGREEMENT_IS_BACK_CLOSE_PARAMS, r107).navigation(r100);
    }

    public static void start(Context r100, int r101, ArrayList<CJPayCardProtocolBean> r102, int r103, boolean r104, boolean r105, boolean r106, boolean r107, boolean r110) {
        CJPayRouterAPI.getInstance().build(CJPayAgreementActivity.class).withInt(CJ_PAY_KEY_AGREEMENT_TYPE_PARAMS, r101).withSerializable(CJ_PAY_KEY_AGREEMENT_DATA_PARAMS, r102).withInt(CJ_PAY_KEY_AGREEMENT_HEIGHT, r103).withBoolean(CJ_PAY_KEY_SHOW_NEXT_BTN_PARAMS, r104).withBoolean(CJ_PAY_KEY_SHOW_NEXT_BTN_IN_DETAIL_PAGE_PARAMS, r105).withBoolean(CJ_PAY_KEY_SHOW_WITH_ANIMATION_PARAMS, r106).withBoolean(CJ_PAY_KEY_AGREEMENT_IS_CLICK_OUTSIDE_ENABLE_PARAMS, r107).withBoolean(CJ_PAY_KEY_AGREEMENT_IS_BACK_CLOSE_PARAMS, r110).navigation(r100);
    }

    public static void start(Context r100, int r101, ArrayList<CJPayCardProtocolBean> r102, int r103, boolean r104, boolean r105, boolean r106, boolean r107, boolean r110, boolean r111) {
        CJPayRouterAPI.getInstance().build(CJPayAgreementActivity.class).withInt(CJ_PAY_KEY_AGREEMENT_TYPE_PARAMS, r101).withSerializable(CJ_PAY_KEY_AGREEMENT_DATA_PARAMS, r102).withInt(CJ_PAY_KEY_AGREEMENT_HEIGHT, r103).withBoolean(CJ_PAY_KEY_SHOW_NEXT_BTN_PARAMS, r104).withBoolean(CJ_PAY_KEY_SHOW_NEXT_BTN_IN_DETAIL_PAGE_PARAMS, r105).withBoolean(CJ_PAY_KEY_SHOW_WITH_ANIMATION_PARAMS, r106).withBoolean(CJ_PAY_KEY_AGREEMENT_IS_CLICK_OUTSIDE_ENABLE_PARAMS, r107).withBoolean(CJ_PAY_KEY_AGREEMENT_IS_BACK_CLOSE_PARAMS, r110).withBoolean(CJ_PAY_KEY_AGREEMENT_IS_SHOW_BG_MASK_PARAMS, r111).navigation(r100);
    }
}
