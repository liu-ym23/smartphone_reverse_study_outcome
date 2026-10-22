package com.bytedance.android.ec.core.cps;

import android.content.Context;
import android.media.MediaDrm;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.util.Base64;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.bpea.cert.token.TokenCert;
import java.io.File;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Locale;
import java.util.UUID;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes43.dex */
public final class c {
    public static final boolean a(String r100) {
        if (r100.length() < 2) goto L10;
        String r101 = r100.substring(0, 1);
        String r102 = r100.substring(1);
        if (new Regex("[a-zA-Z]+").matches(r101) == true) goto L7;
        return false;
    L7:
        if (new Regex("[0-9]+").matches(r102) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public static final Object b(String r100, Continuation r101) {
        if ((r101 instanceof CyberProtectionInjectorKt$encodeByBDSword$1) == false) goto L7;
        CyberProtectionInjectorKt$encodeByBDSword$1 r102 = (CyberProtectionInjectorKt$encodeByBDSword$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L15;
        if (r106 != 1) goto L14;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L21
    L19:
        return (String) r104;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
        CoroutineDispatcher r107 = Dispatchers.getDefault();     // Catch: Throwable -> L21
        CyberProtectionInjectorKt$encodeByBDSword$2 r108 = new CyberProtectionInjectorKt$encodeByBDSword$2(r100, null);     // Catch: Throwable -> L21
        r102.label = 1;     // Catch: Throwable -> L21
        r104 = BuildersKt.withContext(r107, r108, r102);     // Catch: Throwable -> L21
        if (r104 != r105) goto L19;
        return r105;
    L22:
        return null;
    L7:
        r102 = new CyberProtectionInjectorKt$encodeByBDSword$1(r101);
        goto L8
    }

    public static final Object c(String r100, Continuation r110) {
        if ((r110 instanceof CyberProtectionInjectorKt$paramsOfKey$1) == false) goto L7;
        CyberProtectionInjectorKt$paramsOfKey$1 r101 = (CyberProtectionInjectorKt$paramsOfKey$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean r104 = false;
        String r105 = null;
        switch(r101.label) {
            case 0: goto L23;
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L14;
            case 10: goto L13;
            case 11: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r111);
    L152:
        r105 = (String) r111;
    L198:
        if (r105 != null) goto L200;
    L201:
        r104 = true;
    L202:
        if (r104 == false) goto L205;
        return "none";
    L205:
        return r105;
    L200:
        if (StringsKt.isBlank(r105) == false) goto L202;
    L13:
        ResultKt.throwOnFailure(r111);
    L184:
        r105 = (String) r111;
        goto L198
    L14:
        ResultKt.throwOnFailure(r111);
    L190:
        r105 = (String) r111;
        goto L198
    L15:
        ResultKt.throwOnFailure(r111);
    L105:
        r105 = (String) r111;
        goto L198
    L16:
        ResultKt.throwOnFailure(r111);
    L117:
        r105 = (String) r111;
        goto L198
    L17:
        ResultKt.throwOnFailure(r111);
    L136:
        Float r112 = (Float) r111;
        if (r112 == null) goto L198;
        r105 = String.valueOf(r112.floatValue());
        goto L198
    L18:
        ResultKt.throwOnFailure(r111);
    L144:
        Integer r113 = (Integer) r111;
        if (r113 == null) goto L198;
        r105 = String.valueOf(r113.intValue());
        goto L198
    L19:
        ResultKt.throwOnFailure(r111);
    L63:
        Long r114 = (Long) r111;
        if (r114 == null) goto L198;
        r105 = String.valueOf(r114.longValue());
        goto L198
    L20:
        ResultKt.throwOnFailure(r111);
    L71:
        Long r115 = (Long) r111;
        if (r115 == null) goto L198;
        r105 = String.valueOf(r115.longValue());
        goto L198
    L21:
        ResultKt.throwOnFailure(r111);
    L36:
        r105 = (String) r111;
        goto L198
    L22:
        ResultKt.throwOnFailure(r111);
    L42:
        Long r116 = (Long) r111;
        if (r116 == null) goto L198;
        r105 = String.valueOf(r116.longValue());
        goto L198
    L23:
        ResultKt.throwOnFailure(r111);
        CyberProtectionCollector r117 = CyberProtectionCollector.f43916a;
        Locale r106 = Locale.getDefault();
        if (r100 == null) goto L207;
        String r107 = r100.toUpperCase(r106);
        int r108 = r107.hashCode();
        switch(r108) {
            case 2064: goto L54;
            case 2065: goto L49;
            case 2066: goto L46;
            case 2067: goto L38;
            case 2068: goto L32;
            default: goto L27;
        };
    L27:
        switch(r108) {
            case 2157: goto L97;
            case 2158: goto L92;
            case 2159: goto L87;
            case 2160: goto L84;
            case 2161: goto L81;
            case 2162: goto L78;
            case 2163: goto L75;
            case 2164: goto L67;
            case 2165: goto L59;
            default: goto L210;
        };
    L210:
        switch(r108) {
            case 66915: goto L140;
            case 66916: goto L132;
            case 66917: goto L125;
            case 66918: goto L123;
            case 66919: goto L119;
            case 66920: goto L113;
            case 66921: goto L110;
            case 66922: goto L107;
            case 66923: goto L101;
            case 66924: goto L99;
            default: goto L29;
        };
    L29:
        switch(r108) {
            case 66946: goto L192;
            case 66947: goto L186;
            case 66948: goto L180;
            case 66949: goto L154;
            case 66950: goto L148;
            default: goto L198;
        };
    L148:
        if (r107.equals("D24") == false) goto L198;
        r101.label = 11;
        r111 = b.h(r101);
        if (r111 != r103) goto L152;
        return r103;
    L154:
        if (r107.equals("D23") == false) goto L198;
        Context r109 = b.m();
        if (r109 == null) goto L198;
        WifiManager r118 = (WifiManager) r109.getApplicationContext().getSystemService("wifi");
        if (r118.isWifiEnabled() == false) goto L164;
        TokenCert r119 = TokenCert.with("bpea-ec_debug_tools_connection_info");
        int r120 = com.bytedance.bpea.entry.api.device.info.h.f202191a;
        WifiInfo r121 = com.bytedance.bpea.entry.api.device.info.h.a.a(r118, r119);
        if (r121 == null) goto L198;
        TokenCert r122 = TokenCert.with("bpea-ec_debug_tools_connection_info");
        int r123 = com.bytedance.bpea.entry.api.device.info.g.f202190a;
        Integer r124 = com.bytedance.bpea.entry.api.device.info.g.a.a(r121, r122);
        if (r124 == null) goto L198;
        int r125 = r124.intValue();
        String r126 = (r125 & 255) + "." + ((r125 >> 8) & 255) + "." + ((r125 >> 16) & 255) + "." + ((r125 >> 24) & 255);
    L52:
        r105 = r126;
        goto L198
    L164:
        TokenCert r127 = TokenCert.with("bpea-ec_debug_tools_connection_info");     // Catch: Exception -> L208
        int r128 = com.bytedance.bpea.entry.api.device.info.c.f202186a;     // Catch: Exception -> L208
        Enumeration r129 = com.bytedance.bpea.entry.api.device.info.c.a.a(r127);     // Catch: Exception -> L208
    L165:
        if (r129 == null) goto L198;
        if (r129.hasMoreElements() == false) goto L198;
        Enumeration<InetAddress> r130 = ((NetworkInterface) r129.nextElement()).getInetAddresses();     // Catch: Exception -> L208
    L170:
        if (r130.hasMoreElements() == false) goto L165;
        InetAddress r131 = r130.nextElement();     // Catch: Exception -> L208
        if (r131.isLoopbackAddress() == true) goto L170;
        if (r131.isLinkLocalAddress() == true) goto L170;
        if ((r131 instanceof Inet4Address) == false) goto L170;
        TokenCert r132 = TokenCert.with("bpea-ec_debug_tools_connection_info");     // Catch: Exception -> L208
        int r133 = com.bytedance.bpea.entry.api.device.info.b.f202185a;     // Catch: Exception -> L208
        r126 = com.bytedance.bpea.entry.api.device.info.b.a.a((Inet4Address) r131, r132);     // Catch: Exception -> L208
    L209:
    L180:
        if (r107.equals("D22") == false) goto L198;
        r101.label = 10;
        r111 = b.j(r101);
        if (r111 != r103) goto L184;
        return r103;
    L186:
        if (r107.equals("D21") == false) goto L198;
        r101.label = 9;
        r111 = b.g(r101);
        if (r111 != r103) goto L190;
        return r103;
    L192:
        if (r107.equals("D20") == false) goto L198;
        Context r134 = b.m();
        if (r134 == null) goto L198;
        File r135 = r134.getExternalFilesDir(null);
        if (r135 == null) goto L198;
        r126 = r135.getAbsolutePath();
        goto L52
    L99:
        r107.equals("D19");
        goto L198
    L123:
        r107.equals("D13");
        goto L198
    L101:
        if (r107.equals("D18") == false) goto L198;
        r101.label = 8;
        r111 = b.f(r101);
        if (r111 != r103) goto L105;
        return r103;
    L107:
        if (r107.equals("D17") == false) goto L198;
        r105 = String.valueOf(SystemClock.uptimeMillis());
        goto L198
    L110:
        if (r107.equals("D16") == false) goto L198;
        r105 = String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime());
        goto L198
    L113:
        if (r107.equals("D15") == false) goto L198;
        r101.label = 7;
        r111 = BuildersKt.withContext(Dispatchers.getIO(), new CyberProtectionCollector$oaid$2(null), r101);
        if (r111 != r103) goto L117;
        return r103;
    L119:
        if (r107.equals("D14") == false) goto L198;
        r126 = Base64.encodeToString(new MediaDrm(new UUID(-1301668207276963122L, -6645017420763422227L)).getPropertyByteArray("deviceUniqueId"), 2);     // Catch: Exception -> L208
        goto L209
    L125:
        if (r107.equals("D12") == false) goto L198;
        Context r136 = b.m();
        if (r136 == null) goto L130;
        int r137 = com.bytedance.bpea.entry.api.device.info.f.f202189a;
        r126 = com.bytedance.bpea.entry.api.device.info.f.a.a(r136, TokenCert.Companion.with("bpea-track_sdk_get_device_info"));
        if (r126 != null) goto L52;
    L130:
        r126 = "android_id";
        goto L52
    L132:
        if (r107.equals("D11") == false) goto L198;
        r101.label = 6;
        r111 = b.e(r101);
        if (r111 != r103) goto L136;
        return r103;
    L140:
        if (r107.equals("D10") == false) goto L198;
        r101.label = 5;
        r111 = b.d(r101);
        if (r111 != r103) goto L144;
        return r103;
    L59:
        if (r107.equals("D9") == false) goto L198;
        r101.label = 4;
        r111 = b.c(r101);
        if (r111 != r103) goto L63;
        return r103;
    L67:
        if (r107.equals("D8") == false) goto L198;
        r101.label = 3;
        r111 = b.k(r101);
        if (r111 != r103) goto L71;
        return r103;
    L75:
        if (r107.equals("D7") == false) goto L198;
        r105 = String.valueOf(System.currentTimeMillis());
        goto L198
    L78:
        if (r107.equals("D6") == false) goto L198;
        r105 = Build.VERSION.RELEASE;
        goto L198
    L81:
        if (r107.equals("D5") == false) goto L198;
        r105 = "android";
        goto L198
    L84:
        if (r107.equals("D4") == false) goto L198;
        r105 = Build.SUPPORTED_ABIS[0];
        goto L198
    L87:
        if (r107.equals("D3") == false) goto L198;
        r126 = Build.MODEL;
        if (com.bytedance.android.shopping.extensions.k.c(r126) == false) goto L198;
    L92:
        if (r107.equals("D2") == false) goto L198;
        r126 = Build.MANUFACTURER;
        if (com.bytedance.android.shopping.extensions.k.c(r126) == false) goto L198;
    L97:
        if (r107.equals("D1") == false) goto L198;
        r105 = ECAppInfoService.f48114e.getServerDeviceId();
        goto L198
    L32:
        if (r107.equals("A5") == false) goto L198;
        r101.label = 2;
        r111 = r117.a(r101);
        if (r111 != r103) goto L36;
        return r103;
    L38:
        if (r107.equals("A4") == false) goto L198;
        r101.label = 1;
        r111 = b.b(r101);
        if (r111 != r103) goto L42;
        return r103;
    L46:
        if (r107.equals("A3") == false) goto L198;
        r105 = String.valueOf(44700);
        goto L198
    L49:
        if (r107.equals("A2") == false) goto L198;
        r126 = ECAppInfoService.f48114e.getAppVersion();
        if (com.bytedance.android.shopping.extensions.k.c(r126) == false) goto L198;
    L54:
        if (r107.equals("A1") == false) goto L198;
        r126 = ECAppInfoService.f48114e.getAppId();
        if (com.bytedance.android.shopping.extensions.k.c(r126) == false) goto L198;
    L207:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r101 = new CyberProtectionInjectorKt$paramsOfKey$1(r110);
        goto L8
    }
}
