package com.bytedance.android.ec.core.imagex.common;

import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class ProxyRequestListener extends BaseRequestListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f44623c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f44624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w<RequestListener> f44625b;

    public static final class a {
        public static x a(RequestListener r100, BaseRequestListener r101) {
            x r102 = new x();
            if ((r100 instanceof ProxyRequestListener) == false) goto L8;
            Set<RequestListener> r103 = ((ProxyRequestListener) r100).f44625b.f44663a;
            w<RequestListener> r104 = r102.f44625b;
            if (r103 == null) goto L7;
            r104.f44663a.addAll(r103);
        L12:
            r102.f44625b.f44663a.add(r101);
            return r102;
        L7:
            r104.getClass();
            goto L12
        L8:
            w<RequestListener> r105 = r102.f44625b;
            if (r100 == null) goto L11;
            r105.f44663a.add(r100);
            goto L12
        L11:
            r105.getClass();
            goto L12
        }
    }

    static {
    }

    public final void b(Function1<? super RequestListener, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        this.f44625b.a(r100);
    }

    public ProxyRequestListener() {
        this.f44625b = new w(null);
        this.f44624a = new LinkedHashMap();
    }

    public final Object a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return ((LinkedHashMap) this.f44624a).get(r100);
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public final void onRequestCancellation(final String r100) {
        b(new C98351(r100));
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public final boolean requiresExtraMap(String r100) {
        RequestListener r101 = (RequestListener) CollectionsKt.firstOrNull(this.f44625b.f44663a);
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.requiresExtraMap(r100) != true) goto L7;
        return true;
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public final void onProducerStart(final String r100, final String r101) {
        b(new C98341(r100, r101));
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public final void onProducerEvent(final String r100, final String r101, final String r102) {
        b(new AnonymousClass1(r100, r101, r102));
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public final void onProducerFinishWithCancellation(final String r100, final String r101, final Map<String, String> r102) {
        b(new C98311(r100, r101, r102));
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public final void onProducerFinishWithSuccess(final String r100, final String r101, final Map<String, String> r102) {
        b(new C98331(r100, r101, r102));
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener
    public final void onRequestIntermediateResult(final ImageRequest r100, final String r101, final boolean r102) {
        b(new ProxyRequestListener$onRequestIntermediateResult$$inlined$withEachType$1(r100, r101, r102));
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public final void onRequestSuccess(final ImageRequest r100, final String r101, final boolean r102) {
        b(new C98381(r100, r101, r102));
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public final void onUltimateProducerReached(final String r100, final String r101, final boolean r102) {
        b(new C98391(r100, r101, r102));
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public final void onProducerFinishWithFailure(final String r100, final String r101, final Throwable r102, final Map<String, String> r103) {
        b(new C98321(r100, r101, r102, r103));
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public final void onRequestFailure(final ImageRequest r100, final String r101, final Throwable r102, final boolean r103) {
        b(new C98361(r100, r101, r102, r103));
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public final void onRequestStart(final ImageRequest r100, final Object r101, final String r102, final boolean r103) {
        b(new C98371(r100, r101, r102, r103));
    }
}
