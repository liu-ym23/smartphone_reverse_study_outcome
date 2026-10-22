package kotlin.reflect.jvm.internal;

import E9.O;
import K9.C0925f;
import La.D;
import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonPointer;
import ea.C4019c;
import fa.C4068e;
import fa.C4071h;
import java.util.Collection;
import java.util.List;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.u;
import ra.InterfaceC5238k;
import ua.C5601K;
import w9.InterfaceC5744c;
import w9.InterfaceC5752k;
import z9.C6424k0;
import z9.C6426l0;
import z9.C6428m0;
import z9.C6430n0;
import z9.C6432o0;
import z9.C6434p0;
import z9.C6436q0;
import z9.c1;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u00012B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010$\u001a\f\u0012\b\u0012\u00060!R\u00020\u00000 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010&\u001a\u0006\u0012\u0002\b\u00030\u00028TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001fR\u001e\u0010*\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030'0\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020+0\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010)R\u0014\u00101\u001a\u00020.8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00063"}, d2 = {"Lkotlin/reflect/jvm/internal/k;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Ljava/lang/Class;", "jClass", "<init>", "(Ljava/lang/Class;)V", "Lga/e;", "name", "", "LE9/O;", "M", "(Lga/e;)Ljava/util/Collection;", "Lkotlin/reflect/jvm/internal/impl/descriptors/e;", "I", "", "index", "J", "(I)LE9/O;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_UMID, "Ljava/lang/Class;", "m", "()Ljava/lang/Class;", "LY8/h;", "Lkotlin/reflect/jvm/internal/k$a;", "e", "LY8/h;", "data", "L", "methodOwner", "Lw9/c;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/Collection;", "members", "Lkotlin/reflect/jvm/internal/impl/descriptors/c;", "H", "constructorDescriptors", "Lra/k;", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "scope", Const.INTENT_KEY_APIKEY, "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class k extends KDeclarationContainerImpl {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Class<?> jClass;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Y8.h<a> data;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u001d\u0010\n\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\u000eR!\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R/\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u001cR%\u0010#\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001f0\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0007\u001a\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lkotlin/reflect/jvm/internal/k$a;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$b;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "<init>", "(Lkotlin/reflect/jvm/internal/k;)V", "LJ9/f;", Const.INTENT_KEY_UMID, "Lkotlin/reflect/jvm/internal/u$a;", "getKotlinClass", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;", "kotlinClass", "Lra/k;", "e", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "scope", "Ljava/lang/Class;", "f", "LY8/h;", "l", "()Ljava/lang/Class;", "multifileFacade", "Lkotlin/Triple;", "Lfa/e;", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package;", "Lea/c;", Const.INTENT_KEY_BACKGROUND_COMMAND, "k", "()Lkotlin/Triple;", "metadata", "", "Lkotlin/reflect/jvm/internal/d;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Ljava/util/Collection;", "members", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class a extends KDeclarationContainerImpl.b {

        /* renamed from: j, reason: collision with root package name */
        public static final /* synthetic */ InterfaceC5752k<Object>[] f36113j = {kotlin.jvm.internal.t.i(new PropertyReference1Impl(a.class, "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(a.class, "scope", "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(a.class, "members", "getMembers()Ljava/util/Collection;", 0))};

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final u.a kotlinClass;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final u.a scope;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public final Y8.h multifileFacade;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public final Y8.h metadata;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        public final u.a members;

        public a() {
            super();
            this.kotlinClass = u.c(new C6428m0(k.this));
            this.scope = u.c(new C6430n0(this));
            LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
            this.multifileFacade = C4848b.a(lazyThreadSafetyMode, new C6432o0(this, k.this));
            this.metadata = C4848b.a(lazyThreadSafetyMode, new C6434p0(this));
            this.members = u.c(new C6436q0(k.this, this));
        }

        public static final J9.f n(k kVar) {
            return J9.f.f3793c.a(kVar.m());
        }

        public static final Collection o(k kVar, a aVar) {
            return kVar.K(aVar.m(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
        }

        public static final Triple p(a aVar) {
            KotlinClassHeader kotlinClassHeaderB;
            J9.f fVarI = aVar.i();
            if (fVarI != null && (kotlinClassHeaderB = fVarI.b()) != null) {
                String[] strArrA = kotlinClassHeaderB.a();
                String[] strArrG = kotlinClassHeaderB.g();
                if (strArrA != null && strArrG != null) {
                    Pair<C4068e, ProtoBuf$Package> pairM = C4071h.m(strArrA, strArrG);
                    return new Triple(pairM.a(), pairM.b(), kotlinClassHeaderB.d());
                }
            }
            return null;
        }

        public static final Class q(a aVar, k kVar) {
            KotlinClassHeader kotlinClassHeaderB;
            J9.f fVarI = aVar.i();
            String strE = (fVarI == null || (kotlinClassHeaderB = fVarI.b()) == null) ? null : kotlinClassHeaderB.e();
            if (strE == null || strE.length() <= 0) {
                return null;
            }
            return kVar.m().getClassLoader().loadClass(D.S(strE, JsonPointer.SEPARATOR, '.', false, 4, null));
        }

        public static final InterfaceC5238k r(a aVar) {
            J9.f fVarI = aVar.i();
            return fVarI != null ? aVar.b().c().a(fVarI) : InterfaceC5238k.b.f38898b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final J9.f i() {
            return (J9.f) this.kotlinClass.b(this, f36113j[0]);
        }

        public final Collection<d<?>> j() {
            T tB = this.members.b(this, f36113j[2]);
            kotlin.jvm.internal.p.h(tB, "getValue(...)");
            return (Collection) tB;
        }

        public final Triple<C4068e, ProtoBuf$Package, C4019c> k() {
            return (Triple) this.metadata.getValue();
        }

        public final Class<?> l() {
            return (Class) this.multifileFacade.getValue();
        }

        public final InterfaceC5238k m() {
            T tB = this.scope.b(this, f36113j[1]);
            kotlin.jvm.internal.p.h(tB, "getValue(...)");
            return (InterfaceC5238k) tB;
        }
    }

    public k(Class<?> jClass) {
        kotlin.jvm.internal.p.i(jClass, "jClass");
        this.jClass = jClass;
        this.data = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new C6424k0(this));
    }

    public static final a U(k kVar) {
        return kVar.new a();
    }

    public static final O V(C5601K deserializeToDescriptor, ProtoBuf$Property proto) {
        kotlin.jvm.internal.p.i(deserializeToDescriptor, "$this$deserializeToDescriptor");
        kotlin.jvm.internal.p.i(proto, "proto");
        return deserializeToDescriptor.x(proto, true);
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> H() {
        return C1173v.m();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.e> I(ga.e name) {
        kotlin.jvm.internal.p.i(name, "name");
        return W().c(name, NoLookupLocation.FROM_REFLECTION);
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public O J(int index) {
        Triple<C4068e, ProtoBuf$Package, C4019c> tripleK = this.data.getValue().k();
        if (tripleK != null) {
            C4068e c4068eA = tripleK.a();
            ProtoBuf$Package protoBuf$PackageB = tripleK.b();
            C4019c c4019cC = tripleK.c();
            GeneratedMessageLite.e<ProtoBuf$Package, List<ProtoBuf$Property>> packageLocalVariable = JvmProtoBuf.f35751n;
            kotlin.jvm.internal.p.h(packageLocalVariable, "packageLocalVariable");
            ProtoBuf$Property protoBuf$Property = (ProtoBuf$Property) ea.f.b(protoBuf$PackageB, packageLocalVariable, index);
            if (protoBuf$Property != null) {
                Class<?> clsM = m();
                ProtoBuf$TypeTable protoBuf$TypeTableV = protoBuf$PackageB.V();
                kotlin.jvm.internal.p.h(protoBuf$TypeTableV, "getTypeTable(...)");
                return (O) c1.h(clsM, protoBuf$Property, c4068eA, new ea.h(protoBuf$TypeTableV), c4019cC, C6426l0.f45368a);
            }
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Class<?> L() {
        Class<?> clsL = this.data.getValue().l();
        return clsL == null ? m() : clsL;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<O> M(ga.e name) {
        kotlin.jvm.internal.p.i(name, "name");
        return W().a(name, NoLookupLocation.FROM_REFLECTION);
    }

    public final InterfaceC5238k W() {
        return this.data.getValue().m();
    }

    @Override // w9.InterfaceC5747f
    public Collection<InterfaceC5744c<?>> b() {
        return this.data.getValue().j();
    }

    public boolean equals(Object other) {
        return (other instanceof k) && kotlin.jvm.internal.p.d(m(), ((k) other).m());
    }

    public int hashCode() {
        return m().hashCode();
    }

    @Override // kotlin.jvm.internal.f
    public Class<?> m() {
        return this.jClass;
    }

    public String toString() {
        return "file class " + C0925f.e(m()).a();
    }
}
