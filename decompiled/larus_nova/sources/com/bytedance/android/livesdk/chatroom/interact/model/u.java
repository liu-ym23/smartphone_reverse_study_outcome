package com.bytedance.android.livesdk.chatroom.interact.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0003\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001c\u0010\t\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\u0004\"\u0004\b\b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R\u001c\u0010\u0012\u001a\u00020\r8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/u;", "Lvh7/c;", "", "is_anchor_involved", "()J", "set_anchor_involved", "(J)V", "getLast_battle_duration_by_anchor", "setLast_battle_duration_by_anchor", "last_battle_duration_by_anchor", "getLoserNum", "setLoserNum", "loserNum", "", "getScoreType", "()I", "setScoreType", "(I)V", "scoreType", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface u extends vh7.c<u> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    long getLast_battle_duration_by_anchor();

    long getLoserNum();

    int getScoreType();

    long is_anchor_involved();

    void setLast_battle_duration_by_anchor(long r100);

    void setLoserNum(long r100);

    void setScoreType(int r100);

    void set_anchor_involved(long r100);
}
