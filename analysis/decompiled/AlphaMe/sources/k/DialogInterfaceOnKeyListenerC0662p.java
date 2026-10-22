package k;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import androidx.appcompat.app.C0182h;
import androidx.appcompat.app.C0186l;
import androidx.appcompat.app.DialogInterfaceC0187m;
import stepos.support.v7.app.C0861f;
import stepos.support.v7.app.C0864i;
import stepos.support.v7.app.DialogInterfaceC0865j;

/* renamed from: k.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class DialogInterfaceOnKeyListenerC0662p implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, InterfaceC0672z, L3.v {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13262a;

    /* renamed from: b, reason: collision with root package name */
    public final F.a f13263b;

    /* renamed from: c, reason: collision with root package name */
    public Dialog f13264c;

    /* renamed from: d, reason: collision with root package name */
    public AdapterView.OnItemClickListener f13265d;

    public /* synthetic */ DialogInterfaceOnKeyListenerC0662p(F.a aVar, int i4) {
        this.f13262a = i4;
        this.f13263b = aVar;
    }

    public final void a() throws Resources.NotFoundException {
        F.a aVar = this.f13263b;
        switch (this.f13262a) {
            case 0:
                C0661o c0661o = (C0661o) aVar;
                C0186l c0186l = new C0186l(c0661o.f13238a);
                C0657k c0657k = new C0657k(((C0182h) c0186l.f2661c).f2597a);
                this.f13265d = c0657k;
                c0657k.f13229e = this;
                c0661o.b(c0657k, c0661o.f13238a);
                C0657k c0657k2 = (C0657k) this.f13265d;
                if (c0657k2.f13230f == null) {
                    c0657k2.f13230f = new C0656j(c0657k2);
                }
                C0656j c0656j = c0657k2.f13230f;
                Object obj = c0186l.f2661c;
                C0182h c0182h = (C0182h) obj;
                c0182h.f2609m = c0656j;
                c0182h.f2610n = this;
                View view = c0661o.f13252o;
                if (view != null) {
                    c0182h.f2601e = view;
                } else {
                    ((C0182h) obj).f2599c = c0661o.f13251n;
                    ((C0182h) obj).f2600d = c0661o.f13250m;
                }
                ((C0182h) obj).f2607k = this;
                DialogInterfaceC0187m dialogInterfaceC0187mB = c0186l.b();
                this.f13264c = dialogInterfaceC0187mB;
                dialogInterfaceC0187mB.setOnDismissListener(this);
                WindowManager.LayoutParams attributes = ((DialogInterfaceC0187m) this.f13264c).getWindow().getAttributes();
                attributes.type = 1003;
                attributes.flags |= 131072;
                ((DialogInterfaceC0187m) this.f13264c).show();
                break;
            default:
                L3.k kVar = (L3.k) aVar;
                C0864i c0864i = new C0864i(kVar.f1281a);
                C0861f c0861f = c0864i.f14506a;
                L3.h hVar = new L3.h(c0861f.f14449a);
                this.f13265d = hVar;
                hVar.f1278e = this;
                kVar.b(hVar, kVar.f1281a);
                c0861f.f14464p = ((L3.h) this.f13265d).b();
                c0861f.f14465q = this;
                View view2 = kVar.f1294n;
                if (view2 != null) {
                    c0861f.f14453e = view2;
                } else {
                    c0861f.f14451c = kVar.f1293m;
                    c0861f.f14452d = kVar.f1292l;
                }
                c0861f.f14462n = this;
                DialogInterfaceC0865j dialogInterfaceC0865jA = c0864i.a(new com.google.android.gms.common.api.internal.p(28, c0864i));
                this.f13264c = dialogInterfaceC0865jA;
                dialogInterfaceC0865jA.setOnDismissListener(this);
                WindowManager.LayoutParams attributes2 = ((DialogInterfaceC0865j) this.f13264c).getWindow().getAttributes();
                attributes2.type = 1003;
                attributes2.flags |= 131072;
                ((DialogInterfaceC0865j) this.f13264c).show();
                break;
        }
    }

    @Override // k.InterfaceC0672z
    public final void b(C0661o c0661o, boolean z4) {
        if (z4 || c0661o == ((C0661o) this.f13263b)) {
            switch (this.f13262a) {
                case 0:
                    DialogInterfaceC0187m dialogInterfaceC0187m = (DialogInterfaceC0187m) this.f13264c;
                    if (dialogInterfaceC0187m != null) {
                        dialogInterfaceC0187m.dismiss();
                        break;
                    }
                    break;
                default:
                    DialogInterfaceC0865j dialogInterfaceC0865j = (DialogInterfaceC0865j) this.f13264c;
                    if (dialogInterfaceC0865j != null) {
                        dialogInterfaceC0865j.dismiss();
                        break;
                    }
                    break;
            }
        }
    }

    @Override // L3.v
    public final void d(L3.k kVar, boolean z4) {
        if (z4 || kVar == ((L3.k) this.f13263b)) {
            switch (this.f13262a) {
                case 0:
                    DialogInterfaceC0187m dialogInterfaceC0187m = (DialogInterfaceC0187m) this.f13264c;
                    if (dialogInterfaceC0187m != null) {
                        dialogInterfaceC0187m.dismiss();
                        break;
                    }
                    break;
                default:
                    DialogInterfaceC0865j dialogInterfaceC0865j = (DialogInterfaceC0865j) this.f13264c;
                    if (dialogInterfaceC0865j != null) {
                        dialogInterfaceC0865j.dismiss();
                        break;
                    }
                    break;
            }
        }
    }

    @Override // k.InterfaceC0672z
    public final boolean f(C0661o c0661o) {
        return false;
    }

    @Override // L3.v
    public final boolean g(L3.k kVar) {
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i4) {
        F.a aVar = this.f13263b;
        switch (this.f13262a) {
            case 0:
                C0661o c0661o = (C0661o) aVar;
                C0657k c0657k = (C0657k) this.f13265d;
                if (c0657k.f13230f == null) {
                    c0657k.f13230f = new C0656j(c0657k);
                }
                c0661o.q((C0663q) c0657k.f13230f.getItem(i4), null, 0);
                break;
            default:
                ((L3.k) aVar).p((L3.l) ((L3.h) this.f13265d).b().getItem(i4), null, 0);
                break;
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        F.a aVar = this.f13263b;
        switch (this.f13262a) {
            case 0:
                ((C0657k) this.f13265d).b((C0661o) aVar, true);
                break;
            default:
                ((L3.h) this.f13265d).d((L3.k) aVar, true);
                break;
        }
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i4, KeyEvent keyEvent) {
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
        F.a aVar = this.f13263b;
        switch (this.f13262a) {
            case 0:
                if (i4 == 82 || i4 == 4) {
                    if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                        Window window3 = ((DialogInterfaceC0187m) this.f13264c).getWindow();
                        if (window3 != null && (decorView2 = window3.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                            keyDispatcherState2.startTracking(keyEvent, this);
                            return true;
                        }
                    } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = ((DialogInterfaceC0187m) this.f13264c).getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                        ((C0661o) aVar).c(true);
                        dialogInterface.dismiss();
                        return true;
                    }
                }
                return ((C0661o) aVar).performShortcut(i4, keyEvent, 0);
            default:
                if (i4 == 82 || i4 == 4) {
                    if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                        Window window4 = ((DialogInterfaceC0865j) this.f13264c).getWindow();
                        if (window4 != null && (decorView4 = window4.getDecorView()) != null && (keyDispatcherState4 = decorView4.getKeyDispatcherState()) != null) {
                            keyDispatcherState4.startTracking(keyEvent, this);
                            return true;
                        }
                    } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window2 = ((DialogInterfaceC0865j) this.f13264c).getWindow()) != null && (decorView3 = window2.getDecorView()) != null && (keyDispatcherState3 = decorView3.getKeyDispatcherState()) != null && keyDispatcherState3.isTracking(keyEvent)) {
                        ((L3.k) aVar).c(true);
                        dialogInterface.dismiss();
                        return true;
                    }
                }
                return ((L3.k) aVar).performShortcut(i4, keyEvent, 0);
        }
    }
}
