package androidx.appsearch.platformstorage.util;

import B7.a;
import androidx.annotation.RestrictTo;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.exceptions.IllegalSchemaException;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class SchemaValidationUtil {
    private SchemaValidationUtil() {
    }

    public static void checkSchemasAreValidOrThrow(Set<AppSearchSchema> set, int i) throws IllegalSchemaException {
        ArrayMap arrayMap = new ArrayMap();
        for (AppSearchSchema appSearchSchema : set) {
            arrayMap.put(appSearchSchema.getSchemaType(), appSearchSchema);
        }
        ArrayMap arrayMap2 = new ArrayMap();
        Iterator<AppSearchSchema> it = set.iterator();
        while (it.hasNext()) {
            if (getNumSectionsInSchemaOrThrow(it.next(), arrayMap, arrayMap2, new ArraySet()) > i) {
                throw new IllegalSchemaException(a.h(i, "Too many properties to be indexed, max number of properties allowed: "));
            }
        }
    }

    private static int getNumSectionsInSchemaOrThrow(AppSearchSchema appSearchSchema, Map<String, AppSearchSchema> map, Map<String, Integer> map2, Set<String> set) throws IllegalSchemaException {
        String schemaType = appSearchSchema.getSchemaType();
        if (set.contains(schemaType)) {
            throw new IllegalSchemaException(a.m("Invalid cycle detected in schema type configs. '", schemaType, "' references itself."));
        }
        if (map2.containsKey(schemaType)) {
            return map2.get(schemaType).intValue();
        }
        set.add(schemaType);
        int size = 0;
        for (AppSearchSchema.PropertyConfig propertyConfig : appSearchSchema.getProperties()) {
            if (propertyConfig.getDataType() == 6) {
                AppSearchSchema.DocumentPropertyConfig documentPropertyConfig = (AppSearchSchema.DocumentPropertyConfig) propertyConfig;
                String schemaType2 = documentPropertyConfig.getSchemaType();
                if (!map.containsKey(schemaType2)) {
                    throw new IllegalSchemaException(a.k("Undefined schema type: ", schemaType2));
                }
                size = (!documentPropertyConfig.shouldIndexNestedProperties() ? documentPropertyConfig.getIndexableNestedProperties().size() : getNumSectionsInSchemaOrThrow(map.get(schemaType2), map, map2, set)) + size;
            } else {
                size += isPropertyIndexable(propertyConfig) ? 1 : 0;
            }
        }
        set.remove(schemaType);
        map2.put(schemaType, Integer.valueOf(size));
        return size;
    }

    private static boolean isPropertyIndexable(AppSearchSchema.PropertyConfig propertyConfig) {
        int dataType = propertyConfig.getDataType();
        if (dataType == 1) {
            return ((AppSearchSchema.StringPropertyConfig) propertyConfig).getIndexingType() != 0;
        }
        if (dataType == 2) {
            return ((AppSearchSchema.LongPropertyConfig) propertyConfig).getIndexingType() != 0;
        }
        if (dataType != 6) {
            return false;
        }
        AppSearchSchema.DocumentPropertyConfig documentPropertyConfig = (AppSearchSchema.DocumentPropertyConfig) propertyConfig;
        return documentPropertyConfig.shouldIndexNestedProperties() || !documentPropertyConfig.getIndexableNestedProperties().isEmpty();
    }
}
