package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.format.Format;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public class FormatKeyword implements Keyword {
    private final Map<String, Format> formats;
    private final String value;

    public FormatKeyword(Map<String, Format> map) {
        this(KeywordType.FORMAT, map);
    }

    public Collection<Format> getFormats() {
        return Collections.unmodifiableCollection(this.formats.values());
    }

    @Override // com.networknt.schema.keyword.Keyword
    public String getValue() {
        return this.value;
    }

    @Override // com.networknt.schema.keyword.Keyword
    public KeywordValidator newValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        Format format;
        if (jsonNode == null || !jsonNode.isTextual()) {
            format = null;
        } else {
            format = this.formats.get(jsonNode.textValue());
        }
        return new FormatValidator(schemaLocation, jsonNode, schema, schemaContext, format, this);
    }

    public FormatKeyword(Keyword keyword, Map<String, Format> map) {
        this(keyword.getValue(), map);
    }

    public FormatKeyword(String str, Map<String, Format> map) {
        this.value = str;
        this.formats = map;
    }
}
