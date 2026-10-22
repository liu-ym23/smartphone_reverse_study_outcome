package androidx.appsearch.platformstorage.converter;

import android.annotation.SuppressLint;
import android.app.appsearch.AppSearchSchema;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.platformstorage.util.AppSearchVersionUtil;
import androidx.core.util.Preconditions;
import java.util.Collection;
import java.util.List;

@RequiresApi(31)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class SchemaToPlatformConverter {

    @RequiresApi(36)
    @SuppressLint({"NewApi"})
    public static class ApiHelperForB {
        private ApiHelperForB() {
        }

        @DoNotInline
        @SuppressLint({"WrongConstant"})
        public static AppSearchSchema.EmbeddingPropertyConfig createJetpackEmbeddingPropertyConfig(AppSearchSchema.EmbeddingPropertyConfig embeddingPropertyConfig) {
            return new AppSearchSchema.EmbeddingPropertyConfig.Builder(embeddingPropertyConfig.getName()).setCardinality(embeddingPropertyConfig.getCardinality()).setIndexingType(embeddingPropertyConfig.getIndexingType()).build();
        }

        @DoNotInline
        @SuppressLint({"WrongConstant"})
        public static AppSearchSchema.PropertyConfig createPlatformEmbeddingPropertyConfig(AppSearchSchema.EmbeddingPropertyConfig embeddingPropertyConfig) {
            a.A();
            return a.f(embeddingPropertyConfig.getName()).setCardinality(embeddingPropertyConfig.getCardinality()).setIndexingType(embeddingPropertyConfig.getIndexingType()).build();
        }
    }

    @RequiresApi(34)
    public static class ApiHelperForU {
        private ApiHelperForU() {
        }

        @DoNotInline
        @SuppressLint({"WrongConstant"})
        public static int getIndexingType(AppSearchSchema.LongPropertyConfig longPropertyConfig) {
            return longPropertyConfig.getIndexingType();
        }

        @DoNotInline
        @SuppressLint({"WrongConstant"})
        public static int getJoinableValueType(AppSearchSchema.StringPropertyConfig stringPropertyConfig) {
            return stringPropertyConfig.getJoinableValueType();
        }

        @DoNotInline
        public static void setIndexingType(AppSearchSchema.LongPropertyConfig.Builder builder, int i) {
            builder.setIndexingType(i);
        }

        @DoNotInline
        public static void setJoinableValueType(AppSearchSchema.StringPropertyConfig.Builder builder, int i) {
            builder.setJoinableValueType(i);
        }
    }

    @RequiresApi(35)
    public static class ApiHelperForV {
        private ApiHelperForV() {
        }

        @DoNotInline
        public static void addIndexableNestedProperties(AppSearchSchema.DocumentPropertyConfig.Builder builder, Collection<String> collection) {
            builder.addIndexableNestedProperties(collection);
        }

        @DoNotInline
        @SuppressLint({"NewApi"})
        public static void addParentType(AppSearchSchema.Builder builder, String str) {
            builder.addParentType(str);
        }

        @DoNotInline
        public static List<String> getIndexableNestedProperties(AppSearchSchema.DocumentPropertyConfig documentPropertyConfig) {
            return documentPropertyConfig.getIndexableNestedProperties();
        }

        @DoNotInline
        public static List<String> getParentTypes(android.app.appsearch.AppSearchSchema appSearchSchema) {
            return appSearchSchema.getParentTypes();
        }
    }

    private SchemaToPlatformConverter() {
    }

    @SuppressLint({"WrongConstant", "NewApi"})
    private static AppSearchSchema.PropertyConfig toJetpackProperty(AppSearchSchema.PropertyConfig propertyConfig) {
        Preconditions.checkNotNull(propertyConfig);
        if (propertyConfig instanceof AppSearchSchema.StringPropertyConfig) {
            AppSearchSchema.StringPropertyConfig stringPropertyConfig = (AppSearchSchema.StringPropertyConfig) propertyConfig;
            AppSearchSchema.StringPropertyConfig.Builder tokenizerType = new AppSearchSchema.StringPropertyConfig.Builder(stringPropertyConfig.getName()).setCardinality(stringPropertyConfig.getCardinality()).setIndexingType(stringPropertyConfig.getIndexingType()).setTokenizerType(stringPropertyConfig.getTokenizerType());
            if (Build.VERSION.SDK_INT >= 34) {
                tokenizerType.setJoinableValueType(ApiHelperForU.getJoinableValueType(stringPropertyConfig));
            }
            return tokenizerType.build();
        }
        if (propertyConfig instanceof AppSearchSchema.LongPropertyConfig) {
            AppSearchSchema.LongPropertyConfig longPropertyConfig = (AppSearchSchema.LongPropertyConfig) propertyConfig;
            AppSearchSchema.LongPropertyConfig.Builder cardinality = new AppSearchSchema.LongPropertyConfig.Builder(longPropertyConfig.getName()).setCardinality(longPropertyConfig.getCardinality());
            if (Build.VERSION.SDK_INT >= 34) {
                cardinality.setIndexingType(ApiHelperForU.getIndexingType(longPropertyConfig));
            }
            return cardinality.build();
        }
        if (propertyConfig instanceof AppSearchSchema.DoublePropertyConfig) {
            return new AppSearchSchema.DoublePropertyConfig.Builder(propertyConfig.getName()).setCardinality(propertyConfig.getCardinality()).build();
        }
        if (propertyConfig instanceof AppSearchSchema.BooleanPropertyConfig) {
            return new AppSearchSchema.BooleanPropertyConfig.Builder(propertyConfig.getName()).setCardinality(propertyConfig.getCardinality()).build();
        }
        if (propertyConfig instanceof AppSearchSchema.BytesPropertyConfig) {
            return new AppSearchSchema.BytesPropertyConfig.Builder(propertyConfig.getName()).setCardinality(propertyConfig.getCardinality()).build();
        }
        if (propertyConfig instanceof AppSearchSchema.DocumentPropertyConfig) {
            AppSearchSchema.DocumentPropertyConfig documentPropertyConfig = (AppSearchSchema.DocumentPropertyConfig) propertyConfig;
            AppSearchSchema.DocumentPropertyConfig.Builder shouldIndexNestedProperties = new AppSearchSchema.DocumentPropertyConfig.Builder(documentPropertyConfig.getName(), documentPropertyConfig.getSchemaType()).setCardinality(documentPropertyConfig.getCardinality()).setShouldIndexNestedProperties(documentPropertyConfig.shouldIndexNestedProperties());
            if (Build.VERSION.SDK_INT >= 35) {
                shouldIndexNestedProperties.addIndexableNestedProperties(ApiHelperForV.getIndexableNestedProperties(documentPropertyConfig));
            }
            return shouldIndexNestedProperties.build();
        }
        if (AppSearchVersionUtil.isAtLeastB() && a.w(propertyConfig)) {
            return ApiHelperForB.createJetpackEmbeddingPropertyConfig(a.h(propertyConfig));
        }
        throw new IllegalArgumentException("Invalid property type " + propertyConfig.getClass() + ": " + propertyConfig);
    }

    public static androidx.appsearch.app.AppSearchSchema toJetpackSchema(android.app.appsearch.AppSearchSchema appSearchSchema) {
        Preconditions.checkNotNull(appSearchSchema);
        AppSearchSchema.Builder builder = new AppSearchSchema.Builder(appSearchSchema.getSchemaType());
        List<AppSearchSchema.PropertyConfig> properties = appSearchSchema.getProperties();
        if (Build.VERSION.SDK_INT >= 35) {
            List<String> parentTypes = ApiHelperForV.getParentTypes(appSearchSchema);
            for (int i = 0; i < parentTypes.size(); i++) {
                builder.addParentType(parentTypes.get(i));
            }
        }
        for (int i6 = 0; i6 < properties.size(); i6++) {
            builder.addProperty(toJetpackProperty(properties.get(i6)));
        }
        return builder.build();
    }

    @OptIn(markerClass = {ExperimentalAppSearchApi.class})
    @SuppressLint({"WrongConstant"})
    private static AppSearchSchema.PropertyConfig toPlatformProperty(AppSearchSchema.PropertyConfig propertyConfig) {
        Preconditions.checkNotNull(propertyConfig);
        if (!propertyConfig.getDescription().isEmpty()) {
            throw new UnsupportedOperationException("SCHEMA_SET_DESCRIPTION is not available on this AppSearch implementation.");
        }
        if (propertyConfig instanceof AppSearchSchema.StringPropertyConfig) {
            AppSearchSchema.StringPropertyConfig stringPropertyConfig = (AppSearchSchema.StringPropertyConfig) propertyConfig;
            AppSearchSchema.StringPropertyConfig.Builder tokenizerType = new AppSearchSchema.StringPropertyConfig.Builder(stringPropertyConfig.getName()).setCardinality(stringPropertyConfig.getCardinality()).setIndexingType(stringPropertyConfig.getIndexingType()).setTokenizerType(stringPropertyConfig.getTokenizerType());
            int i = Build.VERSION.SDK_INT;
            if (i == 33) {
                Preconditions.checkArgumentInRange(stringPropertyConfig.getTokenizerType(), 0, 1, "tokenizerType");
            }
            if (stringPropertyConfig.getJoinableValueType() == 1) {
                if (i < 34) {
                    throw new UnsupportedOperationException("StringPropertyConfig.JOINABLE_VALUE_TYPE_QUALIFIED_ID is not supported on this AppSearch implementation.");
                }
                ApiHelperForU.setJoinableValueType(tokenizerType, stringPropertyConfig.getJoinableValueType());
            }
            if (stringPropertyConfig.getDeletePropagationType() == 0) {
                return tokenizerType.build();
            }
            throw new UnsupportedOperationException("StringPropertyConfig.DELETE_PROPAGATION_TYPE_PROPAGATE_FROM is not supported on this AppSearch implementation.");
        }
        if (propertyConfig instanceof AppSearchSchema.LongPropertyConfig) {
            AppSearchSchema.LongPropertyConfig longPropertyConfig = (AppSearchSchema.LongPropertyConfig) propertyConfig;
            AppSearchSchema.LongPropertyConfig.Builder cardinality = new AppSearchSchema.LongPropertyConfig.Builder(propertyConfig.getName()).setCardinality(propertyConfig.getCardinality());
            if (longPropertyConfig.getIndexingType() == 1) {
                if (Build.VERSION.SDK_INT < 34) {
                    throw new UnsupportedOperationException("LongProperty.INDEXING_TYPE_RANGE is not supported on this AppSearch implementation.");
                }
                ApiHelperForU.setIndexingType(cardinality, longPropertyConfig.getIndexingType());
            }
            if (longPropertyConfig.isScoringEnabled()) {
                throw new UnsupportedOperationException("SCHEMA_SCORABLE_PROPERTY_CONFIG is not available on this AppSearch implementation.");
            }
            return cardinality.build();
        }
        if (propertyConfig instanceof AppSearchSchema.DoublePropertyConfig) {
            if (((AppSearchSchema.DoublePropertyConfig) propertyConfig).isScoringEnabled()) {
                throw new UnsupportedOperationException("SCHEMA_SCORABLE_PROPERTY_CONFIG is not available on this AppSearch implementation.");
            }
            return new AppSearchSchema.DoublePropertyConfig.Builder(propertyConfig.getName()).setCardinality(propertyConfig.getCardinality()).build();
        }
        if (propertyConfig instanceof AppSearchSchema.BooleanPropertyConfig) {
            if (((AppSearchSchema.BooleanPropertyConfig) propertyConfig).isScoringEnabled()) {
                throw new UnsupportedOperationException("SCHEMA_SCORABLE_PROPERTY_CONFIG is not available on this AppSearch implementation.");
            }
            return new AppSearchSchema.BooleanPropertyConfig.Builder(propertyConfig.getName()).setCardinality(propertyConfig.getCardinality()).build();
        }
        if (propertyConfig instanceof AppSearchSchema.BytesPropertyConfig) {
            return new AppSearchSchema.BytesPropertyConfig.Builder(propertyConfig.getName()).setCardinality(propertyConfig.getCardinality()).build();
        }
        if (propertyConfig instanceof AppSearchSchema.DocumentPropertyConfig) {
            AppSearchSchema.DocumentPropertyConfig documentPropertyConfig = (AppSearchSchema.DocumentPropertyConfig) propertyConfig;
            AppSearchSchema.DocumentPropertyConfig.Builder shouldIndexNestedProperties = new AppSearchSchema.DocumentPropertyConfig.Builder(documentPropertyConfig.getName(), documentPropertyConfig.getSchemaType()).setCardinality(documentPropertyConfig.getCardinality()).setShouldIndexNestedProperties(documentPropertyConfig.shouldIndexNestedProperties());
            if (!documentPropertyConfig.getIndexableNestedProperties().isEmpty()) {
                if (Build.VERSION.SDK_INT < 35) {
                    throw new UnsupportedOperationException("DocumentPropertyConfig.addIndexableNestedProperties is not supported on this AppSearch implementation.");
                }
                ApiHelperForV.addIndexableNestedProperties(shouldIndexNestedProperties, documentPropertyConfig.getIndexableNestedProperties());
            }
            return shouldIndexNestedProperties.build();
        }
        if (!(propertyConfig instanceof AppSearchSchema.EmbeddingPropertyConfig)) {
            if (propertyConfig instanceof AppSearchSchema.BlobHandlePropertyConfig) {
                throw new UnsupportedOperationException("BLOB_STORAGE is not available on this AppSearch implementation.");
            }
            throw new IllegalArgumentException("Invalid dataType: " + propertyConfig.getDataType());
        }
        if (!AppSearchVersionUtil.isAtLeastB()) {
            throw new UnsupportedOperationException("SCHEMA_EMBEDDING_PROPERTY_CONFIG is not available on this AppSearch implementation.");
        }
        AppSearchSchema.EmbeddingPropertyConfig embeddingPropertyConfig = (AppSearchSchema.EmbeddingPropertyConfig) propertyConfig;
        if (embeddingPropertyConfig.getQuantizationType() == 0) {
            return ApiHelperForB.createPlatformEmbeddingPropertyConfig(embeddingPropertyConfig);
        }
        throw new UnsupportedOperationException("SCHEMA_EMBEDDING_QUANTIZATION is not available on this AppSearch implementation.");
    }

    @OptIn(markerClass = {ExperimentalAppSearchApi.class})
    public static android.app.appsearch.AppSearchSchema toPlatformSchema(androidx.appsearch.app.AppSearchSchema appSearchSchema) {
        Preconditions.checkNotNull(appSearchSchema);
        AppSearchSchema.Builder builder = new AppSearchSchema.Builder(appSearchSchema.getSchemaType());
        if (!appSearchSchema.getDescription().isEmpty()) {
            throw new UnsupportedOperationException("SCHEMA_SET_DESCRIPTION is not available on this AppSearch implementation.");
        }
        if (!appSearchSchema.getParentTypes().isEmpty()) {
            if (Build.VERSION.SDK_INT < 35) {
                throw new UnsupportedOperationException("SCHEMA_ADD_PARENT_TYPE is not available on this AppSearch implementation.");
            }
            List<String> parentTypes = appSearchSchema.getParentTypes();
            for (int i = 0; i < parentTypes.size(); i++) {
                ApiHelperForV.addParentType(builder, parentTypes.get(i));
            }
        }
        List<AppSearchSchema.PropertyConfig> properties = appSearchSchema.getProperties();
        for (int i6 = 0; i6 < properties.size(); i6++) {
            builder.addProperty(toPlatformProperty(properties.get(i6)));
        }
        return builder.build();
    }
}
