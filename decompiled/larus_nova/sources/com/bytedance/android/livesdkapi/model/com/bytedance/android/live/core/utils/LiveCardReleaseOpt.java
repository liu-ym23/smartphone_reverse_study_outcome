package com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.utils;

import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004R\u0018\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0018\u0010\u0007\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/live/core/utils/LiveCardReleaseOpt;", "", "()V", "dontRelease", "", "kotlin.jvm.PlatformType", "Ljava/lang/Boolean;", "weakRefEnable", "dontReleaseOnDestroy", "useWeakRef", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCardReleaseOpt {
    public static final LiveCardReleaseOpt INSTANCE = null;
    private static final Boolean dontRelease = null;
    private static final Boolean weakRefEnable = null;

    private LiveCardReleaseOpt() {
    }

    static {
        INSTANCE = new LiveCardReleaseOpt();
        weakRefEnable = LiveInfraSettingKeys.ANNIE_DIALOG_WEAK_REFERENCE_ENABLE.getValue();
        dontRelease = LiveInfraSettingKeys.LIVE_DONT_RELEASE_CARD_ON_DESTROY.getValue();
    }

    public final boolean dontReleaseOnDestroy() {
        return dontRelease.booleanValue();
    }

    public final boolean useWeakRef() {
        return weakRefEnable.booleanValue();
    }
}
