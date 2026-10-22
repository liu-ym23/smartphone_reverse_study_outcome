package l;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, w, te.u {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7606c;

    /* renamed from: f, reason: collision with root package name */
    public Object f7607f;

    /* renamed from: g, reason: collision with root package name */
    public Dialog f7608g;

    /* renamed from: h, reason: collision with root package name */
    public AdapterView.OnItemClickListener f7609h;

    public /* synthetic */ m(int i) {
        this.f7606c = i;
    }

    @Override // te.u
    public void b(te.l lVar, boolean z10) {
        stepos.support.v7.app.i iVar;
        if ((z10 || lVar == ((te.z) this.f7607f)) && (iVar = (stepos.support.v7.app.i) this.f7608g) != null) {
            iVar.dismiss();
        }
    }

    @Override // l.w
    public void d(l lVar, boolean z10) {
        h.h hVar;
        if ((z10 || lVar == ((d0) this.f7607f)) && (hVar = (h.h) this.f7608g) != null) {
            hVar.dismiss();
        }
    }

    @Override // te.u
    public boolean e(te.l lVar) {
        return false;
    }

    @Override // l.w
    public boolean f(l lVar) {
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.f7606c) {
            case 0:
                d0 d0Var = (d0) this.f7607f;
                h hVar = (h) this.f7609h;
                if (hVar.f7575j == null) {
                    hVar.f7575j = new g(hVar);
                }
                d0Var.q(hVar.f7575j.b(i), null, 0);
                break;
            default:
                ((te.z) this.f7607f).p(((g) ((te.i) this.f7609h).h()).c(i), null, 0);
                break;
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        switch (this.f7606c) {
            case 0:
                ((h) this.f7609h).d((d0) this.f7607f, true);
                break;
            default:
                ((te.i) this.f7609h).b((te.z) this.f7607f, true);
                break;
        }
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        Window window2;
        View decorView3;
        KeyEvent.DispatcherState keyDispatcherState3;
        View decorView4;
        KeyEvent.DispatcherState keyDispatcherState4;
        switch (this.f7606c) {
            case 0:
                d0 d0Var = (d0) this.f7607f;
                if (i == 82 || i == 4) {
                    if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                        Window window3 = ((h.h) this.f7608g).getWindow();
                        if (window3 != null && (decorView2 = window3.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                            keyDispatcherState2.startTracking(keyEvent, this);
                            return true;
                        }
                    } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = ((h.h) this.f7608g).getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                        d0Var.c(true);
                        dialogInterface.dismiss();
                        return true;
                    }
                }
                return d0Var.performShortcut(i, keyEvent, 0);
            default:
                te.z zVar = (te.z) this.f7607f;
                if (i == 82 || i == 4) {
                    if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                        Window window4 = ((stepos.support.v7.app.i) this.f7608g).getWindow();
                        if (window4 != null && (decorView4 = window4.getDecorView()) != null && (keyDispatcherState4 = decorView4.getKeyDispatcherState()) != null) {
                            keyDispatcherState4.startTracking(keyEvent, this);
                            return true;
                        }
                    } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window2 = ((stepos.support.v7.app.i) this.f7608g).getWindow()) != null && (decorView3 = window2.getDecorView()) != null && (keyDispatcherState3 = decorView3.getKeyDispatcherState()) != null && keyDispatcherState3.isTracking(keyEvent)) {
                        zVar.c(true);
                        dialogInterface.dismiss();
                        return true;
                    }
                }
                return zVar.performShortcut(i, keyEvent, 0);
        }
    }
}
