package io.ktor.server.engine;

import io.ktor.util.date.DateJvmKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/server/engine/StartupInfo;", "", "<init>", "()V", "", "isFirstLoading", "Z", "()Z", "setFirstLoading", "(Z)V", "", "initializedStartAt", "J", "getInitializedStartAt", "()J", "setInitializedStartAt", "(J)V", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
final class StartupInfo {
    private boolean isFirstLoading = true;
    private long initializedStartAt = DateJvmKt.getTimeMillis();

    public final long getInitializedStartAt() {
        return this.initializedStartAt;
    }

    /* renamed from: isFirstLoading, reason: from getter */
    public final boolean getIsFirstLoading() {
        return this.isFirstLoading;
    }

    public final void setFirstLoading(boolean z10) {
        this.isFirstLoading = z10;
    }

    public final void setInitializedStartAt(long j10) {
        this.initializedStartAt = j10;
    }
}
