package M;

import D7.C;
import D7.q;
import D7.v;
import L8.g;
import M0.i;
import N9.j;
import X8.A;
import X8.AbstractC0272c;
import X8.C0287s;
import X8.F;
import X8.H;
import X8.K;
import X8.N;
import X8.P;
import X8.S;
import X8.w;
import X8.y;
import a7.AbstractC0307c;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.system.Os;
import android.system.OsConstants;
import android.text.TextUtils;
import android.util.Log;
import androidx.autofill.HintConstants;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import c9.C0888a;
import c9.C0891d;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.ConfigManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.statsrpk.RpkInfo;
import com.volcengine.tos.model.object.ResumableCopyObjectCheckpoint;
import e1.C1403b;
import e3.C1417f;
import e8.n;
import e8.o;
import f8.C1445f;
import f8.C1448i;
import g1.AbstractC1451a;
import g9.l;
import h8.InterfaceC1507O;
import h8.InterfaceC1520c;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import i8.C1560f;
import i8.C1562h;
import i8.C1563i;
import i8.InterfaceC1556b;
import i8.InterfaceC1561g;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.annotation.Annotation;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q8.AbstractC1832e;
import s4.h;
import u8.E;
import v8.C2065a;
import za.e;
import za.f;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f948a = 0;
    public static long b = -1;
    public static long c = -1;
    public static D2.a d;
    public static boolean e;

    public static V9.d A() throws InterruptedException {
        V9.d dVar = V9.d.l;
        k.c(dVar);
        V9.d dVar2 = dVar.f;
        if (dVar2 == null) {
            long jNanoTime = System.nanoTime();
            V9.d.i.await(V9.d.f1415j, TimeUnit.MILLISECONDS);
            V9.d dVar3 = V9.d.l;
            k.c(dVar3);
            if (dVar3.f != null || System.nanoTime() - jNanoTime < V9.d.k) {
                return null;
            }
            return V9.d.l;
        }
        long jNanoTime2 = dVar2.g - System.nanoTime();
        if (jNanoTime2 > 0) {
            V9.d.i.await(jNanoTime2, TimeUnit.NANOSECONDS);
            return null;
        }
        V9.d dVar4 = V9.d.l;
        k.c(dVar4);
        dVar4.f = dVar2.f;
        dVar2.f = null;
        return dVar2;
    }

    public static long B() {
        if (c == -1) {
            try {
                c = Runtime.getRuntime().maxMemory();
            } catch (Exception unused) {
            }
        }
        return c;
    }

    public static JSONArray C(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return h(new File(str), -1L);
    }

    public static void D(Context context, String str, RpkInfo rpkInfo) throws JSONException {
        W5.c.a("RpkUxipConfig", "parseConfig");
        JSONObject jSONObject = new JSONObject(str);
        String str2 = "statsrpk_config_" + rpkInfo.f3976a;
        W5.c.d("SharedPreferencesHelper", "init SharedPreferences, name: " + str2);
        SharedPreferences sharedPreferences = context.getSharedPreferences(str2, 0);
        W5.c.a("SharedPreferencesHelper", str2 + " structure complete");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putInt("version", jSONObject.getInt("version"));
        editorEdit.putBoolean("active", jSONObject.getBoolean("active"));
        editorEdit.putString("getTime", new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
        editorEdit.commit();
        HashMap map = new HashMap();
        JSONArray jSONArray = jSONObject.getJSONArray("events");
        String strL = "";
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string = jSONObject2.getString(HintConstants.AUTOFILL_HINT_NAME);
            boolean z10 = jSONObject2.getBoolean("active");
            boolean z11 = jSONObject2.getBoolean("realtime");
            boolean z12 = jSONObject2.getBoolean("neartime");
            map.put(string, new R5.a(string, z10, z11, z12));
            int i6 = !z10 ? 0 : (z11 || z12) ? 2 : 1;
            if (!string.contains(":") && !string.contains(",")) {
                strL = strL + string + ":" + i6;
                if (i < jSONArray.length() - 1) {
                    strL = androidx.appfunctions.metadata.a.l(strL, ",");
                }
            }
        }
        editorEdit.putString("event_filters", strL);
        editorEdit.commit();
    }

    public static void E(File file, JSONObject jSONObject) {
        file.getParentFile().mkdirs();
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file));
            try {
                new com.apm.insight.o.a(bufferedWriter2).c(jSONObject);
                bufferedWriter2.flush();
                i.i(bufferedWriter2);
            } catch (Throwable th) {
                th = th;
                bufferedWriter = bufferedWriter2;
                try {
                    try {
                        jSONObject.put("err_write", th.toString());
                        n2.a.i(jSONObject, "filters", "err_write", th.getLocalizedMessage());
                    } finally {
                        i.i(bufferedWriter);
                    }
                } catch (JSONException unused) {
                }
                int i = com.apm.insight.b.f2156a;
                i.k("NPTH_CATCH", th);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static float F(float f, float f7, float f9, float f10, float f11, float f12) {
        return AbstractC1451a.t((((float) Math.sin((f9 * f) + f10)) * f7 * ((float) Math.sin((f * f11) + f12))) + f7, 0.0f, 1.0f);
    }

    public static float G(float f, float f7, float f9) {
        float f10 = 1.0f - f9;
        float f11 = 3.0f * f10;
        float f12 = f10 * f11 * f9 * f;
        return (f9 * f9 * f9) + (f11 * f9 * f9 * f7) + f12;
    }

    public static long H() {
        int i;
        int i6;
        BufferedReader bufferedReader;
        Throwable th;
        Throwable th2;
        BufferedReader bufferedReader2;
        synchronized (a.class) {
            i = f948a;
            bufferedReader = null;
            if (i == 0) {
                try {
                    bufferedReader2 = new BufferedReader(new FileReader("/proc/cpuinfo"), 50);
                    int i10 = 0;
                    while (true) {
                        try {
                            String line = bufferedReader2.readLine();
                            if (line == null) {
                                break;
                            }
                            if (line.startsWith("processor")) {
                                i10++;
                            }
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            throw th2;
                        }
                    }
                    bufferedReader2.close();
                    f948a = i10;
                    i = f948a;
                } catch (Throwable th4) {
                    th2 = th4;
                    bufferedReader2 = null;
                }
            }
        }
        long j5 = -1;
        if (i <= 0) {
            return -1L;
        }
        for (i6 = 0; i6 < i; i6++) {
            try {
                BufferedReader bufferedReader3 = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu" + i6 + "/cpufreq/stats/time_in_state"), 50);
                while (true) {
                    try {
                        String line2 = bufferedReader3.readLine();
                        if (line2 != null && !line2.isEmpty()) {
                            String[] strArrSplit = line2.split("\\s+");
                            if (strArrSplit.length == 2) {
                                j5 += Long.parseLong(strArrSplit[1]);
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedReader = bufferedReader3;
                        if (bufferedReader == null) {
                            throw th;
                        }
                        bufferedReader.close();
                        throw th;
                    }
                }
                try {
                    bufferedReader3.close();
                } catch (Throwable unused) {
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
        return j5;
    }

    public static void I(String str, String str2) throws Throwable {
        ZipOutputStream zipOutputStream;
        Throwable th;
        File file = new File(str);
        try {
            new File(str2).getParentFile().mkdirs();
            zipOutputStream = new ZipOutputStream(new FileOutputStream(str2));
            try {
                m(file, "", zipOutputStream);
                i.i(zipOutputStream);
            } catch (Throwable th2) {
                th = th2;
                i.i(zipOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            zipOutputStream = null;
            th = th3;
        }
    }

    public static final int J(w wVar) {
        k.f(wVar, "<this>");
        InterfaceC1556b interfaceC1556bM = wVar.getAnnotations().m(n.f4418q);
        if (interfaceC1556bM == null) {
            return 0;
        }
        g gVar = (g) kotlin.collections.a.N(o.e, interfaceC1556bM.a());
        k.d(gVar, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.constants.IntValue");
        return ((Number) ((L8.k) gVar).f939a).intValue();
    }

    public static e K(f param, Map metadata) {
        k.f(param, "param");
        k.f(metadata, "metadata");
        List list = null;
        try {
            LinkedHashMap linkedHashMap = param.f;
            Object obj = linkedHashMap != null ? linkedHashMap.get("experience_actions") : null;
            String str = obj instanceof String ? (String) obj : null;
            j.F(" experienceJson " + str, "Session");
            if (str != null) {
                list = (List) new Gson().fromJson(str, new TypeToken<List<Object>>() { // from class: stepai.aios.guiagent.model.Session$Companion$create$experienceActions$1
                }.getType());
            }
        } catch (Exception e6) {
            j.J("Failed to parse experience actions: " + e6.getMessage(), "Session");
        }
        return new e("session_" + System.currentTimeMillis() + "_" + AbstractC1451a.R(W7.c.f1492a, new Y7.f(0, 999, 1)), param.f7014a, param.g, param.b, metadata, param.c, param.e, list);
    }

    public static final N L(N n, InterfaceC1507O interfaceC1507O) {
        if (interfaceC1507O == null || n.a() == Variance.c) {
            return n;
        }
        if (interfaceC1507O.r() != n.a()) {
            K8.c cVar = new K8.c(n);
            H.b.getClass();
            return new F(new K8.a(n, cVar, false, H.c));
        }
        if (!n.c()) {
            return new F(n.b());
        }
        W8.b NO_LOCKS = W8.i.e;
        k.e(NO_LOCKS, "NO_LOCKS");
        return new F(new y(NO_LOCKS, new I8.e(n, 1)));
    }

    public static final A M(e8.i iVar, InterfaceC1561g interfaceC1561g, w wVar, List contextReceiverTypes, ArrayList arrayList, w wVar2, boolean z10) {
        InterfaceC1522e interfaceC1522eJ;
        k.f(contextReceiverTypes, "contextReceiverTypes");
        ArrayList arrayList2 = new ArrayList(contextReceiverTypes.size() + arrayList.size() + (wVar != null ? 1 : 0) + 1);
        List list = contextReceiverTypes;
        ArrayList arrayList3 = new ArrayList(D7.w.c0(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList3.add(U7.a.p((w) it.next()));
        }
        arrayList2.addAll(arrayList3);
        l.b(arrayList2, wVar != null ? U7.a.p(wVar) : null);
        int i = 0;
        for (Object obj : arrayList) {
            int i6 = i + 1;
            if (i < 0) {
                H4.o.X();
                throw null;
            }
            arrayList2.add(U7.a.p((w) obj));
            i = i6;
        }
        arrayList2.add(U7.a.p(wVar2));
        int size = contextReceiverTypes.size() + arrayList.size() + (wVar == null ? 0 : 1);
        if (z10) {
            interfaceC1522eJ = iVar.v(size);
        } else {
            G8.f fVar = o.f4426a;
            interfaceC1522eJ = iVar.j("Function" + size);
        }
        InterfaceC1561g c1562h = C1560f.f4611a;
        if (wVar != null) {
            G8.c cVar = n.p;
            if (!interfaceC1561g.k(cVar)) {
                ArrayList arrayListP0 = v.P0(interfaceC1561g, new C1563i(iVar, cVar, kotlin.collections.a.M()));
                interfaceC1561g = arrayListP0.isEmpty() ? c1562h : new C1562h(arrayListP0, 0);
            }
        }
        if (!contextReceiverTypes.isEmpty()) {
            int size2 = contextReceiverTypes.size();
            G8.c cVar2 = n.f4418q;
            if (!interfaceC1561g.k(cVar2)) {
                ArrayList arrayListP02 = v.P0(interfaceC1561g, new C1563i(iVar, cVar2, kotlin.collections.a.Q(new Pair(o.e, new L8.k(size2)))));
                if (!arrayListP02.isEmpty()) {
                    c1562h = new C1562h(arrayListP02, 0);
                }
                interfaceC1561g = c1562h;
            }
        }
        return AbstractC0272c.t(AbstractC0272c.C(interfaceC1561g), interfaceC1522eJ, arrayList2);
    }

    public static F1.b N(String str) {
        try {
            String strW = w(str);
            if (strW == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strW);
            F1.b bVar = new F1.b();
            bVar.h = jSONObject.optString(BffConstant.Type.Url);
            bVar.b = jSONObject.optJSONObject("body");
            bVar.c = jSONObject.optString("dump_file");
            jSONObject.optBoolean("encrypt", false);
            return bVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static F1.b O(String str) {
        try {
            JSONObject jSONObject = new JSONObject(w(str));
            F1.b bVar = new F1.b();
            bVar.e = jSONObject.optString("aid");
            bVar.d = jSONObject.optString("did");
            bVar.f = jSONObject.optString("processName");
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("alogFiles");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    arrayList.add(jSONArrayOptJSONArray.getString(i));
                }
                bVar.g = arrayList;
            }
            return bVar;
        } catch (IOException | JSONException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static HashMap P(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            Properties properties = new Properties();
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    properties.load(fileInputStream);
                    Set<String> setStringPropertyNames = properties.stringPropertyNames();
                    HashMap map = new HashMap();
                    for (String str : setStringPropertyNames) {
                        map.put(str, properties.getProperty(str));
                    }
                    i.i(fileInputStream);
                    return map;
                } catch (IOException e6) {
                    e = e6;
                    S0.b.p0(e);
                    i.i(fileInputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                i.i(fileInputStream2);
                throw th;
            }
        } catch (IOException e9) {
            e = e9;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            i.i(fileInputStream2);
            throw th;
        }
    }

    public static Map Q(C c2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator itSourceIterator = c2.sourceIterator();
        while (itSourceIterator.hasNext()) {
            Object objKeyOf = c2.keyOf(itSourceIterator.next());
            Object ref$IntRef = linkedHashMap.get(objKeyOf);
            if (ref$IntRef == null && !linkedHashMap.containsKey(objKeyOf)) {
                ref$IntRef = new Ref$IntRef();
            }
            Ref$IntRef ref$IntRef2 = (Ref$IntRef) ref$IntRef;
            ref$IntRef2.f4918a++;
            linkedHashMap.put(objKeyOf, ref$IntRef2);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            k.d(entry, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace>");
            if ((entry instanceof T7.a) && !(entry instanceof T7.d)) {
                p.j(entry, "kotlin.collections.MutableMap.MutableEntry");
                throw null;
            }
            entry.setValue(Integer.valueOf(((Ref$IntRef) entry.getValue()).f4918a));
        }
        return p.c(linkedHashMap);
    }

    /* JADX WARN: Type inference failed for: r0v17, types: [java.lang.Object, java.util.Map] */
    public static h R(List list, s4.e eVar, s4.f fVar) {
        Object objA;
        int i;
        P3.b bVar = P3.c.f1086a;
        if (list.isEmpty()) {
            P3.c.b("SlaPermPolicy", "no function to judge -> abstain(allow)");
            return new h(true, 0, null, null, null, 28);
        }
        long[] jArr = o4.a.f5427a;
        Object obj = null;
        try {
            if (eVar == null) {
                String msg = "no mapping snapshot -> DENY(fail-closed) all " + list.size() + " funcs";
                k.f(msg, "msg");
                bVar.invoke(5, "Ability_".concat("SlaPermPolicy"), msg, null);
                objA = new h(false, 6, (String) v.A0(list), "no mapping snapshot", null, 16);
            } else if (fVar == null) {
                String msg2 = "no mode snapshot -> DENY(fail-closed) all " + list.size() + " funcs";
                k.f(msg2, "msg");
                bVar.invoke(5, "Ability_".concat("SlaPermPolicy"), msg2, null);
                objA = new h(false, 5, (String) v.A0(list), "no mode snapshot", null, 16);
            } else {
                List list2 = list;
                ArrayList arrayList = new ArrayList(D7.w.c0(list2, 10));
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(j0((String) it.next(), eVar, fVar));
                }
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next = it2.next();
                    if (!((s4.g) next).g) {
                        obj = next;
                        break;
                    }
                }
                s4.g gVar = (s4.g) obj;
                if (gVar == null) {
                    P3.c.b("SlaPermPolicy", "verdict=ALLOW funcs=" + list);
                    objA = new h(true, 0, null, null, arrayList, 12);
                } else {
                    boolean z10 = gVar.f;
                    String str = gVar.c;
                    String str2 = gVar.f5986a;
                    String str3 = gVar.b;
                    if (str3 == null && !eVar.f5984a.containsKey(str2)) {
                        i = 3;
                    } else if (str == null) {
                        i = 4;
                    } else if (z10) {
                        long[] jArr2 = o4.a.f5427a;
                        i = 2;
                    } else {
                        i = 1;
                    }
                    int i6 = i;
                    P3.c.b("SlaPermPolicy", "verdict=DENY funcs=" + list + " reason=" + m0(i6) + " denied='" + str2 + "' detail: " + str2 + " -> " + str3 + " -> " + str + " mode=" + gVar.d + " dataLevel=" + gVar.e + " redline=" + z10);
                    String str4 = gVar.f5986a;
                    String strM0 = m0(i6);
                    StringBuilder sb = new StringBuilder();
                    sb.append("denied '");
                    sb.append(str4);
                    sb.append("' (");
                    sb.append(strM0);
                    sb.append(")");
                    objA = new h(false, i6, str4, sb.toString(), arrayList);
                }
            }
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            String msg3 = "policy judgment threw -> DENY(fail-closed): " + thA;
            k.f(msg3, "msg");
            bVar.invoke(6, "Ability_".concat("SlaPermPolicy"), msg3, thA);
            objA = new h(false, 5, (String) v.C0(list), B7.a.n("policy judgment threw: ", thA.getClass().getSimpleName(), ": ", thA.getMessage()), null, 16);
        }
        return (h) objA;
    }

    public static final G8.f S(w wVar) {
        String str;
        InterfaceC1556b interfaceC1556bM = wVar.getAnnotations().m(n.f4419r);
        if (interfaceC1556bM != null) {
            Object objV0 = v.V0(interfaceC1556bM.a().values());
            L8.w wVar2 = objV0 instanceof L8.w ? (L8.w) objV0 : null;
            if (wVar2 != null && (str = (String) wVar2.f939a) != null) {
                if (!G8.f.f(str)) {
                    str = null;
                }
                if (str != null) {
                    return G8.f.e(str);
                }
            }
        }
        return null;
    }

    public static void T(File file) {
        File file2 = new File(file, "lock");
        try {
            file2.createNewFile();
            NativeImpl.l(file2.getAbsolutePath());
        } catch (Throwable th) {
            int i = com.apm.insight.b.f2156a;
            i.k("NPTH_CATCH", th);
        }
    }

    public static void U(byte[] bArr, int i, int i6, int i10, int i11) {
        q0(bArr, i, i6);
        q0(bArr, i + 4, 1);
        q0(bArr, i + 8, i10);
        q0(bArr, i + 12, 1);
        q0(bArr, i + 16, i11);
        q0(bArr, i + 20, 50);
    }

    public static final Z7.d V(Annotation annotation) {
        k.f(annotation, "<this>");
        Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
        k.e(clsAnnotationType, "annotationType(...)");
        return c0(clsAnnotationType);
    }

    public static final List W(w wVar) {
        k.f(wVar, "<this>");
        h0(wVar);
        int iJ = J(wVar);
        if (iJ == 0) {
            return EmptyList.f4893a;
        }
        List listSubList = wVar.L().subList(0, iJ);
        ArrayList arrayList = new ArrayList(D7.w.c0(listSubList, 10));
        Iterator it = listSubList.iterator();
        while (it.hasNext()) {
            arrayList.add(((N) it.next()).b());
        }
        return arrayList;
    }

    public static P4.a X(Context context) {
        String string;
        String str = "prod";
        if (context != null) {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                if (contentResolver != null && (string = Settings.Secure.getString(contentResolver, "net_env")) != null) {
                    com.stepos.statsrpk.d.D("EnvManager", "getNetEnv: ".concat(string));
                    if (string.equals("test")) {
                        str = "test";
                    }
                }
            } catch (Throwable th) {
                com.stepos.statsrpk.d.u("EnvManager", "getNetEnv error: " + Log.getStackTraceString(th));
            }
        }
        int iHashCode = str.hashCode();
        if (iHashCode != 99349) {
            if (iHashCode != 114214) {
                if (iHashCode == 3556498 && str.equals("test")) {
                    return new C1417f(4);
                }
            } else if (str.equals("stg")) {
                return new C1403b(4);
            }
        } else if (str.equals("dev")) {
            return new F1.a();
        }
        return new M0.h(4);
    }

    public static final f8.j Y(InterfaceC1524g interfaceC1524g) {
        if (!(interfaceC1524g instanceof InterfaceC1522e) || !e8.i.I(interfaceC1524g)) {
            return null;
        }
        G8.e eVarH = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.h(interfaceC1524g);
        if (!eVarH.d() || eVarH.f689a.isEmpty()) {
            return null;
        }
        f8.l lVar = f8.l.c;
        G8.c cVarE = eVarH.g().e();
        String strB = eVarH.f().b();
        k.e(strB, "asString(...)");
        lVar.getClass();
        f8.k kVarA = lVar.a(cVarE, strB);
        if (kVarA != null) {
            return kVarA.f4446a;
        }
        return null;
    }

    public static final Class Z(Z7.d dVar) {
        k.f(dVar, "<this>");
        Class clsB = ((kotlin.jvm.internal.c) dVar).b();
        k.d(clsB, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return clsB;
    }

    public static long a() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/stat")), 1000);
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            String line = bufferedReader.readLine();
            bufferedReader.close();
            String[] strArrSplit = line.split(" ");
            long j5 = Long.parseLong(strArrSplit[13]) + Long.parseLong(strArrSplit[14]) + Long.parseLong(strArrSplit[15]) + Long.parseLong(strArrSplit[16]);
            S0.b.L0(bufferedReader);
            return j5;
        } catch (Throwable unused2) {
            S0.b.L0(bufferedReader);
            return -1L;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static final Class a0(Z7.d dVar) {
        k.f(dVar, "<this>");
        Class clsB = ((kotlin.jvm.internal.c) dVar).b();
        if (!clsB.isPrimitive()) {
            return clsB;
        }
        String name = clsB.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (!name.equals("double")) {
                }
                break;
            case 104431:
                if (!name.equals("int")) {
                }
                break;
            case 3039496:
                if (!name.equals("byte")) {
                }
                break;
            case 3052374:
                if (!name.equals("char")) {
                }
                break;
            case 3327612:
                if (!name.equals("long")) {
                }
                break;
            case 3625364:
                if (!name.equals("void")) {
                }
                break;
            case 64711720:
                if (!name.equals(TypedValues.Custom.S_BOOLEAN)) {
                }
                break;
            case 97526364:
                if (!name.equals(TypedValues.Custom.S_FLOAT)) {
                }
                break;
            case 109413500:
                if (!name.equals("short")) {
                }
                break;
        }
        return clsB;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e1 A[PHI: r6
      0x00e1: PHI (r6v7 java.lang.StringBuilder) = (r6v4 java.lang.StringBuilder), (r6v8 java.lang.StringBuilder) binds: [B:57:0x00f0, B:52:0x00df] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static F1.b b(java.io.File r19, com.apm.insight.CrashType r20) {
        /*
            Method dump skipped, instructions count: 552
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: M.a.b(java.io.File, com.apm.insight.CrashType):F1.b");
    }

    public static final Class b0(Z7.d dVar) {
        k.f(dVar, "<this>");
        Class clsB = ((kotlin.jvm.internal.c) dVar).b();
        if (clsB.isPrimitive()) {
            return clsB;
        }
        String name = clsB.getName();
        switch (name.hashCode()) {
            case -2056817302:
                if (name.equals("java.lang.Integer")) {
                    return Integer.TYPE;
                }
                return null;
            case -527879800:
                if (name.equals("java.lang.Float")) {
                    return Float.TYPE;
                }
                return null;
            case -515992664:
                if (name.equals("java.lang.Short")) {
                    return Short.TYPE;
                }
                return null;
            case 155276373:
                if (name.equals("java.lang.Character")) {
                    return Character.TYPE;
                }
                return null;
            case 344809556:
                if (name.equals("java.lang.Boolean")) {
                    return Boolean.TYPE;
                }
                return null;
            case 398507100:
                if (name.equals("java.lang.Byte")) {
                    return Byte.TYPE;
                }
                return null;
            case 398795216:
                if (name.equals("java.lang.Long")) {
                    return Long.TYPE;
                }
                return null;
            case 399092968:
                if (name.equals("java.lang.Void")) {
                    return Void.TYPE;
                }
                return null;
            case 761287205:
                if (name.equals("java.lang.Double")) {
                    return Double.TYPE;
                }
                return null;
            default:
                return null;
        }
    }

    public static String c(File file) throws Throwable {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        i.i(bufferedReader2);
                        return sb.toString();
                    }
                    if (sb.length() != 0) {
                        sb.append("\n");
                    }
                    sb.append(line);
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    i.i(bufferedReader);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static final Z7.d c0(Class cls) {
        k.f(cls, "<this>");
        return m.f4928a.b(cls);
    }

    public static String d(File file, String str, String str2, String str3, String str4, List list) {
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("aid", str3);
            jSONObject.put("did", str2);
            jSONObject.put("processName", str4);
            jSONObject.put("alogFiles", new JSONArray((Collection<?>) list));
            p(file2, jSONObject);
        } catch (IOException | JSONException e6) {
            e6.printStackTrace();
        }
        return file2.getAbsolutePath();
    }

    public static final w d0(w wVar) {
        k.f(wVar, "<this>");
        h0(wVar);
        if (wVar.getAnnotations().m(n.p) == null) {
            return null;
        }
        return ((N) wVar.L().get(J(wVar))).b();
    }

    public static String e(String str) throws Throwable {
        FileInputStream fileInputStream;
        File file = new File(str);
        FileInputStream fileInputStream2 = null;
        BufferedReader bufferedReader = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            StringBuilder sb = new StringBuilder();
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(fileInputStream));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            bufferedReader2.close();
                            String string = sb.toString();
                            fileInputStream.close();
                            return string;
                        }
                        sb.append(line);
                        sb.append('\n');
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th;
        }
    }

    public static String e0(Throwable th) {
        for (Throwable cause = th; cause != null; cause = cause.getCause()) {
            if (cause instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static StringBuilder f(String str) {
        return androidx.compose.foundation.b.v(str);
    }

    public static final List f0(w wVar) {
        k.f(wVar, "<this>");
        h0(wVar);
        List listL = wVar.L();
        return listL.subList(((!h0(wVar) || wVar.getAnnotations().m(n.p) == null) ? 0 : 1) + J(wVar), listL.size() - 1);
    }

    public static JSONArray g(long j5, String str) {
        ConfigManager configManager = com.apm.insight.g.g;
        try {
            String absolutePath = H4.o.a(configManager.getLogcatDumpCount(), configManager.getLogcatLevel(), str).getAbsolutePath();
            if (j5 > 0) {
                SystemClock.sleep(j5);
            }
            return i(absolutePath);
        } catch (Throwable th) {
            int i = com.apm.insight.b.f2156a;
            i.k("NPTH_CATCH", th);
            return null;
        }
    }

    public static boolean g0(InterfaceC1520c callableMemberDescriptor) {
        k.f(callableMemberDescriptor, "callableMemberDescriptor");
        if (!AbstractC1832e.d.contains(callableMemberDescriptor.getName())) {
            return false;
        }
        if (v.u0(AbstractC1832e.c, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.c(callableMemberDescriptor)) && callableMemberDescriptor.x().isEmpty()) {
            return true;
        }
        if (!e8.i.z(callableMemberDescriptor)) {
            return false;
        }
        Collection collectionE = callableMemberDescriptor.e();
        k.e(collectionE, "getOverriddenDescriptors(...)");
        Collection<InterfaceC1520c> collection = collectionE;
        if (collection.isEmpty()) {
            return false;
        }
        for (InterfaceC1520c interfaceC1520c : collection) {
            k.c(interfaceC1520c);
            if (g0(interfaceC1520c)) {
                return true;
            }
        }
        return false;
    }

    public static JSONArray h(File file, long j5) throws Throwable {
        JSONArray jSONArray = new JSONArray();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            if (j5 > 0) {
                try {
                    bufferedReader2.skip(j5);
                    bufferedReader2.readLine();
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    i.i(bufferedReader);
                    throw th;
                }
            }
            while (true) {
                String line = bufferedReader2.readLine();
                if (line == null) {
                    i.i(bufferedReader2);
                    return jSONArray;
                }
                jSONArray.put(line);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static final boolean h0(w wVar) {
        k.f(wVar, "<this>");
        InterfaceC1524g interfaceC1524gD = wVar.Q().d();
        if (interfaceC1524gD == null) {
            return false;
        }
        f8.j jVarY = Y(interfaceC1524gD);
        return k.b(jVarY, C1445f.c) || k.b(jVarY, C1448i.c);
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0031: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:10:0x0031 */
    public static JSONArray i(String str) throws Throwable {
        Closeable closeable;
        BufferedReader bufferedReader;
        Closeable closeable2 = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray();
                bufferedReader = new BufferedReader(new FileReader(str));
                try {
                    File file = new File(str);
                    if (file.length() > 512000) {
                        bufferedReader.skip(file.length() - 512000);
                    }
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            i.i(bufferedReader);
                            return jSONArray;
                        }
                        jSONArray.put(line);
                    }
                } catch (IOException e6) {
                    e = e6;
                    e.printStackTrace();
                    i.i(bufferedReader);
                    return null;
                }
            } catch (IOException e9) {
                e = e9;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                i.i(closeable2);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
        }
    }

    public static final boolean i0(w wVar) {
        k.f(wVar, "<this>");
        InterfaceC1524g interfaceC1524gD = wVar.Q().d();
        return k.b(interfaceC1524gD != null ? Y(interfaceC1524gD) : null, C1448i.c);
    }

    public static void j(Context context, String str, RpkInfo rpkInfo) throws JSONException {
        W5.c.a("RpkUxipConfig", "parseAppInfo");
        JSONObject jSONObject = new JSONObject(str);
        String str2 = "statsrpk_config_" + rpkInfo.f3976a;
        W5.c.d("SharedPreferencesHelper", "init SharedPreferences, name: " + str2);
        SharedPreferences sharedPreferences = context.getSharedPreferences(str2, 0);
        W5.c.a("SharedPreferencesHelper", str2 + " structure complete");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (!TextUtils.isEmpty(jSONObject.getString("key"))) {
            String string = jSONObject.getString("key");
            rpkInfo.e = string;
            editorEdit.putString("appKey", string);
        }
        if (!TextUtils.isEmpty(jSONObject.getString("primaryPackageName"))) {
            String string2 = jSONObject.getString("primaryPackageName");
            rpkInfo.d = string2;
            editorEdit.putString("apkPkgName", string2);
        }
        editorEdit.commit();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00df  */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Object, java.util.Map] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static s4.g j0(java.lang.String r11, s4.e r12, s4.f r13) {
        /*
            Method dump skipped, instructions count: 235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: M.a.j0(java.lang.String, s4.e, s4.f):s4.g");
    }

    public static void k(File file, File file2) throws Throwable {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream = null;
        try {
            file2.getParentFile().mkdirs();
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i = fileInputStream2.read(bArr);
                        if (i <= 0) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, i);
                        }
                    }
                    i.i(fileInputStream2);
                } catch (Exception e6) {
                    e = e6;
                    fileInputStream = fileInputStream2;
                    try {
                        e.printStackTrace();
                        i.i(fileInputStream);
                        i.i(fileOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        i.i(fileInputStream);
                        i.i(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    i.i(fileInputStream);
                    i.i(fileOutputStream);
                    throw th;
                }
            } catch (Exception e9) {
                e = e9;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (Exception e10) {
            e = e10;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
        i.i(fileOutputStream);
    }

    public static ResumableCopyObjectCheckpoint k0(String str) throws IOException {
        AbstractC0307c.a(str, "checkpointFilePath is null");
        File file = new File(str);
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[(int) file.length()];
            fileInputStream.read(bArr);
            ResumableCopyObjectCheckpoint resumableCopyObjectCheckpoint = (ResumableCopyObjectCheckpoint) a7.f.b.readValue(bArr, new X6.l());
            fileInputStream.close();
            return resumableCopyObjectCheckpoint;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static void l(File file, String str, String str2, JSONObject jSONObject) {
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(BffConstant.Type.Url, str2);
            jSONObject2.put("body", jSONObject);
            jSONObject2.put("dump_file", "");
            jSONObject2.put("encrypt", true);
            p(file2, jSONObject2);
        } catch (IOException | JSONException e6) {
            e6.printStackTrace();
        }
        file2.getAbsolutePath();
    }

    public static float l0(float f, float f7, float f9) {
        if (f9 <= 0.0f) {
            return 0.0f;
        }
        if (f9 >= 1.0f) {
            return 1.0f;
        }
        float fT = f9;
        for (int i = 0; i < 6; i++) {
            float fG = G(f, f7, fT) - f9;
            float f10 = 1.0f - fT;
            float f11 = 3.0f * fT * fT;
            float fB = B7.a.b(1.0f, f7, f11, B7.a.b(f7, f, f10 * 6.0f * fT, f10 * 3.0f * f10 * f));
            if (Math.abs(fB) > 1.0E-6f) {
                fT = AbstractC1451a.t(fT - (fG / fB), 0.0f, 1.0f);
            }
        }
        return G(0.0f, 1.0f, fT);
    }

    public static void m(File file, String str, ZipOutputStream zipOutputStream) throws Throwable {
        FileInputStream fileInputStream;
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            zipOutputStream.putNextEntry(new ZipEntry(androidx.appfunctions.metadata.a.l(str, "/")));
            String strConcat = str.length() == 0 ? "" : str.concat("/");
            for (int i = 0; i < fileArrListFiles.length; i++) {
                File file2 = fileArrListFiles[i];
                StringBuilder sbV = androidx.compose.foundation.b.v(strConcat);
                sbV.append(fileArrListFiles[i].getName());
                m(file2, sbV.toString(), zipOutputStream);
            }
            return;
        }
        zipOutputStream.putNextEntry(new ZipEntry(str));
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int i6 = fileInputStream.read(bArr);
                if (-1 == i6) {
                    i.i(fileInputStream);
                    return;
                }
                zipOutputStream.write(bArr, 0, i6);
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            i.i(fileInputStream2);
            throw th;
        }
    }

    public static String m0(int i) {
        switch (i) {
            case 0:
                return "none";
            case 1:
                return "mode";
            case 2:
                return "redline";
            case 3:
                return "unknownFunction";
            case 4:
                return "scopeMissing";
            case 5:
                return "noModeSnapshot";
            case 6:
                return "noMappingSnapshot";
            case 7:
                return "stale";
            default:
                return androidx.appfunctions.metadata.a.i(i, "unknown(", ")");
        }
    }

    public static void n(File file, Map map) throws Throwable {
        Properties properties;
        FileOutputStream fileOutputStream;
        if (map == null || map.isEmpty()) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                properties = new Properties();
                fileOutputStream = new FileOutputStream(file);
            } catch (IOException e6) {
                e = e6;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            for (Map.Entry entry : map.entrySet()) {
                properties.setProperty((String) entry.getKey(), (String) entry.getValue());
            }
            properties.store(fileOutputStream, "no");
            i.i(fileOutputStream);
        } catch (IOException e9) {
            e = e9;
            fileOutputStream2 = fileOutputStream;
            S0.b.p0(e);
            i.i(fileOutputStream2);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            i.i(fileOutputStream2);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final X8.w n0(X8.w r7, java.util.ArrayList r8) {
        /*
            java.util.List r0 = r7.L()
            r0.size()
            r8.size()
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = D7.w.c0(r8, r1)
            r0.<init>(r1)
            java.util.Iterator r8 = r8.iterator()
        L19:
            boolean r1 = r8.hasNext()
            r2 = 0
            if (r1 == 0) goto L9b
            java.lang.Object r1 = r8.next()
            c9.d r1 = (c9.C0891d) r1
            r1.getClass()
            X8.w r3 = r1.c
            X8.w r4 = r1.b
            h8.O r1 = r1.f2105a
            Y8.l r5 = Y8.d.f1572a
            r5.b(r4, r3)
            boolean r5 = kotlin.jvm.internal.k.b(r4, r3)
            if (r5 != 0) goto L91
            kotlin.reflect.jvm.internal.impl.types.Variance r5 = r1.r()
            kotlin.reflect.jvm.internal.impl.types.Variance r6 = kotlin.reflect.jvm.internal.impl.types.Variance.d
            if (r5 != r6) goto L43
            goto L91
        L43:
            boolean r5 = e8.i.E(r4)
            if (r5 == 0) goto L5f
            kotlin.reflect.jvm.internal.impl.types.Variance r5 = r1.r()
            if (r5 == r6) goto L5f
            X8.F r2 = new X8.F
            kotlin.reflect.jvm.internal.impl.types.Variance r4 = kotlin.reflect.jvm.internal.impl.types.Variance.e
            kotlin.reflect.jvm.internal.impl.types.Variance r1 = r1.r()
            if (r4 != r1) goto L5b
            kotlin.reflect.jvm.internal.impl.types.Variance r4 = kotlin.reflect.jvm.internal.impl.types.Variance.c
        L5b:
            r2.<init>(r3, r4)
            goto L96
        L5f:
            if (r3 == 0) goto L8b
            boolean r2 = e8.i.x(r3)
            if (r2 == 0) goto L7b
            boolean r2 = r3.W()
            if (r2 == 0) goto L7b
            X8.F r2 = new X8.F
            kotlin.reflect.jvm.internal.impl.types.Variance r1 = r1.r()
            if (r6 != r1) goto L77
            kotlin.reflect.jvm.internal.impl.types.Variance r6 = kotlin.reflect.jvm.internal.impl.types.Variance.c
        L77:
            r2.<init>(r4, r6)
            goto L96
        L7b:
            X8.F r2 = new X8.F
            kotlin.reflect.jvm.internal.impl.types.Variance r4 = kotlin.reflect.jvm.internal.impl.types.Variance.e
            kotlin.reflect.jvm.internal.impl.types.Variance r1 = r1.r()
            if (r4 != r1) goto L87
            kotlin.reflect.jvm.internal.impl.types.Variance r4 = kotlin.reflect.jvm.internal.impl.types.Variance.c
        L87:
            r2.<init>(r3, r4)
            goto L96
        L8b:
            r7 = 141(0x8d, float:1.98E-43)
            e8.i.a(r7)
            throw r2
        L91:
            X8.F r2 = new X8.F
            r2.<init>(r4)
        L96:
            r0.add(r2)
            goto L19
        L9b:
            r8 = 6
            X8.w r7 = X8.AbstractC0272c.q(r7, r0, r2, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: M.a.n0(X8.w, java.util.ArrayList):X8.w");
    }

    public static void o(File file, JSONArray jSONArray) {
        file.getParentFile().mkdirs();
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file));
            try {
                new com.apm.insight.o.a(bufferedWriter2).b(jSONArray);
                bufferedWriter2.flush();
                i.i(bufferedWriter2);
            } catch (Throwable unused) {
                bufferedWriter = bufferedWriter2;
                i.i(bufferedWriter);
            }
        } catch (Throwable unused2) {
        }
    }

    public static C2065a o0(TypeUsage typeUsage, boolean z10, E e6, int i) {
        boolean z11 = (i & 1) != 0 ? false : z10;
        boolean z12 = (i & 2) == 0;
        if ((i & 4) != 0) {
            e6 = null;
        }
        return new C2065a(typeUsage, z12, z11, e6 != null ? D7.N.Q(e6) : null, 34);
    }

    public static void p(File file, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        file.getParentFile().mkdirs();
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file));
            try {
                new com.apm.insight.o.a(bufferedWriter2).c(jSONObject);
                bufferedWriter2.flush();
                i.i(bufferedWriter2);
            } catch (Throwable unused) {
                bufferedWriter = bufferedWriter2;
                i.i(bufferedWriter);
            }
        } catch (Throwable unused2) {
        }
    }

    public static P p0(P p) {
        if (!(p instanceof C0287s)) {
            return new K8.d(p, 0);
        }
        C0287s c0287s = (C0287s) p;
        InterfaceC1507O[] interfaceC1507OArr = c0287s.b;
        ArrayList arrayListL0 = q.L0(c0287s.c, interfaceC1507OArr);
        ArrayList arrayList = new ArrayList(D7.w.c0(arrayListL0, 10));
        Iterator it = arrayListL0.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            arrayList.add(L((N) pair.f4886a, (InterfaceC1507O) pair.b));
        }
        return new C0287s(interfaceC1507OArr, (N[]) arrayList.toArray(new N[0]), true);
    }

    public static void q(OutputStream outputStream, F.g... gVarArr) throws Throwable {
        ZipOutputStream zipOutputStream;
        InputStream inputStream;
        ZipOutputStream zipOutputStream2 = null;
        try {
            zipOutputStream = new ZipOutputStream(outputStream);
        } catch (Throwable th) {
            th = th;
        }
        try {
            zipOutputStream.putNextEntry(new ZipEntry("/"));
            for (F.g gVar : gVarArr) {
                if (gVar != null) {
                    zipOutputStream.putNextEntry(new ZipEntry((String) gVar.c));
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int i = ((InputStream) gVar.b).read(bArr);
                            if (-1 == i) {
                                break;
                            } else {
                                zipOutputStream.write(bArr, 0, i);
                            }
                        }
                        inputStream = (InputStream) gVar.b;
                    } catch (Throwable unused) {
                        inputStream = (InputStream) gVar.b;
                    }
                    i.i(inputStream);
                }
            }
            i.i(zipOutputStream);
        } catch (Throwable th2) {
            th = th2;
            zipOutputStream2 = zipOutputStream;
            i.i(zipOutputStream2);
            throw th;
        }
    }

    public static void q0(byte[] bArr, int i, int i6) {
        bArr[i] = (byte) (i6 & 255);
        bArr[i + 1] = (byte) ((i6 >>> 8) & 255);
        bArr[i + 2] = (byte) ((i6 >>> 16) & 255);
        bArr[i + 3] = (byte) ((i6 >>> 24) & 255);
    }

    public static void r(OutputStream outputStream, File... fileArr) throws Throwable {
        ZipOutputStream zipOutputStream = null;
        try {
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(outputStream);
            try {
                zipOutputStream2.putNextEntry(new ZipEntry("/"));
                for (File file : fileArr) {
                    if (file != null && file.exists()) {
                        File[] fileArrListFiles = file.isDirectory() ? file.listFiles() : new File[]{file};
                        if (fileArrListFiles != null) {
                            for (File file2 : fileArrListFiles) {
                                m(file2, file2.getName(), zipOutputStream2);
                            }
                        }
                    }
                }
                i.i(zipOutputStream2);
            } catch (Throwable th) {
                th = th;
                zipOutputStream = zipOutputStream2;
                i.i(zipOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void s(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        u(new File(str));
    }

    public static void t(String str, File file, boolean z10) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, z10);
            try {
                fileOutputStream2.write(str.getBytes());
                fileOutputStream2.flush();
                i.i(fileOutputStream2);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                i.i(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean u(File file) {
        boolean zU;
        boolean z10 = true;
        if (!file.exists()) {
            return true;
        }
        if (!file.canWrite()) {
            return false;
        }
        if (file.isFile()) {
            return file.delete();
        }
        if (!file.isDirectory()) {
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        for (int i = 0; fileArrListFiles != null && i < fileArrListFiles.length; i++) {
            if (!fileArrListFiles[i].isFile()) {
                zU = u(fileArrListFiles[i]);
            } else if (fileArrListFiles[i].canWrite()) {
                zU = fileArrListFiles[i].delete();
            } else {
                z10 = false;
            }
            z10 &= zU;
        }
        return file.delete() & z10;
    }

    public static long v() {
        if (b == -1) {
            long jSysconf = Os.sysconf(OsConstants._SC_CLK_TCK);
            if (jSysconf <= 0) {
                jSysconf = 100;
            }
            b = jSysconf;
        }
        return b;
    }

    public static String w(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return c(new File(str));
    }

    public static int x(int i, int i6, int i10, int i11) {
        if (i < 0) {
            i = 0;
        }
        int i12 = (int) ((i * i11) / 100);
        int i13 = i - i12;
        if (i6 > i - i10) {
            if (i6 <= i13) {
                i10 = i - i6;
            } else if (i10 > i12) {
                i10 = i12;
            }
        }
        return AbstractC1451a.u(i10, 0, i);
    }

    public static final C0888a y(w type) {
        C0891d c0891d;
        k.f(type, "type");
        if (AbstractC0272c.l(type)) {
            C0888a c0888aY = y(AbstractC0272c.m(type));
            C0888a c0888aY2 = y(AbstractC0272c.E(type));
            return new C0888a(AbstractC0272c.i(AbstractC0272c.f(AbstractC0272c.m((w) c0888aY.f2103a), AbstractC0272c.E((w) c0888aY2.f2103a)), type), AbstractC0272c.i(AbstractC0272c.f(AbstractC0272c.m((w) c0888aY.b), AbstractC0272c.E((w) c0888aY2.b)), type));
        }
        K kQ = type.Q();
        boolean z10 = true;
        if (type.Q() instanceof K8.b) {
            k.d(kQ, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.calls.inference.CapturedTypeConstructor");
            N nA = ((K8.b) kQ).a();
            w wVarB = nA.b();
            k.e(wVarB, "getType(...)");
            w wVarH = S.h(wVarB, type.W());
            int iOrdinal = nA.a().ordinal();
            if (iOrdinal == 1) {
                return new C0888a(wVarH, U7.a.x(type).o());
            }
            if (iOrdinal == 2) {
                return new C0888a(S.h(U7.a.x(type).n(), type.W()), wVarH);
            }
            throw new AssertionError("Only nontrivial projections should have been captured, not: " + nA);
        }
        if (type.L().isEmpty() || type.L().size() != kQ.getParameters().size()) {
            return new C0888a(type, type);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List listL = type.L();
        List parameters = kQ.getParameters();
        k.e(parameters, "getParameters(...)");
        Iterator it = v.m1(listL, parameters).iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            N n = (N) pair.f4886a;
            InterfaceC1507O interfaceC1507O = (InterfaceC1507O) pair.b;
            k.c(interfaceC1507O);
            Variance varianceR = interfaceC1507O.r();
            if (varianceR == null) {
                kotlin.reflect.jvm.internal.impl.types.a.a(35);
                throw null;
            }
            if (n == null) {
                kotlin.reflect.jvm.internal.impl.types.a.a(36);
                throw null;
            }
            kotlin.reflect.jvm.internal.impl.types.a aVar = kotlin.reflect.jvm.internal.impl.types.a.b;
            int iOrdinal2 = (n.c() ? Variance.e : kotlin.reflect.jvm.internal.impl.types.a.b(varianceR, n.a())).ordinal();
            if (iOrdinal2 == 0) {
                w wVarB2 = n.b();
                k.e(wVarB2, "getType(...)");
                w wVarB3 = n.b();
                k.e(wVarB3, "getType(...)");
                c0891d = new C0891d(interfaceC1507O, wVarB2, wVarB3);
            } else if (iOrdinal2 == 1) {
                w wVarB4 = n.b();
                k.e(wVarB4, "getType(...)");
                A aO = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.e(interfaceC1507O).o();
                k.e(aO, "getNullableAnyType(...)");
                c0891d = new C0891d(interfaceC1507O, wVarB4, aO);
            } else {
                if (iOrdinal2 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                A aN = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.e(interfaceC1507O).n();
                w wVarB5 = n.b();
                k.e(wVarB5, "getType(...)");
                c0891d = new C0891d(interfaceC1507O, aN, wVarB5);
            }
            if (n.c()) {
                arrayList.add(c0891d);
                arrayList2.add(c0891d);
            } else {
                C0888a c0888aY3 = y(c0891d.b);
                w wVar = (w) c0888aY3.f2103a;
                w wVar2 = (w) c0888aY3.b;
                C0888a c0888aY4 = y(c0891d.c);
                w wVar3 = (w) c0888aY4.f2103a;
                w wVar4 = (w) c0888aY4.b;
                InterfaceC1507O interfaceC1507O2 = c0891d.f2105a;
                C0891d c0891d2 = new C0891d(interfaceC1507O2, wVar2, wVar3);
                C0891d c0891d3 = new C0891d(interfaceC1507O2, wVar, wVar4);
                arrayList.add(c0891d2);
                arrayList2.add(c0891d3);
            }
        }
        if (arrayList.isEmpty()) {
            z10 = false;
        } else {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                C0891d c0891d4 = (C0891d) it2.next();
                c0891d4.getClass();
                if (!Y8.d.f1572a.b(c0891d4.b, c0891d4.c)) {
                    break;
                }
            }
            z10 = false;
        }
        return new C0888a(z10 ? U7.a.x(type).n() : n0(type, arrayList), n0(type, arrayList2));
    }

    public abstract String z();
}
