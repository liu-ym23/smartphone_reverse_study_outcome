package androidx.appcompat.view;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class WindowCallbackWrapper implements Window.Callback {
    final Window.Callback mWrapped;

    static class a {
        static boolean a(Window.Callback r2, SearchEvent r3) {
            return ((Window.Callback) ZeusTransformUtils.wrapperContextForParams(r2, Window.Callback.class, "com.obric.aiagent.plugin")).onSearchRequested(r3);
        }

        static ActionMode a(Window.Callback r2, ActionMode.Callback r3, int r4) {
            return ((Window.Callback) ZeusTransformUtils.wrapperContextForParams(r2, Window.Callback.class, "com.obric.aiagent.plugin")).onWindowStartingActionMode((ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r3, ActionMode.Callback.class, "com.obric.aiagent.plugin"), r4);
        }
    }

    static class b {
        static void a(Window.Callback r2, List<KeyboardShortcutGroup> r3, Menu r4, int r5) {
            ((Window.Callback) ZeusTransformUtils.wrapperContextForParams(r2, Window.Callback.class, "com.obric.aiagent.plugin")).onProvideKeyboardShortcuts((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin"), r5);
        }
    }

    static class c {
        static void a(Window.Callback r2, boolean r3) {
            ((Window.Callback) ZeusTransformUtils.wrapperContextForParams(r2, Window.Callback.class, "com.obric.aiagent.plugin")).onPointerCaptureChanged(r3);
        }
    }

    public WindowCallbackWrapper(Window.Callback r3) {
        Window.Callback r4 = (Window.Callback) ZeusTransformUtils.wrapperContextForParams(r3, Window.Callback.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L7;
        this.mWrapped = r4;
        return;
    L7:
        throw new IllegalArgumentException("Window callback may not be null");
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent r1) {
        return this.mWrapped.dispatchKeyEvent(r1);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent r1) {
        return this.mWrapped.dispatchKeyShortcutEvent(r1);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent r1) {
        return this.mWrapped.dispatchTouchEvent(r1);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent r1) {
        return this.mWrapped.dispatchTrackballEvent(r1);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent r1) {
        return this.mWrapped.dispatchGenericMotionEvent(r1);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r1) {
        return this.mWrapped.dispatchPopulateAccessibilityEvent(r1);
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int r1) {
        return this.mWrapped.onCreatePanelView(r1);
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int r3, Menu r4) {
        Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin");
        return this.mWrapped.onCreatePanelMenu(r3, r5);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int r3, View r4, Menu r5) {
        Menu r6 = (Menu) ZeusTransformUtils.wrapperContextForParams(r5, Menu.class, "com.obric.aiagent.plugin");
        return this.mWrapped.onPreparePanel(r3, r4, r6);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int r3, Menu r4) {
        Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin");
        return this.mWrapped.onMenuOpened(r3, r5);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int r3, MenuItem r4) {
        MenuItem r5 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r4, MenuItem.class, "com.obric.aiagent.plugin");
        return this.mWrapped.onMenuItemSelected(r3, r5);
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams r1) {
        this.mWrapped.onWindowAttributesChanged(r1);
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
        this.mWrapped.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean r1) {
        this.mWrapped.onWindowFocusChanged(r1);
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        this.mWrapped.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.mWrapped.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int r3, Menu r4) {
        Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin");
        this.mWrapped.onPanelClosed(r3, r5);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent r1) {
        return a.a(this.mWrapped, r1);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.mWrapped.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback r3) {
        ActionMode.Callback r4 = (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r3, ActionMode.Callback.class, "com.obric.aiagent.plugin");
        return this.mWrapped.onWindowStartingActionMode(r4);
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback r3, int r4) {
        ActionMode.Callback r5 = (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r3, ActionMode.Callback.class, "com.obric.aiagent.plugin");
        return a.a(this.mWrapped, r5, r4);
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(ActionMode r1) {
        this.mWrapped.onActionModeStarted(r1);
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(ActionMode r1) {
        this.mWrapped.onActionModeFinished(r1);
    }

    @Override // android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> r3, Menu r4, int r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        Menu r7 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin");
        b.a(this.mWrapped, r6, r7, r5);
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean r1) {
        c.a(this.mWrapped, r1);
    }

    public final Window.Callback getWrapped() {
        return this.mWrapped;
    }
}
