package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.error.Mark;

/* loaded from: classes5.dex */
public abstract class Event {
    private final Mark endMark;
    private final Mark startMark;

    public enum ID {
        Alias,
        Comment,
        DocumentEnd,
        DocumentStart,
        MappingEnd,
        MappingStart,
        Scalar,
        SequenceEnd,
        SequenceStart,
        StreamEnd,
        StreamStart
    }

    public Event(Mark mark, Mark mark2) {
        this.startMark = mark;
        this.endMark = mark2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Event) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public String getArguments() {
        return "";
    }

    public Mark getEndMark() {
        return this.endMark;
    }

    public abstract ID getEventId();

    public Mark getStartMark() {
        return this.startMark;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public boolean is(ID id) {
        return getEventId() == id;
    }

    public String toString() {
        return "<" + getClass().getName() + "(" + getArguments() + ")>";
    }
}
