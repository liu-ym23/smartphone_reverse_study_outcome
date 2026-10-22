package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.appcompat.R$dimen;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class j implements MenuHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MenuBuilder f607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f609d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f610e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f611f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f612g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f613h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MenuPresenter.Callback f614i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public i f615j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PopupWindow.OnDismissListener f616k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PopupWindow.OnDismissListener f617l;

    public class a implements PopupWindow.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f618a;

        public a(j r10) {
            this.f618a = r10;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            this.f618a.d();
        }
    }

    public static class b {
        @DoNotInline
        public static void a(Display r10, Point r11) {
            r10.getRealSize(r11);
        }
    }

    public j(Context r10, MenuBuilder r11, View r12, boolean r13, int r14) {
        this(r10, r11, r12, r13, r14, 0);
    }

    public final i a() {
        Display r10 = ((WindowManager) this.f606a.getSystemService("window")).getDefaultDisplay();
        Point r11 = new Point();
        b.a(r10, r11);
        if (Math.min(r11.x, r11.y) < this.f606a.getResources().getDimensionPixelSize(R$dimen.abc_cascading_menus_min_smallest_width)) goto L5;
        i r12 = new CascadingMenuPopup(this.f606a, this.f611f, this.f609d, this.f610e, this.f608c);
    L6:
        r12.a(this.f607b);
        r12.setOnDismissListener(this.f617l);
        r12.e(this.f611f);
        r12.setCallback(this.f614i);
        r12.g(this.f613h);
        r12.h(this.f612g);
        return r12;
    L5:
        r12 = new l(this.f606a, this.f607b, this.f611f, this.f609d, this.f610e, this.f608c);
        goto L6
    }

    public i b() {
        if (this.f615j != null) goto L6;
        this.f615j = a();
    L6:
        return this.f615j;
    }

    public boolean c() {
        i r10 = this.f615j;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isShowing() == false) goto L7;
        return true;
    }

    public void d() {
        this.f615j = null;
        PopupWindow.OnDismissListener r10 = this.f616k;
        if (r10 == null) goto L6;
        r10.onDismiss();
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuHelper
    public void dismiss() {
        if (c() == false) goto L6;
        this.f615j.dismiss();
        return;
    }

    public void e(View r10) {
        this.f611f = r10;
    }

    public void f(boolean r10) {
        this.f613h = r10;
        i r11 = this.f615j;
        if (r11 == null) goto L6;
        r11.g(r10);
        return;
    }

    public void g(int r10) {
        this.f612g = r10;
    }

    public void h() {
        if (j() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    public final void i(int r10, int r11, boolean r12, boolean r13) {
        i r14 = b();
        r14.j(r13);
        if (r12 == true) goto L5;
    L8:
        r14.show();
        return;
    L5:
        if ((androidx.core.view.c.b(this.f612g, ViewCompat.A(this.f611f)) & 7) != 5) goto L7;
        r10 = r10 - this.f611f.getWidth();
    L7:
        r14.i(r10);
        r14.k(r11);
        int r15 = (int) ((this.f606a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
        r14.f(new Rect(r10 - r15, r11 - r15, r10 + r15, r11 + r15));
        goto L8
    }

    public boolean j() {
        if (c() == false) goto L6;
        return true;
    L6:
        if (this.f611f != null) goto L8;
        return false;
    L8:
        i(0, 0, false, false);
        return true;
    }

    public boolean k(int r10, int r11) {
        if (c() == false) goto L6;
        return true;
    L6:
        if (this.f611f != null) goto L9;
        return false;
    L9:
        i(r10, r11, true, true);
        return true;
    }

    public void setOnDismissListener(@Nullable PopupWindow.OnDismissListener r10) {
        this.f616k = r10;
    }

    @Override // androidx.appcompat.view.menu.MenuHelper
    public void setPresenterCallback(MenuPresenter.Callback r10) {
        this.f614i = r10;
        i r11 = this.f615j;
        if (r11 == null) goto L6;
        r11.setCallback(r10);
        return;
    }

    public j(Context r10, MenuBuilder r11, View r12, boolean r13, int r14, int r15) {
        this.f612g = 8388611;
        this.f617l = new a(this);
        this.f606a = r10;
        this.f607b = r11;
        this.f611f = r12;
        this.f608c = r13;
        this.f609d = r14;
        this.f610e = r15;
    }
}
