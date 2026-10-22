package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.homepage.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.CJPayKotlinExtensionsKt;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.theme.widget.CJPayStandardCircleCheckbox;
import com.android.ttcjpaysdk.base.ui.Utils.CJPayGradientUtil;
import com.android.ttcjpaysdk.base.ui.data.CJOptionShowInfo;
import com.android.ttcjpaysdk.base.ui.data.CJPayUIComponent;
import com.android.ttcjpaysdk.base.utils.CJPayExtentSizeUtils;
import com.android.ttcjpaysdk.base.utils.CJPayFakeBoldUtils;
import com.android.ttcjpaysdk.base.utils.CJPayLargeScreenUtils;
import com.android.ttcjpaysdk.thirdparty.data.CJPayPayAndXShowParams;
import com.android.ttcjpaysdk.thirdparty.data.unifypay.UnifyCashierRenderInfo;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.homepage.OptionShowInfoStorage;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.method.data.CJUnifyPayMethodTuple;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.operation.utils.CJUnifyPayXRecActionCallback;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.operation.utils.CJUnifyPayXRecRenderHelper;
import com.android.ttcjpaysdk.thirdparty.utils.CJPayUIUtils;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 R2\u00020\u0001:\u0002RSB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0019H\u0002J\b\u0010/\u001a\u00020-H\u0002J\b\u00100\u001a\u00020-H\u0002J\u0019\u00101\u001a\u00020-2\n\b\u0002\u00102\u001a\u0004\u0018\u000103H\u0002¢\u0006\u0002\u00104J\b\u00105\u001a\u00020-H\u0002J\r\u00106\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u00107J\u0006\u00108\u001a\u00020\u000eJ\u0010\u00109\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010:H\u0002J\u0006\u0010<\u001a\u00020\nJ\b\u0010=\u001a\u00020-H\u0002J\u0010\u0010>\u001a\u00020-2\b\u0010?\u001a\u0004\u0018\u00010@J\u0006\u0010A\u001a\u00020\u000eJ\u0018\u0010B\u001a\u00020-2\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u0007H\u0014J(\u0010E\u001a\u00020-2\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u0007H\u0014J\b\u0010J\u001a\u000203H\u0002J\u0010\u0010K\u001a\u00020-2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u000e\u0010L\u001a\u00020-2\u0006\u0010\u0017\u001a\u00020\u0007J\u0016\u0010M\u001a\u00020-2\u0006\u0010N\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u0007J\u0010\u0010P\u001a\u00020-2\b\u0010?\u001a\u0004\u0018\u00010@J\b\u0010Q\u001a\u00020-H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\r\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n \u001c*\u0004\u0018\u00010\u001e0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u00060'R\u00020\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006T"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/view/CJUnifyPayXRecTopView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "FALLBACK_SETTINGS_KEY", "", "callback", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/operation/utils/CJUnifyPayXRecActionCallback;", "isPayAndXFallbackEnabled", "", "()Z", "isPayAndXFallbackEnabled$delegate", "Lkotlin/Lazy;", "ivTitleIcon", "Landroid/widget/ImageView;", "ivTitleIconOverlay", "llServiceRootView", "Landroid/widget/LinearLayout;", "maxHeight", "renderData", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayPayAndXShowParams;", "rootView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "scrollView", "Landroidx/core/widget/NestedScrollView;", "tvTitle", "Landroid/widget/TextView;", "tvVoucherTag1", "tvVoucherTag2", "vBottomMask", "vCheckBox", "Lcom/android/ttcjpaysdk/base/theme/widget/CJPayStandardCircleCheckbox;", "viewConfig", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/view/CJUnifyPayXRecTopView$ViewConfig;", "getViewConfig", "()Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/view/CJUnifyPayXRecTopView$ViewConfig;", "setViewConfig", "(Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/view/CJUnifyPayXRecTopView$ViewConfig;)V", "bindServiceDetail", "", "data", "bindTitle", "bindTitleIcon", "bindVoucherTag", "titleWidth", "", "(Ljava/lang/Float;)V", "changeSubTitleVisible", "getContentHeight", "()Ljava/lang/Integer;", "getDefaultSelected", "getRecommendVoucherInfo", "", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayUIComponent;", "getTitleText", "initCheckBox", "initData", "cashierRenderInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo;", "isRecSelected", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "resolveContentWidthPx", "setCallback", "setMaxHeight", "updateBottomMask", "fromColor", "toColor", "updateData", "updateTitleLines", "Companion", "ViewConfig", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyPayXRecTopView extends FrameLayout {
    public static final Companion Companion = null;
    private static final String TAG = "CJUnifyPayXRecTopView";
    private static final int topRecHeightFold = 0;
    private static final int topRecMaxHeightExpand = 0;
    private static final int topRecMinHeightExpand = 0;
    private final String FALLBACK_SETTINGS_KEY;
    private CJUnifyPayXRecActionCallback callback;
    private final Lazy isPayAndXFallbackEnabled$delegate;
    private final ImageView ivTitleIcon;
    private final ImageView ivTitleIconOverlay;
    private final LinearLayout llServiceRootView;
    private int maxHeight;
    private CJPayPayAndXShowParams renderData;
    private final View rootView;
    private final NestedScrollView scrollView;
    private final TextView tvTitle;
    private final TextView tvVoucherTag1;
    private final TextView tvVoucherTag2;
    private final View vBottomMask;
    private CJPayStandardCircleCheckbox vCheckBox;
    private ViewConfig viewConfig;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/view/CJUnifyPayXRecTopView$Companion;", "", "()V", "TAG", "", "topRecHeightFold", "", "getTopRecHeightFold", "()I", "topRecMaxHeightExpand", "getTopRecMaxHeightExpand", "topRecMinHeightExpand", "getTopRecMinHeightExpand", "match", "", "cashierRenderInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo;", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final int getTopRecHeightFold() {
            return CJUnifyPayXRecTopView.access$getTopRecHeightFold$cp();
        }

        public final int getTopRecMaxHeightExpand() {
            return CJUnifyPayXRecTopView.access$getTopRecMaxHeightExpand$cp();
        }

        public final int getTopRecMinHeightExpand() {
            return CJUnifyPayXRecTopView.access$getTopRecMinHeightExpand$cp();
        }

        public final boolean match(UnifyCashierRenderInfo r100) {
            return CJUnifyPayXRecRenderHelper.INSTANCE.matches(r100, "top");
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bJ\u0016\u0010\u0011\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\bR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\n\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/view/CJUnifyPayXRecTopView$ViewConfig;", "", "(Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/view/CJUnifyPayXRecTopView;)V", "curPaymentMethodInfo", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyPayMethodTuple;", "getCurPaymentMethodInfo", "()Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyPayMethodTuple;", "optionShowInfoCallback", "Lkotlin/Function0;", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/OptionShowInfoStorage;", "optionShowInfoStorage", "getOptionShowInfoStorage", "()Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/OptionShowInfoStorage;", "paymentMethodCallback", "setOptionShowInfoCallback", "", "callback", "setPaymentMethodCallback", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ViewConfig {
        private Function0<OptionShowInfoStorage> optionShowInfoCallback;
        private Function0<CJUnifyPayMethodTuple> paymentMethodCallback;
        final /* synthetic */ CJUnifyPayXRecTopView this$0;

        public final CJUnifyPayMethodTuple getCurPaymentMethodInfo() {
            return this.paymentMethodCallback.invoke();
        }

        public final OptionShowInfoStorage getOptionShowInfoStorage() {
            return this.optionShowInfoCallback.invoke();
        }

        public ViewConfig(CJUnifyPayXRecTopView r100) {
            this.this$0 = r100;
            this.optionShowInfoCallback = CJUnifyPayXRecTopView$ViewConfig$optionShowInfoCallback$1.INSTANCE;
            this.paymentMethodCallback = CJUnifyPayXRecTopView$ViewConfig$paymentMethodCallback$1.INSTANCE;
        }

        public final void setOptionShowInfoCallback(Function0<OptionShowInfoStorage> r100) {
            Intrinsics.checkNotNullParameter(r100, "callback");
            this.optionShowInfoCallback = r100;
        }

        public final void setPaymentMethodCallback(Function0<CJUnifyPayMethodTuple> r100) {
            Intrinsics.checkNotNullParameter(r100, "callback");
            this.paymentMethodCallback = r100;
        }
    }

    public CJUnifyPayXRecTopView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public CJUnifyPayXRecTopView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    static {
        Companion = new Companion(null);
        topRecMinHeightExpand = CJPayBasicExtensionKt.dp(60);
        topRecMaxHeightExpand = CJPayBasicExtensionKt.dp(200);
        topRecHeightFold = CJPayBasicExtensionKt.dp(80);
    }

    private final void bindTitle() {
        TextView r100 = this.tvTitle;
        r100.setEllipsize(TextUtils.TruncateAt.END);
        CJPayPayAndXShowParams.UIControlConfig r101 = this.renderData.ui_control_config;
        List<CJPayUIComponent> r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.recommend_voucher_display_style;
    L6:
        boolean r104 = Intrinsics.areEqual(r103, CJPayPayAndXShowParams.UIControlConfig.VOUCHER_POSITION_TITLE_APPEND);
        CJUnifyPayXRecRenderHelper r105 = CJUnifyPayXRecRenderHelper.INSTANCE;
        CJPayPayAndXShowParams r106 = this.renderData;
        if (r104 == false) goto L9;
        r102 = getRecommendVoucherInfo();
    L9:
        CJPayUIUtils.INSTANCE.textImageSpan(r100, r105.buildTitleComponents(r106, r102, r104), CJPayBasicExtensionKt.dp(15), CJPayBasicExtensionKt.dp(15), CJPayBasicExtensionKt.dp(4));
        CJPayFakeBoldUtils.fakeBold(r100);
        return;
    L5:
        r103 = null;
        goto L6
    }

    private final void bindTitleIcon() {
        ViewGroup.LayoutParams r100 = this.ivTitleIcon.getLayoutParams();
        if (r100 == null) goto L5;
        r100.width = CJPayBasicExtensionKt.dp(18);
        r100.height = CJPayBasicExtensionKt.dp(18);
        this.ivTitleIcon.setLayoutParams(r100);
    L5:
        this.ivTitleIcon.setClipToOutline(true);
        this.ivTitleIcon.setOutlineProvider(new AnonymousClass2());
        CJUnifyPayXRecRenderHelper.INSTANCE.bindTitleIcon(this.ivTitleIcon, this.ivTitleIconOverlay, this.renderData);
    }

    private final void changeSubTitleVisible() {
        boolean r100 = true;
        if (this.renderData.show_check_box == true) goto L9;
        LinearLayout r101 = this.llServiceRootView;
        if (r101.getChildCount() > 0) goto L8;
        r100 = false;
    L8:
        CJPayViewExtensionsKt.toggleVisible(r101, r100);
        return;
    L9:
        LinearLayout r102 = this.llServiceRootView;
        if (this.vCheckBox.isChecked() == true) goto L12;
    L14:
        r100 = false;
    L15:
        CJPayViewExtensionsKt.toggleVisible(r102, r100);
        return;
    L12:
        if (this.llServiceRootView.getChildCount() <= 0) goto L14;
        goto L14
    }

    private final List<CJPayUIComponent> getRecommendVoucherInfo() {
        OptionShowInfoStorage r100 = this.viewConfig.getOptionShowInfoStorage();
        List<CJOptionShowInfo> r101 = null;
        if (r100 == null) goto L9;
        CJUnifyPayMethodTuple r102 = this.viewConfig.getCurPaymentMethodInfo();
        if (r102 == null) goto L8;
        r101 = r102.getOptionShowInfoList();
    L8:
        return r100.getRecommendVoucherInfoList(r101);
    L9:
        return null;
    }

    private final void initCheckBox() {
        if (this.renderData.show_check_box == true) goto L6;
        CJPayViewExtensionsKt.viewGone(this.vCheckBox);
        return;
    L6:
        CJPayViewExtensionsKt.viewVisible(this.vCheckBox);
        CJUnifyPayXRecRenderHelper r100 = CJUnifyPayXRecRenderHelper.INSTANCE;
        r100.configureCheckBox(this.vCheckBox);
        this.vCheckBox.setChecked(this.renderData.choose);
        changeSubTitleVisible();
        CJPayExtentSizeUtils.expendTouchArea(this.vCheckBox, new int[]{CJPayBasicExtensionKt.dp(13.0f), CJPayBasicExtensionKt.dp(10.0f), CJPayBasicExtensionKt.dp(13.0f), CJPayBasicExtensionKt.dp(10.0f)});
        r100.setCheckBoxClickListener(this.vCheckBox, new AnonymousClass1(this));
    }

    private final boolean isPayAndXFallbackEnabled() {
        return ((Boolean) this.isPayAndXFallbackEnabled$delegate.getValue()).booleanValue();
    }

    private final void updateTitleLines() {
        TextView r100 = this.tvTitle;
        r100.setEllipsize(TextUtils.TruncateAt.END);
        r100.setSingleLine(false);
        r100.setMaxLines(2);
        r100.setLineSpacing(10.0f, 1.0f);
        CJPayViewExtensionsKt.setTopMargin(this.ivTitleIcon, CJPayBasicExtensionKt.dp(1));
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        ConstraintLayout.LayoutParams r102 = null;
        if ((r101 instanceof ConstraintLayout.LayoutParams) == false) goto L5;
        ConstraintLayout.LayoutParams r103 = (ConstraintLayout.LayoutParams) r101;
    L7:
        if (r103 == null) goto L9;
        r103.topToTop = 0;
        r103.bottomToBottom = -1;
        CJPayViewExtensionsKt.setMargins(r100, CJPayBasicExtensionKt.dp(6), 0, 0, 0);
        r100.setLayoutParams(r103);
    L9:
        ViewGroup.LayoutParams r104 = this.vCheckBox.getLayoutParams();
        if ((r104 instanceof ConstraintLayout.LayoutParams) == false) goto L12;
        r102 = (ConstraintLayout.LayoutParams) r104;
    L12:
        if (r102 == null) goto L15;
        r102.topToTop = this.tvTitle.getId();
        r102.bottomToBottom = -1;
        ((ViewGroup.MarginLayoutParams) r102).topMargin = CJPayBasicExtensionKt.dp(2);
        this.vCheckBox.setLayoutParams(r102);
        return;
    L15:
        return;
    L5:
        r103 = null;
        goto L7
    }

    public final Integer getContentHeight() {
        boolean r100 = false;
        View r101 = this.scrollView.getChildAt(0);
        if (r101 != null) goto L5;
        return null;
    L5:
        Integer r102 = Integer.valueOf(r101.getHeight());
        if (r102.intValue() <= 0) goto L8;
        r100 = true;
    L8:
        if (r100 == true) goto L10;
        return null;
    L10:
        return r102;
    }

    public final boolean getDefaultSelected() {
        return this.renderData.choose;
    }

    public final String getTitleText() {
        return this.tvTitle.getText().toString();
    }

    public final boolean isRecSelected() {
        if (CJPayKotlinExtensionsKt.isVisible(this.vCheckBox) != true) goto L6;
        return this.vCheckBox.isChecked();
    L6:
        return getDefaultSelected();
    }

    private final float resolveContentWidthPx() {
        return CJPayLargeScreenUtils.resolveCashierContentWidthPx(getContext(), this);
    }

    public static final /* synthetic */ int access$getTopRecHeightFold$cp() {
        return topRecHeightFold;
    }

    public static final /* synthetic */ int access$getTopRecMaxHeightExpand$cp() {
        return topRecMaxHeightExpand;
    }

    public static final /* synthetic */ int access$getTopRecMinHeightExpand$cp() {
        return topRecMinHeightExpand;
    }

    public final ViewConfig getViewConfig() {
        return this.viewConfig;
    }

    public static final /* synthetic */ void access$changeSubTitleVisible(CJUnifyPayXRecTopView r100) {
        r100.changeSubTitleVisible();
    }

    public static final /* synthetic */ CJUnifyPayXRecActionCallback access$getCallback$p(CJUnifyPayXRecTopView r100) {
        return r100.callback;
    }

    public static final /* synthetic */ String access$getFALLBACK_SETTINGS_KEY$p(CJUnifyPayXRecTopView r100) {
        return r100.FALLBACK_SETTINGS_KEY;
    }

    public static final /* synthetic */ NestedScrollView access$getScrollView$p(CJUnifyPayXRecTopView r100) {
        return r100.scrollView;
    }

    public static final /* synthetic */ View access$getVBottomMask$p(CJUnifyPayXRecTopView r100) {
        return r100.vBottomMask;
    }

    private final void bindServiceDetail(CJPayPayAndXShowParams r210) {
        this.llServiceRootView.removeAllViews();
        ArrayList<CJPayPayAndXShowParams.ShowInfo> r100 = r210.show_info_detail_list;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L13;
        this.llServiceRootView.setVisibility(8);
        return;
    L13:
        this.llServiceRootView.setVisibility(0);
        ArrayList<CJPayPayAndXShowParams.ShowInfo> r102 = r210.show_info_detail_list;
        ViewGroup r103 = null;
        if (r102 == null) goto L31;
        Iterator<T> r104 = r102.iterator();
        if (r104.hasNext() == true) goto L18;
        Object r105 = null;
    L27:
        CJPayPayAndXShowParams.ShowInfo r106 = (CJPayPayAndXShowParams.ShowInfo) r105;
        if (r106 == null) goto L31;
        String r107 = r106.name;
        if (r107 == null) goto L31;
    L32:
        LayoutInflater r108 = LayoutInflater.from(getContext());
        int r109 = R.layout.cj_pay_view_unify_pay_rec_service_detail_item_layout;
        View r110 = r108.inflate(R.layout.cj_pay_view_unify_pay_rec_service_detail_item_layout, null, false);
        int r111 = R.id.tv_service_left;
        TextView r112 = (TextView) r110.findViewById(R.id.tv_service_left);
        if (r107.length() <= 4) goto L35;
        r107 = r107.substring(0, 4);
    L35:
        float r113 = r112.getPaint().measureText(r107);
        ArrayList<CJPayPayAndXShowParams.ShowInfo> r114 = r210.show_info_detail_list;
        if (r114 == null) goto L64;
        Iterator<T> r115 = r114.iterator();
        int r116 = 0;
    L39:
        if (r115.hasNext() == false) goto L64;
        Object r117 = r115.next();
        int r118 = r116 + 1;
        if (r116 >= 0) goto L43;
        CollectionsKt.throwIndexOverflow();
    L43:
        CJPayPayAndXShowParams.ShowInfo r119 = (CJPayPayAndXShowParams.ShowInfo) r117;
        View r120 = LayoutInflater.from(getContext()).inflate(r109, r103, false);
        TextView r121 = (TextView) r120.findViewById(r111);
        TextView r122 = (TextView) r120.findViewById(R.id.tv_service_right);
        if (r116 <= 0) goto L46;
        FrameLayout.LayoutParams r123 = new FrameLayout.LayoutParams(-1, -2);
        r123.topMargin = CJPayBasicExtensionKt.dp(8.0f);
        this.llServiceRootView.addView(r120, r123);
    L48:
        if (r119.name.length() <= 4) goto L50;
        String r124 = r119.name.substring(0, 4);
    L51:
        r121.setText(r124);
        ArrayList<CJPayPayAndXShowParams.ShowInfo> r125 = r210.show_info_detail_list;
        if (r125 != null) goto L54;
    L56:
        boolean r126 = false;
    L57:
        if (r126 == false) goto L59;
        r121.setVisibility(8);
    L60:
        r122.setText(r119.desc);
        SpannableStringBuilder r127 = CJUnifyPayXRecRenderHelper.INSTANCE.buildProtocolText(getContext(), r119.desc, r119, String.valueOf(r210.exts), new CJUnifyPayXRecTopView$bindServiceDetail$1$1(this));
        if (r127 == null) goto L63;
        r122.setMovementMethod(LinkMovementMethod.getInstance());
        r122.setHighlightColor(getContext().getResources().getColor(R.color.cj_pay_color_trans));
        r122.setText(r127);
    L63:
        r116 = r118;
        r103 = null;
        r109 = R.layout.cj_pay_view_unify_pay_rec_service_detail_item_layout;
        r111 = R.id.tv_service_left;
        goto L39
    L59:
        CJPayViewExtensionsKt.setMargins(r122, (int) (CJPayBasicExtensionKt.dp(16.0f) + r113), 0, 0, 0);
        goto L60
    L54:
        if (r125.size() != 1) goto L56;
        r126 = true;
        goto L57
    L50:
        r124 = r119.name;
        goto L51
    L46:
        this.llServiceRootView.addView(r120);
    L64:
        changeSubTitleVisible();
        return;
    L18:
        r105 = r104.next();
        if (r104.hasNext() == false) goto L27;
        int r128 = ((CJPayPayAndXShowParams.ShowInfo) r105).name.length();
    L22:
        Object r129 = r104.next();
        int r130 = ((CJPayPayAndXShowParams.ShowInfo) r129).name.length();
        if (r128 >= r130) goto L26;
        r105 = r129;
        r128 = r130;
    L26:
        if (r104.hasNext() == true) goto L22;
    L31:
        r107 = "";
        goto L32
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L10
    }

    private final void bindVoucherTag(Float r110) {
        List<CJPayUIComponent> r100 = getRecommendVoucherInfo();
        if (r100 == null) goto L12;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((CJPayUIComponent) r103).type, "text") == false) goto L6;
        r101.add(r103);
        goto L6
    L10:
        String r104 = CollectionsKt.joinToString$default(r101, "", null, null, 0, null, CJUnifyPayXRecTopView$bindVoucherTag$voucherLabel$2.INSTANCE, 30, null);
        if (r104 == null) goto L12;
    L13:
        this.tvVoucherTag1.setText(r104);
        CJPayPayAndXShowParams.UIControlConfig r105 = this.renderData.ui_control_config;
        String r106 = null;
        if (r105 == null) goto L16;
        String r107 = r105.recommend_voucher_display_style;
    L17:
        boolean r108 = true;
        if (Intrinsics.areEqual(r107, "tag") == true) goto L25;
        CJPayPayAndXShowParams.UIControlConfig r109 = this.renderData.ui_control_config;
        if (r109 == null) goto L22;
        r106 = r109.recommend_voucher_display_style;
    L22:
        if (r106 == null) goto L25;
        boolean r111 = false;
    L27:
        if (r104.length() == 0) goto L31;
        r108 = false;
    L31:
        if (r108 == true) goto L49;
        if (r111 == false) goto L49;
        float r112 = resolveContentWidthPx();
        float r113 = 0.0f;
        if (r110 == null) goto L37;
        float r114 = r110.floatValue();
    L38:
        float r115 = (((((r112 - r114) - (CJPayBasicExtensionKt.dp(12.0f) * 2)) - (CJPayBasicExtensionKt.dp(16.0f) * 2)) - CJPayBasicExtensionKt.dp(18.0f)) - CJPayBasicExtensionKt.dp(12.0f)) - CJPayBasicExtensionKt.dp(4.0f);
        if (CJPayKotlinExtensionsKt.isVisible(this.vCheckBox) == false) goto L41;
        r115 = r115 - (CJPayBasicExtensionKt.dp(16.0f) * 2);
    L41:
        TextPaint r116 = this.tvVoucherTag1.getPaint();
        if (r116 == null) goto L45;
        r113 = r116.measureText(r104);
    L45:
        if (r113 <= r115) goto L47;
        this.tvVoucherTag1.setVisibility(8);
        this.tvVoucherTag2.setVisibility(0);
        this.tvVoucherTag2.setText(r104);
        return;
    L47:
        this.tvVoucherTag1.setVisibility(0);
        this.tvVoucherTag2.setVisibility(8);
        this.tvVoucherTag1.setText(r104);
        return;
    L37:
        r114 = 0.0f;
    L49:
        this.tvVoucherTag1.setVisibility(8);
        this.tvVoucherTag2.setVisibility(8);
        return;
    L25:
        r111 = true;
        goto L27
    L16:
        r107 = null;
    L12:
        r104 = this.renderData.voucher_label;
        goto L13
    }

    public final void initData(UnifyCashierRenderInfo r100) {
        updateData(r100);
        initCheckBox();
    }

    public final void setCallback(CJUnifyPayXRecActionCallback r100) {
        this.callback = r100;
    }

    public final void setMaxHeight(int r100) {
        if (r100 <= 0) goto L5;
        this.maxHeight = r100;
        requestLayout();
        return;
    }

    public final void setViewConfig(ViewConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.viewConfig = r100;
    }

    public final void updateData(UnifyCashierRenderInfo r100) {
        Float r101 = null;
        if (r100 == null) goto L5;
        CJPayPayAndXShowParams r102 = r100.pay_and_x_show_info;
    L6:
        if (r102 != null) goto L8;
    L15:
        setVisibility(8);
        CJLogger.d(TAG, "view gone for reason");
        return;
    L8:
        if (Companion.match(r100) == false) goto L15;
        setVisibility(0);
        this.renderData = r102;
        bindTitleIcon();
        bindTitle();
        TextPaint r103 = this.tvTitle.getPaint();
        if (r103 == null) goto L13;
        r101 = Float.valueOf(r103.measureText(this.tvTitle.getText().toString()));
    L13:
        bindVoucherTag(r101);
        updateTitleLines();
        bindServiceDetail(r102);
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        if (this.maxHeight > 0) goto L6;
        super.onMeasure(r100, r101);
        return;
    L6:
        boolean r102 = true;
        if (isPayAndXFallbackEnabled() == false) goto L30;
        int r103 = View.MeasureSpec.getMode(r101);
        int r104 = View.MeasureSpec.getSize(r101);
        if (r103 == Integer.MIN_VALUE) goto L21;
        if (r103 == 0) goto L20;
        if (r103 != 1073741824) goto L28;
        int r105 = this.maxHeight;
        if (1 > r105) goto L17;
        if (r105 >= r104) goto L17;
    L18:
        if (r102 == false) goto L28;
        r101 = View.MeasureSpec.makeMeasureSpec(r105, 1073741824);
    L17:
        r102 = false;
    L28:
        super.onMeasure(r100, r101);
        return;
    L20:
        r101 = View.MeasureSpec.makeMeasureSpec(this.maxHeight, Integer.MIN_VALUE);
        goto L28
    L21:
        int r106 = this.maxHeight;
        if (1 > r106) goto L25;
        if (r106 >= r104) goto L25;
    L26:
        if (r102 == false) goto L28;
        r101 = View.MeasureSpec.makeMeasureSpec(r106, Integer.MIN_VALUE);
    L25:
        r102 = false;
        goto L26
    L30:
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(0, 0));
        int r107 = Math.min(getMeasuredHeight(), this.maxHeight);
        int r108 = View.MeasureSpec.getMode(r101);
        int r109 = View.MeasureSpec.getSize(r101);
        if (r108 == Integer.MIN_VALUE) goto L42;
        if (r108 == 0) goto L41;
        if (r108 != 1073741824) goto L48;
        if (1 > r107) goto L38;
        if (r107 >= r109) goto L38;
    L39:
        if (r102 == false) goto L48;
        r101 = View.MeasureSpec.makeMeasureSpec(r107, 1073741824);
    L38:
        r102 = false;
    L48:
        super.onMeasure(r100, r101);
        return;
    L41:
        r101 = View.MeasureSpec.makeMeasureSpec(r107, Integer.MIN_VALUE);
        goto L48
    L42:
        if (1 > r107) goto L45;
        if (r107 >= r109) goto L45;
    L46:
        if (r102 == false) goto L48;
        r101 = View.MeasureSpec.makeMeasureSpec(r107, Integer.MIN_VALUE);
    L45:
        r102 = false;
        goto L46
    }

    public final void updateBottomMask(int r100, int r110) {
        CJPayGradientUtil r101 = CJPayGradientUtil.INSTANCE;
        GradientDrawable.Orientation r102 = GradientDrawable.Orientation.TOP_BOTTOM;
        float r103 = CJPayBasicExtensionKt.dpF(8);
        GradientDrawable r104 = r101.getGradientDrawable(r100, r110, r102, 0.0f, 0.0f, CJPayBasicExtensionKt.dpF(8), r103);
        this.vBottomMask.setBackground(r104);
    }

    public CJUnifyPayXRecTopView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.viewConfig = new ViewConfig(this);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.cj_pay_view_unify_pay_home_page_pay_x_rec_top_layout, this, true);
        this.rootView = r103;
        this.scrollView = (NestedScrollView) r103.findViewById(R.id.scroll_view);
        this.llServiceRootView = (LinearLayout) r103.findViewById(R.id.ll_service_detail_root_view);
        this.ivTitleIcon = (ImageView) r103.findViewById(R.id.iv_title_icon);
        this.ivTitleIconOverlay = (ImageView) r103.findViewById(R.id.iv_title_icon_overlay);
        this.tvTitle = (TextView) r103.findViewById(R.id.tv_title);
        this.tvVoucherTag1 = (TextView) r103.findViewById(R.id.tv_voucher_tag1);
        this.tvVoucherTag2 = (TextView) r103.findViewById(R.id.tv_voucher_tag2);
        this.vBottomMask = r103.findViewById(R.id.v_bottom_mask);
        this.vCheckBox = (CJPayStandardCircleCheckbox) r103.findViewById(R.id.v_check_box);
        this.maxHeight = -1;
        this.renderData = new CJPayPayAndXShowParams();
        this.FALLBACK_SETTINGS_KEY = "cj_unify_pay_and_x_layout_fallback";
        this.isPayAndXFallbackEnabled$delegate = LazyKt.lazy(new C94472(this));
    }

    public static /* synthetic */ void bindVoucherTag$default(CJUnifyPayXRecTopView r100, Float r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = Float.valueOf(0.0f);
    L5:
        r100.bindVoucherTag(r101);
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, final int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        post(new RunnableC94481(this, r101));
    }

    public /* synthetic */ CJUnifyPayXRecTopView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
