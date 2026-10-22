package com.bytedance.android.livesdk.gift.util;

import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheGetProducer;
import com.facebook.imagepipeline.producers.NetworkFetchProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f extends BaseRequestListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f132339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f132340b;

    public static final class a {
    }

    static {
    }

    public f(String r100) {
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public final void onUltimateProducerReached(String r100, String r101, boolean r102) {
        if (this.f132340b == false) goto L8;
        if (Intrinsics.areEqual(r101, NetworkFetchProducer.PRODUCER_NAME) == false) goto L8;
        Objects.toString(this.f132339a);
        System.currentTimeMillis();
    L8:
        if (this.f132340b == false) goto L10;
        return;
    L10:
        if ((!Intrinsics.areEqual(r101, BitmapMemoryCacheGetProducer.PRODUCER_NAME)) == false) goto L14;
        Objects.toString(this.f132339a);
        System.currentTimeMillis();
        return;
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public final void onRequestStart(ImageRequest r100, Object r101, String r102, boolean r103) {
        this.f132339a = r101;
        this.f132340b = r103;
        System.currentTimeMillis();
    }
}
