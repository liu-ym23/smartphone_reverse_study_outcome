package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.ListUserTag;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R*\u0010\u0011\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R6\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b \u0010\b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010(\u001a\u0004\u0018\u00010\"8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b'\u0010\b\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010,\u001a\u0004\u0018\u00010\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b+\u0010\b\u001a\u0004\b)\u0010\u0014\"\u0004\b*\u0010\u0016¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/LinkmicAudienceRecommendItem;", "Lvh7/c;", "", "getRoomId", "()Ljava/lang/Long;", "setRoomId", "(Ljava/lang/Long;)V", "getRoomId$annotations", "()V", "roomId", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/android/live/base/model/user/IBaseUserKt;", "getAnchor", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setAnchor", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "getAnchor$annotations", "anchor", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getText$annotations", "text", "", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getLinkedUser", "()Ljava/util/List;", "setLinkedUser", "(Ljava/util/List;)V", "getLinkedUser$annotations", "linkedUser", "Lcom/bytedance/android/live/liveinteract/plantform/model/ListUserTag;", "getTag", "()Lcom/bytedance/android/live/liveinteract/plantform/model/ListUserTag;", "setTag", "(Lcom/bytedance/android/live/liveinteract/plantform/model/ListUserTag;)V", "getTag$annotations", "tag", "getRoomTitle", "setRoomTitle", "getRoomTitle$annotations", "roomTitle", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface LinkmicAudienceRecommendItem extends vh7.c<LinkmicAudienceRecommendItem> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "anchor")
    IBaseUser getAnchor();

    @FieldName(name = "linked_users")
    List<com.bytedance.android.livesdk.link.model.bridge.k> getLinkedUser();

    @FieldName(name = "room_id")
    Long getRoomId();

    @FieldName(name = "room_title")
    String getRoomTitle();

    @FieldName(name = "tag")
    ListUserTag getTag();

    @FieldName(name = "text")
    String getText();

    @FieldName(name = "anchor#setter")
    void setAnchor(IBaseUser r100);

    @FieldName(name = "linked_users#setter")
    void setLinkedUser(List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r100);

    @FieldName(name = "room_id#setter")
    void setRoomId(Long r100);

    @FieldName(name = "room_title#setter")
    void setRoomTitle(String r100);

    @FieldName(name = "tag#setter")
    void setTag(ListUserTag r100);

    @FieldName(name = "text#setter")
    void setText(String r100);
}
