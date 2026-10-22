package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.networknt.schema.Error;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.path.NodePath;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class PropertyNamesValidator extends BaseKeywordValidator implements KeywordValidator {
    private final Schema innerSchema;

    public PropertyNamesValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.PROPERTY_NAMES, jsonNode, schemaLocation, schema, schemaContext);
        this.innerSchema = schemaContext.newSchema(schemaLocation, jsonNode, schema);
    }

    @Override // com.networknt.schema.keyword.KeywordValidator
    public void preloadSchema() {
        this.innerSchema.initializeValidators();
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        List<Error> errors = executionContext.getErrors();
        ArrayList arrayList = new ArrayList();
        executionContext.setErrors(arrayList);
        Iterator<String> itFieldNames = jsonNode.fieldNames();
        while (itFieldNames.hasNext()) {
            String next = itFieldNames.next();
            this.innerSchema.validate(executionContext, TextNode.valueOf(next), jsonNode, nodePath.append(next));
            Iterator<Error> it = arrayList.iterator();
            while (it.hasNext()) {
                errors.add(error().property(next).instanceNode(jsonNode).instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).locale(executionContext.getExecutionConfig().getLocale()).arguments(next, it.next().getMessage()).build());
            }
            arrayList.clear();
        }
        executionContext.setErrors(errors);
    }
}
