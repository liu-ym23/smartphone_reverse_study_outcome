package com.autonavi.aps.protocol.aps.impl.v56.b;

import com.autonavi.aps.protocol.aps.common.constant.Constant;
import com.autonavi.aps.protocol.aps.common.e.e;
import com.autonavi.aps.protocol.aps.common.enums.Status;
import com.autonavi.aps.protocol.aps.impl.v56.a.a;
import com.autonavi.aps.protocol.aps.impl.v56.a.c;
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
public class a extends com.autonavi.aps.protocol.aps.common.d.a<com.autonavi.aps.protocol.aps.impl.v56.vo.a, com.autonavi.aps.protocol.aps.request.model.message.a> {

    /* renamed from: com.autonavi.aps.protocol.aps.impl.v56.b.a$a, reason: collision with other inner class name */
    public static class C0209a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f18695a = new a();
    }

    public static a b() {
        return C0209a.f18695a;
    }

    private a.f c(com.autonavi.aps.protocol.aps.request.model.a.a aVar) {
        a.f fVar = new a.f();
        fVar.f18591a = aVar.i();
        fVar.f18592b = aVar.j();
        fVar.f18593c = aVar.k();
        if (com.autonavi.aps.protocol.aps.common.e.a.b(aVar.l())) {
            fVar.f18594d = aVar.l();
        }
        if (com.autonavi.aps.protocol.aps.common.e.a.b(aVar.m())) {
            fVar.f18595e = aVar.m();
        }
        if (aVar.o() != null) {
            fVar.f18596f = aVar.o().toString();
        }
        fVar.f18597g = aVar.p();
        fVar.f18598h = aVar.q();
        fVar.f18599i = aVar.r();
        fVar.f18600j = aVar.s();
        fVar.f18601k = aVar.t();
        if (com.autonavi.aps.protocol.aps.common.e.a.b(aVar.u())) {
            fVar.f18602l = aVar.u();
        }
        fVar.f18603m = aVar.h();
        return fVar;
    }

    private a.g d(com.autonavi.aps.protocol.aps.request.model.a.a aVar) {
        a.g gVar = new a.g();
        if (aVar.M() != null) {
            gVar.f18604a = aVar.M().a();
        }
        if (aVar.O() != null) {
            gVar.f18605b = aVar.O().a();
        }
        if (aVar.P() != null) {
            gVar.f18606c = aVar.P();
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
                    eVar.f18583d = bVar.d();
                    eVar.f18585f = bVar.e();
                    eVar.f18582c = bVar.c();
                    eVar.f18590k = com.autonavi.aps.protocol.aps.common.e.a.a((byte) 1, (byte) 0, bVar.a() ? (byte) 1 : (byte) 0);
                } else if (b10 == 2) {
                    HistoryCells.a aVar2 = (HistoryCells.a) next;
                    eVar.f18585f = aVar2.f();
                    eVar.f18590k = com.autonavi.aps.protocol.aps.common.e.a.a((byte) 2, (byte) 0, aVar2.a() ? (byte) 1 : (byte) 0);
                    a.d dVar = new a.d();
                    dVar.f18575a = aVar2.c();
                    dVar.f18576b = aVar2.d();
                    dVar.f18577c = aVar2.e();
                    eVar.f18589j = dVar;
                } else if (b10 == 3) {
                    HistoryCells.c cVar = (HistoryCells.c) next;
                    eVar.f18583d = cVar.d();
                    eVar.f18585f = cVar.e();
                    eVar.f18582c = cVar.c();
                    eVar.f18590k = com.autonavi.aps.protocol.aps.common.e.a.a((byte) 3, (byte) 0, cVar.a() ? (byte) 1 : (byte) 0);
                } else if (b10 == 4) {
                    HistoryCells.e eVar2 = (HistoryCells.e) next;
                    eVar.f18583d = eVar2.d();
                    eVar.f18585f = eVar2.e();
                    eVar.f18582c = eVar2.c();
                    eVar.f18590k = com.autonavi.aps.protocol.aps.common.e.a.a((byte) 4, (byte) 0, eVar2.a() ? (byte) 1 : (byte) 0);
                } else if (b10 == 5) {
                    HistoryCells.d dVar2 = (HistoryCells.d) next;
                    eVar.f18583d = dVar2.d();
                    eVar.f18585f = dVar2.e();
                    eVar.f18582c = dVar2.c();
                    eVar.f18590k = com.autonavi.aps.protocol.aps.common.e.a.a((byte) 5, (byte) 0, dVar2.a() ? (byte) 1 : (byte) 0);
                }
                arrayList.add(eVar);
            }
            gVar.f18607d = arrayList;
        }
        TrackPoints trackPointsL = aVar.L();
        if (trackPointsL != null && trackPointsL.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<TrackPoints.a> it2 = trackPointsL.iterator();
            while (it2.hasNext()) {
                TrackPoints.a next2 = it2.next();
                a.b bVar2 = new a.b();
                bVar2.f18559b = (int) Math.round(next2.b() * 1000000.0d);
                bVar2.f18558a = (int) Math.round(next2.a() * 1200000.0d);
                bVar2.f18560c = next2.c();
                bVar2.f18561d = next2.d().getCode().byteValue();
                bVar2.f18562e = next2.e();
                arrayList2.add(bVar2);
            }
            gVar.f18608e = arrayList2;
        }
        HisLocCtxs hisLocCtxsR = aVar.R();
        if (hisLocCtxsR != null && hisLocCtxsR.size() > 0) {
            ArrayList arrayList3 = new ArrayList();
            Iterator<HisLocCtxs.a> it3 = hisLocCtxsR.iterator();
            while (it3.hasNext()) {
                HisLocCtxs.a next3 = it3.next();
                a.b bVar3 = new a.b();
                bVar3.f18559b = next3.c();
                bVar3.f18558a = next3.b();
                bVar3.f18560c = next3.d();
                bVar3.f18561d = HisLocCtxs.a.b(next3.e());
                bVar3.f18562e = next3.a();
                arrayList3.add(bVar3);
            }
            gVar.f18609f = arrayList3;
        }
        return gVar;
    }

    private List<a.i> e(com.autonavi.aps.protocol.aps.request.model.a.a aVar) {
        ArrayList arrayList = new ArrayList();
        com.autonavi.aps.protocol.aps.request.model.fields.wifi.b bVarJ = aVar.J();
        if (bVarJ != null) {
            a.i iVar = new a.i();
            iVar.f18614a = com.autonavi.aps.protocol.aps.common.e.a.c(bVarJ.a().a());
            iVar.f18615b = bVarJ.c();
            String strB = bVarJ.b();
            if (com.autonavi.aps.protocol.aps.common.e.a.b(strB)) {
                iVar.f18616c = strB;
            }
            iVar.f18617d = bVarJ.d();
            boolean zE = bVarJ.e();
            iVar.f18619f = com.autonavi.aps.protocol.aps.common.e.a.a(zE ? (byte) 1 : (byte) 0, (byte) 1, bVarJ.f());
            arrayList.add(iVar);
        }
        NbWifis nbWifisK = aVar.K();
        if (nbWifisK != null && nbWifisK.size() > 0) {
            Iterator<NbWifis.a> it = nbWifisK.iterator();
            while (it.hasNext()) {
                NbWifis.a next = it.next();
                a.i iVar2 = new a.i();
                iVar2.f18614a = com.autonavi.aps.protocol.aps.common.e.a.c(next.a().a());
                iVar2.f18615b = next.c();
                String strB2 = next.b();
                if (com.autonavi.aps.protocol.aps.common.e.a.b(strB2)) {
                    iVar2.f18616c = strB2;
                }
                iVar2.f18617d = next.d();
                iVar2.f18618e = next.e();
                iVar2.f18619f = 0;
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
            eVar.f18590k = com.autonavi.aps.protocol.aps.common.e.a.a(aVarG.i(), (byte) 0, (byte) 1);
            arrayList.add(eVar);
        }
        com.autonavi.aps.protocol.aps.request.model.fields.cell.b bVarF = aVar.F();
        if (bVarF != null) {
            a.e eVar2 = new a.e();
            aVar2.a(bVarF, eVar2);
            eVar2.f18590k = com.autonavi.aps.protocol.aps.common.e.a.a(bVarF.i(), (byte) 0, (byte) 1);
            arrayList.add(eVar2);
        }
        GsmNbCells gsmNbCellsH = aVar.H();
        if (gsmNbCellsH != null && gsmNbCellsH.size() > 0) {
            Iterator<GsmNbCells.a> it = gsmNbCellsH.iterator();
            while (it.hasNext()) {
                GsmNbCells.a next = it.next();
                a.e eVar3 = new a.e();
                eVar3.f18583d = next.b();
                eVar3.f18582c = next.a();
                eVar3.f18584e = next.c();
                eVar3.f18585f = next.d();
                eVar3.f18590k = com.autonavi.aps.protocol.aps.common.e.a.a(next.e(), (byte) 0, (byte) 0);
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
                    eVar4.f18588i = cVar.j();
                    eVar4.f18586g = cVar.g();
                    eVar4.f18587h = cVar.h();
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
                eVar4.f18590k = next2.a() ? com.autonavi.aps.protocol.aps.common.e.a.a(next2.i(), (byte) 1, (byte) 1) : com.autonavi.aps.protocol.aps.common.e.a.a(next2.i(), (byte) 1, (byte) 0);
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
                cVar.f18563a = com.autonavi.aps.protocol.aps.common.e.a.c(next.a().toString());
                if (com.autonavi.aps.protocol.aps.common.e.a.b(next.b())) {
                    cVar.f18564b = next.b().getBytes("UTF-8");
                }
                cVar.f18565c = next.c();
                cVar.f18566d = next.d();
                cVar.f18567e = next.e();
                cVar.f18568f = next.f();
                cVar.f18569g = next.g();
                if (com.autonavi.aps.protocol.aps.common.e.a.b(next.h())) {
                    cVar.f18570h = next.h();
                }
                cVar.f18571i = next.i();
                cVar.f18572j = next.j();
                cVar.f18573k = next.k();
                cVar.f18574l = next.l();
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    private a.C0206a h(com.autonavi.aps.protocol.aps.request.model.a.a aVar) {
        a.C0206a c0206a = new a.C0206a();
        c0206a.f18543a = aVar.w().toByte();
        c0206a.f18544b = aVar.x().toByte();
        c0206a.f18545c = aVar.y().toByte();
        c0206a.f18554l = aVar.f();
        c0206a.f18555m = aVar.g();
        c0206a.f18556n = aVar.e();
        c0206a.f18557o = aVar.n();
        c0206a.f18547e = (int) Math.round(aVar.A() * 1000000.0d);
        c0206a.f18546d = (int) Math.round(aVar.z() * 1000000.0d);
        c0206a.f18548f = aVar.B();
        c0206a.f18549g = aVar.C();
        c0206a.f18550h = aVar.D();
        c0206a.f18551i = aVar.E();
        if (aVar.d() != null) {
            c0206a.f18552j = aVar.d().a();
        }
        if (com.autonavi.aps.protocol.aps.common.e.a.b(aVar.v())) {
            c0206a.f18553k = aVar.v();
        }
        return c0206a;
    }

    @Override // com.autonavi.aps.protocol.aps.common.d.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.autonavi.aps.protocol.aps.impl.v56.vo.a a(com.autonavi.aps.protocol.aps.request.model.a.a aVar) {
        com.autonavi.aps.protocol.aps.impl.v56.vo.a aVar2 = new com.autonavi.aps.protocol.aps.impl.v56.vo.a();
        try {
            aVar2.a(aVar.b());
            aVar2.a(aVar.c());
            com.autonavi.aps.protocol.aps.impl.v56.a.a aVar3 = new com.autonavi.aps.protocol.aps.impl.v56.a.a();
            aVar3.f18535a = h(aVar);
            aVar3.f18536b.addAll(f(aVar));
            aVar3.f18537c.addAll(e(aVar));
            aVar3.f18538d = g(aVar);
            aVar3.f18540f = d(aVar);
            a.h hVar = new a.h();
            com.autonavi.aps.protocol.aps.request.model.fields.a.a aVarS = aVar.S();
            if (aVarS != null) {
                hVar.f18610a = aVarS.a();
                hVar.f18611b = aVarS.b();
                hVar.f18612c = aVarS.c();
                hVar.f18613d = aVarS.d();
            }
            aVar3.f18539e = hVar;
            aVar3.f18541g = c(aVar);
            if (aVar.T() != null && aVar.T().length != 0) {
                aVar3.f18542h = aVar.T();
            }
            aVar2.a(aVar3);
            return aVar2;
        } catch (Exception unused) {
            aVar2.a(Status.REQ_ENC_ERROR);
            return aVar2;
        }
    }

    @Override // com.autonavi.aps.protocol.aps.common.d.e
    public com.autonavi.aps.protocol.aps.impl.v56.vo.a a(com.autonavi.aps.protocol.aps.request.model.message.a aVar) {
        com.autonavi.aps.protocol.aps.impl.v56.vo.a aVar2 = new com.autonavi.aps.protocol.aps.impl.v56.vo.a();
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
            aVar2.a((com.autonavi.aps.protocol.aps.impl.v56.a.a) new com.autonavi.aps.protocol.aps.impl.v56.a.a().a(c.a(bArrA, 0, bArrA.length)));
        } catch (Exception unused2) {
            aVar2.a(Status.RES_DEC_ERROR);
        }
        return aVar2;
    }

    @Override // com.autonavi.aps.protocol.aps.common.d.e
    public com.autonavi.aps.protocol.aps.request.model.message.a a(com.autonavi.aps.protocol.aps.impl.v56.vo.a aVar) {
        com.autonavi.aps.protocol.aps.request.model.message.a aVar2 = new com.autonavi.aps.protocol.aps.request.model.message.a();
        aVar2.a(aVar.c());
        aVar2.a(aVar.d());
        try {
            com.autonavi.aps.protocol.aps.impl.v56.a.e eVar = new com.autonavi.aps.protocol.aps.impl.v56.a.e();
            aVar.a().a(eVar);
            byte[] bArrA = eVar.a();
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
        eVar.f18580a = i10;
        if (i11 == Integer.MAX_VALUE) {
            i11 = 65535;
        }
        eVar.f18581b = i11;
        eVar.f18583d = j10;
        if (i12 == Integer.MAX_VALUE) {
            i12 = 65535;
        }
        eVar.f18582c = i12;
        eVar.f18584e = b10;
        eVar.f18585f = i13;
        eVar.f18588i = i14;
        eVar.f18586g = i15;
        eVar.f18587h = i16;
    }

    private void a(com.autonavi.aps.protocol.aps.request.model.fields.cell.b bVar, a.e eVar) {
        a(eVar, bVar.b_(), bVar.b(), bVar.d(), bVar.c(), bVar.e(), bVar.f(), 0, 0, 0);
    }

    private void a(com.autonavi.aps.protocol.aps.request.model.fields.cell.a aVar, a.e eVar) {
        eVar.f18580a = aVar.a_();
        a.d dVar = new a.d();
        dVar.f18577c = aVar.d();
        dVar.f18576b = aVar.c();
        dVar.f18575a = aVar.b();
        dVar.f18579e = aVar.f();
        dVar.f18578d = aVar.e();
        eVar.f18589j = dVar;
        eVar.f18584e = aVar.g();
        eVar.f18585f = aVar.h();
    }
}
