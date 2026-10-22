package com.bytedance.android.ecom.arch.slice.render.elements;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.RecordingCanvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.RenderNode;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Toast;
import androidx.core.view.ViewCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.linkcommon.cybergarage.upnp.event.Subscription;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.n;
import com.bytedance.android.ecom.arch.slice.action.ui.SlcUIActionErrorCode;
import com.bytedance.android.ecom.arch.slice.render.ISlcElement;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.SlcImageFetchManager;
import com.bytedance.android.ecom.arch.slice.render.event.SlcEventHelper;
import com.bytedance.android.ecom.arch.slice.render.exposure.SlcTemplateExposureMgr;
import com.bytedance.android.ecom.arch.slice.render.m;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.util.accessibility.AccessibilityUtil$setAccessibilityDelegate$1;
import com.bytedance.android.ecom.arch.slice.render.util.touch_delegate.SlcTouchDelegateHelper;
import com.bytedance.android.ecom.arch.slice.render.widget.SlcRootView;
import com.bytedance.android.ecom.arch.slice.render.widget.animation.j;
import com.bytedance.android.ecom.arch.slice.render.widget.background.SlcBackgroundDrawable;
import com.bytedance.android.ecom.arch.slice.render.widget.yoga.SlcItemView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaGutter;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.texturerender.TextureRenderKeys;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes44.dex */
public abstract class BaseSlcViewManager<VType extends View> implements g, Drawable.Callback {
    public static final /* synthetic */ KProperty[] G3 = null;
    public Object A;
    public xq.a A3;
    public Object B;
    public xq.a B3;
    public Object C;
    public BaseSlcViewManager<VType>.a C3;
    public Object D;
    public VType D3;
    public Object E;
    public Map<String, ? extends Object> E2;
    public BaseSlcViewManager<VType>.b E3;
    public Object F;
    public List<? extends IAction> F2;
    public final Lazy F3;
    public Object G;
    public Object G1;
    public List<Float> G2;
    public Object H;
    public Object H0;
    public Object H1;
    public WeakHashMap<View, SlcTouchDelegateHelper> H2;
    public Object I;
    public uq.a I2;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public Object f50259J;
    public uq.a J2;
    public Object K;
    public boolean K2;
    public Object L;
    public Object L0;
    public Object L1;
    public List<String> L2;
    public Object M;
    public Object M1;
    public List<Float> M2;
    public Object N;
    public List<Float> N2;
    public Object O;
    public List<String> O2;
    public Object P;
    public Object P0;
    public com.bytedance.android.ecom.arch.slice.render.util.touch_delegate.a P1;
    public Map<String, Object> P2;
    public Object Q;
    public ArrayList<Runnable> Q1;
    public j Q2;
    public Object R;
    public Object R2;
    public Object S;
    public boolean S1;
    public Object S2;
    public Object T;
    public Map<String, ? extends Object> T1;
    public Object T2;
    public Object U;
    public Object U2;
    public Object V;
    public Object V0;
    public boolean V1;
    public Object V2;
    public Object W;
    public Object W2;
    public Object X;
    public Object X2;
    public Object Y;
    public Object Y2;
    public Object Z;
    public boolean Z2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SlcTemplateContext f50260a;

    /* JADX INFO: renamed from: a3, reason: collision with root package name */
    public List<String> f50261a3;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, ? extends Object> f50262b;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public Object f50263b1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public boolean f50264b2;

    /* JADX INFO: renamed from: b3, reason: collision with root package name */
    public List<String> f50265b3;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, ? extends Object> f50266c;

    /* JADX INFO: renamed from: c3, reason: collision with root package name */
    public List<? extends Object> f50267c3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BaseSlcViewGroupManager<?> f50268d;

    /* JADX INFO: renamed from: d3, reason: collision with root package name */
    public List<? extends Object> f50269d3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SlcElement f50270e;

    /* JADX INFO: renamed from: e3, reason: collision with root package name */
    public List<? extends Object> f50271e3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final YogaNode f50272f;

    /* JADX INFO: renamed from: f3, reason: collision with root package name */
    public List<? extends Object> f50273f3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SlcBackgroundDrawable f50274g;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public Object f50275g1;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public boolean f50276g2;

    /* JADX INFO: renamed from: g3, reason: collision with root package name */
    public List<? extends Object> f50277g3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f50278h;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public Object f50279h1;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public Object f50280h2;

    /* JADX INFO: renamed from: h3, reason: collision with root package name */
    public List<? extends Object> f50281h3;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Object f50282i;

    /* JADX INFO: renamed from: i3, reason: collision with root package name */
    public com.bytedance.android.ecom.arch.slice.render.widget.animation.c f50283i3;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Object f50284j;

    /* JADX INFO: renamed from: j3, reason: collision with root package name */
    public boolean f50285j3;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Object f50286k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public Object f50287k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public Object f50288k1;

    /* JADX INFO: renamed from: k3, reason: collision with root package name */
    public boolean f50289k3;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f50290l;

    /* JADX INFO: renamed from: l3, reason: collision with root package name */
    public boolean f50291l3;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Object f50292m;

    /* JADX INFO: renamed from: m3, reason: collision with root package name */
    public boolean f50293m3;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Object f50294n;

    /* JADX INFO: renamed from: n3, reason: collision with root package name */
    public boolean f50295n3;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Object f50296o;

    /* JADX INFO: renamed from: o3, reason: collision with root package name */
    public Object f50297o3;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f50298p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public Object f50299p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public Object f50300p1;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public boolean f50301p2;

    /* JADX INFO: renamed from: p3, reason: collision with root package name */
    public int f50302p3;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Object f50303q;

    /* JADX INFO: renamed from: q3, reason: collision with root package name */
    public ArrayList<Integer> f50304q3;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Object f50305r;

    /* JADX INFO: renamed from: r3, reason: collision with root package name */
    public boolean f50306r3;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Object f50307s;

    /* JADX INFO: renamed from: s3, reason: collision with root package name */
    public BaseSlcViewGroupManager<?> f50308s3;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Object f50309t;

    /* JADX INFO: renamed from: t3, reason: collision with root package name */
    public boolean f50310t3;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Object f50311u;

    /* JADX INFO: renamed from: u3, reason: collision with root package name */
    public boolean f50312u3;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f50313v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public Map<String, ? extends Object> f50314v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public Object f50315v2;

    /* JADX INFO: renamed from: v3, reason: collision with root package name */
    public int f50316v3;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f50317w;

    /* JADX INFO: renamed from: w3, reason: collision with root package name */
    public int f50318w3;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f50319x;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public Object f50320x1;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public IAction f50321x2;

    /* JADX INFO: renamed from: x3, reason: collision with root package name */
    public int f50322x3;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f50323y;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public Object f50324y1;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    public IAction f50325y2;

    /* JADX INFO: renamed from: y3, reason: collision with root package name */
    public int f50326y3;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Object f50327z;

    /* JADX INFO: renamed from: z3, reason: collision with root package name */
    public int f50328z3;

    public final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseSlcViewManager f50329a;

        public a(BaseSlcViewManager r100) {
            this.f50329a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            this.f50329a.C0();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            this.f50329a.D0();
        }
    }

    public final class b implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f50330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f50331b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BaseSlcViewManager f50332c;

        public b(BaseSlcViewManager r100) {
            this.f50332c = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            if (this.f50330a == false) goto L37;
            BaseSlcViewManager r101 = this.f50332c;
            KProperty[] r102 = BaseSlcViewManager.G3;
            if (r101.r0() == true) goto L37;
            List<String> r103 = r101.f50261a3;
            List<String> r104 = r103;
            boolean r105 = false;
            if (r104 != null) goto L10;
        L13:
            boolean r106 = true;
        L14:
            if (r106 == true) goto L37;
            if ((!r101.W().f50815c.isEmpty()) == true) goto L37;
            List<? extends Object> r107 = r101.f50277g3;
            if (r107 == null) goto L35;
            HashMap<String, com.bytedance.android.ecom.arch.slice.render.widget.animation.a> r108 = com.bytedance.android.ecom.arch.slice.render.widget.animation.c.f50812e;
            if (r107.isEmpty() == true) goto L33;
            int r109 = r107.size();
            int r110 = 0;
        L23:
            if (r110 >= r109) goto L33;
            Object r111 = ListProtector.get(r107, r110);
            if (r111 != null) goto L27;
        L29:
            boolean r112 = false;
        L30:
            if (r112 == true) goto L31;
            r110 = r110 + 1;
            goto L23
        L31:
            r105 = true;
            goto L33
        L27:
            if (Subscription.INFINITE_STRING.equals(r111) == false) goto L29;
            r112 = true;
        L33:
            if (r105 != true) goto L35;
            r101.W().h(r103, true);
        L35:
            r101.W().d(r103);
            goto L37
        L10:
            if (r104.isEmpty() == true) goto L13;
            r106 = false;
        L37:
            if (this.f50331b == false) goto L44;
            SlcImageFetchManager r113 = this.f50332c.K().f50866r;
            if (r113 == null) goto L45;
            r113.g();
            return;
        L45:
            return;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            if (this.f50330a == false) goto L14;
            BaseSlcViewManager r101 = this.f50332c;
            List<String> r102 = r101.f50261a3;
            if (r102 != null) goto L7;
        L10:
            boolean r103 = true;
        L11:
            if (r103 == true) goto L14;
            r101.W().b(true);
            goto L14
        L7:
            if (r102.isEmpty() == true) goto L10;
            r103 = false;
        L14:
            if (this.f50331b == false) goto L19;
            SlcImageFetchManager r104 = this.f50332c.K().f50866r;
            if (r104 == null) goto L20;
            r104.h();
            return;
        L20:
            return;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseSlcViewManager f50333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ uq.a f50334b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ uq.a f50335c;

        public c(BaseSlcViewManager r100, uq.a r101, uq.a r102) {
            this.f50333a = r100;
            this.f50334b = r101;
            this.f50335c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BaseSlcViewManager r100 = this.f50333a;     // Catch: Throwable -> L4
            r100.Y0(r100.R(this.f50334b), this.f50333a.S(this.f50335c));     // Catch: Throwable -> L4
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
        G3 = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(BaseSlcViewManager.class), "devToolsId", "getDevToolsId$slice_render_release()Ljava/lang/String;"))};
    }

    public abstract VType A0(Context r100);

    public YogaNode B0() {
        return com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.f(this, true);
    }

    public final void C() {
        this.V1 = false;
        this.f50268d = null;
        d1();
        WeakHashMap<View, SlcTouchDelegateHelper> r100 = this.H2;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L15;
        Iterator<Map.Entry<View, SlcTouchDelegateHelper>> r102 = r100.entrySet().iterator();
    L12:
        if (r102.hasNext() == false) goto L14;
        r102.next().getValue().b();
        goto L12
    L14:
        r100.clear();
    L15:
        this.f50302p3 = 0;
        if (this.f50306r3 == true) goto L18;
        nq.a.d(!q0(), null, null);
        return;
    L18:
        N();
        return;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public void C0() {
    }

    public boolean D(Canvas r100) {
        return false;
    }

    public void G0(Map<String, ? extends Object> r100) {
    }

    public abstract void H0(Map<String, ? extends Object> r100);

    public void I0(Map<String, ? extends Object> r100) {
    }

    public void J(Canvas r100) {
    }

    public void N0(boolean r100) {
    }

    public String a0() {
        return null;
    }

    @SlcUIActionErrorCode
    public int k0(lq.b r100) {
        return 3;
    }

    public void v0(Map<String, ? extends Object> r100) {
    }

    public void w0(Map<String, ? extends Object> r100) {
    }

    public void x0(VType r100) {
    }

    public void y0(SlcElement r100) {
    }

    public Map<String, Object> z0(Map<String, ? extends Object> r100) {
        return r100;
    }

    public final void H() {
        if (this.f50315v2 == null) goto L61;
        if (r0() == true) goto L61;
        int r100 = SlcEventHelper.f50626a;
        long r101 = System.nanoTime();
        IAction r102 = n.a(this.f50315v2);
        if (r102 == null) goto L10;
        List<IAction> r103 = r102.getActions();
    L11:
        List<IAction> r104 = r103;
        boolean r105 = true;
        if (r104 != null) goto L14;
    L17:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L20;
        d1();
        this.F2 = null;
    L57:
        int r107 = SlcEventHelper.f50626a;
        long r108 = (System.nanoTime() - r101) + 0;
        if (r108 <= 0) goto L66;
        this.f50260a.f50220h.f50628b.f542925f += r108;
        return;
    L66:
        return;
    L20:
        List<IAction> r109 = r103;
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator<T> r111 = r109.iterator();
    L22:
        if (r111.hasNext() == false) goto L24;
        r110.add(SlcTemplateContext.k(this.f50260a, (IAction) r111.next(), this.f50262b, 4));
        goto L22
    L24:
        this.F2 = r110;
        boolean r112 = this.f50301p2;
        if (r112 == true) goto L57;
        if (r112 == true) goto L57;
        SlcTemplateExposureMgr r113 = this.f50260a.l();
        SlcTemplateContext r114 = this.f50260a;
        String r115 = r114.f50219g;
        if (r115 != null) goto L30;
    L33:
        boolean r116 = true;
    L35:
        if (r116 == false) goto L37;
        com.bytedance.android.ecom.arch.slice.render.event.monitor.a.a(new com.bytedance.android.ecom.arch.slice.render.event.monitor.a("PARAMS_INVALID", "exposure_missing_params", "模版:" + r114.n() + ",带有精准曝光需要bindData传入uniqueNodeId", null, null, null, 56), r114, null, false, 6);
    L49:
        boolean r117 = false;
    L51:
        if (r117 == true) goto L54;
        r105 = false;
    L56:
        this.f50301p2 = r105;
        goto L57
    L54:
        if (r113.f50659a.contains(this) == true) goto L56;
        r113.f50659a.add(this);
        goto L56
    L37:
        Object r118 = this.f50280h2;
        if (r118 == null) goto L40;
        String r119 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r118);
    L41:
        if (r119 != null) goto L43;
    L46:
        boolean r120 = true;
    L47:
        if (r120 == false) goto L50;
        com.bytedance.android.ecom.arch.slice.render.event.monitor.a.a(new com.bytedance.android.ecom.arch.slice.render.event.monitor.a("PARAMS_INVALID", "exposure_missing_params", "模版:" + r114.n() + ",带有精准曝光的element需要配置exposure-id 或 slice-key", null, null, null, 56), r114, null, false, 6);
        goto L49
    L50:
        r117 = true;
        goto L51
    L43:
        if (r119.length() == 0) goto L46;
        r120 = false;
        goto L47
    L40:
        r119 = d0();
        goto L41
    L30:
        if (r115.length() == 0) goto L33;
        r116 = false;
        goto L35
    L14:
        if (r104.isEmpty() == true) goto L17;
        r106 = false;
        goto L18
    L10:
        r103 = null;
    L61:
        if (this.f50301p2 == false) goto L63;
        d1();
    L63:
        this.F2 = null;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.View] */
    public void J0() {
        if (this.f50306r3 == false) goto L13;
        this.f50312u3 = true;
        BaseSlcViewGroupManager<?> r100 = this.f50268d;
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.f50306r3 == false) goto L9;
        boolean r101 = r100.f50312u3;
    L10:
        if (r101 == true) goto L20;
        r100.J0();
        return;
    L20:
        return;
    L9:
        r101 = r100.getView().isLayoutRequested();
        goto L10
    L13:
        if (this.f50260a.f50235w.M == false) goto L16;
        getView().requestLayout();
        return;
    L16:
        if (getView().isLayoutRequested() == true) goto L23;
        getView().requestLayout();
        return;
    }

    public final SlcBackgroundDrawable K() {
        SlcBackgroundDrawable r100 = this.f50274g;
        if (r100 != null) goto L6;
        SlcBackgroundDrawable r101 = new SlcBackgroundDrawable();
        this.f50274g = r101;
        this.f50278h = true;
        return r101;
    L6:
        return r100;
    }

    public final void K0() {
        xq.a r100 = this.A3;
        if (r100 != null) goto L5;
    L9:
        xq.a r101 = this.B3;
        if (r101 != null) goto L12;
        return;
    L12:
        if (r101.a() == false) goto L18;
        RenderNode r102 = r101.f564791b;
        if (r102 == null) goto L19;
        r102.discardDisplayList();
        return;
    L19:
        return;
    L18:
        return;
    L5:
        if (r100.a() == false) goto L9;
        RenderNode r103 = r100.f564791b;
        if (r103 == null) goto L9;
        r103.discardDisplayList();
        goto L9
    }

    public final void L() {
        SlcElement r100 = this.f50270e;
        if (r100 == null) goto L7;
        com.bytedance.android.ecom.arch.slice.render.bindinfo.d r101 = r100.bindInfo;
        if (r101 == null) goto L7;
        Map<String, String> r102 = r101.f50141l;
    L9:
        if (r102 != null) goto L11;
    L14:
        boolean r103 = true;
    L15:
        if (r103 == true) goto L25;
        Map<String, ? extends Object> r104 = l();
        String r105 = r102.get("aria_hidden");
        if (r105 == null) goto L19;
        SlcTemplateContext r106 = this.f50260a;
        this.f50284j = r106.f50235w.f50187m0.a(r105, r104, r106.f50230r);
    L19:
        String r107 = r102.get("aria_label");
        if (r107 == null) goto L22;
        SlcTemplateContext r108 = this.f50260a;
        this.f50286k = r108.f50235w.f50187m0.a(r107, r104, r108.f50230r);
    L22:
        String r109 = r102.get("role");
        if (r109 == null) goto L25;
        SlcTemplateContext r110 = this.f50260a;
        this.f50282i = r110.f50235w.f50187m0.a(r109, r104, r110.f50230r);
    L25:
        this.f50290l = true;
        return;
    L11:
        if (r102.isEmpty() == true) goto L14;
        r103 = false;
    L7:
        r102 = null;
        goto L9
    }

    public final String Q() {
        String r100 = this.f50260a.f50219g;
        HashMap<String, com.bytedance.android.ecom.arch.slice.render.widget.animation.a> r101 = j.f50835d;
        Object r102 = this.Y2;
        if (r102 == null) goto L13;
        String r103 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r102);
        if (r103 != null) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == false) goto L15;
        r103 = d0();
    L15:
        return r100 + '_' + r103;
    L7:
        if (r103.length() == 0) goto L10;
        r104 = false;
        goto L11
    L13:
        r103 = d0();
        goto L15
    }

    public String T() {
        if (this.f50290l == true) goto L5;
        L();
    L5:
        String r100 = com.bytedance.android.ecom.arch.slice.render.util.b.r(this.f50286k);
        if (r100 != null) goto L10;
        return "";
    L10:
        return r100;
    }

    public final com.bytedance.android.ecom.arch.slice.render.widget.animation.c W() {
        com.bytedance.android.ecom.arch.slice.render.widget.animation.c r100 = this.f50283i3;
        if (r100 != null) goto L6;
        com.bytedance.android.ecom.arch.slice.render.widget.animation.c r101 = new com.bytedance.android.ecom.arch.slice.render.widget.animation.c(this);
        this.f50283i3 = r101;
        return r101;
    L6:
        return r100;
    }

    public final View X() {
        if (this.f50306r3 == false) goto L9;
        BaseSlcViewGroupManager<?> r100 = this.f50308s3;
        if (r100 != null) goto L10;
        nq.a.c(null, BaseSlcViewManager$getAttachView$1.INSTANCE, 1);
        return null;
    L10:
        return (ViewGroup) r100.getView();
    L9:
        return getView();
    }

    public final wq.a Y() {
        xq.a r100 = this.B3;
        if (r100 == null) goto L5;
        return r100;
    L5:
        if (wq.b.f560681a == null) goto L7;
    L16:
        wq.b.f560681a.getClass();
        xq.a r101 = wq.b.a("bg");
        this.B3 = r101;
        return r101;
    L7:
        monitor-enter(wq.b.class);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (wq.b.f560681a != null) goto L11;
        wq.b.f560681a = new wq.b();     // Catch: Throwable -> L13
    L11:
        monitor-exit(wq.b.class);     // Catch: Throwable -> L13
        goto L16
    }

    public final boolean Z() {
        return !Intrinsics.areEqual(this.f50327z, "visible");
    }

    public final int c0() {
        if (this.f50306r3 == false) goto L6;
        return Math.round(this.f50272f.getLayoutHeight());
    L6:
        return getView().getHeight();
    }

    public final String d0() {
        Map<String, ? extends Object> r100 = this.f50266c;
        if (r100 == null) goto L5;
        Object r101 = r100.get(SlcElement.KEY_SLICE_KEY);
    L7:
        return com.bytedance.android.ecom.arch.slice.render.util.b.r(r101);
    L5:
        r101 = null;
        goto L7
    }

    public final void d1() {
        if (this.f50301p2 == false) goto L6;
        this.f50301p2 = false;
        this.f50260a.l().f50659a.remove(this);
        return;
    }

    public final Matrix e0() {
        if (this.f50306r3 == false) goto L6;
        Lazy r100 = this.f50260a.f50235w.f50181j0;
        KProperty r101 = SlcRenderContext.f50160n0[7];
        Matrix r102 = (Matrix) r100.getValue();
        ((xq.a) g0()).f564791b.getMatrix(r102);
        return r102;
    L6:
        return getView().getMatrix();
    }

    public final float f0() {
        if (this.f50306r3 == false) goto L6;
        return ((xq.a) g0()).f564791b.getAlpha();
    L6:
        return getView().getAlpha();
    }

    public final wq.a g0() {
        xq.a r100 = this.A3;
        if (r100 == null) goto L5;
        return r100;
    L5:
        if (wq.b.f560681a == null) goto L7;
    L16:
        wq.b.f560681a.getClass();
        xq.a r101 = wq.b.a(null);
        this.A3 = r101;
        return r101;
    L7:
        monitor-enter(wq.b.class);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (wq.b.f560681a != null) goto L11;
        wq.b.f560681a = new wq.b();     // Catch: Throwable -> L13
    L11:
        monitor-exit(wq.b.class);     // Catch: Throwable -> L13
        goto L16
    }

    public final Context getContext() {
        return this.f50260a.getContext();
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.g
    public final VType getView() {
        VType r100 = this.D3;
        if (r100 != null) goto L19;
        r100 = (VType) A0(getContext());
        SliceRender.f50121o.getClass();
        if (SliceRender.f() == true) goto L7;
    L9:
        x0(r100);
        this.D3 = r100;
        if (this.f50306r3 == false) goto L17;
        if (r100 == null) goto L14;
        nq.a.c(null, new BaseSlcViewManager$assertFlatten$1(this), 1);
    L14:
        if (this.f50308s3 != null) goto L19;
        nq.a.c(null, new BaseSlcViewManager$assertFlatten$2(this), 1);
        goto L19
    L17:
        if (this.f50308s3 == null) goto L19;
        nq.a.c(null, new BaseSlcViewManager$assertFlatten$3(this), 1);
        goto L19
    L7:
        if ((r100 instanceof ViewGroup) == false) goto L9;
        r100.setClipChildren(false);
    L19:
        return r100;
    }

    public final int j0() {
        if (this.f50306r3 == false) goto L6;
        return Math.round(this.f50272f.getLayoutWidth());
    L6:
        return getView().getWidth();
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.g
    public final Map<String, Object> l() {
        Map<String, ? extends Object> r100 = this.f50262b;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return MapsKt.emptyMap();
    }

    public final boolean l0() {
        if (this.f50306r3 == false) goto L6;
        return ((xq.a) g0()).f564791b.hasIdentityMatrix();
    L6:
        return getView().getMatrix().isIdentity();
    }

    public final void n0() {
        if (this.f50306r3 == true) goto L5;
        getView().invalidate();
        return;
    L5:
        if (s0() == false) goto L7;
        return;
    L7:
        if (this.f50310t3 == true) goto L15;
        this.f50310t3 = true;
        BaseSlcViewGroupManager<?> r100 = this.f50308s3;
        if (r100 == null) goto L16;
        r100.n0();
        return;
    L16:
        return;
    }

    public final Boolean p0() {
        if (this.f50290l == true) goto L5;
        L();
    L5:
        Object r100 = this.f50284j;
        if (r100 != null) goto L10;
        return null;
    L10:
        return Boolean.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.a(r100));
    }

    public final boolean r0() {
        if (this.f50298p == false) goto L14;
        Object r100 = this.f50296o;
        if (r100 != null) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == true) goto L15;
        return false;
    L15:
        return true;
    L7:
        if ("none".equals(r100) == false) goto L9;
        r101 = true;
        goto L10
    L14:
        return true;
    }

    public final boolean y() {
        if (this.f50306r3 == true) goto L6;
        return SlcViewExtensionsKt.a(getView());
    L6:
        if (s0() == true) goto L8;
        return true;
    L8:
        return false;
    }

    public View E0() {
        return getView();
    }

    public void N() {
        K0();
        BaseSlcViewManager<VType>.a r100 = this.C3;
        if (r100 != null) goto L5;
        r100 = new a(this);
        this.C3 = r100;
    L5:
        View r101 = X();
        if (r101 == null) goto L8;
        r101.removeOnAttachStateChangeListener(r100);
    L8:
        this.f50308s3 = null;
    }

    public String U() {
        return T();
    }

    public final boolean f1() {
        if (r0() == false) goto L5;
        a1(8);
        this.f50272f.setDisplay(YogaDisplay.NONE);
        return false;
    L5:
        Object r100 = this.f50294n;
        if ((r100 instanceof String) == true) goto L8;
        r100 = null;
    L8:
        String r101 = (String) r100;
        if (r101 != null) goto L12;
    L17:
        int r102 = 0;
    L18:
        this.f50272f.setDisplay(YogaDisplay.FLEX);
        a1(r102);
        if (r102 != 0) goto L23;
        return true;
    L23:
        return false;
    L12:
        if (r101.hashCode() != (-1217487446)) goto L17;
        if (r101.equals("hidden") == false) goto L17;
        r102 = 4;
        goto L18
    }

    public int h0() {
        return getView().getScrollX();
    }

    public int i0() {
        return getView().getScrollY();
    }

    public final boolean o0() {
        if (Intrinsics.areEqual(p0(), Boolean.FALSE) == false) goto L5;
        return true;
    L5:
        if ((!Intrinsics.areEqual(p0(), Boolean.TRUE)) == false) goto L22;
        IAction r100 = this.f50321x2;
        if (r100 == null) goto L9;
        boolean r101 = !SlcTemplateContext.k(this.f50260a, r100, null, 6).getDisable();
    L10:
        if (r101 == true) goto L25;
        IAction r102 = this.f50325y2;
        if (r102 == null) goto L14;
        boolean r103 = !SlcTemplateContext.k(this.f50260a, r102, null, 6).getDisable();
    L15:
        if (r103 == false) goto L17;
        return true;
    L17:
        if (T().length() <= 0) goto L19;
        boolean r104 = true;
    L20:
        if (r104 == false) goto L22;
        return true;
    L19:
        r104 = false;
        goto L20
    L14:
        r103 = false;
        goto L15
    L25:
        return true;
    L9:
        r101 = false;
    L22:
        return false;
    }

    public final boolean q0() {
        View r100 = X();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isAttachedToWindow() != true) goto L7;
        return true;
    }

    public final boolean s0() {
        if (r0() == true) goto L14;
        Object r100 = this.f50294n;
        if (r100 != null) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == true) goto L15;
        return false;
    L15:
        return true;
    L7:
        if ("hidden".equals(r100) == false) goto L9;
        r101 = true;
        goto L10
    L14:
        return true;
    }

    public void D0() {
        K0();
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.g
    public final SlcTemplateContext getTemplateContext() {
        return this.f50260a;
    }

    public BaseSlcViewManager(SlcTemplateContext r100) {
        this.f50260a = r100;
        this.f50298p = true;
        this.L = Float.valueOf(1.0f);
        this.G2 = CollectionsKt.emptyList();
        this.f50272f = B0();
        this.F3 = LazyKt.lazy(new BaseSlcViewManager$devToolsId$2(this));
    }

    public static int j1(YogaMeasureMode r100) {
        int r101 = com.bytedance.android.ecom.arch.slice.render.elements.c.f50404a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return Integer.MIN_VALUE;
    L5:
        if (r101 == 2) goto L7;
        return 0;
    L7:
        return 1073741824;
    }

    public void A(ArrayList r100) {
        SlcElement r101 = this.f50270e;
        if (r101 == null) goto L55;
        com.bytedance.android.ecom.arch.slice.render.bindinfo.d r102 = r101.bindInfo;
        if (r102 == null) goto L7;
        Map<String, String> r103 = r102.f50137h;
    L8:
        boolean r104 = false;
        if (r103 != null) goto L11;
    L14:
        boolean r105 = true;
    L15:
        if (r105 == false) goto L17;
        return;
    L17:
        if (this.S1 == false) goto L27;
        Map<String, ? extends Object> r106 = this.T1;
        if (r106 != null) goto L21;
    L24:
        boolean r107 = true;
    L25:
        if (r107 == false) goto L27;
        return;
    L21:
        if (((HashMap) r106).isEmpty() == true) goto L24;
        r107 = false;
    L27:
        if (r0() == false) goto L29;
        return;
    L29:
        if (s0() == false) goto L32;
        return;
    L32:
        if (this.S1 == true) goto L49;
        this.S1 = true;
        Map<String, Object> r108 = r101.getStorage();
        if (r108 != null) goto L36;
    L39:
        boolean r109 = true;
    L40:
        if (r109 == false) goto L48;
        if (r103 != null) goto L43;
    L44:
        r104 = true;
    L45:
        if (r104 == false) goto L48;
        this.T1 = null;
        return;
    L43:
        if (r103.isEmpty() == false) goto L45;
    L48:
        this.T1 = com.bytedance.android.ecom.arch.slice.render.util.b.w(r108, this.f50260a.f(r103, l()));
        goto L49
    L36:
        if (r108.isEmpty() == true) goto L39;
        r109 = false;
    L49:
        Map<String, ? extends Object> r110 = this.T1;
        if (r110 == null) goto L59;
        Object r111 = ((HashMap) r110).get("show_event");
        if (r111 == null) goto L60;
        r100.add(r111);
        return;
    L60:
        return;
    L59:
        return;
    L11:
        if (r103.isEmpty() == true) goto L14;
        r105 = false;
        goto L15
    L7:
        r103 = null;
        goto L8
    }

    public final boolean B(Rect r110) {
        ViewParent r100 = getView().getParent();
        if ((r100 instanceof ViewGroup) == true) goto L5;
        r100 = null;
    L5:
        final ViewGroup r101 = (ViewGroup) r100;
        if (r101 != null) goto L8;
    L59:
        return false;
    L8:
        if ((r101 instanceof SlcRootView) == false) goto L12;
        return r101.getChildVisibleRect(getView(), r110, null);
    L12:
        if ((r101 instanceof SlcItemView) == false) goto L58;
        Lazy r102 = this.f50260a.f50235w.f50179i0;
        KProperty r103 = SlcRenderContext.f50160n0[6];
        RectF r104 = (RectF) r102.getValue();
        r104.set(r110);
        if (l0() == true) goto L16;
        e0().mapRect(r104);
    L16:
        SlcItemView r105 = (SlcItemView) r101;
        r104.offset(com.bytedance.android.ecom.arch.slice.render.util.b.c(Integer.valueOf(getView().getLeft() - r105.getScrollX()), 0.0f), com.bytedance.android.ecom.arch.slice.render.util.b.c(Integer.valueOf(getView().getTop() - r105.getScrollY()), 0.0f));
        if (Z() == true) goto L19;
    L21:
        boolean r106 = true;
    L22:
        r110.set((int) Math.floor(r104.left), (int) Math.floor(r104.top), (int) Math.ceil(r104.right), (int) Math.ceil(r104.bottom));
        if (r106 == true) goto L25;
        return false;
    L25:
        ViewParent r107 = r105.getParent();
        if ((r107 instanceof ViewGroup) == true) goto L28;
        r107 = null;
    L28:
        ViewGroup r108 = (ViewGroup) r107;
        if (r108 == null) goto L31;
        BaseSlcViewManager<?> r109 = SlcViewExtensionsKt.g(r108);
    L32:
        if (r109 != null) goto L34;
        nq.a.c(null, new BaseSlcViewManager$dealRootViewManager$1(this), 1);
        return false;
    L34:
        if (r109.s0() == false) goto L36;
        return false;
    L36:
        r104.set(r110);
        r104.offset(com.bytedance.android.ecom.arch.slice.render.util.b.c(Integer.valueOf(r105.getLeft() - r109.h0()), 0.0f), com.bytedance.android.ecom.arch.slice.render.util.b.c(Integer.valueOf(r105.getTop() - r109.i0()), 0.0f));
        BaseSlcViewGroupManager<?> r111 = r109.f50268d;
        if (r109.Z() == false) goto L42;
        if (r104.intersect(0.0f, 0.0f, com.bytedance.android.ecom.arch.slice.render.util.b.c(Integer.valueOf(r109.j0()), 0.0f), com.bytedance.android.ecom.arch.slice.render.util.b.c(Integer.valueOf(r109.c0()), 0.0f)) == true) goto L42;
        r106 = false;
    L42:
        if (r108.getClipToPadding() == true) goto L44;
    L48:
        r110.set((int) Math.floor(r104.left), (int) Math.floor(r104.top), (int) Math.ceil(r104.right), (int) Math.ceil(r104.bottom));
        if (r106 == true) goto L51;
        return false;
    L51:
        if (r111 == null) goto L55;
        return r111.t1(r109, r110);
    L55:
        return r109.B(r110);
    L44:
        if ((((r108.getPaddingLeft() | r108.getPaddingTop()) | r108.getPaddingRight()) | r108.getPaddingBottom()) == 0) goto L48;
        if (r104.intersect(com.bytedance.android.ecom.arch.slice.render.util.b.c(Integer.valueOf(r108.getPaddingLeft()), 0.0f), com.bytedance.android.ecom.arch.slice.render.util.b.c(Integer.valueOf(r108.getPaddingTop()), 0.0f), r108.getWidth() - com.bytedance.android.ecom.arch.slice.render.util.b.c(Integer.valueOf(r108.getPaddingRight()), 0.0f), r108.getHeight() - com.bytedance.android.ecom.arch.slice.render.util.b.c(Integer.valueOf(r108.getPaddingBottom()), 0.0f)) == true) goto L48;
        r106 = false;
        goto L48
    L31:
        r109 = null;
        goto L32
    L19:
        if (r104.intersect(0.0f, 0.0f, com.bytedance.android.ecom.arch.slice.render.util.b.c(Integer.valueOf(r105.getWidth()), 0.0f), com.bytedance.android.ecom.arch.slice.render.util.b.c(Integer.valueOf(r105.getHeight()), 0.0f)) == true) goto L21;
        r106 = false;
        goto L22
    L58:
        nq.a.c(null, new BaseSlcViewManager$dealRootViewManager$2(this, r101), 1);
        goto L59
    }

    public com.bytedance.android.ecom.arch.slice.render.util.accessibility.b E(MotionEvent r100) {
        if (o0() == true) goto L5;
        return null;
    L5:
        return new com.bytedance.android.ecom.arch.slice.render.util.accessibility.b(this, false);
    }

    public void F(MotionEvent r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f50295n3 == false) goto L39;
        int r101 = r100.getActionMasked();
        if (r101 == 0) goto L28;
        if (r101 == 1) goto L16;
        if (r101 == 3) goto L16;
        if (r101 == 5) goto L28;
        if (r101 == 6) goto L16;
        return;
    L16:
        if (this.f50302p3 == 0) goto L40;
        ArrayList<Integer> r102 = this.f50304q3;
        if (r102 != null) goto L21;
        r102 = new ArrayList(1);
        this.f50304q3 = r102;
    L21:
        if (r102.remove(Integer.valueOf(r100.getPointerId(r100.getActionIndex()))) == false) goto L41;
        ArrayList<Integer> r103 = this.f50304q3;
        if (r103 != null) goto L26;
        r103 = new ArrayList(1);
        this.f50304q3 = r103;
    L26:
        if (r103.isEmpty() == false) goto L42;
        this.f50302p3 = 0;
        G(false);
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L28:
        ArrayList<Integer> r104 = this.f50304q3;
        if (r104 != null) goto L31;
        r104 = new ArrayList(1);
        this.f50304q3 = r104;
    L31:
        r104.add(Integer.valueOf(r100.getPointerId(r100.getActionIndex())));
        if (this.f50302p3 != 0) goto L44;
        long r105 = com.bytedance.android.ecom.arch.slice.render.util.b.l(this.f50297o3, 0);
        if (r105 <= 0) goto L36;
        this.f50302p3 = 1;
        Function0<Unit> r106 = new BaseSlcViewManager$dispatchTouchEvent$1(this);
        com.bytedance.android.ecom.arch.slice.render.util.h.f50743a.postDelayed(new com.bytedance.android.ecom.arch.slice.render.util.g(r106), r105);
        return;
    L36:
        this.f50302p3 = 2;
        G(true);
        return;
    L44:
        return;
    }

    public final void G(boolean r100) {
        Map<String, ? extends Object> r101 = this.f50314v1;
        if (r101 == null) goto L96;
        Iterator<Map.Entry<String, ? extends Object>> r102 = r101.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L123;
        Map.Entry<String, ? extends Object> r103 = r102.next();
        String r104 = r103.getKey();
        Object r105 = r103.getValue();
        if (r105 == null) goto L6;
        Object r106 = null;
        boolean r107 = false;
        int r108 = 0;
        switch(r104.hashCode()) {
            case -1391253303: goto L46;
            case -1267206133: goto L40;
            case -1265068311: goto L23;
            case 1406540266: goto L13;
            default: goto L6;
        };
    L13:
        if (r104.equals("bg_gradient") == false) goto L6;
        if (r100 == true) goto L18;
        r105 = this.F;
    L18:
        if ((r105 instanceof Map) == false) goto L21;
        r106 = r105;
    L21:
        K().r(uq.b.b((Map) r106));
        goto L6
    L23:
        if (r104.equals("bg_color") == false) goto L6;
        if (r100 == true) goto L28;
        r105 = this.A;
    L28:
        if ((r105 instanceof String) == false) goto L31;
        r106 = r105;
    L31:
        SlcBackgroundDrawable r109 = K();
        Integer r110 = com.bytedance.android.ecom.arch.slice.render.util.b.g((String) r106);
        if (r110 == null) goto L34;
        int r111 = r110.intValue();
    L35:
        Integer r112 = Integer.valueOf(r111);
        if (r112 == null) goto L38;
        r108 = r112.intValue();
    L38:
        r109.f50849a = r108;
        r109.c().setColor(r109.f50849a);
        r109.invalidateSelf();
        goto L6
    L34:
        r111 = 0;
        goto L35
    L40:
        if (r104.equals(GXTemplateKey.STYLE_OPACITY) == false) goto L6;
        if (r100 == true) goto L44;
        r105 = this.f50287k0;
    L44:
        S0(com.bytedance.android.ecom.arch.slice.render.util.b.e(r105));
        goto L6
    L46:
        if (r104.equals("bg_img") == false) goto L6;
        if (r100 == true) goto L51;
        r105 = this.B;
    L51:
        if ((r105 instanceof String) == true) goto L53;
        r105 = null;
    L53:
        String r113 = (String) r105;
        SlcBackgroundDrawable r114 = K();
        if (r113 != null) goto L56;
    L59:
        boolean r115 = true;
    L60:
        if (r115 == true) goto L61;
        if (r114.f50866r == null) goto L79;
        boolean r116 = true;
    L80:
        if (r116 == true) goto L91;
        SlcTemplateContext r117 = this.f50260a;
        SlcImageFetchManager r118 = r114.t(r117.f50235w, r117.q(null));
        if (q0() == false) goto L84;
        r118.g();
    L84:
        BaseSlcViewManager<VType>.b r119 = this.E3;
        if (r119 != null) goto L89;
        r119 = new b(this);
        this.E3 = r119;
        View r120 = X();
        if (r120 == null) goto L89;
        r120.addOnAttachStateChangeListener(r119);
    L89:
        r119.f50331b = true;
    L91:
        if (r114.f50866r == null) goto L93;
        r107 = true;
    L93:
        nq.a.e(r107, null, 6);
        SlcImageFetchManager r121 = r114.f50866r;
        if (r121 == null) goto L6;
        r121.a(r113, r114.f50855g);
        goto L6
    L79:
        r116 = false;
        goto L80
    L61:
        BaseSlcViewManager<VType>.b r122 = this.E3;
        if (r122 == null) goto L69;
        r122.f50331b = false;
        if ((true ^ r122.f50330a) == false) goto L69;
        View r123 = X();
        if (r123 == null) goto L68;
        r123.removeOnAttachStateChangeListener(r122);
    L68:
        this.E3 = null;
    L69:
        SlcImageFetchManager r124 = r114.f50866r;
        if (r124 == null) goto L72;
        r124.h();
    L72:
        SlcImageFetchManager r125 = r114.f50866r;
        if (r125 == null) goto L75;
        r125.f50370n = null;
    L75:
        r114.f50866r = null;
        goto L6
    L56:
        if (r113.length() == 0) goto L59;
        r115 = false;
        goto L60
    L123:
        return;
    }

    public void L0(SlcTemplateContext r100) {
        this.f50260a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseSlcViewManager<?> M(String r100) {
        String r101 = d0();
        if (r101 == null) goto L10;
        if (r100 == null) goto L9;
        if (r100.equals(r101) == false) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == false) goto L13;
        return this;
    L13:
        return null;
    L9:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
    L10:
        r102 = false;
        goto L11
    }

    public final void M0(float r100) {
        if (r100 > 0) goto L5;
        r100 = FloatCompanionObject.INSTANCE.getNaN();
    L5:
        this.f50272f.setAspectRatio(r100);
        J0();
    }

    public final void O(Canvas r110) {
        int r100 = r110.save();
        boolean r101 = r110.isHardwareAccelerated();     // Catch: Throwable -> L11 Exception -> L13
        SliceRender.f50121o.getClass();     // Catch: Throwable -> L11 Exception -> L13
        if (SliceRender.f() == false) goto L6;
        boolean r102 = Z();     // Catch: Throwable -> L11 Exception -> L13
    L16:
        if (r101 == false) goto L39;
        boolean r103 = this.f50310t3;     // Catch: Throwable -> L11 Exception -> L13
        this.f50310t3 = false;     // Catch: Throwable -> L11 Exception -> L13
        if (r103 == false) goto L20;
    L30:
        wq.a r104 = g0();     // Catch: Throwable -> L11 Exception -> L13
        RecordingCanvas r105 = ((xq.a) r104).f564791b.beginRecording(j0(), c0());     // Catch: Throwable -> L11 Exception -> L13
        SlcBackgroundDrawable r106 = this.f50274g;     // Catch: Throwable -> L11 Exception -> L13
        ((xq.a) g0()).f564791b.setClipToBounds(r102);     // Catch: Throwable -> L11 Exception -> L13
        if (r106 == null) goto L35;
        I(r106, Y());     // Catch: Throwable -> L11 Exception -> L13
        if (Y().a() == false) goto L35;
        r105.drawRenderNode(((xq.a) Y()).f564791b);     // Catch: Throwable -> L11 Exception -> L13
    L35:
        J(r105);     // Catch: Throwable -> L11 Exception -> L13
        D(r105);     // Catch: Throwable -> L11 Exception -> L13
        ((xq.a) g0()).f564791b.endRecording();     // Catch: Throwable -> L11 Exception -> L13
    L37:
        if (g0().a() == false) goto L64;
        r110.drawRenderNode(((xq.a) g0()).f564791b);     // Catch: Throwable -> L11 Exception -> L13
    L64:
        r110.restoreToCount(r100);
        return;
    L20:
        if (g0().a() == false) goto L30;
        if ((this instanceof BaseSlcViewGroupManager) == false) goto L37;
        wq.a r107 = g0();     // Catch: Throwable -> L11 Exception -> L13
        RecordingCanvas r108 = ((xq.a) r107).f564791b.beginRecording(j0(), c0());     // Catch: Throwable -> L11 Exception -> L13
        if (this.f50274g != null) goto L27;
    L29:
        D(r108);     // Catch: Throwable -> L11 Exception -> L13
        ((xq.a) g0()).f564791b.endRecording();     // Catch: Throwable -> L11 Exception -> L13
        goto L37
    L27:
        if (Y().a() == false) goto L29;
        r108.drawRenderNode(((xq.a) Y()).f564791b);     // Catch: Throwable -> L11 Exception -> L13
        goto L29
    L39:
        r110.translate(this.f50272f.getLayoutX(), this.f50272f.getLayoutY());     // Catch: Throwable -> L11 Exception -> L13
        if (l0() == true) goto L42;
        r110.concat(e0());     // Catch: Throwable -> L11 Exception -> L13
    L42:
        float r109 = ((xq.a) g0()).f564791b.getAlpha();     // Catch: Throwable -> L11 Exception -> L13
        if (r109 < 1.0f) goto L45;
    L55:
        if (r102 == false) goto L57;
        r110.clipRect(0, 0, j0(), c0());     // Catch: Throwable -> L11 Exception -> L13
    L57:
        SlcBackgroundDrawable r111 = this.f50274g;     // Catch: Throwable -> L11 Exception -> L13
        if (r111 == null) goto L60;
        r111.draw(r110);     // Catch: Throwable -> L11 Exception -> L13
    L60:
        J(r110);     // Catch: Throwable -> L11 Exception -> L13
        D(r110);     // Catch: Throwable -> L11 Exception -> L13
        goto L64
    L45:
        if (this.f50306r3 == false) goto L48;
        float r112 = this.f50272f.getLayoutWidth();     // Catch: Throwable -> L11 Exception -> L13
    L47:
        float r113 = r112;
        if (this.f50306r3 == false) goto L53;
        float r114 = this.f50272f.getLayoutHeight();     // Catch: Throwable -> L11 Exception -> L13
    L54:
        r110.saveLayerAlpha(0.0f, 0.0f, r113, r114, (int) (r109 * 255));     // Catch: Throwable -> L11 Exception -> L13
        goto L55
    L53:
        r114 = com.bytedance.android.ecom.arch.slice.render.util.b.c(Integer.valueOf(getView().getHeight()), 0.0f);     // Catch: Throwable -> L11 Exception -> L13
        goto L54
    L48:
        r112 = com.bytedance.android.ecom.arch.slice.render.util.b.c(Integer.valueOf(getView().getWidth()), 0.0f);     // Catch: Throwable -> L11 Exception -> L13
        goto L47
    L6:
        BaseSlcViewGroupManager<?> r115 = this.f50268d;     // Catch: Throwable -> L11 Exception -> L13
        if (r115 != null) goto L9;
    L15:
        r102 = false;
        goto L16
    L9:
        if ((!Intrinsics.areEqual(r115.f50327z, "visible")) != true) goto L15;
        r102 = true;
    L13:
        e = move-exception;
        nq.a.c(e, null, 2);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        r110.restoreToCount(r100);
        throw th;
    }

    public final void O0(float r100) {
        if (this.f50306r3 == false) goto L5;
        ((xq.a) g0()).f564791b.setRotationZ(r100);
        return;
    L5:
        getView().setRotation(r100);
    }

    public boolean P(Drawable r100) {
        return Intrinsics.areEqual(this.f50274g, r100);
    }

    public void Q0(String r100) {
        this.f50272f.setAlignItems(com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.a(r100, YogaAlign.STRETCH));
        J0();
    }

    public final float R(uq.a r100) {
        if (r100 == null) goto L12;
        int r101 = r100.f551168b;
        if (r101 == 1) goto L11;
        if (r101 == 2) goto L13;
        return 0.0f;
    L13:
        return this.f50272f.getLayoutWidth() * (r100.f551167a / 100);
    L11:
        return r100.f551167a;
    L12:
        return 0.0f;
    }

    public void R0(String r100) {
        YogaNode r101 = this.f50272f;
        int r102 = com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.f51025a;
        if (r100 != null) goto L6;
    L26:
        YogaJustify r103 = YogaJustify.FLEX_START;
    L27:
        r101.setJustifyContent(r103);
        J0();
        return;
    L6:
        switch(r100.hashCode()) {
            case -1364013995: goto L24;
            case -46581362: goto L21;
            case 441309761: goto L18;
            case 1742952711: goto L15;
            case 1937124468: goto L12;
            case 2055030478: goto L9;
            default: goto L26;
        };
    L9:
        if (r100.equals("space-evenly") == false) goto L26;
        r103 = YogaJustify.SPACE_EVENLY;
        goto L27
    L12:
        if (r100.equals("space-around") == false) goto L26;
        r103 = YogaJustify.SPACE_AROUND;
        goto L27
    L15:
        if (r100.equals("flex-end") == false) goto L26;
        r103 = YogaJustify.FLEX_END;
        goto L27
    L18:
        if (r100.equals("space-between") == false) goto L26;
        r103 = YogaJustify.SPACE_BETWEEN;
        goto L27
    L21:
        if (r100.equals("flex-start") == false) goto L26;
        r103 = YogaJustify.FLEX_START;
        goto L27
    L24:
        if (r100.equals("center") == false) goto L26;
        r103 = YogaJustify.CENTER;
        goto L27
    }

    public final float S(uq.a r100) {
        if (r100 == null) goto L12;
        int r101 = r100.f551168b;
        if (r101 == 1) goto L11;
        if (r101 == 2) goto L13;
        return 0.0f;
    L13:
        return this.f50272f.getLayoutHeight() * (r100.f551167a / 100);
    L11:
        return r100.f551167a;
    L12:
        return 0.0f;
    }

    public final void S0(Float r100) {
        if (z(GXTemplateKey.STYLE_OPACITY, r100) == true) goto L15;
        float r101 = 1.0f;
        if (this.f50306r3 == false) goto L10;
        wq.a r102 = g0();
        if (r100 == null) goto L9;
        r101 = r100.floatValue();
    L9:
        ((xq.a) r102).f564791b.setAlpha(r101);
        return;
    L10:
        View r103 = getView();
        if (r100 == null) goto L13;
        r101 = r100.floatValue();
    L13:
        r103.setAlpha(r101);
        return;
    }

    public void U0(List<Float> r100) {
        if (r100.isEmpty() == false) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        getView().setPadding(0, 0, 0, 0);
        return;
    L8:
        int r102 = r100.size();
        if (r102 != 1) goto L11;
        int r103 = SlcDimensExtensionsKt.a((Number) ListProtector.get(r100, 0), this.f50260a.m());
        getView().setPadding(r103, r103, r103, r103);
        return;
    L11:
        if (r102 != 2) goto L13;
        int r104 = SlcDimensExtensionsKt.a((Number) ListProtector.get(r100, 0), this.f50260a.m());
        int r105 = SlcDimensExtensionsKt.a((Number) ListProtector.get(r100, 1), this.f50260a.m());
        getView().setPadding(r105, r104, r105, r104);
        return;
    L13:
        if (r102 == 3) goto L15;
        int r106 = SlcDimensExtensionsKt.a((Number) ListProtector.get(r100, 0), this.f50260a.m());
        int r107 = SlcDimensExtensionsKt.a((Number) ListProtector.get(r100, 1), this.f50260a.m());
        int r108 = SlcDimensExtensionsKt.a((Number) ListProtector.get(r100, 2), this.f50260a.m());
        int r109 = SlcDimensExtensionsKt.a((Number) ListProtector.get(r100, 3), this.f50260a.m());
        getView().setPadding(r109, r106, r107, r108);
        return;
    L15:
        int r110 = SlcDimensExtensionsKt.a((Number) ListProtector.get(r100, 0), this.f50260a.m());
        int r111 = SlcDimensExtensionsKt.a((Number) ListProtector.get(r100, 1), this.f50260a.m());
        int r112 = SlcDimensExtensionsKt.a((Number) ListProtector.get(r100, 2), this.f50260a.m());
        getView().setPadding(r111, r110, r111, r112);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final Object V(String r100) {
        Map<String, ? extends Object> r101 = this.E2;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    public void a1(int r100) {
        if (this.f50306r3 == false) goto L14;
        int r101 = this.f50316v3;
        if (r101 == r100) goto L16;
        this.f50316v3 = r100;
        if (r100 == 8) goto L13;
        if (r101 == 8) goto L13;
        BaseSlcViewGroupManager<?> r102 = this.f50268d;
        if (r102 == null) goto L17;
        r102.n0();
        return;
    L17:
        return;
    L13:
        J0();
        return;
    L16:
        return;
    L14:
        getView().setVisibility(r100);
    }

    public final boolean b0(Rect r100) {
        if (s0() == false) goto L5;
    L17:
        return false;
    L5:
        if (q0() == false) goto L17;
        if (j0() <= 0) goto L17;
        if (c0() <= 0) goto L17;
        r100.set(0, 0, j0(), c0());
        BaseSlcViewGroupManager<?> r101 = this.f50268d;
        if (r101 == null) goto L16;
        return r101.t1(this, r100);
    L16:
        return B(r100);
    }

    public final void b1(boolean r100) {
        if (this.f50298p != r100) goto L5;
        boolean r101 = true;
    L7:
        if ((!r101) == false) goto L10;
        this.f50298p = r100;
        f1();
        return;
    L10:
        return;
    L5:
        r101 = false;
        goto L7
    }

    public final void e1(Map<String, ? extends Object> r100) {
        this.E2 = r100;
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        this.f50315v2 = r100.get("on_exposure");
        if (this.f50260a.f50235w.f50184l == true) goto L8;
    L12:
        G0(r100);
        return;
    L8:
        if (r100.get("on_touchdown") == null) goto L10;
    L11:
        getView().setOnTouchListener(new com.bytedance.android.ecom.arch.slice.render.util.j(this));
        goto L12
    L10:
        if (r100.get("on_touchup") == null) goto L12;
        goto L11
    }

    public final void g1(Map<String, ? extends Object> r110) {
        this.f50266c = r110;
        if (r110.isEmpty() == false) goto L6;
        return;
    L6:
        if (r110.isEmpty() == true) goto L108;
        Iterator<Map.Entry<String, ? extends Object>> r100 = r110.entrySet().iterator();
        boolean r101 = false;
        boolean r102 = false;
    L10:
        if (r100.hasNext() == false) goto L90;
        Map.Entry<String, ? extends Object> r103 = r100.next();
        String r104 = r103.getKey();
        Object r105 = r103.getValue();
        m r106 = null;
        switch(r104.hashCode()) {
            case -1320463578: goto L80;
            case -1197589088: goto L74;
            case -1161559213: goto L69;
            case -450820034: goto L64;
            case 3506294: goto L59;
            case 41213021: goto L49;
            case 90550069: goto L32;
            case 1173911478: goto L27;
            case 1640291426: goto L20;
            case 1999391600: goto L15;
            default: goto L10;
        };
    L15:
        if (r104.equals("active_style_delay_time") == false) goto L10;
        if ((true ^ Intrinsics.areEqual(this.f50297o3, r105)) == false) goto L10;
        this.f50297o3 = r105;
        goto L10
    L20:
        if (r104.equals("a11y_id") == false) goto L10;
        if ((true ^ Intrinsics.areEqual(null, r105)) == false) goto L10;
        if (this.f50306r3 == true) goto L10;
        getView().setId(com.bytedance.android.ecom.arch.slice.render.util.b.f(r105, -1));
        goto L10
    L27:
        if (r104.equals("animation_id") == false) goto L10;
        if ((true ^ Intrinsics.areEqual(this.Y2, r105)) == false) goto L10;
        this.Y2 = r105;
        goto L10
    L32:
        if (r104.equals("bg_img_preferred_size") == false) goto L10;
        if ((!Intrinsics.areEqual(this.f50292m, r105)) == false) goto L10;
        this.f50292m = r105;
        this.f50276g2 = true;
        SlcBackgroundDrawable r107 = K();
        boolean r108 = com.bytedance.android.ecom.arch.slice.render.util.e.f50736a;
        com.bytedance.android.ecom.arch.slice.render.context.b r109 = this.f50260a.m();
        if (r105 == null) goto L38;
        List<Integer> r111 = com.bytedance.android.ecom.arch.slice.render.util.b.h(r105);
    L39:
        if (r111 != null) goto L41;
    L47:
        r107.f50855g = r106;
        goto L10
    L41:
        if (r111.size() != 2) goto L47;
        if (((Number) ListProtector.get(r111, 0)).intValue() <= 0) goto L47;
        if (((Number) ListProtector.get(r111, 1)).intValue() <= 0) goto L47;
        r106 = new m(SlcDimensExtensionsKt.a((Number) ListProtector.get(r111, 0), r109), SlcDimensExtensionsKt.a((Number) ListProtector.get(r111, 1), r109));
        goto L47
    L38:
        r111 = null;
        goto L39
    L49:
        if (r104.equals("check_virtual_click") == false) goto L10;
        if ((true ^ Intrinsics.areEqual(this.M1, r105)) == false) goto L10;
        this.M1 = r105;
        if (this.f50306r3 == true) goto L10;
        if (com.bytedance.android.ecom.arch.slice.render.util.b.a(r105) == true) goto L56;
        getView().setOnTouchListener(null);
        goto L10
    L56:
        this.P1 = new com.bytedance.android.ecom.arch.slice.render.util.touch_delegate.a();
        getView().setOnTouchListener(this.P1);
        goto L10
    L59:
        if (r104.equals("role") == false) goto L10;
        if ((!Intrinsics.areEqual(this.f50282i, r105)) == false) goto L10;
        this.f50282i = r105;
    L78:
        r102 = true;
        goto L10
    L64:
        if (r104.equals("aria_label") == false) goto L10;
        if ((!Intrinsics.areEqual(this.f50286k, r105)) == false) goto L10;
        this.f50286k = r105;
        goto L78
    L69:
        if (r104.equals("exposure_id") == false) goto L10;
        if ((true ^ Intrinsics.areEqual(this.f50280h2, r105)) == false) goto L10;
        this.f50280h2 = r105;
        goto L10
    L74:
        if (r104.equals("aria_hidden") == false) goto L10;
        if ((!Intrinsics.areEqual(this.f50284j, r105)) == false) goto L10;
        this.f50284j = r105;
        goto L78
    L80:
        if (r104.equals("hit_slop") == false) goto L10;
        if ((true ^ Intrinsics.areEqual(null, r105)) == false) goto L10;
        if (this.f50306r3 == true) goto L10;
        List<Float> r112 = com.bytedance.android.ecom.arch.slice.render.util.b.d(r105);
        if (r112 != null) goto L89;
        r112 = CollectionsKt.emptyList();
    L89:
        this.G2 = r112;
        goto L10
    L90:
        if (r102 == false) goto L108;
        SliceRender.f50121o.getClass();
        if (SliceRender.b() == true) goto L108;
        if (this.f50306r3 == true) goto L108;
        if (com.bytedance.android.ecom.arch.slice.render.util.b.a(this.f50284j) == false) goto L98;
        AccessibilityManager r113 = com.bytedance.android.ecom.arch.slice.render.util.accessibility.a.f50727a;
        com.bytedance.android.ecom.arch.slice.render.util.accessibility.a.a(getView(), false);
        goto L108
    L98:
        AccessibilityManager r114 = com.bytedance.android.ecom.arch.slice.render.util.accessibility.a.f50727a;
        com.bytedance.android.ecom.arch.slice.render.util.accessibility.a.a(getView(), true);
        getView().setContentDescription(com.bytedance.android.ecom.arch.slice.render.util.b.r(this.f50286k));
        String r115 = com.bytedance.android.ecom.arch.slice.render.util.accessibility.a.b(com.bytedance.android.ecom.arch.slice.render.util.b.r(this.f50282i));
        if (r115 != null) goto L101;
    L102:
        r101 = true;
    L103:
        if (r101 == true) goto L108;
        View r116 = getView();
        final e r117 = new e(r101, r115);
        if (r116 == null) goto L108;
        ViewCompat.setAccessibilityDelegate(r116, new AccessibilityUtil$setAccessibilityDelegate$1(r117));
        goto L108
    L101:
        if (r115.length() != 0) goto L103;
    L108:
        H0(r110);
    }

    public final void i1(Map<String, ? extends Object> r110) {
        boolean r100 = false;
        if (r110 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return;
    L12:
        if (r110.isEmpty() == true) goto L562;
        com.bytedance.android.ecom.arch.slice.render.context.b r102 = this.f50260a.m();
        Iterator<Map.Entry<String, ? extends Object>> r103 = r110.entrySet().iterator();
        boolean r104 = false;
        boolean r105 = false;
        boolean r106 = false;
    L15:
        Object r107 = null;
        List<? extends Object> r108 = null;
        Object r109 = null;
        Object r111 = null;
        List<? extends Object> r112 = null;
        List<? extends Object> r113 = null;
        Object r114 = null;
        Object r115 = null;
        Object r116 = null;
        Object r117 = null;
        Object r118 = null;
        List<String> r119 = null;
        Object r120 = null;
        uq.a r121 = null;
        Object r122 = null;
        Object r123 = null;
        Object r124 = null;
        List<? extends Object> r125 = null;
        List<? extends Object> r126 = null;
        List<String> r127 = null;
        Object r128 = null;
        List<Float> r129 = null;
        Object r130 = null;
        Object r131 = null;
        Object r132 = null;
        List<String> r133 = null;
        r133 = null;
        Object r134 = null;
        Object r135 = null;
        List<? extends Object> r136 = null;
        List<Float> r137 = null;
        float r138 = 0.0f;
        if (r103.hasNext() == false) goto L538;
        Map.Entry<String, ? extends Object> r139 = r103.next();
        String r140 = r139.getKey();
        Object r141 = r139.getValue();
        switch(r140.hashCode()) {
            case -2105149843: goto L534;
            case -1990508226: goto L523;
            case -1926331128: goto L511;
            case -1756800871: goto L506;
            case -1756324656: goto L497;
            case -1517039783: goto L467;
            case -1447318938: goto L450;
            case -1391253303: goto L445;
            case -1383228885: goto L440;
            case -1267206133: goto L434;
            case -1265068311: goto L417;
            case -1246710908: goto L404;
            case -1221029593: goto L399;
            case -1081309778: goto L390;
            case -1066109415: goto L379;
            case -1042969530: goto L370;
            case -991637121: goto L359;
            case -938578798: goto L354;
            case -925180581: goto L349;
            case -887656757: goto L341;
            case -826243148: goto L336;
            case -806339567: goto L330;
            case -785704977: goto L318;
            case -680775054: goto L306;
            case -573585203: goto L301;
            case -540008775: goto L292;
            case -230974677: goto L287;
            case -199136998: goto L282;
            case -115006108: goto L277;
            case -29095665: goto L272;
            case 115029: goto L267;
            case 3317767: goto L262;
            case 108511772: goto L257;
            case 109250890: goto L248;
            case 113126854: goto L243;
            case 529642498: goto L238;
            case 541503897: goto L233;
            case 560904838: goto L228;
            case 560904839: goto L223;
            case 747804969: goto L214;
            case 996724834: goto L209;
            case 1052832078: goto L185;
            case 1088020803: goto L174;
            case 1313099890: goto L165;
            case 1363260874: goto L156;
            case 1368627320: goto L151;
            case 1386871537: goto L146;
            case 1406540266: goto L137;
            case 1507808255: goto L129;
            case 1671764162: goto L123;
            case 1723544976: goto L110;
            case 1738482654: goto L101;
            case 1741829107: goto L96;
            case 1885163890: goto L84;
            case 1919711204: goto L72;
            case 1941332754: goto L67;
            case 1956617535: goto L58;
            case 1985451019: goto L50;
            case 1985451020: goto L42;
            case 2018888198: goto L33;
            case 2073200772: goto L21;
            default: goto L15;
        };
    L21:
        if (r140.equals("animation_direction") == false) goto L15;
        if ((!Intrinsics.areEqual(this.U2, r141)) == false) goto L15;
        this.U2 = r141;
        HashMap<String, com.bytedance.android.ecom.arch.slice.render.widget.animation.a> r142 = com.bytedance.android.ecom.arch.slice.render.widget.animation.c.f50812e;
        if (r141 != null) goto L28;
    L31:
        this.f50271e3 = r108;
        goto L15
    L28:
        if ((r141 instanceof List) == false) goto L30;
        r108 = (List) r141;
        goto L31
    L30:
        r108 = CollectionsKt.listOf(r141);
        goto L31
    L33:
        if (r140.equals("align_items") == false) goto L15;
        if ((!Intrinsics.areEqual(this.Q, r141)) == false) goto L15;
        this.Q = r141;
        if ((r141 instanceof String) == false) goto L40;
        r109 = r141;
    L40:
        Q0((String) r109);
        goto L15
    L42:
        if (r140.equals("shadow_offset_y") == false) goto L15;
        if ((!Intrinsics.areEqual(this.f50324y1, r141)) == false) goto L15;
        this.f50324y1 = r141;
        SlcBackgroundDrawable r143 = K();
        Float r144 = com.bytedance.android.ecom.arch.slice.render.util.b.e(r141);
        if (r144 == null) goto L48;
        r138 = SlcDimensExtensionsKt.c(r144, this.f50260a.m());
    L48:
        r143.x(r138);
        goto L15
    L50:
        if (r140.equals("shadow_offset_x") == false) goto L15;
        if ((!Intrinsics.areEqual(this.f50320x1, r141)) == false) goto L15;
        this.f50320x1 = r141;
        SlcBackgroundDrawable r145 = K();
        Float r146 = com.bytedance.android.ecom.arch.slice.render.util.b.e(r141);
        if (r146 == null) goto L56;
        r138 = SlcDimensExtensionsKt.c(r146, this.f50260a.m());
    L56:
        r145.w(r138);
        goto L15
    L58:
        if (r140.equals("align_content") == false) goto L15;
        if ((!Intrinsics.areEqual(this.P, r141)) == false) goto L15;
        this.P = r141;
        if ((r141 instanceof String) == false) goto L65;
        r111 = r141;
    L65:
        com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.i(this.f50272f, (String) r111);
        J0();
        goto L15
    L67:
        if (r140.equals(RemoteMessageConst.Notification.VISIBILITY) == false) goto L15;
        if ((!Intrinsics.areEqual(this.f50294n, r141)) == false) goto L15;
        this.f50294n = r141;
    L127:
        r104 = true;
        goto L15
    L72:
        if (r140.equals("animation_fill_mode") == false) goto L15;
        if ((!Intrinsics.areEqual(this.X2, r141)) == false) goto L15;
        this.X2 = r141;
        HashMap<String, com.bytedance.android.ecom.arch.slice.render.widget.animation.a> r147 = com.bytedance.android.ecom.arch.slice.render.widget.animation.c.f50812e;
        if (r141 != null) goto L79;
    L82:
        this.f50281h3 = r112;
        goto L15
    L79:
        if ((r141 instanceof List) == false) goto L81;
        r112 = (List) r141;
        goto L82
    L81:
        r112 = CollectionsKt.listOf(r141);
        goto L82
    L84:
        if (r140.equals("animation_timing_function") == false) goto L15;
        if ((!Intrinsics.areEqual(this.V2, r141)) == false) goto L15;
        this.V2 = r141;
        HashMap<String, com.bytedance.android.ecom.arch.slice.render.widget.animation.a> r148 = com.bytedance.android.ecom.arch.slice.render.widget.animation.c.f50812e;
        if (r141 != null) goto L91;
    L94:
        this.f50273f3 = r113;
        goto L15
    L91:
        if ((r141 instanceof List) == false) goto L93;
        r113 = (List) r141;
        goto L94
    L93:
        r113 = CollectionsKt.listOf(r141);
        goto L94
    L96:
        if (r140.equals("border_width") == false) goto L15;
        if ((!Intrinsics.areEqual(this.D, r141)) == false) goto L15;
        this.D = r141;
        K().q(SlcDimensExtensionsKt.c(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.c(r141, 0.0f)), r102));
    L334:
        r105 = true;
        goto L15
    L101:
        if (r140.equals("border_style") == false) goto L15;
        if ((!Intrinsics.areEqual(this.E, r141)) == false) goto L15;
        this.E = r141;
        if ((r141 instanceof String) == false) goto L108;
        r114 = r141;
    L108:
        SlcViewExtensionsKt.l(this, r102, (String) r114);
        goto L15
    L110:
        if (r140.equals("border_color") == false) goto L15;
        if ((!Intrinsics.areEqual(this.C, r141)) == false) goto L15;
        this.C = r141;
        if ((r141 instanceof String) == false) goto L117;
        r115 = r141;
    L117:
        SlcBackgroundDrawable r149 = K();
        Integer r150 = com.bytedance.android.ecom.arch.slice.render.util.b.g((String) r115);
        if (r150 == null) goto L120;
        int r151 = r150.intValue();
    L121:
        r149.p(r151);
        goto L15
    L120:
        r151 = 0;
        goto L121
    L123:
        if (r140.equals("display") == false) goto L15;
        if ((!Intrinsics.areEqual(this.f50296o, r141)) == false) goto L15;
        this.f50296o = r141;
        goto L127
    L129:
        if (r140.equals("shadow_spread_radius") == false) goto L15;
        if ((!Intrinsics.areEqual(this.H1, r141)) == false) goto L15;
        this.H1 = r141;
        SlcBackgroundDrawable r152 = K();
        Float r153 = com.bytedance.android.ecom.arch.slice.render.util.b.e(r141);
        if (r153 == null) goto L135;
        r138 = SlcDimensExtensionsKt.c(r153, this.f50260a.m());
    L135:
        r152.y(r138);
        goto L15
    L137:
        if (r140.equals("bg_gradient") == false) goto L15;
        if ((!Intrinsics.areEqual(this.F, r141)) == false) goto L15;
        this.F = r141;
        if ((r141 instanceof Map) == false) goto L144;
        r116 = r141;
    L144:
        K().r(uq.b.b((Map) r116));
        goto L15
    L146:
        if (r140.equals("row_gap") == false) goto L15;
        if ((!Intrinsics.areEqual(this.U, r141)) == false) goto L15;
        this.U = r141;
        com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.m(this.f50272f, YogaGutter.ROW, this.f50260a.m(), r141);
        J0();
        goto L15
    L151:
        if (r140.equals("flex_basis") == false) goto L15;
        if ((!Intrinsics.areEqual(this.N, r141)) == false) goto L15;
        this.N = r141;
        com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.j(this.f50272f, this.f50260a.m(), r141);
        J0();
        goto L15
    L156:
        if (r140.equals("justify_content") == false) goto L15;
        if ((!Intrinsics.areEqual(this.R, r141)) == false) goto L15;
        this.R = r141;
        if ((r141 instanceof String) == false) goto L163;
        r117 = r141;
    L163:
        R0((String) r117);
        goto L15
    L165:
        if (r140.equals("background_size") == false) goto L15;
        if ((!Intrinsics.areEqual(this.f50259J, r141)) == false) goto L15;
        this.f50259J = r141;
        if ((r141 instanceof String) == false) goto L172;
        r118 = r141;
    L172:
        K().o(r102, (String) r118);
        goto L15
    L174:
        if (r140.equals("transition_timing_function") == false) goto L15;
        if ((!Intrinsics.areEqual(this.f50288k1, r141)) == false) goto L15;
        this.f50288k1 = r141;
        int r154 = uq.b.f551169a;
        if (r141 != null) goto L180;
    L183:
        this.O2 = r119;
        goto L15
    L180:
        if ((r141 instanceof List) == false) goto L182;
        r119 = com.bytedance.android.ecom.arch.slice.render.util.b.s(r141);
        goto L183
    L182:
        r119 = CollectionsKt.listOf(r141.toString());
        goto L183
    L185:
        if (r140.equals("translate") == false) goto L15;
        if ((!Intrinsics.areEqual(this.H0, r141)) == false) goto L15;
        this.H0 = r141;
        if ((r141 instanceof List) == true) goto L191;
        r141 = null;
    L191:
        List r155 = (List) r141;
        if (r155 == null) goto L194;
        int r156 = r155.size();
    L195:
        if (r156 <= 0) goto L201;
        SlcTemplateContext r157 = this.f50260a;
        if (r155 == null) goto L199;
        Object r158 = CollectionsKt.getOrNull(r155, 0);
    L200:
        uq.a r159 = uq.b.d(r157, r158);
    L202:
        if (r156 <= 1) goto L207;
        SlcTemplateContext r160 = this.f50260a;
        if (r155 == null) goto L206;
        r120 = CollectionsKt.getOrNull(r155, 1);
    L206:
        r121 = uq.b.d(r160, r120);
    L207:
        s(this, r159, r121);
        goto L15
    L199:
        r158 = null;
        goto L200
    L201:
        r159 = null;
        goto L202
    L194:
        r156 = 0;
        goto L195
    L209:
        if (r140.equals(TextureRenderKeys.KEY_IS_MAX_HEIGHT) == false) goto L15;
        if ((!Intrinsics.areEqual(this.f50309t, r141)) == false) goto L15;
        this.f50309t = r141;
        com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.n(this.f50272f, this.f50260a.m(), r141);
        J0();
        goto L15
    L214:
        if (r140.equals("position") == false) goto L15;
        if ((!Intrinsics.areEqual(this.V, r141)) == false) goto L15;
        this.V = r141;
        if ((r141 instanceof String) == false) goto L221;
        r122 = r141;
    L221:
        com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.s(this.f50272f, (String) r122);
        J0();
        goto L15
    L223:
        if (r140.equals("bg_offset_y") == false) goto L15;
        if ((!Intrinsics.areEqual(this.I, r141)) == false) goto L15;
        this.I = r141;
        K().l(SlcDimensExtensionsKt.c(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.c(r141, 0.0f)), r102));
        goto L15
    L228:
        if (r140.equals("bg_offset_x") == false) goto L15;
        if ((!Intrinsics.areEqual(this.H, r141)) == false) goto L15;
        this.H = r141;
        K().k(SlcDimensExtensionsKt.c(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.c(r141, 0.0f)), r102));
        goto L15
    L233:
        if (r140.equals("min_width") == false) goto L15;
        if ((!Intrinsics.areEqual(this.f50311u, r141)) == false) goto L15;
        this.f50311u = r141;
        com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.q(this.f50272f, this.f50260a.m(), r141);
        J0();
        goto L15
    L238:
        if (r140.equals("overflow") == false) goto L15;
        if ((!Intrinsics.areEqual(this.f50327z, r141)) == false) goto L15;
        this.f50327z = r141;
        this.f50293m3 = true;
    L438:
        r106 = true;
        goto L15
    L243:
        if (r140.equals("width") == false) goto L15;
        if ((!Intrinsics.areEqual(this.f50303q, r141)) == false) goto L15;
        this.f50303q = r141;
        SlcViewExtensionsKt.r(this, r141);
        goto L15
    L248:
        if (r140.equals("scale") == false) goto L15;
        if ((!Intrinsics.areEqual(this.L0, r141)) == false) goto L15;
        this.L0 = r141;
        if ((r141 instanceof List) == false) goto L255;
        r123 = r141;
    L255:
        List r161 = (List) r123;
        P0(uq.b.e(r161), uq.b.g(r161));
        goto L15
    L257:
        if (r140.equals("right") == false) goto L15;
        if ((!Intrinsics.areEqual(this.Y, r141)) == false) goto L15;
        this.Y = r141;
        com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.r(this.f50272f, this.f50260a.m(), YogaEdge.RIGHT, r141);
        J0();
        goto L15
    L262:
        if (r140.equals("left") == false) goto L15;
        if ((!Intrinsics.areEqual(this.W, r141)) == false) goto L15;
        this.W = r141;
        com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.r(this.f50272f, this.f50260a.m(), YogaEdge.LEFT, r141);
        J0();
        goto L15
    L267:
        if (r140.equals("top") == false) goto L15;
        if ((!Intrinsics.areEqual(this.X, r141)) == false) goto L15;
        this.X = r141;
        com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.r(this.f50272f, this.f50260a.m(), YogaEdge.TOP, r141);
        J0();
        goto L15
    L272:
        if (r140.equals("flex_shrink") == false) goto L15;
        if ((!Intrinsics.areEqual(this.L, r141)) == false) goto L15;
        this.L = r141;
        this.f50272f.setFlexShrink(com.bytedance.android.ecom.arch.slice.render.util.b.c(r141, 0.0f));
        J0();
        goto L15
    L277:
        if (r140.equals(TextureRenderKeys.KEY_IS_ASPECT_RATIO) == false) goto L15;
        if ((!Intrinsics.areEqual(this.f50263b1, r141)) == false) goto L15;
        this.f50263b1 = r141;
        M0(com.bytedance.android.ecom.arch.slice.render.util.b.c(r141, 0.0f));
        goto L15
    L282:
        if (r140.equals("background_position") == false) goto L15;
        if ((!Intrinsics.areEqual(this.G, r141)) == false) goto L15;
        this.G = r141;
        K().m(r141);
        goto L15
    L287:
        if (r140.equals(TextureRenderKeys.KEY_IS_MAX_WIDTH) == false) goto L15;
        if ((!Intrinsics.areEqual(this.f50307s, r141)) == false) goto L15;
        this.f50307s = r141;
        com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.o(this.f50272f, this.f50260a.m(), r141);
        J0();
        goto L15
    L292:
        if (r140.equals("flex_direction") == false) goto L15;
        if ((!Intrinsics.areEqual(this.O, r141)) == false) goto L15;
        this.O = r141;
        if ((r141 instanceof String) == false) goto L299;
        r124 = r141;
    L299:
        com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.k(this.f50272f, (String) r124);
        J0();
        goto L15
    L301:
        if (r140.equals("z_index") == false) goto L15;
        if ((!Intrinsics.areEqual(this.f50299p0, r141)) == false) goto L15;
        this.f50299p0 = r141;
        t(this, com.bytedance.android.ecom.arch.slice.render.util.b.f(r141, 0));
        goto L15
    L306:
        if (r140.equals("animation_iteration_count") == false) goto L15;
        if ((!Intrinsics.areEqual(this.W2, r141)) == false) goto L15;
        this.W2 = r141;
        HashMap<String, com.bytedance.android.ecom.arch.slice.render.widget.animation.a> r162 = com.bytedance.android.ecom.arch.slice.render.widget.animation.c.f50812e;
        if (r141 != null) goto L313;
    L316:
        this.f50277g3 = r125;
        goto L15
    L313:
        if ((r141 instanceof List) == false) goto L315;
        r125 = (List) r141;
        goto L316
    L315:
        r125 = CollectionsKt.listOf(r141);
        goto L316
    L318:
        if (r140.equals("animation_duration") == false) goto L15;
        if ((!Intrinsics.areEqual(this.S2, r141)) == false) goto L15;
        this.S2 = r141;
        HashMap<String, com.bytedance.android.ecom.arch.slice.render.widget.animation.a> r163 = com.bytedance.android.ecom.arch.slice.render.widget.animation.c.f50812e;
        if (r141 != null) goto L325;
    L328:
        this.f50267c3 = r126;
        goto L15
    L325:
        if ((r141 instanceof List) == false) goto L327;
        r126 = (List) r141;
        goto L328
    L327:
        r126 = CollectionsKt.listOf(r141);
        goto L328
    L330:
        if (r140.equals(GXTemplateKey.FLEXBOX_PADDING) == false) goto L15;
        if ((!Intrinsics.areEqual(this.f50319x, r141)) == false) goto L15;
        this.f50319x = r141;
        goto L334
    L336:
        if (r140.equals("min_height") == false) goto L15;
        if ((!Intrinsics.areEqual(this.f50313v, r141)) == false) goto L15;
        this.f50313v = r141;
        com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.p(this.f50272f, this.f50260a.m(), r141);
        J0();
        goto L15
    L341:
        if (r140.equals("shadow_blur_radius") == false) goto L15;
        if ((!Intrinsics.areEqual(this.G1, r141)) == false) goto L15;
        this.G1 = r141;
        SlcBackgroundDrawable r164 = K();
        Float r165 = com.bytedance.android.ecom.arch.slice.render.util.b.e(r141);
        if (r165 == null) goto L347;
        r138 = SlcDimensExtensionsKt.c(r165, this.f50260a.m());
    L347:
        r164.u(r138);
        goto L15
    L349:
        if (r140.equals("rotate") == false) goto L15;
        if ((!Intrinsics.areEqual(this.P0, r141)) == false) goto L15;
        this.P0 = r141;
        O0(com.bytedance.android.ecom.arch.slice.render.util.b.c(r141, 0.0f));
        goto L15
    L354:
        if (r140.equals("radius") == false) goto L15;
        if ((!Intrinsics.areEqual(this.f50323y, r141)) == false) goto L15;
        this.f50323y = r141;
        goto L438
    L359:
        if (r140.equals("transition_property") == false) goto L15;
        if ((!Intrinsics.areEqual(this.f50275g1, r141)) == false) goto L15;
        this.f50275g1 = r141;
        int r166 = uq.b.f551169a;
        if (r141 != null) goto L365;
    L368:
        this.L2 = r127;
        goto L15
    L365:
        if ((r141 instanceof List) == false) goto L367;
        r127 = com.bytedance.android.ecom.arch.slice.render.util.b.s(r141);
        goto L368
    L367:
        r127 = CollectionsKt.listOf(r141.toString());
        goto L368
    L370:
        if (r140.equals("align_self") == false) goto L15;
        if ((!Intrinsics.areEqual(this.M, r141)) == false) goto L15;
        this.M = r141;
        if ((r141 instanceof String) == false) goto L377;
        r128 = r141;
    L377:
        this.f50272f.setAlignSelf(com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.a((String) r128, YogaAlign.AUTO));
        J0();
        goto L15
    L379:
        if (r140.equals("transition_delay") == false) goto L15;
        if ((!Intrinsics.areEqual(this.f50300p1, r141)) == false) goto L15;
        this.f50300p1 = r141;
        int r167 = uq.b.f551169a;
        if (r141 != null) goto L385;
    L388:
        this.N2 = r129;
        goto L15
    L385:
        if ((r141 instanceof List) == false) goto L387;
        r129 = com.bytedance.android.ecom.arch.slice.render.util.b.d(r141);
        goto L388
    L387:
        r129 = CollectionsKt.listOf(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.c(r141, 0.0f)));
        goto L388
    L390:
        if (r140.equals(GXTemplateKey.FLEXBOX_MARGIN) == false) goto L15;
        if ((!Intrinsics.areEqual(this.f50317w, r141)) == false) goto L15;
        this.f50317w = r141;
        if ((r141 instanceof List) == false) goto L397;
        r130 = r141;
    L397:
        SlcViewExtensionsKt.q(this, (List) r130);
        goto L15
    L399:
        if (r140.equals("height") == false) goto L15;
        if ((!Intrinsics.areEqual(this.f50305r, r141)) == false) goto L15;
        this.f50305r = r141;
        SlcViewExtensionsKt.n(this, r141);
        goto L15
    L404:
        if (r140.equals("shadow_color") == false) goto L15;
        if ((!Intrinsics.areEqual(this.L1, r141)) == false) goto L15;
        this.L1 = r141;
        SlcBackgroundDrawable r168 = K();
        if ((r141 instanceof String) == false) goto L411;
        r131 = r141;
    L411:
        Integer r169 = com.bytedance.android.ecom.arch.slice.render.util.b.g((String) r131);
        if (r169 == null) goto L414;
        int r170 = r169.intValue();
    L415:
        r168.v(r170);
        goto L15
    L414:
        r170 = 0;
        goto L415
    L417:
        if (r140.equals("bg_color") == false) goto L15;
        if ((!Intrinsics.areEqual(this.A, r141)) == false) goto L15;
        this.A = r141;
        if ((r141 instanceof String) == false) goto L424;
        r132 = r141;
    L424:
        SlcBackgroundDrawable r171 = K();
        Integer r172 = com.bytedance.android.ecom.arch.slice.render.util.b.g((String) r132);
        if (r172 == null) goto L427;
        int r173 = r172.intValue();
    L428:
        Integer r174 = Integer.valueOf(r173);
        if (r174 == null) goto L431;
        int r175 = r174.intValue();
    L432:
        r171.f50849a = r175;
        r171.c().setColor(r171.f50849a);
        r171.invalidateSelf();
        goto L15
    L431:
        r175 = 0;
        goto L432
    L427:
        r173 = 0;
        goto L428
    L434:
        if (r140.equals(GXTemplateKey.STYLE_OPACITY) == false) goto L15;
        if ((!Intrinsics.areEqual(this.f50287k0, r141)) == false) goto L15;
        this.f50287k0 = r141;
        S0(com.bytedance.android.ecom.arch.slice.render.util.b.e(r141));
        goto L438
    L440:
        if (r140.equals("bottom") == false) goto L15;
        if ((!Intrinsics.areEqual(this.Z, r141)) == false) goto L15;
        this.Z = r141;
        com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.r(this.f50272f, this.f50260a.m(), YogaEdge.BOTTOM, r141);
        J0();
        goto L15
    L445:
        if (r140.equals("bg_img") == false) goto L15;
        if ((!Intrinsics.areEqual(this.B, r141)) == false) goto L15;
        this.B = r141;
        this.f50276g2 = true;
        goto L15
    L450:
        if (r140.equals("animation_name") == false) goto L15;
        if ((!Intrinsics.areEqual(this.R2, r141)) == false) goto L15;
        this.R2 = r141;
        this.f50265b3 = this.f50261a3;
        if ((r141 instanceof String) == false) goto L463;
        if (((CharSequence) r141).length() != 0) goto L458;
        boolean r176 = true;
    L459:
        if (r176 == true) goto L465;
        r133 = CollectionsKt.listOf(r141);
    L465:
        this.f50261a3 = r133;
        this.Z2 = true;
        goto L15
    L458:
        r176 = false;
        goto L459
    L463:
        if ((r141 instanceof List) == false) goto L465;
        r133 = com.bytedance.android.ecom.arch.slice.render.util.b.p(r141);
        goto L465
    L467:
        if (r140.equals("transform_origin") == false) goto L15;
        if ((!Intrinsics.areEqual(this.V0, r141)) == false) goto L15;
        this.V0 = r141;
        if ((r141 instanceof List) == false) goto L474;
        r134 = r141;
    L474:
        List r177 = (List) r134;
        List r178 = r177;
        if (r178 != null) goto L477;
    L480:
        boolean r179 = true;
    L482:
        if (r179 == true) goto L495;
        if (r177.size() < 2) goto L495;
        uq.a r180 = uq.b.d(this.f50260a, ListProtector.get(r177, 0));
        if (r180 != null) goto L490;
        r180 = new uq.a(50.0f, 2);
    L490:
        uq.a r181 = uq.b.d(this.f50260a, ListProtector.get(r177, 1));
        if (r181 != null) goto L494;
        r181 = new uq.a(50.0f, 2);
    L494:
        r(this, r180, r181);
    L495:
        uq.a r182 = new uq.a(50.0f, 2);
        r(this, r182, r182);
        goto L15
    L477:
        if (r178.isEmpty() == true) goto L480;
        r179 = false;
        goto L482
    L497:
        if (r140.equals("flex_wrap") == false) goto L15;
        if ((!Intrinsics.areEqual(this.S, r141)) == false) goto L15;
        this.S = r141;
        if ((r141 instanceof String) == false) goto L504;
        r135 = r141;
    L504:
        com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.l(this.f50272f, (String) r135);
        J0();
        goto L15
    L506:
        if (r140.equals("flex_grow") == false) goto L15;
        if ((!Intrinsics.areEqual(this.K, r141)) == false) goto L15;
        this.K = r141;
        this.f50272f.setFlexGrow(com.bytedance.android.ecom.arch.slice.render.util.b.c(r141, 0.0f));
        J0();
        goto L15
    L511:
        if (r140.equals("animation_delay") == false) goto L15;
        if ((!Intrinsics.areEqual(this.T2, r141)) == false) goto L15;
        this.T2 = r141;
        HashMap<String, com.bytedance.android.ecom.arch.slice.render.widget.animation.a> r183 = com.bytedance.android.ecom.arch.slice.render.widget.animation.c.f50812e;
        if (r141 != null) goto L518;
    L521:
        this.f50269d3 = r136;
        goto L15
    L518:
        if ((r141 instanceof List) == false) goto L520;
        r136 = (List) r141;
        goto L521
    L520:
        r136 = CollectionsKt.listOf(r141);
        goto L521
    L523:
        if (r140.equals("transition_duration") == false) goto L15;
        if ((!Intrinsics.areEqual(this.f50279h1, r141)) == false) goto L15;
        this.f50279h1 = r141;
        int r184 = uq.b.f551169a;
        if (r141 != null) goto L529;
    L532:
        this.M2 = r137;
        goto L15
    L529:
        if ((r141 instanceof List) == false) goto L531;
        r137 = com.bytedance.android.ecom.arch.slice.render.util.b.d(r141);
        goto L532
    L531:
        r137 = CollectionsKt.listOf(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.c(r141, 0.0f)));
        goto L532
    L534:
        if (r140.equals("column_gap") == false) goto L15;
        if ((!Intrinsics.areEqual(this.T, r141)) == false) goto L15;
        this.T = r141;
        com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.m(this.f50272f, YogaGutter.COLUMN, this.f50260a.m(), r141);
        J0();
        goto L15
    L538:
        if (r104 == false) goto L540;
        f1();
    L540:
        if (r105 == false) goto L545;
        Object r185 = this.f50319x;
        if ((r185 instanceof List) == true) goto L544;
        r185 = null;
    L544:
        V0((List) r185, com.bytedance.android.ecom.arch.slice.render.util.b.c(this.D, 0.0f));
    L545:
        if (r106 == false) goto L562;
        Object r186 = this.f50323y;
        if ((r186 instanceof List) == false) goto L550;
        r107 = r186;
    L550:
        List<?> r187 = (List) r107;
        String r188 = com.bytedance.android.ecom.arch.slice.render.util.b.r(this.f50327z);
        float r189 = f0();
        if (r188 != null) goto L553;
    L555:
        boolean r190 = false;
    L556:
        W0(r187, !r190);
        if (this.f50293m3 == false) goto L562;
        if (r189 >= 1.0f) goto L561;
        r100 = true;
    L561:
        T0(r188, r100);
        goto L562
    L553:
        if ("visible".equals(r188) == false) goto L555;
        r190 = true;
    L562:
        I0(r110);
        return;
    L5:
        if (r110.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        if (P(r100) == false) goto L6;
        n0();
        return;
    }

    public final void m0(SlcElement r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f50270e = r100;
        if (this.V1 == false) goto L7;
        return;
    L7:
        boolean r101 = true;
        this.V1 = true;
        IAction r102 = r100.getClickAction();
        if (r102 == null) goto L10;
        this.f50321x2 = r102;
        SlcViewExtensionsKt.m(this, r102);
    L10:
        IAction r103 = r100.getLongClickAction();
        if (r103 == null) goto L14;
        this.f50325y2 = r103;
        SlcViewExtensionsKt.o(this, r103);
    L14:
        if (this.f50306r3 == false) goto L16;
    L18:
        BaseSlcViewGroupManager<?> r104 = this.f50268d;
        if (r104 == null) goto L21;
        r104.C1(this);
    L21:
        com.bytedance.android.ecom.arch.slice.render.bindinfo.d r105 = r100.bindInfo;
        Map<String, String> r106 = null;
        if (r105 == null) goto L24;
        Map<String, String> r107 = r105.f50131b;
    L26:
        if (r107 != null) goto L28;
    L31:
        boolean r108 = true;
    L32:
        if (r108 == false) goto L34;
    L35:
        ISlcElement r109 = this.f50270e;
        if (r109 == null) goto L38;
        Map<String, Object> r110 = r109.getStyle();
    L39:
        i1(r110);
        this.f50264b2 = true;
    L40:
        if (r105 == null) goto L42;
        Map<String, String> r111 = r105.f50132c;
    L43:
        if (r111 != null) goto L45;
    L48:
        boolean r112 = true;
    L49:
        if (r112 == false) goto L62;
        SlcElement r113 = this.f50270e;
        if (r113 == null) goto L55;
        Map<String, ? extends Object> r114 = r113.getActiveStyle();
        if (r114 == null) goto L55;
    L57:
        if (r114.isEmpty() == true) goto L62;
        if ((!Intrinsics.areEqual(this.f50314v1, r114)) == false) goto L62;
        this.f50314v1 = r114;
    L55:
        r114 = MapsKt.emptyMap();
    L62:
        if (r105 == null) goto L64;
        Map<String, String> r115 = r105.f50136g;
    L65:
        if (r115 != null) goto L67;
    L70:
        boolean r116 = true;
    L71:
        if (r116 == false) goto L79;
        SlcElement r117 = this.f50270e;
        if (r117 == null) goto L77;
        Map<String, IAction> r118 = r117.getAction();
        if (r118 == null) goto L77;
    L78:
        e1(r118);
    L77:
        r118 = MapsKt.emptyMap();
    L79:
        if (r105 == null) goto L81;
        r106 = r105.f50130a;
    L81:
        if (r106 != null) goto L83;
    L86:
        if (r101 == false) goto L95;
        ISlcElement r119 = this.f50270e;
        if (r119 == null) goto L92;
        Map<String, Object> r120 = r119.getAttr();
        if (r120 == null) goto L92;
    L93:
        g1(r120);
    L92:
        r120 = MapsKt.emptyMap();
    L95:
        if (this.f50306r3 == false) goto L102;
        BaseSlcViewManager<VType>.a r121 = this.C3;
        if (r121 != null) goto L99;
        r121 = new a(this);
        this.C3 = r121;
    L99:
        View r122 = X();
        if (r122 == null) goto L102;
        r122.addOnAttachStateChangeListener(r121);
    L102:
        y0(r100);
        return;
    L83:
        if (r106.isEmpty() == true) goto L86;
        r101 = false;
        goto L86
    L67:
        if (r115.isEmpty() == true) goto L70;
        r116 = false;
        goto L71
    L64:
        r115 = null;
        goto L65
    L45:
        if (r111.isEmpty() == true) goto L48;
        r112 = false;
        goto L49
    L42:
        r111 = null;
        goto L43
    L38:
        r110 = null;
        goto L39
    L34:
        if (this.f50260a.f50214b == false) goto L40;
    L28:
        if (r107.isEmpty() == true) goto L31;
        r108 = false;
        goto L32
    L24:
        r107 = null;
        goto L26
    L16:
        if (getView().getLayoutParams() != null) goto L18;
        getView().setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -2));
        goto L18
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.g
    public final Object o(String r100) {
        Map<String, ? extends Object> r101 = this.f50266c;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    public void u(BaseSlcViewGroupManager<?> r100) {
        if (this.f50306r3 == true) goto L6;
        r100.m1(this, -1);
        return;
    }

    public final void x(Map<String, ? extends Object> r110) {
        this.f50291l3 = false;
        if (this.f50285j3 == false) goto L5;
        Map<String, Object> r100 = z0(r110);
    L6:
        SlcElement r101 = this.f50270e;
        if (r101 == null) goto L9;
        com.bytedance.android.ecom.arch.slice.render.bindinfo.d r102 = r101.bindInfo;
    L10:
        SlcTemplateContext r103 = this.f50260a;
        boolean r104 = r103.f50235w.f50161J;
        if (r104 == false) goto L29;
        if (r102 == null) goto L46;
        int r105 = com.bytedance.android.ecom.arch.slice.render.bindinfo.d.f50129m;
        String r106 = r102.f50140k;
        if (r106 != null) goto L16;
    L19:
        boolean r107 = true;
    L21:
        if ((!r107) == false) goto L46;
        if (this.f50268d == null) goto L25;
        boolean r108 = true;
    L27:
        if (this.f50298p == r108) goto L47;
        this.f50298p = r108;
        f1();
    L47:
        if (r108 == true) goto L63;
        this.f50262b = r100;
        this.F2 = null;
        this.f50295n3 = false;
        if (this.f50306r3 == false) goto L57;
        if (this.D3 == null) goto L54;
        nq.a.c(null, new BaseSlcViewManager$assertFlatten$1(this), 1);
    L54:
        if (this.f50308s3 != null) goto L60;
        nq.a.c(null, new BaseSlcViewManager$assertFlatten$2(this), 1);
    L60:
        if (this.f50289k3 == false) goto L461;
        v0(r100);
        return;
    L461:
        return;
    L57:
        if (this.f50308s3 == null) goto L60;
        nq.a.c(null, new BaseSlcViewManager$assertFlatten$3(this), 1);
        goto L60
    L63:
        if (r104 == false) goto L65;
    L81:
        SlcElement r109 = this.f50270e;
        if (r109 == null) goto L84;
        Map<String, ? extends Object> r111 = r109.getProps();
    L85:
        if (r111 != null) goto L87;
    L90:
        boolean r112 = true;
    L92:
        if (r112 == true) goto L99;
        int r113 = SlcEventHelper.f50626a;
        long r114 = System.nanoTime();
        Map<String, Object> r115 = this.f50260a.g(r111, r100);
        long r116 = System.nanoTime() - r114;
        if (r116 <= 0) goto L96;
        this.f50260a.f50220h.f50628b.f542925f += r116;
    L96:
        r100 = this.f50260a.r(MapsKt.hashMapOf(new Pair[]{TuplesKt.to(SlcElement.KEY_PROPS, r115)}));
        if (Intrinsics.areEqual(this.f50262b, r100) == false) goto L99;
        boolean r117 = true;
    L100:
        if (r117 == true) goto L102;
        if (r104 == false) goto L169;
        if (r102 == null) goto L153;
        SlcTemplateContext r118 = this.f50260a;
        String r119 = r102.f50138i;
        if (r119 != null) goto L121;
    L124:
        boolean r120 = true;
    L125:
        if (r120 == true) goto L127;
        Object r121 = r118.f50235w.f50187m0.a(r102.f50138i, r100, r118.f50230r);
    L129:
        if ((!Intrinsics.areEqual(this.f50296o, r121)) == false) goto L131;
        this.f50296o = r121;
        f1();
    L131:
        if (r121 != null) goto L133;
    L135:
        boolean r122 = false;
    L136:
        if (r122 == false) goto L153;
        this.f50262b = r100;
        this.F2 = null;
        this.f50295n3 = false;
        if (this.f50306r3 == false) goto L146;
        if (this.D3 == null) goto L143;
        nq.a.c(null, new BaseSlcViewManager$assertFlatten$1(this), 1);
    L143:
        if (this.f50308s3 != null) goto L149;
        nq.a.c(null, new BaseSlcViewManager$assertFlatten$2(this), 1);
    L149:
        if (this.f50289k3 == false) goto L464;
        v0(r100);
        return;
    L464:
        return;
    L146:
        if (this.f50308s3 == null) goto L149;
        nq.a.c(null, new BaseSlcViewManager$assertFlatten$3(this), 1);
        goto L149
    L133:
        if ("none".equals(r121) == false) goto L135;
        r122 = true;
        goto L136
    L127:
        r121 = r102.f50139j;
        goto L129
    L121:
        if (r119.length() == 0) goto L124;
        r120 = false;
    L153:
        if (this.f50291l3 == false) goto L169;
        if (this.f50306r3 == false) goto L163;
        if (this.D3 == null) goto L160;
        nq.a.c(null, new BaseSlcViewManager$assertFlatten$1(this), 1);
    L160:
        if (this.f50308s3 != null) goto L166;
        nq.a.c(null, new BaseSlcViewManager$assertFlatten$2(this), 1);
    L166:
        if (this.f50289k3 == false) goto L465;
        v0(r100);
        return;
    L465:
        return;
    L163:
        if (this.f50308s3 == null) goto L166;
        nq.a.c(null, new BaseSlcViewManager$assertFlatten$3(this), 1);
    L169:
        this.S1 = false;
        this.T1 = null;
        this.f50262b = r100;
        if (r102 == null) goto L280;
        int r123 = SlcEventHelper.f50626a;
        long r124 = System.nanoTime();
        Map<String, String> r125 = r102.f50131b;
        if (r125 != null) goto L174;
    L177:
        boolean r126 = true;
    L178:
        if (r126 == true) goto L180;
        Map<String, Object> r127 = this.f50260a.f(r102.f50131b, r100);
    L181:
        Map<String, String> r128 = r102.f50132c;
        if (r128 != null) goto L184;
    L187:
        boolean r129 = true;
    L188:
        if (r129 == true) goto L190;
        Map<String, Object> r130 = this.f50260a.f(r102.f50132c, r100);
    L191:
        Map<String, String> r131 = r102.f50136g;
        if (r131 != null) goto L194;
    L197:
        boolean r132 = true;
    L198:
        if (r132 == true) goto L200;
        Map<String, Object> r133 = this.f50260a.f(r102.f50136g, r100);
    L201:
        Map<String, String> r134 = r102.f50130a;
        if (r134 != null) goto L204;
    L207:
        boolean r135 = true;
    L208:
        if (r135 == true) goto L210;
        Map<String, Object> r136 = this.f50260a.f(r102.f50130a, r100);
    L211:
        long r137 = System.nanoTime();
        long r138 = (r137 - r124) + 0;
        if (r127 != null) goto L214;
    L217:
        boolean r139 = true;
    L218:
        if (r139 == false) goto L220;
    L227:
        if (r130 != null) goto L229;
    L232:
        boolean r140 = true;
    L233:
        if (r140 == true) goto L244;
        SlcElement r141 = this.f50270e;
        if (r141 == null) goto L237;
        Map<String, Object> r142 = r141.getActiveStyle();
    L238:
        Map<String, ? extends Object> r143 = com.bytedance.android.ecom.arch.slice.render.util.b.w(r142, r130);
        if (((HashMap) r143).isEmpty() == true) goto L244;
        if ((!Intrinsics.areEqual(this.f50314v1, r143)) == false) goto L244;
        this.f50314v1 = r143;
        goto L244
    L237:
        r142 = null;
    L244:
        String r144 = r102.f50134e;
        if (r144 != null) goto L247;
    L250:
        boolean r145 = true;
    L251:
        if (r145 == true) goto L253;
        SlcTemplateContext r146 = this.f50260a;
        IAction r147 = n.a(r146.f50235w.f50187m0.a(r144, r100, r146.f50230r));
        this.f50321x2 = r147;
        SlcViewExtensionsKt.m(this, r147);
    L253:
        String r148 = r102.f50135f;
        if (r148 != null) goto L256;
    L259:
        boolean r149 = true;
    L260:
        if (r149 == true) goto L262;
        SlcTemplateContext r150 = this.f50260a;
        IAction r151 = n.a(r150.f50235w.f50187m0.a(r148, r100, r150.f50230r));
        this.f50325y2 = r151;
        SlcViewExtensionsKt.o(this, r151);
    L262:
        if (r133 == null) goto L268;
        SlcElement r152 = this.f50270e;
        if (r152 == null) goto L266;
        Map<String, IAction> r153 = r152.getAction();
    L267:
        e1(com.bytedance.android.ecom.arch.slice.render.util.b.w(r153, r133));
        goto L268
    L266:
        r153 = null;
    L268:
        if (r136 == null) goto L274;
        SlcElement r154 = this.f50270e;
        if (r154 == null) goto L272;
        Map<String, Object> r155 = r154.getAttr();
    L273:
        g1(com.bytedance.android.ecom.arch.slice.render.util.b.w(r155, r136));
        goto L274
    L272:
        r155 = null;
    L274:
        long r156 = (System.nanoTime() - r137) + 0;
        if (r138 <= 0) goto L278;
        this.f50260a.f50220h.f50628b.f542925f += r138;
    L278:
        if (r156 <= 0) goto L280;
        this.f50260a.f50220h.f50628b.f542927h += r156;
        goto L280
    L256:
        if (r148.length() == 0) goto L259;
        r149 = false;
        goto L260
    L247:
        if (r144.length() == 0) goto L250;
        r145 = false;
        goto L251
    L229:
        if (r130.isEmpty() == true) goto L232;
        r140 = false;
        goto L233
    L220:
        if (this.f50264b2 == false) goto L222;
        i1(r127);
        goto L227
    L222:
        SlcElement r157 = this.f50270e;
        if (r157 == null) goto L225;
        Map<String, Object> r158 = r157.getStyle();
    L226:
        i1(com.bytedance.android.ecom.arch.slice.render.util.b.w(r158, r127));
        this.f50264b2 = true;
        goto L227
    L225:
        r158 = null;
        goto L226
    L214:
        if (r127.isEmpty() == true) goto L217;
        r139 = false;
        goto L218
    L210:
        r136 = null;
        goto L211
    L204:
        if (r134.isEmpty() == true) goto L207;
        r135 = false;
        goto L208
    L200:
        r133 = null;
        goto L201
    L194:
        if (r131.isEmpty() == true) goto L197;
        r132 = false;
        goto L198
    L190:
        r130 = null;
        goto L191
    L184:
        if (r128.isEmpty() == true) goto L187;
        r129 = false;
        goto L188
    L180:
        r127 = null;
        goto L181
    L174:
        if (r125.isEmpty() == true) goto L177;
        r126 = false;
    L280:
        Map<String, ? extends Object> r159 = this.f50314v1;
        if (r159 != null) goto L283;
    L286:
        boolean r160 = true;
    L287:
        if (r160 == false) goto L289;
        this.f50295n3 = false;
    L290:
        this.f50290l = false;
        final Map<String, Object> r161 = this.P2;
        if (r161 == null) goto L293;
        com.bytedance.android.ecom.arch.slice.render.util.h.c(new BaseSlcViewManager$doBindAnimation$$inlined$let$lambda$1(r161, this));
    L293:
        List<String> r162 = this.f50261a3;
        List<String> r163 = r162;
        if (r163 != null) goto L296;
    L299:
        boolean r164 = true;
    L300:
        if (r164 == true) goto L307;
        if (this.Z2 == true) goto L307;
        if ((!Intrinsics.areEqual(this.f50260a.f50235w.f50193s.get(Q()), r162)) == false) goto L307;
        this.Z2 = true;
    L307:
        if (this.Z2 == false) goto L377;
        this.Z2 = false;
        W().f50814b.clear();
        String r165 = Q();
        if (r163 != null) goto L311;
    L314:
        boolean r166 = true;
    L315:
        if (r166 == false) goto L365;
        this.f50260a.f50235w.f50193s.remove(r165);
        List<String> r167 = this.f50265b3;
        if (r167 != null) goto L319;
    L322:
        boolean r168 = true;
    L323:
        if (r168 == true) goto L354;
        com.bytedance.android.ecom.arch.slice.render.widget.animation.c r169 = W();
        List<String> r170 = this.f50265b3;
        List<String> r171 = r170;
        if (r171 != null) goto L327;
    L330:
        boolean r172 = true;
    L331:
        if (r172 == true) goto L354;
        int r173 = r170.size();
        int r174 = 0;
    L334:
        if (r174 >= r173) goto L354;
        String r175 = (String) ListProtector.get(r170, r174);
        if (r175 != null) goto L338;
    L341:
        boolean r176 = true;
    L342:
        if (r176 == true) goto L353;
        com.bytedance.android.ecom.arch.slice.render.widget.animation.b r177 = r169.g(r175);
        if (r177 != null) goto L347;
        nq.a.i(r169.f50816d.getContext(), "fillConfigValues,模版:" + r169.f50816d.f50260a.n() + ",找不到animation:" + r175);
        goto L353
    L347:
        Iterator<T> r178 = r177.f50810c.iterator();
    L349:
        if (r178.hasNext() == false) goto L353;
        com.bytedance.android.ecom.arch.slice.render.widget.animation.a r179 = com.bytedance.android.ecom.arch.slice.render.widget.animation.c.f50812e.get((String) r178.next());
        if (r179 == null) goto L349;
        r179.e(r169.f50816d);
    L353:
        r174 = r174 + 1;
        goto L334
    L338:
        if (r175.length() == 0) goto L341;
        r176 = false;
        goto L342
    L327:
        if (r171.isEmpty() == true) goto L330;
        r172 = false;
    L354:
        W().b(false);
        BaseSlcViewManager<VType>.b r180 = this.E3;
        if (r180 == null) goto L377;
        r180.f50330a = false;
        if (r180.f50331b == true) goto L359;
        boolean r181 = true;
    L360:
        if (r181 == false) goto L377;
        View r182 = X();
        if (r182 == null) goto L364;
        r182.removeOnAttachStateChangeListener(r180);
    L364:
        this.E3 = null;
        goto L377
    L359:
        r181 = false;
        goto L360
    L319:
        if (r167.isEmpty() == true) goto L322;
        r168 = false;
        goto L323
    L365:
        BaseSlcViewManager<VType>.b r183 = this.E3;
        if (r183 != null) goto L370;
        r183 = new b(this);
        this.E3 = r183;
        View r184 = X();
        if (r184 == null) goto L370;
        r184.addOnAttachStateChangeListener(r183);
    L370:
        r183.f50330a = true;
        if ((!Intrinsics.areEqual(this.f50260a.f50235w.f50193s.get(r165), r162)) == false) goto L374;
        this.f50260a.f50235w.f50193s.put(r165, r162);
        W().h(r162, false);
        goto L377
    L374:
        if (q0() == false) goto L377;
        W().b(false);
        W().d(r162);
        goto L377
    L311:
        if (r163.isEmpty() == true) goto L314;
        r166 = false;
    L377:
        if (this.f50260a.f50235w.f50170e == true) goto L379;
        H();
    L379:
        w0(r100);
        if (this.f50276g2 == false) goto L429;
        this.f50276g2 = false;
        Object r185 = this.B;
        if ((r185 instanceof String) == true) goto L384;
        r185 = null;
    L384:
        String r186 = (String) r185;
        SlcBackgroundDrawable r187 = K();
        if (r186 != null) goto L387;
    L390:
        boolean r188 = true;
    L391:
        if (r188 == false) goto L408;
        BaseSlcViewManager<VType>.b r189 = this.E3;
        if (r189 == null) goto L400;
        r189.f50331b = false;
        if ((!r189.f50330a) == false) goto L400;
        View r190 = X();
        if (r190 == null) goto L399;
        r190.removeOnAttachStateChangeListener(r189);
    L399:
        this.E3 = null;
    L400:
        SlcImageFetchManager r191 = r187.f50866r;
        if (r191 == null) goto L403;
        r191.h();
    L403:
        SlcImageFetchManager r192 = r187.f50866r;
        if (r192 == null) goto L406;
        r192.f50370n = null;
    L406:
        r187.f50866r = null;
        goto L429
    L408:
        if (r187.f50866r == null) goto L410;
        boolean r193 = true;
    L411:
        if (r193 == true) goto L422;
        SlcTemplateContext r194 = this.f50260a;
        SlcImageFetchManager r195 = r187.t(r194.f50235w, r194.q(null));
        if (q0() == false) goto L415;
        r195.g();
    L415:
        BaseSlcViewManager<VType>.b r196 = this.E3;
        if (r196 != null) goto L420;
        r196 = new b(this);
        this.E3 = r196;
        View r197 = X();
        if (r197 == null) goto L420;
        r197.addOnAttachStateChangeListener(r196);
    L420:
        r196.f50331b = true;
    L422:
        if (r187.f50866r == null) goto L424;
        boolean r198 = true;
    L425:
        nq.a.e(r198, null, 6);
        SlcImageFetchManager r199 = r187.f50866r;
        if (r199 == null) goto L429;
        r199.a(r186, r187.f50855g);
        goto L429
    L424:
        r198 = false;
        goto L425
    L410:
        r193 = false;
        goto L411
    L387:
        if (r186.length() == 0) goto L390;
        r188 = false;
    L429:
        if (this.f50278h == false) goto L438;
        if (this.f50306r3 == false) goto L435;
        SlcBackgroundDrawable r200 = this.f50274g;
        if (r200 == null) goto L436;
        r200.setCallback(this);
    L436:
        this.f50278h = false;
        goto L438
    L435:
        getView().setBackground(this.f50274g);
    L438:
        if (this.f50306r3 == false) goto L447;
        if (this.D3 == null) goto L442;
        Throwable r201 = null;
        nq.a.c(null, new BaseSlcViewManager$assertFlatten$1(this), 1);
    L444:
        if (this.f50308s3 != null) goto L450;
        nq.a.c(r201, new BaseSlcViewManager$assertFlatten$2(this), 1);
    L450:
        if (this.f50289k3 == false) goto L466;
        v0(r100);
        return;
    L466:
        return;
    L442:
        r201 = null;
        goto L444
    L447:
        if (this.f50308s3 == null) goto L450;
        nq.a.c(null, new BaseSlcViewManager$assertFlatten$3(this), 1);
        goto L450
    L296:
        if (r163.isEmpty() == true) goto L299;
        r164 = false;
        goto L300
    L289:
        this.f50295n3 = true;
        this.f50260a.f50231s++;
        goto L290
    L283:
        if (r159.isEmpty() == true) goto L286;
        r160 = false;
        goto L287
    L102:
        if (this.f50306r3 == false) goto L110;
        if (this.D3 == null) goto L107;
        nq.a.c(null, new BaseSlcViewManager$assertFlatten$1(this), 1);
    L107:
        if (this.f50308s3 != null) goto L113;
        nq.a.c(null, new BaseSlcViewManager$assertFlatten$2(this), 1);
    L113:
        if (this.f50289k3 == false) goto L463;
        v0(r100);
        return;
    L463:
        return;
    L110:
        if (this.f50308s3 == null) goto L113;
        nq.a.c(null, new BaseSlcViewManager$assertFlatten$3(this), 1);
    L99:
        r117 = false;
        goto L100
    L87:
        if (r111.isEmpty() == true) goto L90;
        r112 = false;
        goto L92
    L84:
        r111 = null;
        goto L85
    L65:
        if (this.f50291l3 == false) goto L81;
        if (this.f50306r3 == false) goto L75;
        if (this.D3 == null) goto L72;
        nq.a.c(null, new BaseSlcViewManager$assertFlatten$1(this), 1);
    L72:
        if (this.f50308s3 != null) goto L78;
        nq.a.c(null, new BaseSlcViewManager$assertFlatten$2(this), 1);
    L78:
        if (this.f50289k3 == false) goto L462;
        v0(r100);
        return;
    L462:
        return;
    L75:
        if (this.f50308s3 == null) goto L78;
        nq.a.c(null, new BaseSlcViewManager$assertFlatten$3(this), 1);
        goto L78
    L25:
        r108 = r102.b(this.f50260a, r100);
        goto L27
    L16:
        if (r106.length() == 0) goto L19;
        r107 = false;
    L46:
        r108 = true;
        goto L47
    L29:
        if (r102 == null) goto L46;
        if (this.f50268d == null) goto L33;
        boolean r202 = true;
    L34:
        if (r202 == false) goto L37;
        r108 = r102.a(r103, r100);
    L44:
        if (this.f50298p == r108) goto L47;
        this.f50298p = r108;
        f1();
        goto L47
    L37:
        if (r102.b(r103, r100) == true) goto L40;
    L41:
        r108 = false;
        goto L44
    L40:
        if (r102.a(r103, r100) == false) goto L41;
        r108 = true;
        goto L44
    L33:
        r202 = false;
        goto L34
    L9:
        r102 = null;
        goto L10
    L5:
        r100 = r110;
        goto L6
    }

    public static void I(SlcBackgroundDrawable r100, wq.a r101) {
        Rect r102 = r100.getBounds();
        xq.a r103 = (xq.a) r101;
        RecordingCanvas r104 = r103.f564791b.beginRecording(r102.width(), r102.height());
        r104.translate(-r102.left, -r102.top);
        r100.draw(r104);     // Catch: Throwable -> L6
        r103.f564791b.endRecording();
        r103.f564791b.setPosition(r102.left, r102.top, r102.right, r102.bottom);
        return;
    L6:
        th = move-exception;
        r103.f564791b.endRecording();
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void t(BaseSlcViewManager r100, int r101) {
        BaseSlcViewGroupManager<?> r102 = r100.f50268d;
        if (r102 != 0) goto L5;
    L9:
        Object r103 = r100.getView().getParent();
        SliceRender.f50121o.getClass();
        if (SliceRender.d() == false) goto L17;
        if (r103 != null) goto L17;
        if (r102 == 0) goto L14;
        Object r104 = (ViewGroup) r102.getView();
    L15:
        r103 = r104;
        goto L17
    L14:
        r104 = null;
    L17:
        if ((r103 instanceof com.bytedance.android.ecom.arch.slice.render.widget.drawchild.a.InterfaceC0866a) == false) goto L25;
        com.bytedance.android.ecom.arch.slice.render.widget.drawchild.a r105 = ((com.bytedance.android.ecom.arch.slice.render.widget.drawchild.a.InterfaceC0866a) r103).getSlcDrawChild();
        r105.b(r100.getView(), r101);
        r105.a();
        if ((r103 instanceof SlcRootView) == false) goto L21;
    L22:
        ((View) r103).setTranslationZ(r101);
        return;
    L21:
        if ((r103 instanceof SlcItemView) == true) goto L22;
        return;
    L25:
        return;
    L5:
        if (r102.u1() != true) goto L9;
        if ((r102 instanceof com.bytedance.android.ecom.arch.slice.render.widget.drawchild.a.InterfaceC0866a) == false) goto L9;
        ((com.bytedance.android.ecom.arch.slice.render.widget.drawchild.a.InterfaceC0866a) r102).getSlcDrawChild().d(r100, r101);
    }

    public final void P0(float r100, float r101) {
        if (this.f50306r3 == false) goto L5;
        ((xq.a) g0()).f564791b.setScaleX(r100);
        ((xq.a) g0()).f564791b.setScaleY(r101);
        return;
    L5:
        getView().setScaleX(r100);
        getView().setScaleY(r101);
    }

    public void T0(String r100, boolean r101) {
        SliceRender.f50121o.getClass();
        boolean r102 = false;
        if (SliceRender.f() == false) goto L21;
        if (r100 != null) goto L6;
    L8:
        boolean r103 = !r102;
        View r104 = getView();
        r104.setTag(Boolean.valueOf(r103));
        Object r105 = r104.getParent();
        if (r105 == null) goto L17;
        if ((r105 instanceof SlcRootView) == false) goto L14;
        ((View) r105).setTag(Boolean.valueOf(r103));
        goto L17
    L14:
        if ((r105 instanceof SlcItemView) == false) goto L17;
        ((View) r105).setTag(Boolean.valueOf(r103));
    L17:
        if ((r104 instanceof ViewGroup) == true) goto L19;
        return;
    L19:
        if (Build.VERSION.SDK_INT < 24) goto L42;
        r104.forceHasOverlappingRendering(!r101);
        return;
    L42:
        return;
    L6:
        if ("visible".equals(r100) == false) goto L8;
        r102 = true;
        goto L8
    L21:
        View r106 = getView();
        if ((r106 instanceof ViewGroup) == false) goto L44;
        if (r100 != null) goto L25;
    L27:
        boolean r107 = false;
    L28:
        boolean r108 = !r107;
        ViewGroup r109 = (ViewGroup) r106;
        r109.setClipChildren(r108);
        ViewParent r110 = r109.getParent();
        if ((r110 instanceof SlcRootView) == false) goto L32;
        ((SlcRootView) r110).setClipChildren(r108);
    L35:
        if (Build.VERSION.SDK_INT < 24) goto L45;
        if (r108 == true) goto L39;
        if (r101 == false) goto L39;
        r106.forceHasOverlappingRendering(false);
        return;
    L39:
        r106.forceHasOverlappingRendering(true);
        return;
    L45:
        return;
    L32:
        if ((r110 instanceof SlcItemView) == false) goto L35;
        ((SlcItemView) r110).setClipChildren(r108);
        goto L35
    L25:
        if ("visible".equals(r100) == false) goto L27;
        r107 = true;
        goto L28
    }

    public void V0(List<?> r100, float r101) {
        List<?> r102 = r100;
        int r103 = 0;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        ArrayList r105 = new ArrayList(1);
        r105.add(Float.valueOf(r101));
    L15:
        U0(r105);
        return;
    L11:
        int r106 = r100.size();
        ArrayList r107 = new ArrayList(r106);
    L12:
        if (r103 >= r106) goto L14;
        r107.add(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.c(ListProtector.get(r100, r103), 0.0f) + r101));
        r103 = r103 + 1;
        goto L12
    L14:
        r105 = r107;
        goto L15
    L5:
        if (r102.isEmpty() == true) goto L8;
        r104 = false;
        goto L9
    }

    public void W0(List<?> r100, boolean r101) {
        boolean r102 = true;
        if (this.f50306r3 == false) goto L13;
        SlcBackgroundDrawable r103 = K();
        SlcViewExtensionsKt.k(r103, this.f50260a.m(), r100, r101);
        wq.a r104 = g0();
        if (SlcBackgroundDrawable.f50846t == true) goto L11;
        com.bytedance.android.ecom.arch.slice.render.widget.background.a r105 = r103.f50860l;
        if (r105 == null) goto L11;
        if (r105.f50875h == false) goto L11;
    L12:
        ((xq.a) r104).f564791b.setClipToOutline(r102);
        return;
    L11:
        r102 = false;
        goto L12
    L13:
        View r106 = getView();
        SlcBackgroundDrawable r107 = K();
        SlcViewExtensionsKt.k(r107, this.f50260a.m(), r100, r101);
        if (SlcBackgroundDrawable.f50846t == true) goto L20;
        com.bytedance.android.ecom.arch.slice.render.widget.background.a r108 = r107.f50860l;
        if (r108 == null) goto L20;
        if (r108.f50875h == false) goto L20;
    L21:
        r106.setClipToOutline(r102);
        return;
    L20:
        r102 = false;
        goto L21
    }

    public final void X0(float r100, float r101) {
        if (this.f50306r3 == false) goto L5;
        ((xq.a) g0()).f564791b.setPivotX(r100);
        ((xq.a) g0()).f564791b.setPivotY(r101);
        return;
    L5:
        getView().setPivotX(r100);
        getView().setPivotY(r101);
    }

    public final void Y0(float r100, float r101) {
        if (this.f50306r3 == false) goto L5;
        ((xq.a) g0()).f564791b.setTranslationX(r100);
        ((xq.a) g0()).f564791b.setTranslationY(r101);
        return;
    L5:
        getView().setTranslationX(r100);
        getView().setTranslationY(r101);
    }

    public final void Z0(uq.a r100, uq.a r101) {
        c r102 = new c(this, r100, r101);
        if (q0() == true) goto L5;
    L7:
        ArrayList<Runnable> r103 = this.Q1;
        if (r103 != null) goto L11;
        r103 = new ArrayList();
        this.Q1 = r103;
    L11:
        if (r103.contains(r102) == true) goto L15;
        r103.add(r102);
        return;
    L15:
        return;
    L5:
        if (getView().isLaidOut() == false) goto L7;
        r102.run();
    }

    public final boolean t0(float r100, float r101) {
        if (this.f50306r3 == true) goto L7;
        return SlcViewExtensionsKt.h(getView(), r100, r101);
    L7:
        if (q0() == true) goto L9;
        return false;
    L9:
        Lazy r102 = this.f50260a.f50235w.f50171e0;
        KProperty r103 = SlcRenderContext.f50160n0[2];
        float[] r104 = (float[]) r102.getValue();
        r104[0] = this.f50272f.getLayoutX();
        r104[1] = this.f50272f.getLayoutY();
        if (l0() == true) goto L12;
        e0().mapPoints(r104);
    L12:
        BaseSlcViewGroupManager<?> r105 = this.f50268d;
    L13:
        if (r105 == null) goto L21;
        if (r105.f50306r3 == false) goto L16;
        if (r105.l0() == true) goto L20;
        r105.e0().mapPoints(r104);
    L20:
        r104[0] = r104[0] + r105.f50272f.getLayoutX();
        r104[1] = r104[1] + r105.f50272f.getLayoutY();
        r105 = r105.f50268d;
        goto L13
    L16:
        Lazy r106 = this.f50260a.f50235w.f50169d0;
        KProperty r107 = SlcRenderContext.f50160n0[1];
        int[] r108 = (int[]) r106.getValue();
        ((ViewGroup) r105.getView()).getLocationOnScreen(r108);
        r104[0] = r104[0] + com.bytedance.android.ecom.arch.slice.render.util.b.c(Integer.valueOf(r108[0]), 0.0f);
        r104[1] = r104[1] + com.bytedance.android.ecom.arch.slice.render.util.b.c(Integer.valueOf(r108[1]), 0.0f);
    L21:
        float r109 = r104[0];
        if (r100 >= r109) goto L24;
        return false;
    L24:
        if (r101 > r104[1]) goto L26;
        return false;
    L26:
        if (r100 <= (r109 + j0())) goto L28;
        return false;
    L28:
        if (r101 > (r104[1] + c0())) goto L38;
        return true;
    L38:
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r100, Runnable r101) {
        if (P(r100) == false) goto L6;
        com.bytedance.android.ecom.arch.slice.render.util.h.f50743a.removeCallbacks(r101, r100);
        return;
    }

    public final void w(String r100, Object r101) {
        com.bytedance.android.ecom.arch.slice.render.widget.animation.a r102 = com.bytedance.android.ecom.arch.slice.render.widget.animation.c.f50812e.get(r100);
        if (r102 == null) goto L6;
        r102.a(this, r101);
        return;
    }

    public final boolean z(String r100, Object r101) {
        List<String> r102 = this.L2;
        if (r102 != null) goto L5;
        return false;
    L5:
        if (r102.contains(r100) == true) goto L7;
        return false;
    L7:
        j.f50836e.getClass();
        String r103 = j.a.b(this, r100);
        if (this.f50260a.f50235w.f50192r.containsKey(r103) == true) goto L10;
        this.f50260a.f50235w.f50192r.put(r103, null);
        boolean r104 = true;
    L11:
        if (r104 == false) goto L14;
        return false;
    L14:
        if (nq.a.g() == false) goto L35;
        String r105 = d0();
        if (r105 != null) goto L18;
    L21:
        boolean r106 = true;
    L23:
        if (r106 == false) goto L25;
        Toast.makeText(getContext(), "动画不生效，属性" + r100 + "：没有配置slice_key", 0).show();
        goto L35
    L25:
        String r107 = this.f50260a.f50219g;
        if (r107 != null) goto L28;
    L31:
        boolean r108 = true;
    L32:
        if (r108 == false) goto L35;
        Toast.makeText(getContext(), "动画不生效，属性" + r100 + "：bindData没有设置nodeId参数", 0).show();
        goto L35
    L28:
        if (r107.length() == 0) goto L31;
        r108 = false;
        goto L32
    L18:
        if (r105.length() == 0) goto L21;
        r106 = false;
    L35:
        if (j.a.a(this) == true) goto L38;
    L39:
        boolean r109 = false;
    L41:
        if (r109 == true) goto L43;
        return false;
    L43:
        Map r110 = this.P2;
        if (r110 != null) goto L47;
        r110 = new HashMap();
        this.P2 = r110;
    L47:
        r110.put(r100, r101);
        return true;
    L38:
        if (Intrinsics.areEqual(this.f50260a.f50235w.f50192r.get(j.a.b(this, r100)), r101) == true) goto L39;
        r109 = true;
        goto L41
    L10:
        r104 = false;
        goto L11
    }

    public static final void r(BaseSlcViewManager r100, uq.a r101, uq.a r102) {
        r100.getClass();
        if (r101.f551168b == 1) goto L5;
    L7:
        View r103 = r100.X();
        if (r103 == null) goto L12;
        com.bytedance.android.ecom.arch.slice.render.util.f r104 = new com.bytedance.android.ecom.arch.slice.render.util.f(r103, new d(r100, r101, r102));
        r103.getViewTreeObserver().addOnPreDrawListener(r104);
        r103.addOnAttachStateChangeListener(r104);
        return;
    L12:
        return;
    L5:
        if (r102.f551168b != 1) goto L7;
        r100.X0(r101.f551167a, r102.f551167a);
    }

    public static final void s(BaseSlcViewManager r100, uq.a r101, uq.a r102) {
        r100.I2 = r101;
        r100.J2 = r102;
        boolean r103 = false;
        if (r101 != null) goto L5;
    L6:
        if (r102 != null) goto L8;
    L10:
        boolean r104 = false;
    L11:
        boolean r105 = r100.z("translate", CollectionsKt.listOf(new uq.a[]{r101, r102}));
        if (r104 == false) goto L15;
        if (r105 == true) goto L15;
        r103 = true;
    L15:
        r100.K2 = r103;
        if (r105 == true) goto L22;
        if (r104 == true) goto L19;
    L20:
        r100.Y0(r100.R(r101), r100.S(r102));
        return;
    L19:
        if (r100.q0() == true) goto L20;
        return;
    L22:
        return;
    L8:
        if (r102.f551168b != 2) goto L10;
    L9:
        r104 = true;
        goto L11
    L5:
        if (r101.f551168b == 2) goto L9;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
        if (P(r100) == false) goto L6;
        com.bytedance.android.ecom.arch.slice.render.util.h.f50743a.postAtTime(r101, r100, r102);
        return;
    }

    public void F0(int r100, int r101, int r102, int r103) {
        getView().measure(View.MeasureSpec.makeMeasureSpec(r102 - r100, 1073741824), View.MeasureSpec.makeMeasureSpec(r103 - r101, 1073741824));
        getView().layout(r100, r101, r102, r103);
    }

    public final void h1(int r100, int r101, int r102, int r110) {
        int r103 = this.f50318w3;
        if (r103 == r100) goto L5;
    L10:
        int r104 = this.f50326y3 - r103;
        int r105 = this.f50328z3 - this.f50322x3;
        int r106 = r102 - r100;
        int r107 = r110 - r101;
        this.f50318w3 = r100;
        this.f50322x3 = r101;
        this.f50326y3 = r102;
        this.f50328z3 = r110;
        ((xq.a) g0()).f564791b.setPosition(r100, r101, r102, r110);
        if (r104 != r106) goto L17;
        if (r105 != r107) goto L17;
        BaseSlcViewGroupManager<?> r108 = this.f50268d;
        if (r108 == null) goto L23;
        r108.n0();
    L23:
        this.f50312u3 = false;
        return;
    L17:
        SlcBackgroundDrawable r109 = this.f50274g;
        if (r109 == null) goto L22;
        r109.setBounds(0, 0, r106, r107);
        if (((xq.a) g0()).f564791b.getClipToOutline() == false) goto L22;
        Lazy r111 = this.f50260a.f50235w.f50173f0;
        KProperty r112 = SlcRenderContext.f50160n0[3];
        Outline r113 = (Outline) r111.getValue();
        r113.setEmpty();
        r113.setAlpha(1.0f);
        r109.getOutline(r113);
        ((xq.a) g0()).f564791b.setOutline(r113);
    L22:
        n0();
        goto L23
    L5:
        if (this.f50322x3 != r101) goto L10;
        if (this.f50326y3 != r102) goto L10;
        if (this.f50328z3 == r110) goto L23;
        goto L10
    }

    public long u0(float r100, YogaMeasureMode r101, float r102, YogaMeasureMode r103) {
        int r104 = View.MeasureSpec.makeMeasureSpec(Math.round(r100), j1(r101));
        int r105 = View.MeasureSpec.makeMeasureSpec(Math.round(r102), j1(r103));
        View r106 = E0();
        r106.measure(r104, r105);
        return YogaMeasureOutput.make(r106.getMeasuredWidth(), r106.getMeasuredHeight());
    }

    public void v(int r100, int r101, int r102, int r110) {
        if (r0() == true) goto L5;
    L7:
        F0(r100, r101, r102, r110);
        ArrayList<Runnable> r103 = this.Q1;
        boolean r104 = true;
        if (r103 != null) goto L10;
    L13:
        boolean r105 = true;
    L14:
        SlcTouchDelegateHelper r111 = null;
        if (r105 == true) goto L24;
        ArrayList<Runnable> r106 = this.Q1;
        if (r106 == null) goto L22;
        Iterator<Runnable> r107 = r106.iterator();
    L20:
        if (r107.hasNext() == false) goto L22;
        r107.next().run();
    L22:
        this.Q1 = null;
    L24:
        if (this.K2 == false) goto L27;
        Y0(R(this.I2), S(this.J2));
    L27:
        if (this.G2.isEmpty() == false) goto L40;
        WeakHashMap<View, SlcTouchDelegateHelper> r108 = this.H2;
        if (r108 != null) goto L31;
    L34:
        if (r104 == true) goto L43;
        View r109 = getView();
        WeakHashMap<View, SlcTouchDelegateHelper> r112 = this.H2;
        if (r112 == null) goto L38;
        r111 = r112.remove(r109);
    L38:
        if (r111 == null) goto L44;
        r111.b();
        return;
    L44:
        return;
    L43:
        return;
    L31:
        if (r108.isEmpty() == true) goto L34;
        r104 = false;
        goto L34
    L40:
        int r113 = SlcDimensExtensionsKt.a(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.k(this.G2)), this.f50260a.m());
        int r114 = SlcDimensExtensionsKt.a(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.t(this.G2)), this.f50260a.m());
        int r115 = SlcDimensExtensionsKt.a(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.q(this.G2)), this.f50260a.m());
        int r116 = SlcDimensExtensionsKt.a(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.b(this.G2)), this.f50260a.m());
        c1(getView(), r113, r114, r115, r116);
        return;
    L10:
        if (r103.isEmpty() == true) goto L13;
        r105 = false;
        goto L14
    L5:
        if (this.f50260a.f50235w.M == false) goto L7;
    }

    public final void c1(View r100, int r101, int r102, int r103, int r104) {
        SlcTouchDelegateHelper.f50772d.getClass();
        if (this.f50260a.f50235w.f50199y == false) goto L29;
        if (r101 < 0) goto L29;
        if (r102 < 0) goto L29;
        if (r103 < 0) goto L29;
        if (r104 < 0) goto L29;
        if (r101 != 0) goto L19;
        if (r102 != 0) goto L19;
        if (r103 != 0) goto L19;
        if (r104 == 0) goto L29;
    L19:
        if (r100.isAttachedToWindow() == false) goto L29;
        if (r100.isClickable() == true) goto L25;
        if (r100.isLongClickable() == false) goto L29;
    L25:
        if (r100.getWidth() <= 0) goto L29;
        if (r100.getHeight() <= 0) goto L29;
        boolean r105 = true;
    L30:
        SlcTouchDelegateHelper r106 = null;
        if (r105 == false) goto L47;
        WeakHashMap<View, SlcTouchDelegateHelper> r107 = this.H2;
        if (r107 == null) goto L35;
        r106 = r107.remove(r100);
    L35:
        if (r106 == null) goto L37;
        r106.b();
    L37:
        View r108 = SlcTouchDelegateHelper.Companion.a(r100, r101, r102, r103, r104);
        if (r108 == null) goto L46;
        SlcTouchDelegateHelper r109 = new SlcTouchDelegateHelper(r100, new WeakReference(r108));
        WeakHashMap<View, SlcTouchDelegateHelper> r110 = this.H2;
        if (r110 != null) goto L42;
        r110 = new WeakHashMap();
        this.H2 = r110;
    L42:
        SlcTouchDelegateHelper r111 = r110.get(r100);
        if (r111 == null) goto L45;
        r111.b();
    L45:
        r110.put(r100, r109);
        r109.a(r101, r102, r103, r104);
        return;
    L46:
        return;
    L47:
        WeakHashMap<View, SlcTouchDelegateHelper> r112 = this.H2;
        if (r112 == null) goto L50;
        r106 = r112.remove(r100);
    L50:
        if (r106 == null) goto L54;
        r106.b();
        return;
    L54:
        return;
    L29:
        r105 = false;
        goto L30
    }
}
