package com.android.internal.policy;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class StepOSColorBarInfo implements Parcelable {
    public static final Parcelable.Creator<StepOSColorBarInfo> CREATOR = new Parcelable.Creator<StepOSColorBarInfo>() { // from class: com.android.internal.policy.StepOSColorBarInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSColorBarInfo createFromParcel(Parcel in) {
            return new StepOSColorBarInfo(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StepOSColorBarInfo[] newArray(int size) {
            return new StepOSColorBarInfo[size];
        }
    };
    public String className;
    public Integer colorNavBarDark;
    public Integer colorNavBarLight;
    public boolean defOnly;
    public boolean fakeDarkMode;
    public boolean fitsNavBar;
    public int statusBarColor;
    public boolean windowDraw;

    public StepOSColorBarInfo() {
    }

    public StepOSColorBarInfo(Parcel source) {
        this.defOnly = source.readBoolean();
        this.windowDraw = source.readBoolean();
        this.colorNavBarLight = (Integer) source.readValue(null);
        this.colorNavBarDark = (Integer) source.readValue(null);
        this.statusBarColor = source.readInt();
        this.className = source.readString();
        this.fakeDarkMode = source.readBoolean();
        this.fitsNavBar = source.readBoolean();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeBoolean(this.defOnly);
        dest.writeBoolean(this.windowDraw);
        dest.writeValue(this.colorNavBarLight);
        dest.writeValue(this.colorNavBarDark);
        dest.writeInt(this.statusBarColor);
        dest.writeString(this.className);
        dest.writeBoolean(this.fakeDarkMode);
        dest.writeBoolean(this.fitsNavBar);
    }
}
