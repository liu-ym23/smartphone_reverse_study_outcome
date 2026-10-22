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
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import stepos.support.v7.widget.v1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class p0 implements Window.Callback {

    /* renamed from: c, reason: collision with root package name */
    public Window.Callback f12411c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ q0 f12412f;

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f12411c.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f12411c.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f12411c.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f12411c.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f12411c.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f12411c.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode actionMode) {
        this.f12411c.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode actionMode) {
        this.f12411c.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.f12411c.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        this.f12411c.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        return this.f12411c.onCreatePanelMenu(i, menu);
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int i) {
        te.i iVar;
        Window.Callback callback = this.f12411c;
        q0 q0Var = this.f12412f;
        v1 v1Var = q0Var.f12452a;
        if (i == 0) {
            Menu menu = v1Var.f12871a.getMenu();
            if (onPreparePanel(i, null, menu) && callback.onMenuOpened(i, menu)) {
                if (q0Var.f12458g == null && (menu instanceof te.l)) {
                    te.l lVar = (te.l) menu;
                    Context context = v1Var.f12871a.getContext();
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(context.getTheme());
                    themeNewTheme.resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true);
                    int i3 = typedValue.resourceId;
                    if (i3 != 0) {
                        themeNewTheme.applyStyle(i3, true);
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
                    te.i iVar2 = new te.i(contextThemeWrapper);
                    q0Var.f12458g = iVar2;
                    o0 o0Var = new o0();
                    o0Var.f12408c = q0Var;
                    VarHandle.storeStoreFence();
                    iVar2.i = o0Var;
                    lVar.b(iVar2, lVar.f13343a);
                }
                if (menu == null || (iVar = q0Var.f12458g) == null || ((l.g) iVar.h()).getCount() <= 0) {
                    return null;
                }
                return (View) q0Var.f12458g.i(v1Var.f12871a);
            }
        }
        return callback.onCreatePanelView(i);
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.f12411c.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.f12411c.onMenuItemSelected(i, menuItem);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int i, Menu menu) {
        return this.f12411c.onMenuOpened(i, menu);
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int i, Menu menu) {
        this.f12411c.onPanelClosed(i, menu);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        boolean zOnPreparePanel = this.f12411c.onPreparePanel(i, view, menu);
        if (zOnPreparePanel) {
            q0 q0Var = this.f12412f;
            if (!q0Var.f12453b) {
                q0Var.f12452a.f12881l = true;
                q0Var.f12453b = true;
            }
        }
        return zOnPreparePanel;
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        return this.f12411c.onSearchRequested(searchEvent);
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f12411c.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z10) {
        this.f12411c.onWindowFocusChanged(z10);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f12411c.onWindowStartingActionMode(callback);
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.f12411c.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        return this.f12411c.onWindowStartingActionMode(callback, i);
    }
}
