package com.bytedance.android.ec.core.imagex;

import com.bytedance.android.ec.model.ECUrlModel;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h0 f44678a = null;

    public h0() {
    }

    static {
        f44678a = new h0();
    }

    @JvmStatic
    public static final IterativeBoxBlurPostProcessor h(Integer r100) {
        if (r100 != null) goto L6;
        return new IterativeBoxBlurPostProcessor(80);
    L6:
        return new IterativeBoxBlurPostProcessor(r100.intValue(), 80);
    }

    public static void a(SimpleDraweeView r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.setImageURI(ImageRequestBuilder.newBuilderWithResourceId(r101).build().getSourceUri());
    }

    public static void i(ECUrlModel r100, r r110) {
        if (r100 == null) goto L5;
        String r101 = r100.getFirstUrl();
    L6:
        String r102 = r101;
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == true) goto L17;
        ImageExtensionsKt.B(r102, r110, null, null, null, null, null, false, 192);
        return;
    L17:
        return;
    L9:
        if (r102.length() == 0) goto L12;
        r103 = false;
        goto L13
    L5:
        r101 = null;
        goto L6
    }

    public static b g(ECUrlModel r100, r r101, Function1 r102) {
        if (r100 == null) goto L5;
        List<String> r103 = r100.getUrlList();
    L6:
        List<String> r104 = r103;
        if (r104 != null) goto L9;
    L12:
        boolean r105 = true;
    L13:
        if (r105 == false) goto L16;
        return null;
    L16:
        return ImageExtensionsKt.g(r103, r101, null, null, null, r102);
    L9:
        if (r104.isEmpty() == true) goto L12;
        r105 = false;
        goto L13
    L5:
        r103 = null;
        goto L6
    }

    public static void e(GenericDraweeView r110, String r111, r r112, Integer r113, Integer r114, int r210) {
        if ((r210 & 8) == 0) goto L5;
        Integer r100 = null;
    L7:
        if ((r210 & 16) == 0) goto L9;
        Integer r101 = null;
    L10:
        Intrinsics.checkNotNullParameter(r110, "draweeView");
        if (r111 != null) goto L13;
    L16:
        boolean r102 = true;
    L17:
        if (r102 == true) goto L21;
        ImageExtensionsKt.w(r110, r111, null, r112, r100, r101, null, null, null, false, null, null, 3840);
        return;
    L21:
        return;
    L13:
        if (r111.length() == 0) goto L16;
        r102 = false;
        goto L17
    L9:
        r101 = r114;
        goto L10
    L5:
        r100 = r113;
        goto L7
    }

    public static /* synthetic */ void f(GenericDraweeView r100, List r110, r r111, Integer r112, Integer r113, int r114) {
        if ((r114 & 8) == 0) goto L5;
        Integer r101 = null;
    L7:
        if ((r114 & 16) == 0) goto L9;
        Integer r102 = null;
    L10:
        c(r100, r110, r111, r101, r102, null, null);
        return;
    L9:
        r102 = r113;
        goto L10
    L5:
        r101 = r112;
        goto L7
    }

    @JvmStatic
    public static final void b(GenericDraweeView r100, ECUrlModel r101, r r102, Integer r110, Integer r111, Postprocessor r112, ControllerListener<? super ImageInfo> r113) {
        Intrinsics.checkNotNullParameter(r100, "draweeView");
        if (r101 == null) goto L5;
        List<String> r103 = r101.getUrlList();
    L6:
        c(r100, r103, r102, r110, r111, r112, r113);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @JvmStatic
    public static final void c(GenericDraweeView r110, List<String> r111, r r112, Integer r113, Integer r114, Postprocessor r210, ControllerListener<? super ImageInfo> r211) {
        Intrinsics.checkNotNullParameter(r110, "draweeView");
        List<String> r100 = r111;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return;
    L11:
        ImageExtensionsKt.x(r110, r111, null, r112, r113, r114, null, r210, r211, false, null, null, null, 7936);
        return;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public static /* synthetic */ void d(GenericDraweeView r100, ECUrlModel r110, r r111, Integer r112, Integer r113, Postprocessor r114, ControllerListener r115, int r116) {
        if ((r116 & 8) == 0) goto L5;
        Integer r101 = null;
    L7:
        if ((r116 & 16) == 0) goto L9;
        Integer r102 = null;
    L11:
        if ((r116 & 32) == 0) goto L13;
        Postprocessor r103 = null;
    L15:
        if ((r116 & 64) == 0) goto L17;
        ControllerListener r104 = null;
    L18:
        b(r100, r110, r111, r101, r102, r103, r104);
        return;
    L17:
        r104 = r115;
        goto L18
    L13:
        r103 = r114;
        goto L15
    L9:
        r102 = r113;
        goto L11
    L5:
        r101 = r112;
        goto L7
    }
}
