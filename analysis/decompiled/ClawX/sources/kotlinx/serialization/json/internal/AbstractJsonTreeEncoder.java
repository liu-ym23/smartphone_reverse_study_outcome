package kotlinx.serialization.json.internal;

import a6.w;
import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.NamedValueEncoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.modules.SerializersModule;
import org.bouncycastle.crypto.hpke.HPKE;
import p5.l;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0002JM\b2\u0018\u00002\u00020\u00012\u00020\u0002B%\bD\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0094\u0080\u0004J\u0012\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0007H\u0096\u0080\u0004J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096\u0080\u0004J\u001a\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0016H\u0094\u0080\u0004J\u001a\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0007H¦\u0080\u0004J\n\u0010&\u001a\u00020\u0007H¦\u0080\u0004J\n\u0010'\u001a\u00020\bH\u0096\u0080\u0004J\n\u0010(\u001a\u00020\bH\u0096\u0080\u0004J\u0012\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u0016H\u0094\u0080\u0004J\u001a\u0010+\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u001cH\u0094\u0080\u0004J\u001a\u0010-\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010,\u001a\u00020.H\u0094\u0080\u0004J\u001a\u0010/\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010,\u001a\u000200H\u0094\u0080\u0004J\u001a\u00101\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010,\u001a\u000202H\u0094\u0080\u0004J\u001a\u00103\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010,\u001a\u000204H\u0094\u0080\u0004J+\u00105\u001a\u00020\b\"\u0004\b\u0000\u001062\f\u00107\u001a\b\u0012\u0004\u0012\u0002H6082\u0006\u0010,\u001a\u0002H6H\u0096\u0080\u0004¢\u0006\u0002\u00109J\u001a\u0010:\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010,\u001a\u00020;H\u0094\u0080\u0004J\u001a\u0010<\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010,\u001a\u00020 H\u0094\u0080\u0004J\u001a\u0010=\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010,\u001a\u00020>H\u0094\u0080\u0004J\u001a\u0010?\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u0016H\u0094\u0080\u0004J\"\u0010@\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010A\u001a\u00020\u001a2\u0006\u0010B\u001a\u00020\u001cH\u0094\u0080\u0004J\u001a\u0010C\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010,\u001a\u00020DH\u0094\u0080\u0004J\u001a\u0010E\u001a\u00020F2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010G\u001a\u00020\u001aH\u0094\u0080\u0004J\u0012\u0010H\u001a\u00020F2\u0006\u0010\u0019\u001a\u00020\u001aH\u0096\u0080\u0004J\u0017\u0010I\u001a\u00020J2\u0006\u0010*\u001a\u00020\u0016H\u0083\u0080\u0004¢\u0006\u0002\u0010KJ\u001f\u0010L\u001a\u00020M2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010G\u001a\u00020\u001aH\u0082\u0080\u0004¢\u0006\u0002\u0010NJ\u0012\u0010O\u001a\u00020P2\u0006\u0010\u0019\u001a\u00020\u001aH\u0096\u0080\u0004J\u0012\u0010Q\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0094\u0080\u0004R\u0015\u0010\u0003\u001a\u00020\u0004X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR!\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0084\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148\u0004X\u0085\u0084\b¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u008e\b¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u008e\b¢\u0006\u0002\n\u0000\u0082\u0001\u0003RST¨\u0006U"}, d2 = {"Lkotlinx/serialization/json/internal/AbstractJsonTreeEncoder;", "Lkotlinx/serialization/internal/NamedValueEncoder;", "Lkotlinx/serialization/json/JsonEncoder;", "json", "Lkotlinx/serialization/json/Json;", "nodeConsumer", "Lkotlin/Function1;", "Lkotlinx/serialization/json/JsonElement;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Lkotlinx/serialization/json/Json;Lkotlin/jvm/functions/Function1;)V", "getJson", "()Lkotlinx/serialization/json/Json;", "getNodeConsumer", "()Lkotlin/jvm/functions/Function1;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "polymorphicDiscriminator", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "polymorphicSerialName", "elementName", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "index", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "encodeJsonElement", "element", "shouldEncodeElementDefault", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "composeName", "parentName", "childName", "putElement", "key", "getCurrent", "encodeNotNullMark", "encodeNull", "encodeTaggedNull", "tag", "encodeTaggedInt", "value", "encodeTaggedByte", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "encodeTaggedShort", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "encodeTaggedLong", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "encodeTaggedFloat", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "encodeSerializableValue", "T", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeTaggedDouble", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "encodeTaggedBoolean", "encodeTaggedChar", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "encodeTaggedString", "encodeTaggedEnum", "enumDescriptor", "ordinal", "encodeTaggedValue", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "encodeTaggedInline", "Lkotlinx/serialization/encoding/Encoder;", "inlineDescriptor", "encodeInline", "inlineUnsignedNumberEncoder", "kotlinx/serialization/json/internal/AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1", "(Ljava/lang/String;)Lkotlinx/serialization/json/internal/AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1;", "inlineUnquotedLiteralEncoder", "kotlinx/serialization/json/internal/AbstractJsonTreeEncoder$inlineUnquotedLiteralEncoder$1", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/json/internal/AbstractJsonTreeEncoder$inlineUnquotedLiteralEncoder$1;", "beginStructure", "Lkotlinx/serialization/encoding/CompositeEncoder;", "endEncode", "Lkotlinx/serialization/json/internal/JsonPrimitiveEncoder;", "Lkotlinx/serialization/json/internal/JsonTreeEncoder;", "Lkotlinx/serialization/json/internal/JsonTreeListEncoder;", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
abstract class AbstractJsonTreeEncoder extends NamedValueEncoder implements JsonEncoder {
    protected final JsonConfiguration configuration;
    private final Json json;
    private final l nodeConsumer;
    private String polymorphicDiscriminator;
    private String polymorphicSerialName;

    public /* synthetic */ AbstractJsonTreeEncoder(Json json, l lVar, i iVar) {
        this(json, lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 beginStructure$lambda$0(AbstractJsonTreeEncoder abstractJsonTreeEncoder, JsonElement node) {
        p.e(node, "node");
        abstractJsonTreeEncoder.putElement(abstractJsonTreeEncoder.getCurrentTag(), node);
        return a0.f883a;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlinx.serialization.json.internal.AbstractJsonTreeEncoder$inlineUnquotedLiteralEncoder$1] */
    private final AnonymousClass1 inlineUnquotedLiteralEncoder(final String tag, final SerialDescriptor inlineDescriptor) {
        return new AbstractEncoder() { // from class: kotlinx.serialization.json.internal.AbstractJsonTreeEncoder.inlineUnquotedLiteralEncoder.1
            @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
            public void encodeString(String value) {
                p.e(value, "value");
                AbstractJsonTreeEncoder.this.putElement(tag, new JsonLiteral(value, false, inlineDescriptor));
            }

            @Override // kotlinx.serialization.encoding.Encoder, kotlinx.serialization.encoding.CompositeEncoder
            public SerializersModule getSerializersModule() {
                return AbstractJsonTreeEncoder.this.getJson().getSerializersModule();
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlinx.serialization.json.internal.AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1] */
    @SuppressAnimalSniffer
    private final C00791 inlineUnsignedNumberEncoder(final String tag) {
        return new AbstractEncoder() { // from class: kotlinx.serialization.json.internal.AbstractJsonTreeEncoder.inlineUnsignedNumberEncoder.1
            private final SerializersModule serializersModule;

            {
                this.serializersModule = AbstractJsonTreeEncoder.this.getJson().getSerializersModule();
            }

            @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
            public void encodeByte(byte value) {
                putUnquotedString(String.valueOf(value & 255));
            }

            @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
            public void encodeInt(int value) {
                putUnquotedString(Integer.toUnsignedString(value));
            }

            @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
            public void encodeLong(long value) {
                putUnquotedString(Long.toUnsignedString(value));
            }

            @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
            public void encodeShort(short value) {
                putUnquotedString(String.valueOf(value & HPKE.aead_EXPORT_ONLY));
            }

            @Override // kotlinx.serialization.encoding.Encoder, kotlinx.serialization.encoding.CompositeEncoder
            public SerializersModule getSerializersModule() {
                return this.serializersModule;
            }

            public final void putUnquotedString(String s8) {
                p.e(s8, "s");
                AbstractJsonTreeEncoder.this.putElement(tag, new JsonLiteral(s8, false, null, 4, null));
            }
        };
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.Encoder
    public CompositeEncoder beginStructure(SerialDescriptor descriptor) {
        AbstractJsonTreeEncoder jsonTreeListEncoder;
        p.e(descriptor, "descriptor");
        l aVar = getCurrentTagOrNull() == null ? this.nodeConsumer : new a(0, this);
        SerialKind kind = descriptor.getKind();
        if (p.a(kind, StructureKind.LIST.INSTANCE) || (kind instanceof PolymorphicKind)) {
            jsonTreeListEncoder = new JsonTreeListEncoder(this.json, aVar);
        } else if (p.a(kind, StructureKind.MAP.INSTANCE)) {
            Json json = this.json;
            SerialDescriptor serialDescriptorCarrierDescriptor = WriteModeKt.carrierDescriptor(descriptor.getElementDescriptor(0), json.getSerializersModule());
            SerialKind kind2 = serialDescriptorCarrierDescriptor.getKind();
            if ((kind2 instanceof PrimitiveKind) || p.a(kind2, SerialKind.ENUM.INSTANCE)) {
                jsonTreeListEncoder = new JsonTreeMapEncoder(this.json, aVar);
            } else {
                if (!json.getConfiguration().getAllowStructuredMapKeys()) {
                    throw JsonExceptionsKt.InvalidKeyKindException(serialDescriptorCarrierDescriptor);
                }
                jsonTreeListEncoder = new JsonTreeListEncoder(this.json, aVar);
            }
        } else {
            jsonTreeListEncoder = new JsonTreeEncoder(this.json, aVar);
        }
        String str = this.polymorphicDiscriminator;
        if (str != null) {
            if (jsonTreeListEncoder instanceof JsonTreeMapEncoder) {
                JsonTreeMapEncoder jsonTreeMapEncoder = (JsonTreeMapEncoder) jsonTreeListEncoder;
                jsonTreeMapEncoder.putElement("key", JsonElementKt.JsonPrimitive(str));
                String serialName = this.polymorphicSerialName;
                if (serialName == null) {
                    serialName = descriptor.getSerialName();
                }
                jsonTreeMapEncoder.putElement("value", JsonElementKt.JsonPrimitive(serialName));
            } else {
                String serialName2 = this.polymorphicSerialName;
                if (serialName2 == null) {
                    serialName2 = descriptor.getSerialName();
                }
                jsonTreeListEncoder.putElement(str, JsonElementKt.JsonPrimitive(serialName2));
            }
            this.polymorphicDiscriminator = null;
            this.polymorphicSerialName = null;
        }
        return jsonTreeListEncoder;
    }

    @Override // kotlinx.serialization.internal.NamedValueEncoder
    public String composeName(String parentName, String childName) {
        p.e(parentName, "parentName");
        p.e(childName, "childName");
        return childName;
    }

    @Override // kotlinx.serialization.internal.NamedValueEncoder
    public String elementName(SerialDescriptor descriptor, int index) {
        p.e(descriptor, "descriptor");
        return JsonNamesMapKt.getJsonElementName(descriptor, this.json, index);
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.Encoder
    public Encoder encodeInline(SerialDescriptor descriptor) {
        p.e(descriptor, "descriptor");
        if (getCurrentTagOrNull() == null) {
            return new JsonPrimitiveEncoder(this.json, this.nodeConsumer).encodeInline(descriptor);
        }
        if (this.polymorphicDiscriminator != null) {
            this.polymorphicSerialName = descriptor.getSerialName();
        }
        return super.encodeInline(descriptor);
    }

    @Override // kotlinx.serialization.json.JsonEncoder
    public void encodeJsonElement(JsonElement element) {
        p.e(element, "element");
        if (this.polymorphicDiscriminator == null || (element instanceof JsonObject)) {
            encodeSerializableValue(JsonElementSerializer.INSTANCE, element);
        } else {
            PolymorphicKt.throwJsonElementPolymorphicException(this.polymorphicSerialName, element);
            throw new w();
        }
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeNull() {
        String currentTagOrNull = getCurrentTagOrNull();
        if (currentTagOrNull == null) {
            this.nodeConsumer.invoke(JsonNull.INSTANCE);
        } else {
            encodeTaggedNull(currentTagOrNull);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0087  */
    @Override // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.Encoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T> void encodeSerializableValue(kotlinx.serialization.SerializationStrategy<? super T> r4, T r5) {
        /*
            r3 = this;
            java.lang.String r0 = "serializer"
            kotlin.jvm.internal.p.e(r4, r0)
            java.lang.Object r0 = r3.getCurrentTagOrNull()
            if (r0 != 0) goto L2b
            kotlinx.serialization.descriptors.SerialDescriptor r0 = r4.getDescriptor()
            kotlinx.serialization.modules.SerializersModule r1 = r3.getSerializersModule()
            kotlinx.serialization.descriptors.SerialDescriptor r0 = kotlinx.serialization.json.internal.WriteModeKt.carrierDescriptor(r0, r1)
            boolean r0 = kotlinx.serialization.json.internal.TreeJsonEncoderKt.access$getRequiresTopLevelTag(r0)
            if (r0 != 0) goto L1e
            goto L2b
        L1e:
            kotlinx.serialization.json.internal.JsonPrimitiveEncoder r0 = new kotlinx.serialization.json.internal.JsonPrimitiveEncoder
            kotlinx.serialization.json.Json r1 = r3.json
            p5.l r3 = r3.nodeConsumer
            r0.<init>(r1, r3)
            r0.encodeSerializableValue(r4, r5)
            return
        L2b:
            kotlinx.serialization.json.Json r0 = r3.getJson()
            kotlinx.serialization.json.JsonConfiguration r0 = r0.getConfiguration()
            boolean r0 = r0.getUseArrayPolymorphism()
            if (r0 == 0) goto L3d
            r4.serialize(r3, r5)
            return
        L3d:
            boolean r0 = r4 instanceof kotlinx.serialization.internal.AbstractPolymorphicSerializer
            if (r0 == 0) goto L52
            kotlinx.serialization.json.Json r1 = r3.getJson()
            kotlinx.serialization.json.JsonConfiguration r1 = r1.getConfiguration()
            kotlinx.serialization.json.ClassDiscriminatorMode r1 = r1.getClassDiscriminatorMode()
            kotlinx.serialization.json.ClassDiscriminatorMode r2 = kotlinx.serialization.json.ClassDiscriminatorMode.NONE
            if (r1 == r2) goto L9a
            goto L87
        L52:
            kotlinx.serialization.json.Json r1 = r3.getJson()
            kotlinx.serialization.json.JsonConfiguration r1 = r1.getConfiguration()
            kotlinx.serialization.json.ClassDiscriminatorMode r1 = r1.getClassDiscriminatorMode()
            int[] r2 = kotlinx.serialization.json.internal.PolymorphicKt.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r2[r1]
            r2 = 1
            if (r1 == r2) goto L9a
            r2 = 2
            if (r1 == r2) goto L9a
            r2 = 3
            if (r1 != r2) goto L94
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r4.getDescriptor()
            kotlinx.serialization.descriptors.SerialKind r1 = r1.getKind()
            kotlinx.serialization.descriptors.StructureKind$CLASS r2 = kotlinx.serialization.descriptors.StructureKind.CLASS.INSTANCE
            boolean r2 = kotlin.jvm.internal.p.a(r1, r2)
            if (r2 != 0) goto L87
            kotlinx.serialization.descriptors.StructureKind$OBJECT r2 = kotlinx.serialization.descriptors.StructureKind.OBJECT.INSTANCE
            boolean r1 = kotlin.jvm.internal.p.a(r1, r2)
            if (r1 == 0) goto L9a
        L87:
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r4.getDescriptor()
            kotlinx.serialization.json.Json r2 = r3.getJson()
            java.lang.String r1 = kotlinx.serialization.json.internal.PolymorphicKt.classDiscriminator(r1, r2)
            goto L9b
        L94:
            a6.w r3 = new a6.w
            r3.<init>()
            throw r3
        L9a:
            r1 = 0
        L9b:
            if (r0 == 0) goto Lcd
            r0 = r4
            kotlinx.serialization.internal.AbstractPolymorphicSerializer r0 = (kotlinx.serialization.internal.AbstractPolymorphicSerializer) r0
            if (r5 == 0) goto Lac
            kotlinx.serialization.SerializationStrategy r0 = kotlinx.serialization.PolymorphicSerializerKt.findPolymorphicSerializer(r0, r3, r5)
            java.lang.String r2 = "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.encodePolymorphically>"
            kotlin.jvm.internal.p.c(r0, r2)
            goto Lce
        Lac:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Value for serializer "
            r3.<init>(r4)
            kotlinx.serialization.descriptors.SerialDescriptor r4 = r0.getDescriptor()
            r3.append(r4)
            java.lang.String r4 = " should always be non-null. Please report issue to the kotlinx.serialization tracker."
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r3 = r3.toString()
            r4.<init>(r3)
            throw r4
        Lcd:
            r0 = r4
        Lce:
            if (r1 == 0) goto Lee
            kotlinx.serialization.json.Json r2 = r3.getJson()
            kotlinx.serialization.json.internal.PolymorphicKt.access$checkEncodingConflicts(r2, r4, r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r4 = r0.getDescriptor()
            kotlinx.serialization.descriptors.SerialKind r4 = r4.getKind()
            kotlinx.serialization.json.internal.PolymorphicKt.checkKind(r4)
            kotlinx.serialization.descriptors.SerialDescriptor r4 = r0.getDescriptor()
            java.lang.String r4 = r4.getSerialName()
            r3.polymorphicDiscriminator = r1
            r3.polymorphicSerialName = r4
        Lee:
            r0.serialize(r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.AbstractJsonTreeEncoder.encodeSerializableValue(kotlinx.serialization.SerializationStrategy, java.lang.Object):void");
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void endEncode(SerialDescriptor descriptor) {
        p.e(descriptor, "descriptor");
        this.nodeConsumer.invoke(getCurrent());
    }

    public abstract JsonElement getCurrent();

    @Override // kotlinx.serialization.json.JsonEncoder
    public final Json getJson() {
        return this.json;
    }

    public final l getNodeConsumer() {
        return this.nodeConsumer;
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.Encoder, kotlinx.serialization.encoding.CompositeEncoder
    public final SerializersModule getSerializersModule() {
        return this.json.getSerializersModule();
    }

    public abstract void putElement(String key, JsonElement element);

    @Override // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.CompositeEncoder
    public boolean shouldEncodeElementDefault(SerialDescriptor descriptor, int index) {
        p.e(descriptor, "descriptor");
        return this.configuration.getEncodeDefaults();
    }

    private AbstractJsonTreeEncoder(Json json, l lVar) {
        this.json = json;
        this.nodeConsumer = lVar;
        this.configuration = json.getConfiguration();
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedBoolean(String tag, boolean value) {
        p.e(tag, "tag");
        putElement(tag, JsonElementKt.JsonPrimitive(Boolean.valueOf(value)));
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedByte(String tag, byte value) {
        p.e(tag, "tag");
        putElement(tag, JsonElementKt.JsonPrimitive(Byte.valueOf(value)));
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedChar(String tag, char value) {
        p.e(tag, "tag");
        putElement(tag, JsonElementKt.JsonPrimitive(String.valueOf(value)));
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedDouble(String tag, double value) {
        p.e(tag, "tag");
        putElement(tag, JsonElementKt.JsonPrimitive(Double.valueOf(value)));
        if (!this.configuration.getAllowSpecialFloatingPointValues() && Math.abs(value) > Double.MAX_VALUE) {
            throw JsonExceptionsKt.InvalidFloatingPointEncoded(Double.valueOf(value), tag, getCurrent().toString());
        }
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedEnum(String tag, SerialDescriptor enumDescriptor, int ordinal) {
        p.e(tag, "tag");
        p.e(enumDescriptor, "enumDescriptor");
        putElement(tag, JsonElementKt.JsonPrimitive(enumDescriptor.getElementName(ordinal)));
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedFloat(String tag, float value) {
        p.e(tag, "tag");
        putElement(tag, JsonElementKt.JsonPrimitive(Float.valueOf(value)));
        if (!this.configuration.getAllowSpecialFloatingPointValues() && Math.abs(value) > Float.MAX_VALUE) {
            throw JsonExceptionsKt.InvalidFloatingPointEncoded(Float.valueOf(value), tag, getCurrent().toString());
        }
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    public Encoder encodeTaggedInline(String tag, SerialDescriptor inlineDescriptor) {
        p.e(tag, "tag");
        p.e(inlineDescriptor, "inlineDescriptor");
        return StreamingJsonEncoderKt.isUnsignedNumber(inlineDescriptor) ? inlineUnsignedNumberEncoder(tag) : StreamingJsonEncoderKt.isUnquotedLiteral(inlineDescriptor) ? inlineUnquotedLiteralEncoder(tag, inlineDescriptor) : super.encodeTaggedInline((AbstractJsonTreeEncoder) tag, inlineDescriptor);
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedInt(String tag, int value) {
        p.e(tag, "tag");
        putElement(tag, JsonElementKt.JsonPrimitive(Integer.valueOf(value)));
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedLong(String tag, long value) {
        p.e(tag, "tag");
        putElement(tag, JsonElementKt.JsonPrimitive(Long.valueOf(value)));
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedNull(String tag) {
        p.e(tag, "tag");
        putElement(tag, JsonNull.INSTANCE);
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedShort(String tag, short value) {
        p.e(tag, "tag");
        putElement(tag, JsonElementKt.JsonPrimitive(Short.valueOf(value)));
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedString(String tag, String value) {
        p.e(tag, "tag");
        p.e(value, "value");
        putElement(tag, JsonElementKt.JsonPrimitive(value));
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder
    public void encodeTaggedValue(String tag, Object value) {
        p.e(tag, "tag");
        p.e(value, "value");
        putElement(tag, JsonElementKt.JsonPrimitive(value.toString()));
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeNotNullMark() {
    }
}
