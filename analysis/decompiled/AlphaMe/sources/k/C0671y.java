package k;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.stepos.alphame.R;

/* renamed from: k.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0671y {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13307a;

    /* renamed from: b, reason: collision with root package name */
    public final C0661o f13308b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f13309c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13310d;

    /* renamed from: e, reason: collision with root package name */
    public final int f13311e;

    /* renamed from: f, reason: collision with root package name */
    public View f13312f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f13314h;

    /* renamed from: i, reason: collision with root package name */
    public InterfaceC0672z f13315i;

    /* renamed from: j, reason: collision with root package name */
    public AbstractC0669w f13316j;

    /* renamed from: k, reason: collision with root package name */
    public PopupWindow.OnDismissListener f13317k;

    /* renamed from: g, reason: collision with root package name */
    public int f13313g = 8388611;

    /* renamed from: l, reason: collision with root package name */
    public final C0670x f13318l = new C0670x(this);

    public C0671y(int i4, int i5, Context context, View view, C0661o c0661o, boolean z4) {
        this.f13307a = context;
        this.f13308b = c0661o;
        this.f13312f = view;
        this.f13309c = z4;
        this.f13310d = i4;
        this.f13311e = i5;
    }

    public final AbstractC0669w a() {
        AbstractC0669w viewOnKeyListenerC0645F;
        if (this.f13316j == null) {
            Context context = this.f13307a;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            if (Math.min(point.x, point.y) >= context.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
                viewOnKeyListenerC0645F = new ViewOnKeyListenerC0655i(this.f13307a, this.f13312f, this.f13310d, this.f13311e, this.f13309c);
            } else {
                View view = this.f13312f;
                viewOnKeyListenerC0645F = new ViewOnKeyListenerC0645F(this.f13310d, this.f13311e, this.f13307a, view, this.f13308b, this.f13309c);
            }
            viewOnKeyListenerC0645F.l(this.f13308b);
            viewOnKeyListenerC0645F.r(this.f13318l);
            viewOnKeyListenerC0645F.n(this.f13312f);
            viewOnKeyListenerC0645F.j(this.f13315i);
            viewOnKeyListenerC0645F.o(this.f13314h);
            viewOnKeyListenerC0645F.p(this.f13313g);
            this.f13316j = viewOnKeyListenerC0645F;
        }
        return this.f13316j;
    }

    public final boolean b() {
        AbstractC0669w abstractC0669w = this.f13316j;
        return abstractC0669w != null && abstractC0669w.e();
    }

    public void c() {
        this.f13316j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f13317k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final void d(int i4, int i5, boolean z4, boolean z5) {
        AbstractC0669w abstractC0669wA = a();
        abstractC0669wA.s(z5);
        if (z4) {
            if ((Gravity.getAbsoluteGravity(this.f13313g, this.f13312f.getLayoutDirection()) & 7) == 5) {
                i4 -= this.f13312f.getWidth();
            }
            abstractC0669wA.q(i4);
            abstractC0669wA.t(i5);
            int i6 = (int) ((this.f13307a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            abstractC0669wA.f13305a = new Rect(i4 - i6, i5 - i6, i4 + i6, i5 + i6);
        }
        abstractC0669wA.g();
    }
}
