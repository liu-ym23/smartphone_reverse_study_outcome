package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u001b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R*\u0010\u0011\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0019\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\b\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010 \u001a\u0004\u0018\u00010\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\b\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010$\u001a\u0004\u0018\u00010\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\b\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\"\u0010(\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b'\u0010\b\u001a\u0004\b%\u0010\u0004\"\u0004\b&\u0010\u0006R\"\u0010,\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b+\u0010\b\u001a\u0004\b)\u0010\u0004\"\u0004\b*\u0010\u0006R\"\u00100\u001a\u00020\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b/\u0010\b\u001a\u0004\b-\u0010\u001c\"\u0004\b.\u0010\u001eR\"\u00104\u001a\u00020\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b3\u0010\b\u001a\u0004\b1\u0010\u001c\"\u0004\b2\u0010\u001e¨\u00065"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/LinkerPrepareInviteContent;", "Lvh7/c;", "", "getFromRoomId", "()J", "setFromRoomId", "(J)V", "getFromRoomId$annotations", "()V", "fromRoomId", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/android/live/base/model/user/IBaseUserKt;", "getInvitorUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setInvitorUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "getInvitorUser$annotations", "invitorUser", "Lcom/bytedance/android/live/base/model/message/a5;", "Lcom/bytedance/android/live/base/model/message/ITextKt;", "getContent", "()Lcom/bytedance/android/live/base/model/message/a5;", "setContent", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "getContent$annotations", "content", "", "getSource", "()Ljava/lang/String;", "setSource", "(Ljava/lang/String;)V", "getSource$annotations", "source", "getSubtitle", "setSubtitle", "getSubtitle$annotations", "subtitle", "get_fromUserId", "set_fromUserId", "get_fromUserId$annotations", "_fromUserId", "get_toUserId", "set_toUserId", "get_toUserId$annotations", "_toUserId", "get_fromOpenId", "set_fromOpenId", "get_fromOpenId$annotations", "_fromOpenId", "get_toOpenId", "set_toOpenId", "get_toOpenId$annotations", "_toOpenId", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface LinkerPrepareInviteContent extends vh7.c<LinkerPrepareInviteContent> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "content")
    a5 getContent();

    @FieldName(name = ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_ID)
    long getFromRoomId();

    @FieldName(name = "invitor_user")
    IBaseUser getInvitorUser();

    @FieldName(name = "source")
    String getSource();

    @FieldName(name = BdpAppEventConstant.PARAMS_SUB_TITLE)
    String getSubtitle();

    @FieldName(name = "from_open_id")
    String get_fromOpenId();

    @FieldName(name = "from_user_id")
    long get_fromUserId();

    @FieldName(name = "to_open_id")
    String get_toOpenId();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID)
    long get_toUserId();

    @FieldName(name = "content#setter")
    void setContent(a5 r100);

    @FieldName(name = "from_room_id#setter")
    void setFromRoomId(long r100);

    @FieldName(name = "invitor_user#setter")
    void setInvitorUser(IBaseUser r100);

    @FieldName(name = "source#setter")
    void setSource(String r100);

    @FieldName(name = "sub_title#setter")
    void setSubtitle(String r100);

    @FieldName(name = "from_open_id#setter")
    void set_fromOpenId(String r100);

    @FieldName(name = "from_user_id#setter")
    void set_fromUserId(long r100);

    @FieldName(name = "to_open_id#setter")
    void set_toOpenId(String r100);

    @FieldName(name = "to_user_id#setter")
    void set_toUserId(long r100);
}
