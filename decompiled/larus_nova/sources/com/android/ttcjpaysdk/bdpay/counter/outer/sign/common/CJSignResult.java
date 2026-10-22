package com.android.ttcjpaysdk.bdpay.counter.outer.sign.common;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0002\u0011\u0012B\u0007\b\u0004¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\r\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0007J\u000b\u0010\b\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ \u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u000eJ \u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\u000e\u0082\u0001\u0002\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/common/CJSignResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "exceptionOrNull", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/common/CJSignException;", "getOrNull", "()Ljava/lang/Object;", "getOrThrow", "isFailure", "", "isSuccess", "onFailure", "action", "Lkotlin/Function1;", "", "onSuccess", "Error", "Success", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/common/CJSignResult$Error;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/common/CJSignResult$Success;", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CJSignResult<T> {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/common/CJSignResult$Error;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/common/CJSignResult;", "", a.KEY_EXCEPTION, "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/common/CJSignException;", "(Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/common/CJSignException;)V", "getException", "()Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/common/CJSignException;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Error extends CJSignResult {
        private final CJSignException exception;

        public static /* synthetic */ Error copy$default(Error r100, CJSignException r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.exception;
        L6:
            return r100.copy(r101);
        }

        public final CJSignException component1() {
            return this.exception;
        }

        public final Error copy(CJSignException r100) {
            Intrinsics.checkNotNullParameter(r100, a.KEY_EXCEPTION);
            return new Error(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Error) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.exception, ((Error) r100).exception) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "Error(exception=" + this.exception + ')';
        }

        public final CJSignException getException() {
            return this.exception;
        }

        public Error(CJSignException r100) {
            Intrinsics.checkNotNullParameter(r100, a.KEY_EXCEPTION);
            super(null);
            this.exception = r100;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/common/CJSignResult$Success;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/common/CJSignResult;", "data", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/common/CJSignResult$Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Success<T> extends CJSignResult<T> {
        private final T data;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success copy$default(Success r100, Object r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.data;
        L6:
            return r100.copy(r101);
        }

        public final T component1() {
            return this.data;
        }

        public final Success<T> copy(T r100) {
            return new Success(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Success) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.data, ((Success) r100).data) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            T r100 = this.data;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public String toString() {
            return "Success(data=" + this.data + ')';
        }

        public final T getData() {
            return this.data;
        }

        public Success(T r100) {
            super(null);
            this.data = r100;
        }
    }

    private CJSignResult() {
    }

    public /* synthetic */ CJSignResult(DefaultConstructorMarker r100) {
        this();
    }

    public final CJSignException exceptionOrNull() {
        if ((this instanceof Success) == false) goto L6;
        return null;
    L6:
        if ((this instanceof Error) == false) goto L10;
        return ((Error) this).getException();
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final T getOrNull() {
        if ((this instanceof Success) == false) goto L6;
        return (T) ((Success) this).getData();
    L6:
        if ((this instanceof Error) == false) goto L10;
        return null;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final T getOrThrow() {
        if ((this instanceof Success) == false) goto L7;
        return (T) ((Success) this).getData();
    L7:
        if ((this instanceof Error) == false) goto L11;
        throw ((Error) this).getException();
    L11:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean isFailure() {
        return this instanceof Error;
    }

    public final boolean isSuccess() {
        return this instanceof Success;
    }

    public final CJSignResult<T> onFailure(Function1<? super CJSignException, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if ((this instanceof Error) == false) goto L5;
        r100.invoke(((Error) this).getException());
    L5:
        return this;
    }

    public final CJSignResult<T> onSuccess(Function1<? super T, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if ((this instanceof Success) == false) goto L5;
        r100.invoke((Object) ((Success) this).getData());
    L5:
        return this;
    }
}
