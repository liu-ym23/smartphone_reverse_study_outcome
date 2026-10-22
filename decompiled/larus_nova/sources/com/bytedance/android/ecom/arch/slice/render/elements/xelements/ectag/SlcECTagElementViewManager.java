package com.bytedance.android.ecom.arch.slice.render.elements.xelements.ectag;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.bytedance.android.annie.card.base.BaseHybridComponent;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.action.r;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.elements.text.SlcTextElementView;
import com.bytedance.android.ecom.arch.slice.render.elements.xelements.ectaggroup.SlcECTagGroupElementView;
import com.bytedance.android.ecom.arch.slice.render.elements.xelements.ectaggroup.SlcECTagGroupElementViewManager;
import com.bytedance.android.ecom.arch.slice.render.event.SlcEventHelper;
import com.bytedance.android.ecom.arch.slice.render.f;
import com.bytedance.android.ecom.arch.slice.render.g;
import com.bytedance.android.ecom.arch.slice.render.i;
import com.bytedance.android.ecom.arch.slice.render.o;
import com.bytedance.android.ecom.arch.slice.render.p;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class SlcECTagElementViewManager extends BaseSlcViewManager<SlcECTagElementView> {
    public static final /* synthetic */ KProperty[] Z3 = null;

    /* JADX INFO: renamed from: a4, reason: collision with root package name */
    public static final Rect f50568a4 = null;

    /* JADX INFO: renamed from: b4, reason: collision with root package name */
    public static final Lazy f50569b4 = null;

    /* JADX INFO: renamed from: c4, reason: collision with root package name */
    public static final Companion f50570c4 = null;
    public b H3;
    public BaseSlcViewManager<?> I3;
    public Map<String, ? extends Object> J3;
    public Map<String, ? extends Object> K3;
    public boolean L3;
    public boolean M3;
    public Map<String, ? extends Object> N3;
    public String O3;
    public String P3;
    public String Q3;
    public Map<String, ? extends Object> R3;
    public String S3;
    public boolean T3;
    public boolean U3;
    public final Lazy V3;
    public final Lazy W3;
    public final a X3;
    public long Y3;

    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ KProperty[] f50571a = null;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f50572a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function0 f50573b;

            public a(String r100, Function0 r101) {
                this.f50572a = r100;
                this.f50573b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                SliceRender.f50121o.getClass();     // Catch: Throwable -> L6
                pq.a r100 = SliceRender.f50108b;     // Catch: Throwable -> L6
                if (r100 == null) goto L9;
                r100.i(this.f50572a, (Map) this.f50573b.invoke());     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        static {
            f50571a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Companion.class), "ectagGlobalProps", "getEctagGlobalProps()Ljava/util/HashMap;"))};
        }

        public Companion() {
        }

        public static void a(Map r100) {
            HashMap r101 = (HashMap) r100;
            r101.put("etag_sdk_tech", "SLICE_Android");
            r101.put("etag_sdk_version", 1);
            r101.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        }

        public static float e(final SlcECTagGroupElementViewManager r100) {
            SliceRender.f50121o.getClass();
            if (SliceRender.f() == false) goto L37;
            if (r100.q0() == true) goto L8;
            return 0.0f;
        L8:
            if (r100.getView().getVisibility() == 0) goto L10;
            return 0.0f;
        L10:
            Rect r101 = SlcECTagElementViewManager.f50568a4;
            boolean r102 = false;
            if (r100.s0() == true) goto L29;
            r101.set(0, 0, r100.j0(), r100.c0());
            if ((r100.getView().getParent() instanceof SlcTextElementView) == false) goto L28;
            Object r103 = r100.getView().getParent();
            if ((r103 instanceof View) == true) goto L18;
            r103 = null;
        L18:
            View r104 = (View) r103;
            if (r104 == null) goto L21;
            BaseSlcViewManager<?> r105 = SlcViewExtensionsKt.g(r104);
        L22:
            if (r105 != null) goto L25;
            nq.a.c(null, new SlcECTagElementViewManager$Companion$getECTagGroupVisibleBounds$1(r100), 1);
            goto L29
        L25:
            if (m(r100, r105, r101) == false) goto L29;
            r102 = c(r105, r101);
            goto L29
        L21:
            r105 = null;
            goto L22
        L28:
            r102 = c(r100, r101);
        L29:
            if (r102 == true) goto L31;
            return 0.0f;
        L31:
            int r106 = r100.getView().getWidth() * r100.getView().getHeight();
            if (r106 > 0) goto L35;
            return 0.0f;
        L35:
            return (float) ((((double) (r101.width() * r101.height())) * 1.0d) / ((double) r106));
        L37:
            return h(r100.getView());
        }

        public static com.bytedance.android.ecom.arch.slice.render.elements.xelements.ectag.a f(SlcRenderContext r100) {
            Object r101 = r100.g(com.bytedance.android.ecom.arch.slice.render.elements.xelements.ectag.a.class);
            if ((r101 instanceof com.bytedance.android.ecom.arch.slice.render.elements.xelements.ectag.a) == true) goto L5;
            r101 = null;
        L5:
            com.bytedance.android.ecom.arch.slice.render.elements.xelements.ectag.a r102 = (com.bytedance.android.ecom.arch.slice.render.elements.xelements.ectag.a) r101;
            if (r102 != null) goto L10;
            com.bytedance.android.ecom.arch.slice.render.elements.xelements.ectag.a r103 = new com.bytedance.android.ecom.arch.slice.render.elements.xelements.ectag.a(100);
            r100.o(com.bytedance.android.ecom.arch.slice.render.elements.xelements.ectag.a.class, r103);
            return r103;
        L10:
            return r102;
        }

        public static float g(Map r100) {
            if (r100 != null) goto L4;
        L7:
            boolean r101 = true;
        L9:
            if (r101 == false) goto L11;
            return -1.0f;
        L11:
            Object r102 = r100.get("etag_raw_data");
            if ((r102 instanceof Map) == true) goto L14;
            r102 = null;
        L14:
            Map r103 = (Map) r102;
            if (r103 != null) goto L17;
            return -1.0f;
        L17:
            return com.bytedance.android.ecom.arch.slice.render.util.b.c(r103.get("width"), -1.0f);
        L4:
            if (r100.isEmpty() == true) goto L7;
            r101 = false;
            goto L9
        }

        public static float h(View r100) {
            if (r100.getVisibility() == 0) goto L5;
            return 0.0f;
        L5:
            Rect r101 = SlcECTagElementViewManager.f50568a4;
            if (r100.getGlobalVisibleRect(r101) == true) goto L9;
            return 0.0f;
        L9:
            return (float) ((((double) (r101.width() * r101.height())) * 1.0d) / ((double) (r100.getWidth() * r100.getHeight())));
        }

        public static Map i(List r100) {
            if (r100 == null) goto L5;
            int r101 = r100.size();
        L6:
            int r102 = 0;
        L7:
            Map r103 = null;
            if (r102 >= r101) goto L16;
            if (r100 == null) goto L11;
            r103 = (Map) CollectionsKt.getOrNull(r100, r102);
        L11:
            if (r103 == null) goto L15;
            if (com.bytedance.android.ecom.arch.slice.render.util.b.f(r103.get("version"), 0) <= 1) goto L16;
        L15:
            r102 = r102 + 1;
        L16:
            return r103;
        L5:
            r101 = 0;
            goto L6
        }

        public static Map j(Map r100) {
            boolean r101 = false;
            if (r100 != null) goto L5;
        L8:
            boolean r102 = true;
        L10:
            if (r102 == false) goto L13;
            return null;
        L13:
            if (com.bytedance.android.ecom.arch.slice.render.util.b.f(r100.get("version"), 0) <= 1) goto L26;
            Object r103 = r100.get("fallback");
            if ((r103 instanceof List) == true) goto L17;
            r103 = null;
        L17:
            Map r104 = i((List) r103);
            if (r104 != null) goto L20;
        L21:
            r101 = true;
        L22:
            if (r101 == false) goto L27;
            nq.a.c(null, SlcECTagElementViewManager$Companion$getSliceTypeFallbackData$1.INSTANCE, 1);
            return r100;
        L27:
            return r104;
        L20:
            if (r104.isEmpty() == false) goto L22;
        L26:
            return r100;
        L5:
            if (r100.isEmpty() == true) goto L8;
            r102 = false;
            goto L10
        }

        public static Map k(Map r100) {
            if (r100 != null) goto L4;
        L7:
            boolean r101 = true;
        L9:
            if (r101 == false) goto L11;
            return null;
        L11:
            Object r102 = r100.get("etag_log_extra");
            if ((r102 instanceof Map) == true) goto L14;
            r102 = null;
        L14:
            Map r103 = (Map) r102;
            if (r103 == null) goto L22;
            Object r104 = r103.get("tag_info");
            if ((r104 instanceof Map) == true) goto L19;
            r104 = null;
        L19:
            Map r105 = (Map) r104;
            if (r105 == null) goto L22;
            return r105;
        L22:
            return null;
        L4:
            if (r100.isEmpty() == true) goto L7;
            r101 = false;
            goto L9
        }

        public static void b(SlcRenderContext r100, String r101) {
            Object r102 = r100.g("slice_ectag_exposure_map");
            if ((r102 instanceof HashSet) == true) goto L5;
            r102 = null;
        L5:
            HashSet r103 = (HashSet) r102;
            if (r103 != null) goto L8;
            HashSet r104 = new HashSet();
            r104.add(r101);
            r100.o("slice_ectag_exposure_map", r104);
            return;
        L8:
            r103.add(r101);
        }

        public static boolean c(BaseSlcViewManager r100, Rect r101) {
            if (r100.s0() == false) goto L6;
            return false;
        L6:
            BaseSlcViewGroupManager<?> r102 = r100.f50268d;
            if (r102 == null) goto L10;
            return r102.t1(r100, r101);
        L10:
            return r100.B(r101);
        }

        public static boolean d(SlcRenderContext r100, String r101) {
            Object r102 = r100.g("slice_ectag_exposure_map");
            if ((r102 instanceof HashSet) == true) goto L5;
            r102 = null;
        L5:
            HashSet r103 = (HashSet) r102;
            if (r103 != null) goto L10;
            r100.o("slice_ectag_exposure_map", new HashSet());
            return false;
        L10:
            return r103.contains(r101);
        }

        public static void l(String r100, Function0 r101) {
            SliceRender.f50121o.getClass();
            SliceRender.g().execute(new a(r100, r101));
        }

        public static boolean m(BaseSlcViewManager r100, BaseSlcViewManager r101, Rect r102) {
            if (r101.s0() == false) goto L5;
            return false;
        L5:
            Lazy r103 = r101.f50260a.f50235w.f50179i0;
            KProperty r104 = SlcRenderContext.f50160n0[6];
            RectF r105 = (RectF) r103.getValue();
            r105.set(r102);
            if (r100.l0() == true) goto L8;
            r100.e0().mapRect(r105);
        L8:
            r105.offset(com.bytedance.android.ecom.arch.slice.render.util.b.c(Integer.valueOf(r100.getView().getLeft() - r101.h0()), 0.0f), com.bytedance.android.ecom.arch.slice.render.util.b.c(Integer.valueOf(r100.getView().getTop() - r101.i0()), 0.0f));
            if (r101.Z() == true) goto L11;
        L13:
            r102.set((int) Math.floor(r105.left), (int) Math.floor(r105.top), (int) Math.ceil(r105.right), (int) Math.ceil(r105.bottom));
            return true;
        L11:
            if (r105.intersect(0.0f, 0.0f, com.bytedance.android.ecom.arch.slice.render.util.b.c(Integer.valueOf(r101.j0()), 0.0f), com.bytedance.android.ecom.arch.slice.render.util.b.c(Integer.valueOf(r101.c0()), 0.0f)) == true) goto L13;
            return false;
        }
    }

    public final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlcECTagElementViewManager f50574a;

        public a(SlcECTagElementViewManager r100) {
            this.f50574a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            SlcECTagElementViewManager r101 = this.f50574a;
            if (r101.U3 == true) goto L7;
            r101.U3 = true;
            Lazy r102 = r101.V3;
            KProperty[] r103 = SlcECTagElementViewManager.Z3;
            KProperty r104 = r103[0];
            com.bytedance.android.ecom.arch.slice.render.elements.xelements.ectag.a r105 = (com.bytedance.android.ecom.arch.slice.render.elements.xelements.ectag.a) r102.getValue();
            Lazy r106 = r101.W3;
            KProperty r107 = r103[1];
            r105.a((SlcECTagElementViewManager$timerListener$2.a) r106.getValue());
            r101.n1();
            return;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            this.f50574a.k1();
        }
    }

    public static final class b implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<SlcECTagElementViewManager> f50575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f50576b;

        public b(WeakReference r100) {
            this.f50575a = r100;
            this.f50576b = false;
        }

        @Override // com.bytedance.android.ecom.arch.slice.render.f
        public final void a(o r110) {
            if (this.f50576b == false) goto L5;
            return;
        L5:
            SlcECTagElementViewManager r100 = this.f50575a.get();
            if (r100 == null) goto L30;
            SlcElement r101 = r110.f50683b;
            if (r101 == null) goto L25;
            r100.L3 = false;
            r100.I3 = null;
            r100.getView().removeAllViews();
            int r111 = r100.f50272f.getChildCount();
            int r102 = 0;
        L10:
            if (r102 >= r111) goto L13;
            r100.f50272f.removeChildAt(r102);
            r102 = r102 + 1;
            goto L10
        L13:
            if (r100.f50272f.getChildCount() != 0) goto L15;
            boolean r112 = true;
        L16:
            nq.a.e(r112, null, 6);
            if (r100.f50272f.getChildCount() != r100.getView().getChildCount()) goto L19;
            boolean r113 = true;
        L20:
            nq.a.e(r113, null, 6);
            BaseSlcViewManager<?> r114 = r100.m1().c(r101.getType(), true, false);
            r100.f50272f.setMeasureFunction(null);
            r100.f50272f.addChildAt(r114.f50272f, 0);
            r100.getView().addView(r114.getView(), 0);
            r114.m0(r101);
            r100.I3 = r114;
            r100.L3 = true;
            nq.a.e(true, null, 6);
            Map<String, ? extends Object> r115 = r100.J3;
            if (r115 == null) goto L31;
            BaseSlcViewManager<?> r103 = r100.I3;
            if (r103 == null) goto L32;
            r103.x(r115);
            return;
        L32:
            return;
        L31:
            return;
        L19:
            r113 = false;
            goto L20
        L15:
            r112 = false;
            goto L16
        L25:
            SlcECTagElementViewManager r104 = this.f50575a.get();
            if (r104 == null) goto L34;
            com.bytedance.android.ecom.arch.slice.render.event.monitor.a.a(new com.bytedance.android.ecom.arch.slice.render.event.monitor.a("RENDER_ERROR", "create_ectag_error", "fail to create ECTag,scene:" + r104.O3 + ",position:" + r104.P3 + ",geckoErrorCode:" + Integer.valueOf(r110.f50686e), null, Integer.valueOf(r110.f50686e), null, 40), r104.m1(), null, false, 6);
            return;
        L34:
            return;
        }
    }

    public static final class c implements com.bytedance.android.ecom.arch.slice.render.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlcECTagElementViewManager f50577a;

        public c(SlcECTagElementViewManager r100) {
            this.f50577a = r100;
        }

        @Override // com.bytedance.android.ecom.arch.slice.render.b
        public final void a(r r100) {
            SlcECTagElementViewManager r101 = this.f50577a;
            SlcTemplateContext r102 = r101.f50260a;
            IAction r103 = r100.f49993a;
            View r104 = r100.f49996d;
            Map<String, ? extends Object> r105 = r101.l();
            Map<String, ? extends Object> r106 = this.f50577a.R3;
            Object r107 = null;
            if (r106 == null) goto L5;
            Object r108 = r106.get("tag_info");
        L7:
            if ((r108 instanceof Map) == false) goto L10;
            r107 = r108;
        L10:
            r102.d(r103, r104, r105, (Map) r107, r100.f49994b);
            return;
        L5:
            r108 = null;
            goto L7
        }
    }

    static {
        Z3 = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SlcECTagElementViewManager.class), UploadTypeInf.TIMER, "getTimer()Lcom/bytedance/android/ecom/arch/slice/render/elements/xelements/ectag/ECTagCloseableTimer;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SlcECTagElementViewManager.class), "timerListener", "getTimerListener()Lcom/bytedance/android/ecom/arch/slice/render/elements/xelements/ectag/SlcECTagElementViewManager$timerListener$2$1;"))};
        f50570c4 = new Companion();
        f50568a4 = new Rect();
        f50569b4 = LazyKt.lazy(LazyThreadSafetyMode.NONE, SlcECTagElementViewManager$Companion$ectagGlobalProps$2.INSTANCE);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final YogaNode B0() {
        YogaNode r100 = com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.f(this, false);
        r100.setFlexShrink(0.0f);
        r100.setAlignItems(YogaAlign.FLEX_START);
        return r100;
    }

    public final void k1() {
        if (this.U3 == false) goto L9;
        Lazy r100 = this.V3;
        KProperty[] r101 = Z3;
        KProperty r102 = r101[0];
        com.bytedance.android.ecom.arch.slice.render.elements.xelements.ectag.a r103 = (com.bytedance.android.ecom.arch.slice.render.elements.xelements.ectag.a) r100.getValue();
        Lazy r104 = this.W3;
        KProperty r105 = r101[1];
        SlcECTagElementViewManager$timerListener$2.a r106 = (SlcECTagElementViewManager$timerListener$2.a) r104.getValue();
        r103.getClass();
        nq.a.a();
        r103.f50582d.remove(r106);
        if (r103.f50582d.isEmpty() == false) goto L7;
        r103.f50580b = false;
        r103.f50581c.removeCallbacks(r103.f50583e);
    L7:
        this.U3 = false;
        return;
    }

    public final String l1() {
        if (Intrinsics.areEqual(this.S3, "slice") == true) goto L15;
        SliceRender.f50121o.getClass();
        pq.a r100 = SliceRender.f50108b;
        if (r100 == null) goto L10;
        pq.b r101 = r100.h();
        if (r101 == null) goto L10;
        String r102 = r101.f530257a;
    L11:
        if (r102 != null) goto L16;
        return "";
    L16:
        return r102;
    L10:
        r102 = null;
        goto L11
    L15:
        return "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/etag_template/" + this.Q3 + "/main.json";
    }

    public final SlcTemplateContext m1() {
        BaseSlcViewManager<?> r100 = this.I3;
        if (r100 != null) goto L5;
        Float r101 = com.bytedance.android.ecom.arch.slice.render.util.b.e(this.f50305r);
        if (r101 != null) goto L9;
    L12:
        com.bytedance.android.ecom.arch.slice.render.context.b r102 = this.f50260a.m();
    L13:
        float r103 = this.f50260a.m().f50242d;
        f50570c4.getClass();
        Lazy r104 = f50569b4;
        KProperty r105 = Companion.f50571a[0];
        ((HashMap) r104.getValue()).put("etag_font_scale", Float.valueOf(r103));
        SlcTemplateContext r106 = this.f50260a;
        p r107 = r106.f50236x;
        if (r107 == null) goto L16;
        String r108 = r107.f50691a;
    L18:
        if (r108 == null) goto L20;
        String r109 = r108;
    L21:
        String r110 = "SLICE_ECTAG_".concat(r106.n());
        p r111 = this.f50260a.f50236x;
        if (r111 == null) goto L26;
        String r112 = r111.f50693c;
        if (r112 == null) goto L26;
        String r113 = r112;
    L27:
        p r114 = new p(r109, r110, r113, null, 120);
        SlcTemplateContext r115 = new SlcTemplateContext(r106.f50235w, r114);
        r115.f50220h = r106.f50220h;
        r115.f50229q = r102;
        r115.t(new c(this));
        return r115;
    L26:
        r113 = "";
        goto L27
    L20:
        r109 = "";
        goto L21
    L16:
        r108 = null;
        goto L18
    L9:
        if (Intrinsics.areEqual(r101, 14.0f) == true) goto L12;
        float r116 = r101.floatValue() / 14.0f;
        com.bytedance.android.ecom.arch.slice.render.context.b r117 = this.f50260a.m();
        r102 = com.bytedance.android.ecom.arch.slice.render.context.b.a(r117, 0.0f, r117.f50240b * r116, r117.f50241c * r116, r117.f50242d * r116, 1);
        goto L13
    L5:
        return r100.f50260a;
    }

    public final void n1() {
        String r100 = this.f50260a.f50219g;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L14;
        nq.a.c(null, new SlcECTagElementViewManager$tryExposure$1(this), 1);
        k1();
        return;
    L14:
        if (Intrinsics.areEqual(this.S3, "slice") == false) goto L28;
        Map<String, ? extends Object> r102 = this.R3;
        if (r102 == null) goto L18;
        Object r103 = r102.get("tag_info");
    L20:
        if ((r103 instanceof Map) == true) goto L22;
        r103 = null;
    L22:
        Map r104 = (Map) r103;
        if (r104 == null) goto L27;
        Object r105 = r104.get("tag_code");
        if (r105 == null) goto L27;
        String r106 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r105);
    L29:
        if (r106 != null) goto L31;
    L34:
        boolean r107 = true;
    L35:
        if (r107 == false) goto L38;
        nq.a.c(null, new SlcECTagElementViewManager$tryExposure$2(this), 1);
        k1();
        return;
    L38:
        String r108 = "ECTag_" + r100 + '_' + r106;
        Companion r109 = f50570c4;
        SlcRenderContext r110 = this.f50260a.f50235w;
        r109.getClass();
        if (Companion.d(r110, r108) == false) goto L42;
        k1();
        return;
    L42:
        BaseSlcViewManager<?> r111 = this.I3;
        if (r111 == null) goto L121;
        boolean r112 = this.M3;
        SliceRender.f50121o.getClass();
        if (SliceRender.f() == true) goto L47;
        float r113 = Companion.h(r111.getView());
    L115:
        if (r113 > 0) goto L117;
        return;
    L117:
        if (r113 < 0.25f) goto L123;
        final Map<String, ? extends Object> r114 = this.N3;
        final Map<String, ? extends Object> r115 = this.R3;
        final String r116 = this.O3;
        final String r117 = this.P3;
        final String r118 = this.S3;
        final String r119 = this.Q3;
        Companion.l("etag_show", new SlcECTagElementViewManager$reportShowEvent$1(r114, r115, r116, r117, r118, r119));
        Companion.b(this.f50260a.f50235w, r108);
        k1();
        return;
    L123:
        return;
    L47:
        if (q0() == true) goto L50;
    L111:
        r113 = 0.0f;
        goto L115
    L50:
        if (getView().getVisibility() != 0) goto L111;
        Rect r120 = f50568a4;
        if (r111.s0() == true) goto L104;
        r120.set(0, 0, r111.j0(), r111.c0());
        if (Companion.m(r111, this, r120) == false) goto L104;
        if (r112 == false) goto L92;
        ViewParent r121 = getView().getParent();
        if ((r121 instanceof SlcECTagGroupElementView) == true) goto L62;
        r121 = null;
    L62:
        SlcECTagGroupElementView r122 = (SlcECTagGroupElementView) r121;
        if (r122 == null) goto L65;
        BaseSlcViewManager<?> r123 = SlcViewExtensionsKt.g(r122);
    L67:
        if ((r123 instanceof SlcECTagGroupElementViewManager) == true) goto L69;
        r123 = null;
    L69:
        final SlcECTagGroupElementViewManager r124 = (SlcECTagGroupElementViewManager) r123;
        if (r124 != null) goto L73;
        nq.a.c(null, new SlcECTagElementViewManager$Companion$getContentVisibleBounds$1(this), 1);
        goto L104
    L73:
        if (Companion.m(this, r124, r120) == false) goto L104;
        if ((r124.getView().getParent() instanceof SlcTextElementView) == false) goto L90;
        Object r125 = r124.getView().getParent();
        if ((r125 instanceof View) == true) goto L80;
        r125 = null;
    L80:
        View r126 = (View) r125;
        if (r126 == null) goto L83;
        BaseSlcViewManager<?> r127 = SlcViewExtensionsKt.g(r126);
    L84:
        if (r127 != null) goto L87;
        nq.a.c(null, new SlcECTagElementViewManager$Companion$getContentVisibleBounds$2(r124), 1);
        goto L104
    L87:
        if (Companion.m(r124, r127, r120) == false) goto L104;
        boolean r128 = Companion.c(r127, r120);
    L107:
        if (r128 == false) goto L111;
        int r129 = r111.getView().getWidth() * r111.getView().getHeight();
        if (r129 <= 0) goto L111;
        r113 = (float) ((((double) (r120.width() * r120.height())) * 1.0d) / ((double) r129));
        goto L115
    L83:
        r127 = null;
        goto L84
    L90:
        r128 = Companion.c(r124, r120);
        goto L107
    L65:
        r123 = null;
        goto L67
    L92:
        if ((getView().getParent() instanceof SlcTextElementView) == false) goto L106;
        Object r130 = getView().getParent();
        if ((r130 instanceof View) == true) goto L96;
        r130 = null;
    L96:
        View r131 = (View) r130;
        if (r131 == null) goto L99;
        BaseSlcViewManager<?> r132 = SlcViewExtensionsKt.g(r131);
    L100:
        if (r132 != null) goto L103;
        nq.a.c(null, new SlcECTagElementViewManager$Companion$getContentVisibleBounds$3(this), 1);
        goto L104
    L103:
        if (Companion.m(this, r132, r120) == false) goto L104;
        r128 = Companion.c(r132, r120);
        goto L107
    L99:
        r132 = null;
        goto L100
    L106:
        r128 = Companion.c(this, r120);
    L104:
        r128 = false;
        goto L107
    L121:
        return;
    L31:
        if (r106.length() == 0) goto L34;
        r107 = false;
    L27:
        r106 = null;
        goto L29
    L18:
        r103 = null;
        goto L20
    L28:
        r106 = String.valueOf(l().hashCode());
        goto L29
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L10
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final String T() {
        return U();
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final String U() {
        String r100 = super.T();
        int r101 = 0;
        if (r100.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return r100;
    L8:
        int r103 = getView().getChildCount();
    L9:
        if (r101 >= r103) goto L18;
        View r104 = getView().getChildAt(r101);
        if (r104 == null) goto L17;
        BaseSlcViewManager<?> r105 = SlcViewExtensionsKt.g(r104);
        if (r105 == null) goto L17;
        if ((!Intrinsics.areEqual(r105.p0(), Boolean.TRUE)) == false) goto L17;
        r100 = r100 + r105.U();
    L17:
        r101 = r101 + 1;
        goto L9
    L18:
        return r100;
    L5:
        r102 = false;
        goto L6
    }

    public SlcECTagElementViewManager(final SlcTemplateContext r100) {
        super(r100);
        this.O3 = r100.f50235w.f50185l0;
        this.P3 = r100.n();
        this.S3 = "feature";
        this.V3 = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new SlcECTagElementViewManager$timer$2(r100));
        this.W3 = LazyKt.lazy(new SlcECTagElementViewManager$timerListener$2(this));
        this.X3 = new a(this);
        this.f50285j3 = true;
        this.f50289k3 = true;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final View A0(Context r100) {
        return new SlcECTagElementView(r100, null, 6, 0);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final com.bytedance.android.ecom.arch.slice.render.util.accessibility.b E(MotionEvent r100) {
        final int r101 = getView().getChildCount();
        final int r102 = 0;
    L3:
        if (r102 >= r101) goto L23;
        View r103 = getView().getChildAt(r102);
        if (r103 == null) goto L7;
        BaseSlcViewManager<?> r104 = SlcViewExtensionsKt.g(r103);
    L9:
        if (r104 != null) goto L11;
        nq.a.c(null, new SlcECTagElementViewManager$dispatchHoverEventA11y$1(this, r102, r101), 1);
    L21:
        r102 = r102 + 1;
        goto L3
    L11:
        if ((!Intrinsics.areEqual(r104.p0(), Boolean.TRUE)) == false) goto L21;
        if (r104.y() == false) goto L21;
        if (r104.t0(r100.getRawX(), r100.getRawY()) == false) goto L21;
        float r105 = h0() - r104.getView().getLeft();
        float r106 = i0() - r104.getView().getTop();
        r100.offsetLocation(r105, r106);
        com.bytedance.android.ecom.arch.slice.render.util.accessibility.b r107 = r104.E(r100);
        r100.offsetLocation(-r105, -r106);
        if (r107 == null) goto L21;
        return new com.bytedance.android.ecom.arch.slice.render.util.accessibility.b(this, false);
    L7:
        r104 = null;
        goto L9
    L23:
        return super.E(r100);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void H0(Map<String, ? extends Object> r100) {
        String r101 = this.Q3;     // Catch: Throwable -> L31
        o1(r100);     // Catch: Throwable -> L31
        Map<String, ? extends Object> r102 = this.K3;     // Catch: Throwable -> L31
        if (r102 != null) goto L6;
    L9:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
        b1(false);     // Catch: Throwable -> L31
        return;
    L12:
        b1(true);     // Catch: Throwable -> L31
        f50570c4.getClass();     // Catch: Throwable -> L31
        Lazy r104 = f50569b4;     // Catch: Throwable -> L31
        KProperty r105 = Companion.f50571a[0];     // Catch: Throwable -> L31
        this.J3 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("data", this.K3), TuplesKt.to(BaseHybridComponent.GLOBAL_PROPS, (HashMap) r104.getValue())});     // Catch: Throwable -> L31
        if (r101 != null) goto L15;
    L24:
        i r106 = new i(l1(), "SLICE_ECTAG_".concat(this.f50260a.n()), "");     // Catch: Throwable -> L31
        b r107 = this.H3;     // Catch: Throwable -> L31
        if (r107 == null) goto L27;
        r107.f50576b = true;     // Catch: Throwable -> L31
    L27:
        b r108 = new b(new WeakReference(this));     // Catch: Throwable -> L31
        this.H3 = r108;     // Catch: Throwable -> L31
        SlcRenderContext r109 = this.f50260a.f50235w;     // Catch: Throwable -> L31
        g r110 = r109.f50163a0;     // Catch: Throwable -> L31
        if (r110 == null) goto L40;
        r110.a(r106, r109.f50176h, r108);     // Catch: Throwable -> L31
        return;
    L40:
        return;
    L15:
        if ((!Intrinsics.areEqual(r101, this.Q3)) == true) goto L24;
        if (this.L3 == false) goto L36;
        Map<String, ? extends Object> r111 = this.J3;     // Catch: Throwable -> L31
        if (r111 == null) goto L37;
        BaseSlcViewManager<?> r112 = this.I3;     // Catch: Throwable -> L31
        if (r112 == null) goto L38;
        r112.x(r111);     // Catch: Throwable -> L31
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L6:
        if (r102.isEmpty() == true) goto L9;
        r103 = false;
    L31:
        th = move-exception;
        nq.a.b(th, new SlcECTagElementViewManager$onUpdateProp$2(th));
        String r113 = th.getMessage();
        String r114 = this.O3;
        String r115 = this.P3;
        String r116 = this.S3;
        Companion r117 = f50570c4;
        SlcECTagElementViewManager$reportErrorEvent$1 r118 = new SlcECTagElementViewManager$reportErrorEvent$1("BIND_DATA", r113, r114, r115, r116);
        r117.getClass();
        Companion.l("etag_runtime_error", r118);
        throw th;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final BaseSlcViewManager<?> M(String r100) {
        BaseSlcViewManager<?> r101 = super.M(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        BaseSlcViewManager<?> r102 = this.I3;
        if (r102 != null) goto L10;
        return null;
    L10:
        return r102.M(r100);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void U0(List<Float> r100) {
        SlcViewExtensionsKt.j(this, r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Map<java.lang.String, ? extends java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final void o1(Map<String, ? extends Object> r110) {
        Object r100 = r110.get("data");
        ?? r101 = 0;
        Map r102 = null;
        r101 = 0;
        r101 = 0;
        r101 = 0;
        if ((r100 instanceof Map) == true) goto L5;
        r100 = null;
    L5:
        ?? r103 = (Map) r100;
        boolean r104 = false;
        if (this.M3 == true) goto L31;
        Object r105 = r110.get("track_params");
        if ((r105 instanceof Map) == true) goto L10;
        r105 = null;
    L10:
        this.N3 = (Map) r105;
        String r106 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r110.get("tag_show_scene"));
        if (r106 != null) goto L13;
    L16:
        boolean r107 = true;
    L17:
        if (r107 == false) goto L20;
        r106 = this.f50260a.f50235w.f50185l0;
    L20:
        this.O3 = r106;
        String r111 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r110.get("tag_show_page_position"));
        if (r111 != null) goto L23;
    L26:
        boolean r108 = true;
    L27:
        if (r108 == false) goto L30;
        r111 = this.f50260a.n();
    L30:
        this.P3 = r111;
        goto L31
    L23:
        if (StringsKt.isBlank(r111) == true) goto L26;
        r108 = false;
        goto L27
    L13:
        if (StringsKt.isBlank(r106) == true) goto L16;
        r107 = false;
    L31:
        String r112 = "feature";
        if (r103 == 0) goto L116;
        String r109 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r103.get("data_type"));
        if (r109 == null) goto L36;
        r112 = r109;
    L36:
        this.S3 = r112;
        if (Intrinsics.areEqual(r112, "slice") == false) goto L102;
        Object r113 = r103.get("etag_data");
        if ((r113 instanceof Map) == true) goto L41;
        r113 = null;
    L41:
        Companion r114 = f50570c4;
        r114.getClass();
        Map r115 = Companion.j((Map) r113);
        if (r115 == null) goto L44;
        Object r116 = r115.get("etag_template_id");
    L45:
        this.Q3 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r116);
        if (r115 == null) goto L48;
        Object r117 = r115.get("etag_log_extra");
    L50:
        if ((r117 instanceof Map) == true) goto L52;
        r117 = null;
    L52:
        this.R3 = (Map) r117;
        float r118 = Companion.g(r115);
        Map r119 = Companion.k(r115);
        if (r119 == null) goto L57;
        Object r120 = r119.get("tag_code");
        if (r120 == null) goto L57;
        String r121 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r120);
    L58:
        if (r121 != null) goto L60;
    L63:
        boolean r122 = true;
    L64:
        if (r122 == false) goto L66;
        SlcECTagElementViewManager$reportErrorEvent$1 r123 = new SlcECTagElementViewManager$reportErrorEvent$1("TAG_CODE_NULL", "tag_code is null or an empty string", this.O3, this.P3, this.S3);
        r114.getClass();
        Companion.l("etag_runtime_error", r123);
    L66:
        if (r115 == null) goto L68;
        Object r124 = r115.get("etag_raw_data");
    L70:
        if ((r124 instanceof Map) == true) goto L72;
        r124 = null;
    L72:
        Map r125 = (Map) r124;
        if (r125 == null) goto L75;
        Object r126 = r125.get(SlcCommonAction.KEY_PARAMS);
    L77:
        if ((r126 instanceof Map) == true) goto L79;
        r126 = null;
    L79:
        Map r127 = (Map) r126;
        if (r122 == false) goto L82;
    L117:
        this.K3 = r101;
        return;
    L82:
        if (r118 <= 0) goto L117;
        if (r127 != null) goto L85;
    L86:
        r104 = true;
    L87:
        if (r104 == true) goto L117;
        r103 = new HashMap();
        r103.putAll(r127);
        Object r128 = r127.get("extra_fields");
        if ((r128 instanceof String) == false) goto L93;
        SlcECTagGroupElementViewManager.f50591d4.getClass();
        Map r129 = (Map) GsonProtectorUtils.fromJson(SlcECTagGroupElementViewManager.a.c(), (String) r128, Map.class);
    L97:
        if ((r129 instanceof Map) == false) goto L100;
        r102 = r129;
    L100:
        if (r102 == null) goto L115;
        r103.putAll(r102);
    L115:
        r101 = r103;
        goto L117
    L93:
        if ((r128 instanceof Map) == false) goto L95;
        r129 = (Map) r128;
        goto L97
    L95:
        r129 = null;
        goto L97
    L85:
        if (r127.isEmpty() == false) goto L87;
    L75:
        r126 = null;
        goto L77
    L68:
        r124 = null;
        goto L70
    L60:
        if (r121.length() == 0) goto L63;
        r122 = false;
    L57:
        r121 = null;
        goto L58
    L48:
        r117 = null;
        goto L50
    L44:
        r116 = null;
        goto L45
    L102:
        this.Q3 = null;
        this.R3 = null;
        int r130 = com.bytedance.android.ecom.arch.slice.render.util.b.f(r103.get("version"), 0);
        f50570c4.getClass();
        if (r130 <= 1) goto L115;
        Object r131 = r103.get("fallback");
        if ((r131 instanceof List) == true) goto L107;
        r131 = null;
    L107:
        Map r132 = Companion.i((List) r131);
        if (r132 != null) goto L110;
    L111:
        r104 = true;
    L112:
        if (r104 == true) goto L114;
        r101 = r132;
        goto L117
    L114:
        nq.a.c(null, SlcECTagElementViewManager$updateECTagData$2.INSTANCE, 1);
        goto L115
    L110:
        if (r132.isEmpty() == false) goto L112;
    L116:
        this.S3 = "feature";
        this.Q3 = null;
        this.R3 = null;
        goto L117
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void v0(Map<String, ? extends Object> r110) {
        if (r0() == false) goto L6;
        k1();
    L17:
        int r111 = SlcEventHelper.f50626a;
        final long r100 = System.nanoTime() - this.Y3;
        final String r101 = this.O3;
        final String r102 = this.P3;
        final String r103 = this.S3;
        Companion r112 = f50570c4;
        Function0<HashMap<String, Object>> r104 = new SlcECTagElementViewManager$reportPerfEvent$1(r101, r102, r103, r100);
        r112.getClass();
        Companion.l("etag_performance_log", r104);
        return;
    L6:
        if (this.f50260a.f50235w.f50170e == true) goto L17;
        if (this.T3 == true) goto L11;
        getView().addOnAttachStateChangeListener(this.X3);
        this.T3 = true;
    L11:
        if (getView().isAttachedToWindow() == false) goto L17;
        boolean r113 = this.U3;
        if (r113 == true) goto L17;
        if (r113 == true) goto L17;
        this.U3 = true;
        Lazy r114 = this.V3;
        KProperty[] r105 = Z3;
        KProperty r106 = r105[0];
        com.bytedance.android.ecom.arch.slice.render.elements.xelements.ectag.a r115 = (com.bytedance.android.ecom.arch.slice.render.elements.xelements.ectag.a) r114.getValue();
        Lazy r107 = this.W3;
        KProperty r108 = r105[1];
        r115.a((SlcECTagElementViewManager$timerListener$2.a) r107.getValue());
        n1();
        goto L17
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final Map<String, Object> z0(Map<String, ? extends Object> r100) {
        int r101 = SlcEventHelper.f50626a;
        this.Y3 = System.nanoTime();
        return r100;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void V0(List<?> r100, float r101) {
        this.f50272f.setBorder(YogaEdge.ALL, SlcDimensExtensionsKt.a(Float.valueOf(r101), this.f50260a.m()));
        SlcViewExtensionsKt.j(this, com.bytedance.android.ecom.arch.slice.render.util.b.d(r100));
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final long u0(float r100, YogaMeasureMode r101, float r102, YogaMeasureMode r103) {
        return YogaMeasureOutput.make(0, 0);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void v(int r100, int r101, int r102, int r103) {
        super.v(r100, r101, r102, r103);
        if (getView().getVisibility() != 8) goto L5;
        return;
    L5:
        BaseSlcViewManager<?> r104 = this.I3;
        if (r104 == null) goto L9;
        int r105 = Math.round(r104.f50272f.getLayoutX());
        int r106 = Math.round(r104.f50272f.getLayoutY());
        r104.v(r105, r106, Math.round(r104.f50272f.getLayoutWidth()) + r105, Math.round(r104.f50272f.getLayoutHeight()) + r106);
        return;
    }
}
