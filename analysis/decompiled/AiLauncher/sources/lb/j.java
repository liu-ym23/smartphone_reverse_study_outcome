package lb;

import Z8.C1168p;
import Z8.C1173v;
import Z8.H;
import Z8.Q;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.y;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Encoder;
import mb.C4931a;
import nb.AbstractC4951d;
import nb.AbstractC4959l;
import nb.C4948a;
import nb.C4958k;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import pb.AbstractC5086b;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003BI\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0014\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00060\b\u0012\u0014\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\n0\b¢\u0006\u0004\b\f\u0010\rBY\b\u0011\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0014\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00060\b\u0012\u0014\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\n0\b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\b¢\u0006\u0004\b\f\u0010\u0010J)\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00142\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u001b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u001b\u0010*\u001a\u00020%8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R0\u0010-\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0006\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\n0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010,R(\u0010.\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\n0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010,¨\u0006/"}, d2 = {"Llb/j;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lpb/b;", "", "serialName", "Lw9/d;", "baseClass", "", "subclasses", "Lkotlinx/serialization/KSerializer;", "subclassSerializers", "<init>", "(Ljava/lang/String;Lw9/d;[Lw9/d;[Lkotlinx/serialization/KSerializer;)V", "", "classAnnotations", "(Ljava/lang/String;Lw9/d;[Lw9/d;[Lkotlinx/serialization/KSerializer;[Ljava/lang/annotation/Annotation;)V", "Lob/c;", "decoder", "klassName", "Llb/a;", Const.INTENT_KEY_UMID, "(Lob/c;Ljava/lang/String;)Llb/a;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "Llb/m;", "e", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)Llb/m;", Const.INTENT_KEY_APIKEY, "Lw9/d;", "f", "()Lw9/d;", "", Const.INTENT_KEY_PKGNAME, "Ljava/util/List;", "_annotations", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "c", "LY8/h;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "Ljava/util/Map;", "class2Serializer", "serialName2Serializer", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class j<T> extends AbstractC5086b<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5745d<T> baseClass;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public List<? extends Annotation> _annotations;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Y8.h descriptor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Map<InterfaceC5745d<? extends T>, KSerializer<? extends T>> class2Serializer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Map<String, KSerializer<? extends T>> serialName2Serializer;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u0015\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"lb/j$a", "LZ8/H;", "", Const.INTENT_KEY_PKGNAME, "()Ljava/util/Iterator;", "element", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements H<Map.Entry<? extends InterfaceC5745d<? extends T>, ? extends KSerializer<? extends T>>, String> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f37019a;

        public a(Iterable iterable) {
            this.f37019a = iterable;
        }

        @Override // Z8.H
        public String a(Map.Entry<? extends InterfaceC5745d<? extends T>, ? extends KSerializer<? extends T>> element) {
            return element.getValue().getDescriptor().getSerialName();
        }

        @Override // Z8.H
        public Iterator<Map.Entry<? extends InterfaceC5745d<? extends T>, ? extends KSerializer<? extends T>>> b() {
            return this.f37019a.iterator();
        }
    }

    public j(final String serialName, InterfaceC5745d<T> baseClass, InterfaceC5745d<? extends T>[] subclasses, KSerializer<? extends T>[] subclassSerializers) {
        kotlin.jvm.internal.p.i(serialName, "serialName");
        kotlin.jvm.internal.p.i(baseClass, "baseClass");
        kotlin.jvm.internal.p.i(subclasses, "subclasses");
        kotlin.jvm.internal.p.i(subclassSerializers, "subclassSerializers");
        this.baseClass = baseClass;
        this._annotations = C1173v.m();
        this.descriptor = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: lb.g
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return j.j(serialName, this);
            }
        });
        if (subclasses.length != subclassSerializers.length) {
            throw new IllegalArgumentException("All subclasses of sealed class " + f().t() + " should be marked @Serializable");
        }
        Map<InterfaceC5745d<? extends T>, KSerializer<? extends T>> mapY = kotlin.collections.a.y(Z8.r.m1(subclasses, subclassSerializers));
        this.class2Serializer = mapY;
        H aVar = new a(mapY.entrySet());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> itB = aVar.b();
        while (itB.hasNext()) {
            T next = itB.next();
            Object objA = aVar.a(next);
            Object obj = linkedHashMap.get(objA);
            if (obj == null) {
                linkedHashMap.containsKey(objA);
            }
            Map.Entry entry = (Map.Entry) next;
            Map.Entry entry2 = (Map.Entry) obj;
            String str = (String) objA;
            if (entry2 != null) {
                throw new IllegalStateException(("Multiple sealed subclasses of '" + f() + "' have the same serial name '" + str + "': '" + entry2.getKey() + "', '" + entry.getKey() + '\'').toString());
            }
            linkedHashMap.put(objA, entry);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(Q.e(linkedHashMap.size()));
        for (Map.Entry entry3 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry3.getKey(), (KSerializer) ((Map.Entry) entry3.getValue()).getValue());
        }
        this.serialName2Serializer = linkedHashMap2;
    }

    public static final SerialDescriptor j(String str, final j jVar) {
        return C4958k.g(str, AbstractC4951d.b.f37262a, new SerialDescriptor[0], new InterfaceC5074l() { // from class: lb.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return j.k(this.f37012a, (C4948a) obj);
            }
        });
    }

    public static final Y8.t k(final j jVar, C4948a buildSerialDescriptor) {
        kotlin.jvm.internal.p.i(buildSerialDescriptor, "$this$buildSerialDescriptor");
        C4948a.b(buildSerialDescriptor, "type", C4931a.H(y.f34840a).getDescriptor(), null, false, 12, null);
        C4948a.b(buildSerialDescriptor, UxipConstants.f30680s, C4958k.g("kotlinx.serialization.Sealed<" + jVar.f().t() + '>', AbstractC4959l.a.f37291a, new SerialDescriptor[0], new InterfaceC5074l() { // from class: lb.i
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return j.l(this.f37013a, (C4948a) obj);
            }
        }), null, false, 12, null);
        buildSerialDescriptor.h(jVar._annotations);
        return Y8.t.f7040a;
    }

    public static final Y8.t l(j jVar, C4948a buildSerialDescriptor) {
        kotlin.jvm.internal.p.i(buildSerialDescriptor, "$this$buildSerialDescriptor");
        for (Map.Entry<String, KSerializer<? extends T>> entry : jVar.serialName2Serializer.entrySet()) {
            C4948a.b(buildSerialDescriptor, entry.getKey(), entry.getValue().getDescriptor(), null, false, 12, null);
        }
        return Y8.t.f7040a;
    }

    @Override // pb.AbstractC5086b
    public InterfaceC4883a<T> d(ob.c decoder, String klassName) {
        kotlin.jvm.internal.p.i(decoder, "decoder");
        KSerializer<? extends T> kSerializer = this.serialName2Serializer.get(klassName);
        return kSerializer != null ? kSerializer : super.d(decoder, klassName);
    }

    @Override // pb.AbstractC5086b
    public m<T> e(Encoder encoder, T value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(value, "value");
        KSerializer<? extends T> kSerializer = this.class2Serializer.get(kotlin.jvm.internal.t.b(value.getClass()));
        KSerializer<? extends T> kSerializerE = kSerializer != null ? kSerializer : super.e(encoder, value);
        if (kSerializerE != null) {
            return kSerializerE;
        }
        return null;
    }

    @Override // pb.AbstractC5086b
    public InterfaceC5745d<T> f() {
        return this.baseClass;
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.descriptor.getValue();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(String serialName, InterfaceC5745d<T> baseClass, InterfaceC5745d<? extends T>[] subclasses, KSerializer<? extends T>[] subclassSerializers, Annotation[] classAnnotations) {
        this(serialName, baseClass, subclasses, subclassSerializers);
        kotlin.jvm.internal.p.i(serialName, "serialName");
        kotlin.jvm.internal.p.i(baseClass, "baseClass");
        kotlin.jvm.internal.p.i(subclasses, "subclasses");
        kotlin.jvm.internal.p.i(subclassSerializers, "subclassSerializers");
        kotlin.jvm.internal.p.i(classAnnotations, "classAnnotations");
        this._annotations = C1168p.d(classAnnotations);
    }
}
