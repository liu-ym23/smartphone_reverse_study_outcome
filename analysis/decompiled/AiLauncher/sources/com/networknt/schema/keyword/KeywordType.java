package com.networknt.schema.keyword;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.SpecificationVersion;
import com.networknt.schema.SpecificationVersionRange;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'ADDITIONAL_PROPERTIES' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public class KeywordType implements Keyword {
    private static final /* synthetic */ KeywordType[] $VALUES;
    public static final KeywordType ADDITIONAL_PROPERTIES;
    public static final KeywordType ALL_OF;
    public static final KeywordType ANY_OF;
    public static final KeywordType CONST;
    private static final Map<String, KeywordType> CONSTANTS;
    public static final KeywordType CONTAINS;
    public static final KeywordType CONTENT_ENCODING;
    public static final KeywordType CONTENT_MEDIA_TYPE;
    public static final KeywordType DEPENDENCIES;
    public static final KeywordType DEPENDENT_REQUIRED;
    public static final KeywordType DEPENDENT_SCHEMAS;
    public static final KeywordType DISCRIMINATOR;
    public static final KeywordType DYNAMIC_REF;
    public static final KeywordType ENUM;
    public static final KeywordType EXCLUSIVE_MAXIMUM;
    public static final KeywordType EXCLUSIVE_MINIMUM;
    public static final KeywordType FALSE;
    public static final KeywordType FORMAT;
    public static final KeywordType ID;
    public static final KeywordType IF_THEN_ELSE;
    public static final KeywordType ITEMS;
    public static final KeywordType ITEMS_LEGACY;
    public static final KeywordType MAXIMUM;
    public static final KeywordType MAX_CONTAINS;
    public static final KeywordType MAX_ITEMS;
    public static final KeywordType MAX_LENGTH;
    public static final KeywordType MAX_PROPERTIES;
    public static final KeywordType MINIMUM;
    public static final KeywordType MIN_CONTAINS;
    public static final KeywordType MIN_ITEMS;
    public static final KeywordType MIN_LENGTH;
    public static final KeywordType MIN_PROPERTIES;
    public static final KeywordType MULTIPLE_OF;
    public static final KeywordType NOT;
    public static final KeywordType NOT_ALLOWED;
    public static final KeywordType ONE_OF;
    public static final KeywordType PATTERN;
    public static final KeywordType PATTERN_PROPERTIES;
    public static final KeywordType PREFIX_ITEMS;
    public static final KeywordType PROPERTIES;
    public static final KeywordType PROPERTY_DEPENDENCIES;
    public static final KeywordType PROPERTY_NAMES;
    public static final KeywordType READ_ONLY;
    public static final KeywordType RECURSIVE_REF;
    public static final KeywordType REF;
    public static final KeywordType REQUIRED;
    public static final KeywordType TRUE;
    public static final KeywordType TYPE;
    public static final KeywordType UNEVALUATED_ITEMS;
    public static final KeywordType UNEVALUATED_PROPERTIES;
    public static final KeywordType UNION_TYPE;
    public static final KeywordType UNIQUE_ITEMS;
    public static final KeywordType WRITE_ONLY;
    private final SpecificationVersionRange specificationVersionRange;
    private final ValidatorFactory validatorFactory;
    private final String value;

    private static /* synthetic */ KeywordType[] $values() {
        return new KeywordType[]{ADDITIONAL_PROPERTIES, ALL_OF, ANY_OF, CONST, CONTAINS, CONTENT_ENCODING, CONTENT_MEDIA_TYPE, DEPENDENCIES, DEPENDENT_REQUIRED, DEPENDENT_SCHEMAS, DISCRIMINATOR, DYNAMIC_REF, ENUM, EXCLUSIVE_MAXIMUM, EXCLUSIVE_MINIMUM, FALSE, FORMAT, ID, IF_THEN_ELSE, ITEMS, ITEMS_LEGACY, MAX_CONTAINS, MAX_ITEMS, MAX_LENGTH, MAX_PROPERTIES, MAXIMUM, MIN_CONTAINS, MIN_ITEMS, MIN_LENGTH, MIN_PROPERTIES, MINIMUM, MULTIPLE_OF, NOT_ALLOWED, NOT, ONE_OF, PATTERN_PROPERTIES, PATTERN, PREFIX_ITEMS, PROPERTIES, PROPERTY_DEPENDENCIES, PROPERTY_NAMES, READ_ONLY, RECURSIVE_REF, REF, REQUIRED, TRUE, TYPE, UNEVALUATED_ITEMS, UNEVALUATED_PROPERTIES, UNION_TYPE, UNIQUE_ITEMS, WRITE_ONLY};
    }

    static {
        ValidatorFactory validatorFactory = new ValidatorFactory() { // from class: com.networknt.schema.keyword.j
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new AdditionalPropertiesValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        };
        SpecificationVersionRange specificationVersionRange = SpecificationVersionRange.MAX_DRAFT_7;
        ADDITIONAL_PROPERTIES = new KeywordType("ADDITIONAL_PROPERTIES", 0, "additionalProperties", validatorFactory, specificationVersionRange);
        ALL_OF = new KeywordType("ALL_OF", 1, "allOf", new ValidatorFactory() { // from class: com.networknt.schema.keyword.l
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new AllOfValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange);
        ANY_OF = new KeywordType("ANY_OF", 2, "anyOf", new ValidatorFactory() { // from class: com.networknt.schema.keyword.w
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new AnyOfValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange);
        ValidatorFactory validatorFactory2 = new ValidatorFactory() { // from class: com.networknt.schema.keyword.I
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new ConstValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        };
        SpecificationVersionRange specificationVersionRange2 = SpecificationVersionRange.DRAFT_6_TO_DRAFT_7;
        CONST = new KeywordType("CONST", 3, "const", validatorFactory2, specificationVersionRange2);
        CONTAINS = new KeywordType("CONTAINS", 4, "contains", new ValidatorFactory() { // from class: com.networknt.schema.keyword.V
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new ContainsValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange2);
        ValidatorFactory validatorFactory3 = new ValidatorFactory() { // from class: com.networknt.schema.keyword.W
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new ContentEncodingValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        };
        SpecificationVersionRange specificationVersionRange3 = SpecificationVersionRange.DRAFT_7;
        CONTENT_ENCODING = new KeywordType("CONTENT_ENCODING", 5, "contentEncoding", validatorFactory3, specificationVersionRange3);
        CONTENT_MEDIA_TYPE = new KeywordType("CONTENT_MEDIA_TYPE", 6, "contentMediaType", new ValidatorFactory() { // from class: com.networknt.schema.keyword.X
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new ContentMediaTypeValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange3);
        ValidatorFactory validatorFactory4 = new ValidatorFactory() { // from class: com.networknt.schema.keyword.Y
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new DependenciesValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        };
        SpecificationVersionRange specificationVersionRange4 = SpecificationVersionRange.ALL_VERSIONS;
        DEPENDENCIES = new KeywordType("DEPENDENCIES", 7, "dependencies", validatorFactory4, specificationVersionRange4);
        ValidatorFactory validatorFactory5 = new ValidatorFactory() { // from class: com.networknt.schema.keyword.Z
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new DependentRequired(schemaLocation, jsonNode, schema, schemaContext);
            }
        };
        SpecificationVersionRange specificationVersionRange5 = SpecificationVersionRange.NONE;
        DEPENDENT_REQUIRED = new KeywordType("DEPENDENT_REQUIRED", 8, "dependentRequired", validatorFactory5, specificationVersionRange5);
        DEPENDENT_SCHEMAS = new KeywordType("DEPENDENT_SCHEMAS", 9, "dependentSchemas", new ValidatorFactory() { // from class: com.networknt.schema.keyword.a0
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new DependentSchemas(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange5);
        DISCRIMINATOR = new KeywordType("DISCRIMINATOR", 10, "discriminator", new ValidatorFactory() { // from class: com.networknt.schema.keyword.u
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new DiscriminatorValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange5);
        DYNAMIC_REF = new KeywordType("DYNAMIC_REF", 11, "$dynamicRef", new ValidatorFactory() { // from class: com.networknt.schema.keyword.F
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new DynamicRefValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange5);
        ENUM = new KeywordType("ENUM", 12, "enum", new ValidatorFactory() { // from class: com.networknt.schema.keyword.Q
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new EnumValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange);
        EXCLUSIVE_MAXIMUM = new KeywordType("EXCLUSIVE_MAXIMUM", 13, "exclusiveMaximum", new ValidatorFactory() { // from class: com.networknt.schema.keyword.b0
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new ExclusiveMaximumValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange2);
        EXCLUSIVE_MINIMUM = new KeywordType("EXCLUSIVE_MINIMUM", 14, "exclusiveMinimum", new ValidatorFactory() { // from class: com.networknt.schema.keyword.c0
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new ExclusiveMinimumValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange2);
        ValidatorFactory validatorFactory6 = new ValidatorFactory() { // from class: com.networknt.schema.keyword.d0
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new FalseValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        };
        SpecificationVersionRange specificationVersionRange6 = SpecificationVersionRange.MIN_DRAFT_6;
        FALSE = new KeywordType("FALSE", 15, "false", validatorFactory6, specificationVersionRange6);
        FORMAT = new KeywordType("FORMAT", 16, "format", null, specificationVersionRange) { // from class: com.networknt.schema.keyword.KeywordType.1
            @Override // com.networknt.schema.keyword.KeywordType, com.networknt.schema.keyword.Keyword
            public KeywordValidator newValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                throw new UnsupportedOperationException("Use FormatKeyword instead");
            }
        };
        ID = new KeywordType("ID", 17, "id", null, specificationVersionRange4);
        IF_THEN_ELSE = new KeywordType("IF_THEN_ELSE", 18, "if", new ValidatorFactory() { // from class: com.networknt.schema.keyword.e0
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new IfValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange3);
        ITEMS = new KeywordType("ITEMS", 19, DidiCardProvider.KEY_ITEMS, new ValidatorFactory() { // from class: com.networknt.schema.keyword.f0
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new ItemsValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange5);
        ITEMS_LEGACY = new KeywordType("ITEMS_LEGACY", 20, DidiCardProvider.KEY_ITEMS, new ValidatorFactory() { // from class: com.networknt.schema.keyword.g0
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new ItemsLegacyValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange);
        MAX_CONTAINS = new KeywordType("MAX_CONTAINS", 21, "maxContains", new ValidatorFactory() { // from class: com.networknt.schema.keyword.k
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new MinMaxContainsValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange5);
        MAX_ITEMS = new KeywordType("MAX_ITEMS", 22, "maxItems", new ValidatorFactory() { // from class: com.networknt.schema.keyword.m
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new MaxItemsValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange);
        MAX_LENGTH = new KeywordType("MAX_LENGTH", 23, "maxLength", new ValidatorFactory() { // from class: com.networknt.schema.keyword.n
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new MaxLengthValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange);
        MAX_PROPERTIES = new KeywordType("MAX_PROPERTIES", 24, "maxProperties", new ValidatorFactory() { // from class: com.networknt.schema.keyword.o
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new MaxPropertiesValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange);
        MAXIMUM = new KeywordType("MAXIMUM", 25, "maximum", new ValidatorFactory() { // from class: com.networknt.schema.keyword.p
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new MaximumValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange);
        MIN_CONTAINS = new KeywordType("MIN_CONTAINS", 26, "minContains", new ValidatorFactory() { // from class: com.networknt.schema.keyword.k
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new MinMaxContainsValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange5);
        MIN_ITEMS = new KeywordType("MIN_ITEMS", 27, "minItems", new ValidatorFactory() { // from class: com.networknt.schema.keyword.q
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new MinItemsValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange);
        MIN_LENGTH = new KeywordType("MIN_LENGTH", 28, "minLength", new ValidatorFactory() { // from class: com.networknt.schema.keyword.r
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new MinLengthValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange);
        MIN_PROPERTIES = new KeywordType("MIN_PROPERTIES", 29, "minProperties", new ValidatorFactory() { // from class: com.networknt.schema.keyword.s
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new MinPropertiesValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange);
        MINIMUM = new KeywordType("MINIMUM", 30, "minimum", new ValidatorFactory() { // from class: com.networknt.schema.keyword.t
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new MinimumValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange);
        MULTIPLE_OF = new KeywordType("MULTIPLE_OF", 31, "multipleOf", new ValidatorFactory() { // from class: com.networknt.schema.keyword.v
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new MultipleOfValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange);
        NOT_ALLOWED = new KeywordType("NOT_ALLOWED", 32, "notAllowed", new ValidatorFactory() { // from class: com.networknt.schema.keyword.x
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new NotAllowedValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange4);
        NOT = new KeywordType("NOT", 33, "not", new ValidatorFactory() { // from class: com.networknt.schema.keyword.y
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new NotValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange);
        ONE_OF = new KeywordType("ONE_OF", 34, "oneOf", new ValidatorFactory() { // from class: com.networknt.schema.keyword.z
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new OneOfValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange);
        PATTERN_PROPERTIES = new KeywordType("PATTERN_PROPERTIES", 35, PatternPropertiesValidator.PROPERTY, new ValidatorFactory() { // from class: com.networknt.schema.keyword.A
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new PatternPropertiesValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange);
        PATTERN = new KeywordType("PATTERN", 36, "pattern", new ValidatorFactory() { // from class: com.networknt.schema.keyword.B
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new PatternValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange);
        PREFIX_ITEMS = new KeywordType("PREFIX_ITEMS", 37, "prefixItems", new ValidatorFactory() { // from class: com.networknt.schema.keyword.C
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new PrefixItemsValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange5);
        PROPERTIES = new KeywordType("PROPERTIES", 38, PropertiesValidator.PROPERTY, new ValidatorFactory() { // from class: com.networknt.schema.keyword.D
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new PropertiesValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange);
        PROPERTY_DEPENDENCIES = new KeywordType("PROPERTY_DEPENDENCIES", 39, "propertyDependencies", new ValidatorFactory() { // from class: com.networknt.schema.keyword.E
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new PropertyDependenciesValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange5);
        PROPERTY_NAMES = new KeywordType("PROPERTY_NAMES", 40, "propertyNames", new ValidatorFactory() { // from class: com.networknt.schema.keyword.G
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new PropertyNamesValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange2);
        READ_ONLY = new KeywordType("READ_ONLY", 41, "readOnly", new ValidatorFactory() { // from class: com.networknt.schema.keyword.H
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new ReadOnlyValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange3);
        RECURSIVE_REF = new KeywordType("RECURSIVE_REF", 42, "$recursiveRef", new ValidatorFactory() { // from class: com.networknt.schema.keyword.J
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new RecursiveRefValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange5);
        REF = new KeywordType("REF", 43, "$ref", new ValidatorFactory() { // from class: com.networknt.schema.keyword.K
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new RefValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange);
        REQUIRED = new KeywordType("REQUIRED", 44, "required", new ValidatorFactory() { // from class: com.networknt.schema.keyword.L
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new RequiredValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange);
        TRUE = new KeywordType("TRUE", 45, "true", new ValidatorFactory() { // from class: com.networknt.schema.keyword.M
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new TrueValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange6);
        TYPE = new KeywordType("TYPE", 46, "type", new ValidatorFactory() { // from class: com.networknt.schema.keyword.N
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new TypeValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange);
        UNEVALUATED_ITEMS = new KeywordType("UNEVALUATED_ITEMS", 47, "unevaluatedItems", new ValidatorFactory() { // from class: com.networknt.schema.keyword.O
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new UnevaluatedItemsValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange5);
        UNEVALUATED_PROPERTIES = new KeywordType("UNEVALUATED_PROPERTIES", 48, "unevaluatedProperties", new ValidatorFactory() { // from class: com.networknt.schema.keyword.P
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new UnevaluatedPropertiesValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange5);
        UNION_TYPE = new KeywordType("UNION_TYPE", 49, "unionType", new ValidatorFactory() { // from class: com.networknt.schema.keyword.S
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new UnionTypeValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange5);
        UNIQUE_ITEMS = new KeywordType("UNIQUE_ITEMS", 50, "uniqueItems", new ValidatorFactory() { // from class: com.networknt.schema.keyword.T
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new UniqueItemsValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange);
        WRITE_ONLY = new KeywordType("WRITE_ONLY", 51, "writeOnly", new ValidatorFactory() { // from class: com.networknt.schema.keyword.U
            @Override // com.networknt.schema.keyword.ValidatorFactory
            public final KeywordValidator newInstance(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
                return new WriteOnlyValidator(schemaLocation, jsonNode, schema, schemaContext);
            }
        }, specificationVersionRange3);
        $VALUES = $values();
        CONSTANTS = new HashMap();
        for (KeywordType keywordType : values()) {
            CONSTANTS.put(keywordType.value, keywordType);
        }
    }

    public static KeywordType fromValue(String str) {
        KeywordType keywordType = CONSTANTS.get(str);
        if (keywordType != null) {
            return keywordType;
        }
        throw new IllegalArgumentException(str);
    }

    public static List<KeywordType> getKeywords(SpecificationVersion specificationVersion) {
        ArrayList arrayList = new ArrayList();
        for (KeywordType keywordType : values()) {
            if (keywordType.getSpecificationVersionRange().getVersions().contains(specificationVersion)) {
                arrayList.add(keywordType);
            }
        }
        return arrayList;
    }

    public static KeywordType valueOf(String str) {
        return (KeywordType) Enum.valueOf(KeywordType.class, str);
    }

    public static KeywordType[] values() {
        return (KeywordType[]) $VALUES.clone();
    }

    public SpecificationVersionRange getSpecificationVersionRange() {
        return this.specificationVersionRange;
    }

    @Override // com.networknt.schema.keyword.Keyword
    public String getValue() {
        return this.value;
    }

    @Override // com.networknt.schema.keyword.Keyword
    public KeywordValidator newValidator(SchemaLocation schemaLocation, JsonNode jsonNode, Schema schema, SchemaContext schemaContext) {
        ValidatorFactory validatorFactory = this.validatorFactory;
        if (validatorFactory != null) {
            return validatorFactory.newInstance(schemaLocation, jsonNode, schema, schemaContext);
        }
        throw new UnsupportedOperationException("No suitable validator for " + getValue());
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    private KeywordType(String str, int i10, String str2, ValidatorFactory validatorFactory, SpecificationVersionRange specificationVersionRange) {
        this.value = str2;
        this.validatorFactory = validatorFactory;
        this.specificationVersionRange = specificationVersionRange;
    }
}
