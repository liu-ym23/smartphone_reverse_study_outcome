package com.networknt.schema.keyword;

import com.networknt.schema.SchemaException;
import com.networknt.schema.Validator;

/* loaded from: classes2.dex */
public interface KeywordValidator extends Validator {
    String getKeyword();

    default void preloadSchema() throws SchemaException {
    }
}
