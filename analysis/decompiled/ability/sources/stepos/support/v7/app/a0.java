package stepos.support.v7.app;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.R;
import stepos.support.v7.widget.G0;

/* loaded from: classes4.dex */
public final class a0 implements Window.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final Window.Callback f6290a;
    public final /* synthetic */ b0 b;

    public a0(b0 b0Var, Window.Callback callback) {
        this.b = b0Var;
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.f6290a = callback;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f6290a.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f6290a.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f6290a.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f6290a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f6290a.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f6290a.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode actionMode) {
        this.f6290a.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode actionMode) {
        this.f6290a.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.f6290a.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        this.f6290a.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        return this.f6290a.onCreatePanelMenu(i, menu);
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int i) {
        Va.k kVar;
        Window.Callback callback = this.f6290a;
        if (i == 0) {
            b0 b0Var = this.b;
            Menu menu = b0Var.f6292a.f6462a.getMenu();
            if (onPreparePanel(i, null, menu) && callback.onMenuOpened(i, menu)) {
                G0 g02 = b0Var.f6292a;
                if (b0Var.g == null && (menu instanceof Va.n)) {
                    Va.n nVar = (Va.n) menu;
                    Context context = g02.f6462a.getContext();
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(context.getTheme());
                    themeNewTheme.resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true);
                    int i6 = typedValue.resourceId;
                    if (i6 != 0) {
                        themeNewTheme.applyStyle(i6, true);
                    }
                    themeNewTheme.resolveAttribute(R.attr.panelMenuListTheme, typedValue, true);
                    int i10 = typedValue.resourceId;
                    if (i10 != 0) {
                        themeNewTheme.applyStyle(i10, true);
                    } else {
                        themeNewTheme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
                    }
                    ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
                    contextThemeWrapper.getTheme().setTo(themeNewTheme);
                    Va.k kVar2 = new Va.k(contextThemeWrapper);
                    b0Var.g = kVar2;
                    kVar2.e = new B1.c(b0Var);
                    nVar.b(kVar2, nVar.f1442a);
                }
                if (menu == null || (kVar = b0Var.g) == null || ((Va.j) kVar.e()).getCount() <= 0) {
                    return null;
                }
                return (View) b0Var.g.g(g02.f6462a);
            }
        }
        return callback.onCreatePanelView(i);
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.f6290a.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.f6290a.onMenuItemSelected(i, menuItem);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int i, Menu menu) {
        return this.f6290a.onMenuOpened(i, menu);
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int i, Menu menu) {
        this.f6290a.onPanelClosed(i, menu);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        boolean zOnPreparePanel = this.f6290a.onPreparePanel(i, view, menu);
        if (zOnPreparePanel) {
            b0 b0Var = this.b;
            if (!b0Var.b) {
                b0Var.f6292a.l = true;
                b0Var.b = true;
            }
        }
        return zOnPreparePanel;
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        return this.f6290a.onSearchRequested(searchEvent);
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f6290a.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z10) {
        this.f6290a.onWindowFocusChanged(z10);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f6290a.onWindowStartingActionMode(callback);
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.f6290a.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        return this.f6290a.onWindowStartingActionMode(callback, i);
    }
}
