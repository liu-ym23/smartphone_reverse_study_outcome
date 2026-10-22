package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\u0004\"\u0004\b\u0012\u0010\u0006R\"\u0010\u0018\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/LinkerConfirmUnsilenceContent;", "Lvh7/c;", "", "getFromRoomId", "()J", "setFromRoomId", "(J)V", "getFromRoomId$annotations", "()V", "fromRoomId", "", "getToast", "()Ljava/lang/String;", "setToast", "(Ljava/lang/String;)V", "getToast$annotations", "toast", "get_fromUserId", "set_fromUserId", "get_fromUserId$annotations", "_fromUserId", "get_fromOpenId", "set_fromOpenId", "get_fromOpenId$annotations", "_fromOpenId", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface LinkerConfirmUnsilenceContent extends vh7.c<LinkerConfirmUnsilenceContent> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_ID)
    long getFromRoomId();

    @FieldName(name = "toast")
    String getToast();

    @FieldName(name = "from_open_id")
    String get_fromOpenId();

    @FieldName(name = "from_user_id")
    long get_fromUserId();

    @FieldName(name = "from_room_id#setter")
    void setFromRoomId(long r100);

    @FieldName(name = "toast#setter")
    void setToast(String r100);

    @FieldName(name = "from_open_id#setter")
    void set_fromOpenId(String r100);

    @FieldName(name = "from_user_id#setter")
    void set_fromUserId(long r100);
}
