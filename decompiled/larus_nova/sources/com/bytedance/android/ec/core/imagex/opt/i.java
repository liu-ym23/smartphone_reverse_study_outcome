package com.bytedance.android.ec.core.imagex.opt;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class i {

    public static final class a implements ResourceReleaser<CloseableImage> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CloseableReference<Bitmap> f44862a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CloseableStaticBitmap f44863b;

        public a(CloseableStaticBitmap r100) {
            this.f44863b = r100;
            this.f44862a = r100.cloneUnderlyingBitmapReference();
        }

        @Override // com.facebook.common.references.ResourceReleaser
        public final void release(CloseableImage r100) {
            CloseableReference<Bitmap> r101 = this.f44862a;
            if (r101 == null) goto L6;
            r101.close();
            return;
        }
    }

    public static final boolean a(CloseableStaticBitmap r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$reuseValid");
        if (r100.isClosed() == false) goto L5;
    L7:
        return false;
    L5:
        if (r100.isThumbCache() == true) goto L7;
        return true;
    }

    public static final CloseableReference<CloseableImage> b(CloseableStaticBitmap r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toCloseableReference");
        return CloseableReference.of(r100, new a(r100));
    }
}
