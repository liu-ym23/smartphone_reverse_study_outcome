package com.bytedance.android.livesdkapi.depend.message;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\u0004\"\u0004\b\u0012\u0010\u0006R\"\u0010\u0018\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0004\"\u0004\b\u0016\u0010\u0006R\"\u0010\u001c\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\b\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR$\u0010#\u001a\u0004\u0018\u00010\u001d8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\"\u0010\b\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010*\u001a\u0004\u0018\u00010$8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b)\u0010\b\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010.\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b-\u0010\b\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000e¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/LinkerPrepareInviteContent;", "Lvh7/c;", "", "getFromUserId", "()J", "setFromUserId", "(J)V", "getFromUserId$annotations", "()V", "fromUserId", "", "getFromOpenId", "()Ljava/lang/String;", "setFromOpenId", "(Ljava/lang/String;)V", "getFromOpenId$annotations", "fromOpenId", "getFromRoomId", "setFromRoomId", "getFromRoomId$annotations", "fromRoomId", "getToUserId", "setToUserId", "getToUserId$annotations", "toUserId", "getToOpenId", "setToOpenId", "getToOpenId$annotations", "toOpenId", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getInvitorUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setInvitorUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "getInvitorUser$annotations", "invitorUser", "Lcom/bytedance/android/live/base/model/message/a5;", "getContent", "()Lcom/bytedance/android/live/base/model/message/a5;", "setContent", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "getContent$annotations", "content", "getSource", "setSource", "getSource$annotations", "source", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
@ForMain
public interface LinkerPrepareInviteContent extends c<LinkerPrepareInviteContent> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        @FieldName(name = "content")
        public static /* synthetic */ void getContent$annotations() {
        }

        @FieldName(name = "from_open_id")
        public static /* synthetic */ void getFromOpenId$annotations() {
        }

        @FieldName(name = ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_ID)
        public static /* synthetic */ void getFromRoomId$annotations() {
        }

        @FieldName(name = "from_user_id")
        public static /* synthetic */ void getFromUserId$annotations() {
        }

        @FieldName(name = "invitor_user")
        public static /* synthetic */ void getInvitorUser$annotations() {
        }

        @FieldName(name = "source")
        public static /* synthetic */ void getSource$annotations() {
        }

        @FieldName(name = "to_open_id")
        public static /* synthetic */ void getToOpenId$annotations() {
        }

        @FieldName(name = a.KEY_TO_USER_ID)
        public static /* synthetic */ void getToUserId$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "content")
    a5 getContent();

    @FieldName(name = "from_open_id")
    String getFromOpenId();

    @FieldName(name = ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_ID)
    long getFromRoomId();

    @FieldName(name = "from_user_id")
    long getFromUserId();

    @FieldName(name = "invitor_user")
    IBaseUser getInvitorUser();

    @FieldName(name = "source")
    String getSource();

    @FieldName(name = "to_open_id")
    String getToOpenId();

    @FieldName(name = a.KEY_TO_USER_ID)
    long getToUserId();

    @FieldName(name = "content#setter")
    void setContent(a5 r100);

    @FieldName(name = "from_open_id#setter")
    void setFromOpenId(String r100);

    @FieldName(name = "from_room_id#setter")
    void setFromRoomId(long r100);

    @FieldName(name = "from_user_id#setter")
    void setFromUserId(long r100);

    @FieldName(name = "invitor_user#setter")
    void setInvitorUser(IBaseUser r100);

    @FieldName(name = "source#setter")
    void setSource(String r100);

    @FieldName(name = "to_open_id#setter")
    void setToOpenId(String r100);

    @FieldName(name = "to_user_id#setter")
    void setToUserId(long r100);
}
