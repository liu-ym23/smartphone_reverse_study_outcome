package stepos.support.v7.view.menu;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import stepos.support.v7.view.menu.b;
import stepos.support.v7.view.menu.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, g.a {

    /* renamed from: a, reason: collision with root package name */
    public i f12394a;

    /* renamed from: b, reason: collision with root package name */
    public stepos.support.v7.app.e f12395b;

    /* renamed from: c, reason: collision with root package name */
    public b f12396c;

    @Override // stepos.support.v7.view.menu.g.a
    public final void a(c cVar, boolean z) {
        stepos.support.v7.app.e eVar;
        if ((z || cVar == this.f12394a) && (eVar = this.f12395b) != null) {
            eVar.dismiss();
        }
    }

    @Override // stepos.support.v7.view.menu.g.a
    public final boolean b(c cVar) {
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        this.f12394a.p(((b.a) this.f12396c.h()).getItem(i10), null, 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.f12396c.a(this.f12394a, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        i iVar = this.f12394a;
        if (i10 == 82 || i10 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f12395b.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f12395b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                iVar.c(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return iVar.performShortcut(i10, keyEvent, 0);
    }
}
