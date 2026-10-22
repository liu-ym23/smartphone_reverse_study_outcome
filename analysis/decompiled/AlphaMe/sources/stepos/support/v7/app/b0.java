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
import com.stepos.alphame.R;
import stepos.support.v7.widget.w0;

/* loaded from: classes2.dex */
public final class b0 implements Window.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final Window.Callback f14435a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c0 f14436b;

    public b0(c0 c0Var, Window.Callback callback) {
        this.f14436b = c0Var;
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.f14435a = callback;
    }

    @Override // android.view.Window.Callback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void onActionModeFinished(ActionMode actionMode) {
        this.f14435a.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void onActionModeStarted(ActionMode actionMode) {
        this.f14435a.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final void onAttachedToWindow() {
        this.f14435a.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final void onContentChanged() {
        this.f14435a.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f14435a.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f14435a.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f14435a.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f14435a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f14435a.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f14435a.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final void onDetachedFromWindow() {
        this.f14435a.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final void onPanelClosed(int i4, Menu menu) {
        this.f14435a.onPanelClosed(i4, menu);
    }

    @Override // android.view.Window.Callback
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f14435a.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final void onWindowFocusChanged(boolean z4) {
        this.f14435a.onWindowFocusChanged(z4);
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i4, Menu menu) {
        return this.f14435a.onCreatePanelMenu(i4, menu);
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int i4) {
        L3.h hVar;
        Window.Callback callback = this.f14435a;
        if (i4 == 0) {
            c0 c0Var = this.f14436b;
            Menu menu = c0Var.f14438a.f15201a.getMenu();
            if (onPreparePanel(i4, null, menu) && callback.onMenuOpened(i4, menu)) {
                L3.h hVar2 = c0Var.f14444g;
                w0 w0Var = c0Var.f14438a;
                if (hVar2 == null && (menu instanceof L3.k)) {
                    L3.k kVar = (L3.k) menu;
                    Context context = w0Var.f15201a.getContext();
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(context.getTheme());
                    themeNewTheme.resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true);
                    int i5 = typedValue.resourceId;
                    if (i5 != 0) {
                        themeNewTheme.applyStyle(i5, true);
                    }
                    themeNewTheme.resolveAttribute(R.attr.panelMenuListTheme, typedValue, true);
                    int i6 = typedValue.resourceId;
                    if (i6 != 0) {
                        themeNewTheme.applyStyle(i6, true);
                    } else {
                        themeNewTheme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
                    }
                    ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
                    contextThemeWrapper.getTheme().setTo(themeNewTheme);
                    L3.h hVar3 = new L3.h(contextThemeWrapper);
                    c0Var.f14444g = hVar3;
                    hVar3.f1278e = new a0(c0Var, 3);
                    kVar.b(hVar3, kVar.f1281a);
                }
                if (menu == null || (hVar = c0Var.f14444g) == null || hVar.b().getCount() <= 0) {
                    return null;
                }
                return (View) c0Var.f14444g.i(w0Var.f15201a);
            }
        }
        return callback.onCreatePanelView(i4);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int i4, MenuItem menuItem) {
        return this.f14435a.onMenuItemSelected(i4, menuItem);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int i4, Menu menu) {
        return this.f14435a.onMenuOpened(i4, menu);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i4, View view, Menu menu) {
        boolean zOnPreparePanel = this.f14435a.onPreparePanel(i4, view, menu);
        if (zOnPreparePanel) {
            c0 c0Var = this.f14436b;
            if (!c0Var.f14439b) {
                c0Var.f14438a.f15212l = true;
                c0Var.f14439b = true;
            }
        }
        return zOnPreparePanel;
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        return this.f14435a.onSearchRequested(searchEvent);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f14435a.onWindowStartingActionMode(callback);
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.f14435a.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i4) {
        return this.f14435a.onWindowStartingActionMode(callback, i4);
    }
}
