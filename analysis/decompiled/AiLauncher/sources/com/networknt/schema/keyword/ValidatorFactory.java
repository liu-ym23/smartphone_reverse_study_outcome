package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;

@FunctionalInterface
/* loaded from: classes2.dex */
interface ValidatorFactory {
    KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext);
}
