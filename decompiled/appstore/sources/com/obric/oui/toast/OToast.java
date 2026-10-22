package com.obric.oui.toast;

import android.app.Activity;
import android.content.Context;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.button.OButton;
import com.obric.oui.common.style.OUILayoutHelper;
import com.obric.oui.common.style.Shadow;
import com.obric.oui.popover.SingleChildFrameLayout;
import com.obric.oui.utils.log.L;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.apache.http.message.TokenParser;
import tc.f;
import tc.g;
import tc.h;
import tc.l;

/* JADX INFO: loaded from: classes4.dex */
public final class OToast {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f17557p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f17558q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static WeakReference f17559r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Handler f17560s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ArrayDeque f17561t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static OToast f17562u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f17563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f17565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f17566d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f17567e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f17568f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f17569g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f17570h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Toast f17571i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f17572j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f17573k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f17574l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f17575m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f17576n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public OButton f17577o;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static /* synthetic */ void a(OToast r10) {
            i(r10);
        }

        public static /* synthetic */ void b(OToast r10) {
            f(r10);
        }

        public static final /* synthetic */ void c(a r10, OToast r11) {
            r10.e(r11);
        }

        public static final /* synthetic */ void d(a r10, OToast r11) {
            r10.h(r11);
        }

        public static final void f(OToast r10) {
            q.g(r10, "$toast");
            if (OToast.b() != r10) goto L5;
            return;
        L5:
            if (OToast.d().contains(r10) == true) goto L18;
            int r11 = OToast.d().size();
            if (OToast.b() != null) goto L10;
            int r12 = 0;
        L11:
            int r13 = r11 + r12;
            if (r13 < 50) goto L15;
            L.j(OToast.f17557p.g(), "Package has already queued " + r13 + " toasts. Not showing more.");
            return;
        L15:
            OToast.d().offer(r10);
            OToast.f17557p.j();
            return;
        L10:
            r12 = 1;
            goto L11
        }

        public static final void i(OToast r10) {
            q.g(r10, "$toast");
            if (OToast.b() != r10) goto L5;
            OToast.f(null);
            OToast.f17557p.j();
            return;
        L5:
            OToast.d().remove(r10);
        }

        public final void e(final OToast r10) {
            OToast.e().post(new c(r10));
        }

        public final String g() {
            return OToast.c();
        }

        public final void h(final OToast r10) {
            OToast.e().post(new com.obric.oui.toast.b(r10));
        }

        public final void j() {
            if (OToast.b() == null) goto L5;
            return;
        L5:
            OToast r10 = (OToast) OToast.d().poll();
            if (r10 != null) goto L8;
            return;
        L8:
            OToast.f(r10);
            OToast.g(r10);
        }

        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final a f17578r = null;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final int f17579s = 0;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final int f17580t = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WindowManager.LayoutParams f17581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Boolean f17582b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Handler f17583c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f17584d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f17585e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f17586f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f17587g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f17588h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f17589i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public View f17590j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public View f17591k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Context f17592l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public IBinder f17593m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Integer f17594n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public WindowManager f17595o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f17596p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public Function0 f17597q;

        public static final class a {

            /* JADX INFO: renamed from: com.obric.oui.toast.OToast$b$a$a, reason: collision with other inner class name */
            public static final class HandlerC0209a extends Handler {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final b f17598a;

                public HandlerC0209a(b r10) {
                    q.g(r10, "tn");
                    super(Looper.getMainLooper());
                    this.f17598a = r10;
                }

                @Override // android.os.Handler
                public void handleMessage(Message r10) {
                    q.g(r10, "msg");
                    Log.v(OToast.f17557p.g(), "handleMessage " + r10.what + TokenParser.SP + this.f17598a);
                    b.a(this.f17598a, r10);
                }
            }

            public /* synthetic */ a(DefaultConstructorMarker r10) {
                this();
            }

            public final int a(String r10, String r11) {
                q.g(r10, "type");
                return Class.forName(q.p("com.android.internal.R$", r10)).getField(r11).getInt(null);
            L5:
                e = move-exception;
                e.printStackTrace();
                return 0;
            }

            public a() {
            }
        }

        static {
            f17578r = new a(null);
            f17579s = 1;
            f17580t = 2;
        }

        public b() {
            WindowManager.LayoutParams r10 = new WindowManager.LayoutParams();
            this.f17581a = r10;
            this.f17583c = new a.HandlerC0209a(this);
            this.f17589i = 2000;
            this.f17596p = true;
            r10.height = -2;
            r10.width = -2;
            r10.format = -3;
            r10.windowAnimations = f17578r.a("style", "Animation_Toast");
            r10.type = 2;
            r10.flags = 168;
            r10.setTitle("ObricCustomToast");
        }

        public static final /* synthetic */ void a(b r10, Message r11) {
            r10.e(r11);
        }

        public final int b() {
            return this.f17589i;
        }

        public final Handler c() {
            return this.f17583c;
        }

        public final void d() {
            a r10 = OToast.f17557p;
            Log.v(r10.g(), "handleHide " + this.f17590j + " in " + this);
            if (this.f17590j == null) goto L15;
            String r11 = r10.g();
            View r12 = this.f17590j;
            q.d(r12);
            Log.v(r11, q.p("handleHide parent ", r12.getParent()));
            View r13 = this.f17590j;
            q.d(r13);
            if (r13.getParent() == null) goto L11;
            Log.v(r10.g(), "REMOVE! " + this.f17590j + " in " + this);
            WindowManager r14 = this.f17595o;     // Catch: Exception -> L9
            q.d(r14);     // Catch: Exception -> L9
            r14.removeView(this.f17590j);     // Catch: Exception -> L9
        L9:
            e = move-exception;
            e.printStackTrace();
        L11:
            this.f17590j = null;
            return;
        }

        public final void e(Message r10) {
            int r11 = r10.what;
            if (r11 != f17579s) goto L6;
            f();
            return;
        L6:
            if (r11 != f17580t) goto L13;
            d();
            this.f17591k = null;
            this.f17592l = null;
            this.f17595o = null;
            this.f17593m = null;
            Function0 r12 = this.f17597q;
            this.f17597q = null;
            if (r12 == null) goto L14;
            r12.invoke();
            return;
        L14:
            return;
        }

        public final void f() {
            a r10 = OToast.f17557p;
            Log.v(r10.g(), "HANDLE SHOW: " + this + " mView=" + this.f17590j + " mNextView=" + this.f17591k);
            d();
            Context r11 = this.f17592l;
            if (r11 != null) goto L5;
            Activity r12 = null;
        L6:
            Context r13 = this.f17592l;
            View r14 = this.f17591k;
            q.d(r14);
            View r15 = n(r13, r14, this.f17586f);
            this.f17590j = r15;
            q.d(r15);
            Context r16 = r15.getContext().getApplicationContext();
            View r17 = this.f17590j;
            q.d(r17);
            String r18 = r17.getContext().getPackageName();
            if (r16 != null) goto L9;
            View r19 = this.f17590j;
            q.d(r19);
            r16 = r19.getContext();
        L9:
            q.d(r16);
            Object r20 = r16.getSystemService("window");
            if (r20 == null) goto L40;
            this.f17595o = (WindowManager) r20;
            View r21 = this.f17590j;
            q.d(r21);
            int r22 = Gravity.getAbsoluteGravity(this.f17584d, r21.getContext().getResources().getConfiguration().getLayoutDirection());
            WindowManager.LayoutParams r23 = this.f17581a;
            r23.gravity = r22;
            if ((r22 & 7) != 7) goto L15;
            r23.horizontalWeight = 1.0f;
        L15:
            if ((r22 & 112) != 112) goto L17;
            r23.verticalWeight = 1.0f;
        L17:
            r23.x = this.f17585e;
            r23.y = this.f17586f;
            r23.verticalMargin = this.f17588h;
            r23.horizontalMargin = this.f17587g;
            Integer r24 = this.f17594n;
            if (r24 == null) goto L22;
            this.f17581a.type = r24.intValue();
        L22:
            if (this.f17596p == true) goto L24;
            this.f17581a.flags |= 16;
        L24:
            wd.a.a(r16, this.f17581a, this.f17582b);
            WindowManager.LayoutParams r25 = this.f17581a;
            r25.y = 0;
            r25.width = -1;
            if (r12 == null) goto L27;
            r25.token = r12.getWindow().getAttributes().token;
        L30:
            this.f17581a.packageName = r18;
            View r26 = this.f17590j;
            q.d(r26);
            if (r26.getParent() == null) goto L33;
            Log.v(r10.g(), "REMOVE! " + this.f17590j + " in " + this);
            WindowManager r27 = this.f17595o;
            q.d(r27);
            r27.removeView(this.f17590j);
        L33:
            Log.v(r10.g(), "ADD! " + this.f17590j + " in " + this);
            WindowManager r28 = this.f17595o;     // Catch: Exception -> L36
            q.d(r28);     // Catch: Exception -> L36
            r28.addView(this.f17590j, this.f17581a);     // Catch: Exception -> L36
            return;
        L36:
            e = move-exception;
            e.printStackTrace();
            return;
        L27:
            IBinder r29 = this.f17593m;
            if (r29 == null) goto L30;
            r25.token = r29;
            goto L30
        L40:
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        L5:
            r12 = wd.a.f25402a.b(r11);
            goto L6
        }

        public final void g(Boolean r10) {
            this.f17582b = r10;
        }

        public final void h(Context r10) {
            this.f17592l = r10;
        }

        public final void i(int r10) {
            this.f17584d = r10;
        }

        public final void j(View r10) {
            this.f17591k = r10;
        }

        public final void k(int r10) {
            this.f17586f = r10;
        }

        public final void l(Function0 r10) {
            this.f17597q = r10;
        }

        public final void m() {
            Log.v(OToast.f17557p.g(), q.p("SHOW: ", this));
            Handler r10 = this.f17583c;
            int r11 = f17579s;
            r10.removeMessages(r11);
            Handler r12 = this.f17583c;
            int r13 = f17580t;
            r12.removeMessages(r13);
            this.f17583c.sendEmptyMessage(r11);
            this.f17583c.sendEmptyMessageDelayed(r13, this.f17589i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final View n(Context r11, View r12, int r13) {
            if (r11 != null) goto L4;
            return r12;
        L4:
            td.c r10 = td.c.f24796a;
            AttributeSet r14 = null;
            Object[] r15 = 0;
            if (r12 != null) goto L8;
        L6:
            View r16 = null;
        L10:
            ToastBackgroundView r17 = (ToastBackgroundView) r16;
            if (r17 != null) goto L13;
            int r18 = 24;
        L14:
            View r19 = LayoutInflater.from(r11).inflate(R$layout.o_layout_popover_shadow_frame, null);
            if (r19 == null) goto L37;
            SingleChildFrameLayout r20 = (SingleChildFrameLayout) r19;
            r20.addView(r12, new FrameLayout.LayoutParams(-2, -2));
            r20.setShadowCornerRadius(r18);
            List r110 = OUILayoutHelper.y(r11, "oui_shadow_thick");
            if (r110 != null) goto L19;
            int r21 = 0;
        L34:
            SingleChildFrameLayout r111 = new SingleChildFrameLayout(r11, r14, 2, r15 == true ? 1 : 0);
            r111.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -2));
            FrameLayout.LayoutParams r112 = new FrameLayout.LayoutParams(-2, -2);
            r112.gravity = 1;
            Unit r113 = Unit.f21064a;
            r111.addView(r20, r112);
            r111.setClipChildren(false);
            r111.setClipToPadding(false);
            r111.setPadding(0, r21, 0, r13);
            return r111;
        L19:
            Iterator r114 = r110.iterator();
            r21 = 0;
            int r22 = 0;
            int r23 = 0;
            int r24 = 0;
        L21:
            if (r114.hasNext() == false) goto L34;
            Shadow r25 = (Shadow) r114.next();
            if ((r25.i() - r25.f()) <= r22) goto L26;
            r22 = yf.b.b(r25.i() - r25.f());
        L26:
            if ((r25.i() + r25.f()) <= r23) goto L29;
            r23 = yf.b.b(r25.i() + r25.f());
        L29:
            if ((r25.i() - r25.g()) <= r21) goto L32;
            r21 = yf.b.b(r25.i() - r25.g());
        L32:
            if ((r25.i() + r25.g()) <= r24) goto L21;
            r24 = yf.b.b(r25.i() + r25.g());
            goto L21
        L37:
            throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.popover.SingleChildFrameLayout");
        L13:
            r18 = r17.getCornerRadius();
            goto L14
        L8:
            if ((r12 instanceof ToastBackgroundView) == false) goto L6;
            r16 = r12;
            goto L10
        }
    }

    static {
        f17557p = new a(null);
        f17558q = "OToast";
        f17559r = new WeakReference(null);
        f17560s = new Handler(Looper.getMainLooper());
        f17561t = new ArrayDeque();
    }

    public OToast(Context r11, String r12, int r13, boolean r14) {
        q.g(r11, "mContext");
        q.g(r12, "msg");
        Boolean r10 = null;
        int r15 = 0;
        this(r11, r12, r13, r14, r10, r15, 48, null);
    }

    public static /* synthetic */ void a(OToast r10) {
        n(r10);
    }

    public static final /* synthetic */ OToast b() {
        return f17562u;
    }

    public static final /* synthetic */ String c() {
        return f17558q;
    }

    public static final /* synthetic */ ArrayDeque d() {
        return f17561t;
    }

    public static final /* synthetic */ Handler e() {
        return f17560s;
    }

    public static final /* synthetic */ void f(OToast r10) {
        f17562u = r10;
    }

    public static final /* synthetic */ void g(OToast r10) {
        r10.m();
    }

    public static final void n(OToast r10) {
        q.g(r10, "this$0");
        a.d(f17557p, r10);
    }

    public final OButton h() {
        return this.f17577o;
    }

    public final View i() {
        return this.f17576n;
    }

    public final View j() {
        return this.f17569g;
    }

    public final void k() {
        View r10 = this.f17576n.findViewById(R$id.iv_icon);
        q.f(r10, "contentView.findViewById<ImageView>(R.id.iv_icon)");
        if (l.i(r10) == false) goto L8;
        View r11 = this.f17576n.findViewById(R$id.toast_progress);
        q.f(r11, "contentView.findViewById…iew>(R.id.toast_progress)");
        if (l.i(r11) == false) goto L8;
        int r12 = this.f17574l;
    L9:
        this.f17575m = r12;
        ((TextView) this.f17576n.findViewById(R$id.tv_msg)).setMaxWidth(this.f17575m);
        return;
    L8:
        r12 = this.f17574l - this.f17573k;
        goto L9
    }

    public final void l() {
        a.c(f17557p, this);
    }

    public final void m() {
    L13:
        e = move-exception;
        h.a(q.p("Try DeadObjectException occur, ", e.getMessage()));
    L46:
        h.a(q.p(f17558q, ", showAsDropDown exception occur, try showAtLocation"));
        a.d(f17557p, this);
        return;
    L15:
        e = move-exception;
        h.a(q.p("Try runtimeException occur, ", e.getMessage()));
        goto L46
    L4:
        if (this.f17568f == 0) goto L7;
    L21:
        Log.d(f17558q, "show toast by ocean");     // Catch: DeadObjectException -> L13 RuntimeException -> L15
        int r10 = this.f17565c;     // Catch: DeadObjectException -> L13 RuntimeException -> L15
        if (r10 != 17) goto L24;
    L27:
        int r11 = 0;
    L31:
        if (j() == null) goto L33;
        ((LinearLayout) i().findViewById(R$id.toast_root)).addView(j());     // Catch: DeadObjectException -> L13 RuntimeException -> L15
    L33:
        ((TextView) i().findViewById(R$id.tv_msg)).setMaxWidth(this.f17575m);     // Catch: DeadObjectException -> L13 RuntimeException -> L15
        i().measure(0, 0);     // Catch: DeadObjectException -> L13 RuntimeException -> L15
        td.c r12 = td.c.f24796a;     // Catch: DeadObjectException -> L13 RuntimeException -> L15
        View r13 = i();     // Catch: DeadObjectException -> L13 RuntimeException -> L15
        if (r13 != null) goto L37;
    L35:
        r13 = null;
    L38:
        ToastBackgroundView r14 = (ToastBackgroundView) r13;     // Catch: DeadObjectException -> L13 RuntimeException -> L15
        if (r14 == null) goto L42;
        ToastBackgroundView.d(r14, i().getMeasuredHeight(), 0, null, 6, null);     // Catch: DeadObjectException -> L13 RuntimeException -> L15
    L42:
        b r15 = this.f17570h;     // Catch: DeadObjectException -> L13 RuntimeException -> L15
        r15.j(i());     // Catch: DeadObjectException -> L13 RuntimeException -> L15
        r15.h(this.f17563a);     // Catch: DeadObjectException -> L13 RuntimeException -> L15
        r15.i(this.f17565c);     // Catch: DeadObjectException -> L13 RuntimeException -> L15
        r15.k(r11);     // Catch: DeadObjectException -> L13 RuntimeException -> L15
        r15.g(this.f17567e);     // Catch: DeadObjectException -> L13 RuntimeException -> L15
        r15.l(new OToast$showNow$1$3(this));     // Catch: DeadObjectException -> L13 RuntimeException -> L15
        r15.m();     // Catch: DeadObjectException -> L13 RuntimeException -> L15
    L43:
        Unit r16 = Unit.f21064a;     // Catch: DeadObjectException -> L13 RuntimeException -> L15
    L51:
        return;
    L37:
        if ((r13 instanceof ToastBackgroundView) == false) goto L35;
    L24:
        if (r10 != 48) goto L26;
        r11 = f.b(this.f17563a, 20);     // Catch: DeadObjectException -> L13 RuntimeException -> L15
        goto L31
    L26:
        if (r10 != 80) goto L27;
        r11 = f.b(this.f17563a, 96);     // Catch: DeadObjectException -> L13 RuntimeException -> L15
        goto L31
    L7:
        if (this.f17566d == true) goto L21;
        if (l.i(h()) == false) goto L11;
    L17:
        Log.d(f17558q, "show toast by system");     // Catch: DeadObjectException -> L13 RuntimeException -> L15
        Context r17 = this.f17563a.getApplicationContext();     // Catch: DeadObjectException -> L13 RuntimeException -> L15
        if (r17 != null) goto L20;
        r17 = this.f17563a;     // Catch: DeadObjectException -> L13 RuntimeException -> L15
    L20:
        Toast r18 = Toast.makeText(r17, this.f17564b, 0);     // Catch: DeadObjectException -> L13 RuntimeException -> L15
        this.f17571i = r18;     // Catch: DeadObjectException -> L13 RuntimeException -> L15
        r18.show();     // Catch: DeadObjectException -> L13 RuntimeException -> L15
        this.f17570h.c().postDelayed(new com.obric.oui.toast.a(this), this.f17570h.b());     // Catch: DeadObjectException -> L13 RuntimeException -> L15
        goto L43
    L11:
        if (h().isClickable() == true) goto L21;
        goto L21
    }

    public OToast(Context r10, String r11, int r12, boolean r13, Boolean r14, int r15) {
        q.g(r10, "mContext");
        q.g(r11, "msg");
        this.f17563a = r10;
        this.f17564b = r11;
        this.f17565c = r12;
        this.f17566d = r13;
        this.f17567e = r14;
        this.f17568f = r15;
        b r16 = new b();
        this.f17570h = r16;
        int r17 = f.b(r10, 73);
        this.f17572j = r17;
        this.f17573k = f.b(r10, 28);
        if (g.f24781a.a(r10) == true) goto L5;
        int r18 = f.n(r10) - r17;
    L6:
        this.f17574l = r18;
        this.f17575m = r18;
        LayoutInflater r19 = LayoutInflater.from(r10);
        int r20 = this.f17568f;
        if (r20 != 0) goto L9;
        int r21 = R$layout.o_toast;
    L13:
        View r22 = r19.inflate(r21, null);
        q.f(r22, "from(mContext)\n        .…   }\n            }, null)");
        this.f17576n = r22;
        if (this.f17565c == 80) goto L16;
        this.f17565c = 80;
        L.j(f17558q, "custom position is not supported! position " + this.f17565c + '!');
    L16:
        r16.k(96);
        r16.i(this.f17565c);
        ((TextView) this.f17576n.findViewById(R$id.tv_msg)).setText(r11);
        View r23 = this.f17576n.findViewById(R$id.right_button);
        q.f(r23, "contentView.findViewById(R.id.right_button)");
        this.f17577o = (OButton) r23;
        k();
        return;
    L9:
        if (r20 == 2) goto L11;
        r21 = R$layout.o_toast_light;
        goto L13
    L11:
        r21 = R$layout.o_toast_dark;
        goto L13
    L5:
        r18 = f.b(r10, 288);
        goto L6
    }

    public /* synthetic */ OToast(Context r10, String r11, int r12, boolean r13, Boolean r14, int r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 4) == 0) goto L5;
        r12 = 80;
    L5:
        int r18 = r12;
        if ((r16 & 8) == 0) goto L8;
        boolean r19 = false;
    L10:
        if ((r16 & 16) == 0) goto L12;
        r14 = null;
    L12:
        Boolean r20 = r14;
        if ((r16 & 32) == 0) goto L15;
        int r21 = 0;
    L16:
        this(r10, r11, r18, r19, r20, r21);
        return;
    L15:
        r21 = r15;
        goto L16
    L8:
        r19 = r13;
        goto L10
    }
}
