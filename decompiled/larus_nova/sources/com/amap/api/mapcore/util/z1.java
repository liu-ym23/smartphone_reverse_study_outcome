package com.amap.api.mapcore.util;

import android.text.TextUtils;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.BufferedOutputStream;
import java.io.File;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes28.dex */
public class z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f28546a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f28547a;

        public a() {
            this.f28547a = false;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f28548a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f28549b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private b2 f28550c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private a f28551d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f28552e;

        public void a() {
            this.f28551d.f28547a = true;
        }

        public String b() {
            return this.f28549b;
        }

        public String c() {
            return this.f28552e;
        }

        public a d() {
            return this.f28551d;
        }

        public b2 e() {
            return this.f28550c;
        }

        public String f() {
            return this.f28548a;
        }

        public void a(String r100) {
            if (r100.length() <= 1) goto L6;
            this.f28552e = r100;
            return;
        }

        public b(v1 r100, b2 r101) {
            this.f28550c = null;
            this.f28551d = new a();
            this.f28548a = r100.c();
            this.f28549b = r100.i();
            this.f28550c = r101;
        }
    }

    public interface c {
    }

    public void a() {
        b r100 = this.f28546a;
        if (r100 == null) goto L49;
        b2 r101 = r100.e();
        if (r101 == null) goto L7;
        r101.b();
    L7:
        String r102 = r100.f();
        String r103 = r100.b();
        if (TextUtils.isEmpty(r102) == true) goto L42;
        if (TextUtils.isEmpty(r103) == true) goto L42;
        PolarisFileWrapper r104 = new PolarisFileWrapper(r102);
        if (r104.exists() == false) goto L15;
        PolarisFileWrapper r105 = new PolarisFileWrapper(r103);
        if (r105.exists() == true) goto L23;
        r105.mkdirs();
    L23:
        y1 r106 = new y1(r101);
        if (r100.d().f28547a == false) goto L28;
        if (r101 == null) goto L28;
        r101.d();     // Catch: Throwable -> L35
    L28:
        a(r104, r105, r106, r100);     // Catch: Throwable -> L35
        if (r100.d().f28547a == false) goto L32;
        if (r101 == null) goto L54;
        r101.d();     // Catch: Throwable -> L35
        return;
    L54:
        return;
    L32:
        if (r101 == null) goto L56;
        r101.a(r100.c());     // Catch: Throwable -> L35
        return;
    L56:
        return;
    L36:
        if (r100.d().f28547a == false) goto L39;
        if (r101 == null) goto L57;
        r101.d();
        return;
    L57:
        return;
    L39:
        if (r101 == null) goto L59;
        r101.f();
        return;
    L59:
        return;
    L15:
        if (r100.d().f28547a == false) goto L18;
        if (r101 == null) goto L50;
        r101.d();
        return;
    L50:
        return;
    L18:
        if (r101 == null) goto L52;
        r101.f();
        return;
    L52:
        return;
    L42:
        if (r100.d().f28547a == false) goto L45;
        if (r101 == null) goto L61;
        r101.d();
        return;
    L61:
        return;
    L45:
        if (r101 == null) goto L63;
        r101.f();
        return;
    L63:
        return;
    }

    public void b() {
        b r100 = this.f28546a;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    private static boolean a(String r100) {
        if (r100.contains(DownloadConstants.VULNERABILITY_PATH) == false) goto L5;
        return false;
    L5:
        if (r100.contains(HTTP.URL_DEFAULT) == false) goto L7;
        return false;
    L7:
        if (r100.contains("\\") == false) goto L9;
        return false;
    L9:
        if (r100.contains(GXTemplateKey.GAIAX_PE) == true) goto L16;
        return true;
    L16:
        return false;
    }

    private static void a(File r100) {
        File r101 = r100.getParentFile();
        if (r101.exists() == true) goto L6;
        a(r101);
        r101.mkdir();
        return;
    }

    public z1(v1 r100, b2 r101) {
        this.f28546a = new b(r100, r101);
    }

    private static void a(File r110, File r210, c r211, b r212) throws Exception {
        StringBuffer r100 = new StringBuffer();
        a r101 = r212.d();
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r110);     // Catch: Exception -> L24
        CheckedInputStream r103 = new CheckedInputStream(r102, new CRC32());     // Catch: Exception -> L24
        ZipInputStream r104 = new ZipInputStream(r103);     // Catch: Exception -> L24
        long r105 = 0;
    L77:
        ZipEntry r111 = r104.getNextEntry();     // Catch: Exception -> L22
        if (r111 == null) goto L20;
        if (r101 == null) goto L12;
        if (r101.f28547a == false) goto L12;
        r104.closeEntry();     // Catch: Exception -> L22
        r104.close();     // Catch: Exception -> L22
        r103.close();     // Catch: Exception -> L22
        r102.close();     // Catch: Exception -> L22
    L12:
        if (r111.isDirectory() == true) goto L19;
        if (a(r111.getName()) == false) goto L15;
        r100.append(r111.getName());     // Catch: Exception -> L22
        r100.append(com.alipay.sdk.m.u.i.f25853b);     // Catch: Exception -> L22
        goto L19
    L15:
        b2 r112 = ((y1) r211).f28407a;     // Catch: Exception -> L22
        if (r112 == null) goto L20;
        r112.f();     // Catch: Exception -> L22
    L19:
        r105 = r105 + r111.getSize();     // Catch: Exception -> L22
        r104.closeEntry();     // Catch: Exception -> L22
    L20:
        r212.a(r100.toString());     // Catch: Exception -> L22
        r104.close();     // Catch: Exception -> L22
        r103.close();     // Catch: Exception -> L22
        r102.close();     // Catch: Exception -> L22
    L27:
        PolarisFileInputStreamWrapper r106 = new PolarisFileInputStreamWrapper(r110);
        CheckedInputStream r107 = new CheckedInputStream(r106, new CRC32());
        ZipInputStream r108 = new ZipInputStream(r107);
        int r109 = 0;
        int r113 = 0;
    L28:
        ZipEntry r114 = r108.getNextEntry();
        if (r114 == null) goto L71;
        if (r101 != null) goto L32;
    L34:
        String r115 = r210.getPath() + File.separator + r114.getName();
        if (a(r114.getName()) == false) goto L36;
        PolarisFileWrapper r116 = new PolarisFileWrapper(r115);
        File r117 = r116.getParentFile();
        if (r117.exists() == true) goto L46;
        File r118 = r117.getParentFile();
        if (r118.exists() == true) goto L44;
        a(r118);
        r118.mkdir();
    L44:
        r117.mkdir();
    L46:
        if (r114.isDirectory() == false) goto L48;
        r116.mkdirs();
    L70:
        r108.closeEntry();
        r109 = 0;
        goto L28
    L48:
        long r119 = r113;
        BufferedOutputStream r120 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r116));
        byte[] r121 = new byte[1024];
        int r122 = 0;
    L49:
        int r123 = r108.read(r121, r109, 1024);
        if (r123 == (-1)) goto L68;
        if (r101 != null) goto L53;
    L55:
        r120.write(r121, r109, r123);
        r122 = r122 + r123;
        if (r105 <= 0) goto L67;
        long r124 = ((((long) r122) + r119) * 100) / r105;
        if (r101 == null) goto L73;
        if (r101.f28547a == true) goto L67;
    L73:
        b2 r125 = ((y1) r211).f28407a;     // Catch: Exception -> L66
        if (r125 == null) goto L67;
        r125.a(r124);     // Catch: Exception -> L66
    L67:
        r109 = 0;
        goto L49
    L53:
        if (r101.f28547a == false) goto L55;
        r120.close();
    L69:
        r113 = r113 + r122;
        goto L70
    L68:
        r120.close();
        goto L69
    L36:
        b2 r126 = ((y1) r211).f28407a;
        if (r126 == null) goto L71;
        r126.f();
        goto L71
    L32:
        if (r101.f28547a == false) goto L34;
        r108.closeEntry();
    L71:
        r108.close();
        r107.close();
        r106.close();
        return;
    L22:
        e = e;
    L26:
        e.printStackTrace();
    L24:
        e = e;
        r105 = 0;
        goto L26
    }
}
