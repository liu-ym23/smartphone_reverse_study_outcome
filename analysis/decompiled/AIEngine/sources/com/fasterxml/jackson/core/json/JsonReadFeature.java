package com.fasterxml.jackson.core.json;

import a3.e;
import com.fasterxml.jackson.core.JsonParser;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public enum JsonReadFeature implements e {
    /* JADX INFO: Fake field, exist only in values array */
    ALLOW_JAVA_COMMENTS(JsonParser.Feature.ALLOW_COMMENTS),
    /* JADX INFO: Fake field, exist only in values array */
    ALLOW_YAML_COMMENTS(JsonParser.Feature.ALLOW_YAML_COMMENTS),
    /* JADX INFO: Fake field, exist only in values array */
    ALLOW_SINGLE_QUOTES(JsonParser.Feature.ALLOW_SINGLE_QUOTES),
    /* JADX INFO: Fake field, exist only in values array */
    ALLOW_UNQUOTED_FIELD_NAMES(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES),
    /* JADX INFO: Fake field, exist only in values array */
    ALLOW_UNESCAPED_CONTROL_CHARS(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS),
    /* JADX INFO: Fake field, exist only in values array */
    ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER),
    /* JADX INFO: Fake field, exist only in values array */
    ALLOW_LEADING_ZEROS_FOR_NUMBERS(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS),
    ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS(JsonParser.Feature.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS),
    /* JADX INFO: Fake field, exist only in values array */
    ALLOW_NON_NUMERIC_NUMBERS(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS),
    /* JADX INFO: Fake field, exist only in values array */
    ALLOW_MISSING_VALUES(JsonParser.Feature.ALLOW_MISSING_VALUES),
    /* JADX INFO: Fake field, exist only in values array */
    ALLOW_TRAILING_COMMA(JsonParser.Feature.ALLOW_TRAILING_COMMA);


    /* renamed from: a, reason: collision with root package name */
    public final int f3617a = 1 << ordinal();

    /* renamed from: b, reason: collision with root package name */
    public final JsonParser.Feature f3618b;

    JsonReadFeature(JsonParser.Feature feature) {
        this.f3618b = feature;
    }

    @Override // a3.e
    public final boolean a() {
        return false;
    }

    @Override // a3.e
    public final int b() {
        return this.f3617a;
    }
}
