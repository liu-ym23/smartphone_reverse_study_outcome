package com.stepos.agentframework.adapter.dify;

import androidx.compose.foundation.b;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentframework.adapter.dify.bean.ErrorResult;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0002:\u0003\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016\u0082\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/stepos/agentframework/adapter/dify/HttpResult;", ExifInterface.GPS_DIRECTION_TRUE, "", AppAgent.CONSTRUCT, "()V", "toString", "", "Success", "Failure", "Error", "Lcom/stepos/agentframework/adapter/dify/HttpResult$Error;", "Lcom/stepos/agentframework/adapter/dify/HttpResult$Failure;", "Lcom/stepos/agentframework/adapter/dify/HttpResult$Success;", "dify_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class HttpResult<T> {

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\n\u001a\u00060\u0004j\u0002`\u0005HÆ\u0003J\u0017\u0010\u000b\u001a\u00020\u00002\f\b\u0002\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0015\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/stepos/agentframework/adapter/dify/HttpResult$Error;", "Lcom/stepos/agentframework/adapter/dify/HttpResult;", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", AppAgent.CONSTRUCT, "(Ljava/lang/Exception;)V", "getException", "()Ljava/lang/Exception;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "dify_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Error extends HttpResult {
        private final Exception exception;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(Exception exception) {
            super(null);
            k.f(exception, "exception");
            this.exception = exception;
        }

        public static /* synthetic */ Error copy$default(Error error, Exception exc, int i, Object obj) {
            if ((i & 1) != 0) {
                exc = error.exception;
            }
            return error.copy(exc);
        }

        /* renamed from: component1, reason: from getter */
        public final Exception getException() {
            return this.exception;
        }

        public final Error copy(Exception exception) {
            k.f(exception, "exception");
            return new Error(exception);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Error) && k.b(this.exception, ((Error) other).exception);
        }

        public final Exception getException() {
            return this.exception;
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        @Override // com.stepos.agentframework.adapter.dify.HttpResult
        public String toString() {
            return "Error(exception=" + this.exception + ")";
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentframework/adapter/dify/HttpResult$Failure;", "Lcom/stepos/agentframework/adapter/dify/HttpResult;", "", "errorResult", "Lcom/stepos/agentframework/adapter/dify/bean/ErrorResult;", AppAgent.CONSTRUCT, "(Lcom/stepos/agentframework/adapter/dify/bean/ErrorResult;)V", "getErrorResult", "()Lcom/stepos/agentframework/adapter/dify/bean/ErrorResult;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "dify_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Failure extends HttpResult {
        private final ErrorResult errorResult;

        public Failure(ErrorResult errorResult) {
            super(null);
            this.errorResult = errorResult;
        }

        public static /* synthetic */ Failure copy$default(Failure failure, ErrorResult errorResult, int i, Object obj) {
            if ((i & 1) != 0) {
                errorResult = failure.errorResult;
            }
            return failure.copy(errorResult);
        }

        /* renamed from: component1, reason: from getter */
        public final ErrorResult getErrorResult() {
            return this.errorResult;
        }

        public final Failure copy(ErrorResult errorResult) {
            return new Failure(errorResult);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Failure) && k.b(this.errorResult, ((Failure) other).errorResult);
        }

        public final ErrorResult getErrorResult() {
            return this.errorResult;
        }

        public int hashCode() {
            ErrorResult errorResult = this.errorResult;
            if (errorResult == null) {
                return 0;
            }
            return errorResult.hashCode();
        }

        @Override // com.stepos.agentframework.adapter.dify.HttpResult
        public String toString() {
            return "Failure(errorResult=" + this.errorResult + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\n\b\u0001\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\n\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\bJ\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0004\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/stepos/agentframework/adapter/dify/HttpResult$Success;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/stepos/agentframework/adapter/dify/HttpResult;", SettingsConfig.KEY_DATA, AppAgent.CONSTRUCT, "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/stepos/agentframework/adapter/dify/HttpResult$Success;", "equals", "", "other", "hashCode", "", "toString", "", "dify_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Success<T> extends HttpResult<T> {
        private final T data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(T data) {
            super(null);
            k.f(data, "data");
            this.data = data;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success copy$default(Success success, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = success.data;
            }
            return success.copy(obj);
        }

        public final T component1() {
            return this.data;
        }

        public final Success<T> copy(T data) {
            k.f(data, "data");
            return new Success<>(data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Success) && k.b(this.data, ((Success) other).data);
        }

        public final T getData() {
            return this.data;
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        @Override // com.stepos.agentframework.adapter.dify.HttpResult
        public String toString() {
            return b.s(this.data, "Success(data=", ")");
        }
    }

    public /* synthetic */ HttpResult(e eVar) {
        this();
    }

    public String toString() {
        if (this instanceof Success) {
            return b.s(((Success) this).getData(), "Success[data=", "]");
        }
        if (this instanceof Failure) {
            return "Failure[reason=" + ((Failure) this).getErrorResult() + "]";
        }
        if (!(this instanceof Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return "Error[exception=" + ((Error) this).getException() + "]";
    }

    private HttpResult() {
    }
}
