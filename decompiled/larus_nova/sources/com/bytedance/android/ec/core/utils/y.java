package com.bytedance.android.ec.core.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.imagex.ImageExperiments;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.ImageSettings;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes43.dex */
@Deprecated(message = "USE ImageHelper OR RemoteImage, @kepan.me")
public final class y {

    public class a extends BaseDataSubscriber<CloseableReference<CloseableImage>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f45746a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f45747b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ImagePipeline f45748c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ImageRequest[] f45749d;

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r100) {
            Throwable r101 = r100.getFailureCause();
            ImagePipeline r102 = this.f45748c;
            ImageRequest[] r103 = this.f45749d;
            int r104 = this.f45746a;
            this.f45746a = r104 + 1;
            if (y.i(r102, r103, r104, this) == true) goto L6;
            b r105 = this.f45747b;
            new RuntimeException(r101);
            r105.onFailure();
            return;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> r100) {
            this.f45747b.onSuccess(r100);
        }

        public a(b r100, ImagePipeline r101, ImageRequest[] r102) {
            this.f45747b = r100;
            this.f45748c = r101;
            this.f45749d = r102;
            this.f45746a = 1;
        }
    }

    public interface b {
        void onFailure();

        void onSuccess(DataSource<CloseableReference<CloseableImage>> r100);
    }

    public interface c<T> {
        void accept(T r100);
    }

    public static abstract class d implements ControllerListener<ImageInfo> {
        public d() {
        }

        public void a(String r100, ImageInfo r101, Animatable r102) {
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onIntermediateImageFailed(String r100, Throwable r101) {
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onRelease(String r100) {
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onSubmit(String r100, Object r101) {
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final /* bridge */ /* synthetic */ void onIntermediateImageSet(String r100, ImageInfo r101) {
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public /* bridge */ /* synthetic */ void onFinalImageSet(String r100, ImageInfo r101, Animatable r102) {
            a(r100, r101, r102);
        }
    }

    public static boolean m() {
        return ((Boolean) ImageSettings.f44458a.getValue()).booleanValue();
    }

    public static com.bytedance.android.ec.core.imagex.r j(GenericDraweeView r100) {
        if (r100 == null) goto L4;
        com.bytedance.android.ec.core.imagex.r r101 = ImageExtensionsKt.j(r100);
        if (r101 != null) goto L9;
        com.bytedance.android.ec.core.imagex.r r102 = com.bytedance.android.ec.core.imagex.t.f44951a;
        r101 = com.bytedance.android.ec.core.imagex.t.a(r100.getContext());
    L9:
        if ((r101 instanceof com.bytedance.android.ec.core.imagex.r) == false) goto L12;
        com.bytedance.android.ec.core.imagex.u r103 = new com.bytedance.android.ec.core.imagex.u(r101);
        r103.B();
        r103.A(r100.getContext());
        r103.D(r100);
        return r103;
    L12:
        return r101;
    L4:
        return com.bytedance.android.ec.core.imagex.t.a(null);
    }

    public static boolean k(Uri r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        ImageRequest r101 = ImageRequest.fromUri(r100);
        CacheKey r102 = Fresco.getImagePipeline().getCacheKeyFactory().getEncodedCacheKey(r101, null);
        return ImagePipelineFactory.getInstance().getMainFileCache().hasKey(r102);
    }

    public static void a(GenericDraweeView r100, ECUrlModel r101) {
        c(r100, r101, -1, -1, null);
    }

    public static void d(GenericDraweeView r100, String r101) {
        e(r100, r101, -1, -1, null);
    }

    public static ImageRequest[] h(ECUrlModel r100, ResizeOptions r101) {
        if (r100 == null) goto L48;
        if (r100.getUrlList() == null) goto L48;
        if (r100.getUrlList().size() == 0) goto L48;
        if (m() == false) goto L31;
        ImageExperiments.G.getClass();
        if (ImageExperiments.c() == false) goto L31;
        KProperty[] r102 = ImageExtensionsKt.f44433a;
        Intrinsics.checkNotNullParameter(r100, "urlModel");
        List<String> r103 = r100.getUrlList();
        List<String> r104 = r103;
        if (r104 != null) goto L16;
    L19:
        boolean r105 = true;
    L20:
        Pair<List<ImageRequest>, com.bytedance.android.ec.core.imagex.r> r106 = null;
        if (r105 == true) goto L24;
        r106 = ImageExtensionsKt.m(r103, null, null, null, null);
    L24:
        if (r106 == null) goto L31;
        if (r106.getFirst() == null) goto L31;
        if (r106.getFirst().isEmpty() == true) goto L31;
        return (ImageRequest[]) r106.getFirst().toArray(new ImageRequest[0]);
    L16:
        if (r104.isEmpty() == true) goto L19;
        r105 = false;
    L31:
        ArrayList r107 = new ArrayList();
        Iterator<String> r108 = r100.getUrlList().iterator();
    L33:
        if (r108.hasNext() == false) goto L42;
        String r109 = r108.next();
        if (StringUtils.isEmpty(r109) == true) goto L33;
        ImageRequestBuilder r110 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r109));
        if (r101 == null) goto L40;
        r110.setResizeOptions(r101);
    L40:
        r107.add(r110.build());
        goto L33
    L42:
        if (r107.size() != 0) goto L46;
        return new ImageRequest[0];
    L46:
        return (ImageRequest[]) r107.toArray(new ImageRequest[r107.size()]);
    L48:
        return new ImageRequest[0];
    }

    public static void n(ECUrlModel r100, b r101) {
        ImageRequest[] r102 = h(r100, null);
        ImagePipeline r103 = Fresco.getImagePipeline();
        i(r103, r102, 0, new a(r101, r103, r102));
    }

    public static void b(GenericDraweeView r100, ECUrlModel r101, int r102, int r103) {
        c(r100, r101, r102, r103, null);
    }

    public static void g(GenericDraweeView r100, String r101, int r102, int r103) {
        int r104 = -2;
        if (r102 > 0) goto L6;
        if (r103 > 0) goto L6;
        r102 = -2;
        int r105 = 33;
    L12:
        if (r100.getLayoutParams() == null) goto L14;
        r100.getLayoutParams().width = r102;
        r100.getLayoutParams().height = r104;
    L15:
        if (r105 != 0) goto L17;
    L19:
        e(r100, r101, -1, -1, null);
        return;
    L17:
        if ((r100 instanceof ECDraweeView) == false) goto L19;
        ((ECDraweeView) r100).setAdjustMode(r105);
        goto L19
    L14:
        r100.setLayoutParams(new ViewGroup.LayoutParams(r102, r104));
    L6:
        if (r102 > 0) goto L8;
        r104 = r103;
        r102 = -2;
        r105 = 1;
        goto L12
    L8:
        if (r103 > 0) goto L10;
        r105 = 2;
        goto L12
    L10:
        r104 = r103;
        r105 = 0;
        goto L12
    }

    public static boolean i(ImagePipeline r100, ImageRequest[] r101, int r102, DataSubscriber<CloseableReference<CloseableImage>> r103) {
        if (r102 < r101.length) goto L6;
        return false;
    L6:
        com.bytedance.android.ec.core.imagex.r r104 = null;
        if (m() == false) goto L11;
        ImageExperiments.G.getClass();
        if (ImageExperiments.c() == false) goto L11;
        r104 = com.bytedance.android.ec.core.imagex.t.a(null);
    L11:
        r100.fetchDecodedImage(r101[r102], r104).subscribe(r103, UiThreadImmediateExecutorService.getInstance());
        return true;
    }

    public static void l(ECUrlModel r100, int r101, int r110, final c<Bitmap> r111) {
        ImageExperiments.G.getClass();
        ResizeOptions r102 = null;
        if (ImageExperiments.c() == false) goto L5;
        com.bytedance.android.ec.core.imagex.r r103 = com.bytedance.android.ec.core.imagex.t.a(null);
    L7:
        if (m() == false) goto L20;
        if (r100 == null) goto L20;
        if ((r103 instanceof com.bytedance.android.ec.core.imagex.r) == false) goto L20;
        Integer r104 = Integer.valueOf(r101);
        Integer r105 = Integer.valueOf(r110);
        Function1 r106 = new x(r111);
        KProperty[] r107 = ImageExtensionsKt.f44433a;
        Intrinsics.checkNotNullParameter(r100, "$this$fetchImage");
        List<String> r108 = r100.getUrlList();
        if (r108 != null) goto L14;
        return;
    L14:
        if ((!r108.isEmpty()) == false) goto L16;
        List<String> r109 = r108;
    L17:
        if (r109 == null) goto L38;
        ImageExtensionsKt.g(r109, r103, r104, r105, null, r106);
        return;
    L38:
        return;
    L16:
        r109 = null;
    L20:
        if ((r103 instanceof com.bytedance.android.ec.core.imagex.r) == false) goto L22;
        com.bytedance.android.ec.core.imagex.u r112 = new com.bytedance.android.ec.core.imagex.u(r103);
        r103 = r112;
    L23:
        if (r112 == null) goto L25;
        r112.B();
    L25:
        ImagePipeline r113 = ImagePipelineFactory.getInstance().getImagePipeline();
        if (r101 <= 0) goto L29;
        if (r110 <= 0) goto L29;
        r102 = new ResizeOptions(r101, r110);
    L29:
        ImageRequest[] r114 = h(r100, r102);
        if (r114.length == 0) goto L40;
        DataSource<CloseableReference<CloseableImage>> r115 = r113.fetchDecodedImage(r114[0], r103);
        if (r112 == null) goto L35;
        r112.C(r102);
        r112.k();
    L35:
        r115.subscribe(new z(r115, r111), CallerThreadExecutor.getInstance());
        return;
    L40:
        return;
    L22:
        r112 = null;
        goto L23
    L5:
        r103 = null;
        goto L7
    }

    public static void c(GenericDraweeView r110, ECUrlModel r111, int r112, int r113, z53.a r210) {
        if (r110 == null) goto L32;
        if (r111 != null) goto L6;
        return;
    L6:
        if (r111.getUrlList() != null) goto L8;
        return;
    L8:
        if (r111.getUrlList().size() != 0) goto L11;
        return;
    L11:
        if (m() == false) goto L14;
        ImageExtensionsKt.r(r110, r111, null, null, Integer.valueOf(r112), Integer.valueOf(r113), null, null, r210, true, null, null, null, null);
        return;
    L14:
        com.bytedance.android.ec.core.imagex.r r100 = j(r110);
        if (r112 <= 0) goto L18;
        if (r113 <= 0) goto L18;
        ResizeOptions r101 = new ResizeOptions(r112, r113);
    L19:
        ImageRequest[] r102 = h(r111, r101);
        if (r102 != null) goto L22;
        return;
    L22:
        if (r102.length == 0) goto L37;
        PipelineDraweeControllerBuilder r103 = Fresco.newDraweeControllerBuilder().setOldController(r110.getController()).setFirstAvailableImageRequests(r102);
        if (r210 == null) goto L27;
        r103.setControllerListener(r210);
    L27:
        AbstractDraweeController r104 = r103.setCallerContext(r100).build();
        if ((r100 instanceof com.bytedance.android.ec.core.imagex.u) == false) goto L30;
        com.bytedance.android.ec.core.imagex.u r105 = (com.bytedance.android.ec.core.imagex.u) r100;
        r105.C(r101);
        r105.k();
    L30:
        r110.setController(r104);
        return;
    L37:
        return;
    L18:
        r101 = null;
        goto L19
    }

    public static void e(GenericDraweeView r110, String r111, int r112, int r113, w r114) {
        if (r110 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r111) == true) goto L36;
        ControllerListener<? super ImageInfo> r100 = null;
        if (m() == false) goto L14;
        if (r114 == null) goto L11;
        ControllerListener<? super ImageInfo> r101 = r114.f45734a;
        Function1<? super DraweeController, Unit> r115 = r114.f45735b;
        ControllerListener<? super ImageInfo> r102 = r101;
    L12:
        ImageExtensionsKt.s(r110, r111, null, null, Integer.valueOf(r112), Integer.valueOf(r113), null, null, r102, true, null, r115, null);
        return;
    L11:
        r102 = null;
        r115 = null;
        goto L12
    L14:
        com.bytedance.android.ec.core.imagex.r r103 = j(r110);
        if (r112 <= 0) goto L18;
        if (r113 <= 0) goto L18;
        ResizeOptions r104 = new ResizeOptions(r112, r113);
    L19:
        ImageRequestBuilder r105 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r111));
        if (r104 == null) goto L22;
        r105.setResizeOptions(r104);
    L22:
        PipelineDraweeControllerBuilder r106 = Fresco.newDraweeControllerBuilder().setOldController(r110.getController()).setImageRequest(r105.build()).setCallerContext(r103);
        if (r114 == null) goto L25;
        r100 = r114.f45734a;
    L25:
        AbstractDraweeController r107 = r106.setControllerListener(r100).build();
        if (r114 == null) goto L31;
        Function1<? super DraweeController, Unit> r108 = r114.f45735b;
        if (r108 == null) goto L31;
        r108.invoke(r107);
    L31:
        if ((r103 instanceof com.bytedance.android.ec.core.imagex.u) == false) goto L33;
        com.bytedance.android.ec.core.imagex.u r109 = (com.bytedance.android.ec.core.imagex.u) r103;
        r109.C(r104);
        r109.k();
    L33:
        r110.setController(r107);
        return;
    L18:
        r104 = null;
        goto L19
    }

    public static void f(GenericDraweeView r110, String r111, int r112, int r113, ControllerListener r114) {
        if (r110 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r111) == false) goto L8;
        return;
    L8:
        if (m() == false) goto L11;
        ImageExtensionsKt.s(r110, r111, null, null, Integer.valueOf(r112), Integer.valueOf(r113), null, null, r114, true, null, null, null);
        return;
    L11:
        com.bytedance.android.ec.core.imagex.r r100 = j(r110);
        if (r112 <= 0) goto L15;
        if (r113 <= 0) goto L15;
        ResizeOptions r101 = new ResizeOptions(r112, r113);
    L16:
        ImageRequestBuilder r102 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r111));
        if (r101 == null) goto L19;
        r102.setResizeOptions(r101);
    L19:
        ImageRequest r103 = r102.build();
        AbstractDraweeController r104 = Fresco.newDraweeControllerBuilder().setOldController(r110.getController()).setControllerListener(r114).setImageRequest(r103).setCallerContext(r100).build();
        if ((r100 instanceof com.bytedance.android.ec.core.imagex.u) == false) goto L22;
        com.bytedance.android.ec.core.imagex.u r105 = (com.bytedance.android.ec.core.imagex.u) r100;
        r105.C(r101);
        r105.k();
    L22:
        r110.setController(r104);
        return;
    L15:
        r101 = null;
        goto L16
    }
}
