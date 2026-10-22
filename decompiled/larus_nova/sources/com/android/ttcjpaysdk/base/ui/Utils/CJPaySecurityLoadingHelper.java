package com.android.ttcjpaysdk.base.ui.Utils;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPaySecurityLoadingService;
import com.android.ttcjpaysdk.base.ui.component.CJLoading;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 =2\u00020\u0001:\u0001=B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u001bJ\b\u0010\u001e\u001a\u00020\u001bH\u0007J\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010 \u001a\u00020\u0019J\u0010\u0010!\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010\u0011J9\u0010#\u001a\u00020\u001b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010'Jè\u0001\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b26\u0010*\u001a2\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u00190+2\u0006\u00100\u001a\u0002012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00112:\b\u0002\u00102\u001a4\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u0019\u0018\u00010+2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u00104\u001a\u00020\u001b2\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u00020\u001b2\b\b\u0002\u00108\u001a\u00020\u001b2\b\b\u0002\u00109\u001a\u00020\u001b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0018\u0010:\u001a\u00020\u00192\u0010\b\u0002\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010<R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/Utils/CJPaySecurityLoadingHelper;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "contentView", "Landroid/view/View;", "panelView", "percent", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "(Landroid/content/Context;Landroid/view/View;Landroid/view/View;FLandroid/view/ViewGroup$LayoutParams;)V", "securityLoadingContainer", "Landroid/widget/FrameLayout;", "securityLoadingService", "Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService;", "getLoadingInfo", "", "getSecurityLoadingMinTime", "", "customScene", "Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService$LoadingCustomScene;", "(Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService$LoadingCustomScene;)Ljava/lang/Long;", "getSecurityLoadingMsg", "hideDialogLoading", "", "isHitLoadingUniform", "", "isDialogLoading", "isPanelLoadingShowing", "isValidSecurityInfo", "notifyUpdate", "release", "setSecurityLoadingInfo", "securityLoadingInfo", "showDialogLoading", "text", "loadingInfo", "isBgTrans", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Z", "showSecurityLoading", "isShow", "defaultLoadingTask", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "show", BaseHttpRequestInfo.KEY_HIT, "scene", "Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService$SecurityLoadingScene;", "extraTask", "titleBarView", "special", "containerHeightDip", "", "degrade", "isPayNewCard", "isHidePre", "updateSecurityLoadingAfterPayFinish", "performTask", "Lkotlin/Function0;", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPaySecurityLoadingHelper {
    public static final Companion Companion = null;
    private static final String TAG = "CJPaySecurityLoadingHel";
    private static boolean isDismissDialogLocked;
    private final Context context;
    private final View panelView;
    private final ViewGroup.LayoutParams params;
    private final float percent;
    private FrameLayout securityLoadingContainer;
    private ICJPaySecurityLoadingService securityLoadingService;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/Utils/CJPaySecurityLoadingHelper$Companion;", "", "()V", "TAG", "", "isDismissDialogLocked", "", "()Z", "setDismissDialogLocked", "(Z)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final boolean isDismissDialogLocked() {
            return CJPaySecurityLoadingHelper.access$isDismissDialogLocked$cp();
        }

        public final void setDismissDialogLocked(boolean r100) {
            CJPaySecurityLoadingHelper.access$setDismissDialogLocked$cp(r100);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final String getLoadingInfo() {
        ICJPaySecurityLoadingService r100 = this.securityLoadingService;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSecurityLoadingInfo();
    }

    public final void hideDialogLoading() {
        ICJPaySecurityLoadingService r100 = this.securityLoadingService;
        if (r100 == null) goto L6;
        r100.hideLoading();
        return;
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

    @Deprecated(level = DeprecationLevel.WARNING, message = "暂时没看到这个方法实现的必要性，先不提供", replaceWith = @ReplaceWith(expression = "CJPayStdLoadingComponent.getInstance().isValidSecurityInfo()", imports = {}))
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

    public static final /* synthetic */ boolean access$isDismissDialogLocked$cp() {
        return isDismissDialogLocked;
    }

    public static final /* synthetic */ void access$setDismissDialogLocked$cp(boolean r100) {
        isDismissDialogLocked = r100;
    }

    public final Long getSecurityLoadingMinTime(ICJPaySecurityLoadingService.LoadingCustomScene r100) {
        ICJPaySecurityLoadingService r101 = this.securityLoadingService;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getSecurityLoadingMinTime(r100);
    }

    public final String getSecurityLoadingMsg(ICJPaySecurityLoadingService.LoadingCustomScene r100) {
        ICJPaySecurityLoadingService r101 = this.securityLoadingService;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getSecurityLoadingMsg(r100);
    }

    public final boolean isHitLoadingUniform(boolean r100) {
        ICJPaySecurityLoadingService r101 = this.securityLoadingService;
        if (r101 == null) goto L5;
        Boolean r102 = Boolean.valueOf(r101.isUniform());
    L7:
        if (r102 == null) goto L9;
        boolean r103 = r102.booleanValue();
    L10:
        if (r103 == false) goto L16;
        if (r100 == false) goto L13;
    L14:
        return true;
    L13:
        if ((this.securityLoadingContainer instanceof ViewGroup) == true) goto L14;
        return false;
    L16:
        return false;
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = null;
        goto L7
    }

    public final void notifyUpdate(boolean r100) {
        ICJPaySecurityLoadingService r101 = this.securityLoadingService;
        if (r101 == null) goto L6;
        r101.notifyUpdate(r100);
        return;
    }

    public final void setSecurityLoadingInfo(String r100) {
        ICJPaySecurityLoadingService r101 = this.securityLoadingService;
        if (r101 == null) goto L6;
        r101.setSecurityLoadingInfo(r100);
        return;
    }

    public final void updateSecurityLoadingAfterPayFinish(Function0<Unit> r100) {
        CJLoading.Companion.getInstance().updateSecurityLoadingAfterPayFinish(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateSecurityLoadingAfterPayFinish$default(CJPaySecurityLoadingHelper r100, Function0 r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = null;
    L5:
        r100.updateSecurityLoadingAfterPayFinish(r101);
    }

    public final boolean showDialogLoading(Context r100, String r110, String r111, Boolean r112) {
        ICJPaySecurityLoadingService r101 = this.securityLoadingService;
        if (r101 == null) goto L7;
        if (r110 != null) goto L9;
        r110 = "";
    L9:
        return ICJPaySecurityLoadingService.DefaultImpls.showLoading$default(r101, r100, r110, r111, r112, null, 16, null);
    L7:
        return false;
    }

    public CJPaySecurityLoadingHelper(Context r100, View r101, View r102, float r103, ViewGroup.LayoutParams r104) {
        this.context = r100;
        this.panelView = r102;
        this.percent = r103;
        this.params = r104;
        this.securityLoadingService = (ICJPaySecurityLoadingService) CJPayServiceManager.getInstance().getIService(ICJPaySecurityLoadingService.class);
        if (r101 == null) goto L5;
        FrameLayout r105 = (FrameLayout) r101.findViewById(R.id.cj_pay_security_panel_loading_container);
    L6:
        this.securityLoadingContainer = r105;
        return;
    L5:
        r105 = null;
        goto L6
    }

    public /* synthetic */ CJPaySecurityLoadingHelper(Context r100, View r101, View r110, float r111, ViewGroup.LayoutParams r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 2) == 0) goto L5;
        View r102 = null;
    L7:
        if ((r113 & 4) == 0) goto L9;
        View r103 = null;
    L11:
        if ((r113 & 8) == 0) goto L13;
        float r104 = 0.26f;
    L15:
        if ((r113 & 16) == 0) goto L17;
        ViewGroup.LayoutParams r105 = null;
    L18:
        this(r100, r102, r103, r104, r105);
        return;
    L17:
        r105 = r112;
        goto L18
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r101;
        goto L7
    }

    public static /* synthetic */ boolean showDialogLoading$default(CJPaySecurityLoadingHelper r100, Context r101, String r102, String r103, Boolean r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L6;
        r102 = "";
    L6:
        if ((r105 & 4) == 0) goto L9;
        r103 = null;
    L9:
        if ((r105 & 8) == 0) goto L12;
        r104 = Boolean.FALSE;
    L12:
        return r100.showDialogLoading(r101, r102, r103, r104);
    }

    public final void showSecurityLoading(boolean r210, boolean r211, Function2<? super Boolean, ? super Boolean, Unit> r212, ICJPaySecurityLoadingService.SecurityLoadingScene r213, String r214, Function2<? super Boolean, ? super Boolean, Unit> r215, View r216, boolean r310, int r311, boolean r312, boolean r313, boolean r314, ICJPaySecurityLoadingService.LoadingCustomScene r315) {
        Intrinsics.checkNotNullParameter(r212, "defaultLoadingTask");
        Intrinsics.checkNotNullParameter(r213, "scene");
        StringBuilder r100 = new StringBuilder("showSecurityLoading isShow:");
        r100.append(r210);
        r100.append(",isDialogLoading:");
        r100.append(r211);
        r100.append(",sceneDes:");
        r100.append(r213.getSceneDes());
        r100.append(",customScene:");
        Boolean r101 = null;
        if (r315 == null) goto L5;
        String r102 = r315.getScene();
    L6:
        r100.append(r102);
        CJLogger.d(TAG, r100.toString());
        CJLogger.a(TAG, "showSecurityLoading\n" + Log.getStackTraceString(new Throwable("invoke loading")));
        if (isHitLoadingUniform(r211) == false) goto L20;
        if (r211 == true) goto L20;
        if (this.percent != 0.2f) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L20;
        if (r216 == null) goto L20;
        if (r210 == false) goto L18;
        int r104 = 4;
    L19:
        r216.setVisibility(r104);
        goto L20
    L18:
        r104 = 0;
        goto L19
    L12:
        r103 = false;
    L20:
        if (r210 == false) goto L74;
        if (r214 == null) goto L90;
        String r110 = r214;
    L28:
        if (isHitLoadingUniform(r211) == false) goto L31;
        ViewGroup r105 = this.securityLoadingContainer;     // Catch: Throwable -> L66
    L30:
        ViewGroup r111 = r105;
    L89:
        if (r211 == false) goto L46;
        ICJPaySecurityLoadingService r106 = this.securityLoadingService;     // Catch: Throwable -> L66
        if (r106 == null) goto L42;
        r101 = Boolean.valueOf(ICJPaySecurityLoadingService.DefaultImpls.showDialogLoadingForInnerInvoke$default(r106, this.context, r213, r110, r312, r313, r315, null, null, 192, null));     // Catch: Throwable -> L64
    L66:
        Throwable th10 = th;
    L68:
        CJBasicCommonUtils.reportCatchException("CJPaySecurityLoadingHelper#showSecurityLoading", th10);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPaySecurityLoadingHelper#showSecurityLoading", th10);
    L69:
        boolean r112 = false;
    L70:
        if (r112 == true) goto L72;
        r212.invoke(Boolean.TRUE, Boolean.valueOf(isHitLoadingUniform(r211)));
        return;
    L72:
        if (r215 == null) goto L93;
        r215.invoke(Boolean.TRUE, Boolean.valueOf(isHitLoadingUniform(r211)));
        return;
    L93:
        return;
    L42:
        if (r101 == null) goto L69;
        boolean r107 = r101.booleanValue();     // Catch: Throwable -> L64
    L44:
        r112 = r107;
        goto L70
    L46:
        if (isHitLoadingUniform(false) == false) goto L52;
        ICJPaySecurityLoadingService r108 = this.securityLoadingService;     // Catch: Throwable -> L64
        if (r108 == null) goto L50;
        r101 = Boolean.valueOf(ICJPaySecurityLoadingService.DefaultImpls.showPanelLoading$default(r108, this.context, r213, r110, r111, r311, this.percent, r312, true, false, r314, null, null, 3328, null));     // Catch: Throwable -> L64
    L50:
        if (r101 == null) goto L69;
        r107 = r101.booleanValue();     // Catch: Throwable -> L64
        goto L44
    L52:
        if (r310 == false) goto L58;
        ICJPaySecurityLoadingService r109 = this.securityLoadingService;     // Catch: Throwable -> L64
        if (r109 == null) goto L56;
        r101 = Boolean.valueOf(ICJPaySecurityLoadingService.DefaultImpls.showPanelLoadingForSpecial$default(r109, this.context, r213, r110, r111, this.params, r312, false, null, 128, null));     // Catch: Throwable -> L64
    L56:
        if (r101 == null) goto L69;
        r107 = r101.booleanValue();     // Catch: Throwable -> L64
        goto L44
    L58:
        ICJPaySecurityLoadingService r113 = this.securityLoadingService;     // Catch: Throwable -> L64
        if (r113 == null) goto L61;
        r101 = Boolean.valueOf(ICJPaySecurityLoadingService.DefaultImpls.showPanelLoadingForCommon$default(r113, this.context, r213, r110, r111, r311, r312, false, null, 128, null));     // Catch: Throwable -> L64
    L61:
        if (r101 == null) goto L69;
        r107 = r101.booleanValue();     // Catch: Throwable -> L64
    L64:
        th10 = th;
        goto L68
    L31:
        View r114 = this.panelView;     // Catch: Throwable -> L66
        if ((r114 instanceof ViewGroup) == false) goto L34;
        r105 = (ViewGroup) r114;     // Catch: Throwable -> L66
        goto L30
    L34:
        r111 = null;
        goto L89
    L90:
        ICJPaySecurityLoadingService r115 = this.securityLoadingService;     // Catch: Throwable -> L66
        if (r115 == null) goto L25;
        r110 = r115.getSecurityLoadingInfo();     // Catch: Throwable -> L66
        goto L28
    L25:
        r110 = null;
        goto L28
    L74:
        if (r211 == true) goto L76;
        ICJPaySecurityLoadingService r116 = this.securityLoadingService;
        if (r116 == null) goto L85;
        r116.hidePanelLoading();
    L85:
        Boolean r117 = Boolean.FALSE;
        r212.invoke(r117, Boolean.valueOf(isHitLoadingUniform(r211)));
        if (r215 == null) goto L95;
        r215.invoke(r117, Boolean.valueOf(isHitLoadingUniform(r211)));
        return;
    L95:
        return;
    L76:
        if (isDismissDialogLocked == false) goto L79;
        CJLogger.d(TAG, "showSecurityLoading: dismiss dialog blocked by pay-again lock");
        return;
    L79:
        ICJPaySecurityLoadingService r118 = this.securityLoadingService;
        if (r118 == null) goto L85;
        r118.hideDialogLoadingForInnerInvoke();
        goto L85
    L5:
        r102 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showSecurityLoading$default(CJPaySecurityLoadingHelper r110, boolean r111, boolean r112, Function2 r210, ICJPaySecurityLoadingService.SecurityLoadingScene r211, String r212, Function2 r213, View r214, boolean r215, int r216, boolean r217, boolean r218, boolean r219, ICJPaySecurityLoadingService.LoadingCustomScene r310, int r311, Object r312) {
        if ((r311 & 16) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r311 & 32) == 0) goto L9;
        Function2 r101 = null;
    L11:
        if ((r311 & 64) == 0) goto L13;
        View r113 = null;
    L15:
        if ((r311 & 128) == 0) goto L17;
        boolean r114 = false;
    L19:
        if ((r311 & 256) != 0) goto L21;
        int r115 = r216;
    L27:
        if ((r311 & 512) == 0) goto L29;
        boolean r116 = false;
    L31:
        if ((r311 & 1024) == 0) goto L33;
        boolean r117 = false;
    L35:
        if ((r311 & 2048) == 0) goto L37;
        boolean r118 = true;
    L39:
        if ((r311 & 4096) == 0) goto L41;
        ICJPaySecurityLoadingService.LoadingCustomScene r119 = null;
    L42:
        r110.showSecurityLoading(r111, r112, r210, r211, r100, r101, r113, r114, r115, r116, r117, r118, r119);
        return;
    L41:
        r119 = r310;
        goto L42
    L37:
        r118 = r219;
        goto L39
    L33:
        r117 = r218;
        goto L35
    L29:
        r116 = r217;
        goto L31
    L21:
        if (r110.isHitLoadingUniform(r112) == false) goto L23;
        int r102 = 0;
    L24:
        r115 = r102;
        goto L27
    L23:
        r102 = 470;
        goto L24
    L17:
        r114 = r215;
        goto L19
    L13:
        r113 = r214;
        goto L15
    L9:
        r101 = r213;
        goto L11
    L5:
        r100 = r212;
        goto L7
    }
}
