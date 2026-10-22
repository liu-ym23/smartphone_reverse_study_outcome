package u1;

import A2.h;
import D7.v;
import F9.E;
import F9.F;
import F9.x;
import F9.y;
import L8.f;
import L8.q;
import L8.s;
import M0.i;
import N9.j;
import T8.D;
import T8.g;
import X8.w;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;
import com.apm.insight.AttachUserData;
import com.apm.insight.CrashType;
import com.apm.insight.entity.Header;
import com.stepos.statsapp.v3.lib.plugin.IVccOfflineStatsInterface;
import com.stepos.statsrpk.RpkEvent;
import com.stepos.statsrpk.RpkInfo;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import com.stepos.widget.list.StepOSCardPosition;
import g9.l;
import h8.C1542y;
import h8.C1543z;
import h8.InterfaceC1503K;
import h8.InterfaceC1506N;
import h8.InterfaceC1522e;
import h8.InterfaceC1540w;
import i8.InterfaceC1556b;
import java.io.File;
import java.io.IOException;
import java.text.FieldPosition;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import k2.C1621a;
import k8.Q;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment;
import m8.C1681a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qa.C1849a;
import qa.C1850b;
import qa.G;
import qa.N;
import v0.C2054a;
import w0.C2086g;
import z8.C2193e;
import z8.n;
import z8.o;
import z8.p;
import z8.r;

/* loaded from: classes2.dex */
public class d implements g, Ua.b, l7.b, p, n, o {
    public static d f = null;
    public static volatile d g = null;
    public static boolean h = false;
    public static final Object i = new Object();

    /* renamed from: j, reason: collision with root package name */
    public static d f6688j;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6689a;
    public Object b;
    public Object c;
    public Object d;
    public Object e;

    public /* synthetic */ d(int i6, boolean z10) {
        this.f6689a = i6;
    }

    public static d B() {
        if (f6688j == null) {
            Context context = com.apm.insight.g.f2160a;
            d dVar = new d(25, false);
            dVar.e = null;
            File file = new File(j.C(context), "apminsight/RuntimeContext");
            if (!file.exists() || (!file.isDirectory() && file.delete())) {
                file.mkdirs();
                A2.e.f82x = true;
            }
            dVar.b = file;
            dVar.c = new File(file, "did");
            dVar.d = new File(file, "device_uuid");
            f6688j = dVar;
        }
        return f6688j;
    }

    public static d s() {
        if (g == null) {
            Context context = com.apm.insight.g.f2160a;
            if (context == null) {
                throw new IllegalArgumentException("NpthBus not init");
            }
            d dVar = new d(1, false);
            dVar.c = new HashMap();
            dVar.b = context;
            try {
                dVar.d = A2.e.c();
                h hVar = new h();
                hVar.b = -1L;
                dVar.e = hVar;
            } catch (Throwable th) {
                int i6 = com.apm.insight.b.f2156a;
                i.k("NPTH_CATCH", th);
            }
            g = dVar;
        }
        return g;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A(java.util.Map r11, org.json.JSONArray r12) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.d.A(java.util.Map, org.json.JSONArray):void");
    }

    @Override // z8.o
    public void C(f fVar) {
        ((ArrayList) this.b).add(new s(new q(fVar)));
    }

    public void D() {
        synchronized (i) {
            try {
                if (((A.d) this.c) == null) {
                    A.c cVar = new A.c("io-task");
                    cVar.b = new C2054a(this);
                    this.c = new A.d(cVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String E() {
        if (((String) this.c) == null) {
            synchronized (this) {
                this.c = UUID.randomUUID().toString();
                W5.c.a("RpkPageController", "generate a sessionId: " + ((String) this.c));
            }
        }
        return (String) this.c;
    }

    public JSONArray F(long j5) {
        File file;
        String strW;
        Iterator it = N(".allData").iterator();
        while (true) {
            if (!it.hasNext()) {
                file = null;
                break;
            }
            z2.n nVar = (z2.n) it.next();
            if (j5 >= nVar.f6937a && j5 <= nVar.b) {
                file = nVar.c;
                break;
            }
        }
        if (file == null) {
            Iterator it2 = N(".allData").iterator();
            z2.n nVar2 = null;
            while (it2.hasNext()) {
                z2.n nVar3 = (z2.n) it2.next();
                if (nVar2 == null || Math.abs(nVar2.b - j5) > Math.abs(nVar3.b - j5)) {
                    nVar2 = nVar3;
                }
            }
            file = nVar2 == null ? null : nVar2.c;
        }
        if (file != null) {
            try {
                strW = M.a.w(file.getAbsolutePath());
                try {
                    return new JSONArray(strW);
                } catch (Throwable th) {
                    th = th;
                    int i6 = com.apm.insight.b.f2156a;
                    i.k("NPTH_CATCH", new IOException(B7.a.k("content :", strW), th));
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                strW = null;
            }
        }
        return null;
    }

    public void G() {
        synchronized (i) {
            try {
                if (((A.d) this.d) == null) {
                    A.c cVar = new A.c("light-weight-task");
                    cVar.b = new C2086g(this);
                    this.d = new A.d(cVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean H(Context context) {
        if (((ServiceInfo) this.b) == null) {
            W5.c.f("V3RemoteServiceReq", "checkRemoteInterface, remote service is null, reinitialize");
            v(context, null);
        }
        if (((ServiceInfo) this.b) == null) {
            W5.c.b("V3RemoteServiceReq", "checkRemoteInterface fail, unable get remote service");
            return false;
        }
        if (((IVccOfflineStatsInterface) this.c) == null) {
            W5.c.f("V3RemoteServiceReq", "checkRemoteInterface, remote interface is null, rebind service");
            if (((ServiceInfo) this.b) == null) {
                W5.c.d("V3RemoteServiceReq", "offline service is null,unable to bind");
            } else {
                synchronized (((com.stepos.statsapp.v3.lib.plugin.emitter.remote.f) this.d)) {
                    Intent intent = new Intent();
                    intent.setAction("com.stepos.dataservice.action.vccOfflineStats");
                    intent.setPackage(((ServiceInfo) this.b).packageName);
                    ServiceInfo serviceInfo = (ServiceInfo) this.b;
                    intent.setComponent(new ComponentName(serviceInfo.packageName, serviceInfo.name));
                    try {
                        boolean zBindService = context.bindService(intent, (com.stepos.statsapp.v3.lib.plugin.emitter.remote.f) this.d, 33);
                        W5.c.a("V3RemoteServiceReq", "bindService, " + ((com.stepos.statsapp.v3.lib.plugin.emitter.remote.f) this.d) + " result: " + zBindService);
                        if (zBindService) {
                            ((com.stepos.statsapp.v3.lib.plugin.emitter.remote.f) this.d).wait(3000L);
                            W5.c.a("V3RemoteServiceReq", "serviceConn wait END");
                        }
                    } catch (Exception e) {
                        W5.c.b("V3RemoteServiceReq", "Exception:" + e + " - Cause:" + e.getCause());
                    }
                }
            }
        }
        if (((IVccOfflineStatsInterface) this.c) != null) {
            return true;
        }
        W5.c.b("V3RemoteServiceReq", "checkRemoteInterface fail, unable get remote interface");
        return false;
    }

    public void I(String str) {
        Objects.requireNonNull(str, "baseUrl == null");
        x xVar = new x(0);
        xVar.j(null, str);
        y yVarD = xVar.d();
        if ("".equals(yVarD.f.get(r0.size() - 1))) {
            this.c = yVarD;
        } else {
            throw new IllegalArgumentException("baseUrl must end in /: " + yVarD);
        }
    }

    public N J() {
        ArrayList arrayList = (ArrayList) this.d;
        if (((y) this.c) == null) {
            throw new IllegalStateException("Base URL required.");
        }
        F f7 = (F) this.b;
        if (f7 == null) {
            f7 = new F(new E());
        }
        F f9 = f7;
        U5.d dVar = G.f5629a;
        C1849a c1849a = G.c;
        ArrayList arrayList2 = new ArrayList((ArrayList) this.e);
        List listA = c1849a.a(dVar);
        arrayList2.addAll(listA);
        List listB = c1849a.b();
        ArrayList arrayList3 = new ArrayList(arrayList.size() + 1 + listB.size());
        arrayList3.add(new C1850b(0));
        arrayList3.addAll(arrayList);
        arrayList3.addAll(listB);
        y yVar = (y) this.c;
        List listUnmodifiableList = Collections.unmodifiableList(arrayList3);
        List listUnmodifiableList2 = Collections.unmodifiableList(arrayList2);
        listA.size();
        return new N(f9, yVar, listUnmodifiableList, listUnmodifiableList2, dVar);
    }

    public void K() {
        synchronized (i) {
            try {
                if (((A.d) this.e) == null) {
                    A.c cVar = new A.c("time-sensitive-task");
                    cVar.b = new A0.b(this, 11);
                    this.e = new A.d(cVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // z8.o
    public n L(G8.b bVar) {
        ArrayList arrayList = new ArrayList();
        return new d(((C2193e) this.c).e(bVar, InterfaceC1503K.f4577I, arrayList), this, arrayList);
    }

    public void M(AttachUserData attachUserData, CrashType crashType) {
        List arrayList;
        HashMap map = (HashMap) this.b;
        if (map.get(crashType) == null) {
            arrayList = new ArrayList();
            map.put(crashType, arrayList);
        } else {
            arrayList = (List) map.get(crashType);
        }
        arrayList.add(attachUserData);
    }

    public ArrayList N(String str) {
        File[] fileArrListFiles = ((File) this.b).listFiles(new X9.a(str, 1));
        ArrayList arrayList = new ArrayList();
        if (fileArrListFiles != null) {
            S0.b.N("foundRuntimeContextFiles " + fileArrListFiles.length);
            z2.n nVar = null;
            for (File file : fileArrListFiles) {
                try {
                    z2.n nVar2 = new z2.n(file);
                    arrayList.add(nVar2);
                    if (((z2.n) this.e) == null && ".ctx".equals(str) && (nVar == null || nVar2.b >= nVar.b)) {
                        nVar = nVar2;
                    }
                } catch (Throwable th) {
                    int i6 = com.apm.insight.b.f2156a;
                    i.k("NPTH_CATCH", th);
                    try {
                        file.delete();
                    } catch (Throwable unused) {
                    }
                }
            }
            if (((z2.n) this.e) == null && nVar != null) {
                this.e = nVar;
            }
        }
        return arrayList;
    }

    public void O(AttachUserData attachUserData, CrashType crashType) {
        List arrayList;
        HashMap map = (HashMap) this.c;
        if (map.get(crashType) == null) {
            arrayList = new ArrayList();
            map.put(crashType, arrayList);
        } else {
            arrayList = (List) map.get(crashType);
        }
        arrayList.add(attachUserData);
    }

    public void P(AttachUserData attachUserData, CrashType crashType) {
        List list = (List) ((HashMap) this.b).get(crashType);
        if (list != null) {
            list.remove(attachUserData);
        }
    }

    public void Q(AttachUserData attachUserData, CrashType crashType) {
        List list = (List) ((HashMap) this.c).get(crashType);
        if (list != null) {
            list.remove(attachUserData);
        }
    }

    public Ua.h R(Ua.c cVar) {
        ArrayList arrayList = (ArrayList) this.d;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            Ua.h hVar = (Ua.h) arrayList.get(i6);
            if (hVar != null && hVar.b == cVar) {
                return hVar;
            }
        }
        Ua.h hVar2 = new Ua.h((Context) this.c, cVar);
        arrayList.add(hVar2);
        return hVar2;
    }

    public InterfaceC1522e S(G8.b classId, List typeParametersCount) {
        k.f(classId, "classId");
        k.f(typeParametersCount, "typeParametersCount");
        return (InterfaceC1522e) ((W8.e) this.e).invoke(new C1543z(classId, typeParametersCount));
    }

    public String T(String str, Locale locale, Object... objArr) {
        String string;
        String str2 = (String) ((Map) ((ConcurrentHashMap) this.c).computeIfAbsent(locale, new reactor.util.retry.a(5))).computeIfAbsent(str, new y3.b(this, locale, 0));
        str2.getClass();
        if (!str2.isEmpty()) {
            str = str2;
        }
        if (objArr == null || objArr.length == 0) {
            return str;
        }
        MessageFormat messageFormat = (MessageFormat) ((Map) ((ConcurrentHashMap) this.d).computeIfAbsent(locale, new reactor.util.retry.a(4))).computeIfAbsent(str, new Ba.g(locale, 12));
        synchronized (messageFormat) {
            string = messageFormat.format(objArr, new StringBuffer(), (FieldPosition) null).toString();
        }
        return string;
    }

    public boolean U(InterfaceC1506N descriptor) {
        k.f(descriptor, "descriptor");
        if (k.b((InterfaceC1506N) this.c, descriptor)) {
            return true;
        }
        d dVar = (d) this.b;
        return dVar != null ? dVar.U(descriptor) : false;
    }

    public F1.b V(int i6, G8.b bVar, C1681a c1681a) {
        r rVar = new r(((r) this.b).f6988a + '@' + i6);
        O2.a aVar = (O2.a) this.e;
        HashMap map = (HashMap) aVar.c;
        List arrayList = (List) map.get(rVar);
        if (arrayList == null) {
            arrayList = new ArrayList();
            map.put(rVar, arrayList);
        }
        return ((C2193e) aVar.b).f(bVar, c1681a, arrayList);
    }

    @Override // Ua.b
    public boolean a(Ua.c cVar, Menu menu) {
        ActionMode.Callback callback = (ActionMode.Callback) this.b;
        Ua.h hVarR = R(cVar);
        SimpleArrayMap simpleArrayMap = (SimpleArrayMap) this.e;
        Menu menu2 = (Menu) simpleArrayMap.get(menu);
        if (menu2 == null) {
            Va.E e = new Va.E((Context) this.c, (SupportMenu) menu);
            simpleArrayMap.put(menu, e);
            menu2 = e;
        }
        return callback.onCreateActionMode(hVarR, menu2);
    }

    @Override // Ua.b
    public boolean b(Ua.c cVar, Menu menu) {
        ActionMode.Callback callback = (ActionMode.Callback) this.b;
        Ua.h hVarR = R(cVar);
        SimpleArrayMap simpleArrayMap = (SimpleArrayMap) this.e;
        Menu menu2 = (Menu) simpleArrayMap.get(menu);
        if (menu2 == null) {
            Va.E e = new Va.E((Context) this.c, (SupportMenu) menu);
            simpleArrayMap.put(menu, e);
            menu2 = e;
        }
        return callback.onPrepareActionMode(hVarR, menu2);
    }

    @Override // z8.p
    public n c(G8.b bVar, C1681a c1681a) {
        return ((C2193e) ((O2.a) this.d).b).f(bVar, c1681a, (ArrayList) this.c);
    }

    @Override // Ua.b
    public void d(Ua.c cVar) {
        ((ActionMode.Callback) this.b).onDestroyActionMode(R(cVar));
    }

    @Override // T8.g
    public T8.f e(G8.b classId) {
        k.f(classId, "classId");
        ProtoBuf$Class protoBuf$Class = (ProtoBuf$Class) ((LinkedHashMap) this.e).get(classId);
        if (protoBuf$Class == null) {
            return null;
        }
        D8.g gVar = (D8.g) this.b;
        C8.a aVar = (C8.a) this.c;
        ((D) this.d).invoke(classId);
        return new T8.f(gVar, protoBuf$Class, aVar, InterfaceC1503K.f4577I);
    }

    @Override // Ua.b
    public boolean f(Ua.c cVar, MenuItem menuItem) {
        return ((ActionMode.Callback) this.b).onActionItemClicked(R(cVar), new Va.x((Context) this.c, (SupportMenuItem) menuItem));
    }

    @Override // z8.o
    public void f0(G8.b bVar, G8.f fVar) {
        ((ArrayList) this.b).add(new L8.i(bVar, fVar));
    }

    public int g(String str) throws NumberFormatException {
        String string = ((V5.a) this.d).f1385a.getString("event_filters", "");
        if (!TextUtils.isEmpty(string)) {
            for (String str2 : string.split(",")) {
                String str3 = str2.split(":")[0];
                int i6 = Integer.parseInt(str2.split(":")[1]);
                if (str3.equals(str)) {
                    return i6;
                }
            }
        }
        return 1;
    }

    public A.d h(z.c cVar) {
        cc.dd.aa.cc.cc.b bVarB = cVar.b();
        if (bVarB == cc.dd.aa.cc.cc.b.f2129a) {
            if (((A.d) this.c) == null) {
                D();
            }
            return (A.d) this.c;
        }
        if (bVarB == cc.dd.aa.cc.cc.b.b) {
            if (((A.d) this.e) == null) {
                K();
            }
            return (A.d) this.e;
        }
        if (((A.d) this.d) == null) {
            G();
        }
        return (A.d) this.d;
    }

    public A2.g i(CrashType crashType) {
        A2.a aVar;
        h hVar = (h) this.e;
        A2.e eVar = (A2.e) this.d;
        Context context = (Context) this.b;
        HashMap map = (HashMap) this.c;
        A2.g iVar = (A2.g) map.get(crashType);
        if (iVar != null) {
            return iVar;
        }
        switch (A2.j.f91a[crashType.ordinal()]) {
            case 1:
                aVar = new A2.a(CrashType.JAVA, context, eVar, hVar, 5);
                iVar = aVar;
                break;
            case 2:
                aVar = new A2.a(CrashType.LAUNCH, context, eVar, hVar, 6);
                iVar = aVar;
                break;
            case 3:
                aVar = new A2.a(CrashType.NATIVE, context, eVar, hVar, 7);
                iVar = aVar;
                break;
            case 4:
                aVar = new A2.a(CrashType.ANR, context, eVar, hVar, 0);
                iVar = aVar;
                break;
            case 5:
                aVar = new A2.a(CrashType.DART, context, eVar, hVar, 3);
                iVar = aVar;
                break;
            case 6:
                aVar = new A2.a(CrashType.CUSTOM_JAVA, context, eVar, hVar, 2);
                iVar = aVar;
                break;
            case 7:
                iVar = new A2.i(CrashType.BLOCK, context, eVar, hVar);
                break;
            case 8:
                iVar = new A2.k(CrashType.ENSURE, context, eVar, hVar);
                break;
            case 9:
                aVar = new A2.a(CrashType.EXIT, context, eVar, hVar, 4);
                iVar = aVar;
                break;
            case 10:
                aVar = new A2.a(CrashType.PORTRAIT, context, eVar, hVar, 1);
                iVar = aVar;
                break;
        }
        if (iVar != null) {
            map.put(crashType, iVar);
        }
        return iVar;
    }

    public Object j() {
        x.n nVar;
        Context context = (Context) this.e;
        x.o oVar = (x.o) this.d;
        CountDownLatch countDownLatch = (CountDownLatch) this.b;
        if (Looper.getMainLooper() != Looper.myLooper()) {
            try {
                nVar = new x.n(countDownLatch, oVar);
                context.bindService((Intent) this.c, nVar, 1);
                countDownLatch.await();
                try {
                    Object objB = oVar.b(nVar.c);
                    try {
                        context.unbindService(nVar);
                        return objB;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return objB;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                        return null;
                    } finally {
                        if (nVar != null) {
                            try {
                                context.unbindService(nVar);
                            } catch (Throwable th3) {
                                th3.printStackTrace();
                            }
                        }
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                nVar = null;
            }
        }
        return null;
    }

    @Override // z8.o
    public void j0(Object obj) {
        ((ArrayList) this.b).add(C2193e.h((C2193e) this.c, (G8.f) this.d, obj));
    }

    @Override // z8.n
    public void k() {
        switch (this.f6689a) {
            case 26:
                ArrayList arrayList = (ArrayList) this.c;
                if (!arrayList.isEmpty()) {
                    ((HashMap) ((O2.a) this.d).c).put((r) this.b, arrayList);
                    break;
                }
                break;
            case 27:
                ((F1.b) this.c).k();
                ((ArrayList) ((d) this.d).b).add(new L8.a((InterfaceC1556b) v.U0((ArrayList) this.e)));
                break;
            default:
                F1.b bVar = (F1.b) this.e;
                G8.f fVar = (G8.f) this.d;
                ArrayList elements = (ArrayList) this.b;
                bVar.getClass();
                k.f(elements, "elements");
                if (fVar != null) {
                    Q qB = com.stepos.ability.task.executor.e.B(fVar, (InterfaceC1522e) bVar.e);
                    if (qB == null) {
                        if (((C2193e) bVar.d).d((G8.b) bVar.f) && k.b(fVar.b(), "value")) {
                            ArrayList arrayList2 = new ArrayList();
                            Iterator it = elements.iterator();
                            while (it.hasNext()) {
                                Object next = it.next();
                                if (next instanceof L8.a) {
                                    arrayList2.add(next);
                                }
                            }
                            List list = (List) bVar.g;
                            Iterator it2 = arrayList2.iterator();
                            while (it2.hasNext()) {
                                list.add((InterfaceC1556b) ((L8.a) it2.next()).f939a);
                            }
                            break;
                        }
                    } else {
                        HashMap map = (HashMap) bVar.c;
                        List value = l.e(elements);
                        w type = qB.getType();
                        k.e(type, "getType(...)");
                        k.f(value, "value");
                        map.put(fVar, new L8.x(value, type));
                        break;
                    }
                }
                break;
        }
    }

    @Override // z8.n
    public n l(G8.b bVar, G8.f fVar) {
        return ((F1.b) this.b).l(bVar, fVar);
    }

    @Override // z8.n
    public void m(G8.f fVar, f fVar2) {
        ((F1.b) this.b).m(fVar, fVar2);
    }

    @Override // z8.n
    public o n(G8.f fVar) {
        return ((F1.b) this.b).n(fVar);
    }

    public n2.a o(CrashType crashType, A2.f fVar) {
        A2.g gVarI;
        if (crashType == null || (gVarI = i(crashType)) == null) {
            return null;
        }
        return gVarI.c(null, fVar, true);
    }

    @Override // l7.b
    public void onBindFailed(String str) {
        l7.b bVar = (l7.b) this.b;
        if (bVar != null) {
            bVar.onBindFailed(str);
        }
        S7.k kVar = (S7.k) this.e;
        if (kVar != null) {
            kVar.invoke(str);
        }
    }

    @Override // l7.b
    public void onConnected() {
        l7.b bVar = (l7.b) this.b;
        if (bVar != null) {
            bVar.onConnected();
        }
        ((com.zyql.agentfront.sdk.client.b) this.c).c = bVar;
        ((S7.a) this.d).invoke();
    }

    @Override // l7.b
    public void onDisconnected() {
        l7.b bVar = (l7.b) this.b;
        if (bVar != null) {
            bVar.onDisconnected();
        }
    }

    public n2.a p(CrashType crashType, n2.a aVar) {
        A2.g gVarI;
        return (crashType == null || (gVarI = i(crashType)) == null) ? aVar : gVarI.c(aVar, null, false);
    }

    public n2.a q(LinkedList linkedList, JSONArray jSONArray) {
        if (linkedList.isEmpty()) {
            return null;
        }
        n2.a aVar = new n2.a();
        JSONArray jSONArray2 = new JSONArray();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            jSONArray2.put(((n2.a) it.next()).f5345a);
        }
        aVar.e(jSONArray2, SettingsConfig.KEY_DATA);
        aVar.e(jSONArray, "all_data");
        Header headerA = Header.a();
        Header.addRuntimeHeader(headerA.f2158a);
        headerA.h();
        headerA.j();
        headerA.k();
        Header.f(headerA);
        aVar.d(headerA);
        return aVar;
    }

    public JSONObject r(long j5) {
        JSONObject jSONObject;
        File file;
        boolean z10;
        String strW;
        Iterator it = N(".ctx").iterator();
        while (true) {
            jSONObject = null;
            if (!it.hasNext()) {
                file = null;
                break;
            }
            z2.n nVar = (z2.n) it.next();
            if (j5 >= nVar.f6937a && j5 <= nVar.b) {
                file = nVar.c;
                break;
            }
        }
        if (file == null) {
            Iterator it2 = N(".ctx").iterator();
            z2.n nVar2 = null;
            while (it2.hasNext()) {
                z2.n nVar3 = (z2.n) it2.next();
                if (nVar2 == null || Math.abs(nVar2.b - j5) > Math.abs(nVar3.b - j5)) {
                    nVar2 = nVar3;
                }
            }
            file = nVar2 == null ? null : nVar2.c;
            z10 = true;
        } else {
            z10 = false;
        }
        if (file != null) {
            try {
                strW = M.a.w(file.getAbsolutePath());
                try {
                    jSONObject = new JSONObject(strW);
                } catch (Throwable th) {
                    th = th;
                    int i6 = com.apm.insight.b.f2156a;
                    i.k("NPTH_CATCH", new IOException(B7.a.k("content :", strW), th));
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("unauthentic_version", 1);
                        } catch (JSONException e) {
                            int i10 = com.apm.insight.b.f2156a;
                            i.k("NPTH_CATCH", e);
                        }
                    }
                    return jSONObject;
                }
            } catch (Throwable th2) {
                th = th2;
                strW = null;
            }
        }
        if (jSONObject != null && z10) {
            jSONObject.put("unauthentic_version", 1);
        }
        return jSONObject;
    }

    @Override // z8.n
    public void t(G8.f fVar, Object obj) {
        ((F1.b) this.b).t(fVar, obj);
    }

    public String toString() {
        switch (this.f6689a) {
            case 8:
                StringBuilder sb = new StringBuilder("CloudMessage{mParams='");
                sb.append((String) this.b);
                sb.append("', mType=");
                sb.append((String) this.c);
                sb.append(", send_time=0, command_id='");
                return B7.a.q(sb, (String) this.d, "'}");
            default:
                return super.toString();
        }
    }

    public void u(long j5, long j6, JSONObject jSONObject, JSONArray jSONArray) {
        File file = (File) this.b;
        StringBuilder sb = new StringBuilder("");
        sb.append(j5);
        sb.append("-");
        File file2 = new File(file, androidx.constraintlayout.core.dsl.a.e(j6, ".ctx", sb));
        StringBuilder sb2 = new StringBuilder("");
        sb2.append(j5);
        sb2.append("-");
        File file3 = new File(file, androidx.constraintlayout.core.dsl.a.e(j6, ".allData", sb2));
        try {
            M.a.p(file2, jSONObject);
            M.a.o(file3, jSONArray);
            this.e = new z2.n(file2);
        } catch (Exception e) {
            int i6 = com.apm.insight.b.f2156a;
            i.k("NPTH_CATCH", e);
        }
    }

    public void v(Context context, com.stepos.statsapp.v3.lib.plugin.emitter.remote.d dVar) {
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(new Intent("com.stepos.dataservice.action.vccOfflineStats"), 64);
        W5.c.a("V3RemoteServiceReq", "queryIntentServices for ACTION_VCC_OFFLINE_STATS: " + listQueryIntentServices);
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
                W5.c.a("V3RemoteServiceReq", "choose serviceName---" + str2 + " pkgName---" + str);
                this.b = next.serviceInfo;
                break;
            }
        }
        if (dVar != null) {
            this.e = dVar;
        }
    }

    public void w(Context context, String str, String str2, String str3, List list, List list2) {
        if (H(context)) {
            try {
                ((IVccOfflineStatsInterface) this.c).emitterBulkAddEvents(str, str2, str3, list, list2);
            } catch (Throwable th) {
                W5.c.b("V3RemoteServiceReq", "emitterBulkAddEvents error: " + th.getMessage());
            }
        }
    }

    public void x(AttachUserData attachUserData, CrashType crashType) {
        if (crashType != CrashType.ALL) {
            M(attachUserData, crashType);
            return;
        }
        M(attachUserData, CrashType.LAUNCH);
        M(attachUserData, CrashType.JAVA);
        M(attachUserData, CrashType.CUSTOM_JAVA);
        M(attachUserData, CrashType.NATIVE);
        M(attachUserData, CrashType.ANR);
        M(attachUserData, CrashType.DART);
    }

    @Override // z8.n
    public void y(G8.f fVar, G8.b bVar, G8.f fVar2) {
        ((F1.b) this.b).y(fVar, bVar, fVar2);
    }

    public void z(String str, long j5, long j6, long j10) {
        if (((V5.a) this.d).f1385a.getBoolean("active", true) && g(str) != -1) {
            RpkEvent rpkEvent = new RpkEvent();
            rpkEvent.f3975a = "page";
            rpkEvent.b = str;
            rpkEvent.c = str;
            HashMap map = new HashMap();
            map.put("start", String.valueOf(j5));
            map.put("end", String.valueOf(j6));
            map.put("duration2", String.valueOf(j10));
            rpkEvent.d = map;
            rpkEvent.e = ((com.stepos.statsrpk.e) this.e).c.E();
            ((C1621a) this.b).c(rpkEvent, (RpkInfo) this.c);
        }
    }

    public /* synthetic */ d(Object obj, Object obj2, Object obj3, Object obj4, int i6) {
        this.f6689a = i6;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
        this.e = obj4;
    }

    public d(Context context) {
        this.f6689a = 0;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.d = atomicBoolean;
        LinkedList linkedList = new LinkedList();
        this.e = linkedList;
        Context applicationContext = context.getApplicationContext();
        this.b = new ConcurrentHashMap();
        e eVar = new e(applicationContext, this, linkedList, atomicBoolean);
        this.c = eVar;
        eVar.start();
    }

    public d(Context context, Intent intent, x.o oVar) {
        this.f6689a = 22;
        this.e = context;
        this.c = intent;
        this.d = oVar;
        this.b = new CountDownLatch(1);
    }

    public d(int i6) {
        this.f6689a = i6;
        switch (i6) {
            case 3:
                this.b = null;
                break;
            case 11:
                this.d = new com.stepos.statsapp.v3.lib.plugin.emitter.remote.f(this);
                break;
            case 20:
                this.d = new ArrayList();
                this.e = new ArrayList();
                break;
            default:
                this.e = StepOSCardPosition.f4109a;
                break;
        }
    }

    public d(W8.i iVar, InterfaceC1540w module) {
        this.f6689a = 16;
        k.f(module, "module");
        this.b = iVar;
        this.c = module;
        this.d = iVar.c(new C1542y(this, 0));
        this.e = iVar.c(new C1542y(this, 1));
    }

    public d(ProtoBuf$PackageFragment protoBuf$PackageFragment, D8.g gVar, C8.a aVar, D d) {
        this.f6689a = 4;
        this.b = gVar;
        this.c = aVar;
        this.d = d;
        List list = protoBuf$PackageFragment.g;
        k.e(list, "getClass_List(...)");
        List list2 = list;
        int iP = kotlin.collections.a.P(D7.w.c0(list2, 10));
        LinkedHashMap linkedHashMap = new LinkedHashMap(iP < 16 ? 16 : iP);
        for (Object obj : list2) {
            linkedHashMap.put(j.s((D8.g) this.b, ((ProtoBuf$Class) obj).e), obj);
        }
        this.e = linkedHashMap;
    }

    public d(String[] strArr) {
        this.f6689a = 23;
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        this.e = Arrays.asList(strArr);
    }

    public d(O2.a aVar, r rVar) {
        this.f6689a = 26;
        this.e = aVar;
        this.f6689a = 26;
        this.d = aVar;
        this.b = rVar;
        this.c = new ArrayList();
    }

    public d(Context context, ActionMode.Callback callback) {
        this.f6689a = 5;
        this.c = context;
        this.b = callback;
        this.d = new ArrayList();
        this.e = new SimpleArrayMap();
    }

    public d(List list, Set modulesWhoseInternalsAreVisible, List directExpectedByDependencies, Set allExpectedByDependencies) {
        this.f6689a = 17;
        k.f(modulesWhoseInternalsAreVisible, "modulesWhoseInternalsAreVisible");
        k.f(directExpectedByDependencies, "directExpectedByDependencies");
        k.f(allExpectedByDependencies, "allExpectedByDependencies");
        this.b = list;
        this.c = modulesWhoseInternalsAreVisible;
        this.d = directExpectedByDependencies;
        this.e = allExpectedByDependencies;
    }

    public d(C2193e c2193e, G8.f fVar, F1.b bVar) {
        this.f6689a = 28;
        this.c = c2193e;
        this.d = fVar;
        this.e = bVar;
        this.b = new ArrayList();
    }

    public d(F1.b bVar, d dVar, ArrayList arrayList) {
        this.f6689a = 27;
        this.c = bVar;
        this.d = dVar;
        this.e = arrayList;
        this.b = bVar;
    }

    public d(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b bVar) {
        this.f6689a = 6;
        this.e = bVar;
        List list = bVar.e.f5032t;
        k.e(list, "getEnumEntryList(...)");
        List list2 = list;
        int iP = kotlin.collections.a.P(D7.w.c0(list2, 10));
        LinkedHashMap linkedHashMap = new LinkedHashMap(iP < 16 ? 16 : iP);
        for (Object obj : list2) {
            linkedHashMap.put(j.x(bVar.l.b, ((ProtoBuf$EnumEntry) obj).d), obj);
        }
        this.b = linkedHashMap;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b bVar2 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b) this.e;
        this.c = bVar2.l.f1228a.f1222a.d(new J4.f(2, this, bVar2));
        W8.i iVar = ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b) this.e).l.f1228a.f1222a;
        I8.e eVar = new I8.e(this, 6);
        iVar.getClass();
        this.d = new W8.h(iVar, eVar);
    }
}
