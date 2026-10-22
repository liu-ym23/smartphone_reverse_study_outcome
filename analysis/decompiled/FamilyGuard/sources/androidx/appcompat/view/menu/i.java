package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.j;
import androidx.core.view.C0464i;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private final Context f7939a;

    /* renamed from: b, reason: collision with root package name */
    private final e f7940b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f7941c;

    /* renamed from: d, reason: collision with root package name */
    private final int f7942d;

    /* renamed from: e, reason: collision with root package name */
    private final int f7943e;

    /* renamed from: f, reason: collision with root package name */
    private View f7944f;

    /* renamed from: g, reason: collision with root package name */
    private int f7945g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f7946h;

    /* renamed from: i, reason: collision with root package name */
    private j.a f7947i;

    /* renamed from: j, reason: collision with root package name */
    private h f7948j;

    /* renamed from: k, reason: collision with root package name */
    private PopupWindow.OnDismissListener f7949k;

    /* renamed from: l, reason: collision with root package name */
    private final PopupWindow.OnDismissListener f7950l;

    class a implements PopupWindow.OnDismissListener {
        a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            i.this.e();
        }
    }

    public i(Context context, e eVar, View view, boolean z5, int i5) {
        this(context, eVar, view, z5, i5, 0);
    }

    private h a() {
        Display defaultDisplay = ((WindowManager) this.f7939a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        h bVar = Math.min(point.x, point.y) >= this.f7939a.getResources().getDimensionPixelSize(g.d.f16861c) ? new b(this.f7939a, this.f7944f, this.f7942d, this.f7943e, this.f7941c) : new l(this.f7939a, this.f7940b, this.f7944f, this.f7942d, this.f7943e, this.f7941c);
        bVar.k(this.f7940b);
        bVar.u(this.f7950l);
        bVar.p(this.f7944f);
        bVar.g(this.f7947i);
        bVar.r(this.f7946h);
        bVar.s(this.f7945g);
        return bVar;
    }

    private void l(int i5, int i6, boolean z5, boolean z6) {
        h hVarC = c();
        hVarC.v(z6);
        if (z5) {
            if ((C0464i.b(this.f7945g, this.f7944f.getLayoutDirection()) & 7) == 5) {
                i5 -= this.f7944f.getWidth();
            }
            hVarC.t(i5);
            hVarC.w(i6);
            int i7 = (int) ((this.f7939a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            hVarC.q(new Rect(i5 - i7, i6 - i7, i5 + i7, i6 + i7));
        }
        hVarC.a();
    }

    public void b() {
        if (d()) {
            this.f7948j.dismiss();
        }
    }

    public h c() {
        if (this.f7948j == null) {
            this.f7948j = a();
        }
        return this.f7948j;
    }

    public boolean d() {
        h hVar = this.f7948j;
        return hVar != null && hVar.h();
    }

    protected void e() {
        this.f7948j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f7949k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(View view) {
        this.f7944f = view;
    }

    public void g(boolean z5) {
        this.f7946h = z5;
        h hVar = this.f7948j;
        if (hVar != null) {
            hVar.r(z5);
        }
    }

    public void h(int i5) {
        this.f7945g = i5;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.f7949k = onDismissListener;
    }

    public void j(j.a aVar) {
        this.f7947i = aVar;
        h hVar = this.f7948j;
        if (hVar != null) {
            hVar.g(aVar);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f7944f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i5, int i6) {
        if (d()) {
            return true;
        }
        if (this.f7944f == null) {
            return false;
        }
        l(i5, i6, true, true);
        return true;
    }

    public i(Context context, e eVar, View view, boolean z5, int i5, int i6) {
        this.f7945g = 8388611;
        this.f7950l = new a();
        this.f7939a = context;
        this.f7940b = eVar;
        this.f7944f = view;
        this.f7941c = z5;
        this.f7942d = i5;
        this.f7943e = i6;
    }
}
