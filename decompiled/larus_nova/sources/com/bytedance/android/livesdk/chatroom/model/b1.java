package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.ListUserTag;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface b1 extends vh7.c<b1> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "count_down_seconds")
    long getCountDownSeconds();

    @FieldName(name = "linked_user")
    List<com.bytedance.android.livesdk.link.model.bridge.k> getLinkedUser();

    @FieldName(name = "matched_room_id")
    long getMatchedRoomId();

    @FieldName(name = "matched_anchor")
    IBaseUser getMatchedUser();

    @FieldName(name = "req_id")
    String getRequestId();

    @FieldName(name = "result_tag")
    List<c1> getResultTagList();

    @FieldName(name = "room_title")
    String getRoomTitle();

    @FieldName(name = "scene")
    int getScene();

    @FieldName(name = "stop_match")
    boolean getStopMatch();

    @FieldName(name = "tag")
    ListUserTag getTag();

    @FieldName(name = "text")
    String getText();

    @FieldName(name = "toast")
    String getToast();

    @FieldName(name = "topic_str")
    List<String> getTopicStrList();
}
