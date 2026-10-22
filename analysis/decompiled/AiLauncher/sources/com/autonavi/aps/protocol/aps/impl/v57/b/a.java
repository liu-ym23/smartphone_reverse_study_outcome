package com.autonavi.aps.protocol.aps.impl.v57.b;

import com.autonavi.aps.protocol.aps.common.b.c;
import com.autonavi.aps.protocol.aps.common.constant.Constant;
import com.autonavi.aps.protocol.aps.common.e.e;
import com.autonavi.aps.protocol.aps.common.enums.Status;
import com.autonavi.aps.protocol.aps.impl.v57.a.a;
import com.autonavi.aps.protocol.aps.request.model.fields.HisLocCtxs;
import com.autonavi.aps.protocol.aps.request.model.fields.bluetooth.Bluetooths;
import com.autonavi.aps.protocol.aps.request.model.fields.cell.GsmNbCells;
import com.autonavi.aps.protocol.aps.request.model.fields.cell.HistoryCells;
import com.autonavi.aps.protocol.aps.request.model.fields.cell.NewApiCells;
import com.autonavi.aps.protocol.aps.request.model.fields.context.TrackPoints;
import com.autonavi.aps.protocol.aps.request.model.fields.wifi.NbWifis;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class a extends com.autonavi.aps.protocol.aps.common.d.a<com.autonavi.aps.protocol.aps.impl.v57.vo.a, com.autonavi.aps.protocol.aps.request.model.message.a> {

    /* renamed from: com.autonavi.aps.protocol.aps.impl.v57.b.a$a, reason: collision with other inner class name */
    public static class C0213a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f18861a = new a();
    }

    public static a b() {
        return C0213a.f18861a;
    }

    private a.f c(com.autonavi.aps.protocol.aps.request.model.a.a aVar) {
        a.f fVar = new a.f();
        fVar.f18767a = aVar.i();
        fVar.f18768b = aVar.j();
        fVar.f18769c = aVar.k();
        if (com.autonavi.aps.protocol.aps.common.e.a.b(aVar.l())) {
            fVar.f18770d = aVar.l();
        }
        if (com.autonavi.aps.protocol.aps.common.e.a.b(aVar.m())) {
            fVar.f18771e = aVar.m();
        }
        if (aVar.o() != null) {
            fVar.f18772f = aVar.o().toString();
        }
        fVar.f18773g = aVar.p();
        fVar.f18774h = aVar.q();
        fVar.f18775i = aVar.r();
        fVar.f18776j = aVar.s();
        fVar.f18777k = aVar.t();
        if (com.autonavi.aps.protocol.aps.common.e.a.b(aVar.u())) {
            fVar.f18778l = aVar.u();
        }
        fVar.f18779m = aVar.h();
        return fVar;
    }

    private a.g d(com.autonavi.aps.protocol.aps.request.model.a.a aVar) {
        a.g gVar = new a.g();
        if (aVar.M() != null) {
            gVar.f18780a = aVar.M().a();
        }
        if (aVar.O() != null) {
            gVar.f18781b = aVar.O().a();
        }
        if (aVar.P() != null) {
            gVar.f18782c = aVar.P();
        }
        HistoryCells historyCellsQ = aVar.Q();
        if (aVar.Q() != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<HistoryCells.f> it = historyCellsQ.iterator();
            while (it.hasNext()) {
                HistoryCells.f next = it.next();
                a.e eVar = new a.e();
                byte b10 = next.b();
                if (b10 == 1) {
                    HistoryCells.b bVar = (HistoryCells.b) next;
                    eVar.f18759d = bVar.d();
                    eVar.f18761f = bVar.e();
                    eVar.f18758c = bVar.c();
                    eVar.f18766k = com.autonavi.aps.protocol.aps.common.e.a.a((byte) 1, (byte) 0, bVar.a() ? (byte) 1 : (byte) 0);
                } else if (b10 == 2) {
                    HistoryCells.a aVar2 = (HistoryCells.a) next;
                    eVar.f18761f = aVar2.f();
                    eVar.f18766k = com.autonavi.aps.protocol.aps.common.e.a.a((byte) 2, (byte) 0, aVar2.a() ? (byte) 1 : (byte) 0);
                    a.d dVar = new a.d();
                    dVar.f18751a = aVar2.c();
                    dVar.f18752b = aVar2.d();
                    dVar.f18753c = aVar2.e();
                    eVar.f18765j = dVar;
                } else if (b10 == 3) {
                    HistoryCells.c cVar = (HistoryCells.c) next;
                    eVar.f18759d = cVar.d();
                    eVar.f18761f = cVar.e();
                    eVar.f18758c = cVar.c();
                    eVar.f18766k = com.autonavi.aps.protocol.aps.common.e.a.a((byte) 3, (byte) 0, cVar.a() ? (byte) 1 : (byte) 0);
                } else if (b10 == 4) {
                    HistoryCells.e eVar2 = (HistoryCells.e) next;
                    eVar.f18759d = eVar2.d();
                    eVar.f18761f = eVar2.e();
                    eVar.f18758c = eVar2.c();
                    eVar.f18766k = com.autonavi.aps.protocol.aps.common.e.a.a((byte) 4, (byte) 0, eVar2.a() ? (byte) 1 : (byte) 0);
                } else if (b10 == 5) {
                    HistoryCells.d dVar2 = (HistoryCells.d) next;
                    eVar.f18759d = dVar2.d();
                    eVar.f18761f = dVar2.e();
                    eVar.f18758c = dVar2.c();
                    eVar.f18766k = com.autonavi.aps.protocol.aps.common.e.a.a((byte) 5, (byte) 0, dVar2.a() ? (byte) 1 : (byte) 0);
                }
                arrayList.add(eVar);
            }
            gVar.f18783d = arrayList;
        }
        TrackPoints trackPointsL = aVar.L();
        if (trackPointsL != null && trackPointsL.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<TrackPoints.a> it2 = trackPointsL.iterator();
            while (it2.hasNext()) {
                TrackPoints.a next2 = it2.next();
                a.b bVar2 = new a.b();
                bVar2.f18735b = (int) Math.round(next2.b() * 1000000.0d);
                bVar2.f18734a = (int) Math.round(next2.a() * 1200000.0d);
                bVar2.f18736c = next2.c();
                bVar2.f18737d = next2.d().getCode().byteValue();
                bVar2.f18738e = next2.e();
                arrayList2.add(bVar2);
            }
            gVar.f18784e = arrayList2;
        }
        HisLocCtxs hisLocCtxsR = aVar.R();
        if (hisLocCtxsR != null && hisLocCtxsR.size() > 0) {
            ArrayList arrayList3 = new ArrayList();
            Iterator<HisLocCtxs.a> it3 = hisLocCtxsR.iterator();
            while (it3.hasNext()) {
                HisLocCtxs.a next3 = it3.next();
                a.b bVar3 = new a.b();
                bVar3.f18735b = next3.c();
                bVar3.f18734a = next3.b();
                bVar3.f18736c = next3.d();
                bVar3.f18737d = HisLocCtxs.a.b(next3.e());
                bVar3.f18738e = next3.a();
                arrayList3.add(bVar3);
            }
            gVar.f18785f = arrayList3;
        }
        return gVar;
    }

    private List<a.i> e(com.autonavi.aps.protocol.aps.request.model.a.a aVar) {
        ArrayList arrayList = new ArrayList();
        com.autonavi.aps.protocol.aps.request.model.fields.wifi.b bVarJ = aVar.J();
        if (bVarJ != null) {
            a.i iVar = new a.i();
            iVar.f18790a = com.autonavi.aps.protocol.aps.common.e.a.c(bVarJ.a().a());
            iVar.f18791b = bVarJ.c();
            String strB = bVarJ.b();
            if (com.autonavi.aps.protocol.aps.common.e.a.b(strB)) {
                iVar.f18792c = strB;
            }
            iVar.f18793d = bVarJ.d();
            boolean zE = bVarJ.e();
            iVar.f18795f = com.autonavi.aps.protocol.aps.common.e.a.a(zE ? (byte) 1 : (byte) 0, (byte) 1, bVarJ.f());
            arrayList.add(iVar);
        }
        NbWifis nbWifisK = aVar.K();
        if (nbWifisK != null && nbWifisK.size() > 0) {
            Iterator<NbWifis.a> it = nbWifisK.iterator();
            while (it.hasNext()) {
                NbWifis.a next = it.next();
                a.i iVar2 = new a.i();
                iVar2.f18790a = com.autonavi.aps.protocol.aps.common.e.a.c(next.a().a());
                iVar2.f18791b = next.c();
                String strB2 = next.b();
                if (com.autonavi.aps.protocol.aps.common.e.a.b(strB2)) {
                    iVar2.f18792c = strB2;
                }
                iVar2.f18793d = next.d();
                iVar2.f18794e = next.e();
                iVar2.f18795f = 0;
                arrayList.add(iVar2);
            }
        }
        return arrayList;
    }

    private List<a.e> f(com.autonavi.aps.protocol.aps.request.model.a.a aVar) {
        a aVar2 = this;
        ArrayList arrayList = new ArrayList();
        com.autonavi.aps.protocol.aps.request.model.fields.cell.a aVarG = aVar.G();
        if (aVarG != null) {
            a.e eVar = new a.e();
            aVar2.a(aVarG, eVar);
            eVar.f18766k = com.autonavi.aps.protocol.aps.common.e.a.a(aVarG.i(), (byte) 0, (byte) 1);
            arrayList.add(eVar);
        }
        com.autonavi.aps.protocol.aps.request.model.fields.cell.b bVarF = aVar.F();
        if (bVarF != null) {
            a.e eVar2 = new a.e();
            aVar2.a(bVarF, eVar2);
            eVar2.f18766k = com.autonavi.aps.protocol.aps.common.e.a.a(bVarF.i(), (byte) 0, (byte) 1);
            arrayList.add(eVar2);
        }
        GsmNbCells gsmNbCellsH = aVar.H();
        if (gsmNbCellsH != null && gsmNbCellsH.size() > 0) {
            Iterator<GsmNbCells.a> it = gsmNbCellsH.iterator();
            while (it.hasNext()) {
                GsmNbCells.a next = it.next();
                a.e eVar3 = new a.e();
                eVar3.f18759d = next.b();
                eVar3.f18758c = next.a();
                eVar3.f18760e = next.c();
                eVar3.f18761f = next.d();
                eVar3.f18766k = com.autonavi.aps.protocol.aps.common.e.a.a(next.e(), (byte) 0, (byte) 0);
                arrayList.add(eVar3);
            }
        }
        NewApiCells newApiCellsI = aVar.I();
        if (newApiCellsI != null && newApiCellsI.size() > 0) {
            Iterator<NewApiCells.a> it2 = newApiCellsI.iterator();
            while (it2.hasNext()) {
                NewApiCells.a next2 = it2.next();
                a.e eVar4 = new a.e();
                if (1 == next2.i()) {
                    NewApiCells.c cVar = (NewApiCells.c) next2;
                    aVar2.a(cVar, eVar4);
                    eVar4.f18764i = cVar.j();
                    eVar4.f18762g = cVar.g();
                    eVar4.f18763h = cVar.h();
                } else if (2 == next2.i()) {
                    aVar2.a((NewApiCells.b) next2, eVar4);
                } else if (3 == next2.i()) {
                    NewApiCells.d dVar = (NewApiCells.d) next2;
                    aVar2.a(eVar4, dVar.c_(), dVar.b(), dVar.d(), dVar.c(), dVar.e(), dVar.f(), dVar.j(), dVar.g(), dVar.h());
                } else if (4 == next2.i()) {
                    NewApiCells.f fVar = (NewApiCells.f) next2;
                    a(eVar4, fVar.b(), fVar.c(), fVar.e(), fVar.d(), fVar.f(), fVar.g(), fVar.k(), fVar.h(), fVar.j());
                } else if (5 == next2.i()) {
                    NewApiCells.e eVar5 = (NewApiCells.e) next2;
                    a(eVar4, eVar5.b(), eVar5.c(), eVar5.e(), eVar5.d(), eVar5.f(), eVar5.g(), eVar5.k(), eVar5.h(), eVar5.j());
                }
                eVar4.f18766k = next2.a() ? com.autonavi.aps.protocol.aps.common.e.a.a(next2.i(), (byte) 1, (byte) 1) : com.autonavi.aps.protocol.aps.common.e.a.a(next2.i(), (byte) 1, (byte) 0);
                arrayList.add(eVar4);
                aVar2 = this;
            }
        }
        return arrayList;
    }

    private List<a.c> g(com.autonavi.aps.protocol.aps.request.model.a.a aVar) throws UnsupportedEncodingException {
        Bluetooths bluetoothsN = aVar.N();
        ArrayList arrayList = new ArrayList();
        if (bluetoothsN != null && bluetoothsN.size() > 0) {
            Iterator<Bluetooths.a> it = bluetoothsN.iterator();
            while (it.hasNext()) {
                Bluetooths.a next = it.next();
                a.c cVar = new a.c();
                cVar.f18739a = com.autonavi.aps.protocol.aps.common.e.a.c(next.a().toString());
                if (com.autonavi.aps.protocol.aps.common.e.a.b(next.b())) {
                    cVar.f18740b = next.b().getBytes("UTF-8");
                }
                cVar.f18741c = next.c();
                cVar.f18742d = next.d();
                cVar.f18743e = next.e();
                cVar.f18744f = next.f();
                cVar.f18745g = next.g();
                if (com.autonavi.aps.protocol.aps.common.e.a.b(next.h())) {
                    cVar.f18746h = next.h();
                }
                cVar.f18747i = next.i();
                cVar.f18748j = next.j();
                cVar.f18749k = next.k();
                cVar.f18750l = next.l();
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    private a.C0210a h(com.autonavi.aps.protocol.aps.request.model.a.a aVar) {
        a.C0210a c0210a = new a.C0210a();
        c0210a.f18719a = aVar.w().toByte();
        c0210a.f18720b = aVar.x().toByte();
        c0210a.f18721c = aVar.y().toByte();
        c0210a.f18730l = aVar.f();
        c0210a.f18731m = aVar.g();
        c0210a.f18732n = aVar.e();
        c0210a.f18733o = aVar.n();
        c0210a.f18723e = (int) Math.round(aVar.A() * 1000000.0d);
        c0210a.f18722d = (int) Math.round(aVar.z() * 1000000.0d);
        c0210a.f18724f = aVar.B();
        c0210a.f18725g = aVar.C();
        c0210a.f18726h = aVar.D();
        c0210a.f18727i = aVar.E();
        if (aVar.d() != null) {
            c0210a.f18728j = aVar.d().a();
        }
        if (com.autonavi.aps.protocol.aps.common.e.a.b(aVar.v())) {
            c0210a.f18729k = aVar.v();
        }
        return c0210a;
    }

    @Override // com.autonavi.aps.protocol.aps.common.d.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.autonavi.aps.protocol.aps.impl.v57.vo.a a(com.autonavi.aps.protocol.aps.request.model.a.a aVar) {
        com.autonavi.aps.protocol.aps.impl.v57.vo.a aVar2 = new com.autonavi.aps.protocol.aps.impl.v57.vo.a();
        try {
            aVar2.a(aVar.b());
            aVar2.a(aVar.c());
            com.autonavi.aps.protocol.aps.impl.v57.a.a aVar3 = new com.autonavi.aps.protocol.aps.impl.v57.a.a();
            aVar3.f18711a = h(aVar);
            aVar3.f18712b.addAll(f(aVar));
            aVar3.f18713c.addAll(e(aVar));
            aVar3.f18714d = g(aVar);
            aVar3.f18716f = d(aVar);
            a.h hVar = new a.h();
            com.autonavi.aps.protocol.aps.request.model.fields.a.a aVarS = aVar.S();
            if (aVarS != null) {
                hVar.f18786a = aVarS.a();
                hVar.f18787b = aVarS.b();
                hVar.f18788c = aVarS.c();
                hVar.f18789d = aVarS.d();
            }
            aVar3.f18715e = hVar;
            aVar3.f18717g = c(aVar);
            if (aVar.T() != null && aVar.T().length != 0) {
                aVar3.f18718h = aVar.T();
            }
            aVar2.a(aVar3);
            return aVar2;
        } catch (Exception unused) {
            aVar2.a(Status.REQ_ENC_ERROR);
            return aVar2;
        }
    }

    @Override // com.autonavi.aps.protocol.aps.common.d.e
    public com.autonavi.aps.protocol.aps.impl.v57.vo.a a(com.autonavi.aps.protocol.aps.request.model.message.a aVar) {
        com.autonavi.aps.protocol.aps.impl.v57.vo.a aVar2 = new com.autonavi.aps.protocol.aps.impl.v57.vo.a();
        aVar2.a(aVar.b());
        aVar2.a(aVar.c());
        try {
            byte[] bArrA = aVar.a();
            if (aVar.b().a()) {
                try {
                    bArrA = e.b(bArrA);
                } catch (Exception unused) {
                }
            }
            aVar2.a((com.autonavi.aps.protocol.aps.impl.v57.a.a) new com.autonavi.aps.protocol.aps.impl.v57.a.a().a(com.autonavi.aps.protocol.aps.common.b.a.a(bArrA, 0, bArrA.length)));
        } catch (Exception unused2) {
            aVar2.a(Status.RES_DEC_ERROR);
        }
        return aVar2;
    }

    @Override // com.autonavi.aps.protocol.aps.common.d.e
    public com.autonavi.aps.protocol.aps.request.model.message.a a(com.autonavi.aps.protocol.aps.impl.v57.vo.a aVar) {
        com.autonavi.aps.protocol.aps.request.model.message.a aVar2 = new com.autonavi.aps.protocol.aps.request.model.message.a();
        aVar2.a(aVar.c());
        aVar2.a(aVar.d());
        try {
            c cVar = new c();
            aVar.a().b(cVar);
            byte[] bArrA = cVar.a();
            if (aVar.c().a()) {
                try {
                    bArrA = e.a(bArrA);
                } catch (Exception unused) {
                    throw new Constant.EncryptException();
                }
            }
            aVar2.a(bArrA);
            return aVar2;
        } catch (Exception unused2) {
            aVar2.a(Status.RES_ENC_ERROR);
            return aVar2;
        }
    }

    private void a(a.e eVar, int i10, int i11, long j10, int i12, byte b10, int i13, int i14, int i15, int i16) {
        if (i10 == Integer.MAX_VALUE) {
            i10 = 65535;
        }
        eVar.f18756a = i10;
        if (i11 == Integer.MAX_VALUE) {
            i11 = 65535;
        }
        eVar.f18757b = i11;
        eVar.f18759d = j10;
        if (i12 == Integer.MAX_VALUE) {
            i12 = 65535;
        }
        eVar.f18758c = i12;
        eVar.f18760e = b10;
        eVar.f18761f = i13;
        eVar.f18764i = i14;
        eVar.f18762g = i15;
        eVar.f18763h = i16;
    }

    private void a(com.autonavi.aps.protocol.aps.request.model.fields.cell.b bVar, a.e eVar) {
        a(eVar, bVar.b_(), bVar.b(), bVar.d(), bVar.c(), bVar.e(), bVar.f(), 0, 0, 0);
    }

    private void a(com.autonavi.aps.protocol.aps.request.model.fields.cell.a aVar, a.e eVar) {
        eVar.f18756a = aVar.a_();
        a.d dVar = new a.d();
        dVar.f18753c = aVar.d();
        dVar.f18752b = aVar.c();
        dVar.f18751a = aVar.b();
        dVar.f18755e = aVar.f();
        dVar.f18754d = aVar.e();
        eVar.f18765j = dVar;
        eVar.f18760e = aVar.g();
        eVar.f18761f = aVar.h();
    }
}
