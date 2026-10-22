package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/c0;", "", "", com.bytedance.android.livesdk.gift.model.n.KEY_MAIN_TEXT, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "roomList", "Ljava/util/List;", "c", "()Ljava/util/List;", "insertAnchorId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "room_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c0 {

    @SerializedName("insert_anchor_id")
    private final String insertAnchorId;

    @SerializedName("main_text")
    private final String mainText;

    @SerializedName("room_list")
    private final List<Room> roomList;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c0) == false) goto L12;
        c0 r101 = (c0) r100;
        if (Intrinsics.areEqual(this.mainText, r101.mainText) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.roomList, r101.roomList) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.insertAnchorId, r101.insertAnchorId) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.mainText;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<Room> r104 = this.roomList;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.insertAnchorId;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "EndPageTabliveResponse(mainText=" + this.mainText + ", roomList=" + this.roomList + ", insertAnchorId=" + this.insertAnchorId + ")";
    }

    public c0() {
        this.mainText = null;
        this.roomList = null;
        this.insertAnchorId = null;
    }

    public final String a() {
        return this.insertAnchorId;
    }

    public final String b() {
        return this.mainText;
    }

    public final List<Room> c() {
        return this.roomList;
    }
}
