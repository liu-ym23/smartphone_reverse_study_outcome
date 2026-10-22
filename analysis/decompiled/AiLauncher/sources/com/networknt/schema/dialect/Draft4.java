package com.networknt.schema.dialect;

import com.networknt.schema.SpecificationVersion;
import com.networknt.schema.dialect.Dialect;
import com.networknt.schema.format.Formats;
import com.networknt.schema.keyword.AnnotationKeyword;
import com.networknt.schema.keyword.KeywordType;
import com.networknt.schema.keyword.NonValidationKeyword;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class Draft4 {
    private static final String ID = "http://json-schema.org/draft-04/schema#";
    private static final String ID_KEYWORD = "id";

    public static class Holder {
        private static final Dialect INSTANCE;

        static {
            Dialect.Builder builder = Dialect.builder("http://json-schema.org/draft-04/schema#");
            SpecificationVersion specificationVersion = SpecificationVersion.DRAFT_4;
            INSTANCE = builder.specificationVersion(specificationVersion).idKeyword(Draft4.ID_KEYWORD).formats(Formats.DEFAULT).keywords(KeywordType.getKeywords(specificationVersion)).keywords(Arrays.asList(new NonValidationKeyword("$schema"), new NonValidationKeyword(Draft4.ID_KEYWORD), new AnnotationKeyword("title"), new AnnotationKeyword("description"), new AnnotationKeyword("default"), new NonValidationKeyword("definitions"), new NonValidationKeyword("additionalItems"), new AnnotationKeyword("exampleSetFlag"), new NonValidationKeyword("exclusiveMinimum"), new NonValidationKeyword("exclusiveMaximum"))).build();
        }

        private Holder() {
        }
    }

    public static Dialect getInstance() {
        return Holder.INSTANCE;
    }
}
