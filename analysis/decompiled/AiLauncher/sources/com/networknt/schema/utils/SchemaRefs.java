package com.networknt.schema.utils;

import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaRef;
import com.networknt.schema.keyword.DynamicRefValidator;
import com.networknt.schema.keyword.KeywordValidator;
import com.networknt.schema.keyword.RecursiveRefValidator;
import com.networknt.schema.keyword.RefValidator;

/* loaded from: classes2.dex */
public class SchemaRefs {
    public static SchemaRef from(Schema schema, ExecutionContext executionContext) {
        for (KeywordValidator keywordValidator : schema.getValidators()) {
            if (keywordValidator instanceof RefValidator) {
                return ((RefValidator) keywordValidator).getSchemaRef();
            }
            if (keywordValidator instanceof DynamicRefValidator) {
                return ((DynamicRefValidator) keywordValidator).getSchemaRef(executionContext);
            }
            if (keywordValidator instanceof RecursiveRefValidator) {
                return ((RecursiveRefValidator) keywordValidator).getSchemaRef(executionContext);
            }
        }
        return null;
    }
}
