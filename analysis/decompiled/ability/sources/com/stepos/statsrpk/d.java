package com.stepos.statsrpk;

import D7.A;
import D7.AbstractC0218j;
import D7.N;
import D7.w;
import F9.M;
import Q8.n;
import Q8.o;
import V9.g;
import X8.G;
import Z7.t;
import Z7.u;
import Z7.v;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Debug;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import androidx.appfunctions.metadata.AppFunctionMetadata;
import b8.l0;
import b8.m0;
import b8.p0;
import c8.C0887b;
import ca.AbstractC0897f;
import com.bytedance.applog.encryptor.EncryptorUtil;
import com.stepos.ability.appfunctions.JetpackAppFunctionsExt;
import com.stepos.ability.appfunctions.JetpackAppFunctionsReport;
import com.stepos.ability.commoninternal.CallType;
import com.stepos.ability.commoninternal.CallingMethod;
import com.stepos.ability.net.biz.model.InputSchema;
import com.stepos.ability.net.biz.model.OutputSchema;
import com.stepos.ability.net.biz.model.ToolItem;
import e2.C1404a;
import e3.z;
import h8.InterfaceC1507O;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import j9.AbstractC1607a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.net.IDN;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.zip.GZIPOutputStream;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.collections.builders.ListBuilder;
import kotlin.collections.builders.MapBuilder;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import m9.C1718k;
import n3.InterfaceFutureC1739a;
import org.json.JSONException;
import org.json.JSONObject;
import w.h;
import z8.C2196h;
import z8.l;

/* loaded from: classes3.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static c f3980a = null;
    public static String b = null;
    public static Class c = null;
    public static Field d = null;
    public static Field e = null;
    public static boolean f = false;

    /* JADX WARN: Multi-variable type inference failed */
    public static final Z7.d A(Z7.e eVar) {
        InterfaceC1522e interfaceC1522e;
        if (eVar instanceof Z7.d) {
            return (Z7.d) eVar;
        }
        if (!(eVar instanceof v)) {
            throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + eVar);
        }
        p0 p0Var = ((m0) ((v) eVar)).b;
        t tVar = m0.d[0];
        Object objInvoke = p0Var.invoke();
        k.e(objInvoke, "getValue(...)");
        List list = (List) objInvoke;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            u uVar = (u) next;
            k.d(uVar, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
            InterfaceC1524g interfaceC1524gD = ((l0) uVar).f2046a.Q().d();
            interfaceC1522e = interfaceC1524gD instanceof InterfaceC1522e ? (InterfaceC1522e) interfaceC1524gD : null;
            if (interfaceC1522e != null && interfaceC1522e.getKind() != ClassKind.b && interfaceC1522e.getKind() != ClassKind.e) {
                interfaceC1522e = next;
                break;
            }
        }
        u uVar2 = (u) interfaceC1522e;
        if (uVar2 == null) {
            uVar2 = (u) D7.v.C0(list);
        }
        return uVar2 != null ? B(uVar2) : m.f4928a.b(Object.class);
    }

    public static final Z7.d B(u uVar) {
        Z7.e eVarA = uVar.a();
        if (eVarA != null) {
            return A(eVarA);
        }
        throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + uVar);
    }

    public static String C() {
        return Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry();
    }

    public static final void D(String tag, String msg) {
        k.f(tag, "tag");
        k.f(msg, "msg");
        Ya.a.f1580a.F(tag);
        A8.d.D(new Object[0]);
    }

    public static List E(ListBuilder existing, List jetpackMetadatas, String packageName) throws JSONException {
        List<ToolItem> list;
        OutputSchema outputSchema;
        k.f(existing, "existing");
        k.f(jetpackMetadatas, "jetpackMetadatas");
        k.f(packageName, "packageName");
        if (jetpackMetadatas.isEmpty()) {
            return existing;
        }
        ArrayList arrayList = new ArrayList(w.c0(existing, 10));
        Iterator<E> it = existing.iterator();
        while (it.hasNext()) {
            arrayList.add(((ToolItem) it.next()).getFunctionName());
        }
        Set setI1 = D7.v.i1(arrayList);
        ArrayList arrayListG1 = D7.v.g1(existing);
        if (jetpackMetadatas.isEmpty()) {
            list = EmptyList.f4893a;
        } else {
            Set<Map.Entry<String, AppFunctionMetadata>> setEntrySet = JetpackAppFunctionsReport.INSTANCE.buildToolNameIndex(jetpackMetadatas).entrySet();
            int iP = kotlin.collections.a.P(w.c0(setEntrySet, 10));
            if (iP < 16) {
                iP = 16;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(iP);
            Iterator<T> it2 = setEntrySet.iterator();
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                linkedHashMap.put((AppFunctionMetadata) entry.getValue(), (String) entry.getKey());
            }
            List<AppFunctionMetadata> list2 = jetpackMetadatas;
            ArrayList arrayList2 = new ArrayList(w.c0(list2, 10));
            for (AppFunctionMetadata metadata : list2) {
                String strEncodeToolName = (String) linkedHashMap.get(metadata);
                if (strEncodeToolName == null) {
                    strEncodeToolName = JetpackAppFunctionsReport.INSTANCE.encodeToolName(metadata.getPackageName(), metadata.getId());
                }
                String toolName = strEncodeToolName;
                k.f(metadata, "metadata");
                k.f(toolName, "toolName");
                JetpackAppFunctionsReport jetpackAppFunctionsReport = JetpackAppFunctionsReport.INSTANCE;
                JSONObject anthropicTool = jetpackAppFunctionsReport.toAnthropicTool(metadata, toolName);
                String strOptString = anthropicTool.optString("description");
                if (j9.m.s0(strOptString)) {
                    strOptString = j9.m.R0(metadata.getDescription()).toString();
                    if (j9.m.s0(strOptString)) {
                        strOptString = B7.a.k("AppFunction ", metadata.getId());
                    }
                }
                String str = strOptString;
                JSONObject jSONObject = anthropicTool.getJSONObject("input_schema");
                k.e(jSONObject, "getJSONObject(...)");
                InputSchema inputSchemaF = com.stepos.ability.manager.convertor.a.f(jSONObject);
                JSONObject outputSchemaJson = jetpackAppFunctionsReport.toOutputSchemaJson(metadata);
                if (outputSchemaJson != null) {
                    InputSchema inputSchemaF2 = com.stepos.ability.manager.convertor.a.f(outputSchemaJson);
                    outputSchema = new OutputSchema(inputSchemaF2.getType(), inputSchemaF2.getProperties(), inputSchemaF2.getRequired());
                } else {
                    outputSchema = null;
                }
                OutputSchema outputSchema2 = outputSchema;
                String id = metadata.getId();
                k.c(str);
                ToolItem toolItem = new ToolItem(toolName, id, str, null, null, null, CallType.FUNCTION_CALL, CallingMethod.LOCAL, 150, "PHONE", inputSchemaF, outputSchema2, JetpackAppFunctionsExt.INSTANCE.toExecutionExtra(metadata), null, null, null, 57400, null);
                Log.i("JetpackToolConverter", "Convert Jetpack AppFunction tool -> " + toolItem);
                arrayList2.add(toolItem);
            }
            list = arrayList2;
        }
        for (ToolItem toolItem2 : list) {
            String functionName = toolItem2.getFunctionName();
            if (setI1.contains(functionName)) {
                StringBuilder sbW = B7.a.w("package=", packageName, ": duplicate functionName=\"", functionName, "\" — keep existing, skip Jetpack (functionId=");
                sbW.append(functionName);
                sbW.append(").");
                Log.w("JetpackToolConverter", sbW.toString());
            } else {
                setI1.add(functionName);
                arrayListG1.add(toolItem2);
            }
        }
        return arrayListG1;
    }

    public static void F(String str) {
        G("oobe_page_view", "oobe", kotlin.collections.a.R(new Pair("page_name", "oobe"), new Pair("step_from", str)));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void G(java.lang.String r8, java.lang.String r9, java.util.Map r10) {
        /*
            java.lang.String r0 = " page="
            java.lang.String r1 = " "
            java.lang.String r2 = "event="
            java.lang.StringBuilder r0 = B7.a.w(r2, r8, r0, r9, r1)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "VoiceWakeupTracker"
            android.util.Log.d(r1, r0)
            boolean r0 = k2.C1621a.d     // Catch: java.lang.Throwable -> L39
            if (r0 == 0) goto L3c
            java.util.HashMap r6 = new java.util.HashMap     // Catch: java.lang.Throwable -> L39
            r6.<init>(r10)     // Catch: java.lang.Throwable -> L39
            boolean r10 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> L39
            if (r10 == 0) goto L27
            r4 = r8
            goto L33
        L27:
            O5.d r10 = O5.c.f1037a     // Catch: java.lang.Throwable -> L39
            F9.v r2 = r10.g     // Catch: java.lang.Throwable -> L39
            com.stepos.ability.App r3 = r10.f1038a     // Catch: java.lang.Throwable -> L39
            r7 = 1
            r4 = r8
            r5 = r9
            r2.f(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L36
        L33:
            C7.r r8 = C7.r.f317a     // Catch: java.lang.Throwable -> L36
            goto L49
        L36:
            r0 = move-exception
        L37:
            r8 = r0
            goto L45
        L39:
            r0 = move-exception
            r4 = r8
            goto L37
        L3c:
            r4 = r8
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L36
            java.lang.String r9 = "UsageStatsProxy3 is not initialised - invoke at least once with parameterised init"
            r8.<init>(r9)     // Catch: java.lang.Throwable -> L36
            throw r8     // Catch: java.lang.Throwable -> L36
        L45:
            kotlin.Result$Failure r8 = kotlin.b.a(r8)
        L49:
            java.lang.Throwable r8 = kotlin.Result.a(r8)
            if (r8 == 0) goto L5a
            java.lang.String r8 = r8.getMessage()
            java.lang.String r9 = "track fail: event="
            java.lang.String r10 = ", "
            androidx.constraintlayout.core.dsl.a.x(r9, r4, r10, r8, r1)
        L5a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.statsrpk.d.G(java.lang.String, java.lang.String, java.util.Map):void");
    }

    public static final void H(Object[] objArr, int i, int i6) {
        k.f(objArr, "<this>");
        while (i < i6) {
            objArr[i] = null;
            i++;
        }
    }

    public static final Object I(Set set, Enum r22, Enum r32, Enum r42, boolean z10) {
        Set setJ1;
        if (!z10) {
            if (r42 != null && (setJ1 = D7.v.j1(N.M(set, r42))) != null) {
                set = setJ1;
            }
            return D7.v.V0(set);
        }
        Enum r1 = set.contains(r22) ? r22 : set.contains(r32) ? r32 : null;
        if (k.b(r1, r22) && k.b(r42, r32)) {
            return null;
        }
        return r42 == null ? r1 : r42;
    }

    public static void J(String str) {
        G("amoo_settings_wake_up_switch", "amoo_settings", kotlin.collections.a.R(new Pair("page_name", "amoo_settings"), new Pair("switch_status", str)));
    }

    public static void K(String str, String str2) {
        MapBuilder mapBuilder = new MapBuilder();
        mapBuilder.put("page_name", "oobe");
        mapBuilder.put("setup_type", "voiceprint");
        mapBuilder.put("status", str);
        if (str.equals("fail") && str2 != null && str2.length() != 0) {
            mapBuilder.put("fail_reason", str2);
        }
        G("oobe_setup_result", "oobe", mapBuilder.b());
    }

    public static String L(Map map) {
        if (map == null || map.isEmpty()) {
            return "size=0, keys=none";
        }
        List listY0 = D7.v.Y0(map.keySet());
        return androidx.constraintlayout.core.dsl.a.c(map.size(), "size=", ", keys=", listY0.size() <= 5 ? D7.v.I0(listY0, ",", null, null, null, 62) : androidx.appfunctions.metadata.a.l(D7.v.I0(D7.v.a1(listY0, 5), ",", null, null, null, 62), ",..."));
    }

    public static String M(String str) throws NoSuchAlgorithmException {
        if (str == null) {
            return "len=0, sha256=none";
        }
        if (str.length() == 0) {
            return "len=0, sha256=empty";
        }
        int length = str.length();
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = str.getBytes(AbstractC1607a.f4778a);
        k.e(bytes, "getBytes(...)");
        byte[] bArrDigest = messageDigest.digest(bytes);
        k.c(bArrDigest);
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        int i = 0;
        for (byte b5 : bArrDigest) {
            i++;
            if (i > 1) {
                sb.append((CharSequence) "");
            }
            sb.append((CharSequence) String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b5)}, 1)));
        }
        sb.append((CharSequence) "");
        return androidx.constraintlayout.core.dsl.a.c(length, "len=", ", sha256=", j9.m.N0(12, sb.toString()));
    }

    public static final String N(String str) {
        k.f(str, "<this>");
        int i = 0;
        int i6 = -1;
        if (!j9.m.h0(str, ":", false)) {
            try {
                String ascii = IDN.toASCII(str);
                k.e(ascii, "toASCII(host)");
                Locale US = Locale.US;
                k.e(US, "US");
                String lowerCase = ascii.toLowerCase(US);
                k.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (lowerCase.length() == 0) {
                    return null;
                }
                int length = lowerCase.length();
                for (int i10 = 0; i10 < length; i10++) {
                    char cCharAt = lowerCase.charAt(i10);
                    if (k.g(cCharAt, 31) <= 0 || k.g(cCharAt, 127) >= 0 || j9.m.p0(" #%/:?@[\\]", cCharAt, 0, 6) != -1) {
                        return null;
                    }
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress inetAddressT = (j9.t.e0(str, "[", false) && j9.t.W(str, "]", false)) ? t(1, str.length() - 1, str) : t(0, str.length(), str);
        if (inetAddressT == null) {
            return null;
        }
        byte[] address = inetAddressT.getAddress();
        if (address.length != 16) {
            if (address.length == 4) {
                return inetAddressT.getHostAddress();
            }
            throw new AssertionError(androidx.compose.foundation.b.m('\'', "Invalid IPv6 address: '", str));
        }
        int i11 = 0;
        int i12 = 0;
        while (i11 < address.length) {
            int i13 = i11;
            while (i13 < 16 && address[i13] == 0 && address[i13 + 1] == 0) {
                i13 += 2;
            }
            int i14 = i13 - i11;
            if (i14 > i12 && i14 >= 4) {
                i6 = i11;
                i12 = i14;
            }
            i11 = i13 + 2;
        }
        g gVar = new g();
        while (i < address.length) {
            if (i == i6) {
                gVar.L(58);
                i += i12;
                if (i == 16) {
                    gVar.L(58);
                }
            } else {
                if (i > 0) {
                    gVar.L(58);
                }
                byte b5 = address[i];
                byte[] bArr = G9.b.f704a;
                gVar.N(((b5 & 255) << 8) | (address[i + 1] & 255));
                i += 2;
            }
        }
        return gVar.G();
    }

    public static final void O(String str, String str2) {
        Ya.a.f1580a.F(str);
        A8.d.I(new Object[0]);
    }

    public static Context P(Context context) {
        k.f(context, "<this>");
        Configuration configuration = context.getResources().getConfiguration();
        if (configuration.fontScale <= 1.3f) {
            return context;
        }
        Configuration configuration2 = new Configuration(configuration);
        configuration2.fontScale = 1.3f;
        Context contextCreateConfigurationContext = context.createConfigurationContext(configuration2);
        k.e(contextCreateConfigurationContext, "createConfigurationContext(...)");
        return contextCreateConfigurationContext;
    }

    public static long a(int i) {
        if (i < 0) {
            return 0L;
        }
        return i * 1024;
    }

    public static void b(Context context, JSONObject jSONObject) {
        try {
            c(jSONObject);
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                k(jSONObject, activityManager);
            }
            d(jSONObject, activityManager);
        } catch (Throwable unused) {
        }
    }

    public static void c(JSONObject jSONObject) throws JSONException {
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("dalvikPrivateDirty", a(memoryInfo.dalvikPrivateDirty));
        jSONObject2.put("dalvikPss", a(memoryInfo.dalvikPss));
        jSONObject2.put("dalvikSharedDirty", a(memoryInfo.dalvikSharedDirty));
        jSONObject2.put("nativePrivateDirty", a(memoryInfo.nativePrivateDirty));
        jSONObject2.put("nativePss", a(memoryInfo.nativePss));
        jSONObject2.put("nativeSharedDirty", a(memoryInfo.nativeSharedDirty));
        jSONObject2.put("otherPrivateDirty", a(memoryInfo.otherPrivateDirty));
        jSONObject2.put("otherPss", a(memoryInfo.otherPss));
        jSONObject2.put("otherSharedDirty", memoryInfo.otherSharedDirty);
        try {
            String memoryStat = memoryInfo.getMemoryStat("summary.graphics");
            if (!TextUtils.isEmpty(memoryStat)) {
                jSONObject2.put("summary.graphics", a(Integer.parseInt(memoryStat)));
            }
        } catch (Throwable unused) {
        }
        jSONObject2.put("totalPrivateClean", memoryInfo.getTotalPrivateClean());
        jSONObject2.put("totalPrivateDirty", memoryInfo.getTotalPrivateDirty());
        jSONObject2.put("totalPss", a(memoryInfo.getTotalPss()));
        jSONObject2.put("totalSharedClean", memoryInfo.getTotalSharedClean());
        jSONObject2.put("totalSharedDirty", a(memoryInfo.getTotalSharedDirty()));
        jSONObject2.put("totalSwappablePss", a(memoryInfo.getTotalSwappablePss()));
        jSONObject.put("memory_info", jSONObject2);
    }

    public static void d(JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        n2.a.i(jSONObject, "filters", "native_heap_leak", String.valueOf(Debug.getNativeHeapAllocatedSize() > 209715200));
        jSONObject2.put("native_heap_size", Debug.getNativeHeapSize());
        jSONObject2.put("native_heap_alloc_size", Debug.getNativeHeapAllocatedSize());
        jSONObject2.put("native_heap_free_size", Debug.getNativeHeapFreeSize());
        Runtime runtime = Runtime.getRuntime();
        long jMaxMemory = runtime.maxMemory();
        long jFreeMemory = runtime.freeMemory();
        long j5 = runtime.totalMemory();
        jSONObject2.put("max_memory", jMaxMemory);
        jSONObject2.put("free_memory", jFreeMemory);
        jSONObject2.put("total_memory", j5);
        n2.a.i(jSONObject, "filters", "java_heap_leak", String.valueOf(((float) (j5 - jFreeMemory)) > ((float) jMaxMemory) * 0.95f));
        if (activityManager != null) {
            jSONObject2.put("memory_class", activityManager.getMemoryClass());
            jSONObject2.put("large_memory_class", activityManager.getLargeMemoryClass());
        }
        jSONObject.put("app_memory_info", jSONObject2);
    }

    public static boolean e(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ComponentName componentName;
        if (context == null) {
            return A2.e.c().p;
        }
        if (!A2.e.c().p) {
            String packageName = context.getPackageName();
            try {
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null && !runningTasks.isEmpty() && (componentName = runningTasks.get(0).topActivity) != null) {
                    if (packageName.equals(componentName.getPackageName())) {
                    }
                }
            } catch (Throwable unused) {
            }
            return false;
        }
        return true;
    }

    public static byte[] f(String str) throws IOException {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        try {
            try {
                int i = C1404a.e;
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(str.getBytes("UTF-8"));
                    gZIPOutputStream.close();
                } catch (Throwable th) {
                    th = th;
                    try {
                        h.b(th);
                        if (gZIPOutputStream != null) {
                            gZIPOutputStream.close();
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        int i6 = C1404a.e;
                        return EncryptorUtil.a(byteArray.length, byteArray);
                    } catch (Throwable th2) {
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (IOException e6) {
                                h.b(e6);
                            }
                        }
                        throw th2;
                    }
                }
            } catch (IOException e9) {
                h.b(e9);
            }
        } catch (Throwable th3) {
            th = th3;
            gZIPOutputStream = null;
        }
        byte[] byteArray2 = byteArrayOutputStream.toByteArray();
        int i62 = C1404a.e;
        return EncryptorUtil.a(byteArray2.length, byteArray2);
    }

    public static final String g(Object[] objArr, int i, int i6, AbstractC0218j abstractC0218j) {
        StringBuilder sb = new StringBuilder((i6 * 3) + 2);
        sb.append("[");
        for (int i10 = 0; i10 < i6; i10++) {
            if (i10 > 0) {
                sb.append(", ");
            }
            Object obj = objArr[i + i10];
            if (obj == abstractC0218j) {
                sb.append("(this Collection)");
            } else {
                sb.append(obj);
            }
        }
        sb.append("]");
        String string = sb.toString();
        k.e(string, "toString(...)");
        return string;
    }

    public static void h(Appendable appendable, Object obj, S7.k kVar) {
        k.f(appendable, "<this>");
        if (kVar != null) {
            appendable.append((CharSequence) kVar.invoke(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            appendable.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            appendable.append(((Character) obj).charValue());
        } else {
            appendable.append(obj.toString());
        }
    }

    public static final Object i(InterfaceFutureC1739a interfaceFutureC1739a, ContinuationImpl continuationImpl) throws Throwable {
        try {
            if (interfaceFutureC1739a.isDone()) {
                return AbstractC0897f.D(interfaceFutureC1739a);
            }
            C1718k c1718k = new C1718k(1, U7.a.I(continuationImpl));
            c1718k.y();
            interfaceFutureC1739a.addListener(new A.a(16, interfaceFutureC1739a, false, c1718k), com.google.common.util.concurrent.a.a());
            c1718k.j(new J4.b(interfaceFutureC1739a, 20));
            Object objX = c1718k.x();
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            return objX;
        } catch (ExecutionException e6) {
            Throwable cause = e6.getCause();
            k.c(cause);
            throw cause;
        }
    }

    public static void j(Runnable runnable) {
        if (f3980a == null) {
            synchronized (d.class) {
                HandlerThread handlerThread = new HandlerThread("com.stepos.statsrpk.apiWorker", 5);
                handlerThread.start();
                f3980a = new c(handlerThread.getLooper(), 0);
            }
        }
        f3980a.post(runnable);
    }

    public static void k(JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        jSONObject2.put("availMem", memoryInfo.availMem);
        jSONObject2.put("lowMemory", memoryInfo.lowMemory);
        jSONObject2.put("threshold", memoryInfo.threshold);
        jSONObject2.put("totalMem", memoryInfo.totalMem);
        jSONObject.put("sys_memory_info", jSONObject2);
    }

    public static boolean l(Context context) {
        String strO = o();
        if (strO != null && strO.contains(":")) {
            return false;
        }
        if (strO == null || !strO.equals(context.getPackageName())) {
            return strO != null && strO.equals(context.getApplicationInfo().processName);
        }
        return true;
    }

    public static final Object m(Object possiblyPrimitiveType, boolean z10) {
        JvmPrimitiveType jvmPrimitiveType;
        k.f(possiblyPrimitiveType, "possiblyPrimitiveType");
        if (z10) {
            possiblyPrimitiveType = (z8.m) possiblyPrimitiveType;
            if ((possiblyPrimitiveType instanceof l) && (jvmPrimitiveType = ((l) possiblyPrimitiveType).i) != null) {
                G8.c cVar = jvmPrimitiveType.d;
                if (cVar == null) {
                    JvmPrimitiveType.a(15);
                    throw null;
                }
                String strD = O8.b.b(cVar).d();
                k.e(strD, "getInternalName(...)");
                return C2196h.d(strD);
            }
        }
        return possiblyPrimitiveType;
    }

    public static void n(String str, String str2) {
        G("oobe_button_click", "oobe", kotlin.collections.a.R(new Pair("page_name", "oobe"), new Pair("step_from", str), new Pair("button_type", str2)));
    }

    public static String o() {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        try {
            b = D2.b.a();
        } catch (Throwable unused) {
        }
        String str = b;
        return str == null ? "" : str;
    }

    public static o p(Iterable scopes, String debugName) {
        n nVar;
        k.f(debugName, "debugName");
        k.f(scopes, "scopes");
        g9.f fVar = new g9.f();
        Iterator it = scopes.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            nVar = n.b;
            if (!zHasNext) {
                break;
            }
            o oVar = (o) it.next();
            if (oVar != nVar) {
                if (oVar instanceof Q8.a) {
                    A.g0(fVar, ((Q8.a) oVar).c);
                } else {
                    fVar.add(oVar);
                }
            }
        }
        int i = fVar.f4504a;
        return i != 0 ? i != 1 ? new Q8.a(debugName, (o[]) fVar.toArray(new o[0])) : (o) fVar.get(0) : nVar;
    }

    public static final Object q(Class annotationClass, Map map, List methods) throws IllegalArgumentException {
        k.f(annotationClass, "annotationClass");
        k.f(methods, "methods");
        C7.f fVarA = kotlin.a.a(new I8.e(map, 18));
        Object objNewProxyInstance = Proxy.newProxyInstance(annotationClass.getClassLoader(), new Class[]{annotationClass}, new C0887b(annotationClass, map, kotlin.a.a(new J4.e(8, annotationClass, map)), fVarA, methods));
        k.d(objNewProxyInstance, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance");
        return objNewProxyInstance;
    }

    public static final G r(InterfaceC1522e from, InterfaceC1522e to) {
        k.f(from, "from");
        k.f(to, "to");
        from.h().size();
        to.h().size();
        List listH = from.h();
        k.e(listH, "getDeclaredTypeParameters(...)");
        List list = listH;
        ArrayList arrayList = new ArrayList(w.c0(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((InterfaceC1507O) it.next()).m());
        }
        List listH2 = to.h();
        k.e(listH2, "getDeclaredTypeParameters(...)");
        List list2 = listH2;
        ArrayList arrayList2 = new ArrayList(w.c0(list2, 10));
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            X8.A aG = ((InterfaceC1507O) it2.next()).g();
            k.e(aG, "getDefaultType(...)");
            arrayList2.add(U7.a.p(aG));
        }
        return new G(kotlin.collections.a.X(D7.v.m1(arrayList, arrayList2)), 1);
    }

    public static final void s(String str, String msg) {
        k.f(msg, "msg");
        Ya.a.f1580a.F(str);
        A8.d.q(new Object[0]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x00cb, code lost:
    
        if (r7 == 16) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00cd, code lost:
    
        if (r8 != (-1)) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00d1, code lost:
    
        r0 = r7 - r8;
        java.lang.System.arraycopy(r3, r8, r3, 16 - r0, r0);
        java.util.Arrays.fill(r3, r8, (16 - r7) + r8, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00e1, code lost:
    
        return java.net.InetAddress.getByAddress(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:?, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.net.InetAddress t(int r17, int r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.statsrpk.d.t(int, int, java.lang.String):java.net.InetAddress");
    }

    public static final void u(String str, String msg) {
        k.f(msg, "msg");
        Ya.a.f1580a.F(str);
        A8.d.B(new Object[0]);
    }

    public static final void v(String str, String msg, Throwable tr) {
        k.f(msg, "msg");
        k.f(tr, "tr");
        Ya.a.f1580a.F(str);
        A8.d.C(new Object[0]);
    }

    public static String w(char[] cArr, int i, M2.d dVar) {
        int i6;
        if (dVar == null) {
            i6 = 0;
        } else if (dVar.equals(M2.d.c)) {
            cArr[i] = 'Z';
            i6 = 1;
        } else {
            cArr[i] = dVar.a() < 0 ? '-' : '+';
            O2.b.c(Math.abs(dVar.f963a), i + 1, cArr, 2);
            cArr[i + 3] = ':';
            O2.b.c(Math.abs(dVar.b), i + 4, cArr, 2);
            i6 = 6;
        }
        return new String(cArr, 0, i + i6);
    }

    public static Class x(Context context) {
        if (c == null && !f) {
            try {
                c = Class.forName(context.getPackageName() + ".BuildConfig");
            } catch (ClassNotFoundException unused) {
            }
            f = true;
        }
        return c;
    }

    public static Account y(Context context) {
        Account[] accountsByType = AccountManager.get(context).getAccountsByType("com.stepos.account");
        Log.e("[Cloud]Account.SDK", "getAccount length: " + accountsByType.length);
        if (accountsByType.length <= 0) {
            return null;
        }
        if (accountsByType.length != 1) {
            Log.e("[Cloud]Account.SDK", "more than 1 stepos account : " + accountsByType.length);
        }
        return accountsByType[0];
    }

    public abstract void onClosed(U9.a aVar);

    public abstract void onEvent(U9.a aVar, String str, String str2, String str3);

    public abstract void onFailure(U9.a aVar, Throwable th, M m);

    public abstract void onOpen(U9.a aVar, M m);

    public abstract void z(z zVar, float f7, float f9);
}
