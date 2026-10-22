package kotlinx.serialization;

import b5.a0;
import b8.h;
import c5.l;
import c5.s;
import c5.v;
import c5.z;
import com.stepos.stepclaw.SecurePrefs;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.p;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003BK\bF\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0014\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00070\t\u0012\u0014\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b0\t¢\u0006\u0004\b\f\u0010\rBY\bQ\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0014\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00070\t\u0012\u0014\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b0\t\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\t¢\u0006\u0004\b\f\u0010\u0010J$\u0010 \u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0005H\u0096\u0080\u0004J'\u0010 \u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010)R\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014X\u0082\u008e\b¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168VX\u0096\u0084\n¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R1\u0010\u001b\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0007\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b0\u001cX\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR#\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b0\u001cX\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lkotlinx/serialization/SealedClassSerializer;", "T", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "serialName", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "baseClass", "Lkotlin/reflect/KClass;", "subclasses", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "subclassSerializers", "Lkotlinx/serialization/KSerializer;", "<init>", "(Ljava/lang/String;Lkotlin/reflect/KClass;[Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;)V", "classAnnotations", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "(Ljava/lang/String;Lkotlin/reflect/KClass;[Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;[Ljava/lang/annotation/Annotation;)V", "getBaseClass", "()Lkotlin/reflect/KClass;", "_annotations", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor$delegate", "Lkotlin/Lazy;", "class2Serializer", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getClass2Serializer$kotlinx_serialization_core", "()Ljava/util/Map;", "serialName2Serializer", "findPolymorphicSerializerOrNull", "Lkotlinx/serialization/DeserializationStrategy;", "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "klassName", "Lkotlinx/serialization/SerializationStrategy;", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
@InternalSerializationApi
/* loaded from: classes.dex */
public final class SealedClassSerializer<T> extends AbstractPolymorphicSerializer<T> {
    private List<? extends Annotation> _annotations;
    private final v5.c baseClass;
    private final Map<v5.c, KSerializer<? extends T>> class2Serializer;
    private final b5.e descriptor$delegate;
    private final Map<String, KSerializer<? extends T>> serialName2Serializer;

    public SealedClassSerializer(String serialName, v5.c baseClass, v5.c[] subclasses, KSerializer<? extends T>[] subclassSerializers) {
        p.e(serialName, "serialName");
        p.e(baseClass, "baseClass");
        p.e(subclasses, "subclasses");
        p.e(subclassSerializers, "subclassSerializers");
        this.baseClass = baseClass;
        this._annotations = s.f1092a;
        this.descriptor$delegate = h.w(b5.f.f889a, new com.stepos.stepclaw.memory.lightmem.f((Object) serialName, 4, (Object) this));
        if (subclasses.length != subclassSerializers.length) {
            throw new IllegalArgumentException("All subclasses of sealed class " + ((kotlin.jvm.internal.h) getBaseClass()).b() + " should be marked @Serializable");
        }
        int iMin = Math.min(subclasses.length, subclassSerializers.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i8 = 0; i8 < iMin; i8++) {
            arrayList.add(new b5.g(subclasses[i8], subclassSerializers[i8]));
        }
        Map<v5.c, KSerializer<? extends T>> mapV = z.V(arrayList);
        this.class2Serializer = mapV;
        final Set<Map.Entry<v5.c, KSerializer<? extends T>>> setEntrySet = mapV.entrySet();
        v vVar = new v() { // from class: kotlinx.serialization.SealedClassSerializer$special$$inlined$groupingBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // c5.v
            public String keyOf(Map.Entry<? extends v5.c, ? extends KSerializer<? extends T>> element) {
                return ((KSerializer) element.getValue()).getDescriptor().getSerialName();
            }

            @Override // c5.v
            public Iterator<Map.Entry<? extends v5.c, ? extends KSerializer<? extends T>>> sourceIterator() {
                return setEntrySet.iterator();
            }
        };
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator itSourceIterator = vVar.sourceIterator();
        while (itSourceIterator.hasNext()) {
            Object next = itSourceIterator.next();
            Object objKeyOf = vVar.keyOf(next);
            Object obj = linkedHashMap.get(objKeyOf);
            if (obj == null) {
                linkedHashMap.containsKey(objKeyOf);
            }
            Map.Entry entry = (Map.Entry) next;
            Map.Entry entry2 = (Map.Entry) obj;
            String str = (String) objKeyOf;
            if (entry2 != null) {
                throw new IllegalStateException(("Multiple sealed subclasses of '" + getBaseClass() + "' have the same serial name '" + str + "': '" + entry2.getKey() + "', '" + entry.getKey() + '\'').toString());
            }
            linkedHashMap.put(objKeyOf, entry);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(z.T(linkedHashMap.size()));
        for (Map.Entry entry3 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry3.getKey(), (KSerializer) ((Map.Entry) entry3.getValue()).getValue());
        }
        this.serialName2Serializer = linkedHashMap2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerialDescriptor descriptor_delegate$lambda$0(String str, SealedClassSerializer sealedClassSerializer) {
        return SerialDescriptorsKt.buildSerialDescriptor(str, PolymorphicKind.SEALED.INSTANCE, new SerialDescriptor[0], new b(sealedClassSerializer, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 descriptor_delegate$lambda$0$0(SealedClassSerializer sealedClassSerializer, ClassSerialDescriptorBuilder buildSerialDescriptor) {
        p.e(buildSerialDescriptor, "$this$buildSerialDescriptor");
        ClassSerialDescriptorBuilder.element$default(buildSerialDescriptor, "type", BuiltinSerializersKt.serializer(c0.f3665a).getDescriptor(), null, false, 12, null);
        ClassSerialDescriptorBuilder.element$default(buildSerialDescriptor, "value", SerialDescriptorsKt.buildSerialDescriptor("kotlinx.serialization.Sealed<" + ((kotlin.jvm.internal.h) sealedClassSerializer.getBaseClass()).b() + '>', SerialKind.CONTEXTUAL.INSTANCE, new SerialDescriptor[0], new b(sealedClassSerializer, 1)), null, false, 12, null);
        buildSerialDescriptor.setAnnotations(sealedClassSerializer._annotations);
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 descriptor_delegate$lambda$0$0$0(SealedClassSerializer sealedClassSerializer, ClassSerialDescriptorBuilder buildSerialDescriptor) {
        p.e(buildSerialDescriptor, "$this$buildSerialDescriptor");
        for (Map.Entry<String, KSerializer<? extends T>> entry : sealedClassSerializer.serialName2Serializer.entrySet()) {
            ClassSerialDescriptorBuilder.element$default(buildSerialDescriptor, entry.getKey(), entry.getValue().getDescriptor(), null, false, 12, null);
        }
        return a0.f883a;
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public DeserializationStrategy<T> findPolymorphicSerializerOrNull(CompositeDecoder decoder, String klassName) {
        p.e(decoder, "decoder");
        KSerializer<? extends T> kSerializer = this.serialName2Serializer.get(klassName);
        return kSerializer != null ? kSerializer : super.findPolymorphicSerializerOrNull(decoder, klassName);
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public v5.c getBaseClass() {
        return this.baseClass;
    }

    public final Map<v5.c, KSerializer<? extends T>> getClass2Serializer$kotlinx_serialization_core() {
        return this.class2Serializer;
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.descriptor$delegate.getValue();
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public SerializationStrategy<T> findPolymorphicSerializerOrNull(Encoder encoder, T value) {
        p.e(encoder, "encoder");
        p.e(value, "value");
        KSerializer<? extends T> kSerializer = this.class2Serializer.get(kotlin.jvm.internal.z.a(value.getClass()));
        KSerializer<? extends T> kSerializerFindPolymorphicSerializerOrNull = kSerializer != null ? kSerializer : super.findPolymorphicSerializerOrNull(encoder, (Encoder) value);
        if (kSerializerFindPolymorphicSerializerOrNull != null) {
            return kSerializerFindPolymorphicSerializerOrNull;
        }
        return null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SealedClassSerializer(String serialName, v5.c baseClass, v5.c[] subclasses, KSerializer<? extends T>[] subclassSerializers, Annotation[] classAnnotations) {
        this(serialName, baseClass, subclasses, subclassSerializers);
        p.e(serialName, "serialName");
        p.e(baseClass, "baseClass");
        p.e(subclasses, "subclasses");
        p.e(subclassSerializers, "subclassSerializers");
        p.e(classAnnotations, "classAnnotations");
        this._annotations = l.S(classAnnotations);
    }
}
