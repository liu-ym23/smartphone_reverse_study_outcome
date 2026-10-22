package androidx.activity.result;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityResult implements Parcelable {
    public static final Parcelable.Creator<ActivityResult> CREATOR = null;
    private final Intent mData;
    private final int mResultCode;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ActivityResult(int r1, Intent r2) {
        this.mResultCode = r1;
        this.mData = r2;
    }

    ActivityResult(Parcel r3) {
        this.mResultCode = r3.readInt();
        if (r3.readInt() != 0) goto L5;
        Intent r4 = null;
    L6:
        this.mData = r4;
        return;
    L5:
        r4 = (Intent) ZeusTransformUtils.preCheckCast(Intent.CREATOR.createFromParcel(r3), Intent.class, "com.obric.aiagent.plugin");
        goto L6
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public Intent getData() {
        return this.mData;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + resultCodeToString(this.mResultCode) + ", data=" + this.mData + '}';
    }

    public static String resultCodeToString(int r1) {
        if (r1 == (-1)) goto L9;
        if (r1 != 0) goto L6;
        return "RESULT_CANCELED";
    L6:
        return String.valueOf(r1);
    L9:
        return "RESULT_OK";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeInt(this.mResultCode);
        if (this.mData != null) goto L5;
        int r0 = 0;
    L6:
        r2.writeInt(r0);
        Intent r1 = this.mData;
        if (r1 == null) goto L10;
        r1.writeToParcel(r2, r3);
        return;
    L10:
        return;
    L5:
        r0 = 1;
        goto L6
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
