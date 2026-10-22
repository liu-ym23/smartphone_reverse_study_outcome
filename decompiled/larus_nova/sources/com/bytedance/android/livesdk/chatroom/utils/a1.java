package com.bytedance.android.livesdk.chatroom.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.utils.fresco.ImageNetworkRequestsMonitor;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdkapi.util.LiveBlurProcessorV2;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.FirstAvailableDataSourceSupplier;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.optimize.statistics.FrescoTraceListener;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes8.dex */
public final class a1 {

    public class a extends BaseDataSubscriber<CloseableReference<PooledByteBuffer>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f114395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f114396b;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.utils.a1$a$a, reason: collision with other inner class name */
        public class C1689a implements Consumer<Bitmap> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f114397a;

            public C1689a(a r100) {
                this.f114397a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Bitmap r100) throws Exception {
                Bitmap r101 = r100;
                if (r101 != null) goto L5;
            L10:
                boolean r102 = false;
            L11:
                if (r102 == true) goto L16;
                c r103 = this.f114397a.f114396b;
                if (r103 == null) goto L17;
                new RuntimeException();
                r103.onFail();
                return;
            L17:
                return;
            L16:
                return;
            L5:
                if (r101.getNinePatchChunk() == null) goto L10;
                a1.i(r101.getNinePatchChunk());
                NinePatchDrawable r104 = new NinePatchDrawable(com.bytedance.android.live.core.utils.s1.getResources(), r101, r101.getNinePatchChunk(), new Rect(), null);
                r104.setAutoMirrored(this.f114397a.f114395a);
                c r105 = this.f114397a.f114396b;
                if (r105 == null) goto L9;
                r105.a(r104);
            L9:
                r102 = true;
                goto L11
            }
        }

        public class b implements Function<PooledByteBuffer, Bitmap> {
            public b() {
            }

            @Override // io.reactivex.functions.Function
            public final Bitmap apply(PooledByteBuffer r100) throws Exception {
                return BitmapFactory.decodeStream(new PooledByteBufferInputStream(r100));
            }
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onFailureImpl(DataSource<CloseableReference<PooledByteBuffer>> r100) {
            c r101 = this.f114396b;
            if (r101 == null) goto L6;
            new RuntimeException();
            r101.onFail();
            return;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onNewResultImpl(DataSource<CloseableReference<PooledByteBuffer>> r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            if (r100.isFinished() == true) goto L6;
            return;
        L6:
            if (r100.getResult() != null) goto L8;
            return;
        L8:
            if (r100.getResult().get() == null) goto L15;
            Observable.just(r100.getResult().get()).subscribeOn(Schedulers.io()).map(new b()).compose(RxUtil.rxSchedulerHelper()).subscribe(new C1689a(this), RxUtil.getNoOpThrowable());
            return;
        }

        public a(boolean r100, c r101) {
            this.f114395a = r100;
            this.f114396b = r101;
        }
    }

    public interface b {
        void a(Bitmap r100);

        void onFail(Exception r100);
    }

    public interface c {
        void a(NinePatchDrawable r100);

        void onFail();
    }

    public static Rect i(byte[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ByteBuffer r101 = ByteBuffer.wrap(r100).order(ByteOrder.nativeOrder());
        if (r101.get() != 0) goto L8;
        return null;
    L8:
        r101.get();
        r101.get();
        r101.get();
        r101.getInt();
        r101.getInt();
        Rect r102 = new Rect();
        r102.left = r101.getInt();
        r102.right = r101.getInt();
        r102.top = r101.getInt();
        r102.bottom = r101.getInt();
        return r102;
    }

    public static boolean j(py.k r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.isValid() == false) goto L6;
        return true;
    }

    public static Observable<Bitmap> k(py.k r100) {
        return l(r100, 0, 0, false, null);
    }

    public static void z(py.k r100) {
        if (r100 == null) goto L5;
        k(r100).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.user.h());
        return;
    }

    public static ImageRequest[] b(py.k r100, int r110) {
        if (r100 != null) goto L5;
    L33:
        return null;
    L5:
        if (r100.getUrls() == null) goto L33;
        if (r100.getUrls().size() == 0) goto L33;
        ArrayList r101 = new ArrayList();
        ImageNetworkRequestsMonitor r102 = new ImageNetworkRequestsMonitor();
        Iterator<String> r103 = r100.getUrls().iterator();
    L11:
        if (r103.hasNext() == false) goto L29;
        String r104 = r103.next();
        if (StringUtils.isEmpty(r104) == true) goto L11;
        ImageRequestBuilder r105 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r104));
        r102.monitor(r105);
        if (r110 < 0) goto L27;
        CountingMemoryCache<CacheKey, CloseableImage> r106 = com.bytedance.android.live.core.utils.fresco.e.f66139a;
        Bitmap.Config r107 = Bitmap.Config.ARGB_8888;
        if (r105 == null) goto L27;
        ImageDecodeOptionsBuilder r108 = new ImageDecodeOptionsBuilder().setBitmapConfig(r107);
        Method r109 = com.bytedance.android.live.core.utils.fresco.e.f66140b;
        if (r109 != null) goto L34;
    L26:
        r105.setImageDecodeOptions(r108.build());
        goto L27
    L34:
        r109.invoke(r108, new Object[]{Integer.valueOf(r110)});     // Catch: Throwable -> L25
    L25:
        ALogger.e(FrescoTraceListener.ALOGTAG, "");
    L27:
        r101.add(r105.build());
        goto L11
    L29:
        if (r101.size() != 0) goto L32;
        return null;
    L32:
        return (ImageRequest[]) r101.toArray(new ImageRequest[r101.size()]);
    }

    public static Drawable e(py.k r100, boolean r101) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.getUrls() != null) goto L6;
        return null;
    L6:
        if (r100.getUrls().size() == 0) goto L16;
        ImageRequest[] r102 = b(r100, -1);
        AbstractDraweeController r103 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(r102).setAutoPlayAnimations(true).build();
        GenericDraweeHierarchy r104 = new GenericDraweeHierarchyBuilder(com.bytedance.android.live.core.utils.s1.getResources()).build();
        if (r101 == false) goto L11;
        r104.setFadeDuration(0);
    L11:
        DraweeHolder r105 = DraweeHolder.create(r104, com.bytedance.android.live.core.utils.s1.getContext());
        r105.setController(r103);
        return r105.getTopLevelDrawable();
    L16:
        return null;
    }

    public static NinePatchDrawable h(Bitmap r110, float r111) {
        Matrix r100 = new Matrix();
        r100.postScale(r111, r111);
        Bitmap r101 = Bitmap.createBitmap(r110, 0, 0, r110.getWidth(), r110.getHeight(), r100, true);
        if (r110.getNinePatchChunk() == null) goto L24;
        byte[] r112 = r110.getNinePatchChunk();
        if (r112 != null) goto L7;
    L6:
        byte[] r113 = null;
    L23:
        return new NinePatchDrawable(com.bytedance.android.live.core.utils.s1.getResources(), r101, r113, i(r113), null);
    L7:
        ByteBuffer r102 = ByteBuffer.allocate(r112.length).order(ByteOrder.nativeOrder());
        ByteBuffer r114 = ByteBuffer.wrap(r112).order(ByteOrder.nativeOrder());
        if (r114.get() == 0) goto L6;
        r102.put((byte) 1);
        int r103 = r114.get();
        int[] r104 = new int[r103];
        int r105 = r114.get();
        int[] r106 = new int[r105];
        int r107 = r114.get();
        int[] r108 = new int[r107];
        r102.put((byte) r103);
        r102.put((byte) r105);
        r102.put((byte) r107);
        r102.putInt(r114.getInt());
        r102.putInt(r114.getInt());
        r102.putInt((int) (r114.getInt() * r111));
        r102.putInt((int) (r114.getInt() * r111));
        r102.putInt((int) (r114.getInt() * r111));
        r102.putInt((int) (r114.getInt() * r111));
        r102.putInt(r114.getInt());
        int r109 = 0;
        r104[0] = r114.getInt();
        int r115 = r114.getInt();
        r104[1] = r115;
        int r116 = (int) (r104[0] * r111);
        int r117 = (int) (r115 * r111);
        if (r117 != r116) goto L14;
        if (r117 == 0) goto L14;
        r117 = r117 + 1;
    L14:
        r102.putInt(r116);
        r102.putInt(r117);
        r106[0] = r114.getInt();
        int r118 = r114.getInt();
        r106[1] = r118;
        int r119 = (int) (r106[0] * r111);
        int r120 = (int) (r118 * r111);
        if (r119 != r120) goto L18;
        if (r120 == 0) goto L18;
        r120 = r120 + 1;
    L18:
        r102.putInt(r119);
        r102.putInt(r120);
    L19:
        if (r109 >= r107) goto L21;
        r102.putInt(r114.getInt());
        r109 = r109 + 1;
        goto L19
    L21:
        r113 = r102.array();
        goto L23
    L24:
        return null;
    }

    public static void m(ImageView r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        ImageUtil.loadImage(r100, Integer.valueOf(r101));
    }

    public static void n(HSImageView r100, String r101) {
        py.k r102 = (py.k) vh7.f.c(py.k.class);
        r102.setUrls(Collections.singletonList(r101));
        ImageUtil.loadImage(r100, r102, 0);
    }

    public static void s(HSImageView r100, String r101) {
        FrescoLoader.with(r100.getContext()).load(r101).cornersRadius(com.bytedance.android.live.core.utils.s1.f(8)).actualScaleType(ImageView.ScaleType.CENTER_CROP).into(r100);
    }

    @Deprecated(message = "新方案多端统一，不再使用.9图，需要UI给新png图，见ResizableImageLoader")
    public static void u(py.k r100, b r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getUrls() != null) goto L6;
        return;
    L6:
        if (r100.getUrls().size() == 0) goto L12;
        Uri r102 = UriProtector.parse((String) ListProtector.get(r100.getUrls(), 0));
        ImageNetworkRequestsMonitor r103 = new ImageNetworkRequestsMonitor();
        ImageRequestBuilder r104 = ImageRequestBuilder.newBuilderWithSource(r102);
        r103.monitor(r104);
        ImageRequest r105 = r104.build();
        Fresco.getImagePipeline().fetchEncodedImage(r105, null).subscribe(new z0(r101), UiThreadImmediateExecutorService.getInstance());
        return;
    }

    @Deprecated(message = "新方案多端统一，不再使用.9图，需要UI给新png图，见ResizableImageLoader")
    public static void d(py.k r100, boolean r101, c r102) {
        if (r100.getUrls() != null) goto L5;
        return;
    L5:
        if (r100.getUrls().size() == 0) goto L10;
        Uri r103 = UriProtector.parse((String) ListProtector.get(r100.getUrls(), 0));
        ImageNetworkRequestsMonitor r104 = new ImageNetworkRequestsMonitor();
        ImageRequestBuilder r105 = ImageRequestBuilder.newBuilderWithSource(r103);
        r104.monitor(r105);
        ImageRequest r106 = r105.build();
        Fresco.getImagePipeline().fetchEncodedImage(r106, null).subscribe(new a(r101, r102), UiThreadImmediateExecutorService.getInstance());
        return;
    }

    public static void o(HSImageView r100, py.k r101, ImageView.ScaleType r110) {
        ImageUtil.loadImage(r100, r101, -1, -1, false, 0, r110, null);
    }

    public static void q(HSImageView r110, py.k r111, boolean r112) {
        ImageLoader.bindImage(r110, r111, null, 300, -1, -1, null, null, false, r112, true);
    }

    public static void r(HSImageView r100, String r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L12;
        ImageNetworkRequestsMonitor r103 = new ImageNetworkRequestsMonitor();
        ImageRequestBuilder r104 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r101));
        r103.monitor(r104);
        ImageRequest r105 = r104.build();
        AbstractDraweeController r106 = Fresco.newDraweeControllerBuilder().setOldController(r100.getController()).setFirstAvailableImageRequests(new ImageRequest[]{r105}).build();
        if (r102 == 0) goto L9;
        r100.getHierarchy().setPlaceholderImage(r102);
    L9:
        r100.setController(r106);
        return;
    }

    public static void v(ImageView r100, py.k r101, int r102) {
        ImageUtil.loadRoundImage(r100, r101, 0, 0, r102, null);
    }

    public static byte[] f(byte[] r100, float r101, boolean r110, boolean r111) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ByteBuffer r102 = ByteBuffer.allocate(r100.length).order(ByteOrder.nativeOrder());
        ByteBuffer r103 = ByteBuffer.wrap(r100).order(ByteOrder.nativeOrder());
        if (r103.get() != 0) goto L8;
        return null;
    L8:
        r102.put((byte) 1);
        int r104 = r103.get();
        int[] r105 = new int[r104];
        int r106 = r103.get();
        int[] r107 = new int[r106];
        int r108 = r103.get();
        int[] r109 = new int[r108];
        r102.put((byte) r104);
        r102.put((byte) r106);
        r102.put((byte) r108);
        r102.putInt(r103.getInt());
        r102.putInt(r103.getInt());
        r102.putInt((int) (r103.getInt() * r101));
        r102.putInt((int) (r103.getInt() * r101));
        r102.putInt((int) (r103.getInt() * r101));
        r102.putInt((int) (r103.getInt() * r101));
        r102.putInt(r103.getInt());
        int r112 = 0;
        r105[0] = r103.getInt();
        int r113 = r103.getInt();
        r105[1] = r113;
        if (r110 == false) goto L15;
        int r114 = (int) (r105[0] * r101);
        int r115 = (int) (r113 * r101);
        if (r115 != r114) goto L14;
        if (r115 == 0) goto L14;
        r115 = r115 + 1;
    L14:
        r102.putInt(r114);
        r102.putInt(r115);
    L16:
        r107[0] = r103.getInt();
        int r116 = r103.getInt();
        r107[1] = r116;
        if (r111 == false) goto L23;
        int r117 = (int) (r107[0] * r101);
        int r118 = (int) (r116 * r101);
        if (r118 != r117) goto L22;
        if (r118 == 0) goto L22;
        r118 = r118 + 1;
    L22:
        r102.putInt(r117);
        r102.putInt(r118);
    L24:
        if (r112 >= r108) goto L27;
        r102.putInt(r103.getInt());
        r112 = r112 + 1;
        goto L24
    L27:
        return r102.array();
    L23:
        r102.putInt((int) (r107[0] * r101));
        r102.putInt((int) (r107[1] * r101));
        goto L24
    L15:
        r102.putInt((int) (r105[0] * r101));
        r102.putInt((int) (r105[1] * r101));
        goto L16
    }

    public static NinePatchDrawable g(Bitmap r110, float r111, boolean r112, boolean r113) {
        Matrix r100 = new Matrix();
        r100.postScale(r111, r111);
        Bitmap r114 = Bitmap.createBitmap(r110, 0, 0, r110.getWidth(), r110.getHeight(), r100, true);
        if (r110.getNinePatchChunk() == null) goto L6;
        byte[] r115 = f(r110.getNinePatchChunk(), r111, r112, r113);
        Rect r116 = i(r115);
        return new NinePatchDrawable(com.bytedance.android.live.core.utils.s1.getResources(), r114, r115, r116, null);
    L6:
        return null;
    }

    public static void p(HSImageView r110, String r111, LiveBlurProcessorV2 r112, boolean r113) {
        py.k r100 = (py.k) vh7.f.c(py.k.class);
        r100.setUrls(Collections.singletonList(r111));
        ImageLoader.bindImage(r110, r100, null, 300, -1, -1, r112, null, false, r113, true);
    }

    @Deprecated(message = "新方案多端统一，不再使用.9图，需要UI给新png图，见ResizableImageLoader")
    public static void t(View r100, py.k r101, boolean r102, ht2.e r103) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.getUrls() != null) goto L6;
        return;
    L6:
        if (r101.getUrls().size() == 0) goto L12;
        Uri r104 = UriProtector.parse((String) ListProtector.get(r101.getUrls(), 0));
        ImageNetworkRequestsMonitor r105 = new ImageNetworkRequestsMonitor();
        ImageRequestBuilder r106 = ImageRequestBuilder.newBuilderWithSource(r104);
        r105.monitor(r106);
        ImageRequest r107 = r106.build();
        Fresco.getImagePipeline().fetchEncodedImage(r107, null).subscribe(new w0(r100, r102, r103), UiThreadImmediateExecutorService.getInstance());
        return;
    }

    public static void w(ImageView r100, py.k r101, int r102, int r103) {
        ImageUtil.loadRoundImage(r100, r101, r102, r103, 0, null);
    }

    public static DataSource<CloseableReference<CloseableImage>> a(py.k r100, int r101, int r102, boolean r103, Postprocessor r104) {
        if (r103 == true) goto L9;
        if (r101 <= 0) goto L6;
        if (r102 > 0) goto L9;
    L6:
        if (r104 != null) goto L9;
        ImageRequest[] r105 = b(r100, -1);
    L13:
        if (r105 != null) goto L15;
    L29:
        return null;
    L15:
        if (r105.length == 0) goto L29;
        ArrayList r106 = new ArrayList();
        int r107 = r105.length;
        int r108 = 0;
    L18:
        if (r108 >= r107) goto L25;
        ImageRequest r109 = r105[r108];
        if (r109 == null) goto L23;
        r106.add(Fresco.getImagePipeline().getDataSourceSupplier(r109, null, ImageRequest.RequestLevel.FULL_FETCH));
    L23:
        r108 = r108 + 1;
        goto L18
    L25:
        if (r106.isEmpty() == false) goto L28;
        return null;
    L28:
        return FirstAvailableDataSourceSupplier.create(r106).get();
    L9:
        if (r103 == false) goto L11;
        Bitmap.Config r110 = Bitmap.Config.RGB_565;
    L12:
        r105 = c(r100, r101, r102, r110, r104);
        goto L13
    L11:
        r110 = null;
        goto L12
    }

    public static ImageRequest[] c(py.k r100, int r101, int r102, Bitmap.Config r103, Postprocessor r104) {
        if (r100 != null) goto L5;
    L29:
        return null;
    L5:
        if (r100.getUrls() == null) goto L29;
        if (r100.getUrls().size() == 0) goto L29;
        ArrayList r105 = new ArrayList();
        ImageNetworkRequestsMonitor r106 = new ImageNetworkRequestsMonitor();
        Iterator<String> r107 = r100.getUrls().iterator();
    L11:
        if (r107.hasNext() == false) goto L25;
        String r108 = r107.next();
        if (StringUtils.isEmpty(r108) == true) goto L11;
        ImageRequestBuilder r109 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r108));
        if (r101 <= 0) goto L19;
        if (r102 <= 0) goto L19;
        r109.setResizeOptions(new ResizeOptions(r101, r102));
    L19:
        if (r103 == null) goto L21;
        r109.setImageDecodeOptions(new ImageDecodeOptionsBuilder().setBitmapConfig(r103).build());
    L21:
        if (r104 == null) goto L23;
        r109.setPostprocessor(r104);
    L23:
        r106.monitor(r109);
        r105.add(r109.build());
        goto L11
    L25:
        if (r105.size() != 0) goto L28;
        return null;
    L28:
        return (ImageRequest[]) r105.toArray(new ImageRequest[r105.size()]);
    }

    public static Observable l(final py.k r100, final int r101, final int r110, final boolean r111, final com.bytedance.android.livesdk.utils.l3 r112) {
        if (r100 == null) goto L4;
    L6:
        Throwable r102 = null;
    L7:
        final Throwable r103 = r102;
        return Observable.create(new t0(r111, r101, r110, r112, r100, r103));
    L4:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L6;
        r102 = new Throwable();
        goto L7
    }

    public static void x(ImageView r100, py.k r101, int r102, int r103, int r110) {
        ImageUtil.loadRoundImage(r100, r101, r102, r103, r110, null);
    }

    public static void y(ImageView r100, py.k r110, int r111, int r112, float r113) {
        ImageUtil.loadRoundImageWithBorder(r100, r110, 0, 0, r111, r112, r113, false, null);
    }
}
