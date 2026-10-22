package com.android.ttcjpaysdk.bindcard.base.pay;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.alipay.sdk.m.k.b;
import com.android.ttcjpaysdk.base.eventbus.EventManager;
import com.android.ttcjpaysdk.base.framework.BaseActivity;
import com.android.ttcjpaysdk.base.framework.CJPayActivityManager;
import com.android.ttcjpaysdk.base.framework.event.CJPayBindCardPayEvent;
import com.android.ttcjpaysdk.base.framework.event.CJPayFinishAllBindCardPageEvent;
import com.android.ttcjpaysdk.base.framework.event.CJPayFinishSmsPageWithAnimEvent;
import com.android.ttcjpaysdk.base.ktextension.CJPayKotlinExtensionsKt;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.service.ICJPayNewCardCallback;
import com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayDialogBuilder;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayDialogUtils;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayLynxFullScreenDialog;
import com.android.ttcjpaysdk.base.utils.CJPayActivityUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.bindcard.base.applog.PayNewCardLogger;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayNewCardBean;
import com.android.ttcjpaysdk.bindcard.base.bean.NewCardPreChargeBean;
import com.android.ttcjpaysdk.bindcard.base.ui.CJPaySmsCodeCheckActivity;
import com.android.ttcjpaysdk.bindcard.base.utils.BindCardCommonInfoUtil;
import com.android.ttcjpaysdk.thirdparty.data.CJPayProcessInfo;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 D2\u00020\u0001:\u0001DB\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0002J&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\bH&J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\bH\u0016J@\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u001e\u001a\u00020\u00102\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\bJD\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010'\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010(\u001a\u0004\u0018\u00010\bJ\u0006\u0010)\u001a\u00020\bJ\"\u0010*\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\b\u0010\u0017\u001a\u0004\u0018\u00010\bH\u0002J\u0006\u0010+\u001a\u00020\u0010JJ\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u00102\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010/\u001a\u0004\u0018\u000100H\u0007J\u001c\u00101\u001a\u00020\u00122\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\b\u0002\u00102\u001a\u00020\u0010J'\u00103\u001a\u0004\u0018\u00010$2\u0016\u00104\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u000105H\u0002¢\u0006\u0002\u00106J\u0014\u00107\u001a\u0004\u0018\u00010\u00162\b\u00108\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u00109\u001a\u00020\u00122\u0006\u0010:\u001a\u00020\u0010H\u0002J\b\u0010;\u001a\u00020\u0010H\u0002J:\u0010<\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u001e\u001a\u00020\u00102\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\bH\u0002J.\u0010=\u001a\u00020\u00122\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010!\u001a\u00020\"2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010>\u001a\u00020\u0010J \u0010?\u001a\u00020\u00102\u0016\u00104\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u000105H\u0002J$\u0010@\u001a\u00020\u00102\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010!\u001a\u00020\"2\b\u0010A\u001a\u0004\u0018\u00010\u0016H\u0002J$\u0010B\u001a\u00020\u00122\b\u0010\u0002\u001a\u0004\u0018\u00010C2\u0006\u0010!\u001a\u00020\"2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\bR\u0014\u0010\u0007\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006E"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/pay/IPayNewCardBaseResponse;", "", "activity", "Landroid/app/Activity;", "logger", "Lcom/android/ttcjpaysdk/bindcard/base/applog/PayNewCardLogger;", "(Landroid/app/Activity;Lcom/android/ttcjpaysdk/bindcard/base/applog/PayNewCardLogger;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getActivity", "()Landroid/app/Activity;", "getLogger", "()Lcom/android/ttcjpaysdk/bindcard/base/applog/PayNewCardLogger;", "containSmsCheckInBindCard", "", "dealWithResponse", "", "bean", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayNewCardBean;", "tradeQuery", "Lorg/json/JSONObject;", "memberBizOrderNo", "Lcom/android/ttcjpaysdk/bindcard/base/bean/NewCardPreChargeBean;", "executeFinishAll", "finishSelf", "notifyBindCardPayEvent", "code", "params", "isNotifyNow", "getErrorDialogClickListener", "Landroid/view/View$OnClickListener;", "info", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayButtonInfo;", "action", "", "dialog", "Lcom/android/ttcjpaysdk/base/ui/dialog/CJPayCommonDialog;", "onErrorDialogBtnClick", "getTradeNo", "getUid", "handleButtonInfoWithLynxOrNativeIfNeeded", "isNotifyAfterPayFailed", "notifyAll", "isPaySucceed", "responseParams", "processInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayProcessInfo;", "notifyPartially", "isRisk", "parseLynxAction", "data", "", "(Ljava/util/Map;)Ljava/lang/Integer;", "parseLynxPageInfo", TemplateNodeType.RAW, "performFinishAllBindCardPageEvent", "doAnim", "performFinishAllWithAnim", "performNotifyBindCardPayEvent", "processButtonInfo", "tryLynx", "shouldFallbackToNative", "shouldOpenLynx", "initJson", "showErrorDialog", "Lcom/android/ttcjpaysdk/base/framework/BaseActivity;", "Companion", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class IPayNewCardBaseResponse {
    public static final Companion Companion = null;
    private static final String EVENT_NAME_KEY = "cjpay_event_name";
    private static final String EVENT_ON_CANCEL_AND_LEAVE = "on_cancel_and_leave";
    private final String TAG;
    private final Activity activity;
    private final PayNewCardLogger logger;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/pay/IPayNewCardBaseResponse$Companion;", "", "()V", "EVENT_NAME_KEY", "", "EVENT_ON_CANCEL_AND_LEAVE", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    public abstract void dealWithResponse(CJPayNewCardBean r100, JSONObject r101, String r102);

    public void dealWithResponse(NewCardPreChargeBean r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "bean");
    }

    private final boolean containSmsCheckInBindCard() {
        Activity r100 = CJPayActivityManager.searchTopActivityClass(CJPaySmsCodeCheckActivity.class);
        if (r100 != null) goto L7;
        return false;
    L7:
        return CJPayKotlinExtensionsKt.isAlive(r100);
    }

    public final String getTradeNo() {
        ICJPayNewCardCallback r100 = BindCardCommonInfoUtil.INSTANCE.getPayNewCardCallback();
        if (r100 == null) goto L7;
        JSONObject r101 = r100.getPayNewCardConfigs();
        if (r101 == null) goto L7;
        return r101.optString(b.B0);
    L7:
        return null;
    }

    public final String getUid() {
        ICJPayNewCardCallback r100 = BindCardCommonInfoUtil.INSTANCE.getPayNewCardCallback();
        if (r100 == null) goto L7;
        JSONObject r101 = r100.getPayNewCardConfigs();
        if (r101 == null) goto L7;
        String r102 = r101.optString("uid");
    L8:
        if (r102 != null) goto L11;
        return "";
    L11:
        return r102;
    L7:
        r102 = null;
        goto L8
    }

    public final boolean isNotifyAfterPayFailed() {
        ICJPayNewCardCallback r100 = BindCardCommonInfoUtil.INSTANCE.getPayNewCardCallback();
        if (r100 == null) goto L7;
        JSONObject r101 = r100.getPayNewCardConfigs();
        if (r101 == null) goto L7;
        return r101.optBoolean("isNotifyAfterPayFailed");
    L7:
        return true;
    }

    private final boolean performFinishAllWithAnim() {
        if (containSmsCheckInBindCard() == false) goto L5;
        EventManager.INSTANCE.notify(new CJPayFinishSmsPageWithAnimEvent());
        boolean r100 = false;
    L6:
        Activity r101 = this.activity;
        if (r101 == null) goto L9;
        r101.finish();
    L9:
        CJPayActivityUtils.executeActivityFadeInOrOutAnimation(this.activity);
        return r100;
    L5:
        r100 = true;
        goto L6
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final PayNewCardLogger getLogger() {
        return this.logger;
    }

    public final String getTAG() {
        return this.TAG;
    }

    private final Integer parseLynxAction(Map<String, ? extends Object> r100) {
        if (r100 == null) goto L14;
        Object r101 = r100.get("action");
        if (r101 != null) goto L8;
        return null;
    L8:
        if ((r101 instanceof Number) == false) goto L11;
        return Integer.valueOf(((Number) r101).intValue());
    L11:
        if ((r101 instanceof String) == true) goto L13;
        return null;
    L13:
        return StringsKt.toIntOrNull((String) r101);
    L14:
        return null;
    }

    private final JSONObject parseLynxPageInfo(String r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L27;
        return null;
    L27:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L14
        Object r104 = Result.m9449constructorimpl(new JSONObject(r100));     // Catch: Throwable -> L14
    L17:
        if (Result.m9455isFailureimpl(r104) == false) goto L19;
        r104 = null;
    L19:
        JSONObject r105 = (JSONObject) r104;
        if (r105 != null) goto L22;
        return null;
    L22:
        if (r105.length() <= 0) goto L24;
        r101 = true;
    L24:
        if (r101 == true) goto L26;
        return null;
    L26:
        return r105;
    L14:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L10
    }

    private final void performFinishAllBindCardPageEvent(boolean r100) {
        if (r100 == false) goto L4;
        boolean r101 = performFinishAllWithAnim();
    L5:
        if (r101 == false) goto L8;
        new Handler(Looper.getMainLooper()).postDelayed(new RunnableC91181(this), 300);
        return;
    L8:
        return;
    L4:
        r101 = true;
        goto L5
    }

    private final boolean shouldFallbackToNative(Map<String, ? extends Object> r100) {
        if (r100 == null) goto L6;
        Object r101 = r100.get("cjpay_event_name");
        if (r101 == null) goto L6;
        String r102 = r101.toString();
    L8:
        return Intrinsics.areEqual(r102, "on_cancel_and_leave");
    L6:
        r102 = null;
        goto L8
    }

    public IPayNewCardBaseResponse(Activity r100, PayNewCardLogger r101) {
        this.activity = r100;
        this.logger = r101;
        this.TAG = "IPayNewCardBaseResponse";
    }

    public static final /* synthetic */ Integer access$parseLynxAction(IPayNewCardBaseResponse r100, Map r101) {
        return r100.parseLynxAction(r101);
    }

    public static final /* synthetic */ boolean access$shouldFallbackToNative(IPayNewCardBaseResponse r100, Map r101) {
        return r100.shouldFallbackToNative(r101);
    }

    public final void notifyPartially(String r110, boolean r111) {
        EventManager r100 = EventManager.INSTANCE;
        r100.notify(new CJPayFinishAllBindCardPageEvent(false, 1, null));
        if (isNotifyAfterPayFailed() == false) goto L6;
        r100.notifyLast(new CJPayBindCardPayEvent("1", null, r110, r111, 2, null));
        return;
    }

    private final boolean handleButtonInfoWithLynxOrNativeIfNeeded(final Activity r110, final CJPayButtonInfo r111, final String r112) {
        JSONObject r100 = parseLynxPageInfo(r111.lynx_page_info);
        if (shouldOpenLynx(r110, r111, r100) == true) goto L6;
        return false;
    L6:
        final Ref.BooleanRef r101 = new Ref.BooleanRef();
        JSONObject r102 = new JSONObject();
        r102.put("id", "bank_fail_retain_dialog");
        r102.put("lynx_page_info", r100);
        CJPayLynxFullScreenDialog.Companion.showDialog(r110, r111.lynx_url, KtSafeMethodExtensionKt.toAnyMap(r102), MapsKt.mapOf(TuplesKt.to(CJPayLynxFullScreenDialog.EXTRA_LISTEN_BACK_PRESSED, Boolean.TRUE)), new C91171(this, r101, r110, r111, r112));
        return true;
    }

    private final boolean shouldOpenLynx(Activity r100, CJPayButtonInfo r101, JSONObject r102) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.isFinishing() == false) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(r101.use_lynx_style, "1") == true) goto L9;
        return false;
    L9:
        if (r101.lynx_url.length() <= 0) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L21;
        if (r102 != null) goto L15;
        return false;
    L15:
        if (r102.length() <= 0) goto L23;
        return true;
    L23:
        return false;
    L21:
        return false;
    L11:
        r103 = false;
        goto L12
    }

    public final void showErrorDialog(final BaseActivity r110, final CJPayButtonInfo r111, String r112) {
        Intrinsics.checkNotNullParameter(r111, "info");
        View.OnClickListener r100 = new IPayNewCardBaseResponse$showErrorDialog$onErrorDialogBtnClick$1(r110, this, r111);
        CJPayDialogBuilder r101 = CJPayDialogUtils.getDefaultBuilder(r110);
        int r102 = r111.left_button_action;
        if (r110 == null) goto L5;
        CJPayCommonDialog r103 = r110.mCommonDialog;
    L6:
        CJPayDialogBuilder r104 = r101.setLeftBtnListener(getErrorDialogClickListener(r111, r102, r103, r110, r100, r112));
        int r105 = r111.right_button_action;
        if (r110 == null) goto L9;
        CJPayCommonDialog r106 = r110.mCommonDialog;
    L10:
        CJPayDialogBuilder r107 = r104.setRightBtnListener(getErrorDialogClickListener(r111, r105, r106, r110, r100, r112));
        int r108 = r111.action;
        if (r110 == null) goto L13;
        CJPayCommonDialog r109 = r110.mCommonDialog;
    L14:
        CJPayDialogBuilder r113 = r107.setSingleBtnListener(getErrorDialogClickListener(r111, r108, r109, r110, r100, r112)).setCloseBtnListener(new IPayNewCardBaseResponse$showErrorDialog$builder$1(r110, this, r111)).setWidth(300);
        r113.setButtonInfo(r111);
        if (r110 == null) goto L17;
        r110.showCommonDialog(r113);
    L17:
        PayNewCardLogger r114 = this.logger;
        if (r114 == null) goto L21;
        r114.logButtonInfoShow(r111.button_type, r111.main_title, r111.page_desc, r111.track_exts);
        return;
    L21:
        return;
    L13:
        r109 = null;
        goto L14
    L9:
        r106 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public /* synthetic */ IPayNewCardBaseResponse(Activity r100, PayNewCardLogger r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }

    public final void processButtonInfo(Activity r100, CJPayButtonInfo r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "info");
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isFinishing() == false) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual("4", r101.button_type) == true) goto L10;
        if (r103 == true) goto L14;
    L16:
        showErrorDialog((BaseActivity) r100, r101, r102);
        return;
    L14:
        if (handleButtonInfoWithLynxOrNativeIfNeeded(r100, r101, r102) == false) goto L16;
        return;
    L10:
        if (TextUtils.isEmpty(r101.page_desc) == true) goto L19;
        CJPayBasicUtils.displayToast(r100, r101.page_desc);
        return;
    }

    public static final /* synthetic */ void access$handleButtonInfoWithLynxOrNativeIfNeeded$fallbackToNative(Ref.BooleanRef r100, IPayNewCardBaseResponse r101, Activity r102, CJPayButtonInfo r103, String r104) {
        handleButtonInfoWithLynxOrNativeIfNeeded$fallbackToNative(r100, r101, r102, r103, r104);
    }

    private static final void handleButtonInfoWithLynxOrNativeIfNeeded$fallbackToNative(Ref.BooleanRef r100, IPayNewCardBaseResponse r101, Activity r102, CJPayButtonInfo r103, String r104) {
        if (r100.element == false) goto L5;
        return;
    L5:
        r100.element = true;
        r101.processButtonInfo(r102, r103, r104, false);
    }

    public static /* synthetic */ void notifyPartially$default(IPayNewCardBaseResponse r100, String r101, boolean r102, int r103, Object r104) {
        if (r104 != null) goto L12;
        if ((r103 & 1) == 0) goto L7;
        r101 = null;
    L7:
        if ((r103 & 2) == 0) goto L9;
        r102 = false;
    L9:
        r100.notifyPartially(r101, r102);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: notifyPartially");
    }

    private final void performNotifyBindCardPayEvent(boolean r100, String r101, JSONObject r110, boolean r111, String r112) {
        if (r100 == false) goto L7;
        if (r111 == false) goto L5;
        EventManager.INSTANCE.notifyLastNow(new CJPayBindCardPayEvent(r101, r110, r112, false, 8, null));
        return;
    L5:
        EventManager.INSTANCE.notifyLast(new CJPayBindCardPayEvent(r101, r110, r112, false, 8, null));
        return;
    }

    public static /* synthetic */ void dealWithResponse$default(IPayNewCardBaseResponse r100, CJPayNewCardBean r101, JSONObject r102, String r103, int r104, Object r105) {
        if (r105 != null) goto L9;
        if ((r104 & 4) == 0) goto L6;
        r103 = null;
    L6:
        r100.dealWithResponse(r101, r102, r103);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dealWithResponse");
    }

    private final View.OnClickListener getErrorDialogClickListener(final CJPayButtonInfo r110, final int r111, final CJPayCommonDialog r112, final Activity r113, final View.OnClickListener r114, final String r115) {
        if (r113 != null) goto L4;
    L7:
        return null;
    L4:
        if (r113.isFinishing() == true) goto L7;
        return new AnonymousClass1(r114, r111, r112, r113, this, r115, r110);
    }

    public static /* synthetic */ void showErrorDialog$default(IPayNewCardBaseResponse r100, BaseActivity r101, CJPayButtonInfo r102, String r103, int r104, Object r105) {
        if (r105 != null) goto L9;
        if ((r104 & 4) == 0) goto L6;
        r103 = null;
    L6:
        r100.showErrorDialog(r101, r102, r103);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showErrorDialog");
    }

    public final void executeFinishAll(boolean r100, boolean r101, String r102, JSONObject r110, boolean r111, String r112) {
        Intrinsics.checkNotNullParameter(r102, "code");
        performNotifyBindCardPayEvent(r101, r102, r110, r111, r112);
        performFinishAllBindCardPageEvent(r100);
    }

    public final void notifyAll(boolean r110, boolean r111, JSONObject r112, JSONObject r113, String r114, CJPayProcessInfo r115) {
        String r100 = "";
        if (r110 == false) goto L13;
        Activity r101 = this.activity;
        if ((r101 instanceof CJPayNewCardActivity) == false) goto L7;
        CJPayNewCardActivity r102 = (CJPayNewCardActivity) r101;
    L8:
        if (r102 == null) goto L13;
        String r103 = r102.getCheckList();
        if (r103 == null) goto L13;
        r100 = r103;
        goto L13
    L7:
        r102 = null;
    L13:
        JSONObject r104 = new JSONObject();
        if (r112 == null) goto L16;
        r112.put("check_list", r100);
        JSONObject r105 = r112;
    L17:
        if (r110 == false) goto L20;
        if (r113 == null) goto L20;
        r105.put("trade_query_response", r113);
    L20:
        if (r115 == null) goto L23;
        KtSafeMethodExtensionKt.safePut(r105, "process_info", r115.toJson().toString());
    L23:
        if (r110 == false) goto L25;
        String r106 = "0";
    L26:
        executeFinishAll$default(this, r111, true, r106, r105, false, r114, 16, null);
        return;
    L25:
        r106 = "1";
        goto L26
    L16:
        r104.put("check_list", r100);
        r105 = r104;
        goto L17
    }

    public static final /* synthetic */ View.OnClickListener access$getErrorDialogClickListener(IPayNewCardBaseResponse r100, CJPayButtonInfo r101, int r102, CJPayCommonDialog r103, Activity r104, View.OnClickListener r105, String r106) {
        return r100.getErrorDialogClickListener(r101, r102, r103, r104, r105, r106);
    }

    public static /* synthetic */ void processButtonInfo$default(IPayNewCardBaseResponse r100, Activity r101, CJPayButtonInfo r102, String r103, boolean r104, int r105, Object r106) {
        if (r106 != null) goto L12;
        if ((r105 & 4) == 0) goto L7;
        r103 = null;
    L7:
        if ((r105 & 8) == 0) goto L9;
        r104 = true;
    L9:
        r100.processButtonInfo(r101, r102, r103, r104);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: processButtonInfo");
    }

    public static /* synthetic */ void performNotifyBindCardPayEvent$default(IPayNewCardBaseResponse r100, boolean r101, String r102, JSONObject r110, boolean r111, String r112, int r113, Object r114) {
        if (r114 != null) goto L18;
        if ((r113 & 4) == 0) goto L6;
        JSONObject r103 = null;
    L8:
        if ((r113 & 8) == 0) goto L10;
        boolean r104 = false;
    L12:
        if ((r113 & 16) == 0) goto L14;
        String r105 = null;
    L15:
        r100.performNotifyBindCardPayEvent(r101, r102, r103, r104, r105);
        return;
    L14:
        r105 = r112;
        goto L15
    L10:
        r104 = r111;
        goto L12
    L6:
        r103 = r110;
        goto L8
    L18:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: performNotifyBindCardPayEvent");
    }

    public static /* synthetic */ void executeFinishAll$default(IPayNewCardBaseResponse r100, boolean r110, boolean r111, String r112, JSONObject r113, boolean r114, String r115, int r116, Object r117) {
        if (r117 != null) goto L18;
        if ((r116 & 8) == 0) goto L6;
        JSONObject r101 = null;
    L8:
        if ((r116 & 16) == 0) goto L10;
        boolean r102 = false;
    L12:
        if ((r116 & 32) == 0) goto L14;
        String r103 = null;
    L15:
        r100.executeFinishAll(r110, r111, r112, r101, r102, r103);
        return;
    L14:
        r103 = r115;
        goto L15
    L10:
        r102 = r114;
        goto L12
    L6:
        r101 = r113;
        goto L8
    L18:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: executeFinishAll");
    }

    public static /* synthetic */ View.OnClickListener getErrorDialogClickListener$default(IPayNewCardBaseResponse r100, CJPayButtonInfo r101, int r102, CJPayCommonDialog r110, Activity r111, View.OnClickListener r112, String r113, int r114, Object r115) {
        if (r115 != null) goto L9;
        if ((r114 & 32) == 0) goto L7;
        r113 = null;
    L7:
        return r100.getErrorDialogClickListener(r101, r102, r110, r111, r112, r113);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getErrorDialogClickListener");
    }

    public static /* synthetic */ void notifyAll$default(IPayNewCardBaseResponse r100, boolean r101, boolean r102, JSONObject r110, JSONObject r111, String r112, CJPayProcessInfo r113, int r114, Object r115) {
        if (r115 != null) goto L26;
        if ((r114 & 2) == 0) goto L6;
        boolean r103 = true;
    L8:
        if ((r114 & 4) == 0) goto L10;
        JSONObject r104 = null;
    L12:
        if ((r114 & 8) == 0) goto L14;
        JSONObject r105 = null;
    L16:
        if ((r114 & 16) == 0) goto L18;
        String r106 = null;
    L20:
        if ((r114 & 32) == 0) goto L22;
        CJPayProcessInfo r107 = null;
    L23:
        r100.notifyAll(r101, r103, r104, r105, r106, r107);
        return;
    L22:
        r107 = r113;
        goto L23
    L18:
        r106 = r112;
        goto L20
    L14:
        r105 = r111;
        goto L16
    L10:
        r104 = r110;
        goto L12
    L6:
        r103 = r102;
        goto L8
    L26:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: notifyAll");
    }
}
