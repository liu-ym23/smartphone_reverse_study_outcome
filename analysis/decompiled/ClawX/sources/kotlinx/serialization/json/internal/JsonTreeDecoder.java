package kotlinx.serialization.json.internal;

import a8.b;
import c5.u;
import c5.z;
import com.stepos.stepclaw.SecurePrefs;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.internal.JsonInternalDependenciesKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonNamingStrategy;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.json.JsonSchemaCacheKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0012\u0018\u00002\u00020\u0001B1\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\tH\u0096\u0080\u0004J\u001a\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u000fH\u0082\u0080\u0004J\n\u0010\u0016\u001a\u00020\u0011H\u0096\u0080\u0004J\u001a\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u000fH\u0094\u0080\u0004J\u0012\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0007H\u0094\u0080\u0004J\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0007H\u0086\u0080\u0004J\u0012\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\tH\u0096\u0080\u0004J\u0012\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0013\u001a\u00020\tH\u0096\u0080\u0004R\u0015\u0010\u0004\u001a\u00020\u0005X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u000e\u001a\u00020\u000fX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0010\u001a\u00020\u0011X\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeDecoder;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeDecoder;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonObject;", "polymorphicDiscriminator", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "polyDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "getValue", "()Lkotlinx/serialization/json/JsonObject;", "position", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "forceNull", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "decodeElementIndex", "descriptor", "setForceNull", "index", "decodeNotNullMark", "elementName", "currentElement", "Lkotlinx/serialization/json/JsonElement;", "tag", "currentElementOrNull", "beginStructure", "Lkotlinx/serialization/encoding/CompositeDecoder;", "endStructure", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
class JsonTreeDecoder extends AbstractJsonTreeDecoder {
    private boolean forceNull;
    private final SerialDescriptor polyDescriptor;
    private int position;
    private final JsonObject value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeDecoder(Json json, JsonObject value, String str, SerialDescriptor serialDescriptor) {
        super(json, value, str, null);
        p.e(json, "json");
        p.e(value, "value");
        this.value = value;
        this.polyDescriptor = serialDescriptor;
    }

    private final boolean setForceNull(SerialDescriptor descriptor, int index) {
        boolean z = (getJson().getConfiguration().getExplicitNulls() || descriptor.isElementOptional(index) || !descriptor.getElementDescriptor(index).isNullable()) ? false : true;
        this.forceNull = z;
        return z;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder, kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public CompositeDecoder beginStructure(SerialDescriptor descriptor) {
        p.e(descriptor, "descriptor");
        if (descriptor != this.polyDescriptor) {
            return super.beginStructure(descriptor);
        }
        Json json = getJson();
        JsonElement jsonElementCurrentObject = currentObject();
        String serialName = this.polyDescriptor.getSerialName();
        if (jsonElementCurrentObject instanceof JsonObject) {
            return new JsonTreeDecoder(json, (JsonObject) jsonElementCurrentObject, getPolymorphicDiscriminator(), this.polyDescriptor);
        }
        StringBuilder sb = new StringBuilder("Expected ");
        b.w(JsonObject.class, sb, ", but had ", jsonElementCurrentObject, " as the serialized body of ");
        sb.append(serialName);
        sb.append(" at element: ");
        sb.append(renderTagStack());
        throw JsonExceptionsKt.JsonDecodingException(-1, sb.toString(), jsonElementCurrentObject.toString());
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    public JsonElement currentElement(String tag) {
        p.e(tag, "tag");
        return (JsonElement) z.S(getValue(), tag);
    }

    public final JsonElement currentElementOrNull(String tag) {
        p.e(tag, "tag");
        return (JsonElement) getValue().get((Object) tag);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int decodeElementIndex(SerialDescriptor descriptor) {
        p.e(descriptor, "descriptor");
        while (this.position < descriptor.getElementsCount()) {
            int i8 = this.position;
            this.position = i8 + 1;
            String tag = getTag(descriptor, i8);
            int i9 = this.position - 1;
            this.forceNull = false;
            if (getValue().containsKey((Object) tag) || setForceNull(descriptor, i9)) {
                if (this.configuration.getCoerceInputValues()) {
                    Json json = getJson();
                    boolean zIsElementOptional = descriptor.isElementOptional(i9);
                    SerialDescriptor elementDescriptor = descriptor.getElementDescriptor(i9);
                    if (!zIsElementOptional || elementDescriptor.isNullable() || !(currentElementOrNull(tag) instanceof JsonNull)) {
                        if (p.a(elementDescriptor.getKind(), SerialKind.ENUM.INSTANCE)) {
                            if (elementDescriptor.isNullable() && (currentElementOrNull(tag) instanceof JsonNull)) {
                                return i9;
                            }
                            JsonElement jsonElementCurrentElementOrNull = currentElementOrNull(tag);
                            JsonPrimitive jsonPrimitive = jsonElementCurrentElementOrNull instanceof JsonPrimitive ? (JsonPrimitive) jsonElementCurrentElementOrNull : null;
                            String contentOrNull = jsonPrimitive != null ? JsonElementKt.getContentOrNull(jsonPrimitive) : null;
                            if (contentOrNull == null) {
                                return i9;
                            }
                            int jsonNameIndex = JsonNamesMapKt.getJsonNameIndex(elementDescriptor, json, contentOrNull);
                            boolean z = !json.getConfiguration().getExplicitNulls() && elementDescriptor.isNullable();
                            if (jsonNameIndex != -3 || ((!zIsElementOptional && !z) || setForceNull(descriptor, i9))) {
                            }
                        }
                    }
                }
                return i9;
            }
        }
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder, kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public boolean decodeNotNullMark() {
        return !this.forceNull && super.decodeNotNullMark();
    }

    @Override // kotlinx.serialization.internal.NamedValueDecoder
    public String elementName(SerialDescriptor descriptor, int index) {
        Object next;
        p.e(descriptor, "descriptor");
        JsonNamingStrategy jsonNamingStrategyNamingStrategy = JsonNamesMapKt.namingStrategy(descriptor, getJson());
        String elementName = descriptor.getElementName(index);
        if (jsonNamingStrategyNamingStrategy != null || (this.configuration.getUseAlternativeNames() && !getValue().keySet().contains(elementName))) {
            Map<String, Integer> mapDeserializationNamesMap = JsonNamesMapKt.deserializationNamesMap(getJson(), descriptor);
            Iterator<T> it = getValue().keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                Integer num = mapDeserializationNamesMap.get((String) next);
                if (num != null && num.intValue() == index) {
                    break;
                }
            }
            String str = (String) next;
            if (str != null) {
                return str;
            }
            String strSerialNameForJson = jsonNamingStrategyNamingStrategy != null ? jsonNamingStrategyNamingStrategy.serialNameForJson(descriptor, index, elementName) : null;
            if (strSerialNameForJson != null) {
                return strSerialNameForJson;
            }
        }
        return elementName;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder, kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public void endStructure(SerialDescriptor descriptor) {
        Set<String> setZ;
        p.e(descriptor, "descriptor");
        if (JsonNamesMapKt.ignoreUnknownKeys(descriptor, getJson()) || (descriptor.getKind() instanceof PolymorphicKind)) {
            return;
        }
        JsonNamingStrategy jsonNamingStrategyNamingStrategy = JsonNamesMapKt.namingStrategy(descriptor, getJson());
        if (jsonNamingStrategyNamingStrategy == null && !this.configuration.getUseAlternativeNames()) {
            setZ = JsonInternalDependenciesKt.jsonCachedSerialNames(descriptor);
        } else if (jsonNamingStrategyNamingStrategy != null) {
            setZ = JsonNamesMapKt.deserializationNamesMap(getJson(), descriptor).keySet();
        } else {
            Set<String> setJsonCachedSerialNames = JsonInternalDependenciesKt.jsonCachedSerialNames(descriptor);
            Map map = (Map) JsonSchemaCacheKt.getSchemaCache(getJson()).get(descriptor, JsonNamesMapKt.getJsonDeserializationNamesKey());
            Set setKeySet = map != null ? map.keySet() : null;
            if (setKeySet == null) {
                setKeySet = u.f1094a;
            }
            setZ = a.a.Z(setJsonCachedSerialNames, setKeySet);
        }
        for (String str : getValue().keySet()) {
            if (!setZ.contains(str) && !p.a(str, getPolymorphicDiscriminator())) {
                throw JsonExceptionsKt.JsonDecodingException(-1, "Encountered an unknown key '" + str + "' at element: " + renderTagStack() + "\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder or '@JsonIgnoreUnknownKeys' annotation to ignore unknown keys.\nJSON input: " + ((Object) JsonExceptionsKt.minify$default(getValue().toString(), 0, 1, null)));
            }
        }
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    public JsonObject getValue() {
        return this.value;
    }

    public /* synthetic */ JsonTreeDecoder(Json json, JsonObject jsonObject, String str, SerialDescriptor serialDescriptor, int i8, i iVar) {
        this(json, jsonObject, (i8 & 4) != 0 ? null : str, (i8 & 8) != 0 ? null : serialDescriptor);
    }
}
