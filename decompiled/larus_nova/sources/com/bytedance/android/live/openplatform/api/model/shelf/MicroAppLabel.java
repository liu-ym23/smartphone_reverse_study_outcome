package com.bytedance.android.live.openplatform.api.model.shelf;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.data.MicroAppLabel")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/shelf/MicroAppLabel;", "Landroid/os/Parcelable;", "", "name", "Ljava/lang/String;", "", "fontSize", "I", "fontColor", "backgroundBeginColor", "backgroundEndColor", "url", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MicroAppLabel implements Parcelable, h {
    public static final Parcelable.Creator<MicroAppLabel> CREATOR = null;

    @SerializedName("background_begin_color")
    public String backgroundBeginColor;

    @SerializedName("background_end_color")
    public String backgroundEndColor;

    @SerializedName("font_color")
    public String fontColor;

    @SerializedName("font_size")
    public int fontSize;

    @SerializedName("name")
    public String name;

    @SerializedName("url")
    public String url;

    public static class a implements Parcelable.Creator<MicroAppLabel> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MicroAppLabel createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            return new MicroAppLabel(r100.readString(), r100.readInt(), r100.readString(), r100.readString(), r100.readString(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final MicroAppLabel[] newArray(int r100) {
            return new MicroAppLabel[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public MicroAppLabel(String r100, int r101, String r102, String r103, String r104, String r105) {
        this.name = r100;
        this.fontSize = r101;
        this.fontColor = r102;
        this.backgroundBeginColor = r103;
        this.backgroundEndColor = r104;
        this.url = r105;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof MicroAppLabel) == false) goto L18;
        MicroAppLabel r101 = (MicroAppLabel) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L8;
        return false;
    L8:
        if (this.fontSize == r101.fontSize) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.fontColor, r101.fontColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.backgroundBeginColor, r101.backgroundBeginColor) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.backgroundEndColor, r101.backgroundEndColor) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.fontSize) * 31;
        String r104 = this.fontColor;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.backgroundBeginColor;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.backgroundEndColor;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.url;
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

    public final String toString() {
        return "MicroAppLabel(name=" + this.name + ", fontSize=" + this.fontSize + ", fontColor=" + this.fontColor + ", backgroundBeginColor=" + this.backgroundBeginColor + ", backgroundEndColor=" + this.backgroundEndColor + ", url=" + this.url + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.name);
        r100.writeInt(this.fontSize);
        r100.writeString(this.fontColor);
        r100.writeString(this.backgroundBeginColor);
        r100.writeString(this.backgroundEndColor);
        r100.writeString(this.url);
    }

    public MicroAppLabel() {
        this.name = null;
        this.fontSize = 0;
        this.fontColor = null;
        this.backgroundBeginColor = null;
        this.backgroundEndColor = null;
        this.url = null;
    }

    public MicroAppLabel(am3.g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L13;
        switch(r103) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.url = am3.h.c(r100);
        goto L3
    L8:
        this.backgroundEndColor = am3.h.c(r100);
        goto L3
    L9:
        this.backgroundBeginColor = am3.h.c(r100);
        goto L3
    L10:
        this.fontColor = am3.h.c(r100);
        goto L3
    L11:
        this.fontSize = r100.i();
        r102 = r102 | true;
        goto L3
    L12:
        this.name = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
        if (this.name != null) goto L17;
        this.name = null;
    L17:
        if ((r102 & true) == true) goto L20;
        this.fontSize = 0;
    L20:
        if (this.fontColor != null) goto L23;
        this.fontColor = null;
    L23:
        if (this.backgroundBeginColor != null) goto L26;
        this.backgroundBeginColor = null;
    L26:
        if (this.backgroundEndColor != null) goto L29;
        this.backgroundEndColor = null;
    L29:
        if (this.url != null) goto L48;
        this.url = null;
        return;
    }
}
