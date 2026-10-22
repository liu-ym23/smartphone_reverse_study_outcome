package k;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.widget.C0229u0;
import androidx.appcompat.widget.I0;
import androidx.appcompat.widget.L0;
import com.stepos.alphame.R;
import d.C0527a;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: k.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnKeyListenerC0655i extends AbstractC0669w implements View.OnKeyListener, PopupWindow.OnDismissListener {

    /* renamed from: A, reason: collision with root package name */
    public boolean f13196A;

    /* renamed from: b, reason: collision with root package name */
    public final Context f13197b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13198c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13199d;

    /* renamed from: e, reason: collision with root package name */
    public final int f13200e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f13201f;

    /* renamed from: g, reason: collision with root package name */
    public final Handler f13202g;

    /* renamed from: o, reason: collision with root package name */
    public View f13210o;

    /* renamed from: p, reason: collision with root package name */
    public View f13211p;

    /* renamed from: q, reason: collision with root package name */
    public int f13212q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f13213r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f13214s;

    /* renamed from: t, reason: collision with root package name */
    public int f13215t;

    /* renamed from: u, reason: collision with root package name */
    public int f13216u;

    /* renamed from: w, reason: collision with root package name */
    public boolean f13218w;

    /* renamed from: x, reason: collision with root package name */
    public InterfaceC0672z f13219x;

    /* renamed from: y, reason: collision with root package name */
    public ViewTreeObserver f13220y;

    /* renamed from: z, reason: collision with root package name */
    public PopupWindow.OnDismissListener f13221z;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f13203h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f13204i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public final ViewTreeObserverOnGlobalLayoutListenerC0651e f13205j = new ViewTreeObserverOnGlobalLayoutListenerC0651e(0, this);

    /* renamed from: k, reason: collision with root package name */
    public final ViewOnAttachStateChangeListenerC0652f f13206k = new ViewOnAttachStateChangeListenerC0652f(0, this);

    /* renamed from: l, reason: collision with root package name */
    public final C0527a f13207l = new C0527a(3, this);

    /* renamed from: m, reason: collision with root package name */
    public int f13208m = 0;

    /* renamed from: n, reason: collision with root package name */
    public int f13209n = 0;

    /* renamed from: v, reason: collision with root package name */
    public boolean f13217v = false;

    public ViewOnKeyListenerC0655i(Context context, View view, int i4, int i5, boolean z4) {
        this.f13197b = context;
        this.f13210o = view;
        this.f13199d = i4;
        this.f13200e = i5;
        this.f13201f = z4;
        this.f13212q = view.getLayoutDirection() != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.f13198c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f13202g = new Handler();
    }

    @Override // k.InterfaceC0640A
    public final void a() {
        Iterator it = this.f13204i.iterator();
        while (it.hasNext()) {
            ListAdapter adapter = ((C0654h) it.next()).f13193a.f2823c.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((C0658l) adapter).notifyDataSetChanged();
        }
    }

    @Override // k.InterfaceC0640A
    public final void b(C0661o c0661o, boolean z4) {
        ArrayList arrayList = this.f13204i;
        int size = arrayList.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                i4 = -1;
                break;
            } else if (c0661o == ((C0654h) arrayList.get(i4)).f13194b) {
                break;
            } else {
                i4++;
            }
        }
        if (i4 < 0) {
            return;
        }
        int i5 = i4 + 1;
        if (i5 < arrayList.size()) {
            ((C0654h) arrayList.get(i5)).f13194b.c(false);
        }
        C0654h c0654h = (C0654h) arrayList.remove(i4);
        c0654h.f13194b.r(this);
        boolean z5 = this.f13196A;
        L0 l02 = c0654h.f13193a;
        if (z5) {
            I0.b(l02.f2846z, null);
            l02.f2846z.setAnimationStyle(0);
        }
        l02.dismiss();
        int size2 = arrayList.size();
        if (size2 > 0) {
            this.f13212q = ((C0654h) arrayList.get(size2 - 1)).f13195c;
        } else {
            this.f13212q = this.f13210o.getLayoutDirection() == 1 ? 0 : 1;
        }
        if (size2 != 0) {
            if (z4) {
                ((C0654h) arrayList.get(0)).f13194b.c(false);
                return;
            }
            return;
        }
        dismiss();
        InterfaceC0672z interfaceC0672z = this.f13219x;
        if (interfaceC0672z != null) {
            interfaceC0672z.b(c0661o, true);
        }
        ViewTreeObserver viewTreeObserver = this.f13220y;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f13220y.removeGlobalOnLayoutListener(this.f13205j);
            }
            this.f13220y = null;
        }
        this.f13211p.removeOnAttachStateChangeListener(this.f13206k);
        this.f13221z.onDismiss();
    }

    @Override // k.InterfaceC0640A
    public final boolean c() {
        return false;
    }

    @Override // k.InterfaceC0644E
    public final void dismiss() {
        ArrayList arrayList = this.f13204i;
        int size = arrayList.size();
        if (size > 0) {
            C0654h[] c0654hArr = (C0654h[]) arrayList.toArray(new C0654h[size]);
            for (int i4 = size - 1; i4 >= 0; i4--) {
                C0654h c0654h = c0654hArr[i4];
                if (c0654h.f13193a.f2846z.isShowing()) {
                    c0654h.f13193a.dismiss();
                }
            }
        }
    }

    @Override // k.InterfaceC0644E
    public final boolean e() {
        ArrayList arrayList = this.f13204i;
        return arrayList.size() > 0 && ((C0654h) arrayList.get(0)).f13193a.f2846z.isShowing();
    }

    @Override // k.InterfaceC0640A
    public final boolean f(SubMenuC0646G subMenuC0646G) {
        Iterator it = this.f13204i.iterator();
        while (it.hasNext()) {
            C0654h c0654h = (C0654h) it.next();
            if (subMenuC0646G == c0654h.f13194b) {
                c0654h.f13193a.f2823c.requestFocus();
                return true;
            }
        }
        if (!subMenuC0646G.hasVisibleItems()) {
            return false;
        }
        l(subMenuC0646G);
        InterfaceC0672z interfaceC0672z = this.f13219x;
        if (interfaceC0672z != null) {
            interfaceC0672z.f(subMenuC0646G);
        }
        return true;
    }

    @Override // k.InterfaceC0644E
    public final void g() {
        if (e()) {
            return;
        }
        ArrayList arrayList = this.f13203h;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            v((C0661o) it.next());
        }
        arrayList.clear();
        View view = this.f13210o;
        this.f13211p = view;
        if (view != null) {
            boolean z4 = this.f13220y == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f13220y = viewTreeObserver;
            if (z4) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f13205j);
            }
            this.f13211p.addOnAttachStateChangeListener(this.f13206k);
        }
    }

    @Override // k.InterfaceC0644E
    public final C0229u0 i() {
        ArrayList arrayList = this.f13204i;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((C0654h) arrayList.get(arrayList.size() - 1)).f13193a.f2823c;
    }

    @Override // k.InterfaceC0640A
    public final void j(InterfaceC0672z interfaceC0672z) {
        this.f13219x = interfaceC0672z;
    }

    @Override // k.AbstractC0669w
    public final void l(C0661o c0661o) {
        c0661o.b(this, this.f13197b);
        if (e()) {
            v(c0661o);
        } else {
            this.f13203h.add(c0661o);
        }
    }

    @Override // k.AbstractC0669w
    public final void n(View view) {
        if (this.f13210o != view) {
            this.f13210o = view;
            this.f13209n = Gravity.getAbsoluteGravity(this.f13208m, view.getLayoutDirection());
        }
    }

    @Override // k.AbstractC0669w
    public final void o(boolean z4) {
        this.f13217v = z4;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        C0654h c0654h;
        ArrayList arrayList = this.f13204i;
        int size = arrayList.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                c0654h = null;
                break;
            }
            c0654h = (C0654h) arrayList.get(i4);
            if (!c0654h.f13193a.f2846z.isShowing()) {
                break;
            } else {
                i4++;
            }
        }
        if (c0654h != null) {
            c0654h.f13194b.c(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i4, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i4 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // k.AbstractC0669w
    public final void p(int i4) {
        if (this.f13208m != i4) {
            this.f13208m = i4;
            this.f13209n = Gravity.getAbsoluteGravity(i4, this.f13210o.getLayoutDirection());
        }
    }

    @Override // k.AbstractC0669w
    public final void q(int i4) {
        this.f13213r = true;
        this.f13215t = i4;
    }

    @Override // k.AbstractC0669w
    public final void r(PopupWindow.OnDismissListener onDismissListener) {
        this.f13221z = onDismissListener;
    }

    @Override // k.AbstractC0669w
    public final void s(boolean z4) {
        this.f13218w = z4;
    }

    @Override // k.AbstractC0669w
    public final void t(int i4) {
        this.f13214s = true;
        this.f13216u = i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0160  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(k.C0661o r17) {
        /*
            Method dump skipped, instructions count: 444
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k.ViewOnKeyListenerC0655i.v(k.o):void");
    }
}
