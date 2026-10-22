package com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.framework;

import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0006¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/live/core/framework/LiveInteractionFrameworkOptHelper;", "", "()V", "audienceMessageFetchType", "", "enable", "", "fragmentAbilityOpt", "fragmentRemoveStateOpt", "monitorConfig", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/live/core/framework/InteractionMonitorConfig;", "uselessWidgetOpt", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveInteractionFrameworkOptHelper {
    public static final LiveInteractionFrameworkOptHelper INSTANCE = null;

    private LiveInteractionFrameworkOptHelper() {
    }

    static {
        INSTANCE = new LiveInteractionFrameworkOptHelper();
    }

    public final int audienceMessageFetchType() {
        return LiveInfraSettingKeys.LIVE_MESSAGE_WIDGET_AUDIENCE_START_FETCH_TYPE.getValue().intValue();
    }

    public final boolean enable() {
        return LiveInfraSettingKeys.LIVE_INTERACTION_FRAMEWORK_OPT.getValue().booleanValue();
    }

    public final boolean fragmentAbilityOpt() {
        return LiveInfraSettingKeys.LIVE_INTERACTION_FRAMEWORK_FRAGMENT_ABILITY_OPT.getValue().booleanValue();
    }

    public final boolean fragmentRemoveStateOpt() {
        return LiveInfraSettingKeys.LIVE_INTERACTION_FRAMEWORK_FRAGMENT_REMOVE_OPT.getValue().booleanValue();
    }

    public final InteractionMonitorConfig monitorConfig() {
        return LiveInfraSettingKeys.LIVE_INTERACTION_FRAMEWORK_MONITOR_CONFIG.getValue();
    }

    public final boolean uselessWidgetOpt() {
        return LiveInfraSettingKeys.LIVE_INTERACTION_FRAMEWORK_USELESS_WIDGET_OPT_.getValue().booleanValue();
    }
}
