package org.yaml.snakeyaml.events;

import java.util.Map;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.Event;

/* loaded from: classes5.dex */
public final class DocumentStartEvent extends Event {
    private final boolean explicit;
    private final Map<String, String> tags;
    private final DumperOptions.Version version;

    public DocumentStartEvent(Mark mark, Mark mark2, boolean z10, DumperOptions.Version version, Map<String, String> map) {
        super(mark, mark2);
        this.explicit = z10;
        this.version = version;
        this.tags = map;
    }

    @Override // org.yaml.snakeyaml.events.Event
    public Event.ID getEventId() {
        return Event.ID.DocumentStart;
    }

    public boolean getExplicit() {
        return this.explicit;
    }

    public Map<String, String> getTags() {
        return this.tags;
    }

    public DumperOptions.Version getVersion() {
        return this.version;
    }
}
