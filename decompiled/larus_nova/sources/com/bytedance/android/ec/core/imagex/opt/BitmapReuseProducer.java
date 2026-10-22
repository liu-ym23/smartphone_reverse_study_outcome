package com.bytedance.android.ec.core.imagex.opt;

import com.bytedance.common.utility.Logger;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes43.dex */
public final class BitmapReuseProducer implements Producer<CloseableReference<CloseableImage>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f44725a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f44726b = null;

    public static final class a {
        public a() {
        }
    }

    public BitmapReuseProducer() {
    }

    static {
        f44726b = new a();
        f44725a = LazyKt.lazy(BitmapReuseProducer$Companion$bitmapReuseProducer$2.INSTANCE);
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void produceResults(Consumer<CloseableReference<CloseableImage>> r100, ProducerContext r101) {
        CloseableReference<CloseableImage> r102 = null;
        if (r101 == null) goto L11;
        r102 = i.b(((j) r101).f44864a);     // Catch: Throwable -> L8
        if (r100 == null) goto L7;
        r100.onNewResult(r102, 1);     // Catch: Throwable -> L8
    L7:
        Logger.d("BitmapReuseProducer", "onReuse success");     // Catch: Throwable -> L8
    L13:
        CloseableReference.closeSafely(r102);
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.core.imagex.opt.BitmapReuseSettableProducerContext");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        com.bytedance.crash.d.c(th);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableReference.closeSafely(null);
        throw th;
    }
}
