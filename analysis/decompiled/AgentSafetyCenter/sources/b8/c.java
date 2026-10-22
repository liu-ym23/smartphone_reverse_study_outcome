package b8;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends f {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f1941g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f1942h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(x xVar, JsonNode jsonNode, w7.n nVar, w7.l lVar, androidx.room.q qVar, int i) {
        super(xVar, jsonNode, nVar, lVar, qVar);
        this.f1941g = i;
    }

    @Override // w7.s
    public final void a(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar, boolean z10) {
        int i = 0;
        switch (this.f1941g) {
            case 0:
                if (z10 && jsonNode != null) {
                    n(fVar, jsonNode, jsonNode2, aVar, true);
                    return;
                }
                ArrayList arrayList = this.f1942h;
                int size = arrayList.size();
                int i3 = 0;
                while (i < size) {
                    int i10 = i + 1;
                    w7.l lVar = (w7.l) arrayList.get(i);
                    fVar.b(i3);
                    try {
                        lVar.a(fVar, jsonNode, jsonNode2, aVar, false);
                        fVar.d();
                        i3++;
                        i = i10;
                    } finally {
                    }
                }
                return;
            case 1:
                if (z10 && jsonNode != null) {
                    n(fVar, jsonNode, jsonNode2, aVar, true);
                    return;
                }
                ArrayList arrayList2 = this.f1942h;
                int size2 = arrayList2.size();
                int i11 = 0;
                while (i < size2) {
                    int i12 = i + 1;
                    w7.l lVar2 = (w7.l) arrayList2.get(i);
                    fVar.b(i11);
                    try {
                        lVar2.a(fVar, jsonNode, jsonNode2, aVar, false);
                        fVar.d();
                        i11++;
                        i = i12;
                    } finally {
                    }
                }
                return;
            case 2:
                if (z10 && jsonNode != null) {
                    n(fVar, jsonNode, jsonNode2, aVar, true);
                    return;
                }
                ArrayList arrayList3 = this.f1942h;
                int size3 = arrayList3.size();
                int i13 = 0;
                while (i < size3) {
                    int i14 = i + 1;
                    w7.l lVar3 = (w7.l) arrayList3.get(i);
                    fVar.b(i13);
                    try {
                        lVar3.a(fVar, jsonNode, jsonNode2, aVar, false);
                        fVar.d();
                        i13++;
                        i = i14;
                    } finally {
                    }
                }
                return;
            default:
                boolean z11 = jsonNode instanceof ArrayNode;
                ArrayList arrayList4 = this.f1942h;
                if (!z11) {
                    int size4 = arrayList4.size();
                    while (i < size4) {
                        m(fVar, i, null, jsonNode2, aVar, z10);
                        i++;
                    }
                    return;
                }
                int size5 = arrayList4.size();
                while (i < size5) {
                    JsonNode jsonNode3 = jsonNode.get(i);
                    fVar.f().getClass();
                    m(fVar, i, jsonNode3, jsonNode2, aVar, z10);
                    i++;
                }
                if (!a.g(fVar)) {
                    a.d(fVar, e());
                    return;
                }
                int size6 = jsonNode.isArray() ? jsonNode.size() : 1;
                int size7 = arrayList4.size();
                String str = this.f1907a;
                w7.n nVar = this.f1909c;
                if (size6 > size7) {
                    androidx.room.t tVarE = fVar.e();
                    c8.a aVar2 = fVar.f15311f;
                    Integer numValueOf = Integer.valueOf(size7);
                    x7.a aVar3 = new x7.a();
                    aVar3.f15589f = true;
                    aVar3.f15584a = str;
                    aVar3.f15585b = aVar;
                    aVar3.f15586c = nVar;
                    aVar3.f15587d = aVar2;
                    aVar3.f15588e = numValueOf;
                    VarHandle.storeStoreFence();
                    tVarE.b(aVar3);
                    return;
                }
                androidx.room.t tVarE2 = fVar.e();
                c8.a aVar4 = fVar.f15311f;
                Boolean bool = Boolean.TRUE;
                x7.a aVar5 = new x7.a();
                aVar5.f15589f = true;
                aVar5.f15584a = str;
                aVar5.f15585b = aVar;
                aVar5.f15586c = nVar;
                aVar5.f15587d = aVar4;
                aVar5.f15588e = bool;
                VarHandle.storeStoreFence();
                tVarE2.b(aVar5);
                return;
        }
    }

    @Override // b8.a, w7.s
    public final void b(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar) {
        switch (this.f1941g) {
            case 0:
                n(fVar, jsonNode, jsonNode2, aVar, false);
                return;
            case 1:
                n(fVar, jsonNode, jsonNode2, aVar, false);
                return;
            case 2:
                n(fVar, jsonNode, jsonNode2, aVar, false);
                return;
            default:
                ArrayList arrayList = this.f1942h;
                if (jsonNode.isArray()) {
                    int iMin = Math.min(jsonNode.size(), arrayList.size());
                    for (int i = 0; i < iMin; i++) {
                        c8.a aVarA = aVar.a(i);
                        fVar.b(i);
                        try {
                            ((w7.l) arrayList.get(i)).b(fVar, jsonNode.get(i), jsonNode2, aVarA);
                            fVar.d();
                        } catch (Throwable th) {
                            fVar.d();
                            throw th;
                        }
                    }
                    if (!a.g(fVar)) {
                        a.d(fVar, e());
                        return;
                    }
                    int size = jsonNode.isArray() ? jsonNode.size() : 1;
                    int size2 = arrayList.size();
                    String str = this.f1907a;
                    w7.n nVar = this.f1909c;
                    if (size > size2) {
                        androidx.room.t tVarE = fVar.e();
                        c8.a aVar2 = fVar.f15311f;
                        Integer numValueOf = Integer.valueOf(size2);
                        x7.a aVar3 = new x7.a();
                        aVar3.f15589f = true;
                        aVar3.f15584a = str;
                        aVar3.f15585b = aVar;
                        aVar3.f15586c = nVar;
                        aVar3.f15587d = aVar2;
                        aVar3.f15588e = numValueOf;
                        VarHandle.storeStoreFence();
                        tVarE.b(aVar3);
                        return;
                    }
                    androidx.room.t tVarE2 = fVar.e();
                    c8.a aVar4 = fVar.f15311f;
                    Boolean bool = Boolean.TRUE;
                    x7.a aVar5 = new x7.a();
                    aVar5.f15589f = true;
                    aVar5.f15584a = str;
                    aVar5.f15585b = aVar;
                    aVar5.f15586c = nVar;
                    aVar5.f15587d = aVar4;
                    aVar5.f15588e = bool;
                    VarHandle.storeStoreFence();
                    tVarE2.b(aVar5);
                    return;
                }
                return;
        }
    }

    @Override // b8.a
    public final void i() {
        switch (this.f1941g) {
            case 0:
                f.l(this.f1942h);
                break;
            case 1:
                f.l(this.f1942h);
                break;
            case 2:
                ArrayList arrayList = this.f1942h;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((w7.l) obj).h();
                }
                break;
            default:
                f.l(this.f1942h);
                break;
        }
    }

    public void m(w7.f fVar, int i, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar, boolean z10) {
        w7.l lVar = (w7.l) this.f1942h.get(i);
        c8.a aVarA = aVar.a(i);
        fVar.f().getClass();
        b0.S.getClass();
        int size = fVar.f15309d.size();
        fVar.b(i);
        try {
            lVar.a(fVar, jsonNode, jsonNode2, aVarA, z10);
            fVar.d();
            fVar.f().getClass();
            List list = fVar.f15309d;
            list.subList(size, list.size());
        } catch (Throwable th) {
            fVar.d();
            throw th;
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void n(w7.f r27, com.fasterxml.jackson.databind.JsonNode r28, com.fasterxml.jackson.databind.JsonNode r29, c8.a r30, boolean r31) {
        /*
            Method dump skipped, instructions count: 868
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b8.c.n(w7.f, com.fasterxml.jackson.databind.JsonNode, com.fasterxml.jackson.databind.JsonNode, c8.a, boolean):void");
    }
}
