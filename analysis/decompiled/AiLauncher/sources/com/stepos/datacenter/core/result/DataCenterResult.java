package com.stepos.datacenter.core.result;

import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u001d*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0003\u001e\u001f\u001dB\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\t\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ3\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000fH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J9\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u000e2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00000\u000fH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0012J-\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u000fH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0012J-\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u000fH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0012J-\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00150\u000fH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0012R\u0011\u0010\u001a\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001b\u0082\u0001\u0002\u000b \u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006!"}, d2 = {"Lcom/stepos/datacenter/core/result/DataCenterResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "getOrNull", "()Ljava/lang/Object;", "getOrThrow", "default", "getOrElse", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lcom/stepos/datacenter/core/result/DataCenterResult$Failure;", "failureOrNull", "()Lcom/stepos/datacenter/core/result/DataCenterResult$Failure;", "R", "Lkotlin/Function1;", "transform", C3081a.FOCUS_MAP_NAME, "(Lp9/l;)Lcom/stepos/datacenter/core/result/DataCenterResult;", "flatMap", "mapError", "LY8/t;", "action", "onSuccess", "onFailure", "", "isSuccess", "()Z", "isFailure", "Companion", "Success", "Failure", "Lcom/stepos/datacenter/core/result/DataCenterResult$Success;", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class DataCenterResult<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006\"\u0004\b\u0001\u0010\u00042\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0015J7\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u0018\"\u0004\b\u0001\u0010\u00042\b\b\u0002\u0010\u0013\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u0016H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001b"}, d2 = {"Lcom/stepos/datacenter/core/result/DataCenterResult$Companion;", "", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, UxipConstants.f30680s, "Lcom/stepos/datacenter/core/result/DataCenterResult$Success;", "ok", "(Ljava/lang/Object;)Lcom/stepos/datacenter/core/result/DataCenterResult$Success;", "Lcom/stepos/datacenter/core/result/DataCenterError;", "error", "", "message", "", "cause", "Lcom/stepos/datacenter/core/result/DataCenterResult$Failure;", "failure", "(Lcom/stepos/datacenter/core/result/DataCenterError;Ljava/lang/String;Ljava/lang/Throwable;)Lcom/stepos/datacenter/core/result/DataCenterResult$Failure;", "t", "default", "fromThrowable", "(Ljava/lang/Throwable;Lcom/stepos/datacenter/core/result/DataCenterError;)Lcom/stepos/datacenter/core/result/DataCenterResult$Failure;", "Lkotlin/Function0;", "block", "Lcom/stepos/datacenter/core/result/DataCenterResult;", "runCatching", "(Lcom/stepos/datacenter/core/result/DataCenterError;Lp9/a;)Lcom/stepos/datacenter/core/result/DataCenterResult;", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public static /* synthetic */ Failure failure$default(Companion companion, DataCenterError dataCenterError, String str, Throwable th, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                str = dataCenterError.getDesc();
            }
            if ((i10 & 4) != 0) {
                th = null;
            }
            return companion.failure(dataCenterError, str, th);
        }

        public static /* synthetic */ Failure fromThrowable$default(Companion companion, Throwable th, DataCenterError dataCenterError, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                dataCenterError = DataCenterError.INTERNAL_ERROR;
            }
            return companion.fromThrowable(th, dataCenterError);
        }

        public static /* synthetic */ DataCenterResult runCatching$default(Companion companion, DataCenterError dataCenterError, InterfaceC5063a block, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                dataCenterError = DataCenterError.INTERNAL_ERROR;
            }
            p.i(dataCenterError, "default");
            p.i(block, "block");
            try {
                return new Success(block.invoke());
            } catch (Throwable th) {
                return companion.fromThrowable(th, dataCenterError);
            }
        }

        public final Failure failure(DataCenterError error, String message, Throwable cause) {
            p.i(error, "error");
            p.i(message, "message");
            return new Failure(error, message, cause);
        }

        public final Failure fromThrowable(Throwable t10, DataCenterError dataCenterError) {
            p.i(t10, "t");
            p.i(dataCenterError, "default");
            if (t10 instanceof IllegalArgumentException) {
                dataCenterError = DataCenterError.INVALID_ARGS;
            } else if (t10 instanceof IllegalStateException) {
                dataCenterError = DataCenterError.NOT_INITIALIZED;
            } else if (t10 instanceof DataCenterException) {
                dataCenterError = ((DataCenterException) t10).getError();
            }
            String message = t10.getMessage();
            if (message == null) {
                message = dataCenterError.getDesc();
            }
            return new Failure(dataCenterError, message, t10);
        }

        public final <T> Success<T> ok(T value) {
            return new Success<>(value);
        }

        public final <T> DataCenterResult<T> runCatching(DataCenterError dataCenterError, InterfaceC5063a<? extends T> block) {
            p.i(dataCenterError, "default");
            p.i(block, "block");
            try {
                return new Success(block.invoke());
            } catch (Throwable th) {
                return fromThrowable(th, dataCenterError);
            }
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/stepos/datacenter/core/result/DataCenterResult$Success;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/stepos/datacenter/core/result/DataCenterResult;", UxipConstants.f30680s, "<init>", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", ChatTracker.CLICK_COPY, "(Ljava/lang/Object;)Lcom/stepos/datacenter/core/result/DataCenterResult$Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Success<T> extends DataCenterResult<T> {
        private final T value;

        public Success(T t10) {
            super(null);
            this.value = t10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success copy$default(Success success, Object obj, int i10, Object obj2) {
            if ((i10 & 1) != 0) {
                obj = success.value;
            }
            return success.copy(obj);
        }

        public final T component1() {
            return this.value;
        }

        public final Success<T> copy(T value) {
            return new Success<>(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Success) && p.d(this.value, ((Success) other).value);
        }

        public final T getValue() {
            return this.value;
        }

        public int hashCode() {
            T t10 = this.value;
            if (t10 == null) {
                return 0;
            }
            return t10.hashCode();
        }

        public String toString() {
            return "Success(value=" + this.value + ")";
        }
    }

    public /* synthetic */ DataCenterResult(i iVar) {
        this();
    }

    public final Failure failureOrNull() {
        if (this instanceof Failure) {
            return (Failure) this;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> DataCenterResult<R> flatMap(InterfaceC5074l<? super T, ? extends DataCenterResult<? extends R>> transform) {
        p.i(transform, "transform");
        if (this instanceof Success) {
            return transform.invoke((Object) ((Success) this).getValue());
        }
        if (this instanceof Failure) {
            return this;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final T getOrElse(T t10) {
        if (this instanceof Success) {
            return (T) ((Success) this).getValue();
        }
        if (this instanceof Failure) {
            return t10;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final T getOrNull() {
        Success success = this instanceof Success ? (Success) this : null;
        if (success != null) {
            return (T) success.getValue();
        }
        return null;
    }

    public final T getOrThrow() throws DataCenterException {
        if (this instanceof Success) {
            return (T) ((Success) this).getValue();
        }
        if (!(this instanceof Failure)) {
            throw new NoWhenBranchMatchedException();
        }
        Failure failure = (Failure) this;
        throw new DataCenterException(failure.getError(), failure.getMessage(), failure.getCause());
    }

    public final boolean isFailure() {
        return this instanceof Failure;
    }

    public final boolean isSuccess() {
        return this instanceof Success;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> DataCenterResult<R> map(InterfaceC5074l<? super T, ? extends R> transform) {
        p.i(transform, "transform");
        if (this instanceof Success) {
            return new Success(transform.invoke((Object) ((Success) this).getValue()));
        }
        if (this instanceof Failure) {
            return this;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final DataCenterResult<T> mapError(InterfaceC5074l<? super Failure, Failure> transform) {
        p.i(transform, "transform");
        if (this instanceof Success) {
            return this;
        }
        if (this instanceof Failure) {
            return transform.invoke(this);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final DataCenterResult<T> onFailure(InterfaceC5074l<? super Failure, t> action) {
        p.i(action, "action");
        if (this instanceof Failure) {
            action.invoke(this);
        }
        return this;
    }

    public final DataCenterResult<T> onSuccess(InterfaceC5074l<? super T, t> action) {
        p.i(action, "action");
        if (this instanceof Success) {
            action.invoke((Object) ((Success) this).getValue());
        }
        return this;
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J)\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/stepos/datacenter/core/result/DataCenterResult$Failure;", "Lcom/stepos/datacenter/core/result/DataCenterResult;", "", "error", "Lcom/stepos/datacenter/core/result/DataCenterError;", "message", "", "cause", "", "<init>", "(Lcom/stepos/datacenter/core/result/DataCenterError;Ljava/lang/String;Ljava/lang/Throwable;)V", "getError", "()Lcom/stepos/datacenter/core/result/DataCenterError;", "getMessage", "()Ljava/lang/String;", "getCause", "()Ljava/lang/Throwable;", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "equals", "", "other", "", "hashCode", "", "toString", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Failure extends DataCenterResult {
        private final Throwable cause;
        private final DataCenterError error;
        private final String message;

        public /* synthetic */ Failure(DataCenterError dataCenterError, String str, Throwable th, int i10, i iVar) {
            this(dataCenterError, (i10 & 2) != 0 ? dataCenterError.getDesc() : str, (i10 & 4) != 0 ? null : th);
        }

        public static /* synthetic */ Failure copy$default(Failure failure, DataCenterError dataCenterError, String str, Throwable th, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                dataCenterError = failure.error;
            }
            if ((i10 & 2) != 0) {
                str = failure.message;
            }
            if ((i10 & 4) != 0) {
                th = failure.cause;
            }
            return failure.copy(dataCenterError, str, th);
        }

        /* renamed from: component1, reason: from getter */
        public final DataCenterError getError() {
            return this.error;
        }

        /* renamed from: component2, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        /* renamed from: component3, reason: from getter */
        public final Throwable getCause() {
            return this.cause;
        }

        public final Failure copy(DataCenterError error, String message, Throwable cause) {
            p.i(error, "error");
            p.i(message, "message");
            return new Failure(error, message, cause);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Failure)) {
                return false;
            }
            Failure failure = (Failure) other;
            return this.error == failure.error && p.d(this.message, failure.message) && p.d(this.cause, failure.cause);
        }

        public final Throwable getCause() {
            return this.cause;
        }

        public final DataCenterError getError() {
            return this.error;
        }

        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            int iHashCode = ((this.error.hashCode() * 31) + this.message.hashCode()) * 31;
            Throwable th = this.cause;
            return iHashCode + (th == null ? 0 : th.hashCode());
        }

        public String toString() {
            return "Failure(error=" + this.error + ", message=" + this.message + ", cause=" + this.cause + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(DataCenterError error, String message, Throwable th) {
            super(null);
            p.i(error, "error");
            p.i(message, "message");
            this.error = error;
            this.message = message;
            this.cause = th;
        }
    }

    private DataCenterResult() {
    }
}
