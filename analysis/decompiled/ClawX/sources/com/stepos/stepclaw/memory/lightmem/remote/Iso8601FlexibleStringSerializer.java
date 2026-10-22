package com.stepos.stepclaw.memory.lightmem.remote;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.storage.file.MemoryFile;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonPrimitive;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/remote/Iso8601FlexibleStringSerializer;", "Lkotlinx/serialization/KSerializer;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/String;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lb5/a0;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/String;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Iso8601FlexibleStringSerializer implements KSerializer<String> {
    public static final Iso8601FlexibleStringSerializer INSTANCE = new Iso8601FlexibleStringSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor("Iso8601FlexibleString", PrimitiveKind.STRING.INSTANCE);

    private Iso8601FlexibleStringSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public String deserialize(Decoder decoder) {
        long jLongValue;
        p.e(decoder, "decoder");
        JsonDecoder jsonDecoder = decoder instanceof JsonDecoder ? (JsonDecoder) decoder : null;
        if (jsonDecoder == null) {
            return decoder.decodeString();
        }
        JsonElement jsonElementDecodeJsonElement = jsonDecoder.decodeJsonElement();
        if (!(jsonElementDecodeJsonElement instanceof JsonPrimitive)) {
            return jsonElementDecodeJsonElement.toString();
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementDecodeJsonElement;
        if (jsonPrimitive.getIsString()) {
            return jsonPrimitive.getContent();
        }
        Long longOrNull = JsonElementKt.getLongOrNull(jsonPrimitive);
        if (longOrNull != null) {
            jLongValue = longOrNull.longValue();
        } else {
            Double doubleOrNull = JsonElementKt.getDoubleOrNull(jsonPrimitive);
            Long lValueOf = doubleOrNull != null ? Long.valueOf((long) doubleOrNull.doubleValue()) : null;
            if (lValueOf == null) {
                return jsonPrimitive.getContent();
            }
            jLongValue = lValueOf.longValue();
        }
        if (jLongValue < 100000000000L) {
            jLongValue *= 1000;
        }
        return MemoryFile.INSTANCE.formatAsIso8601(jLongValue);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, String value) {
        p.e(encoder, "encoder");
        p.e(value, "value");
        encoder.encodeString(value);
    }
}
