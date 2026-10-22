package b8;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u extends f {

    /* renamed from: j, reason: collision with root package name */
    public static final List f2024j = Arrays.asList("if", "then", "else");

    /* renamed from: g, reason: collision with root package name */
    public w7.l f2025g;

    /* renamed from: h, reason: collision with root package name */
    public w7.l f2026h;
    public w7.l i;

    @Override // w7.s
    public final void a(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar, boolean z10) {
        w7.l lVar = this.i;
        boolean z11 = jsonNode != null && z10;
        boolean zG = fVar.g();
        List list = fVar.f15309d;
        ArrayList arrayList = new ArrayList();
        fVar.f15309d = arrayList;
        try {
            fVar.h(false);
            this.f2025g.a(fVar, jsonNode, jsonNode2, aVar, z10);
            boolean zIsEmpty = arrayList.isEmpty();
            fVar.f15309d = list;
            fVar.h(zG);
            w7.l lVar2 = this.f2026h;
            if (!z11) {
                if (lVar2 != null) {
                    fVar.d();
                    fVar.c("then");
                    try {
                        this.f2026h.a(fVar, jsonNode, jsonNode2, aVar, z10);
                    } finally {
                    }
                }
                if (lVar != null) {
                    fVar.d();
                    fVar.c("else");
                    try {
                        this.i.a(fVar, jsonNode, jsonNode2, aVar, z10);
                        return;
                    } finally {
                    }
                }
                return;
            }
            if (lVar2 != null && zIsEmpty) {
                fVar.d();
                fVar.c("then");
                try {
                    this.f2026h.a(fVar, jsonNode, jsonNode2, aVar, z10);
                    return;
                } finally {
                }
            }
            if (lVar == null || zIsEmpty) {
                return;
            }
            fVar.d();
            fVar.c("else");
            try {
                this.i.a(fVar, jsonNode, jsonNode2, aVar, z10);
            } finally {
            }
        } catch (Throwable th) {
            fVar.f15309d = list;
            fVar.h(zG);
            throw th;
        }
    }

    @Override // b8.a, w7.s
    public final void b(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar) {
        w7.l lVar = this.i;
        w7.l lVar2 = this.f2026h;
        boolean zG = fVar.g();
        List list = fVar.f15309d;
        ArrayList arrayList = new ArrayList();
        fVar.f15309d = arrayList;
        try {
            fVar.h(false);
            this.f2025g.b(fVar, jsonNode, jsonNode2, aVar);
            boolean zIsEmpty = arrayList.isEmpty();
            fVar.f15309d = list;
            fVar.h(zG);
            if (zIsEmpty && lVar2 != null) {
                fVar.d();
                fVar.c("then");
                try {
                    lVar2.b(fVar, jsonNode, jsonNode2, aVar);
                    return;
                } finally {
                }
            }
            if (zIsEmpty || lVar == null) {
                return;
            }
            fVar.d();
            fVar.c("else");
            try {
                lVar.b(fVar, jsonNode, jsonNode2, aVar);
            } finally {
            }
        } catch (Throwable th) {
            fVar.f15309d = list;
            fVar.h(zG);
            throw th;
        }
    }

    @Override // b8.a
    public final void i() {
        w7.l lVar = this.f2025g;
        if (lVar != null) {
            lVar.h();
        }
        w7.l lVar2 = this.f2026h;
        if (lVar2 != null) {
            lVar2.h();
        }
        w7.l lVar3 = this.i;
        if (lVar3 != null) {
            lVar3.h();
        }
    }
}
