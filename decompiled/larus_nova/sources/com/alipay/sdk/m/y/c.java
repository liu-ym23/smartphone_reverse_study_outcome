package com.alipay.sdk.m.y;

import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f25986a = "idnjfhncnsfuobcnt847y929o449u474w7j3h22aoddc98euk#%&&)*&^%#";

    public static String a() {
        String r100 = new String();
        int r101 = 0;
    L4:
        if (r101 >= (f25986a.length() - 1)) goto L6;
        r100 = r100 + f25986a.charAt(r101);
        r101 = r101 + 4;
        goto L4
    L6:
        return r100;
    }

    public static String a(String r100, String r101) {
        PBEKeySpec r102 = a(r100);     // Catch: Exception -> L4
        byte[] r103 = r101.getBytes();     // Catch: Exception -> L4
        byte[] r104 = b();     // Catch: Exception -> L4
        SecretKeySpec r105 = new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(r102).getEncoded(), CryptoConst.ALGORITHM_AES);     // Catch: Exception -> L4
        Cipher r106 = Cipher.getInstance("AES/CBC/PKCS5Padding");     // Catch: Exception -> L4
        r106.init(1, r105, new IvParameterSpec(r104));     // Catch: Exception -> L4
        byte[] r107 = r102.getSalt();     // Catch: Exception -> L4
        ByteBuffer r108 = ByteBuffer.allocate(r107.length + r106.getOutputSize(r103.length));     // Catch: Exception -> L4
        r108.put(r107);     // Catch: Exception -> L4
        r106.doFinal(ByteBuffer.wrap(r103), r108);     // Catch: Exception -> L4
        return a(r108.array());
    L4:
        return null;
    }

    public static String a(byte[] r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        StringBuffer r101 = new StringBuffer(r100.length * 2);
        int r102 = 0;
    L7:
        if (r102 >= r100.length) goto L10;
        byte r103 = r100[r102];
        r101.append("0123456789ABCDEF".charAt((r103 >> 4) & 15));
        r101.append("0123456789ABCDEF".charAt(r103 & 15));
        r102 = r102 + 1;
        goto L7
    L10:
        return r101.toString();
    }

    public static PBEKeySpec a(String r100) {
        Class r101 = INVOKESTATIC_com_alipay_sdk_m_y_c_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(new String(a.a("amF2YS5zZWN1cml0eS5TZWN1cmVSYW5kb20=")));
        Object r102 = r101.newInstance();
        byte[] r103 = new byte[16];
        Method r104 = r101.getMethod("nextBytes", new Class[]{r103.getClass()});
        r104.setAccessible(true);
        r104.invoke(r102, new Object[]{r103});
        return new PBEKeySpec(r100.toCharArray(), r103, 10, 128);
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static String b(String r100, String r110) {
        PBEKeySpec r101 = a(r100);     // Catch: Exception -> L18
        int r102 = r110.length() / 2;     // Catch: Exception -> L18
        byte[] r103 = new byte[r102];     // Catch: Exception -> L18
        int r104 = 0;
    L5:
        if (r104 >= r102) goto L7;
        int r105 = r104 * 2;     // Catch: Exception -> L18
        r103[r104] = CastIntegerProtector.valueOf(r110.substring(r105, r105 + 2), 16).byteValue();     // Catch: Exception -> L18
        r104 = r104 + 1;     // Catch: Exception -> L18
        goto L5
    L7:
        byte[] r111 = b();     // Catch: Exception -> L18
        if (r102 > 16) goto L10;
        byte[] r106 = null;
    L11:
        if (r106 == null) goto L16;
        String r112 = new String(r106);     // Catch: Exception -> L18
        if (com.alipay.sdk.m.z.a.c(r112) == false) goto L17;
        return r112;
    L16:
        throw new Exception();     // Catch: Exception -> L18
    L10:
        SecretKeySpec r107 = new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(r101.getPassword(), Arrays.copyOf(r103, 16), 10, 128)).getEncoded(), CryptoConst.ALGORITHM_AES);     // Catch: Exception -> L18
        Cipher r108 = Cipher.getInstance("AES/CBC/PKCS5Padding");     // Catch: Exception -> L18
        r108.init(2, r107, new IvParameterSpec(r111));     // Catch: Exception -> L18
        r106 = r108.doFinal(r103, 16, r102 - 16);     // Catch: Exception -> L18
    L17:
        return null;
    }

    public static byte[] b() {
        StringBuilder r100 = new StringBuilder();     // Catch: Exception -> L9
        int r101 = 0;
    L5:
        if (r101 >= 48) goto L7;
        r100.append("AsAgAtA5A6AdAgABABACADAfAsAdAfAsAgAaAgA3A5A6=8=0".charAt(r101));     // Catch: Exception -> L9
        r101 = r101 + 2;     // Catch: Exception -> L9
        goto L5
    L7:
        return a.a(r100.toString());
    L9:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_alipay_sdk_m_y_c_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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
