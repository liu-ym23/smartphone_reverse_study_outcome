package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.livesdk.chatroom.model.IJoinChannelResult;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/h;", "Lvh7/c;", "", "getAlreadyJoinChannel", "()Z", "setAlreadyJoinChannel", "(Z)V", "getAlreadyJoinChannel$annotations", "()V", "alreadyJoinChannel", "Lcom/bytedance/android/livesdk/chatroom/model/IJoinChannelResult;", "getJoinChannelResp", "()Lcom/bytedance/android/livesdk/chatroom/model/IJoinChannelResult;", "setJoinChannelResp", "(Lcom/bytedance/android/livesdk/chatroom/model/IJoinChannelResult;)V", "getJoinChannelResp$annotations", "joinChannelResp", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface h extends vh7.c<h> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "already_join_channel")
    boolean getAlreadyJoinChannel();

    @FieldName(name = "data")
    IJoinChannelResult getJoinChannelResp();

    @FieldName(name = "already_join_channel#setter")
    void setAlreadyJoinChannel(boolean r100);

    @FieldName(name = "data#setter")
    void setJoinChannelResp(IJoinChannelResult r100);
}
