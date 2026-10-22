package com.mdisdk.capability.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public class RequestInfo implements Parcelable {
    public static final Parcelable.Creator<RequestInfo> CREATOR = new Parcelable.Creator<RequestInfo>() { // from class: com.mdisdk.capability.model.RequestInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RequestInfo createFromParcel(Parcel parcel) {
            return new RequestInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RequestInfo[] newArray(int i) {
            return new RequestInfo[i];
        }
    };
    public static final String FUNCTION_CLICK = "click";
    public static final String FUNCTION_DOUBLE_CLICK = "doubleClick";
    public static final String FUNCTION_LONG_CLICK = "longClick";
    public static final String FUNCTION_REPLACE_TEXT = "replaceText";
    public static final String FUNCTION_REPLACE_TEXT_BY_CODE_POINT = "replaceTextByCodePoint";
    public static final String FUNCTION_SCROLL_DOWN = "scrollDown";
    public static final String FUNCTION_SCROLL_LEFT = "scrollLeft";
    public static final String FUNCTION_SCROLL_RIGHT = "scrollRight";
    public static final String FUNCTION_SCROLL_UP = "scrollUp";
    public static final String FUNCTION_SET_TEXT = "setText";
    public static final String FUNCTION_SNAPSHOT = "snapshot";
    public static final String FUNCTION_SWIPE = "swipe";

    @Nullable
    private final ActionExtra actionExtra;

    @Nullable
    private final String activityClassName;

    @Nullable
    private final String activityClassNameContains;

    @Nullable
    private final Integer displayId;
    private final String function;

    @Nullable
    private final String packageName;
    private final long requestId;

    @Nullable
    private final String windowTitle;

    @Nullable
    private final String windowTitleContains;

    public static class Builder {
        private ActionExtra actionExtra;
        private String activityClassName;
        private String activityClassNameContains;
        private Integer displayId;
        private String function = RequestInfo.FUNCTION_SNAPSHOT;
        private String packageName;
        private long requestId;
        private String windowTitle;
        private String windowTitleContains;

        public Builder actionExtra(ActionExtra actionExtra) {
            this.actionExtra = actionExtra;
            return this;
        }

        public Builder activityClassName(String str) {
            this.activityClassName = str;
            return this;
        }

        public Builder activityClassNameContains(String str) {
            this.activityClassNameContains = str;
            return this;
        }

        public RequestInfo build() {
            return new RequestInfo(this);
        }

        public Builder displayId(Integer num) {
            this.displayId = num;
            return this;
        }

        public Builder function(String str) {
            this.function = str;
            return this;
        }

        public Builder packageName(String str) {
            this.packageName = str;
            return this;
        }

        public Builder requestId(long j5) {
            this.requestId = j5;
            return this;
        }

        public Builder windowTitle(String str) {
            this.windowTitle = str;
            return this;
        }

        public Builder windowTitleContains(String str) {
            this.windowTitleContains = str;
            return this;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public ActionExtra getActionExtra() {
        return this.actionExtra;
    }

    @Nullable
    public String getActivityClassName() {
        return this.activityClassName;
    }

    @Nullable
    public String getActivityClassNameContains() {
        return this.activityClassNameContains;
    }

    @Nullable
    public Integer getDisplayId() {
        return this.displayId;
    }

    public String getFunction() {
        return this.function;
    }

    @Nullable
    public String getPackageName() {
        return this.packageName;
    }

    public long getRequestId() {
        return this.requestId;
    }

    @Nullable
    public String getWindowTitle() {
        return this.windowTitle;
    }

    @Nullable
    public String getWindowTitleContains() {
        return this.windowTitleContains;
    }

    public boolean isValid() {
        if (this.displayId != null) {
            return true;
        }
        String str = this.packageName;
        if (str != null && !str.isEmpty()) {
            return true;
        }
        String str2 = this.windowTitle;
        if (str2 != null && !str2.isEmpty()) {
            return true;
        }
        String str3 = this.windowTitleContains;
        if (str3 != null && !str3.isEmpty()) {
            return true;
        }
        String str4 = this.activityClassName;
        if (str4 != null && !str4.isEmpty()) {
            return true;
        }
        String str5 = this.activityClassNameContains;
        return (str5 == null || str5.isEmpty()) ? false : true;
    }

    public String toString() {
        return "RequestInfo{requestId=" + this.requestId + ", function='" + this.function + "', displayId=" + this.displayId + ", packageName='" + this.packageName + "', windowTitle='" + this.windowTitle + "', windowTitleContains='" + this.windowTitleContains + "', activityClassName='" + this.activityClassName + "', activityClassNameContains='" + this.activityClassNameContains + "', actionExtra=" + this.actionExtra + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.requestId);
        parcel.writeString(this.function);
        if (this.displayId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.displayId.intValue());
        }
        parcel.writeString(this.packageName);
        parcel.writeString(this.windowTitle);
        parcel.writeString(this.windowTitleContains);
        parcel.writeString(this.activityClassName);
        parcel.writeString(this.activityClassNameContains);
        parcel.writeParcelable(this.actionExtra, i);
    }

    private RequestInfo(Builder builder) {
        this.requestId = builder.requestId;
        this.function = builder.function;
        this.displayId = builder.displayId;
        this.packageName = builder.packageName;
        this.windowTitle = builder.windowTitle;
        this.windowTitleContains = builder.windowTitleContains;
        this.activityClassName = builder.activityClassName;
        this.activityClassNameContains = builder.activityClassNameContains;
        this.actionExtra = builder.actionExtra;
    }

    public RequestInfo(Parcel parcel) {
        this.requestId = parcel.readLong();
        this.function = parcel.readString();
        this.displayId = parcel.readByte() == 0 ? null : Integer.valueOf(parcel.readInt());
        this.packageName = parcel.readString();
        this.windowTitle = parcel.readString();
        this.windowTitleContains = parcel.readString();
        this.activityClassName = parcel.readString();
        this.activityClassNameContains = parcel.readString();
        this.actionExtra = (ActionExtra) parcel.readParcelable(ActionExtra.class.getClassLoader());
    }
}
