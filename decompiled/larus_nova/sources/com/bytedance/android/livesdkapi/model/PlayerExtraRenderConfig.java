package com.bytedance.android.livesdkapi.model;

import com.amap.api.services.core.AMapException;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerScene;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0016\u0010\u0014\u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u0016\u0010\u0016\u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerExtraRenderConfig;", "", "()V", "allowShareScenes", "", "", "getAllowShareScenes", "()Ljava/util/List;", "decimalOpt", "", "getDecimalOpt", "()Z", "degradeMode", "", "getDegradeMode", "()I", "setDegradeMode", "(I)V", "legalDisplays", "getLegalDisplays", "surfaceEnable", "getSurfaceEnable", "textureStateOpt", "getTextureStateOpt", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerExtraRenderConfig {

    @SerializedName("allow_share_scene")
    private final List<String> allowShareScenes;

    @SerializedName("decimal_opt")
    private final boolean decimalOpt;

    @SerializedName("degrade_mode")
    private int degradeMode;

    @SerializedName("legal_displays")
    private final List<Integer> legalDisplays;

    @SerializedName("surface_enable")
    private final boolean surfaceEnable;

    @SerializedName("texture_state_opt")
    private final boolean textureStateOpt;

    public PlayerExtraRenderConfig() {
        LivePlayerScene r100 = LivePlayerScene.INSTANCE;
        this.allowShareScenes = CollectionsKt.arrayListOf(new String[]{r100.getFEED_PREVIEW().getScene(), r100.getPREVIEW_EXTRA_RENDER().getScene()});
        this.legalDisplays = CollectionsKt.arrayListOf(new Integer[]{2101, Integer.valueOf(AMapException.CODE_AMAP_CLIENT_USERID_ILLEGAL)});
        this.surfaceEnable = true;
        this.decimalOpt = true;
    }

    public final List<String> getAllowShareScenes() {
        return this.allowShareScenes;
    }

    public final boolean getDecimalOpt() {
        return this.decimalOpt;
    }

    public final int getDegradeMode() {
        return this.degradeMode;
    }

    public final List<Integer> getLegalDisplays() {
        return this.legalDisplays;
    }

    public final boolean getSurfaceEnable() {
        return this.surfaceEnable;
    }

    public final boolean getTextureStateOpt() {
        return this.textureStateOpt;
    }

    public final void setDegradeMode(int r100) {
        this.degradeMode = r100;
    }
}
