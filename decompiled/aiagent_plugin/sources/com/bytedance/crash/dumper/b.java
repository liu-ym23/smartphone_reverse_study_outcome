package com.bytedance.crash.dumper;

import android.text.TextUtils;
import com.bytedance.crash.jni.NativeBridge;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: BuildId.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: compiled from: BuildId.java */
    static class a extends d {
        a(File r1) {
            super(r1);
        }

        @Override // com.bytedance.crash.dumper.b.d
        Pattern a() {
            return Pattern.compile("^  native: #\\d{1,3} pc [0-9a-f]{8,16} {2}(/(?:[^/]+/)+.*\\.so).*");
        }

        @Override // com.bytedance.crash.dumper.b.d
        boolean a(String r1) {
            return r1.startsWith("  native: #");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.crash.dumper.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BuildId.java */
    static class C0162b extends d {
        C0162b(File r1) {
            super(r1);
        }

        @Override // com.bytedance.crash.dumper.b.d
        Pattern a() {
            return Pattern.compile("^#\\d{1,3} pc [0-9a-f]{8,16} {2}(/(?:[^/]+/)+.*\\.so).*");
        }

        @Override // com.bytedance.crash.dumper.b.d
        boolean a(String r1) {
            return r1.startsWith("#");
        }
    }

    /* JADX INFO: compiled from: BuildId.java */
    static class c extends d {
        c(File r1) {
            super(r1);
        }

        @Override // com.bytedance.crash.dumper.b.d
        Pattern a() {
            return Pattern.compile("^0x[0-9a-f]{1,16}:(/(?:[^/]+/)+[^.]+\\.so):.*");
        }

        @Override // com.bytedance.crash.dumper.b.d
        boolean a(String r1) {
            return r1.startsWith("0x");
        }
    }

    /* JADX INFO: compiled from: BuildId.java */
    static abstract class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f7405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Pattern f7406b;

        abstract Pattern a();

        abstract boolean a(String r1);

        d(File r1) {
            this.f7405a = r1;
            this.f7406b = a();
        }

        void a(List<String> r6) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
            if (this.f7405a.exists() == true) goto L5;
            return;
        L5:
            BufferedReader r0 = null;
            BufferedReader r1 = new BufferedReader(new InputStreamReader(new FileInputStream(this.f7405a)));     // Catch: Throwable -> L23
        L24:
            String r2 = r1.readLine();     // Catch: Throwable -> L19
            if (r2 == null) goto L21;
            if (a(r2) == false) goto L24;
            Matcher r3 = this.f7406b.matcher(r2);     // Catch: Throwable -> L19
            if (r3.find() == false) goto L24;
            if (r3.groupCount() != 1) goto L24;
            String r4 = r3.group(1);     // Catch: Throwable -> L19
            if (r7.contains(r4) == true) goto L24;
            r7.add(r4);     // Catch: Throwable -> L19
        L21:
            com.bytedance.crash.o.i.a(r1);
            return;
        L19:
            r0 = r1;
        L20:
            r1 = r0;
            goto L21
        }
    }

    public static void a(JSONObject r4, File r5, boolean r6) {
        HashMap r0 = new HashMap();
        ArrayList r1 = new ArrayList();
        if (r6 == false) goto L5;
        a(r0, new File(r5, "tombstone.txt"));
        new C0162b(new File(r5, "nstack.txt")).a(r1);
    L5:
        new c(new File(r5, "rountines.txt")).a(r1);
        Iterator r7 = r1.iterator();
    L7:
        if (r7.hasNext() == false) goto L15;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin");
        if (c(r8) == true) goto L7;
        if (r0.containsKey(r8) == true) goto L7;
        String r2 = NativeBridge.j(r8);
        if (r2 == null) goto L7;
        r0.put(r8, r2);
        goto L7
    L15:
        a(r4, r0);
    }

    public static void a(JSONObject r4, File r5) {
        HashMap r0 = new HashMap();
        ArrayList r1 = new ArrayList();
        new a(r5).a(r1);
        Iterator r6 = r1.iterator();
    L4:
        if (r6.hasNext() == false) goto L12;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin");
        if (c(r2) == true) goto L4;
        if (r0.containsKey(r2) == true) goto L4;
        String r3 = NativeBridge.j(r2);
        if (r3 == null) goto L4;
        r0.put(r2, r3);
        goto L4
    L12:
        a(r4, r0);
    }

    private static void a(JSONObject r6, Map<String, String> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        JSONArray r0 = new JSONArray();
        Iterator r9 = r8.entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L10;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r3 = a((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r3) == true) goto L4;
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L12
        com.bytedance.crash.o.l.a(r4, "lib_name", r3);     // Catch: Throwable -> L12
        com.bytedance.crash.o.l.a(r4, "lib_uuid", b((String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L12
        r0.put(r4);     // Catch: Throwable -> L12
        goto L4
    L10:
        com.bytedance.crash.o.l.a(r6, "crash_lib_uuid", r0);
    }

    private static String a(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L10;
        int r0 = r2.lastIndexOf(47);
        if (r0 == (-1)) goto L13;
        String r3 = r2.substring(r0 + 1);
        int r1 = r3.indexOf(".apk!");
        if (r1 != (-1)) goto L9;
        return r3;
    L9:
        return r3.substring(r1 + 5);
    L13:
        return null;
    L10:
        return null;
    }

    private static String b(String r4) {
        StringBuilder r0 = new StringBuilder();
        if (r4.length() >= 16) goto L6;
        r0.append(r4);     // Catch: Throwable -> L11
    L12:
        goto L10
    L6:
        r0.append(r4.charAt(6));     // Catch: Throwable -> L11
        r0.append(r4.charAt(7));     // Catch: Throwable -> L11
        r0.append(r4.charAt(4));     // Catch: Throwable -> L11
        r0.append(r4.charAt(5));     // Catch: Throwable -> L11
        r0.append(r4.charAt(2));     // Catch: Throwable -> L11
        r0.append(r4.charAt(3));     // Catch: Throwable -> L11
        r0.append(r4.charAt(0));     // Catch: Throwable -> L11
        r0.append(r4.charAt(1));     // Catch: Throwable -> L11
        r0.append(r4.charAt(10));     // Catch: Throwable -> L11
        r0.append(r4.charAt(11));     // Catch: Throwable -> L11
        r0.append(r4.charAt(8));     // Catch: Throwable -> L11
        r0.append(r4.charAt(9));     // Catch: Throwable -> L11
        r0.append(r4.charAt(14));     // Catch: Throwable -> L11
        r0.append(r4.charAt(15));     // Catch: Throwable -> L11
        r0.append(r4.charAt(12));     // Catch: Throwable -> L11
        r0.append(r4.charAt(13));     // Catch: Throwable -> L11
        if (r4.length() < 32) goto L12;
        r0.append(r4, 16, 32);     // Catch: Throwable -> L11
        r0.append('0');     // Catch: Throwable -> L11
    L10:
        return r0.toString().toUpperCase();
    }

    private static boolean c(String r1) {
        if (r1.startsWith("/system/lib") == false) goto L5;
    L10:
        return true;
    L5:
        if (r1.startsWith("/vendor/lib") == true) goto L10;
        if (r1.startsWith("/apex/") == true) goto L10;
        return false;
    }

    private static void a(Map<String, String> r5, File r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if (r6.exists() == true) goto L5;
        return;
    L5:
        Pattern r0 = Pattern.compile("^ {4}(/(?:[^/]+/)+[^.]+\\.so) \\(BuildId: ([0-9a-f]+)\\).*");
        BufferedReader r1 = null;
        BufferedReader r2 = new BufferedReader(new InputStreamReader(new FileInputStream(r6)));     // Catch: Throwable -> L32
    L33:
        String r8 = r2.readLine();     // Catch: Throwable -> L28
        if (r8 == null) goto L30;
        if (r8.startsWith("build id:") == false) goto L33;
    L11:
        String r9 = r2.readLine();     // Catch: Throwable -> L28
        if (r9 == null) goto L33;
        if (r9.startsWith("    /") == false) goto L33;
        Matcher r10 = r0.matcher(r9);     // Catch: Throwable -> L28
        if (r10.find() == false) goto L11;
        if (r10.groupCount() != 2) goto L11;
        String r3 = r10.group(1);     // Catch: Throwable -> L28
        String r11 = r10.group(2);     // Catch: Throwable -> L28
        if (r3 == null) goto L11;
        if (c(r3) == true) goto L11;
        if (r7.containsKey(r3) == true) goto L11;
        r7.put(r3, r11);     // Catch: Throwable -> L28
    L30:
        com.bytedance.crash.o.i.a(r2);
        return;
    L28:
        r1 = r2;
    L29:
        r2 = r1;
        goto L30
    }
}
