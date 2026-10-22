package com.android.contacts.widget;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.EditText;
import android.window.CompatOnBackInvokedCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CopyTextView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u0010\u001b\u001a\u00020\tJ\u0006\u0010\u001c\u001a\u00020\tJ\b\u0010\u001d\u001a\u00020\u001aH\u0002J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\r\u0010\u001f\u001a\u00020\u001aH\u0000¢\u0006\u0002\b J\b\u0010!\u001a\u00020\u001aH\u0016J\u0006\u0010\"\u001a\u00020\u001aJ\u0006\u0010#\u001a\u00020\u001aR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcom/android/contacts/widget/CopyAll;", "Landroid/window/CompatOnBackInvokedCallback;", "view", "Landroid/view/View;", "getText", "Lkotlin/Function0;", "", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;)V", "backCallbackRegistered", "", "copyAllActionMode", "Landroid/view/ActionMode;", "copyAllActionModeCallback", "Landroid/view/ActionMode$Callback;", "getCopyAllActionModeCallback", "()Landroid/view/ActionMode$Callback;", "setCopyAllActionModeCallback", "(Landroid/view/ActionMode$Callback;)V", "dismissOverlayView", "getGetText", "()Lkotlin/jvm/functions/Function0;", "text", "()Ljava/lang/CharSequence;", "getView", "()Landroid/view/View;", "attachDismissOverlay", "", "canCopy", "canPaste", "cleanupActionModeState", "detachDismissOverlay", "onActionModeDestroyed", "onActionModeDestroyed$app_QssiCnRelease", "onBackInvoked", "startCopyAllActionMode", "stopCopyAllActionMode", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CopyAll implements CompatOnBackInvokedCallback {
    private boolean backCallbackRegistered;
    private ActionMode copyAllActionMode;
    private ActionMode.Callback copyAllActionModeCallback;
    private View dismissOverlayView;
    private final Function0<CharSequence> getText;
    private final View view;

    /* JADX INFO: renamed from: $r8$lambda$_F-U0h04FAkrrmirrSqpLsSAYr8, reason: not valid java name */
    public static /* synthetic */ void m227$r8$lambda$_FU0h04FAkrrmirrSqpLsSAYr8(CopyAll r0, View r1) {
        attachDismissOverlay$lambda$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$dfW4dww5fBYuS-WJBaNhWxXZxto, reason: not valid java name */
    public static /* synthetic */ void m228$r8$lambda$dfW4dww5fBYuSWJBaNhWxXZxto(View r0, ViewGroup r1) {
        detachDismissOverlay$lambda$1(r0, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CopyAll(View r2, Function0<? extends CharSequence> r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "getText");
        this.view = r2;
        this.getText = r3;
    }

    public final Function0<CharSequence> getGetText() {
        return this.getText;
    }

    public final View getView() {
        return this.view;
    }

    public final ActionMode.Callback getCopyAllActionModeCallback() {
        return this.copyAllActionModeCallback;
    }

    public final void setCopyAllActionModeCallback(ActionMode.Callback r1) {
        this.copyAllActionModeCallback = r1;
    }

    private final void attachDismissOverlay() {
        Context r0 = this.view.getContext();
        ViewGroup r2 = null;
        if ((r0 instanceof Activity) == false) goto L5;
        Activity r1 = (Activity) r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        Window r3 = r1.getWindow();
        if (r3 == null) goto L11;
        View r4 = r3.getDecorView();
    L13:
        if ((r4 instanceof ViewGroup) == false) goto L15;
        r2 = (ViewGroup) r4;
    L15:
        if (r2 != null) goto L17;
        return;
    L17:
        detachDismissOverlay();
        View r5 = new View(r1);
        r5.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r5.setClickable(true);
        r5.setOnClickListener(new CopyAll$$ExternalSyntheticLambda0(this));
        r2.addView(r5);
        this.dismissOverlayView = r5;
        return;
    L11:
        r4 = null;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    private static final void attachDismissOverlay$lambda$0(CopyAll r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.stopCopyAllActionMode();
    }

    private final void detachDismissOverlay() {
        final View r0 = this.dismissOverlayView;
        if (r0 != null) goto L5;
        return;
    L5:
        final ViewGroup r1 = null;
        this.dismissOverlayView = null;
        ViewParent r3 = r0.getParent();
        if ((r3 instanceof ViewGroup) == false) goto L8;
        r1 = (ViewGroup) r3;
    L8:
        if (r1 != null) goto L10;
        return;
    L10:
        r1.post(new CopyAll$$ExternalSyntheticLambda1(r0, r1));
    }

    private static final void detachDismissOverlay$lambda$1(View r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "$overlay");
        Intrinsics.checkNotNullParameter(r2, "$parent");
        if (r1.getParent() != r2) goto L6;
        r2.removeView(r1);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void cleanupActionModeState() {
        detachDismissOverlay();
        if (this.backCallbackRegistered == false) goto L13;
        Context r0 = this.view.getContext();
        if ((r0 instanceof Activity) == false) goto L7;
        Activity r1 = (Activity) r0;
    L8:
        if (r1 == null) goto L12;
        OnBackInvokedDispatcher r2 = r1.getOnBackInvokedDispatcher();
        if (r2 == null) goto L12;
        r2.unregisterOnBackInvokedCallback((OnBackInvokedCallback) this);
    L12:
        this.backCallbackRegistered = false;
        goto L13
    L7:
        r1 = null;
    L13:
        this.copyAllActionMode = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void startCopyAllActionMode() {
        if (this.view.isAttachedToWindow() == true) goto L5;
        return;
    L5:
        ActionMode.Callback r0 = this.copyAllActionModeCallback;
        Activity r2 = null;
        if (r0 == null) goto L8;
        ActionMode r1 = this.view.startActionMode(r0, 1);
    L9:
        this.copyAllActionMode = r1;
        if (r1 != null) goto L12;
        return;
    L12:
        attachDismissOverlay();
        if (this.backCallbackRegistered == true) goto L21;
        Context r3 = this.view.getContext();
        if ((r3 instanceof Activity) == false) goto L17;
        r2 = (Activity) r3;
    L17:
        if (r2 == null) goto L21;
        OnBackInvokedDispatcher r4 = r2.getOnBackInvokedDispatcher();
        if (r4 == null) goto L21;
        r4.registerOnBackInvokedCallback(0, (OnBackInvokedCallback) this);
        this.backCallbackRegistered = true;
    L21:
        final View r5 = this.view;
        if (ViewCompat.isAttachedToWindow(r5) == true) goto L24;
        stopCopyAllActionMode();
        return;
    L24:
        r5.addOnAttachStateChangeListener(new CopyAll$startCopyAllActionMode$$inlined$doOnDetach$1(r5, this));
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final void stopCopyAllActionMode() {
        ActionMode r0 = this.copyAllActionMode;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0 == null) goto L7;
        r0.finish();
    L7:
        cleanupActionModeState();
    }

    public void onBackInvoked() {
        stopCopyAllActionMode();
    }

    public final void onActionModeDestroyed$app_QssiCnRelease() {
        cleanupActionModeState();
    }

    public final CharSequence getText() {
        return this.getText.invoke();
    }

    public final boolean canCopy() {
        CharSequence r1 = getText();
        if (r1 != null) goto L5;
        return false;
    L5:
        if (r1.length() > 0) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canPaste() {
        if ((this.view instanceof EditText) == false) goto L26;
        Object r0 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        ClipboardManager r3 = (ClipboardManager) ((EditText) this.view).getContext().getSystemService(ClipboardManager.class);     // Catch: Throwable -> L11
        if (r3 == null) goto L8;
        Boolean r4 = Boolean.valueOf(r3.hasPrimaryClip());     // Catch: Throwable -> L11
    L9:
        Object r5 = Result.m803constructorimpl(r4);     // Catch: Throwable -> L11
    L14:
        if (Result.m809isFailureimpl(r5) == true) goto L17;
        r0 = r5;
    L17:
        Boolean r1 = (Boolean) r0;
        if (r1 == null) goto L20;
        boolean r6 = r1.booleanValue();
    L21:
        if (r6 == false) goto L27;
        return true;
    L27:
        return false;
    L20:
        r6 = false;
        goto L21
    L8:
        r4 = null;
    L11:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L14
    L26:
        return false;
    }
}
