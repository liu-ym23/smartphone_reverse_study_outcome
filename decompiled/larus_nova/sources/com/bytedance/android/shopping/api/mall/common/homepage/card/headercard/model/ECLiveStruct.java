package com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model;

import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JV\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECLiveStruct;", "", "roomId", "", "streamData", "uid", "title", "status", "", "wysiwygParam", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getRoomId", "()Ljava/lang/String;", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStreamData", "getTitle", "getUid", "getWysiwygParam", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECLiveStruct;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLiveStruct {

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName("status")
    private final Integer status;

    @SerializedName(MiniAppConstants.KEY_MINI_APP_STREAM_DATA)
    private final String streamData;

    @SerializedName("title")
    private final String title;

    @SerializedName("uid")
    private final String uid;

    @SerializedName("wysiwyg_param")
    private final String wysiwygParam;

    public ECLiveStruct() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ ECLiveStruct copy$default(ECLiveStruct r100, String r101, String r102, String r103, String r104, Integer r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.roomId;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.streamData;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.uid;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.title;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.status;
    L17:
        Integer r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.wysiwygParam;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.roomId;
    }

    public final String component2() {
        return this.streamData;
    }

    public final String component3() {
        return this.uid;
    }

    public final String component4() {
        return this.title;
    }

    public final Integer component5() {
        return this.status;
    }

    public final String component6() {
        return this.wysiwygParam;
    }

    public final ECLiveStruct copy(String r100, String r110, String r111, String r112, Integer r113, String r114) {
        return new ECLiveStruct(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECLiveStruct) == false) goto L18;
        ECLiveStruct r101 = (ECLiveStruct) r100;
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.streamData, r101.streamData) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.uid, r101.uid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.wysiwygParam, r101.wysiwygParam) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        String r100 = this.roomId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.streamData;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.uid;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.title;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.status;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.wysiwygParam;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ECLiveStruct(roomId=" + this.roomId + ", streamData=" + this.streamData + ", uid=" + this.uid + ", title=" + this.title + ", status=" + this.status + ", wysiwygParam=" + this.wysiwygParam + ")";
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final String getStreamData() {
        return this.streamData;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUid() {
        return this.uid;
    }

    public final String getWysiwygParam() {
        return this.wysiwygParam;
    }

    public ECLiveStruct(String r100, String r101, String r102, String r103, Integer r104, String r105) {
        this.roomId = r100;
        this.streamData = r101;
        this.uid = r102;
        this.title = r103;
        this.status = r104;
        this.wysiwygParam = r105;
    }

    public /* synthetic */ ECLiveStruct(String r100, String r101, String r102, String r103, Integer r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        String r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        Integer r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        String r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
