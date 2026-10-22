package com.obric.oui.window.permission;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PermissionPurposeWindow.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/window/permission/PermissionPurposeWindow;", "", "purposeTitle", "", "purposeDesc", "mActivity", "Landroid/app/Activity;", "(Ljava/lang/String;Ljava/lang/String;Landroid/app/Activity;)V", "activity", "decorView", "Landroid/view/ViewGroup;", "handler", "Lcom/obric/oui/window/permission/PermissionPurposeWindowHandler;", "isViewAdded", "", "view", "Landroid/view/View;", "dismiss", "", "show", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PermissionPurposeWindow {
    private final Activity activity;
    private ViewGroup decorView;
    private final PermissionPurposeWindowHandler handler;
    private boolean isViewAdded;
    private final String purposeDesc;
    private final String purposeTitle;
    private View view;

    public PermissionPurposeWindow(String r2, String r3, Activity r4) {
        Intrinsics.checkNotNullParameter(r2, "purposeTitle");
        Intrinsics.checkNotNullParameter(r3, "purposeDesc");
        this.purposeTitle = r2;
        this.purposeDesc = r3;
        this.handler = new PermissionPurposeWindowHandler(r2, r3);
        this.activity = r4;
    }

    public final void show() {
        if (this.isViewAdded == true) goto L38;
        Activity r0 = this.activity;
        if (r0 == null) goto L39;
        View r1 = null;
        if (r0 == null) goto L14;
        Window r2 = r0.getWindow();
        if (r2 == null) goto L14;
        r1 = r2.getDecorView();
    L14:
        ViewGroup r3 = (ViewGroup) r1;
        this.decorView = r3;
        int[] r4 = {0, 0};
        if (r3 == null) goto L18;
        r3.getLocationOnScreen(r4);
    L18:
        Activity r5 = this.activity;
        this.view = this.handler.onCreateView(r5, r4);
        ViewGroup.LayoutParams r6 = new ViewGroup.LayoutParams(-1, -2);
        View r7 = this.view;
        if (r7 == null) goto L22;
        r7.setLayoutParams(r6);
    L22:
        View r8 = this.view;
        if (r8 != null) goto L26;
        return;
    L26:
        if (r8.getParent() == null) goto L32;
        ViewParent r9 = r8.getParent();
        if (r9 == null) goto L31;
        ((ViewGroup) r9).removeView(r8);
        goto L32
    L31:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L32:
        ViewGroup r10 = this.decorView;
        if (r10 == null) goto L36;
        r10.addView(r8, r6);
    L36:
        this.isViewAdded = true;
        return;
    L39:
        return;
    }

    public final void dismiss() {
        View r0 = this.view;
        if (r0 == null) goto L11;
        ViewGroup r1 = this.decorView;
        if (r1 == null) goto L9;
        r1.removeView(r0);
    L9:
        this.view = null;
        this.isViewAdded = false;
        return;
    }
}
