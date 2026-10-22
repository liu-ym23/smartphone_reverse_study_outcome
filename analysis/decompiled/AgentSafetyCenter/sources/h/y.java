package h;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.PopupWindow;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ViewStubCompat;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import p.p0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y extends k.o {

    /* renamed from: f, reason: collision with root package name */
    public boolean f4897f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f4898g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f4899h;
    public final /* synthetic */ e0 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(e0 e0Var, Window.Callback callback) {
        super(callback);
        this.i = e0Var;
    }

    public final void a(Window.Callback callback) {
        try {
            this.f4897f = true;
            callback.onContentChanged();
        } finally {
            this.f4897f = false;
        }
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z10 = this.f4898g;
        Window.Callback callback = this.f6859c;
        return z10 ? callback.dispatchKeyEvent(keyEvent) : this.i.s(keyEvent) || callback.dispatchKeyEvent(keyEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006e A[RETURN] */
    @Override // android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchKeyShortcutEvent(android.view.KeyEvent r6) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r5 = this;
            android.view.Window$Callback r0 = r5.f6859c
            boolean r0 = r0.dispatchKeyShortcutEvent(r6)
            r1 = 1
            if (r0 != 0) goto L6f
            int r0 = r6.getKeyCode()
            h.e0 r5 = r5.i
            r5.y()
            h.o0 r2 = r5.f4798p
            r3 = 0
            if (r2 == 0) goto L3d
            h.n0 r2 = r2.i
            if (r2 != 0) goto L1d
        L1b:
            r0 = r3
            goto L39
        L1d:
            l.l r2 = r2.f4857h
            if (r2 == 0) goto L1b
            int r4 = r6.getDeviceId()
            android.view.KeyCharacterMap r4 = android.view.KeyCharacterMap.load(r4)
            int r4 = r4.getKeyboardType()
            if (r4 == r1) goto L31
            r4 = r1
            goto L32
        L31:
            r4 = r3
        L32:
            r2.setQwertyMode(r4)
            boolean r0 = r2.performShortcut(r0, r6, r3)
        L39:
            if (r0 == 0) goto L3d
        L3b:
            r5 = r1
            goto L6b
        L3d:
            h.d0 r0 = r5.O
            if (r0 == 0) goto L52
            int r2 = r6.getKeyCode()
            boolean r0 = r5.D(r0, r2, r6)
            if (r0 == 0) goto L52
            h.d0 r5 = r5.O
            if (r5 == 0) goto L3b
            r5.f4776l = r1
            goto L3b
        L52:
            h.d0 r0 = r5.O
            if (r0 != 0) goto L6a
            h.d0 r0 = r5.x(r3)
            r5.E(r0, r6)
            int r2 = r6.getKeyCode()
            boolean r5 = r5.D(r0, r2, r6)
            r0.f4775k = r3
            if (r5 == 0) goto L6a
            goto L3b
        L6a:
            r5 = r3
        L6b:
            if (r5 == 0) goto L6e
            goto L6f
        L6e:
            return r3
        L6f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: h.y.dispatchKeyShortcutEvent(android.view.KeyEvent):boolean");
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        if (this.f4897f) {
            this.f6859c.onContentChanged();
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0 || (menu instanceof l.l)) {
            return this.f6859c.onCreatePanelMenu(i, menu);
        }
        return false;
    }

    @Override // k.o, android.view.Window.Callback
    public final View onCreatePanelView(int i) {
        return this.f6859c.onCreatePanelView(i);
    }

    @Override // k.o, android.view.Window.Callback
    public final boolean onMenuOpened(int i, Menu menu) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.onMenuOpened(i, menu);
        if (i == 108) {
            e0 e0Var = this.i;
            e0Var.y();
            o0 o0Var = e0Var.f4798p;
            if (o0Var != null) {
                ArrayList arrayList = o0Var.f4873m;
                if (true != o0Var.f4872l) {
                    o0Var.f4872l = true;
                    if (arrayList.size() > 0) {
                        arrayList.get(0).getClass();
                        od.f.j();
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override // k.o, android.view.Window.Callback
    public final void onPanelClosed(int i, Menu menu) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.f4899h) {
            this.f6859c.onPanelClosed(i, menu);
            return;
        }
        super.onPanelClosed(i, menu);
        e0 e0Var = this.i;
        if (i != 108) {
            if (i == 0) {
                d0 d0VarX = e0Var.x(i);
                if (d0VarX.f4777m) {
                    e0Var.q(d0VarX, false);
                    return;
                }
                return;
            }
            return;
        }
        e0Var.y();
        o0 o0Var = e0Var.f4798p;
        if (o0Var != null) {
            ArrayList arrayList = o0Var.f4873m;
            if (o0Var.f4872l) {
                o0Var.f4872l = false;
                if (arrayList.size() <= 0) {
                    return;
                }
                arrayList.get(0).getClass();
                od.f.j();
            }
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        l.l lVar = menu instanceof l.l ? (l.l) menu : null;
        if (i == 0 && lVar == null) {
            return false;
        }
        if (lVar != null) {
            lVar.f7605x = true;
        }
        boolean zOnPreparePanel = this.f6859c.onPreparePanel(i, view, menu);
        if (lVar != null) {
            lVar.f7605x = false;
        }
        return zOnPreparePanel;
    }

    @Override // k.o, android.view.Window.Callback
    public final void onProvideKeyboardShortcuts(List list, Menu menu, int i) {
        l.l lVar = this.i.x(0).f4773h;
        if (lVar != null) {
            super.onProvideKeyboardShortcuts(list, lVar, i);
        } else {
            super.onProvideKeyboardShortcuts(list, menu, i);
        }
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        ViewGroup viewGroup;
        e0 e0Var = this.i;
        Context context = e0Var.f4794l;
        if (!e0Var.A || i != 0) {
            return k.l.b(this.f6859c, callback, i);
        }
        k.e eVar = new k.e();
        eVar.f6811f = context;
        eVar.f6810c = callback;
        eVar.f6812g = new ArrayList();
        eVar.f6813h = new p0(0);
        VarHandle.storeStoreFence();
        k.a aVar = e0Var.f4804v;
        if (aVar != null) {
            aVar.a();
        }
        p5.l lVar = new p5.l();
        lVar.f9739f = e0Var;
        lVar.f9738c = eVar;
        VarHandle.storeStoreFence();
        e0Var.y();
        o0 o0Var = e0Var.f4798p;
        int i3 = 1;
        if (o0Var != null) {
            n0 n0Var = o0Var.i;
            if (n0Var != null) {
                n0Var.a();
            }
            o0Var.f4864c.setHideOnContentScrollEnabled(false);
            o0Var.f4867f.e();
            Context context2 = o0Var.f4867f.getContext();
            n0 n0Var2 = new n0();
            n0Var2.f4859k = o0Var;
            n0Var2.f4856g = context2;
            n0Var2.i = lVar;
            l.l lVar2 = new l.l(context2);
            lVar2.f7593l = 1;
            n0Var2.f4857h = lVar2;
            lVar2.f7587e = n0Var2;
            VarHandle.storeStoreFence();
            lVar2.w();
            try {
                if (((k.e) n0Var2.i.f9738c).h(n0Var2, lVar2)) {
                    o0Var.i = n0Var2;
                    n0Var2.h();
                    o0Var.f4867f.c(n0Var2);
                    o0Var.a(true);
                } else {
                    n0Var2 = null;
                }
                e0Var.f4804v = n0Var2;
            } finally {
                lVar2.v();
            }
        }
        if (e0Var.f4804v == null) {
            n3.o0 o0Var2 = e0Var.f4808z;
            if (o0Var2 != null) {
                o0Var2.b();
            }
            k.a aVar2 = e0Var.f4804v;
            if (aVar2 != null) {
                aVar2.a();
            }
            if (e0Var.f4805w == null) {
                if (e0Var.K) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = context.getTheme();
                    theme.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = context.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        k.c cVar = new k.c(context, 0);
                        cVar.getTheme().setTo(themeNewTheme);
                        context = cVar;
                    }
                    e0Var.f4805w = new ActionBarContextView(context);
                    PopupWindow popupWindow = new PopupWindow(context, (AttributeSet) null, R.attr.actionModePopupWindowStyle);
                    e0Var.f4806x = popupWindow;
                    popupWindow.setWindowLayoutType(2);
                    e0Var.f4806x.setContentView(e0Var.f4805w);
                    e0Var.f4806x.setWidth(-1);
                    context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
                    e0Var.f4805w.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                    e0Var.f4806x.setHeight(-2);
                    r rVar = new r(i3);
                    rVar.f4891f = e0Var;
                    VarHandle.storeStoreFence();
                    e0Var.f4807y = rVar;
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) e0Var.C.findViewById(R.id.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        e0Var.y();
                        o0 o0Var3 = e0Var.f4798p;
                        Context contextB = o0Var3 != null ? o0Var3.b() : null;
                        if (contextB != null) {
                            context = contextB;
                        }
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(context));
                        e0Var.f4805w = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (e0Var.f4805w != null) {
                n3.o0 o0Var4 = e0Var.f4808z;
                if (o0Var4 != null) {
                    o0Var4.b();
                }
                e0Var.f4805w.e();
                Context context3 = e0Var.f4805w.getContext();
                ActionBarContextView actionBarContextView = e0Var.f4805w;
                k.d dVar = new k.d();
                dVar.f6805g = context3;
                dVar.f6806h = actionBarContextView;
                dVar.i = lVar;
                l.l lVar3 = new l.l(actionBarContextView.getContext());
                lVar3.f7593l = 1;
                dVar.f6809l = lVar3;
                lVar3.f7587e = dVar;
                if (((k.e) lVar.f9738c).h(dVar, lVar3)) {
                    dVar.h();
                    e0Var.f4805w.c(dVar);
                    e0Var.f4804v = dVar;
                    boolean z10 = e0Var.B && (viewGroup = e0Var.C) != null && viewGroup.isLaidOut();
                    ActionBarContextView actionBarContextView2 = e0Var.f4805w;
                    if (z10) {
                        actionBarContextView2.setAlpha(0.0f);
                        n3.o0 o0VarA = n3.k0.a(e0Var.f4805w);
                        o0VarA.a(1.0f);
                        e0Var.f4808z = o0VarA;
                        u uVar = new u(i3);
                        uVar.f4896h = e0Var;
                        VarHandle.storeStoreFence();
                        o0VarA.e(uVar);
                    } else {
                        actionBarContextView2.setAlpha(1.0f);
                        e0Var.f4805w.setVisibility(0);
                        if (e0Var.f4805w.getParent() instanceof View) {
                            View view = (View) e0Var.f4805w.getParent();
                            WeakHashMap weakHashMap = n3.k0.f8724a;
                            view.requestApplyInsets();
                        }
                    }
                    if (e0Var.f4806x != null) {
                        e0Var.f4795m.getDecorView().post(e0Var.f4807y);
                    }
                } else {
                    e0Var.f4804v = null;
                }
            }
            e0Var.G();
            e0Var.f4804v = e0Var.f4804v;
        }
        e0Var.G();
        k.a aVar3 = e0Var.f4804v;
        if (aVar3 != null) {
            return eVar.a(aVar3);
        }
        return null;
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }
}
