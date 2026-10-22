package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/a5;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/message/model/v8;", "Lcom/bytedance/android/livesdk/link/model/b5;", "Lja0/a;", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a5 extends vh7.e<com.bytedance.android.livesdk.message.model.v8>, com.bytedance.android.livesdk.message.model.v8, b5, ja0.a {
    @Override // com.bytedance.android.livesdk.message.model.v8, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.message.model.v8, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    /* synthetic */ z4 getBattleFinishExtra();

    /* synthetic */ List<a1> getBattleScorePairList();

    /* synthetic */ u1 getBattleSetting();

    /* synthetic */ Map<String, IBattleUserInfo> getBattleUserInfoMap();

    /* synthetic */ n3 getBreakthroughInfo();

    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    /* synthetic */ String getCutShortPrompt();

    /* synthetic */ boolean getCutShortWin();

    /* synthetic */ int getEndReason();

    /* synthetic */ String getEventTrackingInfo();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    /* synthetic */ Map<String, z2> getGradeChanges();

    /* synthetic */ int getKillFinishType();

    /* synthetic */ x2 getSkinConfig();

    /* synthetic */ int getSkinType();

    /* synthetic */ l9 getSurvivalInfo();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);
}
