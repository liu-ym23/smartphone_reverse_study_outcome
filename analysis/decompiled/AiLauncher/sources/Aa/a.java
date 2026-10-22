package Aa;

import E9.C0810o;
import E9.InterfaceC0797b;
import E9.InterfaceC0819y;
import E9.W;
import H9.C0830i;
import H9.C0832k;
import Z8.C1173v;
import Z8.X;
import java.util.List;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import ra.InterfaceC5238k;
import ya.E0;

/* loaded from: classes5.dex */
public final class a extends C0832k {
    /* JADX WARN: Illegal instructions before constructor call */
    public a(ga.e name) {
        p.i(name, "name");
        i iVar = i.f1351a;
        InterfaceC0819y interfaceC0819yI = iVar.i();
        Modality modality = Modality.OPEN;
        ClassKind classKind = ClassKind.CLASS;
        List listM = C1173v.m();
        W w10 = W.f2444a;
        super(interfaceC0819yI, name, modality, classKind, listM, w10, false, LockBasedStorageManager.f36050e);
        C0830i c0830iH1 = C0830i.h1(this, F9.g.f2609m0.b(), true, w10);
        c0830iH1.k1(C1173v.m(), C0810o.f2473e);
        p.h(c0830iH1, "apply(...)");
        ErrorScopeKind errorScopeKind = ErrorScopeKind.SCOPE_FOR_ERROR_CLASS;
        String string = c0830iH1.getName().toString();
        p.h(string, "toString(...)");
        InterfaceC5238k interfaceC5238kB = i.b(errorScopeKind, string, "");
        ErrorTypeKind errorTypeKind = ErrorTypeKind.ERROR_CLASS;
        c0830iH1.a1(new g(iVar.e(errorTypeKind, new String[0]), interfaceC5238kB, errorTypeKind, null, false, new String[0], 24, null));
        E0(interfaceC5238kB, X.d(c0830iH1), c0830iH1);
    }

    @Override // H9.AbstractC0822a, E9.Y
    /* renamed from: A0 */
    public InterfaceC0797b c(TypeSubstitutor substitutor) {
        p.i(substitutor, "substitutor");
        return this;
    }

    @Override // H9.AbstractC0822a, H9.z
    public InterfaceC5238k T(E0 typeSubstitution, kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
        p.i(typeSubstitution, "typeSubstitution");
        p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        ErrorScopeKind errorScopeKind = ErrorScopeKind.SCOPE_FOR_ERROR_CLASS;
        String string = getName().toString();
        p.h(string, "toString(...)");
        return i.b(errorScopeKind, string, typeSubstitution.toString());
    }

    @Override // H9.C0832k
    public String toString() {
        String strB = getName().b();
        p.h(strB, "asString(...)");
        return strB;
    }
}
