package ha;

import org.yaml.snakeyaml.comments.CommentType;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.Event$ID;

/* renamed from: ha.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1548d extends AbstractC1551g {
    public final CommentType c;
    public final String d;

    public C1548d(CommentType commentType, String str, Mark mark, Mark mark2) {
        super(mark, mark2);
        if (commentType == null) {
            throw new NullPointerException("Event Type must be provided.");
        }
        this.c = commentType;
        if (str == null) {
            throw new NullPointerException("Value must be provided.");
        }
        this.d = str;
    }

    @Override // ha.AbstractC1551g
    public final String a() {
        return "type=" + this.c + ", value=" + this.d;
    }

    @Override // ha.AbstractC1551g
    public final Event$ID b() {
        return Event$ID.b;
    }
}
