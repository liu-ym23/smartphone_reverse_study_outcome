package com.stepos.deepbinder.core.exception;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@f.a
/* loaded from: classes.dex */
public final class IPCException extends RuntimeException implements Parcelable {
    public static final a CREATOR = new a();
    private final int errorCode;
    private final String extraErrorData;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.Creator<IPCException> {
        @Override // android.os.Parcelable.Creator
        public final IPCException createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            return new IPCException(parcel, (e) null);
        }

        @Override // android.os.Parcelable.Creator
        public final IPCException[] newArray(int i10) {
            return new IPCException[i10];
        }
    }

    public /* synthetic */ IPCException(Parcel parcel, e eVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getExtraErrorData() {
        return this.extraErrorData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0022  */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r2v9 */
    @Override // android.os.Parcelable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void writeToParcel(android.os.Parcel r1, int r2) {
        /*
            r0 = this;
            java.lang.String r2 = "dest"
            kotlin.jvm.internal.g.f(r1, r2)
            java.lang.String r2 = r0.getMessage()
            r1.writeString(r2)
            int r2 = r0.errorCode
            r1.writeInt(r2)
            java.lang.String r2 = r0.extraErrorData
            r1.writeString(r2)
            java.lang.Throwable r2 = r0.getCause()
            if (r2 == 0) goto L22
            java.lang.StackTraceElement[] r2 = r2.getStackTrace()
            if (r2 != 0) goto L26
        L22:
            java.lang.StackTraceElement[] r2 = r0.getStackTrace()
        L26:
            r1.writeSerializable(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.deepbinder.core.exception.IPCException.writeToParcel(android.os.Parcel, int):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IPCException(int i10, String message) {
        super(message);
        g.f(message, "message");
        this.errorCode = i10;
        this.extraErrorData = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IPCException(int i10, String message, String str) {
        super(message);
        g.f(message, "message");
        this.errorCode = i10;
        this.extraErrorData = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IPCException(int i10, Throwable cause) {
        super(cause.getMessage(), cause);
        g.f(cause, "cause");
        this.errorCode = i10;
        this.extraErrorData = null;
    }

    private IPCException(Parcel parcel) {
        super(parcel.readString());
        this.errorCode = parcel.readInt();
        this.extraErrorData = parcel.readString();
        Object serializable = parcel.readSerializable();
        StackTraceElement[] stackTraceElementArr = serializable instanceof StackTraceElement[] ? (StackTraceElement[]) serializable : null;
        if (stackTraceElementArr != null) {
            setStackTrace(stackTraceElementArr);
        }
        initCause(null);
    }
}
