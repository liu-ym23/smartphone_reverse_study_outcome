package com.mdisdk.action;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowStateInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/mdisdk/action/WaitArgs;", "", "durationInMs", "", WindowStateInfo.KEY_DISPLAY_ID, "", AppAgent.CONSTRUCT, "(JLjava/lang/Integer;)V", "getDurationInMs", "()J", "getDisplayId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(JLjava/lang/Integer;)Lcom/mdisdk/action/WaitArgs;", "equals", "", "other", "hashCode", "toString", "", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class WaitArgs {
    private final Integer displayId;
    private final long durationInMs;

    public WaitArgs(long j5, Integer num) {
        this.durationInMs = j5;
        this.displayId = num;
    }

    public static /* synthetic */ WaitArgs copy$default(WaitArgs waitArgs, long j5, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            j5 = waitArgs.durationInMs;
        }
        if ((i & 2) != 0) {
            num = waitArgs.displayId;
        }
        return waitArgs.copy(j5, num);
    }

    /* renamed from: component1, reason: from getter */
    public final long getDurationInMs() {
        return this.durationInMs;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getDisplayId() {
        return this.displayId;
    }

    public final WaitArgs copy(long durationInMs, Integer displayId) {
        return new WaitArgs(durationInMs, displayId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WaitArgs)) {
            return false;
        }
        WaitArgs waitArgs = (WaitArgs) other;
        return this.durationInMs == waitArgs.durationInMs && k.b(this.displayId, waitArgs.displayId);
    }

    public final Integer getDisplayId() {
        return this.displayId;
    }

    public final long getDurationInMs() {
        return this.durationInMs;
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.durationInMs) * 31;
        Integer num = this.displayId;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "WaitArgs(durationInMs=" + this.durationInMs + ", displayId=" + this.displayId + ')';
    }
}
