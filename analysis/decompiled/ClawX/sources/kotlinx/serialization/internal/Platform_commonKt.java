package kotlinx.serialization.internal;

import com.stepos.stepclaw.SecurePrefs;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.p;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import p5.l;
import v5.d;
import v5.i;
import v5.k;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0080\u0080\u0004\u001a!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bH\u0080\u0080\u0004¢\u0006\u0002\u0010\t\u001a\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u0004\b\u0000\u0010\f*\u0006\u0012\u0002\b\u00030\u000bH\u0081\u0088\u0004\u001a\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\r\"\u0004\b\u0000\u0010\f*\u0006\u0012\u0002\b\u00030\rH\u0081\u0088\u0004\u001a\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000e\"\u0004\b\u0000\u0010\f*\u0006\u0012\u0002\b\u00030\u000eH\u0081\u0088\u0004\u001a\u0012\u0010\u000f\u001a\u00020\u0010*\u0006\u0012\u0002\b\u00030\u0011H\u0080\u0080\u0004\u001a\u0012\u0010\u0012\u001a\u00020\u0002*\u0006\u0012\u0002\b\u00030\u0011H\u0080\u0080\u0004\u001a\u0012\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0080\u0080\u0004\u001a\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0011*\u00020\u0016H\u0080\u0080\u0004\u001a\u000e\u0010\u0017\u001a\u00020\u0016*\u00020\u0018H\u0080\u0080\u0004\u001a7\u0010\u0019\u001a\u00020\u001a\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u001b*\b\u0012\u0004\u0012\u0002H\f0\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u001b0\u001eH\u0080\u0088\u0004ø\u0001\u0000\"\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, d2 = {"cachedSerialNames", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlinx/serialization/descriptors/SerialDescriptor;", "EMPTY_DESCRIPTOR_ARRAY", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "[Lkotlinx/serialization/descriptors/SerialDescriptor;", "compactArray", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "(Ljava/util/List;)[Lkotlinx/serialization/descriptors/SerialDescriptor;", "cast", "Lkotlinx/serialization/KSerializer;", "T", "Lkotlinx/serialization/SerializationStrategy;", "Lkotlinx/serialization/DeserializationStrategy;", "serializerNotRegistered", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlin/reflect/KClass;", "notRegisteredMessage", "className", "kclass", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlin/reflect/KType;", "typeOrThrow", "Lkotlin/reflect/KTypeProjection;", "elementsHashCodeBy", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "K", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "selector", "Lkotlin/Function1;", "kotlinx-serialization-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Platform_commonKt {
    private static final SerialDescriptor[] EMPTY_DESCRIPTOR_ARRAY = new SerialDescriptor[0];

    public static final Set<String> cachedSerialNames(SerialDescriptor serialDescriptor) {
        p.e(serialDescriptor, "<this>");
        if (serialDescriptor instanceof CachedNames) {
            return ((CachedNames) serialDescriptor).getSerialNames();
        }
        HashSet hashSet = new HashSet(serialDescriptor.getElementsCount());
        int elementsCount = serialDescriptor.getElementsCount();
        for (int i8 = 0; i8 < elementsCount; i8++) {
            hashSet.add(serialDescriptor.getElementName(i8));
        }
        return hashSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> DeserializationStrategy<T> cast(DeserializationStrategy<?> deserializationStrategy) {
        p.e(deserializationStrategy, "<this>");
        return deserializationStrategy;
    }

    public static final SerialDescriptor[] compactArray(List<? extends SerialDescriptor> list) {
        SerialDescriptor[] serialDescriptorArr;
        if (list == null || list.isEmpty()) {
            list = null;
        }
        return (list == null || (serialDescriptorArr = (SerialDescriptor[]) list.toArray(new SerialDescriptor[0])) == null) ? EMPTY_DESCRIPTOR_ARRAY : serialDescriptorArr;
    }

    public static final <T, K> int elementsHashCodeBy(Iterable<? extends T> iterable, l selector) {
        p.e(iterable, "<this>");
        p.e(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        int iHashCode = 1;
        while (it.hasNext()) {
            int i8 = iHashCode * 31;
            Object objInvoke = selector.invoke(it.next());
            iHashCode = i8 + (objInvoke != null ? objInvoke.hashCode() : 0);
        }
        return iHashCode;
    }

    public static final v5.c kclass(i iVar) {
        p.e(iVar, "<this>");
        d classifier = iVar.getClassifier();
        if (classifier instanceof v5.c) {
            return (v5.c) classifier;
        }
        if (!(classifier instanceof e0)) {
            throw new IllegalArgumentException("Only KClass supported as classifier, got " + classifier);
        }
        throw new IllegalArgumentException("Captured type parameter " + classifier + " from generic non-reified function. Such functionality cannot be supported because " + classifier + " is erased, either specify serializer explicitly or make calling function inline with reified " + classifier + '.');
    }

    public static final String notRegisteredMessage(v5.c cVar) {
        p.e(cVar, "<this>");
        String strB = ((h) cVar).b();
        if (strB == null) {
            strB = "<local class name not available>";
        }
        return notRegisteredMessage(strB);
    }

    public static final Void serializerNotRegistered(v5.c cVar) {
        p.e(cVar, "<this>");
        throw new SerializationException(notRegisteredMessage(cVar));
    }

    public static final i typeOrThrow(k kVar) {
        p.e(kVar, "<this>");
        i iVar = kVar.f5988b;
        if (iVar != null) {
            return iVar;
        }
        throw new IllegalArgumentException(("Star projections in type arguments are not allowed, but had " + iVar).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> KSerializer<T> cast(KSerializer<?> kSerializer) {
        p.e(kSerializer, "<this>");
        return kSerializer;
    }

    public static final String notRegisteredMessage(String className) {
        p.e(className, "className");
        return "Serializer for class '" + className + "' is not found.\nPlease ensure that class is marked as '@Serializable' and that the serialization compiler plugin is applied.\n";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> SerializationStrategy<T> cast(SerializationStrategy<?> serializationStrategy) {
        p.e(serializationStrategy, "<this>");
        return serializationStrategy;
    }
}
