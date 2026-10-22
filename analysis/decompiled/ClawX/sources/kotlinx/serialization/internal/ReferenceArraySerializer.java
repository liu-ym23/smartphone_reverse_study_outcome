package kotlinx.serialization.internal;

import c5.l;
import com.stepos.stepclaw.SecurePrefs;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\n\b\u0001\u0010\u0003*\u0004\u0018\u0001H\u00012*\u0012\u0004\u0012\u0002H\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002H\u00030\u0006j\b\u0012\u0004\u0012\u0002H\u0003`\u00070\u0004B%\bF\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0012\u001a\u00020\u0013*\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0094\u0080\u0004¢\u0006\u0002\u0010\u0014J\u001f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0016*\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0094\u0080\u0004¢\u0006\u0002\u0010\u0017J\u001a\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u0007H\u0094\u0080\u0004J\u001e\u0010\u0019\u001a\u00020\u0013*\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u0007H\u0094\u0080\u0004J)\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005*\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u0007H\u0094\u0080\u0004¢\u0006\u0002\u0010\u001bJ)\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u0007*\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0094\u0080\u0004¢\u0006\u0002\u0010\u001dJ&\u0010\u001e\u001a\u00020\u001f*\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u00072\u0006\u0010 \u001a\u00020\u0013H\u0094\u0080\u0004J3\u0010!\u001a\u00020\u001f*\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u00072\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00028\u0001H\u0094\u0080\u0004¢\u0006\u0002\u0010$R\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u000e\u001a\u00020\u000fX\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006%"}, d2 = {"Lkotlinx/serialization/internal/ReferenceArraySerializer;", "ElementKlass", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Element", "Lkotlinx/serialization/internal/CollectionLikeSerializer;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "kClass", "Lkotlin/reflect/KClass;", "eSerializer", "Lkotlinx/serialization/KSerializer;", "<init>", "(Lkotlin/reflect/KClass;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "collectionSize", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "([Ljava/lang/Object;)I", "collectionIterator", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "([Ljava/lang/Object;)Ljava/util/Iterator;", "builder", "builderSize", "toResult", "(Ljava/util/ArrayList;)[Ljava/lang/Object;", "toBuilder", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "checkCapacity", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "size", "insert", "index", "element", "(Ljava/util/ArrayList;ILjava/lang/Object;)V", "kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ReferenceArraySerializer<ElementKlass, Element extends ElementKlass> extends CollectionLikeSerializer<Element, Element[], ArrayList<Element>> {
    private final SerialDescriptor descriptor;
    private final v5.c kClass;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReferenceArraySerializer(v5.c kClass, KSerializer<Element> eSerializer) {
        super(eSerializer, null);
        p.e(kClass, "kClass");
        p.e(eSerializer, "eSerializer");
        this.kClass = kClass;
        this.descriptor = new ArrayClassDesc(eSerializer.getDescriptor());
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer
    public /* bridge */ /* synthetic */ void insert(Object obj, int i8, Object obj2) {
        insert((ArrayList<int>) obj, i8, (int) obj2);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public ArrayList<Element> builder() {
        return new ArrayList<>();
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public int builderSize(ArrayList<Element> arrayList) {
        p.e(arrayList, "<this>");
        return arrayList.size();
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public void checkCapacity(ArrayList<Element> arrayList, int i8) {
        p.e(arrayList, "<this>");
        arrayList.ensureCapacity(i8);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public Iterator<Element> collectionIterator(Element[] elementArr) {
        p.e(elementArr, "<this>");
        return d0.c(elementArr);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public int collectionSize(Element[] elementArr) {
        p.e(elementArr, "<this>");
        return elementArr.length;
    }

    public void insert(ArrayList<Element> arrayList, int i8, Element element) {
        p.e(arrayList, "<this>");
        arrayList.add(i8, element);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public ArrayList<Element> toBuilder(Element[] elementArr) {
        p.e(elementArr, "<this>");
        return new ArrayList<>(l.S(elementArr));
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public Element[] toResult(ArrayList<Element> arrayList) {
        p.e(arrayList, "<this>");
        return (Element[]) PlatformKt.toNativeArrayImpl(arrayList, this.kClass);
    }
}
