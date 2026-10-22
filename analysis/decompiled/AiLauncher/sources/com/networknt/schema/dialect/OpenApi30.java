package com.networknt.schema.dialect;

import com.networknt.schema.SpecificationVersion;
import com.networknt.schema.format.Formats;
import com.networknt.schema.keyword.AnnotationKeyword;
import com.networknt.schema.keyword.KeywordType;
import com.networknt.schema.keyword.NonValidationKeyword;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class OpenApi30 {
    private static final String ID = "https://spec.openapis.org/oas/3.0/dialect";
    private static final String ID_KEYWORD = "id";

    public static class Holder {
        private static final Dialect INSTANCE = Dialect.builder("https://spec.openapis.org/oas/3.0/dialect").specificationVersion(SpecificationVersion.DRAFT_4).idKeyword(OpenApi30.ID_KEYWORD).formats(Formats.DEFAULT).keywords(Arrays.asList(new AnnotationKeyword("title"), KeywordType.PATTERN, KeywordType.REQUIRED, KeywordType.ENUM, KeywordType.MINIMUM, KeywordType.MAXIMUM, KeywordType.MULTIPLE_OF, KeywordType.MIN_LENGTH, KeywordType.MAX_LENGTH, KeywordType.MIN_ITEMS, KeywordType.MAX_ITEMS, KeywordType.UNIQUE_ITEMS, KeywordType.MIN_PROPERTIES, KeywordType.MAX_PROPERTIES, KeywordType.TYPE, KeywordType.FORMAT, new AnnotationKeyword("description"), KeywordType.ITEMS_LEGACY, KeywordType.PROPERTIES, KeywordType.ADDITIONAL_PROPERTIES, new AnnotationKeyword("default"), KeywordType.ALL_OF, KeywordType.ONE_OF, KeywordType.ANY_OF, KeywordType.NOT, new AnnotationKeyword("deprecated"), KeywordType.DISCRIMINATOR, new AnnotationKeyword("example"), new AnnotationKeyword("externalDocs"), new NonValidationKeyword("nullable"), KeywordType.READ_ONLY, KeywordType.WRITE_ONLY, new AnnotationKeyword("xml"), KeywordType.REF)).build();

        private Holder() {
        }
    }

    public static Dialect getInstance() {
        return Holder.INSTANCE;
    }
}
