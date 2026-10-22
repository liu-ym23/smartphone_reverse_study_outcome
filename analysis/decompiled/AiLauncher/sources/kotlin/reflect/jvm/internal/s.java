package kotlin.reflect.jvm.internal;

import E9.D;
import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.b0;
import K9.C0925f;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.u;
import o9.C5013a;
import p9.InterfaceC5063a;
import w9.C5757p;
import w9.InterfaceC5746e;
import w9.InterfaceC5752k;
import w9.InterfaceC5755n;
import ya.AbstractC5974I;
import ya.AbstractC5990d0;
import ya.B0;
import ya.C5998h0;
import ya.S;
import z9.AbstractC6403a;
import z9.G0;
import z9.H0;
import z9.I0;
import z9.J0;
import z9.K0;
import z9.X0;
import z9.c1;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\u000bJ\u0019\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001d\u0010'\u001a\u0004\u0018\u00010\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b%\u0010$\u001a\u0004\b#\u0010&R!\u0010-\u001a\b\u0012\u0004\u0012\u00020)0(8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b*\u0010$\u001a\u0004\b+\u0010,R\u0016\u00100\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u00102\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u00101R\u0016\u00106\u001a\u0004\u0018\u0001038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u00108\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00101R\u0014\u0010:\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u00101R\u0014\u0010<\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u00101¨\u0006>²\u0006\u0012\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00050(8\nX\u008a\u0084\u0002"}, d2 = {"Lkotlin/reflect/jvm/internal/s;", "Lz9/a;", "Lya/S;", "type", "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "computeJavaType", "", "isAbbreviation", "<init>", "(Lorg/jetbrains/kotlin/types/KotlinType;Lp9/a;Z)V", "(Lorg/jetbrains/kotlin/types/KotlinType;Lp9/a;)V", "Lw9/e;", ExifInterface.LONGITUDE_EAST, "(Lya/S;)Lw9/e;", "r", "()Lz9/a;", "s", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Lya/S;", "getType", "()Lorg/jetbrains/kotlin/types/KotlinType;", Const.INTENT_KEY_PKGNAME, "Z", "Lkotlin/reflect/jvm/internal/u$a;", "c", "Lkotlin/reflect/jvm/internal/u$a;", Const.INTENT_KEY_UMID, "()Lw9/e;", "classifier", "", "Lw9/p;", "e", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/util/List;", "arguments", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ljava/lang/reflect/Type;", "javaType", "()Z", "isMarkedNullable", "Lw9/n;", "l", "()Lw9/n;", "abbreviation", "m", "isDefinitelyNotNullType", "p", "isNothingType", "o", "isMutableCollectionType", "parameterizedTypeArguments", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class s extends AbstractC6403a {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC5752k<Object>[] f36153f = {kotlin.jvm.internal.t.i(new PropertyReference1Impl(s.class, "classifier", "getClassifier()Lkotlin/reflect/KClassifier;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(s.class, "arguments", "getArguments()Ljava/util/List;", 0))};

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final S type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean isAbbreviation;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final u.a<Type> computeJavaType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final u.a classifier;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final u.a arguments;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36159a;

        static {
            int[] iArr = new int[Variance.values().length];
            try {
                iArr[Variance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Variance.IN_VARIANCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Variance.OUT_VARIANCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f36159a = iArr;
        }
    }

    public s(S type, InterfaceC5063a<? extends Type> interfaceC5063a, boolean z10) {
        kotlin.jvm.internal.p.i(type, "type");
        this.type = type;
        this.isAbbreviation = z10;
        u.a<Type> aVarC = null;
        u.a<Type> aVar = interfaceC5063a instanceof u.a ? (u.a) interfaceC5063a : null;
        if (aVar != null) {
            aVarC = aVar;
        } else if (interfaceC5063a != null) {
            aVarC = u.c(interfaceC5063a);
        }
        this.computeJavaType = aVarC;
        this.classifier = u.c(new H0(this));
        this.arguments = u.c(new I0(this, interfaceC5063a));
    }

    public static final List A(s sVar) {
        Type typeI = sVar.i();
        kotlin.jvm.internal.p.f(typeI);
        return C0925f.h(typeI);
    }

    public static final List<Type> B(Y8.h<? extends List<? extends Type>> hVar) {
        return (List) hVar.getValue();
    }

    public static final Type C(s sVar, int i10, Y8.h<? extends List<? extends Type>> hVar) {
        Type typeI = sVar.i();
        if (typeI instanceof Class) {
            Class cls = (Class) typeI;
            Class componentType = cls.isArray() ? cls.getComponentType() : Object.class;
            kotlin.jvm.internal.p.f(componentType);
            return componentType;
        }
        if (typeI instanceof GenericArrayType) {
            if (i10 == 0) {
                Type genericComponentType = ((GenericArrayType) typeI).getGenericComponentType();
                kotlin.jvm.internal.p.f(genericComponentType);
                return genericComponentType;
            }
            throw new KotlinReflectionInternalError("Array type has been queried for a non-0th argument: " + sVar);
        }
        if (!(typeI instanceof ParameterizedType)) {
            throw new KotlinReflectionInternalError("Non-generic type has been queried for arguments: " + sVar);
        }
        Type type = B(hVar).get(i10);
        if (!(type instanceof WildcardType)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        Type[] lowerBounds = wildcardType.getLowerBounds();
        kotlin.jvm.internal.p.h(lowerBounds, "getLowerBounds(...)");
        Type type2 = (Type) Z8.r.Z(lowerBounds);
        if (type2 == null) {
            Type[] upperBounds = wildcardType.getUpperBounds();
            kotlin.jvm.internal.p.h(upperBounds, "getUpperBounds(...)");
            type2 = (Type) Z8.r.X(upperBounds);
        }
        kotlin.jvm.internal.p.f(type2);
        return type2;
    }

    public static final InterfaceC5746e D(s sVar) {
        return sVar.E(sVar.type);
    }

    public static final List z(s sVar, InterfaceC5063a interfaceC5063a) {
        C5757p c5757pD;
        List<B0> listF0 = sVar.type.F0();
        if (listF0.isEmpty()) {
            return C1173v.m();
        }
        Y8.h hVarA = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new J0(sVar));
        List<B0> list = listF0;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        int i10 = 0;
        for (Object obj : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            B0 b02 = (B0) obj;
            if (b02.b()) {
                c5757pD = C5757p.INSTANCE.c();
            } else {
                S type = b02.getType();
                kotlin.jvm.internal.p.h(type, "getType(...)");
                s sVar2 = new s(type, interfaceC5063a == null ? null : new K0(sVar, i10, hVarA));
                int i12 = a.f36159a[b02.c().ordinal()];
                if (i12 == 1) {
                    c5757pD = C5757p.INSTANCE.d(sVar2);
                } else if (i12 == 2) {
                    c5757pD = C5757p.INSTANCE.a(sVar2);
                } else {
                    if (i12 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    c5757pD = C5757p.INSTANCE.b(sVar2);
                }
            }
            arrayList.add(c5757pD);
            i10 = i11;
        }
        return arrayList;
    }

    public final InterfaceC5746e E(S type) {
        S type2;
        if (this.isAbbreviation) {
            InterfaceC0799d interfaceC0799dD = type.H0().d();
            D.b bVar = interfaceC0799dD instanceof D.b ? (D.b) interfaceC0799dD : null;
            if (bVar != null) {
                return new G0(DescriptorUtilsKt.o(bVar));
            }
        }
        InterfaceC0799d interfaceC0799dD2 = type.H0().d();
        if (!(interfaceC0799dD2 instanceof InterfaceC0797b)) {
            if (interfaceC0799dD2 instanceof b0) {
                return new t(null, (b0) interfaceC0799dD2);
            }
            return null;
        }
        Class<?> clsR = c1.r((InterfaceC0797b) interfaceC0799dD2);
        if (clsR == null) {
            return null;
        }
        if (!C9.j.d0(type)) {
            if (ya.H0.l(type)) {
                return new e(clsR);
            }
            Class<?> clsI = C0925f.i(clsR);
            if (clsI != null) {
                clsR = clsI;
            }
            return new e(clsR);
        }
        B0 b02 = (B0) F.Z0(type.F0());
        if (b02 == null || (type2 = b02.getType()) == null) {
            return new e(clsR);
        }
        InterfaceC5746e interfaceC5746eE = E(Da.d.B(type2));
        if (interfaceC5746eE != null) {
            return new e(c1.f(C5013a.b(y9.c.a(interfaceC5746eE))));
        }
        throw new KotlinReflectionInternalError("Cannot determine classifier for array element type: " + this);
    }

    /* renamed from: F, reason: from getter */
    public final S getType() {
        return this.type;
    }

    @Override // w9.InterfaceC5755n
    public InterfaceC5746e c() {
        return (InterfaceC5746e) this.classifier.b(this, f36153f[0]);
    }

    @Override // w9.InterfaceC5755n
    public boolean e() {
        return this.type.I0();
    }

    public boolean equals(Object other) {
        if (!(other instanceof s)) {
            return false;
        }
        s sVar = (s) other;
        return kotlin.jvm.internal.p.d(this.type, sVar.type) && kotlin.jvm.internal.p.d(c(), sVar.c()) && kotlin.jvm.internal.p.d(g(), sVar.g());
    }

    @Override // w9.InterfaceC5755n
    public List<C5757p> g() {
        T tB = this.arguments.b(this, f36153f[1]);
        kotlin.jvm.internal.p.h(tB, "getValue(...)");
        return (List) tB;
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        InterfaceC5746e interfaceC5746eC = c();
        return ((iHashCode + (interfaceC5746eC != null ? interfaceC5746eC.hashCode() : 0)) * 31) + g().hashCode();
    }

    @Override // kotlin.jvm.internal.q
    public Type i() {
        u.a<Type> aVar = this.computeJavaType;
        if (aVar != null) {
            return aVar.invoke();
        }
        return null;
    }

    @Override // z9.AbstractC6403a
    public InterfaceC5755n l() {
        AbstractC5990d0 abstractC5990d0B = C5998h0.b(this.type);
        if (abstractC5990d0B != null) {
            return new s(abstractC5990d0B, this.computeJavaType, true);
        }
        return null;
    }

    @Override // z9.AbstractC6403a
    public boolean m() {
        return C5998h0.c(this.type);
    }

    @Override // z9.AbstractC6403a
    public boolean o() {
        InterfaceC0799d interfaceC0799dD = this.type.H0().d();
        InterfaceC0797b interfaceC0797b = interfaceC0799dD instanceof InterfaceC0797b ? (InterfaceC0797b) interfaceC0799dD : null;
        return interfaceC0797b != null && D9.b.f2290a.c(interfaceC0797b);
    }

    @Override // z9.AbstractC6403a
    public boolean p() {
        return C9.j.p0(this.type);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // z9.AbstractC6403a
    public AbstractC6403a r() {
        ya.K0 K02 = this.type.K0();
        InterfaceC5063a interfaceC5063a = null;
        Object[] objArr = 0;
        if (K02 instanceof AbstractC5974I) {
            return new s(((AbstractC5974I) K02).P0(), interfaceC5063a, 2, objArr == true ? 1 : 0);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // z9.AbstractC6403a
    public AbstractC6403a s() {
        ya.K0 K02 = this.type.K0();
        InterfaceC5063a interfaceC5063a = null;
        Object[] objArr = 0;
        if (K02 instanceof AbstractC5974I) {
            return new s(((AbstractC5974I) K02).Q0(), interfaceC5063a, 2, objArr == true ? 1 : 0);
        }
        return null;
    }

    public String toString() {
        return X0.f45332a.y(this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public s(S type, InterfaceC5063a<? extends Type> interfaceC5063a) {
        this(type, interfaceC5063a, false);
        kotlin.jvm.internal.p.i(type, "type");
    }

    public /* synthetic */ s(S s10, InterfaceC5063a interfaceC5063a, int i10, kotlin.jvm.internal.i iVar) {
        this(s10, (i10 & 2) != 0 ? null : interfaceC5063a);
    }
}
