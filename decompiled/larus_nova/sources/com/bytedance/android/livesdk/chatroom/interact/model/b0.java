package com.bytedance.android.livesdk.chatroom.interact.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/b0;", "Lvh7/c;", "", "getLast_fight_duration_by_anchor", "()J", "setLast_fight_duration_by_anchor", "(J)V", "last_fight_duration_by_anchor", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface b0 extends vh7.c<b0> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    long getLast_fight_duration_by_anchor();

    void setLast_fight_duration_by_anchor(long r100);
}
