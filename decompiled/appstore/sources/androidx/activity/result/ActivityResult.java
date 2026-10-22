package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class ActivityResult implements Parcelable {

    @NonNull
    public static final Parcelable.Creator<ActivityResult> CREATOR = null;

    @Nullable
    private final Intent mData;
    private final int mResultCode;

    public class a implements Parcelable.Creator {
        public a() {
        }

        public ActivityResult a(Parcel r10) {
            return new ActivityResult(r10);
        }

        public ActivityResult[] b(int r10) {
            return new ActivityResult[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new a();
    }

    public ActivityResult(int r10, @Nullable Intent r11) {
        this.mResultCode = r10;
        this.mData = r11;
    }

    @NonNull
    public static String resultCodeToString(int r10) {
        if (r10 == (-1)) goto L9;
        if (r10 != 0) goto L6;
        return "RESULT_CANCELED";
    L6:
        return String.valueOf(r10);
    L9:
        return "RESULT_OK";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public Intent getData() {
        return this.mData;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + resultCodeToString(this.mResultCode) + ", data=" + this.mData + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r10, int r11) {
        r10.writeInt(this.mResultCode);
        if (this.mData != null) goto L5;
        int r12 = 0;
    L6:
        r10.writeInt(r12);
        Intent r13 = this.mData;
        if (r13 == null) goto L10;
        r13.writeToParcel(r10, r11);
        return;
    L10:
        return;
    L5:
        r12 = 1;
        goto L6
    }

    public ActivityResult(Parcel r10) {
        this.mResultCode = r10.readInt();
        if (r10.readInt() != 0) goto L5;
        Intent r11 = null;
    L6:
        this.mData = r11;
        return;
    L5:
        r11 = (Intent) Intent.CREATOR.createFromParcel(r10);
        goto L6
    }
}
