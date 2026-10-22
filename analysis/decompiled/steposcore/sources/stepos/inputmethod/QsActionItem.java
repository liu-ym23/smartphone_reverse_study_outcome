package stepos.inputmethod;

import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.StepOSDateTimeUrlHelper;
import java.util.Random;

/* loaded from: classes.dex */
public class QsActionItem implements Parcelable {
    public static final Parcelable.Creator<QsActionItem> CREATOR = new Parcelable.Creator<QsActionItem>() { // from class: stepos.inputmethod.QsActionItem.1
        @Override // android.os.Parcelable.Creator
        public QsActionItem createFromParcel(Parcel in) {
            return new QsActionItem(in);
        }

        @Override // android.os.Parcelable.Creator
        public QsActionItem[] newArray(int size) {
            return new QsActionItem[size];
        }
    };
    private int mDisplayId;
    private long mExpiryTime;
    private final CharSequence mID;
    private Icon mIcon;
    private CharSequence mInput;
    private CharSequence mLabel;
    private final CharSequence mPackageName;
    private int mPosition;
    private int mShowSeconds;
    private int mState;
    private final long mToken;
    private final int mType;

    protected QsActionItem(Parcel in) {
        this.mDisplayId = -1;
        this.mExpiryTime = 0L;
        this.mShowSeconds = 0;
        this.mState = 0;
        this.mPosition = in.readInt();
        this.mDisplayId = in.readInt();
        this.mExpiryTime = in.readLong();
        this.mShowSeconds = in.readInt();
        this.mType = in.readInt();
        this.mState = in.readInt();
        this.mID = in.readCharSequence();
        this.mPackageName = in.readCharSequence();
        this.mLabel = in.readCharSequence();
        this.mInput = in.readCharSequence();
        this.mIcon = (Icon) in.readParcelable(Icon.class.getClassLoader());
        this.mToken = in.readLong();
    }

    public static String createKey(CharSequence packageName, CharSequence ID) {
        return ((Object) packageName) + StepOSDateTimeUrlHelper.COLON_STRING + ((Object) ID);
    }

    public static QsActionItem create(int type, CharSequence id, String packageName) {
        return new QsActionItem(type, id, packageName);
    }

    public static QsActionItem create(CharSequence id, Context context) {
        return new QsActionItem(1, id, context.getPackageName());
    }

    public static QsActionItem create(CharSequence id, String packageName) {
        return new QsActionItem(1, id, packageName);
    }

    public String toString() {
        return "QsActionItem:(mPosition=" + this.mPosition + ",mType=" + this.mType + ",mDisplayId=" + this.mDisplayId + ",mDisplaySeconds=" + this.mShowSeconds + ",mIntervalSec=" + this.mExpiryTime + ",mState=" + this.mState + ",mID=" + ((Object) this.mID) + ",mPackageName=" + ((Object) this.mPackageName) + ",mInput=" + ((Object) this.mInput) + ",mLabel=" + ((Object) this.mLabel) + ",mIcon=" + this.mIcon + ",mToken=" + this.mToken + ")";
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof QsActionItem)) {
            return false;
        }
        QsActionItem other = (QsActionItem) obj;
        return this.mPosition == other.mPosition && this.mDisplayId == other.mDisplayId && this.mExpiryTime == other.mExpiryTime && this.mShowSeconds == other.mShowSeconds && this.mType == other.mType && this.mState == other.mState && TextUtils.equals(this.mID, other.mID) && TextUtils.equals(this.mInput, other.mInput) && TextUtils.equals(this.mPackageName, other.mPackageName) && TextUtils.equals(this.mLabel, other.mLabel) && this.mIcon == other.mIcon && this.mToken == other.mToken;
    }

    public QsActionItem(QsActionItem other) {
        this.mDisplayId = -1;
        this.mExpiryTime = 0L;
        this.mShowSeconds = 0;
        this.mState = 0;
        this.mPosition = other.mPosition;
        this.mDisplayId = other.mDisplayId;
        this.mExpiryTime = other.mExpiryTime;
        this.mShowSeconds = other.mShowSeconds;
        this.mType = other.mType;
        this.mState = other.mState;
        this.mID = other.mID;
        this.mPackageName = other.mPackageName;
        this.mLabel = other.mLabel;
        this.mInput = other.mInput;
        this.mIcon = other.mIcon;
        this.mToken = other.mToken;
    }

    private QsActionItem(int type, CharSequence id, String packageName) {
        this.mDisplayId = -1;
        this.mExpiryTime = 0L;
        this.mShowSeconds = 0;
        this.mState = 0;
        this.mID = id;
        this.mType = type;
        this.mPackageName = packageName;
        Random random = new Random(this.mPackageName.length() * System.nanoTime());
        this.mToken = random.nextLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mPosition);
        dest.writeInt(this.mDisplayId);
        dest.writeLong(this.mExpiryTime);
        dest.writeInt(this.mShowSeconds);
        dest.writeInt(this.mType);
        dest.writeInt(this.mState);
        dest.writeCharSequence(this.mID);
        dest.writeCharSequence(this.mPackageName);
        dest.writeCharSequence(this.mLabel);
        dest.writeCharSequence(this.mInput);
        dest.writeParcelable(this.mIcon, flags);
        dest.writeLong(this.mToken);
    }

    public String getKey() {
        return createKey(this.mPackageName, this.mID);
    }

    public int getPosition() {
        return this.mPosition;
    }

    public long getExpiryTime() {
        return this.mExpiryTime;
    }

    public void setExpiryTime(long expiryTime) {
        this.mExpiryTime = expiryTime;
    }

    public int getShowSeconds() {
        return this.mShowSeconds;
    }

    public void setShowSeconds(int seconds) {
        this.mShowSeconds = seconds;
    }

    public int getDisplayId() {
        return this.mDisplayId;
    }

    public void setDisplayId(int displayId) {
        this.mDisplayId = displayId;
    }

    public void setPosition(int position) {
        this.mPosition = position;
    }

    public int getType() {
        return this.mType;
    }

    public int getState() {
        return this.mState;
    }

    public void setState(int state) {
        this.mState = state;
    }

    public CharSequence getID() {
        return this.mID;
    }

    public CharSequence getLabel() {
        return this.mLabel;
    }

    public CharSequence getInput() {
        return this.mInput;
    }

    public void setLabel(CharSequence label) {
        this.mLabel = label;
    }

    public void setInput(CharSequence input) {
        this.mInput = input;
    }

    public CharSequence getPackageName() {
        return this.mPackageName;
    }

    public Icon getIcon() {
        return this.mIcon;
    }

    public void setIcon(Icon icon) {
        this.mIcon = icon;
    }

    public long getToken() {
        return this.mToken;
    }
}
