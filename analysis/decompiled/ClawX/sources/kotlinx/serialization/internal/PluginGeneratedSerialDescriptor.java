package kotlinx.serialization.internal;

import b5.e;
import b5.f;
import b8.h;
import c5.s;
import c5.t;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.ExtensionCallContract;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B)\bF\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001c\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00042\b\b\u0002\u00108\u001a\u000209H\u0086\u0080\u0004J\u0012\u0010:\u001a\u0002062\u0006\u0010;\u001a\u00020\u0015H\u0086\u0080\u0004J\u0012\u0010<\u001a\u0002062\u0006\u0010=\u001a\u00020\u0015H\u0086\u0080\u0004J\u0012\u0010>\u001a\u00020\u00012\u0006\u0010?\u001a\u00020\bH\u0096\u0080\u0004J\u0012\u0010@\u001a\u0002092\u0006\u0010?\u001a\u00020\bH\u0096\u0080\u0004J\u0018\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010?\u001a\u00020\bH\u0096\u0080\u0004J\u0012\u0010B\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\bH\u0096\u0080\u0004J\u0012\u0010C\u001a\u00020\b2\u0006\u00107\u001a\u00020\u0004H\u0096\u0080\u0004J\u0016\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0'H\u0082\u0080\u0004J\u0014\u0010E\u001a\u0002092\b\u0010F\u001a\u0004\u0018\u00010GH\u0096\u0082\u0004J\n\u0010H\u001a\u00020\bH\u0096\u0080\u0004J\n\u0010I\u001a\u00020\u0004H\u0096\u0080\u0004R\u0015\u0010\u0003\u001a\u00020\u0004X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0007\u001a\u00020\bX\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u000f\u001a\u00020\u00108VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000f\u0010\u0018\u001a\u00020\bX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u001aX\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\u001bR\u001f\u0010\u001c\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001d0\u001aX\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\u001eR\u0017\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001dX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010 \u001a\u00020!X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040#8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001b\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0'X\u0082\u008e\b¢\u0006\u0002\n\u0000R%\u0010(\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030)0\u001a8BX\u0082\u0084\n¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b*\u0010+R!\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a8@X\u0080\u0084\n¢\u0006\f\n\u0004\b1\u0010-\u001a\u0004\b/\u00100R\u001b\u00102\u001a\u00020\b8BX\u0082\u0084\n¢\u0006\f\n\u0004\b4\u0010-\u001a\u0004\b3\u0010\u000e¨\u0006J"}, d2 = {"Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/internal/CachedNames;", "serialName", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "generatedSerializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "elementsCount", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;Lkotlinx/serialization/internal/GeneratedSerializer;I)V", "getSerialName", "()Ljava/lang/String;", "getElementsCount", "()I", ExtensionCallContract.KIND, "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "annotations", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getAnnotations", "()Ljava/util/List;", "added", "names", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "[Ljava/lang/String;", "propertiesAnnotations", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "[Ljava/util/List;", "classAnnotations", "elementsOptionality", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "serialNames", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getSerialNames", "()Ljava/util/Set;", "indices", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "childSerializers", "Lkotlinx/serialization/KSerializer;", "getChildSerializers", "()[Lkotlinx/serialization/KSerializer;", "childSerializers$delegate", "Lkotlin/Lazy;", "typeParameterDescriptors", "getTypeParameterDescriptors$kotlinx_serialization_core", "()[Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeParameterDescriptors$delegate", "_hashCode", "get_hashCode", "_hashCode$delegate", "addElement", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "name", "isOptional", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "pushAnnotation", "annotation", "pushClassAnnotation", "a", "getElementDescriptor", "index", "isElementOptional", "getElementAnnotations", "getElementName", "getElementIndex", "buildIndices", "equals", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "hashCode", "toString", "kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public class PluginGeneratedSerialDescriptor implements SerialDescriptor, CachedNames {
    private final e _hashCode$delegate;
    private int added;
    private final e childSerializers$delegate;
    private List<Annotation> classAnnotations;
    private final int elementsCount;
    private final boolean[] elementsOptionality;
    private final GeneratedSerializer<?> generatedSerializer;
    private Map<String, Integer> indices;
    private final String[] names;
    private final List<Annotation>[] propertiesAnnotations;
    private final String serialName;
    private final e typeParameterDescriptors$delegate;

    public PluginGeneratedSerialDescriptor(String serialName, GeneratedSerializer<?> generatedSerializer, int i8) {
        p.e(serialName, "serialName");
        this.serialName = serialName;
        this.generatedSerializer = generatedSerializer;
        this.elementsCount = i8;
        this.added = -1;
        String[] strArr = new String[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            strArr[i9] = "[UNINITIALIZED]";
        }
        this.names = strArr;
        int i10 = this.elementsCount;
        this.propertiesAnnotations = new List[i10];
        this.elementsOptionality = new boolean[i10];
        this.indices = t.f1093a;
        f fVar = f.f889a;
        final int i11 = 0;
        this.childSerializers$delegate = h.w(fVar, new p5.a(this) { // from class: kotlinx.serialization.internal.b

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PluginGeneratedSerialDescriptor f3702b;

            {
                this.f3702b = this;
            }

            @Override // p5.a
            public final Object invoke() {
                int i12 = i11;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = this.f3702b;
                switch (i12) {
                    case 0:
                        return PluginGeneratedSerialDescriptor.childSerializers_delegate$lambda$0(pluginGeneratedSerialDescriptor);
                    case 1:
                        return PluginGeneratedSerialDescriptor.typeParameterDescriptors_delegate$lambda$0(pluginGeneratedSerialDescriptor);
                    default:
                        return Integer.valueOf(PluginGeneratedSerialDescriptor._hashCode_delegate$lambda$0(pluginGeneratedSerialDescriptor));
                }
            }
        });
        final int i12 = 1;
        this.typeParameterDescriptors$delegate = h.w(fVar, new p5.a(this) { // from class: kotlinx.serialization.internal.b

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PluginGeneratedSerialDescriptor f3702b;

            {
                this.f3702b = this;
            }

            @Override // p5.a
            public final Object invoke() {
                int i122 = i12;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = this.f3702b;
                switch (i122) {
                    case 0:
                        return PluginGeneratedSerialDescriptor.childSerializers_delegate$lambda$0(pluginGeneratedSerialDescriptor);
                    case 1:
                        return PluginGeneratedSerialDescriptor.typeParameterDescriptors_delegate$lambda$0(pluginGeneratedSerialDescriptor);
                    default:
                        return Integer.valueOf(PluginGeneratedSerialDescriptor._hashCode_delegate$lambda$0(pluginGeneratedSerialDescriptor));
                }
            }
        });
        final int i13 = 2;
        this._hashCode$delegate = h.w(fVar, new p5.a(this) { // from class: kotlinx.serialization.internal.b

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PluginGeneratedSerialDescriptor f3702b;

            {
                this.f3702b = this;
            }

            @Override // p5.a
            public final Object invoke() {
                int i122 = i13;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = this.f3702b;
                switch (i122) {
                    case 0:
                        return PluginGeneratedSerialDescriptor.childSerializers_delegate$lambda$0(pluginGeneratedSerialDescriptor);
                    case 1:
                        return PluginGeneratedSerialDescriptor.typeParameterDescriptors_delegate$lambda$0(pluginGeneratedSerialDescriptor);
                    default:
                        return Integer.valueOf(PluginGeneratedSerialDescriptor._hashCode_delegate$lambda$0(pluginGeneratedSerialDescriptor));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int _hashCode_delegate$lambda$0(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        return PluginGeneratedSerialDescriptorKt.hashCodeImpl(pluginGeneratedSerialDescriptor, pluginGeneratedSerialDescriptor.getTypeParameterDescriptors$kotlinx_serialization_core());
    }

    public static /* synthetic */ void addElement$default(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor, String str, boolean z, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addElement");
        }
        if ((i8 & 2) != 0) {
            z = false;
        }
        pluginGeneratedSerialDescriptor.addElement(str, z);
    }

    private final Map<String, Integer> buildIndices() {
        HashMap map = new HashMap();
        int length = this.names.length;
        for (int i8 = 0; i8 < length; i8++) {
            map.put(this.names[i8], Integer.valueOf(i8));
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KSerializer[] childSerializers_delegate$lambda$0(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        KSerializer<?>[] kSerializerArrChildSerializers;
        GeneratedSerializer<?> generatedSerializer = pluginGeneratedSerialDescriptor.generatedSerializer;
        return (generatedSerializer == null || (kSerializerArrChildSerializers = generatedSerializer.childSerializers()) == null) ? PluginHelperInterfacesKt.EMPTY_SERIALIZER_ARRAY : kSerializerArrChildSerializers;
    }

    private final KSerializer<?>[] getChildSerializers() {
        return (KSerializer[]) this.childSerializers$delegate.getValue();
    }

    private final int get_hashCode() {
        return ((Number) this._hashCode$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerialDescriptor[] typeParameterDescriptors_delegate$lambda$0(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        ArrayList arrayList;
        KSerializer<?>[] kSerializerArrTypeParametersSerializers;
        GeneratedSerializer<?> generatedSerializer = pluginGeneratedSerialDescriptor.generatedSerializer;
        if (generatedSerializer == null || (kSerializerArrTypeParametersSerializers = generatedSerializer.typeParametersSerializers()) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(kSerializerArrTypeParametersSerializers.length);
            for (KSerializer<?> kSerializer : kSerializerArrTypeParametersSerializers) {
                arrayList.add(kSerializer.getDescriptor());
            }
        }
        return Platform_commonKt.compactArray(arrayList);
    }

    public final void addElement(String name, boolean isOptional) {
        p.e(name, "name");
        String[] strArr = this.names;
        int i8 = this.added + 1;
        this.added = i8;
        strArr[i8] = name;
        this.elementsOptionality[i8] = isOptional;
        this.propertiesAnnotations[i8] = null;
        if (i8 == this.elementsCount - 1) {
            this.indices = buildIndices();
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PluginGeneratedSerialDescriptor)) {
            return false;
        }
        SerialDescriptor serialDescriptor = (SerialDescriptor) other;
        if (!p.a(getSerialName(), serialDescriptor.getSerialName()) || !Arrays.equals(getTypeParameterDescriptors$kotlinx_serialization_core(), ((PluginGeneratedSerialDescriptor) other).getTypeParameterDescriptors$kotlinx_serialization_core()) || getElementsCount() != serialDescriptor.getElementsCount()) {
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
        List<Annotation> list = this.classAnnotations;
        return list == null ? s.f1092a : list;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> getElementAnnotations(int index) {
        List<Annotation> list = this.propertiesAnnotations[index];
        return list == null ? s.f1092a : list;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor getElementDescriptor(int index) {
        return getChildSerializers()[index].getDescriptor();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementIndex(String name) {
        p.e(name, "name");
        Integer num = this.indices.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String getElementName(int index) {
        return this.names[index];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int getElementsCount() {
        return this.elementsCount;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialKind getKind() {
        return StructureKind.CLASS.INSTANCE;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String getSerialName() {
        return this.serialName;
    }

    @Override // kotlinx.serialization.internal.CachedNames
    public Set<String> getSerialNames() {
        return this.indices.keySet();
    }

    public final SerialDescriptor[] getTypeParameterDescriptors$kotlinx_serialization_core() {
        return (SerialDescriptor[]) this.typeParameterDescriptors$delegate.getValue();
    }

    public int hashCode() {
        return get_hashCode();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isElementOptional(int index) {
        return this.elementsOptionality[index];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public /* bridge */ boolean isInline() {
        return super.isInline();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public /* bridge */ boolean isNullable() {
        return super.isNullable();
    }

    public final void pushAnnotation(Annotation annotation) {
        p.e(annotation, "annotation");
        List<Annotation> arrayList = this.propertiesAnnotations[this.added];
        if (arrayList == null) {
            arrayList = new ArrayList<>(1);
            this.propertiesAnnotations[this.added] = arrayList;
        }
        arrayList.add(annotation);
    }

    public final void pushClassAnnotation(Annotation a9) {
        p.e(a9, "a");
        if (this.classAnnotations == null) {
            this.classAnnotations = new ArrayList(1);
        }
        List<Annotation> list = this.classAnnotations;
        p.b(list);
        list.add(a9);
    }

    public String toString() {
        return PluginGeneratedSerialDescriptorKt.toStringImpl(this);
    }

    public /* synthetic */ PluginGeneratedSerialDescriptor(String str, GeneratedSerializer generatedSerializer, int i8, int i9, i iVar) {
        this(str, (i9 & 2) != 0 ? null : generatedSerializer, i8);
    }
}
