package kotlinx.serialization.json.internal;

import a6.w;
import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.NamedValueDecoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.modules.SerializersModule;
import m0.f;
import p5.l;
import x5.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u00012\u00020\u0002B%\bD\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\n\u0010\u0017\u001a\u00020\u0006H\u0084\u0080\u0004J\u0012\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bH\u0086\u0080\u0004J\n\u0010\u001a\u001a\u00020\u0006H\u0096\u0080\u0004J#\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001eH\u0096\u0080\u0004¢\u0006\u0002\u0010\u001fJ\u001a\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bH\u0094\u0080\u0004J\u0012\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0096\u0080\u0004J+\u0010'\u001a\u0002H\u001c\"\n\b\u0000\u0010\u001c\u0018\u0001*\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&H\u0086\u0088\u0004¢\u0006\u0002\u0010(J3\u0010'\u001a\u0002H\u001c\"\n\b\u0000\u0010\u001c\u0018\u0001*\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\bH\u0086\u0088\u0004¢\u0006\u0002\u0010+J\u0012\u0010,\u001a\u00020-2\u0006\u0010%\u001a\u00020&H\u0096\u0080\u0004J\n\u0010.\u001a\u00020/H\u0096\u0080\u0004J\u001a\u00100\u001a\u0002012\u0006\u0010*\u001a\u00020\b2\u0006\u0010%\u001a\u00020&H\u0084\u0088\u0004JD\u00100\u001a\u0002H\u001c\"\b\b\u0000\u0010\u001c*\u0002022\u0006\u0010*\u001a\u00020\b2\u0006\u00103\u001a\u00020\b2\u0019\u00104\u001a\u0015\u0012\u0004\u0012\u000201\u0012\u0006\u0012\u0004\u0018\u0001H\u001c05¢\u0006\u0002\b6H\u0082\u0088\u0004¢\u0006\u0002\u00107J\"\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002012\u0006\u0010;\u001a\u00020\b2\u0006\u0010*\u001a\u00020\bH\u0082\u0080\u0004J\u0012\u0010<\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\bH¤\u0080\u0004J\u001a\u0010=\u001a\u00020>2\u0006\u0010*\u001a\u00020\b2\u0006\u0010?\u001a\u00020&H\u0094\u0080\u0004J\u0014\u0010@\u001a\u0004\u0018\u0001092\u0006\u0010*\u001a\u00020\bH\u0094\u0080\u0004J\u0012\u0010A\u001a\u00020/2\u0006\u0010*\u001a\u00020\bH\u0094\u0080\u0004J\u0012\u0010B\u001a\u00020/2\u0006\u0010*\u001a\u00020\bH\u0094\u0080\u0004J\u0012\u0010C\u001a\u00020D2\u0006\u0010*\u001a\u00020\bH\u0094\u0080\u0004J\u0012\u0010E\u001a\u00020F2\u0006\u0010*\u001a\u00020\bH\u0094\u0080\u0004J\u0012\u0010G\u001a\u00020>2\u0006\u0010*\u001a\u00020\bH\u0094\u0080\u0004J\u0012\u0010H\u001a\u00020I2\u0006\u0010*\u001a\u00020\bH\u0094\u0080\u0004J\u0012\u0010J\u001a\u00020K2\u0006\u0010*\u001a\u00020\bH\u0094\u0080\u0004J\u0012\u0010L\u001a\u00020M2\u0006\u0010*\u001a\u00020\bH\u0094\u0080\u0004J\u0012\u0010N\u001a\u00020O2\u0006\u0010*\u001a\u00020\bH\u0094\u0080\u0004J\u0012\u0010P\u001a\u00020\b2\u0006\u0010*\u001a\u00020\bH\u0094\u0080\u0004J\u001a\u0010Q\u001a\u00020R2\u0006\u0010*\u001a\u00020\b2\u0006\u0010S\u001a\u00020&H\u0094\u0080\u0004J\u0012\u0010T\u001a\u00020R2\u0006\u0010%\u001a\u00020&H\u0096\u0080\u0004R\u0015\u0010\u0003\u001a\u00020\u0004X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0005\u001a\u00020\u0006X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0084\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0011\u001a\u00020\u00128VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00168\u0004X\u0085\u0084\b¢\u0006\u0002\n\u0000\u0082\u0001\u0003UVW¨\u0006X"}, d2 = {"Lkotlinx/serialization/json/internal/AbstractJsonTreeDecoder;", "Lkotlinx/serialization/internal/NamedValueDecoder;", "Lkotlinx/serialization/json/JsonDecoder;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonElement;", "polymorphicDiscriminator", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;)V", "getJson", "()Lkotlinx/serialization/json/Json;", "getValue", "()Lkotlinx/serialization/json/JsonElement;", "getPolymorphicDiscriminator", "()Ljava/lang/String;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "currentObject", "renderTagStack", "currentTag", "decodeJsonElement", "decodeSerializableValue", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "composeName", "parentName", "childName", "beginStructure", "Lkotlinx/serialization/encoding/CompositeDecoder;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "cast", "(Lkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/json/JsonElement;", "serialName", "tag", "(Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;Ljava/lang/String;)Lkotlinx/serialization/json/JsonElement;", "endStructure", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "decodeNotNullMark", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getPrimitiveValue", "Lkotlinx/serialization/json/JsonPrimitive;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "primitiveName", "convert", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "unparsedPrimitive", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "literal", TreeJsonEncoderKt.PRIMITIVE_TAG, "currentElement", "decodeTaggedEnum", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "enumDescriptor", "decodeTaggedNull", "decodeTaggedNotNullMark", "decodeTaggedBoolean", "decodeTaggedByte", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "decodeTaggedShort", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "decodeTaggedInt", "decodeTaggedLong", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "decodeTaggedFloat", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "decodeTaggedDouble", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "decodeTaggedChar", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "decodeTaggedString", "decodeTaggedInline", "Lkotlinx/serialization/encoding/Decoder;", "inlineDescriptor", "decodeInline", "Lkotlinx/serialization/json/internal/JsonPrimitiveDecoder;", "Lkotlinx/serialization/json/internal/JsonTreeDecoder;", "Lkotlinx/serialization/json/internal/JsonTreeListDecoder;", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
abstract class AbstractJsonTreeDecoder extends NamedValueDecoder implements JsonDecoder {
    protected final JsonConfiguration configuration;
    private final Json json;
    private final String polymorphicDiscriminator;
    private final JsonElement value;

    public /* synthetic */ AbstractJsonTreeDecoder(Json json, JsonElement jsonElement, String str, i iVar) {
        this(json, jsonElement, str);
    }

    private final Void unparsedPrimitive(JsonPrimitive literal, String primitive, String tag) {
        throw JsonExceptionsKt.JsonDecodingException(-1, "Failed to parse literal '" + literal + "' as " + (u.c1(primitive, "i", false) ? "an " : "a ").concat(primitive) + " value at element: " + renderTagStack(tag), currentObject().toString());
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public CompositeDecoder beginStructure(SerialDescriptor descriptor) {
        p.e(descriptor, "descriptor");
        JsonElement jsonElementCurrentObject = currentObject();
        SerialKind kind = descriptor.getKind();
        if (p.a(kind, StructureKind.LIST.INSTANCE) || (kind instanceof PolymorphicKind)) {
            Json json = getJson();
            String serialName = descriptor.getSerialName();
            if (jsonElementCurrentObject instanceof JsonArray) {
                return new JsonTreeListDecoder(json, (JsonArray) jsonElementCurrentObject);
            }
            StringBuilder sb = new StringBuilder("Expected ");
            b.w(JsonArray.class, sb, ", but had ", jsonElementCurrentObject, " as the serialized body of ");
            sb.append(serialName);
            sb.append(" at element: ");
            sb.append(renderTagStack());
            throw JsonExceptionsKt.JsonDecodingException(-1, sb.toString(), jsonElementCurrentObject.toString());
        }
        if (!p.a(kind, StructureKind.MAP.INSTANCE)) {
            Json json2 = getJson();
            String serialName2 = descriptor.getSerialName();
            if (jsonElementCurrentObject instanceof JsonObject) {
                return new JsonTreeDecoder(json2, (JsonObject) jsonElementCurrentObject, this.polymorphicDiscriminator, null, 8, null);
            }
            StringBuilder sb2 = new StringBuilder("Expected ");
            b.w(JsonObject.class, sb2, ", but had ", jsonElementCurrentObject, " as the serialized body of ");
            sb2.append(serialName2);
            sb2.append(" at element: ");
            sb2.append(renderTagStack());
            throw JsonExceptionsKt.JsonDecodingException(-1, sb2.toString(), jsonElementCurrentObject.toString());
        }
        Json json3 = getJson();
        SerialDescriptor serialDescriptorCarrierDescriptor = WriteModeKt.carrierDescriptor(descriptor.getElementDescriptor(0), json3.getSerializersModule());
        SerialKind kind2 = serialDescriptorCarrierDescriptor.getKind();
        if ((kind2 instanceof PrimitiveKind) || p.a(kind2, SerialKind.ENUM.INSTANCE)) {
            Json json4 = getJson();
            String serialName3 = descriptor.getSerialName();
            if (jsonElementCurrentObject instanceof JsonObject) {
                return new JsonTreeMapDecoder(json4, (JsonObject) jsonElementCurrentObject);
            }
            StringBuilder sb3 = new StringBuilder("Expected ");
            b.w(JsonObject.class, sb3, ", but had ", jsonElementCurrentObject, " as the serialized body of ");
            sb3.append(serialName3);
            sb3.append(" at element: ");
            sb3.append(renderTagStack());
            throw JsonExceptionsKt.JsonDecodingException(-1, sb3.toString(), jsonElementCurrentObject.toString());
        }
        if (!json3.getConfiguration().getAllowStructuredMapKeys()) {
            throw JsonExceptionsKt.InvalidKeyKindException(serialDescriptorCarrierDescriptor);
        }
        Json json5 = getJson();
        String serialName4 = descriptor.getSerialName();
        if (jsonElementCurrentObject instanceof JsonArray) {
            return new JsonTreeListDecoder(json5, (JsonArray) jsonElementCurrentObject);
        }
        StringBuilder sb4 = new StringBuilder("Expected ");
        b.w(JsonArray.class, sb4, ", but had ", jsonElementCurrentObject, " as the serialized body of ");
        sb4.append(serialName4);
        sb4.append(" at element: ");
        sb4.append(renderTagStack());
        throw JsonExceptionsKt.JsonDecodingException(-1, sb4.toString(), jsonElementCurrentObject.toString());
    }

    public final /* synthetic */ <T extends JsonElement> T cast(JsonElement value, SerialDescriptor descriptor) {
        p.e(value, "value");
        p.e(descriptor, "descriptor");
        descriptor.getSerialName();
        p.i();
        throw null;
    }

    @Override // kotlinx.serialization.internal.NamedValueDecoder
    public String composeName(String parentName, String childName) {
        p.e(parentName, "parentName");
        p.e(childName, "childName");
        return childName;
    }

    public abstract JsonElement currentElement(String tag);

    public final JsonElement currentObject() {
        JsonElement jsonElementCurrentElement;
        String currentTagOrNull = getCurrentTagOrNull();
        return (currentTagOrNull == null || (jsonElementCurrentElement = currentElement(currentTagOrNull)) == null) ? getValue() : jsonElementCurrentElement;
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public Decoder decodeInline(SerialDescriptor descriptor) {
        p.e(descriptor, "descriptor");
        return getCurrentTagOrNull() != null ? super.decodeInline(descriptor) : new JsonPrimitiveDecoder(getJson(), getValue(), this.polymorphicDiscriminator).decodeInline(descriptor);
    }

    @Override // kotlinx.serialization.json.JsonDecoder
    public JsonElement decodeJsonElement() {
        return currentObject();
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public boolean decodeNotNullMark() {
        return !(currentObject() instanceof JsonNull);
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public <T> T decodeSerializableValue(DeserializationStrategy<? extends T> deserializer) {
        JsonPrimitive jsonPrimitive;
        p.e(deserializer, "deserializer");
        if (!(deserializer instanceof AbstractPolymorphicSerializer) || getJson().getConfiguration().getUseArrayPolymorphism()) {
            return deserializer.deserialize(this);
        }
        AbstractPolymorphicSerializer abstractPolymorphicSerializer = (AbstractPolymorphicSerializer) deserializer;
        String strClassDiscriminator = PolymorphicKt.classDiscriminator(abstractPolymorphicSerializer.getDescriptor(), getJson());
        JsonElement jsonElementDecodeJsonElement = decodeJsonElement();
        String serialName = abstractPolymorphicSerializer.getDescriptor().getSerialName();
        if (!(jsonElementDecodeJsonElement instanceof JsonObject)) {
            StringBuilder sb = new StringBuilder("Expected ");
            b.w(JsonObject.class, sb, ", but had ", jsonElementDecodeJsonElement, " as the serialized body of ");
            sb.append(serialName);
            sb.append(" at element: ");
            sb.append(renderTagStack());
            throw JsonExceptionsKt.JsonDecodingException(-1, sb.toString(), jsonElementDecodeJsonElement.toString());
        }
        JsonObject jsonObject = (JsonObject) jsonElementDecodeJsonElement;
        JsonElement jsonElement = (JsonElement) jsonObject.get((Object) strClassDiscriminator);
        try {
            DeserializationStrategy deserializationStrategyFindPolymorphicSerializer = PolymorphicSerializerKt.findPolymorphicSerializer((AbstractPolymorphicSerializer) deserializer, this, (jsonElement == null || (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement)) == null) ? null : JsonElementKt.getContentOrNull(jsonPrimitive));
            p.c(deserializationStrategyFindPolymorphicSerializer, "null cannot be cast to non-null type kotlinx.serialization.DeserializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.decodeSerializableValuePolymorphic>");
            return (T) TreeJsonDecoderKt.readPolymorphicJson(getJson(), strClassDiscriminator, jsonObject, deserializationStrategyFindPolymorphicSerializer);
        } catch (SerializationException e9) {
            String message = e9.getMessage();
            p.b(message);
            throw JsonExceptionsKt.JsonDecodingException(-1, message, jsonObject.toString());
        }
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public Void decodeTaggedNull(String tag) {
        p.e(tag, "tag");
        return null;
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public void endStructure(SerialDescriptor descriptor) {
        p.e(descriptor, "descriptor");
    }

    @Override // kotlinx.serialization.json.JsonDecoder
    public Json getJson() {
        return this.json;
    }

    public final String getPolymorphicDiscriminator() {
        return this.polymorphicDiscriminator;
    }

    public final JsonPrimitive getPrimitiveValue(String tag, SerialDescriptor descriptor) {
        p.e(tag, "tag");
        p.e(descriptor, "descriptor");
        JsonElement jsonElementCurrentElement = currentElement(tag);
        String serialName = descriptor.getSerialName();
        if (jsonElementCurrentElement instanceof JsonPrimitive) {
            return (JsonPrimitive) jsonElementCurrentElement;
        }
        StringBuilder sb = new StringBuilder("Expected ");
        b.w(JsonPrimitive.class, sb, ", but had ", jsonElementCurrentElement, " as the serialized body of ");
        sb.append(serialName);
        sb.append(" at element: ");
        sb.append(renderTagStack(tag));
        throw JsonExceptionsKt.JsonDecodingException(-1, sb.toString(), jsonElementCurrentElement.toString());
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder, kotlinx.serialization.encoding.CompositeDecoder
    public SerializersModule getSerializersModule() {
        return getJson().getSerializersModule();
    }

    public JsonElement getValue() {
        return this.value;
    }

    public final String renderTagStack(String currentTag) {
        p.e(currentTag, "currentTag");
        return renderTagStack() + '.' + currentTag;
    }

    private AbstractJsonTreeDecoder(Json json, JsonElement jsonElement, String str) {
        this.json = json;
        this.value = jsonElement;
        this.polymorphicDiscriminator = str;
        this.configuration = getJson().getConfiguration();
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public boolean decodeTaggedBoolean(String tag) {
        p.e(tag, "tag");
        JsonElement jsonElementCurrentElement = currentElement(tag);
        if (!(jsonElementCurrentElement instanceof JsonPrimitive)) {
            StringBuilder sb = new StringBuilder("Expected ");
            b.w(JsonPrimitive.class, sb, ", but had ", jsonElementCurrentElement, " as the serialized body of boolean at element: ");
            sb.append(renderTagStack(tag));
            throw JsonExceptionsKt.JsonDecodingException(-1, sb.toString(), jsonElementCurrentElement.toString());
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementCurrentElement;
        try {
            Boolean booleanOrNull = JsonElementKt.getBooleanOrNull(jsonPrimitive);
            if (booleanOrNull != null) {
                return booleanOrNull.booleanValue();
            }
            unparsedPrimitive(jsonPrimitive, "boolean", tag);
            throw new w();
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive(jsonPrimitive, "boolean", tag);
            throw new w();
        }
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public byte decodeTaggedByte(String tag) {
        p.e(tag, "tag");
        JsonElement jsonElementCurrentElement = currentElement(tag);
        if (!(jsonElementCurrentElement instanceof JsonPrimitive)) {
            StringBuilder sb = new StringBuilder("Expected ");
            b.w(JsonPrimitive.class, sb, ", but had ", jsonElementCurrentElement, " as the serialized body of byte at element: ");
            sb.append(renderTagStack(tag));
            throw JsonExceptionsKt.JsonDecodingException(-1, sb.toString(), jsonElementCurrentElement.toString());
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementCurrentElement;
        try {
            long longImpl = JsonElementKt.parseLongImpl(jsonPrimitive);
            Byte bValueOf = (-128 > longImpl || longImpl > 127) ? null : Byte.valueOf((byte) longImpl);
            if (bValueOf != null) {
                return bValueOf.byteValue();
            }
            unparsedPrimitive(jsonPrimitive, "byte", tag);
            throw new w();
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive(jsonPrimitive, "byte", tag);
            throw new w();
        }
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public char decodeTaggedChar(String tag) {
        p.e(tag, "tag");
        JsonElement jsonElementCurrentElement = currentElement(tag);
        if (!(jsonElementCurrentElement instanceof JsonPrimitive)) {
            StringBuilder sb = new StringBuilder("Expected ");
            b.w(JsonPrimitive.class, sb, ", but had ", jsonElementCurrentElement, " as the serialized body of char at element: ");
            sb.append(renderTagStack(tag));
            throw JsonExceptionsKt.JsonDecodingException(-1, sb.toString(), jsonElementCurrentElement.toString());
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementCurrentElement;
        try {
            String content = jsonPrimitive.getContent();
            p.e(content, "<this>");
            int length = content.length();
            if (length == 0) {
                throw new NoSuchElementException("Char sequence is empty.");
            }
            if (length == 1) {
                return content.charAt(0);
            }
            throw new IllegalArgumentException("Char sequence has more than one element.");
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive(jsonPrimitive, "char", tag);
            throw new w();
        }
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public double decodeTaggedDouble(String tag) {
        p.e(tag, "tag");
        JsonElement jsonElementCurrentElement = currentElement(tag);
        if (!(jsonElementCurrentElement instanceof JsonPrimitive)) {
            StringBuilder sb = new StringBuilder("Expected ");
            b.w(JsonPrimitive.class, sb, ", but had ", jsonElementCurrentElement, " as the serialized body of double at element: ");
            sb.append(renderTagStack(tag));
            throw JsonExceptionsKt.JsonDecodingException(-1, sb.toString(), jsonElementCurrentElement.toString());
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementCurrentElement;
        try {
            double d = JsonElementKt.getDouble(jsonPrimitive);
            if (getJson().getConfiguration().getAllowSpecialFloatingPointValues() || Math.abs(d) <= Double.MAX_VALUE) {
                return d;
            }
            throw JsonExceptionsKt.InvalidFloatingPointDecoded(Double.valueOf(d), tag, currentObject().toString());
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive(jsonPrimitive, "double", tag);
            throw new w();
        }
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public int decodeTaggedEnum(String tag, SerialDescriptor enumDescriptor) {
        p.e(tag, "tag");
        p.e(enumDescriptor, "enumDescriptor");
        Json json = getJson();
        JsonElement jsonElementCurrentElement = currentElement(tag);
        String serialName = enumDescriptor.getSerialName();
        if (jsonElementCurrentElement instanceof JsonPrimitive) {
            return JsonNamesMapKt.getJsonNameIndexOrThrow$default(enumDescriptor, json, ((JsonPrimitive) jsonElementCurrentElement).getContent(), null, 4, null);
        }
        StringBuilder sb = new StringBuilder("Expected ");
        b.w(JsonPrimitive.class, sb, ", but had ", jsonElementCurrentElement, " as the serialized body of ");
        sb.append(serialName);
        sb.append(" at element: ");
        sb.append(renderTagStack(tag));
        throw JsonExceptionsKt.JsonDecodingException(-1, sb.toString(), jsonElementCurrentElement.toString());
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public float decodeTaggedFloat(String tag) {
        p.e(tag, "tag");
        JsonElement jsonElementCurrentElement = currentElement(tag);
        if (!(jsonElementCurrentElement instanceof JsonPrimitive)) {
            StringBuilder sb = new StringBuilder("Expected ");
            b.w(JsonPrimitive.class, sb, ", but had ", jsonElementCurrentElement, " as the serialized body of float at element: ");
            sb.append(renderTagStack(tag));
            throw JsonExceptionsKt.JsonDecodingException(-1, sb.toString(), jsonElementCurrentElement.toString());
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementCurrentElement;
        try {
            float f3 = JsonElementKt.getFloat(jsonPrimitive);
            if (getJson().getConfiguration().getAllowSpecialFloatingPointValues() || Math.abs(f3) <= Float.MAX_VALUE) {
                return f3;
            }
            throw JsonExceptionsKt.InvalidFloatingPointDecoded(Float.valueOf(f3), tag, currentObject().toString());
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive(jsonPrimitive, "float", tag);
            throw new w();
        }
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public Decoder decodeTaggedInline(String tag, SerialDescriptor inlineDescriptor) {
        p.e(tag, "tag");
        p.e(inlineDescriptor, "inlineDescriptor");
        if (!StreamingJsonEncoderKt.isUnsignedNumber(inlineDescriptor)) {
            return super.decodeTaggedInline((AbstractJsonTreeDecoder) tag, inlineDescriptor);
        }
        Json json = getJson();
        JsonElement jsonElementCurrentElement = currentElement(tag);
        String serialName = inlineDescriptor.getSerialName();
        if (jsonElementCurrentElement instanceof JsonPrimitive) {
            return new JsonDecoderForUnsignedTypes(StringJsonLexerKt.StringJsonLexer(json, ((JsonPrimitive) jsonElementCurrentElement).getContent()), getJson());
        }
        StringBuilder sb = new StringBuilder("Expected ");
        b.w(JsonPrimitive.class, sb, ", but had ", jsonElementCurrentElement, " as the serialized body of ");
        sb.append(serialName);
        sb.append(" at element: ");
        sb.append(renderTagStack(tag));
        throw JsonExceptionsKt.JsonDecodingException(-1, sb.toString(), jsonElementCurrentElement.toString());
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public int decodeTaggedInt(String tag) {
        p.e(tag, "tag");
        JsonElement jsonElementCurrentElement = currentElement(tag);
        if (!(jsonElementCurrentElement instanceof JsonPrimitive)) {
            StringBuilder sb = new StringBuilder("Expected ");
            b.w(JsonPrimitive.class, sb, ", but had ", jsonElementCurrentElement, " as the serialized body of int at element: ");
            sb.append(renderTagStack(tag));
            throw JsonExceptionsKt.JsonDecodingException(-1, sb.toString(), jsonElementCurrentElement.toString());
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementCurrentElement;
        try {
            long longImpl = JsonElementKt.parseLongImpl(jsonPrimitive);
            Integer numValueOf = (-2147483648L > longImpl || longImpl > 2147483647L) ? null : Integer.valueOf((int) longImpl);
            if (numValueOf != null) {
                return numValueOf.intValue();
            }
            unparsedPrimitive(jsonPrimitive, "int", tag);
            throw new w();
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive(jsonPrimitive, "int", tag);
            throw new w();
        }
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public long decodeTaggedLong(String tag) {
        p.e(tag, "tag");
        JsonElement jsonElementCurrentElement = currentElement(tag);
        if (jsonElementCurrentElement instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementCurrentElement;
            try {
                return JsonElementKt.parseLongImpl(jsonPrimitive);
            } catch (IllegalArgumentException unused) {
                this.unparsedPrimitive(jsonPrimitive, "long", tag);
                throw new w();
            }
        }
        StringBuilder sb = new StringBuilder("Expected ");
        b.w(JsonPrimitive.class, sb, ", but had ", jsonElementCurrentElement, " as the serialized body of long at element: ");
        sb.append(renderTagStack(tag));
        throw JsonExceptionsKt.JsonDecodingException(-1, sb.toString(), jsonElementCurrentElement.toString());
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public boolean decodeTaggedNotNullMark(String tag) {
        p.e(tag, "tag");
        return currentElement(tag) != JsonNull.INSTANCE;
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public short decodeTaggedShort(String tag) {
        p.e(tag, "tag");
        JsonElement jsonElementCurrentElement = currentElement(tag);
        if (!(jsonElementCurrentElement instanceof JsonPrimitive)) {
            StringBuilder sb = new StringBuilder("Expected ");
            b.w(JsonPrimitive.class, sb, ", but had ", jsonElementCurrentElement, " as the serialized body of short at element: ");
            sb.append(renderTagStack(tag));
            throw JsonExceptionsKt.JsonDecodingException(-1, sb.toString(), jsonElementCurrentElement.toString());
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementCurrentElement;
        try {
            long longImpl = JsonElementKt.parseLongImpl(jsonPrimitive);
            Short shValueOf = (-32768 > longImpl || longImpl > 32767) ? null : Short.valueOf((short) longImpl);
            if (shValueOf != null) {
                return shValueOf.shortValue();
            }
            unparsedPrimitive(jsonPrimitive, "short", tag);
            throw new w();
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive(jsonPrimitive, "short", tag);
            throw new w();
        }
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public String decodeTaggedString(String tag) {
        p.e(tag, "tag");
        JsonElement jsonElementCurrentElement = currentElement(tag);
        if (!(jsonElementCurrentElement instanceof JsonPrimitive)) {
            StringBuilder sb = new StringBuilder("Expected ");
            b.w(JsonPrimitive.class, sb, ", but had ", jsonElementCurrentElement, " as the serialized body of string at element: ");
            sb.append(renderTagStack(tag));
            throw JsonExceptionsKt.JsonDecodingException(-1, sb.toString(), jsonElementCurrentElement.toString());
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementCurrentElement;
        if (!(jsonPrimitive instanceof JsonLiteral)) {
            throw JsonExceptionsKt.JsonDecodingException(-1, "Expected string value for a non-null key '" + tag + "', got null literal instead at element: " + renderTagStack(tag), currentObject().toString());
        }
        JsonLiteral jsonLiteral = (JsonLiteral) jsonPrimitive;
        if (jsonLiteral.getIsString() || getJson().getConfiguration().getIsLenient()) {
            return jsonLiteral.getContent();
        }
        StringBuilder sb2 = new StringBuilder("String literal for key '");
        sb2.append(tag);
        sb2.append("' should be quoted at element: ");
        throw JsonExceptionsKt.JsonDecodingException(-1, f.f(sb2, renderTagStack(tag), ".\nUse 'isLenient = true' in 'Json {}' builder to accept non-compliant JSON."), currentObject().toString());
    }

    public final /* synthetic */ <T extends JsonElement> T cast(JsonElement value, String serialName, String tag) {
        p.e(value, "value");
        p.e(serialName, "serialName");
        p.e(tag, "tag");
        p.i();
        throw null;
    }

    public /* synthetic */ AbstractJsonTreeDecoder(Json json, JsonElement jsonElement, String str, int i8, i iVar) {
        this(json, jsonElement, (i8 & 4) != 0 ? null : str, null);
    }

    private final <T> T getPrimitiveValue(String str, String str2, l lVar) {
        JsonElement jsonElementCurrentElement = currentElement(str);
        if (jsonElementCurrentElement instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementCurrentElement;
            try {
                T t8 = (T) lVar.invoke(jsonPrimitive);
                if (t8 != null) {
                    return t8;
                }
                unparsedPrimitive(jsonPrimitive, str2, str);
                throw new w();
            } catch (IllegalArgumentException unused) {
                unparsedPrimitive(jsonPrimitive, str2, str);
                throw new w();
            }
        }
        StringBuilder sb = new StringBuilder("Expected ");
        b.w(JsonPrimitive.class, sb, ", but had ", jsonElementCurrentElement, " as the serialized body of ");
        sb.append(str2);
        sb.append(" at element: ");
        sb.append(renderTagStack(str));
        throw JsonExceptionsKt.JsonDecodingException(-1, sb.toString(), jsonElementCurrentElement.toString());
    }
}
