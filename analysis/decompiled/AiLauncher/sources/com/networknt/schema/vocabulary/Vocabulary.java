package com.networknt.schema.vocabulary;

import com.networknt.schema.keyword.AnnotationKeyword;
import com.networknt.schema.keyword.Keyword;
import com.networknt.schema.keyword.KeywordType;
import com.networknt.schema.keyword.NonValidationKeyword;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes2.dex */
public class Vocabulary {
    public static final Vocabulary DRAFT_2019_09_APPLICATOR;
    public static final Vocabulary DRAFT_2019_09_CONTENT;
    public static final Vocabulary DRAFT_2019_09_CORE;
    public static final Vocabulary DRAFT_2019_09_FORMAT;
    public static final Vocabulary DRAFT_2019_09_META_DATA;
    public static final Vocabulary DRAFT_2019_09_VALIDATION;
    public static final Vocabulary DRAFT_2020_12_APPLICATOR;
    public static final Vocabulary DRAFT_2020_12_CONTENT;
    public static final Vocabulary DRAFT_2020_12_CORE;
    public static final Vocabulary DRAFT_2020_12_FORMAT_ANNOTATION;
    public static final Vocabulary DRAFT_2020_12_FORMAT_ASSERTION;
    public static final Vocabulary DRAFT_2020_12_META_DATA;
    public static final Vocabulary DRAFT_2020_12_UNEVALUATED;
    public static final Vocabulary DRAFT_2020_12_VALIDATION;
    public static final Vocabulary OPENAPI_3_1_BASE;
    private final String id;
    private final Set<Keyword> keywords;

    static {
        NonValidationKeyword nonValidationKeyword = new NonValidationKeyword("$id");
        NonValidationKeyword nonValidationKeyword2 = new NonValidationKeyword("$schema");
        NonValidationKeyword nonValidationKeyword3 = new NonValidationKeyword("$anchor");
        KeywordType keywordType = KeywordType.REF;
        DRAFT_2019_09_CORE = new Vocabulary("https://json-schema.org/draft/2019-09/vocab/core", nonValidationKeyword, nonValidationKeyword2, nonValidationKeyword3, keywordType, KeywordType.RECURSIVE_REF, new NonValidationKeyword("$recursiveAnchor"), new NonValidationKeyword("$vocabulary"), new NonValidationKeyword("$comment"), new NonValidationKeyword("$defs"));
        NonValidationKeyword nonValidationKeyword4 = new NonValidationKeyword("additionalItems");
        KeywordType keywordType2 = KeywordType.UNEVALUATED_ITEMS;
        KeywordType keywordType3 = KeywordType.CONTAINS;
        KeywordType keywordType4 = KeywordType.ADDITIONAL_PROPERTIES;
        KeywordType keywordType5 = KeywordType.UNEVALUATED_PROPERTIES;
        KeywordType keywordType6 = KeywordType.PROPERTIES;
        KeywordType keywordType7 = KeywordType.PATTERN_PROPERTIES;
        KeywordType keywordType8 = KeywordType.DEPENDENT_SCHEMAS;
        KeywordType keywordType9 = KeywordType.PROPERTY_NAMES;
        KeywordType keywordType10 = KeywordType.IF_THEN_ELSE;
        NonValidationKeyword nonValidationKeyword5 = new NonValidationKeyword("then");
        NonValidationKeyword nonValidationKeyword6 = new NonValidationKeyword("else");
        KeywordType keywordType11 = KeywordType.ALL_OF;
        KeywordType keywordType12 = KeywordType.ANY_OF;
        KeywordType keywordType13 = KeywordType.ONE_OF;
        KeywordType keywordType14 = KeywordType.NOT;
        DRAFT_2019_09_APPLICATOR = new Vocabulary("https://json-schema.org/draft/2019-09/vocab/applicator", nonValidationKeyword4, keywordType2, KeywordType.ITEMS_LEGACY, keywordType3, keywordType4, keywordType5, keywordType6, keywordType7, keywordType8, keywordType9, keywordType10, nonValidationKeyword5, nonValidationKeyword6, keywordType11, keywordType12, keywordType13, keywordType14);
        KeywordType keywordType15 = KeywordType.MULTIPLE_OF;
        KeywordType keywordType16 = KeywordType.MAXIMUM;
        KeywordType keywordType17 = KeywordType.EXCLUSIVE_MAXIMUM;
        KeywordType keywordType18 = KeywordType.MINIMUM;
        KeywordType keywordType19 = KeywordType.EXCLUSIVE_MINIMUM;
        KeywordType keywordType20 = KeywordType.MAX_LENGTH;
        KeywordType keywordType21 = KeywordType.MIN_LENGTH;
        KeywordType keywordType22 = KeywordType.PATTERN;
        KeywordType keywordType23 = KeywordType.MAX_ITEMS;
        KeywordType keywordType24 = KeywordType.MIN_ITEMS;
        KeywordType keywordType25 = KeywordType.UNIQUE_ITEMS;
        KeywordType keywordType26 = KeywordType.MAX_CONTAINS;
        KeywordType keywordType27 = KeywordType.MIN_CONTAINS;
        KeywordType keywordType28 = KeywordType.MAX_PROPERTIES;
        KeywordType keywordType29 = KeywordType.MIN_PROPERTIES;
        KeywordType keywordType30 = KeywordType.REQUIRED;
        KeywordType keywordType31 = KeywordType.DEPENDENT_REQUIRED;
        KeywordType keywordType32 = KeywordType.CONST;
        KeywordType keywordType33 = KeywordType.ENUM;
        KeywordType keywordType34 = KeywordType.TYPE;
        DRAFT_2019_09_VALIDATION = new Vocabulary("https://json-schema.org/draft/2019-09/vocab/validation", keywordType15, keywordType16, keywordType17, keywordType18, keywordType19, keywordType20, keywordType21, keywordType22, keywordType23, keywordType24, keywordType25, keywordType26, keywordType27, keywordType28, keywordType29, keywordType30, keywordType31, keywordType32, keywordType33, keywordType34);
        AnnotationKeyword annotationKeyword = new AnnotationKeyword("title");
        AnnotationKeyword annotationKeyword2 = new AnnotationKeyword("description");
        AnnotationKeyword annotationKeyword3 = new AnnotationKeyword("default");
        AnnotationKeyword annotationKeyword4 = new AnnotationKeyword("deprecated");
        KeywordType keywordType35 = KeywordType.READ_ONLY;
        KeywordType keywordType36 = KeywordType.WRITE_ONLY;
        DRAFT_2019_09_META_DATA = new Vocabulary("https://json-schema.org/draft/2019-09/vocab/meta-data", annotationKeyword, annotationKeyword2, annotationKeyword3, annotationKeyword4, keywordType35, keywordType36, new AnnotationKeyword("examples"));
        KeywordType keywordType37 = KeywordType.FORMAT;
        DRAFT_2019_09_FORMAT = new Vocabulary("https://json-schema.org/draft/2019-09/vocab/format", keywordType37);
        DRAFT_2019_09_CONTENT = new Vocabulary("https://json-schema.org/draft/2019-09/vocab/content", new AnnotationKeyword("contentMediaType"), new AnnotationKeyword("contentEncoding"), new AnnotationKeyword("contentSchema"));
        DRAFT_2020_12_CORE = new Vocabulary("https://json-schema.org/draft/2020-12/vocab/core", new NonValidationKeyword("$id"), new NonValidationKeyword("$schema"), keywordType, new NonValidationKeyword("$anchor"), KeywordType.DYNAMIC_REF, new NonValidationKeyword("$dynamicAnchor"), new NonValidationKeyword("$vocabulary"), new NonValidationKeyword("$comment"), new NonValidationKeyword("$defs"));
        DRAFT_2020_12_APPLICATOR = new Vocabulary("https://json-schema.org/draft/2020-12/vocab/applicator", KeywordType.PREFIX_ITEMS, KeywordType.ITEMS, keywordType3, keywordType4, keywordType6, keywordType7, keywordType8, keywordType9, keywordType10, new NonValidationKeyword("then"), new NonValidationKeyword("else"), keywordType11, keywordType12, keywordType13, keywordType14);
        DRAFT_2020_12_UNEVALUATED = new Vocabulary("https://json-schema.org/draft/2020-12/vocab/unevaluated", keywordType2, keywordType5);
        DRAFT_2020_12_VALIDATION = new Vocabulary("https://json-schema.org/draft/2020-12/vocab/validation", keywordType34, keywordType32, keywordType33, keywordType15, keywordType16, keywordType17, keywordType18, keywordType19, keywordType20, keywordType21, keywordType22, keywordType23, keywordType24, keywordType25, keywordType26, keywordType27, keywordType28, keywordType29, keywordType30, keywordType31);
        DRAFT_2020_12_META_DATA = new Vocabulary("https://json-schema.org/draft/2020-12/vocab/meta-data", new AnnotationKeyword("title"), new AnnotationKeyword("description"), new AnnotationKeyword("default"), new AnnotationKeyword("deprecated"), keywordType35, keywordType36, new AnnotationKeyword("examples"));
        DRAFT_2020_12_FORMAT_ANNOTATION = new Vocabulary("https://json-schema.org/draft/2020-12/vocab/format-annotation", keywordType37);
        DRAFT_2020_12_FORMAT_ASSERTION = new Vocabulary("https://json-schema.org/draft/2020-12/vocab/format-assertion", keywordType37);
        DRAFT_2020_12_CONTENT = new Vocabulary("https://json-schema.org/draft/2020-12/vocab/content", new AnnotationKeyword("contentEncoding"), new AnnotationKeyword("contentMediaType"), new AnnotationKeyword("contentSchema"));
        OPENAPI_3_1_BASE = new Vocabulary("https://spec.openapis.org/oas/3.1/vocab/base", new AnnotationKeyword("example"), KeywordType.DISCRIMINATOR, new AnnotationKeyword("externalDocs"), new AnnotationKeyword("xml"));
    }

    public Vocabulary(String str, Keyword... keywordArr) {
        this.id = str;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.keywords = linkedHashSet;
        linkedHashSet.addAll(Arrays.asList(keywordArr));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Vocabulary vocabulary = (Vocabulary) obj;
        return Objects.equals(this.id, vocabulary.id) && Objects.equals(this.keywords, vocabulary.keywords);
    }

    public String getId() {
        return this.id;
    }

    public Set<Keyword> getKeywords() {
        return this.keywords;
    }

    public int hashCode() {
        return Objects.hash(this.id, this.keywords);
    }

    public String toString() {
        return "Vocabulary [id=" + this.id + ", keywords=" + this.keywords + "]";
    }
}
