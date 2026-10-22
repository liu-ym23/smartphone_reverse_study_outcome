package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u000eR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/FirstCompShowConfig;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "config", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/FirstCompShowData;", "getConfig", "()Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/FirstCompShowData;", "config$delegate", "Lkotlin/Lazy;", "avatarUsePreloadData", "", "disableFollowEnter", "isDelayClose", "isPreloadInPlay", "onlyPreloadClick", "preloadClickUseful", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FirstCompShowConfig {
    public static final FirstCompShowConfig INSTANCE = null;
    private static final String TAG = null;
    private static final Lazy config$delegate = null;

    private FirstCompShowConfig() {
    }

    public final FirstCompShowData getConfig() {
        return (FirstCompShowData) config$delegate.getValue();
    }

    static {
        INSTANCE = new FirstCompShowConfig();
        TAG = "FirstCompShow";
        config$delegate = LazyKt.lazy(FirstCompShowConfig$config$2.INSTANCE);
    }

    public final boolean avatarUsePreloadData() {
        return getConfig().getUsePreloadData();
    }

    public final boolean disableFollowEnter() {
        return getConfig().getDisableFollowEnter();
    }

    public final boolean isDelayClose() {
        return getConfig().isDelayClose();
    }

    public final boolean isPreloadInPlay() {
        return getConfig().isPreloadInPlay();
    }

    public final boolean onlyPreloadClick() {
        return getConfig().getOnlyPreloadClick();
    }

    public final boolean preloadClickUseful() {
        return getConfig().getPreloadUserInfoClick();
    }

    public final String getTAG() {
        return TAG;
    }
}
