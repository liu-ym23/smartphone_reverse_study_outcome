package stepos.support.v7.app;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import androidx.appcompat.view.WindowCallbackWrapper;

/* renamed from: stepos.support.v7.app.p, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1967p extends WindowCallbackWrapper {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC1966o f6318a;
    public final /* synthetic */ C1968q b;
    public final /* synthetic */ C1968q c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1967p(C1968q c1968q, Window.Callback callback) {
        super(callback);
        this.c = c1968q;
        this.b = c1968q;
        this.f6318a = c1968q;
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f6318a.j(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004e A[RETURN] */
    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchKeyShortcutEvent(android.view.KeyEvent r5) {
        /*
            r4 = this;
            boolean r0 = super.dispatchKeyShortcutEvent(r5)
            r1 = 1
            if (r0 != 0) goto L4f
            int r0 = r5.getKeyCode()
            stepos.support.v7.app.o r4 = r4.f6318a
            stepos.support.v7.app.y r4 = (stepos.support.v7.app.AbstractC1975y) r4
            r4.m()
            stepos.support.v7.app.d r2 = r4.f
            r3 = 0
            if (r2 == 0) goto L1e
            boolean r0 = r2.h(r0, r5)
            if (r0 == 0) goto L1e
            goto L32
        L1e:
            stepos.support.v7.app.x r0 = r4.f6351G
            if (r0 == 0) goto L34
            int r2 = r5.getKeyCode()
            boolean r0 = r4.y(r0, r2, r5)
            if (r0 == 0) goto L34
            stepos.support.v7.app.x r4 = r4.f6351G
            if (r4 == 0) goto L32
            r4.l = r1
        L32:
            r4 = r1
            goto L4b
        L34:
            stepos.support.v7.app.x r0 = r4.f6351G
            if (r0 != 0) goto L4a
            stepos.support.v7.app.x r0 = r4.v(r3)
            r4.A(r0, r5)
            int r2 = r5.getKeyCode()
            boolean r4 = r4.y(r0, r2, r5)
            r0.k = r3
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
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.C1967p.dispatchKeyShortcutEvent(android.view.KeyEvent):boolean");
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
    public final void onContentChanged() {
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0 || (menu instanceof Va.n)) {
            return super.onCreatePanelMenu(i, menu);
        }
        return false;
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
    public final boolean onMenuOpened(int i, Menu menu) {
        super.onMenuOpened(i, menu);
        AbstractC1975y abstractC1975y = (AbstractC1975y) this.f6318a;
        if (i == 108) {
            abstractC1975y.m();
            AbstractC1955d abstractC1955d = abstractC1975y.f;
            if (abstractC1955d != null) {
                abstractC1955d.b(true);
            }
        } else {
            abstractC1975y.getClass();
        }
        return true;
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
    public final void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
        AbstractC1975y abstractC1975y = (AbstractC1975y) this.f6318a;
        if (i == 108) {
            abstractC1975y.m();
            AbstractC1955d abstractC1955d = abstractC1975y.f;
            if (abstractC1955d != null) {
                abstractC1955d.b(false);
                return;
            }
            return;
        }
        if (i == 0) {
            C1974x c1974xV = abstractC1975y.v(i);
            if (c1974xV.m) {
                abstractC1975y.s(c1974xV, false);
            }
        }
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        Va.n nVar = menu instanceof Va.n ? (Va.n) menu : null;
        if (i == 0 && nVar == null) {
            return false;
        }
        if (nVar != null) {
            nVar.u = true;
        }
        boolean zOnPreparePanel = super.onPreparePanel(i, view, menu);
        if (nVar != null) {
            nVar.u = false;
        }
        return zOnPreparePanel;
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0060  */
    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback r5, int r6) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        /*
            r4 = this;
            stepos.support.v7.app.q r0 = r4.c
            boolean r0 = r0.f6334W
            if (r0 == 0) goto L73
            if (r6 == 0) goto L9
            goto L73
        L9:
            u1.d r6 = new u1.d
            stepos.support.v7.app.q r4 = r4.b
            android.content.Context r0 = r4.f6316a
            r6.<init>(r0, r5)
            r0 = 0
            if (r5 != 0) goto L16
            goto L60
        L16:
            java.lang.Class r1 = r5.getClass()
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "com.android.internal.policy.impl.PhoneWindow$DecorView$ActionModeCallbackWrapper"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L2e
            java.lang.String r2 = "com.android.internal.policy.PhoneWindow$DecorView$ActionModeCallback2Wrapper"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L4f
        L2e:
            java.lang.Class r2 = r5.getClass()     // Catch: java.lang.Exception -> L4b
            java.lang.String r3 = "mWrapped"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch: java.lang.Exception -> L4b
            r3 = 1
            r2.setAccessible(r3)     // Catch: java.lang.Exception -> L4b
            java.lang.Object r5 = r2.get(r5)     // Catch: java.lang.Exception -> L4b
            if (r5 == 0) goto L4f
            java.lang.Class r5 = r5.getClass()     // Catch: java.lang.Exception -> L4b
            java.lang.String r1 = r5.getName()     // Catch: java.lang.Exception -> L4b
            goto L4f
        L4b:
            r5 = move-exception
            r5.printStackTrace()
        L4f:
            java.lang.String r5 = "android.widget.AbsListView$MultiChoiceModeWrapper"
            boolean r5 = r1.equals(r5)
            if (r5 != 0) goto L62
            java.lang.String r5 = "stepos.support.v7.widget.StepOSRecyclerView$MultiChoiceModeWrapper"
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L60
            goto L62
        L60:
            r5 = r0
            goto L66
        L62:
            Ua.c r5 = r4.h(r6)
        L66:
            if (r5 != 0) goto L6c
            Ua.c r5 = r4.i(r6)
        L6c:
            if (r5 == 0) goto L72
            Ua.h r0 = r6.R(r5)
        L72:
            return r0
        L73:
            android.view.ActionMode r4 = super.onWindowStartingActionMode(r5, r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.C1967p.onWindowStartingActionMode(android.view.ActionMode$Callback, int):android.view.ActionMode");
    }
}
