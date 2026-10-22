package com.bytedance.android.ecom.arch.slice.render.widget.fresco;

import android.content.Context;
import android.graphics.drawable.Animatable;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.FirstAvailableDataSourceSupplier;
import com.facebook.datasource.IncreasingQualityDataSourceSupplier;
import com.facebook.drawee.backends.pipeline.DefaultDrawableFactory;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes44.dex */
public final class SlcPipelineDraweeControllerBuilder {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f50913l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final NullPointerException f50914m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final AtomicLong f50915n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f50916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public Object f50917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public ImageRequest f50918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public ImageRequest f50919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public ImageRequest[] f50920e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public BaseControllerListener<? super ImageInfo> f50921f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f50922g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public h f50923h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e f50924i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ImagePipeline f50925j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final DefaultDrawableFactory f50926k;

    public static final enum CacheLevel extends Enum<CacheLevel> {
        public static final CacheLevel BITMAP_MEMORY_CACHE = null;
        public static final CacheLevel DISK_CACHE = null;
        public static final CacheLevel FULL_FETCH = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CacheLevel[] f50927a = null;

        static {
            CacheLevel r100 = new CacheLevel("FULL_FETCH", 0);
            FULL_FETCH = r100;
            CacheLevel r101 = new CacheLevel("DISK_CACHE", 1);
            DISK_CACHE = r101;
            CacheLevel r102 = new CacheLevel("BITMAP_MEMORY_CACHE", 2);
            BITMAP_MEMORY_CACHE = r102;
            f50927a = new CacheLevel[]{r100, r101, r102};
        }

        public static CacheLevel[] values() {
            return (CacheLevel[]) f50927a.clone();
        }

        public static CacheLevel valueOf(String r100) {
            return (CacheLevel) r27.a.a(CacheLevel.class, r100);
        }

        public CacheLevel(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class a extends BaseControllerListener<Object> {
        public a() {
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener
        public final void onIntermediateImageSet(String r100, @Nullable Object r101, @Nullable Animatable r102) {
            super.onIntermediateImageSet(r100, r101, r102);
            if (r102 != null) goto L5;
            return;
        L5:
            if (r102.isRunning() == true) goto L9;
            r102.start();
            return;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener
        public final void onFinalImageSet(String r100, @Nullable Object r101, @Nullable Animatable r102, ImageRequest r103, Map r104) {
            if (r102 == null) goto L5;
            r102.start();
            return;
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f50928a = null;

        static {
            int[] r100 = new int[CacheLevel.values().length];
            f50928a = r100;
            r100[CacheLevel.FULL_FETCH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f50928a[CacheLevel.DISK_CACHE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f50928a[CacheLevel.BITMAP_MEMORY_CACHE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public final void b() {
        this.f50917b = null;
        this.f50918c = null;
        this.f50920e = null;
        this.f50919d = null;
        this.f50921f = null;
        this.f50922g = false;
        this.f50923h = null;
        this.f50924i = null;
    }

    static {
        f50913l = new a();
        f50914m = new NullPointerException("No image request was specified!");
        f50915n = new AtomicLong();
    }

    public final h a() {
        h r100 = this.f50923h;
        String r101 = String.valueOf(f50915n.getAndIncrement());
        if (r100 != null) goto L6;
        r100 = new h(AsyncDeferredReleaser.f50912e, this.f50926k, UiThreadImmediateExecutorService.getInstance());
    L6:
        ImageRequest r102 = this.f50918c;
        if (r102 == null) goto L9;
        Supplier<DataSource<CloseableReference<CloseableImage>>> r103 = new i(this, r102, this.f50917b);
    L16:
        if (r103 != null) goto L18;
    L20:
        if (r103 != null) goto L22;
        r103 = DataSources.getFailedDataSourceSupplier(f50914m);
    L22:
        Object r104 = this.f50917b;
        ImageRequest r105 = this.f50918c;
        e r106 = this.f50924i;
        r100.f50954m = r105;
        r100.f50955n = r106;
        r100.c(r101, r104);
        r100.f50953l = false;
        r100.f50957p = r103;
        BaseControllerListener<? super ImageInfo> r107 = this.f50921f;
        if (r107 == null) goto L26;
        r100.a(r107);
    L26:
        if (this.f50922g == false) goto L28;
        r100.a(f50913l);
    L28:
        return r100;
    L18:
        if (this.f50919d == null) goto L20;
        ArrayList r108 = new ArrayList(2);
        r108.add(r103);
        r108.add(new i(this, this.f50919d, this.f50917b));
        r103 = IncreasingQualityDataSourceSupplier.create(r108, false);
        goto L20
    L9:
        ImageRequest[] r109 = this.f50920e;
        if (r109 == null) goto L15;
        ArrayList r110 = new ArrayList(r109.length);
        int r111 = r109.length;
        int r112 = 0;
    L12:
        if (r112 >= r111) goto L14;
        r110.add(new i(this, r109[r112], this.f50917b));
        r112 = r112 + 1;
        goto L12
    L14:
        r103 = FirstAvailableDataSourceSupplier.create(r110);
        goto L16
    L15:
        r103 = null;
        goto L16
    }

    public Context getContext() {
        return this.f50916a;
    }

    public SlcPipelineDraweeControllerBuilder(Context r100, ImagePipeline r101, DefaultDrawableFactory r102) {
        this.f50916a = r100;
        b();
        this.f50925j = r101;
        this.f50926k = r102;
    }
}
