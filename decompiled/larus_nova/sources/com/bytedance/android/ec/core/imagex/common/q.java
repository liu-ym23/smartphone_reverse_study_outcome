package com.bytedance.android.ec.core.imagex.common;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.MultiCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.Postprocessor;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class q extends BasePostprocessor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f44655b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Postprocessor> f44656a;

    public static final class a {
    }

    static {
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public final String getName() {
        return "SRPostProcessor";
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public final CacheKey getPostprocessorCacheKey() {
        LinkedList r100 = new LinkedList();
        Iterator<Postprocessor> r101 = this.f44656a.iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        r100.push(r101.next().getPostprocessorCacheKey());
        goto L4
    L7:
        return new MultiCacheKey(r100);
    }

    public q(List r100) {
        this.f44656a = new LinkedList(r100);
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public final CloseableReference<Bitmap> process(Bitmap r100, PlatformBitmapFactory r101) {
        Intrinsics.checkNotNullParameter(r100, "sourceBitmap");
        Intrinsics.checkNotNullParameter(r101, "bitmapFactory");
        CloseableReference<Bitmap> r102 = null;
        Iterator<Postprocessor> r103 = this.f44656a.iterator();     // Catch: Throwable -> L14
        CloseableReference r104 = null;
    L5:
        if (r103.hasNext() == false) goto L11;
        Postprocessor r105 = r103.next();     // Catch: Throwable -> L14
        if (r104 == null) goto L9;
        Bitmap r106 = (Bitmap) r104.get();     // Catch: Throwable -> L14
    L10:
        r102 = r105.process(r106, r101);     // Catch: Throwable -> L14
        CloseableReference.closeSafely(r104);     // Catch: Throwable -> L14
        r104 = CloseableReference.cloneOrNull(r102);     // Catch: Throwable -> L14
        goto L5
    L9:
        r106 = r100;
        goto L10
    L11:
        CloseableReference<Bitmap> r107 = CloseableReference.cloneOrNull(r102);     // Catch: Throwable -> L14
        CloseableReference.closeSafely(r102);
        return r107;
    L14:
        th = move-exception;
        CloseableReference.closeSafely(r102);
        throw th;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public final CloseableReference<Bitmap> process(Bitmap r100, PlatformBitmapFactory r110, Map<String, String> r111) {
        CloseableReference<Bitmap> r101 = null;
        Iterator<Postprocessor> r102 = this.f44656a.iterator();     // Catch: Throwable -> L20
        CloseableReference r103 = null;
    L5:
        if (r102.hasNext() == false) goto L17;
        Postprocessor r104 = r102.next();     // Catch: Throwable -> L20
        if (r103 == null) goto L9;
        Bitmap r105 = (Bitmap) r103.get();     // Catch: Throwable -> L20
    L11:
        if ((r104 instanceof BasePostprocessor) == true) goto L13;
    L15:
        r101 = r104.process(r105, r110);     // Catch: Throwable -> L20
    L16:
        CloseableReference.closeSafely(r103);     // Catch: Throwable -> L20
        r103 = CloseableReference.cloneOrNull(r101);     // Catch: Throwable -> L20
        goto L5
    L13:
        if (StringsKt.equals("SRPostProcessor", r104.getName(), true) == false) goto L15;
        r101 = ((BasePostprocessor) r104).process(r105, r110, r111);     // Catch: Throwable -> L20
        goto L16
    L9:
        r105 = r100;
        goto L11
    L17:
        CloseableReference<Bitmap> r106 = CloseableReference.cloneOrNull(r101);     // Catch: Throwable -> L20
        CloseableReference.closeSafely(r101);
        return r106;
    L20:
        th = move-exception;
        CloseableReference.closeSafely(r101);
        throw th;
    }
}
