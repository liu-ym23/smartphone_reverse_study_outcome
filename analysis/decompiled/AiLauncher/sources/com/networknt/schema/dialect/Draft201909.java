package com.networknt.schema.dialect;

import com.networknt.schema.SpecificationVersion;
import com.networknt.schema.dialect.Dialect;
import com.networknt.schema.format.Formats;
import com.networknt.schema.keyword.KeywordType;
import com.networknt.schema.keyword.NonValidationKeyword;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class Draft201909 {
    private static final String ID = "https://json-schema.org/draft/2019-09/schema";
    private static final String ID_KEYWORD = "$id";
    private static final Map<String, Boolean> VOCABULARY;

    public static class Holder {
        private static final Dialect INSTANCE;

        static {
            Dialect.Builder builder = Dialect.builder("https://json-schema.org/draft/2019-09/schema");
            SpecificationVersion specificationVersion = SpecificationVersion.DRAFT_2019_09;
            INSTANCE = builder.specificationVersion(specificationVersion).idKeyword(Draft201909.ID_KEYWORD).formats(Formats.DEFAULT).keywords(KeywordType.getKeywords(specificationVersion)).keywords(Collections.singletonList(new NonValidationKeyword("definitions"))).vocabularies(Draft201909.VOCABULARY).build();
        }

        private Holder() {
        }
    }

    static {
        HashMap map = new HashMap();
        Boolean bool = Boolean.TRUE;
        map.put("https://json-schema.org/draft/2019-09/vocab/core", bool);
        map.put("https://json-schema.org/draft/2019-09/vocab/applicator", bool);
        map.put("https://json-schema.org/draft/2019-09/vocab/validation", bool);
        map.put("https://json-schema.org/draft/2019-09/vocab/meta-data", bool);
        map.put("https://json-schema.org/draft/2019-09/vocab/format", Boolean.FALSE);
        map.put("https://json-schema.org/draft/2019-09/vocab/content", bool);
        VOCABULARY = map;
    }

    public static Dialect getInstance() {
        return Holder.INSTANCE;
    }
}
