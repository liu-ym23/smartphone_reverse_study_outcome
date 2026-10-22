package org.yaml.snakeyaml.constructor;

import org.yaml.snakeyaml.error.Mark;

/* loaded from: classes5.dex */
public class DuplicateKeyException extends ConstructorException {
    public DuplicateKeyException(Mark mark, Object obj, Mark mark2) {
        super("while constructing a mapping", mark, "found duplicate key " + obj, mark2);
    }
}
