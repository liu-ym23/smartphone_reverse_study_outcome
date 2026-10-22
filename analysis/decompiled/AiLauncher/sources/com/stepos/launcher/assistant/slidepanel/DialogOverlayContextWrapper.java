package com.stepos.launcher.assistant.slidepanel;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.stepos.launcher.assistant.utils.Utils;
import com.stepos.launcher.client.R$style;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes.dex */
public class DialogOverlayContextWrapper extends ContextThemeWrapper implements Window.Callback {
    public static final String TAG = "DialogOverlayContextWrapper";
    public View mDecorView;
    public final Window mWindow;
    protected final Context mWindowContext;
    protected final WindowManager mWindowContextWm;
    public WindowManager mWindowManager;

    public DialogOverlayContextWrapper(Context context, int i10) {
        super(context, i10);
        Log.e(TAG, TAG);
        Window window = new Dialog(context, R$style.AssistantOverlayWindowTheme).getWindow();
        this.mWindow = window;
        if (Utils.ATLEAST_S) {
            Context contextCreateWindowContext = context.createWindowContext(2, null);
            this.mWindowContext = contextCreateWindowContext;
            this.mWindowContextWm = (WindowManager) contextCreateWindowContext.getSystemService(WindowManager.class);
        } else {
            this.mWindowContext = null;
            this.mWindowContextWm = null;
        }
        if (window == null) {
            throw new IllegalStateException("new Dialog has no window?");
        }
        Log.e(TAG, "setCallback");
        window.setCallback(this);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.mWindow.superDispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
            Log.e(TAG, "dispatchKeyEvent");
            return this.mWindow.superDispatchKeyEvent(keyEvent);
        }
        Log.e(TAG, "onBackPressed");
        onBackPressed();
        return true;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.mWindow.superDispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.mWindow.superDispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.mWindow.superDispatchTrackballEvent(motionEvent);
    }

    public boolean isAttachToWindow() {
        return false;
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
    }

    public void onBackPressed() {
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int i10, Menu menu) {
        return false;
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int i10) {
        return null;
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        return false;
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int i10, Menu menu) {
        return true;
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int i10, Menu menu) {
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int i10, View view, Menu menu) {
        return true;
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        return false;
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        if (isAttachToWindow()) {
            this.mWindowManager.updateViewLayout(this.mDecorView, layoutParams);
        }
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        super.startActivity(intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY));
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent searchEvent) {
        return false;
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i10) {
        return null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        super.startActivity(intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY), bundle);
    }
}
