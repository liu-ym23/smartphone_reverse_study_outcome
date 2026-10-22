package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0014\u0010\u0005\u001a\u00020\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0004R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00148gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00148gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\b8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/e;", "Lvh7/c;", "", "getCardId", "()J", "cardId", "getCardUniqueId", "cardUniqueId", "", "getCardUniqueIdStr", "()Ljava/lang/String;", "cardUniqueIdStr", "getFromStageId", "fromStageId", "Lpy/k;", "getBackground", "()Lpy/k;", "background", "getPairId", "pairId", "Lcom/bytedance/android/livesdk/chatroom/model/interact/f;", "getTitle", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/f;", "title", "getTimestamp", "timestamp", "getNickNameColor", "nickNameColor", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface e extends vh7.c<e> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "background")
    py.k getBackground();

    @FieldName(name = "card_id")
    long getCardId();

    @FieldName(name = "card_unique_id")
    long getCardUniqueId();

    @FieldName(name = "card_unique_id_str")
    String getCardUniqueIdStr();

    @FieldName(name = "from_stage_id")
    long getFromStageId();

    @FieldName(name = "paired_user_nickname_color")
    String getNickNameColor();

    @FieldName(name = "pair_id")
    long getPairId();

    @FieldName(name = "timestamp")
    f getTimestamp();

    @FieldName(name = "title")
    f getTitle();
}
