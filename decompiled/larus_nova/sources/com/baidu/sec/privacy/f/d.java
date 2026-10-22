package com.baidu.sec.privacy.f;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.keva.KevaImpl;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.File;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import kotlin.UByte;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f33538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f33539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PublicKey f33540c;

    public class a implements Comparator<c> {
        public a(d r100) {
        }

        public int a(c r100, c r101) {
            int r102 = r101.f33543c - r100.f33543c;
            if (r102 == 0) goto L5;
            return r102;
        L5:
            boolean r103 = r100.f33542b;
            if (r103 == true) goto L8;
        L11:
            if (r103 == false) goto L15;
            return -1;
        L15:
            if (r101.f33542b == false) goto L18;
            return 1;
        L18:
            return r102;
        L8:
            if (r101.f33542b == false) goto L11;
            return 0;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(c r100, c r101) {
            return a(r100, r101);
        }
    }

    public static class b {
        public static byte[] a(byte[] r100) {
            return a(r100, r100.length);
        }

        public static byte[] a(byte[] r110, int r111) {
            int r100 = (r111 / 4) * 3;
            if (r100 == 0) goto L5;
            byte[] r101 = new byte[r100];
            int r102 = r111;
            int r103 = 0;
        L7:
            byte r104 = r110[r102 - 1];
            byte r105 = 10;
            if (r104 == 10) goto L61;
            if (r104 == 13) goto L61;
            if (r104 == 32) goto L61;
            if (r104 == 9) goto L61;
            if (r104 != 61) goto L17;
            r103 = r103 + 1;
            goto L61
        L17:
            int r106 = 0;
            int r112 = 0;
            int r113 = 0;
            int r114 = 0;
        L19:
            if (r106 >= r102) goto L53;
            byte r115 = r110[r106];
            if (r115 == r105) goto L52;
            if (r115 == 13) goto L52;
            if (r115 == 32) goto L52;
            if (r115 == 9) goto L52;
            if (r115 < 65) goto L31;
            if (r115 > 90) goto L31;
            int r116 = r115 - 65;
        L46:
            r113 = ((byte) r116) | (r113 << 6);
            if ((r114 % 4) != 3) goto L49;
            int r107 = r112 + 1;
            r101[r112] = (byte) ((16711680 & r113) >> 16);
            int r117 = r107 + 1;
            r101[r107] = (byte) ((65280 & r113) >> 8);
            r101[r117] = (byte) (r113 & 255);
            r112 = r117 + 1;
        L49:
            r114 = r114 + 1;
        L31:
            if (r115 < 97) goto L36;
            if (r115 > 122) goto L36;
            r116 = r115 - 71;
        L36:
            if (r115 < 48) goto L41;
            if (r115 > 57) goto L41;
            r116 = r115 + 4;
        L41:
            if (r115 != 43) goto L44;
            r116 = 62;
            goto L46
        L44:
            if (r115 != 47) goto L50;
            r116 = 63;
            goto L46
        L50:
            return null;
        L52:
            r106 = r106 + 1;
            r105 = 10;
            goto L19
        L53:
            if (r103 <= 0) goto L58;
            int r108 = r113 << (r103 * 6);
            int r109 = r112 + 1;
            r101[r112] = (byte) ((r108 & 16711680) >> 16);
            if (r103 != 1) goto L57;
            r112 = r109 + 1;
            r101[r109] = (byte) ((r108 & 65280) >> 8);
            goto L58
        L57:
            r112 = r109;
        L58:
            byte[] r118 = new byte[r112];
            System.arraycopy(r101, 0, r118, 0, r112);
            return r118;
        L61:
            r102 = r102 - 1;
            goto L7
        L5:
            return new byte[0];
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ApplicationInfo f33541a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f33542b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f33543c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f33544d;

        public c() {
            this.f33543c = 0;
            this.f33544d = false;
            this.f33542b = false;
        }

        public /* synthetic */ c(a r100) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.baidu.sec.privacy.f.d$d, reason: collision with other inner class name */
    public static class C0672d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f33545a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f33546b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f33547c;

        public static boolean a(int r100) {
            if (r100 < 14) goto L5;
            return true;
        L5:
            return false;
        }

        public String a() {
            String r100 = this.f33546b;
            if (TextUtils.isEmpty(r100) == false) goto L6;
            r100 = "0";
        L6:
            return this.f33545a + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r100;
        }

        public boolean b() {
            return a(this.f33547c);
        }

        public boolean c() {
            return b(this.f33546b);
        }

        public C0672d() {
            this.f33547c = 0;
        }

        public static C0672d a(String r100) {
            if (TextUtils.isEmpty(r100) == false) goto L33;
            return null;
        L33:
            JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L30
            Iterator<String> r102 = r101.keys();     // Catch: Exception -> L30
            String r103 = "0";
            String r104 = "0";
        L9:
            if (r102.hasNext() == false) goto L15;
            String r105 = r102.next();     // Catch: Exception -> L30
            if (d.a("ZGV2aWNlaWQ=").equals(r105) == true) goto L9;
            if (d.a("dmVy").equals(r105) == true) goto L9;
            r104 = r101.optString(r105, "0");     // Catch: Exception -> L30
            goto L9
        L15:
            String r106 = JSONObjectProtectorUtils.getString(r101, d.a("ZGV2aWNlaWQ="));     // Catch: Exception -> L30
            JSONObjectProtectorUtils.getInt(r101, d.a("dmVy"));     // Catch: Exception -> L30
            if (TextUtils.isEmpty(r104) == false) goto L18;
            int r107 = 0;
        L20:
            if (TextUtils.isEmpty(r106) == true) goto L32;
            C0672d r108 = new C0672d();     // Catch: Exception -> L30
            r108.f33545a = r106;     // Catch: Exception -> L30
            r108.f33547c = r107;     // Catch: Exception -> L30
            if (r107 < 14) goto L25;
            return r108;
        L25:
            if (TextUtils.isEmpty(r104) == true) goto L28;
            r103 = r104;
        L28:
            r108.f33546b = r103;     // Catch: Exception -> L30
            return r108;
        L32:
            return null;
        L18:
            r107 = r104.length();     // Catch: Exception -> L30
        L30:
            e = move-exception;
            com.baidu.sec.privacy.f.c.a(e);
            goto L32
        }

        public static boolean b(String r100) {
            return TextUtils.isEmpty(r100);
        }

        public static /* synthetic */ C0672d a(String r100, String r101) {
            return b(r100, r101);
        }

        public static C0672d b(String r100, String r101) {
            if (TextUtils.isEmpty(r100) == false) goto L6;
            return null;
        L6:
            C0672d r102 = new C0672d();
            r102.f33545a = r100;
            if (TextUtils.isEmpty(r101) == false) goto L9;
            int r103 = 0;
        L10:
            r102.f33547c = r103;
            if (r103 < 14) goto L14;
            return r102;
        L14:
            if (TextUtils.isEmpty(r101) == false) goto L16;
            r101 = "0";
        L16:
            r102.f33546b = r101;
            return r102;
        L9:
            r103 = r101.length();
            goto L10
        }
    }

    public static final class e {
        public static byte[] a() {
            return new byte[]{48, -126, 3, 99, 48, -126, 2, 75, -96, 3, 2, 1, 2, 2, 4, 106, -93, 120, 122, 48, HTTP.CR, 6, 9, 42, -122, 72, -122, -9, HTTP.CR, 1, 1, 11, 5, 0, 48, 97, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 99, 110, 49, 16, 48, 14, 6, 3, 85, 4, 8, 19, 7, 98, 101, 105, 106, 105, 110, 103, 49, 16, 48, 14, 6, 3, 85, 4, 7, 19, 7, 104, 97, 105, 100, 105, 97, 110, 49, 14, 48, 12, 6, 3, 85, 4, 10, 19, 5, 98, 97, 105, 100, 117, 49, 14, 48, 12, 6, 3, 85, 4, 11, 19, 5, 98, 97, 105, 100, 117, 49, 14, 48, 12, 6, 3, 85, 4, 3, 19, 5, 98, 97, 105, 100, 117, 48, 32, 23, HTTP.CR, 49, 53, 49, 48, 50, 49, 48, 52, 51, 54, 51, 55, 90, 24, 15, 50, 48, 55, 48, 48, 55, 50, 52, 48, 52, 51, 54, 51, 55, 90, 48, 97, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 99, 110, 49, 16, 48, 14, 6, 3, 85, 4, 8, 19, 7, 98, 101, 105, 106, 105, 110, 103, 49, 16, 48, 14, 6, 3, 85, 4, 7, 19, 7, 104, 97, 105, 100, 105, 97, 110, 49, 14, 48, 12, 6, 3, 85, 4, 10, 19, 5, 98, 97, 105, 100, 117, 49, 14, 48, 12, 6, 3, 85, 4, 11, 19, 5, 98, 97, 105, 100, 117, 49, 14, 48, 12, 6, 3, 85, 4, 3, 19, 5, 98, 97, 105, 100, 117, 48, -126, 1, 34, 48, HTTP.CR, 6, 9, 42, -122, 72, -122, -9, HTTP.CR, 1, 1, 1, 5, 0, 3, -126, 1, 15, 0, 48, -126, 1, 10, 2, -126, 1, 1, 0, -86, -91, -2, -41, ByteCompanionObject.MAX_VALUE, 37, -25, -33, 93, 51, -73, 32, -81, Base64.padSymbol, 108, 37, 126, 14, -125, 125, -55, -29, 34, -60, 84, -67, -46, 125, -93, -67, -27, 97, 54, 35, 0, -6, 83, 67, -116, 43, -24, 26, 88, -5, 33, 27, -105, 49, 76, -70, -32, 105, -48, 67, 69, 102, -111, -81, 93, -103, -18, 17, 55, 81, -34, -80, -76, -13, -84, 6, 91, 10, 48, -56, -1, 45, 9, 23, 34, 6, 103, 35, -51, 29, 70, -19, -51, 20, -39, -43, -97, 75, 23, -124, -101, -71, -75, -107, -88, -13, -71, 80, 90, -76, -119, 51, -80, 118, ByteCompanionObject.MIN_VALUE, -12, -108, 98, -29, -27, 60, -119, -74, 110, Base64.padSymbol, 51, -22, 53, 66, -99, -45, -25, 111, -121, 25, -72, ByteCompanionObject.MAX_VALUE, 3, 51, -100, 57, -90, 116, -59, -117, 74, -71, 121, 59, 19, -8, -109, 33, -14, 76, -105, -127, -23, 5, 99, -82, 22, -99, 51, 78, -26, 77, -52, -29, 121, 42, -76, 20, 2, 116, 111, -76, 2, -78, -90, -54, 81, 115, 82, 50, 124, -83, 96, 20, -40, -118, 105, 90, -70, 120, -33, -110, 12, -15, 38, 34, -125, -116, 69, -54, -103, -109, -124, 26, 94, -89, -98, -11, -66, 89, 48, PSSSigner.TRAILER_IMPLICIT, -51, 107, -60, 12, 114, -71, 119, 49, -31, -65, 113, -99, 3, -90, 79, -88, -38, -87, -25, -38, 41, 110, -25, 29, 49, 124, -76, -91, 77, -11, -90, 114, -63, 118, -22, -5, -124, 19, 22, -74, -75, 78, 28, 47, -69, 2, 3, 1, 0, 1, -93, 33, 48, 31, 48, 29, 6, 3, 85, 29, 14, 4, 22, 4, 20, -41, -108, 33, -126, -103, 35, 115, -83, 99, 110, -39, 110, -125, -118, -69, 87, -103, 30, 12, -53, 48, HTTP.CR, 6, 9, 42, -122, 72, -122, -9, HTTP.CR, 1, 1, 11, 5, 0, 3, -126, 1, 1, 0, 0, -117, 0, -28, 51, 26, -4, -15, 86, ByteCompanionObject.MAX_VALUE, 14, -101, -48, 121, 115, -53, -72, -22, 4, -83, 49, 106, -15, -44, -116, -105, 19, 65, -32, 65, 92, 21, 51, Base64.padSymbol, -21, -74, 71, 91, 64, 75, -72, -48, 102, 17, -120, -23, PSSSigner.TRAILER_IMPLICIT, 51, 23, -104, 107, 65, -30, 109, -6, 46, -44, -46, -73, -54, -55, 63, 77, -54, -11, -51, 27, -1, 114, 86, -80, 28, -89, 29, -20, 49, -8, 57, -7, -30, Base64.padSymbol, -108, -6, -60, 113, 45, -32, -93, 19, -62, -89, 106, 91, 96, -48, 90, -59, 46, 104, 111, -88, 51, -39, 40, -36, -113, 86, -92, 25, 30, 94, -13, -15, -57, 59, -21, -111, 104, -50, -3, -121, -90, -43, Base64.padSymbol, 105, -3, 57, 69, 51, -3, -31, 105, -12, 19, 77, -82, -120, 121, 108, -63, -126, 46, -43, 14, -56, 21, 47, 63, -104, -7, 113, 57, 100, -9, -12, -101, 107, -77, -64, 91, -104, -61, 0, -7, -72, -19, 75, 12, 111, ByteCompanionObject.MAX_VALUE, -115, -46, -99, -111, -93, -67, -42, -66, 32, 81, 70, 109, -57, 10, 19, -49, -44, 59, 21, 31, -61, -59, 83, -14, 43, 73, -88, 120, -58, -46, 46, 66, 41, -2, -70, -6, -42, 103, 8, 4, 89, 110, -122, 68, -86, 62, PSSSigner.TRAILER_IMPLICIT, HTTP.CR, -117, 35, -52, -6, 106, -91, 91, -62, -56, -26, -41, -109, 68, -102, -43, -29, 113, 43, -126, -127, 122, -47, -30, -96, -2, 78, 44, -92, -38, -124, -102, 73, -105, -66, 5, -85, -7, 56};
        }
    }

    public static final class f {
        public static byte[] a(byte[] r100) {
            return MessageDigest.getInstance("SHA-1").digest(r100);
        L4:
            e = move-exception;
            d.a(e);
            return new byte[0];
        }
    }

    public static void b(Throwable r100) {
    }

    public final void c() {
        ByteArrayInputStream r100 = null;
        ByteArrayInputStream r101 = new ByteArrayInputStream(e.a());     // Catch: Throwable -> L11 Exception -> L13
        this.f33540c = CertificateFactory.getInstance("X.509").generateCertificate(r101).getPublicKey();     // Catch: Throwable -> L7 Exception -> L9
        r101.close();     // Catch: Exception -> L18
    L34:
        return;
    L9:
        e = move-exception;
        e = e;
        r100 = r101;
    L30:
        b(e);     // Catch: Throwable -> L21
        if (r100 == null) goto L41;
        r100.close();     // Catch: Exception -> L18
        goto L34
    L41:
        return;
    L21:
        th = move-exception;
        r101 = r100;
        Throwable th10 = th;
    L23:
        ByteArrayInputStream r102 = r101;
        th = th10;
        r100 = r102;
    L24:
        if (r100 != null) goto L32;
    L29:
        throw th;
    L32:
        r100.close();     // Catch: Exception -> L27
    L27:
        e = move-exception;
        b(e);
    L7:
        th10 = th;
        goto L23
    L18:
        e = move-exception;
        b(e);
        return;
    L13:
        e = e;
    L11:
        th = th;
        goto L24
    }

    public final String e(String r100) {
        return "0";
    }

    static {
        new String(b.a(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 73, Base64.padSymbol}));
        new String(b.a(new byte[]{90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, Base64.padSymbol}));
    }

    public final C0672d a() {
        List<c> r100 = a(new Intent("com.baidu.intent.action.GALAXY").setPackage(this.f33539b.getPackageName()), true);
        boolean r101 = false;
        int r102 = 0;
        if (r100 != null) goto L5;
    L12:
        int r103 = 0;
    L13:
        if (r103 >= 3) goto L15;
        r103 = r103 + 1;
    L15:
        PolarisFileWrapper r104 = new PolarisFileWrapper(this.f33539b.getFilesDir(), com.baidu.bbalbscesium.f.f30074g);
        if (r104.exists() == false) goto L18;
        C0672d r105 = C0672d.a(c(a(r104)));
    L19:
        if (r105 != null) goto L34;
        f33538a |= 16;
        List<c> r106 = a(new Intent("com.baidu.intent.action.GALAXY"), r101);
        if (r106 == null) goto L34;
        File r107 = this.f33539b.getFilesDir();
        String r108 = r107.getName();
        String r109 = KevaImpl.PrivateConstants.FILES_DIR_NAME;
        if (KevaImpl.PrivateConstants.FILES_DIR_NAME.equals(r108) == true) goto L25;
        r109 = r107.getName();
    L25:
        Iterator<c> r110 = r106.iterator();
    L27:
        if (r110.hasNext() == false) goto L34;
        c r111 = r110.next();
        if (r111.f33542b == true) goto L27;
        PolarisFileWrapper r112 = new PolarisFileWrapper(new PolarisFileWrapper(r111.f33541a.dataDir, r109), com.baidu.bbalbscesium.f.f30074g);
        if (r112.exists() == false) goto L27;
        r105 = C0672d.a(c(a(r112)));
        if (r105 == null) goto L27;
    L34:
        if (r105 != null) goto L36;
        r105 = C0672d.a(c(f("com.baidu.deviceid.v2")));
    L36:
        boolean r113 = b("android.permission.READ_EXTERNAL_STORAGE");
        if (r105 != null) goto L40;
        if (r113 == false) goto L40;
        f33538a |= 2;
    L40:
        if (r105 != null) goto L42;
        f33538a |= 8;
        r105 = b();
    L42:
        if (r105 != null) goto L45;
        if (r113 == false) goto L45;
        f33538a |= 1;
        e("");
    L45:
        a(r105);
        return r105;
    L18:
        r105 = null;
        goto L19
    L5:
        if (r100.size() == 0) goto L12;
        boolean r114 = ((c) ListProtector.get(r100, 0)).f33544d;
        if (r114 == true) goto L11;
    L9:
        if (r102 >= 3) goto L11;
        r102 = r102 + 1;
    L11:
        r101 = r114;
        goto L15
    }

    public final C0672d b() {
        return C0672d.a(f("com.baidu.deviceid"), f("bd_setting_i"));
    }

    public d(Context r100) {
        this.f33539b = r100.getApplicationContext();
        c();
    }

    public static String a(byte[] r100) {
        if (r100 == null) goto L13;
        int r101 = r100.length;
        String r102 = "";
        int r103 = 0;
    L4:
        if (r103 >= r101) goto L11;
        String r104 = Integer.toHexString(r100[r103] & UByte.MAX_VALUE);
        if (r104.length() != 1) goto L8;
        r102 = r102 + "0" + r104;
    L9:
        r103 = r103 + 1;
        goto L4
    L8:
        r102 = r102 + r104;
        goto L9
    L11:
        return r102.toLowerCase();
    L13:
        throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
    }

    public static String c(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        return "";
    }

    public static String d(String r100) {
        return new String(b.a(r100.getBytes()));
    }

    public final boolean b(String r100) {
        if (com_baidu_sec_privacy_f_d_android_content_Context_checkPermission(this.f33539b, r100, Process.myPid(), Process.myUid()) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final String f(String r100) {
        return com_baidu_sec_privacy_f_d_android_provider_Settings$System_getString(this.f33539b.getContentResolver(), r100);
    L4:
        e = move-exception;
        b(e);
        return null;
    }

    public static String a(File r100) {
        PolarisFileReaderWrapper r101 = null;
        PolarisFileReaderWrapper r102 = new PolarisFileReaderWrapper(r100);     // Catch: Throwable -> L17 Exception -> L19
    L36:
        char[] r103 = new char[8192];     // Catch: Exception -> L15 Throwable -> L28
        CharArrayWriter r104 = new CharArrayWriter();     // Catch: Exception -> L15 Throwable -> L28
    L6:
        int r105 = r102.read(r103);     // Catch: Exception -> L15 Throwable -> L28
        if (r105 <= 0) goto L9;
        r104.write(r103, 0, r105);     // Catch: Exception -> L15 Throwable -> L28
        goto L6
    L9:
        String r106 = r104.toString();     // Catch: Exception -> L15 Throwable -> L28
        r102.close();     // Catch: Exception -> L12
    L14:
        return r106;
    L12:
        e = move-exception;
        b(e);
    L15:
        e = e;
    L21:
        b(e);     // Catch: Throwable -> L28
        if (r102 != null) goto L38;
    L27:
        return null;
    L38:
        r102.close();     // Catch: Exception -> L25
    L25:
        e = move-exception;
        b(e);
    L28:
        th = th;
        r101 = r102;
    L30:
        if (r101 != null) goto L41;
    L35:
        throw th;
    L41:
        r101.close();     // Catch: Exception -> L33
    L33:
        e = move-exception;
        b(e);
    L19:
        e = e;
        r102 = null;
    L17:
        th = th;
        goto L30
    }

    public static String b(Context r100) {
        C0672d r101 = a(r100);
        if (r101 != null) goto L5;
        return "";
    L5:
        return r101.a();
    }

    public final boolean a(C0672d r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.b() == false) goto L10;
        r100.f33546b = "O";
        return true;
    L10:
        if (r100.c() == true) goto L12;
        return false;
    L12:
        r100.f33546b = "0";
        return true;
    }

    public final String[] a(Signature[] r100) {
        int r101 = r100.length;
        String[] r102 = new String[r101];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r102[r103] = a(f.a(r100[r103].toByteArray()));
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public static C0672d a(Context r100) {
        return new d(r100).a();
    }

    public static /* synthetic */ String a(String r100) {
        return d(r100);
    }

    public static /* synthetic */ void a(Throwable r100) {
        b(r100);
    }

    private static String com_baidu_sec_privacy_f_d_android_provider_Settings$System_getString(ContentResolver r110, String r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r110, r111};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(102003, "android/provider/Settings$System", "getString", Settings.System.class, r101, "java.lang.String", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102003, "android/provider/Settings$System", "getString", Settings.System.class, r101, null, r112, false);
        return (String) r113.f474983b;
    L6:
        String r114 = Settings.System.getString(r110, r111);
        r100.a(102003, "android/provider/Settings$System", "getString", Settings.System.class, r101, r114, r112, true);
        return r114;
    }

    public final List<c> a(Intent r110, boolean r111) {
        ArrayList r100 = new ArrayList();
        PackageManager r101 = this.f33539b.getPackageManager();
        List<ResolveInfo> r112 = r101.queryBroadcastReceivers(r110, 0);
        if (r112 == null) goto L38;
        Iterator<ResolveInfo> r113 = r112.iterator();
    L6:
        if (r113.hasNext() == false) goto L38;
        ResolveInfo r102 = r113.next();
        ActivityInfo r103 = r102.activityInfo;
        if (r103 == null) goto L6;
        if (r103.applicationInfo == null) goto L6;
        ActivityInfo r104 = r102.activityInfo;     // Catch: Exception -> L36
        Bundle r105 = r101.getReceiverInfo(new ComponentName(r104.packageName, r104.name), 128).metaData;     // Catch: Exception -> L36
        if (r105 == null) goto L6;
        String r106 = r105.getString("galaxy_data");     // Catch: Exception -> L36
        if (TextUtils.isEmpty(r106) == true) goto L6;
        byte[] r107 = b.a(r106.getBytes(XML.CHARSET_UTF8));     // Catch: Exception -> L36
        JSONObject r108 = new JSONObject(new String(r107));     // Catch: Exception -> L36
        c r109 = new c(null);     // Catch: Exception -> L36
        r109.f33543c = JSONObjectProtectorUtils.getInt(r108, "priority");     // Catch: Exception -> L36
        r109.f33541a = r102.activityInfo.applicationInfo;     // Catch: Exception -> L36
        if (this.f33539b.getPackageName().equals(r102.activityInfo.applicationInfo.packageName) == false) goto L18;
        r109.f33542b = true;     // Catch: Exception -> L36
    L18:
        if (r111 == false) goto L34;
        String r114 = r105.getString("galaxy_sf");     // Catch: Exception -> L36
        if (TextUtils.isEmpty(r114) == true) goto L34;
        PackageInfo r115 = r101.getPackageInfo(r102.activityInfo.applicationInfo.packageName, 64);     // Catch: Exception -> L36
        JSONArray r116 = JSONObjectProtectorUtils.getJSONArray(r108, "sigs");     // Catch: Exception -> L36
        int r117 = r116.length();     // Catch: Exception -> L36
        String[] r118 = new String[r117];     // Catch: Exception -> L36
        int r119 = 0;
    L22:
        if (r119 >= r117) goto L25;
        r118[r119] = JSONArrayProtectorUtils.getString(r116, r119);     // Catch: Exception -> L36
        r119 = r119 + 1;     // Catch: Exception -> L36
        goto L22
    L25:
        if (a(r118, a(r115.signatures)) == false) goto L34;
        byte[] r120 = a(b.a(r114.getBytes()), this.f33540c);     // Catch: Exception -> L36
        if (r120 != null) goto L29;
    L31:
        boolean r121 = false;
    L32:
        if (r121 == false) goto L34;
        r109.f33544d = true;     // Catch: Exception -> L36
        goto L34
    L29:
        if (Arrays.equals(r120, f.a(r107)) == false) goto L31;
        r121 = true;
    L34:
        r100.add(r109);     // Catch: Exception -> L36
    L36:
        e = move-exception;
        b(e);
    L38:
        Collections.sort(r100, new a(this));
        return r100;
    }

    public final boolean a(String[] r100, String[] r101) {
        int r102 = 0;
        if (r100 == null) goto L16;
        if (r101 == null) goto L16;
        if (r100.length != r101.length) goto L16;
        HashSet r103 = new HashSet();
        int r104 = r100.length;
        int r105 = 0;
    L9:
        if (r105 >= r104) goto L11;
        r103.add(r100[r105]);
        r105 = r105 + 1;
        goto L9
    L11:
        HashSet r106 = new HashSet();
        int r107 = r101.length;
    L12:
        if (r102 >= r107) goto L15;
        r106.add(r101[r102]);
        r102 = r102 + 1;
        goto L12
    L15:
        return r103.equals(r106);
    L16:
        return false;
    }

    public static byte[] a(byte[] r100, PublicKey r101) throws Exception {
        Cipher r102 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        r102.init(2, r101);
        return r102.doFinal(r100);
    }

    private static int com_baidu_sec_privacy_f_d_android_content_Context_checkPermission(Context r110, String r111, int r210, int r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, Integer.valueOf(r210), Integer.valueOf(r211)};
        f06.b r112 = new f06.b("auto_cert_com_baidu_sec_privacy_f_d_android_content_Context_checkPermission");
        g06.a r102 = ApiHookConfig.f245611b.get(102607);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(102607, "android/content/Context", "checkPermission", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.checkPermission(r111, r210, r211);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
