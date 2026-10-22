package com.android.ttcjpaysdk.integrated.counter.outerpay;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.android.ttcjpaysdk.base.CJOuterPayBean;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.OuterType;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.router.CJPayRouterAPI;
import com.android.ttcjpaysdk.base.service.CJOuterPayCallback;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayIntegratedCounterService;
import com.android.ttcjpaysdk.base.service.IOuterPayService;
import com.android.ttcjpaysdk.integrated.counter.CJPayBaseConstant;
import com.android.ttcjpaysdk.integrated.counter.activity.IntegratedCounterActivity;
import com.android.ttcjpaysdk.integrated.counter.beans.ShareData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\b\u0010\u0016\u001a\u00020\u000fH\u0002J\b\u0010\u0017\u001a\u00020\u000fH\u0002J\u0006\u0010\u0018\u001a\u00020\u000fJ\b\u0010\u0019\u001a\u00020\u000fH\u0002J\u0012\u0010\u001a\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\tH\u0002R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/outerpay/IntegratedOuterPayRooter;", "", "activity", "Landroid/app/Activity;", "bean", "Lcom/android/ttcjpaysdk/base/CJOuterPayBean;", "intent", "Landroid/content/Intent;", "callback", "Lcom/android/ttcjpaysdk/base/service/CJOuterPayCallback;", "(Landroid/app/Activity;Lcom/android/ttcjpaysdk/base/CJOuterPayBean;Landroid/content/Intent;Lcom/android/ttcjpaysdk/base/service/CJOuterPayCallback;)V", "rooterMap", "", "", "Lkotlin/Function0;", "", "getFrom", "Lcom/android/ttcjpaysdk/integrated/counter/outerpay/CJOuterPayManager$OuterType;", "outerType", "Lcom/android/ttcjpaysdk/base/OuterType;", "gotoIntegratedCounterPay", "gotoOuterAuthorized", "gotoSignAndPay", "gotoSignOnly", "gotoTargetPageBySource", "setCallbackId", "setOuterPayCallback", "outerPayCallback", "Companion", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IntegratedOuterPayRooter {
    public static final String BIND_AND_WITHDRAW = "bind_and_withdraw";
    public static final Companion Companion = null;
    public static final String INTEGRATED_REGULAR_PAY = "";
    public static final String INTEGRATED_SIGN_AND_PAY = "sign_and_pay";
    public static final String SIGN_ONLY = "sign_only";
    public Activity activity;
    public CJOuterPayBean bean;
    public CJOuterPayCallback callback;
    public Intent intent;
    private final Map<String, Function0<Unit>> rooterMap;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/outerpay/IntegratedOuterPayRooter$Companion;", "", "()V", "BIND_AND_WITHDRAW", "", "INTEGRATED_REGULAR_PAY", "INTEGRATED_SIGN_AND_PAY", "SIGN_ONLY", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[OuterType.values().length];
            r100[OuterType.TYPE_THIRD_APP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[OuterType.TYPE_BROWSER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r100;
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final void gotoIntegratedCounterPay() {
        if (this.activity == null) goto L21;
        Intent r100 = this.intent;
        if (r100 == null) goto L22;
        Uri r101 = r100.getData();
        if (r101 == null) goto L23;
        CJOuterPayBean r102 = this.bean;
        ResultReceiver r103 = null;
        if (r102 == null) goto L11;
        CJPayHostInfo r104 = r102.hostInfo;
    L12:
        ShareData.hostInfo = r104;
        if (r102 == null) goto L15;
        OuterType r105 = r102.getFrom();
    L16:
        CJOuterPayManager.OuterType r106 = getFrom(r105);
        setOuterPayCallback(this.callback);
        CJOuterPayManager.INSTANCE.setStartCounterActivityTime(System.currentTimeMillis());
        CJPayRouterAPI.Builder r107 = CJPayRouterAPI.getInstance().build(IntegratedCounterActivity.class).withBoolean(CJPayBaseConstant.PARAM_CHECKOUT_ENTER_FROM_DY_OUTER, true).withInt(CJPayBaseConstant.PARAM_DY_OUTER_TYPE, r106.getValue()).withParcelable(ICJPayIntegratedCounterService.INTENT_KEY_DATA_FROM_DY, r101);
        Intent r108 = this.intent;
        if (r108 == null) goto L19;
        r103 = (ResultReceiver) r108.getParcelableExtra(CJOuterPayManager.KEY_HIDE_LOADING_CALLBACK);
    L19:
        r107.withParcelable(CJOuterPayManager.KEY_HIDE_LOADING_CALLBACK, r103).withAnimationType(3).navigation(this.activity);
        return;
    L15:
        r105 = null;
        goto L16
    L11:
        r104 = null;
        goto L12
    L23:
        return;
    L22:
        return;
    }

    private final void gotoOuterAuthorized() {
        CJOuterPayBean r100 = this.bean;
        if (r100 == null) goto L6;
        setCallbackId();
        TextUtils.isEmpty(r100.bindPhone);
        CJPayRouterAPI.getInstance().build("com.android.ttcjpaysdk.bdpay.outer.authorize.ui.activity.CJPayOuterAuthorizeActivity").withSerializable("outer_pay_bean", r100).navigation(this.activity);
        return;
    }

    public final void gotoTargetPageBySource() {
        CJOuterPayBean r100 = this.bean;
        if (r100 == null) goto L8;
        Function0<Unit> r101 = this.rooterMap.get(r100.getPaySource());
        if (r101 == null) goto L9;
        r101.invoke();
        return;
    L9:
        return;
    }

    private final void gotoSignOnly() {
        setCallbackId();
        CJPayRouterAPI.getInstance().build("com.android.ttcjpaysdk.bdpay.sign.view.SignOnlyActivity").withSerializable("outer_pay_bean", this.bean).withAnimationType(1).navigation(this.activity);
    }

    private final void setCallbackId() {
        IOuterPayService r100 = (IOuterPayService) CJPayServiceManager.getInstance().getIService(IOuterPayService.class);
        if (r100 == null) goto L5;
        int r101 = r100.addOuterCallback(this.callback);
    L6:
        CJOuterPayBean r102 = this.bean;
        if (r102 == null) goto L11;
        r102.callbackId = r101;
        return;
    L11:
        return;
    L5:
        r101 = -1;
        goto L6
    }

    private final void gotoSignAndPay() {
        gotoIntegratedCounterPay();
    }

    public static final /* synthetic */ void access$gotoIntegratedCounterPay(IntegratedOuterPayRooter r100) {
        r100.gotoIntegratedCounterPay();
    }

    public static final /* synthetic */ void access$gotoOuterAuthorized(IntegratedOuterPayRooter r100) {
        r100.gotoOuterAuthorized();
    }

    public static final /* synthetic */ void access$gotoSignAndPay(IntegratedOuterPayRooter r100) {
        r100.gotoSignAndPay();
    }

    public static final /* synthetic */ void access$gotoSignOnly(IntegratedOuterPayRooter r100) {
        r100.gotoSignOnly();
    }

    private final CJOuterPayManager.OuterType getFrom(OuterType r100) {
        if (r100 != null) goto L4;
        int r101 = -1;
    L6:
        if (r101 == 1) goto L12;
        if (r101 == 2) goto L14;
        return CJOuterPayManager.OuterType.TYPE_UNKNOWN;
    L14:
        return CJOuterPayManager.OuterType.TYPE_BROWSER;
    L12:
        return CJOuterPayManager.OuterType.TYPE_THIRD_APP;
    L4:
        r101 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
        goto L6
    }

    private final void setOuterPayCallback(CJOuterPayCallback r100) {
        if (CJPayCallBackCenter.getInstance().getOuterPayCallback() == null) goto L5;
        CJOuterPayCallback r101 = CJPayCallBackCenter.getInstance().getOuterPayCallback();
        JSONObject r102 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r102, "code", "1");
        r101.onPayResult(r102.toString());
    L5:
        CJPayCallBackCenter.getInstance().setOuterPayCallback(r100);
    }

    public IntegratedOuterPayRooter(Activity r100, CJOuterPayBean r101, Intent r102, CJOuterPayCallback r103) {
        this.activity = r100;
        this.bean = r101;
        this.intent = r102;
        this.callback = r103;
        this.rooterMap = MapsKt.mapOf(new Pair[]{TuplesKt.to(BIND_AND_WITHDRAW, new IntegratedOuterPayRooter$rooterMap$1(this)), TuplesKt.to(SIGN_ONLY, new IntegratedOuterPayRooter$rooterMap$2(this)), TuplesKt.to(INTEGRATED_SIGN_AND_PAY, new IntegratedOuterPayRooter$rooterMap$3(this)), TuplesKt.to("", new IntegratedOuterPayRooter$rooterMap$4(this))});
    }

    public /* synthetic */ IntegratedOuterPayRooter(Activity r100, CJOuterPayBean r101, Intent r102, CJOuterPayCallback r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102, r103);
    }
}
