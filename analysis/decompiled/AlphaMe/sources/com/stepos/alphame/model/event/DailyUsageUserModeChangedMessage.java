package com.stepos.alphame.model.event;

import B0.g;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/stepos/alphame/model/event/DailyUsageUserModeChangedMessage;", "Lcom/stepos/alphame/model/event/DailyUsageMessage;", "requestTime", "", "oldUserMode", "", "newUserMode", "(JII)V", "getNewUserMode", "()I", "getOldUserMode", "getRequestTime", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "model_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DailyUsageUserModeChangedMessage implements DailyUsageMessage {
    private final int newUserMode;
    private final int oldUserMode;
    private final long requestTime;

    public DailyUsageUserModeChangedMessage(long j4, int i4, int i5) {
        this.requestTime = j4;
        this.oldUserMode = i4;
        this.newUserMode = i5;
    }

    public static /* synthetic */ DailyUsageUserModeChangedMessage copy$default(DailyUsageUserModeChangedMessage dailyUsageUserModeChangedMessage, long j4, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            j4 = dailyUsageUserModeChangedMessage.requestTime;
        }
        if ((i6 & 2) != 0) {
            i4 = dailyUsageUserModeChangedMessage.oldUserMode;
        }
        if ((i6 & 4) != 0) {
            i5 = dailyUsageUserModeChangedMessage.newUserMode;
        }
        return dailyUsageUserModeChangedMessage.copy(j4, i4, i5);
    }

    /* renamed from: component1, reason: from getter */
    public final long getRequestTime() {
        return this.requestTime;
    }

    /* renamed from: component2, reason: from getter */
    public final int getOldUserMode() {
        return this.oldUserMode;
    }

    /* renamed from: component3, reason: from getter */
    public final int getNewUserMode() {
        return this.newUserMode;
    }

    @NotNull
    public final DailyUsageUserModeChangedMessage copy(long requestTime, int oldUserMode, int newUserMode) {
        return new DailyUsageUserModeChangedMessage(requestTime, oldUserMode, newUserMode);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DailyUsageUserModeChangedMessage)) {
            return false;
        }
        DailyUsageUserModeChangedMessage dailyUsageUserModeChangedMessage = (DailyUsageUserModeChangedMessage) other;
        return this.requestTime == dailyUsageUserModeChangedMessage.requestTime && this.oldUserMode == dailyUsageUserModeChangedMessage.oldUserMode && this.newUserMode == dailyUsageUserModeChangedMessage.newUserMode;
    }

    public final int getNewUserMode() {
        return this.newUserMode;
    }

    public final int getOldUserMode() {
        return this.oldUserMode;
    }

    @Override // com.stepos.alphame.model.event.DailyUsageMessage
    public long getRequestTime() {
        return this.requestTime;
    }

    public int hashCode() {
        return Integer.hashCode(this.newUserMode) + g.d(this.oldUserMode, Long.hashCode(this.requestTime) * 31, 31);
    }

    @NotNull
    public String toString() {
        return "DailyUsageUserModeChangedMessage(requestTime=" + this.requestTime + ", oldUserMode=" + this.oldUserMode + ", newUserMode=" + this.newUserMode + ")";
    }
}
