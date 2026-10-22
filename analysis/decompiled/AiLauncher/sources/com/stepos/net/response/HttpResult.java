package com.stepos.net.response;

import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.net.exception.ApiException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0002\u001c\u001dB\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\n\u0010\u0006J-\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u000bH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f0\u000bH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u000fJ3\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u000fJ\u0013\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0004\b\u0016\u0010\u0006R\u0011\u0010\u0019\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001a\u0082\u0001\u0002\u001e\u001f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006 "}, d2 = {"Lcom/stepos/net/response/HttpResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "getOrNull", "()Ljava/lang/Object;", "default", "getOrElse", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrThrow", "Lkotlin/Function1;", "LY8/t;", "action", "onSuccess", "(Lp9/l;)Lcom/stepos/net/response/HttpResult;", "Lcom/stepos/net/exception/ApiException;", "onError", "R", "transform", C3081a.FOCUS_MAP_NAME, "Lkotlin/Result;", "toKotlinResult-d1pmJ48", "toKotlinResult", "", "isSuccess", "()Z", "isError", "Success", "Error", "Lcom/stepos/net/response/HttpResult$Error;", "Lcom/stepos/net/response/HttpResult$Success;", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class HttpResult<T> {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/net/response/HttpResult$Error;", "Lcom/stepos/net/response/HttpResult;", "", "exception", "Lcom/stepos/net/exception/ApiException;", "<init>", "(Lcom/stepos/net/exception/ApiException;)V", "getException", "()Lcom/stepos/net/exception/ApiException;", "component1", ChatTracker.CLICK_COPY, "equals", "", "other", "", "hashCode", "", "toString", "", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Error extends HttpResult {
        private final ApiException exception;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(ApiException exception) {
            super(null);
            p.i(exception, "exception");
            this.exception = exception;
        }

        public static /* synthetic */ Error copy$default(Error error, ApiException apiException, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                apiException = error.exception;
            }
            return error.copy(apiException);
        }

        /* renamed from: component1, reason: from getter */
        public final ApiException getException() {
            return this.exception;
        }

        public final Error copy(ApiException exception) {
            p.i(exception, "exception");
            return new Error(exception);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Error) && p.d(this.exception, ((Error) other).exception);
        }

        public final ApiException getException() {
            return this.exception;
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "Error(exception=" + this.exception + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/stepos/net/response/HttpResult$Success;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/stepos/net/response/HttpResult;", "data", "<init>", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", ChatTracker.CLICK_COPY, "(Ljava/lang/Object;)Lcom/stepos/net/response/HttpResult$Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Success<T> extends HttpResult<T> {
        private final T data;

        public Success(T t10) {
            super(null);
            this.data = t10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success copy$default(Success success, Object obj, int i10, Object obj2) {
            if ((i10 & 1) != 0) {
                obj = success.data;
            }
            return success.copy(obj);
        }

        public final T component1() {
            return this.data;
        }

        public final Success<T> copy(T data) {
            return new Success<>(data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Success) && p.d(this.data, ((Success) other).data);
        }

        public final T getData() {
            return this.data;
        }

        public int hashCode() {
            T t10 = this.data;
            if (t10 == null) {
                return 0;
            }
            return t10.hashCode();
        }

        public String toString() {
            return "Success(data=" + this.data + ")";
        }
    }

    public /* synthetic */ HttpResult(i iVar) {
        this();
    }

    public final T getOrElse(T t10) {
        T t11;
        Success success = this instanceof Success ? (Success) this : null;
        return (success == null || (t11 = (T) success.getData()) == null) ? t10 : t11;
    }

    public final T getOrNull() {
        Success success = this instanceof Success ? (Success) this : null;
        if (success != null) {
            return (T) success.getData();
        }
        return null;
    }

    public final T getOrThrow() {
        if (this instanceof Success) {
            return (T) ((Success) this).getData();
        }
        if (this instanceof Error) {
            throw ((Error) this).getException();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean isError() {
        return this instanceof Error;
    }

    public final boolean isSuccess() {
        return this instanceof Success;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> HttpResult<R> map(InterfaceC5074l<? super T, ? extends R> transform) {
        p.i(transform, "transform");
        if (this instanceof Success) {
            return new Success(transform.invoke((Object) ((Success) this).getData()));
        }
        if (this instanceof Error) {
            return this;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final HttpResult<T> onError(InterfaceC5074l<? super ApiException, t> action) {
        p.i(action, "action");
        if (this instanceof Error) {
            action.invoke(((Error) this).getException());
        }
        return this;
    }

    public final HttpResult<T> onSuccess(InterfaceC5074l<? super T, t> action) {
        p.i(action, "action");
        if (this instanceof Success) {
            action.invoke((Object) ((Success) this).getData());
        }
        return this;
    }

    /* renamed from: toKotlinResult-d1pmJ48, reason: not valid java name */
    public final Object m64toKotlinResultd1pmJ48() {
        if (this instanceof Success) {
            Result.Companion companion = Result.INSTANCE;
            return Result.b(((Success) this).getData());
        }
        if (!(this instanceof Error)) {
            throw new NoWhenBranchMatchedException();
        }
        Result.Companion companion2 = Result.INSTANCE;
        return Result.b(C4849c.a(((Error) this).getException()));
    }

    private HttpResult() {
    }
}
