package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.config.iw;
import com.bytedance.android.livesdk.config.nw;
import com.bytedance.android.livesdk.config.uw;
import com.bytedance.android.livesdk.config.yw;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/LiveModuleCrashFixConfig;", "", "()V", "getLiveFixDetailNpe", "", "getLiveFixHostInitializeNpe", "getLiveFixServiceExceptionAnr", "getLiveFixWidgetAutoDisposeNpe", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveModuleCrashFixConfig {
    public static final LiveModuleCrashFixConfig INSTANCE = null;

    private LiveModuleCrashFixConfig() {
    }

    static {
        INSTANCE = new LiveModuleCrashFixConfig();
    }

    @JvmStatic
    public static final boolean getLiveFixDetailNpe() {
        return iw.f120483a.getValue().booleanValue();
    }

    @JvmStatic
    public static final boolean getLiveFixHostInitializeNpe() {
        return nw.f120864a.getValue().booleanValue();
    }

    @JvmStatic
    public static final boolean getLiveFixServiceExceptionAnr() {
        return uw.f121405a.getValue().booleanValue();
    }

    @JvmStatic
    public static final boolean getLiveFixWidgetAutoDisposeNpe() {
        return yw.f121720a.getValue().booleanValue();
    }
}
