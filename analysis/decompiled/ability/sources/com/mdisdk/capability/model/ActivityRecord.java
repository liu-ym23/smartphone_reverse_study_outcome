package com.mdisdk.capability.model;

import B7.a;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public class ActivityRecord implements Parcelable {
    public static final Parcelable.Creator<ActivityRecord> CREATOR = new Parcelable.Creator<ActivityRecord>() { // from class: com.mdisdk.capability.model.ActivityRecord.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityRecord createFromParcel(Parcel parcel) {
            return new ActivityRecord(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityRecord[] newArray(int i) {
            return new ActivityRecord[i];
        }
    };
    private final String className;
    private final int displayId;
    private final String packageName;
    private final int windowingMode;

    public ActivityRecord(String str, String str2, int i, int i6) {
        this.packageName = str == null ? "" : str;
        this.className = str2 == null ? "" : str2;
        this.displayId = i;
        this.windowingMode = i6;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ActivityRecord activityRecord = (ActivityRecord) obj;
            if (this.displayId == activityRecord.displayId && this.packageName.equals(activityRecord.packageName) && this.className.equals(activityRecord.className)) {
                return true;
            }
        }
        return false;
    }

    public String getClassName() {
        return this.className;
    }

    public int getDisplayId() {
        return this.displayId;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getWindowingMode() {
        return this.windowingMode;
    }

    public int hashCode() {
        return a.c(this.packageName.hashCode() * 31, 31, this.className) + this.displayId;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ActivityRecord{packageName='");
        sb.append(this.packageName);
        sb.append("', className='");
        sb.append(this.className);
        sb.append("', displayId=");
        sb.append(this.displayId);
        sb.append(", windowingMode=");
        return a.o(sb, this.windowingMode, '}');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.packageName);
        parcel.writeString(this.className);
        parcel.writeInt(this.displayId);
        parcel.writeInt(this.windowingMode);
    }

    public ActivityRecord(String str, String str2, @Nullable Bundle bundle) {
        this.packageName = str == null ? "" : str;
        this.className = str2 == null ? "" : str2;
        if (bundle != null) {
            this.displayId = bundle.getInt(WindowStateInfo.KEY_DISPLAY_ID, 0);
            this.windowingMode = bundle.getInt(WindowStateInfo.KEY_WIN_MODE, 0);
        } else {
            this.displayId = 0;
            this.windowingMode = 0;
        }
    }

    public ActivityRecord(@Nullable Bundle bundle) {
        if (bundle != null) {
            this.packageName = bundle.getString(WindowStateInfo.KEY_WIN_PACKAGE, "");
            this.className = bundle.getString(WindowStateInfo.KEY_WIN_ACTIVITY, "");
            this.displayId = bundle.getInt(WindowStateInfo.KEY_DISPLAY_ID, 0);
            this.windowingMode = bundle.getInt(WindowStateInfo.KEY_WIN_MODE, 0);
            return;
        }
        this.packageName = "";
        this.className = "";
        this.displayId = 0;
        this.windowingMode = 0;
    }

    public ActivityRecord(WindowStateInfo windowStateInfo) {
        this.packageName = windowStateInfo.getPackageName();
        this.className = windowStateInfo.getActivityClassName() != null ? windowStateInfo.getActivityClassName() : "";
        this.displayId = 0;
        this.windowingMode = windowStateInfo.getWindowingMode();
    }

    public ActivityRecord(Parcel parcel) {
        this.packageName = parcel.readString();
        this.className = parcel.readString();
        this.displayId = parcel.readInt();
        this.windowingMode = parcel.readInt();
    }
}
