package com.apm.lite.k;

import android.text.TextUtils;
import com.apm.lite.nativecrash.NativeImpl;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StackTraceElement f30016a = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f30018b;

        public a() {
            this.f30017a = -1;
            this.f30018b = -1;
        }

        public final JSONObject a() {
            JSONObject r100 = new JSONObject();
            r100.put("start", this.f30017a);     // Catch: Throwable -> L5
            r100.put("end", this.f30018b);     // Catch: Throwable -> L5
        L4:
            return r100;
        }
    }

    static {
        f30016a = new StackTraceElement("", "", "", 0);
    }

    public static String a(String r100) {
        BufferedReader r101 = null;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == true) goto L8;
        return null;
    L8:
        LinkedList r103 = new LinkedList();
        LinkedList r104 = new LinkedList();
        StringBuilder r105 = new StringBuilder();
        int r106 = 0;
        BufferedReader r107 = new BufferedReader(new PolarisFileReaderWrapper(r102));     // Catch: Throwable -> L34
        int r108 = 0;
    L35:
        String r109 = r107.readLine();     // Catch: Throwable -> L22
        if (r109 == null) goto L21;
        if (r108 > 256) goto L16;
        r103.add(r109);     // Catch: Throwable -> L22
        r105.append(r109);     // Catch: Throwable -> L22
        r105.append('\n');     // Catch: Throwable -> L22
    L20:
        r108 = r108 + 1;
        goto L35
    L16:
        r104.add(r109);     // Catch: Throwable -> L22
        if (r104.size() <= 256) goto L20;
        r104.poll();     // Catch: Throwable -> L22
        r106 = r106 + 1;
        goto L20
    L21:
        j.a(r107);
    L25:
        if (r104.isEmpty() == true) goto L33;
        if (r106 == 0) goto L28;
        r105.append("\t... skip ");
        r105.append(r106);
        r105.append(" lines\n");
    L28:
        Iterator r110 = r104.iterator();
    L30:
        if (r110.hasNext() == false) goto L33;
        r105.append((String) r110.next());
        r105.append('\n');
    L33:
        return r105.toString();
    L22:
        r101 = r107;
    L23:
        j.a(r101);
        goto L25
    }

    /* JADX WARN: Unreachable blocks removed: 3, instructions: 3 */
    public static String b(Throwable r100) {
        StringWriter r101 = new StringWriter();
        PrintWriter r102 = new PrintWriter(r101);
        g(r100, r102);     // Catch: Throwable -> L6
        String r103 = r101.toString();     // Catch: Throwable -> L6
        r102.close();
        return r103;
    L7:
        r102.close();
        return "";
    }

    public static void f(Throwable r100, int r101, String r102, String r103) {
        StackTraceElement[] r104 = r100.getStackTrace();
        NativeImpl.writeFile(r101, r103);     // Catch: Throwable -> L14
        NativeImpl.writeFile(r101, r102);     // Catch: Throwable -> L14
    L4:
        m(r100, r101);
        int r105 = r104.length;
        int r106 = 0;
        int r107 = 0;
    L5:
        if (r107 >= r105) goto L7;
        e(r104[r107], r101);
        r107 = r107 + 1;
        goto L5
    L7:
        Throwable[] r108 = r100.getSuppressed();
        int r109 = r108.length;
    L8:
        if (r106 >= r109) goto L10;
        f(r108[r106], r101, "Suppressed: ", r103 + "\t");
        r106 = r106 + 1;
        goto L8
    L10:
        Throwable r110 = r100.getCause();
        if (r110 == null) goto L19;
        f(r110, r101, "Caused by: ", r103);
        return;
    }

    public static void g(Throwable r110, PrintWriter r111) {
        if (r110 == null) goto L34;
        Set r100 = Collections.newSetFromMap(new IdentityHashMap());
        r100.add(r110);
        r111.println(r110);
        StackTraceElement[] r101 = r110.getStackTrace();
        if (r101.length <= 384) goto L6;
        boolean r102 = true;
    L7:
        int r103 = r101.length;
        int r104 = 0;
        int r105 = 0;
    L9:
        if (r104 >= r103) goto L16;
        StackTraceElement r106 = r101[r104];
        if (r102 == false) goto L15;
        if (r105 <= 256) goto L15;
        r111.println("\t... skip " + ((r101.length - r105) + com.alipay.sdk.m.n.a.f25611g) + " lines");
    L15:
        r111.println("\tat " + r106);
        r105 = r105 + 1;
        r104 = r104 + 1;
    L16:
        if (r102 == false) goto L21;
        int r107 = r101.length + com.alipay.sdk.m.n.a.f25611g;
    L19:
        if (r107 >= r101.length) goto L21;
        r111.println("\tat " + r101[r107]);
        r107 = r107 + 1;
    L21:
        Throwable[] r108 = r110.getSuppressed();
        int r109 = r108.length;
        int r112 = 0;
    L22:
        if (r112 >= r109) goto L24;
        h(r108[r112], r111, "Suppressed: ", "\t", r100, 128);
        r112 = r112 + 1;
        goto L22
    L24:
        Throwable r113 = r110.getCause();
        if (r113 == null) goto L35;
        h(r113, r111, "Caused by: ", "", r100, 128);
        return;
    L35:
        return;
    L6:
        r102 = false;
        goto L7
    }

    public static void h(Throwable r100, PrintWriter r110, String r111, String r112, Set r113, int r114) {
        if (r113.contains(r100) == false) goto L5;
        r110.println("\t[CIRCULAR REFERENCE:" + r100 + "]");
        return;
    L5:
        r113.add(r100);
        StackTraceElement[] r101 = r100.getStackTrace();
        int r102 = 0;
        if (r101.length <= r114) goto L8;
        boolean r103 = true;
    L9:
        r110.println(r112 + r111 + r100);
        int r115 = r101.length;
        int r104 = 0;
        int r105 = 0;
    L11:
        if (r104 >= r115) goto L17;
        StackTraceElement r106 = r101[r104];
        if (r103 == false) goto L16;
        if (r105 <= r114) goto L16;
        r110.println("\t... skip " + ((r101.length - r105) - (r114 / 2)) + " lines");
    L16:
        r110.println("\tat " + r106);
        r105 = r105 + 1;
        r104 = r104 + 1;
    L17:
        if (r103 == false) goto L22;
        int r116 = r101.length - (r114 / 2);
    L20:
        if (r116 >= r101.length) goto L22;
        r110.println("\tat " + r101[r116]);
        r116 = r116 + 1;
    L22:
        Throwable[] r117 = r100.getSuppressed();
        int r107 = r117.length;
    L24:
        if (r102 >= r107) goto L30;
        Throwable r108 = r117[r102];
        String r109 = r112 + "\t";
        int r118 = r114 / 2;
        if (r118 <= 10) goto L28;
        int r119 = r118;
    L29:
        h(r108, r110, "Suppressed: ", r109, r113, r119);
        r102 = r102 + 1;
        goto L24
    L28:
        r119 = 10;
        goto L29
    L30:
        Throwable r120 = r100.getCause();
        if (r120 == null) goto L47;
        int r121 = r114 / 2;
        if (r121 <= 10) goto L35;
        int r122 = r121;
    L36:
        h(r120, r110, "Caused by: ", r112, r113, r122);
        return;
    L35:
        r122 = 10;
        goto L36
    L47:
        return;
    L8:
        r103 = false;
        goto L9
    }

    public static void i(Throwable r110, List<StackTraceElement> r111) {
        if (r110 == null) goto L34;
        Set r100 = Collections.newSetFromMap(new IdentityHashMap());
        r100.add(r110);
        ArrayList r101 = (ArrayList) r111;
        r101.add(f30016a);
        StackTraceElement[] r102 = r110.getStackTrace();
        int r103 = 0;
        if (r102.length <= 384) goto L6;
        boolean r104 = true;
    L7:
        int r105 = r102.length;
        int r106 = 0;
        int r107 = 0;
    L8:
        if (r106 >= r105) goto L15;
        StackTraceElement r108 = r102[r106];
        if (r104 == false) goto L14;
        if (r107 <= 256) goto L14;
        r101.add(f30016a);
    L14:
        r101.add(r108);
        r107 = r107 + 1;
        r106 = r106 + 1;
    L15:
        if (r104 == false) goto L20;
        int r109 = r102.length + com.alipay.sdk.m.n.a.f25611g;
    L18:
        if (r109 >= r102.length) goto L20;
        r101.add(r102[r109]);
        r109 = r109 + 1;
    L20:
        Throwable[] r112 = r110.getSuppressed();
        int r113 = r112.length;
    L22:
        if (r103 >= r113) goto L24;
        j(r112[r103], r111, "\t", r100, 128);
        r103 = r103 + 1;
        goto L22
    L24:
        Throwable r114 = r110.getCause();
        if (r114 == null) goto L35;
        j(r114, r111, "", r100, 128);
        return;
    L35:
        return;
    L6:
        r104 = false;
        goto L7
    }

    public static void j(Throwable r100, List r101, String r110, Set r111, int r112) {
        if (r111.contains(r100) == false) goto L5;
        ((ArrayList) r101).add(f30016a);
        return;
    L5:
        r111.add(r100);
        StackTraceElement[] r102 = r100.getStackTrace();
        int r103 = 0;
        if (r102.length <= r112) goto L8;
        boolean r104 = true;
    L9:
        ArrayList r105 = (ArrayList) r101;
        r105.add(f30016a);
        int r106 = r102.length;
        int r107 = 0;
        int r108 = 0;
    L10:
        if (r107 >= r106) goto L16;
        StackTraceElement r109 = r102[r107];
        if (r104 == false) goto L15;
        if (r108 <= r112) goto L15;
        r105.add(f30016a);
    L15:
        r105.add(r109);
        r108 = r108 + 1;
        r107 = r107 + 1;
    L16:
        if (r104 == false) goto L21;
        int r113 = r102.length - (r112 / 2);
    L19:
        if (r113 >= r102.length) goto L21;
        r105.add(r102[r113]);
        r113 = r113 + 1;
    L21:
        Throwable[] r114 = r100.getSuppressed();
        int r115 = r114.length;
    L22:
        int r116 = 10;
        if (r103 >= r115) goto L28;
        Throwable r117 = r114[r103];
        String r118 = r110 + "\t";
        int r119 = r112 / 2;
        if (r119 <= 10) goto L27;
        r116 = r119;
    L27:
        j(r117, r101, r118, r111, r116);
        r103 = r103 + 1;
        goto L22
    L28:
        Throwable r120 = r100.getCause();
        if (r120 == null) goto L44;
        int r121 = r112 / 2;
        if (r121 <= 10) goto L33;
        r116 = r121;
    L33:
        j(r120, r101, r110, r111, r116);
        return;
    L44:
        return;
    L8:
        r104 = false;
        goto L9
    }

    public static boolean k(String r100, String[] r101) {
        if (r101 != null) goto L5;
    L14:
        return false;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L14;
        int r102 = r101.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L14;
        if (r100.contains(r101[r103]) == true) goto L11;
        r103 = r103 + 1;
        goto L8
    L11:
        return true;
    }

    public static void n(Throwable r100, int r101) {
        if (r100 == null) goto L17;
        if (r101 <= 0) goto L19;
        m(r100, r101);
        StackTraceElement[] r102 = r100.getStackTrace();
        int r103 = r102.length;
        int r104 = 0;
        int r105 = 0;
    L6:
        if (r105 >= r103) goto L8;
        e(r102[r105], r101);
        r105 = r105 + 1;
        goto L6
    L8:
        Throwable[] r106 = r100.getSuppressed();
        int r107 = r106.length;
    L9:
        if (r104 >= r107) goto L11;
        f(r106[r104], r101, "Suppressed: ", "\t");
        r104 = r104 + 1;
        goto L9
    L11:
        Throwable r108 = r100.getCause();
        if (r108 == null) goto L18;
        f(r108, r101, "Caused by: ", "");
        return;
    L18:
        return;
    L19:
        return;
    }

    public static boolean o(Throwable r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = 0;
    L6:
        if (r100 == null) goto L16;
        if ((r100 instanceof OutOfMemoryError) == true) goto L9;
        if (r101 > 20) goto L13;
        r101 = r101 + 1;     // Catch: Throwable -> L17
        r100 = r100.getCause();     // Catch: Throwable -> L17
    L13:
        return false;
    L9:
        return true;
    L16:
        return false;
    }

    public static String d(StackTraceElement[] r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L6;
        StackTraceElement r104 = r100[r103];
        String r105 = r104.getClassName();
        r101.append("  at ");
        r101.append(r105);
        r101.append(".");
        r101.append(r104.getMethodName());
        r101.append("(");
        r101.append(r104.getFileName());
        r101.append(":");
        r101.append(r104.getLineNumber());
        r101.append(")\n");
        r103 = r103 + 1;
        goto L3
    L6:
        return r101.toString();
    }

    public static JSONObject l(String r110) {
        Map<Thread, StackTraceElement[]> r100 = Thread.getAllStackTraces();     // Catch: Throwable -> L45
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L45
        if (r100 != null) goto L6;
        return null;
    L6:
        r101.put("thread_all_count", r100.size());     // Catch: Throwable -> L45
        JSONArray r102 = new JSONArray();     // Catch: Throwable -> L45
        Iterator<Map.Entry<Thread, StackTraceElement[]>> r103 = r100.entrySet().iterator();     // Catch: Throwable -> L45
    L8:
        if (r103.hasNext() == false) goto L43;
        Map.Entry<Thread, StackTraceElement[]> r104 = r103.next();     // Catch: Throwable -> L45
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L45
        Thread r106 = r104.getKey();     // Catch: Throwable -> L45
        String r111 = r106.getName();     // Catch: Throwable -> L45
        HashSet r112 = (HashSet) i.f30001a;     // Catch: Throwable -> L45
        if (r112.contains(r111) == true) goto L19;
        Iterator r113 = r112.iterator();     // Catch: Throwable -> L45
    L14:
        if (r113.hasNext() == false) goto L20;
        String r114 = (String) r113.next();     // Catch: Throwable -> L45
        if (TextUtils.isEmpty(r111) == true) goto L14;
        if (r111.startsWith(r114) == false) goto L14;
    L20:
        boolean r115 = false;
    L21:
        if (r115 == true) goto L8;
        if (r110 == null) goto L30;
        if (r110.equals(r111) == true) goto L8;
        if (r111.startsWith(r110) == true) goto L8;
        if (r111.endsWith(r110) == true) goto L8;
    L30:
        r105.put("thread_name", r106.getName() + "(" + r106.getId() + ")");     // Catch: Throwable -> L45
        StackTraceElement[] r107 = r104.getValue();     // Catch: Throwable -> L45
        if (r107 == null) goto L40;
        JSONArray r108 = new JSONArray();     // Catch: Throwable -> L45
        int r116 = r107.length;     // Catch: Throwable -> L45
        int r117 = 0;
    L33:
        if (r117 >= r116) goto L35;
        StackTraceElement r118 = r107[r117];     // Catch: Throwable -> L45
        r108.put(r118.getClassName() + "." + r118.getMethodName() + "(" + r118.getLineNumber() + ")");     // Catch: Throwable -> L45
        r117 = r117 + 1;     // Catch: Throwable -> L45
        goto L33
    L35:
        r105.put("thread_stack", r108);     // Catch: Throwable -> L45
        if (r108.length() <= 0) goto L38;
        boolean r119 = true;
    L39:
        boolean r120 = r119;
    L41:
        if (r120 == false) goto L8;
        r102.put(r105);     // Catch: Throwable -> L45
        goto L8
    L38:
        r119 = false;
        goto L39
    L40:
        r120 = true;
    L19:
        r115 = true;
        goto L21
    L43:
        r101.put("thread_stacks", r102);     // Catch: Throwable -> L45
        return r101;
    L45:
        return null;
    }

    public static void e(StackTraceElement r100, int r101) {
        NativeImpl.writeFile(r101, "\tat ");     // Catch: Throwable -> L21
        NativeImpl.writeFile(r101, r100.getClassName());     // Catch: Throwable -> L21
        NativeImpl.writeFile(r101, ".");     // Catch: Throwable -> L21
        NativeImpl.writeFile(r101, r100.getMethodName());     // Catch: Throwable -> L21
        if (r100.isNativeMethod() == false) goto L8;
        String r102 = "(Native Method)";
    L5:
        NativeImpl.writeFile(r101, r102);     // Catch: Throwable -> L21
    L19:
        NativeImpl.writeFile(r101, "\n");     // Catch: Throwable -> L21
        return;
    L8:
        if (r100.getFileName() == null) goto L16;
        if (r100.getLineNumber() < 0) goto L14;
        NativeImpl.writeFile(r101, "(");     // Catch: Throwable -> L21
        NativeImpl.writeFile(r101, r100.getFileName());     // Catch: Throwable -> L21
        NativeImpl.writeFile(r101, ":");     // Catch: Throwable -> L21
        String r103 = String.valueOf(r100.getLineNumber());     // Catch: Throwable -> L21
    L13:
        NativeImpl.writeFile(r101, r103);     // Catch: Throwable -> L21
        NativeImpl.writeFile(r101, ")");     // Catch: Throwable -> L21
        goto L19
    L14:
        NativeImpl.writeFile(r101, "(");     // Catch: Throwable -> L21
        r103 = r100.getFileName();     // Catch: Throwable -> L21
        goto L13
    L16:
        if (r100.getLineNumber() < 0) goto L18;
        NativeImpl.writeFile(r101, "(Unknown Source:");     // Catch: Throwable -> L21
        r103 = String.valueOf(r100.getLineNumber());     // Catch: Throwable -> L21
        goto L13
    L18:
        r102 = "(Unknown Source)";
    }

    public static void m(Throwable r100, int r101) {
        r100.getClass();
        String r102 = r100.getLocalizedMessage();
        NativeImpl.writeFile(r101, r100.getClass().getName());     // Catch: Throwable -> L8
        if (r102 == null) goto L6;
        NativeImpl.writeFile(r101, ": ");     // Catch: Throwable -> L8
        NativeImpl.writeFile(r101, r102);     // Catch: Throwable -> L8
    L6:
        NativeImpl.writeFile(r101, "\n");     // Catch: Throwable -> L8
        return;
    }

    public static String c(Throwable r100, PrintStream r101, f.a r102) {
        MessageDigest r103 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L5
    L6:
        f r104 = new f(r101, r103, r102);
        g(r100, r104);     // Catch: Throwable -> L9
    L10:
        r104.close();
        if (r103 == null) goto L23;
        byte[] r105 = r103.digest();
        if (r105 != null) goto L15;
    L21:
        return "";
    L15:
        if (r105.length <= 0) goto L21;
        char[] r106 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
        char[] r107 = new char[r105.length * 2];
        int r108 = r105.length;
        int r109 = 0;
        int r110 = 0;
    L18:
        if (r109 >= r108) goto L29;
        byte r111 = r105[r109];
        int r112 = r110 + 1;
        r107[r110] = r106[(r111 >>> 4) & 15];
        r110 = r112 + 1;
        r107[r112] = r106[r111 & 15];
        r109 = r109 + 1;
        goto L18
    L29:
        return new String(r107);
    L23:
        return null;
    L5:
        r103 = null;
        goto L6
    }
}
