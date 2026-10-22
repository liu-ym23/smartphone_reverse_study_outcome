package com.bytedance.android.ecom.arch.slice.render.elements.asyncimage;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bytedance.android.ecom.arch.slice.render.widget.fresco.e;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: classes44.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a$a, reason: collision with other inner class name */
    public interface InterfaceC0857a {
        void d(CloseableReference<CloseableImage> r100, Drawable r101);

        void onFailure(Throwable r100);
    }

    boolean a(Uri r100, SlcImageFetchManager r101, e r102, Object r103, SlcImageFetchManager.a r104);

    ImageRequest b(Uri r100);

    void c(Object r100);
}
