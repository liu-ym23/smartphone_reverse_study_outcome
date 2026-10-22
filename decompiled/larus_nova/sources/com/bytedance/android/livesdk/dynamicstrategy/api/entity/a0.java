package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

import com.facebook.keyframes.model.KFImage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class a0 {

    @SerializedName(ComposerHelper.COMPOSER_DEFAULT_VALUE)
    public i defaultResult;

    @SerializedName(KFImage.FEATURES_JSON_FIELD)
    public List<m> features;

    @SerializedName("rule_type")
    public int ruleType;

    @SerializedName("rule_details")
    public List<w> rules;

    @SerializedName("strategy_id")
    public long strategyId;

    @SerializedName("strategy_name")
    public String strategyName;

    @SerializedName("strategy_status")
    public int strategyStatus;

    @SerializedName("version")
    public int version;

    public a0() {
    }
}
