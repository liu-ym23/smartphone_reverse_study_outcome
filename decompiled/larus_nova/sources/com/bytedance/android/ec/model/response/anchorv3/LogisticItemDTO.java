package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJJ\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0007HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f¨\u0006!"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/LogisticItemDTO;", "Ljava/io/Serializable;", "itemType", "", "pic", "Lcom/bytedance/android/ec/model/ECUrlModel;", "text", "", "fontColor", "fontType", "(Ljava/lang/Integer;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getFontColor", "()Ljava/lang/String;", "getFontType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getItemType", "getPic", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getText", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/android/ec/model/response/anchorv3/LogisticItemDTO;", "equals", "", "other", "", "hashCode", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class LogisticItemDTO implements Serializable {

    @SerializedName("font_color")
    private final String fontColor;

    @SerializedName("font_type")
    private final Integer fontType;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
    private final Integer itemType;

    /* JADX INFO: renamed from: pic, reason: collision with root package name */
    @SerializedName("pic")
    private final ECUrlModel f47932pic;

    @SerializedName("text")
    private final String text;

    public LogisticItemDTO() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ LogisticItemDTO copy$default(LogisticItemDTO r100, Integer r101, ECUrlModel r102, String r103, String r104, Integer r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.itemType;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.f47932pic;
    L8:
        ECUrlModel r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.text;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.fontColor;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.fontType;
    L17:
        Integer r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Integer component1() {
        return this.itemType;
    }

    public final ECUrlModel component2() {
        return this.f47932pic;
    }

    public final String component3() {
        return this.text;
    }

    public final String component4() {
        return this.fontColor;
    }

    public final Integer component5() {
        return this.fontType;
    }

    public final LogisticItemDTO copy(Integer r100, ECUrlModel r101, String r110, String r111, Integer r112) {
        return new LogisticItemDTO(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LogisticItemDTO) == false) goto L16;
        LogisticItemDTO r101 = (LogisticItemDTO) r100;
        if (Intrinsics.areEqual(this.itemType, r101.itemType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f47932pic, r101.f47932pic) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fontColor, r101.fontColor) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.fontType, r101.fontType) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        Integer r100 = this.itemType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECUrlModel r104 = this.f47932pic;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.text;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.fontColor;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.fontType;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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
        return "LogisticItemDTO(itemType=" + this.itemType + ", pic=" + this.f47932pic + ", text=" + this.text + ", fontColor=" + this.fontColor + ", fontType=" + this.fontType + ")";
    }

    public final String getFontColor() {
        return this.fontColor;
    }

    public final Integer getFontType() {
        return this.fontType;
    }

    public final Integer getItemType() {
        return this.itemType;
    }

    public final ECUrlModel getPic() {
        return this.f47932pic;
    }

    public final String getText() {
        return this.text;
    }

    public LogisticItemDTO(Integer r100, ECUrlModel r101, String r102, String r103, Integer r104) {
        this.itemType = r100;
        this.f47932pic = r101;
        this.text = r102;
        this.fontColor = r103;
        this.fontType = r104;
    }

    public /* synthetic */ LogisticItemDTO(Integer r100, ECUrlModel r101, String r102, String r103, Integer r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        Integer r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        ECUrlModel r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        Integer r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
