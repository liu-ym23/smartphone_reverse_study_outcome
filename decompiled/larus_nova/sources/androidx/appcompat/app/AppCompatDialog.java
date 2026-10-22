package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.ActionMode;
import androidx.core.view.KeyEventDispatcher;
import com.bytedance.crash.d;
import com.larus.home.impl.utils.c;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes2.dex */
public class AppCompatDialog extends Dialog implements AppCompatCallback {
    private AppCompatDelegate mDelegate;
    private final KeyEventDispatcher.Component mKeyDispatcher;

    public static /* synthetic */ void access$000(Dialog r100) {
        super.dismiss();
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeFinished(ActionMode r100) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeStarted(ActionMode r100) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback r100) {
        return null;
    }

    public AppCompatDelegate getDelegate() {
        if (this.mDelegate != null) goto L6;
        this.mDelegate = AppCompatDelegate.create(this, this);
    L6:
        return this.mDelegate;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        INVOKESPECIAL_androidx_appcompat_app_AppCompatDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this);
        getDelegate().onDestroy();
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().getSupportActionBar();
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        getDelegate().onStop();
    }

    public AppCompatDialog(Context r100) {
        this(r100, 0);
    }

    public static void INVOKESPECIAL_androidx_appcompat_app_AppCompatDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(Dialog r100) {
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

    public static View INVOKEVIRTUAL_androidx_appcompat_app_AppCompatDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent r100) {
        View r101 = INVOKEVIRTUAL_androidx_appcompat_app_AppCompatDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow());
        return KeyEventDispatcher.dispatchKeyEvent(this.mKeyDispatcher, r101, this, r100);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int r100) {
        return (T) getDelegate().findViewById(r100);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r100) {
        getDelegate().installViewFactory();
        super.onCreate(r100);
        getDelegate().onCreate(r100);
    }

    @Override // android.app.Dialog
    public void setContentView(int r100) {
        getDelegate().setContentView(r100);
    }

    @Override // android.app.Dialog
    public void setTitle(int r100) {
        super.setTitle(r100);
        getDelegate().setTitle(getContext().getString(r100));
    }

    boolean superDispatchKeyEvent(KeyEvent r100) {
        return super.dispatchKeyEvent(r100);
    }

    public boolean supportRequestWindowFeature(int r100) {
        return getDelegate().requestWindowFeature(r100);
    }

    @Override // android.app.Dialog
    public void setContentView(View r100) {
        getDelegate().setContentView(r100);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence r100) {
        super.setTitle(r100);
        getDelegate().setTitle(r100);
    }

    public AppCompatDialog(Context r100, int r101) {
        super(r100, getThemeResId(r100, r101));
        this.mKeyDispatcher = new AnonymousClass1(this);
        AppCompatDelegate r102 = getDelegate();
        r102.setTheme(getThemeResId(r100, r101));
        r102.onCreate(null);
    }

    private static int getThemeResId(Context r100, int r101) {
        if (r101 != 0) goto L5;
        TypedValue r102 = new TypedValue();
        r100.getTheme().resolveAttribute(R.attr.dialogTheme, r102, true);
        return r102.resourceId;
    L5:
        return r101;
    }

    @Override // android.app.Dialog
    public void addContentView(View r100, ViewGroup.LayoutParams r101) {
        getDelegate().addContentView(r100, r101);
    }

    @Override // android.app.Dialog
    public void setContentView(View r100, ViewGroup.LayoutParams r101) {
        getDelegate().setContentView(r100, r101);
    }

    public AppCompatDialog(Context r100, boolean r101, DialogInterface.OnCancelListener r102) {
        super(r100, r101, r102);
        this.mKeyDispatcher = new AnonymousClass1(this);
    }
}
