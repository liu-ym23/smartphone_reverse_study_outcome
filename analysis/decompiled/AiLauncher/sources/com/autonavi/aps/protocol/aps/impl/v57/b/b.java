package com.autonavi.aps.protocol.aps.impl.v57.b;

import com.autonavi.aps.protocol.aps.common.enums.Status;
import com.autonavi.aps.protocol.aps.impl.v57.a.b;
import com.autonavi.aps.protocol.aps.response.model.vo.fields.Semantics;
import com.autonavi.aps.protocol.aps.response.model.vo.fields.c;
import com.autonavi.aps.protocol.aps.response.model.vo.fields.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class b extends com.autonavi.aps.protocol.aps.common.d.b<com.autonavi.aps.protocol.aps.impl.v57.vo.b, com.autonavi.aps.protocol.aps.response.model.b.a> {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f18862a = new b();
    }

    public static b b() {
        return a.f18862a;
    }

    @Override // com.autonavi.aps.protocol.aps.common.d.e
    public com.autonavi.aps.protocol.aps.response.model.b.a a(com.autonavi.aps.protocol.aps.impl.v57.vo.b bVar) {
        return null;
    }

    @Override // com.autonavi.aps.protocol.aps.common.d.b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.autonavi.aps.protocol.aps.response.model.a.a a(com.autonavi.aps.protocol.aps.impl.v57.vo.b bVar) {
        int i10;
        int i11;
        com.autonavi.aps.protocol.aps.response.model.a.a aVar = new com.autonavi.aps.protocol.aps.response.model.a.a();
        aVar.a(bVar.b());
        aVar.a(bVar.d());
        com.autonavi.aps.protocol.aps.impl.v57.a.b bVarC = bVar.c();
        if (bVarC != null) {
            if (bVarC.f18799d != null) {
                c cVar = new c();
                b.e eVar = bVarC.f18799d;
                cVar.a(eVar.f18821b);
                cVar.f(eVar.f18823d);
                cVar.c(eVar.f18824e);
                cVar.e(eVar.f18825f);
                cVar.i(eVar.f18832m);
                cVar.h(eVar.f18831l);
                cVar.d(eVar.f18826g);
                cVar.j(eVar.f18833n);
                cVar.b(eVar.f18820a);
                cVar.g(eVar.f18827h);
                d dVar = new d();
                dVar.a(eVar.f18828i);
                cVar.a(dVar);
                ArrayList<com.autonavi.aps.protocol.aps.response.model.vo.fields.a> arrayList = new ArrayList<>();
                for (b.e.a aVar2 : bVarC.f18799d.f18829j) {
                    com.autonavi.aps.protocol.aps.response.model.vo.fields.a aVar3 = new com.autonavi.aps.protocol.aps.response.model.vo.fields.a();
                    aVar3.a(aVar2.f18836c);
                    arrayList.add(aVar3);
                }
                cVar.a(arrayList);
                aVar.a(cVar);
            }
            if (bVarC.f18798c.size() > 0) {
                b.d dVar2 = bVarC.f18798c.get(0);
                com.autonavi.aps.protocol.aps.response.model.vo.fields.b bVar2 = new com.autonavi.aps.protocol.aps.response.model.vo.fields.b();
                bVar2.a(dVar2.f18817a / 1000000.0d);
                bVar2.b(dVar2.f18818b / 1000000.0d);
                bVar2.a(dVar2.f18819c);
                aVar.a(Collections.singletonList(bVar2));
            }
            b.c cVar2 = bVarC.f18800e;
            if (cVar2 != null) {
                if (com.autonavi.aps.protocol.aps.common.e.a.b(cVar2.f18815a)) {
                    aVar.a(cVar2.f18815a);
                }
                if (com.autonavi.aps.protocol.aps.common.e.a.b(cVar2.f18816b)) {
                    aVar.b(cVar2.f18816b);
                }
            }
            b.a aVar4 = bVarC.f18801f;
            if (aVar4 != null) {
                aVar.a(Short.valueOf((short) aVar4.f18805a));
                aVar.a(Byte.valueOf((byte) aVar4.f18807c));
                aVar.b(Byte.valueOf((byte) aVar4.f18806b));
                aVar.a((short) aVar4.f18810f);
                if (com.autonavi.aps.protocol.aps.common.e.a.b(aVar4.f18812h)) {
                    aVar.a(aVar4.f18812h);
                }
            }
            b.C0211b c0211b = bVarC.f18802g;
            if (c0211b != null) {
                String str = c0211b.f18814b;
                if (str != null) {
                    String[] strArrSplit = str.split("\\*");
                    if (strArrSplit.length >= 2) {
                        str = "eab:" + strArrSplit[0] + "*ctl:" + strArrSplit[1] + "*suc:1";
                    }
                }
                aVar.c(str);
                aVar.a(c0211b.f18813a);
            }
            List<b.f> list = bVarC.f18803h;
            if (list != null && list.size() != 0) {
                ArrayList arrayList2 = new ArrayList();
                for (b.f fVar : bVarC.f18803h) {
                    Semantics semantics = new Semantics();
                    semantics.setLat(fVar.f18846b);
                    semantics.setLon(fVar.f18845a);
                    semantics.setScenes(fVar.f18848d);
                    semantics.setScode(fVar.f18853i);
                    semantics.setConfidence(fVar.f18847c);
                    Semantics.Poi poi = new Semantics.Poi();
                    Semantics.Building building = new Semantics.Building();
                    Semantics.Block block = new Semantics.Block();
                    Semantics.Area area = new Semantics.Area();
                    semantics.setPoi((Semantics.Poi) a(fVar.f18849e, poi));
                    b.f.C0212b c0212b = fVar.f18849e;
                    if (c0212b != null && (i11 = c0212b.f18860g) != 0) {
                        poi.setFloor(Integer.valueOf(i11));
                    }
                    semantics.setBuilding((Semantics.Building) a(fVar.f18850f, building));
                    b.f.C0212b c0212b2 = fVar.f18850f;
                    if (c0212b2 != null && (i10 = c0212b2.f18860g) != 0) {
                        building.setFloor(Integer.valueOf(i10));
                    }
                    semantics.setBlock((Semantics.Block) a(fVar.f18851g, block));
                    semantics.setArea((Semantics.Area) a(fVar.f18852h, area));
                    arrayList2.add(semantics);
                }
                aVar.b(arrayList2);
            }
            byte[] bArr = bVarC.f18804i;
            if (bArr.length != 0) {
                aVar.b(bArr);
            }
        }
        aVar.a(bVar.f());
        return aVar;
    }

    @Override // com.autonavi.aps.protocol.aps.common.d.e
    public com.autonavi.aps.protocol.aps.impl.v57.vo.b a(com.autonavi.aps.protocol.aps.response.model.b.a aVar) {
        com.autonavi.aps.protocol.aps.impl.v57.vo.b bVar = new com.autonavi.aps.protocol.aps.impl.v57.vo.b();
        try {
            byte[] bArrA = com.autonavi.aps.protocol.aps.common.e.b.a(aVar.c(), aVar.a(), aVar.b(), a());
            bVar.a((com.autonavi.aps.protocol.aps.impl.v57.a.b) new com.autonavi.aps.protocol.aps.impl.v57.a.b().a(com.autonavi.aps.protocol.aps.common.b.a.a(bArrA, 0, bArrA.length)));
            bVar.a(Status.SUCCESS);
            return bVar;
        } catch (Exception unused) {
            bVar.a(Status.RES_DEC_ERROR);
            return bVar;
        }
    }

    private <T extends Semantics.BasePoi> T a(b.f.a aVar, T t10) {
        if (aVar == null) {
            return null;
        }
        t10.setId(aVar.f18854a);
        t10.setName(aVar.f18855b);
        t10.setLat(aVar.f18857d);
        t10.setLon(aVar.f18856c);
        t10.setCategoryIds(aVar.f18858e);
        t10.setExtConfidence(aVar.f18859f);
        return t10;
    }
}
