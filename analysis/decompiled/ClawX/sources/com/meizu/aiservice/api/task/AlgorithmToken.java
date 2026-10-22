package com.meizu.aiservice.api.task;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import b.a;
import m0.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@a
/* loaded from: classes.dex */
public class AlgorithmToken implements Parcelable {
    public static final Parcelable.Creator<AlgorithmToken> CREATOR = new a3.a(6);
    private static final String KEY_API = "api";
    private static final String KEY_IDENTITY = "id";
    private static final String KEY_REASON = "reason";
    private static final String KEY_REASON_CODE = "reason.code";
    private static final String KEY_RESULT = "result";
    public static final int REASON_CODE_CLIENT_EXCEPTION = -1;
    public static final int REASON_CODE_DEAD_OBJECT = -2;
    public static final int REASON_CODE_LOAD_ALGORITHM_FAIL = -3;
    public static final int REASON_CODE_SERVER_EXCEPTION = 0;
    public static final int REASON_CODE_SIGNATURE_MISMATCH = -4;
    public static final int RESULT_CANCELED = -2;
    public static final int RESULT_FAILED = -1;
    public static final int RESULT_NONE = 0;
    public static final int RESULT_SUCCEEDED = 1;
    public int api;
    private long identity;
    private int pid;
    private String reason;
    private int reasonCode;
    private int result;
    private int uid;

    public AlgorithmToken() {
        this(System.currentTimeMillis());
    }

    public static AlgorithmToken fromBundle(Bundle bundle) {
        AlgorithmToken algorithmToken = new AlgorithmToken(bundle.getLong("id", -1L));
        algorithmToken.api = bundle.getInt("api");
        algorithmToken.setResult(bundle.getInt(KEY_RESULT));
        algorithmToken.setReasonCode(bundle.getInt(KEY_REASON_CODE));
        algorithmToken.setReason(bundle.getString(KEY_REASON));
        return algorithmToken;
    }

    private void updateFromParcel(Parcel parcel) {
        this.api = parcel.readInt();
        this.identity = parcel.readLong();
        this.result = parcel.readInt();
        this.reasonCode = parcel.readInt();
        this.reason = parcel.readString();
        int i8 = parcel.readInt();
        this.uid = i8;
        if (this.api > 2) {
            this.pid = parcel.readInt();
        } else {
            this.pid = i8;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AlgorithmToken algorithmToken = (AlgorithmToken) obj;
        if (this.identity == algorithmToken.identity && this.result == algorithmToken.result && this.uid == algorithmToken.uid && this.pid == algorithmToken.pid && this.reasonCode == algorithmToken.reasonCode) {
            return TextUtils.equals(this.reason, algorithmToken.reason);
        }
        return false;
    }

    public long getIdentity() {
        return this.identity;
    }

    public int getPid() {
        return this.pid;
    }

    public String getReason() {
        return this.reason;
    }

    public int getReasonCode() {
        return this.reasonCode;
    }

    public int getResult() {
        return this.result;
    }

    public int getUid() {
        return this.uid;
    }

    public boolean hasResult() {
        return this.result != 0;
    }

    public int hashCode() {
        long j4 = this.identity;
        int i8 = ((((((((((int) (j4 ^ (j4 >>> 32))) * 31) + this.result) * 31) + this.uid) * 31) + this.pid) * 31) + this.reasonCode) * 31;
        String str = this.reason;
        return i8 + (str != null ? str.hashCode() : 0);
    }

    public boolean isResultCanceled() {
        return this.result == -2;
    }

    public boolean isResultFailed() {
        return this.result == -1;
    }

    public boolean isResultSuccess() {
        return this.result == 1;
    }

    public void readFromParcel(Parcel parcel) {
        updateFromParcel(parcel);
    }

    public void setPid(int i8) {
        this.pid = i8;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public void setReasonCode(int i8) {
        this.reasonCode = i8;
    }

    public void setResult(int i8) {
        this.result = i8;
    }

    public void setUid(int i8) {
        this.uid = i8;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("api", this.api);
        bundle.putLong("id", this.identity);
        bundle.putInt(KEY_RESULT, this.result);
        bundle.putInt(KEY_REASON_CODE, this.reasonCode);
        bundle.putString(KEY_REASON, this.reason);
        return bundle;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AlgorithmToken{identity=");
        sb.append(this.identity);
        sb.append(", result=");
        sb.append(this.result);
        sb.append(", uid=");
        sb.append(this.uid);
        sb.append(", pid=");
        sb.append(this.pid);
        sb.append(", reasonCode=");
        sb.append(this.reasonCode);
        sb.append(", reason='");
        return f.f(sb, this.reason, "'}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeInt(this.api);
        parcel.writeLong(this.identity);
        parcel.writeInt(this.result);
        parcel.writeInt(this.reasonCode);
        parcel.writeString(this.reason);
        parcel.writeInt(this.uid);
        parcel.writeInt(this.pid);
    }

    public AlgorithmToken(long j4) {
        this.api = 3;
        this.identity = j4;
        this.result = 0;
        this.reason = null;
        this.uid = Process.myUid();
        this.pid = Process.myPid();
    }

    public AlgorithmToken(Parcel parcel) {
        this.api = 3;
        this.result = 0;
        updateFromParcel(parcel);
    }
}
