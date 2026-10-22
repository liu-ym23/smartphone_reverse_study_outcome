package com.bytedance.android.livesdk.schema.model;

import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/schema/model/FriendRoomSchemaModel;", "Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;", "roomId", "", "enterFromMerge", "enterMethod", "enterFrom", "invitorUserId", "userId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEnterFrom", "()Ljava/lang/String;", "getEnterFromMerge", "getEnterMethod", "getInvitorUserId", "getRoomId", "getUserId", "getSchemaHost", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FriendRoomSchemaModel extends BaseSchemaModel {

    @SerializedName("enter_from")
    private final String enterFrom;

    @SerializedName("enter_from_merge")
    private final String enterFromMerge;

    @SerializedName("enter_method")
    private final String enterMethod;

    @SerializedName("invitor_user_id")
    private final String invitorUserId;

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName("user_id")
    private final String userId;

    @Override // com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel
    public String getSchemaHost() {
        return "webcast_friend_room";
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterFromMerge() {
        return this.enterFromMerge;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getInvitorUserId() {
        return this.invitorUserId;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public FriendRoomSchemaModel(String r100, String r101, String r102, String r103, String r104, String r105) {
        this.roomId = r100;
        this.enterFromMerge = r101;
        this.enterMethod = r102;
        this.enterFrom = r103;
        this.invitorUserId = r104;
        this.userId = r105;
    }
}
