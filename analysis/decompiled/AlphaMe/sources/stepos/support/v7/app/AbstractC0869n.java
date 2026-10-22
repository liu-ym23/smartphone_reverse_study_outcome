package stepos.support.v7.app;

import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;

/* renamed from: stepos.support.v7.app.n, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0869n extends j.q {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractC0870o f14508b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0869n(AbstractC0870o abstractC0870o, Window.Callback callback) {
        super(callback);
        this.f14508b = abstractC0870o;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f14508b.k(keyEvent) || this.f13116a.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        if (this.f13116a.dispatchKeyShortcutEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        AbstractC0880z abstractC0880z = (AbstractC0880z) this.f14508b;
        abstractC0880z.l();
        AbstractC0860e abstractC0860e = abstractC0880z.f14514f;
        if (abstractC0860e != null && abstractC0860e.i(keyCode, keyEvent)) {
            return true;
        }
        C0879y c0879y = abstractC0880z.f14618G;
        if (c0879y != null && abstractC0880z.y(c0879y, keyEvent.getKeyCode(), keyEvent)) {
            C0879y c0879y2 = abstractC0880z.f14618G;
            if (c0879y2 == null) {
                return true;
            }
            c0879y2.f14606l = true;
            return true;
        }
        if (abstractC0880z.f14618G == null) {
            C0879y c0879yU = abstractC0880z.u(0);
            abstractC0880z.A(c0879yU, keyEvent);
            boolean zY = abstractC0880z.y(c0879yU, keyEvent.getKeyCode(), keyEvent);
            c0879yU.f14605k = false;
            if (zY) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i4, Menu menu) {
        if (i4 != 0 || (menu instanceof L3.k)) {
            return this.f13116a.onCreatePanelMenu(i4, menu);
        }
        return false;
    }

    @Override // j.q, android.view.Window.Callback
    public final boolean onMenuOpened(int i4, Menu menu) {
        super.onMenuOpened(i4, menu);
        AbstractC0880z abstractC0880z = (AbstractC0880z) this.f14508b;
        if (i4 == 108) {
            abstractC0880z.l();
            AbstractC0860e abstractC0860e = abstractC0880z.f14514f;
            if (abstractC0860e != null) {
                abstractC0860e.b(true);
            }
        } else {
            abstractC0880z.getClass();
        }
        return true;
    }

    @Override // j.q, android.view.Window.Callback
    public final void onPanelClosed(int i4, Menu menu) {
        super.onPanelClosed(i4, menu);
        AbstractC0880z abstractC0880z = (AbstractC0880z) this.f14508b;
        if (i4 == 108) {
            abstractC0880z.l();
            AbstractC0860e abstractC0860e = abstractC0880z.f14514f;
            if (abstractC0860e != null) {
                abstractC0860e.b(false);
                return;
            }
            return;
        }
        if (i4 != 0) {
            abstractC0880z.getClass();
            return;
        }
        C0879y c0879yU = abstractC0880z.u(i4);
        if (c0879yU.f14607m) {
            abstractC0880z.r(c0879yU, false);
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i4, View view, Menu menu) {
        L3.k kVar = menu instanceof L3.k ? (L3.k) menu : null;
        if (i4 == 0 && kVar == null) {
            return false;
        }
        if (kVar != null) {
            kVar.f1301u = true;
        }
        boolean zOnPreparePanel = this.f13116a.onPreparePanel(i4, view, menu);
        if (kVar != null) {
            kVar.f1301u = false;
        }
        return zOnPreparePanel;
    }
}
