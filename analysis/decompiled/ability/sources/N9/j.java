package N9;

import D7.v;
import D7.w;
import Q8.o;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import androidx.compose.material3.internal.CalendarModelKt;
import androidx.compose.ui.unit.Dp;
import b8.p0;
import ca.AbstractC0897f;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.ability.mcpserver.model.TaskResult;
import h8.InterfaceC1503K;
import h8.InterfaceC1520c;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import h8.InterfaceC1536s;
import i8.InterfaceC1556b;
import i8.InterfaceC1561g;
import j9.t;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k8.Q;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable;
import org.json.JSONArray;
import stepai.android.logger.Logger;
import u8.C2045C;

/* loaded from: classes4.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f1023a = false;
    public static final w.f b = new w.f(1);
    public static String c;
    public static File d;
    public static File e;
    public static File f;
    public static String g;

    public static final String A(String str, Map map) {
        kotlin.jvm.internal.k.f(map, "<this>");
        Object obj = map.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public static boolean B(InterfaceC1561g interfaceC1561g, G8.c fqName) {
        kotlin.jvm.internal.k.f(fqName, "fqName");
        return interfaceC1561g.m(fqName) != null;
    }

    public static String C(Context context) {
        if (TextUtils.isEmpty(c)) {
            try {
                c = context.getFilesDir().getAbsolutePath();
            } catch (Exception e6) {
                c = "/sdcard/";
                e6.printStackTrace();
            }
        }
        return c;
    }

    public static File D(Context context) {
        return new File(C(context) + "/apminsight/CustomFile/" + com.apm.insight.g.g());
    }

    public static p0 E(InterfaceC1520c interfaceC1520c, S7.a aVar) {
        if (aVar != null) {
            return new p0(interfaceC1520c, aVar);
        }
        throw new IllegalArgumentException("Argument for @NotNull parameter 'initializer' of kotlin/reflect/jvm/internal/ReflectProperties.lazySoft must not be null");
    }

    public static final void F(String str, String str2) {
        kotlin.jvm.internal.k.f(str, "<this>");
        Logger.INSTANCE.d(str2, str);
    }

    public static final void G(String str, String str2) {
        kotlin.jvm.internal.k.f(str, "<this>");
        Logger.INSTANCE.e(str2, str);
    }

    public static final void H(String str, String tag) {
        kotlin.jvm.internal.k.f(str, "<this>");
        kotlin.jvm.internal.k.f(tag, "tag");
        Logger.INSTANCE.i(tag, str);
    }

    public static final void I(String str, String str2) {
        kotlin.jvm.internal.k.f(str, "<this>");
        Logger.INSTANCE.v(str2, str);
    }

    public static final void J(String str, String str2) {
        kotlin.jvm.internal.k.f(str, "<this>");
        Logger.INSTANCE.w(str2, str);
    }

    public static float K(float f7, float... fArr) {
        for (float f9 : fArr) {
            f7 = Math.max(f7, f9);
        }
        return f7;
    }

    public static Comparable L(Dp a3, Dp b5) {
        kotlin.jvm.internal.k.f(a3, "a");
        kotlin.jvm.internal.k.f(b5, "b");
        return a3.compareTo(b5) >= 0 ? a3 : b5;
    }

    public static final int M(W7.c cVar, Y7.f fVar) {
        kotlin.jvm.internal.k.f(cVar, "<this>");
        int i = fVar.f1569a;
        if (!fVar.isEmpty()) {
            int i6 = fVar.b;
            return i6 < Integer.MAX_VALUE ? cVar.c(i, i6 + 1) : i > Integer.MIN_VALUE ? cVar.c(i - 1, i6) + 1 : cVar.b();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + fVar);
    }

    public static G8.f N(G8.f fVar, String str, String str2, int i) {
        char cCharAt;
        char cCharAt2;
        Object next;
        boolean z10 = (i & 4) != 0;
        if ((i & 8) != 0) {
            str2 = null;
        }
        if (!fVar.b) {
            String strC = fVar.c();
            if (t.e0(strC, str, false) && strC.length() != str.length() && ('a' > (cCharAt = strC.charAt(str.length())) || cCharAt >= '{')) {
                if (str2 != null) {
                    return G8.f.e(str2.concat(j9.m.y0(str, strC)));
                }
                if (!z10) {
                    return fVar;
                }
                String strY0 = j9.m.y0(str, strC);
                if (strY0.length() != 0 && M0.i.z(0, strY0)) {
                    if (strY0.length() != 1 && M0.i.z(1, strY0)) {
                        Y7.e it = new Y7.f(0, strY0.length() - 1, 1).iterator();
                        while (true) {
                            if (!it.c) {
                                next = null;
                                break;
                            }
                            next = it.next();
                            if (!M0.i.z(((Number) next).intValue(), strY0)) {
                                break;
                            }
                        }
                        Integer num = (Integer) next;
                        if (num != null) {
                            int iIntValue = num.intValue() - 1;
                            String strSubstring = strY0.substring(0, iIntValue);
                            kotlin.jvm.internal.k.e(strSubstring, "substring(...)");
                            String strJ = M0.i.J(strSubstring);
                            String strSubstring2 = strY0.substring(iIntValue);
                            kotlin.jvm.internal.k.e(strSubstring2, "substring(...)");
                            strY0 = strJ.concat(strSubstring2);
                        } else {
                            strY0 = M0.i.J(strY0);
                        }
                    } else if (strY0.length() != 0 && 'A' <= (cCharAt2 = strY0.charAt(0)) && cCharAt2 < '[') {
                        char lowerCase = Character.toLowerCase(cCharAt2);
                        String strSubstring3 = strY0.substring(1);
                        kotlin.jvm.internal.k.e(strSubstring3, "substring(...)");
                        strY0 = lowerCase + strSubstring3;
                    }
                }
                if (G8.f.f(strY0)) {
                    return G8.f.e(strY0);
                }
            }
        }
        return null;
    }

    public static Object O(Object obj, Map map) {
        TaskResult taskResult;
        Integer numF0;
        if (obj instanceof String) {
            String str = (String) obj;
            if (t.e0(str, "$ref:", false)) {
                List listD0 = j9.m.D0(j9.m.y0("$ref:", str), new String[]{"."}, 6);
                if (listD0.size() < 2 || (taskResult = (TaskResult) map.get((String) listD0.get(0))) == null || !taskResult.getSuccess()) {
                    return null;
                }
                Object result = taskResult.getResult();
                int size = listD0.size();
                for (int i = 1; i < size; i++) {
                    String str2 = (String) listD0.get(i);
                    if (!kotlin.jvm.internal.k.b(str2, "result") || i != 1) {
                        if (result instanceof Map) {
                            result = ((Map) result).get(str2);
                        } else {
                            if (!(result instanceof List) || (numF0 = t.f0(str2)) == null) {
                                return null;
                            }
                            result = v.D0(numF0.intValue(), (List) result);
                        }
                    }
                }
                return result;
            }
        } else {
            if (obj instanceof Map) {
                kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
                Map map2 = (Map) obj;
                LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.collections.a.P(map2.size()));
                for (Map.Entry entry : map2.entrySet()) {
                    linkedHashMap.put(entry.getKey(), O(entry.getValue(), map));
                }
                return linkedHashMap;
            }
            if (obj instanceof List) {
                Iterable iterable = (Iterable) obj;
                ArrayList arrayList = new ArrayList(w.c0(iterable, 10));
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(O(it.next(), map));
                }
                return arrayList;
            }
        }
        return obj;
    }

    public static int P(int i) {
        return (int) (Integer.rotateLeft((int) (i * (-862048943)), 15) * 461845907);
    }

    public static void Q(Rect rect, A5.c cVar, int i, int i6, float f7) {
        float f9 = i;
        float f10 = f9 / 1080.0f;
        float fT = cVar.t("uCenterX") * f9;
        float fT2 = cVar.t("uCenterY") * i6;
        float fT3 = cVar.t("uSizeW1") * f10 * 0.5f;
        float fT4 = cVar.t("uSizeH1") * f10 * 0.5f;
        float fT5 = (cVar.t("uBlur1") * f7) + (cVar.t("uEndWidth") * f10 * 0.5f) + 32.0f;
        rect.union(new Rect((int) ((fT - fT3) - fT5), (int) ((fT2 - fT4) - fT5), (int) (fT + fT3 + fT5), (int) (fT2 + fT4 + fT5)));
    }

    public static void R(Parcel parcel, Parcelable parcelable, int i) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, i);
        }
    }

    public static Object a(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() != 0) {
            return creator.createFromParcel(parcel);
        }
        return null;
    }

    public static void b(Parcel parcel, List list, int i) {
        if (list == null) {
            parcel.writeInt(-1);
            return;
        }
        int size = list.size();
        parcel.writeInt(size);
        for (int i6 = 0; i6 < size; i6++) {
            R(parcel, (Parcelable) list.get(i6), i);
        }
    }

    public static File c() {
        File file = d;
        if (file != null) {
            return file;
        }
        Context context = com.apm.insight.g.f2160a;
        if (d == null) {
            d = new File(C(context), "apminsight/CrashLogNative");
        }
        return d;
    }

    public static File d(long j5) {
        return new File(C(com.apm.insight.g.f2160a), "apminsight/ProcessTrack/" + ((j5 - (j5 % CalendarModelKt.MillisecondsIn24Hours)) / CalendarModelKt.MillisecondsIn24Hours));
    }

    public static File e(long j5, String str) {
        if (str == null) {
            return null;
        }
        return new File(C(com.apm.insight.g.f2160a), "apminsight/ProcessTrack/" + (j5 / CalendarModelKt.MillisecondsIn24Hours) + JsonPointer.SEPARATOR + str.replace(':', '_') + ".txt");
    }

    public static File f(Context context) {
        return new File(C(context), "apminsight/CrashLogJava");
    }

    public static File g(Context context, String str) {
        return new File(C(context) + "/apminsight/CrashCommonLog/" + str);
    }

    public static HashMap h(long j5) throws Throwable {
        File file = new File(C(com.apm.insight.g.f2160a), "apminsight/ProcessTrack/" + ((j5 - (j5 % CalendarModelKt.MillisecondsIn24Hours)) / CalendarModelKt.MillisecondsIn24Hours));
        String[] list = file.list();
        HashMap map = new HashMap();
        if (list != null) {
            for (String str : list) {
                File file2 = new File(file, str);
                long length = file2.length();
                try {
                    JSONArray jSONArrayH = M.a.h(file2, length > 1048576 ? length - 524288 : 0L);
                    int length2 = jSONArrayH.length() - 1;
                    while (true) {
                        if (length2 >= 0) {
                            String strOptString = jSONArrayH.optString(length2);
                            if (!TextUtils.isEmpty(strOptString) && strOptString.startsWith("anr_trace")) {
                                map.put(str.replace('_', ':').replace(".txt", ""), new z2.m(strOptString));
                                break;
                            }
                            length2--;
                        }
                    }
                } catch (IOException unused) {
                }
            }
        }
        return map;
    }

    public static void i(String str, String str2) {
        try {
            File fileJ = j();
            if (fileJ != null) {
                M.a.t(g + ' ' + str + ' ' + str2 + ' ' + System.currentTimeMillis() + '\n', fileJ, true);
            }
        } catch (Throwable unused) {
        }
    }

    public static File j() {
        if (f == null) {
            Context context = com.apm.insight.g.f2160a;
            String strO = com.stepos.statsrpk.d.o();
            if (strO == null) {
                return null;
            }
            g = String.valueOf(Process.myPid());
            long jCurrentTimeMillis = System.currentTimeMillis();
            f = new File(C(com.apm.insight.g.f2160a), "apminsight/ProcessTrack/" + ((jCurrentTimeMillis - (jCurrentTimeMillis % CalendarModelKt.MillisecondsIn24Hours)) / CalendarModelKt.MillisecondsIn24Hours) + JsonPointer.SEPARATOR + strO.replace(':', '_') + ".txt");
            z2.l.i().b(new A1.a(25), 15000L);
        }
        return f;
    }

    public static File k(Context context, String str) {
        return new File(C(context) + "/apminsight/CustomFile/" + str);
    }

    public static final String l(Number number, Number number2) {
        return "Random range is empty: [" + number + ", " + number2 + ").";
    }

    public static int m(Comparable comparable, Comparable comparable2) {
        if (comparable == comparable2) {
            return 0;
        }
        if (comparable == null) {
            return -1;
        }
        if (comparable2 == null) {
            return 1;
        }
        return comparable.compareTo(comparable2);
    }

    public static final ArrayList n(ArrayList arrayList, Collection oldValueParameters, InterfaceC1536s interfaceC1536s) {
        kotlin.jvm.internal.k.f(oldValueParameters, "oldValueParameters");
        arrayList.size();
        oldValueParameters.size();
        ArrayList arrayListM1 = v.m1(arrayList, oldValueParameters);
        ArrayList arrayList2 = new ArrayList(w.c0(arrayListM1, 10));
        Iterator it = arrayListM1.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            X8.w wVar = (X8.w) pair.f4886a;
            Q q5 = (Q) pair.b;
            int i = q5.f;
            InterfaceC1561g annotations = q5.getAnnotations();
            G8.f name = q5.getName();
            kotlin.jvm.internal.k.e(name, "getName(...)");
            boolean zS0 = q5.S0();
            boolean z10 = q5.h;
            boolean z11 = q5.i;
            X8.w wVarF = q5.f4842j != null ? kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.j(interfaceC1536s).c().f(wVar) : null;
            InterfaceC1503K source = q5.getSource();
            kotlin.jvm.internal.k.e(source, "getSource(...)");
            arrayList2.add(new Q(interfaceC1536s, null, i, annotations, name, wVar, zS0, z10, z11, wVarF, source));
        }
        return arrayList2;
    }

    public static D8.k o(ProtoBuf$VersionRequirementTable table) {
        kotlin.jvm.internal.k.f(table, "table");
        if (table.b.size() == 0) {
            return D8.k.b;
        }
        List list = table.b;
        kotlin.jvm.internal.k.e(list, "getRequirementList(...)");
        return new D8.k(list);
    }

    public static File p(Context context) {
        if (e == null) {
            e = new File(C(context) + "/apminsight/CrashCommonLog/" + com.apm.insight.g.g());
        }
        return e;
    }

    public static InterfaceC1556b q(InterfaceC1561g interfaceC1561g, G8.c fqName) {
        Object next;
        kotlin.jvm.internal.k.f(fqName, "fqName");
        Iterator it = interfaceC1561g.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (kotlin.jvm.internal.k.b(((InterfaceC1556b) next).b(), fqName)) {
                break;
            }
        }
        return (InterfaceC1556b) next;
    }

    public static final Boolean r(String str, Map map) {
        kotlin.jvm.internal.k.f(map, "<this>");
        Object obj = map.get(str);
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        return null;
    }

    public static final G8.b s(D8.f fVar, int i) {
        kotlin.jvm.internal.k.f(fVar, "<this>");
        return AbstractC0897f.A(fVar.b(i), fVar.a(i));
    }

    public static String t() throws IllegalAccessException, NoSuchFieldException, IOException, SecurityException, IllegalArgumentException {
        String strTrim;
        String str;
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/cmdline")));
            strTrim = bufferedReader.readLine().trim();
            bufferedReader.close();
        } catch (Exception e6) {
            e6.printStackTrace();
            strTrim = "";
        }
        if (!TextUtils.isEmpty(strTrim)) {
            return strTrim;
        }
        try {
            activityManager = (ActivityManager) S0.b.X0().getSystemService("activity");
        } catch (Exception unused) {
        }
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null || runningAppProcesses.size() == 0) {
            str = "";
        } else {
            int iMyPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == iMyPid && (str = runningAppProcessInfo.processName) != null) {
                    break;
                }
            }
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            Application applicationX0 = S0.b.X0();
            Field field = applicationX0.getClass().getField("mLoadedApk");
            field.setAccessible(true);
            Object obj = field.get(applicationX0);
            Field declaredField = obj.getClass().getDeclaredField("mActivityThread");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            return (String) obj2.getClass().getDeclaredMethod("getProcessName", null).invoke(obj2, null);
        } catch (Exception e9) {
            e9.printStackTrace();
            return "";
        }
    }

    public static final Float u(String str, Map map) {
        kotlin.jvm.internal.k.f(map, "<this>");
        Object obj = map.get(str);
        Number number = obj instanceof Number ? (Number) obj : null;
        if (number != null) {
            return Float.valueOf(number.floatValue());
        }
        return null;
    }

    public static final Integer v(String str, Map map) {
        kotlin.jvm.internal.k.f(map, "<this>");
        Object obj = map.get(str);
        Number number = obj instanceof Number ? (Number) obj : null;
        if (number != null) {
            return Integer.valueOf(number.intValue());
        }
        return null;
    }

    public static final Long w(String str, Map map) {
        kotlin.jvm.internal.k.f(map, "<this>");
        Object obj = map.get(str);
        Number number = obj instanceof Number ? (Number) obj : null;
        if (number != null) {
            return Long.valueOf(number.longValue());
        }
        return null;
    }

    public static final G8.f x(D8.f fVar, int i) {
        kotlin.jvm.internal.k.f(fVar, "<this>");
        return G8.f.d(fVar.getString(i));
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String y(android.content.Context r12) throws java.lang.Throwable {
        /*
            C5.f r0 = C5.f.c()
            android.content.Context r12 = r12.getApplicationContext()
            java.lang.Object r1 = r0.b
            C5.b r1 = (C5.b) r1
            r2 = 0
            if (r1 != 0) goto L10
            goto L26
        L10:
            long r3 = r1.b
            long r5 = java.lang.System.currentTimeMillis()
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L1f
            java.io.Serializable r12 = r1.c
            java.lang.String r12 = (java.lang.String) r12
            return r12
        L1f:
            r3 = 1
            boolean r4 = r0.e(r12, r3)
            if (r4 != 0) goto L27
        L26:
            return r2
        L27:
            C4.a r4 = r0.a(r12)
            if (r4 == 0) goto Lac
            boolean r5 = r4.b
            if (r5 == 0) goto Lac
            if (r5 == 0) goto L3d
            java.lang.Object r5 = r4.c     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            C5.c r5 = (C5.c) r5     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            java.lang.String r5 = r5.b     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            goto L3e
        L3a:
            r8 = r2
            goto L9d
        L3d:
            r5 = r2
        L3e:
            android.net.Uri r7 = android.net.Uri.parse(r5)     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            android.content.ContentResolver r6 = r12.getContentResolver()     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            java.lang.Object r5 = r1.d     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            java.lang.String[] r10 = new java.lang.String[]{r5}     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            r11 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r5 = r6.query(r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            r6 = 0
            if (r5 == 0) goto L88
            C5.d r7 = C5.f.b(r5)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L85
            java.lang.Object r8 = r7.d     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L85
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L85
            r1.c = r8     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            long r9 = r7.c     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            r1.b = r9     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            int r1 = r7.b     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r1 == r2) goto L81
            r0.d(r12, r4)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            boolean r1 = r0.e(r12, r6)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            if (r1 != 0) goto L81
            r0.e(r12, r3)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7d
            goto L81
        L79:
            r0 = move-exception
            r12 = r0
            r2 = r5
            goto La6
        L7d:
            r0 = move-exception
            r12 = r0
        L7f:
            r2 = r5
            goto L9d
        L81:
            r2 = r8
            goto L91
        L83:
            r8 = r2
            goto L7f
        L85:
            r0 = move-exception
            r12 = r0
            goto L83
        L88:
            boolean r1 = r0.e(r12, r6)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L85
            if (r1 == 0) goto L91
            r0.e(r12, r3)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L85
        L91:
            if (r5 == 0) goto L96
            r5.close()
        L96:
            return r2
        L97:
            r0 = move-exception
            r12 = r0
            goto La6
        L9a:
            r0 = move-exception
            r12 = r0
            goto L3a
        L9d:
            r12.getMessage()     // Catch: java.lang.Throwable -> L97
            if (r2 == 0) goto La5
            r2.close()
        La5:
            return r8
        La6:
            if (r2 == 0) goto Lab
            r2.close()
        Lab:
            throw r12
        Lac:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: N9.j.y(android.content.Context):java.lang.String");
    }

    public static final C2045C z(InterfaceC1522e interfaceC1522e) {
        InterfaceC1522e interfaceC1522e2;
        InterfaceC1524g interfaceC1524gD;
        kotlin.jvm.internal.k.f(interfaceC1522e, "<this>");
        int i = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.f5120a;
        Iterator it = interfaceC1522e.g().Q().e().iterator();
        while (true) {
            if (!it.hasNext()) {
                interfaceC1522e2 = null;
                break;
            }
            X8.w wVar = (X8.w) it.next();
            if (!e8.i.x(wVar)) {
                interfaceC1524gD = wVar.Q().d();
                int i6 = J8.e.f883a;
                if (J8.e.n(interfaceC1524gD, ClassKind.f4951a) || J8.e.n(interfaceC1524gD, ClassKind.c)) {
                    break;
                }
            }
        }
        kotlin.jvm.internal.k.d(interfaceC1524gD, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        interfaceC1522e2 = (InterfaceC1522e) interfaceC1524gD;
        if (interfaceC1522e2 == null) {
            return null;
        }
        o oVarH0 = interfaceC1522e2.h0();
        C2045C c2045c = oVarH0 instanceof C2045C ? (C2045C) oVarH0 : null;
        return c2045c == null ? z(interfaceC1522e2) : c2045c;
    }
}
