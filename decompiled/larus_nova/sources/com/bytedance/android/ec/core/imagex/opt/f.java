package com.bytedance.android.ec.core.imagex.opt;

import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public final class f implements RequestListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RequestListener f44851a;

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public final void onRequestFailure(ImageRequest r100, String r101, Throwable r102, boolean r103) {
    }

    public f(RequestListener r100) {
        this.f44851a = r100;
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public final void onRequestCancellation(String r100) {
        this.f44851a.onRequestCancellation(r100);
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public final boolean requiresExtraMap(String r100) {
        return this.f44851a.requiresExtraMap(r100);
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public final void onProducerStart(String r100, String r101) {
        this.f44851a.onProducerStart(r100, r101);
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public final void onProducerEvent(String r100, String r101, String r102) {
        this.f44851a.onProducerEvent(r100, r101, r102);
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public final void onProducerFinishWithCancellation(String r100, String r101, Map<String, String> r102) {
        this.f44851a.onProducerFinishWithCancellation(r100, r101, r102);
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public final void onProducerFinishWithSuccess(String r100, String r101, Map<String, String> r102) {
        this.f44851a.onProducerFinishWithSuccess(r100, r101, r102);
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public final void onRequestSuccess(ImageRequest r100, String r101, boolean r102) {
        this.f44851a.onRequestSuccess(r100, r101, r102);
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public final void onUltimateProducerReached(String r100, String r101, boolean r102) {
        this.f44851a.onUltimateProducerReached(r100, r101, r102);
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public final void onProducerFinishWithFailure(String r100, String r101, Throwable r102, Map<String, String> r103) {
        this.f44851a.onProducerFinishWithFailure(r100, r101, r102, r103);
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public final void onRequestStart(ImageRequest r100, Object r101, String r102, boolean r103) {
        this.f44851a.onRequestStart(r100, r101, r102, r103);
    }
}
