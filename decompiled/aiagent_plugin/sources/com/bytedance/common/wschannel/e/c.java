package com.bytedance.common.wschannel.e;

import android.app.ActivityManager;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.j;
import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f6943a;

    static {
    }

    public static String a(byte[] r1) {
        return a(r1, " ");
    }

    public static String a(byte[] r5, String r6) {
        StringBuilder r0 = new StringBuilder("");
        int r1 = 0;
    L4:
        if (r1 >= r5.length) goto L10;
        String r2 = Integer.toHexString(r5[r1] & 255);
        if (r2.length() != 1) goto L8;
        r2 = "0" + r2;
    L8:
        r0.append(r2);
        r0.append(r6);
        r1 = r1 + 1;
        goto L4
    L10:
        return r0.toString().toUpperCase().trim();
    }

    public static String a(String r7) {
        if (TextUtils.isEmpty(r7) == false) goto L16;
        return "";
    L16:
        byte[] r8 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5).digest(r7.getBytes());     // Catch: NoSuchAlgorithmException -> L13
        StringBuilder r0 = new StringBuilder();     // Catch: NoSuchAlgorithmException -> L13
        int r2 = r8.length;     // Catch: NoSuchAlgorithmException -> L13
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L11;
        String r4 = Integer.toHexString(r8[r3] & 255);     // Catch: NoSuchAlgorithmException -> L13
        if (r4.length() != 1) goto L10;
        r4 = "0" + r4;     // Catch: NoSuchAlgorithmException -> L13
    L10:
        r0.append(r4);     // Catch: NoSuchAlgorithmException -> L13
        r3 = r3 + 1;     // Catch: NoSuchAlgorithmException -> L13
        goto L6
    L11:
        return r0.toString();
    L13:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static String a(long r2) {
        return DateFormat.getDateTimeInstance().format(new Date(r2));
    }

    public static boolean a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        String r0 = b(r4);
        if (r0 != null) goto L5;
    L7:
        if (r0 != null) goto L9;
        return false;
    L9:
        if (r0.equals(r4.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r0.contains(":") == false) goto L7;
        return false;
    }

    public static boolean a(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
    L7:
        if (r3 != null) goto L9;
        return false;
    L9:
        if (r3.equals(r4.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r3.contains(":") == false) goto L7;
        return false;
    }

    public static String b(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        String r0 = f6943a;
        if (j.a(r0) == true) goto L5;
        return r0;
    L5:
        String r1 = a();
        f6943a = r1;
        if (j.a(r1) == false) goto L8;
        String r4 = b();
        f6943a = r4;
        if (j.a(r4) == false) goto L12;
        String r5 = c();
        f6943a = r5;
        if (j.a(r5) == false) goto L16;
        String r6 = c(r3);
        f6943a = r6;
        return r6;
    L16:
        return f6943a;
    L12:
        return f6943a;
    L8:
        return f6943a;
    }

    private static String a() {
        if (Build.VERSION.SDK_INT < 28) goto L12;
        return Application.getProcessName();
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        return null;
    }

    private static String b() {
        Method r2 = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", (Class[]) ZeusTransformUtils.preCheckCast(new Class[0], Class[].class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L7
        r2.setAccessible(true);     // Catch: Throwable -> L7
        Object r3 = r2.invoke(null, new Object[0]);     // Catch: Throwable -> L7
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L12;
        return (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
    L12:
        return null;
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private static String c(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        String r0 = null;
        if (r8 != null) goto L18;
        return null;
    L18:
        int r2 = Process.myPid();     // Catch: Exception -> L15
        Iterator<ActivityManager.RunningAppProcessInfo> r9 = ((ActivityManager) ZeusTransformUtils.preCheckCast(r8.getSystemService("activity"), ActivityManager.class, "com.obric.aiagent.plugin")).getRunningAppProcesses().iterator();     // Catch: Exception -> L15
    L6:
        if (r9.hasNext() == false) goto L17;
        ActivityManager.RunningAppProcessInfo r3 = (ActivityManager.RunningAppProcessInfo) ZeusTransformUtils.preCheckCast(r9.next(), ActivityManager.RunningAppProcessInfo.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L15
        if (r3.pid != r2) goto L6;
        if (Logger.debug() == false) goto L13;
        Logger.d("Process", "processName = " + r3.processName);     // Catch: Exception -> L15
    L13:
        r0 = r3.processName;     // Catch: Exception -> L15
    L17:
        return r0;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    private static String c() {
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L14
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L19
    L5:
        int r3 = r1.read();     // Catch: Throwable -> L19
        if (r3 <= 0) goto L9;
        r2.append((char) r3);     // Catch: Throwable -> L19
        goto L5
    L9:
        if (Logger.debug() == false) goto L11;
        Logger.d("Process", "get processName = " + r2.toString());     // Catch: Throwable -> L19
    L11:
        String r0 = r2.toString();     // Catch: Throwable -> L19
        r1.close();     // Catch: Exception -> L18
    L13:
        return r0;
    L15:
        if (r1 != null) goto L21;
    L17:
        return null;
    L21:
        r1.close();     // Catch: Exception -> L20
    L14:
        r1 = null;
        goto L15
    }

    public static boolean b(String r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (r1.endsWith(":push") == false) goto L6;
        return true;
    }

    public static boolean a(Context r4, Class<? extends Service> r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L20;
        if (r5 == null) goto L20;
        Iterator<ActivityManager.RunningServiceInfo> r7 = ((ActivityManager) ZeusTransformUtils.preCheckCast(r6.getSystemService("activity"), ActivityManager.class, "com.obric.aiagent.plugin")).getRunningServices(Integer.MAX_VALUE).iterator();     // Catch: Exception -> L18
    L8:
        if (r7.hasNext() == false) goto L20;
        ActivityManager.RunningServiceInfo r2 = (ActivityManager.RunningServiceInfo) ZeusTransformUtils.preCheckCast(r7.next(), ActivityManager.RunningServiceInfo.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L18
        if (r2 == null) goto L8;
        if (r2.service == null) goto L8;
        if (TextUtils.equals(r5.getName(), r2.service.getClassName()) == false) goto L8;
        return true;
    L18:
        e = move-exception;
        e.printStackTrace();
    L20:
        return false;
    }

    public static JSONObject a(Map<String, String> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        JSONObject r0 = new JSONObject();
        if (r6 != null) goto L5;
    L17:
        return r0;
    L5:
        if (r6.isEmpty() == true) goto L17;
        Iterator r7 = r6.entrySet().iterator();
    L9:
        if (r7.hasNext() == false) goto L17;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r2.getKey(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L9;
        r0.put((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"), r2.getValue());     // Catch: JSONException -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public static Map<String, String> a(JSONObject r5) {
        HashMap r0 = new HashMap();
        if (r5 != null) goto L5;
        return r0;
    L5:
        Iterator<String> r1 = r5.keys();
    L7:
        if (r1.hasNext() == false) goto L16;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r2) == true) goto L7;
        Object r3 = r5.opt(r2);
        if (r3 != null) goto L14;
        String r4 = null;
    L15:
        r0.put(r2, r4);
        goto L7
    L14:
        r4 = r3.toString();
        goto L15
    L16:
        return r0;
    }

    public static String a(Throwable r3) {
        String r0 = null;
        if (r3 != null) goto L29;
        return null;
    L29:
        StringWriter r1 = new StringWriter();     // Catch: Throwable -> L15
        PrintWriter r2 = new PrintWriter(r1);     // Catch: Throwable -> L15
        r3.printStackTrace(r2);     // Catch: Throwable -> L13
        Throwable r4 = r3.getCause();     // Catch: Throwable -> L13
        if (r4 == null) goto L11;
        r4.printStackTrace(r2);     // Catch: Throwable -> L13
        Throwable r5 = r4.getCause();     // Catch: Throwable -> L13
        if (r5 == null) goto L11;
        r5.printStackTrace(r2);     // Catch: Throwable -> L13
    L11:
        r0 = r1.toString();     // Catch: Throwable -> L13
    L12:
        r2.close();
    L20:
        return r0;
    L13:
        th = th;
    L25:
        th.printStackTrace();     // Catch: Throwable -> L21
        if (r2 == null) goto L20;
    L21:
        th = move-exception;
        if (r2 == null) goto L24;
        r2.close();
    L24:
        throw th;
    L15:
        th = th;
        r2 = null;
        goto L25
    }
}
