package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.utils;

import androidx.camera.video.AudioStats;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.TimeConsumingFuncOpt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.random.Random;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/utils/TimeConsumingFuncUtils;", "", "()V", "optConfig", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/TimeConsumingFuncOpt;", "kotlin.jvm.PlatformType", "getOptConfig", "()Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/TimeConsumingFuncOpt;", "optConfig$delegate", "Lkotlin/Lazy;", "asyncToolbarAnim", "", "enableReport", "enableSample", "shouldSample", "sampleRate", "", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TimeConsumingFuncUtils {
    public static final TimeConsumingFuncUtils INSTANCE = null;
    private static final Lazy optConfig$delegate = null;

    private TimeConsumingFuncUtils() {
    }

    public final TimeConsumingFuncOpt getOptConfig() {
        return (TimeConsumingFuncOpt) optConfig$delegate.getValue();
    }

    static {
        INSTANCE = new TimeConsumingFuncUtils();
        optConfig$delegate = LazyKt.lazy(TimeConsumingFuncUtils$optConfig$2.INSTANCE);
    }

    private final boolean enableSample() {
        return getOptConfig().getEnableSample();
    }

    public final boolean asyncToolbarAnim() {
        return getOptConfig().getAsyncToolbarAnimLog();
    }

    public final boolean enableReport() {
        if (enableSample() == true) goto L5;
        return true;
    L5:
        return shouldSample(getOptConfig().getSampleRate());
    }

    private final boolean shouldSample(double r100) {
        if (r100 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L15;
        if (Random.Default.nextDouble() < r100) goto L16;
        return false;
    L16:
        return true;
    L15:
        throw new IllegalArgumentException("抽样比例必须在 0.0 到 1.0 之间".toString());
    L5:
        if (r100 > 1.0d) goto L7;
        r101 = true;
        goto L8
    }
}
