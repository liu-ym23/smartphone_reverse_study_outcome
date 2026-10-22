package com.android.ttcjpaysdk.base.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.ktextension.CJPayKotlinExtensionsKt;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJLynxComponent;
import com.android.ttcjpaysdk.base.service.ICJPayH5Service;
import com.android.ttcjpaysdk.base.statusbar.CJPayImmersedStatusBarUtils;
import com.android.ttcjpaysdk.base.ui.Utils.CJPayLynxDialogUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainEventTypes;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.crash.d;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0003$%&BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\u001e\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\b\u0010\b\u001a\u0004\u0018\u00010\u001eJ\b\u0010\u001f\u001a\u00020\u001bH\u0016J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u001bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/dialog/CJPayLynxFullScreenDialog;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "themeResId", "", "lynxScheme", "", "initData", "", "", ControlRule.KEY_EXTRA_DATA, "callback", "Lcom/android/ttcjpaysdk/base/ui/dialog/CJPayLynxFullScreenDialog$Callback;", "(Landroid/app/Activity;ILjava/lang/String;Ljava/util/Map;Ljava/util/Map;Lcom/android/ttcjpaysdk/base/ui/dialog/CJPayLynxFullScreenDialog$Callback;)V", "eventTriggerCount", "hasLoadSuccess", "", "listenBackPressed", "lynxComponent", "Lcom/android/ttcjpaysdk/base/service/ICJLynxComponent;", "rootLayout", "Landroid/widget/LinearLayout;", "selfDestructionProcess", "Landroid/os/CountDownTimer;", "createCommonParam", "dismiss", "", "loadFailFallback", "lynxCardInitDataWrapUp", "Lorg/json/JSONObject;", "onBackPressed", "selfDestruction", HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME, "", "setUpLynxView", "Callback", "Companion", "LynxEvent", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayLynxFullScreenDialog extends Dialog {
    public static final Companion Companion = null;
    public static final String EVENT_NAME = "cjpay_event_name";
    public static final String EXTRA_LISTEN_BACK_PRESSED = "listen_back_pressed";
    public static final String LYNX_CARD_COMMENT_EVENT = "cjpay_lynxcard_common_event";
    private final Activity activity;
    private final Callback callback;
    private int eventTriggerCount;
    private final Map<String, Object> extraData;
    private boolean hasLoadSuccess;
    private final Map<String, Object> initData;
    private final boolean listenBackPressed;
    private ICJLynxComponent lynxComponent;
    private final String lynxScheme;
    private LinearLayout rootLayout;
    private CountDownTimer selfDestructionProcess;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007H&J \u0010\t\u001a\u00020\u00032\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007H&J\b\u0010\n\u001a\u00020\u0003H\u0016J \u0010\u000b\u001a\u00020\u00032\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007H\u0016J \u0010\f\u001a\u00020\u00032\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007H&¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/dialog/CJPayLynxFullScreenDialog$Callback;", "", "onButtonInfoAction", "", "eventName", "", "data", "", "onCancel", "onConfirm", "onLoadFailed", "onPay", "onSelectPay", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Callback {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void onButtonInfoAction(Callback r100, String r101, Map<String, ? extends Object> r102) {
                Intrinsics.checkNotNullParameter(r101, "eventName");
            }

            public static void onLoadFailed(Callback r100) {
            }

            public static void onPay(Callback r100, Map<String, ? extends Object> r101) {
            }
        }

        void onButtonInfoAction(String r100, Map<String, ? extends Object> r101);

        void onCancel(Map<String, ? extends Object> r100);

        void onConfirm(Map<String, ? extends Object> r100);

        void onLoadFailed();

        void onPay(Map<String, ? extends Object> r100);

        void onSelectPay(Map<String, ? extends Object> r100);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fJN\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/dialog/CJPayLynxFullScreenDialog$Companion;", "", "()V", "EVENT_NAME", "", "EXTRA_LISTEN_BACK_PRESSED", "LYNX_CARD_COMMENT_EVENT", "showDialog", "", "activity", "Landroid/app/Activity;", "scheme", "initData", "", "callback", "Lcom/android/ttcjpaysdk/base/ui/dialog/CJPayLynxFullScreenDialog$Callback;", ControlRule.KEY_EXTRA_DATA, "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final void showDialog(Activity r100, String r101, Map<String, ? extends Object> r110, Callback r111) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "scheme");
            Intrinsics.checkNotNullParameter(r110, "initData");
            showDialog(r100, r101, r110, new LinkedHashMap(), r111);
        }

        public final void showDialog(Activity r110, String r111, Map<String, ? extends Object> r112, Map<String, ? extends Object> r113, Callback r114) {
            Intrinsics.checkNotNullParameter(r110, "activity");
            Intrinsics.checkNotNullParameter(r111, "scheme");
            Intrinsics.checkNotNullParameter(r112, "initData");
            Intrinsics.checkNotNullParameter(r113, ControlRule.KEY_EXTRA_DATA);
            if (r111.length() != 0) goto L5;
            boolean r100 = true;
        L6:
            if (r100 == false) goto L8;
            return;
        L8:
            CJPayKotlinExtensionsKt.showSafely(new CJPayLynxFullScreenDialog(r110, 0, r111, r112, r113, r114, 2, null), r110);
            return;
        L5:
            r100 = false;
            goto L6
        }

        public static /* synthetic */ void showDialog$default(Companion r100, Activity r101, String r102, Map r103, Callback r104, int r105, Object r106) {
            if ((r105 & 8) == 0) goto L5;
            r104 = null;
        L5:
            r100.showDialog(r101, r102, r103, r104);
        }

        public static /* synthetic */ void showDialog$default(Companion r100, Activity r101, String r102, Map r103, Map r110, Callback r111, int r112, Object r113) {
            if ((r112 & 16) == 0) goto L5;
            r111 = null;
        L5:
            r100.showDialog(r101, r102, r103, r110, r111);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/dialog/CJPayLynxFullScreenDialog$LynxEvent;", "", "eventName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getEventName", "()Ljava/lang/String;", "ON_CONFIRM", "STATUS_PAGE_LOAD_SUCCESS", "ON_CANCEL_AND_LEAVE", "ON_SELECT_PAY", "ON_CANCEL", "ON_PAY", "ON_BUTTON_INFO_ACTION", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum LynxEvent extends Enum<LynxEvent> {
        private static final /* synthetic */ LynxEvent[] $VALUES = null;
        public static final Companion Companion = null;
        public static final LynxEvent ON_BUTTON_INFO_ACTION = null;
        public static final LynxEvent ON_CANCEL = null;
        public static final LynxEvent ON_CANCEL_AND_LEAVE = null;
        public static final LynxEvent ON_CONFIRM = null;
        public static final LynxEvent ON_PAY = null;
        public static final LynxEvent ON_SELECT_PAY = null;
        public static final LynxEvent STATUS_PAGE_LOAD_SUCCESS = null;
        private final String eventName;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/dialog/CJPayLynxFullScreenDialog$LynxEvent$Companion;", "", "()V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }
        }

        private static final /* synthetic */ LynxEvent[] $values() {
            return new LynxEvent[]{ON_CONFIRM, STATUS_PAGE_LOAD_SUCCESS, ON_CANCEL_AND_LEAVE, ON_SELECT_PAY, ON_CANCEL, ON_PAY, ON_BUTTON_INFO_ACTION};
        }

        public static LynxEvent valueOf(String r100) {
            return (LynxEvent) a.a(LynxEvent.class, r100);
        }

        public static LynxEvent[] values() {
            return (LynxEvent[]) $VALUES.clone();
        }

        static {
            ON_CONFIRM = new LynxEvent("ON_CONFIRM", 0, "on_confirm");
            STATUS_PAGE_LOAD_SUCCESS = new LynxEvent("STATUS_PAGE_LOAD_SUCCESS", 1, "status_page_load_success");
            ON_CANCEL_AND_LEAVE = new LynxEvent("ON_CANCEL_AND_LEAVE", 2, CancelRetainEventTypes.OnCancelAndLeave);
            ON_SELECT_PAY = new LynxEvent("ON_SELECT_PAY", 3, "on_select_pay");
            ON_CANCEL = new LynxEvent("ON_CANCEL", 4, CancelRetainEventTypes.OnCancel);
            ON_PAY = new LynxEvent("ON_PAY", 5, "on_pay");
            ON_BUTTON_INFO_ACTION = new LynxEvent("ON_BUTTON_INFO_ACTION", 6, "cjpay_button_info_action");
            $VALUES = $values();
            Companion = new Companion(null);
        }

        public final String getEventName() {
            return this.eventName;
        }

        private LynxEvent(String r100, int r101, String r102) {
            super(r100, r101);
            this.eventName = r102;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void access$000(Dialog r100) {
        super.dismiss();
    }

    private final Map<String, Object> createCommonParam() {
        LinkedHashMap r100 = new LinkedHashMap();
        boolean r101 = CJPayLynxDialogUtils.INSTANCE.isLynxPackageReady("fe_lynx_cashdesk_dynamic");
        r100.put("scheme", this.lynxScheme);
        r100.put("scene", this.extraData.get("from_scene"));
        r100.put("channel", "fe_lynx_cashdesk_dynamic");
        r100.put("status", Boolean.valueOf(r101));
        return r100;
    }

    private final void loadFailFallback() {
        CJReporter.h(CJReporter.f202294a, CJPayCallBackCenter.getInstance().getCjContext(), "wallet_rd_show_fail_lynx", createCommonParam(), null, 56);
        Callback r100 = this.callback;
        if (r100 == null) goto L5;
        r100.onLoadFailed();
    L5:
        CJPayKotlinExtensionsKt.dismissSafely(this);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        ICJLynxComponent r100 = this.lynxComponent;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        this.lynxComponent = null;
        INVOKESPECIAL_com_android_ttcjpaysdk_base_ui_dialog_CJPayLynxFullScreenDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (this.listenBackPressed == false) goto L5;
        return;
    L5:
        super.onBackPressed();
    }

    private final void setUpLynxView() {
        ICJPayH5Service r100 = (ICJPayH5Service) CJPayServiceManager.getInstance().getIService(ICJPayH5Service.class);
        ICJLynxComponent r101 = null;
        if (r100 == null) goto L20;
        final ICJLynxComponent r102 = r100.createLynxComponent(getContext(), this.lynxScheme, lynxCardInitDataWrapUp(new JSONObject(this.initData)), new C88981(this));
        if (r102 == null) goto L20;
        String r103 = UriProtector.parse(this.lynxScheme).getHost();
        boolean r104 = false;
        if (r103 != null) goto L9;
    L11:
        if (r104 == false) goto L13;
        r102.reloadLongSchema();
    L13:
        View r105 = r102.getCJLynxView();
        LinearLayout r106 = this.rootLayout;
        if (r106 == null) goto L16;
        r106.addView(r105);
    L16:
        ViewGroup.LayoutParams r107 = r105.getLayoutParams();
        if (r107 == null) goto L19;
        r107.width = -1;
        r107.height = -1;
        r105.setLayoutParams(r107);
    L19:
        r102.registerSubscriber(r102.containerId(), System.currentTimeMillis(), "cjpay_lynxcard_common_event", new CJPayLynxFullScreenDialog$setUpLynxView$2$1(r102, this));
        r101 = r102;
        goto L20
    L9:
        if (StringsKt.contains$default(r103, "redirect", false, 2, null) != true) goto L11;
        r104 = true;
    L20:
        this.lynxComponent = r101;
    }

    public static void INVOKESPECIAL_com_android_ttcjpaysdk_base_ui_dialog_CJPayLynxFullScreenDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(Dialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        access$000(r100);     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static final /* synthetic */ Map access$createCommonParam(CJPayLynxFullScreenDialog r100) {
        return r100.createCommonParam();
    }

    public static final /* synthetic */ Callback access$getCallback$p(CJPayLynxFullScreenDialog r100) {
        return r100.callback;
    }

    public static final /* synthetic */ boolean access$getHasLoadSuccess$p(CJPayLynxFullScreenDialog r100) {
        return r100.hasLoadSuccess;
    }

    public static final /* synthetic */ CountDownTimer access$getSelfDestructionProcess$p(CJPayLynxFullScreenDialog r100) {
        return r100.selfDestructionProcess;
    }

    public static final /* synthetic */ void access$loadFailFallback(CJPayLynxFullScreenDialog r100) {
        r100.loadFailFallback();
    }

    private final void selfDestruction(final long r100) {
        if (r100 > 0) goto L5;
        return;
    L5:
        this.selfDestructionProcess = new AnonymousClass1(r100, this).start();
    }

    public final Map<String, Object> lynxCardInitDataWrapUp(JSONObject r100) {
        JSONObject r101 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r101, "cj_data", r100);
        KtSafeMethodExtensionKt.safePut(r101, "cj_sdk_version", CJPayBasicUtils.getRealVersion());
        KtSafeMethodExtensionKt.safePut(r101, "cj_sdk_plugin_version", CJPayBasicUtils.getVersionName());
        KtSafeMethodExtensionKt.safePut(r101, "cj_sdk_plugin_version_code", Integer.valueOf(CJPayBasicUtils.getSDKVersionCode()));
        KtSafeMethodExtensionKt.safePut(r101, "cj_host_plugin_version_code", Long.valueOf(CJPayBasicUtils.getPluginVerCodeHost()));
        KtSafeMethodExtensionKt.safePut(r101, "cj_version", 1);
        return MapsKt.mapOf(TuplesKt.to("cj_initial_props", r101));
    }

    public static final /* synthetic */ void access$setHasLoadSuccess$p(CJPayLynxFullScreenDialog r100, boolean r101) {
        r100.hasLoadSuccess = r101;
    }

    public CJPayLynxFullScreenDialog(Activity r100, int r101, String r102, Map<String, ? extends Object> r110, Map<String, ? extends Object> r111, Callback r112) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r102, "lynxScheme");
        Intrinsics.checkNotNullParameter(r110, "initData");
        Intrinsics.checkNotNullParameter(r111, ControlRule.KEY_EXTRA_DATA);
        super(r100, r101);
        this.activity = r100;
        this.lynxScheme = r102;
        this.initData = r110;
        this.extraData = r111;
        this.callback = r112;
        Object r103 = r111.get(EXTRA_LISTEN_BACK_PRESSED);
        Long r104 = null;
        if ((r103 instanceof Boolean) == false) goto L5;
        Boolean r105 = (Boolean) r103;
    L6:
        if (r105 == null) goto L8;
        boolean r106 = r105.booleanValue();
    L9:
        this.listenBackPressed = r106;
        CJReporter.h(CJReporter.f202294a, CJPayCallBackCenter.getInstance().getCjContext(), "wallet_rd_try_open_lynx", createCommonParam(), null, 56);
        requestWindowFeature(1);
        Window r107 = getWindow();
        if (r107 == null) goto L12;
        CJPayImmersedStatusBarUtils.setWindowStatusBarLightModeCompatLollipop(r107, true);
        WindowManager.LayoutParams r113 = r107.getAttributes();
        r113.width = -1;
        r113.height = -1;
        r107.setAttributes(r113);
    L12:
        View r108 = LayoutInflater.from(getContext()).inflate(R.layout.cj_pay_lynx_dialog_layout, null);
        setContentView(r108);
        this.rootLayout = (LinearLayout) r108.findViewById(R.id.cj_pay_lynx_dialog_root_layout);
        setUpLynxView();
        setCancelable(true);
        Object r109 = r111.get("wait_time");
        if ((r109 instanceof Long) == false) goto L15;
        r104 = (Long) r109;
    L15:
        if (r104 == null) goto L18;
        selfDestruction(r104.longValue());
        return;
    L18:
        return;
    L8:
        r106 = false;
        goto L9
    L5:
        r105 = null;
        goto L6
    }

    public /* synthetic */ CJPayLynxFullScreenDialog(Activity r100, int r101, String r110, Map r111, Map r112, Callback r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 2) == 0) goto L5;
        int r102 = R.style.CJ_Pay_Full_Dialog_Fragment_Style;
    L7:
        if ((r114 & 32) == 0) goto L9;
        r113 = null;
    L9:
        this(r100, r102, r110, r111, r112, r113);
        return;
    L5:
        r102 = r101;
        goto L7
    }
}
