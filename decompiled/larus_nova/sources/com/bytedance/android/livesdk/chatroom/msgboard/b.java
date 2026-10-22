package com.bytedance.android.livesdk.chatroom.msgboard;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R*\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/msgboard/b;", "", "", "bannerHasPaid", "Z", "getBannerHasPaid", "()Z", "setBannerHasPaid", "(Z)V", "", "ticketPurchaseSchema", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setTicketPurchaseSchema", "(Ljava/lang/String;)V", "badgeTextConfig", "getBadgeTextConfig", "setBadgeTextConfig", "Lcom/bytedance/android/livesdk/chatroom/msgboard/DressListTextConfig;", "dressListText", "Lcom/bytedance/android/livesdk/chatroom/msgboard/DressListTextConfig;", "b", "()Lcom/bytedance/android/livesdk/chatroom/msgboard/DressListTextConfig;", "setDressListText", "(Lcom/bytedance/android/livesdk/chatroom/msgboard/DressListTextConfig;)V", "", "Lcom/bytedance/android/livesdk/chatroom/msgboard/VSMsgBoardDress;", "skinInfo", "Ljava/util/List;", "c", "()Ljava/util/List;", "setSkinInfo", "(Ljava/util/List;)V", "badgeInfo", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setBadgeInfo", "<init>", "()V", "vs-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("badge_info")
    private List<VSMsgBoardDress> badgeInfo;

    @SerializedName("badge_text_config")
    private String badgeTextConfig;

    @SerializedName("banner_has_paid")
    private boolean bannerHasPaid;

    @SerializedName("dress_list_text")
    private DressListTextConfig dressListText;

    @SerializedName("cover_info")
    private List<VSMsgBoardDress> skinInfo;

    @SerializedName("ticket_purchase_schema")
    private String ticketPurchaseSchema;

    public b() {
        this.ticketPurchaseSchema = "";
        this.badgeTextConfig = "";
    }

    public final List<VSMsgBoardDress> a() {
        return this.badgeInfo;
    }

    public final DressListTextConfig b() {
        return this.dressListText;
    }

    public final List<VSMsgBoardDress> c() {
        return this.skinInfo;
    }

    public final String d() {
        return this.ticketPurchaseSchema;
    }
}
