package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.core.view.ViewCompat;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MenuPopupHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MenuBuilder f331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f334e;
    private View f;
    private int g;
    private boolean h;
    private d.a i;
    private MenuPopup j;
    private PopupWindow.OnDismissListener k;
    private final PopupWindow.OnDismissListener l;

    /* JADX INFO: compiled from: MenuPopupHelper.java */
    static class a {
        static void a(Display r0, Point r1) {
            r0.getRealSize(r1);
        }
    }

    public c(Context r8, MenuBuilder r9, View r10, boolean r11, int r12) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin"), r9, r10, r11, r12, 0);
    }

    public c(Context r3, MenuBuilder r4, View r5, boolean r6, int r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.g = 8388611;
        this.l = new MenuPopupHelper$1(this);
        this.f330a = ZeusTransformUtils.wrapperContext(r9, "com.obric.aiagent.plugin");
        this.f331b = r4;
        this.f = r5;
        this.f332c = r6;
        this.f333d = r7;
        this.f334e = r8;
    }

    public void a(PopupWindow.OnDismissListener r3) {
        this.k = (PopupWindow.OnDismissListener) ZeusTransformUtils.wrapperContextForParams(r3, PopupWindow.OnDismissListener.class, "com.obric.aiagent.plugin");
    }

    public void a(View r1) {
        this.f = r1;
    }

    public void a(boolean r1) {
        this.h = r1;
        MenuPopup r0 = this.j;
        if (r0 == null) goto L6;
        r0.setForceShowIcon(r1);
        return;
    }

    public void a(int r1) {
        this.g = r1;
    }

    public void a() {
        if (c() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    public MenuPopup b() {
        if (this.j != null) goto L6;
        this.j = g();
    L6:
        return this.j;
    }

    public boolean c() {
        if (f() == false) goto L6;
        return true;
    L6:
        if (this.f != null) goto L8;
        return false;
    L8:
        a(0, 0, false, false);
        return true;
    }

    public boolean a(int r3, int r4) {
        if (f() == false) goto L6;
        return true;
    L6:
        if (this.f != null) goto L9;
        return false;
    L9:
        a(r3, r4, true, true);
        return true;
    }

    private MenuPopup g() {
        Display r0 = ((WindowManager) ZeusTransformUtils.preCheckCast(this.f330a.getSystemService("window"), WindowManager.class, "com.obric.aiagent.plugin")).getDefaultDisplay();
        Point r1 = new Point();
        if (Build.VERSION.SDK_INT < 17) goto L5;
        a.a(r0, r1);
    L7:
        if (Math.min(r1.x, r1.y) < ZeusTransformUtils.getResources(this.f330a, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.abc_cascading_menus_min_smallest_width, "dimen", "abc_cascading_menus_min_smallest_width"))) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        MenuPopup r3 = new CascadingMenuPopup(this.f330a, this.f, this.f333d, this.f334e, this.f332c);
    L13:
        r3.addMenu(this.f331b);
        r3.setOnDismissListener(this.l);
        r3.setAnchorView(this.f);
        r3.setCallback(this.i);
        r3.setForceShowIcon(this.h);
        r3.setGravity(this.g);
        return r3;
    L12:
        r3 = new StandardMenuPopup(this.f330a, this.f331b, this.f, this.f333d, this.f334e, this.f332c);
        goto L13
    L9:
        r2 = false;
        goto L10
    L5:
        r0.getSize(r1);
        goto L7
    }

    private void a(int r3, int r4, boolean r5, boolean r6) {
        MenuPopup r0 = b();
        r0.setShowTitle(r6);
        if (r5 == true) goto L5;
    L8:
        r0.show();
        return;
    L5:
        if ((androidx.core.view.d.a(this.g, ViewCompat.i(this.f)) & 7) != 5) goto L7;
        r3 = r3 - this.f.getWidth();
    L7:
        r0.setHorizontalOffset(r3);
        r0.setVerticalOffset(r4);
        int r2 = (int) ((ZeusTransformUtils.getResources(this.f330a, "com.obric.aiagent.plugin").getDisplayMetrics().density * 48.0f) / 2.0f);
        r0.setEpicenterBounds(new Rect(r3 - r2, r4 - r2, r3 + r2, r4 + r2));
        goto L8
    }

    public void d() {
        if (f() == false) goto L6;
        this.j.dismiss();
        return;
    }

    public void e() {
        this.j = null;
        PopupWindow.OnDismissListener r1 = this.k;
        if (r1 == null) goto L6;
        r1.onDismiss();
        return;
    }

    public boolean f() {
        MenuPopup r0 = this.j;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isShowing() == false) goto L7;
        return true;
    }

    public void a(d.a r3) {
        d.a r4 = (d.a) ZeusTransformUtils.wrapperContextForParams(r3, d.a.class, "com.obric.aiagent.plugin");
        this.i = r4;
        MenuPopup r2 = this.j;
        if (r2 == null) goto L6;
        r2.setCallback(r4);
        return;
    }
}
