package oa;

import org.yaml.snakeyaml.DumperOptions$ScalarStyle;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.tokens.Token$ID;

/* loaded from: classes4.dex */
public final class g extends k {
    public final String c;
    public final boolean d;
    public final DumperOptions$ScalarStyle e;

    public g(String str, boolean z10, Mark mark, Mark mark2, DumperOptions$ScalarStyle dumperOptions$ScalarStyle) {
        super(mark, mark2);
        this.c = str;
        this.d = z10;
        this.e = dumperOptions$ScalarStyle;
    }

    @Override // oa.k
    public final Token$ID a() {
        return Token$ID.Scalar;
    }
}
