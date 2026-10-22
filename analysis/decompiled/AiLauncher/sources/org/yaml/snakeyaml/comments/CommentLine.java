package org.yaml.snakeyaml.comments;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.CommentEvent;

/* loaded from: classes5.dex */
public class CommentLine {
    private final CommentType commentType;
    private final Mark endMark;
    private final Mark startMark;
    private final String value;

    public CommentLine(CommentEvent commentEvent) {
        this(commentEvent.getStartMark(), commentEvent.getEndMark(), commentEvent.getValue(), commentEvent.getCommentType());
    }

    public CommentType getCommentType() {
        return this.commentType;
    }

    public Mark getEndMark() {
        return this.endMark;
    }

    public Mark getStartMark() {
        return this.startMark;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return "<" + getClass().getName() + " (type=" + getCommentType() + ", value=" + getValue() + ")>";
    }

    public CommentLine(Mark mark, Mark mark2, String str, CommentType commentType) {
        this.startMark = mark;
        this.endMark = mark2;
        this.value = str;
        this.commentType = commentType;
    }
}
