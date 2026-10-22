package com.alipay.sdk.m.a0;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.crypto.platform.PlatformConst;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.sva.sdk.data.SettingsDAO;
import com.ss.android.lark.camera_export.CameraParam;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.ttvideoengine.net.DNSParser;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import faceverify.w;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f25222b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f25223a;

    static {
        f25222b = new b();
    }

    public b() {
    }

    public static b a(f r100) {
        b r101 = f25222b;
        r101.f25223a = r100;
        return r101;
    }

    public static boolean a(Context r100, String r101) {
        if (r100.getPackageManager().checkPermission(r101, r100.getPackageName()) != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        return true;
    L8:
        return false;
    L5:
        r102 = false;
        goto L6
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static String b() {
        StatFs r100 = new StatFs(Environment.getDataDirectory().getPath());     // Catch: Throwable -> L4
        long r101 = ((long) r100.getAvailableBlocks()) * r100.getBlockSize();
    L6:
        return String.valueOf(r101);
    L4:
        r101 = 0;
        goto L6
    }

    public static String c() {
        StatFs r100 = new StatFs("/sdcard");     // Catch: Throwable -> L4
        long r101 = r100.getBlockSize() * ((long) r100.getAvailableBlocks());
    L6:
        return String.valueOf(r101);
    L4:
        r101 = 0;
        goto L6
    }

    public static String d() {
        String r100 = "0000000000000000";
        LineNumberReader r101 = null;
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper("/proc/cpuinfo"));     // Catch: Throwable -> L22
        InputStreamReader r103 = new InputStreamReader(r102);     // Catch: Throwable -> L21
        LineNumberReader r104 = new LineNumberReader(r103);     // Catch: Throwable -> L20
        int r105 = 1;
    L8:
        if (r105 >= 100) goto L52;
        String r106 = r104.readLine();     // Catch: Throwable -> L16
        if (r106 == null) goto L52;
        if (r106.indexOf("Serial") >= 0) goto L13;
        r105 = r105 + 1;
        goto L8
    L13:
        r100 = r106.substring(r106.indexOf(":") + 1, r106.length()).trim();     // Catch: Throwable -> L16
    L16:
        r101 = r104;
    L52:
        r104.close();     // Catch: Throwable -> L38
    L48:
        r103.close();     // Catch: Throwable -> L39
    L50:
        r102.close();     // Catch: Throwable -> L34
    L35:
        if (r100 != null) goto L59;
        return "";
    L59:
        return r100;
    L23:
        if (r101 != null) goto L54;
    L27:
        if (r103 != null) goto L42;
    L31:
        if (r102 == null) goto L35;
    L42:
        r103.close();     // Catch: Throwable -> L30
        goto L31
    L54:
        r101.close();     // Catch: Throwable -> L26
    L21:
        r103 = null;
    L22:
        r102 = null;
        r103 = null;
        goto L23
    }

    public static String e() {
        String r100 = t();
        if (com.alipay.sdk.m.z.a.a(r100) == true) goto L6;
        return r100;
    L6:
        return u();
    }

    public static String f() {
        PolarisFileReaderWrapper r100 = null;
        PolarisFileReaderWrapper r101 = new PolarisFileReaderWrapper("/proc/cpuinfo");     // Catch: Throwable -> L18
        BufferedReader r102 = new BufferedReader(r101);     // Catch: Throwable -> L16
        String[] r103 = r102.readLine().split(":\\s+", 2);     // Catch: Throwable -> L15
        if (r103 != null) goto L8;
    L41:
        r101.close();     // Catch: Throwable -> L29
    L45:
        r102.close();     // Catch: Throwable -> L30
        return "";
    L48:
        return "";
    L8:
        if (r103.length <= 1) goto L41;
        String r104 = r103[1];     // Catch: Throwable -> L15
        r101.close();     // Catch: Throwable -> L27
    L35:
        r102.close();     // Catch: Throwable -> L28
    L12:
        return r104;
    L17:
        r100 = r101;
    L19:
        if (r100 != null) goto L37;
    L23:
        if (r102 != null) goto L45;
        return "";
    L37:
        r100.close();     // Catch: Throwable -> L22
    L16:
        r102 = null;
    L18:
        r102 = null;
        goto L19
    }

    public static String f(Context r100) {
        int r101 = 0;
        r101 = Settings.System.getInt(r100.getContentResolver(), "airplane_mode_on", 0);     // Catch: Throwable -> L5
    L7:
        if (r101 != 1) goto L10;
        return "1";
    L10:
        return "0";
    }

    public static String g() {
        long r100 = 0;
        PolarisFileReaderWrapper r101 = null;
        PolarisFileReaderWrapper r102 = new PolarisFileReaderWrapper("/proc/meminfo");     // Catch: Throwable -> L14
        BufferedReader r103 = new BufferedReader(r102, 8192);     // Catch: Throwable -> L12
        String r104 = r103.readLine();     // Catch: Throwable -> L11
        if (r104 == null) goto L29;
        r100 = Integer.parseInt(r104.split("\\s+")[1]);     // Catch: Throwable -> L11
    L29:
        r102.close();     // Catch: Throwable -> L23
    L33:
        r103.close();     // Catch: Throwable -> L24
    L22:
        return String.valueOf(r100);
    L13:
        r101 = r102;
    L15:
        if (r101 != null) goto L25;
    L19:
        if (r103 == null) goto L22;
    L25:
        r101.close();     // Catch: Throwable -> L18
    L12:
        r103 = null;
    L14:
        r103 = null;
        goto L15
    }

    public static String g(Context r100) {
        JSONObject r101 = new JSONObject();
        AudioManager r102 = (AudioManager) r100.getSystemService("audio");     // Catch: Throwable -> L22
        if (r102.getRingerMode() != 0) goto L6;
        int r103 = 1;
    L7:
        int r104 = r102.getStreamVolume(0);     // Catch: Throwable -> L22
        int r105 = r102.getStreamVolume(1);     // Catch: Throwable -> L22
        int r106 = r102.getStreamVolume(2);     // Catch: Throwable -> L22
        int r107 = r102.getStreamVolume(3);     // Catch: Throwable -> L22
        int r108 = r102.getStreamVolume(4);     // Catch: Throwable -> L22
        r101.put("ringermode", String.valueOf(r103));     // Catch: Throwable -> L22
        r101.put(NotificationCompat.CATEGORY_CALL, String.valueOf(r104));     // Catch: Throwable -> L22
        r101.put(CameraParam.TYPE_SYSTEM_CAMERA, String.valueOf(r105));     // Catch: Throwable -> L22
        r101.put("ring", String.valueOf(r106));     // Catch: Throwable -> L22
        r101.put("music", String.valueOf(r107));     // Catch: Throwable -> L22
        r101.put("alarm", String.valueOf(r108));     // Catch: Throwable -> L22
        goto L21
    L6:
        r103 = 0;
    L21:
        return r101.toString();
    }

    public static String h() {
        StatFs r100 = new StatFs(Environment.getDataDirectory().getPath());     // Catch: Throwable -> L4
        long r101 = ((long) r100.getBlockCount()) * r100.getBlockSize();
    L6:
        return String.valueOf(r101);
    L4:
        r101 = 0;
        goto L6
    }

    public static String h(Context r100) {
        if (r100 != null) goto L20;
    L15:
        String r101 = null;
    L16:
        if (r101 != null) goto L23;
        return "";
    L23:
        return r101;
    L20:
        SensorManager r102 = (SensorManager) r100.getSystemService(w.BLOB_ELEM_TYPE_SENSOR);     // Catch: Throwable -> L19
        if (r102 == null) goto L15;
        List<Sensor> r103 = r102.getSensorList(-1);     // Catch: Throwable -> L19
        if (r103 == null) goto L15;
        if (r103.size() <= 0) goto L15;
        StringBuilder r104 = new StringBuilder();     // Catch: Throwable -> L19
        Iterator<Sensor> r105 = r103.iterator();     // Catch: Throwable -> L19
    L11:
        if (r105.hasNext() == false) goto L13;
        Sensor r106 = r105.next();     // Catch: Throwable -> L19
        r104.append(r106.getName());     // Catch: Throwable -> L19
        r104.append(r106.getVersion());     // Catch: Throwable -> L19
        r104.append(r106.getVendor());     // Catch: Throwable -> L19
        goto L11
    L13:
        r101 = com.alipay.sdk.m.z.a.e(r104.toString());     // Catch: Throwable -> L19
        goto L16
    }

    public static String i() {
        StatFs r100 = new StatFs("/sdcard");     // Catch: Throwable -> L4
        long r101 = r100.getBlockSize() * ((long) r100.getBlockCount());
    L6:
        return String.valueOf(r101);
    L4:
        r101 = 0;
        goto L6
    }

    public static String i(Context r100) {
        JSONArray r101 = new JSONArray();
        if (r100 == null) goto L24;
        SensorManager r102 = (SensorManager) r100.getSystemService(w.BLOB_ELEM_TYPE_SENSOR);     // Catch: Throwable -> L25
        if (r102 == null) goto L24;
        List<Sensor> r103 = r102.getSensorList(-1);     // Catch: Throwable -> L25
        if (r103 == null) goto L24;
        if (r103.size() <= 0) goto L24;
        Iterator<Sensor> r104 = r103.iterator();     // Catch: Throwable -> L25
    L12:
        if (r104.hasNext() == false) goto L24;
        Sensor r105 = r104.next();     // Catch: Throwable -> L25
        if (r105 == null) goto L12;
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L25
        r106.put("name", r105.getName());     // Catch: Throwable -> L25
        r106.put("version", r105.getVersion());     // Catch: Throwable -> L25
        r106.put(Constants.OperatorKey.KEY_VENDOR, r105.getVendor());     // Catch: Throwable -> L25
        r101.put(r106);     // Catch: Throwable -> L25
    L24:
        return r101.toString();
    }

    public static String j() {
        Class r100 = INVOKESTATIC_com_alipay_sdk_m_a0_b_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Throwable -> L7
        Object r101 = r100.newInstance();     // Catch: Throwable -> L7
        String r102 = (String) r100.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(r101, new Object[]{"gsm.version.baseband", "no message"});     // Catch: Throwable -> L7
    L8:
        if (r102 != null) goto L11;
        return "";
    L11:
        return r102;
    L7:
        r102 = "";
        goto L8
    }

    public static String j(Context r100) {
        DisplayMetrics r101 = INVOKEVIRTUAL_com_alipay_sdk_m_a0_b_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources());     // Catch: Throwable -> L4
        return Integer.toString(r101.widthPixels) + "*" + Integer.toString(r101.heightPixels);
    L4:
        return "";
    }

    public static String k() {
        String r100 = Locale.getDefault().toString();     // Catch: Throwable -> L5
    L6:
        if (r100 != null) goto L9;
        return "";
    L9:
        return r100;
    L5:
        r100 = "";
        goto L6
    }

    public static String k(Context r100) {
        DisplayMetrics r101 = INVOKEVIRTUAL_com_alipay_sdk_m_a0_b_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources());     // Catch: Throwable -> L4
        StringBuilder r102 = new StringBuilder();     // Catch: Throwable -> L4
        r102.append(r101.widthPixels);     // Catch: Throwable -> L4
        return r102.toString();
    L4:
        return "";
    }

    public static String l() {
        String r100 = TimeZone.getDefault().getDisplayName(false, 0);     // Catch: Throwable -> L5
    L6:
        if (r100 != null) goto L9;
        return "";
    L9:
        return r100;
    L5:
        r100 = "";
        goto L6
    }

    public static String l(Context r100) {
        DisplayMetrics r101 = INVOKEVIRTUAL_com_alipay_sdk_m_a0_b_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources());     // Catch: Throwable -> L4
        StringBuilder r102 = new StringBuilder();     // Catch: Throwable -> L4
        r102.append(r101.heightPixels);     // Catch: Throwable -> L4
        return r102.toString();
    L4:
        return "";
    }

    public static String m() {
        long r100 = System.currentTimeMillis() - SystemClock.elapsedRealtime();     // Catch: Throwable -> L4
        StringBuilder r101 = new StringBuilder();     // Catch: Throwable -> L4
        r101.append(r100 - (r100 % 1000));     // Catch: Throwable -> L4
        return r101.toString();
    L4:
        return "";
    }

    public static String m(Context r100) {
        TelephonyManager r101 = (TelephonyManager) r100.getSystemService("phone");     // Catch: Throwable -> L8
        if (r101 == null) goto L6;
        return String.valueOf(r101.getNetworkType());
    L6:
        return "";
    L11:
        return "";
    }

    public static String n() {
        StringBuilder r100 = new StringBuilder();     // Catch: Throwable -> L4
        r100.append(SystemClock.elapsedRealtime());     // Catch: Throwable -> L4
        return r100.toString();
    L4:
        return "";
    }

    public static String n(Context r100) {
        int r101 = r100.getApplicationInfo().targetSdkVersion;
        int r102 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L13
        if (r102 >= 29) goto L14;
        if (r102 >= 26) goto L9;
    L11:
        String r103 = com_alipay_sdk_m_a0_b_android_os_Build_SERIAL();     // Catch: Throwable -> L13
    L15:
        if (r103 != null) goto L18;
        return "";
    L18:
        return r103;
    L9:
        if (r101 < 28) goto L11;
        r103 = com_alipay_sdk_m_a0_b_android_os_Build_getSerial();     // Catch: Throwable -> L13
    L14:
        r103 = "";
        goto L15
    }

    public static String o() {
        StringBuilder r100 = new StringBuilder();     // Catch: Throwable -> L13
        String[] r101 = {"/dev/qemu_pipe", "/dev/socket/qemud", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/genyd", "/dev/socket/baseband_genyd"};     // Catch: Throwable -> L13
        r100.append("00:");     // Catch: Throwable -> L13
        int r102 = 0;
    L4:
        if (r102 >= 7) goto L11;
        if (new PolarisFileWrapper(r101[r102]).exists() == false) goto L9;
        String r103 = "1";
    L8:
        r100.append(r103);     // Catch: Throwable -> L13
        r102 = r102 + 1;     // Catch: Throwable -> L13
        goto L4
    L9:
        r103 = "0";
        goto L8
    L11:
        return r100.toString();
    L13:
        return "";
    }

    public static String o(Context r100) {
    L16:
        return "";
    L3:
        if (((KeyguardManager) r100.getSystemService("keyguard")).isKeyguardSecure() == true) goto L6;
        return "0:0";
    L6:
        String[] r101 = {"/data/system/password.key", "/data/system/gesture.key", "/data/system/gatekeeper.password.key", "/data/system/gatekeeper.gesture.key", "/data/system/gatekeeper.pattern.key"};     // Catch: Throwable -> L16
        long r102 = 0;
        int r103 = 0;
    L8:
        if (r103 >= 5) goto L14;
        long r104 = new PolarisFileWrapper(r101[r103]).lastModified();     // Catch: Throwable -> L12
    L13:
        r102 = Math.max(r104, r102);     // Catch: Throwable -> L16
        r103 = r103 + 1;     // Catch: Throwable -> L16
    L12:
        r104 = -1;
        goto L13
    L14:
        return "1:" + r102;
    }

    public static String p() {
        String[] r100 = {"dalvik.system.Taint"};
        StringBuilder r101 = new StringBuilder("00:");
        int r102 = 0;
    L3:
        if (r102 > 0) goto L10;
        INVOKESTATIC_com_alipay_sdk_m_a0_b_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100[0]);     // Catch: Throwable -> L7
        r101.append("1");     // Catch: Throwable -> L7
    L8:
        r102 = r102 + 1;
    L7:
        r101.append("0");
        goto L8
    L10:
        return r101.toString();
    }

    public static String p(Context r100) {
        Intent r101 = INVOKEVIRTUAL_com_alipay_sdk_m_a0_b_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));     // Catch: Throwable -> L15
        int r102 = r101.getIntExtra("level", -1);     // Catch: Throwable -> L15
        int r103 = r101.getIntExtra("status", -1);     // Catch: Throwable -> L15
        if (r103 != 2) goto L5;
    L8:
        boolean r104 = true;
    L9:
        StringBuilder r105 = new StringBuilder();     // Catch: Throwable -> L15
        if (r104 == false) goto L12;
        String r106 = "1";
    L13:
        r105.append(r106);     // Catch: Throwable -> L15
        r105.append(":");     // Catch: Throwable -> L15
        r105.append(r102);     // Catch: Throwable -> L15
        return r105.toString();
    L12:
        r106 = "0";
        goto L13
    L5:
        if (r103 == 5) goto L8;
        r104 = false;
    L15:
        return "";
    }

    public static String q() {
        StringBuilder r100 = new StringBuilder("00:");
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("/system/build.prop", "ro.product.name=sdk");
        r101.put("/proc/tty/drivers", "goldfish");
        r101.put("/proc/cpuinfo", "goldfish");
        Iterator r102 = r101.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L22;
        String r103 = (String) r102.next();
        char r104 = '0';
        LineNumberReader r105 = new LineNumberReader(new InputStreamReader(new PolarisFileInputStreamWrapper(r103)));     // Catch: Throwable -> L16
    L23:
        String r106 = r105.readLine();     // Catch: Throwable -> L15
        if (r106 == null) goto L12;
        if (r106.toLowerCase().contains((CharSequence) r101.get(r103)) == false) goto L23;
        r104 = '1';
    L12:
        r100.append(r104);
    L27:
        r105.close();     // Catch: Throwable -> L20
    L17:
        r100.append('0');
        if (r105 == null) goto L4;
    L16:
        r105 = null;
        goto L17
    L22:
        return r100.toString();
    }

    public static String q(Context r100) {
        if (a(r100, "android.permission.ACCESS_NETWORK_STATE") == false) goto L54;
        return "";
    L54:
        NetworkInfo r101 = ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L53
        if (r101 != null) goto L12;
        return null;
    L12:
        if (r101.getType() != 1) goto L15;
        return "WIFI";
    L15:
        if (r101.getType() != 0) goto L58;
        int r102 = r101.getSubtype();     // Catch: Throwable -> L53
        if (r102 == 4) goto L51;
        if (r102 == 1) goto L51;
        if (r102 == 2) goto L51;
        if (r102 == 7) goto L51;
        if (r102 == 11) goto L51;
        if (r102 != 3) goto L30;
    L50:
        return "3G";
    L30:
        if (r102 == 5) goto L50;
        if (r102 == 6) goto L50;
        if (r102 == 8) goto L50;
        if (r102 == 9) goto L50;
        if (r102 == 10) goto L50;
        if (r102 == 12) goto L50;
        if (r102 == 14) goto L50;
        if (r102 == 15) goto L50;
        if (r102 != 13) goto L49;
        return "4G";
    L49:
        return "UNKNOW";
    L51:
        return "2G";
    L58:
        return null;
    L62:
        return null;
    }

    public static String r() {
        StringBuilder r100 = new StringBuilder("00:");
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("BRAND", "generic");
        r101.put("BOARD", "unknown");
        r101.put(FeatureConfigInfo.DEVICE_FEATURE_TYPE_ID, "generic");
        r101.put("HARDWARE", "goldfish");
        r101.put("PRODUCT", "sdk");
        r101.put("MODEL", "sdk");
        Iterator r102 = r101.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L15;
        String r103 = (String) r102.next();
        char r104 = '0';
        String r105 = null;
        String r106 = (String) Build.class.getField(r103).get(null);     // Catch: Throwable -> L16
        String r107 = (String) r101.get(r103);     // Catch: Throwable -> L16
        if (r106 == null) goto L9;
        r105 = r106.toLowerCase();     // Catch: Throwable -> L16
    L9:
        if (r105 == null) goto L13;
        if (r105.contains(r107) == false) goto L13;
        r104 = '1';
    L13:
        r100.append(r104);
        goto L4
    L15:
        return r100.toString();
    }

    public static String s() {
        StringBuilder r100 = new StringBuilder("00:");
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put(SettingsDAO.HARDWARE, "goldfish");
        r101.put("ro.kernel.qemu", "1");
        r101.put("ro.product.device", "generic");
        r101.put("ro.product.model", "sdk");
        r101.put("ro.product.brand", "generic");
        r101.put("ro.product.name", "sdk");
        r101.put("ro.build.fingerprint", "test-keys");
        r101.put(PlatformConst.PROP_MANUFACTURER, "unknow");
        Iterator r102 = r101.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L13;
        String r103 = (String) r102.next();
        String r104 = (String) r101.get(r103);
        String r105 = com.alipay.sdk.m.z.a.b(r103, "");
        if (r105 != null) goto L8;
    L10:
        char r106 = '0';
    L11:
        r100.append(r106);
        goto L4
    L8:
        if (r105.contains(r104) == false) goto L10;
        r106 = '1';
        goto L11
    L13:
        return r100.toString();
    }

    public static String t() {
        BufferedReader r100 = null;
        PolarisFileReaderWrapper r101 = new PolarisFileReaderWrapper("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");     // Catch: Throwable -> L15
        BufferedReader r102 = new BufferedReader(r101, 8192);     // Catch: Throwable -> L14
        String r103 = r102.readLine();     // Catch: Throwable -> L13
        if (com.alipay.sdk.m.z.a.a(r103) == true) goto L34;
        String r104 = r103.trim();     // Catch: Throwable -> L13
        r102.close();     // Catch: Throwable -> L24
    L30:
        r101.close();     // Catch: Throwable -> L25
    L10:
        return r104;
    L34:
        r102.close();     // Catch: Throwable -> L26
    L38:
        r101.close();     // Catch: Throwable -> L27
        return "";
    L45:
        return "";
    L13:
        r100 = r102;
    L16:
        if (r100 != null) goto L32;
    L20:
        if (r101 != null) goto L38;
        return "";
    L32:
        r100.close();     // Catch: Throwable -> L19
    L15:
        r101 = null;
        goto L16
    }

    public static String u() {
        String r100 = "";
        PolarisFileReaderWrapper r101 = null;
        PolarisFileReaderWrapper r102 = new PolarisFileReaderWrapper("/proc/cpuinfo");     // Catch: Throwable -> L21
        BufferedReader r103 = new BufferedReader(r102, 8192);     // Catch: Throwable -> L19
    L39:
        String r104 = r103.readLine();     // Catch: Throwable -> L18
        if (r104 != null) goto L8;
    L41:
        r102.close();     // Catch: Throwable -> L29
    L33:
        r103.close();     // Catch: Throwable -> L30
    L28:
        return r100;
    L8:
        if (com.alipay.sdk.m.z.a.a(r104) == true) goto L39;
        String[] r105 = r104.split(":");     // Catch: Throwable -> L18
        if (r105 == null) goto L39;
        if (r105.length <= 1) goto L39;
        if (r105[0].contains("BogoMIPS") == false) goto L39;
        r100 = r105[1].trim();     // Catch: Throwable -> L18
    L20:
        r101 = r102;
    L22:
        if (r101 != null) goto L37;
    L26:
        if (r103 == null) goto L28;
    L37:
        r101.close();     // Catch: Throwable -> L25
    L19:
        r103 = null;
    L21:
        r103 = null;
        goto L22
    }

    private String v() {
        String r100 = d.a(DNSParser.DNS_RESULT_IP);
        if (r100 == null) goto L5;
        return r100;
    L5:
        String r101 = "";
        if (this.f25223a.isBackgroundRunning() == false) goto L27;
        return "";
    L27:
        Enumeration<NetworkInterface> r102 = NetworkInterface.getNetworkInterfaces();     // Catch: Throwable -> L21
    L10:
        if (r102.hasMoreElements() == false) goto L22;
        if (r100 != null) goto L22;
        Enumeration<InetAddress> r103 = r102.nextElement().getInetAddresses();     // Catch: Throwable -> L21
    L14:
        if (r103.hasMoreElements() == false) goto L10;
        InetAddress r104 = r103.nextElement();     // Catch: Throwable -> L21
        if (r104.isLoopbackAddress() == true) goto L14;
        if ((r104 instanceof Inet4Address) == false) goto L14;
        r100 = r104.getHostAddress().toString();     // Catch: Throwable -> L21
    L22:
        if (r100 == null) goto L25;
        r101 = r100;
    L25:
        d.a(DNSParser.DNS_RESULT_IP, r101);
        return r101;
    }

    public final String a() {
        return String.valueOf(new PolarisFileWrapper("/sys/devices/system/cpu/").listFiles(new c(this)).length);
    L4:
        return "1";
    }

    public final synchronized String a(Context r100) {
        monitor-enter(this);
        String r101 = this.f25223a.getSubscriberId();     // Catch: Throwable -> L32
        if (r101 == null) goto L7;
        monitor-exit(this);
        return r101;
    L7:
        String r102 = d.a("imsi");     // Catch: Throwable -> L32
        if (r102 == null) goto L12;
        monitor-exit(this);
        return r102;
    L12:
        if (this.f25223a.isBackgroundRunning() == false) goto L17;
        monitor-exit(this);
        return "";
    L17:
        if (a(r100, "android.permission.READ_PHONE_STATE") == true) goto L19;
        if (r100 != null) goto L37;
    L27:
        if (r102 != null) goto L29;
        r102 = "";
    L29:
        d.a("imsi", r102);     // Catch: Throwable -> L32
        monitor-exit(this);
        return r102;
    L37:
        TelephonyManager r103 = (TelephonyManager) r100.getSystemService("phone");     // Catch: Throwable -> L26
        if (r103 == null) goto L27;
        r102 = com_alipay_sdk_m_a0_b_android_telephony_TelephonyManager_getSubscriberId(r103);     // Catch: Throwable -> L26
        goto L27
    L19:
        monitor-exit(this);
        return "";
    L32:
        th = move-exception;
        throw th;
    }

    public final synchronized String b(Context r100) {
        monitor-enter(this);
        String r101 = d.a("NetworkOperatorName");     // Catch: Throwable -> L20
        if (r101 == null) goto L7;
        monitor-exit(this);
        return r101;
    L7:
        if (r100 != null) goto L25;
    L13:
        if (r101 != null) goto L15;
    L16:
        r101 = "";
    L17:
        d.a("NetworkOperatorName", r101);     // Catch: Throwable -> L20
        monitor-exit(this);
        return r101;
    L15:
        if ("null".equals(r101) == false) goto L17;
    L25:
        TelephonyManager r102 = (TelephonyManager) r100.getSystemService("phone");     // Catch: Throwable -> L12
        if (r102 == null) goto L13;
        r101 = r102.getNetworkOperatorName();     // Catch: Throwable -> L12
    L20:
        th = move-exception;
        throw th;
    }

    public final synchronized String c(Context r100) {
        monitor-enter(this);
        String r101 = d.a("SimSerial");     // Catch: Throwable -> L25
        if (r101 == null) goto L8;
        monitor-exit(this);
        return r101;
    L8:
        if (this.f25223a.isBackgroundRunning() == false) goto L13;
        monitor-exit(this);
        return "";
    L13:
        if (a(r100, "android.permission.READ_PHONE_STATE") == true) goto L15;
        r101 = com_alipay_sdk_m_a0_b_android_telephony_TelephonyManager_getSimSerialNumber((TelephonyManager) r100.getSystemService("phone"));     // Catch: Throwable -> L28
        if (r101 == null) goto L21;
        if (r101.length() != 0) goto L22;
    L21:
        r101 = "";
    L22:
        d.a("SimSerial", r101);     // Catch: Throwable -> L25
        monitor-exit(this);
        return r101;
    L15:
        monitor-exit(this);
        return "";
    L25:
        th = move-exception;
        throw th;
    }

    public final synchronized String d(Context r100) {
        monitor-enter(this);
        String r101 = this.f25223a.getAndroidId();     // Catch: Throwable -> L24
        if (r101 == null) goto L7;
        monitor-exit(this);
        return r101;
    L7:
        String r102 = d.a("ANDROIDID");     // Catch: Throwable -> L24
        if (r102 == null) goto L12;
        monitor-exit(this);
        return r102;
    L12:
        if (this.f25223a.isBackgroundRunning() == true) goto L14;
        r102 = com_alipay_sdk_m_a0_b_android_provider_Settings$Secure_getString(r100.getContentResolver(), "android_id");     // Catch: Throwable -> L18
    L19:
        if (r102 != null) goto L21;
        r102 = "";
    L21:
        d.a("ANDROIDID", r102);     // Catch: Throwable -> L24
        monitor-exit(this);
        return r102;
    L14:
        monitor-exit(this);
        return "";
    L24:
        th = move-exception;
        throw th;
    }

    public final String e(Context r100) {
        String r101 = q(r100);     // Catch: Throwable -> L10
        String r102 = v();     // Catch: Throwable -> L10
        if (com.alipay.sdk.m.z.a.b(r101) == false) goto L8;
        if (com.alipay.sdk.m.z.a.b(r102) == false) goto L8;
        return r101 + ":" + v();
    L8:
        return "";
    }

    private static String com_alipay_sdk_m_a0_b_android_os_Build_SERIAL() {
        ArrayList r100 = new ArrayList();
        Object[] r110 = new Object[0];
        f06.b r111 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(102002);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r103 = r102;
        int r104 = r103.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r103[r105];
        int r112 = r105;
        int r113 = r104;
        f06.a[] r114 = r103;
        f06.d r107 = r106.preInvoke(102002, "android/os/Build", "SERIAL", Build.class, r110, "java.lang.String", r111);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (String) r107.f474983b;
    L21:
        return Build.SERIAL;
    L14:
        r105 = r112 + 1;
        r104 = r113;
        r103 = r114;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    private static String com_alipay_sdk_m_a0_b_android_os_Build_getSerial() {
        ArrayList r100 = new ArrayList();
        Object[] r110 = new Object[0];
        f06.b r111 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(101200);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r103 = r102;
        int r104 = r103.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r103[r105];
        int r112 = r105;
        int r113 = r104;
        f06.a[] r114 = r103;
        f06.d r107 = r106.preInvoke(101200, "android/os/Build", "getSerial", Build.class, r110, "java.lang.String", r111);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (String) r107.f474983b;
    L21:
        return Build.getSerial();
    L14:
        r105 = r112 + 1;
        r104 = r113;
        r103 = r114;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_alipay_sdk_m_a0_b_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static DisplayMetrics INVOKEVIRTUAL_com_alipay_sdk_m_a0_b_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private static String com_alipay_sdk_m_a0_b_android_telephony_TelephonyManager_getSimSerialNumber(TelephonyManager r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        f06.d r112 = r100.b(101400, "android/telephony/TelephonyManager", "getSimSerialNumber", r110, r101, "java.lang.String", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(101400, "android/telephony/TelephonyManager", "getSimSerialNumber", r110, r101, null, r111, false);
        return (String) r112.f474983b;
    L6:
        String r113 = r110.getSimSerialNumber();
        r100.a(101400, "android/telephony/TelephonyManager", "getSimSerialNumber", r110, r101, r113, r111, true);
        return r113;
    }

    private static String com_alipay_sdk_m_a0_b_android_telephony_TelephonyManager_getSubscriberId(TelephonyManager r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(101900);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        f06.d r106 = r105.preInvoke(101900, "android/telephony/TelephonyManager", "getSubscriberId", r110, r111, "java.lang.String", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return (String) r106.f474983b;
    L21:
        return r110.getSubscriberId();
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    private static String com_alipay_sdk_m_a0_b_android_provider_Settings$Secure_getString(ContentResolver r110, String r111) {
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

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_alipay_sdk_m_a0_b_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(r101, r110);
    }
}
