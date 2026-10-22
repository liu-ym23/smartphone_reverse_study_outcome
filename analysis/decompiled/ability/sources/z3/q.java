package z3;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.keyword.KeywordType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public final class q extends AbstractC2161f {
    public static final List i = Arrays.asList("if", "then", "else");
    public final u3.i f;
    public final u3.i g;
    public final u3.i h;

    public q(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
        super(KeywordType.f3050v, jsonNode, jVar, iVar, cVar);
        u3.i iVarC = null;
        u3.i iVarC2 = null;
        u3.i iVarC3 = null;
        for (String str : i) {
            JsonNode jsonNode2 = iVar.g.get(str);
            u3.j jVarB = iVar.i.b(str);
            if (str.equals("if")) {
                iVarC = cVar.c(jVarB, jsonNode2, iVar);
            } else if (str.equals("then") && jsonNode2 != null) {
                iVarC2 = cVar.c(jVarB, jsonNode2, iVar);
            } else if (str.equals("else") && jsonNode2 != null) {
                iVarC3 = cVar.c(jVarB, jsonNode2, iVar);
            }
        }
        this.f = iVarC;
        this.g = iVarC2;
        this.h = iVarC3;
    }

    @Override // z3.AbstractC2156a, u3.m
    public final void a(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar) {
        u3.i iVar;
        u3.i iVar2;
        boolean zG = fVar.g();
        List list = fVar.d;
        ArrayList arrayList = new ArrayList();
        fVar.d = arrayList;
        try {
            fVar.h(false);
            this.f.a(fVar, jsonNode, jsonNode2, aVar);
            boolean zIsEmpty = arrayList.isEmpty();
            fVar.d = list;
            fVar.h(zG);
            if (zIsEmpty && (iVar2 = this.g) != null) {
                fVar.d();
                fVar.c("then");
                try {
                    iVar2.a(fVar, jsonNode, jsonNode2, aVar);
                    return;
                } finally {
                }
            }
            if (zIsEmpty || (iVar = this.h) == null) {
                return;
            }
            fVar.d();
            fVar.c("else");
            try {
                iVar.a(fVar, jsonNode, jsonNode2, aVar);
            } finally {
            }
        } catch (Throwable th) {
            fVar.d = list;
            fVar.h(zG);
            throw th;
        }
    }

    @Override // u3.m
    public final void b(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar, boolean z10) {
        boolean z11 = jsonNode != null && z10;
        boolean zG = fVar.g();
        List list = fVar.d;
        ArrayList arrayList = new ArrayList();
        fVar.d = arrayList;
        try {
            fVar.h(false);
            this.f.b(fVar, jsonNode, jsonNode2, aVar, z10);
            boolean zIsEmpty = arrayList.isEmpty();
            fVar.d = list;
            fVar.h(zG);
            u3.i iVar = this.h;
            u3.i iVar2 = this.g;
            if (!z11) {
                if (iVar2 != null) {
                    fVar.d();
                    fVar.c("then");
                    try {
                        this.g.b(fVar, jsonNode, jsonNode2, aVar, z10);
                    } finally {
                    }
                }
                if (iVar != null) {
                    fVar.d();
                    fVar.c("else");
                    try {
                        this.h.b(fVar, jsonNode, jsonNode2, aVar, z10);
                        return;
                    } finally {
                    }
                }
                return;
            }
            if (iVar2 != null && zIsEmpty) {
                fVar.d();
                fVar.c("then");
                try {
                    this.g.b(fVar, jsonNode, jsonNode2, aVar, z10);
                    return;
                } finally {
                }
            }
            if (iVar == null || zIsEmpty) {
                return;
            }
            fVar.d();
            fVar.c("else");
            try {
                this.h.b(fVar, jsonNode, jsonNode2, aVar, z10);
            } finally {
            }
        } catch (Throwable th) {
            fVar.d = list;
            fVar.h(zG);
            throw th;
        }
    }

    @Override // z3.AbstractC2156a
    public final void i() {
        u3.i iVar = this.f;
        if (iVar != null) {
            iVar.h();
        }
        u3.i iVar2 = this.g;
        if (iVar2 != null) {
            iVar2.h();
        }
        u3.i iVar3 = this.h;
        if (iVar3 != null) {
            iVar3.h();
        }
    }
}
