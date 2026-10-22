package com.stepos.core.callback;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.trace.g;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.core.data.base.Content;
import com.stepos.core.error.AIEngineError;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 '*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\u00020\u0003:\u0007()*+,-'B\t\b\u0004¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\bJ\r\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\bJ\r\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\bJ\r\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\bJ\r\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\bJ\r\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\bJ\u000f\u0010\u0010\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u001e¢\u0006\u0004\b\u001f\u0010 J7\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\b\b\u0001\u0010\"*\u00020\u00012\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010#H\u0086\bø\u0001\u0000¢\u0006\u0004\b%\u0010&\u0082\u0001\u0006\u0015.\u0012/01\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00062"}, d2 = {"Lcom/stepos/core/callback/InferResult;", "Lcom/stepos/core/data/base/Content;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "", "isResult", "()Z", "isComplete", "isError", "isCancelled", "isTerminal", "isSuccessTerminal", "isFailureTerminal", "isRoutingDecision", "getOrNull", "()Lcom/stepos/core/data/base/Content;", "Lcom/stepos/core/callback/InferResult$Error;", "getErrorOrNull", "()Lcom/stepos/core/callback/InferResult$Error;", "Lcom/stepos/core/callback/InferResult$Cancelled;", "getCancelledOrNull", "()Lcom/stepos/core/callback/InferResult$Cancelled;", "", "getErrorCode", "()Ljava/lang/Integer;", "", "getErrorMessage", "()Ljava/lang/String;", "Lkotlin/Result;", "toKotlinResult-d1pmJ48", "()Ljava/lang/Object;", "toKotlinResult", "R", "Lkotlin/Function1;", "transform", C3081a.FOCUS_MAP_NAME, "(Lp9/l;)Lcom/stepos/core/callback/InferResult;", "Companion", "Result", "Complete", "Error", "Cancelled", "Progress", "RoutingDecision", "Lcom/stepos/core/callback/InferResult$Complete;", "Lcom/stepos/core/callback/InferResult$Progress;", "Lcom/stepos/core/callback/InferResult$Result;", "Lcom/stepos/core/callback/InferResult$RoutingDecision;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class InferResult<T extends Content> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJ\b\u0010\u0011\u001a\u00020\u0006H\u0016J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/stepos/core/callback/InferResult$Cancelled;", "Lcom/stepos/core/callback/InferResult;", "", "reason", "", "message", "", "<init>", "(ILjava/lang/String;)V", "getReason", "()I", "getMessage", "()Ljava/lang/String;", "isUserCancelled", "", "isTimeout", "isInterrupted", "toString", "component1", "component2", ChatTracker.CLICK_COPY, "equals", "other", "", "hashCode", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Cancelled extends InferResult {
        private final String message;
        private final int reason;

        /* JADX WARN: Multi-variable type inference failed */
        public Cancelled() {
            this(0, null, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Cancelled copy$default(Cancelled cancelled, int i10, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = cancelled.reason;
            }
            if ((i11 & 2) != 0) {
                str = cancelled.message;
            }
            return cancelled.copy(i10, str);
        }

        /* renamed from: component1, reason: from getter */
        public final int getReason() {
            return this.reason;
        }

        /* renamed from: component2, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Cancelled copy(int reason, String message) {
            p.i(message, "message");
            return new Cancelled(reason, message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Cancelled)) {
                return false;
            }
            Cancelled cancelled = (Cancelled) other;
            return this.reason == cancelled.reason && p.d(this.message, cancelled.message);
        }

        public final String getMessage() {
            return this.message;
        }

        public final int getReason() {
            return this.reason;
        }

        public int hashCode() {
            return (Integer.hashCode(this.reason) * 31) + this.message.hashCode();
        }

        public final boolean isInterrupted() {
            return this.reason == -102;
        }

        public final boolean isTimeout() {
            return this.reason == -101;
        }

        public final boolean isUserCancelled() {
            return this.reason == -100;
        }

        public String toString() {
            return "InferResult.Cancelled(" + this.reason + ": " + this.message + ")";
        }

        public /* synthetic */ Cancelled(int i10, String str, int i11, i iVar) {
            this((i11 & 1) != 0 ? -100 : i10, (i11 & 2) != 0 ? AIEngineError.INSTANCE.getMessage(-100) : str);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Cancelled(int i10, String message) {
            super(null);
            p.i(message, "message");
            this.reason = i10;
            this.message = message;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0001\u0010\u0006*\u00020\u00072\u0006\u0010\b\u001a\u0002H\u0006¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0001\u0010\u0006*\u00020\u0007J&\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0001\u0010\u0006*\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0001\u0010\u0006*\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ \u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0001\u0010\u0006*\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ \u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0001\u0010\u0006*\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ \u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0001\u0010\u0006*\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ&\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0001\u0010\u0006*\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f¨\u0006\u0014"}, d2 = {"Lcom/stepos/core/callback/InferResult$Companion;", "", "<init>", "()V", "success", "Lcom/stepos/core/callback/InferResult;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/stepos/core/data/base/Content;", UxipConstants.f30680s, "(Lcom/stepos/core/data/base/Content;)Lcom/stepos/core/callback/InferResult;", "complete", "error", "errorCode", "", "message", "", "cancelled", "timeout", g.END_INTERRUPTED, "fromErrorCode", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public static /* synthetic */ InferResult cancelled$default(Companion companion, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = "User cancelled";
            }
            return companion.cancelled(str);
        }

        public static /* synthetic */ InferResult interrupted$default(Companion companion, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = "System interrupted";
            }
            return companion.interrupted(str);
        }

        public static /* synthetic */ InferResult timeout$default(Companion companion, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = "Inference timeout";
            }
            return companion.timeout(str);
        }

        public final <T extends Content> InferResult<T> cancelled(String message) {
            p.i(message, "message");
            return new Cancelled(-100, message);
        }

        public final <T extends Content> InferResult<T> complete() {
            return Complete.INSTANCE;
        }

        public final <T extends Content> InferResult<T> error(int errorCode, String message) {
            p.i(message, "message");
            return new Error(errorCode, message);
        }

        public final <T extends Content> InferResult<T> fromErrorCode(int errorCode, String message) {
            p.i(message, "message");
            return AIEngineError.INSTANCE.isCancellation(errorCode) ? new Cancelled(errorCode, message) : new Error(errorCode, message);
        }

        public final <T extends Content> InferResult<T> interrupted(String message) {
            p.i(message, "message");
            return new Cancelled(AIEngineError.INTERRUPTED, message);
        }

        public final <T extends Content> InferResult<T> success(T value) {
            p.i(value, "value");
            return new Result(value);
        }

        public final <T extends Content> InferResult<T> timeout(String message) {
            p.i(message, "message");
            return new Cancelled(AIEngineError.TIMEOUT, message);
        }

        private Companion() {
        }

        public final <T extends Content> InferResult<T> error(int errorCode) {
            return new Error(errorCode, AIEngineError.INSTANCE.getMessage(errorCode));
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/stepos/core/callback/InferResult$Complete;", "Lcom/stepos/core/callback/InferResult;", "", "<init>", "()V", "toString", "", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Complete extends InferResult {
        public static final Complete INSTANCE = new Complete();

        private Complete() {
            super(null);
        }

        public String toString() {
            return "InferResult.Complete";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\b\u0010\u0010\u001a\u00020\u0006H\u0016J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/stepos/core/callback/InferResult$Error;", "Lcom/stepos/core/callback/InferResult;", "", "errorCode", "", "message", "", "<init>", "(ILjava/lang/String;)V", "getErrorCode", "()I", "getMessage", "()Ljava/lang/String;", "isSystemError", "", "isBusinessError", "toString", "component1", "component2", ChatTracker.CLICK_COPY, "equals", "other", "", "hashCode", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Error extends InferResult {
        private final int errorCode;
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(int i10, String message) {
            super(null);
            p.i(message, "message");
            this.errorCode = i10;
            this.message = message;
        }

        public static /* synthetic */ Error copy$default(Error error, int i10, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = error.errorCode;
            }
            if ((i11 & 2) != 0) {
                str = error.message;
            }
            return error.copy(i10, str);
        }

        /* renamed from: component1, reason: from getter */
        public final int getErrorCode() {
            return this.errorCode;
        }

        /* renamed from: component2, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Error copy(int errorCode, String message) {
            p.i(message, "message");
            return new Error(errorCode, message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            Error error = (Error) other;
            return this.errorCode == error.errorCode && p.d(this.message, error.message);
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return (Integer.hashCode(this.errorCode) * 31) + this.message.hashCode();
        }

        public final boolean isBusinessError() {
            return AIEngineError.INSTANCE.isBusinessError(this.errorCode);
        }

        public final boolean isSystemError() {
            return AIEngineError.INSTANCE.isSystemError(this.errorCode);
        }

        public String toString() {
            return "InferResult.Error(" + this.errorCode + ": " + this.message + ")";
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/stepos/core/callback/InferResult$Progress;", "Lcom/stepos/core/callback/InferResult;", "", "percent", "", "extra", "Lcom/stepos/core/data/base/Content;", "<init>", "(ILcom/stepos/core/data/base/Content;)V", "getPercent", "()I", "getExtra", "()Lcom/stepos/core/data/base/Content;", "toString", "", "component1", "component2", ChatTracker.CLICK_COPY, "equals", "", "other", "", "hashCode", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Progress extends InferResult {
        private final Content extra;
        private final int percent;

        public Progress(int i10, Content content) {
            super(null);
            this.percent = i10;
            this.extra = content;
        }

        public static /* synthetic */ Progress copy$default(Progress progress, int i10, Content content, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = progress.percent;
            }
            if ((i11 & 2) != 0) {
                content = progress.extra;
            }
            return progress.copy(i10, content);
        }

        /* renamed from: component1, reason: from getter */
        public final int getPercent() {
            return this.percent;
        }

        /* renamed from: component2, reason: from getter */
        public final Content getExtra() {
            return this.extra;
        }

        public final Progress copy(int percent, Content extra) {
            return new Progress(percent, extra);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Progress)) {
                return false;
            }
            Progress progress = (Progress) other;
            return this.percent == progress.percent && p.d(this.extra, progress.extra);
        }

        public final Content getExtra() {
            return this.extra;
        }

        public final int getPercent() {
            return this.percent;
        }

        public int hashCode() {
            int iHashCode = Integer.hashCode(this.percent) * 31;
            Content content = this.extra;
            return iHashCode + (content == null ? 0 : content.hashCode());
        }

        public String toString() {
            return "InferResult.Progress(" + this.percent + "%)";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\n\b\u0001\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\n\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\bJ\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/stepos/core/callback/InferResult$Result;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/stepos/core/data/base/Content;", "Lcom/stepos/core/callback/InferResult;", UxipConstants.f30680s, "<init>", "(Lcom/stepos/core/data/base/Content;)V", "getValue", "()Lcom/stepos/core/data/base/Content;", "Lcom/stepos/core/data/base/Content;", "component1", ChatTracker.CLICK_COPY, "(Lcom/stepos/core/data/base/Content;)Lcom/stepos/core/callback/InferResult$Result;", "equals", "", "other", "", "hashCode", "", "toString", "", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Result<T extends Content> extends InferResult<T> {
        private final T value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Result(T value) {
            super(null);
            p.i(value, "value");
            this.value = value;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Result copy$default(Result result, Content content, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                content = result.value;
            }
            return result.copy(content);
        }

        public final T component1() {
            return this.value;
        }

        public final Result<T> copy(T value) {
            p.i(value, "value");
            return new Result<>(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Result) && p.d(this.value, ((Result) other).value);
        }

        public final T getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "Result(value=" + this.value + ")";
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/stepos/core/callback/InferResult$RoutingDecision;", "Lcom/stepos/core/callback/InferResult;", "", "executionLocation", "", "reason", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getExecutionLocation", "()Ljava/lang/String;", "getReason", "toString", "component1", "component2", ChatTracker.CLICK_COPY, "equals", "", "other", "", "hashCode", "", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class RoutingDecision extends InferResult {
        private final String executionLocation;
        private final String reason;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RoutingDecision(String executionLocation, String reason) {
            super(null);
            p.i(executionLocation, "executionLocation");
            p.i(reason, "reason");
            this.executionLocation = executionLocation;
            this.reason = reason;
        }

        public static /* synthetic */ RoutingDecision copy$default(RoutingDecision routingDecision, String str, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = routingDecision.executionLocation;
            }
            if ((i10 & 2) != 0) {
                str2 = routingDecision.reason;
            }
            return routingDecision.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getExecutionLocation() {
            return this.executionLocation;
        }

        /* renamed from: component2, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        public final RoutingDecision copy(String executionLocation, String reason) {
            p.i(executionLocation, "executionLocation");
            p.i(reason, "reason");
            return new RoutingDecision(executionLocation, reason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RoutingDecision)) {
                return false;
            }
            RoutingDecision routingDecision = (RoutingDecision) other;
            return p.d(this.executionLocation, routingDecision.executionLocation) && p.d(this.reason, routingDecision.reason);
        }

        public final String getExecutionLocation() {
            return this.executionLocation;
        }

        public final String getReason() {
            return this.reason;
        }

        public int hashCode() {
            return (this.executionLocation.hashCode() * 31) + this.reason.hashCode();
        }

        public String toString() {
            return "InferResult.RoutingDecision(" + this.executionLocation + ")";
        }
    }

    public /* synthetic */ InferResult(i iVar) {
        this();
    }

    public final Cancelled getCancelledOrNull() {
        if (this instanceof Cancelled) {
            return (Cancelled) this;
        }
        return null;
    }

    public final Integer getErrorCode() {
        if (this instanceof Error) {
            return Integer.valueOf(((Error) this).getErrorCode());
        }
        if (this instanceof Cancelled) {
            return Integer.valueOf(((Cancelled) this).getReason());
        }
        return null;
    }

    public final String getErrorMessage() {
        if (this instanceof Error) {
            return ((Error) this).getMessage();
        }
        if (this instanceof Cancelled) {
            return ((Cancelled) this).getMessage();
        }
        return null;
    }

    public final Error getErrorOrNull() {
        if (this instanceof Error) {
            return (Error) this;
        }
        return null;
    }

    public final T getOrNull() {
        Result result = this instanceof Result ? (Result) this : null;
        if (result != null) {
            return (T) result.getValue();
        }
        return null;
    }

    public final boolean isCancelled() {
        return this instanceof Cancelled;
    }

    public final boolean isComplete() {
        return this instanceof Complete;
    }

    public final boolean isError() {
        return this instanceof Error;
    }

    public final boolean isFailureTerminal() {
        return (this instanceof Error) || (this instanceof Cancelled);
    }

    public final boolean isResult() {
        return this instanceof Result;
    }

    public final boolean isRoutingDecision() {
        return this instanceof RoutingDecision;
    }

    public final boolean isSuccessTerminal() {
        return this instanceof Complete;
    }

    public final boolean isTerminal() {
        return (this instanceof Complete) || (this instanceof Error) || (this instanceof Cancelled);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R extends Content> InferResult<R> map(InterfaceC5074l<? super T, ? extends R> transform) {
        p.i(transform, "transform");
        if (this instanceof Result) {
            return new Result(transform.invoke(((Result) this).getValue()));
        }
        if (this instanceof Complete) {
            return Complete.INSTANCE;
        }
        if ((this instanceof Error) || (this instanceof Cancelled) || (this instanceof Progress) || (this instanceof RoutingDecision)) {
            return this;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: toKotlinResult-d1pmJ48, reason: not valid java name */
    public final Object m60toKotlinResultd1pmJ48() {
        if (this instanceof Result) {
            Result.Companion companion = kotlin.Result.INSTANCE;
            return kotlin.Result.b(((Result) this).getValue());
        }
        if (this instanceof Complete) {
            return kotlin.Result.b(null);
        }
        if (this instanceof Error) {
            Result.Companion companion2 = kotlin.Result.INSTANCE;
            Error error = (Error) this;
            return kotlin.Result.b(C4849c.a(new AIEngineException(error.getErrorCode(), error.getMessage())));
        }
        if (this instanceof Cancelled) {
            Result.Companion companion3 = kotlin.Result.INSTANCE;
            Cancelled cancelled = (Cancelled) this;
            return kotlin.Result.b(C4849c.a(new CancellationException(cancelled.getReason(), cancelled.getMessage())));
        }
        if (!(this instanceof Progress) && !(this instanceof RoutingDecision)) {
            throw new NoWhenBranchMatchedException();
        }
        return kotlin.Result.b(null);
    }

    private InferResult() {
    }
}
