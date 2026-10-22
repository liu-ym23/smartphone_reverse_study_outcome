package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.config.bc;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007R\u0018\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/LiveOpenFeatureChooseConfig;", "", "()V", "value", "", "kotlin.jvm.PlatformType", "Ljava/lang/Integer;", "useV3", "", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveOpenFeatureChooseConfig {
    public static final LiveOpenFeatureChooseConfig INSTANCE = null;
    private static final Integer value = null;

    private LiveOpenFeatureChooseConfig() {
    }

    static {
        INSTANCE = new LiveOpenFeatureChooseConfig();
        value = bc.f119855a.getValue();
    }

    @JvmStatic
    public static final boolean useV3() {
        Integer r100 = value;
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 2) goto L8;
        return true;
    }
}
