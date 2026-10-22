package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.Error;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaException;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.Validator;
import com.networknt.schema.path.NodePath;
import com.networknt.schema.utils.JsonType;
import com.networknt.schema.utils.TypeFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class UnionTypeValidator extends BaseKeywordValidator implements KeywordValidator {
    private final String error;
    private final List<Validator> schemas;

    public UnionTypeValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.TYPE, jsonNode, schemaLocation, schema, schemaContext);
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        if (!jsonNode.isArray()) {
            throw new SchemaException("Expected array for type property on Union Type Definition.");
        }
        this.schemas = new ArrayList(jsonNode.size());
        Iterator<JsonNode> it = jsonNode.iterator();
        String str = "";
        int i10 = 0;
        while (it.hasNext()) {
            JsonNode next = it.next();
            JsonType schemaNodeType = TypeFactory.getSchemaNodeType(next);
            sb2.append(str);
            sb2.append(schemaNodeType);
            if (next.isObject()) {
                this.schemas.add(schemaContext.newSchema(schemaLocation.append(i10), next, schema));
            } else {
                this.schemas.add(new TypeValidator(schemaLocation.append(i10), next, schema, schemaContext));
            }
            i10++;
            str = ", ";
        }
        sb2.append(']');
        this.error = sb2.toString();
    }

    @Override // com.networknt.schema.keyword.AbstractKeywordValidator, com.networknt.schema.keyword.KeywordValidator
    public String getKeyword() {
        return "type";
    }

    @Override // com.networknt.schema.keyword.KeywordValidator
    public void preloadSchema() throws SchemaException {
        for (Validator validator : this.schemas) {
            if (validator instanceof KeywordValidator) {
                ((KeywordValidator) validator).preloadSchema();
            } else if (validator instanceof Schema) {
                ((Schema) validator).initializeValidators();
            }
        }
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        JsonType valueNodeType = TypeFactory.getValueNodeType(jsonNode, this.schemaContext.getSchemaRegistryConfig());
        boolean zIsFailFast = executionContext.isFailFast();
        List<Error> errors = executionContext.getErrors();
        try {
            ArrayList arrayList = new ArrayList();
            boolean z10 = false;
            executionContext.setFailFast(false);
            executionContext.setErrors(arrayList);
            Iterator<Validator> it = this.schemas.iterator();
            int i10 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Validator next = it.next();
                executionContext.evaluationPathAddLast(i10);
                try {
                    next.validate(executionContext, jsonNode, jsonNode2, nodePath);
                    executionContext.evaluationPathRemoveLast();
                    i10++;
                    if (arrayList.isEmpty()) {
                        z10 = true;
                        break;
                    }
                    arrayList.clear();
                } catch (Throwable th) {
                    executionContext.evaluationPathRemoveLast();
                    throw th;
                }
            }
            if (z10) {
                return;
            }
            executionContext.addError(error().instanceNode(jsonNode).instanceLocation(nodePath).keyword("type").evaluationPath(executionContext.getEvaluationPath()).locale(executionContext.getExecutionConfig().getLocale()).arguments(valueNodeType.toString(), this.error).build());
        } finally {
            executionContext.setFailFast(zIsFailFast);
            executionContext.setErrors(errors);
        }
    }
}
