package com.bytedance.android.shopping.deepfeed.ui.vh;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.LruCache;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import com.facebook.imagepipeline.request.Postprocessor;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache<String, Bitmap> f173841a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache<String, Bitmap> f173842b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LruCache<String, Bitmap> f173843c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Bitmap f173844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Bitmap f173845e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f173846f;

    public static final class a implements Postprocessor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Postprocessor f173847a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f173848b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f173849c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Integer f173850d;

        @Override // com.facebook.imagepipeline.request.Postprocessor
        public final String getName() {
            return this.f173847a.getName();
        }

        @Override // com.facebook.imagepipeline.request.Postprocessor
        public final CacheKey getPostprocessorCacheKey() {
            return this.f173847a.getPostprocessorCacheKey();
        }

        @Override // com.facebook.imagepipeline.request.Postprocessor
        public final CloseableReference<Bitmap> process(Bitmap r100, PlatformBitmapFactory r101) {
            CloseableReference<Bitmap> r102 = this.f173847a.process(r100, r101);
            Bitmap r103 = r102.get();
            if (r103 != null) goto L5;
        L19:
            return r102;
        L5:
            if (com.bytedance.android.shopping.extensions.k.c(this.f173849c) == false) goto L19;
            if (this.f173848b != 0) goto L19;
            Integer r104 = this.f173850d;
            if (r104 != null) goto L12;
        L16:
            Bitmap.Config r105 = r103.getConfig();
            if (r105 == null) goto L19;
            LruCache<String, Bitmap> r106 = l.f173841a;
            Bitmap r107 = l.f173842b.put(this.f173849c, r103.copy(r105, false));
            goto L19
        L12:
            if (r104.intValue() != 0) goto L16;
            Bitmap.Config r108 = r103.getConfig();
            if (r108 == null) goto L16;
            LruCache<String, Bitmap> r109 = l.f173841a;
            l.f173845e = r103.copy(r108, false);
            goto L16
        }

        public a(IterativeBoxBlurPostProcessor r100, int r101, String r102, Integer r103) {
            this.f173847a = r100;
            this.f173848b = r101;
            this.f173849c = r102;
            this.f173850d = r103;
        }
    }

    public l() {
    }

    static {
        f173841a = new LruCache(5);
        f173842b = new LruCache(5);
        f173843c = new LruCache(3);
    }

    public static /* synthetic */ void c(Integer r100, ECUrlModel r101, SimpleDraweeView r102, com.bytedance.android.ec.core.imagex.r r110) {
        b(r100, r101, 0, r102, r110, null, null);
    }

    public static void a(Integer r110, ECUrlModel r111, int r112, SimpleDraweeView r113, com.bytedance.android.ec.core.imagex.r r114, Bitmap r115) {
        Bitmap r100 = r115;
        Intrinsics.checkNotNullParameter(r113, "blurIV");
        if (f173846f == true) goto L8;
        if (r100 == null) goto L6;
        r113.getHierarchy().setPlaceholderImage(new BitmapDrawable(r113.getResources(), r100));
    L6:
        h0.d(r113, r111, r114, null, null, h0.h(2), null, 88);
        return;
    L8:
        Bitmap r101 = null;
        if (r111 == null) goto L13;
        List<String> r102 = r111.getUrlList();
        if (r102 == null) goto L13;
        String r103 = (String) CollectionsKt.firstOrNull(r102);
    L14:
        if (r103 != null) goto L16;
    L19:
        boolean r104 = true;
    L20:
        if (r104 == true) goto L23;
        r101 = f173842b.get(r103);
    L23:
        if (r101 != null) goto L29;
        if (r110 == null) goto L29;
        if (r110.intValue() != 0) goto L29;
        r101 = f173845e;
    L29:
        if (r101 == null) goto L32;
        r100 = r101;
    L32:
        if (r100 == null) goto L35;
        r113.getHierarchy().setPlaceholderImage(new BitmapDrawable(r113.getResources(), r100));
        h0.d(r113, r111, r114, null, null, h0.h(2), null, 88);
        return;
    L35:
        h0.d(r113, r111, r114, null, null, new a(h0.h(2), r112, r103, r110), null, 88);
        return;
    L16:
        if (r103.length() == 0) goto L19;
        r104 = false;
    L13:
        r103 = null;
        goto L14
    }

    public static void b(Integer r110, ECUrlModel r111, int r112, SimpleDraweeView r113, com.bytedance.android.ec.core.imagex.r r114, j r115, Bitmap r116) {
        Bitmap r100 = r116;
        Intrinsics.checkNotNullParameter(r113, "view");
        if (f173846f == true) goto L8;
        if (r100 == null) goto L6;
        r113.getHierarchy().setPlaceholderImage(new BitmapDrawable(r113.getResources(), r100));
    L6:
        h0.d(r113, r111, r114, null, null, null, r115, 24);
        return;
    L8:
        m r101 = null;
        if (r111 == null) goto L13;
        List<String> r102 = r111.getUrlList();
        if (r102 == null) goto L13;
        String r103 = (String) CollectionsKt.firstOrNull(r102);
    L14:
        boolean r104 = true;
        if (r103 != null) goto L17;
    L20:
        boolean r105 = true;
    L21:
        if (r105 == false) goto L23;
        Bitmap r106 = null;
    L24:
        if (r106 != null) goto L27;
        r101 = new m(r112, r103, r110);
    L27:
        m r107 = r101;
        if (r112 != 0) goto L39;
        if (r103 != null) goto L31;
    L34:
        if (r104 == true) goto L39;
        Bitmap r108 = f173843c.get(r103);
        if (r108 == null) goto L39;
        r106 = r108;
        goto L39
    L31:
        if (r103.length() == 0) goto L34;
        r104 = false;
    L39:
        if (r106 != null) goto L45;
        if (r110 == null) goto L45;
        if (r110.intValue() != 0) goto L45;
        r106 = f173844d;
    L45:
        if (r106 == null) goto L48;
        r100 = r106;
    L48:
        if (r100 == null) goto L50;
        r113.getHierarchy().setPlaceholderImage(new BitmapDrawable(r113.getResources(), r100));
    L50:
        h0.d(r113, r111, r114, null, null, r107, r115, 24);
        return;
    L23:
        r106 = f173841a.get(r103);
        goto L24
    L17:
        if (r103.length() == 0) goto L20;
        r105 = false;
    L13:
        r103 = null;
        goto L14
    }
}
