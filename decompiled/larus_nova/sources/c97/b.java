package c97;

import android.app.Application;
import android.os.Build;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f22858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f22859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f22860c;

    public final String b() {
        if (this.f22859b != null) goto L19;
        PolarisZipFileWrapper r100 = new PolarisZipFileWrapper(new PolarisFileWrapper(this.f22858a.getApplicationInfo().sourceDir));     // Catch: IOException -> L14
        Set r101 = a(r100);     // Catch: IOException -> L14
        r100.close();     // Catch: IOException -> L14
        String[] r102 = Build.SUPPORTED_ABIS;     // Catch: IOException -> L14
        HashSet r103 = (HashSet) r101;     // Catch: IOException -> L14
        int r104 = 0;
        if (r103.isEmpty() == false) goto L8;
        String r105 = r102[0];     // Catch: IOException -> L14
    L17:
        this.f22859b = r105;
        com.bytedance.reparo.core.k.c("AbiHelper", "parse host abi : " + this.f22859b);
        goto L19
    L8:
        int r106 = r102.length;     // Catch: IOException -> L14
    L9:
        if (r104 >= r106) goto L16;
        String r107 = r102[r104];     // Catch: IOException -> L14
        if (r103.contains(r107) == true) goto L12;
        r104 = r104 + 1;
        goto L9
    L12:
        r105 = r107;
        goto L17
    L22:
        r105 = "unknown_host_abi";
    L14:
        e = move-exception;
        e.printStackTrace();
        com.bytedance.reparo.core.k.b("AbiHelper", "parse host abi failed. ", e);
    L16:
        r105 = "unknown_host_abi";
    L19:
        return this.f22859b;
    }

    public b(Application r100) {
        this.f22860c = -1;
        this.f22858a = r100;
    }

    public static Set a(PolarisZipFileWrapper r100) {
        Enumeration<? extends ZipEntry> r101 = r100.entries();
        HashSet r102 = new HashSet();
    L4:
        if (r101.hasMoreElements() == false) goto L8;
        String r103 = r101.nextElement().getName();
        if (r103.endsWith(".so") == false) goto L4;
        r102.add(r103.split(HTTP.URL_DEFAULT)[1]);
        goto L4
    L8:
        return r102;
    }
}
