package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\r\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/b3;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/b0;", "Lcom/bytedance/android/livesdk/link/model/u1;", "getBattleSettings", "()Lcom/bytedance/android/livesdk/link/model/u1;", "getBattleSettings$annotations", "()V", "battleSettings", "Lcom/bytedance/android/livesdk/link/model/l9;", "getSurvivalInfo", "()Lcom/bytedance/android/livesdk/link/model/l9;", "getSurvivalInfo$annotations", "survivalInfo", "", "getScoreVersion", "()Ljava/lang/Long;", "getScoreVersion$annotations", "scoreVersion", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface b3 extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.b0>, com.bytedance.android.livesdk.link.model.bridge.b0 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.b0, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.b0, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "battle_settings")
    u1 getBattleSettings();

    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "score_version")
    Long getScoreVersion();

    @FieldName(name = "survival_info")
    l9 getSurvivalInfo();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);
}
