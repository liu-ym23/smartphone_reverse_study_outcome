package stepos.inputmethod.sms;

import android.graphics.drawable.Icon;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class SmsOtp implements Parcelable {
    public static final Parcelable.Creator<SmsOtp> CREATOR = new Parcelable.Creator<SmsOtp>() { // from class: stepos.inputmethod.sms.SmsOtp.1
        @Override // android.os.Parcelable.Creator
        public SmsOtp createFromParcel(Parcel in) {
            CharSequence label = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            CharSequence code = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            long expiry = in.readLong();
            Icon icon = in.readInt() == 1 ? (Icon) Icon.CREATOR.createFromParcel(in) : null;
            return new SmsOtp(label, code, expiry, icon);
        }

        @Override // android.os.Parcelable.Creator
        public SmsOtp[] newArray(int size) {
            return new SmsOtp[size];
        }
    };
    private final CharSequence mCode;
    private final long mExpiryRealtimeMs;
    private final Icon mIcon;
    private final CharSequence mLabel;

    public SmsOtp(CharSequence label, CharSequence code, long expiryRealtimeMs, Icon icon) {
        this.mLabel = label;
        this.mCode = code;
        this.mExpiryRealtimeMs = expiryRealtimeMs;
        this.mIcon = icon;
    }

    public CharSequence getLabel() {
        return this.mLabel;
    }

    public CharSequence getCode() {
        return this.mCode;
    }

    public long getExpiryRealtimeMs() {
        return this.mExpiryRealtimeMs;
    }

    public Icon getIcon() {
        return this.mIcon;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        TextUtils.writeToParcel(this.mLabel, dest, flags);
        TextUtils.writeToParcel(this.mCode, dest, flags);
        dest.writeLong(this.mExpiryRealtimeMs);
        dest.writeInt(this.mIcon != null ? 1 : 0);
        if (this.mIcon != null) {
            this.mIcon.writeToParcel(dest, flags);
        }
    }

    public String toString() {
        return "SmsOtp{label=" + ((Object) this.mLabel) + ", codeLen=" + (this.mCode == null ? 0 : this.mCode.length()) + ", expiryRtMs=" + this.mExpiryRealtimeMs + ", icon=" + (this.mIcon != null) + "}";
    }
}
