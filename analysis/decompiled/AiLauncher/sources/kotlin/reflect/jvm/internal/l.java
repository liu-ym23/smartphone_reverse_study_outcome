package kotlin.reflect.jvm.internal;

import A9.m;
import E9.InterfaceC0797b;
import E9.InterfaceC0803h;
import E9.M;
import E9.S;
import E9.i0;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.u;
import p9.InterfaceC5063a;
import v9.C5680i;
import w9.InterfaceC5752k;
import w9.InterfaceC5755n;
import z9.C6438r0;
import z9.C6440s0;
import z9.X0;
import z9.c1;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001cB1\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u001a\u001a\u00020\u00182\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u0017\"\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001b\u0010+\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R!\u00101\u001a\b\u0012\u0004\u0012\u00020-0,8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b.\u0010(\u001a\u0004\b/\u00100R\u0016\u00103\u001a\u0004\u0018\u00010\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0016R\u0014\u00107\u001a\u0002048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u0014\u0010:\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u0014\u0010;\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u00109¨\u0006<"}, d2 = {"Lkotlin/reflect/jvm/internal/l;", "Lkotlin/reflect/KParameter;", "Lkotlin/reflect/jvm/internal/d;", "callable", "", "index", "Lkotlin/reflect/KParameter$Kind;", "kind", "Lkotlin/Function0;", "LE9/M;", "computeDescriptor", "<init>", "(Lkotlin/reflect/jvm/internal/d;ILkotlin/reflect/KParameter$Kind;Lp9/a;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "Ljava/lang/reflect/Type;", "types", "r", "([Ljava/lang/reflect/Type;)Ljava/lang/reflect/Type;", Const.INTENT_KEY_APIKEY, "Lkotlin/reflect/jvm/internal/d;", "s", "()Lkotlin/reflect/jvm/internal/d;", Const.INTENT_KEY_PKGNAME, "I", "getIndex", "c", "Lkotlin/reflect/KParameter$Kind;", "getKind", "()Lkotlin/reflect/KParameter$Kind;", Const.INTENT_KEY_UMID, "Lkotlin/reflect/jvm/internal/u$a;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", "descriptor", "", "", "e", "getAnnotations", "()Ljava/util/List;", "annotations", "getName", "name", "Lw9/n;", "getType", "()Lw9/n;", "type", "v", "()Z", "isOptional", "isVararg", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class l implements KParameter {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC5752k<Object>[] f36120f = {kotlin.jvm.internal.t.i(new PropertyReference1Impl(l.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(l.class, "annotations", "getAnnotations()Ljava/util/List;", 0))};

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final d<?> callable;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int index;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final KParameter.Kind kind;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final u.a descriptor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final u.a annotations;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\bR\u001f\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lkotlin/reflect/jvm/internal/l$a;", "Ljava/lang/reflect/Type;", "", "types", "<init>", "([Ljava/lang/reflect/Type;)V", "", "getTypeName", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", Const.INTENT_KEY_APIKEY, "[Ljava/lang/reflect/Type;", "getTypes", "()[Ljava/lang/reflect/Type;", Const.INTENT_KEY_PKGNAME, "I", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements Type {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Type[] types;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final int hashCode;

        public a(Type[] types) {
            kotlin.jvm.internal.p.i(types, "types");
            this.types = types;
            this.hashCode = Arrays.hashCode(types);
        }

        public boolean equals(Object other) {
            return (other instanceof a) && Arrays.equals(this.types, ((a) other).types);
        }

        @Override // java.lang.reflect.Type
        public String getTypeName() {
            return Z8.r.w0(this.types, ", ", "[", "]", 0, null, null, 56, null);
        }

        /* renamed from: hashCode, reason: from getter */
        public int getHashCode() {
            return this.hashCode;
        }

        public String toString() {
            return getTypeName();
        }
    }

    public l(d<?> callable, int i10, KParameter.Kind kind, InterfaceC5063a<? extends M> computeDescriptor) {
        kotlin.jvm.internal.p.i(callable, "callable");
        kotlin.jvm.internal.p.i(kind, "kind");
        kotlin.jvm.internal.p.i(computeDescriptor, "computeDescriptor");
        this.callable = callable;
        this.index = i10;
        this.kind = kind;
        this.descriptor = u.c(computeDescriptor);
        this.annotations = u.c(new C6438r0(this));
    }

    public static final Type l(l lVar) {
        List listA1;
        M mU = lVar.u();
        if ((mU instanceof S) && kotlin.jvm.internal.p.d(c1.j(lVar.callable.f0()), mU) && lVar.callable.f0().getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            InterfaceC0803h interfaceC0803hB = lVar.callable.f0().b();
            kotlin.jvm.internal.p.g(interfaceC0803hB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            Class<?> clsR = c1.r((InterfaceC0797b) interfaceC0803hB);
            if (clsR != null) {
                return clsR;
            }
            throw new KotlinReflectionInternalError("Cannot determine receiver Java type of inherited declaration: " + mU);
        }
        A9.g<?> gVarW = lVar.callable.W();
        if (!(gVarW instanceof A9.m)) {
            if (!(gVarW instanceof m.b)) {
                return gVarW.a().get(lVar.getIndex());
            }
            Class[] clsArr = (Class[]) ((m.b) gVarW).e().get(lVar.getIndex()).toArray(new Class[0]);
            return lVar.r((Type[]) Arrays.copyOf(clsArr, clsArr.length));
        }
        if (lVar.callable.d0()) {
            A9.m mVar = (A9.m) gVarW;
            C5680i c5680iE = mVar.e(lVar.getIndex() + 1);
            int last = mVar.e(0).getLast() + 1;
            listA1 = F.a1(mVar.a(), new C5680i(c5680iE.getFirst() - last, c5680iE.getLast() - last));
        } else {
            A9.m mVar2 = (A9.m) gVarW;
            listA1 = F.a1(mVar2.a(), mVar2.e(lVar.getIndex()));
        }
        Type[] typeArr = (Type[]) listA1.toArray(new Type[0]);
        return lVar.r((Type[]) Arrays.copyOf(typeArr, typeArr.length));
    }

    public static final List p(l lVar) {
        return c1.e(lVar.u());
    }

    @Override // kotlin.reflect.KParameter
    public boolean a() {
        M mU = u();
        return (mU instanceof i0) && ((i0) mU).p0() != null;
    }

    public boolean equals(Object other) {
        if (!(other instanceof l)) {
            return false;
        }
        l lVar = (l) other;
        return kotlin.jvm.internal.p.d(this.callable, lVar.callable) && getIndex() == lVar.getIndex();
    }

    @Override // kotlin.reflect.KParameter
    public int getIndex() {
        return this.index;
    }

    @Override // kotlin.reflect.KParameter
    public KParameter.Kind getKind() {
        return this.kind;
    }

    @Override // kotlin.reflect.KParameter
    public String getName() {
        M mU = u();
        i0 i0Var = mU instanceof i0 ? (i0) mU : null;
        if (i0Var == null || i0Var.b().b0()) {
            return null;
        }
        ga.e name = i0Var.getName();
        kotlin.jvm.internal.p.h(name, "getName(...)");
        if (name.k()) {
            return null;
        }
        return name.b();
    }

    @Override // kotlin.reflect.KParameter
    public InterfaceC5755n getType() {
        ya.S type = u().getType();
        kotlin.jvm.internal.p.h(type, "getType(...)");
        return new s(type, new C6440s0(this));
    }

    public int hashCode() {
        return (this.callable.hashCode() * 31) + Integer.hashCode(getIndex());
    }

    public final Type r(Type... types) {
        int length = types.length;
        if (length != 0) {
            return length != 1 ? new a(types) : (Type) Z8.r.E0(types);
        }
        throw new KotlinReflectionNotSupportedError("Expected at least 1 type for compound type");
    }

    public final d<?> s() {
        return this.callable;
    }

    public String toString() {
        return X0.f45332a.v(this);
    }

    public final M u() {
        T tB = this.descriptor.b(this, f36120f[0]);
        kotlin.jvm.internal.p.h(tB, "getValue(...)");
        return (M) tB;
    }

    @Override // kotlin.reflect.KParameter
    public boolean v() {
        M mU = u();
        i0 i0Var = mU instanceof i0 ? (i0) mU : null;
        if (i0Var != null) {
            return DescriptorUtilsKt.f(i0Var);
        }
        return false;
    }
}
