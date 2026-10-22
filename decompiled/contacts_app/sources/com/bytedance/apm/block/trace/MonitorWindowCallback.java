package com.bytedance.apm.block.trace;

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

/* JADX INFO: loaded from: classes2.dex */
public abstract class MonitorWindowCallback implements Window.Callback {
    protected Window.Callback callback;

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent r1) {
        return this.callback.dispatchKeyShortcutEvent(r1);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent r1) {
        return this.callback.dispatchTrackballEvent(r1);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent r1) {
        return this.callback.dispatchGenericMotionEvent(r1);
    }

    public MonitorWindowCallback(Window.Callback r1) {
        this.callback = r1;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r1) {
        return this.callback.dispatchPopulateAccessibilityEvent(r1);
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int r1) {
        return this.callback.onCreatePanelView(r1);
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int r1, Menu r2) {
        return this.callback.onCreatePanelMenu(r1, r2);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int r1, View r2, Menu r3) {
        return this.callback.onPreparePanel(r1, r2, r3);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int r1, Menu r2) {
        return this.callback.onMenuOpened(r1, r2);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int r1, MenuItem r2) {
        return this.callback.onMenuItemSelected(r1, r2);
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams r1) {
        this.callback.onWindowAttributesChanged(r1);
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
        this.callback.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean r1) {
        this.callback.onWindowFocusChanged(r1);
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        this.callback.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.callback.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int r1, Menu r2) {
        this.callback.onPanelClosed(r1, r2);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.callback.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent r1) {
        return this.callback.onSearchRequested(r1);
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback r1) {
        return this.callback.onWindowStartingActionMode(r1);
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback r1, int r2) {
        return this.callback.onWindowStartingActionMode(r1, r2);
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(ActionMode r1) {
        this.callback.onActionModeStarted(r1);
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(ActionMode r1) {
        this.callback.onActionModeFinished(r1);
    }
}
