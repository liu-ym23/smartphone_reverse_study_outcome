package com.bytedance.android.livesdk.chatroom.distribution;

import com.bytedance.android.livesdkapi.distribution.EXTERNAL_CONFIG_TYPE;
import com.bytedance.android.livesdkapi.distribution.ExternalConfigDetail;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.android.livesdkapi.distribution.InteractionViewConfig;
import com.bytedance.android.livesdkapi.distribution.LiveExternalConfig;
import com.bytedance.android.livesdkapi.distribution.LiveExternalScene;
import com.bytedance.android.livesdkapi.distribution.LiveExternalType;
import com.bytedance.android.livesdkapi.distribution.RoomExitConfig;
import com.bytedance.android.livesdkapi.distribution.ViewConfig;
import com.bytedance.android.livesdkapi.distribution.externalinjectcomponent.IExternalInjectComponentProvider;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class h implements IExternalConfigJudger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LiveExternalConfig f105774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f105775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f105776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f105777d;

    @Override // com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger
    public final LiveExternalScene getExternalScene() {
        LiveExternalConfig r100 = this.f105774a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getScene();
    }

    @Override // com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger
    public final ILivePlayerScene getPlayerScene() {
        LiveExternalConfig r100 = this.f105774a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPlayerScene();
    }

    @Override // com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger
    public final boolean isInExternalMode() {
        LiveExternalConfig r100 = this.f105774a;
        if (r100 == null) goto L31;
        ExternalConfigDetail r101 = null;
        if (r100 == null) goto L7;
        LiveExternalType r102 = r100.getLiveExternalType();
    L9:
        if (r102 != LiveExternalType.Single) goto L15;
        LiveExternalConfig r103 = this.f105774a;
        if (r103 == null) goto L13;
        ExternalConfigDetail r104 = r103.getFisrtRoomConfig();
    L14:
        if (r104 == null) goto L15;
    L30:
        return true;
    L13:
        r104 = null;
    L15:
        LiveExternalConfig r105 = this.f105774a;
        if (r105 == null) goto L18;
        LiveExternalType r106 = r105.getLiveExternalType();
    L20:
        if (r106 != LiveExternalType.Multi) goto L31;
        LiveExternalConfig r107 = this.f105774a;
        if (r107 == null) goto L24;
        ExternalConfigDetail r108 = r107.getFisrtRoomConfig();
    L25:
        if (r108 == null) goto L31;
        LiveExternalConfig r109 = this.f105774a;
        if (r109 == null) goto L29;
        r101 = r109.getFeedRoomConfig();
    L29:
        if (r101 == null) goto L31;
    L24:
        r108 = null;
        goto L25
    L18:
        r106 = null;
        goto L20
    L7:
        r102 = null;
    L31:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger
    public final boolean disableEndPage() {
        if (isInExternalMode() == true) goto L6;
        return false;
    L6:
        ExternalConfigDetail r100 = a(null);
        if (r100 == null) goto L11;
        RoomExitConfig r101 = r100.getRoomExitConfig();
        if (r101 == null) goto L11;
        boolean r102 = r101.isCanShowEndPage();
    L13:
        return !r102;
    L11:
        r102 = true;
        goto L13
    }

    @Override // com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger
    public final boolean disableUserLeave() {
        if (isInExternalMode() == true) goto L6;
        return false;
    L6:
        ExternalConfigDetail r100 = a(null);
        if (r100 == null) goto L11;
        RoomExitConfig r101 = r100.getRoomExitConfig();
        if (r101 == null) goto L11;
        boolean r102 = r101.isEnableUserClose();
    L13:
        return !r102;
    L11:
        r102 = true;
        goto L13
    }

    @Override // com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger
    public final boolean enableFsOpt() {
        if (isInExternalMode() == true) goto L5;
        return false;
    L5:
        ExternalConfigDetail r100 = a(null);
        if (r100 != null) goto L8;
        return false;
    L8:
        return r100.getEnableFsOpt();
    }

    @Override // com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger
    public final Map<String, String> getCommonParams() {
        if (isInExternalMode() == true) goto L5;
        return null;
    L5:
        LiveExternalConfig r100 = this.f105774a;
        if (r100 != null) goto L8;
        return null;
    L8:
        return r100.getCommonParams();
    }

    @Override // com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger
    public final RoomExitConfig getRoomExitConfig() {
        if (isInExternalMode() == true) goto L5;
        return null;
    L5:
        ExternalConfigDetail r100 = a(null);
        if (r100 != null) goto L8;
        return null;
    L8:
        return r100.getRoomExitConfig();
    }

    @Override // com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger
    public final List<String> getShowInClearTagList() {
        if (isInExternalMode() == true) goto L5;
        return null;
    L5:
        ExternalConfigDetail r100 = a(null);
        if (r100 != null) goto L8;
        return null;
    L8:
        return r100.getShowInClearComponentTagList();
    }

    @Override // com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger
    public final Map<String, IExternalInjectComponentProvider> getTemplateComponentProviders() {
        if (isInExternalMode() == true) goto L6;
        return null;
    L6:
        if (os1.b.b().c() == true) goto L8;
        return null;
    L8:
        ExternalConfigDetail r100 = a(null);
        if (r100 != null) goto L11;
        return null;
    L11:
        return r100.getExtendTemplateComponentMap();
    }

    @Override // com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger
    public final boolean isEnableRepeatLeaveCheck() {
        if (isInExternalMode() == true) goto L6;
        return false;
    L6:
        ExternalConfigDetail r100 = a(null);
        if (r100 != null) goto L11;
        return true;
    L11:
        return r100.getEnableRepeatLeaveCheck();
    }

    @Override // com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger
    public final int getCurIndex() {
        return this.f105775b;
    }

    @Override // com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger
    public final String getCurRoomId() {
        return this.f105777d;
    }

    @Override // com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger
    public final String getFirstRoomId() {
        return this.f105776c;
    }

    public final ExternalConfigDetail a(String r100) {
        if (r100 != null) goto L4;
        r100 = this.f105777d;
    L4:
        String r101 = this.f105776c;
        if (r101 != null) goto L7;
    L11:
        LiveExternalConfig r102 = this.f105774a;
        if (r102 != null) goto L14;
        return null;
    L14:
        return r102.getFeedRoomConfig();
    L7:
        if (r101.equals(r100) != true) goto L11;
        LiveExternalConfig r103 = this.f105774a;
        if (r103 != null) goto L16;
        return null;
    L16:
        return r103.getFisrtRoomConfig();
    }

    @Override // com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger
    public final Map<String, IExternalInjectComponentProvider> getNormalComponentProviders(String r100) {
        if (isInExternalMode() == true) goto L5;
        return null;
    L5:
        ExternalConfigDetail r101 = a(r100);
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.getExtendNormalComponentMap();
    }

    @Override // com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger
    public final void setConfig(LiveExternalConfig r100) {
        this.f105774a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger
    public final void updateIndex(int r100) {
        this.f105775b = r100;
    }

    @Override // com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger
    public final void updateRoomId(String r100) {
        this.f105777d = r100;
    }

    public h(String r100, String r101) {
        this.f105776c = r100;
        this.f105777d = r101;
    }

    @Override // com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger
    public final boolean disable(EXTERNAL_CONFIG_TYPE r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return disable(r100, r101, false);
    }

    @Override // com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger
    public final ViewConfig getInteractionViewConfig(boolean r100, String r101) {
        if (isInExternalMode() == true) goto L5;
        return null;
    L5:
        if (r100 == false) goto L11;
        ExternalConfigDetail r102 = a(r101);
        if (r102 == null) goto L17;
        InteractionViewConfig r103 = r102.getInteractionViewConfig();
        if (r103 != null) goto L19;
        return null;
    L19:
        return r103.getPortraitConfig();
    L17:
        return null;
    L11:
        ExternalConfigDetail r104 = a(r101);
        if (r104 == null) goto L20;
        InteractionViewConfig r105 = r104.getInteractionViewConfig();
        if (r105 != null) goto L16;
        return null;
    L16:
        return r105.getLandscapeConfig();
    L20:
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger
    public final boolean canUse(EXTERNAL_CONFIG_TYPE r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        if (isInExternalMode() == true) goto L6;
        return r102;
    L6:
        if (os1.b.a(r100, r101) == true) goto L8;
        return r102;
    L8:
        ExternalConfigDetail r103 = a(null);
        if (r103 != null) goto L11;
        return r102;
    L11:
        return r103.canUse(r100, r101, r102);
    }

    @Override // com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger
    public final boolean disable(EXTERNAL_CONFIG_TYPE r100, String r101, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "type");
        if (isInExternalMode() == true) goto L6;
        return r110;
    L6:
        if (os1.b.a(r100, r101) == true) goto L8;
        return r110;
    L8:
        ExternalConfigDetail r102 = a(null);
        if (r102 != null) goto L11;
        return r110;
    L11:
        return ExternalConfigDetail.disbale$default(r102, r100, r101, false, 4, null);
    }
}
