package com.bytedance.android.live.openplatform.api.model.shelf;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.data.ProductLabelInfo")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\bR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductLabelInfo;", "Landroid/os/Parcelable;", "", "Lcom/bytedance/android/live/base/model/ImageModel;", "leftIconList", "Ljava/util/List;", "", "leftText", "Ljava/lang/String;", "rightText", "", "fontSize", "I", "fontColor", "borderColor", "", "dividingLine", "Z", "labelType", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductLabelInfo implements Parcelable, h {
    public static final Parcelable.Creator<ProductLabelInfo> CREATOR = null;

    @SerializedName("border_color")
    public String borderColor;

    @SerializedName("dividing_line")
    public boolean dividingLine;

    @SerializedName("font_color")
    public String fontColor;

    @SerializedName("font_size")
    public int fontSize;

    @SerializedName("label_type")
    public int labelType;

    @SerializedName("left_icon_list")
    public List<ImageModel> leftIconList;

    @SerializedName("left_text")
    public String leftText;

    @SerializedName("right_text")
    public String rightText;

    public static class a implements Parcelable.Creator<ProductLabelInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ProductLabelInfo createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "in");
            if (r110.readInt() == 0) goto L7;
            int r100 = r110.readInt();
            ArrayList r101 = new ArrayList(r100);
        L5:
            if (r100 == 0) goto L8;
            r101.add((ImageModel) r110.readParcelable(ProductLabelInfo.class.getClassLoader()));
            r100 = r100 - 1;
        L8:
            String r102 = r110.readString();
            String r103 = r110.readString();
            int r104 = r110.readInt();
            String r105 = r110.readString();
            String r106 = r110.readString();
            if (r110.readInt() == 0) goto L11;
            boolean r107 = true;
        L13:
            return new ProductLabelInfo(r101, r102, r103, r104, r105, r106, r107, r110.readInt());
        L11:
            r107 = false;
            goto L13
        L7:
            r101 = null;
            goto L8
        }

        @Override // android.os.Parcelable.Creator
        public final ProductLabelInfo[] newArray(int r100) {
            return new ProductLabelInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProductLabelInfo(List<? extends ImageModel> r100, String r101, String r102, int r103, String r104, String r105, boolean r106, int r107) {
        this.leftIconList = r100;
        this.leftText = r101;
        this.rightText = r102;
        this.fontSize = r103;
        this.fontColor = r104;
        this.borderColor = r105;
        this.dividingLine = r106;
        this.labelType = r107;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ProductLabelInfo) == false) goto L22;
        ProductLabelInfo r101 = (ProductLabelInfo) r100;
        if (Intrinsics.areEqual(this.leftIconList, r101.leftIconList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.leftText, r101.leftText) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.rightText, r101.rightText) == true) goto L12;
        return false;
    L12:
        if (this.fontSize == r101.fontSize) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.fontColor, r101.fontColor) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.borderColor, r101.borderColor) == true) goto L18;
        return false;
    L18:
        if (this.dividingLine == r101.dividingLine) goto L20;
        return false;
    L20:
        if (this.labelType == r101.labelType) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        List<ImageModel> r100 = this.leftIconList;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.leftText;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.rightText;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((r106 + r108) * 31) + this.fontSize) * 31;
        String r110 = this.fontColor;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.borderColor;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        int r114 = (r112 + r101) * 31;
        boolean r115 = this.dividingLine;
        ?? r116 = r115;
        if (r115 == false) goto L25;
        r116 = 1;
    L25:
        return ((r114 + r116) * 31) + this.labelType;
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

    public final String toString() {
        return "ProductLabelInfo(leftIconList=" + this.leftIconList + ", leftText=" + this.leftText + ", rightText=" + this.rightText + ", fontSize=" + this.fontSize + ", fontColor=" + this.fontColor + ", borderColor=" + this.borderColor + ", dividingLine=" + this.dividingLine + ", labelType=" + this.labelType + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        List<ImageModel> r102 = this.leftIconList;
        if (r102 == null) goto L8;
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<ImageModel> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L9;
        r100.writeParcelable(r103.next(), r101);
    L9:
        r100.writeString(this.leftText);
        r100.writeString(this.rightText);
        r100.writeInt(this.fontSize);
        r100.writeString(this.fontColor);
        r100.writeString(this.borderColor);
        r100.writeInt(this.dividingLine ? 1 : 0);
        r100.writeInt(this.labelType);
        return;
    L8:
        r100.writeInt(0);
        goto L9
    }

    public ProductLabelInfo() {
        this.leftIconList = null;
        this.leftText = null;
        this.rightText = null;
        this.fontSize = 0;
        this.fontColor = null;
        this.borderColor = null;
        this.dividingLine = false;
        this.labelType = 0;
    }

    public ProductLabelInfo(am3.g r100) {
        this.leftIconList = new ArrayList();
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        switch(r103) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        this.leftIconList.add(x.a(r100));
        goto L3
    L8:
        this.labelType = r100.i();
        r102 = r102 | 4;
        goto L3
    L9:
        this.dividingLine = am3.h.a(r100);
        r102 = r102 | 2;
        goto L3
    L10:
        this.borderColor = am3.h.c(r100);
        goto L3
    L11:
        this.fontColor = am3.h.c(r100);
        goto L3
    L12:
        this.fontSize = r100.i();
        r102 = r102 | 1;
        goto L3
    L13:
        this.rightText = am3.h.c(r100);
        goto L3
    L14:
        this.leftText = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.leftIconList.isEmpty() == false) goto L19;
        this.leftIconList = null;
    L19:
        if (this.leftText != null) goto L22;
        this.leftText = null;
    L22:
        if (this.rightText != null) goto L25;
        this.rightText = null;
    L25:
        if ((r102 & 1) != 0) goto L28;
        this.fontSize = 0;
    L28:
        if (this.fontColor != null) goto L31;
        this.fontColor = null;
    L31:
        if (this.borderColor != null) goto L34;
        this.borderColor = null;
    L34:
        if ((r102 & 2) != 0) goto L37;
        this.dividingLine = false;
    L37:
        if ((r102 & 4) != 0) goto L60;
        this.labelType = 0;
        return;
    }
}
