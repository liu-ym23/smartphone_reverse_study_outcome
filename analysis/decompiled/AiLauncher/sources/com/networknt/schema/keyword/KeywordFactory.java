package com.networknt.schema.keyword;

import com.networknt.schema.SchemaContext;

@FunctionalInterface
/* loaded from: classes2.dex */
public interface KeywordFactory {
    Keyword getKeyword(String str, SchemaContext schemaContext);
}
