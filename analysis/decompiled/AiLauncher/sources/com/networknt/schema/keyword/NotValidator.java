package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.Error;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.path.NodePath;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class NotValidator extends BaseKeywordValidator {
    private final Schema schema;

    public NotValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.NOT, jsonNode, schemaLocation, schema, schemaContext);
        this.schema = schemaContext.newSchema(schemaLocation, jsonNode, schema);
    }

    @Override // com.networknt.schema.keyword.KeywordValidator
    public void preloadSchema() {
        Schema schema = this.schema;
        if (schema != null) {
            schema.initializeValidators();
        }
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) throws Throwable {
        validate(executionContext, jsonNode, jsonNode2, nodePath, false);
    }

    @Override // com.networknt.schema.Validator, com.networknt.schema.walk.Walker
    public void walk(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, boolean z10) throws Throwable {
        if (!z10 || jsonNode == null) {
            this.schema.walk(executionContext, jsonNode, jsonNode2, nodePath, false);
        } else {
            validate(executionContext, jsonNode, jsonNode2, nodePath, true);
        }
    }

    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, boolean z10) throws Throwable {
        ExecutionContext executionContext2;
        Throwable th;
        JsonNode jsonNode3;
        NodePath nodePath2;
        boolean zIsFailFast = executionContext.isFailFast();
        List<Error> errors = executionContext.getErrors();
        ArrayList arrayList = new ArrayList();
        executionContext.setErrors(arrayList);
        try {
            executionContext.setFailFast(false);
            if (z10) {
                executionContext2 = executionContext;
                jsonNode3 = jsonNode;
                nodePath2 = nodePath;
                try {
                    this.schema.walk(executionContext2, jsonNode3, jsonNode2, nodePath2, true);
                } catch (Throwable th2) {
                    th = th2;
                    th = th;
                    executionContext2.setFailFast(zIsFailFast);
                    executionContext2.setErrors(errors);
                    throw th;
                }
            } else {
                try {
                    this.schema.validate(executionContext, jsonNode, jsonNode2, nodePath);
                    executionContext2 = executionContext;
                    jsonNode3 = jsonNode;
                    nodePath2 = nodePath;
                } catch (Throwable th3) {
                    th = th3;
                    executionContext2 = executionContext;
                    executionContext2.setFailFast(zIsFailFast);
                    executionContext2.setErrors(errors);
                    throw th;
                }
            }
            executionContext2.setFailFast(zIsFailFast);
            executionContext2.setErrors(errors);
            if (arrayList.isEmpty()) {
                executionContext2.addError(error().instanceNode(jsonNode3).instanceLocation(nodePath2).evaluationPath(executionContext2.getEvaluationPath()).locale(executionContext2.getExecutionConfig().getLocale()).arguments(this.schemaNode.toString()).build());
            }
        } catch (Throwable th4) {
            th = th4;
            executionContext2 = executionContext;
        }
    }
}
