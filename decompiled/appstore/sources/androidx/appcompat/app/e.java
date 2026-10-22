package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentDialog;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$attr;
import androidx.appcompat.view.ActionMode;
import androidx.core.view.KeyEventDispatcher;

/* JADX INFO: loaded from: classes.dex */
public class e extends ComponentDialog implements AppCompatCallback {
    private AppCompatDelegate mDelegate;
    private final KeyEventDispatcher.Component mKeyDispatcher;

    public e(Context r10, int r11) {
        super(r10, getThemeResId(r10, r11));
        this.mKeyDispatcher = new d(this);
        AppCompatDelegate r12 = getDelegate();
        r12.L(getThemeResId(r10, r11));
        r12.w(null);
    }

    private static int getThemeResId(Context r10, int r11) {
        if (r11 != 0) goto L5;
        TypedValue r12 = new TypedValue();
        r10.getTheme().resolveAttribute(R$attr.dialogTheme, r12, true);
        return r12.resourceId;
    L5:
        return r11;
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void addContentView(@NonNull View r10, ViewGroup.LayoutParams r11) {
        getDelegate().c(r10, r11);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        getDelegate().x();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent r10) {
        View r11 = getWindow().getDecorView();
        return KeyEventDispatcher.b(this.mKeyDispatcher, r11, this, r10);
    }

    @Override // android.app.Dialog
    @Nullable
    public <T extends View> T findViewById(@IdRes int r10) {
        return (T) getDelegate().h(r10);
    }

    @NonNull
    public AppCompatDelegate getDelegate() {
        if (this.mDelegate != null) goto L6;
        this.mDelegate = AppCompatDelegate.g(this, this);
    L6:
        return this.mDelegate;
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().q();
    }

    @Override // android.app.Dialog
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void invalidateOptionsMenu() {
        getDelegate().s();
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void onCreate(Bundle r10) {
        getDelegate().r();
        super.onCreate(r10);
        getDelegate().w(r10);
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void onStop() {
        super.onStop();
        getDelegate().C();
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeFinished(ActionMode r10) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeStarted(ActionMode r10) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    @Nullable
    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback r10) {
        return null;
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(int r10) {
        getDelegate().G(r10);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence r10) {
        super.setTitle(r10);
        getDelegate().M(r10);
    }

    public boolean superDispatchKeyEvent(KeyEvent r10) {
        return super.dispatchKeyEvent(r10);
    }

    public boolean supportRequestWindowFeature(int r10) {
        return getDelegate().F(r10);
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r10) {
        getDelegate().H(r10);
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r10, ViewGroup.LayoutParams r11) {
        getDelegate().I(r10, r11);
    }

    @Override // android.app.Dialog
    public void setTitle(int r10) {
        super.setTitle(r10);
        getDelegate().M(getContext().getString(r10));
    }

    public e(Context r10, boolean r11, DialogInterface.OnCancelListener r12) {
        super(r10);
        this.mKeyDispatcher = new d(this);
        setCancelable(r11);
        setOnCancelListener(r12);
    }
}
