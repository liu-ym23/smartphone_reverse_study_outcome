package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.R$dimen;
import androidx.appcompat.view.menu.i;
import androidx.core.view.C1321i;
import j.AbstractC4739d;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final Context f8678a;

    /* renamed from: b, reason: collision with root package name */
    public final e f8679b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f8680c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8681d;

    /* renamed from: e, reason: collision with root package name */
    public final int f8682e;

    /* renamed from: f, reason: collision with root package name */
    public View f8683f;

    /* renamed from: g, reason: collision with root package name */
    public int f8684g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f8685h;

    /* renamed from: i, reason: collision with root package name */
    public i.a f8686i;

    /* renamed from: j, reason: collision with root package name */
    public AbstractC4739d f8687j;

    /* renamed from: k, reason: collision with root package name */
    public PopupWindow.OnDismissListener f8688k;

    /* renamed from: l, reason: collision with root package name */
    public final PopupWindow.OnDismissListener f8689l;

    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            h.this.e();
        }
    }

    public h(Context context, e eVar, View view, boolean z10, int i10) {
        this(context, eVar, view, z10, i10, 0);
    }

    public final AbstractC4739d a() {
        Display defaultDisplay = ((WindowManager) this.f8678a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        AbstractC4739d bVar = Math.min(point.x, point.y) >= this.f8678a.getResources().getDimensionPixelSize(R$dimen.abc_cascading_menus_min_smallest_width) ? new b(this.f8678a, this.f8683f, this.f8681d, this.f8682e, this.f8680c) : new k(this.f8678a, this.f8679b, this.f8683f, this.f8681d, this.f8682e, this.f8680c);
        bVar.k(this.f8679b);
        bVar.u(this.f8689l);
        bVar.p(this.f8683f);
        bVar.e(this.f8686i);
        bVar.r(this.f8685h);
        bVar.s(this.f8684g);
        return bVar;
    }

    public void b() {
        if (d()) {
            this.f8687j.dismiss();
        }
    }

    public AbstractC4739d c() {
        if (this.f8687j == null) {
            this.f8687j = a();
        }
        return this.f8687j;
    }

    public boolean d() {
        AbstractC4739d abstractC4739d = this.f8687j;
        return abstractC4739d != null && abstractC4739d.isShowing();
    }

    public void e() {
        this.f8687j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f8688k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(View view) {
        this.f8683f = view;
    }

    public void g(boolean z10) {
        this.f8685h = z10;
        AbstractC4739d abstractC4739d = this.f8687j;
        if (abstractC4739d != null) {
            abstractC4739d.r(z10);
        }
    }

    public void h(int i10) {
        this.f8684g = i10;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.f8688k = onDismissListener;
    }

    public void j(i.a aVar) {
        this.f8686i = aVar;
        AbstractC4739d abstractC4739d = this.f8687j;
        if (abstractC4739d != null) {
            abstractC4739d.e(aVar);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public final void l(int i10, int i11, boolean z10, boolean z11) {
        AbstractC4739d abstractC4739dC = c();
        abstractC4739dC.v(z11);
        if (z10) {
            if ((C1321i.b(this.f8684g, this.f8683f.getLayoutDirection()) & 7) == 5) {
                i10 -= this.f8683f.getWidth();
            }
            abstractC4739dC.t(i10);
            abstractC4739dC.w(i11);
            int i12 = (int) ((this.f8678a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            abstractC4739dC.q(new Rect(i10 - i12, i11 - i12, i10 + i12, i11 + i12));
        }
        abstractC4739dC.show();
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f8683f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i10, int i11) {
        if (d()) {
            return true;
        }
        if (this.f8683f == null) {
            return false;
        }
        l(i10, i11, true, true);
        return true;
    }

    public h(Context context, e eVar, View view, boolean z10, int i10, int i11) {
        this.f8684g = 8388611;
        this.f8689l = new a();
        this.f8678a = context;
        this.f8679b = eVar;
        this.f8683f = view;
        this.f8680c = z10;
        this.f8681d = i10;
        this.f8682e = i11;
    }
}
