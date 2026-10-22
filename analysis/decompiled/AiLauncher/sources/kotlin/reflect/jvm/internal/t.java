package kotlin.reflect.jvm.internal;

import E9.InterfaceC0797b;
import E9.InterfaceC0803h;
import E9.b0;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.A;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.u;
import o9.C5013a;
import w9.InterfaceC5745d;
import w9.InterfaceC5752k;
import w9.InterfaceC5755n;
import w9.InterfaceC5756o;
import wa.InterfaceC5793q;
import wa.InterfaceC5794r;
import ya.S;
import z9.C6423k;
import z9.InterfaceC6400X;
import z9.L0;
import z9.M0;
import z9.N0;
import z9.c1;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0015*\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u0019*\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR!\u0010&\u001a\b\u0012\u0004\u0012\u00020!0 8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001b\u0010\u0004\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010#\u001a\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0013R\u0014\u0010/\u001a\u00020,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00060"}, d2 = {"Lkotlin/reflect/jvm/internal/t;", "Lw9/o;", "Lz9/X;", "Lz9/N0;", "container", "LE9/b0;", "descriptor", "<init>", "(Lz9/N0;Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "LE9/b;", "Lkotlin/reflect/jvm/internal/e;", "o", "(LE9/b;)Lkotlin/reflect/jvm/internal/e;", "Lwa/r;", "Ljava/lang/Class;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lwa/r;)Ljava/lang/Class;", Const.INTENT_KEY_APIKEY, "LE9/b0;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;", "", "Lw9/n;", Const.INTENT_KEY_PKGNAME, "Lkotlin/reflect/jvm/internal/u$a;", "getUpperBounds", "()Ljava/util/List;", "upperBounds", "c", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Lz9/N0;", "getName", "name", "Lkotlin/reflect/KVariance;", "l", "()Lkotlin/reflect/KVariance;", "variance", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class t implements InterfaceC5756o, InterfaceC6400X {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC5752k<Object>[] f36160d = {kotlin.jvm.internal.t.i(new PropertyReference1Impl(t.class, "upperBounds", "getUpperBounds()Ljava/util/List;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(t.class, "container", "getContainer()Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", 0))};

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final b0 descriptor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final u.a upperBounds;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final u.a container;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36164a;

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
            f36164a = iArr;
        }
    }

    public t(N0 n02, b0 descriptor) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        this.descriptor = descriptor;
        this.upperBounds = u.c(new L0(this));
        this.container = u.c(new M0(n02, this));
    }

    public static final N0 e(N0 n02, t tVar) {
        e<?> eVarO;
        Object objV;
        if (n02 != null) {
            return n02;
        }
        InterfaceC0803h interfaceC0803hB = tVar.getDescriptor().b();
        kotlin.jvm.internal.p.h(interfaceC0803hB, "getContainingDeclaration(...)");
        if (interfaceC0803hB instanceof InterfaceC0797b) {
            objV = tVar.o((InterfaceC0797b) interfaceC0803hB);
        } else {
            if (!(interfaceC0803hB instanceof CallableMemberDescriptor)) {
                throw new KotlinReflectionInternalError("Unknown type parameter container: " + interfaceC0803hB);
            }
            InterfaceC0803h interfaceC0803hB2 = ((CallableMemberDescriptor) interfaceC0803hB).b();
            kotlin.jvm.internal.p.h(interfaceC0803hB2, "getContainingDeclaration(...)");
            if (interfaceC0803hB2 instanceof InterfaceC0797b) {
                eVarO = tVar.o((InterfaceC0797b) interfaceC0803hB2);
            } else {
                InterfaceC5794r interfaceC5794r = interfaceC0803hB instanceof InterfaceC5794r ? (InterfaceC5794r) interfaceC0803hB : null;
                if (interfaceC5794r == null) {
                    throw new KotlinReflectionInternalError("Non-class callable descriptor must be deserialized: " + interfaceC0803hB);
                }
                InterfaceC5745d interfaceC5745dE = C5013a.e(tVar.i(interfaceC5794r));
                kotlin.jvm.internal.p.g(interfaceC5745dE, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
                eVarO = (e) interfaceC5745dE;
            }
            objV = interfaceC0803hB.v(new C6423k(eVarO), Y8.t.f7040a);
        }
        return (N0) objV;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final List p(t tVar) {
        List<S> upperBounds = tVar.getDescriptor().getUpperBounds();
        kotlin.jvm.internal.p.h(upperBounds, "getUpperBounds(...)");
        List<S> list = upperBounds;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new s((S) it.next(), null, 2, 0 == true ? 1 : 0));
        }
        return arrayList;
    }

    public boolean equals(Object other) {
        if (!(other instanceof t)) {
            return false;
        }
        t tVar = (t) other;
        return kotlin.jvm.internal.p.d(g(), tVar.g()) && kotlin.jvm.internal.p.d(getName(), tVar.getName());
    }

    public final N0 g() {
        T tB = this.container.b(this, f36160d[1]);
        kotlin.jvm.internal.p.h(tB, "getValue(...)");
        return (N0) tB;
    }

    @Override // w9.InterfaceC5756o
    public String getName() {
        String strB = getDescriptor().getName().b();
        kotlin.jvm.internal.p.h(strB, "asString(...)");
        return strB;
    }

    @Override // w9.InterfaceC5756o
    public List<InterfaceC5755n> getUpperBounds() {
        T tB = this.upperBounds.b(this, f36160d[0]);
        kotlin.jvm.internal.p.h(tB, "getValue(...)");
        return (List) tB;
    }

    public int hashCode() {
        return (g().hashCode() * 31) + getName().hashCode();
    }

    public final Class<?> i(InterfaceC5794r interfaceC5794r) {
        Class<?> clsD;
        InterfaceC5793q interfaceC5793qG = interfaceC5794r.G();
        ba.l lVar = interfaceC5793qG instanceof ba.l ? (ba.l) interfaceC5793qG : null;
        Object objG = lVar != null ? lVar.g() : null;
        J9.f fVar = objG instanceof J9.f ? (J9.f) objG : null;
        if (fVar != null && (clsD = fVar.d()) != null) {
            return clsD;
        }
        throw new KotlinReflectionInternalError("Container of deserialized member is not resolved: " + interfaceC5794r);
    }

    @Override // w9.InterfaceC5756o
    /* renamed from: l */
    public KVariance getVariance() {
        int i10 = a.f36164a[getDescriptor().l().ordinal()];
        if (i10 == 1) {
            return KVariance.INVARIANT;
        }
        if (i10 == 2) {
            return KVariance.IN;
        }
        if (i10 == 3) {
            return KVariance.OUT;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // z9.InterfaceC6400X
    /* renamed from: m, reason: from getter */
    public b0 getDescriptor() {
        return this.descriptor;
    }

    public final e<?> o(InterfaceC0797b interfaceC0797b) {
        Class<?> clsR = c1.r(interfaceC0797b);
        e<?> eVar = (e) (clsR != null ? C5013a.e(clsR) : null);
        if (eVar != null) {
            return eVar;
        }
        throw new KotlinReflectionInternalError("Type parameter container is not resolved: " + interfaceC0797b.b());
    }

    public String toString() {
        return A.INSTANCE.a(this);
    }
}
