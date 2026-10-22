package X8;

import androidx.appcompat.app.AppCompatDelegate;
import h8.InterfaceC1522e;

/* renamed from: X8.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0271b extends AbstractC0275f {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0271b(W8.l lVar) {
        super(lVar);
        if (lVar != null) {
        } else {
            l(0);
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void l(int r9) {
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
        throw new UnsupportedOperationException("Method not decompiled: X8.AbstractC0271b.l(int):void");
    }

    @Override // X8.K
    public final e8.i c() {
        e8.i iVarE = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.e(d());
        if (iVarE != null) {
            return iVarE;
        }
        l(1);
        throw null;
    }

    @Override // X8.AbstractC0275f
    public final w g() {
        InterfaceC1522e interfaceC1522eD = d();
        if (interfaceC1522eD == null) {
            e8.i.a(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR);
            throw null;
        }
        G8.f fVar = e8.i.e;
        if (e8.i.b(interfaceC1522eD, e8.n.f4413a) || e8.i.b(interfaceC1522eD, e8.n.b)) {
            return null;
        }
        return c().e();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0072 A[RETURN] */
    @Override // X8.AbstractC0275f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean j(h8.InterfaceC1524g r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof h8.InterfaceC1522e
            r1 = 0
            if (r0 == 0) goto L73
            h8.e r4 = r4.d()
            java.lang.String r0 = "first"
            kotlin.jvm.internal.k.f(r4, r0)
            G8.f r0 = r4.getName()
            G8.f r2 = r5.getName()
            boolean r0 = kotlin.jvm.internal.k.b(r0, r2)
            r2 = 1
            if (r0 != 0) goto L1f
        L1d:
            r4 = r1
            goto L70
        L1f:
            h8.j r4 = r4.d()
            h8.j r5 = r5.d()
        L27:
            if (r4 == 0) goto L51
            if (r5 == 0) goto L51
            boolean r0 = r4 instanceof h8.InterfaceC1540w
            if (r0 == 0) goto L32
            boolean r4 = r5 instanceof h8.InterfaceC1540w
            goto L70
        L32:
            boolean r0 = r5 instanceof h8.InterfaceC1540w
            if (r0 == 0) goto L37
            goto L1d
        L37:
            boolean r0 = r4 instanceof h8.InterfaceC1494B
            if (r0 == 0) goto L53
            boolean r0 = r5 instanceof h8.InterfaceC1494B
            if (r0 == 0) goto L1d
            h8.B r4 = (h8.InterfaceC1494B) r4
            k8.B r4 = (k8.AbstractC1629B) r4
            G8.c r4 = r4.e
            h8.B r5 = (h8.InterfaceC1494B) r5
            k8.B r5 = (k8.AbstractC1629B) r5
            G8.c r5 = r5.e
            boolean r4 = kotlin.jvm.internal.k.b(r4, r5)
            if (r4 == 0) goto L1d
        L51:
            r4 = r2
            goto L70
        L53:
            boolean r0 = r5 instanceof h8.InterfaceC1494B
            if (r0 == 0) goto L58
            goto L1d
        L58:
            G8.f r0 = r4.getName()
            G8.f r3 = r5.getName()
            boolean r0 = kotlin.jvm.internal.k.b(r0, r3)
            if (r0 != 0) goto L67
            goto L1d
        L67:
            h8.j r4 = r4.d()
            h8.j r5 = r5.d()
            goto L27
        L70:
            if (r4 == 0) goto L73
            return r2
        L73:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: X8.AbstractC0271b.j(h8.g):boolean");
    }

    @Override // X8.K
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public abstract InterfaceC1522e d();
}
