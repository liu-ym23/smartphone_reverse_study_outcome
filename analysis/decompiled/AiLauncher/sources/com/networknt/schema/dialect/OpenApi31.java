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
public class OpenApi31 {
    private static final String ID = "https://spec.openapis.org/oas/3.1/dialect/base";
    private static final String ID_KEYWORD = "$id";
    private static final Map<String, Boolean> VOCABULARY;

    public static class Holder {
        private static final Dialect INSTANCE;

        static {
            Dialect.Builder builder = Dialect.builder("https://spec.openapis.org/oas/3.1/dialect/base");
            SpecificationVersion specificationVersion = SpecificationVersion.DRAFT_2020_12;
            INSTANCE = builder.specificationVersion(specificationVersion).idKeyword(OpenApi31.ID_KEYWORD).formats(Formats.DEFAULT).keywords(KeywordType.getKeywords(specificationVersion)).keywords(Collections.singletonList(new NonValidationKeyword("definitions"))).vocabularies(OpenApi31.VOCABULARY).build();
        }

        private Holder() {
        }
    }

    static {
        HashMap map = new HashMap();
        Boolean bool = Boolean.TRUE;
        map.put("https://json-schema.org/draft/2020-12/vocab/core", bool);
        map.put("https://json-schema.org/draft/2020-12/vocab/applicator", bool);
        map.put("https://json-schema.org/draft/2020-12/vocab/unevaluated", bool);
        map.put("https://json-schema.org/draft/2020-12/vocab/validation", bool);
        map.put("https://json-schema.org/draft/2020-12/vocab/meta-data", bool);
        map.put("https://json-schema.org/draft/2020-12/vocab/format-annotation", bool);
        map.put("https://json-schema.org/draft/2020-12/vocab/content", bool);
        map.put("https://spec.openapis.org/oas/3.1/vocab/base", Boolean.FALSE);
        VOCABULARY = map;
    }

    public static Dialect getInstance() {
        return Holder.INSTANCE;
    }
}
