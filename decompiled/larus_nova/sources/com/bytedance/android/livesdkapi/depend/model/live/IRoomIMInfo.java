package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0012\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R6\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\n\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0015\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomIMInfo;", "Lvh7/c;", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getWelcomeMessage", "()Ljava/util/List;", "setWelcomeMessage", "(Ljava/util/List;)V", "getWelcomeMessage$annotations", "()V", "welcomeMessage", "getRoomTag", "()Ljava/lang/String;", "setRoomTag", "(Ljava/lang/String;)V", "getRoomTag$annotations", "roomTag", "getHideGiftMessage", "setHideGiftMessage", "getHideGiftMessage$annotations", "hideGiftMessage", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IRoomIMInfo extends c<IRoomIMInfo> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "hide_gift_message")
        public static /* synthetic */ void getHideGiftMessage$annotations() {
        }

        @FieldName(name = ILiveRoomPlayFragmentConstant.EXTRA_LOG_ROOM_TAG)
        public static /* synthetic */ void getRoomTag$annotations() {
        }

        @FieldName(name = "welcome_messages")
        public static /* synthetic */ void getWelcomeMessage$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "hide_gift_message")
    String getHideGiftMessage();

    @FieldName(name = ILiveRoomPlayFragmentConstant.EXTRA_LOG_ROOM_TAG)
    String getRoomTag();

    @FieldName(name = "welcome_messages")
    List<String> getWelcomeMessage();

    @FieldName(name = "hide_gift_message#setter")
    void setHideGiftMessage(String r100);

    @FieldName(name = "room_tag#setter")
    void setRoomTag(String r100);

    @FieldName(name = "welcome_messages#setter")
    void setWelcomeMessage(List<String> r100);
}
