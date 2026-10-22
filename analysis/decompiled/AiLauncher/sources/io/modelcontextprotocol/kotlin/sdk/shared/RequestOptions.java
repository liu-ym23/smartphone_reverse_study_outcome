package io.modelcontextprotocol.kotlin.sdk.shared;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.modelcontextprotocol.kotlin.sdk.Progress;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0004\u0018\u0001`\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ$\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0004\u0018\u0001`\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000f\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ8\u0010\u0012\u001a\u00020\u00002\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0004\u0018\u0001`\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR+\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0004\u0018\u0001`\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\fR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b \u0010\u000e¨\u0006!"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/shared/RequestOptions;", "", "Lkotlin/Function1;", "Lio/modelcontextprotocol/kotlin/sdk/Progress;", "LY8/t;", "Lio/modelcontextprotocol/kotlin/sdk/shared/ProgressCallback;", "onProgress", "Lkotlin/time/a;", "timeout", "<init>", "(Lp9/l;JLkotlin/jvm/internal/i;)V", "component1", "()Lp9/l;", "component2-UwyO8pc", "()J", "component2", "copy-HG0u8IE", "(Lp9/l;J)Lio/modelcontextprotocol/kotlin/sdk/shared/RequestOptions;", ChatTracker.CLICK_COPY, "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lp9/l;", "getOnProgress", "J", "getTimeout-UwyO8pc", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RequestOptions {
    private final InterfaceC5074l<Progress, Y8.t> onProgress;
    private final long timeout;

    public /* synthetic */ RequestOptions(InterfaceC5074l interfaceC5074l, long j10, kotlin.jvm.internal.i iVar) {
        this(interfaceC5074l, j10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: copy-HG0u8IE$default, reason: not valid java name */
    public static /* synthetic */ RequestOptions m240copyHG0u8IE$default(RequestOptions requestOptions, InterfaceC5074l interfaceC5074l, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            interfaceC5074l = requestOptions.onProgress;
        }
        if ((i10 & 2) != 0) {
            j10 = requestOptions.timeout;
        }
        return requestOptions.m242copyHG0u8IE(interfaceC5074l, j10);
    }

    public final InterfaceC5074l<Progress, Y8.t> component1() {
        return this.onProgress;
    }

    /* renamed from: component2-UwyO8pc, reason: not valid java name and from getter */
    public final long getTimeout() {
        return this.timeout;
    }

    /* renamed from: copy-HG0u8IE, reason: not valid java name */
    public final RequestOptions m242copyHG0u8IE(InterfaceC5074l<? super Progress, Y8.t> onProgress, long timeout) {
        return new RequestOptions(onProgress, timeout, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequestOptions)) {
            return false;
        }
        RequestOptions requestOptions = (RequestOptions) other;
        return kotlin.jvm.internal.p.d(this.onProgress, requestOptions.onProgress) && kotlin.time.a.n(this.timeout, requestOptions.timeout);
    }

    public final InterfaceC5074l<Progress, Y8.t> getOnProgress() {
        return this.onProgress;
    }

    /* renamed from: getTimeout-UwyO8pc, reason: not valid java name */
    public final long m243getTimeoutUwyO8pc() {
        return this.timeout;
    }

    public int hashCode() {
        InterfaceC5074l<Progress, Y8.t> interfaceC5074l = this.onProgress;
        return ((interfaceC5074l == null ? 0 : interfaceC5074l.hashCode()) * 31) + kotlin.time.a.A(this.timeout);
    }

    public String toString() {
        return "RequestOptions(onProgress=" + this.onProgress + ", timeout=" + ((Object) kotlin.time.a.K(this.timeout)) + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    private RequestOptions(InterfaceC5074l<? super Progress, Y8.t> interfaceC5074l, long j10) {
        this.onProgress = interfaceC5074l;
        this.timeout = j10;
    }

    public /* synthetic */ RequestOptions(InterfaceC5074l interfaceC5074l, long j10, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : interfaceC5074l, (i10 & 2) != 0 ? ProtocolKt.getDEFAULT_REQUEST_TIMEOUT() : j10, null);
    }
}
