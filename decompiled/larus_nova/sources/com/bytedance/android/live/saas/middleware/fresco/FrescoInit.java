package com.bytedance.android.live.saas.middleware.fresco;

import android.app.Application;
import com.bytedance.fresco.heif.HeifDecoder;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.ImageDecoderConfig;
import com.facebook.imagepipeline.memory.PoolConfig;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.net.FrescoTTNetFetcher;
import com.optimize.statistics.FrescoMonitor;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/fresco/FrescoInit;", "", "()V", "initFresco", "", "applicationContext", "Landroid/app/Application;", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class FrescoInit {
    public static final FrescoInit INSTANCE = null;

    private FrescoInit() {
    }

    static {
        INSTANCE = new FrescoInit();
    }

    @JvmStatic
    public static final void initFresco(final Application r100) {
        Intrinsics.checkNotNullParameter(r100, "applicationContext");
        PoolFactory r101 = new PoolFactory(PoolConfig.newBuilder().build());
        HashSet r102 = new HashSet();
        ImageDecoderConfig r103 = ImageDecoderConfig.newBuilder().addDecodingCapability(HeifDecoder.HEIF_FORMAT, new HeifDecoder.HeifFormatChecker(), new HeifDecoder.HeifFormatDecoder(r101.getPooledByteBufferFactory())).build();
        ImagePipelineConfig r104 = ImagePipelineConfig.newBuilder(r100).setImageDecoderConfig(r103).setRequestListeners(r102).setNetworkFetcher(new FrescoTTNetFetcher()).setBitmapMemoryCacheParamsSupplier(new FrescoInit$initFresco$config$1(r100)).setDownsampleEnabled(true).setPoolFactory(r101).build();
        DefaultConfig.assignFrescoException(r104);
        Fresco.initialize(r100, r104);
        FrescoMonitor.setImageTraceListener(new AnonymousClass1());
    }
}
