package f;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.stepos.stepclaw.R;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public final Context f2498a;

    /* renamed from: b, reason: collision with root package name */
    public final j f2499b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f2500c;
    public final int d;

    /* renamed from: e, reason: collision with root package name */
    public View f2501e;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2503g;

    /* renamed from: h, reason: collision with root package name */
    public o f2504h;

    /* renamed from: i, reason: collision with root package name */
    public l f2505i;

    /* renamed from: j, reason: collision with root package name */
    public PopupWindow.OnDismissListener f2506j;

    /* renamed from: f, reason: collision with root package name */
    public int f2502f = 8388611;

    /* renamed from: k, reason: collision with root package name */
    public final m f2507k = new m(this);

    public n(Context context, j jVar, View view, boolean z, int i8, int i9) {
        this.f2498a = context;
        this.f2499b = jVar;
        this.f2501e = view;
        this.f2500c = z;
        this.d = i8;
    }

    public final l a() {
        l sVar;
        if (this.f2505i == null) {
            Context context = this.f2498a;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            if (Math.min(point.x, point.y) >= context.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
                sVar = new g(context, this.f2501e, this.d, this.f2500c);
            } else {
                sVar = new s(this.f2498a, this.f2499b, this.f2501e, this.d, this.f2500c);
            }
            sVar.l(this.f2499b);
            sVar.r(this.f2507k);
            sVar.n(this.f2501e);
            sVar.d(this.f2504h);
            sVar.o(this.f2503g);
            sVar.p(this.f2502f);
            this.f2505i = sVar;
        }
        return this.f2505i;
    }

    public final boolean b() {
        l lVar = this.f2505i;
        return lVar != null && lVar.k();
    }

    public void c() {
        this.f2505i = null;
        PopupWindow.OnDismissListener onDismissListener = this.f2506j;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final void d(int i8, int i9, boolean z, boolean z2) {
        l lVarA = a();
        lVarA.s(z2);
        if (z) {
            if ((Gravity.getAbsoluteGravity(this.f2502f, this.f2501e.getLayoutDirection()) & 7) == 5) {
                i8 -= this.f2501e.getWidth();
            }
            lVarA.q(i8);
            lVarA.t(i9);
            int i10 = (int) ((this.f2498a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            lVarA.f2496a = new Rect(i8 - i10, i9 - i10, i8 + i10, i9 + i10);
        }
        lVarA.a();
    }
}
