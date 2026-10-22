package com.stepos.alphame.model.event;

import B0.g;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/stepos/alphame/model/event/DailyUsageUserDeletedMessage;", "Lcom/stepos/alphame/model/event/DailyUsageMessage;", "requestTime", "", "mode", "", "userId", "", "(JI[J)V", "getMode", "()I", "getRequestTime", "()J", "getUserId", "()[J", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "model_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DailyUsageUserDeletedMessage implements DailyUsageMessage {
    private final int mode;
    private final long requestTime;

    @NotNull
    private final long[] userId;

    public DailyUsageUserDeletedMessage(long j4, int i4, @NotNull long[] userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        this.requestTime = j4;
        this.mode = i4;
        this.userId = userId;
    }

    public static /* synthetic */ DailyUsageUserDeletedMessage copy$default(DailyUsageUserDeletedMessage dailyUsageUserDeletedMessage, long j4, int i4, long[] jArr, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            j4 = dailyUsageUserDeletedMessage.requestTime;
        }
        if ((i5 & 2) != 0) {
            i4 = dailyUsageUserDeletedMessage.mode;
        }
        if ((i5 & 4) != 0) {
            jArr = dailyUsageUserDeletedMessage.userId;
        }
        return dailyUsageUserDeletedMessage.copy(j4, i4, jArr);
    }

    /* renamed from: component1, reason: from getter */
    public final long getRequestTime() {
        return this.requestTime;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMode() {
        return this.mode;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final long[] getUserId() {
        return this.userId;
    }

    @NotNull
    public final DailyUsageUserDeletedMessage copy(long requestTime, int mode, @NotNull long[] userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        return new DailyUsageUserDeletedMessage(requestTime, mode, userId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DailyUsageUserDeletedMessage)) {
            return false;
        }
        DailyUsageUserDeletedMessage dailyUsageUserDeletedMessage = (DailyUsageUserDeletedMessage) other;
        return this.requestTime == dailyUsageUserDeletedMessage.requestTime && this.mode == dailyUsageUserDeletedMessage.mode && Intrinsics.areEqual(this.userId, dailyUsageUserDeletedMessage.userId);
    }

    public final int getMode() {
        return this.mode;
    }

    @Override // com.stepos.alphame.model.event.DailyUsageMessage
    public long getRequestTime() {
        return this.requestTime;
    }

    @NotNull
    public final long[] getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return Arrays.hashCode(this.userId) + g.d(this.mode, Long.hashCode(this.requestTime) * 31, 31);
    }

    @NotNull
    public String toString() {
        return "DailyUsageUserDeletedMessage(requestTime=" + this.requestTime + ", mode=" + this.mode + ", userId=" + Arrays.toString(this.userId) + ")";
    }
}
