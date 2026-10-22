package io.ktor.server.cio;

import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/server/cio/UnixSocketServerSettings;", "", "", "socketPath", "", "connectionIdleTimeoutSeconds", "<init>", "(Ljava/lang/String;J)V", "Ljava/lang/String;", "getSocketPath", "()Ljava/lang/String;", "J", "getConnectionIdleTimeoutSeconds", "()J", "ktor-server-cio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UnixSocketServerSettings {
    private final long connectionIdleTimeoutSeconds;
    private final String socketPath;

    public UnixSocketServerSettings(String socketPath, long j10) {
        p.i(socketPath, "socketPath");
        this.socketPath = socketPath;
        this.connectionIdleTimeoutSeconds = j10;
    }

    public final long getConnectionIdleTimeoutSeconds() {
        return this.connectionIdleTimeoutSeconds;
    }

    public final String getSocketPath() {
        return this.socketPath;
    }

    public /* synthetic */ UnixSocketServerSettings(String str, long j10, int i10, i iVar) {
        this(str, (i10 & 2) != 0 ? 45L : j10);
    }
}
