package H4;

import D7.v;
import X8.A;
import X8.AbstractC0272c;
import X8.S;
import X8.w;
import a.AbstractC0291a;
import a7.AbstractC0307c;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import b8.v0;
import com.apm.insight.CrashInfoCallback;
import com.apm.insight.CrashType;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.ConfigManager;
import com.ethlo.time.Field;
import com.fasterxml.jackson.core.JsonFactory;
import com.volcengine.tos.model.object.DownloadFileCheckpoint;
import g1.AbstractC1451a;
import h8.AbstractC1508P;
import h8.C1541x;
import h8.InterfaceC1501I;
import h8.InterfaceC1510S;
import h8.InterfaceC1520c;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import h8.InterfaceC1526i;
import h8.InterfaceC1527j;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.collections.builders.ListBuilder;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.time.DurationUnit;
import n8.AbstractC1744c;
import org.json.JSONArray;
import org.json.JSONObject;
import stepai.aios.guiexecutor.api.GuiCommand;
import w2.AbstractC2095a;

/* loaded from: classes3.dex */
public abstract class o {
    public static F.i b = new F.i();

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f747a;

    public /* synthetic */ o(int i) {
        this.f747a = i;
    }

    public static File A() throws Throwable {
        BufferedWriter bufferedWriter;
        File file = new File(N9.j.p(com.apm.insight.g.f2160a), "anr_trace.txt");
        if (file.exists() || z2.b.a("custom_event_settings", "npth_simple_setting", "anr_with_traces_txt") != 1) {
            return file;
        }
        File file2 = new File("/data/anr/traces.txt");
        if (file2.exists()) {
            BufferedReader bufferedReader = null;
            try {
                file.getParentFile().mkdirs();
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));
                try {
                    bufferedWriter = new BufferedWriter(new FileWriter(file));
                    int length = 0;
                    do {
                        try {
                            String line = bufferedReader2.readLine();
                            if (line == null) {
                                break;
                            }
                            bufferedWriter.write(line);
                            bufferedWriter.write(10);
                            length += line.length();
                        } catch (IOException unused) {
                            bufferedReader = bufferedReader2;
                            M0.i.i(bufferedReader);
                            M0.i.i(bufferedWriter);
                            return file;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            M0.i.i(bufferedReader);
                            M0.i.i(bufferedWriter);
                            throw th;
                        }
                    } while (length < 1048576);
                    M0.i.i(bufferedReader2);
                } catch (IOException unused2) {
                    bufferedWriter = null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter = null;
                }
            } catch (IOException unused3) {
                bufferedWriter = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedWriter = null;
            }
            M0.i.i(bufferedWriter);
            return file;
        }
        return file;
    }

    public static final n8.d B(Annotation[] annotationArr, G8.c fqName) {
        Annotation annotation;
        kotlin.jvm.internal.k.f(annotationArr, "<this>");
        kotlin.jvm.internal.k.f(fqName, "fqName");
        int length = annotationArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                annotation = null;
                break;
            }
            annotation = annotationArr[i];
            if (kotlin.jvm.internal.k.b(AbstractC1744c.a(M.a.Z(M.a.V(annotation))).a(), fqName)) {
                break;
            }
            i++;
        }
        if (annotation != null) {
            return new n8.d(annotation);
        }
        return null;
    }

    public static final View C(View view) {
        if (view == null) {
            return null;
        }
        if (view instanceof EditText) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View viewC = C(viewGroup.getChildAt(i));
                if (viewC != null) {
                    return viewC;
                }
            }
        }
        return null;
    }

    public static final ArrayList D(Annotation[] annotationArr) {
        kotlin.jvm.internal.k.f(annotationArr, "<this>");
        ArrayList arrayList = new ArrayList(annotationArr.length);
        for (Annotation annotation : annotationArr) {
            arrayList.add(new n8.d(annotation));
        }
        return arrayList;
    }

    public static final w E(InterfaceC1520c interfaceC1520c) {
        k8.u uVarI = interfaceC1520c.I();
        k8.u uVarE = interfaceC1520c.E();
        if (uVarI != null) {
            return uVarI.getType();
        }
        if (uVarE != null) {
            if (interfaceC1520c instanceof InterfaceC1526i) {
                return uVarE.getType();
            }
            InterfaceC1527j interfaceC1527jD = interfaceC1520c.d();
            InterfaceC1522e interfaceC1522e = interfaceC1527jD instanceof InterfaceC1522e ? (InterfaceC1522e) interfaceC1527jD : null;
            if (interfaceC1522e != null) {
                return interfaceC1522e.g();
            }
        }
        return null;
    }

    public static Y7.f F(Collection collection) {
        kotlin.jvm.internal.k.f(collection, "<this>");
        return new Y7.f(0, collection.size() - 1, 1);
    }

    public static final Method G(Class cls, InterfaceC1520c descriptor) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        try {
            return cls.getDeclaredMethod("unbox-impl", null);
        } catch (NoSuchMethodException unused) {
            throw new KotlinReflectionInternalError("No unbox method found in inline class: " + cls + " (calling " + descriptor + ')');
        }
    }

    public static int H(List list) {
        kotlin.jvm.internal.k.f(list, "<this>");
        return list.size() - 1;
    }

    public static final ArrayList I(A a3) {
        ArrayList arrayListJ = J(AbstractC0272c.b(a3));
        if (arrayListJ == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(D7.w.c0(arrayListJ, 10));
        Iterator it = arrayListJ.iterator();
        while (it.hasNext()) {
            arrayList.add("unbox-impl-" + ((String) it.next()));
        }
        InterfaceC1524g interfaceC1524gD = a3.Q().d();
        kotlin.jvm.internal.k.d(interfaceC1524gD, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        Class clsK = v0.k((InterfaceC1522e) interfaceC1524gD);
        kotlin.jvm.internal.k.c(clsK);
        ArrayList arrayList2 = new ArrayList(D7.w.c0(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(clsK.getDeclaredMethod((String) it2.next(), null));
        }
        return arrayList2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.ArrayList] */
    public static final ArrayList J(A a3) {
        ?? M5;
        if (!J8.g.h(a3)) {
            return null;
        }
        InterfaceC1524g interfaceC1524gD = a3.Q().d();
        kotlin.jvm.internal.k.d(interfaceC1524gD, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        int i = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.f5120a;
        AbstractC1508P abstractC1508PP = ((InterfaceC1522e) interfaceC1524gD).P();
        C1541x c1541x = abstractC1508PP instanceof C1541x ? (C1541x) abstractC1508PP : null;
        kotlin.jvm.internal.k.c(c1541x);
        ArrayList<Pair> arrayList = c1541x.f4590a;
        ArrayList arrayList2 = new ArrayList();
        for (Pair pair : arrayList) {
            G8.f fVar = (G8.f) pair.f4886a;
            ArrayList arrayListJ = J((A) pair.b);
            if (arrayListJ != null) {
                M5 = new ArrayList(D7.w.c0(arrayListJ, 10));
                Iterator it = arrayListJ.iterator();
                while (it.hasNext()) {
                    M5.add(fVar.c() + '-' + ((String) it.next()));
                }
            } else {
                M5 = M(fVar.c());
            }
            D7.A.e0((Iterable) M5, arrayList2);
        }
        return arrayList2;
    }

    public static final boolean K(InterfaceC1522e interfaceC1522e) {
        LinkedHashSet linkedHashSet = e8.d.f4380a;
        if (!J8.e.l(interfaceC1522e)) {
            return false;
        }
        LinkedHashSet linkedHashSet2 = e8.d.f4380a;
        G8.b bVarF = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.f(interfaceC1522e);
        return v.u0(linkedHashSet2, bVarF != null ? bVarF.e() : null);
    }

    public static final void L(Ref$BooleanRef ref$BooleanRef, StringBuilder sb, String str, Object obj) {
        if (obj == null) {
            return;
        }
        if (!ref$BooleanRef.f4916a) {
            sb.append(',');
        }
        ref$BooleanRef.f4916a = false;
        j(sb, str);
        sb.append(':');
        i(obj, sb);
    }

    public static List M(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        kotlin.jvm.internal.k.e(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    public static List N(Object... elements) {
        kotlin.jvm.internal.k.f(elements, "elements");
        return elements.length > 0 ? D7.q.L(elements) : EmptyList.f4893a;
    }

    public static List O(Object obj) {
        return obj != null ? M(obj) : EmptyList.f4893a;
    }

    public static DownloadFileCheckpoint P(String str) throws IOException {
        AbstractC0307c.a(str, "checkpointFilePath is null");
        File file = new File(str);
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[(int) file.length()];
            fileInputStream.read(bArr);
            DownloadFileCheckpoint downloadFileCheckpoint = (DownloadFileCheckpoint) a7.f.b.readValue(bArr, new X6.l());
            fileInputStream.close();
            return downloadFileCheckpoint;
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

    public static ArrayList Q(Object... elements) {
        kotlin.jvm.internal.k.f(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new D7.o(elements, true));
    }

    public static final List R(List list) {
        int size = list.size();
        return size != 0 ? size != 1 ? list : M(list.get(0)) : EmptyList.f4893a;
    }

    public static s4.f S(String payloadJson, boolean z10) {
        kotlin.jvm.internal.k.f(payloadJson, "payloadJson");
        try {
            JSONObject jSONObject = new JSONObject(payloadJson);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("groups");
            if (jSONArrayOptJSONArray == null) {
                if (!jSONObject.has("group_id")) {
                    return null;
                }
                String strOptString = jSONObject.optString("group_id");
                kotlin.jvm.internal.k.e(strOptString, "optString(...)");
                String string = j9.m.R0(strOptString).toString();
                if (string.length() == 0) {
                    return null;
                }
                return new s4.f(kotlin.collections.a.Q(new Pair(string, jSONObject.optString("current_mode"))), z10);
            }
            MapBuilder mapBuilder = new MapBuilder();
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString2 = jSONObjectOptJSONObject.optString("group_id");
                    kotlin.jvm.internal.k.e(strOptString2, "optString(...)");
                    String string2 = j9.m.R0(strOptString2).toString();
                    if (string2.length() != 0) {
                        mapBuilder.put(string2, jSONObjectOptJSONObject.optString("current_mode"));
                    }
                }
            }
            return new s4.f(mapBuilder.b(), z10);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void T(String str, char[] cArr, int i) {
        throw new DateTimeParseException(String.format("Expected character %s at position %d, found %s: %s", Arrays.toString(cArr), Integer.valueOf(i + 1), Character.valueOf(str.charAt(i)), str), str, i);
    }

    public static final void U(int i, int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException(androidx.appfunctions.metadata.a.i(i6, "fromIndex (0) is greater than toIndex (", ")."));
        }
        if (i6 > i) {
            throw new IndexOutOfBoundsException(androidx.compose.foundation.b.o(i6, "toIndex (", i, ") is greater than size (", ")."));
        }
    }

    public static final String V(GuiCommand command, String str) {
        kotlin.jvm.internal.k.f(command, "command");
        Object obj = command.getMetadata().get("sessionId");
        String str2 = obj instanceof String ? (String) obj : null;
        return (str2 == null || j9.m.s0(str2)) ? str : B7.a.n("sessionId=", str2, ";", str);
    }

    public static void W() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void X() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static final Class Y(w wVar) {
        A aI;
        Class clsZ = Z(wVar.Q().d());
        if (clsZ == null) {
            return null;
        }
        if (S.e(wVar) && ((aI = J8.g.i(wVar)) == null || S.e(aI) || e8.i.F(aI))) {
            return null;
        }
        return clsZ;
    }

    public static final Class Z(InterfaceC1527j interfaceC1527j) {
        if (!(interfaceC1527j instanceof InterfaceC1522e) || !J8.g.b(interfaceC1527j)) {
            return null;
        }
        InterfaceC1522e interfaceC1522e = (InterfaceC1522e) interfaceC1527j;
        Class clsK = v0.k(interfaceC1522e);
        if (clsK != null) {
            return clsK;
        }
        throw new KotlinReflectionInternalError("Class object for the class " + interfaceC1522e.getName() + " cannot be found (classId=" + kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.f((InterfaceC1524g) interfaceC1527j) + ')');
    }

    public static File a(int i, int i6, String str) throws IOException {
        File file = new File(N9.j.g(com.apm.insight.g.f2160a, str), "logcat.txt");
        if (file.exists() && file.length() > 0) {
            return file;
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        NativeImpl.e(file.getAbsolutePath(), String.valueOf(i), String.valueOf(i6));
        return file;
    }

    public static final Pair a0(Point point) {
        kotlin.jvm.internal.k.f(point, "<this>");
        return new Pair(Integer.valueOf(point.x), Integer.valueOf(point.y));
    }

    public static void b() {
        try {
            ConfigManager configManager = com.apm.insight.g.g;
            a(configManager.getLogcatDumpCount(), configManager.getLogcatLevel(), com.apm.insight.g.g());
            if (com.apm.insight.g.f2167w) {
                File file = new File(N9.j.p(com.apm.insight.g.f2160a), "maps.txt");
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                    try {
                        file.createNewFile();
                    } catch (IOException unused) {
                    }
                    NativeImpl.t(file.getAbsolutePath());
                }
                File file2 = new File(N9.j.p(com.apm.insight.g.f2160a), "fds.txt");
                if (!file2.exists()) {
                    file2.getParentFile().mkdirs();
                    try {
                        file2.createNewFile();
                    } catch (IOException unused2) {
                    }
                    NativeImpl.r(file2.getAbsolutePath());
                }
                File file3 = new File(N9.j.p(com.apm.insight.g.f2160a), "meminfo.txt");
                if (!file3.exists()) {
                    file3.getParentFile().mkdirs();
                    try {
                        file3.createNewFile();
                    } catch (IOException unused3) {
                    }
                    NativeImpl.p(file3.getAbsolutePath());
                }
                File file4 = new File(N9.j.p(com.apm.insight.g.f2160a), "threads.txt");
                if (file4.exists()) {
                    return;
                }
                file4.getParentFile().mkdirs();
                try {
                    file4.createNewFile();
                } catch (IOException unused4) {
                }
                NativeImpl.u(file4.getAbsolutePath());
            }
        } catch (Throwable unused5) {
        }
    }

    public static final CharSequence b0(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == 8220 || cCharAt == 8221) {
                SpannableString spannableString = new SpannableString(str);
                Object[] spans = spannableString.getSpans(0, spannableString.length(), J4.g.class);
                kotlin.jvm.internal.k.e(spans, "getSpans(...)");
                for (Object obj : spans) {
                    spannableString.removeSpan((J4.g) obj);
                }
                int length = spannableString.length();
                for (int i6 = 0; i6 < length; i6++) {
                    if (spannableString.charAt(i6) == 8220 || spannableString.charAt(i6) == 8221) {
                        spannableString.setSpan(new J4.g(), i6, i6 + 1, 33);
                    }
                }
                return spannableString;
            }
        }
        return str;
    }

    public static void c(Parcel parcel, Parcelable parcelable, int i) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, i);
        }
    }

    public static void d(File file, CrashType crashType, String str) {
        try {
            if (z2.b.i()) {
                File file2 = crashType == CrashType.ANR ? null : new File(file, "external_files");
                if (file2 == null || !file2.exists()) {
                    file.mkdirs();
                    ArrayList arrayList = new ArrayList();
                    CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) z2.k.f.f;
                    Iterator it = copyOnWriteArrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        File[] fileArrCrashFileList = ((CrashInfoCallback) it.next()).crashFileList(crashType);
                        if (fileArrCrashFileList != null) {
                            long j5 = 0;
                            for (File file3 : fileArrCrashFileList) {
                                if (file3.exists() && !file3.isDirectory()) {
                                    if (crashType == CrashType.ANR) {
                                        long length = file3.length();
                                        if (length <= 1048576) {
                                            long j6 = length + j5;
                                            if (j6 <= 20971520) {
                                                arrayList.add(file3);
                                                j5 = j6;
                                            }
                                        }
                                    } else {
                                        M.a.t(file3.getAbsolutePath() + "\n", file2, true);
                                    }
                                }
                            }
                        }
                    }
                    if (crashType != CrashType.ANR || arrayList.isEmpty()) {
                        return;
                    }
                    AbstractC2095a.k(com.apm.insight.g.g.getFileUploadUrl(), str, (File[]) arrayList.toArray(new File[0]));
                    Iterator it2 = copyOnWriteArrayList.iterator();
                    while (it2.hasNext()) {
                        CrashInfoCallback crashInfoCallback = (CrashInfoCallback) it2.next();
                        if (crashInfoCallback != null) {
                            crashInfoCallback.onFileUpload(arrayList);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void e(File file, String str) {
        if (z2.b.i()) {
            File file2 = new File(file, "external_files");
            if (file2.exists()) {
                try {
                    JSONArray jSONArrayC = M.a.C(file2.getAbsolutePath());
                    if (jSONArrayC == null) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    long j5 = 0;
                    for (int i = 0; i < jSONArrayC.length(); i++) {
                        String strOptString = jSONArrayC.optString(i);
                        if (!TextUtils.isEmpty(strOptString)) {
                            File file3 = new File(strOptString);
                            if (file3.exists()) {
                                long length = file3.length() + j5;
                                if (length <= 20971520) {
                                    arrayList.add(file3);
                                    j5 = length;
                                }
                            }
                        }
                    }
                    AbstractC2095a.k(com.apm.insight.g.g.getFileUploadUrl(), str, (File[]) arrayList.toArray(new File[0]));
                    Iterator it = ((CopyOnWriteArrayList) z2.k.f.f).iterator();
                    while (it.hasNext()) {
                        CrashInfoCallback crashInfoCallback = (CrashInfoCallback) it.next();
                        if (crashInfoCallback != null) {
                            crashInfoCallback.onFileUpload(arrayList);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void f(String str, String str2) {
        if (AbstractC1451a.f4467a) {
            Log.d(str, str2);
        }
    }

    public static void g(String str, String str2, Throwable th) {
        b.r(str, str2, th);
    }

    public static boolean h() {
        z2.h hVarA = z2.h.a();
        return hVarA.f6930a != -1 && SystemClock.uptimeMillis() - hVarA.f6930a > 5000;
    }

    public static void i(Object obj, StringBuilder sb) {
        if (obj == null) {
            sb.append("null");
            return;
        }
        if ((obj instanceof Number) || (obj instanceof Boolean)) {
            sb.append(obj.toString());
            return;
        }
        boolean z10 = true;
        if (!(obj instanceof Map)) {
            if (!(obj instanceof List)) {
                j(sb, obj.toString());
                return;
            }
            sb.append('[');
            for (Object obj2 : (List) obj) {
                if (!z10) {
                    sb.append(',');
                }
                i(obj2, sb);
                z10 = false;
            }
            sb.append(']');
            return;
        }
        sb.append('{');
        for (Map.Entry entry : ((Map) obj).entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                if (!z10) {
                    sb.append(',');
                }
                j(sb, String.valueOf(key));
                sb.append(':');
                i(value, sb);
                z10 = false;
            }
        }
        sb.append('}');
    }

    public static void j(StringBuilder sb, String str) {
        sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\t') {
                sb.append("\\t");
            } else if (cCharAt == '\n') {
                sb.append("\\n");
            } else if (cCharAt == '\r') {
                sb.append("\\r");
            } else if (cCharAt == '\"') {
                sb.append("\\\"");
            } else if (cCharAt == '\\') {
                sb.append("\\\\");
            } else if (kotlin.jvm.internal.k.g(cCharAt, 32) < 0) {
                sb.append(String.format("\\u%04x", Arrays.copyOf(new Object[]{Integer.valueOf(cCharAt)}, 1)));
            } else {
                sb.append(cCharAt);
            }
        }
        sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
    }

    public static ArrayList k(Object... objArr) {
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new D7.o(objArr, true));
    }

    public static final boolean l(byte[] a3, int i, int i6, byte[] b5, int i10) {
        kotlin.jvm.internal.k.f(a3, "a");
        kotlin.jvm.internal.k.f(b5, "b");
        for (int i11 = 0; i11 < i10; i11++) {
            if (a3[i11 + i] != b5[i11 + i6]) {
                return false;
            }
        }
        return true;
    }

    public static void m(Field field, String str, int i, char c) {
        if (i >= str.length()) {
            throw new DateTimeParseException(B7.a.n("Unexpected end of input, missing field ", field.name(), ": ", str), str, i);
        }
        if (str.charAt(i) != c) {
            throw new DateTimeParseException(String.format("Expected character %s at position %d, found %s: %s", Character.valueOf(c), Integer.valueOf(i + 1), Character.valueOf(str.charAt(i)), str), str, i);
        }
    }

    public static void n(String str, String str2) {
        b.j(str, str2);
    }

    public static int o(List list, int i, S7.k kVar) {
        kotlin.jvm.internal.k.f(list, "<this>");
        U(list.size(), i);
        int i6 = i - 1;
        int i10 = 0;
        while (i10 <= i6) {
            int i11 = (i10 + i6) >>> 1;
            int iIntValue = ((Number) kVar.invoke(list.get(i11))).intValue();
            if (iIntValue < 0) {
                i10 = i11 + 1;
            } else {
                if (iIntValue <= 0) {
                    return i11;
                }
                i6 = i11 - 1;
            }
        }
        return -(i10 + 1);
    }

    public static int p(List list, Comparable comparable) {
        int size = list.size();
        kotlin.jvm.internal.k.f(list, "<this>");
        U(list.size(), size);
        int i = size - 1;
        int i6 = 0;
        while (i6 <= i) {
            int i10 = (i6 + i) >>> 1;
            int iM = N9.j.m((Comparable) list.get(i10), comparable);
            if (iM < 0) {
                i6 = i10 + 1;
            } else {
                if (iM <= 0) {
                    return i10;
                }
                i = i10 - 1;
            }
        }
        return -(i6 + 1);
    }

    public static ListBuilder q(List builder) {
        kotlin.jvm.internal.k.f(builder, "builder");
        ListBuilder listBuilder = (ListBuilder) builder;
        listBuilder.g();
        listBuilder.c = true;
        return listBuilder.b > 0 ? listBuilder : ListBuilder.d;
    }

    public static void r(String str, String str2) {
        if (AbstractC1451a.f4467a) {
            Log.i(str, str2);
        }
    }

    public static final boolean s(View view) {
        kotlin.jvm.internal.k.f(view, "view");
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int childCount = viewGroup.getChildCount() - 1; -1 < childCount; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            kotlin.jvm.internal.k.e(childAt, "getChildAt(...)");
            if (s(childAt)) {
                return true;
            }
        }
        return false;
    }

    public static final void t(long j5, long j6, long j10) {
        if ((j6 | j10) < 0 || j6 > j5 || j5 - j6 < j10) {
            throw new ArrayIndexOutOfBoundsException("size=" + j5 + " offset=" + j6 + " byteCount=" + j10);
        }
    }

    public static final Object u(Object obj, InterfaceC1520c interfaceC1520c) {
        w wVarE;
        Class clsY;
        Method methodG;
        return (((interfaceC1520c instanceof InterfaceC1501I) && J8.g.e((InterfaceC1510S) interfaceC1520c)) || (wVarE = E(interfaceC1520c)) == null || (clsY = Y(wVarE)) == null || (methodG = G(clsY, interfaceC1520c)) == null) ? obj : methodG.invoke(obj, null);
    }

    public static final double v(double d, DurationUnit durationUnit, DurationUnit targetUnit) {
        kotlin.jvm.internal.k.f(targetUnit, "targetUnit");
        long jConvert = targetUnit.f5171a.convert(1L, durationUnit.f5171a);
        return jConvert > 0 ? d * jConvert : d / r8.convert(1L, r9);
    }

    public static final long w(long j5, DurationUnit sourceUnit, DurationUnit targetUnit) {
        kotlin.jvm.internal.k.f(sourceUnit, "sourceUnit");
        kotlin.jvm.internal.k.f(targetUnit, "targetUnit");
        return targetUnit.f5171a.convert(j5, sourceUnit.f5171a);
    }

    public static Q8.o x(String message, Collection types) {
        kotlin.jvm.internal.k.f(message, "message");
        kotlin.jvm.internal.k.f(types, "types");
        Collection collection = types;
        ArrayList arrayList = new ArrayList(D7.w.c0(collection, 10));
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(((w) it.next()).w());
        }
        g9.f fVarA = AbstractC0291a.A(arrayList);
        int i = fVarA.f4504a;
        Q8.o aVar = i != 0 ? i != 1 ? new Q8.a(message, (Q8.o[]) fVarA.toArray(new Q8.o[0])) : (Q8.o) fVarA.get(0) : Q8.n.b;
        return fVarA.f4504a <= 1 ? aVar : new Q8.k(aVar);
    }

    public static ListBuilder y() {
        return new ListBuilder(10);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final c8.e z(c8.e r3, h8.InterfaceC1520c r4, boolean r5) {
        /*
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.k.f(r4, r0)
            boolean r0 = J8.g.a(r4)
            if (r0 != 0) goto L96
            java.util.List r0 = r4.p0()
            java.lang.String r1 = "getContextReceiverParameters(...)"
            kotlin.jvm.internal.k.e(r0, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            if (r1 == 0) goto L24
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L24
            goto L3f
        L24:
            java.util.Iterator r0 = r0.iterator()
        L28:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L3f
            java.lang.Object r1 = r0.next()
            k8.u r1 = (k8.u) r1
            X8.w r1 = r1.getType()
            boolean r1 = J8.g.g(r1)
            if (r1 == 0) goto L28
            goto L96
        L3f:
            java.util.List r0 = r4.x()
            java.lang.String r1 = "getValueParameters(...)"
            kotlin.jvm.internal.k.e(r0, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            if (r1 == 0) goto L58
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L58
            goto L7a
        L58:
            java.util.Iterator r0 = r0.iterator()
        L5c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L7a
            java.lang.Object r1 = r0.next()
            k8.Q r1 = (k8.Q) r1
            k8.S r1 = (k8.S) r1
            X8.w r1 = r1.getType()
            java.lang.String r2 = "getType(...)"
            kotlin.jvm.internal.k.e(r1, r2)
            boolean r1 = J8.g.g(r1)
            if (r1 == 0) goto L5c
            goto L96
        L7a:
            X8.w r0 = r4.getReturnType()
            r1 = 1
            if (r0 == 0) goto L88
            boolean r0 = J8.g.c(r0)
            if (r0 != r1) goto L88
            goto L96
        L88:
            X8.w r0 = E(r4)
            if (r0 == 0) goto L95
            boolean r0 = J8.g.g(r0)
            if (r0 != r1) goto L95
            goto L96
        L95:
            return r3
        L96:
            c8.B r0 = new c8.B
            r0.<init>(r3, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: H4.o.z(c8.e, h8.c, boolean):c8.e");
    }

    public int hashCode() {
        switch (this.f747a) {
            case 22:
                return toString().hashCode();
            default:
                return super.hashCode();
        }
    }

    public String toString() {
        switch (this.f747a) {
            case 22:
                String strM = kotlin.jvm.internal.m.f4928a.b(getClass()).m();
                kotlin.jvm.internal.k.c(strM);
                return strM;
            default:
                return super.toString();
        }
    }
}
