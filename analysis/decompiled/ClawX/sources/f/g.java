package f;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.stepos.stepclaw.R;
import g.g1;
import g.j1;
import g.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g extends l implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public boolean A;

    /* renamed from: b, reason: collision with root package name */
    public final Context f2427b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2428c;
    public final int d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f2429e;

    /* renamed from: f, reason: collision with root package name */
    public final Handler f2430f;

    /* renamed from: o, reason: collision with root package name */
    public View f2438o;

    /* renamed from: p, reason: collision with root package name */
    public View f2439p;

    /* renamed from: q, reason: collision with root package name */
    public int f2440q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f2441r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f2442s;

    /* renamed from: t, reason: collision with root package name */
    public int f2443t;

    /* renamed from: u, reason: collision with root package name */
    public int f2444u;

    /* renamed from: w, reason: collision with root package name */
    public boolean f2446w;

    /* renamed from: x, reason: collision with root package name */
    public o f2447x;
    public ViewTreeObserver y;
    public PopupWindow.OnDismissListener z;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f2431g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f2432h = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public final c f2433j = new c(this, 0);

    /* renamed from: k, reason: collision with root package name */
    public final d f2434k = new d(0, this);

    /* renamed from: l, reason: collision with root package name */
    public final androidx.emoji2.text.m f2435l = new androidx.emoji2.text.m(this);

    /* renamed from: m, reason: collision with root package name */
    public int f2436m = 0;

    /* renamed from: n, reason: collision with root package name */
    public int f2437n = 0;

    /* renamed from: v, reason: collision with root package name */
    public boolean f2445v = false;

    public g(Context context, View view, int i8, boolean z) {
        this.f2427b = context;
        this.f2438o = view;
        this.d = i8;
        this.f2429e = z;
        this.f2440q = view.getLayoutDirection() != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.f2428c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f2430f = new Handler();
    }

    @Override // f.r
    public final void a() {
        if (k()) {
            return;
        }
        ArrayList arrayList = this.f2431g;
        int size = arrayList.size();
        int i8 = 0;
        while (i8 < size) {
            Object obj = arrayList.get(i8);
            i8++;
            u((j) obj);
        }
        arrayList.clear();
        View view = this.f2438o;
        this.f2439p = view;
        if (view != null) {
            boolean z = this.y == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.y = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f2433j);
            }
            this.f2439p.addOnAttachStateChangeListener(this.f2434k);
        }
    }

    @Override // f.p
    public final void b(j jVar, boolean z) {
        ArrayList arrayList = this.f2432h;
        int size = arrayList.size();
        int i8 = 0;
        while (true) {
            if (i8 >= size) {
                i8 = -1;
                break;
            } else if (jVar == ((f) arrayList.get(i8)).f2425b) {
                break;
            } else {
                i8++;
            }
        }
        if (i8 < 0) {
            return;
        }
        int i9 = i8 + 1;
        if (i9 < arrayList.size()) {
            ((f) arrayList.get(i9)).f2425b.c(false);
        }
        f fVar = (f) arrayList.remove(i8);
        j jVar2 = fVar.f2425b;
        j1 j1Var = fVar.f2424a;
        x xVar = j1Var.f2757w;
        CopyOnWriteArrayList copyOnWriteArrayList = jVar2.f2470r;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            p pVar = (p) weakReference.get();
            if (pVar == null || pVar == this) {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
        if (this.A) {
            g1.b(xVar, null);
            xVar.setAnimationStyle(0);
        }
        j1Var.dismiss();
        int size2 = arrayList.size();
        if (size2 > 0) {
            this.f2440q = ((f) arrayList.get(size2 - 1)).f2426c;
        } else {
            this.f2440q = this.f2438o.getLayoutDirection() == 1 ? 0 : 1;
        }
        if (size2 != 0) {
            if (z) {
                ((f) arrayList.get(0)).f2425b.c(false);
                return;
            }
            return;
        }
        dismiss();
        o oVar = this.f2447x;
        if (oVar != null) {
            oVar.b(jVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.y;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.y.removeGlobalOnLayoutListener(this.f2433j);
            }
            this.y = null;
        }
        this.f2439p.removeOnAttachStateChangeListener(this.f2434k);
        this.z.onDismiss();
    }

    @Override // f.p
    public final void d(o oVar) {
        this.f2447x = oVar;
    }

    @Override // f.r
    public final void dismiss() {
        ArrayList arrayList = this.f2432h;
        int size = arrayList.size();
        if (size > 0) {
            f[] fVarArr = (f[]) arrayList.toArray(new f[size]);
            for (int i8 = size - 1; i8 >= 0; i8--) {
                f fVar = fVarArr[i8];
                if (fVar.f2424a.f2757w.isShowing()) {
                    fVar.f2424a.dismiss();
                }
            }
        }
    }

    @Override // f.p
    public final void e() {
        ArrayList arrayList = this.f2432h;
        int size = arrayList.size();
        int i8 = 0;
        while (i8 < size) {
            Object obj = arrayList.get(i8);
            i8++;
            ListAdapter adapter = ((f) obj).f2424a.f2739c.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((h) adapter).notifyDataSetChanged();
        }
    }

    @Override // f.r
    public final ListView g() {
        ArrayList arrayList = this.f2432h;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((f) arrayList.get(arrayList.size() - 1)).f2424a.f2739c;
    }

    @Override // f.p
    public final boolean h() {
        return false;
    }

    @Override // f.p
    public final boolean j(t tVar) {
        ArrayList arrayList = this.f2432h;
        int size = arrayList.size();
        int i8 = 0;
        while (i8 < size) {
            Object obj = arrayList.get(i8);
            i8++;
            f fVar = (f) obj;
            if (tVar == fVar.f2425b) {
                fVar.f2424a.f2739c.requestFocus();
                return true;
            }
        }
        if (!tVar.hasVisibleItems()) {
            return false;
        }
        l(tVar);
        o oVar = this.f2447x;
        if (oVar != null) {
            oVar.g(tVar);
        }
        return true;
    }

    @Override // f.r
    public final boolean k() {
        ArrayList arrayList = this.f2432h;
        return arrayList.size() > 0 && ((f) arrayList.get(0)).f2424a.f2757w.isShowing();
    }

    @Override // f.l
    public final void l(j jVar) {
        jVar.b(this, this.f2427b);
        if (k()) {
            u(jVar);
        } else {
            this.f2431g.add(jVar);
        }
    }

    @Override // f.l
    public final void n(View view) {
        if (this.f2438o != view) {
            this.f2438o = view;
            this.f2437n = Gravity.getAbsoluteGravity(this.f2436m, view.getLayoutDirection());
        }
    }

    @Override // f.l
    public final void o(boolean z) {
        this.f2445v = z;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        f fVar;
        ArrayList arrayList = this.f2432h;
        int size = arrayList.size();
        int i8 = 0;
        while (true) {
            if (i8 >= size) {
                fVar = null;
                break;
            }
            fVar = (f) arrayList.get(i8);
            if (!fVar.f2424a.f2757w.isShowing()) {
                break;
            } else {
                i8++;
            }
        }
        if (fVar != null) {
            fVar.f2425b.c(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i8, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i8 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // f.l
    public final void p(int i8) {
        if (this.f2436m != i8) {
            this.f2436m = i8;
            this.f2437n = Gravity.getAbsoluteGravity(i8, this.f2438o.getLayoutDirection());
        }
    }

    @Override // f.l
    public final void q(int i8) {
        this.f2441r = true;
        this.f2443t = i8;
    }

    @Override // f.l
    public final void r(PopupWindow.OnDismissListener onDismissListener) {
        this.z = onDismissListener;
    }

    @Override // f.l
    public final void s(boolean z) {
        this.f2446w = z;
    }

    @Override // f.l
    public final void t(int i8) {
        this.f2442s = true;
        this.f2444u = i8;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0192  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(f.j r18) {
        /*
            Method dump skipped, instructions count: 496
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f.g.u(f.j):void");
    }
}
