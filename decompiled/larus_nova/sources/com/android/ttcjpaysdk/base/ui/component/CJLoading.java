package com.android.ttcjpaysdk.base.ui.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPaySecurityLoadingService;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.base.ui.Utils.CJPayDyBrandLoadingUtils;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.caijing.sdk.infra.base.task.b;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 G2\u00020\u0001:\u0001GB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0005\u001a\u00020\u00062%\b\u0002\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bJ\u0006\u0010\r\u001a\u00020\u0006J-\u0010\u000e\u001a\u00020\u00062%\b\u0002\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bJ-\u0010\u000f\u001a\u00020\u00062%\b\u0002\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bJ\r\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\tJ\u0006\u0010\u0013\u001a\u00020\tJ\u0006\u0010\u0014\u001a\u00020\tJ\u0006\u0010\u0015\u001a\u00020\u0006J\u0010\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0092\u0001\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2%\b\u0002\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010$\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020\t¢\u0006\u0002\u0010&J\u0092\u0001\u0010'\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010(\u001a\u00020\t2\b\b\u0002\u0010)\u001a\u00020\t2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\t2%\b\u0002\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0002\u0010-J\u001f\u0010.\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010!¢\u0006\u0002\u00100Jô\u0001\u00101\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\n\b\u0002\u00104\u001a\u0004\u0018\u0001032%\b\u0002\u00105\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0006\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00182%\b\u0002\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\n\b\u0002\u00106\u001a\u0004\u0018\u0001032\b\b\u0002\u00107\u001a\u00020\t2\b\b\u0002\u00108\u001a\u00020!2\b\b\u0002\u0010(\u001a\u00020\t2\b\b\u0002\u00109\u001a\u00020\t2\b\b\u0002\u0010:\u001a\u00020;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\b\b\u0002\u0010>\u001a\u00020\t2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0018J.\u0010?\u001a\u00020\u00062\b\u0010@\u001a\u0004\u0018\u00010\u00182\b\u0010A\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010B\u001a\u00020!2\b\b\u0002\u0010C\u001a\u00020\tJ\u0018\u0010D\u001a\u00020\u00062\u0010\b\u0002\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010FR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/CJLoading;", "", "()V", "securityLoadingService", "Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService;", "dismissDialogViewLoading", "", "extraTask", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", BaseHttpRequestInfo.KEY_HIT, "dismissStdDoubleColorBallLoading", "hideCustomPanelViewLoading", "hideStdPanelLoading", "isDialogLoadingViewShowing", "()Ljava/lang/Boolean;", "isNeedUseNewLoading", "isPanelLoadingShowing", "isValidSecurityInfo", "release", "setSecurityLoadingInfo", "securityLoadingInfo", "", "showCustomPanelViewLoading", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "scene", "Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService$SecurityLoadingScene;", "loadingInfo", "specialCopyWrite", "loadingTimeout", "", "containerHeightDip", "url", "showWatermark", "isReuse", "(Landroid/content/Context;Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService$SecurityLoadingScene;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Ljava/lang/Integer;Ljava/lang/String;ZZ)Z", "showDialogViewLoading", "degrade", "isPayNewCard", "customScene", "Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService$LoadingCustomScene;", "isBgTrans", "(Landroid/content/Context;Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService$SecurityLoadingScene;Ljava/lang/String;Ljava/lang/String;ZZLcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService$LoadingCustomScene;Ljava/lang/Integer;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;)Z", "showStdDoubleColorBallLoading", "timeout", "(Landroid/content/Context;Ljava/lang/Integer;)V", "showStdPanelLoading", "panelView", "Landroid/view/View;", "contentView", "defaultLoadingTask", "titleBarView", "special", "containerHeightDipParam", "isHidePre", "percent", "", "layoutParam", "Landroid/view/ViewGroup$LayoutParams;", "needLayoutCenter", "updateDialogLoadingStatus", "msg", "subMsg", "iconType", "shouldCloseAfterDelayTime", "updateSecurityLoadingAfterPayFinish", "performTask", "Lkotlin/Function0;", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJLoading {
    public static final Companion Companion = null;
    private static final String TAG = "CJPaySecurityLoadingComponent";
    private static volatile CJLoading instance;
    private ICJPaySecurityLoadingService securityLoadingService;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/CJLoading$Companion;", "", "()V", "TAG", "", "instance", "Lcom/android/ttcjpaysdk/base/ui/component/CJLoading;", "getInstance", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final CJLoading getInstance() {
            CJLoading r100 = CJLoading.access$getInstance$cp();
            if (r100 != null) goto L13;
            monitor-enter(this);
            r100 = CJLoading.access$getInstance$cp();     // Catch: Throwable -> L10
            if (r100 != null) goto L8;
            r100 = new CJLoading(null);     // Catch: Throwable -> L10
            CJLoading.access$setInstance$cp(r100);     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r100;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ CJLoading(DefaultConstructorMarker r100) {
        this();
    }

    public final void dismissStdDoubleColorBallLoading() {
        CJPayDyBrandLoadingUtils.INSTANCE.hideLoading();
    }

    public final Boolean isDialogLoadingViewShowing() {
        ICJPaySecurityLoadingService r100 = this.securityLoadingService;
        if (r100 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r100.isDialogLoadingViewShowing());
    }

    public final boolean isPanelLoadingShowing() {
        ICJPaySecurityLoadingService r100 = this.securityLoadingService;
        if (r100 == null) goto L5;
        Boolean r101 = Boolean.valueOf(r100.isPanelLoadingShowing());
    L6:
        if (r101 != null) goto L10;
        return false;
    L10:
        return r101.booleanValue();
    L5:
        r101 = null;
        goto L6
    }

    public final boolean isValidSecurityInfo() {
        ICJPaySecurityLoadingService r100 = this.securityLoadingService;
        if (r100 == null) goto L5;
        Boolean r101 = Boolean.valueOf(r100.isValidInfoSupportShow());
    L6:
        if (r101 != null) goto L10;
        return false;
    L10:
        return r101.booleanValue();
    L5:
        r101 = null;
        goto L6
    }

    public final void release() {
        ICJPaySecurityLoadingService r100 = this.securityLoadingService;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        this.securityLoadingService = null;
    }

    private CJLoading() {
        this.securityLoadingService = (ICJPaySecurityLoadingService) CJPayServiceManager.getInstance().getIService(ICJPaySecurityLoadingService.class);
    }

    public final boolean isNeedUseNewLoading() {
        return StringsKt.equals(BdpAppEventConstant.YES, CJPaySettingsManager.getInstance().getSettingsInfo("cjpay_gray_use_new_loading"), true);
    }

    public static final /* synthetic */ CJLoading access$getInstance$cp() {
        return instance;
    }

    public static final /* synthetic */ void access$setInstance$cp(CJLoading r100) {
        instance = r100;
    }

    public final void dismissDialogViewLoading(Function1<? super Boolean, Unit> r100) {
        ICJPaySecurityLoadingService r101 = this.securityLoadingService;
        if (r101 == null) goto L5;
        r101.hideDiaLogViewLoading();
    L5:
        if (r100 == null) goto L8;
        r100.invoke(Boolean.TRUE);
        return;
    }

    public final void hideCustomPanelViewLoading(Function1<? super Boolean, Unit> r100) {
        ICJPaySecurityLoadingService r101 = this.securityLoadingService;
        if (r101 == null) goto L5;
        r101.hideCustomPanelViewLoading();
    L5:
        if (r100 == null) goto L8;
        r100.invoke(Boolean.TRUE);
        return;
    }

    public final void hideStdPanelLoading(Function1<? super Boolean, Unit> r100) {
        ICJPaySecurityLoadingService r101 = this.securityLoadingService;
        if (r101 == null) goto L5;
        r101.hidePanelLoading();
    L5:
        if (r100 == null) goto L8;
        r100.invoke(Boolean.TRUE);
        return;
    }

    public final void setSecurityLoadingInfo(String r100) {
        ICJPaySecurityLoadingService r101 = this.securityLoadingService;
        if (r101 == null) goto L6;
        r101.setSecurityLoadingInfo(r100);
        return;
    }

    public final void updateSecurityLoadingAfterPayFinish(final Function0<Unit> r100) {
        CJLogger.d(TAG, "updateSecurityLoadingAfterPayFinish");
        ICJPaySecurityLoadingService r101 = this.securityLoadingService;
        Unit r102 = null;
        if (r101 != null) goto L5;
    L15:
        if (r102 != null) goto L20;
        if (r100 == null) goto L18;
        r100.invoke();
    L18:
        CJLogger.d(TAG, "updateSecurityLoadingAfterPayFinish run performTask?.invoke()");
        return;
    L20:
        return;
    L5:
        if (isValidSecurityInfo() == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L15;
        if (r101.notifyPayEnd(new CJLoading$updateSecurityLoadingAfterPayFinish$2$callBack$1(r100)) == true) goto L14;
        CJLogger.d(TAG, "updateSecurityLoadingAfterPayFinish !it.notifyPayEnd(callBack)");
        if (r100 == null) goto L14;
        r100.invoke();
    L14:
        r102 = Unit.INSTANCE;
        goto L15
    }

    public final void showStdDoubleColorBallLoading(Context r100, Integer r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        CJPayDyBrandLoadingUtils.showOldLoading$default(CJPayDyBrandLoadingUtils.INSTANCE, r100, false, null, r110, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void dismissDialogViewLoading$default(CJLoading r100, Function1 r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = null;
    L5:
        r100.dismissDialogViewLoading(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void hideCustomPanelViewLoading$default(CJLoading r100, Function1 r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = null;
    L5:
        r100.hideCustomPanelViewLoading(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void hideStdPanelLoading$default(CJLoading r100, Function1 r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = null;
    L5:
        r100.hideStdPanelLoading(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateSecurityLoadingAfterPayFinish$default(CJLoading r100, Function0 r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = null;
    L5:
        r100.updateSecurityLoadingAfterPayFinish(r101);
    }

    public final void updateDialogLoadingStatus(String r100, String r101, int r102, boolean r103) {
        Boolean r104 = isDialogLoadingViewShowing();
        if (r104 == null) goto L5;
        boolean r105 = r104.booleanValue();
    L6:
        if (r105 == false) goto L13;
        ICJPaySecurityLoadingService r106 = this.securityLoadingService;
        if (r106 == null) goto L10;
        r106.updateDialogViewStatusForReuse(r100, r101, r102);
    L10:
        if (r103 == false) goto L14;
        b.g(new AnonymousClass1(this), 3000);
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r105 = false;
        goto L6
    }

    public static /* synthetic */ void showStdDoubleColorBallLoading$default(CJLoading r100, Context r101, Integer r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = -1;
    L5:
        r100.showStdDoubleColorBallLoading(r101, r102);
    }

    public static /* synthetic */ void updateDialogLoadingStatus$default(CJLoading r100, String r101, String r102, int r103, boolean r104, int r105, Object r106) {
        if ((r105 & 4) == 0) goto L6;
        r103 = 0;
    L6:
        if ((r105 & 8) == 0) goto L8;
        r104 = false;
    L8:
        r100.updateDialogLoadingStatus(r101, r102, r103, r104);
    }

    public final boolean showCustomPanelViewLoading(Context r110, ICJPaySecurityLoadingService.SecurityLoadingScene r111, String r112, String r113, Integer r114, Function1<? super Boolean, Unit> r115, Integer r116, String r210, boolean r211, boolean r212) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "scene");
        ICJPaySecurityLoadingService r100 = this.securityLoadingService;
        if (r100 == null) goto L11;
        if (r113 != null) goto L6;
        String r101 = "";
    L7:
        if (r116 == null) goto L9;
        int r102 = r116.intValue();
    L10:
        boolean r103 = r100.showCustomPanelViewLoading(r110, r111, r112, r101, r114, r102, r210, r211, r212);
    L12:
        if (r115 == null) goto L14;
        r115.invoke(Boolean.TRUE);
    L14:
        return r103;
    L9:
        r102 = 420;
        goto L10
    L6:
        r101 = r113;
        goto L7
    L11:
        r103 = false;
        goto L12
    }

    public final boolean showDialogViewLoading(Context r110, ICJPaySecurityLoadingService.SecurityLoadingScene r111, String r112, String r113, boolean r114, boolean r115, ICJPaySecurityLoadingService.LoadingCustomScene r116, Integer r210, Boolean r211, Function1<? super Boolean, Unit> r212) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "scene");
        ICJPaySecurityLoadingService r100 = this.securityLoadingService;
        if (r100 == null) goto L8;
        if (r113 != null) goto L6;
        String r101 = "";
    L7:
        boolean r102 = r100.showStdDialogViewLoading(r110, r111, r112, r101, r114, r115, r116, r210, r211);
    L9:
        if (r212 == null) goto L11;
        r212.invoke(Boolean.TRUE);
    L11:
        return r102;
    L6:
        r101 = r113;
        goto L7
    L8:
        r102 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean showCustomPanelViewLoading$default(CJLoading r110, Context r111, ICJPaySecurityLoadingService.SecurityLoadingScene r112, String r113, String r114, Integer r115, Function1 r210, Integer r211, String r212, boolean r213, boolean r214, int r215, Object r216) {
        if ((r215 & 4) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r215 & 8) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r215 & 16) == 0) goto L13;
        Integer r102 = -1;
    L15:
        if ((r215 & 32) == 0) goto L17;
        Function1 r103 = null;
    L19:
        if ((r215 & 64) == 0) goto L21;
        Integer r116 = 420;
    L23:
        if ((r215 & 128) == 0) goto L25;
        String r117 = null;
    L27:
        if ((r215 & 256) == 0) goto L29;
        boolean r118 = true;
    L31:
        if ((r215 & 512) == 0) goto L33;
        boolean r119 = false;
    L35:
        return r110.showCustomPanelViewLoading(r111, r112, r100, r101, r102, r103, r116, r117, r118, r119);
    L33:
        r119 = r214;
        goto L35
    L29:
        r118 = r213;
        goto L31
    L25:
        r117 = r212;
        goto L27
    L21:
        r116 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r115;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean showDialogViewLoading$default(CJLoading r110, Context r111, ICJPaySecurityLoadingService.SecurityLoadingScene r112, String r113, String r114, boolean r115, boolean r210, ICJPaySecurityLoadingService.LoadingCustomScene r211, Integer r212, Boolean r213, Function1 r214, int r215, Object r216) {
        if ((r215 & 4) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r215 & 8) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r215 & 16) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r215 & 32) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r215 & 64) == 0) goto L21;
        ICJPaySecurityLoadingService.LoadingCustomScene r116 = null;
    L23:
        if ((r215 & 128) == 0) goto L25;
        Integer r117 = -1;
    L27:
        if ((r215 & 256) == 0) goto L29;
        Boolean r118 = Boolean.TRUE;
    L31:
        if ((r215 & 512) == 0) goto L33;
        Function1 r119 = null;
    L35:
        return r110.showDialogViewLoading(r111, r112, r100, r101, r102, r103, r116, r117, r118, r119);
    L33:
        r119 = r214;
        goto L35
    L29:
        r118 = r213;
        goto L31
    L25:
        r117 = r212;
        goto L27
    L21:
        r116 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r115;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }

    public final void showStdPanelLoading(Context r210, View r211, View r212, Function1<? super Boolean, Unit> r213, ICJPaySecurityLoadingService.SecurityLoadingScene r214, String r215, Function1<? super Boolean, Unit> r216, View r217, boolean r218, int r310, boolean r311, boolean r312, float r313, ViewGroup.LayoutParams r314, ICJPaySecurityLoadingService.LoadingCustomScene r315, boolean r316, String r317) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r214, "scene");
        StringBuilder r100 = new StringBuilder("showStdPanelLoading ,sceneDes:");
        r100.append(r214.getSceneDes());
        r100.append(",customScene:");
        Boolean r101 = null;
        if (r315 == null) goto L5;
        String r102 = r315.getScene();
    L6:
        r100.append(r102);
        CJLogger.d(TAG, r100.toString());
        if (r212 == null) goto L9;
        FrameLayout r103 = (FrameLayout) r212.findViewById(R.id.cj_pay_security_panel_loading_container);
    L10:
        boolean r104 = r103 instanceof ViewGroup;
        boolean r110 = false;
        if (r104 == true) goto L13;
    L19:
        if (r215 == null) goto L72;
        String r105 = r215;
    L26:
        if ((r103 instanceof ViewGroup) == false) goto L29;
        ViewGroup r111 = r103;
    L32:
        int r112 = r310;
        if (r112 == (-1)) goto L35;
    L38:
        if (r111 == null) goto L52;
        ICJPaySecurityLoadingService r106 = this.securityLoadingService;     // Catch: Throwable -> L64
        if (r106 == null) goto L42;
        Boolean r107 = Boolean.valueOf(r106.isUniform());     // Catch: Throwable -> L64
    L43:
        if (r107 == null) goto L45;
        boolean r108 = r107.booleanValue();     // Catch: Throwable -> L64
    L46:
        if (r108 == false) goto L52;
        ICJPaySecurityLoadingService r109 = this.securityLoadingService;     // Catch: Throwable -> L64
        if (r109 == null) goto L50;
        r101 = Boolean.valueOf(r109.showPanelLoading(r210, r214, r105, r111, r112, r313, r311, true, r316, r312, Boolean.TRUE, r317));     // Catch: Throwable -> L64
    L50:
        if (r101 == null) goto L66;
        boolean r113 = r101.booleanValue();     // Catch: Throwable -> L64
    L63:
        r110 = r113;
    L66:
        if (r110 == true) goto L69;
        if (r213 == null) goto L73;
        r213.invoke(Boolean.valueOf(r104));
        return;
    L73:
        return;
    L69:
        if (r216 == null) goto L75;
        r216.invoke(Boolean.valueOf(r104));
        return;
    L75:
        return;
    L45:
        r108 = false;
        goto L46
    L42:
        r107 = null;
    L52:
        if (r218 == false) goto L58;
        ICJPaySecurityLoadingService r114 = this.securityLoadingService;     // Catch: Throwable -> L64
        if (r114 == null) goto L56;
        r101 = Boolean.valueOf(r114.showPanelLoadingForSpecial(r210, r214, r105, r111, r314, r311, false, Boolean.TRUE));     // Catch: Throwable -> L64
    L56:
        if (r101 == null) goto L66;
        r113 = r101.booleanValue();     // Catch: Throwable -> L64
        goto L63
    L58:
        ICJPaySecurityLoadingService r115 = this.securityLoadingService;     // Catch: Throwable -> L64
        if (r115 == null) goto L61;
        r101 = Boolean.valueOf(r115.showPanelLoadingForCommon(r210, r214, r105, r111, r112, r311, false, Boolean.TRUE));     // Catch: Throwable -> L64
    L61:
        if (r101 == null) goto L66;
        r113 = r101.booleanValue();     // Catch: Throwable -> L64
        goto L63
    L35:
        if ((r103 instanceof ViewGroup) == false) goto L37;
        r112 = 0;
        goto L38
    L37:
        r112 = 470;
        goto L38
    L29:
        if ((r211 instanceof ViewGroup) == false) goto L31;
        r111 = (ViewGroup) r211;     // Catch: Throwable -> L64
        goto L32
    L31:
        r111 = null;
        goto L32
    L72:
        ICJPaySecurityLoadingService r116 = this.securityLoadingService;     // Catch: Throwable -> L64
        if (r116 == null) goto L23;
        r105 = r116.getSecurityLoadingInfo();     // Catch: Throwable -> L64
        goto L26
    L23:
        r105 = null;
    L64:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJLoading#showStdPanelLoading", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJLoading#showStdPanelLoading", th);
        goto L66
    L13:
        if (r313 != 0.2f) goto L15;
        boolean r117 = true;
    L16:
        if (r117 == false) goto L19;
        if (r217 == null) goto L19;
        CJPayViewExtensionsKt.viewInvisible(r217);
        goto L19
    L15:
        r117 = false;
        goto L16
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showStdPanelLoading$default(CJLoading r210, Context r211, View r212, View r213, Function1 r214, ICJPaySecurityLoadingService.SecurityLoadingScene r215, String r216, Function1 r217, View r218, boolean r310, int r311, boolean r312, boolean r313, float r314, ViewGroup.LayoutParams r315, ICJPaySecurityLoadingService.LoadingCustomScene r316, boolean r317, String r318, int r319, Object r410) {
        if ((r319 & 2) == 0) goto L5;
        View r100 = null;
    L7:
        if ((r319 & 4) == 0) goto L9;
        View r101 = null;
    L11:
        if ((r319 & 8) == 0) goto L13;
        Function1 r102 = null;
    L15:
        if ((r319 & 32) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r319 & 64) == 0) goto L21;
        Function1 r110 = null;
    L23:
        if ((r319 & 128) == 0) goto L25;
        View r111 = null;
    L27:
        if ((r319 & 256) == 0) goto L29;
        boolean r112 = false;
    L31:
        if ((r319 & 512) == 0) goto L33;
        int r113 = -1;
    L35:
        if ((r319 & 1024) == 0) goto L37;
        boolean r114 = false;
    L39:
        if ((r319 & 2048) == 0) goto L41;
        boolean r115 = true;
    L43:
        if ((r319 & 4096) == 0) goto L45;
        float r116 = 0.26f;
    L47:
        if ((r319 & 8192) == 0) goto L49;
        ViewGroup.LayoutParams r117 = null;
    L51:
        if ((r319 & 16384) == 0) goto L53;
        ICJPaySecurityLoadingService.LoadingCustomScene r118 = null;
    L55:
        if ((32768 & r319) == 0) goto L57;
        boolean r119 = false;
    L59:
        if ((r319 & 65536) == 0) goto L61;
        String r219 = null;
    L62:
        r210.showStdPanelLoading(r211, r100, r101, r102, r215, r103, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r219);
        return;
    L61:
        r219 = r318;
        goto L62
    L57:
        r119 = r317;
        goto L59
    L53:
        r118 = r316;
        goto L55
    L49:
        r117 = r315;
        goto L51
    L45:
        r116 = r314;
        goto L47
    L41:
        r115 = r313;
        goto L43
    L37:
        r114 = r312;
        goto L39
    L33:
        r113 = r311;
        goto L35
    L29:
        r112 = r310;
        goto L31
    L25:
        r111 = r218;
        goto L27
    L21:
        r110 = r217;
        goto L23
    L17:
        r103 = r216;
        goto L19
    L13:
        r102 = r214;
        goto L15
    L9:
        r101 = r213;
        goto L11
    L5:
        r100 = r212;
        goto L7
    }
}
