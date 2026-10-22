package com.c.a.e.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DirTreeFileGenerator.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.FileWriter] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.FileWriter, java.io.Writer] */
    public static boolean a(File r2, File r3, List<String> r4) {
        FileWriter r1 = "com.obric.aiagent.plugin";
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        BufferedWriter r0 = null;
        r1 = new FileWriter(r3);     // Catch: Throwable -> L18 IOException -> L20
        BufferedWriter r6 = new BufferedWriter(r1);     // Catch: IOException -> L16 Throwable -> L33
        a(r2, r6, r5);     // Catch: Throwable -> L12 IOException -> L14
    L47:
        r6.close();     // Catch: IOException -> L9
        r1.close();     // Catch: IOException -> L9
    L11:
        return true;
    L9:
        e = move-exception;
        e.printStackTrace();
    L14:
        e = e;
        r0 = r6;
    L22:
        e.printStackTrace();     // Catch: Throwable -> L33
        if (r0 != null) goto L49;
    L27:
        if (r1 == 0) goto L56;
        r1.close();     // Catch: IOException -> L25
        return false;
    L25:
        e = move-exception;
        e.printStackTrace();
        return false;
    L56:
        return false;
    L49:
        r0.close();     // Catch: IOException -> L25
    L12:
        th = th;
        r0 = r6;
    L34:
        if (r0 != null) goto L45;
    L38:
        if (r1 == 0) goto L42;
        r1.close();     // Catch: IOException -> L36
    L36:
        e = move-exception;
        e.printStackTrace();
    L42:
        throw th;
    L45:
        r0.close();     // Catch: IOException -> L36
    L16:
        e = e;
        goto L22
    L33:
        th = th;
    L20:
        e = e;
        r1 = 0;
    L18:
        th = th;
        r1 = 0;
        goto L34
    }

    public static void a(File r4, BufferedWriter r5, List<String> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        HashMap r0 = new HashMap();
        r5.write("{");
        r5.newLine();
        File[] r8 = r4.listFiles();
        int r1 = 0;
    L4:
        if (r1 >= r8.length) goto L12;
        r0.clear();
        a(r8[r1], r0, r7);
        if (r0.keySet().isEmpty() == true) goto L11;
        a(r0, 1, r5);
        if ((r1 + 1) >= r8.length) goto L11;
        r5.write(",");
    L11:
        r1 = r1 + 1;
        goto L4
    L12:
        r5.write("}");
        r5.flush();
    }

    private static void a(HashMap<String, Object> r16, int r17, BufferedWriter r18) {
        int r2 = r16.keySet().size();
        Iterator<String> r3 = r16.keySet().iterator();
        int r5 = 0;
    L4:
        if (r3.hasNext() == false) goto L25;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");
        Object r9 = r16.get(r6);
        r5 = r5 + 1;
        if (ZeusTransformUtils.instanceOf(r9, Long.class) == true) goto L7;
        int r10 = 0;
    L16:
        if (r10 >= r17) goto L18;
        r18.write("\t");
        r10 = r10 + 1;
        goto L16
    L18:
        r18.write(String.format("\"%s\": {", new Object[]{r6.replaceAll("\n", "")}));
        r18.newLine();
        int r8 = r17 + 1;
        a((HashMap) ZeusTransformUtils.preCheckCast(r9, HashMap.class, "com.obric.aiagent.plugin"), r8, r18);
        int r7 = 0;
    L19:
        if (r7 >= r8) goto L21;
        r18.write("\t");
        r7 = r7 + 1;
        goto L19
    L21:
        r18.write("}");
        if (r5 >= r2) goto L24;
        r18.write(",");
    L24:
        r18.newLine();
        goto L4
    L7:
        int r11 = 0;
    L9:
        if (r11 >= (r17 + 1)) goto L11;
        r18.write("\t");
        r11 = r11 + 1;
        goto L9
    L11:
        r18.write(String.format("\"%s\": %d", new Object[]{r6.replaceAll("\n", ""), Long.valueOf(((Long) ZeusTransformUtils.preCheckCast(r9, Long.class, "com.obric.aiagent.plugin")).longValue())}));
        if (r5 >= r2) goto L14;
        r18.write(",");
    L14:
        r18.newLine();
        goto L4
    }

    private static boolean a(String r1) {
        return r1.startsWith(".");
    }

    private static void a(File r5, HashMap<String, Object> r6, List<String> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        if (a(r5.getName()) == false) goto L5;
        return;
    L5:
        int r2 = 0;
        if (com.bytedance.apm6.util.f.a(r8) == true) goto L13;
        Iterator r0 = r8.iterator();
    L9:
        if (r0.hasNext() == false) goto L13;
        if (r5.getAbsolutePath().startsWith((String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin")) == false) goto L9;
        boolean r1 = true;
    L14:
        if (r1 == false) goto L20;
        StringBuilder r3 = new StringBuilder();
        int r4 = 0;
    L17:
        if (r4 >= r5.getName().length()) goto L19;
        r3.append("*");
        r4 = r4 + 1;
        goto L17
    L19:
        String r9 = r3.toString();
    L22:
        if (r5.isFile() == false) goto L25;
        r6.put(r9, Long.valueOf(r5.length()));
    L25:
        if (r5.isDirectory() == false) goto L29;
        HashMap r10 = new HashMap();
        r6.put(r9, r10);
        String[] r11 = r5.list();
        int r12 = r11.length;
    L27:
        if (r2 >= r12) goto L35;
        a(new File(r5, r11[r2]), r10, r8);
        r2 = r2 + 1;
        goto L27
    L35:
        return;
    L29:
        return;
    L20:
        r9 = r5.getName();
    L13:
        r1 = false;
        goto L14
    }
}
