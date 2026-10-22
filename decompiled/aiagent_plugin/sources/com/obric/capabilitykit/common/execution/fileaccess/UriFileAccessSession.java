package com.obric.capabilitykit.common.execution.fileaccess;

import android.content.res.AssetFileDescriptor;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes3.dex */
public final class UriFileAccessSession implements Parcelable {
    public static final Parcelable.Creator<UriFileAccessSession> CREATOR = null;
    private final AssetFileDescriptor fd;
    private final String message;
    private final int status;

    public static final class ErrorCode {
        public static final int ERROR_ACCESSING_INPUT_STREAM = 6;
        public static final int ERROR_ACCESSING_SHARER = 8;
        public static final int ERROR_INVALID_SHARER = 3;
        public static final int ERROR_NOT_SHARED_BY_THIS_ENTITY = 2;
        public static final int ERROR_OPENING_INPUT_STREAM = 5;
        public static final int ERROR_OPENING_URI = 4;
        public static final int ERROR_REQUESTING_URI = 7;
        public static final int ERROR_TIMEOUT = 9;
        public static final int ERROR_UNKNOWN_ERROR = 1;
        public static final ErrorCode INSTANCE = null;
        public static final int NO_ERROR = 0;

        static {
            INSTANCE = new ErrorCode();
        }

        private ErrorCode() {
        }
    }

    public static final class a implements Parcelable.Creator<UriFileAccessSession> {
        public a() {
        }

        public final UriFileAccessSession a(Parcel r5) {
            o.e(r5, "parcel");
            return new UriFileAccessSession(r5.readInt(), r5.readString(), (AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r5.readParcelable(UriFileAccessSession.class.getClassLoader()), AssetFileDescriptor.class, "com.obric.aiagent.plugin"));
        }

        public final UriFileAccessSession[] a(int r1) {
            return new UriFileAccessSession[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ UriFileAccessSession createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ UriFileAccessSession[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public UriFileAccessSession() {
        this(0, null, null, 7, null);
    }

    public UriFileAccessSession(int r2, String r3, AssetFileDescriptor r4) {
        o.e(r3, "message");
        this.status = r2;
        this.message = r3;
        this.fd = r4;
    }

    public /* synthetic */ UriFileAccessSession(int r1, String r2, AssetFileDescriptor r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = "";
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = null;
    L11:
        this(r1, r2, r3);
    }

    public static /* synthetic */ UriFileAccessSession copy$default(UriFileAccessSession r0, int r1, String r2, AssetFileDescriptor r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.status;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.message;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.fd;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.status;
    }

    public final String component2() {
        return this.message;
    }

    public final AssetFileDescriptor component3() {
        return this.fd;
    }

    public final UriFileAccessSession copy(int r1, String r2, AssetFileDescriptor r3) {
        o.e(r2, "message");
        return new UriFileAccessSession(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, UriFileAccessSession.class) == true) goto L8;
        return false;
    L8:
        UriFileAccessSession r6 = (UriFileAccessSession) ZeusTransformUtils.preCheckCast(r5, UriFileAccessSession.class, "com.obric.aiagent.plugin");
        if (this.status == r6.status) goto L12;
        return false;
    L12:
        if (o.a(this.message, r6.message) == true) goto L15;
        return false;
    L15:
        if (o.a(this.fd, r6.fd) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final AssetFileDescriptor getFd() {
        return this.fd;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getStatus() {
        return this.status;
    }

    public int hashCode() {
        int r0 = ((Integer.hashCode(this.status) * 31) + this.message.hashCode()) * 31;
        AssetFileDescriptor r2 = this.fd;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "UriFileAccessSession(status=" + this.status + ", message=" + this.message + ", fd=" + this.fd + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        o.e(r2, "out");
        r2.writeInt(this.status);
        r2.writeString(this.message);
        r2.writeParcelable(this.fd, r3);
    }
}
