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
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
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

    public MonitorWindowCallback(Window.Callback r3) {
        this.callback = (Window.Callback) ZeusTransformUtils.wrapperContextForParams(r3, Window.Callback.class, "com.obric.aiagent.plugin");
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
    public boolean onCreatePanelMenu(int r3, Menu r4) {
        Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin");
        return this.callback.onCreatePanelMenu(r3, r5);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int r3, View r4, Menu r5) {
        Menu r6 = (Menu) ZeusTransformUtils.wrapperContextForParams(r5, Menu.class, "com.obric.aiagent.plugin");
        return this.callback.onPreparePanel(r3, r4, r6);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int r3, Menu r4) {
        Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin");
        return this.callback.onMenuOpened(r3, r5);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int r3, MenuItem r4) {
        MenuItem r5 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r4, MenuItem.class, "com.obric.aiagent.plugin");
        return this.callback.onMenuItemSelected(r3, r5);
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
    public void onPanelClosed(int r3, Menu r4) {
        Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin");
        this.callback.onPanelClosed(r3, r5);
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
    public ActionMode onWindowStartingActionMode(ActionMode.Callback r3) {
        ActionMode.Callback r4 = (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r3, ActionMode.Callback.class, "com.obric.aiagent.plugin");
        return this.callback.onWindowStartingActionMode(r4);
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback r3, int r4) {
        ActionMode.Callback r5 = (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r3, ActionMode.Callback.class, "com.obric.aiagent.plugin");
        return this.callback.onWindowStartingActionMode(r5, r4);
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
