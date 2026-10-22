package com.bytedance.reparo.core;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import dalvik.system.DexFile;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PatchUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap<String, Class> f9318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ArrayList<DexFile> f9319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f9320c = null;

    public l() {
    }

    static {
        f9318a = new HashMap();
        f9319b = new ArrayList();
        f9320c = System.getProperty("java.vm.version", "");
    }

    public static ArrayList<Class> a(Context r9, List<String> r10, List<String> r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        ArrayList<Class> r1 = new ArrayList();
        File r3 = new File(r12.getFilesDir(), "hotfix_opt");     // Catch: Exception -> L30 Throwable -> L32
        if (r3.exists() == true) goto L6;
        r3.mkdirs();     // Catch: Exception -> L30 Throwable -> L32
    L9:
        Iterator r15 = r13.iterator();     // Catch: Exception -> L30 Throwable -> L32
    L11:
        if (r15.hasNext() == false) goto L25;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L30 Throwable -> L32
        File r6 = new File(r4);     // Catch: Exception -> L30 Throwable -> L32
        File r7 = new File(r3, r6.getName());     // Catch: Exception -> L30 Throwable -> L32
        r6.setReadOnly();     // Catch: Exception -> L30 Throwable -> L32
        DexFile r5 = DexFile.loadDex(r4, r7.getAbsolutePath(), 0);     // Catch: Exception -> L30 Throwable -> L32
        f9319b.add(r5);     // Catch: Exception -> L30 Throwable -> L32
        if (r13.size() > 1) goto L21;
        if (r14 == null) goto L21;
        if (r14.isEmpty() == true) goto L21;
        Iterator r8 = r14.iterator();     // Catch: Exception -> L30 Throwable -> L32
    L19:
        if (r8.hasNext() == false) goto L11;
        r1.add(a((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin"), r5));     // Catch: Exception -> L30 Throwable -> L32
    L21:
        Enumeration<String> r16 = r5.entries();     // Catch: Exception -> L30 Throwable -> L32
    L23:
        if (r16.hasMoreElements() == false) goto L11;
        r1.add(a((String) ZeusTransformUtils.preCheckCast(r16.nextElement(), String.class, "com.obric.aiagent.plugin"), r5));     // Catch: Exception -> L30 Throwable -> L32
        goto L23
    L25:
        Iterator<Class> r17 = r1.iterator();     // Catch: Exception -> L30 Throwable -> L32
    L26:
        if (r17.hasNext() == false) goto L34;
        a.a((Class) ZeusTransformUtils.preCheckCast(r17.next(), Class.class, "com.obric.aiagent.plugin"), false);     // Catch: Exception -> L30 Throwable -> L32
    L34:
        return r1;
    L6:
        if (r3.isDirectory() == true) goto L9;
        r3.delete();     // Catch: Exception -> L30 Throwable -> L32
        r3.mkdirs();     // Catch: Exception -> L30 Throwable -> L32
    L32:
        e = move-exception;
        com.bytedance.reparo.core.f.a.b("load additional class failed.", e);
    L30:
        e = move-exception;
        com.bytedance.reparo.core.f.a.b("load additional class failed.", e);
        goto L34
    }

    private static Class a(String r3, DexFile r4) {
        Class r5 = r4.loadClass(r3, l.class.getClassLoader());
        if (r5 == null) goto L9;
        Class.forName(r5.getName(), false, r5.getClassLoader());
        com.bytedance.reparo.core.f.a.c("load additional class :" + r3);
        if (r5 == null) goto L7;
        f9318a.put(r5.getName(), r5);
    L7:
        return r5;
    L9:
        throw new ClassNotFoundException(r3);
    }

    public static void a(Closeable r2) {
        Closeable r3 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L11;
        r3.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.reparo.core.f.a.b("closeSafely", e);
        return;
    }

    public static boolean a() {
        String r1 = f9320c;     // Catch: Exception -> L13
        if (r1 != null) goto L6;
        return true;
    L6:
        if (r1.length() < 1) goto L17;
        if (Integer.parseInt(String.valueOf(r1.charAt(0))) < 2) goto L12;
        return true;
    L12:
        return false;
    L17:
        return true;
    L19:
        return true;
    }

    static boolean b() {
        String r3 = null;
        Method r4 = ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.aiagent.plugin").getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class});     // Catch: Exception -> L6
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.invoke(null, new Object[]{"ro.yunos.version"}), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L6
        r3 = (String) ZeusTransformUtils.preCheckCast(r4.invoke(null, new Object[]{"java.vm.name"}), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L15
    L7:
        if (r3 != null) goto L9;
    L10:
        if (r5 != null) goto L12;
    L14:
        return false;
    L12:
        if (r5.trim().length() <= 0) goto L14;
    L13:
        return true;
    L9:
        if (r3.toLowerCase().contains("lemur") == true) goto L13;
    L6:
        r5 = null;
        goto L7
    }

    public static String a(String r2) {
        String r3 = r2.replace('.', '/');
        if (r3.length() > 0) goto L5;
        return r3;
    L5:
        if (r3.charAt(0) != '[') goto L7;
        return r3;
    L7:
        return "L" + r3 + ";";
    }

    public static String b(String r6) {
        int r0 = r6.length();
        if (r0 > 1) goto L5;
        return r6;
    L5:
        if (r6.charAt(0) != 'L') goto L11;
        int r1 = r0 - 1;
        if (r6.charAt(r1) != ';') goto L11;
        return r6.substring(1, r1).replace('/', '.');
    L11:
        return r6.replace('/', '.');
    }

    public static String a(Method r5) {
        StringBuilder r0 = new StringBuilder();
        r0.append("(");
        Class<?>[] r1 = r5.getParameterTypes();
        int r2 = 0;
    L4:
        if (r2 >= r1.length) goto L9;
        String r3 = a(r1[r2]);
        if (TextUtils.isEmpty(r3) == true) goto L8;
        r0.append(r3);
    L8:
        r2 = r2 + 1;
        goto L4
    L9:
        r0.append(")");
        r0.append(a(r5.getReturnType()));
        return r0.toString();
    }

    public static String a(Constructor r4) {
        StringBuilder r0 = new StringBuilder();
        r0.append("(");
        Class<?>[] r5 = r4.getParameterTypes();
        int r1 = 0;
    L4:
        if (r1 >= r5.length) goto L9;
        String r2 = a(r5[r1]);
        if (TextUtils.isEmpty(r2) == true) goto L8;
        r0.append(r2);
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        r0.append(")");
        r0.append(b(Void.TYPE));
        return r0.toString();
    }

    public static String a(Class<?> r2) {
        if (r2.isPrimitive() == false) goto L7;
        return b(r2);
    L7:
        if (r2.isArray() == false) goto L11;
        return "[" + a(r2.getComponentType());
    L11:
        return a(r2.getName());
    }

    private static String b(Class<?> r1) {
        if (Boolean.TYPE.equals(r1) == false) goto L7;
        return "Z";
    L7:
        if (Byte.TYPE.equals(r1) == false) goto L11;
        return "B";
    L11:
        if (Character.TYPE.equals(r1) == false) goto L15;
        return "C";
    L15:
        if (Short.TYPE.equals(r1) == false) goto L19;
        return "S";
    L19:
        if (Integer.TYPE.equals(r1) == false) goto L23;
        return "I";
    L23:
        if (Long.TYPE.equals(r1) == false) goto L27;
        return "J";
    L27:
        if (Float.TYPE.equals(r1) == false) goto L31;
        return "F";
    L31:
        if (Double.TYPE.equals(r1) == false) goto L35;
        return "D";
    L35:
        if (Void.TYPE.equals(r1) == false) goto L38;
        return "V";
    L38:
        return null;
    }

    public static Class c(String r2) {
        return (Class) ZeusTransformUtils.preCheckCast(f9318a.get(r2 + "_PeerPatchClass"), Class.class, "com.obric.aiagent.plugin");
    }

    public static String a(String r3, String r4) {
        return "L" + r3.replaceAll("\\.", "_") + "_" + r4.replaceAll("<", "_i_").replaceAll(">", "_i_");
    }
}
