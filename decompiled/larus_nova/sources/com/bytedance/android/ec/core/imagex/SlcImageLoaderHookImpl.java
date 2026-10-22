package com.bytedance.android.ec.core.imagex;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bytedance.android.ec.core.imagex.common.ProxyRequestListener;
import com.bytedance.android.ec.core.imagex.common.TaskMergeManager;
import com.bytedance.android.ec.core.imagex.opt.DomainPreConnect;
import com.bytedance.android.ec.core.imagex.opt.ECImageMultiSizeReuseOpt;
import com.bytedance.android.ec.core.imagex.opt.ECImageRequestBuilderCacheForSlc;
import com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.SlcImageFetchManager;
import com.bytedance.android.ecom.arch.slice.render.widget.fresco.SlcPipelineDraweeControllerBuilder;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.DefaultDrawableFactory;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes43.dex */
public final class SlcImageLoaderHookImpl extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static DrawableFactory f44487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static WeakReference<Drawable> f44488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f44489c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final SlcImageLoaderHookImpl f44490d = null;

    public static final class a extends BaseControllerListener<ImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageRequest f44491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a.InterfaceC0857a f44492b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f44493c;

        public a(com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a.InterfaceC0857a r100, r r101) {
            Intrinsics.checkNotNullParameter(r100, "callback");
            this.f44492b = r100;
            this.f44493c = r101;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFailure(String r100, Throwable r101) {
            this.f44492b.onFailure(r101);
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener
        public final void onFinalImageSet(String r100, ImageInfo r101, Animatable r102, ImageRequest r103, Map r104) {
            ImageInfo r105 = r101;
            ImageRequest r106 = null;
            if (r104 == null) goto L5;
            Object r107 = r104.get("image");
        L7:
            if ((r107 instanceof CloseableReference) == true) goto L9;
            r107 = null;
        L9:
            CloseableReference<CloseableImage> r108 = (CloseableReference) r107;
            if (r108 != null) goto L12;
            nq.a.c(null, SlcImageLoaderHookImpl$SlcControllerListener$onFinalImageSet$1.INSTANCE, 1);
            return;
        L12:
            com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a.InterfaceC0857a r109 = this.f44492b;
            boolean r110 = r102 instanceof Drawable;
            Object r111 = r102;
            if (r110 == true) goto L15;
            r111 = null;
        L15:
            r109.d(r108, (Drawable) r111);
            int r112 = d0.f44666a;
            if (r103 != null) goto L22;
            Object r113 = this.f44493c;
            if ((r113 instanceof u) == true) goto L20;
        L23:
            d0.a(r105, r106, this.f44493c);
            return;
        L20:
            if (((u) r113).F == true) goto L23;
            r103 = this.f44491a;
        L22:
            r106 = r103;
            goto L23
        L5:
            r107 = null;
            goto L7
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f44494a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f44495b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ q f44496c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.ecom.arch.slice.render.widget.fresco.e f44497d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ImageRequest f44498e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ a f44499f;

        public b(r r100, Ref.ObjectRef r101, q r102, com.bytedance.android.ecom.arch.slice.render.widget.fresco.e r103, ImageRequest r104, a r105) {
            this.f44494a = r100;
            this.f44495b = r101;
            this.f44496c = r102;
            this.f44497d = r103;
            this.f44498e = r104;
            this.f44499f = r105;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v3, types: [T, com.facebook.imagepipeline.request.ImageRequest[]] */
        public final void a() {
            this.f44495b.element = ImageExtensionsKt.J(this.f44494a, (ImageRequest[]) this.f44495b.element, null).component1();
            r r100 = this.f44494a;
            if ((r100 instanceof u) == true) goto L5;
            r100 = null;
        L5:
            u r101 = (u) r100;
            if (r101 == null) goto L8;
            r101.f45060x = System.nanoTime();
        L8:
            SlcPipelineDraweeControllerBuilder r102 = this.f44496c.b();
            com.bytedance.android.ecom.arch.slice.render.widget.fresco.h r103 = this.f44496c.getController();
            r102.b();
            r102.f50922g = this.f44496c.a();
            r102.f50923h = r103;
            com.bytedance.android.ecom.arch.slice.render.widget.fresco.e r104 = this.f44497d;
            boolean r105 = nq.a.f520084a;
            if (r104 == null) goto L11;
            boolean r106 = true;
        L12:
            nq.a.d(r106, null, null);
            r102.f50924i = r104;
            r102.f50917b = this.f44494a;
            ImageRequest[] r107 = (ImageRequest[]) this.f44495b.element;
            if (r107.length <= 1) goto L15;
            r102.f50920e = r107;
        L16:
            ImageRequest r108 = this.f44498e;
            if (r108 == null) goto L19;
            r102.f50919d = r108;
        L19:
            r102.f50921f = this.f44499f;
            this.f44496c.c(r102.a());
            r r109 = this.f44494a;
            if ((r109 instanceof u) == true) goto L22;
            r109 = null;
        L22:
            u r110 = (u) r109;
            if (r110 == null) goto L46;
            long r111 = System.nanoTime();
            long r112 = r110.f45059w;
            long r113 = r110.f45060x;
            if (r112 <= r113) goto L28;
        L44:
            r110.f45056t = -1;
            r110.f45057u = -1;
            r110.f45058v = -1;
            r110.f45059w = -1;
            r110.f45060x = -1;
            return;
        L28:
            if (r111 < r113) goto L44;
            long r114 = r110.f45058v;
            if (r112 < r114) goto L44;
            long r115 = r110.f45057u;
            if (r114 < r115) goto L44;
            long r116 = r110.f45056t;
            if (r115 < r116) goto L44;
            Long r117 = Long.valueOf(((r111 - r113) + (r112 - r114)) + (r115 - r116));
            if (r117.longValue() <= 0) goto L38;
            boolean r118 = true;
        L39:
            if (r118 == true) goto L42;
            r117 = null;
        L42:
            if (r117 == null) goto L44;
            r110.f("ec_slice_local_duration", Double.valueOf(r117.longValue() / ((double) 1000000.0f)));
            goto L44
        L38:
            r118 = false;
            goto L39
        L46:
            return;
        L15:
            r102.f50918c = (ImageRequest) ArraysKt.firstOrNull(r107);
            goto L16
        L11:
            r106 = false;
            goto L12
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

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Drawable f44500a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a.InterfaceC0857a f44501b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CloseableReference f44502c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ImageRequest f44503d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f44504e;

        public c(Drawable r100, com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a.InterfaceC0857a r101, CloseableReference r102, ImageRequest r103, Object r104) {
            this.f44500a = r100;
            this.f44501b = r101;
            this.f44502c = r102;
            this.f44503d = r103;
            this.f44504e = r104;
        }

        public final void a() {
            Object r100 = this.f44500a;
            boolean r101 = com.bytedance.android.ecom.arch.slice.render.util.e.f50736a;
            if ((r100 instanceof Animatable) == false) goto L5;
            Animatable r102 = (Animatable) r100;
        L6:
            DrawableFactory r103 = SlcImageLoaderHookImpl.f44487a;
            SlcImageLoaderHookImpl.f44488b = new WeakReference(this.f44500a);
            this.f44501b.d(this.f44502c, this.f44500a);
            if (r102 == null) goto L9;
            r102.start();
        L9:
            int r104 = d0.f44666a;
            d0.a(this.f44502c.get(), this.f44503d, this.f44504e);
            return;
        L5:
            r102 = null;
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
        f44490d = new SlcImageLoaderHookImpl();
        f44489c = LazyKt.lazy(SlcImageLoaderHookImpl$taskMergeManager$2.INSTANCE);
    }

    public SlcImageLoaderHookImpl() {
    }

    public static void g(Runnable r100) {
        boolean r101 = com.bytedance.android.ecom.arch.slice.render.util.e.f50736a;
        if (ThreadMethodProxy.currentThread().getName().equals("slice-image-request-thread") == false) goto L7;
        r100.run();
        return;
    L7:
        if (((Boolean) TaskMergeManager.f44626e.getValue()).booleanValue() == false) goto L9;
        ((TaskMergeManager) f44489c.getValue()).a(r100);
        return;
    L9:
        com.bytedance.android.ecom.arch.slice.render.util.e.h(r100);
    }

    public static boolean f(CloseableReference r100, ImageRequest r101, Object r110, com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a.InterfaceC0857a r111) {
        DrawableFactory r102 = f44487a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("defaultDrawableFactory");
    L5:
        WeakReference<Drawable> r103 = f44488b;
        if (r103 == null) goto L8;
        Drawable r104 = r103.get();
    L9:
        Drawable r105 = com.bytedance.android.ecom.arch.slice.render.util.e.a(r100, r102, r104);
        if (r105 == null) goto L13;
        c r106 = new c(r105, r111, r100, r101, r110);
        UiThreadImmediateExecutorService.getInstance().execute(r106);
        return true;
    L13:
        return false;
    L8:
        r104 = null;
        goto L9
    }

    @Override // com.bytedance.android.ec.core.imagex.p
    public final boolean d(Uri r110, SlcImageFetchManager r111, com.bytedance.android.ecom.arch.slice.render.widget.fresco.e r210, Object r211, SlcImageFetchManager.a r212, Function1 r213) {
        Intrinsics.checkNotNullParameter(r110, "uri");
        Intrinsics.checkNotNullParameter(r111, "imageManager");
        Intrinsics.checkNotNullParameter(r210, "imageFetchCancelTag");
        Intrinsics.checkNotNullParameter(r212, "callback");
        ImageExperiments.G.getClass();
        if (((Boolean) ImageExperiments.f44406i.getValue()).booleanValue() == true) goto L5;
        return false;
    L5:
        Context r100 = r111.getContext();
        if (f44487a != null) goto L9;
        f44487a = new DefaultDrawableFactory(th.a.e(r100, true).getResources(), Fresco.getImagePipelineFactory().getAnimatedDrawableFactory(th.a.e(r100, true)));
    L9:
        if ((r211 instanceof r) == true) goto L11;
        Object r101 = null;
    L12:
        r r102 = (r) r101;
        KProperty[] r103 = ImageExtensionsKt.f44433a;
        Intrinsics.checkNotNullParameter(r111, "imageFetchManager");
        if (r102 != null) goto L16;
        r102 = t.a(r111.getContext());
    L16:
        if (r102 != null) goto L18;
        r102 = new r("", "");
    L18:
        u r112 = new u(r102);
        r112.A(r111.getContext());
        Intrinsics.checkNotNullParameter(r111, "imageFetchManager");
        Drawable r104 = r111.e();
        if (r104 == null) goto L23;
        Rect r105 = r104.getBounds();
        if (r105 == null) goto L23;
        int r106 = r105.width();
    L24:
        Drawable r107 = r111.e();
        if (r107 == null) goto L29;
        Rect r108 = r107.getBounds();
        if (r108 == null) goto L29;
        int r109 = r108.height();
    L30:
        if (r106 <= 0) goto L33;
        if (r109 <= 0) goto L33;
        r112.f45046j = new Point(r106, r109);
    L33:
        r112.y();
        r112.f45056t = System.nanoTime();
        r112.f45051o = "slice";
        y0 r113 = new y0(r111);
        if (r213 == null) goto L36;
        ImageRequest[] r114 = (ImageRequest[]) r213.invoke(r110);
    L37:
        if (r114 == null) goto L93;
        ImageRequest r115 = (ImageRequest) ArraysKt.firstOrNull(r114);
        if (ImageExtensionsKt.h(r114) != null) goto L59;
        int r116 = ProxyRequestListener.f44623c;
        if (r115 == null) goto L43;
        RequestListener r117 = r115.getRequestListener();
    L45:
        if ((r117 instanceof ProxyRequestListener) == true) goto L47;
        r117 = null;
    L47:
        ProxyRequestListener r118 = (ProxyRequestListener) r117;
        if (r118 == null) goto L50;
        Object r119 = r118.a("tag#ArrayImageRequest");
    L52:
        if ((r119 instanceof ImageRequest[]) == true) goto L54;
        r119 = null;
    L54:
        ImageRequest[] r120 = (ImageRequest[]) r119;
        if (r120 == null) goto L59;
        if (ImageExtensionsKt.h(r120) == null) goto L59;
        r114 = r120;
        goto L59
    L50:
        r119 = null;
        goto L52
    L43:
        r117 = null;
    L59:
        int r121 = ProxyRequestListener.f44623c;
        if (r115 == null) goto L62;
        RequestListener r122 = r115.getRequestListener();
    L64:
        if ((r122 instanceof ProxyRequestListener) == true) goto L66;
        r122 = null;
    L66:
        ProxyRequestListener r123 = (ProxyRequestListener) r122;
        if (r123 == null) goto L69;
        Object r124 = r123.a("tag#LowImageRequest");
    L71:
        if ((r124 instanceof ImageRequest) == true) goto L73;
        r124 = null;
    L73:
        ImageRequest r125 = (ImageRequest) r124;
        ImageRequest r126 = (ImageRequest) ArraysKt.firstOrNull(r114);
        if (r126 == null) goto L76;
        RequestListener r127 = r126.getRequestListener();
    L78:
        if ((r127 instanceof ProxyRequestListener) == true) goto L80;
        r127 = null;
    L80:
        ProxyRequestListener r128 = (ProxyRequestListener) r127;
        if (r128 == null) goto L83;
        Object r129 = r128.a("tag#ImageUrlParser");
    L85:
        if ((r129 instanceof com.bytedance.android.shopping.api.image.r) == true) goto L87;
        r129 = null;
    L87:
        com.bytedance.android.shopping.api.image.r r130 = (com.bytedance.android.shopping.api.image.r) r129;
        if (r130 == null) goto L90;
        r112.f45062z = r130;
        Unit r131 = Unit.INSTANCE;
    L90:
        r112.f45058v = System.nanoTime();
        if (ImageExtensionsKt.h(r114) == null) goto L93;
        e(r114, r125, r113, r112, r210, new a(r212, r112), r212, true);
        boolean r132 = true;
    L94:
        if (r132 == false) goto L96;
        Object r133 = null;
    L146:
        if ((r211 instanceof u) == false) goto L149;
        r133 = r211;
    L149:
        u r134 = (u) r133;
        if (r134 == null) goto L154;
        long r135 = r134.f45056t;
        if (r135 <= 0) goto L154;
        r134.f("ec_local_duration", Float.valueOf(com.bytedance.android.ec.core.imagex.common.e.a(r135)));
    L154:
        return true;
    L96:
        ResizeOptions r136 = r113.e();
        List r137 = CollectionsKt.listOf(r110.toString());
        Lazy r138 = ECImageRequestBuilderCacheForSlc.f44787a;
        Intrinsics.checkNotNullParameter(r137, "urls");
        r133 = null;
        List r139 = CollectionsKt.listOfNotNull(new Object[]{r137, r112, r136, null, null, null, null});
        StringBuilder r140 = new StringBuilder();
        Iterator r141 = r139.iterator();
    L98:
        if (r141.hasNext() == false) goto L131;
        Object r142 = r141.next();
        if ((r142 instanceof com.bytedance.android.ec.core.imagex.opt.x) == false) goto L103;
        r142 = ((com.bytedance.android.ec.core.imagex.opt.x) r142).getCacheKey();
    L105:
        if (r142 != null) goto L108;
        String r143 = "null";
    L125:
        if (r140.length() <= 0) goto L127;
        boolean r144 = true;
    L128:
        if (r144 == false) goto L130;
        r140.append("$");
    L130:
        r140.append(r143);
        goto L98
    L127:
        r144 = false;
        goto L128
    L108:
        if ((r142 instanceof String) == false) goto L111;
        r143 = (String) r142;
        goto L125
    L111:
        if ((r142 instanceof List) == false) goto L123;
        StringBuilder r145 = new StringBuilder();
        Iterator r146 = ((List) r142).iterator();
    L114:
        if (r146.hasNext() == false) goto L122;
        Object r147 = r146.next();
        if (r145.length() <= 0) goto L118;
        boolean r148 = true;
    L119:
        if (r148 == false) goto L121;
        r145.append("#");
    L121:
        r145.append(r147);
        goto L114
    L118:
        r148 = false;
        goto L119
    L122:
        r143 = r145.toString();
        goto L125
    L123:
        r143 = r142.toString();
        goto L125
    L103:
        if ((r142 instanceof Postprocessor) == false) goto L105;
        r142 = ((Postprocessor) r142).getPostprocessorCacheKey();
        goto L105
    L131:
        String r149 = r140.toString();
        Triple r150 = ECImageRequestBuilderCacheForSlc.a(r149);
        if (r150 == null) goto L144;
        com.bytedance.android.shopping.api.image.q r151 = (com.bytedance.android.shopping.api.image.q) r150.component1();
        List r152 = (List) r150.component2();
        ImageRequest r153 = (ImageRequest) r150.component3();
        Object[] r154 = r152.toArray(new ImageRequest[0]);
        if (r154 == null) goto L143;
        ImageRequest[] r155 = (ImageRequest[]) r154;
        u r156 = s.a(r112);
        if (r156 == null) goto L138;
        r156.f45062z = r151;
    L138:
        u r157 = s.a(r112);
        if (r157 == null) goto L141;
        r157.B = r149;
    L141:
        a r158 = new a(r212, r112);
        ImageExperiments.G.getClass();
        e(r155, r153, r113, r112, r210, r158, r212, !((Boolean) ImageExperiments.f44420w.getValue()).booleanValue());
        goto L146
    L143:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L144:
        r112.f45057u = System.nanoTime();
        g(new z0(r112, r137, r136, r149, r113, r210, r212));
        goto L146
    L83:
        r129 = null;
        goto L85
    L76:
        r127 = null;
        goto L78
    L69:
        r124 = null;
        goto L71
    L62:
        r122 = null;
    L93:
        r132 = false;
        goto L94
    L36:
        r114 = null;
    L29:
        r109 = 0;
    L23:
        r106 = 0;
        goto L24
    L11:
        r101 = r211;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void e(ImageRequest[] r110, ImageRequest r111, q r112, r r210, com.bytedance.android.ecom.arch.slice.render.widget.fresco.e r211, a r212, com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a.InterfaceC0857a r213, boolean r214) {
        r r100 = r210;
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        r101.element = r110;
        int r102 = 0;
        if (r110.length != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        return;
    L8:
        boolean r104 = r100 instanceof u;
        Integer r105 = null;
        if (r104 == true) goto L11;
        r r106 = null;
    L12:
        u r107 = (u) r106;
        if (r107 != null) goto L15;
    L18:
        ImageRequest r108 = null;
    L19:
        r212.f44491a = r108;
        if (r214 == false) goto L28;
        ImageExperiments.G.getClass();
        if (((Boolean) ImageExperiments.f44420w.getValue()).booleanValue() == true) goto L28;
        ImageRequest r109 = (ImageRequest) ArraysKt.firstOrNull((ImageRequest[]) r101.element);
        KProperty[] r113 = ImageExtensionsKt.f44433a;
        if (ECImageMultiSizeReuseOpt.f44769e.j() == false) goto L28;
        ECImageMultiSizeReuseOpt.b r114 = ECImageMultiSizeReuseOpt.d(r109, r100, true);
        if (r114 == null) goto L28;
        CloseableStaticBitmap r115 = r114.f44779a;
    L29:
        if (r115 != null) goto L31;
    L40:
        if (r214 == false) goto L87;
        ImageRequest[] r116 = (ImageRequest[]) r101.element;
        ImageExperiments.G.getClass();
        boolean r117 = ((Boolean) ImageExperiments.f44420w.getValue()).booleanValue();
        ImagePipeline r118 = Fresco.getImagePipelineFactory().getImagePipeline();
        if (r117 == true) goto L55;
        int r119 = r116.length;
        int r120 = 0;
    L44:
        if (r120 >= r119) goto L79;
        ImageRequest r121 = r116[r120];
        CacheKey r122 = com.bytedance.android.ecom.arch.slice.render.util.e.e(r121, r118.getCacheKeyFactory(), r100);
        if (r122 != null) goto L48;
    L47:
        boolean r123 = false;
    L52:
        if (r123 == true) goto L53;
        r120 = r120 + 1;
        goto L44
    L53:
        RequestListener r124 = r118.getRequestListenerForRequest(r121, null);
        r124.onRequestStart(r121, r100, "-1", false);
        r124.onRequestSuccess(r121, "-1", false);
    L78:
        boolean r125 = true;
    L80:
        if (r125 == false) goto L87;
        if (r104 == true) goto L83;
        r100 = null;
    L83:
        u r126 = (u) r100;
        if (r126 == null) goto L134;
        r126.z();
        return;
    L134:
        return;
    L48:
        CloseableReference<CloseableImage> r127 = com.bytedance.android.ecom.arch.slice.render.util.e.f(Fresco.getImagePipelineFactory().getImagePipeline().getBitmapMemoryCache(), r122);
        if (r127 == null) goto L47;
        r123 = f(r127, r121, r100, r213);
    L79:
        r125 = false;
        goto L80
    L55:
        ImageRequest r128 = (ImageRequest) ArraysKt.firstOrNull(r116);
        if (r128 == null) goto L79;
        CacheKey r129 = com.bytedance.android.ecom.arch.slice.render.util.e.e(r128, r118.getCacheKeyFactory(), r100);
        if (r129 != null) goto L61;
    L60:
        boolean r130 = false;
    L65:
        if (r130 == false) goto L67;
        RequestListener r131 = r118.getRequestListenerForRequest(r128, null);
        r131.onRequestStart(r128, r100, "-1", false);
        r131.onRequestSuccess(r128, "-1", false);
        goto L78
    L67:
        KProperty[] r132 = ImageExtensionsKt.f44433a;
        if (ECImageMultiSizeReuseOpt.f44769e.j() == false) goto L72;
        ECImageMultiSizeReuseOpt.b r133 = ECImageMultiSizeReuseOpt.c(r129);
        if (r133 == null) goto L72;
        CloseableStaticBitmap r134 = r133.f44779a;
    L73:
        if (r134 == null) goto L79;
        if (com.bytedance.android.ec.core.imagex.opt.i.a(r134) != true) goto L79;
        if (f(com.bytedance.android.ec.core.imagex.opt.i.b(r134), r128, r100, r213) == false) goto L79;
    L72:
        r134 = null;
        goto L73
    L61:
        CloseableReference<CloseableImage> r135 = com.bytedance.android.ecom.arch.slice.render.util.e.f(Fresco.getImagePipelineFactory().getImagePipeline().getBitmapMemoryCache(), r129);
        if (r135 == null) goto L60;
        r130 = f(r135, r128, r100, r213);
    L87:
        if (r104 == true) goto L89;
        r r136 = null;
    L90:
        u r137 = (u) r136;
        if (r137 == null) goto L93;
        r137.f45059w = System.nanoTime();
    L93:
        ImageRequest r138 = (ImageRequest) ArraysKt.getOrNull(r110, 0);
        if (r138 == null) goto L96;
        Uri r139 = r138.getSourceUri();
    L97:
        if (r104 == true) goto L99;
        r r140 = null;
    L100:
        u r141 = (u) r140;
        if ((r141 instanceof u) == false) goto L129;
        Drawable r142 = com.bytedance.android.ec.core.imagex.common.d.f44645a;
        if (com.bytedance.android.ec.core.imagex.common.d.a(r139, r141, 1) == false) goto L129;
        ResizeOptions r143 = r141.f45047k;
        if (r143 == null) goto L107;
        Integer r144 = Integer.valueOf(r143.width);
    L113:
        if (r144 == null) goto L115;
        r102 = r144.intValue();
    L115:
        ResizeOptions r145 = r141.f45047k;
        if (r145 == null) goto L118;
        r105 = Integer.valueOf(r145.height);
    L123:
        if (r105 == null) goto L125;
        r105.intValue();
    L125:
        Drawable r146 = com.bytedance.android.ec.core.imagex.common.d.b(th.a.e(r112.getContext(), true), r102);
        if (r146 == null) goto L129;
        r112.d(r146, ScalingUtils.ScaleType.FIT_CENTER);
        goto L129
    L118:
        com.bytedance.android.shopping.api.image.q r147 = com.bytedance.android.ec.core.imagex.opt.s.c(r141);
        if (r147 == null) goto L123;
        com.bytedance.android.shopping.api.image.n r148 = r147.b();
        if (r148 == null) goto L123;
        r105 = r148.getValue();
        goto L123
    L107:
        com.bytedance.android.shopping.api.image.q r149 = com.bytedance.android.ec.core.imagex.opt.s.c(r141);
        if (r149 == null) goto L112;
        com.bytedance.android.shopping.api.image.n r150 = r149.d();
        if (r150 == null) goto L112;
        r144 = r150.getValue();
    L112:
        r144 = null;
    L129:
        DomainPreConnect.f44729c.a(r100);
        g(new b(r210, r101, r112, r211, r111, r212));
        return;
    L99:
        r140 = r100;
        goto L100
    L96:
        r139 = null;
        goto L97
    L89:
        r136 = r100;
        goto L90
    L31:
        if (com.bytedance.android.ec.core.imagex.opt.i.a(r115) != true) goto L40;
        if (f(com.bytedance.android.ec.core.imagex.opt.i.b(r115), (ImageRequest) ArraysKt.firstOrNull((ImageRequest[]) r101.element), r100, r213) == false) goto L40;
        if (r104 == true) goto L36;
        r100 = null;
    L36:
        u r151 = (u) r100;
        if (r151 == null) goto L133;
        r151.z();
        return;
    L133:
        return;
    L28:
        r115 = null;
        goto L29
    L15:
        if (r107.n() == null) goto L18;
        if (r110 == 0) goto L18;
        r108 = (ImageRequest) ArraysKt.firstOrNull(r110);
        goto L19
    L11:
        r106 = r100;
        goto L12
    L5:
        r103 = false;
        goto L6
    }
}
