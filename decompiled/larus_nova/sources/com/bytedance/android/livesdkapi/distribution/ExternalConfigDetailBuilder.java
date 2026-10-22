package com.bytedance.android.livesdkapi.distribution;

import com.bytedance.android.livesdkapi.distribution.config.GestureConfig;
import com.bytedance.android.livesdkapi.distribution.config.GuideConfig;
import com.bytedance.android.livesdkapi.distribution.config.OrientationChangeConfig;
import com.bytedance.android.livesdkapi.distribution.externalinjectcomponent.IExternalInjectComponentProvider;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0018J\u0014\u0010\u0019\u001a\u00020\u00002\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bJ\u001c\u0010\u001d\u001a\u00020\u00002\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020 \u0018\u00010\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdkapi/distribution/ExternalConfigDetailBuilder;", "", "()V", "externalConfig", "Lcom/bytedance/android/livesdkapi/distribution/ExternalConfigDetail;", "build", "configFsOpt", "enable", "", "configGesture", "gestureConfig", "Lcom/bytedance/android/livesdkapi/distribution/config/GestureConfig;", "configGuide", "guideConfig", "Lcom/bytedance/android/livesdkapi/distribution/config/GuideConfig;", "configInteractionView", "interactionViewConfig", "Lcom/bytedance/android/livesdkapi/distribution/InteractionViewConfig;", "configOrientationChange", "orientationChangeConfig", "Lcom/bytedance/android/livesdkapi/distribution/config/OrientationChangeConfig;", "configRepeatLeaveCheck", "configRoomExit", "roomExitConfig", "Lcom/bytedance/android/livesdkapi/distribution/RoomExitConfig;", "configShowInClearComponentTagList", "list", "", "", "injectNormalComponent", "map", "", "Lcom/bytedance/android/livesdkapi/distribution/externalinjectcomponent/IExternalInjectComponentProvider;", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExternalConfigDetailBuilder {
    private final ExternalConfigDetail externalConfig;

    public ExternalConfigDetailBuilder() {
        this.externalConfig = new ExternalConfigDetail();
    }

    public final ExternalConfigDetail build() {
        return this.externalConfig;
    }

    public final ExternalConfigDetailBuilder configFsOpt(boolean r100) {
        this.externalConfig.setEnableFsOpt(r100);
        return this;
    }

    public final ExternalConfigDetailBuilder configGesture(GestureConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "gestureConfig");
        this.externalConfig.getConfigMap().put(EXTERNAL_CONFIG_TYPE.Gesture, r100);
        return this;
    }

    public final ExternalConfigDetailBuilder configGuide(GuideConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "guideConfig");
        this.externalConfig.getConfigMap().put(EXTERNAL_CONFIG_TYPE.Guide, r100);
        return this;
    }

    public final ExternalConfigDetailBuilder configInteractionView(InteractionViewConfig r100) {
        this.externalConfig.setInteractionViewConfig(r100);
        return this;
    }

    public final ExternalConfigDetailBuilder configOrientationChange(OrientationChangeConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "orientationChangeConfig");
        this.externalConfig.getConfigMap().put(EXTERNAL_CONFIG_TYPE.OrientationChange, r100);
        return this;
    }

    public final ExternalConfigDetailBuilder configRepeatLeaveCheck(boolean r100) {
        this.externalConfig.setEnableRepeatLeaveCheck(r100);
        return this;
    }

    public final ExternalConfigDetailBuilder configRoomExit(RoomExitConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "roomExitConfig");
        this.externalConfig.setRoomExitConfig(r100);
        return this;
    }

    public final ExternalConfigDetailBuilder configShowInClearComponentTagList(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.externalConfig.setShowInClearComponentTagList(r100);
        return this;
    }

    public final ExternalConfigDetailBuilder injectNormalComponent(Map<String, ? extends IExternalInjectComponentProvider> r100) {
        this.externalConfig.setExtendNormalComponentMap(r100);
        return this;
    }
}
