package com.stepos.alphame.persona.domain.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/stepos/alphame/persona/domain/event/ClearDataMessages;", "Lcom/stepos/alphame/persona/domain/event/Messages;", "eventId", "Lcom/stepos/alphame/persona/domain/event/EventId;", "status", "", "(Lcom/stepos/alphame/persona/domain/event/EventId;Z)V", "getEventId", "()Lcom/stepos/alphame/persona/domain/event/EventId;", "getStatus", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ClearDataMessages extends Messages {

    @NotNull
    private final EventId eventId;
    private final boolean status;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClearDataMessages(@NotNull EventId eventId, boolean z4) {
        super(eventId);
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        this.eventId = eventId;
        this.status = z4;
    }

    public static /* synthetic */ ClearDataMessages copy$default(ClearDataMessages clearDataMessages, EventId eventId, boolean z4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            eventId = clearDataMessages.eventId;
        }
        if ((i4 & 2) != 0) {
            z4 = clearDataMessages.status;
        }
        return clearDataMessages.copy(eventId, z4);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final EventId getEventId() {
        return this.eventId;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getStatus() {
        return this.status;
    }

    @NotNull
    public final ClearDataMessages copy(@NotNull EventId eventId, boolean status) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        return new ClearDataMessages(eventId, status);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClearDataMessages)) {
            return false;
        }
        ClearDataMessages clearDataMessages = (ClearDataMessages) other;
        return this.eventId == clearDataMessages.eventId && this.status == clearDataMessages.status;
    }

    @NotNull
    public final EventId getEventId() {
        return this.eventId;
    }

    public final boolean getStatus() {
        return this.status;
    }

    public int hashCode() {
        return Boolean.hashCode(this.status) + (this.eventId.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "ClearDataMessages(eventId=" + this.eventId + ", status=" + this.status + ")";
    }
}
