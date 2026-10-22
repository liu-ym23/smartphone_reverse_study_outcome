package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/g1;", "Lvh7/c;", "", "Lja0/a;", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface g1 extends vh7.c<g1>, ja0.a {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    /* synthetic */ List<a1> getBattleScorePairList();

    /* synthetic */ u1 getBattleSetting();

    /* synthetic */ Map<String, IBattleUserInfo> getBattleUserInfoMap();

    /* synthetic */ n3 getBreakthroughInfo();

    /* synthetic */ int getEndReason();

    /* synthetic */ String getEventTrackingInfo();

    /* synthetic */ z4 getFinishExtra();

    /* synthetic */ Map<String, z2> getGradeChanges();

    /* synthetic */ x2 getSkinConfig();

    /* synthetic */ int getSkinType();

    /* synthetic */ l9 getSurvivalInfo();
}
