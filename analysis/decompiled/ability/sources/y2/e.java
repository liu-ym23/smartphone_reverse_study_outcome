package y2;

import android.text.TextUtils;
import com.apm.insight.nativecrash.NativeImpl;
import e3.C1417f;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final StackTraceElement f6892a = new StackTraceElement("", "", "", 0);

    /* JADX WARN: Removed duplicated region for block: B:26:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(java.lang.String r8) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            java.io.File r0 = new java.io.File
            r0.<init>(r8)
            boolean r8 = r0.exists()
            if (r8 != 0) goto L14
            return r1
        L14:
            java.util.LinkedList r8 = new java.util.LinkedList
            r8.<init>()
            java.util.LinkedList r2 = new java.util.LinkedList
            r2.<init>()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = 10
            r5 = 0
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L5c
            java.io.FileReader r7 = new java.io.FileReader     // Catch: java.lang.Throwable -> L5c
            r7.<init>(r0)     // Catch: java.lang.Throwable -> L5c
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L5c
            r0 = r5
        L31:
            java.lang.String r1 = r6.readLine()     // Catch: java.lang.Throwable -> L45
            if (r1 == 0) goto L58
            r7 = 256(0x100, float:3.59E-43)
            if (r0 > r7) goto L47
            r8.add(r1)     // Catch: java.lang.Throwable -> L45
            r3.append(r1)     // Catch: java.lang.Throwable -> L45
            r3.append(r4)     // Catch: java.lang.Throwable -> L45
            goto L55
        L45:
            r1 = r6
            goto L5c
        L47:
            r2.add(r1)     // Catch: java.lang.Throwable -> L45
            int r1 = r2.size()     // Catch: java.lang.Throwable -> L45
            if (r1 <= r7) goto L55
            r2.poll()     // Catch: java.lang.Throwable -> L45
            int r5 = r5 + 1
        L55:
            int r0 = r0 + 1
            goto L31
        L58:
            M0.i.i(r6)
            goto L5f
        L5c:
            M0.i.i(r1)
        L5f:
            boolean r8 = r2.isEmpty()
            if (r8 != 0) goto L8b
            if (r5 == 0) goto L74
            java.lang.String r8 = "\t... skip "
            r3.append(r8)
            r3.append(r5)
            java.lang.String r8 = " lines\n"
            r3.append(r8)
        L74:
            java.util.Iterator r8 = r2.iterator()
        L78:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L8b
            java.lang.Object r0 = r8.next()
            java.lang.String r0 = (java.lang.String) r0
            r3.append(r0)
            r3.append(r4)
            goto L78
        L8b:
            java.lang.String r8 = r3.toString()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.e.a(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Unreachable blocks removed: 3, instructions: 3 */
    public static String b(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            h(th, printWriter);
            String string = stringWriter.toString();
            printWriter.close();
            return string;
        } catch (Throwable unused) {
            printWriter.close();
            return "";
        }
    }

    public static String c(Throwable th, PrintStream printStream, C1417f c1417f) throws IOException {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (Throwable unused) {
            messageDigest = null;
        }
        C2129b c2129b = new C2129b(printStream);
        c2129b.b = null;
        c2129b.f6889a = messageDigest;
        c2129b.c = c1417f;
        if (messageDigest != null) {
            c2129b.b = Charset.defaultCharset();
        }
        try {
            h(th, c2129b);
        } catch (Throwable unused2) {
        }
        c2129b.close();
        if (messageDigest == null) {
            return null;
        }
        byte[] bArrDigest = messageDigest.digest();
        if (bArrDigest == null || bArrDigest.length <= 0) {
            return "";
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArrDigest.length * 2];
        int i = 0;
        for (byte b : bArrDigest) {
            int i6 = i + 1;
            cArr2[i] = cArr[(b >>> 4) & 15];
            i += 2;
            cArr2[i6] = cArr[b & 15];
        }
        return new String(cArr2);
    }

    public static String d(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            g(stackTraceElement, sb);
        }
        return sb.toString();
    }

    public static void e(int i, String str, String str2, Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        try {
            NativeImpl.c(i, str2);
            NativeImpl.c(i, str);
        } catch (Throwable unused) {
        }
        n(i, th);
        for (StackTraceElement stackTraceElement : stackTrace) {
            f(stackTraceElement, i);
        }
        for (Throwable th2 : th.getSuppressed()) {
            e(i, "Suppressed: ", str2 + "\t", th2);
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            e(i, "Caused by: ", str2, cause);
        }
    }

    public static void f(StackTraceElement stackTraceElement, int i) {
        String str;
        String strValueOf;
        try {
            NativeImpl.c(i, "\tat ");
            NativeImpl.c(i, stackTraceElement.getClassName());
            NativeImpl.c(i, ".");
            NativeImpl.c(i, stackTraceElement.getMethodName());
            if (!stackTraceElement.isNativeMethod()) {
                if (stackTraceElement.getFileName() != null) {
                    if (stackTraceElement.getLineNumber() >= 0) {
                        NativeImpl.c(i, "(");
                        NativeImpl.c(i, stackTraceElement.getFileName());
                        NativeImpl.c(i, ":");
                        strValueOf = String.valueOf(stackTraceElement.getLineNumber());
                    } else {
                        NativeImpl.c(i, "(");
                        strValueOf = stackTraceElement.getFileName();
                    }
                } else if (stackTraceElement.getLineNumber() >= 0) {
                    NativeImpl.c(i, "(Unknown Source:");
                    strValueOf = String.valueOf(stackTraceElement.getLineNumber());
                } else {
                    str = "(Unknown Source)";
                }
                NativeImpl.c(i, strValueOf);
                NativeImpl.c(i, ")");
                NativeImpl.c(i, "\n");
            }
            str = "(Native Method)";
            NativeImpl.c(i, str);
            NativeImpl.c(i, "\n");
        } catch (Throwable unused) {
        }
    }

    public static void g(StackTraceElement stackTraceElement, StringBuilder sb) {
        String className = stackTraceElement.getClassName();
        sb.append("  at ");
        sb.append(className);
        sb.append(".");
        sb.append(stackTraceElement.getMethodName());
        sb.append("(");
        sb.append(stackTraceElement.getFileName());
        sb.append(":");
        sb.append(stackTraceElement.getLineNumber());
        sb.append(")\n");
    }

    public static void h(Throwable th, PrintWriter printWriter) {
        if (th != null) {
            Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
            setNewSetFromMap.add(th);
            printWriter.println(th);
            StackTraceElement[] stackTrace = th.getStackTrace();
            boolean z10 = stackTrace.length > 384;
            int length = stackTrace.length;
            int i = 0;
            int i6 = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i];
                if (z10 && i6 > 256) {
                    StringBuilder sb = new StringBuilder("\t... skip ");
                    sb.append((stackTrace.length - i6) - 128);
                    sb.append(" lines");
                    printWriter.println(sb.toString());
                    break;
                }
                printWriter.println("\tat " + stackTraceElement);
                i6++;
                i++;
            }
            if (z10) {
                for (int length2 = stackTrace.length - 128; length2 < stackTrace.length; length2++) {
                    printWriter.println("\tat " + stackTrace[length2]);
                }
            }
            for (Throwable th2 : th.getSuppressed()) {
                i(th2, printWriter, "Suppressed: ", "\t", setNewSetFromMap, 128);
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                i(cause, printWriter, "Caused by: ", "", setNewSetFromMap, 128);
            }
        }
    }

    public static void i(Throwable th, PrintWriter printWriter, String str, String str2, Set set, int i) {
        if (set.contains(th)) {
            printWriter.println("\t[CIRCULAR REFERENCE:" + th + "]");
            return;
        }
        set.add(th);
        StackTraceElement[] stackTrace = th.getStackTrace();
        boolean z10 = stackTrace.length > i;
        printWriter.println(str2 + str + th);
        int length = stackTrace.length;
        int i6 = 0;
        int i10 = 0;
        while (true) {
            if (i6 >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i6];
            if (z10 && i10 > i) {
                printWriter.println("\t... skip " + ((stackTrace.length - i10) - (i / 2)) + " lines");
                break;
            }
            printWriter.println("\tat " + stackTraceElement);
            i10++;
            i6++;
        }
        if (z10) {
            for (int length2 = stackTrace.length - (i / 2); length2 < stackTrace.length; length2++) {
                printWriter.println("\tat " + stackTrace[length2]);
            }
        }
        Throwable[] suppressed = th.getSuppressed();
        int length3 = suppressed.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length3) {
                break;
            }
            int i12 = i / 2;
            i(suppressed[i11], printWriter, "Suppressed: ", androidx.appfunctions.metadata.a.l(str2, "\t"), set, i12 > 10 ? i12 : 10);
            i11++;
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            int i13 = i / 2;
            i(cause, printWriter, "Caused by: ", str2, set, i13 > 10 ? i13 : 10);
        }
    }

    public static void j(Throwable th, ArrayList arrayList) {
        if (th != null) {
            Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
            setNewSetFromMap.add(th);
            StackTraceElement stackTraceElement = f6892a;
            arrayList.add(stackTraceElement);
            StackTraceElement[] stackTrace = th.getStackTrace();
            boolean z10 = stackTrace.length > 384;
            int length = stackTrace.length;
            int i = 0;
            int i6 = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                StackTraceElement stackTraceElement2 = stackTrace[i];
                if (z10 && i6 > 256) {
                    arrayList.add(stackTraceElement);
                    break;
                } else {
                    arrayList.add(stackTraceElement2);
                    i6++;
                    i++;
                }
            }
            if (z10) {
                for (int length2 = stackTrace.length - 128; length2 < stackTrace.length; length2++) {
                    arrayList.add(stackTrace[length2]);
                }
            }
            for (Throwable th2 : th.getSuppressed()) {
                k(th2, arrayList, "\t", setNewSetFromMap, 128);
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                k(cause, arrayList, "", setNewSetFromMap, 128);
            }
        }
    }

    public static void k(Throwable th, ArrayList arrayList, String str, Set set, int i) {
        boolean zContains = set.contains(th);
        StackTraceElement stackTraceElement = f6892a;
        if (zContains) {
            arrayList.add(stackTraceElement);
            return;
        }
        set.add(th);
        StackTraceElement[] stackTrace = th.getStackTrace();
        int i6 = 0;
        boolean z10 = stackTrace.length > i;
        arrayList.add(stackTraceElement);
        int length = stackTrace.length;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            StackTraceElement stackTraceElement2 = stackTrace[i10];
            if (z10 && i11 > i) {
                arrayList.add(stackTraceElement);
                break;
            } else {
                arrayList.add(stackTraceElement2);
                i11++;
                i10++;
            }
        }
        if (z10) {
            for (int length2 = stackTrace.length - (i / 2); length2 < stackTrace.length; length2++) {
                arrayList.add(stackTrace[length2]);
            }
        }
        Throwable[] suppressed = th.getSuppressed();
        int length3 = suppressed.length;
        while (true) {
            if (i6 >= length3) {
                break;
            }
            Throwable th2 = suppressed[i6];
            String strL = androidx.appfunctions.metadata.a.l(str, "\t");
            int i12 = i / 2;
            if (i12 > 10) {
                i = i12;
            }
            k(th2, arrayList, strL, set, i);
            i6++;
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            int i13 = i / 2;
            k(cause, arrayList, str, set, i13 > 10 ? i13 : 10);
        }
    }

    public static boolean l(String str, String[] strArr) {
        if (strArr != null && !TextUtils.isEmpty(str)) {
            for (String str2 : strArr) {
                if (str.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static JSONObject m(String str) {
        try {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            JSONObject jSONObject = new JSONObject();
            if (allStackTraces == null) {
                return null;
            }
            jSONObject.put("thread_all_count", allStackTraces.size());
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                JSONObject jSONObject2 = new JSONObject();
                Thread key = entry.getKey();
                String name = key.getName();
                HashSet hashSet = c.f6890a;
                if (!hashSet.contains(name)) {
                    Iterator it = hashSet.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            String str2 = (String) it.next();
                            if (TextUtils.isEmpty(name) || !name.startsWith(str2)) {
                            }
                        } else if (str == null || (!str.equals(name) && !name.startsWith(str) && !name.endsWith(str))) {
                            jSONObject2.put("thread_name", key.getName() + "(" + key.getId() + ")");
                            StackTraceElement[] value = entry.getValue();
                            if (value != null) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (StackTraceElement stackTraceElement : value) {
                                    jSONArray2.put(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "(" + stackTraceElement.getLineNumber() + ")");
                                }
                                jSONObject2.put("thread_stack", jSONArray2);
                                if (jSONArray2.length() > 0) {
                                }
                            }
                            jSONArray.put(jSONObject2);
                        }
                    }
                }
            }
            jSONObject.put("thread_stacks", jSONArray);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void n(int i, Throwable th) {
        th.getClass();
        String localizedMessage = th.getLocalizedMessage();
        try {
            NativeImpl.c(i, th.getClass().getName());
            if (localizedMessage != null) {
                NativeImpl.c(i, ": ");
                NativeImpl.c(i, localizedMessage);
            }
            NativeImpl.c(i, "\n");
        } catch (Throwable unused) {
        }
    }

    public static void o(int i, Throwable th) {
        if (th == null || i <= 0) {
            return;
        }
        n(i, th);
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            f(stackTraceElement, i);
        }
        for (Throwable th2 : th.getSuppressed()) {
            e(i, "Suppressed: ", "\t", th2);
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            e(i, "Caused by: ", "", cause);
        }
    }

    public static boolean p(Throwable th) {
        if (th == null) {
            return false;
        }
        int i = 0;
        while (th != null) {
            try {
                if (th instanceof OutOfMemoryError) {
                    return true;
                }
                if (i > 20) {
                    return false;
                }
                i++;
                th = th.getCause();
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
