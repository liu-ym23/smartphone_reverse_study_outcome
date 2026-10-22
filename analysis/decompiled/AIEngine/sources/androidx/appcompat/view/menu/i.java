package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.j;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public final Context f522a;

    /* renamed from: b, reason: collision with root package name */
    public final f f523b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f524c;

    /* renamed from: d, reason: collision with root package name */
    public final int f525d;

    /* renamed from: e, reason: collision with root package name */
    public View f526e;

    /* renamed from: g, reason: collision with root package name */
    public boolean f528g;
    public j.a h;

    /* renamed from: i, reason: collision with root package name */
    public l.d f529i;

    /* renamed from: j, reason: collision with root package name */
    public PopupWindow.OnDismissListener f530j;

    /* renamed from: f, reason: collision with root package name */
    public int f527f = 8388611;

    /* renamed from: k, reason: collision with root package name */
    public final a f531k = new a();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            i.this.c();
        }
    }

    public i(Context context, f fVar, View view, boolean z, int i10, int i11) {
        this.f522a = context;
        this.f523b = fVar;
        this.f526e = view;
        this.f524c = z;
        this.f525d = i10;
    }

    public final l.d a() {
        l.d lVar;
        if (this.f529i == null) {
            Context context = this.f522a;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            if (Math.min(point.x, point.y) >= context.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
                lVar = new b(context, this.f526e, this.f525d, this.f524c);
            } else {
                lVar = new l(this.f522a, this.f523b, this.f526e, this.f525d, this.f524c);
            }
            lVar.i(this.f523b);
            lVar.o(this.f531k);
            lVar.k(this.f526e);
            lVar.d(this.h);
            lVar.l(this.f528g);
            lVar.m(this.f527f);
            this.f529i = lVar;
        }
        return this.f529i;
    }

    public final boolean b() {
        l.d dVar = this.f529i;
        return dVar != null && dVar.isShowing();
    }

    public void c() {
        this.f529i = null;
        PopupWindow.OnDismissListener onDismissListener = this.f530j;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final void d(int i10, int i11, boolean z, boolean z3) {
        l.d dVarA = a();
        dVarA.p(z3);
        if (z) {
            if ((Gravity.getAbsoluteGravity(this.f527f, this.f526e.getLayoutDirection()) & 7) == 5) {
                i10 -= this.f526e.getWidth();
            }
            dVarA.n(i10);
            dVarA.q(i11);
            int i12 = (int) ((this.f522a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            dVarA.f10179a = new Rect(i10 - i12, i11 - i12, i10 + i12, i11 + i12);
        }
        dVarA.show();
    }
}
