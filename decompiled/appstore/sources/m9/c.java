package m9;

import android.R;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.drawerlayout.widget.DrawerLayout;

/* JADX INFO: loaded from: classes3.dex */
public class c implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f22207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f22208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Activity f22209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Window f22210e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f22211f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f22212g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f22213h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f22214i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f22215j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f22216k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f22217l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f22218m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f22219n;

    public c(e r10, Activity r11, Window r12) {
        this.f22214i = 0;
        this.f22215j = 0;
        this.f22216k = 0;
        this.f22217l = 0;
        this.f22208c = r10;
        this.f22209d = r11;
        this.f22210e = r12;
        View r13 = r12.getDecorView();
        this.f22211f = r13;
        FrameLayout r14 = (FrameLayout) r13.findViewById(R.id.content);
        View r15 = r14.getChildAt(0);
        this.f22213h = r15;
        if (r15 != null) goto L5;
    L10:
        View r16 = this.f22213h;
        View r17 = r14;
        if (r16 == null) goto L13;
        r17 = r16;
    L13:
        this.f22212g = r17;
        a r18 = new a(this.f22209d);
        this.f22206a = r18.i();
        this.f22207b = r18.a();
        return;
    L5:
        if ((r15 instanceof DrawerLayout) == false) goto L7;
        this.f22213h = ((DrawerLayout) r15).getChildAt(0);
    L7:
        View r19 = this.f22213h;
        if (r19 == null) goto L10;
        this.f22214i = r19.getPaddingLeft();
        this.f22215j = this.f22213h.getPaddingTop();
        this.f22216k = this.f22213h.getPaddingRight();
        this.f22217l = this.f22213h.getPaddingBottom();
        goto L10
    }

    public void a() {
        if (this.f22219n == false) goto L6;
        this.f22211f.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.f22219n = false;
        return;
    }

    public void b() {
        if (this.f22219n == true) goto L5;
        return;
    L5:
        if (this.f22213h == null) goto L7;
        this.f22212g.setPadding(this.f22214i, this.f22215j, this.f22216k, this.f22217l);
        return;
    L7:
        this.f22212g.setPadding(this.f22208c.B(), this.f22208c.D(), this.f22208c.C(), this.f22208c.A());
    }

    public void c(int r10) {
        this.f22210e.setSoftInputMode(r10);
        if (this.f22219n == true) goto L6;
        this.f22211f.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.f22219n = true;
        return;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        e r10 = this.f22208c;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.y() != null) goto L7;
        return;
    L7:
        if (this.f22208c.y().C == false) goto L42;
        int r11 = e.z(this.f22209d);
        Rect r12 = new Rect();
        this.f22211f.getWindowVisibleDisplayFrame(r12);
        int r13 = this.f22212g.getHeight() - r12.bottom;
        if (r13 == this.f22218m) goto L43;
        this.f22218m = r13;
        boolean r14 = true;
        int r15 = 0;
        if (e.n(this.f22210e.getDecorView().findViewById(R.id.content)) == false) goto L13;
        r13 = r13 - r11;
        if (r13 > r11) goto L33;
        r14 = false;
    L33:
        if (r13 < 0) goto L37;
        r15 = r13;
    L37:
        if (this.f22208c.y().I == null) goto L44;
        this.f22208c.y().I.onKeyboardChange(r14, r15);
        return;
    L44:
        return;
    L13:
        if (this.f22213h != null) goto L15;
        int r16 = this.f22208c.A();
        r13 = r13 - r11;
        if (r13 <= r11) goto L27;
        r16 = r13 + r11;
    L28:
        this.f22212g.setPadding(this.f22208c.B(), this.f22208c.D(), this.f22208c.C(), r16);
        goto L33
    L27:
        r14 = false;
        goto L28
    L15:
        if (this.f22208c.y().B == false) goto L18;
        r13 = r13 + (this.f22207b + this.f22206a);
    L18:
        if (this.f22208c.y().f22203x == false) goto L20;
        r13 = r13 + this.f22206a;
    L20:
        if (r13 <= r11) goto L22;
        int r17 = this.f22217l + r13;
    L23:
        this.f22212g.setPadding(this.f22214i, this.f22215j, this.f22216k, r17);
        goto L33
    L22:
        r17 = 0;
        r14 = false;
        goto L23
    L43:
        return;
    }
}
