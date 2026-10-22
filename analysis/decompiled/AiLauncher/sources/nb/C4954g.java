package nb;

import Z8.C1174w;
import Z8.F;
import Z8.IndexedValue;
import Z8.r;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.descriptors.SerialDescriptor;
import p9.InterfaceC5063a;
import pb.D0;
import pb.InterfaceC5110n;
import pb.K0;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0014\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\t2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0096\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0007H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0003H\u0016¢\u0006\u0004\b#\u0010$R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010$R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010,\u001a\u0004\b-\u0010\"R \u00101\u001a\b\u0012\u0004\u0012\u00020\u00150\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R \u00105\u001a\b\u0012\u0004\u0012\u00020\u0003028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u00103\u001a\u0004\b%\u00104R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u0003068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u00107R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u0001068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u00109R \u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\t068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010;R\u0014\u0010?\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010>R \u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020\u0001068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u00109R\u001b\u0010H\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bF\u0010\"¨\u0006I"}, d2 = {"Lnb/g;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lpb/n;", "", "serialName", "Lnb/l;", "kind", "", "elementsCount", "", "typeParameters", "Lnb/a;", "builder", "<init>", "(Ljava/lang/String;Lnb/l;ILjava/util/List;Lnb/a;)V", "index", "e", "(I)Ljava/lang/String;", "name", "c", "(Ljava/lang/String;)I", "", "f", "(I)Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(I)Lkotlinx/serialization/descriptors/SerialDescriptor;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(I)Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_PKGNAME, "Lnb/l;", "getKind", "()Lnb/l;", "I", Const.INTENT_KEY_UMID, "Ljava/util/List;", "getAnnotations", "()Ljava/util/List;", "annotations", "", "Ljava/util/Set;", "()Ljava/util/Set;", "serialNames", "", "[Ljava/lang/String;", "elementNames", "[Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementDescriptors", "[Ljava/util/List;", "elementAnnotations", "", "[Z", "elementOptionality", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Ljava/util/Map;", "name2Index", "k", "typeParametersDescriptors", "l", "LY8/h;", "_hashCode", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: nb.g, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4954g implements SerialDescriptor, InterfaceC5110n {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String serialName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final AbstractC4959l kind;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int elementsCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final List<Annotation> annotations;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Set<String> serialNames;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final String[] elementNames;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final SerialDescriptor[] elementDescriptors;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final List<Annotation>[] elementAnnotations;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final boolean[] elementOptionality;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final Map<String, Integer> name2Index;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final SerialDescriptor[] typeParametersDescriptors;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final Y8.h _hashCode;

    public C4954g(String serialName, AbstractC4959l kind, int i10, List<? extends SerialDescriptor> typeParameters, C4948a builder) {
        p.i(serialName, "serialName");
        p.i(kind, "kind");
        p.i(typeParameters, "typeParameters");
        p.i(builder, "builder");
        this.serialName = serialName;
        this.kind = kind;
        this.elementsCount = i10;
        this.annotations = builder.c();
        this.serialNames = F.k1(builder.f());
        String[] strArr = (String[]) builder.f().toArray(new String[0]);
        this.elementNames = strArr;
        this.elementDescriptors = D0.b(builder.e());
        this.elementAnnotations = (List[]) builder.d().toArray(new List[0]);
        this.elementOptionality = F.h1(builder.g());
        Iterable<IndexedValue> iterableJ1 = r.j1(strArr);
        ArrayList arrayList = new ArrayList(C1174w.x(iterableJ1, 10));
        for (IndexedValue indexedValue : iterableJ1) {
            arrayList.add(Y8.j.a(indexedValue.d(), Integer.valueOf(indexedValue.c())));
        }
        this.name2Index = kotlin.collections.a.y(arrayList);
        this.typeParametersDescriptors = D0.b(typeParameters);
        this._hashCode = C4848b.b(new InterfaceC5063a() { // from class: nb.f
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Integer.valueOf(C4954g.k(this.f37272a));
            }
        });
    }

    public static final int k(C4954g c4954g) {
        return K0.b(c4954g, c4954g.typeParametersDescriptors);
    }

    @Override // pb.InterfaceC5110n
    public Set<String> a() {
        return this.serialNames;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean b() {
        return super.b();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int c(String name) {
        p.i(name, "name");
        Integer num = this.name2Index.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    /* renamed from: d, reason: from getter */
    public int getElementsCount() {
        return this.elementsCount;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String e(int index) {
        return this.elementNames[index];
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof C4954g)) {
            return false;
        }
        SerialDescriptor serialDescriptor = (SerialDescriptor) other;
        if (!p.d(getSerialName(), serialDescriptor.getSerialName()) || !Arrays.equals(this.typeParametersDescriptors, ((C4954g) other).typeParametersDescriptors) || getElementsCount() != serialDescriptor.getElementsCount()) {
            return false;
        }
        int elementsCount = getElementsCount();
        for (int i10 = 0; i10 < elementsCount; i10++) {
            if (!p.d(g(i10).getSerialName(), serialDescriptor.g(i10).getSerialName()) || !p.d(g(i10).getKind(), serialDescriptor.g(i10).getKind())) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> f(int index) {
        return this.elementAnnotations[index];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor g(int index) {
        return this.elementDescriptors[index];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> getAnnotations() {
        return this.annotations;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public AbstractC4959l getKind() {
        return this.kind;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    /* renamed from: h, reason: from getter */
    public String getSerialName() {
        return this.serialName;
    }

    public int hashCode() {
        return l();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean i(int index) {
        return this.elementOptionality[index];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    /* renamed from: isInline */
    public boolean getIsInline() {
        return super.getIsInline();
    }

    public final int l() {
        return ((Number) this._hashCode.getValue()).intValue();
    }

    public String toString() {
        return K0.c(this);
    }
}
