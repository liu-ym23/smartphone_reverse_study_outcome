package com.obric.aiagent.executionengine.capabilitymanager.data.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: Result.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RegisterResult implements Parcelable {
    public static final Parcelable.Creator<RegisterResult> CREATOR = null;

    @SerializedName("StatusCode")
    private final Integer statusCode;

    @SerializedName("StatusMessage")
    private final String statusMessage;

    /* JADX INFO: compiled from: Result.kt */
    public static final class Creator implements Parcelable.Creator<RegisterResult> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RegisterResult createFromParcel(Parcel r3) {
            o.e(r3, "parcel");
            String r0 = r3.readString();
            if (r3.readInt() != 0) goto L5;
            Integer r4 = null;
        L7:
            return new RegisterResult(r0, r4);
        L5:
            r4 = Integer.valueOf(r3.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RegisterResult createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RegisterResult[] newArray(int r1) {
            return new RegisterResult[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RegisterResult[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RegisterResult() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ RegisterResult copy$default(RegisterResult r0, String r1, Integer r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.statusMessage;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.statusCode;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.statusMessage;
    }

    public final Integer component2() {
        return this.statusCode;
    }

    public final RegisterResult copy(String r1, Integer r2) {
        return new RegisterResult(r1, r2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, RegisterResult.class) == true) goto L8;
        return false;
    L8:
        RegisterResult r6 = (RegisterResult) ZeusTransformUtils.preCheckCast(r5, RegisterResult.class, "com.obric.aiagent.plugin");
        if (o.a(this.statusMessage, r6.statusMessage) == true) goto L12;
        return false;
    L12:
        if (o.a(this.statusCode, r6.statusCode) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.statusMessage;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.statusCode;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "RegisterResult(statusMessage=" + this.statusMessage + ", statusCode=" + this.statusCode + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "dest");
        r1.writeString(this.statusMessage);
        Integer r0 = this.statusCode;
        if (r0 != null) goto L5;
        int r3 = 0;
    L6:
        r1.writeInt(r3);
        return;
    L5:
        r1.writeInt(1);
        r3 = r0.intValue();
        goto L6
    }

    public RegisterResult(String r1, Integer r2) {
        this.statusMessage = r1;
        this.statusCode = r2;
    }

    public final String getStatusMessage() {
        return this.statusMessage;
    }

    public final Integer getStatusCode() {
        return this.statusCode;
    }

    public /* synthetic */ RegisterResult(String r1, Integer r2, int r3, h r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = -1;
    L8:
        this(r1, r2);
    }
}
