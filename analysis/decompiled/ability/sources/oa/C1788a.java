package oa;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.tokens.Token$ID;

/* renamed from: oa.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1788a extends k {
    public final String c;

    public C1788a(String str, Mark mark, Mark mark2) {
        super(mark, mark2);
        this.c = str;
    }

    @Override // oa.k
    public final Token$ID a() {
        return Token$ID.Alias;
    }
}
