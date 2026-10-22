package com.stepos.stepclaw.bridge.openclaw;

import b5.e;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import com.stepos.stepclaw.provider.contract.OperationResult;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/stepos/stepclaw/bridge/openclaw/ToolsInvokeResult.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/stepos/stepclaw/bridge/openclaw/ToolsInvokeResult;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lb5/a0;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/stepos/stepclaw/bridge/openclaw/ToolsInvokeResult;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/stepos/stepclaw/bridge/openclaw/ToolsInvokeResult;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "step-bridge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* synthetic */ class ToolsInvokeResult$$serializer implements GeneratedSerializer<ToolsInvokeResult> {
    public static final ToolsInvokeResult$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ToolsInvokeResult$$serializer toolsInvokeResult$$serializer = new ToolsInvokeResult$$serializer();
        INSTANCE = toolsInvokeResult$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.stepos.stepclaw.bridge.openclaw.ToolsInvokeResult", toolsInvokeResult$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement(ConfigIpcContract.KEY_OK, true);
        pluginGeneratedSerialDescriptor.addElement(OperationResult.EXTRA_SUCCESS, true);
        pluginGeneratedSerialDescriptor.addElement("disabled", true);
        pluginGeneratedSerialDescriptor.addElement("unavailable", true);
        pluginGeneratedSerialDescriptor.addElement("error", true);
        pluginGeneratedSerialDescriptor.addElement("warning", true);
        pluginGeneratedSerialDescriptor.addElement("action", true);
        pluginGeneratedSerialDescriptor.addElement("details", true);
        pluginGeneratedSerialDescriptor.addElement("data", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ToolsInvokeResult$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        e[] eVarArr = ToolsInvokeResult.$childSerializers;
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(booleanSerializer);
        KSerializer<?> nullable2 = BuiltinSerializersKt.getNullable(booleanSerializer);
        KSerializer<?> nullable3 = BuiltinSerializersKt.getNullable(booleanSerializer);
        KSerializer<?> nullable4 = BuiltinSerializersKt.getNullable(booleanSerializer);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{nullable, nullable2, nullable3, nullable4, BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable((KSerializer) eVarArr[7].getValue()), BuiltinSerializersKt.getNullable((KSerializer) eVarArr[8].getValue())};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final ToolsInvokeResult deserialize(Decoder decoder) {
        int i8;
        Map map;
        String str;
        Map map2;
        String str2;
        String str3;
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4;
        p.e(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        e[] eVarArr = ToolsInvokeResult.$childSerializers;
        int i9 = 7;
        Boolean bool5 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
            Boolean bool6 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, booleanSerializer, null);
            Boolean bool7 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, booleanSerializer, null);
            Boolean bool8 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, booleanSerializer, null);
            Boolean bool9 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, booleanSerializer, null);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, stringSerializer, null);
            String str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, stringSerializer, null);
            String str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, stringSerializer, null);
            Map map3 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, (DeserializationStrategy) eVarArr[7].getValue(), null);
            map = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, (DeserializationStrategy) eVarArr[8].getValue(), null);
            bool = bool9;
            str = str6;
            str2 = str5;
            map2 = map3;
            str3 = str4;
            bool4 = bool8;
            i8 = 511;
            bool3 = bool7;
            bool2 = bool6;
        } else {
            boolean z = true;
            int i10 = 0;
            Map map4 = null;
            String str7 = null;
            Map map5 = null;
            String str8 = null;
            String str9 = null;
            Boolean bool10 = null;
            Boolean bool11 = null;
            Boolean bool12 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        i9 = 7;
                    case 0:
                        bool5 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, BooleanSerializer.INSTANCE, bool5);
                        i10 |= 1;
                        i9 = 7;
                    case 1:
                        bool11 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, BooleanSerializer.INSTANCE, bool11);
                        i10 |= 2;
                        i9 = 7;
                    case 2:
                        bool12 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, BooleanSerializer.INSTANCE, bool12);
                        i10 |= 4;
                        i9 = 7;
                    case 3:
                        bool10 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, BooleanSerializer.INSTANCE, bool10);
                        i10 |= 8;
                        i9 = 7;
                    case 4:
                        str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str9);
                        i10 |= 16;
                        i9 = 7;
                    case 5:
                        str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str8);
                        i10 |= 32;
                        i9 = 7;
                    case 6:
                        str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str7);
                        i10 |= 64;
                        i9 = 7;
                    case 7:
                        map5 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i9, (DeserializationStrategy) eVarArr[i9].getValue(), map5);
                        i10 |= 128;
                    case 8:
                        map4 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, (DeserializationStrategy) eVarArr[8].getValue(), map4);
                        i10 |= 256;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i8 = i10;
            map = map4;
            str = str7;
            map2 = map5;
            str2 = str8;
            str3 = str9;
            bool = bool10;
            bool2 = bool5;
            bool3 = bool11;
            bool4 = bool12;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new ToolsInvokeResult(i8, bool2, bool3, bool4, bool, str3, str2, str, map2, map, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ToolsInvokeResult value) {
        p.e(encoder, "encoder");
        p.e(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        ToolsInvokeResult.write$Self$step_bridge_release(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
