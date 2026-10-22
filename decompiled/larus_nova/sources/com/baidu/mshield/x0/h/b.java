package com.baidu.mshield.x0.h;

import android.content.Context;
import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.baidu.mshield.b.e.c;
import com.baidu.mshield.x0.d.d;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes39.dex */
public class b {

    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f32525a;

        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_baidu_mshield_x0_h_b$a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class r103 = access$000(r100);     // Catch: Throwable -> L8
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        L7:
            return r103;
        L8:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r100);
        L12:
            throw th;
        L34:
            Class r104 = access$000(r100);     // Catch: Throwable -> L17
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        L16:
            return r104;
        L17:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r100);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r100);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
            Class r101 = INVOKESTATIC_com_baidu_mshield_x0_h_b$a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread");     // Catch: Throwable -> L8
            Object r102 = r101.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L8
            Field r103 = r101.getDeclaredField("mInstrumentation");     // Catch: Throwable -> L8
            r103.setAccessible(true);     // Catch: Throwable -> L8
            String r104 = r103.get(r102).getClass().getCanonicalName();     // Catch: Throwable -> L8
            this.f32525a[0] = r104;     // Catch: Throwable -> L8
            Method r105 = INVOKESTATIC_com_baidu_mshield_x0_h_b$a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityManagerNative").getDeclaredMethod("getDefault", new Class[0]);     // Catch: Throwable -> L8
            r105.setAccessible(true);     // Catch: Throwable -> L8
            String r106 = r105.invoke(null, new Object[0]).getClass().getCanonicalName();     // Catch: Throwable -> L8
            this.f32525a[1] = r106;     // Catch: Throwable -> L8
        L10:
            super.handleMessage(r100);
            return;
        L8:
            th = move-exception;
            d.a(th);
            goto L10
        }

        public a(Looper r100, String[] r101) {
            this.f32525a = r101;
            super(r100);
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_baidu_mshield_x0_h_b_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static String[] a(Context r110) {
        String[] r100 = new String[2];
    L15:
        th = move-exception;
        d.a(th);
        return r100;
    L4:
        if (d.a(r110, "plc94", false) == false) goto L6;
        return r100;
    L6:
        long r101 = System.currentTimeMillis();     // Catch: Throwable -> L15
        a r102 = new a(r110.getMainLooper(), r100);     // Catch: Throwable -> L15
        r102.sendEmptyMessage(1);     // Catch: Throwable -> L15
    L8:
        if ((System.currentTimeMillis() - r101) >= 100) goto L13;
        Thread.sleep(10);     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r100[0]) == false) goto L8;
        if (TextUtils.isEmpty(r100[1]) == false) goto L8;
    L13:
        r102.removeCallbacksAndMessages(null);     // Catch: Throwable -> L15
        com.baidu.mshield.b.c.a.b(" spend time : " + (System.currentTimeMillis() - r101) + "");     // Catch: Throwable -> L15
        return r100;
    }

    public static String b(Context r100) {
    L34:
        th = move-exception;
        d.a(th);
        return "";
    L5:
        Object r101 = INVOKESTATIC_com_baidu_mshield_x0_h_b_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L34
        Field r102 = r101.getClass().getDeclaredField("mPackages");     // Catch: Throwable -> L34
        boolean r103 = true;
        r102.setAccessible(true);     // Catch: Throwable -> L34
        Map r104 = (Map) r102.get(r101);     // Catch: Throwable -> L34
        if (r104 != null) goto L8;
        return "";
    L8:
        if (r104.size() <= 0) goto L59;
        ArrayList r105 = new ArrayList();     // Catch: Throwable -> L34
        Iterator r106 = r104.keySet().iterator();     // Catch: Throwable -> L34
    L11:
        if (r106.hasNext() == false) goto L25;
        Object r107 = r106.next();     // Catch: Throwable -> L34
        String r108 = r107.toString();     // Catch: Throwable -> L34
        if (r107.toString().length() <= 1) goto L11;
        if (r108.equals(r100.getPackageName()) == true) goto L11;
        if (r108.endsWith("android.webview") == true) goto L11;
        if (r108.startsWith("com.baidu.") == true) goto L11;
        r100.getPackageManager().getApplicationInfo(r107.toString(), 0);     // Catch: Throwable -> L34
        PolarisFileWrapper r109 = new PolarisFileWrapper("/data/data" + HTTP.URL_DEFAULT + r107.toString());     // Catch: Throwable -> L34
        if (r109.exists() == false) goto L11;
        if (r109.canWrite() == false) goto L11;
        r105.add(r107.toString());     // Catch: Throwable -> L34
        goto L11
    L25:
        StringBuffer r110 = new StringBuffer();     // Catch: Throwable -> L34
        Iterator r111 = r105.iterator();     // Catch: Throwable -> L34
    L27:
        if (r111.hasNext() == false) goto L32;
        String r112 = (String) r111.next();     // Catch: Throwable -> L34
        if (r103 == true) goto L31;
        r110.append(i.f25853b);     // Catch: Throwable -> L34
    L31:
        r110.append(r112);     // Catch: Throwable -> L34
        r103 = false;
        goto L27
    L32:
        return r110.toString();
    L59:
        return "";
    }

    public static String c(Context r100) {
        Class r101 = com.baidu.mshield.b.e.a.c(r100);     // Catch: Throwable -> L7
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.getMethod("getService", new Class[]{String.class}).invoke(r101.newInstance(), new Object[]{"phone"}).getClass().getCanonicalName();
    L7:
        th = move-exception;
        d.a(th);
        return null;
    }

    public static List<String> d(Context r100) {
        List<String> r101 = a(r100, d.f());     // Catch: Throwable -> L12
        if (r101 != null) goto L5;
    L11:
        return r101;
    L5:
        if (r101.size() <= 0) goto L11;
        Iterator<String> r102 = r101.iterator();     // Catch: Throwable -> L12
    L8:
        if (r102.hasNext() == false) goto L11;
        com.baidu.mshield.b.c.a.b("vpn app:" + r102.next());     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        d.a(th);
        return null;
    }

    public static int e(Context r100) {
        String r101 = c(r100);     // Catch: Throwable -> L29
        String[] r102 = a(r100);     // Catch: Throwable -> L29
        int r103 = Binder.getCallingUid();     // Catch: Throwable -> L6
    L8:
        int r104 = String.valueOf(r103).length();     // Catch: Throwable -> L29
        if (a(r102) == false) goto L16;
        if (a(r101) == false) goto L16;
        if (r104 >= 6) goto L16;
        return 1;
    L16:
        if (a(r102) == true) goto L18;
    L19:
        if (r104 < 6) goto L23;
        return 2;
    L23:
        if (a(r102) == false) goto L31;
        if (a(r101) == false) goto L31;
        if (r104 < 6) goto L31;
        return 3;
    L31:
        return 0;
    L18:
        if (a(r101) == true) goto L23;
    L6:
        th = move-exception;
        d.a(th);     // Catch: Throwable -> L29
        r103 = 0;
    L29:
        th = move-exception;
        d.a(th);
        goto L31
    }

    public static boolean a(String[] r100) {
        if (r100 != null) goto L18;
        return false;
    L18:
        String r101 = r100[0];     // Catch: Throwable -> L15
        if (r101 != null) goto L8;
    L10:
        String r102 = r100[1];     // Catch: Throwable -> L15
        if (r102 == null) goto L17;
        if (r102.equals("android.app.ActivityManagerProxy") == true) goto L17;
        return true;
    L17:
        return false;
    L8:
        if (r101.equals("android.app.Instrumentation") == true) goto L10;
        return true;
    L15:
        th = move-exception;
        d.a(th);
        goto L17
    }

    public static boolean a(String r100) {
    L10:
        th = move-exception;
        d.a(th);
    L12:
        return false;
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if ("android.os.BinderProxy".equals(r100) == true) goto L12;
        return true;
    }

    public static List<String> a(Context r100, String r101) {
    L14:
        th = move-exception;
        d.a(th);
        return null;
    L4:
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return null;
    L6:
        JSONArray r102 = new JSONArray(r101);     // Catch: Throwable -> L14
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L14
        int r104 = 0;
    L8:
        if (r104 >= r102.length()) goto L13;
        String r105 = r102.getString(r104);     // Catch: Throwable -> L14
        if (c.a(r100, r105, 0) == null) goto L12;
        r103.add(r105);     // Catch: Throwable -> L14
    L12:
        r104 = r104 + 1;
        goto L8
    L13:
        return r103;
    }
}
