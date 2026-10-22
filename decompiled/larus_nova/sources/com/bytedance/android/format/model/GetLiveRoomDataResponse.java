package com.bytedance.android.format.model;

import com.bytedance.android.format.model.message.LiveMsgSugResp;
import com.bytedance.android.live.base.model.ImageModel;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0004=>?@B\u0007¢\u0006\u0004\b;\u0010<R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR0\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u00105\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006A"}, d2 = {"Lcom/bytedance/android/format/model/GetLiveRoomDataResponse;", "Ljava/io/Serializable;", "Lcom/bytedance/android/format/model/GetLiveRoomDataResponse$HistoryChatData;", "chatHistory", "Lcom/bytedance/android/format/model/GetLiveRoomDataResponse$HistoryChatData;", "getChatHistory", "()Lcom/bytedance/android/format/model/GetLiveRoomDataResponse$HistoryChatData;", "setChatHistory", "(Lcom/bytedance/android/format/model/GetLiveRoomDataResponse$HistoryChatData;)V", "Lcom/bytedance/android/format/model/FormatLiveRoom$UserData;", "userData", "Lcom/bytedance/android/format/model/FormatLiveRoom$UserData;", "getUserData", "()Lcom/bytedance/android/format/model/FormatLiveRoom$UserData;", "setUserData", "(Lcom/bytedance/android/format/model/FormatLiveRoom$UserData;)V", "Lcom/bytedance/android/format/model/GetLiveRoomDataResponse$ProductCard;", "currentProductCard", "Lcom/bytedance/android/format/model/GetLiveRoomDataResponse$ProductCard;", "getCurrentProductCard", "()Lcom/bytedance/android/format/model/GetLiveRoomDataResponse$ProductCard;", "setCurrentProductCard", "(Lcom/bytedance/android/format/model/GetLiveRoomDataResponse$ProductCard;)V", "Lcom/bytedance/android/format/model/FormatLiveRoom$SliceItemInfo;", "sliceData", "Lcom/bytedance/android/format/model/FormatLiveRoom$SliceItemInfo;", "getSliceData", "()Lcom/bytedance/android/format/model/FormatLiveRoom$SliceItemInfo;", "setSliceData", "(Lcom/bytedance/android/format/model/FormatLiveRoom$SliceItemInfo;)V", "", "", "extra", "Ljava/util/Map;", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "Lcom/bytedance/android/format/model/message/LiveMsgSugResp;", "currentInteractiveSug", "Lcom/bytedance/android/format/model/message/LiveMsgSugResp;", "getCurrentInteractiveSug", "()Lcom/bytedance/android/format/model/message/LiveMsgSugResp;", "setCurrentInteractiveSug", "(Lcom/bytedance/android/format/model/message/LiveMsgSugResp;)V", "", "playModeStatus", "I", "getPlayModeStatus", "()I", "setPlayModeStatus", "(I)V", "Lcom/bytedance/android/format/model/m;", "currentCarouselComponentInfo", "Lcom/bytedance/android/format/model/m;", "getCurrentCarouselComponentInfo", "()Lcom/bytedance/android/format/model/m;", "setCurrentCarouselComponentInfo", "(Lcom/bytedance/android/format/model/m;)V", "<init>", "()V", "ChatDetail", "ChatType", "HistoryChatData", "ProductCard", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GetLiveRoomDataResponse implements Serializable {

    @SerializedName("chat_history")
    private HistoryChatData chatHistory;

    @SerializedName("current_carousel_component_info")
    private m currentCarouselComponentInfo;

    @SerializedName("current_ai_interactive_sug_info")
    private LiveMsgSugResp currentInteractiveSug;

    @SerializedName("current_product_card")
    private ProductCard currentProductCard;

    @SerializedName("extra")
    private Map<String, String> extra;

    @SerializedName("play_mode_status")
    private int playModeStatus;

    @SerializedName("latest_slice_item_info")
    private FormatLiveRoom.SliceItemInfo sliceData;

    @SerializedName("user_data")
    private FormatLiveRoom.UserData userData;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u001d\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\"\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R \u0010%\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR \u0010(\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R \u0010+\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001f\"\u0004\b-\u0010!R \u0010.\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001f\"\u0004\b0\u0010!R\u001e\u00101\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0012\"\u0004\b3\u0010\u0014R \u00104\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001f\"\u0004\b6\u0010!R\u001e\u00107\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0012\"\u0004\b9\u0010\u0014¨\u0006:"}, d2 = {"Lcom/bytedance/android/format/model/GetLiveRoomDataResponse$ChatDetail;", "Ljava/io/Serializable;", "()V", "avatarThumb", "Lcom/bytedance/android/live/base/model/ImageModel;", "getAvatarThumb", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setAvatarThumb", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "chatType", "", "getChatType", "()I", "setChatType", "(I)V", "createTimeMs", "", "getCreateTimeMs", "()J", "setCreateTimeMs", "(J)V", "hasKeyMemoryUpdated", "", "getHasKeyMemoryUpdated", "()Ljava/lang/Boolean;", "setHasKeyMemoryUpdated", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", RemoteMessageConst.MSGID, "", "getMsgId", "()Ljava/lang/String;", "setMsgId", "(Ljava/lang/String;)V", "nickName", "getNickName", "setNickName", "respForAvatarThumb", "getRespForAvatarThumb", "setRespForAvatarThumb", "respForMsgId", "getRespForMsgId", "setRespForMsgId", "respForNickName", "getRespForNickName", "setRespForNickName", "respForText", "getRespForText", "setRespForText", "respForUserId", "getRespForUserId", "setRespForUserId", "text", "getText", "setText", "userId", "getUserId", "setUserId", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ChatDetail implements Serializable {

        @SerializedName("avatar_thumb")
        private ImageModel avatarThumb;

        @SerializedName("chat_type")
        private int chatType;

        @SerializedName("create_time_ms")
        private long createTimeMs;

        @SerializedName("has_key_memory_updated")
        private Boolean hasKeyMemoryUpdated;

        @SerializedName("msg_id")
        private String msgId;

        @SerializedName("nick_name")
        private String nickName;

        @SerializedName("resp_for_avatar_thumb")
        private ImageModel respForAvatarThumb;

        @SerializedName("resp_for_msg_id")
        private String respForMsgId;

        @SerializedName("resp_for_nick_name")
        private String respForNickName;

        @SerializedName("resp_for_text")
        private String respForText;

        @SerializedName("resp_for_user_id")
        private long respForUserId;

        @SerializedName("text")
        private String text;

        @SerializedName("user_id")
        private long userId;

        public ChatDetail() {
            this.nickName = "";
            this.respForNickName = "";
        }

        public final ImageModel getAvatarThumb() {
            return this.avatarThumb;
        }

        public final int getChatType() {
            return this.chatType;
        }

        public final long getCreateTimeMs() {
            return this.createTimeMs;
        }

        public final Boolean getHasKeyMemoryUpdated() {
            return this.hasKeyMemoryUpdated;
        }

        public final String getMsgId() {
            return this.msgId;
        }

        public final String getNickName() {
            return this.nickName;
        }

        public final ImageModel getRespForAvatarThumb() {
            return this.respForAvatarThumb;
        }

        public final String getRespForMsgId() {
            return this.respForMsgId;
        }

        public final String getRespForNickName() {
            return this.respForNickName;
        }

        public final String getRespForText() {
            return this.respForText;
        }

        public final long getRespForUserId() {
            return this.respForUserId;
        }

        public final String getText() {
            return this.text;
        }

        public final long getUserId() {
            return this.userId;
        }

        public final void setAvatarThumb(ImageModel r100) {
            this.avatarThumb = r100;
        }

        public final void setChatType(int r100) {
            this.chatType = r100;
        }

        public final void setCreateTimeMs(long r100) {
            this.createTimeMs = r100;
        }

        public final void setHasKeyMemoryUpdated(Boolean r100) {
            this.hasKeyMemoryUpdated = r100;
        }

        public final void setMsgId(String r100) {
            this.msgId = r100;
        }

        public final void setNickName(String r100) {
            this.nickName = r100;
        }

        public final void setRespForAvatarThumb(ImageModel r100) {
            this.respForAvatarThumb = r100;
        }

        public final void setRespForMsgId(String r100) {
            this.respForMsgId = r100;
        }

        public final void setRespForNickName(String r100) {
            this.respForNickName = r100;
        }

        public final void setRespForText(String r100) {
            this.respForText = r100;
        }

        public final void setRespForUserId(long r100) {
            this.respForUserId = r100;
        }

        public final void setText(String r100) {
            this.text = r100;
        }

        public final void setUserId(long r100) {
            this.userId = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/format/model/GetLiveRoomDataResponse$ChatType;", "", "", "value", "I", "getValue", "()I", "AIReplyDefault", "AIReplyTargeted", "UserActive", "UserInteract", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ChatType extends Enum<ChatType> {
        public static final ChatType AIReplyDefault = null;
        public static final ChatType AIReplyTargeted = null;
        public static final ChatType UserActive = null;
        public static final ChatType UserInteract = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ChatType[] f51343a = null;
        private final int value;

        static {
            ChatType r100 = new ChatType("AIReplyDefault", 0, 0);
            AIReplyDefault = r100;
            ChatType r101 = new ChatType("AIReplyTargeted", 1, 1);
            AIReplyTargeted = r101;
            ChatType r102 = new ChatType("UserActive", 2, 2);
            UserActive = r102;
            ChatType r103 = new ChatType("UserInteract", 3, 3);
            UserInteract = r103;
            f51343a = new ChatType[]{r100, r101, r102, r103};
        }

        public static ChatType valueOf(String r100) {
            return (ChatType) r27.a.a(ChatType.class, r100);
        }

        public static ChatType[] values() {
            return (ChatType[]) f51343a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public ChatType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R2\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/format/model/GetLiveRoomDataResponse$HistoryChatData;", "Ljava/io/Serializable;", "()V", "chatDetailList", "Ljava/util/ArrayList;", "Lcom/bytedance/android/format/model/GetLiveRoomDataResponse$ChatDetail;", "Lkotlin/collections/ArrayList;", "getChatDetailList", "()Ljava/util/ArrayList;", "setChatDetailList", "(Ljava/util/ArrayList;)V", "total", "", "getTotal", "()J", "setTotal", "(J)V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class HistoryChatData implements Serializable {

        @SerializedName("chat_detail")
        private ArrayList<ChatDetail> chatDetailList;

        @SerializedName("total")
        private long total;

        public HistoryChatData() {
        }

        public final ArrayList<ChatDetail> getChatDetailList() {
            return this.chatDetailList;
        }

        public final long getTotal() {
            return this.total;
        }

        public final void setChatDetailList(ArrayList<ChatDetail> r100) {
            this.chatDetailList = r100;
        }

        public final void setTotal(long r100) {
            this.total = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/format/model/GetLiveRoomDataResponse$ProductCard;", "Ljava/io/Serializable;", "()V", "productId", "", "getProductId", "()J", "setProductId", "(J)V", "productType", "", "getProductType", "()I", "setProductType", "(I)V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ProductCard implements Serializable {

        @SerializedName("product_id")
        private long productId;

        @SerializedName("product_type")
        private int productType;

        public ProductCard() {
        }

        public final long getProductId() {
            return this.productId;
        }

        public final int getProductType() {
            return this.productType;
        }

        public final void setProductId(long r100) {
            this.productId = r100;
        }

        public final void setProductType(int r100) {
            this.productType = r100;
        }
    }

    public GetLiveRoomDataResponse() {
    }

    public final HistoryChatData getChatHistory() {
        return this.chatHistory;
    }

    public final m getCurrentCarouselComponentInfo() {
        return this.currentCarouselComponentInfo;
    }

    public final LiveMsgSugResp getCurrentInteractiveSug() {
        return this.currentInteractiveSug;
    }

    public final ProductCard getCurrentProductCard() {
        return this.currentProductCard;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final int getPlayModeStatus() {
        return this.playModeStatus;
    }

    public final FormatLiveRoom.SliceItemInfo getSliceData() {
        return this.sliceData;
    }

    public final FormatLiveRoom.UserData getUserData() {
        return this.userData;
    }

    public final void setChatHistory(HistoryChatData r100) {
        this.chatHistory = r100;
    }

    public final void setCurrentCarouselComponentInfo(m r100) {
        this.currentCarouselComponentInfo = r100;
    }

    public final void setCurrentInteractiveSug(LiveMsgSugResp r100) {
        this.currentInteractiveSug = r100;
    }

    public final void setCurrentProductCard(ProductCard r100) {
        this.currentProductCard = r100;
    }

    public final void setExtra(Map<String, String> r100) {
        this.extra = r100;
    }

    public final void setPlayModeStatus(int r100) {
        this.playModeStatus = r100;
    }

    public final void setSliceData(FormatLiveRoom.SliceItemInfo r100) {
        this.sliceData = r100;
    }

    public final void setUserData(FormatLiveRoom.UserData r100) {
        this.userData = r100;
    }
}
