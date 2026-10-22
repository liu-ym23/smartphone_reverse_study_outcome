package com.bytedance.android.ecom.arch.slice.render.context;

import android.content.Context;
import android.view.View;
import com.bytedance.android.annie.card.base.BaseHybridComponent;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.SlcActionSource;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.action.q;
import com.bytedance.android.ecom.arch.slice.action.ui.SlcUIActionErrorCode;
import com.bytedance.android.ecom.arch.slice.render.SlcActionErrorCode;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.cache.DefaultViewManagerPool;
import com.bytedance.android.ecom.arch.slice.render.cache.TemplateViewPool;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.elements.ElementTypes;
import com.bytedance.android.ecom.arch.slice.render.event.SlcEventHelper;
import com.bytedance.android.ecom.arch.slice.render.event.SlcPerfManager;
import com.bytedance.android.ecom.arch.slice.render.exposure.SlcTemplateExposureMgr;
import com.bytedance.android.ecom.arch.slice.render.n;
import com.bytedance.android.ecom.arch.slice.render.p;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.ecom.arch.slice.template.JsonTemplate;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class SlcTemplateContext {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f50212y = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.ecom.arch.slice.render.b f50213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f50214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f50215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f50216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public r f50217e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BaseSlcViewManager<?> f50218f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f50219g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SlcPerfManager f50220h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HashMap<Object, Object> f50221i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map<String, ? extends Object> f50222j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f50223k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f50224l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f50225m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f50226n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SlcTemplateExposureMgr f50227o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public HashMap<String, com.bytedance.android.ecom.arch.slice.render.widget.animation.b> f50228p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public b f50229q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Function1<com.bytedance.android.ecom.arch.slice.expr.c, Unit> f50230r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f50231s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Map<String, ? extends Object> f50232t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ArrayList<Runnable> f50233u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f50234v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final SlcRenderContext f50235w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final p f50236x;

    public static final class a {
    }

    static {
    }

    public final void b() {
        this.f50220h.f50630d = true;
    }

    public final Context getContext() {
        return this.f50235w.getContext();
    }

    public final float i() {
        BaseSlcViewManager<?> r100 = this.f50218f;
        if (r100 == null) goto L9;
        SlcElement r101 = r100.f50270e;
        if (r101 == null) goto L9;
        n r102 = r101.getConfig();
        if (r102 == null) goto L9;
        String r103 = r102.a();
    L10:
        if (r103 != null) goto L12;
    L15:
        boolean r104 = true;
    L16:
        if (r104 == true) goto L21;
        com.bytedance.android.ecom.arch.slice.render.e r105 = this.f50235w.f50167c0;
        if (r105 == null) goto L21;
        return r105.b(r103);
    L21:
        return 0.0f;
    L12:
        if (StringsKt.isBlank(r103) == true) goto L15;
        r104 = false;
    L9:
        r103 = null;
        goto L10
    }

    public final SlcTemplateExposureMgr l() {
        SlcTemplateExposureMgr r100 = this.f50227o;
        if (r100 != null) goto L18;
        r100 = new SlcTemplateExposureMgr(this);
        if (this.f50218f == null) goto L7;
        boolean r101 = true;
    L8:
        nq.a.d(r101, null, null);
        BaseSlcViewManager<?> r102 = this.f50218f;
        if (r102 == null) goto L17;
        r102.getView().addOnAttachStateChangeListener(r100.f50663e);
        if (r102.getView().isAttachedToWindow() == false) goto L17;
        boolean r103 = r100.f50662d;
        if (r103 == true) goto L17;
        if (r103 == true) goto L17;
        r100.f50662d = true;
        Lazy r104 = r100.f50660b;
        KProperty r105 = SlcTemplateExposureMgr.f50658h[0];
        ((ar.a) r104.getValue()).a(r100.f50661c);
        r100.a();
    L17:
        this.f50227o = r100;
        goto L18
    L7:
        r101 = false;
    L18:
        return r100;
    }

    public final b m() {
        b r100 = this.f50229q;
        if (r100 != null) goto L69;
        b r101 = this.f50235w.f50172f;
        BaseSlcViewManager<?> r102 = this.f50218f;
        boolean r103 = false;
        if (r102 == null) goto L11;
        SlcElement r104 = r102.f50270e;
        if (r104 == null) goto L11;
        n r105 = r104.getConfig();
        if (r105 == null) goto L11;
        boolean r106 = r105.b();
    L12:
        if (r106 == false) goto L14;
        b.f50238f.getClass();
        float r107 = b.f50237e.f50239a;
    L15:
        BaseSlcViewManager<?> r108 = this.f50218f;
        if (r108 == null) goto L24;
        SlcElement r109 = r108.f50270e;
        if (r109 == null) goto L24;
        n r110 = r109.getConfig();
        if (r110 == null) goto L24;
        if (r110.c() != true) goto L24;
        boolean r111 = true;
    L25:
        if (r111 == false) goto L27;
        float r112 = r107;
        float r113 = r112;
    L61:
        if (r107 == r101.f50239a) goto L63;
    L67:
        r100 = b.a(r101, r107, r113, r112, 0.0f, 8);
    L68:
        this.f50229q = r100;
        goto L69
    L63:
        if (r113 != r101.f50240b) goto L67;
        if (r112 != r101.f50241c) goto L67;
        r100 = r101;
        goto L68
    L27:
        BaseSlcViewManager<?> r114 = this.f50218f;
        if (r114 == null) goto L34;
        SlcElement r115 = r114.f50270e;
        if (r115 == null) goto L34;
        n r116 = r115.getConfig();
        if (r116 == null) goto L34;
        String r117 = r116.a();
    L35:
        if (r117 != null) goto L37;
    L38:
        r103 = true;
    L40:
        if (r103 == true) goto L45;
        com.bytedance.android.ecom.arch.slice.render.e r118 = this.f50235w.f50167c0;
        if (r118 == null) goto L45;
        float r119 = r118.a(r117);
    L46:
        float r120 = i();
        if (r119 > 0.0f) goto L51;
        if (r106 == false) goto L52;
        r119 = r101.f50241c / r101.f50239a;
        goto L51
    L52:
        float r121 = r101.f50241c;
    L54:
        if (r120 <= 0.0f) goto L56;
        r113 = r120 * r107;
    L59:
        r112 = r121;
        goto L61
    L56:
        if (r106 == false) goto L58;
        r113 = (r101.f50240b / r101.f50239a) * r107;
        goto L59
    L58:
        r113 = r101.f50240b;
    L51:
        r121 = r119 * r107;
    L45:
        r119 = 0.0f;
        goto L46
    L37:
        if (StringsKt.isBlank(r117) == false) goto L40;
    L34:
        r117 = null;
    L24:
        r111 = false;
        goto L25
    L14:
        r107 = r101.f50239a;
    L11:
        r106 = false;
    L69:
        return r100;
    }

    public final String n() {
        p r100 = this.f50236x;
        if (r100 == null) goto L5;
        String r101 = r100.f50692b;
    L6:
        if (r101 != null) goto L10;
        return "";
    L10:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public final BaseSlcViewManager<?> h(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return null;
    L11:
        BaseSlcViewManager<?> r102 = this.f50218f;
        if (r102 != null) goto L14;
        return null;
    L14:
        return r102.M(r100);
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L9
    }

    public final Object o(Object r100) {
        HashMap<Object, Object> r101 = this.f50221i;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    public final Object q(String r100) {
        SliceRender.f50121o.getClass();
        pq.a r101 = SliceRender.f50108b;
        if (r101 == null) goto L14;
        String r102 = this.f50235w.E;
        if (r102 != null) goto L10;
        r102 = this.f50234v;
        if (r102 != null) goto L10;
        r102 = "slice_" + this.f50235w.f50185l0;
        this.f50234v = r102;
    L10:
        if (r100 != null) goto L16;
        r100 = n();
    L16:
        return r101.provideImageCallerContext(r102, r100);
    L14:
        return null;
    }

    public final Map<String, Object> r(Map<String, ? extends Object> r100) {
        HashMap r101 = new HashMap();
        r101.putAll(r100);
        Map<String, ? extends Object> r102 = this.f50232t;
        if (r102 != null) goto L32;
        float r103 = i();
        BaseSlcViewManager<?> r104 = this.f50218f;
        boolean r105 = false;
        if (r104 == null) goto L13;
        SlcElement r106 = r104.f50270e;
        if (r106 == null) goto L13;
        n r107 = r106.getConfig();
        if (r107 == null) goto L13;
        boolean r108 = true;
        if (r107.c() != true) goto L13;
    L14:
        if (r108 == false) goto L16;
    L30:
        SliceRender r109 = SliceRender.f50121o;
        Context r110 = getContext();
        b r111 = m();
        Map<String, ? extends Object> r112 = this.f50235w.F;
        r109.getClass();
        r102 = SliceRender.h(r110, r111, r112);
    L31:
        this.f50232t = r102;
        goto L32
    L16:
        if (r103 > 0) goto L30;
        BaseSlcViewManager<?> r113 = this.f50218f;
        if (r113 == null) goto L24;
        SlcElement r114 = r113.f50270e;
        if (r114 == null) goto L24;
        n r115 = r114.getConfig();
        if (r115 == null) goto L24;
        r105 = r115.b();
    L24:
        if (r105 == true) goto L30;
        SlcRenderContext r116 = this.f50235w;
        Map<String, ? extends Object> r117 = r116.T;
        if (r117 != null) goto L29;
        SliceRender r118 = SliceRender.f50121o;
        Context r119 = r116.f50183k0;
        b r120 = r116.f50172f;
        Map<String, ? extends Object> r121 = r116.F;
        r118.getClass();
        r117 = SliceRender.h(r119, r120, r121);
        r116.T = r117;
    L29:
        r102 = r117;
    L13:
        r108 = false;
    L32:
        r101.put(BaseHybridComponent.GLOBAL_PROPS, r102);
        return r101;
    }

    public final void t(final com.bytedance.android.ecom.arch.slice.render.b r100) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            r3.f50213a = r4
            r0 = 1
            r3.f50225m = r0
            if (r4 == 0) goto Lb
            r4 = 0
            r3.f50226n = r4
            goto L27
        Lb:
            r3.f50226n = r0
            java.lang.String r0 = "slice_set_action_handler_null"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L15
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L15
            throw r1     // Catch: java.lang.Throwable -> L15
        L15:
            r1 = move-exception
            nq.a.f(r1, r0)
            int r0 = r3.hashCode()
            int r2 = com.bytedance.android.ecom.arch.slice.utils.a.f51057a
            com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext$setActionHandler$1 r2 = new com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext$setActionHandler$1
            r2.<init>(r3, r1, r0, r4)
            com.bytedance.android.ecom.arch.slice.utils.a.b(r2)
        L27:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext.t(com.bytedance.android.ecom.arch.slice.render.b):void");
    }

    public final void u(Object r100) {
        HashMap<Object, Object> r101 = this.f50221i;
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }

    public SlcTemplateContext(SlcRenderContext r100, p r101) {
        this.f50235w = r100;
        this.f50236x = r101;
        this.f50216d = true;
        this.f50220h = new SlcPerfManager(this);
        this.f50230r = new SlcTemplateContext$exprFailCallback$1(this);
    }

    public final void a(Map<String, ? extends Object> r110, String r111) {
        this.f50216d = com.bytedance.android.ecom.arch.slice.render.util.h.b();
        int r100 = 0;
        boolean r101 = true;
        Throwable r102 = null;
        this.f50231s = 0;     // Catch: Throwable -> L90
        this.f50219g = r111;     // Catch: Throwable -> L90
        this.f50222j = r110;     // Catch: Throwable -> L90
        BaseSlcViewManager<?> r103 = this.f50218f;     // Catch: Throwable -> L90
        if (r103 == null) goto L64;
        SlcPerfManager r104 = this.f50220h;     // Catch: Throwable -> L90
        r104.getClass();     // Catch: Throwable -> L90
        sq.a r105 = new sq.a();     // Catch: Throwable -> L90
        r104.f50628b = r105;     // Catch: Throwable -> L90
        int r106 = SlcEventHelper.f50626a;     // Catch: Throwable -> L90
        r105.f542920a = System.nanoTime();     // Catch: Throwable -> L90
        sq.a r107 = r104.f50628b;     // Catch: Throwable -> L90
        SlcRenderContext r108 = r104.f50633g.f50235w;     // Catch: Throwable -> L90
        r107.f542922c = r108.f50168d;     // Catch: Throwable -> L90
        r107.f542924e = r108.f50170e;     // Catch: Throwable -> L90
        this.f50223k++;     // Catch: Throwable -> L90
        r103.x(r(r110));     // Catch: Throwable -> L90
        BaseSlcViewManager<?> r112 = this.f50218f;     // Catch: Throwable -> L90
        if (r112 == null) goto L40;
        View r113 = r112.getView();     // Catch: Throwable -> L90
        if (r113 == null) goto L40;
        if (this.f50231s <= 0) goto L13;
        r113.setClickable(true);     // Catch: Throwable -> L90
    L15:
        ArrayList<com.bytedance.android.ecom.arch.slice.render.context.a> r114 = this.f50235w.f50188n;
        if (r114 != null) goto L18;
    L21:
        boolean r109 = true;
    L22:
        if (r109 == true) goto L26;
        int r115 = r114.size();
        int r116 = 0;
    L24:
        if (r116 >= r115) goto L26;
        ((com.bytedance.android.ecom.arch.slice.render.context.a) ListProtector.get(r114, r116)).a(this, r111, null);
        r116 = r116 + 1;
    L26:
        ArrayList<Runnable> r117 = this.f50233u;
        if (r117 != null) goto L29;
    L32:
        boolean r118 = true;
    L33:
        if (r118 == true) goto L38;
        int r119 = r117.size();
    L35:
        if (r100 >= r119) goto L37;
        ((Runnable) ListProtector.get(r117, r100)).run();
        r100 = r100 + 1;
        goto L35
    L37:
        r117.clear();
    L38:
        this.f50220h.a(true);
        return;
    L29:
        if (r117.isEmpty() == true) goto L32;
        r118 = false;
        goto L33
    L18:
        if (r114.isEmpty() == true) goto L21;
        r109 = false;
        goto L22
    L13:
        if (r113.hasOnClickListeners() == true) goto L15;
        r113.setClickable(false);     // Catch: Throwable -> L90
    L40:
        ArrayList<com.bytedance.android.ecom.arch.slice.render.context.a> r120 = this.f50235w.f50188n;
        if (r120 != null) goto L43;
    L46:
        boolean r121 = true;
    L47:
        if (r121 == true) goto L51;
        int r122 = r120.size();
        int r123 = 0;
    L49:
        if (r123 >= r122) goto L51;
        ((com.bytedance.android.ecom.arch.slice.render.context.a) ListProtector.get(r120, r123)).a(this, r111, null);
        r123 = r123 + 1;
    L51:
        ArrayList<Runnable> r124 = this.f50233u;
        if (r124 != null) goto L54;
    L57:
        boolean r125 = true;
    L58:
        if (r125 == true) goto L63;
        int r126 = r124.size();
    L60:
        if (r100 >= r126) goto L62;
        ((Runnable) ListProtector.get(r124, r100)).run();
        r100 = r100 + 1;
        goto L60
    L62:
        r124.clear();
    L63:
        SlcPerfManager r127 = this.f50220h;
    L88:
        r127.a(true);
        return;
    L54:
        if (r124.isEmpty() == true) goto L57;
        r125 = false;
        goto L58
    L43:
        if (r120.isEmpty() == true) goto L46;
        r121 = false;
        goto L47
    L64:
        ArrayList<com.bytedance.android.ecom.arch.slice.render.context.a> r128 = this.f50235w.f50188n;
        if (r128 != null) goto L67;
    L70:
        boolean r129 = true;
    L71:
        if (r129 == true) goto L75;
        int r130 = r128.size();
        int r131 = 0;
    L73:
        if (r131 >= r130) goto L75;
        ((com.bytedance.android.ecom.arch.slice.render.context.a) ListProtector.get(r128, r131)).a(this, r111, null);
        r131 = r131 + 1;
    L75:
        ArrayList<Runnable> r132 = this.f50233u;
        if (r132 != null) goto L78;
    L81:
        boolean r133 = true;
    L82:
        if (r133 == true) goto L87;
        int r134 = r132.size();
    L84:
        if (r100 >= r134) goto L86;
        ((Runnable) ListProtector.get(r132, r100)).run();
        r100 = r100 + 1;
        goto L84
    L86:
        r132.clear();
    L87:
        r127 = this.f50220h;
        goto L88
    L78:
        if (r132.isEmpty() == true) goto L81;
        r133 = false;
        goto L82
    L67:
        if (r128.isEmpty() == true) goto L70;
        r129 = false;
    L90:
        th = move-exception;
        this.f50224l++;     // Catch: Throwable -> L96
        SlcRenderContext r135 = this.f50235w;     // Catch: Throwable -> L94
        Function0<Unit> r136 = new SlcTemplateContext$bindData$1(this, th);     // Catch: Throwable -> L94
        r135.getClass();     // Catch: Throwable -> L94
        SlcRenderContext.m(r136);     // Catch: Throwable -> L94
        throw th;     // Catch: Throwable -> L94
    L94:
        th = move-exception;
        r102 = th;
        th = th;
    L97:
        if (r102 != null) goto L99;
        boolean r137 = true;
    L100:
        ArrayList<com.bytedance.android.ecom.arch.slice.render.context.a> r138 = this.f50235w.f50188n;
        if (r138 != null) goto L103;
    L106:
        boolean r139 = true;
    L107:
        if (r139 == true) goto L111;
        int r140 = r138.size();
        int r141 = 0;
    L109:
        if (r141 >= r140) goto L111;
        ((com.bytedance.android.ecom.arch.slice.render.context.a) ListProtector.get(r138, r141)).a(this, r111, r102);
        r141 = r141 + 1;
    L111:
        ArrayList<Runnable> r142 = this.f50233u;
        if (r142 != null) goto L114;
    L117:
        if (r101 == true) goto L122;
        int r143 = r142.size();
    L119:
        if (r100 >= r143) goto L121;
        ((Runnable) ListProtector.get(r142, r100)).run();
        r100 = r100 + 1;
        goto L119
    L121:
        r142.clear();
    L122:
        this.f50220h.a(r137);
        throw th;
    L114:
        if (r142.isEmpty() == true) goto L117;
        r101 = false;
        goto L117
    L103:
        if (r138.isEmpty() == true) goto L106;
        r139 = false;
        goto L107
    L99:
        r137 = false;
    L96:
        th = th;
        goto L97
    }

    public final Map<String, Object> f(Map<String, String> r100, Map<String, ? extends Object> r101) {
        if (r100 != null) goto L4;
    L7:
        boolean r102 = true;
    L8:
        if (r102 == false) goto L11;
        return null;
    L11:
        HashMap r103 = new HashMap((int) ((r100.size() / 0.75f) + 1.0f));
        Iterator<Map.Entry<String, String>> r104 = r100.entrySet().iterator();
    L13:
        if (r104.hasNext() == false) goto L15;
        Map.Entry<String, String> r105 = r104.next();
        r103.put(r105.getKey(), this.f50235w.f50187m0.a(r105.getValue(), r101, this.f50230r));
        goto L13
    L15:
        return r103;
    L4:
        if (r100.isEmpty() == true) goto L7;
        r102 = false;
        goto L8
    }

    public final Map<String, Object> g(Map<String, ? extends Object> r100, Map<String, ? extends Object> r110) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L12;
        return null;
    L12:
        HashMap r102 = new HashMap((int) ((r100.size() / 0.75f) + 1.0f));
        Iterator<Map.Entry<String, ? extends Object>> r103 = r100.entrySet().iterator();
    L14:
        if (r103.hasNext() == false) goto L36;
        Map.Entry<String, ? extends Object> r104 = r103.next();
        String r105 = r104.getKey();
        if (r105.length() <= 0) goto L18;
        boolean r106 = true;
    L19:
        if (r106 == true) goto L21;
    L23:
        boolean r107 = false;
    L24:
        if (r107 == true) goto L25;
        r102.put(r104.getKey(), r104.getValue());
        goto L14
    L25:
        Object r108 = r104.getValue();
        if ((r108 instanceof String) == true) goto L28;
        r108 = null;
    L28:
        String r109 = (String) r108;
        if (r109 == null) goto L14;
        String r111 = r104.getKey();
        if (r111 == null) goto L34;
        r102.put(r111.substring(1), this.f50235w.f50187m0.a(r109, r110, this.f50230r));
        goto L14
    L34:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L21:
        if (r105.charAt(0) != ':') goto L23;
        r107 = true;
        goto L24
    L18:
        r106 = false;
        goto L19
    L36:
        return r102;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L10
    }

    @SlcUIActionErrorCode
    public final void p(final String r100, final lq.b r101) {
        final int r102 = 1;
        if (r101.getType().length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L12;
        BaseSlcViewManager<?> r104 = h(r100);
        if (r104 != null) goto L11;
        r102 = 2;
        goto L12
    L11:
        r102 = r104.k0(r101);
    L12:
        if (r102 == 0) goto L17;
        int r105 = com.bytedance.android.ecom.arch.slice.utils.a.f51057a;
        Function1<pq.c, Unit> r106 = new SlcTemplateContext$handleUIAction$1(r100, r101, r102);
        SliceRender.f50121o.getClass();
        pq.a r107 = SliceRender.f50108b;
        if (r107 == null) goto L18;
        r107.g(5, r106);
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r103 = false;
        goto L6
    }

    public final void s(Object r100, Object r101) {
        HashMap<Object, Object> r102 = this.f50221i;
        if (r102 != null) goto L5;
        r102 = new HashMap();
        this.f50221i = r102;
    L5:
        r102.put(r100, r101);
    }

    public final BaseSlcViewManager<?> c(String r100, boolean r101, boolean r110) {
        BaseSlcViewManager<?> r102 = null;
        if (r110 == true) goto L33;
        if (r101 == false) goto L27;
        SlcRenderContext r103 = this.f50235w;
        if (r103.f50195u == false) goto L27;
        if (this.f50214b == true) goto L27;
        TemplateViewPool r104 = r103.f50162a;
        if (r100 == null) goto L23;
        DefaultViewManagerPool r111 = r104.f50155c.get(r100);
        if (r111 == null) goto L20;
        SlcRenderContext r105 = r104.f50158f;
        ArrayList<BaseSlcViewManager<?>> r106 = r111.f50145d;
        int r107 = r106.size();
        int r108 = r107 - 1;
        if (r108 < r111.f50144c) goto L16;
    L18:
        if (r107 <= 0) goto L20;
        BaseSlcViewManager<?> r109 = (BaseSlcViewManager) ListProtector.remove(r106, r108);
    L21:
        if (r109 == null) goto L24;
        r109.L0(this);
        r102 = r109;
    L24:
        if (r102 == null) goto L27;
        sq.a r112 = this.f50220h.f50628b;
        r112.f542930k++;
        r112.f542931l++;
        return r102;
    L16:
        if (r111.f50143b <= 0) goto L18;
        r111.b(r105.f50164b);
    L20:
        r109 = null;
        goto L21
    L23:
        r104.getClass();
    L27:
        this.f50220h.f50628b.f542930k++;
        HashMap<String, Function1<SlcTemplateContext, BaseSlcViewManager<?>>> r113 = ElementTypes.f50336a;
        if (r100 != null) goto L32;
        r100 = "";
    L32:
        return ElementTypes.a(this, r100, false);
    L33:
        if (r101 == false) goto L61;
        SliceRender.f50121o.getClass();
        Lazy r114 = SliceRender.f50116j;
        KProperty r115 = SliceRender.f50107a[7];
        if (((Boolean) r114.getValue()).booleanValue() == false) goto L61;
        SlcRenderContext r116 = this.f50235w;
        if (r116.f50195u == false) goto L61;
        if (this.f50214b == true) goto L61;
        TemplateViewPool r117 = r116.f50162a;
        if (r100 == null) goto L57;
        DefaultViewManagerPool r118 = r117.f50155c.get(r100);
        if (r118 == null) goto L54;
        SlcRenderContext r119 = r117.f50158f;
        ArrayList<BaseSlcViewManager<?>> r120 = r118.f50149h;
        if (r120 != null) goto L47;
        r120 = new ArrayList(r118.f50148g);
        r118.f50149h = r120;
    L47:
        int r121 = r120.size();
        if (r118.f50148g > 0) goto L50;
    L52:
        if (r121 <= 0) goto L54;
        BaseSlcViewManager<?> r122 = (BaseSlcViewManager) ListProtector.remove(r120, r121 - 1);
    L55:
        if (r122 == null) goto L58;
        r122.L0(this);
        r102 = r122;
    L58:
        if (r102 == null) goto L61;
        sq.a r123 = this.f50220h.f50628b;
        r123.f542932m++;
        r123.f542933n++;
        return r102;
    L50:
        if ((r121 - 1) >= r118.f50147f) goto L52;
        r118.a(r119.f50164b);
    L54:
        r122 = null;
        goto L55
    L57:
        r117.getClass();
    L61:
        this.f50220h.f50628b.f542932m++;
        HashMap<String, Function1<SlcTemplateContext, BaseSlcViewManager<?>>> r124 = ElementTypes.f50336a;
        if (r100 != null) goto L65;
        r100 = "";
    L65:
        BaseSlcViewManager<?> r125 = ElementTypes.a(this, r100, true);
        if (this.f50214b == false) goto L68;
        r125.g0();
    L68:
        return r125;
    }

    public final IAction j(IAction r110, Map<String, ? extends Object> r210, Map<String, ? extends Object> r211) {
        if ((r110 instanceof SlcCommonAction) == false) goto L75;
        SlcCommonAction r100 = (SlcCommonAction) r110;
        Map<String, Object> r101 = r100.getData();
        DefaultConstructorMarker r102 = null;
        boolean r103 = true;
        boolean r104 = false;
        if (r100.getHasDynamicProp() == false) goto L23;
        if (r210 != null) goto L8;
    L11:
        boolean r105 = true;
    L12:
        if (r105 == false) goto L18;
        Map<String, ? extends Object> r106 = this.f50222j;
        if (r106 != null) goto L17;
        r106 = MapsKt.emptyMap();
    L17:
        Map<String, ? extends Object> r111 = r106;
    L19:
        Map<String, Object> r112 = r100.getData();
        Object r107 = new JsonTemplate(r112, this.f50235w.f50187m0).a(r112, r111, 2, 0, this.f50230r);
        if ((r107 instanceof Map) == true) goto L22;
        r107 = null;
    L22:
        r101 = (Map) r107;
        goto L23
    L18:
        r111 = r210;
        goto L19
    L8:
        if (r210.isEmpty() == true) goto L11;
        r105 = false;
    L23:
        if (r101 == null) goto L25;
        if (r211 != null) goto L31;
    L34:
        boolean r108 = true;
    L35:
        if (r108 == true) goto L41;
        HashMap r109 = new HashMap(r101);
        Object r113 = r101.get(SlcCommonAction.KEY_PARAMS);
        if ((r113 instanceof Map) == true) goto L39;
        r113 = null;
    L39:
        r109.put(SlcCommonAction.KEY_PARAMS, com.bytedance.android.ecom.arch.slice.render.util.b.w((Map) r113, r211));
        r101 = r109;
    L41:
        if (this.f50235w.C == false) goto L66;
        SlcCommonAction.Companion.getClass();
        List r114 = SlcCommonAction.a.d(r101);
        if (r114 != null) goto L45;
    L48:
        boolean r115 = true;
    L49:
        if (r115 == true) goto L65;
        Iterator r116 = r114.iterator();
    L52:
        if (r116.hasNext() == false) goto L58;
        IAction r117 = (IAction) r116.next();
        if ((r117 instanceof SlcCommonAction) == false) goto L52;
        if (((SlcCommonAction) r117).getHasDynamicProp() == false) goto L52;
    L59:
        if (r103 == false) goto L65;
        ArrayList r118 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, 10));
        Iterator r119 = r114.iterator();
    L62:
        if (r119.hasNext() == false) goto L64;
        r118.add(j((IAction) r119.next(), r210, null));
        goto L62
    L64:
        r114 = r118;
        goto L65
    L58:
        r103 = false;
    L65:
        SlcCommonAction.Companion.getClass();
        return new SlcCommonAction(r101, r114, r104, r102);
    L45:
        if (r114.isEmpty() == true) goto L48;
        r115 = false;
        goto L49
    L66:
        SlcCommonAction.Companion.getClass();
        return SlcCommonAction.a.c(r101, true);
    L31:
        if (r211.isEmpty() == true) goto L34;
        r108 = false;
        goto L35
    L25:
        if (r100.getData() != null) goto L27;
        String r120 = "null";
    L28:
        com.bytedance.android.ecom.arch.slice.render.event.monitor.a.a(new com.bytedance.android.ecom.arch.slice.render.event.monitor.a("ACTION_ERROR", "action_eval_null", "actionDatatype:" + r120 + ",template name:" + n(), null, null, null, 56), this, null, false, 6);
        return r110;
    L27:
        r120 = r100.getData().getClass().getSimpleName();
        goto L28
    L75:
        return r110;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IAction k(SlcTemplateContext r100, IAction r101, Map r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.j(r101, r102, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SlcActionErrorCode
    public final int d(IAction r110, View r111, Map<String, ? extends Object> r112, Map<String, ? extends Object> r113, @SlcActionSource String r114) {
        System.currentTimeMillis();
        Boolean r100 = null;
        if (r112 != null) goto L9;
        BaseSlcViewManager<?> r115 = this.f50218f;
        if (r115 == 0) goto L8;
        r112 = r115.l();
        goto L9
    L8:
        r112 = null;
    L9:
        if (r112 != null) goto L12;
        r112 = MapsKt.emptyMap();
    L12:
        IAction r116 = j(r110, r112, r113);
        if (r116.getDisable() == false) goto L15;
        return 1;
    L15:
        System.currentTimeMillis();
        r r101 = this.f50217e;
        com.bytedance.android.ecom.arch.slice.action.r r117 = new com.bytedance.android.ecom.arch.slice.action.r(r116, r114, r101, r111);
        if (r101 == null) goto L24;
        SlcRenderContext r118 = this.f50235w;
        if (r118.Y.isEmpty() == true) goto L24;
        Iterator<q> r119 = r118.Y.iterator();
    L22:
        if (r119.hasNext() == false) goto L24;
        r119.next().a(r117);
    L24:
        String r120 = r116.getType();
        if (r120.length() != 0) goto L27;
        boolean r121 = true;
    L28:
        if (r121 == false) goto L30;
    L53:
        com.bytedance.android.ecom.arch.slice.render.event.monitor.a.a(new com.bytedance.android.ecom.arch.slice.render.event.monitor.a("ACTION_ERROR", "action_type_empty", "action_type_empty,template name:".concat(n()), null, null, null, 56), this, null, true, 2);
        return 2;
    L30:
        if (Intrinsics.areEqual(r120, "__SLC_UNKNOWN__") == true) goto L53;
        com.bytedance.android.ecom.arch.slice.render.b r122 = this.f50213a;
        if (r122 == null) goto L36;
        r122.a(r117);
    L36:
        if (this.f50213a == null) goto L38;
        return 0;
    L38:
        if (this.f50235w.f50170e == false) goto L55;
        return 3;
    L55:
    L43:
        th = move-exception;
        StringBuilder r123 = new StringBuilder("slice_action_handle_null,template name:");
        r123.append(n());
        r123.append(",isEmpty:");
        r123.append(Intrinsics.areEqual(this, this.f50235w.f50164b));
        r123.append(",hadSet:");
        r123.append(this.f50225m);
        r123.append(",setNull:");
        r123.append(this.f50226n);
        r123.append(",isAttach:");
        BaseSlcViewManager<?> r124 = this.f50218f;
        if (r124 == null) goto L49;
        View r125 = r124.getView();
        if (r125 == null) goto L49;
        r100 = Boolean.valueOf(r125.isAttachedToWindow());
    L49:
        r123.append(r100);
        final String r126 = r123.toString();
        com.bytedance.android.ecom.arch.slice.render.event.monitor.a.a(new com.bytedance.android.ecom.arch.slice.render.event.monitor.a("ACTION_ERROR", "no_action_handler", r126, null, null, null, 56), this, th, false, 4);
        final int r127 = hashCode();
        int r128 = com.bytedance.android.ecom.arch.slice.utils.a.f51057a;
        com.bytedance.android.ecom.arch.slice.utils.a.b(new SlcTemplateContext$reportHandlerNullEvent$1(this, th, r127, r126));
        return 3;
    L42:
        throw new IllegalStateException("slice_action_handle_null");     // Catch: Throwable -> L43
    L27:
        r121 = false;
        goto L28
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e(SlcTemplateContext r100, IAction r101, View r110, Map r111, String r112, int r113) {
        if ((r113 & 4) == 0) goto L5;
        Map r102 = null;
    L7:
        if ((r113 & 16) == 0) goto L9;
        String r103 = null;
    L10:
        r100.d(r101, r110, r102, null, r103);
        return;
    L9:
        r103 = r112;
        goto L10
    L5:
        r102 = r111;
        goto L7
    }
}
