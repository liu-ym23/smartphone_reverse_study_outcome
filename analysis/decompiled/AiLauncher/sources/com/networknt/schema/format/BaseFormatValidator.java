package com.networknt.schema.format;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.ExecutionContext;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.SpecificationVersion;
import com.networknt.schema.keyword.BaseKeywordValidator;
import com.networknt.schema.keyword.Keyword;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class BaseFormatValidator extends BaseKeywordValidator {
    protected final boolean assertionsEnabled;

    public BaseFormatValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, Keyword keyword, SchemaContext schemaContext) {
        super(keyword, jsonNode, schemaLocation, schema, schemaContext);
        SpecificationVersion specificationVersion = this.schemaContext.getDialect().getSpecificationVersion();
        if (specificationVersion == null || specificationVersion.getOrder() < SpecificationVersion.DRAFT_2019_09.getOrder()) {
            this.assertionsEnabled = true;
        } else {
            this.assertionsEnabled = isFormatAssertionVocabularyEnabled(specificationVersion, this.schemaContext.getDialect().getVocabularies());
        }
    }

    public boolean isAssertionsEnabled(ExecutionContext executionContext) {
        if (Boolean.TRUE.equals(executionContext.getExecutionConfig().getFormatAssertionsEnabled())) {
            return true;
        }
        if (Boolean.FALSE.equals(executionContext.getExecutionConfig().getFormatAssertionsEnabled())) {
            return false;
        }
        return this.assertionsEnabled;
    }

    public boolean isFormatAssertionVocabularyEnabled() {
        return isFormatAssertionVocabularyEnabled(this.schemaContext.getDialect().getSpecificationVersion(), this.schemaContext.getDialect().getVocabularies());
    }

    public boolean isFormatAssertionVocabularyEnabled(SpecificationVersion specificationVersion, Map<String, Boolean> map) {
        if (SpecificationVersion.DRAFT_2020_12.equals(specificationVersion)) {
            return map.containsKey("https://json-schema.org/draft/2020-12/vocab/format-assertion");
        }
        if (SpecificationVersion.DRAFT_2019_09.equals(specificationVersion)) {
            return map.getOrDefault("https://json-schema.org/draft/2019-09/vocab/format", Boolean.FALSE).booleanValue();
        }
        return false;
    }
}
