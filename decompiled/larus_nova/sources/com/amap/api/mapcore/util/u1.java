package com.amap.api.mapcore.util;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes28.dex */
public class u1 {

    public interface a {
        void a(String r100, String r101);

        void a(String r100, String r101, float r102);

        void a(String r100, String r101, int r102);
    }

    public u1() {
    }

    public long a(File r210, File r211, long r212, long r213, a r214) {
        if (r212 != 0) goto L7;
        if (r214 == null) goto L6;
        r214.a("", "", -1);
    L6:
        return 0;
    L7:
        String r110 = r210.getAbsolutePath();
        String r111 = r211.getAbsolutePath();
    L52:
        e = e;
        long r112 = r212;
    L54:
        e.printStackTrace();
        if (r214 == null) goto L71;
        r214.a(r110, r111, -1);
        return r112;
    L71:
        return r112;
    L10:
        if (r210.isDirectory() == true) goto L12;
        File r100 = r211.getParentFile();     // Catch: Exception -> L52
        if (r100 != null) goto L31;
    L37:
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper(r210);     // Catch: Exception -> L52
        PolarisFileOutputStreamWrapper r102 = new PolarisFileOutputStreamWrapper(r211);     // Catch: Exception -> L52
        byte[] r103 = new byte[1024];     // Catch: Exception -> L52
        long r104 = r212;
    L58:
        int r105 = r101.read(r103);     // Catch: Exception -> L50
        if (r105 <= 0) goto L44;
        r102.write(r103, 0, r105);     // Catch: Exception -> L50
        r104 = r104 + ((long) r105);     // Catch: Exception -> L50
        if (r214 == null) goto L58;
        r214.a(r110, r111, (r104 / r213) * 100.0f);     // Catch: Exception -> L50
        goto L58
    L44:
        r101.close();     // Catch: Exception -> L50
        r102.flush();     // Catch: Exception -> L50
        r102.close();     // Catch: Exception -> L50
        if (r214 == null) goto L70;
        if (r104 < (r213 - 1)) goto L70;
        r214.a(r110, r111);     // Catch: Exception -> L50
    L70:
        return r104;
    L50:
        e = e;
        r112 = r104;
        goto L54
    L31:
        if (r100.exists() == true) goto L37;
        if (r100.mkdirs() == true) goto L37;
        throw new IOException("Cannot create dir " + r100.getAbsolutePath());     // Catch: Exception -> L52
    L12:
        if (r211.exists() == false) goto L14;
    L18:
        String[] r106 = r210.list();     // Catch: Exception -> L52
        r112 = r212;
        if (r106 == null) goto L69;
        int r107 = 0;
    L61:
    L26:
        e = e;
        goto L54
    L23:
        if (r107 >= r106.length) goto L72;
        int r113 = r107;
        String[] r114 = r106;
        r112 = a(new PolarisFileWrapper(r210, r106[r107]), new PolarisFileWrapper(new PolarisFileWrapper(r211, r210.getName()), r106[r107]), r112, r213, r214);     // Catch: Exception -> L26
        r107 = r113 + 1;
        r106 = r114;
        goto L61
    L72:
        return r112;
    L69:
        return r112;
    L14:
        if (r211.mkdirs() == true) goto L18;
        throw new IOException("Cannot create dir " + r211.getAbsolutePath());     // Catch: Exception -> L52
    }
}
