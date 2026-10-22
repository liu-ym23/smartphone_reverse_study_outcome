package g;

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
import androidx.annotation.DoNotInline;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class e implements Window.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Window.Callback f19779a;

    public static class a {
        @DoNotInline
        public static boolean a(Window.Callback r10, SearchEvent r11) {
            return r10.onSearchRequested(r11);
        }

        @DoNotInline
        public static ActionMode b(Window.Callback r10, ActionMode.Callback r11, int r12) {
            return r10.onWindowStartingActionMode(r11, r12);
        }
    }

    public static class b {
        @DoNotInline
        public static void a(Window.Callback r10, List<KeyboardShortcutGroup> r11, Menu r12, int r13) {
            r10.onProvideKeyboardShortcuts(r11, r12, r13);
        }
    }

    public static class c {
        @DoNotInline
        public static void a(Window.Callback r10, boolean r11) {
            r10.onPointerCaptureChanged(r11);
        }
    }

    public e(Window.Callback r10) {
        if (r10 == null) goto L7;
        this.f19779a = r10;
        return;
    L7:
        throw new IllegalArgumentException("Window callback may not be null");
    }

    public final Window.Callback a() {
        return this.f19779a;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent r10) {
        return this.f19779a.dispatchGenericMotionEvent(r10);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent r10) {
        return this.f19779a.dispatchKeyEvent(r10);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent r10) {
        return this.f19779a.dispatchKeyShortcutEvent(r10);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r10) {
        return this.f19779a.dispatchPopulateAccessibilityEvent(r10);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent r10) {
        return this.f19779a.dispatchTouchEvent(r10);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent r10) {
        return this.f19779a.dispatchTrackballEvent(r10);
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(ActionMode r10) {
        this.f19779a.onActionModeFinished(r10);
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(ActionMode r10) {
        this.f19779a.onActionModeStarted(r10);
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        this.f19779a.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int r10, Menu r11) {
        return this.f19779a.onCreatePanelMenu(r10, r11);
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int r10) {
        return this.f19779a.onCreatePanelView(r10);
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f19779a.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int r10, MenuItem r11) {
        return this.f19779a.onMenuItemSelected(r10, r11);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int r10, Menu r11) {
        return this.f19779a.onMenuOpened(r10, r11);
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int r10, Menu r11) {
        this.f19779a.onPanelClosed(r10, r11);
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean r10) {
        c.a(this.f19779a, r10);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int r10, View r11, Menu r12) {
        return this.f19779a.onPreparePanel(r10, r11, r12);
    }

    @Override // android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List r10, Menu r11, int r12) {
        b.a(this.f19779a, r10, r11, r12);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent r10) {
        return a.a(this.f19779a, r10);
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams r10) {
        this.f19779a.onWindowAttributesChanged(r10);
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean r10) {
        this.f19779a.onWindowFocusChanged(r10);
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback r10, int r11) {
        return a.b(this.f19779a, r10, r11);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.f19779a.onSearchRequested();
    }
}
