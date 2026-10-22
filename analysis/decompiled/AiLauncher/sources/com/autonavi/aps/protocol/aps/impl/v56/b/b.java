package com.autonavi.aps.protocol.aps.impl.v56.b;

import com.autonavi.aps.protocol.aps.common.enums.Status;
import com.autonavi.aps.protocol.aps.impl.v56.a.b;
import com.autonavi.aps.protocol.aps.response.model.vo.fields.Semantics;
import com.autonavi.aps.protocol.aps.response.model.vo.fields.c;
import com.autonavi.aps.protocol.aps.response.model.vo.fields.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class b extends com.autonavi.aps.protocol.aps.common.d.b<com.autonavi.aps.protocol.aps.impl.v56.vo.b, com.autonavi.aps.protocol.aps.response.model.b.a> {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f18696a = new b();
    }

    public static b b() {
        return a.f18696a;
    }

    @Override // com.autonavi.aps.protocol.aps.common.d.e
    public com.autonavi.aps.protocol.aps.response.model.b.a a(com.autonavi.aps.protocol.aps.impl.v56.vo.b bVar) {
        return null;
    }

    @Override // com.autonavi.aps.protocol.aps.common.d.b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.autonavi.aps.protocol.aps.response.model.a.a a(com.autonavi.aps.protocol.aps.impl.v56.vo.b bVar) {
        int i10;
        com.autonavi.aps.protocol.aps.response.model.a.a aVar = new com.autonavi.aps.protocol.aps.response.model.a.a();
        aVar.a(bVar.b());
        aVar.a(bVar.d());
        com.autonavi.aps.protocol.aps.impl.v56.a.b bVarC = bVar.c();
        if (bVarC != null) {
            if (bVarC.f18623d != null) {
                c cVar = new c();
                b.e eVar = bVarC.f18623d;
                cVar.a(eVar.f18645b);
                cVar.f(eVar.f18647d);
                cVar.c(eVar.f18648e);
                cVar.e(eVar.f18649f);
                cVar.i(eVar.f18656m);
                cVar.h(eVar.f18655l);
                cVar.d(eVar.f18650g);
                cVar.j(eVar.f18657n);
                cVar.b(eVar.f18644a);
                cVar.g(eVar.f18651h);
                d dVar = new d();
                dVar.a(eVar.f18652i);
                cVar.a(dVar);
                ArrayList<com.autonavi.aps.protocol.aps.response.model.vo.fields.a> arrayList = new ArrayList<>();
                for (b.e.a aVar2 : bVarC.f18623d.f18653j) {
                    com.autonavi.aps.protocol.aps.response.model.vo.fields.a aVar3 = new com.autonavi.aps.protocol.aps.response.model.vo.fields.a();
                    aVar3.a(aVar2.f18660c);
                    arrayList.add(aVar3);
                }
                cVar.a(arrayList);
                aVar.a(cVar);
            }
            if (bVarC.f18622c.size() > 0) {
                b.d dVar2 = bVarC.f18622c.get(0);
                com.autonavi.aps.protocol.aps.response.model.vo.fields.b bVar2 = new com.autonavi.aps.protocol.aps.response.model.vo.fields.b();
                bVar2.a(dVar2.f18641a / 1000000.0d);
                bVar2.b(dVar2.f18642b / 1000000.0d);
                bVar2.a(dVar2.f18643c);
                aVar.a(Collections.singletonList(bVar2));
            }
            b.c cVar2 = bVarC.f18624e;
            if (cVar2 != null) {
                if (com.autonavi.aps.protocol.aps.common.e.a.b(cVar2.f18639a)) {
                    aVar.a(cVar2.f18639a);
                }
                if (com.autonavi.aps.protocol.aps.common.e.a.b(cVar2.f18640b)) {
                    aVar.b(cVar2.f18640b);
                }
            }
            b.a aVar4 = bVarC.f18625f;
            if (aVar4 != null) {
                aVar.a(Short.valueOf((short) aVar4.f18629a));
                aVar.a(Byte.valueOf((byte) aVar4.f18631c));
                aVar.b(Byte.valueOf((byte) aVar4.f18630b));
                aVar.a((short) aVar4.f18634f);
                if (com.autonavi.aps.protocol.aps.common.e.a.b(aVar4.f18636h)) {
                    aVar.a(aVar4.f18636h);
                }
            }
            b.C0207b c0207b = bVarC.f18626g;
            if (c0207b != null) {
                String str = c0207b.f18638b;
                if (str != null) {
                    String[] strArrSplit = str.split("\\*");
                    if (strArrSplit.length >= 2) {
                        str = "eab:" + strArrSplit[0] + "*ctl:" + strArrSplit[1] + "*suc:1";
                    }
                }
                aVar.c(str);
                aVar.a(c0207b.f18637a);
            }
            List<b.f> list = bVarC.f18627h;
            if (list != null && list.size() != 0) {
                ArrayList arrayList2 = new ArrayList();
                for (b.f fVar : bVarC.f18627h) {
                    Semantics semantics = new Semantics();
                    semantics.setLat(fVar.f18670b);
                    semantics.setLon(fVar.f18669a);
                    semantics.setScenes(fVar.f18672d);
                    semantics.setScode(fVar.f18677i);
                    semantics.setConfidence(fVar.f18671c);
                    Semantics.Poi poi = new Semantics.Poi();
                    b.f.e eVar2 = fVar.f18673e;
                    if (eVar2 != null && (i10 = eVar2.f18684g) != 0) {
                        poi.setFloor(Integer.valueOf(i10));
                    }
                    Semantics.Building building = new Semantics.Building();
                    Semantics.Block block = new Semantics.Block();
                    Semantics.Area area = new Semantics.Area();
                    semantics.setPoi((Semantics.Poi) a(fVar.f18673e, poi));
                    semantics.setBuilding((Semantics.Building) a(fVar.f18674f, building));
                    semantics.setBlock((Semantics.Block) a(fVar.f18675g, block));
                    semantics.setArea((Semantics.Area) a(fVar.f18676h, area));
                    arrayList2.add(semantics);
                }
                aVar.b(arrayList2);
            }
            byte[] bArr = bVarC.f18628i;
            if (bArr.length != 0) {
                aVar.b(bArr);
            }
        }
        aVar.a(bVar.f());
        return aVar;
    }

    @Override // com.autonavi.aps.protocol.aps.common.d.e
    public com.autonavi.aps.protocol.aps.impl.v56.vo.b a(com.autonavi.aps.protocol.aps.response.model.b.a aVar) {
        com.autonavi.aps.protocol.aps.impl.v56.vo.b bVar = new com.autonavi.aps.protocol.aps.impl.v56.vo.b();
        try {
            byte[] bArrA = com.autonavi.aps.protocol.aps.common.e.b.a(aVar.c(), aVar.a(), aVar.b(), a());
            bVar.a((com.autonavi.aps.protocol.aps.impl.v56.a.b) new com.autonavi.aps.protocol.aps.impl.v56.a.b().a(com.autonavi.aps.protocol.aps.impl.v56.a.c.a(bArrA, 0, bArrA.length)));
            bVar.a(Status.SUCCESS);
            return bVar;
        } catch (Exception unused) {
            bVar.a(Status.RES_DEC_ERROR);
            return bVar;
        }
    }

    private <T extends Semantics.BasePoi> T a(b.f.C0208b c0208b, T t10) {
        if (c0208b == null) {
            return null;
        }
        t10.setId(c0208b.f18678a);
        t10.setName(c0208b.f18679b);
        t10.setLat(c0208b.f18681d);
        t10.setLon(c0208b.f18680c);
        t10.setCategoryIds(c0208b.f18682e);
        t10.setExtConfidence(c0208b.f18683f);
        return t10;
    }
}
