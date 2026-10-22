package com.stepos.alphame.model.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/stepos/alphame/model/event/DailyUsageTimeChangedMessage;", "Lcom/stepos/alphame/model/event/DailyUsageMessage;", "requestTime", "", "action", "", "(JLjava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getRequestTime", "()J", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "model_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DailyUsageTimeChangedMessage implements DailyUsageMessage {

    @NotNull
    private final String action;
    private final long requestTime;

    public DailyUsageTimeChangedMessage(long j4, @NotNull String action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.requestTime = j4;
        this.action = action;
    }

    public static /* synthetic */ DailyUsageTimeChangedMessage copy$default(DailyUsageTimeChangedMessage dailyUsageTimeChangedMessage, long j4, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j4 = dailyUsageTimeChangedMessage.requestTime;
        }
        if ((i4 & 2) != 0) {
            str = dailyUsageTimeChangedMessage.action;
        }
        return dailyUsageTimeChangedMessage.copy(j4, str);
    }

    /* renamed from: component1, reason: from getter */
    public final long getRequestTime() {
        return this.requestTime;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getAction() {
        return this.action;
    }

    @NotNull
    public final DailyUsageTimeChangedMessage copy(long requestTime, @NotNull String action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return new DailyUsageTimeChangedMessage(requestTime, action);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DailyUsageTimeChangedMessage)) {
            return false;
        }
        DailyUsageTimeChangedMessage dailyUsageTimeChangedMessage = (DailyUsageTimeChangedMessage) other;
        return this.requestTime == dailyUsageTimeChangedMessage.requestTime && Intrinsics.areEqual(this.action, dailyUsageTimeChangedMessage.action);
    }

    @NotNull
    public final String getAction() {
        return this.action;
    }

    @Override // com.stepos.alphame.model.event.DailyUsageMessage
    public long getRequestTime() {
        return this.requestTime;
    }

    public int hashCode() {
        return this.action.hashCode() + (Long.hashCode(this.requestTime) * 31);
    }

    @NotNull
    public String toString() {
        return "DailyUsageTimeChangedMessage(requestTime=" + this.requestTime + ", action=" + this.action + ")";
    }
}
