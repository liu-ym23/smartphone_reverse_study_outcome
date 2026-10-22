package kotlinx.serialization.descriptors;

import b5.e;
import b5.g;
import b7.c;
import b8.h;
import c5.m;
import c5.o;
import c5.w;
import c5.x;
import c5.y;
import c5.z;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.ExtensionCallContract;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.internal.CachedNames;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptorKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u001b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B7\bF\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\bH\u0096\u0080\u0004J\u0012\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\u0004H\u0096\u0080\u0004J\u0018\u00103\u001a\b\u0012\u0004\u0012\u00020\u00160\n2\u0006\u00100\u001a\u00020\bH\u0096\u0080\u0004J\u0012\u00104\u001a\u00020\u00012\u0006\u00100\u001a\u00020\bH\u0096\u0080\u0004J\u0012\u00105\u001a\u0002062\u0006\u00100\u001a\u00020\bH\u0096\u0080\u0004J\u0014\u00107\u001a\u0002062\b\u00108\u001a\u0004\u0018\u000109H\u0096\u0082\u0004J\n\u0010:\u001a\u00020\bH\u0096\u0080\u0004J\n\u0010;\u001a\u00020\u0004H\u0096\u0080\u0004R\u0015\u0010\u0003\u001a\u00020\u0004X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0005\u001a\u00020\u0006X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0007\u001a\u00020\bX\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\nX\u0096\u0084\b¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001cX\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040 X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010!R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010 X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010#R\u001d\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\n0 X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010%R\u000f\u0010&\u001a\u00020'X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u001b\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0)X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010 X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010#R\u001b\u0010+\u001a\u00020\b8BX\u0082\u0084\n¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b,\u0010\u0014¨\u0006<"}, d2 = {"Lkotlinx/serialization/descriptors/SerialDescriptorImpl;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/internal/CachedNames;", "serialName", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ExtensionCallContract.KIND, "Lkotlinx/serialization/descriptors/SerialKind;", "elementsCount", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "typeParameters", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "builder", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialKind;ILjava/util/List;Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;)V", "getSerialName", "()Ljava/lang/String;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "getElementsCount", "()I", "annotations", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getAnnotations$annotations", "()V", "getAnnotations", "()Ljava/util/List;", "serialNames", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getSerialNames", "()Ljava/util/Set;", "elementNames", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "[Ljava/lang/String;", "elementDescriptors", "[Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementAnnotations", "[Ljava/util/List;", "elementOptionality", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "name2Index", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "typeParametersDescriptors", "_hashCode", "get_hashCode", "_hashCode$delegate", "Lkotlin/Lazy;", "getElementName", "index", "getElementIndex", "name", "getElementAnnotations", "getElementDescriptor", "isElementOptional", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "equals", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "hashCode", "toString", "kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SerialDescriptorImpl implements SerialDescriptor, CachedNames {
    private final e _hashCode$delegate;
    private final List<Annotation> annotations;
    private final List<Annotation>[] elementAnnotations;
    private final SerialDescriptor[] elementDescriptors;
    private final String[] elementNames;
    private final boolean[] elementOptionality;
    private final int elementsCount;
    private final SerialKind kind;
    private final Map<String, Integer> name2Index;
    private final String serialName;
    private final Set<String> serialNames;
    private final SerialDescriptor[] typeParametersDescriptors;

    public SerialDescriptorImpl(String serialName, SerialKind kind, int i8, List<? extends SerialDescriptor> typeParameters, ClassSerialDescriptorBuilder builder) {
        p.e(serialName, "serialName");
        p.e(kind, "kind");
        p.e(typeParameters, "typeParameters");
        p.e(builder, "builder");
        this.serialName = serialName;
        this.kind = kind;
        this.elementsCount = i8;
        this.annotations = builder.getAnnotations();
        List<String> elementNames$kotlinx_serialization_core = builder.getElementNames$kotlinx_serialization_core();
        p.e(elementNames$kotlinx_serialization_core, "<this>");
        HashSet hashSet = new HashSet(z.T(o.n0(elementNames$kotlinx_serialization_core, 12)));
        m.M0(elementNames$kotlinx_serialization_core, hashSet);
        this.serialNames = hashSet;
        int i9 = 0;
        this.elementNames = (String[]) builder.getElementNames$kotlinx_serialization_core().toArray(new String[0]);
        this.elementDescriptors = Platform_commonKt.compactArray(builder.getElementDescriptors$kotlinx_serialization_core());
        this.elementAnnotations = (List[]) builder.getElementAnnotations$kotlinx_serialization_core().toArray(new List[0]);
        List<Boolean> elementOptionality$kotlinx_serialization_core = builder.getElementOptionality$kotlinx_serialization_core();
        p.e(elementOptionality$kotlinx_serialization_core, "<this>");
        boolean[] zArr = new boolean[elementOptionality$kotlinx_serialization_core.size()];
        Iterator<Boolean> it = elementOptionality$kotlinx_serialization_core.iterator();
        while (it.hasNext()) {
            zArr[i9] = it.next().booleanValue();
            i9++;
        }
        this.elementOptionality = zArr;
        String[] strArr = this.elementNames;
        p.e(strArr, "<this>");
        x xVar = new x(0, new c(4, strArr));
        ArrayList arrayList = new ArrayList(o.n0(xVar, 10));
        Iterator it2 = xVar.iterator();
        while (true) {
            y yVar = (y) it2;
            if (!yVar.f1100b.hasNext()) {
                this.name2Index = z.V(arrayList);
                this.typeParametersDescriptors = Platform_commonKt.compactArray(typeParameters);
                this._hashCode$delegate = h.x(new c(16, this));
                return;
            }
            w wVar = (w) yVar.next();
            arrayList.add(new g(wVar.f1096b, Integer.valueOf(wVar.f1095a)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int _hashCode_delegate$lambda$0(SerialDescriptorImpl serialDescriptorImpl) {
        return PluginGeneratedSerialDescriptorKt.hashCodeImpl(serialDescriptorImpl, serialDescriptorImpl.typeParametersDescriptors);
    }

    private final int get_hashCode() {
        return ((Number) this._hashCode$delegate.getValue()).intValue();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SerialDescriptorImpl)) {
            return false;
        }
        SerialDescriptor serialDescriptor = (SerialDescriptor) other;
        if (!p.a(getSerialName(), serialDescriptor.getSerialName()) || !Arrays.equals(this.typeParametersDescriptors, ((SerialDescriptorImpl) other).typeParametersDescriptors) || getElementsCount() != serialDescriptor.getElementsCount()) {
            return false;
        }
        int elementsCount = getElementsCount();
        for (int i8 = 0; i8 < elementsCount; i8++) {
            if (!p.a(getElementDescriptor(i8).getSerialName(), serialDescriptor.getElementDescriptor(i8).getSerialName()) || !p.a(getElementDescriptor(i8).getKind(), serialDescriptor.getElementDescriptor(i8).getKind())) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> getAnnotations() {
        return this.annotations;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> getElementAnnotations(int index) {
        return this.elementAnnotations[index];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor getElementDescriptor(int index) {
        return this.elementDescriptors[index];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementIndex(String name) {
        p.e(name, "name");
        Integer num = this.name2Index.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String getElementName(int index) {
        return this.elementNames[index];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementsCount() {
        return this.elementsCount;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialKind getKind() {
        return this.kind;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String getSerialName() {
        return this.serialName;
    }

    @Override // kotlinx.serialization.internal.CachedNames
    public Set<String> getSerialNames() {
        return this.serialNames;
    }

    public int hashCode() {
        return get_hashCode();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isElementOptional(int index) {
        return this.elementOptionality[index];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    /* renamed from: isInline */
    public /* bridge */ boolean getIsInline() {
        return super.getIsInline();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public /* bridge */ boolean isNullable() {
        return super.isNullable();
    }

    public String toString() {
        return PluginGeneratedSerialDescriptorKt.toStringImpl(this);
    }

    public static /* synthetic */ void getAnnotations$annotations() {
    }
}
