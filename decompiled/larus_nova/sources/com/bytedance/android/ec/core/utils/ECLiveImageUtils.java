package com.bytedance.android.ec.core.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.ec.core.imagex.ImageExperiments;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.ImageSettings;
import com.bytedance.android.ec.core.widget.ECLiveExplainWaveView;
import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.bytedance.android.ec.core.widget.ECPromotionImageView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECPromotionBottomBanner;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
public final class ECLiveImageUtils {

    public static class ECNetImageInfo implements Serializable {
        public static final int WRAP_IMAGE = -3;
        public boolean autoPlayAnimations;
        public boolean autoScaleOneSide;
        public boolean disableFade;
        public boolean disablePlaceholder;
        public int height;
        public int placeholderImage;
        public int roundDp;
        public String url;
        public int width;

        public ECNetImageInfo() {
            this.width = -3;
            this.height = -3;
            this.roundDp = 0;
            this.placeholderImage = 0;
            this.autoPlayAnimations = false;
            this.disableFade = false;
            this.disablePlaceholder = false;
        }
    }

    public class a extends BaseControllerListener<ImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f45514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f45515b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f45516c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SimpleDraweeView f45517d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ECUrlModel f45518e;

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onIntermediateImageSet(String r100, Object r101) {
            ImageInfo r102 = (ImageInfo) r101;
            if (this.f45514a == true) goto L5;
        L9:
            ECLiveImageUtils.a(this.f45517d, r102);
        L10:
            this.f45517d.setTag(R.id.detail_page_sku_image_view_uri, this.f45518e.getUri());
            return;
        L5:
            if (this.f45515b <= 0) goto L9;
            if (this.f45516c <= 0) goto L9;
            ECNetImageInfo r103 = new ECNetImageInfo();
            r103.width = this.f45515b;
            r103.height = this.f45516c;
            ECLiveImageUtils.l(this.f45517d, r102, r103);
            goto L10
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            ImageInfo r103 = (ImageInfo) r101;
            if (this.f45514a == true) goto L5;
        L9:
            ECLiveImageUtils.a(this.f45517d, r103);
        L10:
            this.f45517d.setTag(R.id.detail_page_sku_image_view_uri, this.f45518e.getUri());
            return;
        L5:
            if (this.f45515b <= 0) goto L9;
            if (this.f45516c <= 0) goto L9;
            ECNetImageInfo r104 = new ECNetImageInfo();
            r104.width = this.f45515b;
            r104.height = this.f45516c;
            ECLiveImageUtils.l(this.f45517d, r103, r104);
            goto L10
        }

        public a(boolean r100, int r101, int r102, SimpleDraweeView r103, ECUrlModel r104) {
            this.f45514a = r100;
            this.f45515b = r101;
            this.f45516c = r102;
            this.f45517d = r103;
            this.f45518e = r104;
        }
    }

    public class b implements Function1<DraweeController, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f45519a;

        public b(Function1 r100) {
            this.f45519a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(DraweeController r100) {
            DraweeController r101 = r100;
            Function1 r102 = this.f45519a;
            if (r102 == null) goto L7;
            r102.invoke(r101);
            return null;
        L7:
            return null;
        }
    }

    public class c extends BaseControllerListener<ImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f45520a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f45521b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f45522c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SimpleDraweeView f45523d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ECUrlModel f45524e;

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onIntermediateImageSet(String r100, Object r101) {
            ImageInfo r102 = (ImageInfo) r101;
            if (this.f45520a == true) goto L5;
        L9:
            ECLiveImageUtils.a(this.f45523d, r102);
        L10:
            this.f45523d.setTag(R.id.detail_page_sku_image_view_uri, this.f45524e.getUri());
            return;
        L5:
            if (this.f45521b <= 0) goto L9;
            if (this.f45522c <= 0) goto L9;
            ECNetImageInfo r103 = new ECNetImageInfo();
            r103.width = this.f45521b;
            r103.height = this.f45522c;
            ECLiveImageUtils.l(this.f45523d, r102, r103);
            goto L10
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            ImageInfo r103 = (ImageInfo) r101;
            if (this.f45520a == true) goto L5;
        L9:
            ECLiveImageUtils.a(this.f45523d, r103);
        L10:
            this.f45523d.setTag(R.id.detail_page_sku_image_view_uri, this.f45524e.getUri());
            return;
        L5:
            if (this.f45521b <= 0) goto L9;
            if (this.f45522c <= 0) goto L9;
            ECNetImageInfo r104 = new ECNetImageInfo();
            r104.width = this.f45521b;
            r104.height = this.f45522c;
            ECLiveImageUtils.l(this.f45523d, r103, r104);
            goto L10
        }

        public c(boolean r100, int r101, int r102, SimpleDraweeView r103, ECUrlModel r104) {
            this.f45520a = r100;
            this.f45521b = r101;
            this.f45522c = r102;
            this.f45523d = r103;
            this.f45524e = r104;
        }
    }

    public static boolean k() {
        if (((Boolean) ImageSettings.f44458a.getValue()).booleanValue() == false) goto L7;
        ImageExperiments.G.getClass();
        if (ImageExperiments.c() == false) goto L7;
        return true;
    L7:
        return false;
    }

    public static com.bytedance.android.ec.core.imagex.r e(GenericDraweeView r100) {
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

    public static void a(SimpleDraweeView r100, ImageInfo r101) {
        if (r101 == null) goto L5;
        r100.getLayoutParams().width = r101.getWidth();
        r100.getLayoutParams().height = -2;
        r100.setAspectRatio(r101.getWidth() / r101.getHeight());
        return;
    }

    public static void b(final ECNetImageView r110, final ECNetImageInfo r111) {
        if (r110 == null) goto L34;
        if (r111 == null) goto L37;
        PipelineDraweeControllerBuilder r100 = Fresco.newDraweeControllerBuilder();
        e0 r101 = new e0();
        Context r112 = r110.getContext();
        if (r111.width > 0) goto L9;
    L11:
        r101.f45695a = new d0(r110, r111);
        if (k() == true) goto L14;
    L16:
        r100.setControllerListener(r101);
        String r102 = r111.url;
        if (r102 == null) goto L19;
        r100.setUri(UriProtector.parse(r102));
    L19:
        r100.setAutoPlayAnimations(r111.autoPlayAnimations);
        r100.setCallerContext(e(r110));
        r110.setController(r100.build());
    L20:
        GenericDraweeHierarchy r103 = r110.getHierarchy();
        if (r112 == null) goto L35;
        if (r103 != null) goto L24;
        return;
    L24:
        if (r111.disableFade == false) goto L27;
        r103.setFadeDuration(0);
    L27:
        if (r111.disablePlaceholder == true) goto L32;
        int r104 = r111.placeholderImage;
        if (r104 == 0) goto L31;
        r103.setPlaceholderImage(r104);
        goto L32
    L31:
        r103.setPlaceholderImage(R.drawable.ec_placeholder_small_image);
    L32:
        RoundingParams r105 = new RoundingParams();
        r105.setCornersRadius(d(r112, r111.roundDp));
        r103.setRoundingParams(r105);
        return;
    L35:
        return;
    L14:
        if (r111.url == null) goto L16;
        ImageExtensionsKt.s(r110, r111.url, null, null, null, null, null, null, r101, true, null, null, null);
        goto L20
    L9:
        if (r111.height <= 0) goto L11;
        r110.getLayoutParams().width = d(r112, r111.width);
        r110.getLayoutParams().height = d(r112, r111.height);
        goto L11
    L37:
        return;
    }

    public static int d(Context r100, float r101) {
        Resources r102 = r100.getResources();
        return (int) ((r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
    }

    public static void f(String r100, o r101) {
        ImagePipeline r102 = ImagePipelineFactory.getInstance().getImagePipeline();
        Priority r103 = Priority.MEDIUM;
        Bitmap.Config r104 = Bitmap.Config.RGB_565;
        if (k() == true) goto L5;
    L13:
        ImageDecodeOptionsBuilder r105 = new ImageDecodeOptionsBuilder();
        r105.setBitmapConfig(r104);
        r105.setPreDecodeFrameCount(1);
        r105.setDecodeAllFrames(false);
        ImageDecodeOptions r106 = new ImageDecodeOptions(r105);
        ImageRequest r107 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r100)).setRequestPriority(r103).setImageDecodeOptions(r106).build();
    L14:
        DataSource<CloseableReference<CloseableImage>> r108 = r102.fetchDecodedImage(r107, null);
        r108.subscribe(new f0(r108, r101), CallerThreadExecutor.getInstance());
        return;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L13;
        ArrayList r109 = new ArrayList();
        r109.add(r100);
        Pair<List<ImageRequest>, com.bytedance.android.ec.core.imagex.r> r110 = ImageExtensionsKt.m(r109, -1, -1, null, null);
        if (r110 == null) goto L13;
        if (r110.getFirst() == null) goto L13;
        if (r110.getFirst().isEmpty() == true) goto L13;
        r107 = (ImageRequest) ListProtector.get(r110.getFirst(), 0);
        goto L14
    }

    public static void g(ECPromotionImageView r100, String r101) {
        r100.getClass();
        if (TextUtils.isEmpty(r101) == true) goto L5;
        r100.f45988d.setVisibility(0);
        i(r100.f45988d, r101, r100.getImageRadius(), android.R.color.transparent);
        return;
    L5:
        ECNetImageView r102 = r100.f45988d;
        if (r102 == null) goto L10;
        r102.setVisibility(8);
        return;
    }

    public static void j(SimpleDraweeView r110, String r111) {
        if (r110 == null) goto L11;
        if (r111 != null) goto L6;
        return;
    L6:
        if (k() == false) goto L9;
        ImageExtensionsKt.s(r110, r111, null, null, null, null, null, null, null, true, null, null, null);
        return;
    L9:
        r110.setController(Fresco.newDraweeControllerBuilder().setOldController(r110.getController()).setCallerContext(e(r110)).setUri(UriProtector.parse(r111)).build());
        return;
    }

    public static void l(SimpleDraweeView r100, ImageInfo r101, ECNetImageInfo r102) {
        if (r101 == null) goto L22;
        int r103 = r102.width;
        if (r103 != (-3)) goto L6;
        r103 = r101.getWidth();
    L6:
        int r104 = r102.height;
        if (r104 != (-3)) goto L10;
        r104 = r101.getHeight();
    L10:
        if (r102.autoScaleOneSide == false) goto L19;
        ViewGroup.LayoutParams r105 = r100.getLayoutParams();
        int r106 = r102.width;
        int r107 = -2;
        if (r106 != (-3)) goto L14;
        r106 = -2;
    L14:
        r105.width = r106;
        ViewGroup.LayoutParams r108 = r100.getLayoutParams();
        int r109 = r102.height;
        if (r109 == (-3)) goto L18;
        r107 = r109;
    L18:
        r108.height = r107;
    L20:
        r100.setAspectRatio(r101.getWidth() / r101.getHeight());
        return;
    L19:
        r100.getLayoutParams().width = r103;
        r100.getLayoutParams().height = r104;
        goto L20
    }

    public static void c(SimpleDraweeView r110, ECUrlModel r111, boolean r112, Function1<DraweeController, Unit> r113) {
        if (r110 == null) goto L29;
        if (r111 != null) goto L6;
        return;
    L6:
        if (r111.getUrlList() != null) goto L8;
        return;
    L8:
        if (r111.getUrlList().isEmpty() == true) goto L33;
        int r100 = d(r110.getContext(), r111.getWidth());
        int r101 = d(r110.getContext(), r111.getHeight());
        if (r100 <= 0) goto L14;
        if (r101 <= 0) goto L14;
        ResizeOptions r102 = new ResizeOptions(r100, r101);
    L15:
        String r103 = (String) ListProtector.get(r111.getUrlList(), 0);
        if (r103 != null) goto L18;
        r103 = "";
    L18:
        String r114 = r103;
        if (k() == false) goto L21;
        ImageExtensionsKt.s(r110, r114, null, null, Integer.valueOf(r100), Integer.valueOf(r101), null, null, new a(r112, r100, r101, r110, r111), true, null, new b(r113), null);
        return;
    L21:
        ImageRequestBuilder r104 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r114));
        if (r102 == null) goto L24;
        r104.setResizeOptions(r102);
    L24:
        AbstractDraweeController r105 = Fresco.newDraweeControllerBuilder().setControllerListener(new c(r112, r100, r101, r110, r111)).setOldController(r110.getController()).setImageRequest(r104.build()).setCallerContext(e(r110)).build();
        if (r113 == null) goto L27;
        r113.invoke(r105);
    L27:
        r110.setController(r105);
        return;
    L14:
        r102 = null;
        goto L15
    L33:
        return;
    }

    public static void i(SimpleDraweeView r110, String r111, int r112, int r113) {
        if (r110 == null) goto L18;
        if (r111 != null) goto L7;
        return;
    L7:
        if (k() == false) goto L9;
        ImageExtensionsKt.s(r110, r111, null, null, null, null, null, null, null, true, null, null, null);
    L10:
        Context r100 = r110.getContext();
        GenericDraweeHierarchy r101 = r110.getHierarchy();
        if (r100 == null) goto L19;
        if (r101 == null) goto L20;
        if (r113 == 0) goto L15;
        r101.setPlaceholderImage(r113);
    L16:
        RoundingParams r102 = new RoundingParams();
        r102.setCornersRadius(d(r100, r112));
        r101.setRoundingParams(r102);
        return;
    L15:
        r101.setPlaceholderImage(R.drawable.ec_placeholder_small_image);
        goto L16
    L20:
        return;
    L19:
        return;
    L9:
        PipelineDraweeControllerBuilder r103 = Fresco.newDraweeControllerBuilder();
        r103.setUri(UriProtector.parse(r111));
        r103.setCallerContext(e(r110));
        r110.setController(r103.build());
        goto L10
    }

    public static void h(ECPromotionImageView r100, ECUIPromotion r101, int r102, boolean r103, boolean r110) {
        String r104 = r101.getImageUrl();
        String r105 = r101.soldHint;
        ECPromotionBottomBanner r106 = r101.bottomBanner;
        if (r102 != 1) goto L6;
        r100.B(r104);
    L34:
        if (r103 == false) goto L42;
        r100.getClass();
        if (ECAppInfoService.h() == false) goto L41;
        r100.f45993i.setVisibility(0);
        if (r110 == false) goto L40;
        r100.f45992h.setVisibility(8);
        r100.f45992h.clearAnimation();
        goto L42
    L40:
        r100.f45992h.setVisibility(0);
        r100.f45992h.setAnimation(r100.f45998n);
        r100.f45992h.playAnimation();
        r100.f45992h.loop(true);
        goto L42
    L41:
        r100.f45990f.setVisibility(0);
        ECLiveExplainWaveView r111 = r100.f45991g.f45915a;
        r111.f45975k = true;
        r111.invalidate();
    L42:
        r100.getClass();
        if (r103 == false) goto L46;
        if (r106 == null) goto L46;
        r100.f45996l.setVisibility(0);
        r100.f45995k.setText(r106.getText());
        c(r100.f45996l, r106.getRightIcon(), true, null);
        return;
    L46:
        r100.f45996l.setVisibility(8);
        TextView r107 = r100.f45995k;
        r107.setText(th.a.g(r107.getContext(), R.string.ec_explaining_text));
        return;
    L6:
        if (TextUtils.isEmpty(r105) == true) goto L12;
        r100.getClass();
        if (TextUtils.isEmpty(r105) == false) goto L10;
        r100.B(r104);
        r100.f45989e.setText(R.string.ec_sold_out);
        r100.f45989e.setVisibility(0);
        goto L34
    L10:
        r100.B(r104);
        TextView r108 = r100.f45989e;
        r108.setText(r108.getContext().getString(R.string.ec_sold_hint, new Object[]{r105}));
        r100.f45989e.setVisibility(0);
        goto L34
    L12:
        if (r102 != 4) goto L14;
    L32:
        r100.B(r104);
        r100.f45989e.setText(R.string.ec_sold_out);
        r100.f45989e.setVisibility(0);
        goto L34
    L14:
        if (r102 == 3) goto L32;
        if (r102 != 5) goto L20;
        r100.B(r104);
        r100.f45989e.setText(R.string.ec_under_stock);
        r100.f45989e.setVisibility(0);
        goto L34
    L20:
        if (r102 != 2) goto L23;
        r100.B(r104);
        r100.f45989e.setText(R.string.ec_sell_out);
        r100.f45989e.setVisibility(0);
        goto L34
    L23:
        if (r102 != 7000) goto L26;
        r100.B(r104);
        goto L34
    L26:
        if (r102 != 8000) goto L28;
    L31:
        r100.B(r104);
        goto L34
    L28:
        if (r102 == 9000) goto L31;
        r100.B(r104);
        r100.f45989e.setText(R.string.ec_sell_out);
        r100.f45989e.setVisibility(0);
        goto L34
    }
}
