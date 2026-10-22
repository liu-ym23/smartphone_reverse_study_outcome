package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.c;
import androidx.appcompat.view.menu.j;

/* loaded from: classes.dex */
class f implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, j.a {

    /* renamed from: a, reason: collision with root package name */
    private e f7902a;

    /* renamed from: b, reason: collision with root package name */
    private androidx.appcompat.app.c f7903b;

    /* renamed from: c, reason: collision with root package name */
    c f7904c;

    /* renamed from: d, reason: collision with root package name */
    private j.a f7905d;

    public f(e eVar) {
        this.f7902a = eVar;
    }

    public void a() {
        androidx.appcompat.app.c cVar = this.f7903b;
        if (cVar != null) {
            cVar.dismiss();
        }
    }

    public void b(IBinder iBinder) {
        e eVar = this.f7902a;
        c.a aVar = new c.a(eVar.u());
        c cVar = new c(aVar.b(), g.g.f16954j);
        this.f7904c = cVar;
        cVar.g(this);
        this.f7902a.b(this.f7904c);
        aVar.c(this.f7904c.a(), this);
        View viewY = eVar.y();
        if (viewY != null) {
            aVar.d(viewY);
        } else {
            aVar.e(eVar.w()).m(eVar.x());
        }
        aVar.i(this);
        androidx.appcompat.app.c cVarA = aVar.a();
        this.f7903b = cVarA;
        cVarA.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f7903b.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f7903b.show();
    }

    @Override // androidx.appcompat.view.menu.j.a
    public void d(e eVar, boolean z5) {
        if (z5 || eVar == this.f7902a) {
            a();
        }
        j.a aVar = this.f7905d;
        if (aVar != null) {
            aVar.d(eVar, z5);
        }
    }

    @Override // androidx.appcompat.view.menu.j.a
    public boolean e(e eVar) {
        j.a aVar = this.f7905d;
        if (aVar != null) {
            return aVar.e(eVar);
        }
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i5) {
        this.f7902a.M((g) this.f7904c.a().getItem(i5), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f7904c.d(this.f7902a, true);
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
                Window window2 = this.f7903b.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f7903b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f7902a.e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f7902a.performShortcut(i5, keyEvent, 0);
    }
}
