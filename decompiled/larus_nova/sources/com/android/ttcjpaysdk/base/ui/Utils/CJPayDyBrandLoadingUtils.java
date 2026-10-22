package com.android.ttcjpaysdk.base.ui.Utils;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.base.settings.abtest.CJPayABExperimentKeys;
import com.android.ttcjpaysdk.base.settings.bean.CJPayLoadingConfig;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog;
import com.android.ttcjpaysdk.base.ui.widget.DyBrandLoadingView;
import com.bytedance.caijing.sdk.infra.base.task.b;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0006\u0010\u000e\u001a\u00020\nJ\u001c\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u001e\u0010\u0014\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J(\u0010\u0014\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007J&\u0010\u0019\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u001a\u001a\u00020\bJ\u001a\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J7\u0010\u001d\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u001a\u001a\u00020\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u001fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/Utils/CJPayDyBrandLoadingUtils;", "", "()V", "dyBrandLoadingView", "Lcom/android/ttcjpaysdk/base/ui/widget/DyBrandLoadingView;", "loadingCountdown", "Landroid/os/CountDownTimer;", "settingsControlIsShowLoading", "", "cancelLoadingCountdown", "", "handleLoadingTimeout", "loadingTimeoutMs", "", "hideLoading", "initCountDownTimer", "timeout", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", DyPayConstant.KEY_SHOW_LOADING, "loadingMessage", "", "backPressedListener", "Lcom/android/ttcjpaysdk/base/ui/dialog/CJPayCommonDialog$DialogBackPressedListener;", "showLoadingWithDefault", "showBackground", "showManualCloseDialog", "timeoutDurationMs", "showOldLoading", "loadingTimeout", "(Landroid/content/Context;ZLcom/android/ttcjpaysdk/base/ui/dialog/CJPayCommonDialog$DialogBackPressedListener;Ljava/lang/Integer;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayDyBrandLoadingUtils {
    public static final CJPayDyBrandLoadingUtils INSTANCE = null;
    private static DyBrandLoadingView dyBrandLoadingView;
    private static CountDownTimer loadingCountdown;
    private static final boolean settingsControlIsShowLoading = false;

    private CJPayDyBrandLoadingUtils() {
    }

    static {
        INSTANCE = new CJPayDyBrandLoadingUtils();
        CJPayLoadingConfig r100 = CJPaySettingsManager.getInstance().getCJPayLoadingConfig();
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        settingsControlIsShowLoading = !r101;
        return;
    L5:
        if (r100.loading_time_out != 0) goto L7;
        r101 = true;
        goto L7
    }

    private final void cancelLoadingCountdown() {
        CountDownTimer r100 = loadingCountdown;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        loadingCountdown = null;
    }

    public final void hideLoading() {
        cancelLoadingCountdown();
        DyBrandLoadingView r100 = dyBrandLoadingView;
        if (r100 == null) goto L5;
        r100.hideLoading();
    L5:
        dyBrandLoadingView = null;
    }

    public static final /* synthetic */ DyBrandLoadingView access$getDyBrandLoadingView$p() {
        return dyBrandLoadingView;
    }

    public static final /* synthetic */ CountDownTimer access$getLoadingCountdown$p() {
        return loadingCountdown;
    }

    public static final /* synthetic */ void access$setDyBrandLoadingView$p(DyBrandLoadingView r100) {
        dyBrandLoadingView = r100;
    }

    public static final /* synthetic */ void access$setLoadingCountdown$p(CountDownTimer r100) {
        loadingCountdown = r100;
    }

    private final void handleLoadingTimeout(long r100) {
        CJPayLoadingLogger.reportTimeout(CJPayLoadingLogger.LOADING_TYPE_DOUBLE_BALL, r100, "CJPayDyBrandLoadingUtils#handleLoadingTimeout");
        DyBrandLoadingView r101 = dyBrandLoadingView;
        if (r101 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r101.isShowing(), Boolean.TRUE) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L15;
        DyBrandLoadingView r102 = dyBrandLoadingView;
        if (r102 == null) goto L12;
        r102.hideLoading();
    L12:
        dyBrandLoadingView = null;
        return;
    }

    public static final /* synthetic */ void access$handleLoadingTimeout(CJPayDyBrandLoadingUtils r100, long r101) {
        r100.handleLoadingTimeout(r101);
    }

    private final void initCountDownTimer(final int r100, Context r101) {
        cancelLoadingCountdown();
        if (Intrinsics.areEqual(CJPayABExperimentKeys.getCjLoadingOpt().value(true), "1") == false) goto L15;
        if (r100 <= 0) goto L6;
        Pair r102 = TuplesKt.to(Long.valueOf(r100), new AnonymousClass1(r100));
    L11:
        final long r103 = ((Number) r102.component1()).longValue();
        final Function0 r104 = (Function0) r102.component2();
        if (r103 <= 0) goto L24;
        loadingCountdown = new CJPayDyBrandLoadingUtils$initCountDownTimer$countDownTimer$1(r103, r104);
        return;
    L24:
        return;
    L6:
        final long r105 = CJPaySettingsManager.getInstance().getLoadingManualCloseTime();
        if (r101 == null) goto L9;
        final WeakReference r106 = new WeakReference(r101);
    L10:
        r102 = TuplesKt.to(Long.valueOf(r105), new AnonymousClass2(r105, r106));
        goto L11
    L9:
        r106 = null;
        goto L10
    L15:
        if (r100 > 0) goto L22;
        CJPayLoadingConfig r107 = CJPaySettingsManager.getInstance().getCJPayLoadingConfig();
        if (r107 == null) goto L20;
        int r108 = r107.loading_time_out;
    L21:
        r100 = r108 * 1000;
        goto L22
    L20:
        r108 = 15;
    L22:
        final long r109 = r100;
        loadingCountdown = new CJPayDyBrandLoadingUtils$initCountDownTimer$countDownTimer$2(r109, r109);
    }

    private final void showManualCloseDialog(long r100, final Context r101) {
        CJPayLoadingLogger.reportTimeout(CJPayLoadingLogger.LOADING_TYPE_DOUBLE_BALL, r100, "CJPayDyBrandLoadingUtils#showManualCloseDialog");
        final Ref.ObjectRef r102 = new Ref.ObjectRef();
        b.i(new RunnableC88771(r101, r102));
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "This function is deprecated, use newFunction() instead", replaceWith = @ReplaceWith(expression = "CJPayStdLoadingComponent.getInstance().showStdDialogActivityLoading()", imports = {}))
    public final boolean showLoading(Context r100, String r101) {
        return showLoading(r100, r101, null);
    }

    public static final /* synthetic */ void access$showManualCloseDialog(CJPayDyBrandLoadingUtils r100, long r101, Context r102) {
        r100.showManualCloseDialog(r101, r102);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "点点点样式的loading已废弃，预期要更换为标准样式", replaceWith = @ReplaceWith(expression = "CJPayStdLoadingComponent.getInstance().showStdDialogActivityLoading()", imports = {}))
    public final boolean showLoading(Context r100, String r101, CJPayCommonDialog.DialogBackPressedListener r102) {
        if (CJPaySettingsManager.getInstance().getBrandPromotion().show_new_loading == false) goto L31;
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof Activity) == true) goto L8;
        return false;
    L8:
        if (settingsControlIsShowLoading == false) goto L34;
        DyBrandLoadingView r103 = dyBrandLoadingView;
        if (r103 == null) goto L19;
        if (r103 == null) goto L13;
        boolean r104 = Intrinsics.areEqual(r103.isShowing(), Boolean.TRUE);
    L14:
        if (r104 == false) goto L18;
        DyBrandLoadingView r105 = dyBrandLoadingView;
        if (r105 == null) goto L18;
        r105.hideLoading();
    L18:
        dyBrandLoadingView = null;
        goto L19
    L13:
        r104 = false;
    L19:
        DyBrandLoadingView r106 = new DyBrandLoadingView(r100);
        dyBrandLoadingView = r106;
        r106.setLoadingMessage(r101);
        if (r102 == null) goto L24;
        DyBrandLoadingView r107 = dyBrandLoadingView;
        if (r107 == null) goto L24;
        r107.setDialogBackPressedListener(r102);
    L24:
        initCountDownTimer(-1, r100);
        CountDownTimer r108 = loadingCountdown;
        if (r108 == null) goto L27;
        r108.start();
    L27:
        DyBrandLoadingView r109 = dyBrandLoadingView;
        if (r109 != null) goto L30;
        return false;
    L30:
        return r109.showLoading();
    L34:
        return false;
    L31:
        return false;
    }

    public final void showLoadingWithDefault(Context r100, String r101, boolean r110) {
        if (showLoading(r100, r101) == true) goto L6;
        showOldLoading$default(this, r100, r110, null, null, 12, null);
        return;
    }

    public final void showOldLoading(Context r100, boolean r101, CJPayCommonDialog.DialogBackPressedListener r102, Integer r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if ((r100 instanceof Activity) == true) goto L6;
        return;
    L6:
        if (settingsControlIsShowLoading == false) goto L31;
        DyBrandLoadingView r104 = dyBrandLoadingView;
        if (r104 == null) goto L17;
        if (r104 == null) goto L11;
        boolean r105 = Intrinsics.areEqual(r104.isShowing(), Boolean.TRUE);
    L12:
        if (r105 == false) goto L16;
        DyBrandLoadingView r106 = dyBrandLoadingView;
        if (r106 == null) goto L16;
        r106.hideLoading();
    L16:
        dyBrandLoadingView = null;
        goto L17
    L11:
        r105 = false;
    L17:
        DyBrandLoadingView r107 = new DyBrandLoadingView(r100);
        dyBrandLoadingView = r107;
        r107.showOldLoading(r101);
        if (r102 == null) goto L22;
        DyBrandLoadingView r108 = dyBrandLoadingView;
        if (r108 == null) goto L22;
        r108.setDialogBackPressedListener(r102);
    L22:
        if (r103 == null) goto L24;
        int r109 = r103.intValue();
    L25:
        initCountDownTimer(r109, r100);
        CountDownTimer r110 = loadingCountdown;
        if (r110 == null) goto L32;
        r110.start();
        return;
    L32:
        return;
    L24:
        r109 = -1;
        goto L25
    }

    public static /* synthetic */ void initCountDownTimer$default(CJPayDyBrandLoadingUtils r100, int r101, Context r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = -1;
    L5:
        r100.initCountDownTimer(r101, r102);
    }

    public static /* synthetic */ boolean showLoading$default(CJPayDyBrandLoadingUtils r100, Context r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = "";
    L6:
        return r100.showLoading(r101, r102);
    }

    public static /* synthetic */ boolean showLoading$default(CJPayDyBrandLoadingUtils r100, Context r101, String r102, CJPayCommonDialog.DialogBackPressedListener r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = "";
    L6:
        return r100.showLoading(r101, r102, r103);
    }

    public static /* synthetic */ void showLoadingWithDefault$default(CJPayDyBrandLoadingUtils r100, Context r101, String r102, boolean r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = "";
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = true;
    L8:
        r100.showLoadingWithDefault(r101, r102, r103);
    }

    public static /* synthetic */ void showOldLoading$default(CJPayDyBrandLoadingUtils r100, Context r101, boolean r102, CJPayCommonDialog.DialogBackPressedListener r103, Integer r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L6;
        r102 = true;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r103 = null;
    L9:
        if ((r105 & 8) == 0) goto L11;
        r104 = -1;
    L11:
        r100.showOldLoading(r101, r102, r103, r104);
    }
}
