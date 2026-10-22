package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.Event;

/* loaded from: classes5.dex */
public final class DocumentEndEvent extends Event {
    private final boolean explicit;

    public DocumentEndEvent(Mark mark, Mark mark2, boolean z10) {
        super(mark, mark2);
        this.explicit = z10;
    }

    @Override // org.yaml.snakeyaml.events.Event
    public Event.ID getEventId() {
        return Event.ID.DocumentEnd;
    }

    public boolean getExplicit() {
        return this.explicit;
    }
}
