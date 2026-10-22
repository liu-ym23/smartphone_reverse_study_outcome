package com.networknt.schema.dialect;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.Error;
import com.networknt.schema.InvalidSchemaException;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.SchemaException;
import com.networknt.schema.SchemaLocation;
import com.networknt.schema.SpecificationVersion;
import com.networknt.schema.format.Format;
import com.networknt.schema.keyword.FormatKeyword;
import com.networknt.schema.keyword.Keyword;
import com.networknt.schema.keyword.KeywordFactory;
import com.networknt.schema.keyword.KeywordType;
import com.networknt.schema.keyword.KeywordValidator;
import com.networknt.schema.keyword.UnknownKeywordFactory;
import com.networknt.schema.utils.Strings;
import com.networknt.schema.vocabulary.Vocabularies;
import com.networknt.schema.vocabulary.Vocabulary;
import com.networknt.schema.vocabulary.VocabularyRegistry;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import vc.e;

/* loaded from: classes2.dex */
public class Dialect {
    private static final vc.c logger = e.l(Dialect.class);
    private final Builder builder;
    private final String id;
    private final String idKeyword;
    private final Map<String, Keyword> keywords;
    private final SpecificationVersion specificationVersion;
    private final Map<String, Boolean> vocabularies;

    public static class Builder {
        private String id;
        private String idKeyword = "$id";
        private SpecificationVersion specificationVersion = null;
        private final Map<String, Keyword> keywords = new HashMap();
        private final Map<String, Format> formats = new HashMap();
        private final Map<String, Boolean> vocabularies = new HashMap();
        private FormatKeywordFactory formatKeywordFactory = null;
        private VocabularyRegistry vocabularyRegistry = null;
        private KeywordFactory unknownKeywordFactory = null;

        public Builder(String str) {
            this.id = str;
        }

        private Map<String, Keyword> createKeywordsMap(Map<String, Keyword> map, Map<String, Format> map2) {
            HashMap map3 = new HashMap();
            boolean z10 = false;
            for (Map.Entry<String, Keyword> entry : map.entrySet()) {
                String key = entry.getKey();
                Keyword value = entry.getValue();
                KeywordType keywordType = KeywordType.FORMAT;
                if (!keywordType.getValue().equals(key)) {
                    map3.put(value.getValue(), value);
                } else {
                    if (!(value instanceof FormatKeyword) && !keywordType.equals(value)) {
                        throw new IllegalArgumentException("Overriding the keyword 'format' is not supported. Use the formatKeywordFactory and extend the FormatKeyword.");
                    }
                    z10 = true;
                }
            }
            if (z10) {
                FormatKeywordFactory formatKeywordFactory = this.formatKeywordFactory;
                FormatKeyword formatKeywordNewInstance = formatKeywordFactory != null ? formatKeywordFactory.newInstance(map2) : new FormatKeyword(map2);
                map3.put(formatKeywordNewInstance.getValue(), formatKeywordNewInstance);
            }
            return map3;
        }

        public Dialect build() {
            Map<String, Keyword> map = this.keywords;
            SpecificationVersion specificationVersion = this.specificationVersion;
            if (specificationVersion != null && specificationVersion.getOrder() >= SpecificationVersion.DRAFT_2019_09.getOrder()) {
                map = new HashMap<>(this.keywords);
                for (Map.Entry<String, Boolean> entry : this.vocabularies.entrySet()) {
                    String key = entry.getKey();
                    VocabularyRegistry vocabularyRegistry = this.vocabularyRegistry;
                    Vocabulary vocabulary = vocabularyRegistry != null ? vocabularyRegistry.getVocabulary(key) : null;
                    if (vocabulary == null) {
                        vocabulary = Vocabularies.getVocabulary(key);
                    }
                    if (vocabulary != null) {
                        for (Keyword keyword : vocabulary.getKeywords()) {
                            map.putIfAbsent(keyword.getValue(), keyword);
                        }
                    } else if (Boolean.TRUE.equals(entry.getValue())) {
                        throw new InvalidSchemaException(Error.builder().message("Meta-schema ''{0}'' has unknown required vocabulary ''{1}''").arguments(this.id, key).build());
                    }
                }
            }
            return new Dialect(this.id, this.idKeyword, createKeywordsMap(map, this.formats), this.vocabularies, this.specificationVersion, this);
        }

        public Builder format(Format format) {
            this.formats.put(format.getName(), format);
            return this;
        }

        public Builder formatKeywordFactory(FormatKeywordFactory formatKeywordFactory) {
            this.formatKeywordFactory = formatKeywordFactory;
            return this;
        }

        public Builder formats(Consumer<Map<String, Format>> consumer) {
            consumer.accept(this.formats);
            return this;
        }

        public Builder idKeyword(String str) {
            this.idKeyword = str;
            return this;
        }

        public Builder keyword(Keyword keyword) {
            this.keywords.put(keyword.getValue(), keyword);
            return this;
        }

        public Builder keywords(Consumer<Map<String, Keyword>> consumer) {
            consumer.accept(this.keywords);
            return this;
        }

        public Builder specificationVersion(SpecificationVersion specificationVersion) {
            this.specificationVersion = specificationVersion;
            return this;
        }

        public Builder unknownKeywordFactory(KeywordFactory keywordFactory) {
            this.unknownKeywordFactory = keywordFactory;
            return this;
        }

        public Builder vocabularies(Map<String, Boolean> map) {
            this.vocabularies.putAll(map);
            return this;
        }

        public Builder vocabulary(String str) {
            return vocabulary(str, true);
        }

        public Builder vocabularyRegistry(VocabularyRegistry vocabularyRegistry) {
            this.vocabularyRegistry = vocabularyRegistry;
            return this;
        }

        public Builder formats(Collection<? extends Format> collection) {
            Iterator<? extends Format> it = collection.iterator();
            while (it.hasNext()) {
                format(it.next());
            }
            return this;
        }

        public Builder keywords(Collection<? extends Keyword> collection) {
            for (Keyword keyword : collection) {
                this.keywords.put(keyword.getValue(), keyword);
            }
            return this;
        }

        public Builder vocabularies(Consumer<Map<String, Boolean>> consumer) {
            consumer.accept(this.vocabularies);
            return this;
        }

        public Builder vocabulary(String str, boolean z10) {
            this.vocabularies.put(str, Boolean.valueOf(z10));
            return this;
        }
    }

    public interface FormatKeywordFactory {
        FormatKeyword newInstance(Map<String, Format> map);
    }

    public Dialect(String str, String str2, Map<String, Keyword> map, Map<String, Boolean> map2, SpecificationVersion specificationVersion, Builder builder) {
        if (Strings.isBlank(str)) {
            throw new IllegalArgumentException("dialect id must not be null or blank");
        }
        if (Strings.isBlank(str2)) {
            throw new IllegalArgumentException("idKeyword must not be null or blank");
        }
        if (map == null) {
            throw new IllegalArgumentException("keywords must not be null ");
        }
        this.id = str;
        this.idKeyword = str2;
        this.keywords = map;
        this.specificationVersion = specificationVersion;
        this.vocabularies = map2;
        this.builder = builder;
    }

    public static Builder builder(String str) {
        return new Builder(str);
    }

    private static String readText(JsonNode jsonNode, String str) {
        JsonNode jsonNode2 = jsonNode.get(str);
        if (jsonNode2 == null) {
            return null;
        }
        return jsonNode2.textValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return Objects.equals(this.id, ((Dialect) obj).id);
        }
        return false;
    }

    public String getId() {
        return this.id;
    }

    public String getIdKeyword() {
        return this.idKeyword;
    }

    public Map<String, Keyword> getKeywords() {
        return this.keywords;
    }

    public SpecificationVersion getSpecificationVersion() {
        return this.specificationVersion;
    }

    public Map<String, Boolean> getVocabularies() {
        return this.vocabularies;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public KeywordValidator newValidator(SchemaContext schemaContext, SchemaLocation schemaLocation, String str, JsonNode jsonNode, Schema schema) {
        try {
            Keyword keyword = this.keywords.get(str);
            if (keyword == null) {
                if (str.equals(schemaContext.getSchemaRegistryConfig().getErrorMessageKeyword())) {
                    return null;
                }
                if (schemaContext.isNullableKeywordEnabled() && "nullable".equals(str)) {
                    return null;
                }
                KeywordType keywordType = KeywordType.DISCRIMINATOR;
                if (keywordType.getValue().equals(str) && schemaContext.isDiscriminatorKeywordEnabled()) {
                    return keywordType.newValidator(schemaLocation, jsonNode, schema, schemaContext);
                }
                keyword = this.builder.unknownKeywordFactory != null ? this.builder.unknownKeywordFactory.getKeyword(str, schemaContext) : UnknownKeywordFactory.getInstance().getKeyword(str, schemaContext);
                if (keyword == null) {
                    return null;
                }
            }
            return keyword.newValidator(schemaLocation, jsonNode, schema, schemaContext);
        } catch (SchemaException e10) {
            throw e10;
        } catch (InvocationTargetException e11) {
            if (e11.getTargetException() instanceof SchemaException) {
                logger.error("Error:", e11);
                throw ((SchemaException) e11.getTargetException());
            }
            logger.j("Could not load validator {}", str);
            throw new SchemaException(e11.getTargetException());
        } catch (Exception e12) {
            logger.j("Could not load validator {}", str);
            throw new SchemaException(e12);
        }
    }

    public String readAnchor(JsonNode jsonNode) {
        if (this.keywords.containsKey("$anchor")) {
            return readText(jsonNode, "$anchor");
        }
        return null;
    }

    public String readDynamicAnchor(JsonNode jsonNode) {
        if (this.keywords.containsKey("$dynamicAnchor")) {
            return readText(jsonNode, "$dynamicAnchor");
        }
        return null;
    }

    public String readId(JsonNode jsonNode) {
        return readText(jsonNode, this.idKeyword);
    }

    public String toString() {
        return this.id;
    }

    public static Builder builder(String str, Dialect dialect) {
        Builder builder = builder(dialect);
        builder.id = str;
        return builder;
    }

    public static Builder builder(Dialect dialect) {
        return builder(dialect.getId()).idKeyword(dialect.idKeyword).keywords(dialect.builder.keywords.values()).formats(dialect.builder.formats.values()).specificationVersion(dialect.getSpecificationVersion()).vocabularies(new HashMap(dialect.getVocabularies())).vocabularyRegistry(dialect.builder.vocabularyRegistry).formatKeywordFactory(dialect.builder.formatKeywordFactory).unknownKeywordFactory(dialect.builder.unknownKeywordFactory);
    }
}
