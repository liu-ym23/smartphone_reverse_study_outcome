package com.google.android.material.sidesheet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes2.dex */
public class SideSheetDialog extends SheetDialog<SideSheetCallback> {
    private static final int SIDE_SHEET_DIALOG_DEFAULT_THEME_RES = 0;
    private static final int SIDE_SHEET_DIALOG_THEME_ATTR = 0;

    @Override // com.google.android.material.sidesheet.SheetDialog
    int getStateOnStart() {
        return 3;
    }

    @Override // com.google.android.material.sidesheet.SheetDialog, android.app.Dialog, android.content.DialogInterface
    public /* bridge */ /* synthetic */ void cancel() {
        super.cancel();
    }

    @Override // com.google.android.material.sidesheet.SheetDialog
    public /* bridge */ /* synthetic */ Sheet getBehavior() {
        return getBehavior();
    }

    @Override // com.google.android.material.sidesheet.SheetDialog
    public /* bridge */ /* synthetic */ boolean isDismissWithSheetAnimationEnabled() {
        return super.isDismissWithSheetAnimationEnabled();
    }

    @Override // com.google.android.material.sidesheet.SheetDialog, android.app.Dialog
    public /* bridge */ /* synthetic */ void setCancelable(boolean r1) {
        super.setCancelable(r1);
    }

    @Override // com.google.android.material.sidesheet.SheetDialog, android.app.Dialog
    public /* bridge */ /* synthetic */ void setCanceledOnTouchOutside(boolean r1) {
        super.setCanceledOnTouchOutside(r1);
    }

    @Override // com.google.android.material.sidesheet.SheetDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public /* bridge */ /* synthetic */ void setContentView(int r1) {
        super.setContentView(r1);
    }

    @Override // com.google.android.material.sidesheet.SheetDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public /* bridge */ /* synthetic */ void setContentView(View r1) {
        super.setContentView(r1);
    }

    @Override // com.google.android.material.sidesheet.SheetDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public /* bridge */ /* synthetic */ void setContentView(View r1, ViewGroup.LayoutParams r2) {
        super.setContentView(r1, r2);
    }

    @Override // com.google.android.material.sidesheet.SheetDialog
    public /* bridge */ /* synthetic */ void setDismissWithSheetAnimationEnabled(boolean r1) {
        super.setDismissWithSheetAnimationEnabled(r1);
    }

    static {
        SIDE_SHEET_DIALOG_THEME_ATTR = R.attr.sideSheetDialogTheme;
        SIDE_SHEET_DIALOG_DEFAULT_THEME_RES = R.style.Theme_Material3_Light_SideSheetDialog;
    }

    public SideSheetDialog(Context r2) {
        this(r2, 0);
    }

    public SideSheetDialog(Context r3, int r4) {
        super(r3, r4, SIDE_SHEET_DIALOG_THEME_ATTR, SIDE_SHEET_DIALOG_DEFAULT_THEME_RES);
    }

    @Override // com.google.android.material.sidesheet.SheetDialog
    void addSheetCancelOnHideCallback(Sheet<SideSheetCallback> r2) {
        r2.addCallback(new AnonymousClass1(this));
    }

    @Override // com.google.android.material.sidesheet.SheetDialog
    int getLayoutResId() {
        return R.layout.m3_side_sheet_dialog;
    }

    @Override // com.google.android.material.sidesheet.SheetDialog
    int getDialogId() {
        return R.id.m3_side_sheet;
    }

    @Override // com.google.android.material.sidesheet.SheetDialog
    Sheet<SideSheetCallback> getBehaviorFromSheet(FrameLayout r1) {
        return SideSheetBehavior.from(r1);
    }

    @Override // com.google.android.material.sidesheet.SheetDialog
    public SideSheetBehavior<? extends View> getBehavior() {
        Sheet r1 = super.getBehavior();
        if ((r1 instanceof SideSheetBehavior) == false) goto L7;
        return (SideSheetBehavior) r1;
    L7:
        throw new IllegalStateException("The view is not associated with SideSheetBehavior");
    }
}
