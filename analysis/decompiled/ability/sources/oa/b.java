package oa;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.tokens.Token$ID;

/* loaded from: classes4.dex */
public final class b extends k {
    public final String c;

    public b(String str, Mark mark, Mark mark2) {
        super(mark, mark2);
        this.c = str;
    }

    @Override // oa.k
    public final Token$ID a() {
        return Token$ID.Anchor;
    }
}
