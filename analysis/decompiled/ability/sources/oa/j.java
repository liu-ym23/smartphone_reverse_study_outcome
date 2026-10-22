package oa;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.tokens.Token$ID;

/* loaded from: classes4.dex */
public final class j extends k {
    public final M0.k c;

    public j(M0.k kVar, Mark mark, Mark mark2) {
        super(mark, mark2);
        this.c = kVar;
    }

    @Override // oa.k
    public final Token$ID a() {
        return Token$ID.Tag;
    }
}
