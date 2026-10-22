package androidx.appcompat.app;

import K.S;
import K.e0;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.PopupWindow;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ViewStubCompat;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import j.AbstractC0624c;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import k.C0661o;

/* loaded from: classes.dex */
public final class y extends j.q {

    /* renamed from: b, reason: collision with root package name */
    public boolean f2684b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2685c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2686d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ F f2687e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(F f4, Window.Callback callback) {
        super(callback);
        this.f2687e = f4;
    }

    public final void a(Window.Callback callback) {
        try {
            this.f2684b = true;
            callback.onContentChanged();
        } finally {
            this.f2684b = false;
        }
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z4 = this.f2685c;
        Window.Callback callback = this.f13116a;
        return z4 ? callback.dispatchKeyEvent(keyEvent) : this.f2687e.g(keyEvent) || callback.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        M m4;
        C0661o c0661o;
        if (this.f13116a.dispatchKeyShortcutEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        F f4 = this.f2687e;
        N nP = f4.p();
        if (nP != null && (m4 = nP.f2567j) != null && (c0661o = m4.f2553d) != null) {
            c0661o.setQwertyMode(KeyCharacterMap.load(keyEvent.getDeviceId()).getKeyboardType() != 1);
            if (c0661o.performShortcut(keyCode, keyEvent, 0)) {
                return true;
            }
        }
        E e4 = f4.f2491F;
        if (e4 != null && f4.u(e4, keyEvent.getKeyCode(), keyEvent)) {
            E e5 = f4.f2491F;
            if (e5 == null) {
                return true;
            }
            e5.f2478l = true;
            return true;
        }
        if (f4.f2491F == null) {
            E eO = f4.o(0);
            f4.v(eO, keyEvent);
            boolean zU = f4.u(eO, keyEvent.getKeyCode(), keyEvent);
            eO.f2477k = false;
            if (zU) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        if (this.f2684b) {
            this.f13116a.onContentChanged();
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i4, Menu menu) {
        if (i4 != 0 || (menu instanceof C0661o)) {
            return this.f13116a.onCreatePanelMenu(i4, menu);
        }
        return false;
    }

    @Override // j.q, android.view.Window.Callback
    public final View onCreatePanelView(int i4) {
        return this.f13116a.onCreatePanelView(i4);
    }

    @Override // j.q, android.view.Window.Callback
    public final boolean onMenuOpened(int i4, Menu menu) {
        super.onMenuOpened(i4, menu);
        F f4 = this.f2687e;
        if (i4 == 108) {
            N nP = f4.p();
            if (nP != null && true != nP.f2570m) {
                nP.f2570m = true;
                ArrayList arrayList = nP.f2571n;
                if (arrayList.size() > 0) {
                    B0.g.y(arrayList.get(0));
                    throw null;
                }
            }
        } else {
            f4.getClass();
        }
        return true;
    }

    @Override // j.q, android.view.Window.Callback
    public final void onPanelClosed(int i4, Menu menu) {
        if (this.f2686d) {
            this.f13116a.onPanelClosed(i4, menu);
            return;
        }
        super.onPanelClosed(i4, menu);
        F f4 = this.f2687e;
        if (i4 != 108) {
            if (i4 != 0) {
                f4.getClass();
                return;
            }
            E eO = f4.o(i4);
            if (eO.f2479m) {
                f4.f(eO, false);
                return;
            }
            return;
        }
        N nP = f4.p();
        if (nP == null || !nP.f2570m) {
            return;
        }
        nP.f2570m = false;
        ArrayList arrayList = nP.f2571n;
        if (arrayList.size() <= 0) {
            return;
        }
        B0.g.y(arrayList.get(0));
        throw null;
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i4, View view, Menu menu) {
        C0661o c0661o = menu instanceof C0661o ? (C0661o) menu : null;
        if (i4 == 0 && c0661o == null) {
            return false;
        }
        if (c0661o != null) {
            c0661o.f13261x = true;
        }
        boolean zOnPreparePanel = this.f13116a.onPreparePanel(i4, view, menu);
        if (c0661o != null) {
            c0661o.f13261x = false;
        }
        return zOnPreparePanel;
    }

    @Override // j.q, android.view.Window.Callback
    public final void onProvideKeyboardShortcuts(List list, Menu menu, int i4) {
        C0661o c0661o = this.f2687e.o(0).f2474h;
        if (c0661o != null) {
            super.onProvideKeyboardShortcuts(list, c0661o, i4);
        } else {
            super.onProvideKeyboardShortcuts(list, menu, i4);
        }
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i4) {
        ViewGroup viewGroup;
        F f4 = this.f2687e;
        if (!f4.f2525r || i4 != 0) {
            return j.n.b(this.f13116a, callback, i4);
        }
        j.g gVar = new j.g(f4.f2512e, callback, 0);
        AbstractC0624c abstractC0624c = f4.f2520m;
        if (abstractC0624c != null) {
            abstractC0624c.a();
        }
        u uVar = new u(f4, gVar);
        N nP = f4.p();
        int i5 = 1;
        if (nP != null) {
            M m4 = nP.f2567j;
            if (m4 != null) {
                m4.a();
            }
            nP.f2561d.setHideOnContentScrollEnabled(false);
            nP.f2564g.e();
            M m5 = new M(nP, nP.f2564g.getContext(), uVar);
            C0661o c0661o = m5.f2553d;
            c0661o.w();
            try {
                if (m5.f2554e.c(m5, c0661o)) {
                    nP.f2567j = m5;
                    m5.g();
                    nP.f2564g.c(m5);
                    nP.d0(true);
                } else {
                    m5 = null;
                }
                f4.f2520m = m5;
            } finally {
                c0661o.v();
            }
        }
        if (f4.f2520m == null) {
            e0 e0Var = f4.f2524q;
            if (e0Var != null) {
                e0Var.b();
            }
            AbstractC0624c abstractC0624c2 = f4.f2520m;
            if (abstractC0624c2 != null) {
                abstractC0624c2.a();
            }
            if (f4.f2521n == null) {
                if (f4.f2487B) {
                    TypedValue typedValue = new TypedValue();
                    Context context = f4.f2512e;
                    Resources.Theme theme = context.getTheme();
                    theme.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = context.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        j.e eVar = new j.e(context, 0);
                        eVar.getTheme().setTo(themeNewTheme);
                        context = eVar;
                    }
                    f4.f2521n = new ActionBarContextView(context, null);
                    PopupWindow popupWindow = new PopupWindow(context, (AttributeSet) null, R.attr.actionModePopupWindowStyle);
                    f4.f2522o = popupWindow;
                    androidx.core.widget.k.d(popupWindow, 2);
                    f4.f2522o.setContentView(f4.f2521n);
                    f4.f2522o.setWidth(-1);
                    context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
                    f4.f2521n.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                    f4.f2522o.setHeight(-2);
                    f4.f2523p = new r(f4, i5);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) f4.f2527t.findViewById(R.id.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(f4.l()));
                        f4.f2521n = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (f4.f2521n != null) {
                e0 e0Var2 = f4.f2524q;
                if (e0Var2 != null) {
                    e0Var2.b();
                }
                f4.f2521n.e();
                Context context2 = f4.f2521n.getContext();
                ActionBarContextView actionBarContextView = f4.f2521n;
                j.f fVar = new j.f();
                fVar.f13053c = context2;
                fVar.f13054d = actionBarContextView;
                fVar.f13055e = uVar;
                C0661o c0661o2 = new C0661o(actionBarContextView.getContext());
                c0661o2.f13249l = 1;
                fVar.f13058h = c0661o2;
                c0661o2.f13242e = fVar;
                if (uVar.f2682a.c(fVar, c0661o2)) {
                    fVar.g();
                    f4.f2521n.c(fVar);
                    f4.f2520m = fVar;
                    if (f4.f2526s && (viewGroup = f4.f2527t) != null && viewGroup.isLaidOut()) {
                        f4.f2521n.setAlpha(Property.DEFAULT_FLOAT_VALUE);
                        e0 e0VarA = S.a(f4.f2521n);
                        e0VarA.a(1.0f);
                        f4.f2524q = e0VarA;
                        e0VarA.e(new t(i5, f4));
                    } else {
                        f4.f2521n.setAlpha(1.0f);
                        f4.f2521n.setVisibility(0);
                        if (f4.f2521n.getParent() instanceof View) {
                            View view = (View) f4.f2521n.getParent();
                            WeakHashMap weakHashMap = S.f939a;
                            K.H.c(view);
                        }
                    }
                    if (f4.f2522o != null) {
                        f4.f2513f.getDecorView().post(f4.f2523p);
                    }
                } else {
                    f4.f2520m = null;
                }
            }
            f4.y();
            f4.f2520m = f4.f2520m;
        }
        f4.y();
        AbstractC0624c abstractC0624c3 = f4.f2520m;
        if (abstractC0624c3 != null) {
            return gVar.j(abstractC0624c3);
        }
        return null;
    }
}
