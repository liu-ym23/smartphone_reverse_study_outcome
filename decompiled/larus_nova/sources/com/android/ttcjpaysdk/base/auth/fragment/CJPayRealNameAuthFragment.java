package com.android.ttcjpaysdk.base.auth.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.android.ttcjpaysdk.base.auth.CJPayRealNameAuthService;
import com.android.ttcjpaysdk.base.auth.activity.CJPayRealNameAuthActivity;
import com.android.ttcjpaysdk.base.auth.data.CJPayBusiAuthorizeInfo;
import com.android.ttcjpaysdk.base.auth.data.TTCJPayAuthContent;
import com.android.ttcjpaysdk.base.auth.data.TTCJPayQueryAuthInfo;
import com.android.ttcjpaysdk.base.auth.presenter.CJPayRealNameAuthPresenter;
import com.android.ttcjpaysdk.base.auth.utils.CJPayAuthLogUtils;
import com.android.ttcjpaysdk.base.auth.wrapper.CJPayRealNameAuthWrapper;
import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import com.android.ttcjpaysdk.base.eventbus.EventManager;
import com.android.ttcjpaysdk.base.eventbus.Observer;
import com.android.ttcjpaysdk.base.framework.BaseFragment;
import com.android.ttcjpaysdk.base.framework.event.CJPayFinishH5ActivityEvent;
import com.android.ttcjpaysdk.base.framework.event.CJPayLogoutAccountEvent;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.ktextension.CJPayKotlinExtensionsKt;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayDialogUtils;
import com.android.ttcjpaysdk.base.ui.widget.CJPayTextLoadingView;
import com.android.ttcjpaysdk.base.utils.CJPayAnimationUtils;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayRealNameAuthCallback;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001CB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\u0018\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020\rJ\b\u0010#\u001a\u00020\u0007H\u0014J\b\u0010$\u001a\u00020\u0005H\u0016J\b\u0010%\u001a\u00020\u001dH\u0002J\u0012\u0010&\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010'\u001a\u00020\u001dH\u0014J\u001c\u0010(\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\u001b\u0010+\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020.0-0,H\u0016¢\u0006\u0002\u0010/J\b\u00100\u001a\u00020\u001dH\u0016J\b\u00101\u001a\u00020\u001dH\u0016J\u0010\u00102\u001a\u00020\u001d2\u0006\u00103\u001a\u00020.H\u0016J\u0010\u00104\u001a\u00020\u001d2\u0006\u00105\u001a\u00020\u0005H\u0002J\u0012\u00106\u001a\u00020\u001d2\b\u00107\u001a\u0004\u0018\u000108H\u0002JJ\u00109\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u00052\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010@2\u0006\u0010B\u001a\u00020@R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/android/ttcjpaysdk/base/auth/fragment/CJPayRealNameAuthFragment;", "Lcom/android/ttcjpaysdk/base/framework/BaseFragment;", "Lcom/android/ttcjpaysdk/base/eventbus/Observer;", "()V", "activity_info", "", "authorizeItem", "", "contentLayout", "Landroid/widget/FrameLayout;", "dialog", "Lcom/android/ttcjpaysdk/base/ui/dialog/CJPayCommonDialog;", "isLogoutAccountSuccess", "", "isNoiseReduceStyle", "loadingView", "Lcom/android/ttcjpaysdk/base/ui/widget/CJPayTextLoadingView;", "presenter", "Lcom/android/ttcjpaysdk/base/auth/presenter/CJPayRealNameAuthPresenter;", "realNameAuthWrapper", "Lcom/android/ttcjpaysdk/base/auth/wrapper/CJPayRealNameAuthWrapper;", "getRealNameAuthWrapper", "()Lcom/android/ttcjpaysdk/base/auth/wrapper/CJPayRealNameAuthWrapper;", "setRealNameAuthWrapper", "(Lcom/android/ttcjpaysdk/base/auth/wrapper/CJPayRealNameAuthWrapper;)V", "rootLayout", "Landroid/view/ViewGroup;", "status", "bindViews", "", "contentView", "Landroid/view/View;", "executeTranslateAnimation", "isUP", "isClose", "getContentViewLayoutId", "getFragmentName", "gotoCreateAuth", "initActions", "initData", "initViews", "savedInstanceState", "Landroid/os/Bundle;", "listEvents", "", "Ljava/lang/Class;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "()[Ljava/lang/Class;", LiveCommonConstants.REASON_ON_DEDTROY, "onDestroyView", "onEvent", "event", "setJson", "info", "setResponse", "json", "Lorg/json/JSONObject;", "showDialog", "title", "errorMsg", "leftBtnStr", "rightBtnStr", "singleBtnStr", "leftClickListener", "Landroid/view/View$OnClickListener;", "rightClickListener", "singleClickListener", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayRealNameAuthFragment extends BaseFragment implements Observer {
    private static final String AUTH_FAILED = "0";
    private static final String AUTH_SUCCESS = "1";
    public static final Companion Companion = null;
    public static final int STATUS_TO_BUSINESS = 1;
    public static final int STATUS_TO_CAIJING = 0;
    private static final String THEME_AUTH = "auth";
    private static final String THEME_PAY = "pay";
    private String activity_info;
    private int authorizeItem;
    private FrameLayout contentLayout;
    private CJPayCommonDialog dialog;
    private boolean isLogoutAccountSuccess;
    private boolean isNoiseReduceStyle;
    private CJPayTextLoadingView loadingView;
    private CJPayRealNameAuthPresenter presenter;
    public CJPayRealNameAuthWrapper realNameAuthWrapper;
    private ViewGroup rootLayout;
    private int status;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/auth/fragment/CJPayRealNameAuthFragment$Companion;", "", "()V", "AUTH_FAILED", "", "AUTH_SUCCESS", "STATUS_TO_BUSINESS", "", "STATUS_TO_CAIJING", "THEME_AUTH", "THEME_PAY", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public int getContentViewLayoutId() {
        return R.layout.cj_pay_fragment_real_name_auth;
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public String getFragmentName() {
        return "实名授权页";
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public void initActions(View r100) {
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public void initViews(View r100, Bundle r101) {
    }

    @Override // com.android.ttcjpaysdk.base.eventbus.Observer
    public Class<? extends BaseEvent>[] listEvents() {
        return new Class[]{CJPayLogoutAccountEvent.class, CJPayFinishH5ActivityEvent.class};
    }

    private final void gotoCreateAuth() {
        CJPayRealNameAuthPresenter r100 = this.presenter;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
        r100 = null;
    L5:
        r100.createAuthorization(this.authorizeItem, new AnonymousClass1(this));
    }

    public final CJPayRealNameAuthWrapper getRealNameAuthWrapper() {
        CJPayRealNameAuthWrapper r100 = this.realNameAuthWrapper;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("realNameAuthWrapper");
        return null;
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public void initData() {
        if (this.status != 1) goto L13;
        this.presenter = new CJPayRealNameAuthPresenter(getStringParam(CJPayRealNameAuthActivity.KEY_MERCHANT_ID), getStringParam(CJPayRealNameAuthActivity.KEY_APP_ID));
        CJPayTextLoadingView r100 = this.loadingView;
        CJPayRealNameAuthPresenter r101 = null;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        r100 = null;
    L7:
        r100.show();
        CJPayRealNameAuthPresenter r102 = this.presenter;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L11:
        r101.fetchAuthInfo(getStringParam(CJPayRealNameAuthActivity.KEY_SCENE), new C88111(this));
        return;
    L10:
        r101 = r102;
        goto L11
    L13:
        if (TextUtils.isEmpty(getStringParam("activity_info")) == true) goto L15;
        String r103 = getStringParam("activity_info");
    L16:
        this.activity_info = r103;
        setJson(getStringParam(CJPayRealNameAuthActivity.KEY_INFO));
        return;
    L15:
        r103 = "[]";
        goto L16
    }

    public CJPayRealNameAuthFragment() {
        this.authorizeItem = 1;
        this.status = 1;
        this.activity_info = "[]";
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        CJPayRealNameAuthPresenter r100 = this.presenter;
        if (r100 == null) goto L7;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
        r100 = null;
    L6:
        r100.cancelRequest();
    L7:
        getRealNameAuthWrapper().release();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventManager.INSTANCE.unregister(this);
    }

    public static void INVOKEVIRTUAL_com_android_ttcjpaysdk_base_auth_fragment_CJPayRealNameAuthFragment_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(CJPayCommonDialog r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public static final /* synthetic */ FrameLayout access$getContentLayout$p(CJPayRealNameAuthFragment r100) {
        return r100.contentLayout;
    }

    public static final /* synthetic */ CJPayCommonDialog access$getDialog$p(CJPayRealNameAuthFragment r100) {
        return r100.dialog;
    }

    public static final /* synthetic */ CJPayTextLoadingView access$getLoadingView$p(CJPayRealNameAuthFragment r100) {
        return r100.loadingView;
    }

    public static final /* synthetic */ Context access$getMContext$p$s24526946(CJPayRealNameAuthFragment r100) {
        return r100.mContext;
    }

    public static final /* synthetic */ void access$gotoCreateAuth(CJPayRealNameAuthFragment r100) {
        r100.gotoCreateAuth();
    }

    private final void setJson(String r110) {
        final CJPayRealNameAuthWrapper r100 = getRealNameAuthWrapper();
        final CJPayBusiAuthorizeInfo r111 = (CJPayBusiAuthorizeInfo) CJPayJsonParser.fromJson(r110, CJPayBusiAuthorizeInfo.class);
        if (r111 == null) goto L10;
        CJPayAuthLogUtils.Companion r101 = CJPayAuthLogUtils.Companion;
        r101.initBusiParams(r111.needIdentify, r111.hasPass, r111.showOneStep, r111.isOneStep, r111.authType, new JSONArray(this.activity_info));
        r101.walletBusinesstopayAuthImp();
        r100.setIcon(r111.busi_authorize_content.business_brief_info.display_url);
        r100.setTitle(r111.busi_authorize_content.business_brief_info.display_desc);
        r100.setAuthTitle(r111.busi_authorize_content.propose_desc);
        r100.setAuthInfo(r111.busi_authorize_content.propose_contents);
        final int r102 = CJPayRealNameAuthWrapper.setAgreements$default(r100, r111.protocol_group_contents, null, null, 6, null);
        r100.setAgreementCheckBox(r111.protocol_group_contents.isNeedCheckBox());
        r100.setOnCloseClickListener(new CJPayRealNameAuthFragment$setJson$1$1$1(this));
        r100.setOnTipClickListener(new CJPayRealNameAuthFragment$setJson$1$1$2(this, r100, r111));
        r100.setOnNextStepClickListener(new CJPayRealNameAuthFragment$setJson$1$1$3(r102, this, r100, r111));
        if (this.isNoiseReduceStyle == true) goto L10;
        if (TextUtils.isEmpty(r111.busi_authorize_content.not_agreement_url) == false) goto L9;
        getRealNameAuthWrapper().hideRejectTextView();
        goto L10
    L9:
        r100.setOnRejectClickListener(new CJPayRealNameAuthFragment$setJson$1$1$4(this, r100, r111));
    L10:
        FragmentActivity r112 = getActivity();
        if ((r112 instanceof CJPayRealNameAuthActivity) == false) goto L13;
        CJPayRealNameAuthActivity r113 = (CJPayRealNameAuthActivity) r112;
    L14:
        if (r113 == null) goto L16;
        r113.setRootLayoutBgColor(getResources().getColor(R.color.cj_pay_color_trans_4c));
    L16:
        FrameLayout r114 = this.contentLayout;
        if (r114 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
        r114 = null;
    L19:
        r114.setVisibility(0);
        executeTranslateAnimation$default(this, true, false, 2, null);
        return;
    L13:
        r113 = null;
        goto L14
    }

    private final void setResponse(JSONObject r110) {
        if (this.mContext != null) goto L5;
        return;
    L5:
        if (getActivity() == null) goto L56;
        CJPayTextLoadingView r100 = this.loadingView;
        if (r100 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        r100 = null;
    L10:
        r100.hide();
        CJPayAuthLogUtils.Companion.logPageShow();
        final TTCJPayQueryAuthInfo r101 = new TTCJPayQueryAuthInfo(null, 0, 0, 7, null);
        if (r110 == null) goto L13;
        JSONObject r111 = r110.optJSONObject("response");
    L14:
        r101.parseJson(r111);
        if (Intrinsics.areEqual(r101.code, "UM0000") == false) goto L45;
        if (r101.is_authorize != 1) goto L24;
        TTCJPayRealNameAuthCallback r112 = CJPayRealNameAuthService.Companion.getRealNameAuthCallback();
        if (r112 == null) goto L21;
        r112.onAuthResult(TTCJPayRealNameAuthCallback.AuthResult.AUTHORIZED);
    L21:
        CJPayKotlinExtensionsKt.finishSafely(getActivity());
        return;
    L24:
        if (r101.is_auth != 0) goto L30;
        TTCJPayRealNameAuthCallback r113 = CJPayRealNameAuthService.Companion.getRealNameAuthCallback();
        if (r113 == null) goto L28;
        r113.onAuthResult(TTCJPayRealNameAuthCallback.AuthResult.WITHOUT_REAL_NAME);
    L28:
        CJPayKotlinExtensionsKt.finishSafely(getActivity());
        return;
    L30:
        this.authorizeItem = r101.authorization_agreement_info.authorize_item;
        final CJPayRealNameAuthWrapper r114 = getRealNameAuthWrapper();
        r114.setIconAndTitle(r101.authorization_agreement_info.business_brief_info);
        r114.setAuthTitle(r101.authorization_agreement_info.propose_desc);
        r114.setAuthInfo(r101.authorization_agreement_info.propose_contents);
        TTCJPayAuthContent r102 = r101.authorization_agreement_info;
        CJPayRealNameAuthWrapper.setAgreements$default(r114, r102.agreement_contents, r102.second_agreement_contents, null, null, 12, null);
        r114.setOnCloseClickListener(new CJPayRealNameAuthFragment$setResponse$1$1$1(this));
        r114.setOnTipClickListener(new CJPayRealNameAuthFragment$setResponse$1$1$2(this, r114));
        r114.setOnNextStepClickListener(new CJPayRealNameAuthFragment$setResponse$1$1$3(r101, this, r114));
        if (TextUtils.isEmpty(r101.authorization_agreement_info.not_agreement_url) == false) goto L33;
        getRealNameAuthWrapper().hideRejectTextView();
    L34:
        FragmentActivity r115 = getActivity();
        if ((r115 instanceof CJPayRealNameAuthActivity) == false) goto L37;
        CJPayRealNameAuthActivity r116 = (CJPayRealNameAuthActivity) r115;
    L38:
        if (r116 == null) goto L40;
        r116.setRootLayoutBgColor(getResources().getColor(R.color.cj_pay_color_trans_4c));
    L40:
        FrameLayout r117 = this.contentLayout;
        if (r117 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
        r117 = null;
    L43:
        r117.setVisibility(0);
        executeTranslateAnimation$default(this, true, false, 2, null);
        return;
    L37:
        r116 = null;
        goto L38
    L33:
        r114.setOnRejectClickListener(new CJPayRealNameAuthFragment$setResponse$1$1$4(this, r101, r114));
        goto L34
    L45:
        if (r101.is_auth != 0) goto L49;
        TTCJPayRealNameAuthCallback r118 = CJPayRealNameAuthService.Companion.getRealNameAuthCallback();
        if (r118 == null) goto L52;
        r118.onAuthResult(TTCJPayRealNameAuthCallback.AuthResult.WITHOUT_REAL_NAME);
    L52:
        CJPayKotlinExtensionsKt.finishSafely(getActivity());
        return;
    L49:
        TTCJPayRealNameAuthCallback r119 = CJPayRealNameAuthService.Companion.getRealNameAuthCallback();
        if (r119 == null) goto L52;
        r119.onAuthResult(TTCJPayRealNameAuthCallback.AuthResult.QUERY_AUTH_INFO_ERROR);
        goto L52
    L13:
        r111 = null;
        goto L14
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public void bindViews(View r100) {
        Intrinsics.checkNotNullParameter(r100, "contentView");
        EventManager.INSTANCE.register(this);
        this.isNoiseReduceStyle = getBooleanParam(CJPayRealNameAuthActivity.KEY_IS_NOISE_REDUCE_STYLE, Boolean.FALSE).booleanValue();
        this.status = TextUtils.isEmpty(getStringParam(CJPayRealNameAuthActivity.KEY_INFO)) ? 1 : 0;
        CJPayAuthLogUtils.Companion.init(getStringParam(CJPayRealNameAuthActivity.KEY_APP_ID), getStringParam(CJPayRealNameAuthActivity.KEY_MERCHANT_ID), getStringParam(CJPayRealNameAuthActivity.KEY_EVENT_TRACK));
        this.rootLayout = (ViewGroup) r100.findViewById(R.id.cj_pay_root_layout);
        this.loadingView = (CJPayTextLoadingView) r100.findViewById(R.id.cj_pay_loading_view);
        String r101 = getStringParam(CJPayRealNameAuthActivity.KEY_THEME);
        if (Intrinsics.areEqual(r101, "auth") == false) goto L9;
        if (this.isNoiseReduceStyle == false) goto L7;
        FrameLayout r102 = (FrameLayout) r100.findViewById(R.id.cj_pay_content_layout_auth_noise_reduction);
    L12:
        this.contentLayout = r102;
        if (r102 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
        r102 = null;
    L15:
        CJPayRealNameAuthWrapper r103 = new CJPayRealNameAuthWrapper(r102, this.isNoiseReduceStyle);
        r103.setStyle(getStringParam(CJPayRealNameAuthActivity.KEY_STYLE));
        setRealNameAuthWrapper(r103);
        return;
    L7:
        r102 = (FrameLayout) r100.findViewById(R.id.cj_pay_content_layout_auth);
        goto L12
    L9:
        if (Intrinsics.areEqual(r101, THEME_PAY) == false) goto L11;
        r102 = (FrameLayout) r100.findViewById(R.id.cj_pay_content_layout_pay);
        goto L12
    L11:
        r102 = (FrameLayout) r100.findViewById(R.id.cj_pay_content_layout_auth);
        goto L12
    }

    @Override // com.android.ttcjpaysdk.base.eventbus.Observer
    public void onEvent(BaseEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof CJPayFinishH5ActivityEvent) == false) goto L13;
        FrameLayout r101 = this.contentLayout;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
        r101 = null;
    L8:
        if (r101.isShown() == false) goto L10;
        return;
    L10:
        if (this.isLogoutAccountSuccess == true) goto L20;
        executeTranslateAnimation$default(this, true, false, 2, null);
        return;
    L20:
        return;
    L13:
        if ((r100 instanceof CJPayLogoutAccountEvent) == false) goto L22;
        this.isLogoutAccountSuccess = true;
        TTCJPayRealNameAuthCallback r102 = CJPayRealNameAuthService.Companion.getRealNameAuthCallback();
        if (r102 == null) goto L17;
        r102.onAuthResult(TTCJPayRealNameAuthCallback.AuthResult.LOGOUT_ACCOUNT);
    L17:
        CJPayKotlinExtensionsKt.finishSafely(getActivity());
        return;
    }

    public final void setRealNameAuthWrapper(CJPayRealNameAuthWrapper r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.realNameAuthWrapper = r100;
    }

    public static final /* synthetic */ String access$getStringParam(CJPayRealNameAuthFragment r100, String r101) {
        return r100.getStringParam(r101);
    }

    public static final /* synthetic */ void access$setResponse(CJPayRealNameAuthFragment r100, JSONObject r101) {
        r100.setResponse(r101);
    }

    public final void executeTranslateAnimation(final boolean r100, final boolean r101) {
        FrameLayout r102 = this.contentLayout;
        FrameLayout r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
        r102 = null;
    L5:
        Integer r104 = Integer.valueOf(r102.getMeasuredHeight());
        if (r104.intValue() != 0) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == true) goto L12;
        r104 = null;
    L12:
        if (r104 == null) goto L20;
        r104.intValue();
        int r106 = View.MeasureSpec.makeMeasureSpec(0, 0);
        FrameLayout r107 = this.contentLayout;
        if (r107 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
        r107 = null;
    L16:
        r107.measure(r106, r106);
        FrameLayout r108 = this.contentLayout;
        if (r108 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
        r108 = null;
    L19:
        r108.post(new CJPayRealNameAuthFragment$executeTranslateAnimation$2$2(this));
    L20:
        FrameLayout r109 = this.contentLayout;
        if (r109 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
        r109 = null;
    L23:
        FrameLayout r110 = this.contentLayout;
        if (r110 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
    L27:
        CJPayAnimationUtils.upAndDownAnimation(r109, r100, r103.getMeasuredHeight(), new AnonymousClass3(r100, r101, this));
        return;
    L26:
        r103 = r110;
        goto L27
    L8:
        r105 = false;
        goto L9
    }

    public static /* synthetic */ void executeTranslateAnimation$default(CJPayRealNameAuthFragment r100, boolean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = true;
    L5:
        r100.executeTranslateAnimation(r101, r102);
    }

    public final void showDialog(String r100, String r101, String r102, String r103, String r104, View.OnClickListener r105, View.OnClickListener r110, View.OnClickListener r111) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        Intrinsics.checkNotNullParameter(r102, "leftBtnStr");
        Intrinsics.checkNotNullParameter(r103, "rightBtnStr");
        Intrinsics.checkNotNullParameter(r104, "singleBtnStr");
        Intrinsics.checkNotNullParameter(r111, "singleClickListener");
        Context r106 = getContext();
        Activity r107 = null;
        if ((r106 instanceof Activity) == false) goto L5;
        Activity r108 = (Activity) r106;
    L6:
        if (r108 != null) goto L8;
        return;
    L8:
        if ((!r108.isFinishing()) == false) goto L10;
        r107 = r108;
    L10:
        if (r107 == null) goto L16;
        CJPayCommonDialog r109 = CJPayDialogUtils.initDialog(CJPayDialogUtils.getDefaultBuilder(r107).setTitle(r100).setSubTitle(r101).setLeftBtnStr(r102).setRightBtnStr(r103).setSingleBtnStr(r104).setLeftBtnListener(r105).setRightBtnListener(r110).setSingleBtnListener(r111));
        this.dialog = r109;
        if (r109 == null) goto L17;
        INVOKEVIRTUAL_com_android_ttcjpaysdk_base_auth_fragment_CJPayRealNameAuthFragment_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r109);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r108 = null;
        goto L6
    }
}
