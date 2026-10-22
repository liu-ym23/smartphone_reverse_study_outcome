package K1;

import A5.c;
import F9.AbstractC0226d;
import F9.G;
import F9.K;
import F9.v;
import F9.w;
import F9.x;
import F9.y;
import H4.o;
import M.d;
import N9.j;
import Z6.k;
import a.AbstractC0291a;
import a7.AbstractC0307c;
import aa.InterfaceC0315b;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.BatteryManager;
import android.os.PowerManager;
import com.apm.insight.CrashType;
import com.apm.insight.g;
import com.fasterxml.jackson.core.JsonPointer;
import com.volcengine.tos.TosClientException;
import i8.InterfaceC1556b;
import j9.t;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import k2.C1621a;
import l2.C1655a;
import org.json.JSONObject;
import s2.C1912a;
import t8.C2024a;
import t8.InterfaceC2028e;
import w2.AbstractC2095a;
import w2.e;
import w2.f;
import w2.h;
import w2.i;
import z8.n;

/* loaded from: classes2.dex */
public final class a implements n2.b, n {
    public static volatile a f;

    /* renamed from: a, reason: collision with root package name */
    public Object f903a;
    public Object b;
    public Object c;
    public Object d;
    public Object e;

    public a(Context context) {
        J1.a aVar = J1.a.b;
        Context applicationContext = context.getApplicationContext();
        this.e = aVar;
        M1.a aVar2 = new M1.a(applicationContext, this);
        aVar2.e = false;
        aVar2.f = 0;
        aVar2.g = 0.0f;
        aVar2.h = 0L;
        aVar2.c = (PowerManager) applicationContext.getSystemService("power");
        aVar2.d = (BatteryManager) applicationContext.getSystemService("batterymanager");
        this.f903a = aVar2;
        O1.a aVar3 = new O1.a(applicationContext, this);
        aVar3.c = (PowerManager) applicationContext.getSystemService("power");
        this.b = aVar3;
        N1.a aVar4 = new N1.a(applicationContext, this);
        aVar4.c = false;
        new ArrayList();
        new ArrayList();
        new ArrayList();
        new HashMap();
        new HashMap();
        new ArrayList();
        new ArrayList();
        new ArrayList();
        new ArrayList();
        new HashMap();
        new HashMap();
        new ArrayList();
        new ArrayList();
        new ArrayList();
        this.c = aVar4;
        L1.a aVar5 = new L1.a();
        aVar5.b = false;
        aVar5.f929a = this;
        this.d = aVar5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public J1.b a() {
        M1.a aVar = (M1.a) this.f903a;
        J1.b bVar = new J1.b();
        String str = k.c;
        if (str == null) {
            Method method = P1.b.f1061a;
            if (method == null) {
                str = "";
                k.c = str;
            } else {
                try {
                    str = (String) method.invoke(null, "ro.board.platform", "");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e6) {
                    e6.printStackTrace();
                } catch (InvocationTargetException e9) {
                    e9.printStackTrace();
                }
                k.c = str;
            }
        }
        bVar.f863a = str;
        aVar.d();
        bVar.b = aVar.e;
        aVar.d();
        bVar.c = aVar.f;
        O1.a aVar2 = (O1.a) this.b;
        aVar2.getClass();
        PowerManager powerManager = aVar2.c;
        bVar.d = powerManager != null ? powerManager.getCurrentThermalStatus() : -1;
        M1.a aVar3 = (M1.a) this.f903a;
        aVar3.getClass();
        PowerManager powerManager2 = aVar3.c;
        bVar.e = powerManager2 != null ? powerManager2.isPowerSaveMode() : -1;
        aVar.d();
        bVar.f = aVar.g;
        ((J1.a) ((a) ((N1.a) this.c).b).e).getClass();
        return bVar;
    }

    public void b(String str, String value) {
        kotlin.jvm.internal.k.f(value, "value");
        ((v) this.c).c(str, value);
    }

    @Override // n2.b
    public void c(JSONObject jSONObject) {
        boolean zA;
        C1621a c1621a = (C1621a) this.c;
        i iVarA = i.a();
        File file = (File) this.f903a;
        Context context = ((f) this.e).f6835a;
        e eVar = (e) this.b;
        File fileG = j.g(context, eVar.f6834a);
        iVarA.getClass();
        try {
            zA = AbstractC2095a.a(g.g.getNativeCrashUploadUrl(), jSONObject.toString(), file, fileG, j.d(System.currentTimeMillis())).a();
        } catch (Throwable th) {
            S0.b.p0(th);
            zA = false;
        }
        if (zA) {
            if (!c1621a.t()) {
                String absolutePath = new File((File) ((c) c1621a.b).d, "upload.json").getAbsolutePath();
                C1655a c1655a = new C1655a();
                c1655a.f5272a = absolutePath;
                c1655a.b = System.currentTimeMillis();
                C1621a c1621aA = C1621a.a();
                synchronized (c1621aA) {
                    if (((C1912a) c1621aA.f4793a) == null) {
                        c1621aA.b(g.f2160a);
                    }
                    C1912a c1912a = (C1912a) c1621aA.f4793a;
                    if (c1912a != null) {
                        c1912a.d((SQLiteDatabase) c1621aA.b, c1655a);
                    }
                }
            }
            o.e(j.k(g.f2160a, eVar.f6834a), file.getName());
            h.a(CrashType.NATIVE, (JSONObject) this.d);
            eVar.h = true;
        }
    }

    public G d() {
        Map mapUnmodifiableMap;
        y yVar = (y) this.f903a;
        if (yVar == null) {
            throw new IllegalStateException("url == null");
        }
        String str = (String) this.b;
        w wVarG = ((v) this.c).g();
        K k = (K) this.d;
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.e;
        byte[] bArr = G9.b.f704a;
        kotlin.jvm.internal.k.f(linkedHashMap, "<this>");
        if (linkedHashMap.isEmpty()) {
            mapUnmodifiableMap = kotlin.collections.a.M();
        } else {
            mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(linkedHashMap));
            kotlin.jvm.internal.k.e(mapUnmodifiableMap, "{\n    Collections.unmodi…(LinkedHashMap(this))\n  }");
        }
        return new G(yVar, str, wVarG, k, mapUnmodifiableMap);
    }

    public String e(String str, String str2, String str3, ArrayList arrayList, ArrayList arrayList2, OffsetDateTime offsetDateTime, S6.a aVar) {
        String str4 = (String) this.b;
        StringBuilder sb = new StringBuilder(512);
        sb.append(str);
        sb.append('\n');
        DateTimeFormatter dateTimeFormatter = a7.e.f1650a;
        sb.append((str2 == null || str2.isEmpty()) ? "/" : a7.f.g(str2, false));
        sb.append('\n');
        sb.append(a7.e.a(arrayList2));
        sb.append('\n');
        ArrayList arrayList3 = new ArrayList(arrayList.size());
        Collections.sort(arrayList, new d(4));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str5 = (String) entry.getKey();
            arrayList3.add(str5);
            sb.append(str5);
            sb.append(':');
            sb.append(entry.getValue() == null ? "" : (String) entry.getValue());
            sb.append('\n');
        }
        sb.append('\n');
        sb.append(AbstractC0291a.z(";", arrayList3));
        sb.append('\n');
        if (AbstractC0291a.y(str3)) {
            sb.append(str3);
        } else {
            sb.append("e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855");
        }
        String string = sb.toString();
        InterfaceC0315b interfaceC0315b = a7.f.e;
        interfaceC0315b.j(string, "canonical request:\n{}");
        StringBuilder sb2 = new StringBuilder(144);
        sb2.append("TOS4-HMAC-SHA256\n");
        sb2.append(offsetDateTime.format(a7.e.b));
        sb2.append('\n');
        String str6 = offsetDateTime.format(a7.e.f1650a);
        sb2.append(str6);
        sb2.append(JsonPointer.SEPARATOR);
        sb2.append(str4);
        sb2.append("/tos/request\n");
        sb2.append(a7.e.d(a7.e.c(string)));
        interfaceC0315b.j(sb2.toString(), "string to sign:\n {}");
        String str7 = aVar.c;
        Charset charset = StandardCharsets.UTF_8;
        return String.valueOf(a7.e.d(a7.e.b(a7.e.b(a7.e.b(a7.e.b(a7.e.b(str7.getBytes(charset), str6.getBytes(charset)), str4.getBytes(charset)), "tos".getBytes(charset)), "request".getBytes(charset)), sb2.toString().getBytes(charset))));
    }

    public void f() throws InterruptedException {
        Z6.a aVar = (Z6.a) this.e;
        ArrayList arrayList = (ArrayList) this.b;
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.f903a;
        Iterator it = ((ArrayList) this.d).iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(threadPoolExecutor.submit(((Z6.h) it.next()).b()));
            } finally {
                threadPoolExecutor.shutdown();
            }
        }
        try {
            try {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((ArrayList) this.c).add(((Future) it2.next()).get());
                }
                try {
                    threadPoolExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    if (aVar != null) {
                        aVar.a();
                    }
                    throw new TosClientException("tos: await executor terminated failed", e);
                }
            } catch (InterruptedException e6) {
                throw new TosClientException("tos: execute interrupted", e6);
            }
        } catch (CancellationException e9) {
            throw new TosClientException("tos: execute canceled", e9);
        } catch (ExecutionException e10) {
            if (aVar != null) {
                aVar.a();
            }
            throw new TosClientException("tos: execute failed", e10);
        }
    }

    public void g(String name, String value) {
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(value, "value");
        v vVar = (v) this.c;
        vVar.getClass();
        AbstractC0226d.b(name);
        AbstractC0226d.c(value, name);
        vVar.h(name);
        vVar.d(name, value);
    }

    public void h(String method, K k) {
        kotlin.jvm.internal.k.f(method, "method");
        if (method.length() <= 0) {
            throw new IllegalArgumentException("method.isEmpty() == true");
        }
        if (k == null) {
            if (method.equals("POST") || method.equals("PUT") || method.equals("PATCH") || method.equals("PROPPATCH") || method.equals("REPORT")) {
                throw new IllegalArgumentException(B7.a.m("method ", method, " must have a request body.").toString());
            }
        } else if (!M0.i.B(method)) {
            throw new IllegalArgumentException(B7.a.m("method ", method, " must not have a request body.").toString());
        }
        this.b = method;
        this.d = k;
    }

    public void i(K body) {
        kotlin.jvm.internal.k.f(body, "body");
        h("POST", body);
    }

    public void j() {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.f903a;
        if (threadPoolExecutor != null) {
            try {
                Iterator it = ((ArrayList) this.b).iterator();
                while (it.hasNext()) {
                    ((Future) it.next()).cancel(true);
                }
            } finally {
                threadPoolExecutor.shutdownNow();
            }
        }
    }

    @Override // z8.n
    public void k() {
        ((F1.b) this.b).k();
        F1.b bVar = (F1.b) this.c;
        ((HashMap) bVar.c).put((G8.f) this.d, new L8.a((InterfaceC1556b) D7.v.U0((ArrayList) this.e)));
    }

    @Override // z8.n
    public n l(G8.b bVar, G8.f fVar) {
        return ((F1.b) this.f903a).l(bVar, fVar);
    }

    @Override // z8.n
    public void m(G8.f fVar, L8.f fVar2) {
        ((F1.b) this.f903a).m(fVar, fVar2);
    }

    @Override // z8.n
    public z8.o n(G8.f fVar) {
        return ((F1.b) this.f903a).n(fVar);
    }

    public HashMap o(X6.n nVar) {
        AbstractC0307c.a(nVar.c, "host");
        HashMap map = new HashMap(4);
        ((C3.a) this.e).getClass();
        OffsetDateTime offsetDateTimeAtOffset = Instant.now().atOffset(ZoneOffset.UTC);
        String str = offsetDateTimeAtOffset.format(a7.e.b);
        HashMap map2 = nVar.m;
        String str2 = (String) map2.get("X-Tos-Content-Sha256");
        ArrayList arrayListP = p(map2, false);
        arrayListP.add(new AbstractMap.SimpleEntry("X-Tos-Date".toLowerCase(), str));
        arrayListP.add(new AbstractMap.SimpleEntry("date", str));
        arrayListP.add(new AbstractMap.SimpleEntry("host", nVar.c));
        S6.a aVarA = ((S6.a) ((S6.b) this.f903a)).a();
        String str3 = aVarA.d;
        if (AbstractC0291a.y(str3)) {
            arrayListP.add(new AbstractMap.SimpleEntry("X-Tos-Security-Token".toLowerCase(), str3));
            map.put("X-Tos-Security-Token", str3);
        }
        Collections.sort(arrayListP, new d(2));
        HashMap map3 = nVar.n;
        ArrayList arrayList = new ArrayList(10);
        if (map3 != null) {
            map3.forEach(new S6.d(this, arrayList, 0));
        }
        String strE = e(nVar.b, nVar.d, str2, arrayListP, arrayList, offsetDateTimeAtOffset, aVarA);
        StringBuilder sbW = B7.a.w("TOS4-HMAC-SHA256 Credential=", aVarA.b + "/" + offsetDateTimeAtOffset.format(a7.e.f1650a) + "/" + ((String) this.b) + "/tos/request", ",SignedHeaders=", (String) arrayListP.stream().map(new E3.d(2)).sorted().collect(Collectors.joining(";")), ",Signature=");
        sbW.append(strE);
        map.put("Authorization", sbW.toString());
        map.put("X-Tos-Date", str);
        map.put("Date", str);
        return map;
    }

    public ArrayList p(Map map, boolean z10) {
        ArrayList arrayList = new ArrayList(10);
        if (map != null && !map.isEmpty()) {
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                if (AbstractC0291a.y(str)) {
                    String lowerCase = str.toLowerCase();
                    ((G4.a) this.c).getClass();
                    if (!AbstractC0291a.x(lowerCase) && (("content-type".equals(lowerCase) && !z10) || lowerCase.startsWith("x-tos"))) {
                        if (str2 == null) {
                            str2 = "";
                        }
                        arrayList.add(new AbstractMap.SimpleEntry(lowerCase, str2));
                    }
                }
            }
        }
        return arrayList;
    }

    public void q() throws InterruptedException {
        if (((ThreadPoolExecutor) this.f903a) != null) {
            Iterator it = ((ArrayList) this.b).iterator();
            while (it.hasNext()) {
                try {
                    ((Future) it.next()).wait();
                } catch (InterruptedException e) {
                    throw new TosClientException("tos: execute interrupted while waiting", e);
                }
            }
        }
    }

    public void r(Class type, Object obj) {
        kotlin.jvm.internal.k.f(type, "type");
        if (obj == null) {
            ((LinkedHashMap) this.e).remove(type);
            return;
        }
        if (((LinkedHashMap) this.e).isEmpty()) {
            this.e = new LinkedHashMap();
        }
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.e;
        Object objCast = type.cast(obj);
        kotlin.jvm.internal.k.c(objCast);
        linkedHashMap.put(type, objCast);
    }

    public void s(String url) {
        kotlin.jvm.internal.k.f(url, "url");
        if (t.e0(url, "ws:", true)) {
            String strSubstring = url.substring(3);
            kotlin.jvm.internal.k.e(strSubstring, "this as java.lang.String).substring(startIndex)");
            url = "http:".concat(strSubstring);
        } else if (t.e0(url, "wss:", true)) {
            String strSubstring2 = url.substring(4);
            kotlin.jvm.internal.k.e(strSubstring2, "this as java.lang.String).substring(startIndex)");
            url = "https:".concat(strSubstring2);
        }
        kotlin.jvm.internal.k.f(url, "<this>");
        x xVar = new x(0);
        xVar.j(null, url);
        this.f903a = xVar.d();
    }

    @Override // z8.n
    public void t(G8.f fVar, Object obj) {
        ((F1.b) this.f903a).t(fVar, obj);
    }

    @Override // z8.n
    public void y(G8.f fVar, G8.b bVar, G8.f fVar2) {
        ((F1.b) this.f903a).y(fVar, bVar, fVar2);
    }

    public a(int i, int i6, Z6.a aVar) {
        this.f903a = new ThreadPoolExecutor(i, i, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        this.b = new ArrayList(i6);
        this.c = new ArrayList(i6);
        this.d = new ArrayList(i6);
        this.e = aVar;
    }

    public a(S6.b bVar, String str) {
        AbstractC0307c.a(bVar, "Credentials");
        AbstractC0307c.a(str, "Region");
        this.f903a = bVar;
        this.b = str;
        this.c = new G4.a(4);
        this.d = new S6.c(0);
        this.e = new C3.a(1);
    }

    public a(C2024a c2024a, InterfaceC2028e typeParameterResolver, C7.f fVar) {
        kotlin.jvm.internal.k.f(typeParameterResolver, "typeParameterResolver");
        this.f903a = c2024a;
        this.b = typeParameterResolver;
        this.c = fVar;
        this.d = fVar;
        this.e = new c(this, typeParameterResolver);
    }

    public a() {
        this.e = new LinkedHashMap();
        this.b = "GET";
        this.c = new v(0);
    }
}
