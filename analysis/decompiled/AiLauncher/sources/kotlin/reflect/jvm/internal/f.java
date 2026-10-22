package kotlin.reflect.jvm.internal;

import A9.h;
import A9.m;
import E9.InterfaceC0803h;
import E9.i0;
import Z8.C1174w;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ka.C4829i;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.b;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller;
import kotlin.reflect.jvm.internal.u;
import p9.InterfaceC5063a;
import p9.InterfaceC5064b;
import p9.InterfaceC5065c;
import p9.InterfaceC5066d;
import p9.InterfaceC5067e;
import p9.InterfaceC5068f;
import p9.InterfaceC5069g;
import p9.InterfaceC5070h;
import p9.InterfaceC5071i;
import p9.InterfaceC5072j;
import p9.InterfaceC5073k;
import p9.InterfaceC5074l;
import p9.InterfaceC5075m;
import p9.InterfaceC5076n;
import p9.w;
import pa.C5078b;
import w9.InterfaceC5744c;
import w9.InterfaceC5748g;
import w9.InterfaceC5752k;
import ya.S;
import z9.C6410d0;
import z9.C6412e0;
import z9.C6414f0;
import z9.X0;
import z9.c1;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b&\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00032\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00042\u00020\u0002B7\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000eB\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u0010B+\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u0012J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b!\u0010 J5\u0010%\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\"0$2\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\"2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0017H\u0002¢\u0006\u0004\b%\u0010&J\u001a\u0010(\u001a\u00020\u00172\b\u0010'\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0007H\u0016¢\u0006\u0004\b-\u0010.R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001f\u0010?\u001a\u0006\u0012\u0002\b\u00030\u001b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R!\u0010B\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b@\u0010<\u001a\u0004\bA\u0010>R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0014\u0010G\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0014\u0010\b\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bH\u0010.R\u0014\u0010J\u001a\u00020*8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bI\u0010,R\u0014\u0010K\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bK\u0010FR\u0014\u0010L\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bL\u0010FR\u0014\u0010M\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bM\u0010FR\u0014\u0010N\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u0010FR\u0014\u0010O\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bO\u0010F¨\u0006P"}, d2 = {"Lkotlin/reflect/jvm/internal/f;", "Lkotlin/reflect/jvm/internal/d;", "", "Lw9/g;", "Lkotlin/jvm/internal/m;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "", "name", "signature", "Lkotlin/reflect/jvm/internal/impl/descriptors/e;", "descriptorInitialValue", "rawBoundReceiver", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Ljava/lang/Object;)V", "descriptor", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;)V", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "y0", "(Lkotlin/reflect/jvm/internal/impl/descriptors/e;)Lkotlin/reflect/jvm/internal/impl/descriptors/e;", "Ljava/lang/reflect/Method;", "member", "", "z0", "(Ljava/lang/reflect/Method;)Z", "isCallByToValueClassMangledMethod", "LA9/g;", "m0", "(Ljava/lang/reflect/Method;Z)LA9/g;", "LA9/h$h;", "l0", "(Ljava/lang/reflect/Method;)LA9/h$h;", "k0", "Ljava/lang/reflect/Constructor;", "isDefault", "LA9/h;", "j0", "(Ljava/lang/reflect/Constructor;Lkotlin/reflect/jvm/internal/impl/descriptors/e;Z)LA9/h;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "X", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Ljava/lang/Object;", "k", "Lkotlin/reflect/jvm/internal/u$a;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "l", "LY8/h;", ExifInterface.LONGITUDE_WEST, "()LA9/g;", "caller", "m", "Y", "defaultCaller", "w0", "()Ljava/lang/Object;", "d0", "()Z", "isBound", "getName", "getArity", "arity", "isInline", "isExternal", "isOperator", "isInfix", "isSuspend", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class f extends d<Object> implements kotlin.jvm.internal.m<Object>, InterfaceC5748g<Object>, InterfaceC5063a, InterfaceC5074l, InterfaceC5064b, InterfaceC5065c, InterfaceC5066d, InterfaceC5067e, InterfaceC5068f, InterfaceC5069g, InterfaceC5070h, InterfaceC5071i, InterfaceC5072j, InterfaceC5073k, p9.p, InterfaceC5075m, InterfaceC5076n, p9.o, p9.q, p9.r, p9.s, p9.t, p9.u, p9.v, w, InterfaceC5744c {

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC5752k<Object>[] f34935n = {kotlin.jvm.internal.t.i(new PropertyReference1Impl(f.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", 0))};

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final KDeclarationContainerImpl container;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final String signature;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final Object rawBoundReceiver;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final u.a descriptor;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final Y8.h caller;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final Y8.h defaultCaller;

    public f(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, Object obj) {
        this.container = kDeclarationContainerImpl;
        this.signature = str2;
        this.rawBoundReceiver = obj;
        this.descriptor = u.b(eVar, new C6410d0(this, str));
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this.caller = C4848b.a(lazyThreadSafetyMode, new C6412e0(this));
        this.defaultCaller = C4848b.a(lazyThreadSafetyMode, new C6414f0(this));
    }

    public static final A9.g i0(f fVar) throws NoSuchMethodException, SecurityException {
        Object objD;
        A9.g<?> gVarK0;
        b bVarG = v.f36168a.g(fVar.f0());
        if (bVarG instanceof b.d) {
            if (fVar.c0()) {
                Class<?> clsM = fVar.getContainer().m();
                List<KParameter> parameters = fVar.getParameters();
                ArrayList arrayList = new ArrayList(C1174w.x(parameters, 10));
                Iterator<T> it = parameters.iterator();
                while (it.hasNext()) {
                    String name = ((KParameter) it.next()).getName();
                    kotlin.jvm.internal.p.f(name);
                    arrayList.add(name);
                }
                return new AnnotationConstructorCaller(clsM, arrayList, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
            }
            objD = fVar.getContainer().x(((b.d) bVarG).b());
        } else if (bVarG instanceof b.e) {
            kotlin.reflect.jvm.internal.impl.descriptors.e eVarF0 = fVar.f0();
            InterfaceC0803h interfaceC0803hB = eVarF0.b();
            kotlin.jvm.internal.p.h(interfaceC0803hB, "getContainingDeclaration(...)");
            if (C4829i.d(interfaceC0803hB) && (eVarF0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.c) && ((kotlin.reflect.jvm.internal.impl.descriptors.c) eVarF0).X()) {
                kotlin.reflect.jvm.internal.impl.descriptors.e eVarF02 = fVar.f0();
                KDeclarationContainerImpl container = fVar.getContainer();
                String strB = ((b.e) bVarG).b();
                List<i0> listI = fVar.f0().i();
                kotlin.jvm.internal.p.h(listI, "getValueParameters(...)");
                return new m.b(eVarF02, container, strB, listI);
            }
            b.e eVar = (b.e) bVarG;
            objD = fVar.getContainer().C(eVar.c(), eVar.b());
        } else if (bVarG instanceof b.c) {
            objD = ((b.c) bVarG).getMethod();
            kotlin.jvm.internal.p.g(objD, "null cannot be cast to non-null type java.lang.reflect.Member");
        } else {
            if (!(bVarG instanceof b.C0433b)) {
                if (!(bVarG instanceof b.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                List<Method> listD = ((b.a) bVarG).d();
                Class<?> clsM2 = fVar.getContainer().m();
                List<Method> list = listD;
                ArrayList arrayList2 = new ArrayList(C1174w.x(list, 10));
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(((Method) it2.next()).getName());
                }
                return new AnnotationConstructorCaller(clsM2, arrayList2, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.JAVA, listD);
            }
            objD = ((b.C0433b) bVarG).d();
            kotlin.jvm.internal.p.g(objD, "null cannot be cast to non-null type java.lang.reflect.Member");
        }
        if (objD instanceof Constructor) {
            gVarK0 = fVar.j0((Constructor) objD, fVar.f0(), false);
        } else {
            if (!(objD instanceof Method)) {
                throw new KotlinReflectionInternalError("Could not compute caller for function: " + fVar.f0() + " (member = " + objD + ')');
            }
            Method method = (Method) objD;
            gVarK0 = !Modifier.isStatic(method.getModifiers()) ? fVar.k0(method) : fVar.f0().getAnnotations().d(c1.k()) != null ? fVar.l0(method) : fVar.m0(method, false);
        }
        return A9.n.j(gVarK0, fVar.f0(), false, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x017b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final A9.g u0(kotlin.reflect.jvm.internal.f r11) {
        /*
            Method dump skipped, instructions count: 407
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.f.u0(kotlin.reflect.jvm.internal.f):A9.g");
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.e v0(f fVar, String str) {
        return fVar.getContainer().A(str, fVar.signature);
    }

    private final Object w0() {
        return A9.n.h(this.rawBoundReceiver, f0());
    }

    @Override // kotlin.reflect.jvm.internal.d
    public A9.g<?> W() {
        return (A9.g) this.caller.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.d
    /* renamed from: X, reason: from getter */
    public KDeclarationContainerImpl getContainer() {
        return this.container;
    }

    @Override // kotlin.reflect.jvm.internal.d
    public A9.g<?> Y() {
        return (A9.g) this.defaultCaller.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.d
    public boolean d0() {
        return this.rawBoundReceiver != CallableReference.NO_RECEIVER;
    }

    public boolean equals(Object other) {
        f fVarC = c1.c(other);
        return fVarC != null && kotlin.jvm.internal.p.d(getContainer(), fVarC.getContainer()) && kotlin.jvm.internal.p.d(getName(), fVarC.getName()) && kotlin.jvm.internal.p.d(this.signature, fVarC.signature) && kotlin.jvm.internal.p.d(this.rawBoundReceiver, fVarC.rawBoundReceiver);
    }

    @Override // kotlin.jvm.internal.m
    public int getArity() {
        return A9.i.a(W());
    }

    @Override // w9.InterfaceC5744c
    public String getName() {
        String strB = f0().getName().b();
        kotlin.jvm.internal.p.h(strB, "asString(...)");
        return strB;
    }

    public int hashCode() {
        return (((getContainer().hashCode() * 31) + getName().hashCode()) * 31) + this.signature.hashCode();
    }

    @Override // p9.InterfaceC5063a
    public /* bridge */ Object invoke() {
        return n0();
    }

    @Override // w9.InterfaceC5748g
    public boolean isExternal() {
        return f0().isExternal();
    }

    @Override // w9.InterfaceC5748g
    public boolean isInfix() {
        return f0().isInfix();
    }

    @Override // w9.InterfaceC5748g
    public boolean isInline() {
        return f0().isInline();
    }

    @Override // w9.InterfaceC5748g
    public boolean isOperator() {
        return f0().isOperator();
    }

    @Override // w9.InterfaceC5744c
    public boolean isSuspend() {
        return f0().isSuspend();
    }

    public final A9.h<Constructor<?>> j0(Constructor<?> member, kotlin.reflect.jvm.internal.impl.descriptors.e descriptor, boolean isDefault) {
        return (isDefault || !C5078b.f(descriptor)) ? d0() ? new h.c(member, w0()) : new h.e(member) : d0() ? new h.a(member, w0()) : new h.b(member);
    }

    public final h.AbstractC0005h k0(Method member) {
        return d0() ? new h.AbstractC0005h.a(member, w0()) : new h.AbstractC0005h.e(member);
    }

    public final h.AbstractC0005h l0(Method member) {
        return d0() ? new h.AbstractC0005h.b(member) : new h.AbstractC0005h.f(member);
    }

    @Override // p9.t
    public /* bridge */ Object m(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return t0(obj, obj2, obj3, obj4, obj5, obj6);
    }

    public final A9.g<?> m0(Method member, boolean isCallByToValueClassMangledMethod) {
        if (d0()) {
            return new h.AbstractC0005h.c(member, isCallByToValueClassMangledMethod, z0(member) ? this.rawBoundReceiver : w0());
        }
        return new h.AbstractC0005h.g(member);
    }

    public Object n0() {
        return call(new Object[0]);
    }

    public Object o0(Object obj) {
        return call(obj);
    }

    public Object p0(Object obj, Object obj2) {
        return call(obj, obj2);
    }

    public Object q0(Object obj, Object obj2, Object obj3) {
        return call(obj, obj2, obj3);
    }

    public Object r0(Object obj, Object obj2, Object obj3, Object obj4) {
        return call(obj, obj2, obj3, obj4);
    }

    public Object s0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return call(obj, obj2, obj3, obj4, obj5);
    }

    public Object t0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return call(obj, obj2, obj3, obj4, obj5, obj6);
    }

    public String toString() {
        return X0.f45332a.q(this);
    }

    @Override // kotlin.reflect.jvm.internal.d
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.e f0() {
        T tB = this.descriptor.b(this, f34935n[0]);
        kotlin.jvm.internal.p.h(tB, "getValue(...)");
        return (kotlin.reflect.jvm.internal.impl.descriptors.e) tB;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlin.reflect.jvm.internal.impl.descriptors.e y0(kotlin.reflect.jvm.internal.impl.descriptors.e r5) {
        /*
            r4 = this;
            java.util.List r0 = r5.i()
            java.lang.String r1 = "getValueParameters(...)"
            kotlin.jvm.internal.p.h(r0, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r2 = r0 instanceof java.util.Collection
            r3 = 0
            if (r2 == 0) goto L1a
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L1a
            goto L32
        L1a:
            java.util.Iterator r0 = r0.iterator()
        L1e:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L32
            java.lang.Object r2 = r0.next()
            E9.i0 r2 = (E9.i0) r2
            boolean r2 = r2.v0()
            if (r2 == 0) goto L1e
            goto La2
        L32:
            E9.h r0 = r5.b()
            java.lang.String r2 = "getContainingDeclaration(...)"
            kotlin.jvm.internal.p.h(r0, r2)
            boolean r0 = ka.C4829i.g(r0)
            if (r0 == 0) goto La2
            A9.g r4 = r4.W()
            java.lang.reflect.Member r4 = r4.getMember()
            kotlin.jvm.internal.p.f(r4)
            int r4 = r4.getModifiers()
            boolean r4 = java.lang.reflect.Modifier.isStatic(r4)
            if (r4 == 0) goto La2
            r4 = 0
            Ka.j r4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.z(r5, r4)
            java.util.Iterator r4 = r4.iterator()
        L5f:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L9a
            java.lang.Object r5 = r4.next()
            r0 = r5
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r0
            java.util.List r0 = r0.i()
            kotlin.jvm.internal.p.h(r0, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r2 = r0 instanceof java.util.Collection
            if (r2 == 0) goto L83
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L83
            goto L5f
        L83:
            java.util.Iterator r0 = r0.iterator()
        L87:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L5f
            java.lang.Object r2 = r0.next()
            E9.i0 r2 = (E9.i0) r2
            boolean r2 = r2.v0()
            if (r2 == 0) goto L87
            goto L9b
        L9a:
            r5 = r3
        L9b:
            boolean r4 = r5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.e
            if (r4 == 0) goto La2
            kotlin.reflect.jvm.internal.impl.descriptors.e r5 = (kotlin.reflect.jvm.internal.impl.descriptors.e) r5
            return r5
        La2:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.f.y0(kotlin.reflect.jvm.internal.impl.descriptors.e):kotlin.reflect.jvm.internal.impl.descriptors.e");
    }

    public final boolean z0(Method member) {
        S type;
        E9.S sH = f0().H();
        if (sH == null || (type = sH.getType()) == null || !C4829i.c(type)) {
            return false;
        }
        Class<?>[] parameterTypes = member.getParameterTypes();
        kotlin.jvm.internal.p.h(parameterTypes, "getParameterTypes(...)");
        Class cls = (Class) Z8.r.Z(parameterTypes);
        return cls != null && cls.isInterface();
    }

    @Override // p9.InterfaceC5074l
    public /* bridge */ Object invoke(Object obj) {
        return o0(obj);
    }

    @Override // p9.p
    public /* bridge */ Object invoke(Object obj, Object obj2) {
        return p0(obj, obj2);
    }

    @Override // p9.q
    public /* bridge */ Object invoke(Object obj, Object obj2, Object obj3) {
        return q0(obj, obj2, obj3);
    }

    @Override // p9.r
    public /* bridge */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return r0(obj, obj2, obj3, obj4);
    }

    @Override // p9.s
    public /* bridge */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return s0(obj, obj2, obj3, obj4, obj5);
    }

    public /* synthetic */ f(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, Object obj, int i10, kotlin.jvm.internal.i iVar) {
        this(kDeclarationContainerImpl, str, str2, eVar, (i10 & 16) != 0 ? CallableReference.NO_RECEIVER : obj);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(KDeclarationContainerImpl container, String name, String signature, Object obj) {
        this(container, name, signature, null, obj);
        kotlin.jvm.internal.p.i(container, "container");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(signature, "signature");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public f(KDeclarationContainerImpl container, kotlin.reflect.jvm.internal.impl.descriptors.e descriptor) {
        kotlin.jvm.internal.p.i(container, "container");
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        String strB = descriptor.getName().b();
        kotlin.jvm.internal.p.h(strB, "asString(...)");
        this(container, strB, v.f36168a.g(descriptor).get_signature(), descriptor, null, 16, null);
    }
}
