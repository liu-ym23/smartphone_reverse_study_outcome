package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livesdkapi.service.IMiddleWareWindowDegradeManager;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0006H&J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0012\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u0010H\u0004J\b\u0010\u001b\u001a\u00020\u0010H\u0016R\u001e\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "Lcom/bytedance/android/livesdk/widget/LiveBottomSheetDialog;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "theme", "", "(Landroid/content/Context;I)V", "isLandscape", "", "isPad", "(Landroid/content/Context;ZZ)V", "<set-?>", "isViewValid", "()Z", "dismiss", "", "getDegradeTag", "", "getLayoutId", "onAttachedToWindow", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "onDetachedFromWindow", "removeAccessOutSideForcuse", "show", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class CommonBottomDialog extends LiveBottomSheetDialog {
    private boolean isViewValid;

    public static final class a implements LiveBottomSheetDialog.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f160795a = null;

        static {
            f160795a = new a();
        }

        public a() {
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final boolean disableDragDown() {
            return false;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final /* synthetic */ boolean shouldInterceptSlide(int r100) {
            return true;
        }
    }

    public static /* synthetic */ void access$000(LiveBottomSheetDialog r100) {
        super.show();
    }

    public static /* synthetic */ void access$001(LiveBottomSheetDialog r100) {
        super.dismiss();
    }

    public String getDegradeTag() {
        return "";
    }

    public abstract int getLayoutId();

    public void onCreateBefore() {
    }

    public final void removeAccessOutSideForcuse() {
        this.outsideView.setImportantForAccessibility(2);
        this.outsideView.setFocusable(false);
    }

    @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        INVOKESPECIAL_com_bytedance_android_livesdk_widget_CommonBottomDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this);
        if (LiveInfraSettingKeys.LIVE_FIX_DIALOG_MANAGER_DUPLICATE_ADD.getValue().booleanValue() == true) goto L6;
        com.bytedance.android.livesdk.e.b().d();
        com.bytedance.android.livesdk.f.d().f();
        return;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        boolean r100 = true;
        this.isViewValid = true;
        String r101 = getDegradeTag();
        if (r101 != null) goto L5;
    L8:
        if (r100 == false) goto L10;
        return;
    L10:
        IMiddleWareWindowDegradeManager r102 = (IMiddleWareWindowDegradeManager) jc1.k.f(IMiddleWareWindowDegradeManager.class);
        if (r102 == null) goto L14;
        r102.checkDegradeForNative(r101);
        return;
    L14:
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r100 = false;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        boolean r100 = false;
        this.isViewValid = false;
        String r101 = getDegradeTag();
        if (r101 != null) goto L5;
    L6:
        r100 = true;
    L7:
        if (r100 == false) goto L9;
        return;
    L9:
        IMiddleWareWindowDegradeManager r102 = (IMiddleWareWindowDegradeManager) jc1.k.f(IMiddleWareWindowDegradeManager.class);
        if (r102 == null) goto L13;
        IMiddleWareWindowDegradeManager.DefaultImpls.checkRecoverForNative$default(r102, r101, null, 2, null);
        return;
    L13:
        return;
    L5:
        if (r101.length() != 0) goto L7;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, android.app.Dialog
    public void show() {
        INVOKESPECIAL_com_bytedance_android_livesdk_widget_CommonBottomDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this);
        if (LiveInfraSettingKeys.LIVE_FIX_DIALOG_MANAGER_DUPLICATE_ADD.getValue().booleanValue() == true) goto L6;
        com.bytedance.android.livesdk.e.b().a();
        com.bytedance.android.livesdk.f.d().a();
        return;
    }

    public final boolean isViewValid() {
        return this.isViewValid;
    }

    public CommonBottomDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, R.style.ttlive_common_bottom_dialog_normal);
    }

    public static void INVOKESPECIAL_com_bytedance_android_livesdk_widget_CommonBottomDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(LiveBottomSheetDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        access$001(r100);     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void INVOKESPECIAL_com_bytedance_android_livesdk_widget_CommonBottomDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(LiveBottomSheetDialog r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        access$000(r100);
        DialogLancet.afterDialogShow(r100);
    }

    @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle r100) {
        onCreateBefore();
        super.onCreate(r100);
        setContentView(getLayoutId());
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.setLayout(-1, -1);
    L5:
        Window r102 = getWindow();
        if (r102 == null) goto L8;
        r102.setGravity(80);
    L8:
        setBottomSheetSlideProcessor(a.f160795a);
    }

    public CommonBottomDialog(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    public CommonBottomDialog(Context r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r103 = pn2.b.f529958a;
        if (r102 == false) goto L5;
        int r104 = R.style.ttlive_standard_dialog_hd_theme;
    L8:
        super(r100, r104);
        return;
    L5:
        if (r101 == false) goto L7;
        r104 = R.style.ttlive_standard_dialog_right_theme;
        goto L8
    L7:
        r104 = R.style.ttlive_standard_dialog_bottom_theme;
        goto L8
    }
}
