package com.bytedance.android.livehostapi.business.depend.livead.model;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR \u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/model/CardRemoveRequest;", "", "()V", "cardId", "", "getCardId", "()Ljava/lang/String;", "setCardId", "(Ljava/lang/String;)V", WikiFolderPushPlugin.OPT, "", "getOperation", "()Ljava/lang/Integer;", "setOperation", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "roomId", "getRoomId", "setRoomId", "secUid", "getSecUid", "setSecUid", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardRemoveRequest {

    @SerializedName("card_id")
    private String cardId;

    @SerializedName(WikiFolderPushPlugin.OPT)
    private Integer operation;

    @SerializedName("room_id")
    private String roomId;

    @SerializedName("sec_uid")
    private String secUid;

    public CardRemoveRequest() {
    }

    public final String getCardId() {
        return this.cardId;
    }

    public final Integer getOperation() {
        return this.operation;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getSecUid() {
        return this.secUid;
    }

    public final void setCardId(String r100) {
        this.cardId = r100;
    }

    public final void setOperation(Integer r100) {
        this.operation = r100;
    }

    public final void setRoomId(String r100) {
        this.roomId = r100;
    }

    public final void setSecUid(String r100) {
        this.secUid = r100;
    }
}
