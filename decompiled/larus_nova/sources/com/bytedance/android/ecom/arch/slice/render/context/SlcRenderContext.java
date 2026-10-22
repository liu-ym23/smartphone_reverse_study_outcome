package com.bytedance.android.ecom.arch.slice.render.context;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.widget.Toast;
import com.bytedance.android.ecom.arch.slice.action.q;
import com.bytedance.android.ecom.arch.slice.expr.SlcExprContext;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.cache.TemplateViewPool;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.event.SlcEventHelper;
import com.bytedance.android.ecom.arch.slice.render.j;
import com.bytedance.android.ecom.arch.slice.render.o;
import com.bytedance.android.ecom.arch.slice.render.p;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.util.keyboard.SlcKeyboardMonitor;
import com.bytedance.android.ecom.arch.slice.render.widget.SlcRootView;
import com.bytedance.android.ecom.arch.slice.render.widget.background.SlcBackgroundDrawable;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.facebook.yoga.YogaNode;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public class SlcRenderContext {

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f50160n0 = null;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public String E;
    public Map<String, ? extends Object> F;
    public boolean G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f50161J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public com.bytedance.android.ecom.arch.slice.render.elements.text.f P;
    public int Q;
    public int R;
    public boolean S;
    public Map<String, ? extends Object> T;
    public volatile boolean U;
    public e V;
    public SlcKeyboardMonitor W;
    public final HashMap<Long, ar.a> X;
    public final ArrayList<q> Y;
    public final Lazy Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TemplateViewPool f50162a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public com.bytedance.android.ecom.arch.slice.render.g f50163a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SlcTemplateContext f50164b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public com.bytedance.android.ecom.arch.slice.render.context.c f50165b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BaseSlcViewManager f50166c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public com.bytedance.android.ecom.arch.slice.render.e f50167c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f50168d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final Lazy f50169d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f50170e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final Lazy f50171e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.ecom.arch.slice.render.context.b f50172f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final Lazy f50173f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f50174g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final Lazy f50175g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, ? extends Object> f50176h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final Lazy f50177h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f50178i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final Lazy f50179i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f50180j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public final Lazy f50181j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f50182k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final Context f50183k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f50184l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public final String f50185l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ConcurrentHashMap<Object, Object> f50186m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public final SlcExprContext f50187m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList<com.bytedance.android.ecom.arch.slice.render.context.a> f50188n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a f50189o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f50190p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final HashMap<String, com.bytedance.android.ecom.arch.slice.render.exposure.a> f50191q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final HashMap<String, Object> f50192r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final HashMap<String, List<String>> f50193s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public BaseSlcViewManager<?> f50194t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f50195u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f50196v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f50197w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f50198x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f50199y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f50200z;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.ecom.arch.slice.render.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public r f50201a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public WeakReference<r> f50202b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public WeakReference<com.bytedance.android.ecom.arch.slice.render.d> f50203c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final WeakReference<SlcRenderContext> f50204d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final sq.c f50205e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final com.bytedance.android.ecom.arch.slice.render.i f50206f;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v10 */
        /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r13v3, types: [boolean] */
        /* JADX WARN: Type inference failed for: r13v4 */
        /* JADX WARN: Type inference failed for: r13v5 */
        /* JADX WARN: Type inference failed for: r13v6 */
        /* JADX WARN: Type inference failed for: r13v7 */
        /* JADX WARN: Type inference failed for: r13v8 */
        /* JADX WARN: Type inference failed for: r13v9 */
        @Override // com.bytedance.android.ecom.arch.slice.render.f
        public final void a(o r210) {
            SlcRenderContext r100 = this.f50204d.get();
            WeakReference<com.bytedance.android.ecom.arch.slice.render.d> r101 = this.f50203c;
            if (r101 == null) goto L5;
            com.bytedance.android.ecom.arch.slice.render.d r102 = r101.get();
        L6:
            r r103 = r210.f50682a;
            SlcElement r104 = r210.f50683b;
            boolean r105 = r210.f50684c;
            long r110 = r210.f50685d;
            String r111 = r210.f50688g;
            String r112 = r210.f50689h;
            String r113 = r210.f50690i;
            j r106 = new j(r103, r104, r111, 384);
            if (r103 == null) goto L16;
            sq.c r107 = this.f50205e;
            r107.f542947k = true;
            int r108 = SlcEventHelper.f50626a;
            r107.f542939c = System.nanoTime() - r107.f542937a;
            sq.c r109 = this.f50205e;
            r109.f542946j = true;
            if (r100 == null) goto L11;
            r100.l(r109, r103.f50700b, r210, true);
        L11:
            r106.f50676d = true;
            r106.f50677e = null;
            if (r102 == null) goto L14;
            r102.a(r106);
        L14:
            this.f50201a = r103;
            return;
        L16:
            if (r104 == null) goto L101;
            com.bytedance.android.ecom.arch.slice.render.i r114 = this.f50206f;
            String r115 = r114.f50670a;
            String r116 = r114.f50671b;
            ?? r117 = r114.f50672c;
            p r118 = new p(r115, r116, r117, r110, r111, r112, r113);
            sq.c r119 = this.f50205e;
            r119.f542947k = r105;
            int r120 = SlcEventHelper.f50626a;
            r119.f542939c = System.nanoTime() - r119.f542937a;
            WeakReference<r> r121 = this.f50202b;     // Catch: Throwable -> L69
            if (r121 != null) goto L30;
            if (r100 == null) goto L27;
            r.f50698d.getClass();     // Catch: Throwable -> L69
            r r122 = r.a.a(r100, r104, r118);     // Catch: Throwable -> L69
            r100.l(this.f50205e, r122.f50700b, r210, true);     // Catch: Throwable -> L69
            r106.f50673a = r122;     // Catch: Throwable -> L69
            r106.f50676d = true;     // Catch: Throwable -> L69
            r104 = null;
            r106.f50677e = null;     // Catch: Throwable -> L28
            if (r102 == null) goto L26;
            r102.a(r106);     // Catch: Throwable -> L69
        L26:
            this.f50201a = r122;     // Catch: Throwable -> L69
        L28:
            th = th;
        L71:
            r117 = 0;
        L72:
            r r123 = this.f50201a;
            if (r123 == null) goto L77;
            View r124 = r123.f50701c;
            Object r125 = r124;
            if (r124 == null) goto L77;
        L83:
            Object r126 = r104;
            if ((r125 instanceof SlcRootView) == false) goto L87;
            r126 = r125;
        L87:
            SlcRootView r127 = (SlcRootView) r126;
            if (r127 == null) goto L90;
            r127.g();
        L90:
            r106.f50676d = r117;
            r106.f50677e = "create_view";
            if (r102 == null) goto L93;
            r102.a(r106);
        L93:
            sq.c r128 = this.f50205e;
            r128.f542942f = "create_view";
            r128.f542941e = r117;
            if (r100 == null) goto L100;
            String r129 = th.getMessage();
            if (r129 != null) goto L99;
            r129 = "catch_error";
        L99:
            r100.k(r128, r118, r210, r129, th);
        L100:
            throw th;
        L77:
            WeakReference<r> r130 = this.f50202b;
            if (r130 == null) goto L82;
            r r131 = r130.get();
            if (r131 == null) goto L82;
            r125 = r131.f50701c;
        L82:
            r125 = r104;
        L27:
            Unit r132 = Unit.INSTANCE;     // Catch: Throwable -> L69
            return;
        L30:
            r r133 = r121.get();     // Catch: Throwable -> L69
            if (r133 == null) goto L65;
            SlcTemplateContext r134 = r133.f50700b;     // Catch: Throwable -> L69
            View r135 = r133.f50701c;     // Catch: Throwable -> L69
            if ((r135 instanceof SlcRootView) == true) goto L35;
            r135 = null;
        L35:
            SlcRootView r136 = (SlcRootView) r135;     // Catch: Throwable -> L69
            p r137 = r134.f50236x;     // Catch: Throwable -> L69
            if (r137 == null) goto L38;
            r137.f50694d = r210.f50685d;     // Catch: Throwable -> L69
        L38:
            if (r137 == null) goto L40;
            r137.f50695e = r210.f50688g;     // Catch: Throwable -> L69
        L40:
            if (r137 == null) goto L42;
            r137.f50696f = r210.f50689h;     // Catch: Throwable -> L69
        L42:
            if (r137 == null) goto L44;
            r137.f50697g = r210.f50690i;     // Catch: Throwable -> L69
        L44:
            if (r136 == null) goto L137;
            Map<String, ? extends Object> r138 = r134.f50222j;     // Catch: Throwable -> L69
            String r139 = r134.f50219g;     // Catch: Throwable -> L69
            r117 = 0;
            r117 = 0;
            r117 = 0;
            BaseSlcViewManager<?> r140 = r134.c(r104.getType(), true, false);     // Catch: Throwable -> L63
            r134.f50218f = r140;     // Catch: Throwable -> L63
            r136.setRootViewManager$slice_render_release(r140);     // Catch: Throwable -> L63
            r140.m0(r104);     // Catch: Throwable -> L63
            if (r100 == null) goto L50;
            r100.l(this.f50205e, r133.f50700b, r210, true);     // Catch: Throwable -> L63
        L50:
            if (r138 != null) goto L52;
        L55:
            boolean r141 = true;
        L56:
            if (r141 == true) goto L58;
            r133.a(r138, r139);     // Catch: Throwable -> L63
        L58:
            r106.f50673a = r133;     // Catch: Throwable -> L63
            r106.f50676d = true;     // Catch: Throwable -> L63
            r104 = null;
            r104 = null;
            r106.f50677e = null;     // Catch: Throwable -> L67
            if (r102 == null) goto L128;
            r102.a(r106);     // Catch: Throwable -> L67
            Unit r142 = Unit.INSTANCE;     // Catch: Throwable -> L67
        L128:
            return;
        L52:
            if (r138.isEmpty() == true) goto L55;
            r141 = false;
        L63:
            th = th;
            r104 = null;
            goto L72
        L137:
            return;
        L65:
            r104 = null;
            r117 = 0;
            Unit r143 = Unit.INSTANCE;     // Catch: Throwable -> L67
        L67:
            th = th;
        L69:
            th = th;
            r104 = null;
            goto L71
        L101:
            r r144 = this.f50201a;
            if (r144 == null) goto L106;
            View r145 = r144.f50701c;
            if (r145 == null) goto L106;
        L113:
            if ((r145 instanceof SlcRootView) == true) goto L115;
            View r146 = null;
        L116:
            SlcRootView r147 = (SlcRootView) r146;
            if (r147 == null) goto L119;
            r147.g();
        L119:
            r106.f50676d = false;
            r106.f50677e = "load_template";
            if (r102 == null) goto L122;
            r102.a(r106);
        L122:
            sq.c r148 = this.f50205e;
            r148.f542942f = "load_template";
            r148.f542941e = false;
            if (r100 == null) goto L138;
            com.bytedance.android.ecom.arch.slice.render.i r149 = this.f50206f;
            r100.k(r148, new p(r149.f50670a, r149.f50671b, r149.f50672c, r210.f50688g, 104), r210, "template_load_failed", null);
            return;
        L138:
            return;
        L115:
            r146 = r145;
        L106:
            WeakReference<r> r150 = this.f50202b;
            if (r150 == null) goto L111;
            r r151 = r150.get();
            if (r151 == null) goto L111;
            r145 = r151.f50701c;
        L111:
            r145 = null;
            goto L113
        L5:
            r102 = null;
            goto L6
        }

        public b(WeakReference<SlcRenderContext> r100, sq.c r101, com.bytedance.android.ecom.arch.slice.render.i r102) {
            this.f50204d = r100;
            this.f50205e = r101;
            this.f50206f = r102;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlcRenderContext f50207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ sq.c f50208b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f50209c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ o f50210d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ SlcTemplateContext f50211e;

        public c(SlcRenderContext r100, sq.c r101, boolean r102, o r103, SlcTemplateContext r104) {
            this.f50207a = r100;
            this.f50208b = r101;
            this.f50209c = r102;
            this.f50210d = r103;
            this.f50211e = r104;
        }

        public final void a() {
            sq.c r100 = this.f50208b;
            r100.f542941e = this.f50209c;
            o r101 = this.f50210d;
            if (r101 == null) goto L5;
            long r102 = r101.f50685d;
        L6:
            r100.f542943g = r102;
            if (r101 == null) goto L9;
            int r103 = r101.f50686e;
        L10:
            r100.f542944h = r103;
            SlcTemplateContext r104 = this.f50211e;
            HashMap r105 = new HashMap();
            int r106 = SlcEventHelper.f50626a;
            SlcEventHelper.a(r104, r105, Float.valueOf(Math.round((r100.f542938b - r100.f542937a) / 1000.0f) / 1000.0f), Boolean.valueOf(r100.f542941e));
            r105.put(LocationMonitorConst.IS_BACKGROUND, "1");
            r105.put("first_screen", Integer.valueOf(r100.f542945i ? 1 : 0));
            r105.put("hit_view_cache", Integer.valueOf(r100.f542946j ? 1 : 0));
            r105.put("hit_template_cache", Integer.valueOf(r100.f542947k ? 1 : 0));
            r105.put("error_code", r100.f542942f);
            r105.put("gecko_version", String.valueOf(r100.f542943g));
            r105.put("gecko_error_code", Integer.valueOf(r100.f542944h));
            r105.put("load_template_time", Float.valueOf(Math.round(r100.f542939c / 1000.0f) / 1000.0f));
            r105.put("create_view_time", Float.valueOf(Math.round(r100.f542940d / 1000.0f) / 1000.0f));
            SliceRender.f50121o.getClass();
            pq.a r107 = SliceRender.f50108b;
            if (r107 == null) goto L13;
            r107.i("slice_create_view", r105);
        L13:
            com.bytedance.android.ecom.arch.slice.render.context.c r108 = this.f50207a.f50165b0;
            if (r108 == null) goto L17;
            r108.b("slice_create_view", r105);
            return;
        L17:
            return;
        L9:
            r103 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f50160n0 = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SlcRenderContext.class), "isAccessibilityEnabled", "isAccessibilityEnabled$slice_render_release()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SlcRenderContext.class), "tempLocation", "getTempLocation$slice_render_release()[I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SlcRenderContext.class), "tempLocationF", "getTempLocationF$slice_render_release()[F")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SlcRenderContext.class), "tempOutline", "getTempOutline$slice_render_release()Landroid/graphics/Outline;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SlcRenderContext.class), "tempRect", "getTempRect$slice_render_release()Landroid/graphics/Rect;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SlcRenderContext.class), "tempRect2", "getTempRect2$slice_render_release()Landroid/graphics/Rect;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SlcRenderContext.class), "tempRectF", "getTempRectF$slice_render_release()Landroid/graphics/RectF;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SlcRenderContext.class), "tempMatrix", "getTempMatrix$slice_render_release()Landroid/graphics/Matrix;"))};
    }

    public final boolean j() {
        Lazy r100 = this.Z;
        KProperty r101 = f50160n0[0];
        return ((Boolean) r100.getValue()).booleanValue();
    }

    public final void a() {
        final e r100 = this.V;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f50244a == true) goto L7;
        return;
    L7:
        if (this.U == true) goto L12;
        com.bytedance.android.ecom.arch.slice.render.util.h.a(new SlcRenderContext$checkInitKeyboardMonitor$1(this, r100));
        return;
    }

    public void d() {
        if (this.f50195u == false) goto L5;
        this.f50195u = false;
        this.f50162a.a();
    L5:
        SlcKeyboardMonitor r100 = this.W;
        if (r100 == null) goto L19;
        r100.f50753e = true;
        if (r100.f50757i == false) goto L14;
        SlcKeyboardMonitor.SlcApplyWindowInsetsListener r101 = r100.f50754f;
        if (r101 == null) goto L18;
        SlcKeyboardMonitor.b r102 = r100.f50758j;
        if (r102 == null) goto L18;
        r102.b(r101);
    L18:
        r100.f50749a.clear();
        goto L19
    L14:
        ViewTreeObserver r103 = r100.f50756h.getViewTreeObserver();
        if (r103 == null) goto L17;
        r103.removeOnGlobalLayoutListener(r100.f50751c);
    L17:
        r100.f50751c = null;
    L19:
        Iterator<Map.Entry<Long, ar.a>> r104 = this.X.entrySet().iterator();
    L21:
        if (r104.hasNext() == false) goto L23;
        ar.a r105 = r104.next().getValue();
        r105.f15993a = true;
        r105.f15994b = false;
        r105.f15997e.removeCallbacks(r105.f15998f);
        goto L21
    L23:
        Iterator<Map.Entry<Object, Object>> r106 = this.f50186m.entrySet().iterator();
    L25:
        if (r106.hasNext() == false) goto L33;
        Map.Entry<Object, Object> r107 = r106.next();
        if ((r107.getValue() instanceof com.bytedance.android.ecom.arch.slice.render.c) == false) goto L25;
        Object r108 = r107.getValue();
        if (r108 == null) goto L32;
        ((com.bytedance.android.ecom.arch.slice.render.c) r108).close();
        goto L25
    L32:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.ecom.arch.slice.render.ISlcAutoCloseableService");
    L33:
        com.bytedance.android.ecom.arch.slice.render.g r109 = this.f50163a0;
        if (r109 == null) goto L37;
        r109.release();
    L37:
        if (this.O == false) goto L40;
        Function0<Map<String, ? extends Object>> r110 = new SlcRenderContext$reportTextLayoutCacheHit$1(this);
        SliceRender.f50121o.getClass();
        SliceRender.g().execute(new f("android_slice_text_layout_hit", r110));
    L40:
        SliceRender.f50121o.getClass();
    }

    public final com.bytedance.android.ecom.arch.slice.render.elements.text.f h() {
        com.bytedance.android.ecom.arch.slice.render.elements.text.f r100 = this.P;
        if (r100 != null) goto L14;
        com.bytedance.android.ecom.arch.slice.render.elements.text.f.a r101 = com.bytedance.android.ecom.arch.slice.render.elements.text.f.f50536d;
        String r102 = this.f50185l0;
        monitor-enter(r101);
        HashMap<String, com.bytedance.android.ecom.arch.slice.render.elements.text.f> r103 = com.bytedance.android.ecom.arch.slice.render.elements.text.f.f50535c;     // Catch: Throwable -> L11
        com.bytedance.android.ecom.arch.slice.render.elements.text.f r104 = r103.get(r102);     // Catch: Throwable -> L11
        if (r104 != null) goto L9;
        r104 = new com.bytedance.android.ecom.arch.slice.render.elements.text.f();     // Catch: Throwable -> L11
        r103.put(r102, r104);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r101);
        this.P = r104;
        return r104;
    L11:
        th = move-exception;
        throw th;
    L14:
        return r100;
    }

    public final Context getContext() {
        return this.f50183k0;
    }

    public static void m(Function0 r100) {
        SliceRender.f50121o.getClass();
        SliceRender.g().execute(new h(r100));
    }

    public final void b(boolean r100) {
        e r101 = this.V;
        if (r101 != null) goto L5;
    L7:
        BaseSlcViewManager<?> r102 = this.f50194t;
        if (r102 == null) goto L12;
        r102.N0(false);
        return;
    L12:
        return;
    L5:
        if (r101.f50244a != true) goto L7;
        if (r100 == true) goto L7;
    }

    public final void e(MotionEvent r100) {
        BaseSlcViewManager<?> r101 = this.f50194t;
        e r102 = this.V;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.f50244a != true) goto L26;
        if (r100 == null) goto L27;
        if (r101 == null) goto L28;
        View r103 = r101.getView();
        int r104 = r100.getActionMasked();
        if (r104 == 0) goto L22;
        if (r104 == 1) goto L19;
        if (r104 == 3) goto L19;
        if (r104 == 5) goto L22;
        if (r104 == 6) goto L19;
        return;
    L19:
        if (SlcViewExtensionsKt.i(r103, r100) == true) goto L29;
        r101.N0(false);
        return;
    L29:
        return;
    L22:
        if (SlcViewExtensionsKt.i(r103, r100) == true) goto L31;
        r101.N0(false);
        return;
    L31:
        return;
    L28:
        return;
    L27:
        return;
    }

    public final Object g(Object r100) {
        return this.f50186m.get(r100);
    }

    public final ar.a i(long r100) {
        ar.a r101 = this.X.get(Long.valueOf(r100));
        if (r101 != null) goto L5;
    L6:
        ar.a r102 = new ar.a(r100);
        this.X.put(Long.valueOf(r100), r102);
        return r102;
    L5:
        if (r101.f15993a == true) goto L6;
        return r101;
    }

    public final void n(final SlcKeyboardMonitor.c r100) {
        com.bytedance.android.ecom.arch.slice.render.util.h.a(new SlcRenderContext$registerKeyboardListener$1(this, r100));
    }

    public final void p(Map<String, ? extends Object> r100) {
        if (this.F != null) goto L6;
        this.F = r100;
        return;
    L6:
        if (nq.a.g() == false) goto L10;
        Toast.makeText(this.f50183k0, "无效设置，setCustomGlobalProps，只有首次生效", 0).show();
        return;
    }

    public final void q(e r110) {
        if (r110.f50244a == true) goto L5;
    L7:
        this.V = r110;
        return;
    L5:
        if (r110.f50245b != null) goto L7;
        com.bytedance.android.ecom.arch.slice.render.event.monitor.a.a(new com.bytedance.android.ecom.arch.slice.render.event.monitor.a("CUSTOM_ERROR", "content_view_null", "The content View in the onBlur adaptation information is null", null, null, null, 56), this.f50164b, null, false, 6);
        goto L7
    }

    public final void r(long r100) {
        long r101 = (System.currentTimeMillis() / ((long) 1000)) - r100;
        SlcExprContext r102 = this.f50187m0;
        Long r103 = Long.valueOf(r101);
        r102.f50054a.put("slc_server_time", r103);
    }

    public final void s(int r100) {
        if (this.O == false) goto L8;
        com.bytedance.android.ecom.arch.slice.render.elements.text.f r101 = h();
        if (r100 == r101.f50537a) goto L9;
        r101.f50537a = r100;
        r101.f50538b.resize(RangesKt.coerceAtLeast(r100, 1));
        return;
    L9:
        return;
    }

    public final void t(final SlcKeyboardMonitor.c r100) {
        com.bytedance.android.ecom.arch.slice.render.util.h.a(new SlcRenderContext$unRegisterKeyboardListener$1(this, r100));
    }

    public static View f(View r100, String r101) {
        com.bytedance.android.ecom.arch.slice.render.elements.g r102 = SlcViewExtensionsKt.d(r100);
        if (r102 == null) goto L5;
        SlcTemplateContext r103 = r102.getTemplateContext();
    L6:
        if (r103 == null) goto L11;
        BaseSlcViewManager<?> r104 = r103.h(r101);
        if (r104 != null) goto L10;
        return null;
    L10:
        return r104.getView();
    L11:
        return null;
    L5:
        r103 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v7, types: [T, java.lang.ref.WeakReference, java.lang.ref.WeakReference<com.bytedance.android.ecom.arch.slice.render.r>] */
    public final r c(com.bytedance.android.ecom.arch.slice.render.i r210, com.bytedance.android.ecom.arch.slice.render.d r211) {
        sq.c r100 = new sq.c();
        r100.f542945i = this.f50168d;
        int r101 = SlcEventHelper.f50626a;
        r100.f542937a = System.nanoTime();
        Ref.ObjectRef r102 = new Ref.ObjectRef();
        b r103 = new b(new WeakReference(this), r100, r210);
        if (r211 == null) goto L5;
        r103.f50203c = new WeakReference(r211);
    L5:
        com.bytedance.android.ecom.arch.slice.render.g r104 = this.f50163a0;
        AttributeSet r105 = null;
        if (r104 == null) goto L8;
        r104.a(r210, this.f50176h, r103);
    L9:
        r r106 = r103.f50201a;
        if (r106 != null) goto L20;
        p r107 = new p(r210.f50670a, r210.f50671b, r210.f50672c, null, 120);
        boolean r108 = com.bytedance.android.ecom.arch.slice.render.util.h.b();
        SlcTemplateContext r109 = new SlcTemplateContext(this, r107);
        r109.f50216d = r108;
        BaseSlcViewManager<?> r110 = this.f50166c;
        int r111 = 0;
        if (r110 != null) goto L15;
        SlcElement r112 = new SlcElement("View", null, null, null, null, null, null, null, null, null, null, null, null, null, 16382, null);
        r110 = this.f50164b.c(r112.getType(), false, false);
        this.f50166c = r110;
    L15:
        YogaNode r113 = com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.f(r110, false);
        r113.setHeight(1.0f);
        r113.setWidth(1.0f);
        r113.setMeasureFunction(null);
        SlcRootView r114 = new SlcRootView(this.f50183k0, r105, 6, r111);
        YogaNode r115 = r114.f51020a;
        if (r115 == null) goto L18;
        r115.addChildAt(r113, r115.getChildCount());
    L18:
        r114.f50785j = r113;
        r114.setCreateLayoutListener$slice_render_release(r109.f50220h.f50632f);
        r r116 = new r(r109, r114);
        ?? r117 = new WeakReference(r116);
        r102.element = r117;
        r103.f50202b = r117;
        return r116;
    L20:
        return r106;
    L8:
        nq.a.c(null, new SlcRenderContext$createView$2(this), 1);
        goto L9
    }

    public final void o(Object r100, Object r101) {
        this.f50186m.put(r100, r101);
    }

    public SlcRenderContext(Context r100, String r101, SlcExprContext r102) {
        this.f50183k0 = r100;
        this.f50185l0 = r101;
        this.f50187m0 = r102;
        TemplateViewPool r103 = new TemplateViewPool(this);
        this.f50162a = r103;
        this.f50164b = new SlcTemplateContext(this, null);
        com.bytedance.android.ecom.arch.slice.render.context.b.f50238f.getClass();
        this.f50172f = com.bytedance.android.ecom.arch.slice.render.context.b.f50237e;
        this.f50174g = true;
        this.f50182k = 500;
        this.f50186m = new ConcurrentHashMap();
        this.f50190p = 100;
        this.f50191q = new HashMap();
        this.f50192r = new HashMap();
        this.f50193s = new HashMap();
        this.f50195u = true;
        this.f50196v = -1;
        this.f50197w = true;
        this.f50199y = true;
        this.f50200z = true;
        this.B = true;
        this.C = true;
        this.G = true;
        this.H = true;
        this.I = true;
        this.f50161J = true;
        this.K = true;
        this.M = true;
        this.X = new HashMap();
        this.Y = new ArrayList();
        this.Z = LazyKt.lazy(new SlcRenderContext$isAccessibilityEnabled$2(this));
        LazyThreadSafetyMode r104 = LazyThreadSafetyMode.NONE;
        this.f50169d0 = LazyKt.lazy(r104, SlcRenderContext$tempLocation$2.INSTANCE);
        this.f50171e0 = LazyKt.lazy(r104, SlcRenderContext$tempLocationF$2.INSTANCE);
        this.f50173f0 = LazyKt.lazy(r104, SlcRenderContext$tempOutline$2.INSTANCE);
        this.f50175g0 = LazyKt.lazy(r104, SlcRenderContext$tempRect$2.INSTANCE);
        this.f50177h0 = LazyKt.lazy(r104, SlcRenderContext$tempRect2$2.INSTANCE);
        this.f50179i0 = LazyKt.lazy(r104, SlcRenderContext$tempRectF$2.INSTANCE);
        this.f50181j0 = LazyKt.lazy(r104, SlcRenderContext$tempMatrix$2.INSTANCE);
        if (com.bytedance.android.ecom.arch.slice.render.util.h.getActivity(r100) == null) goto L5;
        boolean r105 = true;
    L6:
        nq.a.e(r105, AnonymousClass1.INSTANCE, 2);
        SliceRender.f50121o.getClass();
        pq.a r106 = SliceRender.f50108b;
        if (r106 == null) goto L12;
        JSONObject r107 = r106.e();
        if (r107 == null) goto L12;
        this.f50197w = r107.optBoolean("enable_lazy_add_children", true);
        this.f50195u = r107.optBoolean("enable_view_pool", true);
        this.f50174g = r107.optBoolean("enable_lynx_typeface", true);
        this.B = r107.optBoolean("fix_a11y_not_find_view", true);
        SlcBackgroundDrawable.f50846t = r107.optBoolean("disable_radius_provider", false);
        SlcBackgroundDrawable.f50847u = r107.optBoolean("enable_anti_alias", true);
        this.f50198x = r107.optBoolean("use_image_loader_hook", false);
        this.D = r107.optBoolean("drawable_reset_pre_fetch", false);
        this.C = r107.optBoolean("enable_eval_child_actions", true);
        this.N = r107.optBoolean("enable_text_measure_opt", false);
        this.S = r107.optBoolean("enable_root_measure_shortcut", false);
        this.M = r107.optBoolean("enable_gone_layout_fix", true);
        this.G = r107.optBoolean("enable_text_decoration", true);
        this.H = r107.optBoolean("enable_list_ui_action", true);
        this.I = r107.optBoolean("enable_list_filter_if", true);
        this.K = r107.optBoolean("fix_inline_image_auto_size", true);
        this.L = r107.optBoolean("fix_waterfall_scroll", false);
        this.f50161J = r107.optBoolean("eval_display_after_props", true);
        this.f50200z = r107.optBoolean("fix_image_flash", true);
    L12:
        if (this.f50195u == false) goto L14;
        r103.c();
    L15:
        ViewConfiguration.get(r100);
        return;
    L14:
        r103.a();
        goto L15
    L5:
        r105 = false;
        goto L6
    }

    public final void l(sq.c r100, SlcTemplateContext r110, o r111, boolean r112) {
        r100.getClass();
        int r101 = SlcEventHelper.f50626a;
        long r102 = System.nanoTime();
        r100.f542938b = r102;
        r100.f542940d = (r102 - r100.f542937a) - r100.f542939c;
        r110.f50220h.f50627a = r100;
        SliceRender.f50121o.getClass();
        SliceRender.g().execute(new c(this, r100, r112, r111, r110));
    }

    public final void k(sq.c r100, p r101, final o r102, String r103, final Throwable r104) {
        final String r105 = "create slice view failure:" + r103 + ",template name:" + r101.f50692b;
        final SlcTemplateContext r106 = new SlcTemplateContext(this, r101);
        l(r100, r106, r102, false);
        m(new SlcRenderContext$logCreateErrorEvent$1(r105, r102, r106, r104));
    }
}
