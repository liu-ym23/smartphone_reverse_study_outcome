package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.tencent.open.SocialConstants;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\u0004\"\u0004\b\u0012\u0010\u0006R\"\u0010\u0018\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0004\"\u0004\b\u0016\u0010\u0006R\"\u0010\u001c\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\b\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR$\u0010#\u001a\u0004\u0018\u00010\u001d8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\"\u0010\b\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010*\u001a\u0004\u0018\u00010$8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b)\u0010\b\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u00101\u001a\u0004\u0018\u00010+8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b0\u0010\b\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R&\u00109\u001a\u000602j\u0002`38&@&X§\u000e¢\u0006\u0012\u0012\u0004\b8\u0010\b\u001a\u0004\b4\u00105\"\u0004\b6\u00107R2\u0010A\u001a\u0012\u0012\u0004\u0012\u00020\u00020:j\b\u0012\u0004\u0012\u00020\u0002`;8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b@\u0010\b\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006B"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ca;", "Lvh7/c;", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getId$annotations", "()V", "id", "", "getInteractType", "()I", "setInteractType", "(I)V", "getInteractType$annotations", "interactType", "getName", "setName", "getName$annotations", "name", "getDesc", "setDesc", "getDesc$annotations", SocialConstants.PARAM_APP_DESC, "getEvalType", "setEvalType", "getEvalType$annotations", "evalType", "Lcom/bytedance/android/livesdk/link/model/da;", "getBattleEffectConfig", "()Lcom/bytedance/android/livesdk/link/model/da;", "setBattleEffectConfig", "(Lcom/bytedance/android/livesdk/link/model/da;)V", "getBattleEffectConfig$annotations", "battleEffectConfig", "Lcom/bytedance/android/livesdk/link/model/fa;", "getRewardPunishConfig", "()Lcom/bytedance/android/livesdk/link/model/fa;", "setRewardPunishConfig", "(Lcom/bytedance/android/livesdk/link/model/fa;)V", "getRewardPunishConfig$annotations", "rewardPunishConfig", "Lcom/bytedance/android/livesdk/link/model/ba;", "getCompeteEvalConfig", "()Lcom/bytedance/android/livesdk/link/model/ba;", "setCompeteEvalConfig", "(Lcom/bytedance/android/livesdk/link/model/ba;)V", "getCompeteEvalConfig$annotations", "competeEvalConfig", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getIcon", "()Lpy/k;", "setIcon", "(Lpy/k;)V", "getIcon$annotations", "icon", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getPlayRule", "()Ljava/util/List;", "setPlayRule", "(Ljava/util/List;)V", "getPlayRule$annotations", "playRule", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ca extends vh7.c<ca> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "battle_effect_config")
    da getBattleEffectConfig();

    @FieldName(name = "compete_eval_config")
    ba getCompeteEvalConfig();

    @FieldName(name = SocialConstants.PARAM_APP_DESC)
    String getDesc();

    @FieldName(name = "eval_type")
    int getEvalType();

    @FieldName(name = "Icon")
    py.k getIcon();

    @FieldName(name = "id")
    String getId();

    @FieldName(name = "interact_type")
    int getInteractType();

    @FieldName(name = "name")
    String getName();

    @FieldName(name = "play_rule")
    List<String> getPlayRule();

    @FieldName(name = "reward_punish_config")
    fa getRewardPunishConfig();

    @FieldName(name = "battle_effect_config#setter")
    void setBattleEffectConfig(da r100);

    @FieldName(name = "compete_eval_config#setter")
    void setCompeteEvalConfig(ba r100);

    @FieldName(name = "desc#setter")
    void setDesc(String r100);

    @FieldName(name = "eval_type#setter")
    void setEvalType(int r100);

    @FieldName(name = "Icon#setter")
    void setIcon(py.k r100);

    @FieldName(name = "id#setter")
    void setId(String r100);

    @FieldName(name = "interact_type#setter")
    void setInteractType(int r100);

    @FieldName(name = "name#setter")
    void setName(String r100);

    @FieldName(name = "play_rule#setter")
    void setPlayRule(List<String> r100);

    @FieldName(name = "reward_punish_config#setter")
    void setRewardPunishConfig(fa r100);
}
