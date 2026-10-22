package stepos.support.v7.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import io.requery.android.database.sqlite.SQLiteDatabase;
import stepos.support.v7.app.c;
import stepos.support.v7.appcompat.R$layout;
import stepos.support.v7.view.menu.g;

/* loaded from: classes5.dex */
public class d implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, g.a {

    /* renamed from: a, reason: collision with root package name */
    public c f40953a;

    /* renamed from: b, reason: collision with root package name */
    public stepos.support.v7.app.c f40954b;

    /* renamed from: c, reason: collision with root package name */
    public b f40955c;

    /* renamed from: d, reason: collision with root package name */
    public g.a f40956d;

    public d(c cVar) {
        this.f40953a = cVar;
    }

    @Override // stepos.support.v7.view.menu.g.a
    public void a(c cVar, boolean z10) {
        if (z10 || cVar == this.f40953a) {
            c();
        }
        g.a aVar = this.f40956d;
        if (aVar != null) {
            aVar.a(cVar, z10);
        }
    }

    @Override // stepos.support.v7.view.menu.g.a
    public boolean b(c cVar) {
        g.a aVar = this.f40956d;
        if (aVar != null) {
            return aVar.b(cVar);
        }
        return false;
    }

    public void c() {
        stepos.support.v7.app.c cVar = this.f40954b;
        if (cVar != null) {
            cVar.dismiss();
        }
    }

    public void d(IBinder iBinder) {
        c cVar = this.f40953a;
        c.a aVar = new c.a(cVar.u());
        b bVar = new b(aVar.e(), R$layout.stepos_list_menu_item_layout);
        this.f40955c = bVar;
        bVar.k(this);
        this.f40953a.b(this.f40955c);
        aVar.f(this.f40955c.i(), this);
        View viewY = cVar.y();
        if (viewY != null) {
            aVar.h(viewY);
        } else {
            aVar.j(cVar.w()).u(cVar.x());
        }
        aVar.q(this);
        stepos.support.v7.app.c cVarC = aVar.c();
        this.f40954b = cVarC;
        cVarC.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f40954b.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= SQLiteDatabase.OPEN_SHAREDCACHE;
        this.f40954b.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        this.f40953a.K((e) this.f40955c.i().getItem(i10), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f40955c.a(this.f40953a, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i10 == 82 || i10 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f40954b.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f40954b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f40953a.e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f40953a.performShortcut(i10, keyEvent, 0);
    }
}
