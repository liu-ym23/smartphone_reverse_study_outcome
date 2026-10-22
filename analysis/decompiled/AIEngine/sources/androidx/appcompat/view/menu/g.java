package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.appcompat.view.menu.d.a;
import androidx.appcompat.view.menu.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, j.a {

    /* renamed from: a, reason: collision with root package name */
    public m f498a;

    /* renamed from: b, reason: collision with root package name */
    public androidx.appcompat.app.f f499b;

    /* renamed from: c, reason: collision with root package name */
    public d f500c;

    @Override // androidx.appcompat.view.menu.j.a
    public final void a(f fVar, boolean z) {
        androidx.appcompat.app.f fVar2;
        if ((z || fVar == this.f498a) && (fVar2 = this.f499b) != null) {
            fVar2.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.j.a
    public final boolean b(f fVar) {
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        m mVar = this.f498a;
        d dVar = this.f500c;
        if (dVar.h == null) {
            dVar.h = dVar.new a();
        }
        mVar.q(dVar.h.getItem(i10), null, 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.f500c.a(this.f498a, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        m mVar = this.f498a;
        if (i10 == 82 || i10 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f499b.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f499b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                mVar.c(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return mVar.performShortcut(i10, keyEvent, 0);
    }
}
