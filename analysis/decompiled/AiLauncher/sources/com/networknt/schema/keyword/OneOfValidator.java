package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.Error;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaException;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.path.NodePath;
import com.networknt.schema.utils.TypeFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class OneOfValidator extends BaseKeywordValidator {
    private final List<Schema> schemas;

    public OneOfValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.ONE_OF, jsonNode, schemaLocation, schema, schemaContext);
        if (!jsonNode.isArray()) {
            throw new SchemaException(error().instanceNode(jsonNode).instanceLocation(schemaLocation.getFragment()).messageKey("type").arguments(TypeFactory.getValueNodeType(jsonNode, this.schemaContext.getSchemaRegistryConfig()).toString(), "array").build());
        }
        int size = jsonNode.size();
        this.schemas = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            this.schemas.add(schemaContext.newSchema(schemaLocation.append(i10), jsonNode.get(i10), schema));
        }
    }

    public boolean canShortCircuit(ExecutionContext executionContext) {
        if (hasUnevaluatedItemsInEvaluationPath(executionContext) || hasUnevaluatedPropertiesInEvaluationPath(executionContext)) {
            return false;
        }
        return !executionContext.getExecutionConfig().isAnnotationCollectionEnabled();
    }

    @Override // com.networknt.schema.keyword.KeywordValidator
    public void preloadSchema() {
        Iterator<Schema> it = this.schemas.iterator();
        while (it.hasNext()) {
            it.next().initializeValidators();
        }
    }

    public boolean reportChildErrors(ExecutionContext executionContext) {
        return !executionContext.getExecutionConfig().isFailFast();
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        validate(executionContext, jsonNode, jsonNode2, nodePath, false);
    }

    @Override // com.networknt.schema.Validator, com.networknt.schema.walk.Walker
    public void walk(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, boolean z10) {
        if (z10 && jsonNode != null) {
            validate(executionContext, jsonNode, jsonNode2, nodePath, true);
            return;
        }
        int i10 = 0;
        for (Schema schema : this.schemas) {
            executionContext.evaluationPathAddLast(i10);
            try {
                schema.walk(executionContext, jsonNode, jsonNode2, nodePath, false);
                executionContext.evaluationPathRemoveLast();
                i10++;
            } catch (Throwable th) {
                executionContext.evaluationPathRemoveLast();
                throw th;
            }
        }
    }

    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath, boolean z10) {
        ArrayList arrayList;
        ArrayList arrayList2;
        DiscriminatorState discriminatorState;
        Schema schema;
        Iterator<Schema> it;
        List<Error> errors = executionContext.getErrors();
        ArrayList arrayList3 = new ArrayList();
        executionContext.setErrors(arrayList3);
        boolean zIsFailFast = executionContext.isFailFast();
        try {
            executionContext.setFailFast(false);
            Iterator<Schema> it2 = this.schemas.iterator();
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            ArrayList arrayList4 = null;
            ArrayList arrayList5 = null;
            ArrayList arrayList6 = null;
            Boolean boolValueOf = null;
            while (true) {
                if (!it2.hasNext()) {
                    arrayList = arrayList4;
                    arrayList2 = arrayList5;
                    break;
                }
                Schema next = it2.next();
                arrayList3.clear();
                executionContext.evaluationPathAddLast(i10);
                if (z10) {
                    ArrayList arrayList7 = arrayList4;
                    schema = next;
                    Iterator<Schema> it3 = it2;
                    arrayList2 = arrayList5;
                    arrayList = arrayList7;
                    it = it3;
                    schema.walk(executionContext, jsonNode, jsonNode2, nodePath, true);
                } else {
                    try {
                        next.validate(executionContext, jsonNode, jsonNode2, nodePath);
                        arrayList = arrayList4;
                        schema = next;
                        it = it2;
                        arrayList2 = arrayList5;
                    } finally {
                        executionContext.evaluationPathRemoveLast();
                    }
                }
                executionContext.evaluationPathRemoveLast();
                i10++;
                if (arrayList3.isEmpty()) {
                    i11++;
                    if (arrayList6 == null) {
                        arrayList6 = new ArrayList();
                    }
                    arrayList6.add(Integer.toString(i12));
                }
                if (i11 > 1) {
                    if (boolValueOf == null) {
                        boolValueOf = Boolean.valueOf(canShortCircuit(executionContext));
                    }
                    if (boolValueOf.booleanValue()) {
                        break;
                    }
                }
                if (this.schemaContext.isDiscriminatorKeywordEnabled()) {
                    DiscriminatorState discriminatorState2 = executionContext.getDiscriminatorMapping().get(nodePath);
                    JsonNode jsonNode3 = schema.getSchemaNode().get("$ref");
                    if (discriminatorState2 == null || jsonNode3 == null || !discriminatorState2.hasDiscriminatingValue()) {
                        if (arrayList2 == null) {
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.addAll(arrayList3);
                            arrayList5 = arrayList2;
                        }
                    } else if (discriminatorState2.matches(jsonNode3.asText()) && !arrayList3.isEmpty()) {
                        arrayList5 = new ArrayList(arrayList3);
                        arrayList4 = null;
                    }
                    arrayList5 = arrayList2;
                    arrayList4 = arrayList;
                } else {
                    if (!arrayList3.isEmpty() && reportChildErrors(executionContext)) {
                        arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                        arrayList4.addAll(arrayList3);
                        arrayList5 = arrayList2;
                    }
                    arrayList5 = arrayList2;
                    arrayList4 = arrayList;
                }
                i12++;
                it2 = it;
            }
            if (this.schemaContext.isDiscriminatorKeywordEnabled() && (discriminatorState = executionContext.getDiscriminatorMapping().get(nodePath)) != null && !discriminatorState.hasMatchedSchema() && discriminatorState.hasDiscriminatingValue()) {
                errors.add(error().keyword("discriminator").instanceNode(jsonNode).instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).locale(executionContext.getExecutionConfig().getLocale()).messageKey("discriminator.oneOf.no_match_found").arguments(discriminatorState.getDiscriminatingValue()).build());
            }
            executionContext.setFailFast(zIsFailFast);
            if (i11 != 1) {
                errors.add(error().instanceNode(jsonNode).instanceLocation(nodePath).messageKey(i11 > 1 ? "oneOf.indexes" : "oneOf").evaluationPath(executionContext.getEvaluationPath()).locale(executionContext.getExecutionConfig().getLocale()).arguments(Integer.toString(i11), i11 > 1 ? String.join(", ", arrayList6) : "").build());
                if (arrayList2 != null) {
                    errors.addAll(arrayList2);
                } else if (arrayList != null) {
                    errors.addAll(arrayList);
                }
            }
            executionContext.setErrors(errors);
        } catch (Throwable th) {
            executionContext.setFailFast(zIsFailFast);
            throw th;
        }
    }
}
