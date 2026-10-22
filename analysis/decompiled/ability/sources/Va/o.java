package Va;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import stepos.support.v7.app.DialogInterfaceC1961j;

/* loaded from: classes4.dex */
public final class o implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, A {

    /* renamed from: a, reason: collision with root package name */
    public F f1448a;
    public DialogInterfaceC1961j b;
    public k c;

    @Override // Va.A
    public final void f(n nVar, boolean z10) {
        DialogInterfaceC1961j dialogInterfaceC1961j;
        if ((z10 || nVar == this.f1448a) && (dialogInterfaceC1961j = this.b) != null) {
            dialogInterfaceC1961j.dismiss();
        }
    }

    @Override // Va.A
    public final boolean n(n nVar) {
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f1448a.p(((j) this.c.e()).getItem(i), null, 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.c.f(this.f1448a, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        F f = this.f1448a;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.b.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                f.c(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return f.performShortcut(i, keyEvent, 0);
    }
}
