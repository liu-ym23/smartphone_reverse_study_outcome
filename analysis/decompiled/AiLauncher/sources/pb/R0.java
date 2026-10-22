package pb;

import Z8.C1168p;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.C4851b;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\n\b\u0001\u0010\u0003*\u0004\u0018\u00018\u00002*\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u00070\u0004B#\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011*\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u0007H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0016\u001a\u00020\u000e*\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u0007H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005*\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u0007H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u0007*\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010\u001e\u001a\u00020\u001d*\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u00072\u0006\u0010\u001c\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ3\u0010\"\u001a\u00020\u001d*\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u00072\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00028\u0001H\u0014¢\u0006\u0004\b\"\u0010#R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010+\u001a\u00020&8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lpb/R0;", "", "ElementKlass", "Element", "Lpb/v;", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lw9/d;", "kClass", "Lkotlinx/serialization/KSerializer;", "eSerializer", "<init>", "(Lw9/d;Lkotlinx/serialization/KSerializer;)V", "", "t", "([Ljava/lang/Object;)I", "", "s", "([Ljava/lang/Object;)Ljava/util/Iterator;", "p", "()Ljava/util/ArrayList;", "q", "(Ljava/util/ArrayList;)I", "w", "(Ljava/util/ArrayList;)[Ljava/lang/Object;", "v", "([Ljava/lang/Object;)Ljava/util/ArrayList;", ContentDisposition.Parameters.Size, "LY8/t;", "r", "(Ljava/util/ArrayList;I)V", "index", "element", "u", "(Ljava/util/ArrayList;ILjava/lang/Object;)V", Const.INTENT_KEY_PKGNAME, "Lw9/d;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "c", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class R0<ElementKlass, Element extends ElementKlass> extends AbstractC5125v<Element, Element[], ArrayList<Element>> {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5745d<ElementKlass> kClass;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final SerialDescriptor descriptor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public R0(InterfaceC5745d<ElementKlass> kClass, KSerializer<Element> eSerializer) {
        super(eSerializer, null);
        kotlin.jvm.internal.p.i(kClass, "kClass");
        kotlin.jvm.internal.p.i(eSerializer, "eSerializer");
        this.kClass = kClass;
        this.descriptor = new C5090d(eSerializer.getDescriptor());
    }

    @Override // pb.AbstractC5125v, kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // pb.AbstractC5084a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public ArrayList<Element> b() {
        return new ArrayList<>();
    }

    @Override // pb.AbstractC5084a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public int c(ArrayList<Element> arrayList) {
        kotlin.jvm.internal.p.i(arrayList, "<this>");
        return arrayList.size();
    }

    @Override // pb.AbstractC5084a
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void d(ArrayList<Element> arrayList, int i10) {
        kotlin.jvm.internal.p.i(arrayList, "<this>");
        arrayList.ensureCapacity(i10);
    }

    @Override // pb.AbstractC5084a
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public Iterator<Element> e(Element[] elementArr) {
        kotlin.jvm.internal.p.i(elementArr, "<this>");
        return C4851b.a(elementArr);
    }

    @Override // pb.AbstractC5084a
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public int f(Element[] elementArr) {
        kotlin.jvm.internal.p.i(elementArr, "<this>");
        return elementArr.length;
    }

    @Override // pb.AbstractC5125v
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void o(ArrayList<Element> arrayList, int i10, Element element) {
        kotlin.jvm.internal.p.i(arrayList, "<this>");
        arrayList.add(i10, element);
    }

    @Override // pb.AbstractC5084a
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public ArrayList<Element> l(Element[] elementArr) {
        kotlin.jvm.internal.p.i(elementArr, "<this>");
        return new ArrayList<>(C1168p.d(elementArr));
    }

    @Override // pb.AbstractC5084a
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public Element[] m(ArrayList<Element> arrayList) {
        kotlin.jvm.internal.p.i(arrayList, "<this>");
        return (Element[]) C0.q(arrayList, this.kClass);
    }
}
