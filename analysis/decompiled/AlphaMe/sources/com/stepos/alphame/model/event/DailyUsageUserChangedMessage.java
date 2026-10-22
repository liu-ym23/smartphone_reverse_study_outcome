package com.stepos.alphame.model.event;

import B0.g;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/stepos/alphame/model/event/DailyUsageUserChangedMessage;", "Lcom/stepos/alphame/model/event/DailyUsageMessage;", "requestTime", "", "currentMode", "", "currentUserId", "oldUserId", "(JIJJ)V", "getCurrentMode", "()I", "getCurrentUserId", "()J", "getOldUserId", "getRequestTime", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "model_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DailyUsageUserChangedMessage implements DailyUsageMessage {
    private final int currentMode;
    private final long currentUserId;
    private final long oldUserId;
    private final long requestTime;

    public DailyUsageUserChangedMessage(long j4, int i4, long j5, long j6) {
        this.requestTime = j4;
        this.currentMode = i4;
        this.currentUserId = j5;
        this.oldUserId = j6;
    }

    /* renamed from: component1, reason: from getter */
    public final long getRequestTime() {
        return this.requestTime;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCurrentMode() {
        return this.currentMode;
    }

    /* renamed from: component3, reason: from getter */
    public final long getCurrentUserId() {
        return this.currentUserId;
    }

    /* renamed from: component4, reason: from getter */
    public final long getOldUserId() {
        return this.oldUserId;
    }

    @NotNull
    public final DailyUsageUserChangedMessage copy(long requestTime, int currentMode, long currentUserId, long oldUserId) {
        return new DailyUsageUserChangedMessage(requestTime, currentMode, currentUserId, oldUserId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DailyUsageUserChangedMessage)) {
            return false;
        }
        DailyUsageUserChangedMessage dailyUsageUserChangedMessage = (DailyUsageUserChangedMessage) other;
        return this.requestTime == dailyUsageUserChangedMessage.requestTime && this.currentMode == dailyUsageUserChangedMessage.currentMode && this.currentUserId == dailyUsageUserChangedMessage.currentUserId && this.oldUserId == dailyUsageUserChangedMessage.oldUserId;
    }

    public final int getCurrentMode() {
        return this.currentMode;
    }

    public final long getCurrentUserId() {
        return this.currentUserId;
    }

    public final long getOldUserId() {
        return this.oldUserId;
    }

    @Override // com.stepos.alphame.model.event.DailyUsageMessage
    public long getRequestTime() {
        return this.requestTime;
    }

    public int hashCode() {
        return Long.hashCode(this.oldUserId) + g.f(this.currentUserId, g.d(this.currentMode, Long.hashCode(this.requestTime) * 31, 31), 31);
    }

    @NotNull
    public String toString() {
        long j4 = this.requestTime;
        int i4 = this.currentMode;
        long j5 = this.currentUserId;
        long j6 = this.oldUserId;
        StringBuilder sb = new StringBuilder("DailyUsageUserChangedMessage(requestTime=");
        sb.append(j4);
        sb.append(", currentMode=");
        sb.append(i4);
        sb.append(", currentUserId=");
        sb.append(j5);
        sb.append(", oldUserId=");
        return g.p(sb, j6, ")");
    }
}
