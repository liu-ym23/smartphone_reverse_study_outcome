package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.path.NodePath;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class NonValidationKeyword extends AbstractKeyword {

    public static final class Validator extends AbstractKeywordValidator {
        public Validator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext, Keyword keyword) {
            super(keyword, jsonNode, schemaLocation);
            String strResolveSchemaId = schemaContext.resolveSchemaId(jsonNode);
            String anchor = schemaContext.getDialect().readAnchor(jsonNode);
            String dynamicAnchor = schemaContext.getDialect().readDynamicAnchor(jsonNode);
            if (strResolveSchemaId != null || anchor != null || dynamicAnchor != null) {
                schemaContext.newSchema(schemaLocation, jsonNode, schema);
            }
            if ("$defs".equals(keyword.getValue()) || "definitions".equals(keyword.getValue())) {
                Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode.fields();
                while (itFields.hasNext()) {
                    Map.Entry<String, JsonNode> next = itFields.next();
                    SchemaLocation schemaLocationAppend = schemaLocation.append(next.getKey());
                    schemaContext.getSchemaReferences().put(schemaLocationAppend.toString(), schemaContext.newSchema(schemaLocationAppend, next.getValue(), schema));
                }
            }
        }

        @Override // com.networknt.schema.Validator
        public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        }
    }

    public NonValidationKeyword(String str) {
        super(str);
    }

    @Override // com.networknt.schema.keyword.Keyword
    public KeywordValidator newValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        return new Validator(schemaLocation, jsonNode, schema, schemaContext, this);
    }
}
