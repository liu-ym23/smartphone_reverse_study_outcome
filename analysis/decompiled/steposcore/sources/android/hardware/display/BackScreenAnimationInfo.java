package android.hardware.display;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class BackScreenAnimationInfo implements Parcelable {
    public static final Parcelable.Creator<BackScreenAnimationInfo> CREATOR = new Parcelable.Creator<BackScreenAnimationInfo>() { // from class: android.hardware.display.BackScreenAnimationInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BackScreenAnimationInfo createFromParcel(Parcel in) {
            return new BackScreenAnimationInfo(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BackScreenAnimationInfo[] newArray(int size) {
            return new BackScreenAnimationInfo[size];
        }
    };
    public static final String TYPE_AGENT = "agent";
    public static final String TYPE_CUSTOM = "custom";
    public static final String TYPE_INPUT = "input";
    public static final String TYPE_OS_STATE = "os_state";
    private final String mId;
    private final String mName;
    private final String mState;
    private final String mType;

    public BackScreenAnimationInfo(String id, String name, String state, String type) {
        this.mId = emptyIfNull(id);
        this.mName = emptyIfNull(name);
        this.mState = emptyIfNull(state);
        this.mType = emptyIfNull(type);
    }

    private BackScreenAnimationInfo(Parcel in) {
        this.mId = emptyIfNull(in.readString());
        this.mName = emptyIfNull(in.readString());
        this.mState = emptyIfNull(in.readString());
        this.mType = emptyIfNull(in.readString());
    }

    private static String emptyIfNull(String value) {
        return value != null ? value : "";
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public String getState() {
        return this.mState;
    }

    public String getType() {
        return this.mType;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mId);
        dest.writeString(this.mName);
        dest.writeString(this.mState);
        dest.writeString(this.mType);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BackScreenAnimationInfo)) {
            return false;
        }
        BackScreenAnimationInfo other = (BackScreenAnimationInfo) o;
        return TextUtils.equals(this.mId, other.mId) && TextUtils.equals(this.mName, other.mName) && TextUtils.equals(this.mState, other.mState) && TextUtils.equals(this.mType, other.mType);
    }

    public int hashCode() {
        int result = this.mId.hashCode();
        return (((((result * 31) + this.mName.hashCode()) * 31) + this.mState.hashCode()) * 31) + this.mType.hashCode();
    }

    public String toString() {
        return "BackScreenAnimationInfo{id=" + this.mId + ", name=" + this.mName + ", state=" + this.mState + ", type=" + this.mType + "}";
    }
}
