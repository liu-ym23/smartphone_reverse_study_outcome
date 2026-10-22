package com.bytedance.android.gamecp.business.gamedetail.component.scaffold;

import android.graphics.Bitmap;
import android.util.Log;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d extends BasePostprocessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SimpleCacheKey f55008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f55009b;

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public final CacheKey getPostprocessorCacheKey() {
        if (this.f55008a != null) goto L6;
        this.f55008a = new SimpleCacheKey("GameCPDetailTitleBarBGProcessor" + this.f55009b);
    L6:
        return this.f55008a;
    }

    public d(int r100) {
        this.f55009b = r100;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public final void process(Bitmap r100) {
        super.process(r100);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L15
        if (r100 == null) goto L6;
        int r102 = r100.getWidth();     // Catch: Throwable -> L15
    L7:
        if (r102 <= 0) goto L13;
        int r103 = this.f55009b;     // Catch: Throwable -> L15
        if (r103 <= 0) goto L11;
        int r104 = (r102 * 80) / r103;     // Catch: Throwable -> L15
    L12:
        NativeBlurFilter.iterativeBoxBlur(r100, 3, r104);     // Catch: Throwable -> L15
        goto L13
    L11:
        r104 = 16;
    L13:
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L23;
        yr.c.e("GameCPDetailTitleBarBGProcessor", "blur exception \n " + Log.getStackTraceString(r106));
        return;
    L23:
        return;
    L6:
        r102 = 0;
    L15:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public final CloseableReference<Bitmap> process(Bitmap r100, PlatformBitmapFactory r101) {
        Intrinsics.checkNotNullParameter(r100, "sourceBitmap");
        Intrinsics.checkNotNullParameter(r101, "bitmapFactory");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L14
        Bitmap.Config r103 = r100.getConfig();     // Catch: Throwable -> L14
        Bitmap.Config r104 = Bitmap.Config.ARGB_8888;     // Catch: Throwable -> L14
        if (r103 == r104) goto L6;
        Bitmap r105 = r100.copy(r104, true);     // Catch: Throwable -> L14
    L7:
        CloseableReference<Bitmap> r106 = r101.createBitmapInternal(r100.getWidth(), r100.getHeight(), Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L14
        process(r106.get(), r105);     // Catch: Throwable -> L11
        CloseableReference<Bitmap> r107 = CloseableReference.cloneOrNull(r106);     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r107);     // Catch: Throwable -> L11
        CloseableReference.closeSafely(r106);     // Catch: Throwable -> L14
        return r107;
    L11:
        th = move-exception;
        CloseableReference.closeSafely(r106);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L6:
        r105 = r100;
    L14:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Throwable r109 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r109 == null) goto L19;
        yr.c.e("GameCPDetailTitleBarBGProcessor", "process exception \n " + Log.getStackTraceString(r109));
    L19:
        return super.process(r100, r101);
    }
}
