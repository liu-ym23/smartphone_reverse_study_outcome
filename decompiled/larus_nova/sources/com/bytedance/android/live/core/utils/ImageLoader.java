package com.bytedance.android.live.core.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.utils.fresco.ImageNetworkRequestsMonitor;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.r3;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.larus.nova.R;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public class ImageLoader {
    public static final int FADE_DURATION = 300;
    private static final Handler HANDLER_MAIN = null;
    private static final String TAG = "ImageLoader";

    public class a implements p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p0 f66050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f66051b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SimpleDraweeView f66052c;

        @Override // com.bytedance.android.live.core.utils.p0
        public final /* synthetic */ void a(ImageInfo r100, Animatable r101) {
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final /* synthetic */ void d(ImageInfo r100) {
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final void e(py.k r100) {
            om0.c.c().i(ImageLoader.TAG, "[loadAntiFlink] load image stated " + r100.getUri() + " time " + System.currentTimeMillis());
            p0 r101 = this.f66050a;
            if (r101 == null) goto L6;
            r101.e(r100);
            return;
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final void b(py.k r100, Exception r101) {
            ALogger.i(ImageLoader.TAG, "[loadAntiFlink] load image fail " + r100.getUri() + " Exception info" + r101.getMessage());
            p0 r102 = this.f66050a;
            if (r102 == null) goto L6;
            r102.b(r100, r101);
            return;
        }

        public a(p0 r100, boolean r101, SimpleDraweeView r102) {
            this.f66050a = r100;
            this.f66051b = r101;
            this.f66052c = r102;
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final void c(py.k r100, int r101, int r102, boolean r103) {
            long r104 = System.currentTimeMillis();
            if (this.f66051b == false) goto L5;
            this.f66052c.setTag(R.id.ttlive_tag_image_model_loaded_key, new Pair(r100, Long.valueOf(r104)));
        L5:
            ALogger.i(ImageLoader.TAG, "[loadAntiFlink] load image success " + r100.getUri() + " time " + r104);
            p0 r105 = this.f66050a;
            if (r105 == null) goto L9;
            r105.c(r100, r101, r102, r103);
            return;
        }
    }

    public class b implements DataSubscriber<CloseableReference<PooledByteBuffer>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PipedOutputStream f66053a;

        @Override // com.facebook.datasource.DataSubscriber
        public final void onProgressUpdate(DataSource<CloseableReference<PooledByteBuffer>> r100) {
        }

        public b(PipedOutputStream r100) {
            this.f66053a = r100;
        }

        @Override // com.facebook.datasource.DataSubscriber
        public final void onCancellation(DataSource<CloseableReference<PooledByteBuffer>> r100) {
            this.f66053a.close();     // Catch: Throwable -> L4 IOException -> L9
        L4:
            th = move-exception;
            r100.close();
            throw th;
        L7:
            r100.close();
        }

        @Override // com.facebook.datasource.DataSubscriber
        public final void onFailure(DataSource<CloseableReference<PooledByteBuffer>> r100) {
            this.f66053a.close();     // Catch: Throwable -> L4 IOException -> L9
        L4:
            th = move-exception;
            r100.close();
            throw th;
        L7:
            r100.close();
        }

        @Override // com.facebook.datasource.DataSubscriber
        public final void onNewResult(DataSource<CloseableReference<PooledByteBuffer>> r100) {
            CloseableReference<PooledByteBuffer> r101 = r100.getResult();
            if (r101 == null) goto L15;
            PooledByteBuffer r102 = r101.get();
            byte[] r103 = new byte[r102.size()];
            r102.read(0, r103, 0, r102.size());
            this.f66053a.write(r103);     // Catch: Throwable -> L7 IOException -> L12
            this.f66053a.close();     // Catch: Throwable -> L7 IOException -> L12
        L7:
            th = move-exception;
            r100.close();
            throw th;
        L10:
            r100.close();
            return;
        }
    }

    public class c extends BaseBitmapDataSubscriber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DataSource f66054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImageUtil.LoadImageCallback f66055b;

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r100) {
            if (r100 == null) goto L4;
            r100.close();
        L4:
            final ImageUtil.LoadImageCallback r101 = this.f66055b;
            if (r101 == null) goto L8;
            ImageLoader.access$000(new r0(r101));
            return;
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public final void onNewResultImpl(Bitmap r100) {
            if (this.f66054a.isFinished() == false) goto L6;
            if (r100 == null) goto L6;
            final Bitmap r101 = r100.copy(Bitmap.Config.ARGB_8888, true);
            final ImageUtil.LoadImageCallback r102 = this.f66055b;
            ImageLoader.access$000(new s0(r102, r101));
        L9:
            this.f66054a.close();
            return;
        L6:
            final ImageUtil.LoadImageCallback r103 = this.f66055b;
            if (r103 == null) goto L9;
            ImageLoader.access$000(new t0(r103));
            goto L9
        }

        public c(DataSource r100, ImageUtil.LoadImageCallback r101) {
            this.f66054a = r100;
            this.f66055b = r101;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final py.k f66056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f66057b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f66058c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Postprocessor f66059d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public p0 f66060e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f66061f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f66062g;

        public d(py.k r100) {
            this.f66057b = -1;
            this.f66058c = -1;
            this.f66059d = null;
            this.f66060e = null;
            this.f66061f = false;
            this.f66062g = true;
            this.f66056a = r100;
        }

        public final void a(HSImageView r110) {
            ImageLoader.bindImage(r110, this.f66056a, null, 300, this.f66057b, this.f66058c, this.f66059d, this.f66060e, this.f66061f, this.f66062g, true);
        }
    }

    public static class e implements ControllerListener<ImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final py.k f66063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p0 f66064b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f66065c;

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onIntermediateImageFailed(String r100, Throwable r101) {
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onRelease(String r100) {
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onFailure(String r100, Throwable r101) {
            p0 r102 = this.f66064b;
            if (r102 == null) goto L6;
            r102.b(this.f66063a, new RuntimeException(r101));
            return;
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final /* bridge */ /* synthetic */ void onIntermediateImageSet(String r100, ImageInfo r101) {
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onSubmit(String r100, Object r101) {
            p0 r102 = this.f66064b;
            if (r102 == null) goto L6;
            r102.e(this.f66063a);
            return;
        }

        public e(py.k r100, p0 r101, boolean r102) {
            this.f66063a = r100;
            this.f66064b = r101;
            this.f66065c = r102;
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, ImageInfo r101, Animatable r110) {
            ImageInfo r102 = r101;
            v0 r103 = v0.f66419e;
            py.k r104 = this.f66063a;
            if (r103.f66423d != null) goto L6;
            r103.f66423d = j40.p.f497278a.getValue();
        L6:
            if (r103.f66423d == Boolean.TRUE) goto L26;
            if (r104 == null) goto L26;
            if (Lists.isEmpty(r104.getUrls()) == true) goto L26;
            Object r105 = r103.f66422c;
            monitor-enter(r105);
            Iterator<String> r106 = r104.getUrls().iterator();     // Catch: Throwable -> L23
        L16:
            if (r106.hasNext() == false) goto L21;
            String r107 = r106.next();     // Catch: Throwable -> L23
            if (((LinkedList) r103.f66421b).contains(r107) == false) goto L16;
            monitor-exit(r105);     // Catch: Throwable -> L23
            boolean r108 = true;
        L27:
            int r109 = -1;
            if (r102 == null) goto L30;
            int r111 = r102.getWidth();
        L31:
            if (r102 == null) goto L34;
            r109 = r102.getHeight();
        L34:
            if ((r110 instanceof AnimatedDrawable2) == true) goto L36;
        L38:
            py.k r112 = this.f66063a;
            if (r112 == null) goto L52;
            final v0 r113 = v0.f66419e;
            Boolean r114 = r113.f66423d;
            if (r114 != null) goto L43;
        L45:
            final List<String> r115 = r112.getUrls();
            if (r115 != null) goto L48;
        L51:
            this.f66063a.setLoaded(true);
            goto L52
        L48:
            if (r115.isEmpty() == true) goto L51;
            r113.f66420a.execute(new u0(r113, r115));
            goto L51
        L43:
            if (r114.booleanValue() == false) goto L45;
        L52:
            p0 r116 = this.f66064b;
            if (r116 == null) goto L60;
            r116.d(r102);
            this.f66064b.c(this.f66063a, r111, r109, r108);
            this.f66064b.a(r102, r110);
            return;
        L60:
            return;
        L36:
            if (this.f66065c == false) goto L38;
            ((AnimatedDrawable2) r110).setPrivateFrameSchedulerFactory(new com.bytedance.android.live.j());
            goto L38
        L30:
            r111 = -1;
            goto L31
        L21:
            monitor-exit(r105);     // Catch: Throwable -> L23
        L23:
            th = move-exception;
            throw th;
        L26:
            r108 = false;
            goto L27
        }
    }

    static {
        HANDLER_MAIN = new Handler(Looper.getMainLooper());
    }

    private ImageLoader() {
    }

    public static /* synthetic */ void access$000(Runnable r100) {
        runOnUiThread(r100);
    }

    public static InputStream getEncodedImageStream(Uri r100) {
        PipedOutputStream r101 = new PipedOutputStream();
        PipedInputStream r102 = new PipedInputStream(r101);     // Catch: IOException -> L6
        ImageRequest r103 = ImageRequestBuilder.newBuilderWithSource(r100).build();
        Fresco.getImagePipeline().fetchEncodedImage(r103, null).subscribe(new b(r101), AsyncTask.THREAD_POOL_EXECUTOR);
        return r102;
    L6:
        return null;
    }

    public static d load(String r100) {
        py.k r101 = (py.k) vh7.f.c(py.k.class);
        r101.setUri(r100);
        return load(r101);
    }

    private static void runOnUiThread(Runnable r100) {
        HANDLER_MAIN.post(r100);
    }

    private static Drawable toDrawable(int r100) {
        if (r100 > 0) goto L6;
        return null;
    L6:
        return s1.getContext().getResources().getDrawable(r100);
    }

    public static d load(py.k r100) {
        return new d(r100);
    }

    public static void bindDrawableResource(SimpleDraweeView r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.setImageURI(ImageRequestBuilder.newBuilderWithResourceId(r101).build().getSourceUri());
    }

    public static void bindGifImage(HSImageView r100, py.k r101) {
        if (r100 == null) goto L16;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getUrls() != null) goto L7;
        return;
    L7:
        if (r101.getUrls().size() == 0) goto L20;
        ImageRequest[] r102 = createImageRequests(r101, null, null);
        if (r102 != null) goto L12;
        return;
    L12:
        if (r102.length == 0) goto L21;
        r100.setController(Fresco.newDraweeControllerBuilder().setOldController(r100.getController()).setFirstAvailableImageRequests(r102).setAutoPlayAnimations(true).build());
        return;
    L21:
        return;
    L20:
        return;
    }

    public static void bindImage(HSImageView r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        r100.setImageURI(ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r101)).build().getSourceUri());
        return;
    }

    private static ImageRequest createImageRequestWithUri(Uri r100, ResizeOptions r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ImageRequestBuilder r102 = ImageRequestBuilder.newBuilderWithSource(r100);
        if (r101 == null) goto L9;
        r102.setResizeOptions(r101);
    L9:
        return r102.build();
    }

    public static void downloadBitmap(Uri r100, BaseBitmapDataSubscriber r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        ImageRequest r102 = ImageRequestBuilder.newBuilderWithSource(r100).setProgressiveRenderingEnabled(true).build();
        DataSource<CloseableReference<CloseableImage>> r103 = Fresco.getImagePipeline().fetchDecodedImage(r102, null);
        if (r101 == null) goto L8;
        r103.subscribe(r101, CallerThreadExecutor.getInstance());
        return;
    }

    private static void loadBitmapSynchronized(ImageRequest[] r100, ImageUtil.LoadImageCallback r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length == 0) goto L9;
        DataSource<CloseableReference<CloseableImage>> r102 = ImagePipelineFactory.getInstance().getImagePipeline().fetchDecodedImage(r100[0], null);
        r102.subscribe(new c(r102, r101), CallerThreadExecutor.getInstance());
        return;
    }

    public static void loadSdcardImage(HSImageView r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return;
    L7:
        if (r101.startsWith(MSkiaImageRegionDecoder.FILE_PREFIX) == true) goto L10;
        r101 = MSkiaImageRegionDecoder.FILE_PREFIX.concat(r101);
    L10:
        r100.setImageURI(ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r101)).build().getSourceUri());
    }

    public static void preload(Context r100, py.k r101) {
        if (r100 == null) goto L9;
        if (r101 != null) goto L5;
        return;
    L5:
        if (Lists.isEmpty(r101.getUrls()) == true) goto L11;
        Fresco.getImagePipeline().prefetchToBitmapCache(ImageRequest.fromUri((String) ListProtector.get(r101.getUrls(), 0)), r100);
        return;
    L11:
        return;
    }

    public static void bindDrawableResource(HSImageView r100, int r101) {
        bindDrawableResource(r100, r101);
    }

    public static void bindImage(SimpleDraweeView r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        r100.setImageURI(ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r101)).build().getSourceUri());
        return;
    }

    public static void downloadBitmap(String r100, BaseBitmapDataSubscriber r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        downloadBitmap(UriProtector.parse(r100), r101);
    }

    public static void preload(Context r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        Fresco.getImagePipeline().prefetchToBitmapCache(ImageRequest.fromUri(r101), r100);
        return;
    }

    public static void bindImage(HSImageView r100, py.k r101) {
        bindImage(r100, r101, null, -1, -1, null, null, false);
    }

    public static void bindImage(SimpleDraweeView r100, py.k r101) {
        bindImage(r100, r101, null, -1, -1, null, null, false);
    }

    public static void bindGifImage(SimpleDraweeView r100, py.k r101, ControllerListener r102) {
        if (r100 == null) goto L14;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getUrls() != null) goto L7;
        return;
    L7:
        if (r101.getUrls().size() == 0) goto L17;
        ImageRequest[] r103 = createImageRequests(r101, null, null);
        if (r103.length != 0) goto L12;
        return;
    L12:
        r100.setController(Fresco.newDraweeControllerBuilder().setOldController(r100.getController()).setFirstAvailableImageRequests(r103).setControllerListener(r102).build());
        return;
    L17:
        return;
    }

    public static void bindImage(HSImageView r100, String r101, Postprocessor r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L10;
        if (r102 == null) goto L11;
        ImageRequest r103 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r101)).setPostprocessor(r102).build();
        PipelineDraweeControllerBuilder r104 = Fresco.newDraweeControllerBuilder().setOldController(r100.getController()).setFirstAvailableImageRequests(new ImageRequest[]{r103});
        r100.setImageURI(r103.getSourceUri());
        r100.setController(r104.build());
        return;
    L11:
        return;
    }

    public static ImageRequest[] createImageRequests(py.k r100, int r101, int r102) {
        if (r100 != null) goto L6;
        return new ImageRequest[0];
    L6:
        return createImageRequests(r100, new ResizeOptions(r101, r102), null);
    }

    public static void bindImage(HSImageView r110, py.k r111, boolean r112) {
        bindImage(r110, r111, null, 300, -1, -1, null, null, false, false, r112);
    }

    public static ImageRequest[] createImageRequests(py.k r100, ResizeOptions r101, Postprocessor r102) {
        return createImageRequests(r100, r101, r102, false);
    }

    public static void bindImage(HSImageView r100, py.k r101, int r110) {
        bindImage(r100, r101, toDrawable(r110), -1, -1, null, null, false);
    }

    public static void bindImage(HSImageView r100, py.k r101, p0 r110) {
        bindImage(r100, r101, null, -1, -1, null, r110, false);
    }

    public static void bindImage(HSImageView r100, py.k r101, Postprocessor r110) {
        bindImage(r100, r101, null, -1, -1, r110, null, false);
    }

    public static void bindAvatar(HSImageView r100, py.k r101, int r110, int r111) {
        bindImage(r100, r101, null, r110, r111, null, null, false);
    }

    public static void bindDrawableResource(HSImageView r100, int r101, int r102, int r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        ImageRequestBuilder r104 = ImageRequestBuilder.newBuilderWithResourceId(r101);
        if (r102 <= 0) goto L8;
        if (r103 <= 0) goto L8;
        r104.setResizeOptions(new ResizeOptions(r102, r103));
    L8:
        r100.setImageRequest(r104.build());
    }

    public static void bindImage(HSImageView r100, String r101, int r102, int r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L13;
        ImageRequestBuilder r104 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r101));
        if (r102 <= 0) goto L10;
        if (r103 <= 0) goto L10;
        r104.setResizeOptions(new ResizeOptions(r102, r103));
    L10:
        r100.setImageURI(r104.build().getSourceUri());
        return;
    }

    public static void bindImageWithAnimation(HSImageView r100, py.k r101, p0 r110, boolean r111) {
        bindImage(r100, r101, null, -1, -1, null, r110, r111);
    }

    private static ImageRequest[] createImageRequests(py.k r100, ResizeOptions r101, Postprocessor r102, boolean r103) {
        if (r100 == null) goto L32;
        if (r100.getUrls() == null) goto L32;
        if (r100.getUrls().size() == 0) goto L32;
        ArrayList r104 = new ArrayList();
        ImageNetworkRequestsMonitor r105 = new ImageNetworkRequestsMonitor();
        Iterator<String> r106 = r100.getUrls().iterator();
    L11:
        if (r106.hasNext() == false) goto L26;
        String r107 = r106.next();
        if (StringUtils.isEmpty(r107) == true) goto L11;
        ImageRequestBuilder r108 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r107));
        if (r102 == null) goto L18;
        r108.setPostprocessor(r102);
    L18:
        if (r101 == null) goto L20;
        r108.setResizeOptions(r101);
    L20:
        r105.monitor(r108);
        if (LiveInfraSettingKeys.LIVE_BLUR_CACHE_KEY_OPT.getValue().booleanValue() == false) goto L24;
        if (r103 == false) goto L24;
        ImageDecodeOptionsBuilder r109 = new ImageDecodeOptionsBuilder();
        r109.setBitmapConfig(Bitmap.Config.RGB_565);
        r108.setImageDecodeOptions(r109.build());
    L24:
        r104.add(r108.build());
        goto L11
    L26:
        if (r104.size() != 0) goto L30;
        return new ImageRequest[0];
    L30:
        return (ImageRequest[]) r104.toArray(new ImageRequest[r104.size()]);
    L32:
        return new ImageRequest[0];
    }

    public static void loadBitmapSynchronized(String r100, int r101, int r102, ImageUtil.LoadImageCallback r103) {
        if (r101 <= 0) goto L5;
        if (r102 <= 0) goto L5;
        ResizeOptions r104 = new ResizeOptions(r101, r102);
    L6:
        ArrayList r105 = new ArrayList();
        ImageRequest r106 = createImageRequestWithUri(UriProtector.parse(r100), r104);
        if (r106 == null) goto L9;
        r105.add(r106);
    L9:
        loadBitmapSynchronized((ImageRequest[]) r105.toArray(new ImageRequest[r105.size()]), r103);
        return;
    L5:
        r104 = null;
        goto L6
    }

    public static void loadSdcardImage(HSImageView r100, String r101, int r102, int r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return;
    L7:
        if (r101.startsWith(MSkiaImageRegionDecoder.FILE_PREFIX) == true) goto L10;
        r101 = MSkiaImageRegionDecoder.FILE_PREFIX.concat(r101);
    L10:
        if (r102 <= 0) goto L13;
        if (r103 <= 0) goto L13;
        ResizeOptions r104 = new ResizeOptions(r102, r103);
    L14:
        ImageRequestBuilder r105 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r101));
        if (r104 == null) goto L17;
        r105.setResizeOptions(r104);
    L17:
        r100.setImageURI(r105.build().getSourceUri());
        return;
    L13:
        r104 = null;
        goto L14
    }

    public static void bindImage(HSImageView r100, py.k r110, p0 r111, boolean r112) {
        bindImage(r100, r110, null, -1, -1, null, r111, false, r112);
    }

    public static ImageRequest[] createImageRequests(py.k r100, int r101, int r102, long r103) {
        if (r100 != null) goto L6;
        return new ImageRequest[0];
    L6:
        return createImageRequests(r100, new ResizeOptions(r101, r102, r103), null);
    }

    public static void bindImage(HSImageView r100, py.k r101, int r110, int r111) {
        bindImage(r100, r101, null, r110, r111, null, null, false);
    }

    public static void bindImage(HSImageView r100, py.k r101, Postprocessor r110, p0 r111) {
        bindImage(r100, r101, null, -1, -1, r110, r111, false);
    }

    public static void bindImage(HSImageView r100, py.k r101, int r110, int r111, int r112) {
        bindImage(r100, r101, toDrawable(r110), r111, r112, null, null, false);
    }

    public static void bindImageWithAnimation(HSImageView r110, py.k r111, p0 r112, boolean r113, boolean r114) {
        bindImage(r110, r111, null, 300, -1, -1, null, r112, r113, false, true, r114);
    }

    public static void bindImageWithFocusCrop(SimpleDraweeView r100, py.k r101, int r102, int r103, PointF r104) {
        if (r100 == null) goto L33;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getUrls() != null) goto L7;
        return;
    L7:
        if (r101.getUrls().size() == 0) goto L38;
        if (r102 < 0) goto L11;
        if (r103 < 0) goto L11;
    L13:
        if (r102 <= 0) goto L16;
        if (r103 <= 0) goto L16;
        ResizeOptions r105 = new ResizeOptions(r102, r103);
    L17:
        ImageRequest[] r106 = createImageRequests(r101, r105, null, false);
        if (r106 != null) goto L20;
        return;
    L20:
        if (r106.length == 0) goto L39;
        PipelineDraweeControllerBuilder r107 = Fresco.newDraweeControllerBuilder().setOldController(r100.getController()).setFirstAvailableImageRequests(r106);
        if (r100.getHierarchy() != null) goto L25;
        r100.setHierarchy(new GenericDraweeHierarchyBuilder(r100.getContext().getResources()).setActualImageFocusPoint(r104).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FOCUS_CROP).build());
    L26:
        r107.setControllerListener(new e(r101, null, false));
        r100.setController(r107.build());
        if (r101.getImageContent() != null) goto L29;
    L31:
        r100.setImportantForAccessibility(2);
        return;
    L29:
        if (TextUtils.isEmpty(r101.getImageContent().getAccessibilityText()) == true) goto L31;
        r100.setFocusable(true);
        r100.setImportantForAccessibility(1);
        r3.a(r100, r101.getImageContent().getAccessibilityText());
        return;
    L25:
        GenericDraweeHierarchy r108 = r100.getHierarchy();
        r108.setActualImageFocusPoint(r104);
        r100.setHierarchy(r108);
        goto L26
    L39:
        return;
    L16:
        r105 = null;
    L11:
        r102 = r100.getMeasuredWidth();
        r103 = r100.getMeasuredHeight();
        goto L13
    L38:
        return;
    }

    public static void loadBitmapSynchronized(py.k r100, int r101, int r102, boolean r103, ImageUtil.LoadImageCallback r104) {
        if (r101 <= 0) goto L6;
        if (r102 <= 0) goto L6;
        ResizeOptions r105 = new ResizeOptions(r101, r102);
    L7:
        loadBitmapSynchronized(createImageRequests(r100, r105, null, r103), r104);
        return;
    L6:
        r105 = null;
        goto L7
    }

    public static void bindImage(HSImageView r100, py.k r101, int r110, int r111, p0 r112) {
        bindImage(r100, r101, null, r110, r111, null, r112, false);
    }

    public static void bindImage(HSImageView r100, py.k r101, int r110, int r111, Postprocessor r112) {
        bindImage(r100, r101, null, r110, r111, r112, null, false);
    }

    public static void bindImage(HSImageView r100, py.k r101, int r110, int r111, int r112, p0 r113) {
        bindImage(r100, r101, toDrawable(r110), r111, r112, null, r113, false);
    }

    public static void bindImage(SimpleDraweeView r110, py.k r111, Drawable r112, int r113, int r114, Postprocessor r115, p0 r116, boolean r117) {
        bindImage(r110, r111, r112, 300, r113, r114, r115, r116, r117, false, true);
    }

    public static void bindImage(SimpleDraweeView r110, py.k r111, Drawable r112, int r113, int r114, Postprocessor r115, p0 r116, boolean r117, boolean r118) {
        bindImage(r110, r111, r112, 300, r113, r114, r115, r116, r117, false, r118);
    }

    public static void bindImage(SimpleDraweeView r110, py.k r111, Drawable r112, int r113, int r114, int r115, Postprocessor r116, p0 r117, boolean r210, boolean r211, boolean r212) {
        bindImage(r110, r111, r112, r113, r114, r115, r116, r117, r210, r211, r212, false);
    }

    public static void bindImageAntiFlink(SimpleDraweeView r110, py.k r111, Drawable r112, int r113, int r114, int r115, Postprocessor r116, p0 r117, boolean r118, boolean r210, boolean r211) {
        if (r110 == null) goto L26;
        if (r111 != null) goto L6;
        return;
    L6:
        if (r111.getUrls() != null) goto L8;
        return;
    L8:
        if (r111.getUrls().size() == 0) goto L29;
        j40.x1 r100 = j40.x1.f497321a;
        boolean r101 = r100.getValue().isAvatarLoadAntiFlink();
        long r102 = r100.getValue().getAntiFlinkDebounce();
        if (r101 == false) goto L24;
        Object r103 = r110.getTag(R.id.ttlive_tag_image_model_loaded_key);
        if ((r103 instanceof Pair) == false) goto L24;
        Pair r104 = (Pair) r103;
        Object r105 = r104.first;
        Object r106 = r104.second;
        if ((r105 instanceof py.k) == false) goto L24;
        if ((r106 instanceof Long) == false) goto L24;
        long r107 = System.currentTimeMillis() - ((Long) r106).longValue();
        ALogger.i(TAG, "[loadAntiFlink] try load image " + r111.getUri() + " old " + ((py.k) r105).getUri() + " duration " + r107);
        if (r107 >= r102) goto L24;
        boolean r108 = r111.equalsOnlyUri(r105);
        ALogger.i(TAG, "[loadAntiFlink] try load image equals " + r108);
        if (r108 == false) goto L24;
        ALogger.e(TAG, "[loadAntiFlink] skip load image " + r111.getUri());
        return;
    L24:
        bindImage(r110, r111, r112, r113, r114, r115, r116, new a(r117, r101, r110), r118, r210, r211);
        return;
    L29:
        return;
    }

    public static void bindImage(SimpleDraweeView r100, py.k r101, Drawable r102, int r103, int r104, int r105, Postprocessor r106, p0 r107, boolean r108, boolean r110, boolean r111, boolean r112) {
        if (r100 == null) goto L41;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getUrls() != null) goto L7;
        return;
    L7:
        if (r101.getUrls().size() == 0) goto L46;
        if (r111 == false) goto L13;
        if (r104 < 0) goto L12;
        if (r105 >= 0) goto L13;
    L12:
        r104 = r100.getMeasuredWidth();
        r105 = r100.getMeasuredHeight();
    L13:
        if (r104 <= 0) goto L16;
        if (r105 <= 0) goto L16;
        ResizeOptions r113 = new ResizeOptions(r104, r105);
    L17:
        ImageRequest[] r109 = createImageRequests(r101, r113, r106, r110);
        if (r109 != null) goto L20;
        return;
    L20:
        if (r109.length == 0) goto L47;
        PipelineDraweeControllerBuilder r114 = Fresco.newDraweeControllerBuilder().setOldController(r100.getController()).setFirstAvailableImageRequests(r109);
        if (r108 == false) goto L25;
        r114.setAutoPlayAnimations(true);
    L25:
        if (r102 == null) goto L31;
        if (r100.getHierarchy() != null) goto L29;
        r100.setHierarchy(new GenericDraweeHierarchyBuilder(r100.getContext().getResources()).setFadeDuration(r103).setPlaceholderImage(r102).setPlaceholderImageScaleType(ScalingUtils.ScaleType.CENTER_CROP).build());
    L34:
        r114.setControllerListener(new e(r101, r107, r112));
        r100.setController(r114.build());
        if (r101.getImageContent() != null) goto L37;
    L39:
        r100.setImportantForAccessibility(2);
        return;
    L37:
        if (TextUtils.isEmpty(r101.getImageContent().getAccessibilityText()) == true) goto L39;
        r100.setFocusable(true);
        r100.setImportantForAccessibility(1);
        r3.a(r100, r101.getImageContent().getAccessibilityText());
        return;
    L29:
        GenericDraweeHierarchy r115 = r100.getHierarchy();
        r115.setFadeDuration(r103);
        r115.setPlaceholderImage(r102);
        r100.setHierarchy(r115);
        goto L34
    L31:
        if (r100.getHierarchy() != null) goto L33;
        r100.setHierarchy(new GenericDraweeHierarchyBuilder(r100.getContext().getResources()).setFadeDuration(r103).build());
        goto L34
    L33:
        GenericDraweeHierarchy r116 = r100.getHierarchy();
        r116.setFadeDuration(r103);
        r100.setHierarchy(r116);
        goto L34
    L47:
        return;
    L16:
        r113 = null;
        goto L17
    L46:
        return;
    }
}
