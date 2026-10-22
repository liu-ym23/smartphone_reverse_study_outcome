package androidx.activity.result;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public final class ActivityResult implements Parcelable {
    public static final Parcelable.Creator<ActivityResult> CREATOR = null;
    private final Intent mData;
    private final int mResultCode;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public String toString() {
        return "ActivityResult{resultCode=" + resultCodeToString(this.mResultCode) + ", data=" + this.mData + '}';
    }

    public Intent getData() {
        return this.mData;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public ActivityResult(Parcel r100) {
        this.mResultCode = r100.readInt();
        if (r100.readInt() != 0) goto L5;
        Intent r101 = null;
    L6:
        this.mData = r101;
        return;
    L5:
        r101 = (Intent) Intent.CREATOR.createFromParcel(r100);
        goto L6
    }

    public static String resultCodeToString(int r100) {
        if (r100 == (-1)) goto L9;
        if (r100 != 0) goto L6;
        return "RESULT_CANCELED";
    L6:
        return String.valueOf(r100);
    L9:
        return "RESULT_OK";
    }

    public ActivityResult(int r100, Intent r101) {
        this.mResultCode = r100;
        this.mData = r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.mResultCode);
        if (this.mData != null) goto L5;
        int r102 = 0;
    L6:
        r100.writeInt(r102);
        Intent r103 = this.mData;
        if (r103 == null) goto L10;
        r103.writeToParcel(r100, r101);
        return;
    L10:
        return;
    L5:
        r102 = 1;
        goto L6
    }
}
