package org.yaml.snakeyaml.tokens;

import java.util.List;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.tokens.Token;

/* loaded from: classes5.dex */
public final class DirectiveToken<T> extends Token {
    private final String name;
    private final List<T> value;

    public DirectiveToken(String str, List<T> list, Mark mark, Mark mark2) {
        super(mark, mark2);
        this.name = str;
        if (list == null || list.size() == 2) {
            this.value = list;
            return;
        }
        throw new YAMLException("Two strings must be provided instead of " + list.size());
    }

    public String getName() {
        return this.name;
    }

    @Override // org.yaml.snakeyaml.tokens.Token
    public Token.ID getTokenId() {
        return Token.ID.Directive;
    }

    public List<T> getValue() {
        return this.value;
    }
}
