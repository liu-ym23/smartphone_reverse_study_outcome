package com.networknt.schema.keyword;

import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.InvalidSchemaRefException;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaException;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.SchemaRef;
import com.networknt.schema.path.NodePath;
import java.util.Iterator;
import java.util.function.Supplier;

/* loaded from: classes2.dex */
public class RecursiveRefValidator extends BaseKeywordValidator {
    /* JADX WARN: Illegal instructions before constructor call */
    public RecursiveRefValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        KeywordType keywordType = KeywordType.RECURSIVE_REF;
        super(keywordType, jsonNode, schemaLocation, schema, schemaContext);
        String strAsText = jsonNode.asText();
        if (!Const.STR_MART_WELL.equals(strAsText)) {
            throw new SchemaException(error().keyword(keywordType.getValue()).messageKey("internal.invalidRecursiveRef").message("The value of a $recursiveRef must be '#' but is '{0}'").instanceLocation(schemaLocation.getFragment()).instanceNode(this.schemaNode).arguments(strAsText).build());
        }
    }

    public static Schema getSchema(Schema schema, ExecutionContext executionContext) {
        Schema schemaFindSchemaResourceRoot = schema.findSchemaResourceRoot();
        if (schemaFindSchemaResourceRoot != null) {
            String string = schemaFindSchemaResourceRoot.getSchemaLocation().getAbsoluteIri() != null ? schemaFindSchemaResourceRoot.getSchemaLocation().getAbsoluteIri().toString() : "";
            if (schemaFindSchemaResourceRoot.isRecursiveAnchor()) {
                Iterator<Schema> itDescendingIterator = executionContext.getEvaluationSchema().descendingIterator();
                while (itDescendingIterator.hasNext()) {
                    Schema next = itDescendingIterator.next();
                    String string2 = next.getSchemaLocation().getAbsoluteIri() != null ? next.getSchemaLocation().getAbsoluteIri().toString() : "";
                    if (!string.equals(string2)) {
                        Schema schemaFindSchemaResourceRoot2 = next.findSchemaResourceRoot();
                        if (schemaFindSchemaResourceRoot2.isRecursiveAnchor()) {
                            schemaFindSchemaResourceRoot = schemaFindSchemaResourceRoot2;
                        }
                        string = string2;
                    }
                }
            }
        }
        return schemaFindSchemaResourceRoot;
    }

    public SchemaRef getSchemaRef(final ExecutionContext executionContext) {
        return new SchemaRef(new Supplier() { // from class: com.networknt.schema.keyword.m0
            @Override // java.util.function.Supplier
            public final Object get() {
                return RecursiveRefValidator.getSchema(this.f21992a.parentSchema, executionContext);
            }
        });
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        Schema schema = getSchemaRef(executionContext).getSchema();
        if (schema == null) {
            throw new InvalidSchemaRefException(error().keyword(KeywordType.RECURSIVE_REF.getValue()).messageKey("internal.unresolvedRef").message("Reference {0} cannot be resolved").instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).arguments(this.schemaNode.asText()).build());
        }
        schema.validate(executionContext, jsonNode, jsonNode2, nodePath);
    }

    @Override // com.networknt.schema.Validator, com.networknt.schema.walk.Walker
    public void walk(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, boolean z10) {
        Schema schema = getSchemaRef(executionContext).getSchema();
        if (schema == null) {
            throw new InvalidSchemaRefException(error().keyword(KeywordType.RECURSIVE_REF.getValue()).messageKey("internal.unresolvedRef").message("Reference {0} cannot be resolved").instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).arguments(this.schemaNode.asText()).build());
        }
        if (jsonNode == null) {
            SchemaLocation schemaLocation = schema.getSchemaLocation();
            Iterator<Schema> itDescendingIterator = executionContext.getEvaluationSchema().descendingIterator();
            while (itDescendingIterator.hasNext()) {
                if (itDescendingIterator.next().getSchemaLocation().equals(schemaLocation)) {
                    return;
                }
            }
        }
        schema.walk(executionContext, jsonNode, jsonNode2, nodePath, z10);
    }
}
