package a9;

import android.database.Cursor;
import android.util.Log;
import androidx.work.impl.WorkDatabase_Impl;
import com.stepos.agentsafetycenter.mcp.service.AbilityService;
import g5.r;
import g5.u;
import h5.d0;
import h5.e0;
import h5.t;
import h5.w;
import h5.x;
import h5.y;
import h5.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import p5.s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Callable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f241c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f242f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f243g;

    public /* synthetic */ a(int i) {
        this.f241c = i;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Object objL;
        Object objL2;
        z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        boolean z10 = false;
        switch (this.f241c) {
            case 0:
                AbilityService abilityService = ((b) this.f243g).f245b;
                Map map = ((b9.a) this.f242f).f2043b;
                try {
                    boolean zJ = a.a.j(map.get("recursive"));
                    jb.g gVarB0 = a.a.b0(a.a.T(map));
                    String str = (String) gVarB0.f6759c;
                    List list = (List) gVarB0.f6760f;
                    Set set = p9.a.f9925a;
                    Log.i("FileRestore", "handle path=" + p9.a.d(str) + " paths=" + (list != null ? list.size() : 0) + " recursive=" + zJ);
                    if (t.B(abilityService)) {
                        j jVarS = new p5.e(abilityService).s(str, list, zJ);
                        b.a(jVarS);
                        objL = ac.a.e0(jVarS);
                    } else {
                        Log.w("FileRestore", "handle denied: missing media/external storage permission");
                        objL = ac.a.e0(f7.f.g(c.f252m, "缺少媒体文件读取或外部存储管理权限"));
                    }
                } catch (Throwable th) {
                    objL = id.c.l(th);
                }
                Throwable thB = jb.i.b(objL);
                Object objE0 = objL;
                if (thB != null) {
                    Log.e("FileRestore", "handle exception", thB);
                    c cVar = c.f252m;
                    String message = thB.getMessage();
                    if (message == null) {
                        message = "Restore failed";
                    }
                    objE0 = ac.a.e0(f7.f.g(cVar, message));
                }
                return (b9.b) objE0;
            case 1:
                AbilityService abilityService2 = ((b) this.f243g).f245b;
                b9.a aVar = (b9.a) this.f242f;
                Map map2 = aVar.f2043b;
                try {
                    boolean zJ2 = a.a.j(map2.get("recursive"));
                    jb.g gVarB02 = a.a.b0(a.a.T(map2));
                    String str2 = (String) gVarB02.f6759c;
                    List list2 = (List) gVarB02.f6760f;
                    Set set2 = p9.a.f9925a;
                    Log.i("FileSafeDelete", "handle path=" + p9.a.d(str2) + " paths=" + (list2 != null ? list2.size() : 0) + " recursive=" + zJ2);
                    if (t.B(abilityService2)) {
                        j jVarV = new p5.e(abilityService2).v(str2, list2, zJ2);
                        b.b(jVarV);
                        String strH = t.n.h(aVar);
                        lb.c cVarO = ac.a.o();
                        if (str2 != null) {
                            cVarO.add(str2);
                        }
                        if (list2 != null) {
                            Iterator it = list2.iterator();
                            while (it.hasNext()) {
                                cVarO.add((String) it.next());
                            }
                        }
                        t0.a.i(abilityService2, strH, ac.a.k(cVarO), jVarV);
                        objL2 = ac.a.e0(jVarV);
                    } else {
                        Log.w("FileSafeDelete", "handle denied: missing media/external storage permission");
                        objL2 = ac.a.e0(f7.f.g(c.f249j, "缺少媒体文件读取或外部存储管理权限"));
                    }
                } catch (Throwable th2) {
                    objL2 = id.c.l(th2);
                }
                Throwable thB2 = jb.i.b(objL2);
                Object objE02 = objL2;
                if (thB2 != null) {
                    Log.e("FileSafeDelete", "handle exception", thB2);
                    c cVar2 = c.f249j;
                    String message2 = thB2.getMessage();
                    if (message2 == null) {
                        message2 = "Trash failed";
                    }
                    objE02 = ac.a.e0(f7.f.g(cVar2, message2));
                }
                return (b9.b) objE02;
            default:
                z zVar = (z) this.f243g;
                d0 d0Var = (d0) this.f242f;
                String str3 = d0Var.f5327c;
                s sVar = d0Var.f5332h;
                if (zVar instanceof x) {
                    g5.s pVar = ((x) zVar).f5388a;
                    int i = sVar.i(str3);
                    p5.m mVarB = d0Var.f5331g.B();
                    WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) mVarB.f9741f;
                    workDatabase_Impl.b();
                    p5.h hVar = (p5.h) mVarB.f9742g;
                    z4.j jVarA = hVar.a();
                    jVarA.h(1, str3);
                    try {
                        workDatabase_Impl.c();
                        try {
                            jVarA.d();
                            workDatabase_Impl.v();
                            if (i != 0) {
                                if (i == 2) {
                                    p5.p pVar2 = d0Var.f5325a;
                                    String str4 = d0Var.f5334k;
                                    if (pVar instanceof r) {
                                        String str5 = e0.f5338a;
                                        u.d().e(str5, "Worker result SUCCESS for " + str4);
                                        if (pVar2.c()) {
                                            d0Var.c();
                                        } else {
                                            sVar.p(3, str3);
                                            g5.h hVar2 = ((r) pVar).f4337a;
                                            hVar2.getClass();
                                            sVar.o(str3, hVar2);
                                            d0Var.f5330f.getClass();
                                            long jCurrentTimeMillis = System.currentTimeMillis();
                                            p5.c cVar3 = d0Var.i;
                                            ArrayList arrayListL = cVar3.l(str3);
                                            int size = arrayListL.size();
                                            int i3 = 0;
                                            while (i3 < size) {
                                                Object obj = arrayListL.get(i3);
                                                i3++;
                                                String str6 = (String) obj;
                                                if (sVar.i(str6) == 5) {
                                                    androidx.room.x xVarD = androidx.room.x.d(1, "SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)");
                                                    xVarD.h(1, str6);
                                                    WorkDatabase_Impl workDatabase_Impl2 = (WorkDatabase_Impl) cVar3.f9717f;
                                                    workDatabase_Impl2.b();
                                                    Cursor cursorD = td.h.D(workDatabase_Impl2, xVarD, false);
                                                    try {
                                                        if (cursorD.moveToFirst() && cursorD.getInt(0) != 0) {
                                                            u.d().e(e0.f5338a, "Setting status to enqueued for ".concat(str6));
                                                            sVar.p(1, str6);
                                                            sVar.n(str6, jCurrentTimeMillis);
                                                        }
                                                    } finally {
                                                        cursorD.close();
                                                        xVarD.e();
                                                    }
                                                }
                                            }
                                        }
                                    } else if (pVar instanceof g5.q) {
                                        String str7 = e0.f5338a;
                                        u.d().e(str7, "Worker result RETRY for " + str4);
                                        d0Var.b(-256);
                                        z10 = true;
                                    } else {
                                        String str8 = e0.f5338a;
                                        u.d().e(str8, "Worker result FAILURE for " + str4);
                                        if (pVar2.c()) {
                                            d0Var.c();
                                        } else {
                                            if (pVar == null) {
                                                pVar = new g5.p();
                                            }
                                            d0Var.d(pVar);
                                        }
                                    }
                                } else if (!androidx.activity.b.a(i)) {
                                    d0Var.b(-512);
                                    z10 = true;
                                }
                            }
                        } finally {
                            workDatabase_Impl.q();
                        }
                    } finally {
                        hVar.c(jVarA);
                    }
                } else if (zVar instanceof w) {
                    d0Var.d(((w) zVar).f5387a);
                } else {
                    if (!(zVar instanceof y)) {
                        g5.f.a();
                        return null;
                    }
                    int i10 = ((y) zVar).f5389a;
                    int i11 = sVar.i(str3);
                    if (i11 == 0 || androidx.activity.b.a(i11)) {
                        String str9 = e0.f5338a;
                        u uVarD = u.d();
                        StringBuilder sbO = androidx.activity.b.o("Status for ", str3, " is ");
                        sbO.append(androidx.activity.b.z(i11));
                        sbO.append(" ; not doing any work");
                        uVarD.a(str9, sbO.toString());
                    } else {
                        String str10 = e0.f5338a;
                        u uVarD2 = u.d();
                        StringBuilder sbO2 = androidx.activity.b.o("Status for ", str3, " is ");
                        sbO2.append(androidx.activity.b.z(i11));
                        sbO2.append("; not doing any work and rescheduling for later execution");
                        uVarD2.a(str10, sbO2.toString());
                        sVar.p(1, str3);
                        sVar.q(i10, str3);
                        sVar.l(str3, -1L);
                        z10 = true;
                    }
                }
                return Boolean.valueOf(z10);
        }
    }
}
