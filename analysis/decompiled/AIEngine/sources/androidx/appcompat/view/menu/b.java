package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.g0;
import androidx.appcompat.widget.l0;
import androidx.appcompat.widget.m0;
import com.stepos.aiengine.R;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b extends l.d implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public ViewTreeObserver A;
    public PopupWindow.OnDismissListener B;
    public boolean C;

    /* renamed from: b, reason: collision with root package name */
    public final Context f437b;

    /* renamed from: c, reason: collision with root package name */
    public final int f438c;

    /* renamed from: d, reason: collision with root package name */
    public final int f439d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f440e;
    public final Handler h;

    /* renamed from: q, reason: collision with root package name */
    public View f448q;
    public View r;

    /* renamed from: s, reason: collision with root package name */
    public int f449s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f450t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f451u;

    /* renamed from: v, reason: collision with root package name */
    public int f452v;

    /* renamed from: w, reason: collision with root package name */
    public int f453w;

    /* renamed from: y, reason: collision with root package name */
    public boolean f455y;
    public j.a z;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f441j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f442k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public final a f443l = new a();

    /* renamed from: m, reason: collision with root package name */
    public final ViewOnAttachStateChangeListenerC0002b f444m = new ViewOnAttachStateChangeListenerC0002b();

    /* renamed from: n, reason: collision with root package name */
    public final c f445n = new c();

    /* renamed from: o, reason: collision with root package name */
    public int f446o = 0;

    /* renamed from: p, reason: collision with root package name */
    public int f447p = 0;

    /* renamed from: x, reason: collision with root package name */
    public boolean f454x = false;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            b bVar = b.this;
            ArrayList arrayList = bVar.f442k;
            if (!bVar.isShowing() || arrayList.size() <= 0) {
                return;
            }
            int i10 = 0;
            if (((d) arrayList.get(0)).f459a.B) {
                return;
            }
            View view = bVar.r;
            if (view == null || !view.isShown()) {
                bVar.dismiss();
                return;
            }
            int size = arrayList.size();
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                ((d) obj).f459a.show();
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c implements l0 {
        public c() {
        }

        @Override // androidx.appcompat.widget.l0
        public final void a(f fVar, h hVar) {
            b bVar = b.this;
            Handler handler = bVar.h;
            handler.removeCallbacksAndMessages(null);
            ArrayList arrayList = bVar.f442k;
            int size = arrayList.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    i10 = -1;
                    break;
                } else if (fVar == ((d) arrayList.get(i10)).f460b) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 == -1) {
                return;
            }
            int i11 = i10 + 1;
            handler.postAtTime(new androidx.appcompat.view.menu.c(this, i11 < arrayList.size() ? (d) arrayList.get(i11) : null, hVar, fVar), fVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.l0
        public final void c(f fVar, MenuItem menuItem) {
            b.this.h.removeCallbacksAndMessages(fVar);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final m0 f459a;

        /* renamed from: b, reason: collision with root package name */
        public final f f460b;

        /* renamed from: c, reason: collision with root package name */
        public final int f461c;

        public d(m0 m0Var, f fVar, int i10) {
            this.f459a = m0Var;
            this.f460b = fVar;
            this.f461c = i10;
        }
    }

    public b(Context context, View view, int i10, boolean z) {
        this.f437b = context;
        this.f448q = view;
        this.f439d = i10;
        this.f440e = z;
        this.f449s = view.getLayoutDirection() != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.f438c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.h = new Handler();
    }

    @Override // androidx.appcompat.view.menu.j
    public final void a(f fVar, boolean z) {
        ArrayList arrayList = this.f442k;
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            } else if (fVar == ((d) arrayList.get(i10)).f460b) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 < 0) {
            return;
        }
        int i11 = i10 + 1;
        if (i11 < arrayList.size()) {
            ((d) arrayList.get(i11)).f460b.c(false);
        }
        d dVar = (d) arrayList.remove(i10);
        f fVar2 = dVar.f460b;
        m0 m0Var = dVar.f459a;
        fVar2.r(this);
        if (this.C) {
            m0.a.b(m0Var.C, null);
            m0Var.C.setAnimationStyle(0);
        }
        m0Var.dismiss();
        int size2 = arrayList.size();
        if (size2 > 0) {
            this.f449s = ((d) arrayList.get(size2 - 1)).f461c;
        } else {
            this.f449s = this.f448q.getLayoutDirection() == 1 ? 0 : 1;
        }
        if (size2 != 0) {
            if (z) {
                ((d) arrayList.get(0)).f460b.c(false);
                return;
            }
            return;
        }
        dismiss();
        j.a aVar = this.z;
        if (aVar != null) {
            aVar.a(fVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.A;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.A.removeGlobalOnLayoutListener(this.f443l);
            }
            this.A = null;
        }
        this.r.removeOnAttachStateChangeListener(this.f444m);
        this.B.onDismiss();
    }

    @Override // androidx.appcompat.view.menu.j
    public final void b() {
        ArrayList arrayList = this.f442k;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ListAdapter adapter = ((d) obj).f459a.f864c.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((e) adapter).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean c() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void d(j.a aVar) {
        this.z = aVar;
    }

    @Override // l.f
    public final void dismiss() {
        ArrayList arrayList = this.f442k;
        int size = arrayList.size();
        if (size > 0) {
            d[] dVarArr = (d[]) arrayList.toArray(new d[size]);
            for (int i10 = size - 1; i10 >= 0; i10--) {
                d dVar = dVarArr[i10];
                if (dVar.f459a.C.isShowing()) {
                    dVar.f459a.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean f(m mVar) {
        ArrayList arrayList = this.f442k;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            d dVar = (d) obj;
            if (mVar == dVar.f460b) {
                dVar.f459a.f864c.requestFocus();
                return true;
            }
        }
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        i(mVar);
        j.a aVar = this.z;
        if (aVar != null) {
            aVar.b(mVar);
        }
        return true;
    }

    @Override // l.f
    public final g0 getListView() {
        ArrayList arrayList = this.f442k;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((d) arrayList.get(arrayList.size() - 1)).f459a.f864c;
    }

    @Override // l.d
    public final void i(f fVar) {
        fVar.b(this, this.f437b);
        if (isShowing()) {
            r(fVar);
        } else {
            this.f441j.add(fVar);
        }
    }

    @Override // l.f
    public final boolean isShowing() {
        ArrayList arrayList = this.f442k;
        return arrayList.size() > 0 && ((d) arrayList.get(0)).f459a.C.isShowing();
    }

    @Override // l.d
    public final void k(View view) {
        if (this.f448q != view) {
            this.f448q = view;
            this.f447p = Gravity.getAbsoluteGravity(this.f446o, view.getLayoutDirection());
        }
    }

    @Override // l.d
    public final void l(boolean z) {
        this.f454x = z;
    }

    @Override // l.d
    public final void m(int i10) {
        if (this.f446o != i10) {
            this.f446o = i10;
            this.f447p = Gravity.getAbsoluteGravity(i10, this.f448q.getLayoutDirection());
        }
    }

    @Override // l.d
    public final void n(int i10) {
        this.f450t = true;
        this.f452v = i10;
    }

    @Override // l.d
    public final void o(PopupWindow.OnDismissListener onDismissListener) {
        this.B = onDismissListener;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        d dVar;
        ArrayList arrayList = this.f442k;
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                dVar = null;
                break;
            }
            dVar = (d) arrayList.get(i10);
            if (!dVar.f459a.C.isShowing()) {
                break;
            } else {
                i10++;
            }
        }
        if (dVar != null) {
            dVar.f460b.c(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i10 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // l.d
    public final void p(boolean z) {
        this.f455y = z;
    }

    @Override // l.d
    public final void q(int i10) {
        this.f451u = true;
        this.f453w = i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0180  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(androidx.appcompat.view.menu.f r18) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.b.r(androidx.appcompat.view.menu.f):void");
    }

    @Override // l.f
    public final void show() {
        if (isShowing()) {
            return;
        }
        ArrayList arrayList = this.f441j;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            r((f) obj);
        }
        arrayList.clear();
        View view = this.f448q;
        this.r = view;
        if (view != null) {
            boolean z = this.A == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.A = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f443l);
            }
            this.r.addOnAttachStateChangeListener(this.f444m);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: androidx.appcompat.view.menu.b$b, reason: collision with other inner class name */
    public class ViewOnAttachStateChangeListenerC0002b implements View.OnAttachStateChangeListener {
        public ViewOnAttachStateChangeListenerC0002b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            b bVar = b.this;
            ViewTreeObserver viewTreeObserver = bVar.A;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    bVar.A = view.getViewTreeObserver();
                }
                bVar.A.removeGlobalOnLayoutListener(bVar.f443l);
            }
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
        }
    }
}
