package ya;

import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import xa.InterfaceC5869l;

/* renamed from: ya.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5985b extends AbstractC6009o {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC5985b(InterfaceC5869l interfaceC5869l) {
        super(interfaceC5869l);
        if (interfaceC5869l == null) {
            I(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ void I(int r9) {
        /*
            r0 = 4
            r1 = 3
            r2 = 1
            if (r9 == r2) goto Lc
            if (r9 == r1) goto Lc
            if (r9 == r0) goto Lc
            java.lang.String r3 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto Le
        Lc:
            java.lang.String r3 = "@NotNull method %s.%s must not return null"
        Le:
            r4 = 2
            if (r9 == r2) goto L17
            if (r9 == r1) goto L17
            if (r9 == r0) goto L17
            r5 = r1
            goto L18
        L17:
            r5 = r4
        L18:
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor"
            r7 = 0
            if (r9 == r2) goto L2f
            if (r9 == r4) goto L2a
            if (r9 == r1) goto L2f
            if (r9 == r0) goto L2f
            java.lang.String r8 = "storageManager"
            r5[r7] = r8
            goto L31
        L2a:
            java.lang.String r8 = "classifier"
            r5[r7] = r8
            goto L31
        L2f:
            r5[r7] = r6
        L31:
            if (r9 == r2) goto L3f
            if (r9 == r1) goto L3a
            if (r9 == r0) goto L3a
            r5[r2] = r6
            goto L43
        L3a:
            java.lang.String r6 = "getAdditionalNeighboursInSupertypeGraph"
            r5[r2] = r6
            goto L43
        L3f:
            java.lang.String r6 = "getBuiltIns"
            r5[r2] = r6
        L43:
            if (r9 == r2) goto L54
            if (r9 == r4) goto L50
            if (r9 == r1) goto L54
            if (r9 == r0) goto L54
            java.lang.String r6 = "<init>"
            r5[r4] = r6
            goto L54
        L50:
            java.lang.String r6 = "isSameClassifier"
            r5[r4] = r6
        L54:
            java.lang.String r3 = java.lang.String.format(r3, r5)
            if (r9 == r2) goto L64
            if (r9 == r1) goto L64
            if (r9 == r0) goto L64
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r3)
            goto L69
        L64:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>(r3)
        L69:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ya.AbstractC5985b.I(int):void");
    }

    /* renamed from: J */
    public abstract InterfaceC0797b d();

    @Override // ya.v0
    public C9.j g() {
        C9.j jVarM = DescriptorUtilsKt.m(d());
        if (jVarM == null) {
            I(1);
        }
        return jVarM;
    }

    @Override // ya.AbstractC6014u
    public boolean j(InterfaceC0799d interfaceC0799d) {
        if (interfaceC0799d == null) {
            I(2);
        }
        return (interfaceC0799d instanceof InterfaceC0797b) && h(d(), interfaceC0799d);
    }

    @Override // ya.AbstractC6009o
    public S t() {
        if (C9.j.v0(d())) {
            return null;
        }
        return g().i();
    }

    @Override // ya.AbstractC6009o
    public Collection<S> u(boolean z10) {
        InterfaceC0803h interfaceC0803hB = d().b();
        if (!(interfaceC0803hB instanceof InterfaceC0797b)) {
            List list = Collections.EMPTY_LIST;
            if (list == null) {
                I(3);
            }
            return list;
        }
        Ia.j jVar = new Ia.j();
        InterfaceC0797b interfaceC0797b = (InterfaceC0797b) interfaceC0803hB;
        jVar.add(interfaceC0797b.n());
        InterfaceC0797b interfaceC0797bH0 = interfaceC0797b.h0();
        if (z10 && interfaceC0797bH0 != null) {
            jVar.add(interfaceC0797bH0.n());
        }
        return jVar;
    }
}
