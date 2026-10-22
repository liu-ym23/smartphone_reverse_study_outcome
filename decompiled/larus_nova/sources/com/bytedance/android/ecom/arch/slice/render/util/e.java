package com.bytedance.android.ecom.arch.slice.render.util;

import android.graphics.drawable.Drawable;
import com.bytedance.android.ecom.arch.slice.render.SlcScaleType;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.SlcImageFetchManager;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.drawable.ArrayDrawable;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegate;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes44.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f50736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f50737b;

    public static final class a extends AnimationBackendDelegate<AnimationBackend> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f50738a;

        @Override // com.facebook.fresco.animation.backend.AnimationBackendDelegate, com.facebook.fresco.animation.backend.AnimationInformation
        public final int getLoopCount() {
            return this.f50738a;
        }

        public a(AnimationBackend r100, int r101) {
            super(r100);
            this.f50738a = r101;
        }
    }

    static {
    }

    public static AnimatedDrawable2 c(Drawable r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if ((r100 instanceof AnimatedDrawable2) == false) goto L8;
        return (AnimatedDrawable2) r100;
    L8:
        if ((r100 instanceof ForwardingDrawable) == false) goto L12;
        return c(((ForwardingDrawable) r100).getCurrent());
    L12:
        if ((r100 instanceof ArrayDrawable) == false) goto L23;
        ArrayDrawable r101 = (ArrayDrawable) r100;
        int r102 = r101.getNumberOfLayers();
        int r103 = 0;
    L14:
        if (r103 >= r102) goto L24;
        AnimatedDrawable2 r104 = c(r101.getDrawable(r103));
        if (r104 != null) goto L17;
        r103 = r103 + 1;
        goto L14
    L17:
        return r104;
    L24:
        return null;
    L23:
        return null;
    }

    public static ScalingUtils.ScaleType d(@SlcScaleType String r100) {
        if (r100 == null) goto L16;
        int r101 = r100.hashCode();
        if (r101 == (-1274273297)) goto L13;
        if (r101 != 1671566394) goto L16;
        if (r100.equals(SlcScaleType.CENTER_CROP) == false) goto L16;
        return ScalingUtils.ScaleType.CENTER_CROP;
    L13:
        if (r100.equals(SlcScaleType.FIT_XY) == false) goto L16;
        return ScalingUtils.ScaleType.FIT_XY;
    L16:
        return ScalingUtils.ScaleType.FIT_CENTER;
    }

    @JvmStatic
    public static final CloseableImage g(CloseableReference r100) {
        nq.a.d(CloseableReference.isValid(r100), null, null);
        if (r100 != null) goto L5;
        return null;
    L5:
        return (CloseableImage) r100.get();
    }

    @JvmStatic
    public static final void h(Runnable r100) {
        if (ThreadMethodProxy.currentThread().getName().equals("slice-image-request-thread") == false) goto L5;
        r100.run();
        return;
    L5:
        SliceRender.f50121o.getClass();
        Lazy r101 = SliceRender.f50111e;
        KProperty r102 = SliceRender.f50107a[2];
        ((Executor) r101.getValue()).execute(r100);
    }

    public static SlcImageFetchManager b(SlcRenderContext r100, Object r101) {
        SlcImageFetchManager r102 = new SlcImageFetchManager(r100.getContext());
        ScalingUtils.ScaleType r103 = ScalingUtils.ScaleType.FIT_CENTER;
        GenericDraweeHierarchy r104 = r102.f();
        if (r104 == null) goto L5;
        r104.setActualImageScaleType(r103);
    L5:
        r102.f50365i = r101;
        r102.f50373q = r100;
        if (r100.f50196v < 0) goto L10;
        GenericDraweeHierarchy r105 = r102.f();
        if (r105 == null) goto L10;
        r105.setFadeDuration(r100.f50196v);
    L10:
        com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a r106 = r100.f50189o;
        if (r106 == null) goto L14;
    L19:
        r102.f50372p = r106;
        r102.f50357a = r100.D;
        return r102;
    L14:
        if (r100.f50198x == false) goto L18;
        SliceRender.f50121o.getClass();
        pq.a r107 = SliceRender.f50108b;
        if (r107 == null) goto L18;
        r106 = r107.c();
    L18:
        r106 = null;
        goto L19
    }

    @JvmStatic
    public static final CloseableReference<CloseableImage> f(MemoryCache<CacheKey, CloseableImage> r100, CacheKey r101) {
        if (r100 == null) goto L13;
        if (r101 == null) goto L13;
        CloseableReference<CloseableImage> r102 = r100.get(r101);
        if (r102 != null) goto L9;
    L12:
        return r102;
    L9:
        if (r102.get().getQualityInfo().isOfFullQuality() == true) goto L12;
        r102.close();
        return null;
    L13:
        return null;
    }

    @JvmStatic
    public static final Drawable a(CloseableReference<CloseableImage> r100, DrawableFactory r101, Drawable r102) {
        Preconditions.checkState(CloseableReference.isValid(r100));
        if (r100 == null) goto L5;
        CloseableImage r103 = r100.get();
    L6:
        Drawable r104 = r101.createDrawable(r103, r102);
        if (r104 != null) goto L11;
        nq.a.c(new UnsupportedOperationException("Unrecognized image class: " + r103), null, 2);
        return null;
    L11:
        return r104;
    L5:
        r103 = null;
        goto L6
    }

    @JvmStatic
    public static final CacheKey e(ImageRequest r100, CacheKeyFactory r101, Object r102) {
        if (r101 == null) goto L8;
        if (r100 == null) goto L8;
        if (r100.getPostprocessor() == null) goto L11;
        return r101.getPostprocessedBitmapCacheKey(r100, r102);
    L11:
        return r101.getBitmapCacheKey(r100, r102);
    L8:
        return null;
    }
}
