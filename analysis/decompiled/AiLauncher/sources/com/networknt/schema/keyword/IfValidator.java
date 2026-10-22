package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.Error;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.path.NodePath;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class IfValidator extends BaseKeywordValidator {
    private static final List<String> KEYWORDS = Arrays.asList("if", "then", "else");
    private final Schema elseSchema;
    private final Schema ifSchema;
    private final Schema thenSchema;

    public IfValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.IF_THEN_ELSE, jsonNode, schemaLocation, schema, schemaContext);
        Schema schemaNewSchema = null;
        Schema schemaNewSchema2 = null;
        Schema schemaNewSchema3 = null;
        for (String str : KEYWORDS) {
            JsonNode jsonNode2 = schema.getSchemaNode().get(str);
            SchemaLocation schemaLocationAppend = schema.getSchemaLocation().append(str);
            if (str.equals("if")) {
                schemaNewSchema = schemaContext.newSchema(schemaLocationAppend, jsonNode2, schema);
            } else if (str.equals("then") && jsonNode2 != null) {
                schemaNewSchema2 = schemaContext.newSchema(schemaLocationAppend, jsonNode2, schema);
            } else if (str.equals("else") && jsonNode2 != null) {
                schemaNewSchema3 = schemaContext.newSchema(schemaLocationAppend, jsonNode2, schema);
            }
        }
        this.ifSchema = schemaNewSchema;
        this.thenSchema = schemaNewSchema2;
        this.elseSchema = schemaNewSchema3;
    }

    @Override // com.networknt.schema.keyword.KeywordValidator
    public void preloadSchema() {
        Schema schema = this.ifSchema;
        if (schema != null) {
            schema.initializeValidators();
        }
        Schema schema2 = this.thenSchema;
        if (schema2 != null) {
            schema2.initializeValidators();
        }
        Schema schema3 = this.elseSchema;
        if (schema3 != null) {
            schema3.initializeValidators();
        }
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        boolean zIsFailFast = executionContext.isFailFast();
        List<Error> errors = executionContext.getErrors();
        ArrayList arrayList = new ArrayList();
        executionContext.setErrors(arrayList);
        try {
            executionContext.setFailFast(false);
            this.ifSchema.validate(executionContext, jsonNode, jsonNode2, nodePath);
            boolean zIsEmpty = arrayList.isEmpty();
            executionContext.setErrors(errors);
            executionContext.setFailFast(zIsFailFast);
            if (zIsEmpty && this.thenSchema != null) {
                executionContext.evaluationPathRemoveLast();
                executionContext.evaluationPathAddLast("then");
                try {
                    this.thenSchema.validate(executionContext, jsonNode, jsonNode2, nodePath);
                    return;
                } finally {
                }
            }
            if (zIsEmpty || this.elseSchema == null) {
                return;
            }
            executionContext.evaluationPathRemoveLast();
            executionContext.evaluationPathAddLast("else");
            try {
                this.elseSchema.validate(executionContext, jsonNode, jsonNode2, nodePath);
            } finally {
            }
        } catch (Throwable th) {
            executionContext.setErrors(errors);
            executionContext.setFailFast(zIsFailFast);
            throw th;
        }
    }

    @Override // com.networknt.schema.Validator, com.networknt.schema.walk.Walker
    public void walk(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, boolean z10) {
        boolean z11 = jsonNode != null && z10;
        boolean zIsFailFast = executionContext.isFailFast();
        List<Error> errors = executionContext.getErrors();
        ArrayList arrayList = new ArrayList();
        executionContext.setErrors(arrayList);
        try {
            executionContext.setFailFast(false);
            this.ifSchema.walk(executionContext, jsonNode, jsonNode2, nodePath, z10);
            boolean zIsEmpty = arrayList.isEmpty();
            executionContext.setErrors(errors);
            executionContext.setFailFast(zIsFailFast);
            if (!z11) {
                if (this.thenSchema != null) {
                    executionContext.evaluationPathRemoveLast();
                    executionContext.evaluationPathAddLast("then");
                    try {
                        this.thenSchema.walk(executionContext, jsonNode, jsonNode2, nodePath, z10);
                    } finally {
                    }
                }
                if (this.elseSchema != null) {
                    executionContext.evaluationPathRemoveLast();
                    executionContext.evaluationPathAddLast("else");
                    try {
                        this.elseSchema.walk(executionContext, jsonNode, jsonNode2, nodePath, z10);
                        return;
                    } finally {
                    }
                }
                return;
            }
            if (this.thenSchema != null && zIsEmpty) {
                executionContext.evaluationPathRemoveLast();
                executionContext.evaluationPathAddLast("then");
                try {
                    this.thenSchema.walk(executionContext, jsonNode, jsonNode2, nodePath, z10);
                    return;
                } finally {
                }
            }
            if (this.elseSchema == null || zIsEmpty) {
                return;
            }
            executionContext.evaluationPathRemoveLast();
            executionContext.evaluationPathAddLast("else");
            try {
                this.elseSchema.walk(executionContext, jsonNode, jsonNode2, nodePath, z10);
            } finally {
            }
        } catch (Throwable th) {
            executionContext.setErrors(errors);
            executionContext.setFailFast(zIsFailFast);
            throw th;
        }
    }
}
