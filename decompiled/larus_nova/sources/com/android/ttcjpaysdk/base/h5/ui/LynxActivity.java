package com.android.ttcjpaysdk.base.h5.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.android.ttcjpaysdk.base.eventbus.EventManager;
import com.android.ttcjpaysdk.base.framework.AnimUtil;
import com.android.ttcjpaysdk.base.framework.CJPayAnimRootView;
import com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity;
import com.android.ttcjpaysdk.base.framework.mvp.nothing.LoggerNothing;
import com.android.ttcjpaysdk.base.framework.mvp.nothing.PresentorNothing;
import com.android.ttcjpaysdk.base.h5.CJPayH5Provider;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.CJPayKotlinExtensionsKt;
import com.android.ttcjpaysdk.base.ktextension.CJSchemaExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.mvp.mvp.MvpModel;
import com.android.ttcjpaysdk.base.service.ICJLynxComponent;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.base.settings.bean.HalfPageHybridConfig;
import com.android.ttcjpaysdk.base.statusbar.CJPayImmersedStatusBarUtils;
import com.android.ttcjpaysdk.base.ui.widget.CJAnnieXWebCard;
import com.android.ttcjpaysdk.base.utils.CJPayAnimationUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.base.utils.CJPayLargeScreenUtils;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
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
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import dc9.d;
import ed4.l;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import v19.f;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000Ë\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\b*\u0001s\b\u0007\u0018\u0000 y2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b:\u0001yB\u0007¢\u0006\u0004\bw\u0010xJ\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J \u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u000bH\u0002J\b\u0010\u001e\u001a\u00020\tH\u0002J\u0016\u0010!\u001a\u00020\u000e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\u001fH\u0002J\b\u0010\"\u001a\u00020\u000eH\u0002J\b\u0010#\u001a\u00020\u000eH\u0002J\u0010\u0010$\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010%\u001a\u00020\u000eH\u0002J\u0010\u0010(\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020&H\u0002J\b\u0010)\u001a\u00020\u000eH\u0002J\u0010\u0010*\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020&H\u0002J\u0016\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010,0+H\u0002J\b\u0010.\u001a\u00020\u0015H\u0002J\u0010\u00100\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u000bH\u0002J\b\u00101\u001a\u00020\u000eH\u0002J\b\u00102\u001a\u00020\u000bH\u0016J\b\u00103\u001a\u00020\tH\u0016J\u0012\u00106\u001a\u00020\u000e2\b\u00105\u001a\u0004\u0018\u000104H\u0014J\b\u00107\u001a\u00020\u000eH\u0014J\b\u00108\u001a\u00020\tH\u0016J\b\u00109\u001a\u00020\tH\u0016J\u0010\u0010:\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010;\u001a\u00020\u000eH\u0016J\b\u0010<\u001a\u00020\u000eH\u0016J\b\u0010=\u001a\u00020\u000eH\u0016J\b\u0010>\u001a\u00020\u000eH\u0016J\b\u0010?\u001a\u00020\u000eH\u0016J\b\u0010@\u001a\u00020\u000eH\u0014J\u0012\u0010C\u001a\u00020\t2\b\u0010B\u001a\u0004\u0018\u00010AH\u0016J\b\u0010D\u001a\u00020\u000eH\u0016J\b\u0010E\u001a\u00020\u000eH\u0014J\b\u0010F\u001a\u00020\u0015H\u0016J\n\u0010H\u001a\u0004\u0018\u00010GH\u0014J\n\u0010J\u001a\u0004\u0018\u00010IH\u0016J\b\u0010K\u001a\u00020\u0015H\u0016J\n\u0010M\u001a\u0004\u0018\u00010LH\u0016J\u001c\u0010Q\u001a\u00020\u000e2\b\u0010N\u001a\u0004\u0018\u00010\u000b2\b\u0010P\u001a\u0004\u0018\u00010OH\u0016J\b\u0010R\u001a\u00020\u000eH\u0016R\u0016\u0010/\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b/\u0010SR\u0016\u0010T\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010V\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bV\u0010SR$\u0010X\u001a\u0004\u0018\u00010W8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R$\u0010_\u001a\u0004\u0018\u00010^8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u0016\u0010e\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010UR\u0018\u0010f\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gRH\u0010l\u001a4\u0012\u0013\u0012\u00110\u000b¢\u0006\f\bi\u0012\b\bj\u0012\u0004\b\b(j\u0012\u0013\u0012\u00110,¢\u0006\f\bi\u0012\b\bj\u0012\u0004\b\b(k\u0012\u0004\u0012\u00020\u000e\u0018\u00010h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0014\u0010o\u001a\u00020n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010q\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0014\u0010t\u001a\u00020s8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010v\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010U¨\u0006z"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/ui/LynxActivity;", "Lcom/android/ttcjpaysdk/base/framework/mvp/MvpBaseLoggerActivity;", "Lcom/android/ttcjpaysdk/base/framework/mvp/nothing/PresentorNothing;", "Lcom/android/ttcjpaysdk/base/framework/mvp/nothing/LoggerNothing;", "Lcom/android/ttcjpaysdk/base/framework/AnimUtil$ILynxAnimView;", "Lcom/android/ttcjpaysdk/base/framework/AnimUtil$ICrossActivityOffscreenTransformGate;", "Led4/l;", "Lcom/android/ttcjpaysdk/base/framework/AnimUtil$IAnimationCallback;", "Lcom/android/ttcjpaysdk/base/ktextension/ICJTag;", "", "isPushAfterLoadSuccess", "", "reason", "shouldRelayoutForPadAdaptPath", "", "sendPadFoldEventToLynx", "Landroid/content/res/Configuration;", "newConfig", "scheduleLynxRelayoutAfterConfiguration", "Landroid/view/View;", "rootView", "", "resolveLynxHostHeight", "hostHeight", "relayoutLynxAnimHostAfterConfiguration", "animContainer", "", "oldTranslationX", "resolveHiddenLynxTranslationX", "getLynxPagePath", "neverBack", "Lkotlin/Function0;", "closeCallback", "closeWithAnim", "closeWithoutAnim", "doCloseAnimOnly", "shouldUseLargeScreenOffscreenGate", "initView", "Lorg/json/JSONObject;", "eventData", "updateContainerHeight", "ready", "containerClose", "", "", "initDataWrapUp", "getSchemaParamsHeight", "schema", "getAppendParamsSchema", "initFallback", "CJTag", "isNeedCloseAnimation", "Landroid/os/Bundle;", "savedInstanceState", WidgetCostModule.TYPE_ON_CREATE, "onPause", "isNeedSetStatusBar", "isActivityPortrait", "onConfigurationChanged", "bindViews", "initData", "initViews", "initActions", TeaEventTrack.ACTION_DRAMA_NEXT, "onResume", "Lcom/android/ttcjpaysdk/base/framework/AnimUtil$IAnimView;", "curPage", "shouldKeepOffscreenAfterCrossActivityPush", "onBackPressed", LiveCommonConstants.REASON_ON_DEDTROY, "getLayoutId", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpModel;", "getModel", "Lcom/android/ttcjpaysdk/base/framework/CJPayAnimRootView;", "getNewAnimView", "getAnimViewHeight", "Landroid/app/Activity;", "getAnimViewContext", "url", "Landroid/webkit/WebView;", "webView", "onLoadUriSuccess", "onStartCallback", "Ljava/lang/String;", "callbackId", "I", "cjInitialProps", "Lcom/android/ttcjpaysdk/base/service/ICJLynxComponent;", "cjLynxComponent", "Lcom/android/ttcjpaysdk/base/service/ICJLynxComponent;", "getCjLynxComponent", "()Lcom/android/ttcjpaysdk/base/service/ICJLynxComponent;", "setCjLynxComponent", "(Lcom/android/ttcjpaysdk/base/service/ICJLynxComponent;)V", "Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXWebCard;", "annieWebCard", "Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXWebCard;", "getAnnieWebCard", "()Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXWebCard;", "setAnnieWebCard", "(Lcom/android/ttcjpaysdk/base/ui/widget/CJAnnieXWebCard;)V", "pageHeight", "animRootView", "Lcom/android/ttcjpaysdk/base/framework/CJPayAnimRootView;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "data", "sendEventToLynx", "Lkotlin/jvm/functions/Function2;", "Landroid/os/Handler;", "fallbackHandler", "Landroid/os/Handler;", "isLoadSuccess", "Z", "com/android/ttcjpaysdk/base/h5/ui/LynxActivity$eventObserver$1", "eventObserver", "Lcom/android/ttcjpaysdk/base/h5/ui/LynxActivity$eventObserver$1;", "schemaParamsHeight", "<init>", "()V", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0})
public final class LynxActivity extends MvpBaseLoggerActivity<PresentorNothing, LoggerNothing> implements AnimUtil.ILynxAnimView, AnimUtil.ICrossActivityOffscreenTransformGate, l, AnimUtil.IAnimationCallback, ICJTag {
    public static final Companion Companion = null;
    public static final String EVENT_CONTENT_HEIGHT = "content_height";
    public static final String EVENT_CONTENT_WIDTH = "content_width";
    public static final String EVENT_NAME = "cjpay_event_name";
    public static final String EVENT_NATIVE_TO_LYNX = "cjpay_lynxcard_common_event_from_native";
    public static final String EVENT_PAD_FOLD = "cjpay_pad_fold";
    public static final String EVENT_SCREEN_HEIGHT = "screen_height";
    public static final String EVENT_SCREEN_WIDTH = "screen_width";
    public static final String LYNX_CARD_COMMENT_EVENT = "cjpay_lynxcard_common_event";
    public static final String TAG = "LynxActivity";
    private CJPayAnimRootView animRootView;
    private CJAnnieXWebCard annieWebCard;
    public int callbackId;
    public String cjInitialProps;
    private ICJLynxComponent cjLynxComponent;
    private final LynxActivity$eventObserver$1 eventObserver;
    private final Handler fallbackHandler;
    private boolean isLoadSuccess;
    private int pageHeight;
    public String schema;
    private int schemaParamsHeight;
    private Function2<? super String, Object, Unit> sendEventToLynx;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/ui/LynxActivity$Companion;", "", "()V", "EVENT_CONTENT_HEIGHT", "", "EVENT_CONTENT_WIDTH", "EVENT_NAME", "EVENT_NATIVE_TO_LYNX", "EVENT_PAD_FOLD", "EVENT_SCREEN_HEIGHT", "EVENT_SCREEN_WIDTH", "LYNX_CARD_COMMENT_EVENT", "TAG", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    public static /* synthetic */ void access$000(MvpBaseLoggerActivity r100, Configuration r101) {
        super.onConfigurationChanged(r101);
    }

    private final void doCloseAnimOnly() {
        AnimUtil.popPage$default(this, null, 2, null);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public String CJTag() {
        return TAG;
    }

    public void com_android_ttcjpaysdk_base_h5_ui_LynxActivity__finish$___twin___() {
        super.finish();
    }

    public void com_android_ttcjpaysdk_base_h5_ui_LynxActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity, com.android.ttcjpaysdk.base.mvp.base.MvpBaseActivity, com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        com_android_ttcjpaysdk_base_h5_ui_LynxActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    @Override // com.android.ttcjpaysdk.base.framework.AnimUtil.IAnimView
    public Activity getAnimViewContext() {
        return this;
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity, com.android.ttcjpaysdk.base.mvp.base.MvpBaseActivity
    public int getLayoutId() {
        return R.layout.cj_pay_lynx_activity;
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity, com.android.ttcjpaysdk.base.mvp.base.MvpBaseActivity
    public MvpModel getModel() {
        return null;
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity
    public void initActions() {
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity
    public void initData() {
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity
    public boolean isNeedCloseAnimation() {
        return false;
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity
    public boolean isNeedSetStatusBar() {
        return false;
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity
    public void next() {
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity, com.android.ttcjpaysdk.base.mvp.base.MvpBaseActivity, com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r100) {
        com_android_ttcjpaysdk_base_h5_ui_LynxActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity, com.android.ttcjpaysdk.base.mvp.base.MvpBaseActivity, com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com_android_ttcjpaysdk_base_h5_ui_LynxActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(this);
    }

    @Override // ed4.l
    public void onLoadStart(String r100, WebView r101) {
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        overridePendingTransition(0, 0);
        super.onPause();
    }

    @Override // ed4.l
    public void onRuntimeReady(String r100, WebView r101) {
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_ttcjpaysdk_base_h5_ui_LynxActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    @Override // ed4.l
    public void onViewDestroy(String r100, WebView r101, Throwable r102) {
    }

    private final String getLynxPagePath() {
        Object r100 = "";
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L21
        String r102 = UriProtector.getQueryParameter(UriProtector.parse(this.schema), "url");     // Catch: Throwable -> L21
        if (r102 != null) goto L6;
    L9:
        boolean r103 = true;
    L11:
        if ((!r103) == true) goto L14;
        r102 = null;
    L14:
        if (r102 != null) goto L16;
        r102 = this.schema;     // Catch: Throwable -> L21
    L16:
        String r104 = UriProtector.parse(r102).getPath();     // Catch: Throwable -> L21
        if (r104 != null) goto L19;
        r104 = "";
    L19:
        String r105 = StringsKt.trimStart(r104, new char[]{'/'});     // Catch: Throwable -> L21
        Object r106 = Result.m9449constructorimpl(StringsKt.substringAfter(r105, "resource/", r105));     // Catch: Throwable -> L21
    L23:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L27;
        CJLogger.c(TAG, "getLynxPagePath error", r107);
    L27:
        if (Result.m9455isFailureimpl(r106) == true) goto L31;
        r100 = r106;
    L31:
        return (String) r100;
    L6:
        if (r102.length() == 0) goto L9;
        r103 = false;
    L21:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    }

    private final int getSchemaParamsHeight() {
        int r100 = this.schemaParamsHeight;
        if (r100 <= 0) goto L5;
        return r100;
    L5:
        String r101 = CJSchemaExtensionKt.getQueryParameter(this.schema, "cjpay_content_height_percent");
        if (r101 == null) goto L8;
        float r102 = CastFloatProtector.parseFloat(r101);
    L9:
        float r103 = (r102 * AnimUtil.getScreenHeight$default(this, true, false, null, 12, null)) / 100.0f;
        if (r103 <= 0.0f) goto L13;
        int r104 = CJPayBasicExtensionKt.px(r103);
        this.schemaParamsHeight = r104;
        return r104;
    L13:
        String r105 = UriProtector.getQueryParameter(UriProtector.parse(this.schema), "cjpay_content_height");
        if (r105 == null) goto L16;
        int r106 = CastIntegerProtector.parseInt(r105);
    L17:
        this.schemaParamsHeight = r106;
        return r106;
    L16:
        r106 = 470;
        goto L17
    L8:
        r102 = 0.0f;
        goto L9
    }

    private final Map<String, Object> initDataWrapUp() {
        JSONObject r100 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r100, "cj_data", KtSafeMethodExtensionKt.safeCreate(this.cjInitialProps).toString());
        KtSafeMethodExtensionKt.safePut(r100, "cjpay_actual_content_height", String.valueOf(getSchemaParamsHeight()));
        return MapsKt.mapOf(TuplesKt.to("cj_initial_props", r100));
    }

    private final void initView() {
        String r100 = com.android.ttcjpaysdk.ktextension.CJSchemaExtensionKt.host(this.schema);
        boolean r101 = false;
        Boolean r102 = null;
        if (r100 == null) goto L5;
        r102 = Boolean.valueOf(StringsKt.contains$default(r100, "webview", false, 2, null));
    L5:
        if (r102 == null) goto L8;
        r101 = r102.booleanValue();
    L8:
        if (r101 == false) goto L20;
        CJPayAnimRootView r103 = getNewAnimView();
        if (r103 == null) goto L13;
        r103.setVisibility(8);
    L13:
        CJAnnieXWebCard r104 = new CJAnnieXWebCard(this);
        this.annieWebCard = r104;
        CJPayAnimRootView r105 = this.animRootView;
        if (r105 == null) goto L16;
        r105.addContainerView(r104, new LinearLayout.LayoutParams(-1, -1));
    L16:
        CJAnnieXWebCard r106 = this.annieWebCard;
        if (r106 == null) goto L28;
        r106.load(new C88632(this));
        return;
    L28:
        return;
    L20:
        final ICJLynxComponent r107 = new CJPayH5Provider().createLynxComponent(this, getAppendParamsSchema(this.schema), this.cjInitialProps, 1, new AnonymousClass3());
        this.cjLynxComponent = r107;
        if (r107 == null) goto L26;
        View r108 = r107.getCJLynxView();
        CJPayAnimRootView r109 = this.animRootView;
        if (r109 == null) goto L25;
        r109.addContainerView(r108, new LinearLayout.LayoutParams(-1, -1));
    L25:
        r107.registerSubscriber(r107.containerId(), System.currentTimeMillis(), "cjpay_lynxcard_common_event", new LynxActivity$initView$4$1(r107, this));
        this.sendEventToLynx = new LynxActivity$initView$4$2(r107);
    L26:
        initFallback();
    }

    private final boolean isPushAfterLoadSuccess() {
        return Intrinsics.areEqual(CJSchemaExtensionKt.getQueryParameter(this.schema, "push_after_load_success"), "1");
    }

    private final boolean neverBack() {
        return Intrinsics.areEqual(CJSchemaExtensionKt.getQueryParameter(this.schema, AnimUtil.NEVER_BACK), "1");
    }

    private final void ready() {
        CJLogger.d(TAG, "ready");
        this.isLoadSuccess = true;
        KtSafeMethodExtensionKt.ifTrue(isPushAfterLoadSuccess(), new C88641(this));
    }

    @Override // com.android.ttcjpaysdk.base.framework.AnimUtil.IAnimView
    public int getAnimViewHeight() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L7
        int r101 = this.pageHeight;     // Catch: Throwable -> L7
        if (r101 <= 0) goto L5;
        return r101;
    L5:
        return getSchemaParamsHeight();
    L7:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return 470;
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Function2<? super String, Object, Unit> r100 = this.sendEventToLynx;
        if (r100 == null) goto L5;
        JSONObject r101 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r101, "cjpay_event_name", "cjpay_container_close");
        KtSafeMethodExtensionKt.safePut(r101, "close_type", "systemBack");
        Unit r102 = Unit.INSTANCE;
        r100.invoke("cjpay_lynxcard_common_event_from_native", r101);
    L5:
        CJAnnieXWebCard r103 = this.annieWebCard;
        if (r103 == null) goto L9;
        JSONObject r104 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r104, "close_type", "systemBack");
        Unit r105 = Unit.INSTANCE;
        r103.sendEvent("cjpay_container_close", r104);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.android.ttcjpaysdk.base.h5.ui.LynxActivity$eventObserver$1] */
    public LynxActivity() {
        this.schema = "";
        this.callbackId = -1;
        this.cjInitialProps = "";
        this.pageHeight = -1;
        this.fallbackHandler = new Handler();
        this.eventObserver = new LynxActivity$eventObserver$1(this);
        this.schemaParamsHeight = -1;
    }

    private final void initFallback() {
        HalfPageHybridConfig r100 = CJPaySettingsManager.getInstance().getHalfPageHybridConfig();
        if (r100 == null) goto L5;
        long r101 = r100.getCloseTimeout();
    L6:
        this.fallbackHandler.postDelayed(new RunnableC88621(this), r101);
        return;
    L5:
        r101 = 5000;
        goto L6
    }

    @Override // com.android.ttcjpaysdk.base.mvp.base.MvpBaseActivity
    public void bindViews() {
        setHalfTranslucent();
        boolean r100 = true;
        CJPayImmersedStatusBarUtils.setWindowStatusBarLightMode(getWindow(), true);
        this.animRootView = (CJPayAnimRootView) findViewById(R.id.anim_root_view);
        if (Intrinsics.areEqual(CJSchemaExtensionKt.getQueryParameter(this.schema, "disable_ntv_bg_color"), "1") == true) goto L9;
        CJPayAnimRootView r101 = this.animRootView;
        if (r101 == null) goto L9;
        FrameLayout r102 = r101.getAnimRootView();
        if (r102 == null) goto L9;
        r102.setBackgroundColor(ColorProtector.parseColor(CJPayAnimationUtils.CJ_PAY_BG_LAYER_COLOR));
    L9:
        Integer r103 = Integer.valueOf(this.callbackId);
        if ((-1) != r103.intValue()) goto L13;
        r100 = false;
    L13:
        if (r100 == true) goto L16;
        r103 = null;
    L16:
        if (r103 == null) goto L19;
        r103.intValue();
        EventManager.INSTANCE.register(this.eventObserver);
        return;
    }

    public void com_android_ttcjpaysdk_base_h5_ui_LynxActivity__onDestroy$___twin___() {
        super.onDestroy();
        EventManager.INSTANCE.unregister(this.eventObserver);
        ICJLynxComponent r100 = this.cjLynxComponent;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        this.fallbackHandler.removeCallbacksAndMessages(null);
        AnimUtil.onActivityDestroy(this);
    }

    @Override // com.android.ttcjpaysdk.base.framework.AnimUtil.IAnimView
    public AnimUtil.AnimGroup getAnimGroup() {
        return AnimUtil.ILynxAnimView.DefaultImpls.getAnimGroup(this);
    }

    @Override // com.android.ttcjpaysdk.base.framework.AnimUtil.IAnimView
    @Deprecated(message = "使用getNewAnimView代替")
    public View getOldRootView() {
        return AnimUtil.ILynxAnimView.DefaultImpls.getOldRootView(this);
    }

    @Override // com.android.ttcjpaysdk.base.framework.BaseActivity
    public boolean isActivityPortrait() {
        CJPaySettingsManager r100 = CJPaySettingsManager.getInstance();
        if (r100.isCashierLargeScreenAdaptEnabled() == true) goto L6;
        CJLogger.d(TAG, "isActivityPortrait lock portrait: cashier large-screen experiment disabled");
        return true;
    L6:
        String r101 = getLynxPagePath();
        boolean r102 = r100.isLynxActivityPadAdaptPath(r101);
        CJLogger.d(TAG, "isActivityPortrait lynxPath=" + r101 + ", isPadAdaptPath=" + r102);
        return !r102;
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity, com.android.ttcjpaysdk.base.mvp.base.MvpBaseActivity, com.android.ttcjpaysdk.base.framework.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        AnimUtil.onResume$default(this, null, 2, null);
    }

    @Override // com.android.ttcjpaysdk.base.framework.AnimUtil.IAnimationCallback
    public void onStartCallback() {
        CJPayAnimRootView r100 = getNewAnimView();
        if (r100 == null) goto L7;
        r100.setVisibility(0);
        return;
    }

    private final void closeWithoutAnim() {
        CJPayKotlinExtensionsKt.finishSafely(this);
    }

    public final CJAnnieXWebCard getAnnieWebCard() {
        return this.annieWebCard;
    }

    public final ICJLynxComponent getCjLynxComponent() {
        return this.cjLynxComponent;
    }

    @Override // com.android.ttcjpaysdk.base.framework.AnimUtil.IAnimView
    public CJPayAnimRootView getNewAnimView() {
        return this.animRootView;
    }

    @Override // com.android.ttcjpaysdk.base.framework.mvp.MvpBaseLoggerActivity
    public void initViews() {
        initView();
    }

    @Override // com.android.ttcjpaysdk.base.framework.AnimUtil.IAnimationCallback
    public void onEndCallback() {
        AnimUtil.IAnimationCallback.DefaultImpls.onEndCallback(this);
    }

    public static View INVOKEVIRTUAL_com_android_ttcjpaysdk_base_h5_ui_LynxActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static final /* synthetic */ void access$closeWithoutAnim(LynxActivity r100) {
        r100.closeWithoutAnim();
    }

    public static final /* synthetic */ Map access$initDataWrapUp(LynxActivity r100) {
        return r100.initDataWrapUp();
    }

    public static final /* synthetic */ boolean access$isLoadSuccess$p(LynxActivity r100) {
        return r100.isLoadSuccess;
    }

    public static final /* synthetic */ void access$ready(LynxActivity r100) {
        r100.ready();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.android.ttcjpaysdk.base.h5.ui.LynxActivity$closeWithAnim$animCallback$1] */
    private final void closeWithAnim(final Function0<Unit> r100) {
        final ?? r101 = new LynxActivity$closeWithAnim$animCallback$1(this, r100);
        KtSafeMethodExtensionKt.ifFalse(KtSafeMethodExtensionKt.ifTrue(neverBack(), new AnonymousClass1(this, r101)), new AnonymousClass2(this, r101));
    }

    public static void com_android_ttcjpaysdk_base_h5_ui_LynxActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(LynxActivity r100) {
        r100.com_android_ttcjpaysdk_base_h5_ui_LynxActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_android_ttcjpaysdk_base_h5_ui_LynxActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static void com_android_ttcjpaysdk_base_h5_ui_LynxActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(LynxActivity r110) {
        r110.com_android_ttcjpaysdk_base_h5_ui_LynxActivity__finish$___twin___();
        if ((r110 instanceof ChatWindowActivity) == false) goto L5;
        return;
    L5:
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(LynxActivity.class.getName()));
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

    public static void com_android_ttcjpaysdk_base_h5_ui_LynxActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(LynxActivity r100) {
        if ((r100 instanceof FragmentActivity) == true) goto L5;
    L7:
        r100.com_android_ttcjpaysdk_base_h5_ui_LynxActivity__onDestroy$___twin___();
        return;
    L5:
        if (WindowUtils.INSTANCE.isMainBotActivity(r100) == false) goto L7;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(r100);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(r100.getClass().getName()));
        goto L7
    }

    private final void containerClose(JSONObject r100) {
        if (Intrinsics.areEqual(r100.optString("close_type"), "background") == false) goto L6;
        doCloseAnimOnly();
        return;
    }

    private final String getAppendParamsSchema(String r100) {
        return CJSchemaExtensionKt.appendQueryParameter(r100, "cjpay_actual_content_height", String.valueOf(getSchemaParamsHeight()));
    }

    private final int resolveLynxHostHeight(View r100) {
        Integer r101 = Integer.valueOf(r100.getHeight());
        boolean r102 = true;
        if (r101.intValue() <= 0) goto L5;
        boolean r103 = true;
    L6:
        Integer r104 = null;
        if (r103 == true) goto L10;
        r101 = null;
    L10:
        if (r101 != null) goto L22;
        Integer r105 = Integer.valueOf(r100.getMeasuredHeight());
        if (r105.intValue() > 0) goto L16;
        r102 = false;
    L16:
        if (r102 == false) goto L18;
        r104 = r105;
    L18:
        if (r104 == null) goto L21;
        return r104.intValue();
    L21:
        return AnimUtil.getScreenHeight$default(this, true, false, BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, 4, null);
    L22:
        return r101.intValue();
    L5:
        r103 = false;
        goto L6
    }

    private final void sendPadFoldEventToLynx(String r110) {
        int r100 = CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(this);
        int r101 = CJPayBasicExtensionKt.px(r100);
        int r102 = CJPayBasicExtensionKt.px(CJPayBasicUtils.getScreenHeight(getApplicationContext()));
        int r103 = CJPayBasicExtensionKt.px(CJPayLargeScreenUtils.resolveCashierVisibleWidthPx(this, r100));
        JSONObject r104 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r104, "cjpay_event_name", "cjpay_pad_fold");
        KtSafeMethodExtensionKt.safePut(r104, "screen_width", Integer.valueOf(r101));
        KtSafeMethodExtensionKt.safePut(r104, "screen_height", Integer.valueOf(r102));
        KtSafeMethodExtensionKt.safePut(r104, "content_width", Integer.valueOf(r103));
        KtSafeMethodExtensionKt.safePut(r104, "content_height", Integer.valueOf(r102));
        StringBuilder r105 = new StringBuilder("send pad fold event to lynx, reason=");
        r105.append(r110);
        r105.append(", screenWidth=");
        r105.append(r101);
        r105.append(", screenHeight=");
        r105.append(r102);
        r105.append(", contentHeight=");
        r105.append(r102);
        r105.append(", contentWidth=");
        r105.append(r103);
        r105.append(", hasLynxSender=");
        boolean r111 = true;
        if (this.sendEventToLynx == null) goto L5;
        boolean r112 = true;
    L6:
        r105.append(r112);
        r105.append(", hasAnnieCard=");
        if (this.annieWebCard != null) goto L10;
        r111 = false;
    L10:
        r105.append(r111);
        CJLogger.d(TAG, r105.toString());
        Function2<? super String, Object, Unit> r113 = this.sendEventToLynx;
        if (r113 == null) goto L13;
        r113.invoke("cjpay_lynxcard_common_event_from_native", r104);
    L13:
        CJAnnieXWebCard r114 = this.annieWebCard;
        if (r114 == null) goto L17;
        JSONObject r106 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r106, "screen_width", Integer.valueOf(r101));
        KtSafeMethodExtensionKt.safePut(r106, "screen_height", Integer.valueOf(r102));
        KtSafeMethodExtensionKt.safePut(r106, "content_width", Integer.valueOf(r103));
        KtSafeMethodExtensionKt.safePut(r106, "content_height", Integer.valueOf(r102));
        Unit r107 = Unit.INSTANCE;
        r114.sendEvent("cjpay_pad_fold", r106);
        return;
    L17:
        return;
    L5:
        r112 = false;
        goto L6
    }

    private final boolean shouldRelayoutForPadAdaptPath(String r100) {
        CJPaySettingsManager r101 = CJPaySettingsManager.getInstance();
        if (r101.isCashierLargeScreenAdaptEnabled() == true) goto L6;
        CJLogger.d(TAG, "skip lynx relayout: experiment disabled, reason=" + r100);
        return false;
    L6:
        String r102 = getLynxPagePath();
        boolean r103 = r101.isLynxActivityPadAdaptPath(r102);
        CJLogger.d(TAG, "shouldRelayoutForPadAdaptPath reason=" + r100 + ", lynxPath=" + r102 + ", isPadAdaptPath=" + r103);
        return r103;
    }

    private final boolean shouldUseLargeScreenOffscreenGate(String r100) {
        if (shouldRelayoutForPadAdaptPath(r100) == true) goto L6;
        return false;
    L6:
        boolean r101 = CJPayLargeScreenUtils.isLargeScreen(this, this.animRootView);
        CJLogger.d(TAG, "shouldUseLargeScreenOffscreenGate reason=" + r100 + ", isLargeScreen=" + r101);
        return r101;
    }

    private final void updateContainerHeight(JSONObject r100) {
        this.pageHeight = r100.optInt("height", -1);
    }

    public void com_android_ttcjpaysdk_base_h5_ui_LynxActivity__onCreate$___twin___(Bundle r100) {
        super.onCreate(r100);
        setStatusBarColor("#00000000");
        String r101 = com.android.ttcjpaysdk.ktextension.CJSchemaExtensionKt.host(this.schema);
        boolean r102 = false;
        if (r101 == null) goto L5;
        Boolean r103 = Boolean.valueOf(StringsKt.contains$default(r101, "webview", false, 2, null));
    L6:
        if (r103 == null) goto L8;
        r102 = r103.booleanValue();
    L8:
        if (r102 == false) goto L10;
        return;
    L10:
        if (isPushAfterLoadSuccess() == true) goto L14;
        AnimUtil.pushPage$default(this, null, 2, null);
        return;
    L14:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void d(String r100) {
        ICJTag.DefaultImpls.d(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void i(String r100) {
        ICJTag.DefaultImpls.i(this, r100);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        INVOKESPECIAL_com_android_ttcjpaysdk_base_h5_ui_LynxActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(this, r100);
        if (shouldRelayoutForPadAdaptPath("activity_config_changed") == true) goto L5;
        return;
    L5:
        sendPadFoldEventToLynx("activity_config_changed");
        scheduleLynxRelayoutAfterConfiguration(r100, "activity_config_changed");
    }

    @Override // com.android.ttcjpaysdk.base.framework.AnimUtil.IAnimationCallback
    public void onError(AnimUtil.ErrorType r100) {
        AnimUtil.IAnimationCallback.DefaultImpls.onError(this, r100);
    }

    public final void setAnnieWebCard(CJAnnieXWebCard r100) {
        this.annieWebCard = r100;
    }

    public final void setCjLynxComponent(ICJLynxComponent r100) {
        this.cjLynxComponent = r100;
    }

    @Override // com.android.ttcjpaysdk.base.framework.AnimUtil.ICrossActivityOffscreenTransformGate
    public boolean shouldKeepOffscreenAfterCrossActivityPush(AnimUtil.IAnimView r100) {
        boolean r101 = shouldUseLargeScreenOffscreenGate("keep_offscreen_after_cross_activity_push");
        StringBuilder r102 = new StringBuilder("shouldKeepOffscreenAfterCrossActivityPush shouldKeepOffscreen=");
        r102.append(r101);
        r102.append(", curPage=");
        if (r100 == null) goto L5;
        String r103 = r100.getClass().getSimpleName();
    L6:
        r102.append(r103);
        CJLogger.d(TAG, r102.toString());
        return r101;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void w(String r100) {
        ICJTag.DefaultImpls.w(this, r100);
    }

    public static void INVOKESPECIAL_com_android_ttcjpaysdk_base_h5_ui_LynxActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(MvpBaseLoggerActivity r100, Configuration r101) {
        access$000(r100, r101);
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

    public static final /* synthetic */ void access$closeWithAnim(LynxActivity r100, Function0 r101) {
        r100.closeWithAnim(r101);
    }

    public static final /* synthetic */ void access$containerClose(LynxActivity r100, JSONObject r101) {
        r100.containerClose(r101);
    }

    public static final /* synthetic */ int access$resolveLynxHostHeight(LynxActivity r100, View r101) {
        return r100.resolveLynxHostHeight(r101);
    }

    public static final /* synthetic */ void access$updateContainerHeight(LynxActivity r100, JSONObject r101) {
        r100.updateContainerHeight(r101);
    }

    public static void com_android_ttcjpaysdk_base_h5_ui_LynxActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(LynxActivity r100, Bundle r101) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(r100.getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(r100) == false) goto L8;
        f.c(r100.getTheme());     // Catch: Throwable -> L10
    L8:
        r100.com_android_ttcjpaysdk_base_h5_ui_LynxActivity__onCreate$___twin___(r101);
    }

    private final float resolveHiddenLynxTranslationX(View r100, float r101) {
        View r102 = r100.getRootView();
        if (r102 == null) goto L5;
        int r103 = r102.getWidth();
    L6:
        int r104 = Math.max(r103, Math.max(r100.getWidth(), CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(this))) + 2;
        if (r101 <= 0.0f) goto L9;
        float r105 = 1.0f;
    L10:
        float r106 = r105 * r104;
        CJLogger.d(TAG, "resolveHiddenLynxTranslationX rootWidth=" + r103 + ", containerWidth=" + r100.getWidth() + ", fullWidth=" + r104 + ", oldTranslationX=" + r101 + ", targetTranslationX=" + r106);
        return r106;
    L9:
        r105 = -1.0f;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    private final void scheduleLynxRelayoutAfterConfiguration(final Configuration r100, final String r101) {
        CJPayAnimRootView r102 = this.animRootView;
        if (r102 == null) goto L6;
        final FrameLayout r103 = r102.getAnimRootView();
        if (r103 == null) goto L6;
    L8:
        if (r103 != null) goto L11;
        CJLogger.e(TAG, "skip lynx relayout: rootView is null, reason=" + r101);
        return;
    L11:
        this.schemaParamsHeight = -1;
        CJPayLargeScreenUtils.scheduleRelayoutAfterNextLayout(r103, TAG, new C88651(r103, this, r100, r101));
        return;
    L6:
        r103 = this.animRootView;
        goto L8
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void e(String r100, Throwable r101) {
        ICJTag.DefaultImpls.e(this, r100, r101);
    }

    @Override // ed4.l
    public void onLoadUriSuccess(String r100, WebView r101) {
        AnimUtil.pushPage(this, this);
    }

    private final void relayoutLynxAnimHostAfterConfiguration(int r100, Configuration r101, String r110) {
        if (r100 > 0) goto L6;
        CJLogger.e(TAG, "skip lynx relayout: invalid hostHeight=" + r100 + ", reason=" + r110);
        return;
    L6:
        CJPayAnimRootView r102 = getNewAnimView();
        ViewGroup.LayoutParams r103 = null;
        if (r102 == null) goto L9;
        LinearLayout r104 = r102.getContainerView();
    L10:
        if (r104 == null) goto L12;
        r103 = r104.getLayoutParams();
    L12:
        if (r104 == null) goto L25;
        if (r103 == null) goto L25;
        boolean r105 = AnimUtil.isTop(this);
        float r106 = r104.getTranslationX();
        CJLogger.d(TAG, "relayout lynx anim host, reason=" + r110 + ", orientation=" + r101.orientation + ", hostHeight=" + r100 + ", oldContainerHeight=" + r104.getHeight() + ", oldLayoutHeight=" + r103.height + ", oldTranslationX=" + r106 + ", isTopPage=" + r105);
        if (r103.height == r100) goto L18;
        r103.height = r100;
        r104.setLayoutParams(r103);
    L18:
        if (r105 == false) goto L20;
        r104.setTranslationX(0.0f);
        r104.setTranslationY(0.0f);
    L21:
        r104.requestLayout();
        CJPayAnimRootView r107 = this.animRootView;
        if (r107 == null) goto L27;
        r107.requestLayout();
        return;
    L27:
        return;
    L20:
        r104.setTranslationX(resolveHiddenLynxTranslationX(r104, r106));
        CJLogger.d(TAG, "keep hidden lynx offscreen, reason=" + r110 + ", oldTranslationX=" + r106 + ", targetTranslationX=" + r104.getTranslationX());
    L25:
        CJLogger.e(TAG, "skip lynx relayout: animContainer is null, reason=" + r110);
        return;
    L9:
        r104 = null;
        goto L10
    }

    @Override // ed4.l
    public void onLoadFail(String r100, WebView r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r102, "e");
    }

    public static final /* synthetic */ void access$relayoutLynxAnimHostAfterConfiguration(LynxActivity r100, int r101, Configuration r102, String r103) {
        r100.relayoutLynxAnimHostAfterConfiguration(r101, r102, r103);
    }
}
