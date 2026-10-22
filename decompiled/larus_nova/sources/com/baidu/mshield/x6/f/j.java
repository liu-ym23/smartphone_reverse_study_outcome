package com.baidu.mshield.x6.f;

import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class j {
    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_baidu_mshield_x6_f_j_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static Object[] a(String r100, String r101) {
        Object[] r102 = new Object[2];
    L32:
        th = move-exception;
        f.b(th);
    L34:
        return r102;
    L4:
        if ("byte".equals(r100) == false) goto L7;
        r102[0] = Byte.TYPE;     // Catch: Throwable -> L32
        r102[1] = Byte.valueOf(Byte.parseByte(r101));     // Catch: Throwable -> L32
    L35:
        goto L34
    L7:
        if ("short".equals(r100) == false) goto L10;
        r102[0] = Short.TYPE;     // Catch: Throwable -> L32
        r102[1] = Short.valueOf(Short.parseShort(r101));     // Catch: Throwable -> L32
        goto L35
    L10:
        if ("int".equalsIgnoreCase(r100) == false) goto L13;
        r102[0] = Integer.TYPE;     // Catch: Throwable -> L32
        r102[1] = Integer.valueOf(Integer.parseInt(r101));     // Catch: Throwable -> L32
        goto L35
    L13:
        if ("long".equalsIgnoreCase(r100) == false) goto L16;
        r102[0] = Long.TYPE;     // Catch: Throwable -> L32
        r102[1] = Long.valueOf(Long.parseLong(r101));     // Catch: Throwable -> L32
        goto L35
    L16:
        if ("float".equalsIgnoreCase(r100) == false) goto L19;
        r102[0] = Float.TYPE;     // Catch: Throwable -> L32
        r102[1] = Float.valueOf(Float.parseFloat(r101));     // Catch: Throwable -> L32
        goto L35
    L19:
        if (ItemStyle.ITEM_STYLE_DOUBLE.equalsIgnoreCase(r100) == false) goto L22;
        r102[0] = Double.TYPE;     // Catch: Throwable -> L32
        r102[1] = Double.valueOf(Double.parseDouble(r101));     // Catch: Throwable -> L32
        goto L35
    L22:
        if ("char".equalsIgnoreCase(r100) == false) goto L25;
        r102[0] = Character.TYPE;     // Catch: Throwable -> L32
        r102[1] = Character.valueOf(r101.charAt(0));     // Catch: Throwable -> L32
        goto L35
    L25:
        if ("boolean".equalsIgnoreCase(r100) == false) goto L28;
        r102[0] = Boolean.TYPE;     // Catch: Throwable -> L32
        r102[1] = Boolean.valueOf(Boolean.parseBoolean(r101));     // Catch: Throwable -> L32
        goto L35
    L28:
        if ("java.lang.String".equalsIgnoreCase(r100) == false) goto L30;
        r102[0] = String.class;     // Catch: Throwable -> L32
        r102[1] = r101;     // Catch: Throwable -> L32
        goto L35
    L30:
        INVOKESTATIC_com_baidu_mshield_x6_f_j_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100).newInstance();     // Catch: Throwable -> L32
        goto L35
    }

    public static String a(String r100, String r101, String r102, String r103) {
        return a(r100, r101, r102, r103, false);
    L5:
        th = move-exception;
        f.b(th);
        return "";
    }

    public static String b(String r100, String r101, String r102, String r103) {
        return a(r100, r101, r102, r103, true);
    L5:
        th = move-exception;
        f.b(th);
        return "";
    }

    public static String a(String r100, String r101, String r102, String r110, boolean r111) {
        com.baidu.mshield.b.c.a.a("doExecMethod cn :" + r100 + ",mn : " + r101 + ", paramTypes : " + r102 + ", paramValues : " + r110 + ", isStaticMethod " + r111);     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r102) == true) goto L23;
        if (TextUtils.isEmpty(r110) == true) goto L23;
        String[] r103 = r102.split("#");     // Catch: Throwable -> L24
        String[] r112 = r110.split("#", -1);     // Catch: Throwable -> L24
        if (r103.length > 0) goto L11;
    L19:
        com.baidu.mshield.b.c.a.a("doExecMethod types values length error");     // Catch: Throwable -> L24
        return "#doExecMethod types values length error";
    L11:
        if (r103.length != r112.length) goto L19;
        Class[] r104 = new Class[r103.length];     // Catch: Throwable -> L24
        Object[] r105 = new Object[r103.length];     // Catch: Throwable -> L24
        int r106 = 0;
    L15:
        if (r106 >= r103.length) goto L18;
        Object[] r107 = a(r103[r106], r112[r106]);     // Catch: Throwable -> L24
        r104[r106] = (Class) r107[0];     // Catch: Throwable -> L24
        r105[r106] = r107[1];     // Catch: Throwable -> L24
        r106 = r106 + 1;     // Catch: Throwable -> L24
        goto L15
    L18:
        return a(r100, r101, r104, r105, r111);
    L23:
        return a(r100, r101, new Class[0], new Object[0], false);
    L24:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L27
        return "#" + th.toString();
    L27:
        th = move-exception;
        f.b(th);
        return "";
    }

    public static String a(String r100, String r101, Class[] r102, Object[] r103, boolean r104) {
        com.baidu.mshield.b.c.a.a("doExecMethod cn :" + r100 + ",mn : " + r101 + ", at : " + r102 + ", ao : " + r103 + ", isStaticMethod " + r104);     // Catch: Throwable -> L15
        Class r105 = INVOKESTATIC_com_baidu_mshield_x6_f_j_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);     // Catch: Throwable -> L15
        Method r106 = r105.getDeclaredMethod(r101, r102);     // Catch: NoSuchMethodException -> L6 Throwable -> L15
    L7:
        if (r106 == null) goto L28;
        com.baidu.mshield.b.c.a.a("doExecMethod method exist ");     // Catch: Throwable -> L15
        if (r104 == false) goto L11;
        Object r107 = r106.invoke(null, r103);     // Catch: Throwable -> L15
    L12:
        if (r107 == null) goto L29;
        return r107.toString();
    L29:
        return "";
    L11:
        r107 = r106.invoke(r105.newInstance(), r103);     // Catch: Throwable -> L15
        goto L12
    L28:
        return "";
    L6:
        r106 = r105.getSuperclass().getMethod(r101, r102);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L18
        return "#" + th.toString();
    L18:
        th = move-exception;
        f.b(th);
        return "";
    }
}
