package com.bytedance.android.ecom.arch.slice.render.elements.asyncimage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.m;
import com.bytedance.android.ecom.arch.slice.render.widget.fresco.SlcPipelineDraweeControllerBuilder;
import com.bytedance.android.ecom.arch.slice.render.widget.fresco.e;
import com.bytedance.android.ecom.arch.slice.render.widget.fresco.h;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.DefaultDrawableFactory;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.VisibilityAwareDrawable;
import com.facebook.drawee.drawable.VisibilityCallback;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyInflater;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes44.dex */
public final class SlcImageFetchManager implements VisibilityCallback {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f50356t = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f50357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.ecom.arch.slice.render.widget.fresco.c<GenericDraweeHierarchy> f50358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DefaultDrawableFactory f50359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImagePipeline f50360d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CloseableReference<CloseableImage> f50361e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f50362f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Uri f50363g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f50364h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Object f50365i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f50366j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f50367k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f50368l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f50369m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a.InterfaceC0857a f50370n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public m f50371o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a f50372p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public SlcRenderContext f50373q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f50374r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Context f50375s;

    public final class a implements com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a.InterfaceC0857a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CloseableReference<CloseableImage> f50376a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Drawable f50377b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e f50378c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SlcImageFetchManager f50379d;

        @Override // com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a.InterfaceC0857a
        public final void onFailure(Throwable r100) {
            e r101 = this.f50378c;
            r101.getClass();
            nq.a.a();
            if (r101.f50936a == true) goto L8;
            SlcImageFetchManager r102 = this.f50379d;
            r102.b(!r102.f50357a);
            com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a.InterfaceC0857a r103 = this.f50379d.f50370n;
            if (r103 == null) goto L9;
            r103.onFailure(r100);
            return;
        L9:
            return;
        }

        public a(SlcImageFetchManager r100, e r101) {
            this.f50379d = r100;
            this.f50378c = r101;
        }

        @Override // com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a.InterfaceC0857a
        public final void d(CloseableReference<CloseableImage> r100, Drawable r101) {
            e r102 = this.f50378c;
            r102.getClass();
            nq.a.a();
            if (r102.f50936a == true) goto L8;
            this.f50376a = r100;
            this.f50377b = r101;
            this.f50379d.m(r100, r101);
            com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a.InterfaceC0857a r103 = this.f50379d.f50370n;
            if (r103 == null) goto L9;
            r103.d(r100, r101);
            return;
        L9:
            return;
        }
    }

    public final class b extends BaseControllerListener<ImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlcImageFetchManager f50380a;

        public b(SlcImageFetchManager r100) {
            this.f50380a = r100;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFailure(String r100, Throwable r101) {
            super.onFailure(r100, r101);
            SlcImageFetchManager r102 = this.f50380a;
            r102.b(!r102.f50357a);
            com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a.InterfaceC0857a r103 = this.f50380a.f50370n;
            if (r103 == null) goto L6;
            r103.onFailure(r101);
            return;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener
        public final void onFinalImageSet(String r100, ImageInfo r101, Animatable r102, ImageRequest r103, Map r104) {
            if (r104 == null) goto L5;
            Object r105 = r104.get("image");
        L7:
            if ((r105 instanceof CloseableReference) == true) goto L9;
            r105 = null;
        L9:
            CloseableReference<CloseableImage> r106 = (CloseableReference) r105;
            if (r106 != null) goto L12;
            nq.a.c(null, SlcImageFetchManager$SlcControllerListener$onFinalImageSet$1.INSTANCE, 1);
            return;
        L12:
            SlcImageFetchManager r107 = this.f50380a;
            KProperty[] r108 = SlcImageFetchManager.f50356t;
            r107.m(r106, null);
            com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a.InterfaceC0857a r109 = this.f50380a.f50370n;
            if (r109 == null) goto L17;
            r109.d(r106, null);
            return;
        L17:
            return;
        L5:
            r105 = null;
            goto L7
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlcImageFetchManager f50381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f50382b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ImageRequest f50383c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e f50384d;

        public c(SlcImageFetchManager r100, boolean r101, ImageRequest r102, e r103) {
            this.f50381a = r100;
            this.f50382b = r101;
            this.f50383c = r102;
            this.f50384d = r103;
        }

        public final void a() {
            SlcImageFetchManager r100 = this.f50381a;
            com.bytedance.android.ecom.arch.slice.render.widget.fresco.c<GenericDraweeHierarchy> r101 = r100.f50358b;
            if (r101 == null) goto L5;
            h r102 = r101.f50934d;
        L6:
            Lazy r103 = r100.f50374r;
            boolean r104 = false;
            KProperty r105 = SlcImageFetchManager.f50356t[0];
            SlcPipelineDraweeControllerBuilder r106 = (SlcPipelineDraweeControllerBuilder) r103.getValue();
            r106.b();
            r106.f50922g = this.f50382b;
            r106.f50918c = this.f50383c;
            r106.f50923h = r102;
            r106.f50921f = new b(this.f50381a);
            e r107 = this.f50384d;
            boolean r108 = nq.a.f520084a;
            if (r107 == null) goto L9;
            r104 = true;
        L9:
            nq.a.d(r104, null, null);
            r106.f50924i = r107;
            Object r109 = this.f50381a.f50365i;
            if (r109 == null) goto L12;
            r106.f50917b = r109;
        L12:
            this.f50381a.l(r106.a());
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
        f50356t = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SlcImageFetchManager.class), "controllerBuilder", "getControllerBuilder()Lcom/bytedance/android/ecom/arch/slice/render/widget/fresco/SlcPipelineDraweeControllerBuilder;"))};
    }

    public final void g() {
        i(true);
        com.bytedance.android.ecom.arch.slice.render.widget.fresco.c<GenericDraweeHierarchy> r100 = this.f50358b;
        if (r100 == null) goto L5;
        r100.f50932b = true;
        r100.f50931a = true;
    L5:
        d(this.f50363g, this.f50364h);
    }

    public final void h() {
        i(false);
        com.bytedance.android.ecom.arch.slice.render.widget.fresco.c<GenericDraweeHierarchy> r100 = this.f50358b;
        if (r100 == null) goto L8;
        r100.f50932b = false;
        if (r100.f50931a == false) goto L8;
        r100.f50931a = false;
        com.bytedance.android.ecom.arch.slice.render.util.e.h(new com.bytedance.android.ecom.arch.slice.render.widget.fresco.b(r100));
    L8:
        b(true);
    }

    @Override // com.facebook.drawee.drawable.VisibilityCallback
    public final void onDraw() {
    }

    public final Drawable e() {
        com.bytedance.android.ecom.arch.slice.render.widget.fresco.c<GenericDraweeHierarchy> r100 = this.f50358b;
        if (r100 == null) goto L12;
        boolean r101 = nq.a.f520084a;
        if (r100.f50933c == 0) goto L7;
        boolean r102 = true;
    L8:
        nq.a.d(r102, null, null);
        GenericDraweeHierarchy r103 = (GenericDraweeHierarchy) r100.f50933c;
        if (r103 != null) goto L11;
        return null;
    L11:
        return r103.getTopLevelDrawable();
    L7:
        r102 = false;
        goto L8
    L12:
        return null;
    }

    public final GenericDraweeHierarchy f() {
        com.bytedance.android.ecom.arch.slice.render.widget.fresco.c<GenericDraweeHierarchy> r100 = this.f50358b;
        if (r100 == null) goto L10;
        boolean r101 = nq.a.f520084a;
        if (r100.f50933c == 0) goto L7;
        boolean r102 = true;
    L8:
        nq.a.d(r102, null, null);
        return (GenericDraweeHierarchy) r100.f50933c;
    L7:
        r102 = false;
        goto L8
    L10:
        return null;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("holder", String.valueOf(this.f50358b)).toString();
    }

    public final Context getContext() {
        return this.f50375s;
    }

    public SlcImageFetchManager(Context r100) {
        this.f50375s = r100;
        this.f50364h = true;
        this.f50368l = true;
        boolean r101 = com.bytedance.android.ecom.arch.slice.render.util.e.f50736a;
        if (com.bytedance.android.ecom.arch.slice.render.util.e.f50736a == false) goto L5;
    L9:
        ImagePipelineFactory r102 = Fresco.getImagePipelineFactory();
        this.f50360d = r102.getImagePipeline();
        this.f50359c = new DefaultDrawableFactory(r100.getResources(), r102.getAnimatedDrawableFactory(r100));
        GenericDraweeHierarchy r103 = GenericDraweeHierarchyInflater.inflateBuilder(r100, null).build();
        this.f50358b = new com.bytedance.android.ecom.arch.slice.render.widget.fresco.c(r103);
        Object r104 = r103.getTopLevelDrawable();
        if ((r104 instanceof VisibilityAwareDrawable) == false) goto L12;
        ((VisibilityAwareDrawable) r104).setVisibilityCallback(this);
    L12:
        this.f50362f = new e(0);
        this.f50374r = LazyKt.lazy(new SlcImageFetchManager$controllerBuilder$2(this));
        return;
    L5:
        if (r100.getApplicationInfo().targetSdkVersion >= 24) goto L7;
        boolean r105 = true;
    L8:
        com.bytedance.android.ecom.arch.slice.render.util.e.f50737b = r105;
        com.bytedance.android.ecom.arch.slice.render.util.e.f50736a = true;
        goto L9
    L7:
        r105 = false;
        goto L8
    }

    public final void b(boolean r100) {
        if (r100 == false) goto L6;
        GenericDraweeHierarchy r101 = f();
        if (r101 == null) goto L6;
        r101.reset();
    L6:
        nq.a.a();
        CloseableReference<CloseableImage> r102 = this.f50361e;
        if (r102 == null) goto L10;
        CloseableReference.closeSafely(r102);
        this.f50361e = null;
        return;
    }

    public final void c(Canvas r100) {
        this.f50369m = false;
        Drawable r101 = e();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100.isHardwareAccelerated() == true) goto L17;
        SlcRenderContext r102 = this.f50373q;
        if (r102 == null) goto L17;
        if (r102.A != true) goto L17;
        boolean r103 = com.bytedance.android.ecom.arch.slice.render.util.e.f50736a;
        CloseableReference<CloseableImage> r104 = this.f50361e;
        if (r104 == null) goto L13;
        CloseableImage r105 = r104.get();
    L15:
        if ((r105 instanceof CloseableAnimatedImage) == false) goto L17;
        return;
    L13:
        r105 = null;
    L17:
        r101.draw(r100);
    }

    public final void i(boolean r100) {
        if (this.f50367k != r100) goto L5;
        return;
    L5:
        this.f50367k = r100;
        if (r100 == false) goto L8;
        k(this, true, false, 6);
        return;
    L8:
        this.f50369m = false;
        k(this, false, true, 4);
    }

    public final void l(h r100) {
        com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a r101 = this.f50372p;
        if (r101 == null) goto L5;
        r101.c(r100);
    L5:
        final com.bytedance.android.ecom.arch.slice.render.widget.fresco.c<GenericDraweeHierarchy> r102 = this.f50358b;
        if (r102 == null) goto L23;
        boolean r103 = r102.f50931a;
        if (r103 == false) goto L14;
        if (r102.f50931a == false) goto L14;
        r102.f50931a = false;
        com.bytedance.android.ecom.arch.slice.render.util.e.h(new com.bytedance.android.ecom.arch.slice.render.widget.fresco.b(r102));
    L14:
        if (r102.a() == false) goto L16;
        r102.f50934d.g(null);
    L16:
        r102.f50934d = r100;
        r100.g(r102.f50933c);
        if (r103 == true) goto L19;
        return;
    L19:
        if (r102.f50931a == true) goto L25;
        r102.f50931a = true;
        com.bytedance.android.ecom.arch.slice.render.util.e.h(new com.bytedance.android.ecom.arch.slice.render.widget.fresco.a(r102));
        return;
    L25:
        return;
    }

    @Override // com.facebook.drawee.drawable.VisibilityCallback
    public final void onVisibilityChange(boolean r100) {
        if (this.f50368l != r100) goto L5;
        return;
    L5:
        this.f50368l = r100;
        if (r100 == false) goto L11;
        k(this, true, false, 6);
        com.bytedance.android.ecom.arch.slice.render.widget.fresco.c<GenericDraweeHierarchy> r101 = this.f50358b;
        if (r101 == null) goto L10;
        r101.f50932b = true;
        r101.f50931a = true;
    L10:
        d(this.f50363g, this.f50364h);
        return;
    L11:
        com.bytedance.android.ecom.arch.slice.render.widget.fresco.c<GenericDraweeHierarchy> r102 = this.f50358b;
        if (r102 == null) goto L17;
        r102.f50932b = false;
        if (r102.f50931a == false) goto L17;
        r102.f50931a = false;
        com.bytedance.android.ecom.arch.slice.render.util.e.h(new com.bytedance.android.ecom.arch.slice.render.widget.fresco.b(r102));
    L17:
        b(true);
        k(this, false, false, 6);
    }

    public final void a(final String r100, m r101) {
        this.f50371o = r101;
        if (r100 != null) goto L19;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L16;
        Uri r103 = UriProtector.parse(r100);     // Catch: Throwable -> L8
    L17:
        k(this, true, false, 6);
        this.f50363g = r103;
        d(r103, this.f50364h);
        return;
    L8:
        th = move-exception;
        nq.a.b(th, new SlcImageFetchManager$bindSrc$uri$1(r100));
    L16:
        r103 = null;
        goto L17
    L19:
        if (r100.length() == 0) goto L10;
        r102 = false;
        goto L11
    }

    public final void d(Uri r110, boolean r111) {
        if (this.f50366j == true) goto L6;
        return;
    L6:
        if (this.f50367k == true) goto L9;
        return;
    L9:
        if (this.f50368l == true) goto L12;
        return;
    L12:
        if (r110 == null) goto L76;
        com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a r112 = this.f50372p;
        if (r112 != null) goto L16;
        boolean r113 = false;
    L32:
        if (r112 == null) goto L36;
        ImageRequest r100 = r112.b(r110);
        if (r100 == null) goto L36;
    L44:
        CacheKey r101 = com.bytedance.android.ecom.arch.slice.render.util.e.e(r100, this.f50360d.getCacheKeyFactory(), this.f50365i);
        if (r101 != null) goto L47;
    L46:
        boolean r102 = false;
    L66:
        if (r102 == false) goto L69;
        k(this, false, true, 4);
        return;
    L69:
        if (r113 == false) goto L71;
    L75:
        nq.a.a();
        com.bytedance.android.ecom.arch.slice.render.util.e.h(new c(this, r111, r100, this.f50362f));
        k(this, false, false, 6);
        return;
    L71:
        if (this.f50357a == false) goto L75;
        GenericDraweeHierarchy r103 = f();
        if (r103 == null) goto L75;
        r103.reset();
        goto L75
    L47:
        CloseableReference<CloseableImage> r104 = com.bytedance.android.ecom.arch.slice.render.util.e.f(this.f50360d.getBitmapMemoryCache(), r101);
        if (r104 == null) goto L46;
        DefaultDrawableFactory r105 = this.f50359c;
        com.bytedance.android.ecom.arch.slice.render.widget.fresco.c<GenericDraweeHierarchy> r106 = this.f50358b;
        if (r106 == null) goto L52;
        h r107 = r106.f50934d;
    L53:
        if (r107 == null) goto L55;
        Drawable r108 = r107.f50952k;
    L56:
        Drawable r109 = com.bytedance.android.ecom.arch.slice.render.util.e.a(r104, r105, r108);
        if (r109 == null) goto L46;
        if (f() == null) goto L46;
        if (r100 == null) goto L62;
        RequestListener r114 = this.f50360d.getRequestListenerForRequest(r100, null);
        r114.onRequestStart(r100, this.f50365i, "-1", false);
        r114.onRequestSuccess(r100, "-1", false);
    L62:
        m(r104, r109);
        com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a.InterfaceC0857a r115 = this.f50370n;
        if (r115 == null) goto L65;
        r115.d(r104, r109);
    L65:
        r102 = true;
        goto L66
    L55:
        r108 = null;
        goto L56
    L52:
        r107 = null;
    L36:
        ImageRequestBuilder r116 = ImageRequestBuilder.newBuilderWithSource(r110).setRotationOptions(RotationOptions.autoRotateAtRenderTime());
        m r117 = this.f50371o;
        if (r117 == null) goto L43;
        int r118 = r117.f50680a;
        if (r118 <= 0) goto L43;
        int r119 = r117.f50681b;
        if (r119 <= 0) goto L43;
        r116.setResizeOptions(new ResizeOptions(r118, r119));
    L43:
        r100 = r116.build();
        goto L44
    L16:
        if (this.f50357a == false) goto L21;
        GenericDraweeHierarchy r120 = f();
        if (r120 == null) goto L20;
        r120.reset();
    L20:
        r113 = true;
    L22:
        e r121 = new e(0);
        a r122 = new a(this, r121);
        if (r112.a(r110, this, r121, this.f50365i, r122) == false) goto L32;
        CloseableReference<CloseableImage> r123 = r122.f50376a;
        Drawable r124 = r122.f50377b;
        if (r123 == null) goto L29;
        if (r124 == null) goto L28;
        j(false, true, r121);
        return;
    L28:
        nq.a.c(null, SlcImageFetchManager$doFetchImage$1.INSTANCE, 1);
        return;
    L29:
        j(false, true, r121);
        return;
    L21:
        r113 = false;
        goto L22
    L76:
        k(this, false, true, 4);
        b(true);
    }

    public final void m(CloseableReference<CloseableImage> r100, Drawable r101) {
        if (r101 == null) goto L6;
        GenericDraweeHierarchy r102 = f();
        if (r102 == null) goto L6;
        r102.setImage(r101, 1.0f, true);
    L6:
        nq.a.a();
        CloseableReference<CloseableImage> r103 = this.f50361e;
        if (r103 == null) goto L9;
        CloseableReference.closeSafely(r103);
        this.f50361e = null;
    L9:
        this.f50361e = r100;
    }

    public final void j(boolean r100, boolean r101, e r102) {
        if (this.f50366j != r100) goto L5;
        return;
    L5:
        this.f50366j = r100;
        if (r100 == true) goto L14;
        if (r101 == false) goto L15;
        nq.a.a();
        e r103 = this.f50362f;
        r103.getClass();
        nq.a.a();
        r103.f50936a = true;
        if (r102 != null) goto L12;
        r102 = new e(0);
    L12:
        this.f50362f = r102;
        return;
    L15:
        return;
    }

    public static /* synthetic */ void k(SlcImageFetchManager r100, boolean r101, boolean r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r102 = false;
    L5:
        r100.j(r101, r102, null);
    }
}
