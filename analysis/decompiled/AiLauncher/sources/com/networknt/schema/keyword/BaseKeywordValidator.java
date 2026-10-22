package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ErrorMessages;
import com.networknt.schema.MessageSourceError;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class BaseKeywordValidator extends AbstractKeywordValidator {
    protected final Map<String, String> errorMessage;
    protected final Schema parentSchema;
    protected final SchemaContext schemaContext;

    public BaseKeywordValidator(Keyword keyword, JsonNode jsonNode, SchemaLocation schemaLocation, Schema schema, SchemaContext schemaContext) {
        super(keyword, jsonNode, schemaLocation);
        this.schemaContext = schemaContext;
        this.parentSchema = schema;
        if (keyword == null || schema == null || schemaContext.getSchemaRegistryConfig().getErrorMessageKeyword() == null) {
            this.errorMessage = null;
        } else {
            this.errorMessage = ErrorMessages.getErrorMessage(schema, schemaContext.getSchemaRegistryConfig().getErrorMessageKeyword(), keyword.getValue());
        }
    }

    public MessageSourceError.Builder error() {
        return MessageSourceError.builder(this.schemaContext.getSchemaRegistryConfig().getMessageSource(), this.errorMessage).schemaNode(this.schemaNode).schemaLocation(this.schemaLocation).keyword(getKeyword()).messageKey(getKeyword());
    }

    public String getNodeFieldType() {
        JsonNode jsonNode = getParentSchema().getSchemaNode().get("type");
        if (jsonNode != null) {
            return jsonNode.asText();
        }
        return null;
    }

    public Schema getParentSchema() {
        return this.parentSchema;
    }

    public void preloadSchemas(Collection<Schema> collection) {
        Iterator<Schema> it = collection.iterator();
        while (it.hasNext()) {
            it.next().initializeValidators();
        }
    }

    public BaseKeywordValidator(Keyword keyword, JsonNode jsonNode, SchemaLocation schemaLocation, SchemaContext schemaContext, Schema schema, Map<String, String> map) {
        super(keyword, jsonNode, schemaLocation);
        this.schemaContext = schemaContext;
        this.parentSchema = schema;
        this.errorMessage = map;
    }
}
