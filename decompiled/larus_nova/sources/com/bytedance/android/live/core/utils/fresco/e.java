package com.bytedance.android.live.core.utils.fresco;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.q6;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.DefaultSerialExecutorService;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.frame.FrameScheduler;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import com.facebook.imagepipeline.cache.BitmapCountingMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheTrimStrategy;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.core.DefaultExecutorSupplier;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.memory.BitmapPoolType;
import com.facebook.imagepipeline.memory.PoolConfig;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.optimize.statistics.FrescoTraceListener;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes45.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static CountingMemoryCache<CacheKey, CloseableImage> f66139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Method f66140b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Method f66141c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Field f66142d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static f f66143e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static AnimatedDrawableUtil f66144f;

    public class a implements Supplier<Integer> {
        public a() {
        }

        @Override // com.facebook.common.internal.Supplier
        public final Integer get() {
            return 1;
        }
    }

    public class b implements Supplier<Integer> {
        public b() {
        }

        @Override // com.facebook.common.internal.Supplier
        public final Integer get() {
            return 0;
        }
    }

    static {
        f66140b = ImageDecodeOptionsBuilder.class.getDeclaredMethod("setPreDecodeFrameCount", new Class[]{Integer.TYPE});     // Catch: Throwable -> L5
        ALogger.i(FrescoTraceListener.ALOGTAG, "Reflect method `setPreDecodeFrameCount` success.");     // Catch: Throwable -> L5
    L21:
        f66141c = AnimatedDrawable2.class.getDeclaredMethod("setPrivateFrameScheduler", new Class[]{FrameScheduler.class});     // Catch: Throwable -> L10
        ALogger.i(FrescoTraceListener.ALOGTAG, "Reflect method `setPrivateFrameScheduler` success.");     // Catch: Throwable -> L10
    L13:
        if (f66141c != null) goto L25;
        Field r100 = AnimatedDrawable2.class.getDeclaredField("mFrameScheduler");     // Catch: Throwable -> L16
        f66142d = r100;     // Catch: Throwable -> L16
        r100.setAccessible(true);     // Catch: Throwable -> L16
        ALogger.i(FrescoTraceListener.ALOGTAG, "Reflect field `mFrameScheduler` success.");     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        f66142d = null;
        ALogger.e(FrescoTraceListener.ALOGTAG, "Reflect field `mFrameScheduler` failed." + Log.getStackTraceString(th));
        return;
    L25:
        return;
    L10:
        th = move-exception;
        f66141c = null;
        ALogger.e(FrescoTraceListener.ALOGTAG, "Reflect method `setPrivateFrameScheduler` failed." + Log.getStackTraceString(th));
    L5:
        th = move-exception;
        ALogger.e(FrescoTraceListener.ALOGTAG, "Reflect method `setPreDecodeFrameCount` failed." + Log.getStackTraceString(th));
        goto L21
    }

    public static void b(AnimatedDrawable2 r100, FrameScheduler r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        Method r102 = f66141c;
        if (r102 == null) goto L7;
    L9:
        boolean r103 = false;
        if (r102 != null) goto L26;
    L16:
        if (r103 == true) goto L28;
        Field r104 = f66142d;
        if (r104 == null) goto L29;
        r104.set(r100, r101);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        ALogger.e(FrescoTraceListener.ALOGTAG, "set sFrameSchedulerField failed." + Log.getStackTraceString(th));
        return;
    L29:
        return;
    L28:
        return;
    L26:
        r102.invoke(r100, new Object[]{r101});     // Catch: Throwable -> L14
        r103 = true;
    L14:
        th = move-exception;
        ALogger.e(FrescoTraceListener.ALOGTAG, "invoke setFrameScheduler failed." + Log.getStackTraceString(th));
        goto L16
    L7:
        if (f66142d != null) goto L9;
    }

    public static void a(Context r110, PipelineDraweeController r111, String r112, boolean r113) {
        if (r110 == null) goto L19;
        if (r111 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r112) == true) goto L21;
        a r100 = new a();
        b r101 = new b();
        DefaultSerialExecutorService r102 = new DefaultSerialExecutorService(new DefaultExecutorSupplier(new PoolFactory(PoolConfig.newBuilder().setBitmapPoolType(BitmapPoolType.DUMMY).build()).getFlexByteArrayPoolMaxNumThreads()).forDecode());
        if (f66139a != null) goto L15;
        if (q6.f65394a.getValue().booleanValue() == false) goto L12;
        Supplier r103 = new com.bytedance.android.live.core.utils.fresco.a((ActivityManager) r110.getSystemService("activity"));
    L13:
        f66139a = BitmapCountingMemoryCacheFactory.get(r103, NoOpMemoryTrimmableRegistry.getInstance(), new BitmapMemoryCacheTrimStrategy());
        goto L15
    L12:
        r103 = new DefaultBitmapMemoryCacheParamsSupplier((ActivityManager) r110.getSystemService("activity"));
    L15:
        if (f66143e != null) goto L17;
        f66143e = new f();
    L17:
        r111.setCustomDrawableFactories(ImmutableList.of(new DrawableFactory[]{new n(f66143e, UiThreadImmediateExecutorService.getInstance(), r102, RealtimeSinceBootClock.get(), ImagePipelineFactory.getInstance().getPlatformBitmapFactory(), f66139a, r100, r101, r112, r113)}));
        return;
    L21:
        return;
    }
}
