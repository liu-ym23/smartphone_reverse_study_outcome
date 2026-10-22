package pb;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import nb.AbstractC4959l;
import nb.AbstractC4960m;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u0018\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0003\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0096\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0003H\u0016¢\u0006\u0004\b$\u0010%J\u001b\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070&H\u0002¢\u0006\u0004\b'\u0010(R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010%R\u001a\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001c\u0010.\u001a\u0004\b/\u0010#R\u0016\u00100\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010.R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\u0003018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u00102R\"\u00106\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0017\u0018\u000104018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u00105R\u001e\u00108\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u00107R\u0014\u0010;\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010:R\"\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010<R%\u0010C\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030>018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR!\u0010G\u001a\b\u0012\u0004\u0012\u00020\u0001018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\bD\u0010@\u001a\u0004\bE\u0010FR\u001b\u0010J\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010@\u001a\u0004\bI\u0010#R\u0014\u0010N\u001a\u00020K8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bL\u0010MR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00030R8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010S¨\u0006U"}, d2 = {"Lpb/I0;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lpb/n;", "", "serialName", "Lpb/M;", "generatedSerializer", "", "elementsCount", "<init>", "(Ljava/lang/String;Lpb/M;I)V", "name", "", "isOptional", "LY8/t;", "n", "(Ljava/lang/String;Z)V", "index", Const.INTENT_KEY_BACKGROUND_COMMAND, "(I)Lkotlinx/serialization/descriptors/SerialDescriptor;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(I)Z", "", "", "f", "(I)Ljava/util/List;", "e", "(I)Ljava/lang/String;", "c", "(Ljava/lang/String;)I", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", "", "p", "()Ljava/util/Map;", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_PKGNAME, "Lpb/M;", "I", Const.INTENT_KEY_UMID, "added", "", "[Ljava/lang/String;", "names", "", "[Ljava/util/List;", "propertiesAnnotations", "Ljava/util/List;", "classAnnotations", "", "[Z", "elementsOptionality", "Ljava/util/Map;", "indices", "Lkotlinx/serialization/KSerializer;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "LY8/h;", "r", "()[Lkotlinx/serialization/KSerializer;", "childSerializers", "k", "s", "()[Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeParameterDescriptors", "l", "t", "_hashCode", "Lnb/l;", "getKind", "()Lnb/l;", "kind", "getAnnotations", "()Ljava/util/List;", "annotations", "", "()Ljava/util/Set;", "serialNames", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public class I0 implements SerialDescriptor, InterfaceC5110n {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String serialName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final M<?> generatedSerializer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int elementsCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int added;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final String[] names;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final List<Annotation>[] propertiesAnnotations;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public List<Annotation> classAnnotations;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final boolean[] elementsOptionality;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public Map<String, Integer> indices;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final Y8.h childSerializers;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final Y8.h typeParameterDescriptors;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final Y8.h _hashCode;

    public I0(String serialName, M<?> m10, int i10) {
        kotlin.jvm.internal.p.i(serialName, "serialName");
        this.serialName = serialName;
        this.generatedSerializer = m10;
        this.elementsCount = i10;
        this.added = -1;
        String[] strArr = new String[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            strArr[i11] = "[UNINITIALIZED]";
        }
        this.names = strArr;
        int i12 = this.elementsCount;
        this.propertiesAnnotations = new List[i12];
        this.elementsOptionality = new boolean[i12];
        this.indices = kotlin.collections.a.i();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this.childSerializers = C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: pb.F0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return I0.q(this.f38276a);
            }
        });
        this.typeParameterDescriptors = C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: pb.G0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return I0.u(this.f38279a);
            }
        });
        this._hashCode = C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: pb.H0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Integer.valueOf(I0.m(this.f38283a));
            }
        });
    }

    public static final int m(I0 i02) {
        return K0.b(i02, i02.s());
    }

    public static /* synthetic */ void o(I0 i02, String str, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addElement");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        i02.n(str, z10);
    }

    public static final KSerializer[] q(I0 i02) {
        KSerializer<?>[] kSerializerArrChildSerializers;
        M<?> m10 = i02.generatedSerializer;
        return (m10 == null || (kSerializerArrChildSerializers = m10.childSerializers()) == null) ? L0.f38302a : kSerializerArrChildSerializers;
    }

    private final int t() {
        return ((Number) this._hashCode.getValue()).intValue();
    }

    public static final SerialDescriptor[] u(I0 i02) {
        ArrayList arrayList;
        KSerializer<?>[] kSerializerArrTypeParametersSerializers;
        M<?> m10 = i02.generatedSerializer;
        if (m10 == null || (kSerializerArrTypeParametersSerializers = m10.typeParametersSerializers()) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(kSerializerArrTypeParametersSerializers.length);
            for (KSerializer<?> kSerializer : kSerializerArrTypeParametersSerializers) {
                arrayList.add(kSerializer.getDescriptor());
            }
        }
        return D0.b(arrayList);
    }

    @Override // pb.InterfaceC5110n
    public Set<String> a() {
        return this.indices.keySet();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean b() {
        return super.b();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int c(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        Integer num = this.indices.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    /* renamed from: d, reason: from getter */
    public final int getElementsCount() {
        return this.elementsCount;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String e(int index) {
        return this.names[index];
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof I0)) {
            return false;
        }
        SerialDescriptor serialDescriptor = (SerialDescriptor) other;
        if (!kotlin.jvm.internal.p.d(getSerialName(), serialDescriptor.getSerialName()) || !Arrays.equals(s(), ((I0) other).s()) || getElementsCount() != serialDescriptor.getElementsCount()) {
            return false;
        }
        int elementsCount = getElementsCount();
        for (int i10 = 0; i10 < elementsCount; i10++) {
            if (!kotlin.jvm.internal.p.d(g(i10).getSerialName(), serialDescriptor.g(i10).getSerialName()) || !kotlin.jvm.internal.p.d(g(i10).getKind(), serialDescriptor.g(i10).getKind())) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> f(int index) {
        List<Annotation> list = this.propertiesAnnotations[index];
        return list == null ? C1173v.m() : list;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor g(int index) {
        return r()[index].getDescriptor();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> getAnnotations() {
        List<Annotation> list = this.classAnnotations;
        return list == null ? C1173v.m() : list;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public AbstractC4959l getKind() {
        return AbstractC4960m.a.f37293a;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    /* renamed from: h, reason: from getter */
    public String getSerialName() {
        return this.serialName;
    }

    public int hashCode() {
        return t();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean i(int index) {
        return this.elementsOptionality[index];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    /* renamed from: isInline */
    public boolean getIsInline() {
        return super.getIsInline();
    }

    public final void n(String name, boolean isOptional) {
        kotlin.jvm.internal.p.i(name, "name");
        String[] strArr = this.names;
        int i10 = this.added + 1;
        this.added = i10;
        strArr[i10] = name;
        this.elementsOptionality[i10] = isOptional;
        this.propertiesAnnotations[i10] = null;
        if (i10 == this.elementsCount - 1) {
            this.indices = p();
        }
    }

    public final Map<String, Integer> p() {
        HashMap map = new HashMap();
        int length = this.names.length;
        for (int i10 = 0; i10 < length; i10++) {
            map.put(this.names[i10], Integer.valueOf(i10));
        }
        return map;
    }

    public final KSerializer<?>[] r() {
        return (KSerializer[]) this.childSerializers.getValue();
    }

    public final SerialDescriptor[] s() {
        return (SerialDescriptor[]) this.typeParameterDescriptors.getValue();
    }

    public String toString() {
        return K0.c(this);
    }

    public /* synthetic */ I0(String str, M m10, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(str, (i11 & 2) != 0 ? null : m10, i10);
    }
}
