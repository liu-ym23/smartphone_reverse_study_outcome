package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonAssertResManager;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ForMain
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/i2;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/gift/model/d;", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface i2 extends vh7.e<d>, d {
    @Override // com.bytedance.android.livesdk.gift.model.d, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.gift.model.d, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "asset_meta_base_version")
    /* synthetic */ String getAssetMetaBaseVersion();

    @FieldName(name = "asset_pools")
    /* synthetic */ Map<String, com.bytedance.android.live.core.resources.c> getAssetPools();

    @FieldName(name = ChameleonAssertResManager.ASSET_FOLDER)
    /* synthetic */ List<com.bytedance.android.live.core.resources.e> getAssets();

    @FieldName(name = "base_assets")
    /* synthetic */ List<com.bytedance.android.live.core.resources.e> getBaseAssets();

    @FieldName(name = "delete_assets")
    /* synthetic */ List<Long> getDeleteAssets();

    @FieldName(name = "dynamic_control")
    /* synthetic */ com.bytedance.android.live.core.resources.d getDynamicControl();

    @FieldName(name = "enable_effect_list_v2")
    /* synthetic */ boolean getEnableEffectListV2();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "image_template")
    /* synthetic */ f2 getImageTemplate();

    @FieldName(name = "zip_sweep_mark_assets")
    /* synthetic */ List<Long> getZipSweepMarkAssets();

    @FieldName(name = "asset_meta_base_version#setter")
    /* synthetic */ void setAssetMetaBaseVersion(String r100);

    @FieldName(name = "assets#setter")
    /* synthetic */ void setAssets(List<? extends com.bytedance.android.live.core.resources.e> r100);

    @FieldName(name = "base_assets#setter")
    /* synthetic */ void setBaseAssets(List<? extends com.bytedance.android.live.core.resources.e> r100);

    @FieldName(name = "delete_assets#setter")
    /* synthetic */ void setDeleteAssets(List<Long> r100);

    @FieldName(name = "dynamic_control#setter")
    /* synthetic */ void setDynamicControl(com.bytedance.android.live.core.resources.d r100);

    @FieldName(name = "enable_effect_list_v2#setter")
    /* synthetic */ void setEnableEffectListV2(boolean r100);

    @FieldName(name = "image_template#setter")
    /* synthetic */ void setImageTemplate(f2 r100);

    @FieldName(name = "zip_sweep_mark_assets#setter")
    /* synthetic */ void setZipSweepMarkAssets(List<Long> r100);
}
