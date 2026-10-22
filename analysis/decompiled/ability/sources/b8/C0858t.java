package b8;

import h8.InterfaceC1522e;
import h8.InterfaceC1526i;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl$MemberBelonginess;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader$Kind;
import m8.C1682b;

/* renamed from: b8.t, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0858t implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2055a;
    public final kotlin.reflect.jvm.internal.a b;

    public /* synthetic */ C0858t(kotlin.reflect.jvm.internal.a aVar, int i) {
        this.f2055a = i;
        this.b = aVar;
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [C7.f, java.lang.Object] */
    @Override // S7.a
    public final Object invoke() {
        int i = this.f2055a;
        kotlin.reflect.jvm.internal.a aVar = this.b;
        switch (i) {
            case 0:
                return new C0862x(aVar);
            case 1:
                int i6 = kotlin.reflect.jvm.internal.a.d;
                G8.b bVarW = aVar.w();
                Class cls = aVar.b;
                p0 p0Var = ((C0862x) aVar.c.getF4884a()).f2016a;
                Z7.t tVar = AbstractC0828A.b[0];
                Object objInvoke = p0Var.invoke();
                kotlin.jvm.internal.k.e(objInvoke, "getValue(...)");
                m8.e eVar = (m8.e) objInvoke;
                T8.k kVar = eVar.f5309a;
                InterfaceC1522e interfaceC1522eB = (bVarW.c && cls.isAnnotationPresent(Metadata.class)) ? kVar.b(bVarW) : kotlin.reflect.jvm.internal.impl.descriptors.a.a(kVar.b, bVarW);
                if (interfaceC1522eB != null) {
                    return interfaceC1522eB;
                }
                if (cls.isSynthetic()) {
                    return kotlin.reflect.jvm.internal.a.v(bVarW, eVar);
                }
                C1682b c1682bT = Z6.k.t(cls);
                KotlinClassHeader$Kind kotlinClassHeader$Kind = c1682bT != null ? (KotlinClassHeader$Kind) c1682bT.b.c : null;
                switch (kotlinClassHeader$Kind == null ? -1 : AbstractC0863y.f2064a[kotlinClassHeader$Kind.ordinal()]) {
                    case -1:
                    case 6:
                        throw new KotlinReflectionInternalError("Unresolved class: " + cls + " (kind = " + kotlinClassHeader$Kind + ')');
                    case 0:
                    default:
                        throw new NoWhenBranchMatchedException();
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        return kotlin.reflect.jvm.internal.a.v(bVarW, eVar);
                    case 5:
                        throw new KotlinReflectionInternalError("Unknown class: " + cls + " (kind = " + kotlinClassHeader$Kind + ')');
                }
            case 2:
                return aVar.n(aVar.x().g().w(), KDeclarationContainerImpl$MemberBelonginess.f4938a);
            case 3:
                Q8.o oVarH0 = aVar.x().h0();
                kotlin.jvm.internal.k.e(oVarH0, "getStaticScope(...)");
                return aVar.n(oVarH0, KDeclarationContainerImpl$MemberBelonginess.f4938a);
            case 4:
                return aVar.n(aVar.x().g().w(), KDeclarationContainerImpl$MemberBelonginess.b);
            case 5:
                Q8.o oVarH02 = aVar.x().h0();
                kotlin.jvm.internal.k.e(oVarH02, "getStaticScope(...)");
                return aVar.n(oVarH02, KDeclarationContainerImpl$MemberBelonginess.b);
            case 6:
                Class cls2 = aVar.b;
                if (cls2.isAnonymousClass()) {
                    return null;
                }
                G8.b bVarW2 = aVar.w();
                if (!bVarW2.c) {
                    String strB = bVarW2.f().b();
                    kotlin.jvm.internal.k.e(strB, "asString(...)");
                    return strB;
                }
                String simpleName = cls2.getSimpleName();
                Method enclosingMethod = cls2.getEnclosingMethod();
                if (enclosingMethod != null) {
                    return j9.m.H0(simpleName, enclosingMethod.getName() + '$', simpleName);
                }
                Constructor<?> enclosingConstructor = cls2.getEnclosingConstructor();
                if (enclosingConstructor == null) {
                    return j9.m.G0('$', simpleName, simpleName);
                }
                return j9.m.H0(simpleName, enclosingConstructor.getName() + '$', simpleName);
            case 7:
                if (aVar.b.isAnonymousClass()) {
                    return null;
                }
                G8.b bVarW3 = aVar.w();
                if (bVarW3.c) {
                    return null;
                }
                return bVarW3.a().b();
            default:
                Collection collectionG = aVar.g();
                ArrayList arrayList = new ArrayList(D7.w.c0(collectionG, 10));
                Iterator it = collectionG.iterator();
                while (it.hasNext()) {
                    arrayList.add(new C0832E(aVar, (InterfaceC1526i) it.next()));
                }
                return arrayList;
        }
    }

    public C0858t(kotlin.reflect.jvm.internal.a aVar, C0862x c0862x) {
        this.f2055a = 6;
        this.b = aVar;
    }
}
