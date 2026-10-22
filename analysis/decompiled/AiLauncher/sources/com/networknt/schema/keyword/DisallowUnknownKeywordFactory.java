package com.networknt.schema.keyword;

import com.networknt.schema.Error;
import com.networknt.schema.InvalidSchemaException;
import com.networknt.schema.SchemaContext;

/* loaded from: classes2.dex */
public class DisallowUnknownKeywordFactory implements KeywordFactory {
    private static final vc.c logger = vc.e.l(DisallowUnknownKeywordFactory.class);

    public static class Holder {
        private static final DisallowUnknownKeywordFactory INSTANCE = new DisallowUnknownKeywordFactory();

        private Holder() {
        }
    }

    public static DisallowUnknownKeywordFactory getInstance() {
        return Holder.INSTANCE;
    }

    @Override // com.networknt.schema.keyword.KeywordFactory
    public Keyword getKeyword(String str, SchemaContext schemaContext) {
        logger.u("Keyword '{}' is unknown and must be configured on the meta-schema or vocabulary", str);
        throw new InvalidSchemaException(Error.builder().message("Keyword ''{0}'' is unknown and must be configured on the meta-schema or vocabulary").arguments(str).build());
    }
}
