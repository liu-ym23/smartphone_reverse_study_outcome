package kotlinx.serialization.json.internal;

import a8.b;
import b5.a0;
import c5.l;
import c5.t;
import c5.z;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.lightmem.f;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.internal.JsonInternalDependenciesKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonIgnoreUnknownKeys;
import kotlinx.serialization.json.JsonNames;
import kotlinx.serialization.json.JsonNamingStrategy;
import kotlinx.serialization.json.JsonSchemaCacheKt;
import kotlinx.serialization.json.internal.DescriptorSchemaCache;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0082\u0080\u0004\u001a\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000bH\u0080\u0080\u0004\u001a)\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\b*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0080\u0080\u0004¢\u0006\u0002\u0010\u0013\u001a\u001e\u0010\u0014\u001a\u00020\u0003*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0004H\u0080\u0080\u0004\u001a\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0080\u0080\u0004\u001a\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u0012*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0080\u0080\u0004\u001a\u001e\u0010\u0019\u001a\u00020\u0004*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0003H\u0082\u0080\u0004\u001a\u0016\u0010\u001b\u001a\u00020\u001c*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000bH\u0082\u0080\u0004\u001a\u001e\u0010\u001d\u001a\u00020\u0004*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0003H\u0080\u0080\u0004\u001a(\u0010\u001e\u001a\u00020\u0004*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u0003H\u0080\u0080\u0004\u001ad\u0010 \u001a\u00020\u001c*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00042!\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b#\u0012\b\b\u001a\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u001c0\"2\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030&2\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020(0&H\u0080\u0088\u0004ø\u0001\u0000\u001a\u0016\u0010)\u001a\u00020\u001c*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0080\u0080\u0004\"'\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001X\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"!\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u0001X\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006*"}, d2 = {"JsonDeserializationNamesKey", "Lkotlinx/serialization/json/internal/DescriptorSchemaCache$Key;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getJsonDeserializationNamesKey", "()Lkotlinx/serialization/json/internal/DescriptorSchemaCache$Key;", "JsonSerializationNamesKey", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getJsonSerializationNamesKey", "buildDeserializationNamesMap", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "json", "Lkotlinx/serialization/json/Json;", "deserializationNamesMap", "descriptor", "serializationNamesIndices", "strategy", "Lkotlinx/serialization/json/JsonNamingStrategy;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonNamingStrategy;)[Ljava/lang/String;", "getJsonElementName", "index", "getJsonEncodedNames", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "namingStrategy", "getJsonNameIndexSlowPath", "name", "decodeCaseInsensitive", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getJsonNameIndex", "getJsonNameIndexOrThrow", "suffix", "tryCoerceValue", "peekNull", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "consume", "peekString", "Lkotlin/Function0;", "onEnumCoercing", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "ignoreUnknownKeys", "kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class JsonNamesMapKt {
    private static final DescriptorSchemaCache.Key<Map<String, Integer>> JsonDeserializationNamesKey = new DescriptorSchemaCache.Key<>();
    private static final DescriptorSchemaCache.Key<String[]> JsonSerializationNamesKey = new DescriptorSchemaCache.Key<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map<String, Integer> buildDeserializationNamesMap(SerialDescriptor serialDescriptor, Json json) {
        String[] strArrNames;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        boolean zDecodeCaseInsensitive = decodeCaseInsensitive(json, serialDescriptor);
        JsonNamingStrategy jsonNamingStrategyNamingStrategy = namingStrategy(serialDescriptor, json);
        int elementsCount = serialDescriptor.getElementsCount();
        for (int i8 = 0; i8 < elementsCount; i8++) {
            List<Annotation> elementAnnotations = serialDescriptor.getElementAnnotations(i8);
            ArrayList arrayList = new ArrayList();
            for (Object obj : elementAnnotations) {
                if (obj instanceof JsonNames) {
                    arrayList.add(obj);
                }
            }
            String strSerialNameForJson = null;
            JsonNames jsonNames = (JsonNames) (arrayList.size() == 1 ? arrayList.get(0) : null);
            if (jsonNames != null && (strArrNames = jsonNames.names()) != null) {
                for (String lowerCase : strArrNames) {
                    if (zDecodeCaseInsensitive) {
                        lowerCase = lowerCase.toLowerCase(Locale.ROOT);
                        p.d(lowerCase, "toLowerCase(...)");
                    }
                    buildDeserializationNamesMap$putOrThrow(linkedHashMap, serialDescriptor, lowerCase, i8);
                }
            }
            if (zDecodeCaseInsensitive) {
                strSerialNameForJson = serialDescriptor.getElementName(i8).toLowerCase(Locale.ROOT);
                p.d(strSerialNameForJson, "toLowerCase(...)");
            } else if (jsonNamingStrategyNamingStrategy != null) {
                strSerialNameForJson = jsonNamingStrategyNamingStrategy.serialNameForJson(serialDescriptor, i8, serialDescriptor.getElementName(i8));
            }
            if (strSerialNameForJson != null) {
                buildDeserializationNamesMap$putOrThrow(linkedHashMap, serialDescriptor, strSerialNameForJson, i8);
            }
        }
        return linkedHashMap.isEmpty() ? t.f1093a : linkedHashMap;
    }

    private static final void buildDeserializationNamesMap$putOrThrow(Map<String, Integer> map, SerialDescriptor serialDescriptor, String str, int i8) {
        String str2 = p.a(serialDescriptor.getKind(), SerialKind.ENUM.INSTANCE) ? "enum value" : "property";
        if (!map.containsKey(str)) {
            map.put(str, Integer.valueOf(i8));
            return;
        }
        throw new JsonDecodingException("The suggested name '" + str + "' for " + str2 + ' ' + serialDescriptor.getElementName(i8) + " is already one of the names for " + str2 + ' ' + serialDescriptor.getElementName(((Number) z.S(map, str)).intValue()) + " in " + serialDescriptor);
    }

    private static final boolean decodeCaseInsensitive(Json json, SerialDescriptor serialDescriptor) {
        return json.getConfiguration().getDecodeEnumsCaseInsensitive() && p.a(serialDescriptor.getKind(), SerialKind.ENUM.INSTANCE);
    }

    public static final Map<String, Integer> deserializationNamesMap(Json json, SerialDescriptor descriptor) {
        p.e(json, "<this>");
        p.e(descriptor, "descriptor");
        return (Map) JsonSchemaCacheKt.getSchemaCache(json).getOrPut(descriptor, JsonDeserializationNamesKey, new f(descriptor, 7, json));
    }

    public static final DescriptorSchemaCache.Key<Map<String, Integer>> getJsonDeserializationNamesKey() {
        return JsonDeserializationNamesKey;
    }

    public static final String getJsonElementName(SerialDescriptor serialDescriptor, Json json, int i8) {
        p.e(serialDescriptor, "<this>");
        p.e(json, "json");
        JsonNamingStrategy jsonNamingStrategyNamingStrategy = namingStrategy(serialDescriptor, json);
        return jsonNamingStrategyNamingStrategy == null ? serialDescriptor.getElementName(i8) : serializationNamesIndices(serialDescriptor, json, jsonNamingStrategyNamingStrategy)[i8];
    }

    public static final Set<String> getJsonEncodedNames(SerialDescriptor serialDescriptor, Json json) {
        p.e(serialDescriptor, "<this>");
        p.e(json, "json");
        JsonNamingStrategy jsonNamingStrategyNamingStrategy = namingStrategy(serialDescriptor, json);
        return jsonNamingStrategyNamingStrategy == null ? JsonInternalDependenciesKt.jsonCachedSerialNames(serialDescriptor) : l.k0(serializationNamesIndices(serialDescriptor, json, jsonNamingStrategyNamingStrategy));
    }

    public static final int getJsonNameIndex(SerialDescriptor serialDescriptor, Json json, String name) {
        p.e(serialDescriptor, "<this>");
        p.e(json, "json");
        p.e(name, "name");
        if (decodeCaseInsensitive(json, serialDescriptor)) {
            String lowerCase = name.toLowerCase(Locale.ROOT);
            p.d(lowerCase, "toLowerCase(...)");
            return getJsonNameIndexSlowPath(serialDescriptor, json, lowerCase);
        }
        if (namingStrategy(serialDescriptor, json) != null) {
            return getJsonNameIndexSlowPath(serialDescriptor, json, name);
        }
        int elementIndex = serialDescriptor.getElementIndex(name);
        return (elementIndex == -3 && json.getConfiguration().getUseAlternativeNames()) ? getJsonNameIndexSlowPath(serialDescriptor, json, name) : elementIndex;
    }

    public static final int getJsonNameIndexOrThrow(SerialDescriptor serialDescriptor, Json json, String name, String suffix) {
        p.e(serialDescriptor, "<this>");
        p.e(json, "json");
        p.e(name, "name");
        p.e(suffix, "suffix");
        int jsonNameIndex = getJsonNameIndex(serialDescriptor, json, name);
        if (jsonNameIndex != -3) {
            return jsonNameIndex;
        }
        throw new SerializationException(serialDescriptor.getSerialName() + " does not contain element with name '" + name + '\'' + suffix);
    }

    public static /* synthetic */ int getJsonNameIndexOrThrow$default(SerialDescriptor serialDescriptor, Json json, String str, String str2, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            str2 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        return getJsonNameIndexOrThrow(serialDescriptor, json, str, str2);
    }

    private static final int getJsonNameIndexSlowPath(SerialDescriptor serialDescriptor, Json json, String str) {
        Integer num = deserializationNamesMap(json, serialDescriptor).get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    public static final DescriptorSchemaCache.Key<String[]> getJsonSerializationNamesKey() {
        return JsonSerializationNamesKey;
    }

    public static final boolean ignoreUnknownKeys(SerialDescriptor serialDescriptor, Json json) {
        p.e(serialDescriptor, "<this>");
        p.e(json, "json");
        if (json.getConfiguration().getIgnoreUnknownKeys()) {
            return true;
        }
        List<Annotation> annotations = serialDescriptor.getAnnotations();
        if (annotations != null && annotations.isEmpty()) {
            return false;
        }
        Iterator<T> it = annotations.iterator();
        while (it.hasNext()) {
            if (((Annotation) it.next()) instanceof JsonIgnoreUnknownKeys) {
                return true;
            }
        }
        return false;
    }

    public static final JsonNamingStrategy namingStrategy(SerialDescriptor serialDescriptor, Json json) {
        p.e(serialDescriptor, "<this>");
        p.e(json, "json");
        if (p.a(serialDescriptor.getKind(), StructureKind.CLASS.INSTANCE)) {
            return json.getConfiguration().getNamingStrategy();
        }
        return null;
    }

    public static final String[] serializationNamesIndices(SerialDescriptor serialDescriptor, Json json, JsonNamingStrategy strategy) {
        p.e(serialDescriptor, "<this>");
        p.e(json, "json");
        p.e(strategy, "strategy");
        return (String[]) JsonSchemaCacheKt.getSchemaCache(json).getOrPut(serialDescriptor, JsonSerializationNamesKey, new f(serialDescriptor, 8, strategy));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String[] serializationNamesIndices$lambda$0(SerialDescriptor serialDescriptor, JsonNamingStrategy jsonNamingStrategy) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int elementsCount = serialDescriptor.getElementsCount();
        String[] strArr = new String[elementsCount];
        for (int i8 = 0; i8 < elementsCount; i8++) {
            String elementName = serialDescriptor.getElementName(i8);
            String strSerialNameForJson = jsonNamingStrategy.serialNameForJson(serialDescriptor, i8, elementName);
            if (!linkedHashSet.add(strSerialNameForJson)) {
                StringBuilder sbV = b.v("The transformed name '", strSerialNameForJson, "' for property ", elementName, " already exists in ");
                sbV.append(serialDescriptor);
                throw new JsonEncodingException(sbV.toString());
            }
            strArr[i8] = strSerialNameForJson;
        }
        return strArr;
    }

    public static final boolean tryCoerceValue(Json json, SerialDescriptor descriptor, int i8, p5.l peekNull, p5.a peekString, p5.a onEnumCoercing) {
        String str;
        p.e(json, "<this>");
        p.e(descriptor, "descriptor");
        p.e(peekNull, "peekNull");
        p.e(peekString, "peekString");
        p.e(onEnumCoercing, "onEnumCoercing");
        boolean zIsElementOptional = descriptor.isElementOptional(i8);
        SerialDescriptor elementDescriptor = descriptor.getElementDescriptor(i8);
        if (zIsElementOptional && !elementDescriptor.isNullable() && ((Boolean) peekNull.invoke(Boolean.TRUE)).booleanValue()) {
            return true;
        }
        if (!p.a(elementDescriptor.getKind(), SerialKind.ENUM.INSTANCE) || ((elementDescriptor.isNullable() && ((Boolean) peekNull.invoke(Boolean.FALSE)).booleanValue()) || (str = (String) peekString.invoke()) == null)) {
            return false;
        }
        int jsonNameIndex = getJsonNameIndex(elementDescriptor, json, str);
        boolean z = !json.getConfiguration().getExplicitNulls() && elementDescriptor.isNullable();
        if (jsonNameIndex == -3 && (zIsElementOptional || z)) {
            onEnumCoercing.invoke();
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean tryCoerceValue$default(Json json, SerialDescriptor descriptor, int i8, p5.l peekNull, p5.a peekString, p5.a onEnumCoercing, int i9, Object obj) {
        String str;
        if ((i9 & 16) != 0) {
            onEnumCoercing = new p5.a() { // from class: kotlinx.serialization.json.internal.JsonNamesMapKt.tryCoerceValue.1
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m43invoke() {
                }

                @Override // p5.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m43invoke();
                    return a0.f883a;
                }
            };
        }
        p.e(json, "<this>");
        p.e(descriptor, "descriptor");
        p.e(peekNull, "peekNull");
        p.e(peekString, "peekString");
        p.e(onEnumCoercing, "onEnumCoercing");
        boolean zIsElementOptional = descriptor.isElementOptional(i8);
        SerialDescriptor elementDescriptor = descriptor.getElementDescriptor(i8);
        if (zIsElementOptional && !elementDescriptor.isNullable() && ((Boolean) peekNull.invoke(Boolean.TRUE)).booleanValue()) {
            return true;
        }
        if (!p.a(elementDescriptor.getKind(), SerialKind.ENUM.INSTANCE) || ((elementDescriptor.isNullable() && ((Boolean) peekNull.invoke(Boolean.FALSE)).booleanValue()) || (str = (String) peekString.invoke()) == null)) {
            return false;
        }
        int jsonNameIndex = getJsonNameIndex(elementDescriptor, json, str);
        boolean z = !json.getConfiguration().getExplicitNulls() && elementDescriptor.isNullable();
        if (jsonNameIndex == -3 && (zIsElementOptional || z)) {
            onEnumCoercing.invoke();
            return true;
        }
        return false;
    }
}
