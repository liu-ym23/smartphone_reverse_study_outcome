package zd;

import android.os.IBinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.o;
import com.obric.oui.utils.log.L;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f26379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f26380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f26381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f26382d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f26383e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f26384f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f26385g;

    public static final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f26386a;

        public a(d r10) {
            this.f26386a = r10;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r10) {
            q.g(r10, "v");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r10) {
            q.g(r10, "v");
            this.f26386a.i();
        }
    }

    public d(View r10) {
        q.g(r10, "targetView");
        this.f26379a = r10;
        this.f26381c = 1;
        this.f26385g = new a(this);
    }

    public static /* synthetic */ WindowInsets a(d r10, Function1 r11, View r12, WindowInsets r13) {
        return m(r10, r11, r12, r13);
    }

    public static /* synthetic */ void b(d r10) {
        f(r10);
    }

    public static /* synthetic */ void c(d r10) {
        n(r10);
    }

    public static final void f(d r10) {
        q.g(r10, "this$0");
        if (r10.f26379a.isAttachedToWindow() == true) goto L5;
        return;
    L5:
        if ((r10.f26379a.getParent() instanceof ViewGroup) == false) goto L36;
        ViewParent r11 = r10.f26379a.getParent();
        if (r11 == null) goto L32;
        ViewGroup r12 = (ViewGroup) r11;
        r10.f26383e = r12;
        r12.removeView(r10.f26379a);
        ViewGroup r13 = r10.f26383e;
        if (r13 == null) goto L12;
        r13.addOnAttachStateChangeListener(r10.f26385g);
    L12:
        Object r14 = r10.f26379a.getContext().getSystemService("window");
        if (r14 == null) goto L30;
        WindowManager r15 = (WindowManager) r14;
        WindowManager.LayoutParams r16 = new WindowManager.LayoutParams(-1, -2, 1000, 16778024, -3);
        r16.gravity = r10.f26381c;
        r16.setFitInsetsSides(0);
        ViewGroup r17 = r10.f26383e;
        if (r17 != null) goto L17;
        IBinder r18 = null;
    L18:
        r16.token = r18;
        r15.addView(r10.f26379a, r16);     // Catch: Exception -> L27
        r10.f26382d = true;     // Catch: Exception -> L27
        ViewGroup r19 = r10.f26383e;     // Catch: Exception -> L27
        if (r19 != null) goto L23;
        return;
    L23:
        if (r19.getRootWindowInsets() == null) goto L38;
        r10.f26379a.requestApplyInsets();     // Catch: Exception -> L27
        return;
    L38:
        return;
    L27:
        e = move-exception;
        L.b("OFloatingWindowHelper", q.p("Failed to add view to WindowManager: ", e.getMessage()));
        return;
    L17:
        r18 = r17.getWindowToken();
        goto L18
    L30:
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    L32:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public static final WindowInsets m(final d r10, Function1 r11, View r12, WindowInsets r13) {
        q.g(r10, "this$0");
        q.g(r11, "$updateLayout");
        q.g(r12, "$noName_0");
        q.g(r13, "insets");
        if (r10.f26380b == true) goto L5;
    L13:
        wd.a r14 = wd.a.f25402a;
        r11.invoke(wd.a.i(r10.f26379a, r13, true));
    L14:
        return r13;
    L5:
        if (r10.f26382d == false) goto L13;
        ViewGroup r15 = r10.f26383e;
        if (r15 == null) goto L14;
        WindowInsets r16 = r15.getRootWindowInsets();
        if (r16 == null) goto L14;
        wd.a r17 = wd.a.f25402a;
        ViewGroup r18 = r10.f26383e;
        q.d(r18);
        r11.invoke(wd.a.i(r18, r16, true));
        r10.f26379a.post(new c(r10));
        goto L14
    }

    public static final void n(d r10) {
        q.g(r10, "this$0");
        r10.o();
    }

    public final void d(View r10, com.obric.oui.material.b r11, int r12) {
        q.g(r10, "maskView");
        q.g(r11, "maskMaterialConfig");
        pc.a r13 = r11.d();
        q.d(r13);
        float r14 = r13.b();
        this.f26384f = r14;
        if (r14 <= 0.0f) goto L5;
        OMaterialHelper.E(r10, r11, r12);
    L6:
        o.n(r10, r10);
        return;
    L5:
        OMaterialHelper.F(r10, 0);
        goto L6
    }

    public final void e() {
        if (this.f26382d == false) goto L5;
        return;
    L5:
        this.f26379a.post(new zd.a(this));
    }

    public final boolean g() {
        return this.f26380b;
    }

    public final void h() {
        if (this.f26380b == true) goto L5;
        return;
    L5:
        if (this.f26382d == true) goto L9;
        e();
        return;
    }

    public final void i() {
        if (this.f26382d == false) goto L19;
        Object r10 = this.f26379a.getContext().getSystemService("window");     // Catch: Exception -> L7
        if (r10 == null) goto L10;
        ((WindowManager) r10).removeViewImmediate(this.f26379a);     // Catch: Exception -> L7
    L12:
        this.f26382d = false;
        ViewGroup r11 = this.f26383e;
        if (r11 == null) goto L16;
        r11.removeOnAttachStateChangeListener(this.f26385g);
    L16:
        this.f26383e = null;
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");     // Catch: Exception -> L7
    L7:
        e = move-exception;
        L.b("OFloatingWindowHelper", q.p("Failed to remove view from WindowManager: ", e.getMessage()));
        goto L12
    }

    public final void j(boolean r10) {
        this.f26380b = r10;
    }

    public final void k(int r10) {
        this.f26381c = r10;
    }

    public final void l(boolean r10, final Function1 r11) {
        q.g(r11, "updateLayout");
        if (r10 == false) goto L6;
        wd.a r12 = wd.a.f25402a;
        r11.invoke(wd.a.i(this.f26379a, null, true));
        this.f26379a.setOnApplyWindowInsetsListener(new b(this, r11));
        return;
    }

    public final void o() {
        if (this.f26382d == false) goto L17;
        Object r10 = this.f26379a.getContext().getSystemService("window");
        if (r10 == null) goto L16;
        WindowManager r11 = (WindowManager) r10;
        ViewGroup.LayoutParams r12 = this.f26379a.getLayoutParams();
        if ((r12 instanceof WindowManager.LayoutParams) == false) goto L9;
        WindowManager.LayoutParams r13 = (WindowManager.LayoutParams) r12;
    L10:
        int r14 = this.f26379a.getMeasuredHeight();
        if (r13 != null) goto L13;
        return;
    L13:
        if (r13.height == r14) goto L19;
        r13.height = r14;
        r11.updateViewLayout(this.f26379a, r13);
        return;
    L19:
        return;
    L9:
        r13 = null;
        goto L10
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }
}
