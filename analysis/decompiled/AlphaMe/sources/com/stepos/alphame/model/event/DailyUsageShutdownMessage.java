package com.stepos.alphame.model.event;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/stepos/alphame/model/event/DailyUsageShutdownMessage;", "Lcom/stepos/alphame/model/event/DailyUsageMessage;", "requestTime", "", "(J)V", "getRequestTime", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "model_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DailyUsageShutdownMessage implements DailyUsageMessage {
    private final long requestTime;

    public DailyUsageShutdownMessage(long j4) {
        this.requestTime = j4;
    }

    public static /* synthetic */ DailyUsageShutdownMessage copy$default(DailyUsageShutdownMessage dailyUsageShutdownMessage, long j4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j4 = dailyUsageShutdownMessage.requestTime;
        }
        return dailyUsageShutdownMessage.copy(j4);
    }

    /* renamed from: component1, reason: from getter */
    public final long getRequestTime() {
        return this.requestTime;
    }

    @NotNull
    public final DailyUsageShutdownMessage copy(long requestTime) {
        return new DailyUsageShutdownMessage(requestTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DailyUsageShutdownMessage) && this.requestTime == ((DailyUsageShutdownMessage) other).requestTime;
    }

    @Override // com.stepos.alphame.model.event.DailyUsageMessage
    public long getRequestTime() {
        return this.requestTime;
    }

    public int hashCode() {
        return Long.hashCode(this.requestTime);
    }

    @NotNull
    public String toString() {
        return "DailyUsageShutdownMessage(requestTime=" + this.requestTime + ")";
    }
}
