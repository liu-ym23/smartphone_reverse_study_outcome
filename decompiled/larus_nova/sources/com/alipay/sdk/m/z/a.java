package com.alipay.sdk.m.z;

import android.util.Base64;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPOutputStream;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public final class a {
    public static String a(Throwable r100) {
        StringWriter r101 = new StringWriter();
        r100.printStackTrace(new PrintWriter(r101));
        return r101.toString();
    }

    public static String a(Map<String, String> r100, String r101, String r102) {
        if (r100 != null) goto L4;
        return r102;
    L4:
        String r103 = r100.get(r101);
        if (r103 != null) goto L7;
        return r102;
    L7:
        return r103;
    }

    public static boolean a(String r100) {
        if (r100 == null) goto L13;
        int r101 = r100.length();
        if (r101 == 0) goto L13;
        int r102 = 0;
    L8:
        if (r102 >= r101) goto L13;
        if (Character.isWhitespace(r100.charAt(r102)) == false) goto L11;
        r102 = r102 + 1;
        goto L8
    L11:
        return false;
    L13:
        return true;
    }

    public static boolean a(String r100, String r101) {
        if (r100 != null) goto L9;
        if (r101 != null) goto L6;
        return true;
    L6:
        return false;
    L9:
        return r100.equals(r101);
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static String b(String r100, String r101) {
    L6:
        return r101;
    L4:
        return (String) INVOKESTATIC_com_alipay_sdk_m_z_a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(null, new Object[]{r100, r101});
    }

    public static boolean b(String r100) {
        if (a(r100) == true) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean c(String r100) {
        byte[] r101 = r100.getBytes();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L12;
        byte r104 = r101[r103];
        if (r104 < 0) goto L9;
        if (r104 > 31) goto L9;
    L10:
        return false;
    L9:
        if (r104 >= 127) goto L10;
        r103 = r103 + 1;
        goto L3
    L12:
        return true;
    }

    public static String d(String r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100;
    }

    public static String e(String r100) {
    L13:
        return null;
    L4:
        if (a(r100) == false) goto L6;
        return null;
    L6:
        MessageDigest r101 = MessageDigest.getInstance("SHA-1");     // Catch: Exception -> L13
        r101.update(r100.getBytes("UTF-8"));     // Catch: Exception -> L13
        byte[] r102 = r101.digest();     // Catch: Exception -> L13
        StringBuilder r103 = new StringBuilder();     // Catch: Exception -> L13
        int r104 = 0;
    L8:
        if (r104 >= r102.length) goto L11;
        r103.append(String.format("%02x", new Object[]{Byte.valueOf(r102[r104])}));     // Catch: Exception -> L13
        r104 = r104 + 1;     // Catch: Exception -> L13
        goto L8
    L11:
        return r103.toString();
    }

    public static String f(String r100) {
        byte[] r101 = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(r100.length()).array();     // Catch: Exception -> L5
        ByteArrayOutputStream r102 = new ByteArrayOutputStream(r100.length());     // Catch: Exception -> L5
        GZIPOutputStream r103 = new GZIPOutputStream(r102);     // Catch: Exception -> L5
        r103.write(r100.getBytes("UTF-8"));     // Catch: Exception -> L5
        r103.close();     // Catch: Exception -> L5
        r102.close();     // Catch: Exception -> L5
        byte[] r104 = new byte[r102.toByteArray().length + 4];     // Catch: Exception -> L5
        System.arraycopy(r101, 0, r104, 0, 4);     // Catch: Exception -> L5
        System.arraycopy(r102.toByteArray(), 0, r104, 4, r102.toByteArray().length);     // Catch: Exception -> L5
        return Base64.encodeToString(r104, 8);
    L5:
        return "";
    }

    public static String g(String r100) {
        if (a(r100) == false) goto L13;
        return "";
    L13:
        ByteArrayInputStream r101 = new ByteArrayInputStream(r100.getBytes(XML.CHARSET_UTF8));     // Catch: Exception -> L12
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();     // Catch: Exception -> L12
        GZIPOutputStream r103 = new GZIPOutputStream(r102);     // Catch: Exception -> L12
        byte[] r104 = new byte[1024];     // Catch: Exception -> L12
    L6:
        int r105 = r101.read(r104, 0, 1024);     // Catch: Exception -> L12
        if (r105 == (-1)) goto L9;
        r103.write(r104, 0, r105);     // Catch: Exception -> L12
        goto L6
    L9:
        r103.flush();     // Catch: Exception -> L12
        r103.close();     // Catch: Exception -> L12
        byte[] r106 = r102.toByteArray();     // Catch: Exception -> L12
        r102.flush();     // Catch: Exception -> L12
        r102.close();     // Catch: Exception -> L12
        r101.close();     // Catch: Exception -> L12
        return new String(Base64.encode(r106, 2));
    L16:
        return "";
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_alipay_sdk_m_z_a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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
}
