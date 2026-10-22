package com.bytedance.android.live.openplatform.api.model.shelf;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.data.ProductIntroductionInfo")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductIntroductionInfo;", "Landroid/os/Parcelable;", "", "content", "Ljava/lang/String;", "", "fontSize", "I", "fontColor", "introductionType", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductIntroductionInfo implements Parcelable, h {
    public static final Parcelable.Creator<ProductIntroductionInfo> CREATOR = null;

    @SerializedName("content")
    public String content;

    @SerializedName("font_color")
    public String fontColor;

    @SerializedName("font_size")
    public int fontSize;

    @SerializedName("introduction_type")
    public int introductionType;

    public static class a implements Parcelable.Creator<ProductIntroductionInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ProductIntroductionInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            return new ProductIntroductionInfo(r100.readString(), r100.readInt(), r100.readString(), r100.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final ProductIntroductionInfo[] newArray(int r100) {
            return new ProductIntroductionInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ProductIntroductionInfo(String r100, int r101, String r102, int r103) {
        this.content = r100;
        this.fontSize = r101;
        this.fontColor = r102;
        this.introductionType = r103;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ProductIntroductionInfo) == false) goto L14;
        ProductIntroductionInfo r101 = (ProductIntroductionInfo) r100;
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L8;
        return false;
    L8:
        if (this.fontSize == r101.fontSize) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.fontColor, r101.fontColor) == true) goto L12;
        return false;
    L12:
        if (this.introductionType == r101.introductionType) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.content;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.fontSize) * 31;
        String r104 = this.fontColor;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return ((r103 + r101) * 31) + this.introductionType;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ProductIntroductionInfo(content=" + this.content + ", fontSize=" + this.fontSize + ", fontColor=" + this.fontColor + ", introductionType=" + this.introductionType + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.content);
        r100.writeInt(this.fontSize);
        r100.writeString(this.fontColor);
        r100.writeInt(this.introductionType);
    }

    public ProductIntroductionInfo() {
        this.content = null;
        this.fontSize = 0;
        this.fontColor = null;
        this.introductionType = 0;
    }

    public ProductIntroductionInfo(am3.g r100) {
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L17;
        if (r103 != 1) goto L7;
        this.content = am3.h.c(r100);
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this.fontSize = r100.i();
        r102 = r102 | 1;
        goto L3
    L9:
        if (r103 != 3) goto L11;
        this.fontColor = am3.h.c(r100);
        goto L3
    L11:
        if (r103 != 4) goto L12;
        this.introductionType = r100.i();
        r102 = r102 | 2;
        goto L3
    L12:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
        if (this.content != null) goto L21;
        this.content = null;
    L21:
        if ((r102 & 1) != 0) goto L24;
        this.fontSize = 0;
    L24:
        if (this.fontColor != null) goto L27;
        this.fontColor = null;
    L27:
        if ((r102 & 2) != 0) goto L45;
        this.introductionType = 0;
        return;
    }
}
