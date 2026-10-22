package com.stepos.alphame.model.event;

import B0.g;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/stepos/alphame/model/event/DailyUsageDataClearMessage;", "Lcom/stepos/alphame/model/event/DailyUsageMessage;", "requestTime", "", "mode", "", "userId", "(JIJ)V", "getMode", "()I", "getRequestTime", "()J", "getUserId", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "model_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DailyUsageDataClearMessage implements DailyUsageMessage {
    private final int mode;
    private final long requestTime;
    private final long userId;

    public DailyUsageDataClearMessage(long j4, int i4, long j5) {
        this.requestTime = j4;
        this.mode = i4;
        this.userId = j5;
    }

    public static /* synthetic */ DailyUsageDataClearMessage copy$default(DailyUsageDataClearMessage dailyUsageDataClearMessage, long j4, int i4, long j5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            j4 = dailyUsageDataClearMessage.requestTime;
        }
        long j6 = j4;
        if ((i5 & 2) != 0) {
            i4 = dailyUsageDataClearMessage.mode;
        }
        int i6 = i4;
        if ((i5 & 4) != 0) {
            j5 = dailyUsageDataClearMessage.userId;
        }
        return dailyUsageDataClearMessage.copy(j6, i6, j5);
    }

    /* renamed from: component1, reason: from getter */
    public final long getRequestTime() {
        return this.requestTime;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMode() {
        return this.mode;
    }

    /* renamed from: component3, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    @NotNull
    public final DailyUsageDataClearMessage copy(long requestTime, int mode, long userId) {
        return new DailyUsageDataClearMessage(requestTime, mode, userId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DailyUsageDataClearMessage)) {
            return false;
        }
        DailyUsageDataClearMessage dailyUsageDataClearMessage = (DailyUsageDataClearMessage) other;
        return this.requestTime == dailyUsageDataClearMessage.requestTime && this.mode == dailyUsageDataClearMessage.mode && this.userId == dailyUsageDataClearMessage.userId;
    }

    public final int getMode() {
        return this.mode;
    }

    @Override // com.stepos.alphame.model.event.DailyUsageMessage
    public long getRequestTime() {
        return this.requestTime;
    }

    public final long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return Long.hashCode(this.userId) + g.d(this.mode, Long.hashCode(this.requestTime) * 31, 31);
    }

    @NotNull
    public String toString() {
        return "DailyUsageDataClearMessage(requestTime=" + this.requestTime + ", mode=" + this.mode + ", userId=" + this.userId + ")";
    }
}
