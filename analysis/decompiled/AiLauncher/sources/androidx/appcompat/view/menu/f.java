package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.R$layout;
import androidx.appcompat.app.c;
import androidx.appcompat.view.menu.i;
import io.requery.android.database.sqlite.SQLiteDatabase;

/* loaded from: classes.dex */
public class f implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, i.a {

    /* renamed from: a, reason: collision with root package name */
    public e f8642a;

    /* renamed from: b, reason: collision with root package name */
    public androidx.appcompat.app.c f8643b;

    /* renamed from: c, reason: collision with root package name */
    public c f8644c;

    /* renamed from: d, reason: collision with root package name */
    public i.a f8645d;

    public f(e eVar) {
        this.f8642a = eVar;
    }

    @Override // androidx.appcompat.view.menu.i.a
    public void a(e eVar, boolean z10) {
        if (z10 || eVar == this.f8642a) {
            c();
        }
        i.a aVar = this.f8645d;
        if (aVar != null) {
            aVar.a(eVar, z10);
        }
    }

    @Override // androidx.appcompat.view.menu.i.a
    public boolean b(e eVar) {
        i.a aVar = this.f8645d;
        if (aVar != null) {
            return aVar.b(eVar);
        }
        return false;
    }

    public void c() {
        androidx.appcompat.app.c cVar = this.f8643b;
        if (cVar != null) {
            cVar.dismiss();
        }
    }

    public void d(IBinder iBinder) {
        e eVar = this.f8642a;
        c.a aVar = new c.a(eVar.w());
        c cVar = new c(aVar.b(), R$layout.abc_list_menu_item_layout);
        this.f8644c = cVar;
        cVar.e(this);
        this.f8642a.b(this.f8644c);
        aVar.c(this.f8644c.k(), this);
        View viewA = eVar.A();
        if (viewA != null) {
            aVar.d(viewA);
        } else {
            aVar.e(eVar.y()).q(eVar.z());
        }
        aVar.k(this);
        androidx.appcompat.app.c cVarA = aVar.a();
        this.f8643b = cVarA;
        cVarA.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f8643b.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= SQLiteDatabase.OPEN_SHAREDCACHE;
        this.f8643b.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        this.f8642a.O((g) this.f8644c.k().getItem(i10), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f8644c.a(this.f8642a, true);
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
                Window window2 = this.f8643b.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f8643b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f8642a.e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f8642a.performShortcut(i10, keyEvent, 0);
    }
}
