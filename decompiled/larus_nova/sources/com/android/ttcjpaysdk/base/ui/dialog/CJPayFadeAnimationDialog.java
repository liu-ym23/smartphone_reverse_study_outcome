package com.android.ttcjpaysdk.base.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayAnimationUtils;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/dialog/CJPayFadeAnimationDialog;", "Landroid/app/Dialog;", "ownerContext", "Landroid/content/Context;", "themeResId", "", "isDoAnim", "", "(Landroid/content/Context;IZ)V", "getOwnerContext", "()Landroid/content/Context;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "show", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class CJPayFadeAnimationDialog extends Dialog {
    private final boolean isDoAnim;
    private final Context ownerContext;

    public static /* synthetic */ void access$000(Dialog r100) {
        super.show();
    }

    @Override // android.app.Dialog
    public void show() {
        INVOKESPECIAL_com_android_ttcjpaysdk_base_ui_dialog_CJPayFadeAnimationDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this);     // Catch: Throwable -> L6
        if (this.isDoAnim == false) goto L11;
        CJPayAnimationUtils.dialogCenterPosAdaptive$default(getWindow(), this.ownerContext, 0, 4, null);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayFadeAnimationDialog#show", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayFadeAnimationDialog#show", th);
    }

    public final Context getOwnerContext() {
        return this.ownerContext;
    }

    public static void INVOKESPECIAL_com_android_ttcjpaysdk_base_ui_dialog_CJPayFadeAnimationDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(Dialog r100) {
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

    @Override // android.app.Dialog
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (this.isDoAnim == false) goto L6;
        CJPayAnimationUtils.setWindowAnimations(getWindow(), R.style.CJ_Pay_Dialog_Fade_In_Or_Out_Animation);
        return;
    }

    public CJPayFadeAnimationDialog(Context r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "ownerContext");
        super(r100, r101);
        this.ownerContext = r100;
        this.isDoAnim = r102;
    }

    public /* synthetic */ CJPayFadeAnimationDialog(Context r100, int r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = true;
    L5:
        this(r100, r101, r102);
    }
}
