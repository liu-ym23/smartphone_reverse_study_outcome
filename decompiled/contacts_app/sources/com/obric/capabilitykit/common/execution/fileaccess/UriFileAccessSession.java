package com.obric.capabilitykit.common.execution.fileaccess;

import android.content.res.AssetFileDescriptor;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u001fB%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lcom/obric/capabilitykit/common/execution/fileaccess/UriFileAccessSession;", "Landroid/os/Parcelable;", "status", "", "message", "", SlardarSettingsConsts.PERF_KEY_FD, "Landroid/content/res/AssetFileDescriptor;", "(ILjava/lang/String;Landroid/content/res/AssetFileDescriptor;)V", "getFd", "()Landroid/content/res/AssetFileDescriptor;", "getMessage", "()Ljava/lang/String;", "getStatus", "()I", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ErrorCode", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class UriFileAccessSession implements Parcelable {
    public static final Parcelable.Creator<UriFileAccessSession> CREATOR = null;
    private final AssetFileDescriptor fd;
    private final String message;
    private final int status;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/capabilitykit/common/execution/fileaccess/UriFileAccessSession$ErrorCode;", "", "()V", "ERROR_ACCESSING_INPUT_STREAM", "", "ERROR_ACCESSING_SHARER", "ERROR_INVALID_SHARER", "ERROR_NOT_SHARED_BY_THIS_ENTITY", "ERROR_OPENING_INPUT_STREAM", "ERROR_OPENING_URI", "ERROR_REQUESTING_URI", "ERROR_TIMEOUT", "ERROR_UNKNOWN_ERROR", "NO_ERROR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<UriFileAccessSession> {
        public a() {
        }

        public final UriFileAccessSession a(Parcel r4) {
            Intrinsics.checkNotNullParameter(r4, "parcel");
            return new UriFileAccessSession(r4.readInt(), r4.readString(), (AssetFileDescriptor) r4.readParcelable(UriFileAccessSession.class.getClassLoader()));
        }

        public final UriFileAccessSession[] a(int r1) {
            return new UriFileAccessSession[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ UriFileAccessSession createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ UriFileAccessSession[] newArray(int r1) {
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
        Intrinsics.checkNotNullParameter(r3, "message");
        this.status = r2;
        this.message = r3;
        this.fd = r4;
    }

    public /* synthetic */ UriFileAccessSession(int r1, String r2, AssetFileDescriptor r3, int r4, DefaultConstructorMarker r5) {
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
        Intrinsics.checkNotNullParameter(r2, "message");
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
        if ((r5 instanceof UriFileAccessSession) == true) goto L8;
        return false;
    L8:
        UriFileAccessSession r6 = (UriFileAccessSession) r5;
        if (this.status == r6.status) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.message, r6.message) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fd, r6.fd) == true) goto L17;
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
        Intrinsics.checkNotNullParameter(r2, "out");
        r2.writeInt(this.status);
        r2.writeString(this.message);
        r2.writeParcelable(this.fd, r3);
    }
}
