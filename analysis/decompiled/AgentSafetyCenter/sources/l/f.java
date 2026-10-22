package l;

import android.content.Context;
import android.os.Handler;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.util.ArrayList;
import m.b2;
import m.j1;
import m.y1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends t implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public w A;
    public ViewTreeObserver B;
    public PopupWindow.OnDismissListener C;
    public boolean D;

    /* renamed from: f, reason: collision with root package name */
    public Context f7548f;

    /* renamed from: g, reason: collision with root package name */
    public int f7549g;

    /* renamed from: h, reason: collision with root package name */
    public int f7550h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public Handler f7551j;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f7552k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f7553l;

    /* renamed from: m, reason: collision with root package name */
    public d f7554m;

    /* renamed from: n, reason: collision with root package name */
    public ab.b f7555n;

    /* renamed from: o, reason: collision with root package name */
    public a1.g f7556o;

    /* renamed from: p, reason: collision with root package name */
    public int f7557p;

    /* renamed from: q, reason: collision with root package name */
    public int f7558q;

    /* renamed from: r, reason: collision with root package name */
    public View f7559r;

    /* renamed from: s, reason: collision with root package name */
    public View f7560s;

    /* renamed from: t, reason: collision with root package name */
    public int f7561t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f7562u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f7563v;

    /* renamed from: w, reason: collision with root package name */
    public int f7564w;

    /* renamed from: x, reason: collision with root package name */
    public int f7565x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f7566y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f7567z;

    @Override // l.x
    public final boolean a() {
        return false;
    }

    @Override // l.b0
    public final boolean b() {
        ArrayList arrayList = this.f7553l;
        return arrayList.size() > 0 && ((e) arrayList.get(0)).f7545a.D.isShowing();
    }

    @Override // l.x
    public final void c() {
        ArrayList arrayList = this.f7553l;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ListAdapter adapter = ((e) obj).f7545a.f8116g.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((i) adapter).notifyDataSetChanged();
        }
    }

    @Override // l.x
    public final void d(l lVar, boolean z10) {
        ArrayList arrayList = this.f7553l;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (lVar == ((e) arrayList.get(i)).f7546b) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            return;
        }
        int i3 = i + 1;
        if (i3 < arrayList.size()) {
            ((e) arrayList.get(i3)).f7546b.c(false);
        }
        e eVar = (e) arrayList.remove(i);
        l lVar2 = eVar.f7546b;
        b2 b2Var = eVar.f7545a;
        lVar2.r(this);
        if (this.D) {
            y1.b(b2Var.D, null);
            b2Var.D.setAnimationStyle(0);
        }
        b2Var.dismiss();
        int size2 = arrayList.size();
        if (size2 > 0) {
            this.f7561t = ((e) arrayList.get(size2 - 1)).f7547c;
        } else {
            this.f7561t = this.f7559r.getLayoutDirection() == 1 ? 0 : 1;
        }
        if (size2 != 0) {
            if (z10) {
                ((e) arrayList.get(0)).f7546b.c(false);
                return;
            }
            return;
        }
        dismiss();
        w wVar = this.A;
        if (wVar != null) {
            wVar.d(lVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.B;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.B.removeGlobalOnLayoutListener(this.f7554m);
            }
            this.B = null;
        }
        this.f7560s.removeOnAttachStateChangeListener(this.f7555n);
        this.C.onDismiss();
    }

    @Override // l.b0
    public final void dismiss() {
        ArrayList arrayList = this.f7553l;
        int size = arrayList.size();
        if (size > 0) {
            e[] eVarArr = (e[]) arrayList.toArray(new e[size]);
            for (int i = size - 1; i >= 0; i--) {
                e eVar = eVarArr[i];
                if (eVar.f7545a.D.isShowing()) {
                    eVar.f7545a.dismiss();
                }
            }
        }
    }

    @Override // l.b0
    public final void f() {
        ArrayList arrayList = this.f7552k;
        if (b()) {
            return;
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            u((l) obj);
        }
        arrayList.clear();
        View view = this.f7559r;
        this.f7560s = view;
        if (view != null) {
            boolean z10 = this.B == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.B = viewTreeObserver;
            if (z10) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f7554m);
            }
            this.f7560s.addOnAttachStateChangeListener(this.f7555n);
        }
    }

    @Override // l.x
    public final void g(w wVar) {
        this.A = wVar;
    }

    @Override // l.b0
    public final j1 h() {
        ArrayList arrayList = this.f7553l;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((e) arrayList.get(arrayList.size() - 1)).f7545a.f8116g;
    }

    @Override // l.x
    public final boolean j(d0 d0Var) {
        ArrayList arrayList = this.f7553l;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            e eVar = (e) obj;
            if (d0Var == eVar.f7546b) {
                eVar.f7545a.f8116g.requestFocus();
                return true;
            }
        }
        if (!d0Var.hasVisibleItems()) {
            return false;
        }
        l(d0Var);
        w wVar = this.A;
        if (wVar != null) {
            wVar.f(d0Var);
        }
        return true;
    }

    @Override // l.t
    public final void l(l lVar) {
        lVar.b(this, this.f7548f);
        if (b()) {
            u(lVar);
        } else {
            this.f7552k.add(lVar);
        }
    }

    @Override // l.t
    public final void n(View view) {
        if (this.f7559r != view) {
            this.f7559r = view;
            this.f7558q = Gravity.getAbsoluteGravity(this.f7557p, view.getLayoutDirection());
        }
    }

    @Override // l.t
    public final void o(boolean z10) {
        this.f7566y = z10;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        e eVar;
        ArrayList arrayList = this.f7553l;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                eVar = null;
                break;
            }
            eVar = (e) arrayList.get(i);
            if (!eVar.f7545a.D.isShowing()) {
                break;
            } else {
                i++;
            }
        }
        if (eVar != null) {
            eVar.f7546b.c(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // l.t
    public final void p(int i) {
        if (this.f7557p != i) {
            this.f7557p = i;
            this.f7558q = Gravity.getAbsoluteGravity(i, this.f7559r.getLayoutDirection());
        }
    }

    @Override // l.t
    public final void q(int i) {
        this.f7562u = true;
        this.f7564w = i;
    }

    @Override // l.t
    public final void r(PopupWindow.OnDismissListener onDismissListener) {
        this.C = onDismissListener;
    }

    @Override // l.t
    public final void s(boolean z10) {
        this.f7567z = z10;
    }

    @Override // l.t
    public final void t(int i) {
        this.f7563v = true;
        this.f7565x = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0180  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(l.l r18) {
        /*
            Method dump skipped, instructions count: 485
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l.f.u(l.l):void");
    }
}
