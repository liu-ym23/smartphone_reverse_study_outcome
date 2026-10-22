package org.yaml.snakeyaml.scanner;

import org.yaml.snakeyaml.tokens.Token;

/* loaded from: classes5.dex */
public interface Scanner {
    default boolean checkToken(Token.ID id) {
        return checkToken(id);
    }

    boolean checkToken(Token.ID... idArr);

    Token getToken();

    Token peekToken();

    void resetDocumentIndex();
}
