package com.obric.oui.toast;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.style.f;
import com.obric.oui.common.style.j;
import com.obric.oui.common.util.g;
import com.obric.oui.d.c;
import com.obric.oui.popover.SingleChildFrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.x;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: OToastModal.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1002a f36785a = null;
    private static final Handler o = null;
    private static final ArrayDeque<b> p = null;
    private static a q;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f36786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f36787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f36788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f36789e;
    private View f;
    private ViewGroup g;
    private View.OnAttachStateChangeListener h;
    private boolean i;
    private boolean j;
    private final Handler k;
    private final Runnable l;
    private final Runnable m;
    private View n;

    /* JADX INFO: renamed from: com.obric.oui.toast.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OToastModal.kt */
    public static final class C1002a {

        /* JADX INFO: renamed from: com.obric.oui.toast.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OToastModal.kt */
        static final class C1003a extends p implements d.h.a.b<b, Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f36790a;

            C1003a(a r1) {
                this.f36790a = r1;
                super(1);
            }

            public final Boolean a(b r1) {
                if (r1.a() != this.f36790a) goto L5;
                boolean r0 = true;
            L7:
                return Boolean.valueOf(r0);
            L5:
                r0 = false;
                goto L7
            }

            @Override // d.h.a.b
            public /* synthetic */ Boolean invoke(b r3) {
                return a((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin"));
            }
        }

        public /* synthetic */ C1002a(h r1) {
            this();
        }

        /* JADX INFO: renamed from: lambda$4BMlum8q-nTzswPRcjNLiNgqXgA, reason: not valid java name */
        public static /* synthetic */ void m1241lambda$4BMlum8qnTzswPRcjNLiNgqXgA(a r0) {
            b(r0);
        }

        private C1002a() {
        }

        public static final /* synthetic */ void a(C1002a r0, a r1) {
            r0.a(r1);
        }

        private final void a(final a r2) {
            a.b().post(new $$Lambda$a$a$4BMlum8qnTzswPRcjNLiNgqXgA(r2));
        }

        private static final void b(a r3) {
            o.e(r3, "$toast");
            if (a.c() != r3) goto L5;
            C1002a r4 = a.f36785a;
            a.b(null);
            a.f36785a.a();
            return;
        L5:
            d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(a.d(), Iterable.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.preCheckCast(new C1003a(r3), d.h.a.b.class, "com.obric.aiagent.plugin"));
        }

        private final void a() {
            if (a.c() == null) goto L5;
            return;
        L5:
            b r2 = (b) ZeusTransformUtils.preCheckCast(a.d().poll(), b.class, "com.obric.aiagent.plugin");
            if (r2 != null) goto L8;
            return;
        L8:
            a.b(r2.a());
            a.a(r2.a(), r2);
        }
    }

    /* JADX INFO: compiled from: OToastModal.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f36791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d.h.a.a<ViewGroup> f36792b;

        public final a a() {
            return this.f36791a;
        }

        public final d.h.a.a<ViewGroup> b() {
            return this.f36792b;
        }
    }

    public static final /* synthetic */ void a(a r0) {
        r0.f();
    }

    public static final /* synthetic */ void a(a r0, b r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ Handler b() {
        return o;
    }

    public static final /* synthetic */ void b(a r0) {
        q = r0;
    }

    public static final /* synthetic */ a c() {
        return q;
    }

    public static final /* synthetic */ ArrayDeque d() {
        return p;
    }

    public final View a() {
        return this.n;
    }

    private final void a(b r9) {
        ViewGroup r10 = (ViewGroup) ZeusTransformUtils.preCheckCast(r9.b().invoke(), ViewGroup.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L5;
    L39:
        h();
        return;
    L5:
        if (r10.isAttachedToWindow() == false) goto L39;
        int r0 = g.a(this.f36786b, 96);
        View r2 = this.f36787c;
        View r4 = null;
        if (r2 == null) goto L20;
        ViewParent r5 = r2.getParent();
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.class) == false) goto L13;
        ViewGroup r6 = (ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.aiagent.plugin");
    L14:
        if (r6 == null) goto L17;
        r6.removeView(r2);
    L17:
        LinearLayout r7 = (LinearLayout) ZeusTransformUtils.preCheckCast(a().findViewById(ZeusTransformUtils.mapRes(R.id.toast_root, DbHelper.COL_ID, "toast_root")), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r2.getParent() == r7) goto L20;
        r7.addView(r2);
        goto L20
    L13:
        r6 = null;
    L20:
        e();
        a(r10);
        ((TextView) ZeusTransformUtils.preCheckCast(this.n.findViewById(ZeusTransformUtils.mapRes(R.id.tv_msg, DbHelper.COL_ID, "tv_msg")), TextView.class, "com.obric.aiagent.plugin")).setMaxWidth(this.f36788d);
        this.n.measure(0, 0);
        View r1 = a(this.n, r0);
        this.f = r1;
        this.i = false;
        this.j = false;
        ViewParent r3 = r1.getParent();
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.class) == false) goto L23;
        ViewGroup r8 = (ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.aiagent.plugin");
    L24:
        if (r8 == null) goto L27;
        r8.removeView(r1);
    L27:
        c r11 = c.f35012a;
        View r12 = this.n;
        if (r12 != null) goto L31;
    L33:
        ToastBackgroundView r13 = (ToastBackgroundView) ZeusTransformUtils.preCheckCast(r4, ToastBackgroundView.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L37;
        r13.setupBackground(this.n.getMeasuredHeight(), 5, this.n);
    L37:
        FrameLayout.LayoutParams r14 = new FrameLayout.LayoutParams(-2, -2);
        r14.gravity = 81;
        x r15 = x.f38692a;
        r10.addView(r1, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r14, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r1.bringToFront();
        r1.setAlpha(0.0f);
        r1.setTranslationY(g.a(r1, 8));
        r1.animate().alpha(1.0f).translationY(0.0f).setDuration(160).start();
        this.k.removeCallbacks(this.l);
        this.k.postDelayed(this.l, this.f36789e);
        return;
    L31:
        if (ZeusTransformUtils.instanceOf(r12, ToastBackgroundView.class) == false) goto L33;
        r4 = r12;
        goto L33
    L23:
        r8 = null;
        goto L24
    }

    private final void e() {
        this.k.removeCallbacks(this.l);
        this.k.removeCallbacks(this.m);
        g();
        View r0 = this.f;
        if (r0 == null) goto L12;
        r0.animate().cancel();
        ViewParent r2 = r0.getParent();
        if (ZeusTransformUtils.instanceOf(r2, ViewGroup.class) == false) goto L8;
        ViewGroup r3 = (ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.aiagent.plugin");
    L9:
        if (r3 == null) goto L12;
        r3.removeView(r0);
        goto L12
    L8:
        r3 = null;
    L12:
        this.f = null;
        this.i = false;
    }

    private final void f() {
        if (this.j == false) goto L5;
        return;
    L5:
        this.j = true;
        e();
        h();
    }

    private final void a(ViewGroup r4) {
        g();
        this.g = r4;
        View.OnAttachStateChangeListener r0 = new OToastModal$registerHostParent$1(this);
        r4.addOnAttachStateChangeListener((View.OnAttachStateChangeListener) ZeusTransformUtils.preCheckCast(r0, View.OnAttachStateChangeListener.class, "com.obric.aiagent.plugin"));
        this.h = (View.OnAttachStateChangeListener) ZeusTransformUtils.preCheckCast(r0, View.OnAttachStateChangeListener.class, "com.obric.aiagent.plugin");
    }

    private final void g() {
        View.OnAttachStateChangeListener r0 = this.h;
        if (r0 == null) goto L9;
        ViewGroup r1 = this.g;
        if (r1 == null) goto L9;
        r1.removeOnAttachStateChangeListener(r0);
    L9:
        this.h = null;
        this.g = null;
    }

    private final View a(View r13, int r14) {
        c r0 = c.f35012a;
        if (r13 != null) goto L6;
    L4:
        View r1 = null;
    L8:
        ToastBackgroundView r2 = (ToastBackgroundView) ZeusTransformUtils.preCheckCast(r1, ToastBackgroundView.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L11;
        int r3 = 24;
    L12:
        View r4 = ZeusTransformUtils.inflate(LayoutInflater.from(this.f36786b), ZeusTransformUtils.mapRes(R.layout.o_layout_popover_shadow_frame, "layout", "o_layout_popover_shadow_frame"), null, "com.obric.aiagent.plugin");
        Objects.requireNonNull(r4, "null cannot be cast to non-null type com.obric.oui.popover.SingleChildFrameLayout");
        SingleChildFrameLayout r5 = (SingleChildFrameLayout) ZeusTransformUtils.preCheckCast(r4, SingleChildFrameLayout.class, "com.obric.aiagent.plugin");
        r5.addView(r13, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r5.setShadowCornerRadius(r3);
        List<j> r15 = f.a(this.f36786b, ZeusTransformUtils.mapRes(R.style.OUIShadow_3, "style", "OUIShadow_3"));
        o.c(r15, "shadows");
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r6 = 0;
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
    L14:
        if (r16.hasNext() == false) goto L27;
        j r10 = (j) ZeusTransformUtils.preCheckCast(r16.next(), j.class, "com.obric.aiagent.plugin");
        if ((r10.b() - r10.c()) <= r6) goto L19;
        r6 = d.i.a.a(r10.b() - r10.c());
    L19:
        if ((r10.b() + r10.c()) <= r8) goto L22;
        r8 = d.i.a.a(r10.b() + r10.c());
    L22:
        if ((r10.b() - r10.d()) <= r7) goto L25;
        r7 = d.i.a.a(r10.b() - r10.d());
    L25:
        if ((r10.b() + r10.d()) <= r9) goto L14;
        r9 = d.i.a.a(r10.b() + r10.d());
        goto L14
    L27:
        SingleChildFrameLayout r17 = new SingleChildFrameLayout(this.f36786b, null, 2, null);
        r17.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ViewGroup.MarginLayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        View r12 = (View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin");
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(-2, -2);
        r11.gravity = 1;
        x r18 = x.f38692a;
        r17.addView(r12, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r11, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r17.setClipChildren(false);
        r17.setClipToPadding(false);
        r17.setPadding(r6, r7, r8, r14 + r9);
        return (View) ZeusTransformUtils.preCheckCast(r17, View.class, "com.obric.aiagent.plugin");
    L11:
        r3 = r2.getCornerRadius();
        goto L12
    L6:
        if (ZeusTransformUtils.instanceOf(r13, ToastBackgroundView.class) == false) goto L4;
        r1 = r13;
        goto L8
    }

    static {
        f36785a = new C1002a(null);
        o = new Handler(Looper.getMainLooper());
        p = new ArrayDeque();
    }

    private final void h() {
        C1002a.a(f36785a, this);
    }
}
