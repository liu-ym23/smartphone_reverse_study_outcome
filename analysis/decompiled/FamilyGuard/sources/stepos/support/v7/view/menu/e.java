package stepos.support.v7.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import stepos.support.v7.app.c;
import stepos.support.v7.view.menu.h;

/* loaded from: classes.dex */
class e implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, h.a {

    /* renamed from: a, reason: collision with root package name */
    private d f21295a;

    /* renamed from: b, reason: collision with root package name */
    private stepos.support.v7.app.c f21296b;

    /* renamed from: c, reason: collision with root package name */
    c f21297c;

    /* renamed from: d, reason: collision with root package name */
    private h.a f21298d;

    public e(d dVar) {
        this.f21295a = dVar;
    }

    @Override // stepos.support.v7.view.menu.h.a
    public void a(d dVar, boolean z5) {
        if (z5 || dVar == this.f21295a) {
            c();
        }
        h.a aVar = this.f21298d;
        if (aVar != null) {
            aVar.a(dVar, z5);
        }
    }

    @Override // stepos.support.v7.view.menu.h.a
    public boolean b(d dVar) {
        h.a aVar = this.f21298d;
        if (aVar != null) {
            return aVar.b(dVar);
        }
        return false;
    }

    public void c() {
        stepos.support.v7.app.c cVar = this.f21296b;
        if (cVar != null) {
            cVar.dismiss();
        }
    }

    public void d(IBinder iBinder) {
        d dVar = this.f21295a;
        c.a aVar = new c.a(dVar.u());
        c cVar = new c(aVar.e(), X4.h.f6044p);
        this.f21297c = cVar;
        cVar.k(this);
        this.f21295a.b(this.f21297c);
        aVar.f(this.f21297c.i(), this);
        View viewY = dVar.y();
        if (viewY != null) {
            aVar.h(viewY);
        } else {
            aVar.j(dVar.w()).y(dVar.x());
        }
        aVar.t(this);
        stepos.support.v7.app.c cVarC = aVar.c();
        this.f21296b = cVarC;
        cVarC.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f21296b.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f21296b.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i5) {
        this.f21295a.K((f) this.f21297c.i().getItem(i5), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f21297c.a(this.f21295a, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i5, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i5 == 82 || i5 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f21296b.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f21296b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f21295a.e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f21295a.performShortcut(i5, keyEvent, 0);
    }
}
