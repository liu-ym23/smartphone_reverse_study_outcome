package com.networknt.schema.keyword;

import com.networknt.schema.SchemaContext;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* loaded from: classes2.dex */
public class UnknownKeywordFactory implements KeywordFactory {
    private static final vc.c logger = vc.e.l(UnknownKeywordFactory.class);
    private final Map<String, Keyword> keywords = new ConcurrentHashMap();

    public static class Holder {
        private static final UnknownKeywordFactory INSTANCE = new UnknownKeywordFactory();

        private Holder() {
        }
    }

    public static /* synthetic */ Keyword a(String str) {
        logger.j("Unknown keyword {} - you should define your own Meta Schema. If the keyword is irrelevant for validation, just use a NonValidationKeyword or if it should generate annotations AnnotationKeyword", str);
        return new AnnotationKeyword(str);
    }

    public static UnknownKeywordFactory getInstance() {
        return Holder.INSTANCE;
    }

    @Override // com.networknt.schema.keyword.KeywordFactory
    public Keyword getKeyword(String str, SchemaContext schemaContext) {
        return this.keywords.computeIfAbsent(str, new Function() { // from class: com.networknt.schema.keyword.D0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return UnknownKeywordFactory.a((String) obj);
            }
        });
    }
}
