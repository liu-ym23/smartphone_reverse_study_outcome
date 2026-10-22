package p5;

import a4.w;
import a4.z;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.lifecycle.a1;
import androidx.lifecycle.b1;
import androidx.lifecycle.c1;
import androidx.lifecycle.s0;
import androidx.lifecycle.v0;
import androidx.lifecycle.y0;
import androidx.room.a0;
import androidx.room.b0;
import androidx.work.impl.WorkDatabase_Impl;
import com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface;
import java.lang.invoke.VarHandle;
import java.nio.ByteBuffer;
import java.text.FieldPosition;
import java.text.MessageFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import o1.x;
import o1.y;
import p.p0;
import r.k0;
import r.l0;
import s.l1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i implements l1, x0.e {
    public static boolean i = false;

    /* renamed from: c, reason: collision with root package name */
    public Object f9730c;

    /* renamed from: f, reason: collision with root package name */
    public Object f9731f;

    /* renamed from: g, reason: collision with root package name */
    public Object f9732g;

    /* renamed from: h, reason: collision with root package name */
    public Object f9733h;

    public i(Typeface typeface, b4.b bVar) {
        int i3;
        int i10;
        int i11;
        int i12;
        this.f9733h = typeface;
        this.f9730c = bVar;
        this.f9732g = new w(1024);
        int iA = bVar.a(6);
        if (iA != 0) {
            int i13 = iA + bVar.f1897c;
            i3 = ((ByteBuffer) bVar.f1900h).getInt(((ByteBuffer) bVar.f1900h).getInt(i13) + i13);
        } else {
            i3 = 0;
        }
        this.f9731f = new char[i3 * 2];
        int iA2 = bVar.a(6);
        if (iA2 != 0) {
            int i14 = iA2 + bVar.f1897c;
            i10 = ((ByteBuffer) bVar.f1900h).getInt(((ByteBuffer) bVar.f1900h).getInt(i14) + i14);
        } else {
            i10 = 0;
        }
        for (int i15 = 0; i15 < i10; i15++) {
            z zVar = new z();
            zVar.f219c = 0;
            zVar.f218b = this;
            zVar.f217a = i15;
            VarHandle.storeStoreFence();
            b4.a aVarB = zVar.b();
            int iA3 = aVarB.a(4);
            Character.toChars(iA3 != 0 ? ((ByteBuffer) aVarB.f1900h).getInt(iA3 + aVarB.f1897c) : 0, (char[]) this.f9731f, i15 * 2);
            b4.a aVarB2 = zVar.b();
            int iA4 = aVarB2.a(16);
            if (iA4 != 0) {
                int i16 = iA4 + aVarB2.f1897c;
                i11 = ((ByteBuffer) aVarB2.f1900h).getInt(((ByteBuffer) aVarB2.f1900h).getInt(i16) + i16);
            } else {
                i11 = 0;
            }
            f.h("invalid metadata codepoint length", i11 > 0);
            w wVar = (w) this.f9732g;
            b4.a aVarB3 = zVar.b();
            int iA5 = aVarB3.a(16);
            if (iA5 != 0) {
                int i17 = iA5 + aVarB3.f1897c;
                i12 = ((ByteBuffer) aVarB3.f1900h).getInt(((ByteBuffer) aVarB3.f1900h).getInt(i17) + i17);
            } else {
                i12 = 0;
            }
            wVar.a(zVar, 0, i12 - 1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A() {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p5.i.A():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r8v8, types: [sc.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object B(pb.c r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof v3.m0
            if (r0 == 0) goto L13
            r0 = r9
            v3.m0 r0 = (v3.m0) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.i = r1
            goto L18
        L13:
            v3.m0 r0 = new v3.m0
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.f14681g
            ob.a r1 = ob.a.f9351c
            int r2 = r0.i
            r3 = 2
            r4 = 1
            jb.v r5 = jb.v.f6774a
            r6 = 0
            if (r2 == 0) goto L44
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L33
            sc.a r8 = r0.f14680f
            p5.i r0 = r0.f14679c
            id.c.I(r9)     // Catch: java.lang.Throwable -> L31
            goto L80
        L31:
            r9 = move-exception
            goto L8f
        L33:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r8)
            r8 = 0
            return r8
        L3a:
            sc.a r8 = r0.f14680f
            p5.i r2 = r0.f14679c
            id.c.I(r9)
            r9 = r8
            r8 = r2
            goto L63
        L44:
            id.c.I(r9)
            java.lang.Object r9 = r8.f9731f
            kc.l r9 = (kc.l) r9
            boolean r9 = r9.M()
            if (r9 == 0) goto L52
            return r5
        L52:
            java.lang.Object r9 = r8.f9730c
            sc.c r9 = (sc.c) r9
            r0.f14679c = r8
            r0.f14680f = r9
            r0.i = r4
            java.lang.Object r2 = r9.d(r0)
            if (r2 != r1) goto L63
            goto L7d
        L63:
            java.lang.Object r2 = r8.f9731f     // Catch: java.lang.Throwable -> L8b
            kc.l r2 = (kc.l) r2     // Catch: java.lang.Throwable -> L8b
            boolean r2 = r2.M()     // Catch: java.lang.Throwable -> L8b
            if (r2 == 0) goto L71
            r9.e(r6)
            return r5
        L71:
            r0.f14679c = r8     // Catch: java.lang.Throwable -> L8b
            r0.f14680f = r9     // Catch: java.lang.Throwable -> L8b
            r0.i = r3     // Catch: java.lang.Throwable -> L8b
            java.lang.Object r0 = r8.p(r0)     // Catch: java.lang.Throwable -> L8b
            if (r0 != r1) goto L7e
        L7d:
            return r1
        L7e:
            r0 = r8
            r8 = r9
        L80:
            java.lang.Object r9 = r0.f9731f     // Catch: java.lang.Throwable -> L31
            kc.l r9 = (kc.l) r9     // Catch: java.lang.Throwable -> L31
            r9.O(r5)     // Catch: java.lang.Throwable -> L31
            r8.e(r6)
            return r5
        L8b:
            r8 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
        L8f:
            r8.e(r6)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p5.i.B(pb.c):java.lang.Object");
    }

    public void C(o1.j jVar) {
        if (((x) this.f9731f) == x.f9099f) {
            s1.q qVar = (s1.q) this.f9730c;
            if (qVar == null) {
                od.f.e("layoutCoordinates not set");
                return;
            }
            o1.q.e(jVar, qVar.D(0L), new y((o1.z) this.f9733h, 1), true);
        }
        this.f9731f = x.f9100g;
    }

    public void D(h5.j jVar) {
        jVar.getClass();
        a0 a0Var = new a0(4);
        a0Var.f1506f = this;
        a0Var.f1507g = jVar;
        VarHandle.storeStoreFence();
        synchronized (this.f9732g) {
        }
        ((Handler) ((a2.i) this.f9730c).f49f).postDelayed(a0Var, 5400000L);
    }

    @Override // s.j1
    public long b(s.n nVar, s.n nVar2, s.n nVar3) {
        ec.a aVarC = f.O(0, nVar.b()).iterator();
        long jMax = 0;
        while (aVarC.f3752h) {
            int iNextInt = aVarC.nextInt();
            jMax = Math.max(jMax, ((s.o) this.f9730c).get(iNextInt).c(nVar.a(iNextInt), nVar2.a(iNextInt), nVar3.a(iNextInt)));
        }
        return jMax;
    }

    public int c(String str) throws NumberFormatException {
        String string = ((ta.a) this.f9732g).f13291a.getString("event_filters", "");
        if (!TextUtils.isEmpty(string)) {
            for (String str2 : string.split(",")) {
                String str3 = str2.split(":")[0];
                int i3 = Integer.parseInt(str2.split(":")[1]);
                if (str3.equals(str)) {
                    return i3;
                }
            }
        }
        return 1;
    }

    public qa.c d() throws PackageManager.NameNotFoundException {
        Bundle bundle;
        PackageInfo packageInfo;
        qa.c cVar = new qa.c();
        cVar.f10213c = new ConcurrentHashMap();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        cVar.f10214d = concurrentHashMap;
        long jCurrentTimeMillis = System.currentTimeMillis();
        concurrentHashMap.put("debug", Boolean.FALSE);
        cVar.d("stepos_ver", Build.DISPLAY);
        ua.c.a("c", "##### Subject step 1, " + (System.currentTimeMillis() - jCurrentTimeMillis));
        Context context = (Context) this.f9730c;
        if (context != null) {
            ua.c.d("c", "setContextualParams start");
            qa.b bVar = new qa.b();
            bVar.f10210c = context;
            cVar.f10211a = bVar.b();
            qa.a aVar = new qa.a();
            aVar.f10209a = new HashMap();
            PackageManager packageManager = context.getPackageManager();
            String strValueOf = "0";
            if (packageManager != null) {
                try {
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
                    if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && bundle.get("uxip_channel_num") != null) {
                        strValueOf = String.valueOf(applicationInfo.metaData.get("uxip_channel_num"));
                    }
                } catch (PackageManager.NameNotFoundException e10) {
                    ua.c.f("AppInfo", "Exception: " + e10.toString() + " - Cause: " + e10.getCause());
                }
            }
            aVar.f10209a.put("channel_id", strValueOf);
            ua.c.e("AppInfo", "AppInfo created successfully.");
            cVar.f10212b = aVar;
            boolean zIsEmpty = TextUtils.isEmpty((String) this.f9733h);
            Context context2 = (Context) this.f9730c;
            if (zIsEmpty) {
                String packageName = context2.getPackageName();
                cVar.d("pkg_name", packageName);
                cVar.d("pkg_ver", ra.b.d(context2, packageName));
                cVar.c(ra.b.c(context2, packageName), "pkg_ver_code");
            } else {
                String str = (String) this.f9733h;
                ua.c.a("c", "### setReplacePackage, replacePackage: " + str);
                try {
                    packageInfo = context2.getPackageManager().getPackageInfo(str, 16384);
                } catch (PackageManager.NameNotFoundException e11) {
                    ua.c.b("c", "setReplacePackage error, " + e11.getMessage());
                    packageInfo = null;
                }
                String packageName2 = context2.getPackageName();
                String strD = ra.b.d(context2, packageName2);
                String str2 = ra.b.c(context2, packageName2) + "";
                if (packageInfo != null) {
                    cVar.d("pkg_name", packageInfo.packageName);
                    cVar.d("pkg_ver", packageInfo.versionName);
                    cVar.c(packageInfo.versionCode, "pkg_ver_code");
                    ua.c.a("c", "setReplacePackage, packageInfo: " + packageInfo);
                } else {
                    cVar.d("pkg_name", packageName2);
                    cVar.d("pkg_ver", strD);
                    cVar.d("pkg_ver_code", str2);
                }
                cVar.f10213c.put("_my_pkg_name_", packageName2);
                cVar.f10213c.put("_my_pkg_ver_", strD);
                cVar.f10213c.put("_my_pkg_ver_code_", str2);
            }
            cVar.d("pkg_key", (String) this.f9731f);
            cVar.c(0, "pkg_type");
            cVar.d("sdk_ver", (String) this.f9732g);
        }
        ua.c.a("c", "##### Subject step 2, " + (System.currentTimeMillis() - jCurrentTimeMillis));
        ua.c.a("c", "Subject created successfully.");
        VarHandle.storeStoreFence();
        return cVar;
    }

    public void e(Context context, com.stepos.statsapp.v3.lib.plugin.emitter.remote.f fVar) {
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(new Intent("com.stepos.dataservice.action.vccOfflineStats"), 64);
        ua.c.a("V3RemoteServiceReq", "queryIntentServices for ACTION_VCC_OFFLINE_STATS: " + listQueryIntentServices);
        Iterator<ResolveInfo> it = listQueryIntentServices.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ResolveInfo next = it.next();
            ServiceInfo serviceInfo = next.serviceInfo;
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            if ("com.stepos.dataservice".equals(str)) {
                ua.c.a("V3RemoteServiceReq", "choose serviceName---" + str2 + " pkgName---" + str);
                this.f9730c = next.serviceInfo;
                break;
            }
        }
        if (fVar != null) {
            this.f9733h = fVar;
        }
    }

    public void f(Context context, String str, String str2, String str3, List list, List list2) {
        if (j(context)) {
            try {
                ((IVccOfflineStatsInterface) this.f9731f).emitterBulkAddEvents(str, str2, str3, list, list2);
            } catch (Throwable th) {
                ua.c.b("V3RemoteServiceReq", "emitterBulkAddEvents error: " + th.getMessage());
            }
        }
    }

    public void g(String str, long j10, long j11, long j12) {
        if (((ta.a) this.f9732g).f13291a.getBoolean("active", true) && c(str) != -1) {
            com.stepos.statsrpk.a aVar = new com.stepos.statsrpk.a();
            aVar.f2844c = "page";
            aVar.f2845f = str;
            aVar.f2846g = str;
            HashMap map = new HashMap();
            map.put("start", String.valueOf(j10));
            map.put("end", String.valueOf(j11));
            map.put("duration2", String.valueOf(j12));
            aVar.f2847h = map;
            aVar.i = ((com.stepos.statsrpk.i) this.f9733h).f2872c.i();
            ((u) this.f9730c).c(aVar, (com.stepos.statsrpk.b) this.f9731f);
        }
    }

    @Override // s.j1
    public s.n h(long j10, s.n nVar, s.n nVar2, s.n nVar3) {
        if (((s.n) this.f9732g) == null) {
            this.f9732g = nVar3.c();
        }
        s.n nVar4 = (s.n) this.f9732g;
        if (nVar4 == null) {
            yb.k.f("velocityVector");
            throw null;
        }
        int iB = nVar4.b();
        int i3 = 0;
        while (true) {
            s.n nVar5 = (s.n) this.f9732g;
            if (i3 >= iB) {
                if (nVar5 != null) {
                    return nVar5;
                }
                yb.k.f("velocityVector");
                throw null;
            }
            if (nVar5 == null) {
                yb.k.f("velocityVector");
                throw null;
            }
            nVar5.e(((s.o) this.f9730c).get(i3).b(j10, nVar.a(i3), nVar2.a(i3), nVar3.a(i3)), i3);
            i3++;
        }
    }

    public String i() {
        if (((String) this.f9732g) == null) {
            synchronized (this) {
                this.f9732g = UUID.randomUUID().toString();
                ua.c.a("RpkPageController", "generate a sessionId: " + ((String) this.f9732g));
            }
        }
        return (String) this.f9732g;
    }

    public boolean j(Context context) {
        if (((ServiceInfo) this.f9730c) == null) {
            ua.c.f("V3RemoteServiceReq", "checkRemoteInterface, remote service is null, reinitialize");
            e(context, null);
        }
        if (((ServiceInfo) this.f9730c) == null) {
            ua.c.b("V3RemoteServiceReq", "checkRemoteInterface fail, unable get remote service");
            return false;
        }
        if (((IVccOfflineStatsInterface) this.f9731f) == null) {
            ua.c.f("V3RemoteServiceReq", "checkRemoteInterface, remote interface is null, rebind service");
            if (((ServiceInfo) this.f9730c) == null) {
                ua.c.d("V3RemoteServiceReq", "offline service is null,unable to bind");
            } else {
                synchronized (((com.stepos.statsapp.v3.lib.plugin.emitter.remote.h) this.f9732g)) {
                    Intent intent = new Intent();
                    intent.setAction("com.stepos.dataservice.action.vccOfflineStats");
                    intent.setPackage(((ServiceInfo) this.f9730c).packageName);
                    ServiceInfo serviceInfo = (ServiceInfo) this.f9730c;
                    intent.setComponent(new ComponentName(serviceInfo.packageName, serviceInfo.name));
                    try {
                        boolean zBindService = context.bindService(intent, (com.stepos.statsapp.v3.lib.plugin.emitter.remote.h) this.f9732g, 33);
                        ua.c.a("V3RemoteServiceReq", "bindService, " + ((com.stepos.statsapp.v3.lib.plugin.emitter.remote.h) this.f9732g) + " result: " + zBindService);
                        if (zBindService) {
                            ((com.stepos.statsapp.v3.lib.plugin.emitter.remote.h) this.f9732g).wait(3000L);
                            ua.c.a("V3RemoteServiceReq", "serviceConn wait END");
                        }
                    } catch (Exception e10) {
                        ua.c.b("V3RemoteServiceReq", "Exception:" + e10 + " - Cause:" + e10.getCause());
                    }
                }
            }
        }
        if (((IVccOfflineStatsInterface) this.f9731f) != null) {
            return true;
        }
        ua.c.b("V3RemoteServiceReq", "checkRemoteInterface fail, unable get remote interface");
        return false;
    }

    @Override // s.j1
    public s.n k(long j10, s.n nVar, s.n nVar2, s.n nVar3) {
        if (((s.n) this.f9731f) == null) {
            this.f9731f = nVar.c();
        }
        s.n nVar4 = (s.n) this.f9731f;
        if (nVar4 == null) {
            yb.k.f("valueVector");
            throw null;
        }
        int iB = nVar4.b();
        int i3 = 0;
        while (true) {
            s.n nVar5 = (s.n) this.f9731f;
            if (i3 >= iB) {
                if (nVar5 != null) {
                    return nVar5;
                }
                yb.k.f("valueVector");
                throw null;
            }
            if (nVar5 == null) {
                yb.k.f("valueVector");
                throw null;
            }
            nVar5.e(((s.o) this.f9730c).get(i3).e(j10, nVar.a(i3), nVar2.a(i3), nVar3.a(i3)), i3);
            i3++;
        }
    }

    public void l(h5.j jVar) {
        Runnable runnable;
        jVar.getClass();
        synchronized (this.f9732g) {
            runnable = (Runnable) ((LinkedHashMap) this.f9733h).remove(jVar);
        }
        if (runnable != null) {
            ((Handler) ((a2.i) this.f9730c).f49f).removeCallbacks(runnable);
        }
    }

    public void m(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            od.f.o("This graph contains cyclic dependencies");
            return;
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) ((p0) this.f9731f).get(obj);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i3 = 0; i3 < size; i3++) {
                m(arrayList2.get(i3), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, java.util.Collection, java.util.List] */
    public void n(o1.j jVar, boolean z10) {
        o1.z zVar = (o1.z) this.f9733h;
        ?? r12 = jVar.f9056a;
        int size = r12.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((o1.s) r12.get(i3)).b()) {
                C(jVar);
                return;
            }
        }
        s1.q qVar = (s1.q) this.f9730c;
        if (qVar == null) {
            od.f.e("layoutCoordinates not set");
            return;
        }
        o1.q.e(jVar, qVar.D(0L), new b0.n(9, this, zVar), false);
        if (((x) this.f9731f) == x.f9099f) {
            if (z10) {
                int size2 = r12.size();
                for (int i10 = 0; i10 < size2; i10++) {
                    ((o1.s) r12.get(i10)).a();
                }
            }
            ma.a aVar = jVar.f9057b;
            if (aVar != null) {
                aVar.f8532a = !zVar.f9106g;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x005f, code lost:
    
        if (r7 == r2) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006e, code lost:
    
        if (r7 == r2) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object p(pb.c r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f9733h
            v3.z r0 = (v3.z) r0
            boolean r1 = r7 instanceof v3.g
            if (r1 == 0) goto L17
            r1 = r7
            v3.g r1 = (v3.g) r1
            int r2 = r1.f14636h
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.f14636h = r2
            goto L1c
        L17:
            v3.g r1 = new v3.g
            r1.<init>(r6, r7)
        L1c:
            java.lang.Object r7 = r1.f14634f
            ob.a r2 = ob.a.f9351c
            int r3 = r1.f14636h
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L3d
            if (r3 == r5) goto L37
            if (r3 != r4) goto L30
            p5.i r6 = r1.f14633c
            id.c.I(r7)
            goto L62
        L30:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r6)
            r6 = 0
            return r6
        L37:
            p5.i r6 = r1.f14633c
            id.c.I(r7)
            goto L71
        L3d:
            id.c.I(r7)
            java.lang.Object r7 = r6.f9732g
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L65
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L4d
            goto L65
        L4d:
            v3.p0 r7 = r0.g()
            v3.j r3 = new v3.j
            r5 = 0
            r3.<init>(r0, r6, r5)
            r1.f14633c = r6
            r1.f14636h = r4
            java.lang.Object r7 = r7.b(r3, r1)
            if (r7 != r2) goto L62
            goto L70
        L62:
            v3.c r7 = (v3.c) r7
            goto L73
        L65:
            r1.f14633c = r6
            r1.f14636h = r5
            r7 = 0
            java.lang.Object r7 = v3.z.f(r0, r7, r1)
            if (r7 != r2) goto L71
        L70:
            return r2
        L71:
            v3.c r7 = (v3.c) r7
        L73:
            java.lang.Object r6 = r6.f9733h
            v3.z r6 = (v3.z) r6
            androidx.room.k r6 = r6.f14758l
            r6.c(r7)
            jb.v r6 = jb.v.f6774a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p5.i.p(pb.c):java.lang.Object");
    }

    public void q(Runnable runnable) {
        ((b0) this.f9730c).execute(runnable);
    }

    @Override // s.j1
    public s.n s(s.n nVar, s.n nVar2, s.n nVar3) {
        if (((s.n) this.f9733h) == null) {
            this.f9733h = nVar3.c();
        }
        s.n nVar4 = (s.n) this.f9733h;
        if (nVar4 == null) {
            yb.k.f("endVelocityVector");
            throw null;
        }
        int iB = nVar4.b();
        int i3 = 0;
        while (true) {
            s.n nVar5 = (s.n) this.f9733h;
            if (i3 >= iB) {
                if (nVar5 != null) {
                    return nVar5;
                }
                yb.k.f("endVelocityVector");
                throw null;
            }
            if (nVar5 == null) {
                yb.k.f("endVelocityVector");
                throw null;
            }
            nVar5.e(((s.o) this.f9730c).get(i3).d(nVar.a(i3), nVar2.a(i3), nVar3.a(i3)), i3);
            i3++;
        }
    }

    public void t(ArrayDeque arrayDeque, Object obj) {
        synchronized (this) {
            if (!arrayDeque.remove(obj)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        A();
    }

    public void u(ed.g gVar) {
        gVar.f3797f.decrementAndGet();
        t((ArrayDeque) this.f9732g, gVar);
    }

    public String v(String str, Locale locale, Object... objArr) {
        String string;
        Map map = (Map) ((ConcurrentHashMap) this.f9731f).computeIfAbsent(locale, new a8.b(1));
        int i3 = 0;
        a8.d dVar = new a8.d(i3);
        dVar.f236b = this;
        dVar.f237c = locale;
        VarHandle.storeStoreFence();
        String str2 = (String) map.computeIfAbsent(str, dVar);
        str2.getClass();
        if (!str2.isEmpty()) {
            str = str2;
        }
        if (objArr == null || objArr.length == 0) {
            return str;
        }
        Map map2 = (Map) ((ConcurrentHashMap) this.f9732g).computeIfAbsent(locale, new a8.b(i3));
        a8.c cVar = new a8.c(i3);
        cVar.f234b = locale;
        VarHandle.storeStoreFence();
        MessageFormat messageFormat = (MessageFormat) map2.computeIfAbsent(str, cVar);
        synchronized (messageFormat) {
            string = messageFormat.format(objArr, new StringBuffer(), (FieldPosition) null).toString();
        }
        return string;
    }

    public g w(j jVar) {
        jVar.getClass();
        String str = jVar.f9734a;
        int i3 = jVar.f9735b;
        androidx.room.x xVarD = androidx.room.x.d(2, "SELECT * FROM SystemIdInfo WHERE work_spec_id=? AND generation=?");
        xVarD.h(1, str);
        xVarD.c(2, i3);
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f9730c;
        workDatabase_Impl.b();
        Cursor cursorD = td.h.D(workDatabase_Impl, xVarD, false);
        try {
            return cursorD.moveToFirst() ? new g(cursorD.getString(f.z(cursorD, "work_spec_id")), cursorD.getInt(f.z(cursorD, "generation")), cursorD.getInt(f.z(cursorD, "system_id"))) : null;
        } finally {
            cursorD.close();
            xVarD.e();
        }
    }

    public s.n x(long j10, s.n nVar, s.n nVar2) {
        if (((s.n) this.f9732g) == null) {
            this.f9732g = nVar.c();
        }
        s.n nVar3 = (s.n) this.f9732g;
        if (nVar3 == null) {
            yb.k.f("velocityVector");
            throw null;
        }
        int iB = nVar3.b();
        int i3 = 0;
        while (true) {
            s.n nVar4 = (s.n) this.f9732g;
            if (i3 >= iB) {
                if (nVar4 != null) {
                    return nVar4;
                }
                yb.k.f("velocityVector");
                throw null;
            }
            if (nVar4 == null) {
                yb.k.f("velocityVector");
                throw null;
            }
            a1.g gVar = (a1.g) this.f9730c;
            nVar.getClass();
            long j11 = j10 / 1000000;
            k0 k0VarA = ((l0) gVar.f19f).a(nVar2.a(i3));
            long j12 = k0VarA.f10311c;
            nVar4.e((((Math.signum(k0VarA.f10309a) * r.b.a(j12 > 0 ? j11 / j12 : 1.0f).f10242b) * k0VarA.f10310b) / j12) * 1000.0f, i3);
            i3++;
        }
    }

    public y0 y(yb.e eVar, String str) {
        y0 y0Var;
        y0 y0VarA;
        synchronized (((j4.b) this.f9733h)) {
            try {
                c1 c1Var = (c1) this.f9730c;
                c1Var.getClass();
                y0Var = (y0) c1Var.f1366a.get(str);
                if (eVar.d(y0Var)) {
                    a1 a1Var = (a1) this.f9731f;
                    if (a1Var instanceof v0) {
                        v0 v0Var = (v0) a1Var;
                        y0Var.getClass();
                        androidx.lifecycle.q qVar = v0Var.f1446h;
                        if (qVar != null) {
                            t4.d dVar = v0Var.i;
                            dVar.getClass();
                            s0.a(y0Var, dVar, qVar);
                        }
                    }
                    y0Var.getClass();
                } else {
                    h4.c cVar = new h4.c((h4.b) this.f9732g);
                    cVar.f5290a.put(b1.f1361b, str);
                    a1 a1Var2 = (a1) this.f9731f;
                    try {
                        try {
                            y0VarA = a1Var2.b(eVar, cVar);
                        } catch (AbstractMethodError unused) {
                            Class cls = eVar.f16088a;
                            cls.getClass();
                            y0VarA = a1Var2.a(cls);
                        }
                    } catch (AbstractMethodError unused2) {
                        Class cls2 = eVar.f16088a;
                        cls2.getClass();
                        y0VarA = a1Var2.c(cls2, cVar);
                    }
                    y0Var = y0VarA;
                    c1 c1Var2 = (c1) this.f9730c;
                    c1Var2.getClass();
                    y0Var.getClass();
                    y0 y0Var2 = (y0) c1Var2.f1366a.put(str, y0Var);
                    if (y0Var2 != null) {
                        y0Var2.b();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return y0Var;
    }

    public void z(g gVar) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f9730c;
        workDatabase_Impl.b();
        workDatabase_Impl.c();
        try {
            ((b) this.f9731f).e(gVar);
            workDatabase_Impl.v();
        } finally {
            workDatabase_Impl.q();
        }
    }

    public i() {
        this.f9730c = null;
    }

    public i(s.o oVar) {
        this.f9730c = oVar;
    }

    public i(s.y yVar) {
        a1.g gVar = new a1.g(28, false);
        gVar.f19f = yVar;
        VarHandle.storeStoreFence();
        this(gVar);
    }
}
