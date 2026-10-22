package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/IAudienceRecommendRoomResponse;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/chatroom/model/LinkmicAudienceRecommendItem;", "getLinkmicAudienceRecommendItem", "()Lcom/bytedance/android/livesdk/chatroom/model/LinkmicAudienceRecommendItem;", "setLinkmicAudienceRecommendItem", "(Lcom/bytedance/android/livesdk/chatroom/model/LinkmicAudienceRecommendItem;)V", "getLinkmicAudienceRecommendItem$annotations", "()V", "linkmicAudienceRecommendItem", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IAudienceRecommendRoomResponse extends vh7.c<IAudienceRecommendRoomResponse> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "linkmicAudienceRecommendItem")
    LinkmicAudienceRecommendItem getLinkmicAudienceRecommendItem();

    @FieldName(name = "linkmicAudienceRecommendItem#setter")
    void setLinkmicAudienceRecommendItem(LinkmicAudienceRecommendItem r100);
}
