package com.stepos.ame.sdk;

import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000f*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0003\u0010\u0011\u000fB\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0007\u0010\u0006J-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\bH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\bH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\f\u0082\u0001\u0002\r\u0012\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2 = {"Lcom/stepos/ame/sdk/AMEngineResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "getOrThrow", "()Ljava/lang/Object;", "getOrNull", "Lkotlin/Function1;", "LY8/t;", "action", "onSuccess", "(Lp9/l;)Lcom/stepos/ame/sdk/AMEngineResult;", "Lcom/stepos/ame/sdk/AMEngineResult$Failure;", "onFailure", "Companion", "Success", "Failure", "Lcom/stepos/ame/sdk/AMEngineResult$Success;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class AMEngineResult<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0001\u0010\u00062\u0006\u0010\u0007\u001a\u0002H\u0006¢\u0006\u0002\u0010\bJ(\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/ame/sdk/AMEngineResult$Companion;", "", "<init>", "()V", "ok", "Lcom/stepos/ame/sdk/AMEngineResult;", ExifInterface.GPS_DIRECTION_TRUE, UxipConstants.f30680s, "(Ljava/lang/Object;)Lcom/stepos/ame/sdk/AMEngineResult;", "failure", "", "error", "Lcom/stepos/ame/sdk/AMEError;", "message", "", "cause", "", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public static /* synthetic */ AMEngineResult failure$default(Companion companion, AMEError aMEError, String str, Throwable th, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                th = null;
            }
            return companion.failure(aMEError, str, th);
        }

        public final AMEngineResult failure(AMEError error, String message, Throwable cause) {
            p.i(error, "error");
            p.i(message, "message");
            return new Failure(error, message, cause);
        }

        public final <T> AMEngineResult<T> ok(T value) {
            return new Success(value);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J)\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/stepos/ame/sdk/AMEngineResult$Failure;", "Lcom/stepos/ame/sdk/AMEngineResult;", "", "error", "Lcom/stepos/ame/sdk/AMEError;", "message", "", "cause", "", "<init>", "(Lcom/stepos/ame/sdk/AMEError;Ljava/lang/String;Ljava/lang/Throwable;)V", "getError", "()Lcom/stepos/ame/sdk/AMEError;", "getMessage", "()Ljava/lang/String;", "getCause", "()Ljava/lang/Throwable;", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "equals", "", "other", "", "hashCode", "", "toString", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Failure extends AMEngineResult {
        private final Throwable cause;
        private final AMEError error;
        private final String message;

        public /* synthetic */ Failure(AMEError aMEError, String str, Throwable th, int i10, i iVar) {
            this(aMEError, str, (i10 & 4) != 0 ? null : th);
        }

        public static /* synthetic */ Failure copy$default(Failure failure, AMEError aMEError, String str, Throwable th, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                aMEError = failure.error;
            }
            if ((i10 & 2) != 0) {
                str = failure.message;
            }
            if ((i10 & 4) != 0) {
                th = failure.cause;
            }
            return failure.copy(aMEError, str, th);
        }

        /* renamed from: component1, reason: from getter */
        public final AMEError getError() {
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

        public final Failure copy(AMEError error, String message, Throwable cause) {
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

        public final AMEError getError() {
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
        public Failure(AMEError error, String message, Throwable th) {
            super(null);
            p.i(error, "error");
            p.i(message, "message");
            this.error = error;
            this.message = message;
            this.cause = th;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/stepos/ame/sdk/AMEngineResult$Success;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/stepos/ame/sdk/AMEngineResult;", UxipConstants.f30680s, "<init>", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", ChatTracker.CLICK_COPY, "(Ljava/lang/Object;)Lcom/stepos/ame/sdk/AMEngineResult$Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Success<T> extends AMEngineResult<T> {
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

    public /* synthetic */ AMEngineResult(i iVar) {
        this();
    }

    public final T getOrNull() {
        Success success = this instanceof Success ? (Success) this : null;
        if (success != null) {
            return (T) success.getValue();
        }
        return null;
    }

    public final T getOrThrow() throws AMEngineException {
        if (this instanceof Success) {
            return (T) ((Success) this).getValue();
        }
        if (!(this instanceof Failure)) {
            throw new NoWhenBranchMatchedException();
        }
        Failure failure = (Failure) this;
        throw new AMEngineException(failure.getError(), failure.getMessage(), failure.getCause());
    }

    public final AMEngineResult<T> onFailure(InterfaceC5074l<? super Failure, t> action) {
        p.i(action, "action");
        if (this instanceof Failure) {
            action.invoke(this);
        }
        return this;
    }

    public final AMEngineResult<T> onSuccess(InterfaceC5074l<? super T, t> action) {
        p.i(action, "action");
        if (this instanceof Success) {
            action.invoke((Object) ((Success) this).getValue());
        }
        return this;
    }

    private AMEngineResult() {
    }
}
