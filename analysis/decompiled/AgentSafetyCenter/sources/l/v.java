package l;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import m.b2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    public final Context f7646a;

    /* renamed from: b, reason: collision with root package name */
    public final l f7647b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f7648c;

    /* renamed from: d, reason: collision with root package name */
    public final int f7649d;

    /* renamed from: e, reason: collision with root package name */
    public View f7650e;

    /* renamed from: f, reason: collision with root package name */
    public int f7651f = 8388611;

    /* renamed from: g, reason: collision with root package name */
    public boolean f7652g;

    /* renamed from: h, reason: collision with root package name */
    public w f7653h;
    public t i;

    /* renamed from: j, reason: collision with root package name */
    public PopupWindow.OnDismissListener f7654j;

    /* renamed from: k, reason: collision with root package name */
    public final u f7655k;

    public v(Context context, l lVar, View view, boolean z10, int i, int i3) {
        u uVar = new u();
        uVar.f7645c = this;
        VarHandle.storeStoreFence();
        this.f7655k = uVar;
        this.f7646a = context;
        this.f7647b = lVar;
        this.f7650e = view;
        this.f7648c = z10;
        this.f7649d = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final t a() throws Resources.NotFoundException {
        c0 c0Var;
        if (this.i == null) {
            Context context = this.f7646a;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            int iMin = Math.min(point.x, point.y);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width);
            View view = this.f7650e;
            int i = 2;
            int i3 = 0;
            boolean z10 = false;
            l lVar = this.f7647b;
            boolean z11 = this.f7648c;
            int i10 = this.f7649d;
            if (iMin >= dimensionPixelSize) {
                f fVar = new f();
                fVar.f7552k = new ArrayList();
                fVar.f7553l = new ArrayList();
                d dVar = new d(i3);
                dVar.f7543f = fVar;
                VarHandle.storeStoreFence();
                fVar.f7554m = dVar;
                ab.b bVar = new ab.b(i);
                bVar.f379f = fVar;
                VarHandle.storeStoreFence();
                fVar.f7555n = bVar;
                a1.g gVar = new a1.g(18, z10 ? 1 : 0);
                gVar.f19f = fVar;
                VarHandle.storeStoreFence();
                fVar.f7556o = gVar;
                fVar.f7557p = 0;
                fVar.f7558q = 0;
                fVar.f7548f = context;
                fVar.f7559r = view;
                fVar.f7550h = i10;
                fVar.i = z11;
                fVar.f7566y = false;
                fVar.f7561t = view.getLayoutDirection() == 1 ? 0 : 1;
                Resources resources = context.getResources();
                fVar.f7549g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
                fVar.f7551j = new Handler();
                VarHandle.storeStoreFence();
                c0Var = fVar;
            } else {
                c0 c0Var2 = new c0();
                d dVar2 = new d(i);
                dVar2.f7543f = c0Var2;
                VarHandle.storeStoreFence();
                c0Var2.f7530m = dVar2;
                ab.b bVar2 = new ab.b(3);
                bVar2.f379f = c0Var2;
                VarHandle.storeStoreFence();
                c0Var2.f7531n = bVar2;
                c0Var2.f7540w = 0;
                c0Var2.f7524f = context;
                c0Var2.f7525g = lVar;
                c0Var2.i = z11;
                c0Var2.f7526h = new i(lVar, LayoutInflater.from(context), z11, R.layout.abc_popup_menu_item_layout);
                c0Var2.f7528k = i10;
                Resources resources2 = context.getResources();
                c0Var2.f7527j = Math.max(resources2.getDisplayMetrics().widthPixels / 2, resources2.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
                c0Var2.f7533p = view;
                c0Var2.f7529l = new b2(context, null, i10, 0);
                lVar.b(c0Var2, context);
                VarHandle.storeStoreFence();
                c0Var = c0Var2;
            }
            c0Var.l(lVar);
            c0Var.r(this.f7655k);
            c0Var.n(this.f7650e);
            c0Var.g(this.f7653h);
            c0Var.o(this.f7652g);
            c0Var.p(this.f7651f);
            this.i = c0Var;
        }
        return this.i;
    }

    public final boolean b() {
        t tVar = this.i;
        return tVar != null && tVar.b();
    }

    public void c() {
        this.i = null;
        PopupWindow.OnDismissListener onDismissListener = this.f7654j;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final void d(int i, int i3, boolean z10, boolean z11) {
        t tVarA = a();
        tVarA.s(z11);
        if (z10) {
            if ((Gravity.getAbsoluteGravity(this.f7651f, this.f7650e.getLayoutDirection()) & 7) == 5) {
                i -= this.f7650e.getWidth();
            }
            tVarA.q(i);
            tVarA.t(i3);
            int i10 = (int) ((this.f7646a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            tVarA.f7644c = new Rect(i - i10, i3 - i10, i + i10, i3 + i10);
        }
        tVarA.f();
    }
}
