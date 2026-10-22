package com.bytedance.android.ecom.slice.ext.template.gecko.loader;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.p;
import com.bytedance.android.ecom.arch.slice.render.q;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.ecom.arch.slice.render.util.h;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;
import com.bytedance.android.ecom.slice.ext.template.gecko.g;
import com.bytedance.android.ecom.slice.ext.template.gecko.i;
import com.bytedance.android.ecom.slice.ext.template.gecko.j;
import com.bytedance.android.ecom.slice.ext.template.gecko.k;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.Response;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class SlcGeckoTemplatePageLoader implements com.bytedance.android.ecom.slice.ext.template.gecko.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, i> f51284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f51285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, SlcTemplateLoadContext> f51286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f51287d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f51288e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f51289f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Forest f51290g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.ecom.arch.slice.expr.b f51291h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SlcGeckoTemplateMgr f51292i;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f51293a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SlcGeckoTemplatePageLoader f51294b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SlcRenderContext f51295c;

        public a(j r100, SlcGeckoTemplatePageLoader r101, SlcRenderContext r102) {
            this.f51293a = r100;
            this.f51294b = r101;
            this.f51295c = r102;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v19, types: [T, com.bytedance.android.ecom.slice.ext.template.gecko.i] */
        /* JADX WARN: Type inference failed for: r2v7, types: [T, com.bytedance.android.ecom.slice.ext.template.gecko.i] */
        public final void a() {
            final SlcGeckoTemplatePageLoader r100 = this.f51294b;
            final SlcRenderContext r110 = this.f51295c;
            j r101 = this.f51293a;
            SlcGeckoTemplateMgr r102 = SlcGeckoTemplateMgr.f51232l;
            String r103 = r100.f51289f;
            r102.getClass();
            SlcGeckoTemplateCache r104 = SlcGeckoTemplateMgr.f51227g;
            g r105 = r104.f51281e.get(r103);
            if (r105 != null) goto L5;
        L9:
            Map<String, List<Object>> r111 = null;
        L92:
            final Ref.IntRef r112 = new Ref.IntRef();     // Catch: Throwable -> L87
            int r106 = r101.b();     // Catch: Throwable -> L87
            r112.element = r106;     // Catch: Throwable -> L87
            if (r106 > 0) goto L14;
            return;
        L14:
            if (r106 <= 16) goto L16;
            r112.element = 16;     // Catch: Throwable -> L87
        L16:
            final String r107 = r101.c();     // Catch: Throwable -> L87
            String r108 = r101.a();     // Catch: Throwable -> L87
            boolean r210 = true;
            if (r108 != null) goto L19;
        L22:
            boolean r109 = true;
        L23:
            if (r109 == false) goto L27;
            String r113 = r101.c();     // Catch: Throwable -> L87
            if (r113 == null) goto L27;
            String r114 = SlcGeckoLoaderHelper.e(r113);     // Catch: Throwable -> L87
        L28:
            if (r107 != null) goto L30;
        L33:
            boolean r115 = true;
        L34:
            if (r115 == true) goto L85;
            if (r114 != null) goto L37;
        L40:
            boolean r116 = true;
        L41:
            if (r116 == true) goto L85;
            final Ref.ObjectRef r117 = new Ref.ObjectRef();     // Catch: Throwable -> L87
            r117.element = r100.f(r107);     // Catch: Throwable -> L87
            int r118 = com.bytedance.android.ecom.arch.slice.utils.a.f51057a;     // Catch: Throwable -> L87
            com.bytedance.android.ecom.arch.slice.utils.a.a(new SlcGeckoTemplatePageLoader$doCreateTemplateViews$3(r107, r117));     // Catch: Throwable -> L87
            if (((i) r117.element) != null) goto L46;
            r100.f51292i.getClass();     // Catch: Throwable -> L87
            r117.element = r104.a(r107);     // Catch: Throwable -> L87
            com.bytedance.android.ecom.arch.slice.utils.a.a(new SlcGeckoTemplatePageLoader$doCreateTemplateViews$4(r117));     // Catch: Throwable -> L87
        L46:
            i r119 = (i) r117.element;     // Catch: Throwable -> L87
            if (r119 == null) goto L95;
            SlcElement r120 = r119.f51261a;     // Catch: Throwable -> L87
            if (r120 == null) goto L96;
            int r121 = r112.element;     // Catch: Throwable -> L87
            int r122 = 0;
        L51:
            if (r122 >= r121) goto L70;
            SliceRender r123 = SliceRender.f50121o;     // Catch: Throwable -> L87
            q r124 = r120.getMeta();     // Catch: Throwable -> L87
            if (r124 == null) goto L57;
            String r125 = r124.a();     // Catch: Throwable -> L87
            if (r125 == null) goto L57;
        L58:
            String r126 = r125;
            T r127 = r117.element;     // Catch: Throwable -> L87
            final Map<String, List<Object>> r211 = r111;
            String r128 = r107;
            String r129 = r114;
            p r130 = new p(r128, r129, r126, ((i) r127).f51263c, ((i) r127).f51266f, ((i) r127).f51267g, ((i) r127).f51268h);     // Catch: Throwable -> L87
            r123.getClass();     // Catch: Throwable -> L87
            r.f50698d.getClass();     // Catch: Throwable -> L87
            r r131 = r.a.a(r110, r120, r130);     // Catch: Throwable -> L87
            c r132 = r100.f51285b;     // Catch: Throwable -> L87
            d r133 = new d(r131, (i) r117.element);     // Catch: Throwable -> L87
            monitor-enter(r132);     // Catch: Throwable -> L87
            c.a r134 = r132.f51319a.get(r107);     // Catch: Throwable -> L67
            if (r134 != null) goto L64;
            r134 = new c.a();     // Catch: Throwable -> L67
            r132.f51319a.put(r107, r134);     // Catch: Throwable -> L67
        L64:
            r134.f51320a.add(r133);     // Catch: Throwable -> L67
            monitor-exit(r132);     // Catch: Throwable -> L87
            int r135 = com.bytedance.android.ecom.arch.slice.utils.a.f51057a;     // Catch: Throwable -> L87
            SlcElement r136 = r120;
            final String r137 = r114;
            final Ref.ObjectRef r138 = r117;
            final String r139 = r107;
            com.bytedance.android.ecom.arch.slice.utils.a.a(new SlcGeckoTemplatePageLoader$doCreateTemplateViews$$inlined$let$lambda$1(r100, r112, r110, r137, r139, r138, r211));     // Catch: Throwable -> L87
            r122 = r122 + 1;     // Catch: Throwable -> L87
            r107 = r107;
            r120 = r136;
            r117 = r138;
            r114 = r114;
            r121 = r121;
            r111 = r211;
            goto L51
        L67:
            th = move-exception;
            throw th;     // Catch: Throwable -> L87
        L57:
            r125 = "";
            goto L58
        L70:
            final Ref.ObjectRef r140 = r117;
            final String r141 = r114;
            Map<String, List<Object>> r212 = r111;
            final String r142 = r107;
            if (r212 == null) goto L73;
            Map<String, List<Object>> r143 = r212;
            final List<Object> r144 = r143.get(r142);     // Catch: Throwable -> L87
        L74:
            List<Object> r145 = r144;     // Catch: Throwable -> L87
            if (r145 != null) goto L77;
        L80:
            if (r210 == false) goto L82;
        L84:
            Unit r146 = Unit.INSTANCE;     // Catch: Throwable -> L87
            return;
        L82:
            if (r100.f51287d == true) goto L84;
            final Map<String, List<Object>> r147 = r143;
            h.a(new SlcGeckoTemplatePageLoader$doCreateTemplateViews$$inlined$let$lambda$2(r144, r100, r112, r110, r141, r142, r140, r147));     // Catch: Throwable -> L87
            goto L84
        L77:
            if (r145.isEmpty() == true) goto L80;
            r210 = false;
            goto L80
        L73:
            r143 = r212;
            r144 = null;
            goto L74
        L96:
            return;
        L95:
            return;
        L37:
            if (r114.length() == 0) goto L40;
            r116 = false;
        L85:
            final String r148 = r114;
            int r149 = com.bytedance.android.ecom.arch.slice.utils.a.f51057a;     // Catch: Throwable -> L87
            com.bytedance.android.ecom.arch.slice.utils.a.b(new SlcGeckoTemplatePageLoader$doCreateTemplateViews$2(r110, r107, r148));     // Catch: Throwable -> L87
            return;
        L30:
            if (r107.length() == 0) goto L33;
            r115 = false;
        L27:
            r114 = r108;
            goto L28
        L19:
            if (r108.length() == 0) goto L22;
            r109 = false;
        L87:
            th = move-exception;
            nq.a.c(th, null, 2);
            Unit r150 = Unit.INSTANCE;
            return;
        L5:
            if (r105.a() == false) goto L9;
            g r151 = r104.f51281e.get(r103);
            if (r151 == null) goto L9;
            r111 = r151.b();
            goto L92
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

    @Override // com.bytedance.android.ecom.slice.ext.template.gecko.c
    public final void a() {
        this.f51287d = true;
    }

    @Override // com.bytedance.android.ecom.slice.ext.template.gecko.c
    public final void release() {
        Iterator<T> r100 = this.f51286c.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((SlcTemplateLoadContext) r100.next()).f();
        goto L4
    L6:
        SlcGeckoTemplateMgr r101 = SlcGeckoTemplateMgr.f51232l;
        String r102 = this.f51288e;
        r101.getClass();
        HashMap<String, com.bytedance.android.ecom.slice.ext.template.gecko.c> r103 = SlcGeckoTemplateMgr.f51226f;
        monitor-enter(r103);
        com.bytedance.android.ecom.slice.ext.template.gecko.c r104 = (com.bytedance.android.ecom.slice.ext.template.gecko.c) TypeIntrinsics.asMutableMap(r103).remove(r102);     // Catch: Throwable -> L11
        monitor-exit(r103);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.ecom.slice.ext.template.gecko.c
    public final com.bytedance.android.ecom.arch.slice.expr.b c() {
        return this.f51291h;
    }

    @Override // com.bytedance.android.ecom.slice.ext.template.gecko.c
    public final void b(SlcRenderContext r100) {
        int r101 = com.bytedance.android.ecom.arch.slice.utils.a.f51057a;
        com.bytedance.android.ecom.arch.slice.utils.a.a(SlcGeckoTemplatePageLoader$preCreateTemplateView$2.INSTANCE);
        SlcGeckoTemplateMgr r102 = SlcGeckoTemplateMgr.f51232l;
        String r103 = this.f51289f;
        r102.getClass();
        g r104 = SlcGeckoTemplateMgr.f51227g.f51281e.get(r103);
        if (r104 == null) goto L5;
        List<j> r105 = r104.c();
    L6:
        if (r105 == null) goto L11;
        Iterator<T> r106 = r105.iterator();
    L9:
        if (r106.hasNext() == false) goto L13;
        j r107 = (j) r106.next();
        SlcGeckoTemplateMgr r108 = SlcGeckoTemplateMgr.f51232l;
        a r109 = new a(r107, this, r100);
        r108.getClass();
        SlcGeckoTemplateMgr.f51223c.execute(r109);
        goto L9
    L13:
        return;
    L11:
        return;
    L5:
        r105 = null;
        goto L6
    }

    public final i f(String r100) {
        SlcGeckoTemplateMgr.f51232l.getClass();
        com.bytedance.android.ecom.slice.ext.template.gecko.b r101 = SlcGeckoTemplateMgr.f51228h;
        if (r101 == null) goto L8;
        com.bytedance.android.ec.slice.a r102 = r101.c();
        if (r102 == null) goto L8;
        r102.b();
    L8:
        return this.f51284a.get(r100);
    }

    @Override // com.bytedance.android.ecom.slice.ext.template.gecko.c
    public final void d(final com.bytedance.android.ecom.arch.slice.render.i r100, Map<String, ? extends Object> r101, Function2<? super i, ? super r, Unit> r102) {
        nq.a.e(h.b(), new SlcGeckoTemplatePageLoader$loadTemplate$1(this, r100), 2);
        e(r100, r101, r102);
    }

    /* JADX WARN: Type inference failed for: r1v13, types: [T, com.bytedance.android.ecom.slice.ext.template.gecko.loader.SlcTemplateLoadContext] */
    /* JADX WARN: Type inference failed for: r1v14, types: [T, com.bytedance.android.ecom.slice.ext.template.gecko.loader.SlcTemplateLoadContext, java.lang.Object] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void e(com.bytedance.android.ecom.arch.slice.render.i r110, Map<String, ? extends Object> r111, Function2<? super i, ? super r, Unit> r112) {
        final String r100 = r110.f50670a;
        c r101 = this.f51285b;
        monitor-enter(r101);
        c.a r102 = r101.f51319a.get(r100);     // Catch: Throwable -> L52
        if (r102 != null) goto L7;
        monitor-exit(r101);
        final d r103 = null;
    L15:
        int r104 = com.bytedance.android.ecom.arch.slice.utils.a.f51057a;
        com.bytedance.android.ecom.arch.slice.utils.a.a(new SlcGeckoTemplatePageLoader$getTemplateViewCache$1(r103, r100));
        if (r103 == null) goto L19;
        r112.invoke(r103.f51322b, r103.f51321a);
        return;
    L19:
        String r105 = r110.f50670a;
        boolean r106 = true;
        if (r105.length() <= 0) goto L22;
        boolean r107 = true;
    L23:
        if (r107 == false) goto L27;
        i r108 = f(r105);
        if (r108 == null) goto L27;
    L31:
        if (r108 == null) goto L33;
        SlcElement r109 = r108.f51261a;
    L34:
        if (r109 == null) goto L37;
        r112.invoke(r108, null);
        return;
    L37:
        int r113 = SlcGeckoLoaderHelper.f51273a;
        if (r110.f50671b.length() > 0) goto L41;
        r106 = false;
    L41:
        if (r106 == false) goto L43;
        String r114 = r110.f50671b;
    L44:
        String r115 = r114;
        Ref.ObjectRef r116 = new Ref.ObjectRef();
        SlcTemplateLoadContext r117 = this.f51286c.get(r110.f50670a);
        r116.element = r117;
        if (r117 != 0) goto L47;
        String r118 = this.f51289f;
        String r119 = r110.f50670a;
        String r120 = r110.f50672c;
        int r121 = k.f51269d;
        ?? r122 = new SlcTemplateLoadContext(r118, false, r119, r115, r120, k.a.a(false, false, 7));
        r122.f51297a = r111;
        r116.element = r122;
        this.f51286c.put(r110.f50670a, (SlcTemplateLoadContext) r122);
        ((SlcTemplateLoadContext) r116.element).e(r112);
        SlcGeckoTemplateMgr r123 = SlcGeckoTemplateMgr.f51232l;
        Forest r124 = this.f51290g;
        SlcTemplateLoadContext r125 = (SlcTemplateLoadContext) r116.element;
        com.bytedance.android.ecom.slice.ext.template.gecko.loader.a r126 = new com.bytedance.android.ecom.slice.ext.template.gecko.loader.a(this, r116);
        r123.getClass();
        SlcGeckoTemplateMgr.c(r124, r125, r126);
        return;
    L47:
        Response r127 = r117.f51306j;
        if (r127 == null) goto L50;
        final String r128 = "SlcTemplateLoadContext is not removed from map after the template is loaded，inMain:" + h.b() + ",biz:" + this.f51289f + ",url:" + ((SlcTemplateLoadContext) r116.element).f51312p + ",loadFrom:" + ((SlcTemplateLoadContext) r116.element).d() + ",geckoErrorCode:" + r127.f244317s.f244212a;
        nq.a.b(new Throwable(r128), new SlcGeckoTemplatePageLoader$getTemplateAsync$3(r128));
        return;
    L50:
        ((SlcTemplateLoadContext) r116.element).e(r112);
        return;
    L43:
        r114 = SlcGeckoLoaderHelper.e(r110.f50670a);
        goto L44
    L33:
        r109 = null;
    L27:
        SlcGeckoTemplateMgr.f51232l.getClass();
        r108 = SlcGeckoTemplateMgr.f51227g.a(r105);
        if (r108 == null) goto L30;
        this.f51284a.put(r105, i.a(r108));
        goto L31
    L30:
        r108 = null;
        goto L31
    L22:
        r107 = false;
        goto L23
    L7:
        if (r102.f51320a.size() <= 0) goto L10;
        ArrayList<d> r129 = r102.f51320a;     // Catch: Throwable -> L52
        r103 = (d) ListProtector.remove(r129, r129.size() - 1);     // Catch: Throwable -> L52
    L11:
        monitor-exit(r101);
        goto L15
    L10:
        r103 = null;
    L52:
        th = move-exception;
        throw th;
    }

    public SlcGeckoTemplatePageLoader(String r100, String r101, Forest r102, com.bytedance.android.ecom.arch.slice.expr.b r103, SlcGeckoTemplateMgr r104) {
        this.f51288e = r100;
        this.f51289f = r101;
        this.f51290g = r102;
        this.f51291h = r103;
        this.f51292i = r104;
        r104.getClass();
        g r105 = SlcGeckoTemplateMgr.f51227g.f51281e.get(r101);
        if (r105 == null) goto L5;
        List<j> r106 = r105.c();
    L6:
        HashMap r107 = new HashMap();
        if (r106 == null) goto L22;
        Iterator<T> r108 = r106.iterator();
    L10:
        if (r108.hasNext() == false) goto L22;
        String r109 = ((j) r108.next()).c();
        if (r109 != null) goto L14;
    L17:
        boolean r110 = true;
    L18:
        if (r110 == true) goto L10;
        i r111 = SlcGeckoTemplateMgr.f51227g.a(r109);
        if (r111 == null) goto L10;
        i r112 = (i) r107.put(r109, r111);
        goto L10
    L14:
        if (r109.length() == 0) goto L17;
        r110 = false;
    L22:
        this.f51284a = new ConcurrentHashMap(r107);
        this.f51285b = new c();
        this.f51286c = new ConcurrentHashMap();
        SlcGeckoTemplateMgr.f51232l.getClass();
        SliceRender.f50121o.getClass();
        return;
    L5:
        r106 = null;
        goto L6
    }
}
