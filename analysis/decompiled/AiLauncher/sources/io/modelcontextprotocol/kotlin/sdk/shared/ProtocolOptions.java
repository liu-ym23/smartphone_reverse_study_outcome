package io.modelcontextprotocol.kotlin.sdk.shared;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/shared/ProtocolOptions;", "", "", "enforceStrictCapabilities", "Lkotlin/time/a;", "timeout", "<init>", "(ZJLkotlin/jvm/internal/i;)V", "Z", "getEnforceStrictCapabilities", "()Z", "setEnforceStrictCapabilities", "(Z)V", "J", "getTimeout-UwyO8pc", "()J", "setTimeout-LRDsOJo", "(J)V", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public class ProtocolOptions {
    private boolean enforceStrictCapabilities;
    private long timeout;

    public /* synthetic */ ProtocolOptions(boolean z10, long j10, kotlin.jvm.internal.i iVar) {
        this(z10, j10);
    }

    public final boolean getEnforceStrictCapabilities() {
        return this.enforceStrictCapabilities;
    }

    /* renamed from: getTimeout-UwyO8pc, reason: not valid java name and from getter */
    public final long getTimeout() {
        return this.timeout;
    }

    public final void setEnforceStrictCapabilities(boolean z10) {
        this.enforceStrictCapabilities = z10;
    }

    /* renamed from: setTimeout-LRDsOJo, reason: not valid java name */
    public final void m239setTimeoutLRDsOJo(long j10) {
        this.timeout = j10;
    }

    private ProtocolOptions(boolean z10, long j10) {
        this.enforceStrictCapabilities = z10;
        this.timeout = j10;
    }

    public /* synthetic */ ProtocolOptions(boolean z10, long j10, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? ProtocolKt.getDEFAULT_REQUEST_TIMEOUT() : j10, null);
    }
}
