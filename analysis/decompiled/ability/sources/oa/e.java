package oa;

import org.yaml.snakeyaml.comments.CommentType;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.tokens.Token$ID;

/* loaded from: classes4.dex */
public final class e extends k {
    public final CommentType c;
    public final String d;

    public e(CommentType commentType, String str, Mark mark, Mark mark2) {
        super(mark, mark2);
        this.c = commentType;
        this.d = str;
    }

    @Override // oa.k
    public final Token$ID a() {
        return Token$ID.Comment;
    }
}
