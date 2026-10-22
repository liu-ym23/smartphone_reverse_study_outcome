package com.android.ttcjpaysdk.thirdparty.counter.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayFingerprintService;
import com.android.ttcjpaysdk.base.ui.data.CJPayResultGuideInfo;
import com.android.ttcjpaysdk.base.ui.data.CJPaySubGuideDesc;
import com.android.ttcjpaysdk.base.ui.data.FingerInfo;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayAnimationUtils;
import com.android.ttcjpaysdk.thirdparty.base.CJPayBaseFragment;
import com.android.ttcjpaysdk.thirdparty.counter.activity.CJPayCheckoutCounterActivity;
import com.android.ttcjpaysdk.thirdparty.counter.data.CJPayCounterTradeQueryResponseBean;
import com.android.ttcjpaysdk.thirdparty.counter.utils.CJPayResultPageLogUtils;
import com.android.ttcjpaysdk.thirdparty.counter.wrapper.BaseGuideWrapper;
import com.android.ttcjpaysdk.thirdparty.counter.wrapper.FingerprintAtmosphericsGuideWrapper;
import com.android.ttcjpaysdk.thirdparty.counter.wrapper.FingerprintGuideWrapper;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCheckoutCounterResponseBean;
import com.android.ttcjpaysdk.thirdparty.data.CJPayProcessInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayTradeInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayUserInfo;
import com.android.ttcjpaysdk.thirdparty.verify.utils.UploadEventUtils;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001:\u0001LB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0014J\u0010\u0010\"\u001a\u00020#2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020\u0004H\u0002J\b\u0010*\u001a\u00020\u0004H\u0002J\b\u0010+\u001a\u00020\bH\u0014J\n\u0010,\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010-\u001a\u00020\bH\u0016J\n\u0010.\u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010/\u001a\u0004\u0018\u00010\u00102\u0006\u0010 \u001a\u00020!2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u00100\u001a\u00020\fH\u0014J\u0018\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000203H\u0016J\u0012\u00105\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u00106\u001a\u00020\u001fH\u0014J\u001c\u00107\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u00108\u001a\u0004\u0018\u000109H\u0014J\u0018\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\f2\u0006\u0010<\u001a\u00020\fH\u0002J\u0010\u0010=\u001a\u00020\u001f2\u0006\u0010>\u001a\u00020\fH\u0002J\u0010\u0010?\u001a\u00020\u001f2\u0006\u0010>\u001a\u00020\fH\u0002J\u0012\u0010@\u001a\u00020\u001f2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u001e\u0010A\u001a\u00020\u001f2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0012J\u0010\u0010D\u001a\u00020\u001f2\b\u0010E\u001a\u0004\u0018\u00010\u0004J\u000e\u0010F\u001a\u00020\u001f2\u0006\u0010G\u001a\u00020\bJ\u0010\u0010H\u001a\u00020\u001f2\b\u0010\u0015\u001a\u0004\u0018\u00010\fJ\u001a\u0010I\u001a\u00020\u001f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\b\u0010J\u001a\u00020\u001fH\u0002J\b\u0010K\u001a\u00020\u001fH\u0003R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006M"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/counter/fragment/CJPayFingerprintGuideFragment;", "Lcom/android/ttcjpaysdk/thirdparty/base/CJPayBaseFragment;", "()V", "commonParams", "Lorg/json/JSONObject;", "dataBean", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCheckoutCounterResponseBean;", "fingerCheckTimes", "", "fingerprintService", "Lcom/android/ttcjpaysdk/base/service/ICJPayFingerprintService;", "from", "", "guideParams", "Lcom/android/ttcjpaysdk/thirdparty/counter/fragment/CJPayFingerprintGuideFragment$ResultGuideParams;", "guideWrapper", "Lcom/android/ttcjpaysdk/thirdparty/counter/wrapper/BaseGuideWrapper;", "hostBean", "Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "pageHeight", "Ljava/lang/Integer;", "pwd", "responseBean", "Lcom/android/ttcjpaysdk/thirdparty/counter/data/CJPayCounterTradeQueryResponseBean;", "rootView", "Landroid/widget/FrameLayout;", "getRootView", "()Landroid/widget/FrameLayout;", "setRootView", "(Landroid/widget/FrameLayout;)V", "bindViews", "", "contentView", "Landroid/view/View;", "createAtmosphericsGuideWrapper", "Lcom/android/ttcjpaysdk/thirdparty/counter/wrapper/FingerprintAtmosphericsGuideWrapper;", "createGuideWrapper", "Lcom/android/ttcjpaysdk/thirdparty/counter/wrapper/FingerprintGuideWrapper;", "delayClosePage", "time", "", "getAwardsParams", "getCommonParams", "getContentViewLayoutId", "getFragmentName", "getPanelHeight", "getPanelView", "getResultGuideWrapper", "getSource", "inOrOutWithAnimation", "isWithAnimation", "", "isShow", "initActions", "initData", "initViews", "savedInstanceState", "Landroid/os/Bundle;", "logFingerGuideClick", "buttonName", "type", "logFingerGuideOpenResult", "result", "logWalletCashierFingerprintEnableCheckPopInput", WidgetCostModule.TYPE_ON_CREATE, "setData", "data", "host", "setLogCommonParams", "params", "setPageHeight", "height", "setPwd", "setResultBioGuideParams", "showEnableFingerprintSucceeded", "showFingerprintGuide", "ResultGuideParams", "bdpay-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayFingerprintGuideFragment extends CJPayBaseFragment {
    private JSONObject commonParams;
    private CJPayCheckoutCounterResponseBean dataBean;
    private int fingerCheckTimes;
    private ICJPayFingerprintService fingerprintService;
    private String from;
    private ResultGuideParams guideParams;
    private BaseGuideWrapper guideWrapper;
    private CJPayHostInfo hostBean;
    private Integer pageHeight;
    private String pwd;
    private CJPayCounterTradeQueryResponseBean responseBean;
    private FrameLayout rootView;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\t\u001a\u0004\u0018\u00010\nH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\f\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\r\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u000f\u001a\u00020\u0010H&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0003H&J\u001c\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u0015H&J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0003H&J\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0002\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/counter/fragment/CJPayFingerprintGuideFragment$ResultGuideParams;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "getAfterOpenDesc", "", "getBioType", "getBubbleText", "getCancelBtnDesc", "getCancelBtnLocation", "getConfirmBtnDesc", "getFingerInfo", "Lcom/android/ttcjpaysdk/base/ui/data/FingerInfo;", "getGuideDesc", "getGuideShowStyle", "getHeaderDesc", "getHeaderPic", "getIsButtonFlick", "", "getPicUrl", "getSubGuideDesc", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/CJPaySubGuideDesc;", "Lkotlin/collections/ArrayList;", "getSubTitle", "getSubTitleColor", "getSubTitleIcon", "getTitle", "getVoucherAmount", "isShowGuide", "()Ljava/lang/Boolean;", "bdpay-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ResultGuideParams extends CJPayObject {
        String getAfterOpenDesc();

        String getBioType();

        String getBubbleText();

        String getCancelBtnDesc();

        String getCancelBtnLocation();

        String getConfirmBtnDesc();

        FingerInfo getFingerInfo();

        String getGuideDesc();

        String getGuideShowStyle();

        String getHeaderDesc();

        String getHeaderPic();

        boolean getIsButtonFlick();

        String getPicUrl();

        ArrayList<CJPaySubGuideDesc> getSubGuideDesc();

        String getSubTitle();

        String getSubTitleColor();

        String getSubTitleIcon();

        String getTitle();

        String getVoucherAmount();

        Boolean isShowGuide();
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public int getContentViewLayoutId() {
        return R.layout.cj_pay_fragment_fingerprint_common_guide_layout;
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public String getFragmentName() {
        return "结果页引导开通指纹";
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public String getSource() {
        return "支付收银台";
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public void initViews(View r100, Bundle r101) {
    }

    private final JSONObject getAwardsParams() {
        JSONObject r100 = new JSONObject();
        CJPayCounterTradeQueryResponseBean r101 = this.responseBean;
        String r102 = null;
        if (r101 == null) goto L7;
        CJPayResultGuideInfo r103 = r101.result_guide_info;
        if (r103 == null) goto L7;
        String r104 = r103.voucher_display_text;
    L8:
        boolean r105 = !TextUtils.isEmpty(r104);
        String r106 = "";
        if (r105 == true) goto L12;
        r104 = "";
    L12:
        KtSafeMethodExtensionKt.safePut(r100, "awards_info", r104);
        if (r105 == false) goto L15;
        String r107 = "1";
    L16:
        KtSafeMethodExtensionKt.safePut(r100, "is_awards_show", r107);
        ResultGuideParams r108 = this.guideParams;
        if (r108 == null) goto L20;
        String r109 = r108.getGuideShowStyle();
        if (r109 == null) goto L20;
    L21:
        KtSafeMethodExtensionKt.safePut(r100, "guide_show_style", r109);
        ResultGuideParams r110 = this.guideParams;
        if (r110 == null) goto L27;
        String r111 = r110.getTitle();
        if (r111 == null) goto L27;
    L26:
        r106 = r111;
    L32:
        KtSafeMethodExtensionKt.safePut(r100, "title", r106);
        return r100;
    L27:
        StringBuilder r112 = new StringBuilder("，");
        ResultGuideParams r113 = this.guideParams;
        if (r113 == null) goto L30;
        r102 = r113.getSubTitle();
    L30:
        r112.append(r102);
        r111 = r112.toString();
        if (r111 != null) goto L26;
    L20:
        r109 = "";
        goto L21
    L15:
        r107 = "0";
    L7:
        r104 = null;
        goto L8
    }

    private final JSONObject getCommonParams() {
        JSONObject r100 = this.commonParams;
        if (r100 == null) goto L7;
        Intrinsics.checkNotNull(r100);
        return r100;
    L7:
        return new JSONObject();
    }

    private final void showFingerprintGuide() {
        ICJPayFingerprintService r100 = this.fingerprintService;
        if (r100 == null) goto L41;
        FragmentActivity r101 = getActivity();
        ResultGuideParams r102 = this.guideParams;
        String r103 = null;
        if (r102 == null) goto L9;
        FingerInfo r104 = r102.getFingerInfo();
        if (r104 == null) goto L9;
        String r105 = r104.title;
    L10:
        ResultGuideParams r106 = this.guideParams;
        if (r106 == null) goto L15;
        FingerInfo r107 = r106.getFingerInfo();
        if (r107 == null) goto L15;
        String r108 = r107.pic_url;
    L16:
        ResultGuideParams r109 = this.guideParams;
        if (r109 == null) goto L21;
        FingerInfo r110 = r109.getFingerInfo();
        if (r110 == null) goto L21;
        String r111 = r110.sub_title;
    L22:
        CJPayCheckoutCounterResponseBean r112 = this.dataBean;
        if (r112 == null) goto L27;
        CJPayProcessInfo r113 = r112.process_info;
        if (r113 == null) goto L27;
        JSONObject r114 = r113.toJson();
    L28:
        CJPayCheckoutCounterResponseBean r115 = this.dataBean;
        if (r115 == null) goto L33;
        CJPayUserInfo r116 = r115.user_info;
        if (r116 == null) goto L33;
        String r117 = r116.uid;
    L34:
        JSONObject r118 = CJPayHostInfo.Companion.toJson$default(CJPayHostInfo.Companion, this.hostBean, null, 2, null);
        CJPayCheckoutCounterResponseBean r119 = this.dataBean;
        if (r119 == null) goto L39;
        CJPayTradeInfo r120 = r119.trade_info;
        if (r120 == null) goto L39;
        r103 = r120.trade_no;
    L39:
        r100.showFingerprintGuide(r101, r105, r108, r111, R.style.CJ_Pay_Dialog_With_Layer, true, true, r114, r117, r118, r103, new C93521(this));
        return;
    L33:
        r117 = null;
    L27:
        r114 = null;
    L21:
        r111 = null;
    L15:
        r108 = null;
    L9:
        r105 = null;
        goto L10
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public int getPanelHeight() {
        BaseGuideWrapper r100 = this.guideWrapper;
        if (r100 != null) goto L7;
        return 470;
    L7:
        return r100.getHeight();
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public View getPanelView() {
        BaseGuideWrapper r100 = this.guideWrapper;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPanelRootView();
    }

    public CJPayFingerprintGuideFragment() {
        this.pwd = "";
        this.from = "";
    }

    private final void showEnableFingerprintSucceeded() {
        FragmentActivity r100 = getActivity();
        if (r100 == null) goto L14;
        BaseGuideWrapper r101 = this.guideWrapper;
        if (r101 == null) goto L12;
        ResultGuideParams r102 = this.guideParams;
        if (r102 == null) goto L10;
        String r103 = r102.getAfterOpenDesc();
        if (r103 == null) goto L10;
    L11:
        r101.updateBtnContent(r103);
        r101.showBtnLoading(false);
        r101.clearBtnClick();
    L10:
        r103 = r100.getString(R.string.cj_pay_fingerprint_enable_succeed);
    L12:
        delayClosePage(800);
        return;
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public void initData() {
        ICJPayFingerprintService r100 = (ICJPayFingerprintService) CJPayServiceManager.getInstance().getIService(ICJPayFingerprintService.class);
        this.fingerprintService = r100;
        if (r100 == null) goto L6;
        r100.releaseFingerprintGuide();
        return;
    }

    public final FrameLayout getRootView() {
        return this.rootView;
    }

    public static final /* synthetic */ JSONObject access$getCommonParams(CJPayFingerprintGuideFragment r100) {
        return r100.getCommonParams();
    }

    public static final /* synthetic */ CJPayCheckoutCounterResponseBean access$getDataBean$p(CJPayFingerprintGuideFragment r100) {
        return r100.dataBean;
    }

    public static final /* synthetic */ String access$getFrom$p(CJPayFingerprintGuideFragment r100) {
        return r100.from;
    }

    public static final /* synthetic */ ResultGuideParams access$getGuideParams$p(CJPayFingerprintGuideFragment r100) {
        return r100.guideParams;
    }

    public static final /* synthetic */ BaseGuideWrapper access$getGuideWrapper$p(CJPayFingerprintGuideFragment r100) {
        return r100.guideWrapper;
    }

    public static final /* synthetic */ CJPayCounterTradeQueryResponseBean access$getResponseBean$p(CJPayFingerprintGuideFragment r100) {
        return r100.responseBean;
    }

    public static final /* synthetic */ void access$showEnableFingerprintSucceeded(CJPayFingerprintGuideFragment r100) {
        r100.showEnableFingerprintSucceeded();
    }

    public static final /* synthetic */ void access$showFingerprintGuide(CJPayFingerprintGuideFragment r100) {
        r100.showFingerprintGuide();
    }

    private final FingerprintAtmosphericsGuideWrapper createAtmosphericsGuideWrapper(View r100) {
        Context r101 = getContext();
        ViewGroup.LayoutParams r102 = null;
        if (r101 == null) goto L5;
        Object r103 = r101.getSystemService("layout_inflater");
    L6:
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.LayoutInflater");
        View r104 = ((LayoutInflater) r103).inflate(R.layout.cj_pay_fragment_fingerprint_atmospherics_guide_layout, null);
        FrameLayout r105 = this.rootView;
        if (r105 == null) goto L9;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
    L10:
        if (r106 == null) goto L13;
        r106.height = CJPayBasicExtensionKt.dp(470);
    L13:
        Integer r107 = this.pageHeight;
        if (r107 == null) goto L21;
        r107.intValue();
        FrameLayout r108 = this.rootView;
        if (r108 == null) goto L18;
        r102 = r108.getLayoutParams();
    L18:
        if (r102 == null) goto L21;
        Integer r109 = this.pageHeight;
        Intrinsics.checkNotNull(r109);
        r102.height = CJPayBasicExtensionKt.dp(r109.intValue());
    L21:
        FrameLayout r110 = this.rootView;
        if (r110 == null) goto L24;
        r110.addView(r104);
    L24:
        final FingerprintAtmosphericsGuideWrapper r111 = new FingerprintAtmosphericsGuideWrapper(r104, this.guideParams);
        r111.setActionCallback(new CJPayFingerprintGuideFragment$createAtmosphericsGuideWrapper$2$1(this, r111));
        return r111;
    L9:
        r106 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    private final FingerprintGuideWrapper createGuideWrapper(View r100) {
        Context r101 = getContext();
        ViewGroup.LayoutParams r102 = null;
        if (r101 == null) goto L5;
        Object r103 = r101.getSystemService("layout_inflater");
    L6:
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.LayoutInflater");
        View r104 = ((LayoutInflater) r103).inflate(R.layout.cj_pay_fragment_fingerprint_guide_layout, null);
        FrameLayout r105 = this.rootView;
        if (r105 == null) goto L9;
        r102 = r105.getLayoutParams();
    L9:
        if (r102 == null) goto L12;
        r102.height = CJPayBasicExtensionKt.dp(470);
    L12:
        FrameLayout r106 = this.rootView;
        if (r106 == null) goto L15;
        r106.addView(r104);
    L15:
        final FingerprintGuideWrapper r107 = new FingerprintGuideWrapper(r104, this.guideParams);
        r107.setActionCallback(new CJPayFingerprintGuideFragment$createGuideWrapper$1$1(this, r107));
        return r107;
    L5:
        r103 = null;
        goto L6
    }

    private final void delayClosePage(long r100) {
        BaseGuideWrapper r101 = this.guideWrapper;
        if (r101 == null) goto L8;
        View r102 = r101.getRootView();
        if (r102 == null) goto L9;
        r102.postDelayed(new AnonymousClass1(this), r100);
        return;
    L9:
        return;
    }

    private final void logFingerGuideOpenResult(String r100) {
        JSONObject r101 = getCommonParams();
        r101.put("result", r100);     // Catch: Exception -> L7
        String r102 = CJPayResultPageLogUtils.getCurrentMethod(this.responseBean);     // Catch: Exception -> L7
        if (TextUtils.isEmpty(r102) == true) goto L9;
        r101.put(e.f25671s, r102);     // Catch: Exception -> L7
    L9:
        CJPayCallBackCenter.getInstance().onEvent("wallet_cashier_fingerprint_enable_result_pop_imp", new JSONObject[]{r101});
        return;
    L7:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayFingerprintGuideFragment#logFingerGuideOpenResult", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayFingerprintGuideFragment#logFingerGuideOpenResult", e);
        goto L9
    }

    private final void logWalletCashierFingerprintEnableCheckPopInput(String r100) {
        this.fingerCheckTimes++;
        JSONObject r101 = getCommonParams();
        int r102 = this.fingerCheckTimes;
        String r103 = this.from;
        ResultGuideParams r104 = this.guideParams;
        if (r104 == null) goto L6;
        String r105 = r104.getPicUrl();
        if (r105 == null) goto L6;
    L7:
        UploadEventUtils.walletCashierFingerprintEnableCheckPopInput(r101, r102, r103, r100, r105);
        return;
    L6:
        r105 = "";
        goto L7
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public void bindViews(View r100) {
        Intrinsics.checkNotNullParameter(r100, "contentView");
        ResultGuideParams r101 = this.guideParams;
        if (r101 == null) goto L6;
        this.rootView = (FrameLayout) r100.findViewById(R.id.cj_pay_fragment_fingerprint_common_guide_root_view);
        this.guideWrapper = getResultGuideWrapper(r100, r101);
        return;
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public void initActions(View r100) {
        BaseGuideWrapper r101 = this.guideWrapper;
        if (r101 == null) goto L6;
        r101.initActions();
        return;
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        JSONObject r101 = getCommonParams();
        String r102 = this.from;
        CJPayCounterTradeQueryResponseBean r103 = this.responseBean;
        if (r103 == null) goto L7;
        CJPayResultGuideInfo r104 = r103.result_guide_info;
        if (r104 == null) goto L7;
        String r105 = r104.pic_url;
    L8:
        if (r105 != null) goto L10;
        r105 = "";
    L10:
        UploadEventUtils.walletCashierFingerprintEnablePopImp(r101, r102, r105, getAwardsParams());
        return;
    L7:
        r105 = null;
        goto L8
    }

    public final void setLogCommonParams(JSONObject r100) {
        this.commonParams = r100;
    }

    public final void setPageHeight(int r100) {
        this.pageHeight = Integer.valueOf(r100);
    }

    public final void setPwd(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        this.pwd = r100;
        return;
    }

    public final void setRootView(FrameLayout r100) {
        this.rootView = r100;
    }

    public static final /* synthetic */ void access$delayClosePage(CJPayFingerprintGuideFragment r100, long r101) {
        r100.delayClosePage(r101);
    }

    public static final /* synthetic */ void access$logFingerGuideOpenResult(CJPayFingerprintGuideFragment r100, String r101) {
        r100.logFingerGuideOpenResult(r101);
    }

    public static final /* synthetic */ void access$logWalletCashierFingerprintEnableCheckPopInput(CJPayFingerprintGuideFragment r100, String r101) {
        r100.logWalletCashierFingerprintEnableCheckPopInput(r101);
    }

    private final BaseGuideWrapper getResultGuideWrapper(View r100, ResultGuideParams r101) {
        String r102 = r101.getTitle();
        boolean r103 = false;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L18;
        String r105 = r101.getBioType();
        if (r105 != null) goto L13;
    L14:
        r103 = true;
    L15:
        if (r103 == true) goto L18;
        return createAtmosphericsGuideWrapper(r100);
    L13:
        if (r105.length() != 0) goto L15;
    L18:
        if (Intrinsics.areEqual(r101.isShowGuide(), Boolean.TRUE) == true) goto L23;
        return null;
    L23:
        return createGuideWrapper(r100);
    L5:
        if (r102.length() == 0) goto L8;
        r104 = false;
        goto L9
    }

    private final void logFingerGuideClick(String r100, String r101) {
        JSONObject r102 = getCommonParams();
        r102.put("button_name", r100);     // Catch: Exception -> L14
        String r103 = CJPayResultPageLogUtils.getCurrentMethod(this.responseBean);     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r103) == true) goto L6;
        r102.put(e.f25671s, r103);     // Catch: Exception -> L14
    L6:
        r102.put("from", this.from);     // Catch: Exception -> L14
        if (r101.length() != 0) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == false) goto L12;
        r101 = "words_style";
    L12:
        r102.put("fingerprint_type", r101);     // Catch: Exception -> L14
    L16:
        CJPayCallBackCenter.getInstance().onEvent("wallet_cashier_fingerprint_enable_pop_click", new JSONObject[]{getAwardsParams(), r102});
        return;
    L9:
        r104 = false;
    L14:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayFingerprintGuideFragment#logFingerGuideClick", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayFingerprintGuideFragment#logFingerGuideClick", e);
        goto L16
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseFragment
    public void inOrOutWithAnimation(boolean r100, boolean r101) {
        FragmentActivity r102 = getActivity();
        BaseGuideWrapper r103 = this.guideWrapper;
        if (r103 == null) goto L5;
        View r104 = r103.getRootView();
    L6:
        CJPayAnimationUtils.inOrOutWithAnimation(r102, r104, r100, r101, false);
        return;
    L5:
        r104 = null;
        goto L6
    }

    public final void setData(CJPayCheckoutCounterResponseBean r100, CJPayHostInfo r101) {
        if (r100 != null) goto L4;
        r100 = CJPayCheckoutCounterActivity.checkoutResponseBean;
    L4:
        this.dataBean = r100;
        if (r101 != null) goto L7;
        r101 = CJPayCheckoutCounterActivity.hostInfo;
    L7:
        this.hostBean = r101;
    }

    public final void setResultBioGuideParams(ResultGuideParams r100, CJPayCounterTradeQueryResponseBean r101) {
        this.guideParams = r100;
        this.responseBean = r101;
        boolean r102 = false;
        if (r101 == null) goto L9;
        CJPayTradeInfo r103 = r101.trade_info;
        if (r103 == null) goto L9;
        if (r103.isTradeAgain() != true) goto L9;
        r102 = true;
    L9:
        if (r102 == false) goto L11;
        String r104 = "wallet_cashier_payafter_second";
    L12:
        this.from = r104;
        return;
    L11:
        r104 = "wallet_cashier_payafter";
        goto L12
    }

    public static final /* synthetic */ void access$logFingerGuideClick(CJPayFingerprintGuideFragment r100, String r101, String r102) {
        r100.logFingerGuideClick(r101, r102);
    }

    public static /* synthetic */ void setData$default(CJPayFingerprintGuideFragment r100, CJPayCheckoutCounterResponseBean r101, CJPayHostInfo r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = null;
    L8:
        r100.setData(r101, r102);
    }
}
