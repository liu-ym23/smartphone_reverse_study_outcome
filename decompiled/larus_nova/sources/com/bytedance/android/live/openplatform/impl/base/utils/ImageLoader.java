package com.bytedance.android.live.openplatform.impl.base.utils;

import android.graphics.drawable.Animatable;
import android.os.SystemClock;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.openplatform.api.utils.image.ImageTag;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.de0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.datasource.BaseBooleanSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegate;
import com.facebook.fresco.animation.bitmap.BitmapAnimationBackend;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.obric.miniapp.alarm.AccountType;
import com.optimize.statistics.FrescoMonitorConst;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class ImageLoader implements mo0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ImageLoader f84018a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/utils/ImageLoader$ImageFromSource;", "", "UNKNOWN", "NETWORK", "MEMORY_CACHE", "DISK_CACHE", AccountType.LOCAL, "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ImageFromSource extends Enum<ImageFromSource> {
        public static final ImageFromSource DISK_CACHE = null;
        public static final ImageFromSource LOCAL = null;
        public static final ImageFromSource MEMORY_CACHE = null;
        public static final ImageFromSource NETWORK = null;
        public static final ImageFromSource UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ImageFromSource[] f84019a = null;

        static {
            ImageFromSource r100 = new ImageFromSource("UNKNOWN", 0);
            UNKNOWN = r100;
            ImageFromSource r101 = new ImageFromSource("NETWORK", 1);
            NETWORK = r101;
            ImageFromSource r102 = new ImageFromSource("MEMORY_CACHE", 2);
            MEMORY_CACHE = r102;
            ImageFromSource r103 = new ImageFromSource("DISK_CACHE", 3);
            DISK_CACHE = r103;
            ImageFromSource r104 = new ImageFromSource(AccountType.LOCAL, 4);
            LOCAL = r104;
            f84019a = new ImageFromSource[]{r100, r101, r102, r103, r104};
        }

        public static ImageFromSource valueOf(String r100) {
            return (ImageFromSource) r27.a.a(ImageFromSource.class, r100);
        }

        public static ImageFromSource[] values() {
            return (ImageFromSource[]) f84019a.clone();
        }

        public ImageFromSource(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a implements ControllerListener<ImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SimpleDraweeView f84020a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BaseControllerListener<ImageInfo> f84021b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f84022c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final mo0.b f84023d;

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onIntermediateImageFailed(String r100, Throwable r101) {
            this.f84021b.onIntermediateImageFailed(r100, r101);
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onRelease(String r100) {
            this.f84021b.onRelease(r100);
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onSubmit(String r100, Object r101) {
            this.f84021b.onSubmit(r100, r101);
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onFailure(String r100, Throwable r101) {
            if (this.f84023d.f514579c == false) goto L9;
            DraweeController r102 = this.f84020a.getController();
            if (r102 == null) goto L8;
            ((AbstractDraweeController) r102).removeControllerListener(this);
            goto L9
        L8:
            throw new NullPointerException("null cannot be cast to non-null type com.facebook.drawee.controller.AbstractDraweeController<*, com.facebook.imagepipeline.image.ImageInfo>");
        L9:
            this.f84021b.onFailure(r100, r101);
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onIntermediateImageSet(String r100, ImageInfo r101) {
            BaseControllerListener<ImageInfo> r102 = this.f84021b;
            r102.onIntermediateImageSet(r100, r101);
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, ImageInfo r101, Animatable r102) {
            ImageInfo r103 = r101;
            if (this.f84023d.f514579c == false) goto L9;
            DraweeController r104 = this.f84020a.getController();
            if (r104 == null) goto L8;
            ((AbstractDraweeController) r104).removeControllerListener(this);
            goto L9
        L8:
            throw new NullPointerException("null cannot be cast to non-null type com.facebook.drawee.controller.AbstractDraweeController<*, com.facebook.imagepipeline.image.ImageInfo>");
        L9:
            mo0.b r105 = this.f84023d;
            ImageTag r106 = r105.f514577a;
            if (r105.f514580d == false) goto L27;
            String r107 = this.f84022c;
            if ((r102 instanceof AnimatedDrawable2) == false) goto L27;
            AnimationBackend r108 = ((AnimatedDrawable2) r102).getAnimationBackend();
            AnimationBackend r109 = null;
            if ((r108 instanceof AnimationBackendDelegate) == true) goto L16;
            r108 = null;
        L16:
            AnimationBackendDelegate r110 = (AnimationBackendDelegate) r108;
            if (r110 == null) goto L19;
            AnimationBackend r111 = r110.getAnimationBackend();
        L21:
            if ((r111 instanceof BitmapAnimationBackend) == false) goto L24;
            r109 = r111;
        L24:
            BitmapAnimationBackend r112 = (BitmapAnimationBackend) r109;
            if (r112 == null) goto L27;
            r112.setFrameListener(new f(r106, r107));
            goto L27
        L19:
            r111 = null;
        L27:
            this.f84021b.onFinalImageSet(r100, r103, r102);
        }

        public a(SimpleDraweeView r100, BaseControllerListener<ImageInfo> r101, String r102, mo0.b r103) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "listener");
            Intrinsics.checkNotNullParameter(r102, "url");
            Intrinsics.checkNotNullParameter(r103, "config");
            this.f84020a = r100;
            this.f84021b = r101;
            this.f84022c = r102;
            this.f84023d = r103;
        }
    }

    public static final class b extends BaseBooleanSubscriber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageRequest f84024a;

        public b(ImageRequest r100) {
            this.f84024a = r100;
        }

        @Override // com.facebook.datasource.BaseBooleanSubscriber
        public final void onFailureImpl(DataSource<Boolean> r100) {
            Fresco.getImagePipeline().prefetchToDiskCache(this.f84024a, s1.getContext());
        }

        @Override // com.facebook.datasource.BaseBooleanSubscriber
        public final void onNewResultImpl(boolean r100) {
            if (r100 == true) goto L5;
            Fresco.getImagePipeline().prefetchToDiskCache(this.f84024a, s1.getContext());
            return;
        }
    }

    public static final class c implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f84025a = null;

        static {
            f84025a = new c();
        }

        public c() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable r100) {
            if (r100 == null) goto L5;
            r100.run();
            return;
        }
    }

    public ImageLoader() {
    }

    static {
        f84018a = new ImageLoader();
    }

    public static void d(String r100) {
        if (de0.f120026a.getValue().k() == 0) goto L16;
        if (r100 != null) goto L6;
    L9:
        boolean r101 = true;
    L10:
        if (r101 == true) goto L18;
        ImageRequest r102 = ImageRequest.fromUri(r100);
        if (Fresco.getImagePipeline().isInBitmapMemoryCache(r102) == true) goto L17;
        Fresco.getImagePipeline().prefetchToBitmapCache(r102, s1.getContext());
        return;
    L17:
        return;
    L18:
        return;
    L6:
        if (r100.length() == 0) goto L9;
        r101 = false;
        goto L10
    }

    public static void e(String r100) {
        if (de0.f120026a.getValue().k() != 0) goto L5;
        return;
    L5:
        if (r100.length() != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L13;
        ImageRequest r102 = ImageRequest.fromUri(r100);
        Fresco.getImagePipeline().isInDiskCache(r102).subscribe(new b(r102), c.f84025a);
        return;
    L13:
        return;
    L7:
        r101 = false;
        goto L8
    }

    public static void c(SimpleDraweeView r100, ImageRequestBuilder r101, mo0.b r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        ImageTag r103 = r102.f514577a;
        if (r103 != null) goto L7;
        r103 = ImageTag.UNKNOWN;
    L7:
        r101.setRequestListener(new g(r103, r101.getSourceUri().toString()));
        PipelineDraweeControllerBuilder r104 = Fresco.newDraweeControllerBuilder().setOldController(r100.getController()).setImageRequest(r101.build());
        BaseControllerListener<ImageInfo> r105 = r102.f514578b;
        if (r105 == null) goto L10;
        r104.setControllerListener(new a(r100, r105, r101.getSourceUri().toString(), r102));
    L10:
        r100.setController(r104.build());
    }

    @Override // mo0.a
    public final void a(HSImageView r100, int r101, mo0.b r102) {
        c(r100, ImageRequestBuilder.newBuilderWithResourceId(r101), r102);
    }

    @Override // mo0.a
    public final void b(SimpleDraweeView r100, String r101, mo0.b r102) {
        if (r101 != null) goto L4;
    L7:
        boolean r103 = true;
    L8:
        if (r103 == false) goto L10;
        return;
    L10:
        c(r100, ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r101)), r102);
        return;
    L4:
        if (r101.length() == 0) goto L7;
        r103 = false;
        goto L8
    }

    public static void f(long r100, String r101, String r110, String r111, int r112, String r113, ImageFromSource r114) {
        long r102 = 0;
        RoomContext r103 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r103 == null) goto L9;
        com.bytedance.live.datacontext.i<Boolean> r104 = r103.isAnchor();
        if (r104 == null) goto L9;
        Boolean r105 = r104.getValue();
        if (r105 == null) goto L9;
        boolean r106 = r105.booleanValue();
    L10:
        if (r106 == false) goto L13;
        return;
    L13:
        if (r100 == (-1)) goto L15;
        r102 = SystemClock.uptimeMillis() - r100;
    L15:
        com.bytedance.android.livesdk.log.u.l().e("mp_live_audience_image_monitor", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(BdpAppEventConstant.PARAMS_FOR_SPECIAL, BdpAppEventConstant.MICRO_APP), TuplesKt.to("image_id", r101), TuplesKt.to("image_url", r110), TuplesKt.to("scene", r111), TuplesKt.to(FrescoMonitorConst.LOAD_STATUS, String.valueOf(r112)), TuplesKt.to("load_status_desc", String.valueOf(r113)), TuplesKt.to("from_source", String.valueOf(r114.ordinal())), TuplesKt.to("duration", String.valueOf(r102))}), new Object[]{Room.class});
        return;
    L9:
        r106 = false;
        goto L10
    }
}
