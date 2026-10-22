package com.alipay.sdk.m.l0;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class d {
    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static String b(Context r100) {
        return "";
    }

    public static String b() {
        String r100 = g.a("ro.aliyun.clouduuid", "");
        if (TextUtils.isEmpty(r100) == false) goto L6;
        r100 = g.a("ro.sys.aliyun.clouduuid", "");
    L6:
        if (TextUtils.isEmpty(r100) == true) goto L8;
        return r100;
    L8:
        return c();
    }

    public static String c() {
    L6:
        return "";
    L4:
        return (String) INVOKESTATIC_com_alipay_sdk_m_l0_d_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.yunos.baseservice.clouduuid.CloudUUID").getMethod("getCloudUUID", new Class[0]).invoke(null, new Object[0]);
    }

    public static String a() {
        int r100 = (int) (System.currentTimeMillis() / 1000);
        int r101 = (int) System.nanoTime();
        int r102 = new Random().nextInt();
        int r103 = new Random().nextInt();
        byte[] r104 = c.a(r100);
        byte[] r105 = c.a(r101);
        byte[] r106 = c.a(r102);
        byte[] r107 = c.a(r103);
        byte[] r108 = new byte[16];
        System.arraycopy(r104, 0, r108, 0, 4);
        System.arraycopy(r105, 0, r108, 4, 4);
        System.arraycopy(r106, 0, r108, 8, 4);
        System.arraycopy(r107, 0, r108, 12, 4);
        return b.c(r108, 2);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_alipay_sdk_m_l0_d_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static String a(Context r100) {
        String r101 = null;
        if (f.m8017a(null) == false) goto L6;
        r101 = b();
    L6:
        if (f.m8017a(r101) == true) goto L8;
        return r101;
    L8:
        return a();
    }
}
