package com.zyql.ai.selector.style;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class PictureCropParameterStyle implements Parcelable {
    public static final Parcelable.Creator<PictureCropParameterStyle> CREATOR = new Parcelable.Creator<PictureCropParameterStyle>() { // from class: com.zyql.ai.selector.style.PictureCropParameterStyle.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PictureCropParameterStyle createFromParcel(Parcel parcel) {
            return new PictureCropParameterStyle(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PictureCropParameterStyle[] newArray(int i10) {
            return new PictureCropParameterStyle[i10];
        }
    };
    public int cropNavBarColor;
    public int cropStatusBarColorPrimaryDark;
    public int cropTitleBarBackgroundColor;
    public int cropTitleColor;
    public boolean isChangeStatusBarFontColor;

    public PictureCropParameterStyle() {
    }

    public static PictureCropParameterStyle ofDefaultCropStyle() {
        return new PictureCropParameterStyle(Color.parseColor("#393a3e"), Color.parseColor("#393a3e"), Color.parseColor("#393a3e"), Color.parseColor("#FFFFFF"), false);
    }

    public static PictureCropParameterStyle ofNewStyle() {
        return new PictureCropParameterStyle(Color.parseColor("#393a3e"), Color.parseColor("#393a3e"), Color.parseColor("#393a3e"), Color.parseColor("#FFFFFF"), false);
    }

    public static PictureCropParameterStyle ofSelectNumberStyle() {
        return new PictureCropParameterStyle(Color.parseColor("#7D7DFF"), Color.parseColor("#7D7DFF"), Color.parseColor("#FFFFFF"), false);
    }

    public static PictureCropParameterStyle ofSelectTotalStyle() {
        return new PictureCropParameterStyle(Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF"), Color.parseColor("#000000"), true);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeByte(this.isChangeStatusBarFontColor ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.cropTitleBarBackgroundColor);
        parcel.writeInt(this.cropStatusBarColorPrimaryDark);
        parcel.writeInt(this.cropTitleColor);
        parcel.writeInt(this.cropNavBarColor);
    }

    public PictureCropParameterStyle(int i10, int i11, int i12, boolean z10) {
        this.cropTitleBarBackgroundColor = i10;
        this.cropStatusBarColorPrimaryDark = i11;
        this.cropTitleColor = i12;
        this.isChangeStatusBarFontColor = z10;
    }

    public PictureCropParameterStyle(int i10, int i11, int i12, int i13, boolean z10) {
        this.cropTitleBarBackgroundColor = i10;
        this.cropNavBarColor = i12;
        this.cropStatusBarColorPrimaryDark = i11;
        this.cropTitleColor = i13;
        this.isChangeStatusBarFontColor = z10;
    }

    public PictureCropParameterStyle(Parcel parcel) {
        this.isChangeStatusBarFontColor = parcel.readByte() != 0;
        this.cropTitleBarBackgroundColor = parcel.readInt();
        this.cropStatusBarColorPrimaryDark = parcel.readInt();
        this.cropTitleColor = parcel.readInt();
        this.cropNavBarColor = parcel.readInt();
    }
}
