package com.networknt.schema.vocabulary;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class Vocabularies {
    private static final Map<String, Vocabulary> VALUES;

    static {
        HashMap map = new HashMap();
        Vocabulary vocabulary = Vocabulary.DRAFT_2019_09_CORE;
        map.put(vocabulary.getId(), vocabulary);
        Vocabulary vocabulary2 = Vocabulary.DRAFT_2019_09_APPLICATOR;
        map.put(vocabulary2.getId(), vocabulary2);
        Vocabulary vocabulary3 = Vocabulary.DRAFT_2019_09_VALIDATION;
        map.put(vocabulary3.getId(), vocabulary3);
        Vocabulary vocabulary4 = Vocabulary.DRAFT_2019_09_META_DATA;
        map.put(vocabulary4.getId(), vocabulary4);
        Vocabulary vocabulary5 = Vocabulary.DRAFT_2019_09_FORMAT;
        map.put(vocabulary5.getId(), vocabulary5);
        Vocabulary vocabulary6 = Vocabulary.DRAFT_2019_09_CONTENT;
        map.put(vocabulary6.getId(), vocabulary6);
        Vocabulary vocabulary7 = Vocabulary.DRAFT_2020_12_CORE;
        map.put(vocabulary7.getId(), vocabulary7);
        Vocabulary vocabulary8 = Vocabulary.DRAFT_2020_12_APPLICATOR;
        map.put(vocabulary8.getId(), vocabulary8);
        Vocabulary vocabulary9 = Vocabulary.DRAFT_2020_12_UNEVALUATED;
        map.put(vocabulary9.getId(), vocabulary9);
        Vocabulary vocabulary10 = Vocabulary.DRAFT_2020_12_VALIDATION;
        map.put(vocabulary10.getId(), vocabulary10);
        Vocabulary vocabulary11 = Vocabulary.DRAFT_2020_12_META_DATA;
        map.put(vocabulary11.getId(), vocabulary11);
        Vocabulary vocabulary12 = Vocabulary.DRAFT_2020_12_FORMAT_ANNOTATION;
        map.put(vocabulary12.getId(), vocabulary12);
        Vocabulary vocabulary13 = Vocabulary.DRAFT_2020_12_FORMAT_ASSERTION;
        map.put(vocabulary13.getId(), vocabulary13);
        Vocabulary vocabulary14 = Vocabulary.DRAFT_2020_12_CONTENT;
        map.put(vocabulary14.getId(), vocabulary14);
        Vocabulary vocabulary15 = Vocabulary.OPENAPI_3_1_BASE;
        map.put(vocabulary15.getId(), vocabulary15);
        VALUES = map;
    }

    public static Vocabulary getVocabulary(String str) {
        return VALUES.get(str);
    }
}
