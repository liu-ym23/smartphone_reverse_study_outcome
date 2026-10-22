package g1;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: classes.dex */
public abstract class g implements Window.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Window.Callback f19887a;

    public g(Window.Callback r10) {
        this.f19887a = r10;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent r10) {
        return this.f19887a.dispatchGenericMotionEvent(r10);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent r10) {
        return this.f19887a.dispatchKeyShortcutEvent(r10);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r10) {
        return this.f19887a.dispatchPopulateAccessibilityEvent(r10);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent r10) {
        return this.f19887a.dispatchTrackballEvent(r10);
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(ActionMode r10) {
        this.f19887a.onActionModeFinished(r10);
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(ActionMode r10) {
        this.f19887a.onActionModeStarted(r10);
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        this.f19887a.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
        this.f19887a.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int r10, Menu r11) {
        return this.f19887a.onCreatePanelMenu(r10, r11);
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int r10) {
        return this.f19887a.onCreatePanelView(r10);
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f19887a.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int r10, MenuItem r11) {
        return this.f19887a.onMenuItemSelected(r10, r11);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int r10, Menu r11) {
        return this.f19887a.onMenuOpened(r10, r11);
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int r10, Menu r11) {
        this.f19887a.onPanelClosed(r10, r11);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int r10, View r11, Menu r12) {
        return this.f19887a.onPreparePanel(r10, r11, r12);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.f19887a.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams r10) {
        this.f19887a.onWindowAttributesChanged(r10);
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean r10) {
        this.f19887a.onWindowFocusChanged(r10);
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback r10) {
        return this.f19887a.onWindowStartingActionMode(r10);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent r10) {
        return this.f19887a.onSearchRequested(r10);
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback r10, int r11) {
        return this.f19887a.onWindowStartingActionMode(r10, r11);
    }
}
