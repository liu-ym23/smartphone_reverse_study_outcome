package A5;

import A2.f;
import Ca.C0203b;
import D7.N;
import F9.D;
import H4.o;
import S7.n;
import X8.A;
import X8.AbstractC0272c;
import X8.w;
import Z8.i;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.apm.insight.CrashType;
import com.apm.insight.ICommonParams;
import com.apm.insight.Npth;
import com.apm.insight.g;
import com.apm.insight.nativecrash.NativeImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.protobuf.AbstractC0926c1;
import com.google.protobuf.C1004w0;
import com.google.protobuf.D0;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InterfaceC0942g1;
import com.google.protobuf.InterfaceC0974o1;
import com.stepos.ability.App;
import com.stepos.policy.sdk.PolicyManager;
import com.stepos.policy.sdk.util.ReadClipboardUtils;
import com.stepos.policy.sdk.util.SocketHookUtil;
import e2.C1406c;
import e3.C1417f;
import fa.C1449a;
import g2.C1452a;
import h2.RunnableC1484b;
import h2.d;
import h8.InterfaceC1525h;
import ha.AbstractC1551g;
import ha.C1548d;
import j4.C1597b;
import j9.AbstractC1607a;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.LongUnaryOperator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import k2.C1621a;
import kotlin.Pair;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import n8.h;
import n8.j;
import n8.s;
import n8.u;
import n8.x;
import okio.ByteString;
import org.json.JSONArray;
import org.json.JSONObject;
import org.yaml.snakeyaml.comments.CommentType;
import org.yaml.snakeyaml.events.Event$ID;
import s2.C1912a;
import stepos.support.v7.app.P;
import t8.C2024a;
import t8.InterfaceC2028e;
import u1.C2031a;
import u2.C2032a;
import u2.C2034c;
import v.C2053a;
import v.l;
import v8.C2065a;
import v8.C2068d;
import v8.C2071g;
import v9.InterfaceC2073b;
import x8.InterfaceC2121d;
import y2.e;
import z3.AbstractC2161f;
import z3.G;
import z8.C2195g;

/* loaded from: classes3.dex */
public class c implements a, InterfaceC0942g1, P, f, InterfaceC2073b, G {
    public static String e;
    public static String f;
    public static volatile String g;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f108a;
    public Object b;
    public Object c;
    public Object d;

    public c(Context context, ICommonParams iCommonParams, c cVar) {
        this.f108a = 22;
        this.b = context;
        this.c = iCommonParams;
        this.d = cVar == null ? null : (ICommonParams) cVar.c;
    }

    public static void i(String str, Object... objArr) {
        String.format(Locale.US, str, objArr);
    }

    public LinkedHashMap A() {
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.d;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(kotlin.collections.a.P(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            float[] fArr = (float[]) entry.getValue();
            float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
            k.e(fArrCopyOf, "copyOf(...)");
            linkedHashMap2.put(key, fArrCopyOf);
        }
        return linkedHashMap2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public X8.U B(n8.h r8, v8.C2065a r9, boolean r10) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.b
            K1.a r0 = (K1.a) r0
            java.lang.Object r1 = r0.f903a
            t8.a r1 = (t8.C2024a) r1
            java.lang.String r2 = "arrayType"
            kotlin.jvm.internal.k.f(r8, r2)
            boolean r9 = r9.e
            n8.u r2 = r8.b
            boolean r3 = r2 instanceof n8.s
            r4 = 0
            if (r3 == 0) goto L1a
            r3 = r2
            n8.s r3 = (n8.s) r3
            goto L1b
        L1a:
            r3 = r4
        L1b:
            if (r3 == 0) goto L35
            java.lang.Class r3 = r3.f5364a
            java.lang.Class r5 = java.lang.Void.TYPE
            boolean r5 = kotlin.jvm.internal.k.b(r3, r5)
            if (r5 == 0) goto L28
            goto L35
        L28:
            java.lang.String r3 = r3.getName()
            kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType r3 = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.b(r3)
            kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType r3 = r3.d()
            goto L36
        L35:
            r3 = r4
        L36:
            t8.c r5 = new t8.c
            r6 = 1
            r5.<init>(r0, r8, r6)
            if (r3 == 0) goto L74
            h8.w r7 = r1.o
            e8.i r7 = r7.c()
            X8.A r7 = r7.q(r3)
            i8.h r8 = new i8.h
            i8.g r10 = r7.getAnnotations()
            r0 = 2
            i8.g[] r0 = new i8.InterfaceC1561g[r0]
            r1 = 0
            r0[r1] = r10
            r0[r6] = r5
            java.util.List r10 = D7.q.I0(r0)
            r8.<init>(r10, r6)
            X8.w r7 = U7.a.Q(r7, r8)
            java.lang.String r8 = "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType"
            kotlin.jvm.internal.k.d(r7, r8)
            X8.A r7 = (X8.A) r7
            if (r9 == 0) goto L6b
            return r7
        L6b:
            X8.A r8 = r7.f0(r6)
            X8.U r7 = X8.AbstractC0272c.f(r7, r8)
            return r7
        L74:
            kotlin.reflect.jvm.internal.impl.types.TypeUsage r8 = kotlin.reflect.jvm.internal.impl.types.TypeUsage.b
            r0 = 6
            v8.a r8 = M.a.o0(r8, r9, r4, r0)
            X8.w r7 = r7.C(r2, r8)
            if (r9 == 0) goto L93
            if (r10 == 0) goto L86
            kotlin.reflect.jvm.internal.impl.types.Variance r8 = kotlin.reflect.jvm.internal.impl.types.Variance.e
            goto L88
        L86:
            kotlin.reflect.jvm.internal.impl.types.Variance r8 = kotlin.reflect.jvm.internal.impl.types.Variance.c
        L88:
            h8.w r9 = r1.o
            e8.i r9 = r9.c()
            X8.A r7 = r9.h(r8, r7, r5)
            return r7
        L93:
            h8.w r8 = r1.o
            e8.i r8 = r8.c()
            kotlin.reflect.jvm.internal.impl.types.Variance r9 = kotlin.reflect.jvm.internal.impl.types.Variance.c
            X8.A r8 = r8.h(r9, r7, r5)
            h8.w r9 = r1.o
            e8.i r9 = r9.c()
            kotlin.reflect.jvm.internal.impl.types.Variance r10 = kotlin.reflect.jvm.internal.impl.types.Variance.e
            X8.A r7 = r9.h(r10, r7, r5)
            X8.A r7 = r7.f0(r6)
            X8.U r7 = X8.AbstractC0272c.f(r8, r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: A5.c.B(n8.h, v8.a, boolean):X8.U");
    }

    public w C(InterfaceC2121d interfaceC2121d, C2065a c2065a) {
        A aQ;
        C2024a c2024a = (C2024a) ((K1.a) this.b).f903a;
        if (interfaceC2121d instanceof s) {
            Class cls = ((s) interfaceC2121d).f5364a;
            PrimitiveType primitiveTypeD = k.b(cls, Void.TYPE) ? null : JvmPrimitiveType.b(cls.getName()).d();
            return primitiveTypeD != null ? c2024a.o.c().s(primitiveTypeD) : c2024a.o.c().w();
        }
        boolean z10 = false;
        if (!(interfaceC2121d instanceof j)) {
            if (interfaceC2121d instanceof h) {
                return B((h) interfaceC2121d, c2065a, false);
            }
            if (interfaceC2121d instanceof x) {
                u uVarC = ((x) interfaceC2121d).c();
                return uVarC != null ? C(uVarC, c2065a) : c2024a.o.c().m();
            }
            if (interfaceC2121d == null) {
                return c2024a.o.c().m();
            }
            throw new UnsupportedOperationException("Unsupported type: " + interfaceC2121d);
        }
        j jVar = (j) interfaceC2121d;
        if (!c2065a.e && c2065a.b != TypeUsage.f5142a) {
            z10 = true;
        }
        boolean zD = jVar.d();
        Type type = jVar.f5359a;
        if (!zD && !z10) {
            A aQ2 = q(jVar, c2065a, null);
            return aQ2 != null ? aQ2 : i.c(ErrorTypeKind.c, type.toString());
        }
        A aQ3 = q(jVar, C2065a.a(c2065a, JavaTypeFlexibility.c, false, null, null, 61), null);
        if (aQ3 != null && (aQ = q(jVar, C2065a.a(c2065a, JavaTypeFlexibility.b, false, null, null, 61), aQ3)) != null) {
            return zD ? new C2071g(aQ3, aQ) : AbstractC0272c.f(aQ3, aQ);
        }
        return i.c(ErrorTypeKind.c, type.toString());
    }

    @Override // com.google.protobuf.InterfaceC0942g1
    public D0 a(GeneratedMessageV3 generatedMessageV3) {
        int number = ((InterfaceC0974o1) GeneratedMessageV3.u((Method) this.c, generatedMessageV3, new Object[0])).getNumber();
        if (number > 0) {
            return ((C1004w0) this.b).g(number);
        }
        return null;
    }

    @Override // com.google.protobuf.InterfaceC0942g1
    public boolean b(GeneratedMessageV3 generatedMessageV3) {
        return ((InterfaceC0974o1) GeneratedMessageV3.u((Method) this.c, generatedMessageV3, new Object[0])).getNumber() != 0;
    }

    @Override // com.google.protobuf.InterfaceC0942g1
    public D0 c(AbstractC0926c1 abstractC0926c1) {
        int number = ((InterfaceC0974o1) GeneratedMessageV3.u((Method) this.d, abstractC0926c1, new Object[0])).getNumber();
        if (number > 0) {
            return ((C1004w0) this.b).g(number);
        }
        return null;
    }

    @Override // com.google.protobuf.InterfaceC0942g1
    public boolean d(AbstractC0926c1 abstractC0926c1) {
        return ((InterfaceC0974o1) GeneratedMessageV3.u((Method) this.d, abstractC0926c1, new Object[0])).getNumber() != 0;
    }

    @Override // A2.f
    public n2.a e(int i, n2.a aVar) {
        switch (this.f108a) {
            default:
                try {
                    JSONObject jSONObject = aVar.f5345a;
                    if (jSONObject.length() > 0) {
                        M.a.p(new File(((File) this.d).getAbsolutePath() + '.' + i), jSONObject);
                    }
                } catch (IOException e6) {
                    int i6 = com.apm.insight.b.f2156a;
                    M0.i.k("NPTH_CATCH", e6);
                }
                if (i == 0) {
                    C1452a c1452aB = C1452a.b();
                    if (c1452aB.f4477a != null) {
                        try {
                            ConcurrentHashMap concurrentHashMap = com.apm.insight.f.c;
                            if (concurrentHashMap != null) {
                                Iterator it = concurrentHashMap.keySet().iterator();
                                while (it.hasNext()) {
                                    c1452aB.f4477a.b((String) it.next());
                                }
                            }
                        } catch (Throwable th) {
                            int i10 = com.apm.insight.b.f2156a;
                            M0.i.k("NPTH_CATCH", th);
                        }
                    }
                }
            case 16:
                return aVar;
        }
    }

    @Override // A2.f
    public n2.a f(int i, n2.a aVar) {
        String strD;
        String str;
        int i6;
        String str2;
        com.apm.insight.f fVar;
        int i10 = 1;
        strD = "";
        switch (this.f108a) {
            case 16:
                C2032a c2032a = (C2032a) this.b;
                if (i != 0) {
                    if (i == 1) {
                        Thread thread = (Thread) this.d;
                        aVar.e(thread != null ? thread.getName() : "", "crash_thread_name");
                        aVar.e(Integer.valueOf(Process.myTid()), "tid");
                        aVar.n("portrait_count", String.valueOf(C2034c.b.get()));
                        aVar.n("rule_id", c2032a.f6691a);
                        aVar.f("rule_id", c2032a.f6691a);
                        break;
                    }
                } else {
                    aVar.e(c2032a.f6691a, "rule_id");
                    aVar.e(e.b((Throwable) this.c), "stack");
                    aVar.e(Long.valueOf(System.currentTimeMillis()), "crash_time");
                    int i11 = A2.e.f81w;
                    if (i11 != 1) {
                        i10 = i11;
                    } else if (A2.e.f82x) {
                        i10 = 2;
                    }
                    aVar.e(Integer.valueOf(i10), "launch_mode");
                    aVar.e(Long.valueOf(A2.e.y), "launch_time");
                    break;
                }
                break;
            default:
                String str3 = (String) this.b;
                str = "true";
                if (i == 1) {
                    File file = (File) this.c;
                    CrashType crashType = CrashType.NATIVE;
                    ConcurrentLinkedQueue concurrentLinkedQueue = n2.c.f5346a;
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = n2.c.f5346a.iterator();
                    while (true) {
                        if (it.hasNext() && (fVar = (com.apm.insight.f) it.next()) != null) {
                            if (z2.b.e(fVar.g())) {
                                jSONArray.put(fVar.c(crashType, null, false));
                            } else {
                                S0.b.N("not enable NativeCrash aid: " + fVar.g());
                            }
                        }
                    }
                    if (!N.g(jSONArray)) {
                        try {
                            M.a.o(new File(file, "all_data.json"), jSONArray);
                        } catch (Exception unused) {
                        }
                    }
                    if (str3 != null && str3.length() != 0) {
                        if (!TextUtils.isEmpty(str3)) {
                            if ("main".equalsIgnoreCase(str3)) {
                                strD = e.d(Looper.getMainLooper().getThread().getStackTrace());
                            } else {
                                ThreadGroup threadGroup = Looper.getMainLooper().getThread().getThreadGroup();
                                int iActiveCount = threadGroup.activeCount();
                                Thread[] threadArr = new Thread[(iActiveCount / 2) + iActiveCount];
                                int iEnumerate = threadGroup.enumerate(threadArr);
                                for (i6 = 0; i6 < iEnumerate; i6++) {
                                    String name = threadArr[i6].getName();
                                    if (!TextUtils.isEmpty(name) && (name.equals(str3) || name.startsWith(str3) || name.endsWith(str3))) {
                                        strD = e.d(threadArr[i6].getStackTrace());
                                    }
                                }
                                try {
                                    for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                                        String name2 = entry.getKey().getName();
                                        if (!name2.equals(str3) && !name2.startsWith(str3) && !name2.endsWith(str3)) {
                                        }
                                        strD = e.d(entry.getValue());
                                    }
                                } catch (Throwable th) {
                                    int i12 = com.apm.insight.b.f2156a;
                                    M0.i.k("NPTH_CATCH", th);
                                }
                            }
                        }
                        aVar.e(strD, "java_data");
                    }
                    str = Npth.hasCrashWhenNativeCrash() ? "true" : "false";
                    str2 = "crash_after_crash";
                } else if (i == 2) {
                    JSONArray jSONArrayY = d.y();
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    JSONObject jSONObjectN = d.n(jUptimeMillis);
                    JSONArray jSONArrayG = M0.i.g(jUptimeMillis);
                    aVar.e(jSONArrayY, "history_message");
                    aVar.e(jSONObjectN, "current_message");
                    aVar.e(jSONArrayG, "pending_messages");
                    aVar.f("disable_looper_monitor", String.valueOf(z2.b.f()));
                    aVar.f("npth_force_apm_crash", String.valueOf(i2.a.a()));
                    break;
                } else if (i != 3) {
                    if (i == 4) {
                        com.stepos.statsrpk.d.b(g.f2160a, aVar.f5345a);
                        o.d(N9.j.D(g.f2160a), CrashType.NATIVE, "");
                        break;
                    }
                } else if (z2.b.a("custom_event_settings", "npth_simple_setting", "enable_all_thread_stack_native") == 1) {
                    aVar.e(e.m(str3), "all_thread_stacks");
                    str2 = "has_all_thread_stack";
                }
                aVar.f(str2, str);
                break;
        }
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String g() {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: A5.c.g():java.lang.String");
    }

    public Map h() {
        Map mapM = m();
        Object obj = mapM.get("aid");
        if ((obj != null ? String.valueOf(obj) : null) == null) {
            mapM.put("aid", 4444);
        }
        return mapM;
    }

    public String j() {
        if (!TextUtils.isEmpty(f)) {
            return f;
        }
        try {
            SharedPreferences sharedPreferences = ((Context) this.b).getSharedPreferences("snssdk_openudid", 0);
            String string = sharedPreferences.getString("clientudid", null);
            if (U7.a.q(string)) {
                ((C2053a) this.d).N0(string, null);
            } else {
                string = UUID.randomUUID().toString();
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putString("clientudid", string);
                editorEdit.commit();
            }
            if (!TextUtils.isEmpty(string)) {
                string = string + "";
            }
            f = string;
            return string;
        } catch (Exception e6) {
            w.h.a("", e6);
            return "";
        }
    }

    public File k(Context context, String str) {
        ((C1912a) this.c).getClass();
        return new File(context.getDir("lib", 0), C1912a.f(str));
    }

    public String l() {
        if (((String) this.b) == null) {
            synchronized (this) {
                this.b = UUID.randomUUID().toString();
                W5.c.a("SessionController", "generate a sessionId: " + ((String) this.b));
            }
        }
        return (String) this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0105 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.util.Map] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.Map m() {
        /*
            Method dump skipped, instructions count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: A5.c.m():java.util.Map");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    public void n(Context context, String str) throws Throwable {
        String str2;
        InputStream inputStream;
        Closeable closeable;
        Closeable closeable2;
        Closeable closeable3;
        Closeable closeable4;
        C1912a c1912a = (C1912a) this.c;
        HashSet hashSet = (HashSet) this.b;
        if (hashSet.contains(str)) {
            i("%s already loaded previously!", str);
            return;
        }
        C1621a c1621a = null;
        try {
            c1912a.getClass();
            System.loadLibrary(str);
            hashSet.add(str);
            i("%s (%s) was loaded normally!", str, null);
        } catch (UnsatisfiedLinkError e6) {
            i("Loading the library normally failed: %s", Log.getStackTraceString(e6));
            i("%s (%s) was not loaded normally, re-linking...", str, null);
            File fileK = k(context, str);
            if (!fileK.exists()) {
                boolean z10 = false;
                File dir = context.getDir("lib", 0);
                File fileK2 = k(context, str);
                c1912a.getClass();
                File[] fileArrListFiles = dir.listFiles(new X9.a(C1912a.f(str), 0));
                if (fileArrListFiles != null) {
                    for (File file : fileArrListFiles) {
                        if (!file.getAbsolutePath().equals(fileK2.getAbsolutePath())) {
                            try {
                                file.delete();
                            } catch (SecurityException e9) {
                                e9.printStackTrace();
                            }
                        }
                    }
                }
                C1417f c1417f = (C1417f) this.d;
                String[] strArr = Build.SUPPORTED_ABIS;
                if (strArr.length <= 0) {
                    String str3 = Build.CPU_ABI2;
                    strArr = (str3 == null || str3.length() == 0) ? new String[]{Build.CPU_ABI} : new String[]{Build.CPU_ABI, str3};
                }
                String strF = C1912a.f(str);
                c1417f.getClass();
                try {
                    C1621a c1621aC = C1417f.c(context, strArr, strF);
                    try {
                        if (c1621aC == null) {
                            throw new org.extra.relinker.b(strF);
                        }
                        ZipFile zipFile = (ZipFile) c1621aC.f4793a;
                        int i = 0;
                        while (true) {
                            int i6 = i + 1;
                            try {
                                if (i >= 5) {
                                    zipFile.close();
                                    break;
                                }
                                i("Found %s! Extracting...", strF);
                                if (fileK.exists() || fileK.createNewFile()) {
                                    try {
                                        inputStream = zipFile.getInputStream((ZipEntry) c1621aC.b);
                                    } catch (FileNotFoundException unused) {
                                        str2 = strF;
                                        inputStream = null;
                                    } catch (IOException unused2) {
                                        str2 = strF;
                                        inputStream = null;
                                    } catch (Throwable th) {
                                        th = th;
                                        inputStream = null;
                                    }
                                    try {
                                        FileOutputStream fileOutputStream = new FileOutputStream(fileK);
                                        try {
                                            byte[] bArr = new byte[4096];
                                            long j5 = 0;
                                            ?? r82 = z10;
                                            while (true) {
                                                int i10 = inputStream.read(bArr);
                                                if (i10 == -1) {
                                                    break;
                                                }
                                                fileOutputStream.write(bArr, r82, i10);
                                                j5 += i10;
                                                strF = strF;
                                                r82 = 0;
                                            }
                                            fileOutputStream.flush();
                                            fileOutputStream.getFD().sync();
                                            if (j5 == fileK.length()) {
                                                C1417f.l(inputStream);
                                                C1417f.l(fileOutputStream);
                                                fileK.setReadable(true, r82);
                                                fileK.setExecutable(true, r82);
                                                fileK.setWritable(true);
                                                zipFile.close();
                                                break;
                                            }
                                            C1417f.l(inputStream);
                                            C1417f.l(fileOutputStream);
                                            str2 = strF;
                                        } catch (FileNotFoundException unused3) {
                                            str2 = strF;
                                            closeable3 = fileOutputStream;
                                            C1417f.l(inputStream);
                                            closeable4 = closeable3;
                                            C1417f.l(closeable4);
                                            strF = str2;
                                            i = i6;
                                            z10 = false;
                                        } catch (IOException unused4) {
                                            str2 = strF;
                                            closeable2 = fileOutputStream;
                                            C1417f.l(inputStream);
                                            closeable4 = closeable2;
                                            C1417f.l(closeable4);
                                            strF = str2;
                                            i = i6;
                                            z10 = false;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            closeable = fileOutputStream;
                                            C1417f.l(inputStream);
                                            C1417f.l(closeable);
                                            throw th;
                                        }
                                    } catch (FileNotFoundException unused5) {
                                        str2 = strF;
                                        closeable3 = null;
                                        C1417f.l(inputStream);
                                        closeable4 = closeable3;
                                        C1417f.l(closeable4);
                                        strF = str2;
                                        i = i6;
                                        z10 = false;
                                    } catch (IOException unused6) {
                                        str2 = strF;
                                        closeable2 = null;
                                        C1417f.l(inputStream);
                                        closeable4 = closeable2;
                                        C1417f.l(closeable4);
                                        strF = str2;
                                        i = i6;
                                        z10 = false;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        closeable = null;
                                        C1417f.l(inputStream);
                                        C1417f.l(closeable);
                                        throw th;
                                    }
                                } else {
                                    str2 = strF;
                                }
                                strF = str2;
                                i = i6;
                                z10 = false;
                            } catch (IOException unused7) {
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        c1621a = c1621aC;
                        if (c1621a != null) {
                            try {
                                ((ZipFile) c1621a.f4793a).close();
                            } catch (IOException unused8) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            }
            String absolutePath = fileK.getAbsolutePath();
            c1912a.getClass();
            System.load(absolutePath);
            hashSet.add(str);
            i("%s (%s) was re-linked!", str, null);
        }
    }

    public AbstractC1551g o(AbstractC1551g abstractC1551g) {
        ArrayDeque arrayDeque = (ArrayDeque) this.c;
        if (abstractC1551g != null) {
            if (!u(abstractC1551g)) {
                return abstractC1551g;
            }
            ((ArrayList) this.b).add(new C1449a((C1548d) abstractC1551g));
        }
        while (u((AbstractC1551g) arrayDeque.peek())) {
            ((ArrayList) this.b).add(new C1449a((C1548d) arrayDeque.poll()));
        }
        return null;
    }

    @Override // stepos.support.v7.app.P
    public void onPermissionClick(DialogInterface dialogInterface, boolean z10, boolean z11) {
        Context context = (Context) this.c;
        if (z11 && ((String) this.b).equals("2")) {
            SocketHookUtil.recoveryPlatform();
            ReadClipboardUtils.setAgreeReadClipBoard(ReadClipboardUtils.READ_CLIPBOARD_PERMISSION_AGREE);
            PolicyManager policyManager = PolicyManager.INSTANCE;
            policyManager.saveReadClipboardStatus(context);
            policyManager.saveAgreeStatus(context, 1);
        }
        ((P) this.d).onPermissionClick(dialogInterface, z10, z11);
    }

    public AbstractC1551g p(AbstractC1551g abstractC1551g) {
        AbstractC1551g abstractC1551gO = o(abstractC1551g);
        return abstractC1551gO != null ? abstractC1551gO : (AbstractC1551g) ((ArrayDeque) this.c).poll();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x020e  */
    /* JADX WARN: Type inference failed for: r11v18, types: [C7.f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r19v0 */
    /* JADX WARN: Type inference failed for: r19v1, types: [X8.A] */
    /* JADX WARN: Type inference failed for: r19v4 */
    /* JADX WARN: Type inference failed for: r19v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public X8.A q(n8.j r23, v8.C2065a r24, X8.A r25) {
        /*
            Method dump skipped, instructions count: 1079
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: A5.c.q(n8.j, v8.a, X8.A):X8.A");
    }

    public String r() {
        try {
            return ((ICommonParams) this.c).getDeviceId();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String s() {
        try {
            return String.valueOf(((ICommonParams) this.c).getCommonParams().get("aid"));
        } catch (Throwable unused) {
            return "4444";
        }
    }

    public float t(String name) {
        k.f(name, "name");
        float[] fArr = (float[]) ((LinkedHashMap) this.d).get(name);
        if (fArr == null) {
            return 0.0f;
        }
        Float fValueOf = fArr.length > 0 ? Float.valueOf(fArr[0]) : null;
        if (fValueOf != null) {
            return fValueOf.floatValue();
        }
        return 0.0f;
    }

    public String toString() {
        switch (this.f108a) {
            case 13:
                StringBuilder sb = new StringBuilder(32);
                sb.append((String) this.b);
                sb.append('{');
                c cVar = (c) ((c) this.c).d;
                String str = "";
                while (cVar != null) {
                    Object obj = cVar.c;
                    sb.append(str);
                    String str2 = (String) cVar.b;
                    if (str2 != null) {
                        sb.append(str2);
                        sb.append('=');
                    }
                    if (obj == null || !obj.getClass().isArray()) {
                        sb.append(obj);
                    } else {
                        String strDeepToString = Arrays.deepToString(new Object[]{obj});
                        sb.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
                    }
                    cVar = (c) cVar.d;
                    str = ", ";
                }
                sb.append('}');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public boolean u(AbstractC1551g abstractC1551g) {
        if (abstractC1551g != null && abstractC1551g.c(Event$ID.b)) {
            C1548d c1548d = (C1548d) abstractC1551g;
            for (CommentType commentType : (CommentType[]) this.d) {
                if (c1548d.c == commentType) {
                    return true;
                }
            }
        }
        return false;
    }

    public void v(String name, float[] v10, boolean z10) {
        k.f(name, "name");
        k.f(v10, "v");
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.d;
        float[] fArrCopyOf = Arrays.copyOf(v10, v10.length);
        k.e(fArrCopyOf, "copyOf(...)");
        linkedHashMap.put(name, fArrCopyOf);
        if (z10) {
            ((n) this.b).invoke(name, v10);
            ((S7.a) this.c).invoke();
        }
    }

    @Override // z3.G
    public String w() {
        switch (this.f108a) {
        }
        return (String) this.b;
    }

    @Override // z3.G
    public boolean x(JsonNode jsonNode) {
        switch (this.f108a) {
            case 23:
                JsonNode jsonNode2 = (JsonNode) this.c;
                if (!jsonNode2.isDouble() || jsonNode2.doubleValue() != Double.POSITIVE_INFINITY) {
                    if (!jsonNode2.isDouble() || jsonNode2.doubleValue() != Double.NEGATIVE_INFINITY) {
                        if (!jsonNode.isDouble() || jsonNode.doubleValue() != Double.NEGATIVE_INFINITY) {
                            if (!jsonNode.isDouble() || jsonNode.doubleValue() != Double.POSITIVE_INFINITY) {
                                int iCompareTo = new BigDecimal(jsonNode.asText()).compareTo(new BigDecimal((String) this.b));
                                if (iCompareTo <= 0 && (!((z3.x) this.d).g || iCompareTo != 0)) {
                                }
                            }
                        }
                    }
                    break;
                }
                break;
            default:
                JsonNode jsonNode3 = (JsonNode) this.c;
                if (!jsonNode3.isDouble() || jsonNode3.doubleValue() != Double.NEGATIVE_INFINITY) {
                    if ((!jsonNode3.isDouble() || jsonNode3.doubleValue() != Double.POSITIVE_INFINITY) && (!jsonNode.isDouble() || jsonNode.doubleValue() != Double.NEGATIVE_INFINITY)) {
                        if (!jsonNode.isDouble() || jsonNode.doubleValue() != Double.POSITIVE_INFINITY) {
                            int iCompareTo2 = new BigDecimal(jsonNode.asText()).compareTo(new BigDecimal((String) this.b));
                            if (iCompareTo2 >= 0 && (!((z3.x) this.d).g || iCompareTo2 != 0)) {
                            }
                        }
                    }
                    break;
                }
                break;
        }
        return true;
    }

    public void y(LinkedHashMap linkedHashMap) {
        LinkedHashMap linkedHashMap2 = (LinkedHashMap) this.d;
        linkedHashMap2.clear();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            float[] fArr = (float[]) entry.getValue();
            float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
            k.e(fArrCopyOf, "copyOf(...)");
            linkedHashMap2.put(str, fArrCopyOf);
        }
    }

    public Map z(F9.G request) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        k.f(request, "request");
        final long jCurrentTimeMillis = System.currentTimeMillis();
        String strValueOf = String.valueOf(((AtomicLong) this.d).updateAndGet(new LongUnaryOperator() { // from class: A5.b
            @Override // java.util.function.LongUnaryOperator
            public final long applyAsLong(long j5) {
                return Math.max(jCurrentTimeMillis, j5 + 1);
            }
        }));
        String str = (String) this.b;
        String str2 = (String) this.c;
        String message = str + strValueOf + strValueOf + str2;
        k.f(message, "message");
        Mac mac = Mac.getInstance("HmacSHA256");
        Charset charset = AbstractC1607a.f4778a;
        byte[] bytes = str2.getBytes(charset);
        k.e(bytes, "getBytes(...)");
        mac.init(new SecretKeySpec(bytes, "HmacSHA256"));
        byte[] bytes2 = message.getBytes(charset);
        k.e(bytes2, "getBytes(...)");
        byte[] bArrDoFinal = mac.doFinal(bytes2);
        k.e(bArrDoFinal, "doFinal(...)");
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        int i = 0;
        for (byte b : bArrDoFinal) {
            i++;
            if (i > 1) {
                sb.append((CharSequence) "");
            }
            sb.append((CharSequence) String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1)));
        }
        sb.append((CharSequence) "");
        return kotlin.collections.a.R(new Pair("zy-app-id", str), new Pair("zy-nonce", strValueOf), new Pair("zy-timestamp", strValueOf), new Pair("zy-sign", sb.toString()));
    }

    public c(File file) {
        String strA;
        this.f108a = 21;
        this.d = file;
        N9.j.g(g.f2160a, file.getName());
        B1.c cVar = new B1.c();
        File file2 = new File(file, "header.bin");
        if (file2.exists() && file2.length() != 0 && (strA = NativeImpl.a(file2.getAbsolutePath())) != null) {
            String[] strArrSplit = strA.split("\n");
            cVar.f180a = new HashMap();
            for (String str : strArrSplit) {
                String[] strArrSplit2 = str.split("=");
                if (strArrSplit2.length == 2) {
                    ((HashMap) cVar.f180a).put(strArrSplit2[0], strArrSplit2[1]);
                }
            }
        }
        this.c = cVar;
        x2.d dVar = new x2.d(file);
        this.b = dVar;
        if (cVar.k() && dVar.e == null) {
            File file3 = new File(file, "tombstone.txt");
            if (file3.exists()) {
                file3.renameTo(new File(file3.getAbsoluteFile() + ".old"));
            }
            NativeImpl.d(file);
            dVar.a(new File(file, "tombstone.txt"));
        }
    }

    public c(File file, File file2, String str) {
        this.f108a = 20;
        this.c = file;
        this.b = str;
        this.d = file2;
    }

    public /* synthetic */ c(Object obj, Object obj2, Object obj3, int i) {
        this.f108a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    public /* synthetic */ c(AbstractC2161f abstractC2161f, JsonNode jsonNode, String str, int i) {
        this.f108a = i;
        this.d = abstractC2161f;
        this.c = jsonNode;
        this.b = str;
    }

    public /* synthetic */ c(F.g gVar) {
        this.f108a = 9;
        this.b = (String) gVar.b;
        this.c = (String[]) gVar.c;
        this.d = null;
    }

    public c(Context context, s.g gVar, C2053a c2053a) {
        this.f108a = 19;
        gVar.b.getClass();
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        C1597b c1597b = new C1597b();
        this.d = c2053a;
        C1406c c1406c = gVar.b;
        c1406c.getClass();
        StringBuilder sbF = M.a.f("applog_stats_");
        sbF.append(c1406c.f4335a);
        l lVar = new l(applicationContext, sbF.toString());
        this.c = lVar;
        lVar.f160a = c2053a;
        new Thread(new RunnableC1484b(c1597b, 7)).start();
    }

    public c(App app) {
        this.f108a = 4;
        HandlerThread handlerThread = new HandlerThread("com.stepos.statsapp.v3.SessionControllerWorker", 5);
        handlerThread.start();
        this.c = new Q5.a(this, handlerThread.getLooper(), 1);
        Q5.b bVar = (Q5.b) this.d;
        if (bVar != null) {
            app.unregisterActivityLifecycleCallbacks(bVar);
            this.d = null;
        }
        Q5.b bVar2 = new Q5.b(this);
        this.d = bVar2;
        app.registerActivityLifecycleCallbacks(bVar2);
        W5.c.a("SessionController", "registerApplicationLifeCycle");
        W5.c.a("SessionController", "SessionController init");
    }

    public c(C2195g c2195g, C2031a c2031a) {
        this.f108a = 14;
        this.b = c2195g;
        this.c = c2031a;
        this.d = new ConcurrentHashMap();
    }

    public c(K1.a aVar, InterfaceC2028e typeParameterResolver) {
        this.f108a = 17;
        k.f(typeParameterResolver, "typeParameterResolver");
        this.b = aVar;
        this.c = typeParameterResolver;
        this.d = new C1449a(new C2068d());
    }

    public c(String str, String str2) {
        this.f108a = 0;
        this.b = str;
        this.c = str2;
        this.d = new AtomicLong(0L);
    }

    public c(InterfaceC1525h classifierDescriptor, List arguments, c cVar) {
        this.f108a = 11;
        k.f(classifierDescriptor, "classifierDescriptor");
        k.f(arguments, "arguments");
        this.b = classifierDescriptor;
        this.c = arguments;
        this.d = cVar;
    }

    public c(Y7.f argumentRange, List[] listArr, Method method) {
        this.f108a = 6;
        k.f(argumentRange, "argumentRange");
        this.b = argumentRange;
        this.c = listArr;
        this.d = method;
    }

    public c(ArrayDeque arrayDeque, CommentType[] commentTypeArr) {
        this.f108a = 10;
        this.c = arrayDeque;
        this.d = commentTypeArr;
        this.b = new ArrayList();
    }

    public c(String str, n nVar, S7.a aVar) {
        this.f108a = 2;
        this.b = nVar;
        this.c = aVar;
        this.d = new LinkedHashMap();
    }

    public c(String str) {
        this.f108a = 13;
        c cVar = new c(12);
        this.c = cVar;
        this.d = cVar;
        this.b = str;
    }

    public c(kotlinx.coroutines.sync.a aVar, S7.o oVar, S7.o oVar2, C0203b c0203b) {
        this.f108a = 18;
        this.b = oVar;
        this.c = oVar2;
        this.d = c0203b;
    }

    public c(int i) {
        this.f108a = i;
        switch (i) {
            case 5:
                C1912a c1912a = new C1912a();
                C1417f c1417f = new C1417f(6);
                this.b = new HashSet();
                this.c = c1912a;
                this.d = c1417f;
                break;
            case 12:
                break;
            default:
                String string = UUID.randomUUID().toString();
                k.e(string, "randomUUID().toString()");
                ByteString byteString = ByteString.d;
                this.b = C1912a.i(string);
                this.c = D.e;
                this.d = new ArrayList();
                break;
        }
    }

    public c(C1004w0 c1004w0, String str, Class cls, Class cls2) {
        this.f108a = 7;
        this.b = c1004w0;
        this.c = GeneratedMessageV3.t(cls, B7.a.m("get", str, "Case"), new Class[0]);
        this.d = GeneratedMessageV3.t(cls2, B7.a.m("get", str, "Case"), new Class[0]);
        GeneratedMessageV3.t(cls2, B7.a.k("clear", str), new Class[0]);
    }
}
