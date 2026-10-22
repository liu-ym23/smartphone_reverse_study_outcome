package com.stepos.alphame.persona.domain.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/alphame/persona/domain/event/Messages;", "", "id", "Lcom/stepos/alphame/persona/domain/event/EventId;", "(Lcom/stepos/alphame/persona/domain/event/EventId;)V", "getId", "()Lcom/stepos/alphame/persona/domain/event/EventId;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public class Messages {

    @NotNull
    private final EventId id;

    public Messages(@NotNull EventId id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
    }

    @NotNull
    public final EventId getId() {
        return this.id;
    }
}
