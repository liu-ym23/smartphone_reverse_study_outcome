package com.bytedance.android.livesdkapi.distribution;

import com.bytedance.android.livesdkapi.distribution.config.BaseCommonConfig;
import com.bytedance.android.livesdkapi.distribution.config.ComponentConfig;
import com.bytedance.android.livesdkapi.distribution.config.GestureConfig;
import com.bytedance.android.livesdkapi.distribution.config.GuideConfig;
import com.bytedance.android.livesdkapi.distribution.config.LivePageConfig;
import com.bytedance.android.livesdkapi.distribution.config.LongPressPanelConfig;
import com.bytedance.android.livesdkapi.distribution.config.OrientationChangeConfig;
import com.bytedance.android.livesdkapi.distribution.config.ServiceConfig;
import com.bytedance.android.livesdkapi.distribution.config.ShieldMode;
import com.bytedance.android.livesdkapi.distribution.externalinjectcomponent.IExternalInjectComponentProvider;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u00052\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u00101\u001a\u00020\nJ$\u00102\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u00052\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u00101\u001a\u00020\nR\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\u0018R(\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\b\"\u0004\b\u001b\u0010\u0018R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdkapi/distribution/ExternalConfigDetail;", "", "()V", "configMap", "", "Lcom/bytedance/android/livesdkapi/distribution/EXTERNAL_CONFIG_TYPE;", "Lcom/bytedance/android/livesdkapi/distribution/config/BaseCommonConfig;", "getConfigMap", "()Ljava/util/Map;", "enableFsOpt", "", "getEnableFsOpt", "()Z", "setEnableFsOpt", "(Z)V", "enableRepeatLeaveCheck", "getEnableRepeatLeaveCheck", "setEnableRepeatLeaveCheck", "extendNormalComponentMap", "", "", "Lcom/bytedance/android/livesdkapi/distribution/externalinjectcomponent/IExternalInjectComponentProvider;", "getExtendNormalComponentMap", "setExtendNormalComponentMap", "(Ljava/util/Map;)V", "extendTemplateComponentMap", "getExtendTemplateComponentMap", "setExtendTemplateComponentMap", "interactionViewConfig", "Lcom/bytedance/android/livesdkapi/distribution/InteractionViewConfig;", "getInteractionViewConfig", "()Lcom/bytedance/android/livesdkapi/distribution/InteractionViewConfig;", "setInteractionViewConfig", "(Lcom/bytedance/android/livesdkapi/distribution/InteractionViewConfig;)V", "roomExitConfig", "Lcom/bytedance/android/livesdkapi/distribution/RoomExitConfig;", "getRoomExitConfig", "()Lcom/bytedance/android/livesdkapi/distribution/RoomExitConfig;", "setRoomExitConfig", "(Lcom/bytedance/android/livesdkapi/distribution/RoomExitConfig;)V", "showInClearComponentTagList", "", "getShowInClearComponentTagList", "()Ljava/util/List;", "setShowInClearComponentTagList", "(Ljava/util/List;)V", "canUse", "type", "action", "defaultValue", "disbale", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExternalConfigDetail {
    private final Map<EXTERNAL_CONFIG_TYPE, BaseCommonConfig> configMap;
    private boolean enableFsOpt;
    private boolean enableRepeatLeaveCheck;
    private Map<String, ? extends IExternalInjectComponentProvider> extendNormalComponentMap;
    private Map<String, ? extends IExternalInjectComponentProvider> extendTemplateComponentMap;
    private InteractionViewConfig interactionViewConfig;
    private RoomExitConfig roomExitConfig;
    private List<String> showInClearComponentTagList;

    /* JADX WARN: Multi-variable type inference failed */
    public ExternalConfigDetail() {
        boolean r100 = false;
        ShieldMode r101 = null;
        int r102 = 7;
        DefaultConstructorMarker r103 = null;
        boolean r104 = false;
        List r105 = null;
        int r106 = 7;
        DefaultConstructorMarker r107 = null;
        this.configMap = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(EXTERNAL_CONFIG_TYPE.OrientationChange, new OrientationChangeConfig(r100, r101, null, r102, r103)), TuplesKt.to(EXTERNAL_CONFIG_TYPE.Guide, new GuideConfig(r100, r101, 0 == true ? 1 : 0, r102, r103)), TuplesKt.to(EXTERNAL_CONFIG_TYPE.Gesture, new GestureConfig(r104, 0 == true ? 1 : 0, r105, r106, r107)), TuplesKt.to(EXTERNAL_CONFIG_TYPE.LongPressPanel, new LongPressPanelConfig(r104, 0 == true ? 1 : 0, r105, r106, r107)), TuplesKt.to(EXTERNAL_CONFIG_TYPE.Component, new ComponentConfig(r104, 0 == true ? 1 : 0, r105, r106, r107)), TuplesKt.to(EXTERNAL_CONFIG_TYPE.Service, new ServiceConfig(r104, 0 == true ? 1 : 0, r105, r106, r107)), TuplesKt.to(EXTERNAL_CONFIG_TYPE.LivePage, new LivePageConfig(true, ShieldMode.NONE, null, null))});
        this.enableRepeatLeaveCheck = true;
    }

    public final Map<EXTERNAL_CONFIG_TYPE, BaseCommonConfig> getConfigMap() {
        return this.configMap;
    }

    public final boolean getEnableFsOpt() {
        return this.enableFsOpt;
    }

    public final boolean getEnableRepeatLeaveCheck() {
        return this.enableRepeatLeaveCheck;
    }

    public final Map<String, IExternalInjectComponentProvider> getExtendNormalComponentMap() {
        return this.extendNormalComponentMap;
    }

    public final Map<String, IExternalInjectComponentProvider> getExtendTemplateComponentMap() {
        return this.extendTemplateComponentMap;
    }

    public final InteractionViewConfig getInteractionViewConfig() {
        return this.interactionViewConfig;
    }

    public final RoomExitConfig getRoomExitConfig() {
        return this.roomExitConfig;
    }

    public final List<String> getShowInClearComponentTagList() {
        return this.showInClearComponentTagList;
    }

    public final void setEnableFsOpt(boolean r100) {
        this.enableFsOpt = r100;
    }

    public final void setEnableRepeatLeaveCheck(boolean r100) {
        this.enableRepeatLeaveCheck = r100;
    }

    public final void setExtendNormalComponentMap(Map<String, ? extends IExternalInjectComponentProvider> r100) {
        this.extendNormalComponentMap = r100;
    }

    public final void setExtendTemplateComponentMap(Map<String, ? extends IExternalInjectComponentProvider> r100) {
        this.extendTemplateComponentMap = r100;
    }

    public final void setInteractionViewConfig(InteractionViewConfig r100) {
        this.interactionViewConfig = r100;
    }

    public final void setRoomExitConfig(RoomExitConfig r100) {
        this.roomExitConfig = r100;
    }

    public final void setShowInClearComponentTagList(List<String> r100) {
        this.showInClearComponentTagList = r100;
    }

    public final boolean canUse(EXTERNAL_CONFIG_TYPE r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        BaseCommonConfig r103 = this.configMap.get(r100);
        if (r103 != null) goto L5;
        return r102;
    L5:
        return r103.canUse(r101);
    }

    public final boolean disbale(EXTERNAL_CONFIG_TYPE r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        BaseCommonConfig r103 = this.configMap.get(r100);
        if (r103 != null) goto L5;
        return r102;
    L5:
        return r103.disable(r101);
    }

    public static /* synthetic */ boolean canUse$default(ExternalConfigDetail r100, EXTERNAL_CONFIG_TYPE r101, String r102, boolean r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = true;
    L9:
        return r100.canUse(r101, r102, r103);
    }

    public static /* synthetic */ boolean disbale$default(ExternalConfigDetail r100, EXTERNAL_CONFIG_TYPE r101, String r102, boolean r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = false;
    L9:
        return r100.disbale(r101, r102, r103);
    }
}
