package com.obric.repo.core;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Result.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0002\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/obric/repo/core/Result;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "Error", "Success", "Lcom/obric/repo/core/Result$Error;", "Lcom/obric/repo/core/Result$Success;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class Result<T> {

    /* JADX INFO: compiled from: Result.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J2\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/obric/repo/core/Result$Error;", "Lcom/obric/repo/core/Result;", "", AccountConst.KEY_ERROR_CODE, "", AccountConst.KEY_ERROR_MSG, "", NotificationCompat.CATEGORY_ERROR, "", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Throwable;)V", "getErr", "()Ljava/lang/Throwable;", "getErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getErrorMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Throwable;)Lcom/obric/repo/core/Result$Error;", "equals", "", "other", "", "hashCode", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Error extends Result {
        private final Throwable err;
        private final Integer errorCode;
        private final String errorMsg;

        public static /* synthetic */ Error copy$default(Error r0, Integer r1, String r2, Throwable r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.errorCode;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.errorMsg;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.err;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final Integer component1() {
            return this.errorCode;
        }

        public final String component2() {
            return this.errorMsg;
        }

        public final Throwable component3() {
            return this.err;
        }

        public final Error copy(Integer r1, String r2, Throwable r3) {
            return new Error(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Error) == true) goto L8;
            return false;
        L8:
            Error r6 = (Error) r5;
            if (Intrinsics.areEqual(this.errorCode, r6.errorCode) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.errorMsg, r6.errorMsg) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.err, r6.err) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            Integer r0 = this.errorCode;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.errorMsg;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Throwable r7 = this.err;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "Error(errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ", err=" + this.err + ')';
        }

        public Error(Integer r2, String r3, Throwable r4) {
            super(null);
            this.errorCode = r2;
            this.errorMsg = r3;
            this.err = r4;
        }

        public final Throwable getErr() {
            return this.err;
        }

        public final Integer getErrorCode() {
            return this.errorCode;
        }

        public final String getErrorMsg() {
            return this.errorMsg;
        }
    }

    /* JADX INFO: compiled from: Result.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/obric/repo/core/Result$Success;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/repo/core/Result;", "data", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/obric/repo/core/Result$Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Success<T> extends Result<T> {
        private final T data;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success copy$default(Success r0, Object r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.data;
        L6:
            return r0.copy(r1);
        }

        public final T component1() {
            return this.data;
        }

        public final Success<T> copy(T r1) {
            return new Success(r1);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof Success) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.data, ((Success) r4).data) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            T r0 = this.data;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "Success(data=" + this.data + ')';
        }

        public Success(T r2) {
            super(null);
            this.data = r2;
        }

        public final T getData() {
            return this.data;
        }
    }

    public /* synthetic */ Result(DefaultConstructorMarker r1) {
        this();
    }

    private Result() {
    }
}
