package com.stepos.alphame.persona.domain.event;

import com.stepos.alphame.persona.common.time.bean.TimeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/stepos/alphame/persona/domain/event/TimeMessages;", "Lcom/stepos/alphame/persona/domain/event/Messages;", "eventId", "Lcom/stepos/alphame/persona/domain/event/EventId;", "timeInfo", "Lcom/stepos/alphame/persona/common/time/bean/TimeInfo;", "(Lcom/stepos/alphame/persona/domain/event/EventId;Lcom/stepos/alphame/persona/common/time/bean/TimeInfo;)V", "getEventId", "()Lcom/stepos/alphame/persona/domain/event/EventId;", "getTimeInfo", "()Lcom/stepos/alphame/persona/common/time/bean/TimeInfo;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class TimeMessages extends Messages {

    @NotNull
    private final EventId eventId;

    @NotNull
    private final TimeInfo timeInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimeMessages(@NotNull EventId eventId, @NotNull TimeInfo timeInfo) {
        super(eventId);
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(timeInfo, "timeInfo");
        this.eventId = eventId;
        this.timeInfo = timeInfo;
    }

    public static /* synthetic */ TimeMessages copy$default(TimeMessages timeMessages, EventId eventId, TimeInfo timeInfo, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            eventId = timeMessages.eventId;
        }
        if ((i4 & 2) != 0) {
            timeInfo = timeMessages.timeInfo;
        }
        return timeMessages.copy(eventId, timeInfo);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final EventId getEventId() {
        return this.eventId;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final TimeInfo getTimeInfo() {
        return this.timeInfo;
    }

    @NotNull
    public final TimeMessages copy(@NotNull EventId eventId, @NotNull TimeInfo timeInfo) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(timeInfo, "timeInfo");
        return new TimeMessages(eventId, timeInfo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimeMessages)) {
            return false;
        }
        TimeMessages timeMessages = (TimeMessages) other;
        return this.eventId == timeMessages.eventId && Intrinsics.areEqual(this.timeInfo, timeMessages.timeInfo);
    }

    @NotNull
    public final EventId getEventId() {
        return this.eventId;
    }

    @NotNull
    public final TimeInfo getTimeInfo() {
        return this.timeInfo;
    }

    public int hashCode() {
        return this.timeInfo.hashCode() + (this.eventId.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "TimeMessages(eventId=" + this.eventId + ", timeInfo=" + this.timeInfo + ")";
    }
}
