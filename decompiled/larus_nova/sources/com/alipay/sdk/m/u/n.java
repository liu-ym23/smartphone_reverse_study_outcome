package com.alipay.sdk.m.u;

import android.app.Activity;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Looper;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.alipay.sdk.app.EnvUtils;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.NamedPipe;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.OthersPermission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Symlink;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import me.ele.lancet.base.annotations.Skip;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25867a = "com.alipay.android.app";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f25868b = "com.eg.android.AlipayGphone";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f25869c = "hk.alipay.wallet";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f25870d = "hk.alipay.walletRC";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f25871e = "com.eg.android.AlipayGphoneRC";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f25872f = 99;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f25873g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f25874h = 125;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f25875i = 460;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final char[] f25876j = null;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f25877a;

        @Override // java.lang.Runnable
        public void run() {
            com_alipay_sdk_m_u_n$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_alipay_sdk_m_u_n$a__run$___twin___() {
            this.f25877a.finish();
        }

        public a(Activity r100) {
            this.f25877a = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_alipay_sdk_m_u_n$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_alipay_sdk_m_u_n$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f25878a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ConditionVariable f25879b;

        @Override // java.lang.Runnable
        public void run() {
            com_alipay_sdk_m_u_n$b_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_alipay_sdk_m_u_n$b__run$___twin___() {
            this.f25878a.run();     // Catch: Throwable -> L5
            this.f25879b.open();
            return;
        L5:
            th = move-exception;
            this.f25879b.open();
            throw th;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_alipay_sdk_m_u_n$b_com_larus_apm_impl_protector_RunnableLancet_run(b r100) {
            r100.com_alipay_sdk_m_u_n$b__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(Runnable r100, ConditionVariable r101) {
            this.f25878a = r100;
            this.f25879b = r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PackageInfo f25880a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f25881b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f25882c;

        public boolean a() {
            if (this.f25880a.versionCode >= this.f25881b) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean a(com.alipay.sdk.m.s.a r100) {
            Signature[] r101 = this.f25880a.signatures;
            if (r101 != null) goto L5;
            return false;
        L5:
            if (r101.length == 0) goto L21;
            int r102 = r101.length;
            int r103 = 0;
        L8:
            if (r103 >= r102) goto L22;
            String r104 = n.a(r100, r101[r103].toByteArray());
            if (r104 == null) goto L14;
            if (TextUtils.equals(r104, this.f25882c) == true) goto L14;
            com.alipay.sdk.m.k.a.b(r100, "biz", com.alipay.sdk.m.k.b.D, String.format("Got %s, expected %s", new Object[]{r104, this.f25882c}));
            return true;
        L14:
            r103 = r103 + 1;
            goto L8
        L22:
            return false;
        L21:
            return false;
        }

        public c(PackageInfo r100, int r101, String r102) {
            this.f25880a = r100;
            this.f25881b = r101;
            this.f25882c = r102;
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static String b(Context r100) {
        return "-1;-1";
    }

    public static boolean i() {
        String[] r100 = com.alipay.sdk.m.m.a.D().g().split("\\|");     // Catch: Throwable -> L16
        String r101 = Build.MODEL;     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return false;
    L6:
        int r102 = r100.length;     // Catch: Throwable -> L16
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L24;
        String r104 = r100[r103];     // Catch: Throwable -> L16
        if (TextUtils.equals(r101, r104) == true) goto L14;
        if (TextUtils.equals(r104, "all") == true) goto L14;
        r103 = r103 + 1;
    L14:
        return true;
    L24:
        return false;
    L16:
        th = move-exception;
        e.a(th);
        return false;
    }

    static {
        f25873g = new String[]{"10.1.5.1013151", "10.1.5.1013148"};
        f25876j = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', Matrix.MATRIX_TYPE_RANDOM_LT, 'M', 'N', 'O', 'P', 'Q', Matrix.MATRIX_TYPE_RANDOM_REGULAR, 'S', OthersPermission.STICKY, Matrix.MATRIX_TYPE_RANDOM_UT, 'V', 'W', 'X', 'Y', Matrix.MATRIX_TYPE_ZERO, 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f', 'g', 'h', 'i', 'j', 'k', Symlink.UNIX_ID, 'm', 'n', 'o', NamedPipe.UNIX_ID, 'q', Permission.READ, 's', OthersPermission.STICKY_E, 'u', 'v', Permission.WRITE, Permission.EXECUTE, 'y', 'z', '+', '/'};
    }

    public static int c() {
        String r100 = Build.BRAND.toLowerCase();     // Catch: Exception -> L28
        String r101 = Build.MANUFACTURER.toLowerCase();     // Catch: Exception -> L28
        if (a(RomUtils.BRAND_HUAWEI, new Object[]{r100, r101}) == false) goto L9;
        return 1;
    L9:
        if (a(AppConstants.CHANNEL_OPPO, new Object[]{r100, r101}) == false) goto L13;
        return 2;
    L13:
        if (a(DimLocationCheckUtil.VIVO, new Object[]{r100, r101}) == false) goto L17;
        return 4;
    L17:
        if (a("lenovo", new Object[]{r100, r101}) == false) goto L21;
        return 8;
    L21:
        if (a(DimLocationCheckUtil.XIAOMI, new Object[]{r100, r101}) == false) goto L24;
        return 16;
    L24:
        if (a("oneplus", new Object[]{r100, r101}) == false) goto L27;
        return 32;
    L27:
        return 0;
    L28:
        return 61440;
    }

    public static String d() {
        BufferedReader r100 = new BufferedReader(new PolarisFileReaderWrapper("/proc/version"), 256);     // Catch: IOException -> L16
        String r101 = r100.readLine();     // Catch: Throwable -> L13
        r100.close();     // Catch: IOException -> L16
        Matcher r102 = PatternProtector.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+(?:@[^\\s.]+)?)[^)]*\\)\\s+\\((?:[^(]*\\([^)]*\\))?[^)]*\\)\\s+([^\\s]+)\\s+(?:PREEMPT\\s+)?(.+)").matcher(r101);     // Catch: IOException -> L16
        if (r102.matches() == true) goto L9;
        return "Unavailable";
    L9:
        if (r102.groupCount() >= 4) goto L12;
        return "Unavailable";
    L12:
        return r102.group(1) + "\n" + r102.group(2) + " " + r102.group(3) + "\n" + r102.group(4);
    L13:
        th = move-exception;
        r100.close();     // Catch: IOException -> L16
        throw th;     // Catch: IOException -> L16
    L16:
        return "Unavailable";
    }

    public static String f() {
        return "Android " + Build.VERSION.RELEASE;
    }

    public static int a() {
        String r100 = com.alipay.sdk.m.s.b.d().c();
        if (TextUtils.isEmpty(r100) == true) goto L10;
        String r101 = r100.replaceAll(ContainerUtils.KEY_VALUE_DELIMITER, "");
        if (r101.length() < 5) goto L7;
        r101 = r101.substring(0, 5);
    L7:
        int r102 = (int) (a(r101) % 10000);
        if (r102 < 0) goto L13;
        return r102;
    L13:
        return r102 * (-1);
    L10:
        return -1;
    }

    public static String b() {
        if (EnvUtils.isSandBox() == true) goto L5;
        return com.alipay.sdk.m.j.a.f25359d.get(0).f25590a;
    L12:
        return f25868b;
    L5:
        if (TextUtils.equals("hk.alipay.wallet", ((com.alipay.sdk.m.m.a.b) ListProtector.get(com.alipay.sdk.m.j.a.f25359d, 0)).f25590a) == false) goto L8;
        return f25870d;
    L8:
        return f25871e;
    }

    public static String e() {
        String r100 = d();
        int r101 = r100.indexOf("-");
        if (r101 == (-1)) goto L5;
        r100 = r100.substring(0, r101);
    L5:
        int r102 = r100.indexOf("\n");
        if (r102 == (-1)) goto L9;
        r100 = r100.substring(0, r102);
    L9:
        return "Linux " + r100;
    }

    public static int g() {
        return Process.myUid();
    L4:
        th = move-exception;
        e.a(th);
        return -200;
    }

    public static boolean h() {
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L5;
        return true;
    L5:
        return false;
    }

    public n() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_alipay_sdk_m_u_n_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static String a(int r100) {
        Random r101 = new Random();
        StringBuilder r102 = new StringBuilder();
        int r103 = 0;
    L3:
        if (r103 >= r100) goto L16;
        int r104 = r101.nextInt(3);
        if (r104 != 0) goto L7;
        r102.append(String.valueOf((char) Math.round((Math.random() * 25.0d) + 65.0d)));
    L14:
        r103 = r103 + 1;
        goto L3
    L7:
        if (r104 != 1) goto L9;
        r102.append(String.valueOf((char) Math.round((Math.random() * 25.0d) + 97.0d)));
        goto L14
    L9:
        if (r104 != 2) goto L14;
        r102.append(String.valueOf(new Random().nextInt(10)));
        goto L14
    L16:
        return r102.toString();
    }

    public static Map<String, String> b(String r100) {
        HashMap r101 = new HashMap();
        String[] r102 = r100.split("&");
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L9;
        String r105 = r102[r104];
        int r106 = r105.indexOf(ContainerUtils.KEY_VALUE_DELIMITER, 1);
        if ((-1) == r106) goto L8;
        r101.put(r105.substring(0, r106), URLDecoder.decode(r105.substring(r106 + 1)));
    L8:
        r104 = r104 + 1;
        goto L3
    L9:
        return r101;
    }

    public static String c(String r100) {
        if (EnvUtils.isSandBox() == true) goto L5;
        return "com.eg.android.AlipayGphone.IAlixPay";
    L5:
        if (TextUtils.equals(r100, f25871e) == false) goto L10;
        return "com.eg.android.AlipayGphoneRC.IAlixPay";
    L10:
        return "com.eg.android.AlipayGphone.IAlixPay";
    }

    public static int d(String r100) {
        int r101 = 0;
    L4:
        if (r101 >= 64) goto L12;
        if (r100.equals(String.valueOf(f25876j[r101])) == true) goto L9;
        r101 = r101 + 1;
        goto L4
    L9:
        return r101;
    L12:
        return 0;
    }

    public static int e(String r100) {
        String r101 = com.alipay.sdk.m.m.a.D().j();     // Catch: Throwable -> L9
        int r102 = 0;
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return 0;
    L5:
        if (b(r101, "").contains(r100) == false) goto L13;
        r102 = 2;
    L13:
        return r102 | 1;
    L9:
        return 61440;
    }

    public static String f(Context r100) {
        DisplayMetrics r101 = d(r100);
        return r101.widthPixels + "*" + r101.heightPixels;
    }

    public static String g(Context r100) {
        return " (" + f() + i.f25853b + e() + i.f25853b + c(r100) + ";;" + f(r100) + ")(sdk android)";
    }

    public static boolean h(Context r100) {
        if (r100.getPackageManager().getPackageInfo(f25867a, 128) != null) goto L6;
        return false;
    L6:
        return true;
    L8:
        return false;
    }

    public static String i(String r100) {
        Uri r101 = Uri.parse(r100);     // Catch: Throwable -> L6
        return String.format("%s%s", new Object[]{r101.getAuthority(), r101.getPath()});
    L6:
        th = move-exception;
        e.a(th);
        return "-";
    }

    public static ActivityInfo a(Context r100) {
    L12:
        th = move-exception;
        e.a(th);
        return null;
    L4:
        if ((r100 instanceof Activity) == false) goto L11;
        Activity r101 = (Activity) r100;     // Catch: Throwable -> L12
        ActivityInfo[] r102 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 1).activities;     // Catch: Throwable -> L12
        int r103 = r102.length;     // Catch: Throwable -> L12
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L11;
        ActivityInfo r105 = r102[r104];     // Catch: Throwable -> L12
        if (TextUtils.equals(r105.name, r101.getClass().getName()) == true) goto L9;
        r104 = r104 + 1;
        goto L6
    L9:
        return r105;
    L11:
        return null;
    }

    public static boolean b(com.alipay.sdk.m.s.a r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (TextUtils.isEmpty(r100.f25775g) == true) goto L6;
        return r100.f25775g.toLowerCase().contains("auth");
    }

    public static String c(Context r100) {
        return r100.getResources().getConfiguration().locale.toString();
    }

    public static DisplayMetrics d(Context r100) {
        DisplayMetrics r101 = new DisplayMetrics();
        ((WindowManager) r100.getApplicationContext().getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay().getMetrics(r101);
        return r101;
    }

    public static String e(Context r100) {
        String r101 = m.b(r100);
        return r101.substring(0, r101.indexOf("://"));
    }

    public static boolean f(String r100) {
        return PatternProtector.compile("^http(s)?://([a-z0-9_\\-]+\\.)*(alipaydev|alipay|taobao)\\.(com|net)(:\\d+)?(/.*)?$").matcher(r100).matches();
    }

    public static String g(String r100) {
        return a(r100, true);
    }

    public static JSONObject h(String r100) {
        return new JSONObject(r100);
    L5:
        return new JSONObject();
    }

    public static JSONObject a(Intent r100) {
        JSONObject r101 = new JSONObject();
        if (r100 != null) goto L5;
        return r101;
    L5:
        Bundle r102 = r100.getExtras();
        if (r102 == null) goto L14;
        Iterator<String> r103 = r102.keySet().iterator();
    L9:
        if (r103.hasNext() == false) goto L14;
        String r104 = r103.next();
        r101.put(r104, String.valueOf(r102.get(r104)));     // Catch: Throwable -> L13
    L14:
        return r101;
    }

    public static int b(int r100) {
        return r100 / 100000;
    }

    public static String a(byte[] r100) {
        StringBuilder r101 = new StringBuilder(r100.length * 2);
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L6;
        byte r104 = r100[r103];
        r101.append(Character.forDigit((r104 & 240) >> 4, 16));
        r101.append(Character.forDigit(r104 & 15, 16));
        r103 = r103 + 1;
        goto L3
    L6:
        return r101.toString();
    }

    public static Map<String, String> a(JSONObject r100) {
        HashMap r101 = new HashMap();
        if (r100 != null) goto L5;
        return r101;
    L5:
        Iterator<String> r102 = r100.keys();
    L7:
        if (r102.hasNext() == false) goto L13;
        String r103 = r102.next();
        r101.put(r103, r100.optString(r103));     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        e.a(th);
        goto L7
    L13:
        return r101;
    }

    public static boolean a(PackageInfo r100) {
        if (r100 != null) goto L13;
        return false;
    L13:
        String r101 = r100.versionName;     // Catch: Throwable -> L12
        String[] r102 = f25873g;     // Catch: Throwable -> L12
        if (TextUtils.equals(r101, r102[0]) == true) goto L11;
        if (TextUtils.equals(r101, r102[1]) == true) goto L11;
        return false;
    L11:
        return true;
    L12:
        return false;
    }

    public static <T> T a(WeakReference<T> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.get();
    }

    public static String a(com.alipay.sdk.m.s.a r100) {
        return c(r100, "ro.build.fingerprint");
    }

    public static long a(String r100) {
        return a(r100, 6);
    }

    public static String a(com.alipay.sdk.m.s.a r110, Context r111) {
        String r100 = j.a(r110, r111, "alipay_cashier_ap_fi", "");     // Catch: Exception -> L17
        if (TextUtils.isEmpty(r100) == true) goto L20;
        return r100;
    L20:
        j.b(r110, r111, "alipay_cashier_ap_fi", com.alipay.sdk.m.h.a.a("FU", System.currentTimeMillis(), new com.alipay.sdk.m.h.d(), 0, new com.alipay.sdk.m.h.f()).a());     // Catch: Exception -> L13
        String r112 = j.a(r110, r111, "alipay_cashier_ap_fi", "");     // Catch: Exception -> L17
        if (TextUtils.isEmpty(r112) == true) goto L11;
        return r112;
    L11:
        com.alipay.sdk.m.k.a.b(r110, "biz", "e_regen_empty", "");     // Catch: Exception -> L17
        return "";
    L13:
        e = move-exception;
        com.alipay.sdk.m.k.a.b(r110, "biz", "e_gen", e.getClass().getSimpleName());     // Catch: Exception -> L17
        return "";
    L17:
        e = move-exception;
        com.alipay.sdk.m.k.a.a(r110, "biz", "e_gen_err", e);
        return "";
    }

    public static Map<String, String> b(com.alipay.sdk.m.s.a r100, String r110) {
        HashMap r101 = new HashMap(4);
        int r102 = r110.indexOf(63);
        if (r102 != (-1)) goto L5;
    L15:
        return r101;
    L5:
        if (r102 >= (r110.length() - 1)) goto L15;
        String[] r111 = r110.substring(r102 + 1).split("&");
        int r103 = r111.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L15;
        String r105 = r111[r104];
        int r106 = r105.indexOf(61, 1);
        if (r106 == (-1)) goto L14;
        if (r106 >= (r105.length() - 1)) goto L14;
        r101.put(r105.substring(0, r106), e(r100, r105.substring(r106 + 1)));
    L14:
        r104 = r104 + 1;
        goto L7
    }

    public static String c(com.alipay.sdk.m.s.a r100, String r101) {
    L7:
        e = move-exception;
        com.alipay.sdk.m.k.a.b(r100, "biz", "rflex", e.getClass().getSimpleName());
        return null;
    L5:
        return (String) INVOKESTATIC_com_alipay_sdk_m_u_n_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(null, new Object[]{r101});
    }

    private static String com_alipay_sdk_m_u_n_android_provider_Settings$Secure_getString(ContentResolver r110, String r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r110, r111};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, "java.lang.String", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, null, r112, false);
        return (String) r113.f474983b;
    L6:
        String r114 = Settings.Secure.getString(r110, r111);
        r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, r114, r112, true);
        return r114;
    }

    public static boolean d(com.alipay.sdk.m.s.a r100, String r101) {
        int r102 = e(r101);     // Catch: Throwable -> L11
        com.alipay.sdk.m.k.a.a(r100, "biz", "bindExt", "" + r102);     // Catch: Throwable -> L11
        if (com.alipay.sdk.m.m.a.D().o() == true) goto L8;
        return false;
    L8:
        if ((r102 & 2) != 2) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public static String e(com.alipay.sdk.m.s.a r100, String r101) {
        return URLDecoder.decode(r101, XML.CHARSET_UTF8);
    L4:
        e = move-exception;
        com.alipay.sdk.m.k.a.a(r100, "biz", com.alipay.sdk.m.k.b.B, e);
        return "";
    }

    public static long a(String r110, int r111) {
        int r112 = (int) Math.pow(2.0d, r111);
        int r100 = r110.length();
        long r101 = 0;
        int r102 = 0;
        int r103 = r100;
    L3:
        if (r102 >= r100) goto L5;
        int r104 = r102 + 1;
        r101 = r101 + (((long) CastIntegerProtector.parseInt(String.valueOf(d(r110.substring(r102, r104))))) * ((long) Math.pow(r112, r103 - 1)));
        r103 = r103 - 1;
        r102 = r104;
        goto L3
    L5:
        return r101;
    }

    public static String b(String r100, String r101) {
        String r102 = com_alipay_sdk_m_u_n_android_provider_Settings$Secure_getString(((Application) com.alipay.sdk.m.s.b.d().b()).getContentResolver(), r100);
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102;
    }

    public static String a(com.alipay.sdk.m.s.a r100, byte[] r101) {
        PublicKey r102 = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(r101))).getPublicKey();     // Catch: Exception -> L8
        if ((r102 instanceof RSAPublicKey) == false) goto L14;
        BigInteger r103 = ((RSAPublicKey) r102).getModulus();     // Catch: Exception -> L8
        if (r103 == null) goto L15;
        return r103.toString(16);
    L15:
        return null;
    L14:
        return null;
    L8:
        e = move-exception;
        com.alipay.sdk.m.k.a.a(r100, "auth", com.alipay.sdk.m.k.b.f25432x, e);
        return null;
    }

    public static String b(com.alipay.sdk.m.s.a r100, Context r101) {
        return a(r100, r101, r101.getPackageName());
    }

    public static String a(String r100, boolean r101) {
        MessageDigest r102 = MessageDigest.getInstance("SHA-256");     // Catch: NoSuchAlgorithmException -> L10
        r102.update(r100.getBytes());     // Catch: NoSuchAlgorithmException -> L10
        byte[] r103 = r102.digest();     // Catch: NoSuchAlgorithmException -> L10
        if (r101 == false) goto L9;
        if (r103.length <= 16) goto L9;
        byte[] r104 = new byte[16];     // Catch: NoSuchAlgorithmException -> L10
        System.arraycopy(r103, 0, r104, 0, 16);     // Catch: NoSuchAlgorithmException -> L10
        return a(r104);
    L9:
        return a(r103);
    L10:
        return "";
    }

    public static boolean a(com.alipay.sdk.m.s.a r100, PackageInfo r101) {
        boolean r102 = false;
        if (r101 != null) goto L5;
        String r103 = "info == null";
    L12:
        if (r102 == true) goto L14;
        com.alipay.sdk.m.k.a.b(r100, "auth", com.alipay.sdk.m.k.b.f25430w, r103);
    L14:
        return r102;
    L5:
        Signature[] r104 = r101.signatures;
        if (r104 != null) goto L9;
        r103 = "info.signatures == null";
        goto L12
    L9:
        if (r104.length > 0) goto L11;
        r103 = "info.signatures.length <= 0";
        goto L12
    L11:
        r103 = "";
        r102 = true;
        goto L12
    }

    public static boolean a(com.alipay.sdk.m.s.a r100, String r101) {
        String r102 = new URL(r101).getHost();     // Catch: Throwable -> L8
        if (r102.endsWith(com.alipay.sdk.m.l.a.B) == true) goto L6;
        if (r102.endsWith(com.alipay.sdk.m.l.a.C) == false) goto L15;
        return true;
    L15:
        return false;
    L6:
        return true;
    L8:
        th = move-exception;
        com.alipay.sdk.m.k.a.a(r100, "biz", "ckUrlErr", th);
        return false;
    }

    public static boolean a(Object r100, Object... r101) {
        if (r101 != null) goto L5;
    L18:
        if (r100 == null) goto L27;
        return false;
    L27:
        return true;
    L5:
        if (r101.length == 0) goto L18;
        int r102 = r101.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L17;
        Object r104 = r101[r103];
        if (r100 != null) goto L12;
        if (r104 != null) goto L12;
    L15:
        return true;
    L12:
        if (r100 == null) goto L16;
        if (r100.equals(r104) == true) goto L15;
    L16:
        r103 = r103 + 1;
        goto L8
    L17:
        return false;
    }

    public static String a(String r100, String r101) {
        return r100 + r101;
    }

    public static PackageInfo a(Context r100, String r101) throws PackageManager.NameNotFoundException {
        return r100.getPackageManager().getPackageInfo(r101, 192);
    }

    public static boolean a(com.alipay.sdk.m.s.a r100, String r101, Activity r110) {
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return true;
    L6:
        if (r110 != null) goto L9;
        return false;
    L9:
        if (r101.toLowerCase().startsWith(com.alipay.sdk.m.l.a.f25466n.toLowerCase()) == false) goto L11;
    L54:
        c r102 = a(r100, r110, com.alipay.sdk.m.j.a.f25359d);     // Catch: Throwable -> L52
        if (r102 == null) goto L51;
        if (r102.a() == true) goto L51;
        if (r102.a(r100) == true) goto L51;
        if (r101.startsWith("intent://platformapi/startapp") == false) goto L50;
        r101 = r101.replaceFirst("intent://platformapi/startapp\\?", com.alipay.sdk.m.l.a.f25466n);     // Catch: Throwable -> L52
    L50:
        r110.startActivity(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(r101)));     // Catch: Throwable -> L52
    L51:
        return true;
    L11:
        if (r101.toLowerCase().startsWith(com.alipay.sdk.m.l.a.f25467o.toLowerCase()) == true) goto L54;
        if (TextUtils.equals(r101, com.alipay.sdk.m.l.a.f25469q) == false) goto L16;
    L36:
        com.alipay.sdk.m.j.b.a(com.alipay.sdk.m.j.b.a());
        r110.finish();
        return true;
    L16:
        if (TextUtils.equals(r101, a("http", com.alipay.sdk.m.l.a.f25471s)) == true) goto L36;
        if (r101.startsWith(com.alipay.sdk.m.l.a.f25468p) == true) goto L53;
        return false;
    L53:
        String r103 = r101.substring(r101.indexOf(com.alipay.sdk.m.l.a.f25468p) + 24);     // Catch: Exception -> L32
        int r104 = CastIntegerProtector.parseInt(r103.substring(r103.lastIndexOf(com.alipay.sdk.m.l.a.f25472t) + 10));     // Catch: Exception -> L32
        if (r104 == com.alipay.sdk.m.j.c.f25362c.b()) goto L27;
        if (r104 == com.alipay.sdk.m.j.c.f25369j.b()) goto L27;
        com.alipay.sdk.m.j.c r105 = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.f25363d.b());     // Catch: Exception -> L32
        com.alipay.sdk.m.j.b.a(com.alipay.sdk.m.j.b.a(r105.b(), r105.a(), ""));     // Catch: Exception -> L32
    L33:
        r110.runOnUiThread(new a(r110));
        return true;
    L27:
        if (com.alipay.sdk.m.l.a.f25476x == false) goto L29;
        StringBuilder r106 = new StringBuilder();     // Catch: Exception -> L32
        String r107 = URLDecoder.decode(r101);     // Catch: Exception -> L32
        String r108 = URLDecoder.decode(r107);     // Catch: Exception -> L32
        String r109 = r108.substring(r108.indexOf(com.alipay.sdk.m.l.a.f25468p) + 24, r108.lastIndexOf(com.alipay.sdk.m.l.a.f25472t)).split(com.alipay.sdk.m.l.a.f25474v)[0];     // Catch: Exception -> L32
        int r111 = r107.indexOf(com.alipay.sdk.m.l.a.f25474v) + 12;     // Catch: Exception -> L32
        r106.append(r109);     // Catch: Exception -> L32
        r106.append(com.alipay.sdk.m.l.a.f25474v);     // Catch: Exception -> L32
        r106.append(r107.substring(r111, r107.indexOf("&", r111)));     // Catch: Exception -> L32
        r106.append(r107.substring(r107.indexOf("&", r111)));     // Catch: Exception -> L32
        String r112 = r106.toString();     // Catch: Exception -> L32
    L30:
        com.alipay.sdk.m.j.c r113 = com.alipay.sdk.m.j.c.b(r104);     // Catch: Exception -> L32
        com.alipay.sdk.m.j.b.a(com.alipay.sdk.m.j.b.a(r113.b(), r113.a(), r112));     // Catch: Exception -> L32
        goto L33
    L29:
        String r114 = URLDecoder.decode(r101);     // Catch: Exception -> L32
        r112 = r114.substring(r114.indexOf(com.alipay.sdk.m.l.a.f25468p) + 24, r114.lastIndexOf(com.alipay.sdk.m.l.a.f25472t));     // Catch: Exception -> L32
    L32:
        com.alipay.sdk.m.j.b.a(com.alipay.sdk.m.j.b.e());
        goto L33
    }

    public static boolean a(long r100, Runnable r101, String r102) {
        if (r101 != null) goto L5;
        return false;
    L5:
        ConditionVariable r103 = new ConditionVariable();
        PthreadThreadV2 r104 = new PthreadThreadV2(new b(r101, r103), "pay/sdk/m/u/n");
        if (TextUtils.isEmpty(r102) == true) goto L8;
        ThreadMethodProxy.setName(r104, r102);
    L8:
        ThreadMethodProxy.start(r104);
        if (r100 > 0) goto L17;
        r103.block();     // Catch: Throwable -> L15
        goto L13
    L17:
        return r103.block(r100);
    L13:
        return true;
    }

    public static c a(com.alipay.sdk.m.s.a r100, Context r101, List<com.alipay.sdk.m.m.a.b> r102) {
        if (r102 != null) goto L5;
        return null;
    L5:
        Iterator<com.alipay.sdk.m.m.a.b> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L18;
        com.alipay.sdk.m.m.a.b r104 = r103.next();
        if (r104 == null) goto L7;
        c r105 = a(r100, r101, r104.f25590a, r104.f25591b, r104.f25592c);
        if (r105 == null) goto L7;
        if (r105.a(r100) == true) goto L7;
        if (r105.a() == true) goto L7;
        return r105;
    L18:
        return null;
    }

    public static String a(String r100, String r101, String r102) {
        int r103 = r102.indexOf(r100) + r100.length();     // Catch: Throwable -> L16
        if (r103 > r100.length()) goto L7;
        return "";
    L7:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        int r104 = r102.indexOf(r101, r103);     // Catch: Throwable -> L16
    L11:
        if (r104 >= 1) goto L15;
        return r102.substring(r103);
    L15:
        return r102.substring(r103, r104);
    L9:
        r104 = 0;
    L16:
        return "";
    }

    public static String a(com.alipay.sdk.m.s.a r100, Context r101, String r102) {
        return r101.getPackageManager().getPackageInfo(r102, 128).versionName;
    L4:
        th = move-exception;
        com.alipay.sdk.m.k.a.a(r100, "biz", com.alipay.sdk.m.k.b.f25428v, th);
        return "";
    }

    public static c a(PackageInfo r100, int r101, String r102) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new c(r100, r101, r102);
    }

    public static boolean a(com.alipay.sdk.m.s.a r100, Context r101, List<com.alipay.sdk.m.m.a.b> r102, boolean r103) {
        Iterator<com.alipay.sdk.m.m.a.b> r104 = r102.iterator();     // Catch: Throwable -> L27
    L5:
        if (r104.hasNext() == false) goto L26;
        com.alipay.sdk.m.m.a.b r105 = r104.next();     // Catch: Throwable -> L27
        if (r105 == null) goto L5;
        String r106 = r105.f25590a;     // Catch: Throwable -> L27
        if (EnvUtils.isSandBox() == false) goto L33;
        if (f25868b.equals(r106) == false) goto L15;
        r106 = f25871e;
        goto L33
    L15:
        if ("hk.alipay.wallet".equals(r106) == false) goto L33;
        r106 = f25870d;
    L33:
        PackageInfo r107 = r101.getPackageManager().getPackageInfo(r106, 128);     // Catch: PackageManager.NameNotFoundException -> L30 Throwable -> L27
        if (r107 == null) goto L5;
        if (r103 == false) goto L24;
        com.alipay.sdk.m.k.a.a(r100, "biz", com.alipay.sdk.m.k.b.X, r107.packageName + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r107.versionName);     // Catch: PackageManager.NameNotFoundException -> L30 Throwable -> L27
        goto L5
    L43:
        return true;
    L24:
        return true;
    L26:
        return false;
    L27:
        th = move-exception;
        com.alipay.sdk.m.k.a.a(r100, "biz", com.alipay.sdk.m.k.b.f25403h0, th);
        return false;
    }

    public static void a(String r100, String r101, Context r102, com.alipay.sdk.m.s.a r103) {
        if (r102 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r101) == false) goto L9;
        return;
    L9:
        if (b(r103) == false) goto L12;
        return;
    L12:
        if (com.alipay.sdk.m.m.a.D().v() == true) goto L19;
        return;
    L19:
        Intent r104 = new Intent(com.alipay.sdk.m.l.b.f25490l);     // Catch: Exception -> L18
        r104.putExtra("bizType", r100);     // Catch: Exception -> L18
        r104.putExtra("exName", r101);     // Catch: Exception -> L18
        r104.setPackage(r102.getPackageName());     // Catch: Exception -> L18
        r102.sendBroadcast(r104);     // Catch: Exception -> L18
        com.alipay.sdk.m.k.a.a(r103, "biz", "AppNotify", r100 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r101);     // Catch: Exception -> L18
        return;
    }

    public static c a(com.alipay.sdk.m.s.a r100, Context r101, String r102, int r103, String r104) {
        if (EnvUtils.isSandBox() == false) goto L20;
        if (f25868b.equals(r102) == false) goto L8;
        r102 = f25871e;
        goto L20
    L8:
        if ("hk.alipay.wallet".equals(r102) == false) goto L20;
        r102 = f25870d;
    L20:
        PackageInfo r105 = a(r101, r102);     // Catch: Throwable -> L13
    L16:
        if (a(r100, r105) == true) goto L19;
        return null;
    L19:
        return a(r105, r103, r104);
    L13:
        th = move-exception;
        com.alipay.sdk.m.k.a.b(r100, "auth", com.alipay.sdk.m.k.b.f25428v, th.getMessage());
        r105 = null;
        goto L16
    }
}
