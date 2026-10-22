package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0019\bg\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001)R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\b\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001b\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0018\u0010\u0004\"\u0004\b\u0019\u0010\u0006R\"\u0010\u001f\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001e\u0010\b\u001a\u0004\b\u001c\u0010\u0004\"\u0004\b\u001d\u0010\u0006R\"\u0010#\u001a\u00020\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\"\u0010\b\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\"\u0010'\u001a\u00020\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b&\u0010\b\u001a\u0004\b$\u0010\u0013\"\u0004\b%\u0010\u0015¨\u0006*"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/LinkerPrepareReplyContent;", "Lvh7/c;", "", "getFromRoomId", "()J", "setFromRoomId", "(J)V", "getFromRoomId$annotations", "()V", "fromRoomId", "", "getReplyType", "()I", "setReplyType", "(I)V", "getReplyType$annotations", "replyType", "", "getToast", "()Ljava/lang/String;", "setToast", "(Ljava/lang/String;)V", "getToast$annotations", "toast", "get_fromUserId", "set_fromUserId", "get_fromUserId$annotations", "_fromUserId", "get_toUserId", "set_toUserId", "get_toUserId$annotations", "_toUserId", "get_fromOpenId", "set_fromOpenId", "get_fromOpenId$annotations", "_fromOpenId", "get_toOpenId", "set_toOpenId", "get_toOpenId$annotations", "_toOpenId", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface LinkerPrepareReplyContent extends vh7.c<LinkerPrepareReplyContent> {
    public static final int ACCEPT = 1;
    public static final a Companion = null;
    public static final int REFUSE = 2;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f106897a = null;

        public a() {
        }

        static {
            f106897a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f106897a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_ID)
    long getFromRoomId();

    @FieldName(name = "reply_type")
    int getReplyType();

    @FieldName(name = "toast")
    String getToast();

    @FieldName(name = "from_open_id")
    String get_fromOpenId();

    @FieldName(name = "from_user_id")
    long get_fromUserId();

    @FieldName(name = "to_open_id")
    String get_toOpenId();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID)
    long get_toUserId();

    @FieldName(name = "from_room_id#setter")
    void setFromRoomId(long r100);

    @FieldName(name = "reply_type#setter")
    void setReplyType(int r100);

    @FieldName(name = "toast#setter")
    void setToast(String r100);

    @FieldName(name = "from_open_id#setter")
    void set_fromOpenId(String r100);

    @FieldName(name = "from_user_id#setter")
    void set_fromUserId(long r100);

    @FieldName(name = "to_open_id#setter")
    void set_toOpenId(String r100);

    @FieldName(name = "to_user_id#setter")
    void set_toUserId(long r100);
}
