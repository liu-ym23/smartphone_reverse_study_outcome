package stepos.support.v7.app;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class n extends k.o {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ o f12348f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ o f12349g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ o f12350h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(o oVar, Window.Callback callback) {
        super(callback);
        this.f12350h = oVar;
        this.f12349g = oVar;
        this.f12348f = oVar;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f12348f.o(keyEvent) || this.f6859c.dispatchKeyEvent(keyEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004e A[RETURN] */
    @Override // android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchKeyShortcutEvent(android.view.KeyEvent r5) {
        /*
            r4 = this;
            android.view.Window$Callback r0 = r4.f6859c
            boolean r0 = r0.dispatchKeyShortcutEvent(r5)
            r1 = 1
            if (r0 != 0) goto L4f
            int r0 = r5.getKeyCode()
            stepos.support.v7.app.o r4 = r4.f12348f
            r4.s()
            stepos.support.v7.app.c r2 = r4.f12391j
            r3 = 0
            if (r2 == 0) goto L1f
            boolean r0 = r2.h(r0, r5)
            if (r0 == 0) goto L1f
        L1d:
            r4 = r1
            goto L4b
        L1f:
            stepos.support.v7.app.r r0 = r4.K
            if (r0 == 0) goto L34
            int r2 = r5.getKeyCode()
            boolean r0 = r4.v(r0, r2, r5)
            if (r0 == 0) goto L34
            stepos.support.v7.app.r r4 = r4.K
            if (r4 == 0) goto L1d
            r4.f12470l = r1
            goto L1d
        L34:
            stepos.support.v7.app.r r0 = r4.K
            if (r0 != 0) goto L4a
            stepos.support.v7.app.r r0 = r4.r(r3)
            r4.x(r0, r5)
            int r2 = r5.getKeyCode()
            boolean r4 = r4.v(r0, r2, r5)
            r0.f12469k = r3
            goto L4b
        L4a:
            r4 = r3
        L4b:
            if (r4 == 0) goto L4e
            goto L4f
        L4e:
            return r3
        L4f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.n.dispatchKeyShortcutEvent(android.view.KeyEvent):boolean");
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0 || (menu instanceof te.l)) {
            return this.f6859c.onCreatePanelMenu(i, menu);
        }
        return false;
    }

    @Override // k.o, android.view.Window.Callback
    public final boolean onMenuOpened(int i, Menu menu) {
        super.onMenuOpened(i, menu);
        if (i == 108) {
            o oVar = this.f12348f;
            oVar.s();
            c cVar = oVar.f12391j;
            if (cVar != null) {
                cVar.b(true);
            }
        }
        return true;
    }

    @Override // k.o, android.view.Window.Callback
    public final void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
        o oVar = this.f12348f;
        if (i == 108) {
            oVar.s();
            c cVar = oVar.f12391j;
            if (cVar != null) {
                cVar.b(false);
                return;
            }
            return;
        }
        if (i == 0) {
            r rVarR = oVar.r(i);
            if (rVarR.f12471m) {
                oVar.n(rVarR, false);
            }
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        te.l lVar = menu instanceof te.l ? (te.l) menu : null;
        if (i == 0 && lVar == null) {
            return false;
        }
        if (lVar != null) {
            lVar.f13362u = true;
        }
        boolean zOnPreparePanel = this.f6859c.onPreparePanel(i, view, menu);
        if (lVar != null) {
            lVar.f13362u = false;
        }
        return zOnPreparePanel;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0077  */
    @Override // android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback r5, int r6) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        /*
            r4 = this;
            stepos.support.v7.app.o r0 = r4.f12350h
            boolean r0 = r0.V
            if (r0 == 0) goto L8a
            if (r6 == 0) goto La
            goto L8a
        La:
            k.e r6 = new k.e
            stepos.support.v7.app.o r4 = r4.f12349g
            android.content.Context r0 = r4.f12387c
            r6.<init>()
            r6.f6811f = r0
            r6.f6810c = r5
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r6.f6812g = r0
            p.p0 r0 = new p.p0
            r1 = 0
            r0.<init>(r1)
            r6.f6813h = r0
            java.lang.invoke.VarHandle.storeStoreFence()
            r0 = 0
            if (r5 != 0) goto L2d
            goto L77
        L2d:
            java.lang.Class r1 = r5.getClass()
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "com.android.internal.policy.impl.PhoneWindow$DecorView$ActionModeCallbackWrapper"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L45
            java.lang.String r2 = "com.android.internal.policy.PhoneWindow$DecorView$ActionModeCallback2Wrapper"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L66
        L45:
            java.lang.Class r2 = r5.getClass()     // Catch: java.lang.Exception -> L62
            java.lang.String r3 = "mWrapped"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch: java.lang.Exception -> L62
            r3 = 1
            r2.setAccessible(r3)     // Catch: java.lang.Exception -> L62
            java.lang.Object r5 = r2.get(r5)     // Catch: java.lang.Exception -> L62
            if (r5 == 0) goto L66
            java.lang.Class r5 = r5.getClass()     // Catch: java.lang.Exception -> L62
            java.lang.String r1 = r5.getName()     // Catch: java.lang.Exception -> L62
            goto L66
        L62:
            r5 = move-exception
            r5.printStackTrace()
        L66:
            java.lang.String r5 = "android.widget.AbsListView$MultiChoiceModeWrapper"
            boolean r5 = r1.equals(r5)
            if (r5 != 0) goto L79
            java.lang.String r5 = "stepos.support.v7.widget.StepOSRecyclerView$MultiChoiceModeWrapper"
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L77
            goto L79
        L77:
            r5 = r0
            goto L7d
        L79:
            se.b r5 = r4.i(r6)
        L7d:
            if (r5 != 0) goto L83
            se.b r5 = r4.j(r6)
        L83:
            if (r5 == 0) goto L89
            se.g r0 = r6.f(r5)
        L89:
            return r0
        L8a:
            android.view.Window$Callback r4 = r4.f6859c
            android.view.ActionMode r4 = k.l.b(r4, r5, r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.n.onWindowStartingActionMode(android.view.ActionMode$Callback, int):android.view.ActionMode");
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }
}
