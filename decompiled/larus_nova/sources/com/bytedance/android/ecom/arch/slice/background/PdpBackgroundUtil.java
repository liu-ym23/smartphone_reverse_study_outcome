package com.bytedance.android.ecom.arch.slice.background;

import android.graphics.Bitmap;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.datasource.DataSubscriber;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class PdpBackgroundUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, WeakReference<Bitmap>> f50015a = null;

    static {
        f50015a = new HashMap();
    }

    @JvmStatic
    public static final uq.a b(com.bytedance.android.ecom.arch.slice.render.context.b r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "slcDisplayMetrics");
        Intrinsics.checkNotNullParameter(r101, "size");
        Intrinsics.checkNotNullParameter(r100, "slcDisplayMetrics");
        Intrinsics.checkNotNullParameter(r101, "size");
    L16:
        uq.a r102 = null;
    L17:
        if (r102 == null) goto L19;
        return r102;
    L19:
        return new uq.a(0.0f, 0);
    L4:
        if ("auto".equals(r101) == false) goto L6;
        r102 = new uq.a(0.0f, 0);     // Catch: Throwable -> L16
        goto L17
    L6:
        int r103 = r101.length();     // Catch: Throwable -> L16
        if (r103 > 0) goto L9;
    L11:
        boolean r104 = false;
    L12:
        if (r104 == false) goto L15;
        r102 = new uq.a(CastFloatProtector.parseFloat(r101.substring(0, r101.length() - 1)), 2);     // Catch: Throwable -> L16
        goto L17
    L15:
        r102 = new uq.a(SlcDimensExtensionsKt.c(Float.valueOf(CastFloatProtector.parseFloat(r101)), r100), 1);     // Catch: Throwable -> L16
        goto L17
    L9:
        if (r101.charAt(r103 - 1) != '%') goto L11;
        r104 = true;
        goto L12
    }

    public static void c(a r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "bgDrawable");
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        r100.g(null);
        return;
    L12:
        WeakReference<Bitmap> r103 = f50015a.get(r101);
        if (r103 == null) goto L18;
        Bitmap r104 = r103.get();
        if (r104 == null) goto L18;
        r100.g(r104);
        return;
    L18:
        PdpBackgroundUtil$setViewBgImg$2 r105 = new PdpBackgroundUtil$setViewBgImg$2(r100, r101);
        List r106 = CollectionsKt.listOf(r101);
        if (r106 != null) goto L21;
        List r107 = CollectionsKt.emptyList();
    L35:
        ImagePipeline r108 = Fresco.getImagePipeline();
        a(r108, r107, 0, new b(r105, r108, r107));
        return;
    L21:
        ArrayList r109 = new ArrayList();
        Iterator r110 = r106.iterator();
    L23:
        if (r110.hasNext() == false) goto L32;
        String r111 = (String) r110.next();
        if (r111.length() != 0) goto L27;
        boolean r112 = true;
    L28:
        if (r112 == true) goto L23;
        r109.add(ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r111)).build());
        goto L23
    L27:
        r112 = false;
        goto L28
    L32:
        if (r109.size() != 0) goto L34;
        r107 = CollectionsKt.emptyList();
        goto L35
    L34:
        r107 = r109;
        goto L35
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r102 = false;
        goto L9
    }

    public static boolean a(ImagePipeline r100, List r101, int r102, DataSubscriber r103) {
        if (r102 < r101.size()) goto L5;
        return false;
    L5:
        ImageRequest r104 = (ImageRequest) CollectionsKt.getOrNull(r101, r102);
        if (r104 != null) goto L8;
        return false;
    L8:
        r100.fetchDecodedImage(r104, null).subscribe(r103, UiThreadImmediateExecutorService.getInstance());
        return true;
    }
}
