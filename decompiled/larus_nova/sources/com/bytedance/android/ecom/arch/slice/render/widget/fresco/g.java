package com.bytedance.android.ecom.arch.slice.render.widget.fresco;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.HashMap;

/* JADX INFO: loaded from: classes44.dex */
public final class g extends BaseDataSubscriber<CloseableReference<CloseableImage>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f50939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f50940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h f50941c;

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r100) {
        this.f50941c.e(this.f50939a, r100, r100.getFailureCause(), true);
    }

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> r110) {
        boolean r100 = r110.isFinished();
        boolean r101 = r110.hasMultipleResults();
        float r102 = r110.getProgress();
        CloseableReference<CloseableImage> r103 = r110.getResult();
        if (r103 == null) goto L56;
        h r104 = this.f50941c;
        String r105 = this.f50939a;
        boolean r106 = this.f50940b;
        if (r104.d(r105, r110) == true) goto L59;
        CloseableReference.closeSafely(r103);
        r110.close();
        return;
    L59:
        Drawable r111 = com.bytedance.android.ecom.arch.slice.render.util.e.a(r103, r104.f50956o, r104.f50952k);     // Catch: Exception -> L54
        if (r111 == null) goto L53;
        CloseableReference<CloseableImage> r112 = r104.f50951j;
        Object r113 = r104.f50952k;
        r104.f50951j = r103;
        r104.f50952k = r111;
        Animatable r107 = null;
        if (r100 == false) goto L19;
        r104.f50950i = null;     // Catch: Throwable -> L42
        SettableDraweeHierarchy r108 = r104.f50945d;     // Catch: Throwable -> L42
        if (r108 == null) goto L14;
        r108.setImage(r111, 1.0f, r106);     // Catch: Throwable -> L42
    L14:
        HashMap r114 = new HashMap();     // Catch: Throwable -> L42
        r114.put("image", r103.cloneOrNull());     // Catch: Throwable -> L42
        BaseControllerListener<ImageInfo> r109 = r104.b();     // Catch: Throwable -> L42
        CloseableImage r115 = com.bytedance.android.ecom.arch.slice.render.util.e.g(r103);     // Catch: Throwable -> L42
        Object r116 = r104.f50952k;     // Catch: Throwable -> L42
        if ((r116 instanceof Animatable) == false) goto L17;
        Animatable r117 = (Animatable) r116;     // Catch: Throwable -> L42
    L18:
        r109.onFinalImageSet(r105, r115, r117, r104.f50954m, r114);     // Catch: Throwable -> L42
    L34:
        if (r113 == null) goto L39;
        if (r113 == r111) goto L39;
        if ((r113 instanceof DrawableWithCaches) == false) goto L39;
        ((DrawableWithCaches) r113).dropCaches();
    L39:
        if (r112 == null) goto L63;
        if (r112 == r103) goto L64;
        CloseableReference.closeSafely(r112);
        return;
    L64:
        return;
    L63:
        return;
    L17:
        r117 = null;
        goto L18
    L19:
        if (r101 == false) goto L27;
        SettableDraweeHierarchy r118 = r104.f50945d;     // Catch: Throwable -> L42
        if (r118 == null) goto L23;
        r118.setImage(r111, 1.0f, r106);     // Catch: Throwable -> L42
    L23:
        BaseControllerListener<ImageInfo> r119 = r104.b();     // Catch: Throwable -> L42
        CloseableImage r120 = com.bytedance.android.ecom.arch.slice.render.util.e.g(r103);     // Catch: Throwable -> L42
        Object r121 = r104.f50952k;     // Catch: Throwable -> L42
        if ((r121 instanceof Animatable) == false) goto L26;
        r107 = (Animatable) r121;     // Catch: Throwable -> L42
    L26:
        r119.onFinalImageSet(r105, r120, r107);     // Catch: Throwable -> L42
        goto L34
    L27:
        SettableDraweeHierarchy r122 = r104.f50945d;     // Catch: Throwable -> L42
        if (r122 == null) goto L30;
        r122.setImage(r111, r102, r106);     // Catch: Throwable -> L42
    L30:
        BaseControllerListener<ImageInfo> r123 = r104.b();     // Catch: Throwable -> L42
        CloseableImage r124 = com.bytedance.android.ecom.arch.slice.render.util.e.g(r103);     // Catch: Throwable -> L42
        Object r125 = r104.f50952k;     // Catch: Throwable -> L42
        if ((r125 instanceof Animatable) == false) goto L33;
        r107 = (Animatable) r125;     // Catch: Throwable -> L42
    L33:
        r123.onIntermediateImageSet(r105, r124, r107);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        if (r113 == null) goto L48;
        if (r113 == r111) goto L48;
        if ((r113 instanceof DrawableWithCaches) == false) goto L48;
        ((DrawableWithCaches) r113).dropCaches();
    L48:
        if (r112 == null) goto L51;
        if (r112 == r103) goto L51;
        CloseableReference.closeSafely(r112);
    L51:
        throw th;
    L53:
        throw new UnsupportedOperationException("Unrecognized image class: " + r103.get());     // Catch: Exception -> L54
    L54:
        e = move-exception;
        CloseableReference.closeSafely(r103);
        r104.e(r105, r110, e, r100);
        return;
    L56:
        if (r100 == false) goto L67;
        this.f50941c.e(this.f50939a, r110, new NullPointerException(), true);
        return;
    }

    @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
    public final void onProgressUpdate(DataSource<CloseableReference<CloseableImage>> r100) {
        boolean r101 = r100.isFinished();
        float r102 = r100.getProgress();
        h r103 = this.f50941c;
        if (r103.d(this.f50939a, r100) == true) goto L5;
        r100.close();
        return;
    L5:
        if (r101 == true) goto L11;
        SettableDraweeHierarchy r104 = r103.f50945d;
        if (r104 == null) goto L12;
        r104.setProgress(r102, false);
        return;
    L12:
        return;
    }

    public g(h r100, String r101, boolean r102) {
        this.f50941c = r100;
        this.f50939a = r101;
        this.f50940b = r102;
    }
}
