package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.tokens.Token;

/* loaded from: classes5.dex */
public final class ScalarToken extends Token {
    private final boolean plain;
    private final DumperOptions.ScalarStyle style;
    private final String value;

    public ScalarToken(String str, Mark mark, Mark mark2, boolean z10) {
        this(str, z10, mark, mark2, DumperOptions.ScalarStyle.PLAIN);
    }

    public boolean getPlain() {
        return this.plain;
    }

    public DumperOptions.ScalarStyle getStyle() {
        return this.style;
    }

    @Override // org.yaml.snakeyaml.tokens.Token
    public Token.ID getTokenId() {
        return Token.ID.Scalar;
    }

    public String getValue() {
        return this.value;
    }

    public ScalarToken(String str, boolean z10, Mark mark, Mark mark2, DumperOptions.ScalarStyle scalarStyle) {
        super(mark, mark2);
        this.value = str;
        this.plain = z10;
        if (scalarStyle == null) {
            throw new NullPointerException("Style must be provided.");
        }
        this.style = scalarStyle;
    }
}
