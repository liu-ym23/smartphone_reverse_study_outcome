package V8;

import X8.AbstractC0271b;
import h8.C1504L;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import java.util.List;
import k8.AbstractC1633b;
import t8.C2024a;

/* loaded from: classes4.dex */
public final class i extends AbstractC0271b {
    public final /* synthetic */ int c = 0;
    public final W8.h d;
    public final /* synthetic */ AbstractC1633b e;

    /* JADX WARN: Illegal instructions before constructor call */
    public i(u8.j jVar) {
        this.e = jVar;
        K1.a aVar = jVar.f6721j;
        super(((C2024a) aVar.f903a).f6670a);
        W8.l lVar = ((C2024a) aVar.f903a).f6670a;
        u8.h hVar = new u8.h(jVar, 2);
        W8.i iVar = (W8.i) lVar;
        iVar.getClass();
        this.d = new W8.h(iVar, hVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0270  */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v3 */
    @Override // X8.AbstractC0275f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Collection b() {
        /*
            Method dump skipped, instructions count: 898
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: V8.i.b():java.util.Collection");
    }

    @Override // X8.AbstractC0271b, X8.K
    public final InterfaceC1524g d() {
        switch (this.c) {
            case 0:
                return (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b) this.e;
            default:
                return (u8.j) this.e;
        }
    }

    @Override // X8.K
    public final boolean f() {
        switch (this.c) {
        }
        return true;
    }

    @Override // X8.K
    public final List getParameters() {
        switch (this.c) {
        }
        return (List) this.d.invoke();
    }

    @Override // X8.AbstractC0275f
    public final C1504L h() {
        switch (this.c) {
            case 0:
                return C1504L.c;
            default:
                return ((C2024a) ((u8.j) this.e).f6721j.f903a).m;
        }
    }

    @Override // X8.AbstractC0271b
    /* renamed from: m */
    public final InterfaceC1522e d() {
        switch (this.c) {
            case 0:
                return (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b) this.e;
            default:
                return (u8.j) this.e;
        }
    }

    public final String toString() {
        switch (this.c) {
            case 0:
                String str = ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b) this.e).getName().f690a;
                kotlin.jvm.internal.k.e(str, "toString(...)");
                return str;
            default:
                String strB = ((u8.j) this.e).getName().b();
                kotlin.jvm.internal.k.e(strB, "asString(...)");
                return strB;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public i(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b bVar) {
        this.e = bVar;
        T8.m mVar = bVar.l;
        super(mVar.f1228a.f1222a);
        W8.i iVar = mVar.f1228a.f1222a;
        d dVar = new d(bVar, 5);
        iVar.getClass();
        this.d = new W8.h(iVar, dVar);
    }
}
