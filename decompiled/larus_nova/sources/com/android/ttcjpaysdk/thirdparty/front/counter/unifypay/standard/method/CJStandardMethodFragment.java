package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.standard.method;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.framework.AnimUtil;
import com.android.ttcjpaysdk.base.framework.CJPayAnimRootView;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.theme.CJPayThemeUtils;
import com.android.ttcjpaysdk.base.utils.CJPayLargeScreenUtils;
import com.android.ttcjpaysdk.thirdparty.data.FrontPreTradeInfo;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.standard.common.StandardBaseFragment;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.larus.nova.R;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 42\u00020\u0001:\u00014B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\bJ\u0012\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0014J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001f\u001a\u00020\rH\u0016J\u0012\u0010 \u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010!\u001a\u00020\rH\u0014J\u001c\u0010\"\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\n2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\b\u0010%\u001a\u00020\u0006H\u0016J\b\u0010&\u001a\u00020\rH\u0016J&\u0010'\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010)2\u0014\u0010*\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\u0004\u0012\u00020\r0+J\u001f\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u001b2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u00100J\u000e\u00101\u001a\u00020\r2\u0006\u00102\u001a\u00020\u0006J\b\u00103\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/method/CJStandardMethodFragment;", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/common/StandardBaseFragment;", "()V", "mInitPanelHeight", "", "mIsCombineMethodDialog", "", "mMethodWrapper", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/method/CJStandardMethodWrapper;", "mPanelView", "Landroid/view/View;", "mPendingRefresh", "applyInitialPanelHeight", "", RootDescription.ROOT_ELEMENT, "Landroid/view/ViewGroup;", "targetHeight", "applyStdThemePatchIfNeeded", "attachMethodWrapper", "wrapper", "bindViews", "contentView", "getAnimCallback", "Lcom/android/ttcjpaysdk/base/framework/AnimUtil$IAnimationCallback;", "getAnimViewHeight", "getContentViewLayoutId", "getFragmentName", "", "getPanelHeight", "getPanelView", "getShowAmount", "hideLoading", "initActions", "initData", "initViews", "savedInstanceState", "Landroid/os/Bundle;", "isUseNewAnim", "onDestroyView", "refreshPayTypeIgnoreCache", "topAssetList", "Lorg/json/JSONArray;", "onResult", "Lkotlin/Function1;", "Lcom/android/ttcjpaysdk/thirdparty/data/FrontPreTradeInfo;", "relayoutCurrentMethodPanelAfterHostLayoutChanged", "reason", "orientation", "(Ljava/lang/String;Ljava/lang/Integer;)V", "setIsCombineMethodDialog", "isCombineMethodDialog", DyPayConstant.KEY_SHOW_LOADING, "Companion", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJStandardMethodFragment extends StandardBaseFragment {
    public static final Companion Companion = null;
    private static final String KEY_PANEL_HEIGHT = "panel_height";
    private static final String TAG = "CJStandardMethodFragment";
    private int mInitPanelHeight;
    private boolean mIsCombineMethodDialog;
    private CJStandardMethodWrapper mMethodWrapper;
    private View mPanelView;
    private boolean mPendingRefresh;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/method/CJStandardMethodFragment$Companion;", "", "()V", "KEY_PANEL_HEIGHT", "", "TAG", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
        return R.layout.cj_pay_activity_view_standard_payment_method_page_ui;
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public String getFragmentName() {
        return "std_method";
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.standard.common.StandardBaseFragment
    public String getShowAmount() {
        return null;
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public void initActions(View r100) {
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public void initData() {
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public void initViews(View r100, Bundle r101) {
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public AnimUtil.IAnimationCallback getAnimCallback() {
        return new AnonymousClass1(this);
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public int getPanelHeight() {
        View r100 = this.mPanelView;
        if (r100 == null) goto L13;
        Integer r101 = Integer.valueOf(CJPayBasicExtensionKt.px(r100.getMeasuredHeight()));
        if (r101.intValue() <= 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L13;
        return r101.intValue();
    L7:
        r102 = false;
    L13:
        Bundle r103 = getArguments();
        if (r103 != null) goto L16;
        return 0;
    L16:
        return r103.getInt("panel_height");
    }

    @Override // com.android.ttcjpaysdk.thirdparty.verify.base.VerifyBaseFragment
    public void hideLoading() {
        CJStandardMethodWrapper r100 = this.mMethodWrapper;
        if (r100 == null) goto L6;
        r100.showPageLoading(false);
        return;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.verify.base.VerifyBaseFragment
    public void showLoading() {
        CJStandardMethodWrapper r100 = this.mMethodWrapper;
        if (r100 == null) goto L6;
        r100.showPageLoading(true);
        return;
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment, com.android.ttcjpaysdk.base.framework.AnimUtil.IAnimView
    public int getAnimViewHeight() {
        return getPanelHeight();
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment, com.android.ttcjpaysdk.base.framework.AnimUtil.IOldAnimView
    public boolean isUseNewAnim() {
        boolean r100 = CJPayLargeScreenUtils.isCashierLargeScreenAdaptEnabled();
        CJLogger.d(TAG, "use new anim for standard method page, enabled=" + r100);
        return r100;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mPendingRefresh = false;
        CJStandardMethodWrapper r100 = this.mMethodWrapper;
        if (r100 == null) goto L5;
        r100.cleanup();
    L5:
        this.mPanelView = null;
    }

    public CJStandardMethodFragment() {
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public View getPanelView() {
        return this.mPanelView;
    }

    public static final /* synthetic */ CJStandardMethodWrapper access$getMMethodWrapper$p(CJStandardMethodFragment r100) {
        return r100.mMethodWrapper;
    }

    private final void applyStdThemePatchIfNeeded(ViewGroup r100) {
        if (isStdThemePatchEnabled() == true) goto L5;
        return;
    L5:
        TextView r101 = (TextView) r100.findViewById(R.id.cj_pay_payment_method_desc);
        if (r101 != null) goto L8;
        return;
    L8:
        int r102 = CJPayThemeUtils.getColor(getActivity(), R.attr.cj_pay_bg_inverse_5);
        if (r102 == (-1)) goto L11;
        r101.setBackgroundColor(r102);
    L11:
        int r103 = CJPayThemeUtils.getColor(getActivity(), R.attr.cj_pay_text_secondary);
        if (r103 == (-1)) goto L15;
        r101.setTextColor(r103);
        return;
    }

    public final void attachMethodWrapper(CJStandardMethodWrapper r100) {
        Intrinsics.checkNotNullParameter(r100, "wrapper");
        this.mMethodWrapper = r100;
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public void bindViews(View r100) {
        if ((r100 instanceof ViewGroup) == false) goto L5;
        ViewGroup r101 = (ViewGroup) r100;
    L6:
        FragmentActivity r102 = getActivity();
        CJStandardMethodWrapper r103 = this.mMethodWrapper;
        if (r101 == null) goto L23;
        if (r102 == null) goto L23;
        if (r103 == null) goto L23;
        this.mPanelView = r101;
        Bundle r104 = getArguments();
        if (r104 == null) goto L14;
        int r105 = r104.getInt("panel_height");
    L15:
        this.mInitPanelHeight = r105;
        if (r105 <= 0) goto L18;
        applyInitialPanelHeight(r101, CJPayBasicExtensionKt.dp(r105));
    L18:
        applyStdThemePatchIfNeeded(r101);
        r103.bind(r101);
        if (this.mPendingRefresh == false) goto L21;
        r103.update(this.mIsCombineMethodDialog);
    L21:
        this.mPendingRefresh = false;
        return;
    L14:
        r105 = 0;
    L23:
        CJLogger.b(TAG, "bindViews failed: activity or contentView or methodWrapper is invalid");
        CJReporter r106 = CJReporter.f202294a;
        CJReporter.m(CJPayCallBackCenter.getInstance().getCjContext(), "unify_pay_home_page_create_fail", 2, new Error());
        if (r102 == null) goto L27;
        r102.finish();
        return;
    L27:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void setIsCombineMethodDialog(boolean r100) {
        this.mIsCombineMethodDialog = r100;
        this.mPendingRefresh = true;
        CJStandardMethodWrapper r101 = this.mMethodWrapper;
        if (r101 == null) goto L6;
        r101.update(r100);
        return;
    }

    private final void applyInitialPanelHeight(ViewGroup r100, int r101) {
        if (r101 > 0) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 != null) goto L7;
        r102 = new ViewGroup.LayoutParams(-1, r101);
    L7:
        r102.height = r101;
        r100.setLayoutParams(r102);
        r100.requestLayout();
    }

    public final void refreshPayTypeIgnoreCache(JSONArray r100, Function1<? super FrontPreTradeInfo, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "onResult");
        CJStandardMethodWrapper r102 = this.mMethodWrapper;
        if (r102 == null) goto L6;
        r102.refreshPayTypeIgnoreCache(r100, r101);
        return;
    }

    public final void relayoutCurrentMethodPanelAfterHostLayoutChanged(String r100, Integer r110) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        if (CJPayLargeScreenUtils.isCashierLargeScreenAdaptEnabled() == true) goto L6;
        CJLogger.d(TAG, "skip method panel relayout: experiment disabled, reason=" + r100);
        return;
    L6:
        CJPayAnimRootView r101 = getNewAnimView();
        ViewGroup.LayoutParams r102 = null;
        if (r101 == null) goto L9;
        LinearLayout r103 = r101.getContainerView();
    L10:
        boolean r104 = true;
        int r105 = 0;
        if (r101 == null) goto L20;
        Integer r106 = Integer.valueOf(r101.getHeight());
        if (r106.intValue() <= 0) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == true) goto L19;
        r106 = null;
    L19:
        if (r106 == null) goto L20;
    L35:
        if (r103 == null) goto L39;
        ViewGroup.LayoutParams r108 = r103.getLayoutParams();
        if (r108 == null) goto L39;
        int r109 = r108.height;
    L40:
        View r111 = this.mPanelView;
        if (r111 == null) goto L46;
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
        if (r112 == null) goto L46;
        r105 = r112.height;
    L46:
        if (r106 == null) goto L51;
        if (r103 == null) goto L49;
        r102 = r103.getLayoutParams();
    L49:
        if (r102 == null) goto L51;
        r103.setTranslationX(0.0f);
        r103.setTranslationY(0.0f);
        r103.getLayoutParams().height = r106.intValue();
        r103.requestLayout();
    L52:
        View r113 = this.mPanelView;
        if (r113 == null) goto L56;
        r113.setTranslationY(0.0f);
    L56:
        View r114 = this.mPanelView;
        if (r114 == null) goto L59;
        r114.requestLayout();
    L59:
        View r115 = getView();
        if (r115 == null) goto L62;
        r115.requestLayout();
    L62:
        CJStandardMethodWrapper r116 = this.mMethodWrapper;
        if (r116 == null) goto L65;
        r116.relayoutItemsAfterConfigurationChanged();
    L65:
        CJLogger.d(TAG, "relayout method panel after host layout changed, reason=" + r100 + ", orientation=" + r110 + ", targetHeight=" + r106 + ", oldContainerHeight=" + r109 + ", panelHeight=" + r105);
        return;
    L51:
        CJLogger.e(TAG, "skip method panel relayout: invalid anim height, reason=" + r100);
    L39:
        r109 = 0;
        goto L40
    L15:
        r107 = false;
    L20:
        if (r101 == null) goto L22;
        Object r117 = r101.getParent();
    L24:
        if ((r117 instanceof View) == false) goto L26;
        View r118 = (View) r117;
    L27:
        if (r118 == null) goto L34;
        r106 = Integer.valueOf(r118.getHeight());
        if (r106.intValue() > 0) goto L32;
        r104 = false;
    L32:
        if (r104 == true) goto L35;
    L34:
        r106 = null;
        goto L35
    L26:
        r118 = null;
        goto L27
    L22:
        r117 = null;
        goto L24
    L9:
        r103 = null;
        goto L10
    }

    public static /* synthetic */ void relayoutCurrentMethodPanelAfterHostLayoutChanged$default(CJStandardMethodFragment r100, String r101, Integer r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.relayoutCurrentMethodPanelAfterHostLayoutChanged(r101, r102);
    }
}
