package com.bytedance.android.gamecp.common.track.monitor;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.common.utils.y0;
import com.larus.nova.R;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements xr.c, Handler.Callback {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f56810y = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f56811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<View> f56812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function2<? super Boolean, ? super Float, Unit> f56813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f56814d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f56815e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f56816f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f56817g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f56818h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f56819i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f56820j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Handler f56821k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f56822l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final g f56823m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final d f56824n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final e f56825o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c f56826p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final f f56827q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f56828r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f56829s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f56830t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final float f56831u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f56832v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Rect f56833w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Rect f56834x;

    /* JADX INFO: renamed from: com.bytedance.android.gamecp.common.track.monitor.a$a, reason: collision with other inner class name */
    public static final class C0914a {
        public static boolean b(View r100) {
            if (r100 == null) goto L17;
            Object r101 = r100.getTag(R.id.gamecp_view_map_tag_key);
            Object r102 = null;
            if ((r101 instanceof HashMap) == true) goto L6;
            r101 = null;
        L6:
            HashMap r103 = (HashMap) r101;
            if (r103 == null) goto L9;
            Object r104 = r103.get("detach");
        L11:
            if ((r104 instanceof Boolean) == false) goto L14;
            r102 = r104;
        L14:
            Boolean r105 = (Boolean) r102;
            if (r105 == null) goto L17;
            return r105.booleanValue();
        L9:
            r104 = null;
        L17:
            return false;
        }

        public static void a(final View r100, final boolean r101) {
            final String r102 = "detach";
            Intrinsics.checkNotNullParameter("detach", "tagKey");
            UtilityKotlinExtentionsKt.g(0, false, false, new GPViewAppearObserver$Companion$setViewDataTag$1(r100, r101, r102), 7);
        }
    }

    static {
    }

    public a() {
        this(0, false, 0.0f, false, null, 63);
    }

    public final void b() {
        this.f56821k.removeMessages(1020304050);
        this.f56821k.removeMessages(1020304051);
    }

    public final void d() {
        boolean r100 = this.f56814d;
        if (r100 == true) goto L5;
    L7:
        if (r100 == true) goto L9;
        return;
    L9:
        if (this.f56832v == true) goto L11;
        return;
    L11:
        if (f().getFirst().booleanValue() == true) goto L17;
        g(false);
        this.f56814d = false;
        this.f56819i = false;
        return;
    L17:
        return;
    L5:
        if (this.f56832v == true) goto L7;
        g(false);
        this.f56814d = false;
        this.f56819i = false;
    }

    public final Pair<Boolean, Float> f() {
        WeakReference<View> r100 = this.f56812b;
        if (r100 == null) goto L5;
        View r101 = r100.get();
    L7:
        if (r101 == null) goto L81;
        if (r101.getVisibility() == 4) goto L81;
        if (r101.getVisibility() == 8) goto L81;
        if (r101.isAttachedToWindow() == false) goto L81;
        if (r101.hasWindowFocus() == false) goto L81;
        Rect r102 = new Rect();
        if (r101.getGlobalVisibleRect(r102) == false) goto L79;
        View r103 = r101;
    L20:
        int r104 = 0;
        if (r103.getVisibility() != 0) goto L32;
        if (r103.getAlpha() <= 0) goto L32;
        Object r105 = r103.getParent();
        if (r105 == null) goto L32;
        if ((r105 instanceof View) == false) goto L30;
        r103 = (View) r105;
        goto L20
    L30:
        boolean r106 = true;
    L33:
        if (r106 == false) goto L79;
        Rect r107 = this.f56833w;
        if (r107 == null) goto L47;
        int r108 = r107.left;
        int r109 = r107.top;
        int r110 = r107.right;
        int r111 = r107.bottom;
        int r112 = r102.left;
        int r113 = r102.top;
        int r114 = r102.right;
        int r115 = r102.bottom;
        if (r113 >= r111) goto L45;
        if (r109 >= r115) goto L45;
        if (r112 >= r110) goto L44;
        if (r108 >= r114) goto L44;
        Rect r116 = new Rect(Math.max(r108, r112), Math.max(r107.top, r102.top), Math.min(r107.right, r102.right), Math.min(r107.bottom, r102.bottom));
    L46:
        int r117 = r116.right - r116.left;
        int r118 = r116.bottom - r116.top;
    L48:
        Rect r119 = this.f56834x;
        if (r119 == null) goto L57;
        int r120 = Math.min(r119.right, r102.right) - Math.max(this.f56834x.left, r102.left);
        if (r120 > 0) goto L54;
        r120 = 0;
    L54:
        int r121 = Math.min(this.f56834x.bottom, r102.bottom) - Math.max(this.f56834x.top, r102.top);
        if (r121 <= 0) goto L58;
        r104 = r121;
    L58:
        int r122 = r101.getHeight();
        int r123 = r101.getWidth();
        if (r122 <= 0) goto L63;
        if (r123 <= 0) goto L63;
        float r124 = (((r104 * r120) * 1.0f) - ((r117 * r118) * 1.0f)) / (r123 * r122);
    L65:
        if (r124 < 1.0f) goto L73;
        if (r122 >= y0.f()) goto L73;
        int[] r125 = new int[2];
        r101.getLocationOnScreen(r125);
        if (r125[1] != 0) goto L73;
        return TuplesKt.to(Boolean.FALSE, Float.valueOf(0.0f));
    L73:
        if (r124 < this.f56831u) goto L77;
        return TuplesKt.to(Boolean.TRUE, Float.valueOf(r124));
    L77:
        return TuplesKt.to(Boolean.FALSE, Float.valueOf(0.0f));
    L63:
        r124 = 0.0f;
        goto L65
    L57:
        r104 = r102.bottom - r102.top;
        r120 = r102.right - r102.left;
    L44:
        r116 = new Rect();
    L45:
        r116 = new Rect();
        goto L46
    L47:
        r117 = 0;
        r118 = 0;
    L32:
        r106 = false;
    L79:
        return TuplesKt.to(Boolean.FALSE, Float.valueOf(0.0f));
    L81:
        return TuplesKt.to(Boolean.FALSE, Float.valueOf(0.0f));
    L5:
        r101 = null;
        goto L7
    }

    public final void h() {
        WeakReference<View> r100 = this.f56812b;
        if (r100 == null) goto L5;
        View r101 = r100.get();
    L6:
        if (r101 == null) goto L26;
        ViewTreeObserver r102 = r101.getViewTreeObserver();
        if (r102 != null) goto L10;
        return;
    L10:
        if (r102.isAlive() != true) goto L28;
        ViewTreeObserver r103 = r101.getViewTreeObserver();     // Catch: Exception -> L15
        if (r103 == null) goto L20;
        r103.removeOnDrawListener(this.f56824n);     // Catch: Exception -> L15
    L20:
        ViewTreeObserver r104 = r101.getViewTreeObserver();
        if (r104 == null) goto L29;
        r104.removeOnScrollChangedListener(this.f56823m);
        return;
    L29:
        return;
    L15:
        e = move-exception;
        String r105 = this.f56811a;
        String r106 = e.getMessage();
        if (r106 != null) goto L19;
        r106 = "removeOnDrawListener error";
    L19:
        yr.c.b(r105, r106);
        goto L20
    L28:
        return;
    L26:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // xr.c
    public final boolean viewIsWillDetached() {
        WeakReference<View> r100 = this.f56812b;
        if (r100 == null) goto L5;
        View r101 = r100.get();
    L7:
        return C0914a.b(r101);
    L5:
        r101 = null;
        goto L7
    }

    public final void a() {
        h();
        WeakReference<View> r100 = this.f56812b;
        if (r100 == null) goto L5;
        View r101 = r100.get();
    L6:
        if (r101 == null) goto L28;
        ViewTreeObserver r102 = r101.getViewTreeObserver();
        if (r102 != null) goto L10;
        return;
    L10:
        if (r102.isAlive() != true) goto L30;
        ViewTreeObserver r103 = r101.getViewTreeObserver();     // Catch: Exception -> L15
        if (r103 == null) goto L21;
        r103.addOnDrawListener(this.f56824n);     // Catch: Exception -> L15
    L21:
        if (this.f56830t == false) goto L31;
        ViewTreeObserver r104 = r101.getViewTreeObserver();
        if (r104 == null) goto L32;
        r104.addOnScrollChangedListener(this.f56823m);
        return;
    L32:
        return;
    L31:
        return;
    L15:
        e = move-exception;
        String r105 = this.f56811a;
        String r106 = e.getMessage();
        if (r106 != null) goto L19;
        r106 = "addOnDrawListener";
    L19:
        yr.c.b(r105, r106);
        goto L21
    L30:
        return;
    L28:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void c() {
        long r100 = System.currentTimeMillis();
        if ((r100 - this.f56816f) >= this.f56829s) goto L6;
        this.f56821k.removeMessages(1020304050);
        this.f56821k.sendEmptyMessageDelayed(1020304050, 100);
        return;
    L6:
        this.f56816f = r100;
        this.f56821k.removeMessages(1020304050);
        e();
    }

    @Override // xr.c
    public final void detachViewAppearObserver() {
        i();
        WeakReference<View> r100 = this.f56812b;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        this.f56812b = null;
        this.f56813c = null;
        this.f56814d = false;
        this.f56816f = 0;
        this.f56817g = 0;
        this.f56818h = false;
        this.f56815e = true;
        this.f56819i = false;
        this.f56820j = false;
        b();
    }

    public final void e() {
        Pair<Boolean, Float> r100 = f();
        if (this.f56814d == r100.getFirst().booleanValue()) goto L6;
        boolean r101 = r100.getFirst().booleanValue();
        r100.getSecond().floatValue();
        g(r101);
        this.f56814d = r100.getFirst().booleanValue();
        return;
    }

    public final void i() {
        h();
        WeakReference<View> r100 = this.f56812b;
        if (r100 == null) goto L5;
        View r101 = r100.get();
    L6:
        if (r101 == null) goto L14;
        ViewTreeObserver r102 = r101.getViewTreeObserver();
        if (r102 == null) goto L14;
        if (r102.isAlive() != true) goto L14;
        ViewTreeObserver r103 = r101.getViewTreeObserver();
        if (r103 == null) goto L14;
        r103.removeOnWindowFocusChangeListener(this.f56825o);
    L14:
        if (r101 == null) goto L16;
        r101.removeOnAttachStateChangeListener(this.f56826p);
    L16:
        if (r101 == null) goto L19;
        r101.removeOnLayoutChangeListener(this.f56827q);
        return;
    L19:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void g(boolean r100) {
        WeakReference<View> r101 = this.f56812b;
        View r102 = null;
        if (r101 == null) goto L5;
        View r103 = r101.get();
    L6:
        HashMap<String, String> r104 = GamecpTracker.f56755a;
        if (r103 == null) goto L13;
        View r105 = r103.getRootView();
        if (r105 == null) goto L13;
        Object r106 = r105.getTag(R.id.gamecp_view_tag_cache_key);
        if (r106 == null) goto L13;
        boolean r107 = r106.equals("1");
    L14:
        if (r107 == false) goto L39;
        b r108 = this.f56822l;
        Intrinsics.checkNotNullParameter(r108, "delayTask");
        if (r103 == null) goto L29;
        View r109 = r103.getRootView();
        if (r109 == null) goto L29;
        Object r110 = r109.getTag(R.id.gamecp_view_tag_delay_task);
        if (r110 == null) goto L29;
        if (TypeIntrinsics.isMutableSet(r110) == true) goto L24;
        r110 = null;
    L24:
        Set r111 = (Set) r110;
        if (r111 == null) goto L27;
        Boolean r112 = Boolean.valueOf(r111.add(r108));
    L28:
        if (r112 == null) goto L29;
    L34:
        this.f56814d = false;
        String r113 = this.f56811a;
        StringBuilder r114 = new StringBuilder("add delayTask ");
        r114.append(this.f56814d);
        r114.append(", ");
        WeakReference<View> r115 = this.f56812b;
        if (r115 == null) goto L37;
        r102 = r115.get();
    L37:
        r114.append(r102);
        yr.c.e(r113, r114.toString());
        return;
    L27:
        r112 = null;
    L29:
        LinkedHashSet r116 = new LinkedHashSet();
        r116.add(r108);
        if (r103 == null) goto L34;
        View r117 = r103.getRootView();
        if (r117 == null) goto L34;
        r117.setTag(R.id.gamecp_view_tag_delay_task, r116);
        Unit r118 = Unit.INSTANCE;
        goto L34
    L39:
        long r119 = 0;
        if (r100 == false) goto L43;
        this.f56828r = System.currentTimeMillis();
    L46:
        Function2<? super Boolean, ? super Float, Unit> r120 = this.f56813c;
        if (r120 == null) goto L50;
        Unit r121 = r120.invoke(Boolean.valueOf(r100), Float.valueOf(r119 / 1000.0f));
        return;
    L50:
        return;
    L43:
        if (this.f56828r > 0) goto L45;
        return;
    L45:
        r119 = System.currentTimeMillis() - this.f56828r;
    L13:
        r107 = false;
        goto L14
    L5:
        r103 = null;
        goto L6
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        int r101 = r100.what;
        if (r101 != 1020304050) goto L6;
        e();
        return true;
    L6:
        if (r101 != 1020304051) goto L11;
        d();
        return true;
    L11:
        return true;
    }

    @Override // xr.c
    public final void attachViewAppearObserver(View r100, Function2<? super Boolean, ? super Float, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "observer");
        if (this.f56818h == true) goto L28;
        if (r100 == null) goto L30;
        this.f56812b = new WeakReference(r100);
        this.f56813c = r101;
        this.f56818h = true;
        this.f56819i = r100.isShown();
        Pair<Boolean, Float> r102 = f();
        boolean r103 = r102.getFirst().booleanValue();
        this.f56814d = r103;
        if (r103 == true) goto L9;
    L11:
        i();
        a();
        WeakReference<View> r104 = this.f56812b;
        if (r104 == null) goto L14;
        View r105 = r104.get();
    L15:
        if (r105 == null) goto L23;
        ViewTreeObserver r106 = r105.getViewTreeObserver();
        if (r106 == null) goto L23;
        if (r106.isAlive() != true) goto L23;
        ViewTreeObserver r107 = r105.getViewTreeObserver();
        if (r107 == null) goto L23;
        r107.addOnWindowFocusChangeListener(this.f56825o);
    L23:
        if (r105 == null) goto L25;
        r105.addOnAttachStateChangeListener(this.f56826p);
    L25:
        if (r105 == null) goto L29;
        r105.addOnLayoutChangeListener(this.f56827q);
        return;
    L29:
        return;
    L14:
        r105 = null;
        goto L15
    L9:
        if (this.f56820j == true) goto L11;
        r102.getSecond().floatValue();
        g(true);
        this.f56820j = true;
        goto L11
    L30:
        return;
    }

    public a(long r100, boolean r101, float r102, boolean r103, Rect r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r100 = 200;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r101 = true;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r102 = 0.5f;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r103 = false;
    L15:
        if ((r105 & 32) == 0) goto L17;
        r104 = null;
    L17:
        this.f56829s = r100;
        this.f56830t = r101;
        this.f56831u = r102;
        this.f56832v = r103;
        this.f56833w = null;
        this.f56834x = r104;
        this.f56811a = "GPViewAppearObserver";
        this.f56815e = true;
        this.f56821k = new Handler(Looper.getMainLooper(), this);
        this.f56822l = new b(this);
        this.f56823m = new g(this);
        this.f56824n = new d(this);
        this.f56825o = new e(this);
        this.f56826p = new c(this);
        this.f56827q = new f(this);
    }
}
