package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.Error;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.keyword.MinMaxContainsValidator;
import com.networknt.schema.path.NodePath;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

/* loaded from: classes2.dex */
public class MinMaxContainsValidator extends BaseKeywordValidator {
    private final Set<Analysis> analysis;

    public static class Analysis {
        private final String messageKey;
        private final SchemaLocation schemaLocation;

        public Analysis(String str, SchemaLocation schemaLocation) {
            this.messageKey = str;
            this.schemaLocation = schemaLocation;
        }

        public String getMessageKey() {
            return this.messageKey;
        }

        public SchemaLocation getSchemaLocation() {
            return this.schemaLocation;
        }
    }

    public MinMaxContainsValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.MAX_CONTAINS, jsonNode, schemaLocation, schema, schemaContext);
        JsonNode jsonNode2 = schema.getSchemaNode().get("minContains");
        LinkedHashSet linkedHashSet = null;
        int iIntValue = 1;
        if (jsonNode2 != null) {
            if (jsonNode2.isNumber() && jsonNode2.canConvertToExactIntegral() && jsonNode2.intValue() >= 0) {
                iIntValue = jsonNode2.intValue();
            } else {
                linkedHashSet = new LinkedHashSet();
                linkedHashSet.add(new Analysis("minContains", schemaLocation));
            }
        }
        JsonNode jsonNode3 = schema.getSchemaNode().get("maxContains");
        int iIntValue2 = Integer.MAX_VALUE;
        if (jsonNode3 != null) {
            if (jsonNode3.isNumber() && jsonNode3.canConvertToExactIntegral() && jsonNode3.intValue() >= 0) {
                iIntValue2 = jsonNode3.intValue();
            } else {
                linkedHashSet = linkedHashSet == null ? new LinkedHashSet() : linkedHashSet;
                linkedHashSet.add(new Analysis("maxContains", schemaLocation));
            }
        }
        if (iIntValue2 < iIntValue) {
            linkedHashSet = linkedHashSet == null ? new LinkedHashSet() : linkedHashSet;
            linkedHashSet.add(new Analysis("minContainsVsMaxContains", schemaLocation));
        }
        this.analysis = linkedHashSet;
    }

    @Override // com.networknt.schema.Validator
    public void validate(final ExecutionContext executionContext, final JsonNode jsonNode, JsonNode jsonNode2, final NodePath nodePath) {
        Set<Analysis> set = this.analysis;
        if (set != null) {
            Stream<R> map = set.stream().map(new Function() { // from class: com.networknt.schema.keyword.h0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    MinMaxContainsValidator minMaxContainsValidator = this.f21983a;
                    JsonNode jsonNode3 = jsonNode;
                    NodePath nodePath2 = nodePath;
                    ExecutionContext executionContext2 = executionContext;
                    MinMaxContainsValidator.Analysis analysis = (MinMaxContainsValidator.Analysis) obj;
                    return minMaxContainsValidator.error().instanceNode(jsonNode3).instanceLocation(nodePath2).evaluationPath(executionContext2.getEvaluationPath()).messageKey(analysis.getMessageKey()).locale(executionContext2.getExecutionConfig().getLocale()).keyword(analysis.getMessageKey()).arguments(minMaxContainsValidator.parentSchema.getSchemaNode().toString()).build();
                }
            });
            Objects.requireNonNull(executionContext);
            map.forEach(new Consumer() { // from class: com.networknt.schema.keyword.i0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    executionContext.addError((Error) obj);
                }
            });
        }
    }
}
