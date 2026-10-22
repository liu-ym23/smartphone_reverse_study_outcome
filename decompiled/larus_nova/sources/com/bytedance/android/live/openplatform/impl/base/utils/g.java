package com.bytedance.android.live.openplatform.impl.base.utils;

import android.os.SystemClock;
import com.bytedance.android.live.openplatform.api.utils.image.ImageTag;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.DiskCacheReadProducer;
import com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer;
import com.facebook.imagepipeline.producers.LocalResourceFetchProducer;
import com.facebook.imagepipeline.producers.NetworkFetchProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;

/* JADX INFO: loaded from: classes46.dex */
public final class g extends BaseRequestListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f84050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f84051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageLoader.ImageFromSource f84052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ImageTag f84053d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f84054e;

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public final void onRequestCancellation(String r100) {
        int r101 = qo0.a.f534145a;
        qo0.a.c("OpenPlatformImageLoader", this.f84053d.name() + "-onRequestCancellation");
        ImageLoader r102 = ImageLoader.f84018a;
        ImageLoader.f(this.f84050a, String.valueOf(this.f84053d.getTagInt()), this.f84054e, this.f84051b, -2, "", this.f84052c);
    }

    public g(ImageTag r100, String r101) {
        this.f84053d = r100;
        this.f84054e = r101;
        this.f84050a = -1;
        this.f84051b = "";
        this.f84052c = ImageLoader.ImageFromSource.UNKNOWN;
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public final void onRequestSuccess(ImageRequest r100, String r110, boolean r111) {
        int r101 = qo0.a.f534145a;
        qo0.a.c("OpenPlatformImageLoader", this.f84053d.name() + "-onRequestSuccess, isPrefetch: " + r111);
        ImageLoader r102 = ImageLoader.f84018a;
        ImageLoader.f(this.f84050a, String.valueOf(this.f84053d.getTagInt()), this.f84054e, this.f84051b, 1, "", this.f84052c);
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public final void onUltimateProducerReached(String r100, String r101, boolean r102) {
        int r103 = qo0.a.f534145a;
        qo0.a.c("OpenPlatformImageLoader", this.f84053d.name() + "-onUltimateProducerReached: " + String.valueOf(r101) + ", success: " + r102);
        if (r101 != null) goto L6;
    L23:
        ImageLoader.ImageFromSource r104 = ImageLoader.ImageFromSource.UNKNOWN;
    L24:
        this.f84052c = r104;
        return;
    L6:
        switch(r101.hashCode()) {
            case -1683996557: goto L21;
            case -1307634203: goto L18;
            case -1224383234: goto L15;
            case 656304759: goto L12;
            case 957714404: goto L9;
            default: goto L23;
        };
    L9:
        if (r101.equals(BitmapMemoryCacheProducer.PRODUCER_NAME) == false) goto L23;
    L19:
        r104 = ImageLoader.ImageFromSource.MEMORY_CACHE;
        goto L24
    L12:
        if (r101.equals(DiskCacheReadProducer.PRODUCER_NAME) == false) goto L23;
        r104 = ImageLoader.ImageFromSource.DISK_CACHE;
        goto L24
    L15:
        if (r101.equals(NetworkFetchProducer.PRODUCER_NAME) == false) goto L23;
        r104 = ImageLoader.ImageFromSource.NETWORK;
        goto L24
    L18:
        if (r101.equals(EncodedMemoryCacheProducer.PRODUCER_NAME) == false) goto L23;
    L21:
        if (r101.equals(LocalResourceFetchProducer.PRODUCER_NAME) == false) goto L23;
        r104 = ImageLoader.ImageFromSource.LOCAL;
        goto L24
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public final void onRequestFailure(ImageRequest r100, String r110, Throwable r111, boolean r112) {
        int r101 = qo0.a.f534145a;
        qo0.a.c("OpenPlatformImageLoader", this.f84053d.name() + "-onRequestFailure, isPrefetch: " + r112);
        ImageLoader r102 = ImageLoader.f84018a;
        ImageLoader.f(this.f84050a, String.valueOf(this.f84053d.getTagInt()), this.f84054e, this.f84051b, -1, String.valueOf(r111), this.f84052c);
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public final void onRequestStart(ImageRequest r100, Object r101, String r102, boolean r103) {
        int r104 = qo0.a.f534145a;
        qo0.a.c("OpenPlatformImageLoader", this.f84053d.name() + "-onRequestStart, isPrefetch: " + r103);
        this.f84050a = SystemClock.uptimeMillis();
        ImageLoader r105 = ImageLoader.f84018a;
        ImageTag r106 = this.f84053d;
        if (r106 != ImageTag.SNOW_FLAKE) goto L5;
    L16:
        HashMap<String, zo0.f> r107 = zo0.g.f573094a;
        if (zo0.h.b(PerformanceScene.SNOW_FLAKE).c("is_from_enter") == false) goto L19;
    L18:
        String r108 = "enter";
    L20:
        this.f84051b = r108;
        this.f84052c = ImageLoader.ImageFromSource.UNKNOWN;
        return;
    L19:
        r108 = "msg";
        goto L20
    L5:
        if (r106 == ImageTag.SPREAD_FLOWERS) goto L16;
        if (r106 != ImageTag.SMALL_CARD_OUT) goto L10;
    L13:
        HashMap<String, zo0.f> r109 = zo0.g.f573094a;
        if (zo0.h.b(PerformanceScene.EXPLAIN_CARD).c("is_from_enter") == false) goto L19;
    L10:
        if (r106 == ImageTag.EXPLAIN_CARD_COVER) goto L13;
        if (r106 != ImageTag.SMALL_CARD_OUT_V2) goto L19;
        goto L13
    }
}
