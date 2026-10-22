package com.bytedance.android.gamecp.common.utils;

import android.net.Uri;
import android.os.Looper;
import com.bytedance.android.gamecp.common.setting.config.GamePromoteIconLocation;
import com.bytedance.android.gamecp.host_api.model.GameImageBundler;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import wu.m4;
import wu.n2;

/* JADX INFO: loaded from: classes44.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.gamecp.common.setting.config.r1 f57199a;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.gamecp.common.utils.b$b, reason: collision with other inner class name */
    public static final class C0916b extends BaseDataSubscriber<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function3 f57200a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f57201b;

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onFailureImpl(DataSource<Void> r100) {
            Function3 r101 = this.f57200a;
            if (r101 == null) goto L6;
            Boolean r102 = Boolean.FALSE;
            JSONObject r103 = new JSONObject();
            r103.put("is_in_disk", false);
            r103.put("option", UploadTypeInf.DISK);
            r103.put("url", this.f57201b);
            Unit r104 = Unit.INSTANCE;
            Unit r105 = (Unit) r101.invoke(r102, r103, null);
            return;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onNewResultImpl(DataSource<Void> r100) {
            Function3 r101 = this.f57200a;
            if (r101 == null) goto L6;
            Boolean r102 = Boolean.TRUE;
            JSONObject r103 = new JSONObject();
            r103.put("is_in_disk", true);
            r103.put("option", UploadTypeInf.DISK);
            r103.put("url", this.f57201b);
            Unit r104 = Unit.INSTANCE;
            Unit r105 = (Unit) r101.invoke(r102, r103, null);
            return;
        }

        public C0916b(Function3 r100, String r101) {
            this.f57200a = r100;
            this.f57201b = r101;
        }
    }

    public static final class c extends BaseDataSubscriber<CloseableReference<CloseableImage>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function3 f57202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f57203b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CacheKey f57204c;

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r100) {
            Function3 r101 = this.f57202a;
            Boolean r102 = null;
            if (r101 == null) goto L5;
            Boolean r103 = Boolean.FALSE;
            JSONObject r104 = new JSONObject();
            r104.put("result", false);
            r104.put("option", "memory");
            r104.put("error", "preload_error");
            r104.put("url", this.f57203b);
            Unit r105 = Unit.INSTANCE;
            Unit r106 = (Unit) r101.invoke(r103, r104, null);
        L5:
            StringBuilder r107 = new StringBuilder("onFailureImpl: dataSource=");
            if (r100 == null) goto L8;
            r102 = Boolean.valueOf(r100.isFinished());
        L8:
            r107.append(r102);
            r107.append(",cacheKey=");
            r107.append(this.f57204c);
            yr.c.b("PromoteCardIconPreloadOpt", r107.toString());
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> r110) {
            if (r110 == null) goto L10;
            CloseableReference<CloseableImage> r100 = r110.getResult();
            if (r100 == null) goto L10;
            Function3 r101 = this.f57202a;
            if (r101 == null) goto L9;
            Boolean r102 = Boolean.TRUE;
            JSONObject r103 = new JSONObject();
            r103.put("result", true);
            r103.put("option", "memory");
            r103.put("url", this.f57203b);
            Unit r104 = Unit.INSTANCE;
            Unit r105 = (Unit) r101.invoke(r102, r103, r100);
        L9:
            yr.c.e("PromoteCardIconPreloadOpt", "preload result success: dataSource=" + r110.isFinished() + ",result=" + r100);
            return;
        L10:
            Function3 r106 = this.f57202a;
            CloseableReference<CloseableImage> r107 = null;
            if (r106 == null) goto L13;
            Boolean r108 = Boolean.FALSE;
            JSONObject r109 = new JSONObject();
            r109.put("result", false);
            r109.put("error", "preload_result_empty");
            r109.put("option", "memory");
            r109.put("url", this.f57203b);
            Unit r111 = Unit.INSTANCE;
            Unit r112 = (Unit) r106.invoke(r108, r109, null);
        L13:
            StringBuilder r113 = new StringBuilder("onNewResultImpl: dataSource=");
            if (r110 == null) goto L16;
            Boolean r114 = Boolean.valueOf(r110.isFinished());
        L17:
            r113.append(r114);
            r113.append(",result=");
            if (r110 == null) goto L20;
            r107 = r110.getResult();
        L20:
            r113.append(r107);
            r113.append(",cacheKey=");
            r113.append(this.f57204c);
            yr.c.b("PromoteCardIconPreloadOpt", r113.toString());
            return;
        L16:
            r114 = null;
            goto L17
        }

        public c(Function3 r100, String r101, CacheKey r102) {
            this.f57202a = r100;
            this.f57203b = r101;
            this.f57204c = r102;
        }
    }

    public static final class d<T> implements SingleOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f57205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GameImageBundler f57206b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function3 f57207c;

        public d(b r100, GameImageBundler r101, Function3 r102) {
            this.f57205a = r100;
            this.f57206b = r101;
            this.f57207c = r102;
        }

        @Override // io.reactivex.SingleOnSubscribe
        public final void subscribe(SingleEmitter<Object> r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            this.f57205a.b(this.f57206b, this.f57207c);
        }
    }

    static {
    }

    public b(GamePromoteIconLocation r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        Map<String, com.bytedance.android.gamecp.common.setting.config.r1> r103 = m4.f561352a.getValue().d();     // Catch: Throwable -> L9
        if (r103 == null) goto L6;
        com.bytedance.android.gamecp.common.setting.config.r1 r104 = r103.get(r100.getLocation());     // Catch: Throwable -> L9
    L7:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r105) == true) goto L15;
        r101 = r105;
    L15:
        this.f57199a = (com.bytedance.android.gamecp.common.setting.config.r1) r101;
        return;
    L6:
        r104 = null;
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public static String a(GameImageBundler r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getUrl");
        Integer r101 = n2.f561356a.getValue();
        Logger.i("game-promote", "getUrl --- mode =" + r101);
        if (r101 != null) goto L6;
    L8:
        if (r101 != null) goto L11;
    L13:
        if (r101 == null) goto L19;
        if (r101.intValue() != 2) goto L19;
        return r100.getThumbHeifImageUrl();
    L19:
        return r100.getOriginImageUrl();
    L11:
        if (r101.intValue() != 1) goto L13;
        return r100.getThumbImageUrl();
    L6:
        if (r101.intValue() != 0) goto L8;
        return r100.getOriginImageUrl();
    }

    public final void b(GameImageBundler r100, Function3<? super Boolean, ? super JSONObject, ? super CloseableReference<CloseableImage>, Unit> r101) {
        if (r100 == null) goto L13;
        String r102 = a(r100);
        if (r102.length() != 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == true) goto L13;
        Uri r104 = UriProtector.parse(r102);
        if (r104 == null) goto L13;
    L15:
        if (r104 != null) goto L20;
        if (r101 == null) goto L51;
        Boolean r105 = Boolean.FALSE;
        JSONObject r106 = new JSONObject();
        r106.put("error", "uri_empty");
        Unit r107 = Unit.INSTANCE;
        Unit r108 = r101.invoke(r105, r106, null);
        return;
    L51:
        return;
    L20:
        if (this.f57199a != null) goto L22;
        yr.c.b("PromoteCardIconPreloadOpt", "preloadIconInThread 未找到对应场景的预加载配置}");
        ImageRequest r109 = null;
    L26:
        yr.c.e("PromoteCardIconPreloadOpt", "preloadIconInThread start,imageRequest=" + r109);
        if (r109 != null) goto L32;
        yr.c.b("PromoteCardIconPreloadOpt", "preloadIconInThread preload error,imageRequest=null");
        if (r101 == null) goto L52;
        Boolean r110 = Boolean.FALSE;
        JSONObject r111 = new JSONObject();
        r111.put("error", "image_request_empty");
        Unit r112 = Unit.INSTANCE;
        Unit r113 = r101.invoke(r110, r111, null);
        return;
    L52:
        return;
    L32:
        String r114 = r104.toString();
        if (r114 != null) goto L35;
        r114 = "";
    L35:
        com.bytedance.android.gamecp.common.setting.config.r1 r115 = this.f57199a;
        if (r115 != null) goto L38;
    L49:
        Fresco.getImagePipeline().prefetchToDiskCache(r109, null).subscribe(new C0916b(r101, r114), CallerThreadExecutor.getInstance());
        return;
    L38:
        if (r115.b() != true) goto L49;
        CacheKey r116 = Fresco.getImagePipeline().getCacheKey(r109, null);
        CloseableReference<CloseableImage> r117 = Fresco.getImagePipeline().getCachedImage(r116);
        if (r117 == null) goto L46;
        yr.c.e("PromoteCardIconPreloadOpt", "preload icon isInMemory=" + r117 + " ; cacheKey=" + r116);
        if (r101 == null) goto L53;
        Boolean r118 = Boolean.TRUE;
        JSONObject r119 = new JSONObject();
        r119.put("result", true);
        r119.put("option", "memory");
        r119.put("url", r114);
        r119.put("is_hit_memory_cache", "1");
        Unit r120 = Unit.INSTANCE;
        Unit r121 = r101.invoke(r118, r119, r117);
        return;
    L53:
        return;
    L46:
        DataSource<CloseableReference<CloseableImage>> r122 = Fresco.getImagePipeline().fetchDecodedImage(r109, null);
        if (r122 == null) goto L54;
        r122.subscribe(new c(r101, r114, r116), CallerThreadExecutor.getInstance());
        return;
    L54:
        return;
    L22:
        ImageRequestBuilder r123 = ImageRequestBuilder.newBuilderWithSource(r104).setImageDecodeOptions(ImageDecodeOptions.newBuilder().setBitmapConfig(this.f57199a.a()).build());
        if (this.f57199a.f() == false) goto L25;
        r123.setResizeOptions(ResizeOptions.forDimensions(this.f57199a.e(), this.f57199a.c()));
    L25:
        int r124 = fv.a.f478946a;
        Intrinsics.checkNotNullParameter(r123, "builder");
        r109 = r123.build();
        goto L26
    L8:
        r103 = false;
    L13:
        r104 = null;
        goto L15
    }

    public final void c(GameImageBundler r100, Function3<? super Boolean, ? super JSONObject, ? super CloseableReference<CloseableImage>, Unit> r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        Object r103 = Result.m9449constructorimpl(Boolean.valueOf(m4.f561352a.getValue().a()));     // Catch: Throwable -> L4
    L6:
        Boolean r104 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = r104;
    L10:
        if (((Boolean) r103).booleanValue() == true) goto L14;
        JSONObject r105 = new JSONObject();
        r105.put("error", "switch_close");
        Unit r106 = Unit.INSTANCE;
        Unit r107 = r101.invoke(r104, r105, null);
        return;
    L14:
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L16;
        Single.create(new d(this, r100, r101)).subscribeOn(Schedulers.io()).subscribe();
        return;
    L16:
        b(r100, r101);
        return;
    L4:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }
}
