package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.FailFastAssertionException;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaException;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.path.NodePath;
import com.networknt.schema.regex.RegularExpression;
import com.networknt.schema.utils.JsonType;
import com.networknt.schema.utils.TypeFactory;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

/* loaded from: classes2.dex */
public class PatternValidator extends BaseKeywordValidator {
    private static final vc.c logger = vc.e.l(PatternValidator.class);
    private final RegularExpression compiledPattern;
    private final String pattern;

    public PatternValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        super(KeywordType.PATTERN, jsonNode, schemaLocation, schema, schemaContext);
        String str = (String) Optional.ofNullable(jsonNode).filter(new Predicate() { // from class: com.networknt.schema.keyword.j0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((JsonNode) obj).isTextual();
            }
        }).map(new Function() { // from class: com.networknt.schema.keyword.k0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((JsonNode) obj).textValue();
            }
        }).orElse(null);
        this.pattern = str;
        try {
            this.compiledPattern = RegularExpression.compile(str, schemaContext);
        } catch (RuntimeException e10) {
            e10.setStackTrace(new StackTraceElement[0]);
            logger.q("Failed to compile pattern '{}': {}", this.pattern, e10.getMessage());
            throw e10;
        }
    }

    private boolean matches(String str) {
        return this.compiledPattern.matches(str);
    }

    @Override // com.networknt.schema.Validator
    public void validate(ExecutionContext executionContext, JsonNode jsonNode, JsonNode jsonNode2, NodePath nodePath) {
        if (TypeFactory.getValueNodeType(jsonNode, this.schemaContext.getSchemaRegistryConfig()) != JsonType.STRING) {
            return;
        }
        try {
            if (matches(jsonNode.asText())) {
                return;
            }
            executionContext.addError(error().instanceNode(jsonNode).instanceLocation(nodePath).evaluationPath(executionContext.getEvaluationPath()).locale(executionContext.getExecutionConfig().getLocale()).arguments(this.pattern).build());
        } catch (FailFastAssertionException | SchemaException e10) {
            throw e10;
        } catch (RuntimeException e11) {
            logger.error("Failed to apply pattern '{}' at {}: {}", this.pattern, nodePath, e11.getMessage());
            throw e11;
        }
    }
}
