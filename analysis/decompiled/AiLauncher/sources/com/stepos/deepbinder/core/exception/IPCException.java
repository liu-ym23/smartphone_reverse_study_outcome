package com.stepos.deepbinder.core.exception;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Keep
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u001f2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001\u001fB\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB#\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\u000bB\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\b\u0010\u000eB\u0011\b\u0012\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\b\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u0013R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/stepos/deepbinder/core/exception/IPCException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "Landroid/os/Parcelable;", "", "errorCode", "", "message", "<init>", "(ILjava/lang/String;)V", "extraData", "(ILjava/lang/String;Ljava/lang/String;)V", "", "cause", "(ILjava/lang/Throwable;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "describeContents", "()I", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getErrorCode", "extraErrorData", "Ljava/lang/String;", "getExtraErrorData", "()Ljava/lang/String;", "CREATOR", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IPCException extends RuntimeException implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int errorCode;
    private final String extraErrorData;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/deepbinder/core/exception/IPCException$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/stepos/deepbinder/core/exception/IPCException;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", ContentDisposition.Parameters.Size, "", "(I)[Lcom/stepos/deepbinder/core/exception/IPCException;", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.deepbinder.core.exception.IPCException$CREATOR, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<IPCException> {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IPCException createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new IPCException(parcel, (i) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IPCException[] newArray(int size) {
            return new IPCException[size];
        }
    }

    public /* synthetic */ IPCException(Parcel parcel, i iVar) {
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
            kotlin.jvm.internal.p.i(r1, r2)
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
        p.i(message, "message");
        this.errorCode = i10;
        this.extraErrorData = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IPCException(int i10, String message, String str) {
        super(message);
        p.i(message, "message");
        this.errorCode = i10;
        this.extraErrorData = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IPCException(int i10, Throwable cause) {
        super(cause.getMessage(), cause);
        p.i(cause, "cause");
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
