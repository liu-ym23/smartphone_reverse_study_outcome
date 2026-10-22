package com.bytedance.android.livesdk.gift.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonAssertResManager;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R2\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR:\u0010\u0011\u001a\u001a\u0012\b\u0012\u00060\fj\u0002`\r0\u0002j\f\u0012\b\u0012\u00060\fj\u0002`\r`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\n\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\"\u0010\u0018\u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\n\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R6\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019j\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b`\u001c8&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\n\u001a\u0004\b\u001d\u0010\u001eR:\u0010$\u001a\u001a\u0012\b\u0012\u00060\fj\u0002`\r0\u0002j\f\u0012\b\u0012\u00060\fj\u0002`\r`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\n\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\"\u0010+\u001a\u00020%8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b*\u0010\n\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R2\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b.\u0010\n\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\"\u00105\u001a\u00020\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b4\u0010\n\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u0010<\u001a\u0002068&@&X§\u000e¢\u0006\u0012\u0012\u0004\b;\u0010\n\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006="}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/d;", "Lvh7/c;", "", "Lcom/bytedance/android/live/core/resources/e;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getAssets", "()Ljava/util/List;", "setAssets", "(Ljava/util/List;)V", "getAssets$annotations", "()V", ChameleonAssertResManager.ASSET_FOLDER, "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getDeleteAssets", "setDeleteAssets", "getDeleteAssets$annotations", "deleteAssets", "", "getEnableEffectListV2", "()Z", "setEnableEffectListV2", "(Z)V", "getEnableEffectListV2$annotations", "enableEffectListV2", "", "", "Lcom/bytedance/android/live/core/resources/c;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getAssetPools", "()Ljava/util/Map;", "getAssetPools$annotations", "assetPools", "getZipSweepMarkAssets", "setZipSweepMarkAssets", "getZipSweepMarkAssets$annotations", "zipSweepMarkAssets", "Lcom/bytedance/android/livesdk/gift/model/f2;", "getImageTemplate", "()Lcom/bytedance/android/livesdk/gift/model/f2;", "setImageTemplate", "(Lcom/bytedance/android/livesdk/gift/model/f2;)V", "getImageTemplate$annotations", "imageTemplate", "getBaseAssets", "setBaseAssets", "getBaseAssets$annotations", "baseAssets", "getAssetMetaBaseVersion", "()Ljava/lang/String;", "setAssetMetaBaseVersion", "(Ljava/lang/String;)V", "getAssetMetaBaseVersion$annotations", "assetMetaBaseVersion", "Lcom/bytedance/android/live/core/resources/d;", "getDynamicControl", "()Lcom/bytedance/android/live/core/resources/d;", "setDynamicControl", "(Lcom/bytedance/android/live/core/resources/d;)V", "getDynamicControl$annotations", "dynamicControl", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface d extends vh7.c<d> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "asset_meta_base_version")
    String getAssetMetaBaseVersion();

    @FieldName(name = "asset_pools")
    Map<String, com.bytedance.android.live.core.resources.c> getAssetPools();

    @FieldName(name = ChameleonAssertResManager.ASSET_FOLDER)
    List<com.bytedance.android.live.core.resources.e> getAssets();

    @FieldName(name = "base_assets")
    List<com.bytedance.android.live.core.resources.e> getBaseAssets();

    @FieldName(name = "delete_assets")
    List<Long> getDeleteAssets();

    @FieldName(name = "dynamic_control")
    com.bytedance.android.live.core.resources.d getDynamicControl();

    @FieldName(name = "enable_effect_list_v2")
    boolean getEnableEffectListV2();

    @FieldName(name = "image_template")
    f2 getImageTemplate();

    @FieldName(name = "zip_sweep_mark_assets")
    List<Long> getZipSweepMarkAssets();

    @FieldName(name = "asset_meta_base_version#setter")
    void setAssetMetaBaseVersion(String r100);

    @FieldName(name = "assets#setter")
    void setAssets(List<? extends com.bytedance.android.live.core.resources.e> r100);

    @FieldName(name = "base_assets#setter")
    void setBaseAssets(List<? extends com.bytedance.android.live.core.resources.e> r100);

    @FieldName(name = "delete_assets#setter")
    void setDeleteAssets(List<Long> r100);

    @FieldName(name = "dynamic_control#setter")
    void setDynamicControl(com.bytedance.android.live.core.resources.d r100);

    @FieldName(name = "enable_effect_list_v2#setter")
    void setEnableEffectListV2(boolean r100);

    @FieldName(name = "image_template#setter")
    void setImageTemplate(f2 r100);

    @FieldName(name = "zip_sweep_mark_assets#setter")
    void setZipSweepMarkAssets(List<Long> r100);
}
