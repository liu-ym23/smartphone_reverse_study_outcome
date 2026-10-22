package com.mdisdk.capability.model;

import android.graphics.Region;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.appfunctions.metadata.a;

/* loaded from: classes3.dex */
public class WindowStateInfo implements Parcelable {
    public static final Parcelable.Creator<WindowStateInfo> CREATOR = new Parcelable.Creator<WindowStateInfo>() { // from class: com.mdisdk.capability.model.WindowStateInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WindowStateInfo createFromParcel(Parcel parcel) {
            return new WindowStateInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WindowStateInfo[] newArray(int i) {
            return new WindowStateInfo[i];
        }
    };
    public static final String KEY_DISPLAY_ID = "displayId";
    public static final String KEY_LAYER = "layer";
    public static final String KEY_TOUCH_REGION = "touchRegion";
    public static final String KEY_TYPE = "type";
    public static final String KEY_WIN_ACTIVITY = "win_activity";
    public static final String KEY_WIN_MODE = "winMode";
    public static final String KEY_WIN_PACKAGE = "win_package";
    public static final String KEY_WIN_TITLE = "winTitle";
    public static final String VISIBLE_WINDOWS = "visible_windows";

    @Nullable
    private final String activityClassName;
    private final boolean isFocused;
    private final String packageName;

    @Nullable
    private final ViewNode rootNode;

    @Nullable
    private final Region touchRegion;
    private final String windowTitle;

    @WindowTypeValue
    private final int windowType;
    private final int windowingMode;

    public WindowStateInfo(String str, @Nullable String str2, String str3, @WindowTypeValue int i, int i6, @Nullable Region region, boolean z10, @Nullable ViewNode viewNode) {
        this.packageName = str;
        this.activityClassName = str2;
        this.windowTitle = str3;
        this.windowType = i;
        this.windowingMode = i6;
        this.touchRegion = region;
        this.isFocused = z10;
        this.rootNode = viewNode;
    }

    public static WindowStateInfo fromBundle(String str, @Nullable String str2, @Nullable Bundle bundle) {
        if (bundle == null) {
            return new WindowStateInfo(str, str2, "Untitled", 2, 0, null);
        }
        int i = bundle.getInt(KEY_WIN_MODE, 0);
        CharSequence charSequence = bundle.getCharSequence(KEY_WIN_TITLE);
        String string = charSequence != null ? charSequence.toString() : "";
        return new WindowStateInfo(str, (!TextUtils.isEmpty(str2) || TextUtils.isEmpty(string)) ? str2 : string, string, bundle.getInt("type", 0), i, (Region) bundle.getParcelable(KEY_TOUCH_REGION));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public String getActivityClassName() {
        return this.activityClassName;
    }

    public String getPackageName() {
        return this.packageName;
    }

    @Nullable
    public ViewNode getRootNode() {
        return this.rootNode;
    }

    @Nullable
    public Region getTouchRegion() {
        return this.touchRegion;
    }

    public String getWindowTitle() {
        return this.windowTitle;
    }

    public int getWindowType() {
        return this.windowType;
    }

    public int getWindowingMode() {
        return this.windowingMode;
    }

    public boolean isFocused() {
        return this.isFocused;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("WindowStateInfo{packageName='");
        sb.append(this.packageName);
        sb.append("', activityClassName='");
        sb.append(this.activityClassName);
        sb.append("', windowTitle='");
        sb.append(this.windowTitle);
        sb.append("', windowType=");
        sb.append(this.windowType);
        sb.append(", windowingMode=");
        sb.append(this.windowingMode);
        sb.append(", isFocused=");
        sb.append(this.isFocused);
        sb.append(", hasRootNode=");
        return a.r(sb, this.rootNode != null, '}');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.packageName);
        parcel.writeString(this.activityClassName);
        parcel.writeString(this.windowTitle);
        parcel.writeInt(this.windowType);
        parcel.writeInt(this.windowingMode);
        parcel.writeParcelable(this.touchRegion, i);
        parcel.writeByte(this.isFocused ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.rootNode, i);
    }

    public WindowStateInfo(String str, @Nullable String str2, String str3, @WindowTypeValue int i, int i6, @Nullable Region region) {
        this(str, str2, str3, i, i6, region, false, null);
    }

    public WindowStateInfo(Parcel parcel) {
        this.packageName = parcel.readString();
        this.activityClassName = parcel.readString();
        this.windowTitle = parcel.readString();
        this.windowType = parcel.readInt();
        this.windowingMode = parcel.readInt();
        this.touchRegion = (Region) parcel.readParcelable(Region.class.getClassLoader());
        this.isFocused = parcel.readByte() != 0;
        this.rootNode = (ViewNode) parcel.readParcelable(ViewNode.class.getClassLoader());
    }
}
