package b9a;

import android.content.Context;
import android.content.pm.PackageManager;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class m extends a9a.a implements h9a.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PolarisFileWrapper f18367b;

    @Override // a9a.a
    public final String f() {
        return "permission";
    }

    @Override // h9a.a
    public final List<String> a() {
        ArrayList r100 = new ArrayList(1);
        PolarisFileWrapper r101 = this.f18367b;
        if (r101 == null) goto L5;
        r100.add(r101.getAbsolutePath());
    L5:
        return r100;
    }

    public m() {
        this.f18367b = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.BufferedWriter] */
    /* JADX WARN: Type inference failed for: r2v3 */
    @Override // a9a.a
    public final boolean g(z8a.a r110) throws Exception {
        if (a9a.a.e(new JSONObject(r110.f570965a), r110) == false) goto L5;
        return true;
    L5:
        Context r100 = x8a.c.b().getContext();
        ?? r101 = 0;
        r101 = 0;
        d9a.d.f467648a = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 4096).requestedPermissions;     // Catch: PackageManager.NameNotFoundException -> L53
        StringBuilder r102 = new StringBuilder();
        r102.append(com.monitor.cloudmessage.utils.a.e(r100).getAbsolutePath());
        String r103 = File.separator;
        r102.append(r103);
        r102.append("permissionInfo");
        String r104 = r102.toString();
        String r105 = r104 + r103 + "permission.txt";
        PolarisFileWrapper r106 = new PolarisFileWrapper(r104);     // Catch: Throwable -> L29 IOException -> L31
        if (r106.exists() == true) goto L11;
        r106.mkdirs();     // Catch: Throwable -> L29 IOException -> L31
    L11:
        PolarisFileWriterWrapper r107 = new PolarisFileWriterWrapper(r104 + r103 + "permission.txt");     // Catch: Throwable -> L29 IOException -> L31
        BufferedWriter r108 = new BufferedWriter(r107);     // Catch: Throwable -> L25 IOException -> L27
        Iterator r109 = ((HashMap) d9a.d.a(r100)).entrySet().iterator();     // Catch: IOException -> L23 Throwable -> L42
    L15:
        if (r109.hasNext() == false) goto L68;
        Map.Entry r111 = (Map.Entry) r109.next();     // Catch: IOException -> L23 Throwable -> L42
        r108.write(String.format("permission: %s, result: %b\n", new Object[]{r111.getKey(), r111.getValue()}));     // Catch: IOException -> L23 Throwable -> L42
        goto L15
    L68:
        r108.close();     // Catch: IOException -> L20
        r107.close();     // Catch: IOException -> L20
    L22:
        PolarisFileWrapper r112 = new PolarisFileWrapper(r105);
    L56:
        if (r112 != null) goto L59;
        i9a.b r113 = new i9a.b(r110.f570967c, null);
        r113.f488823d = 3;
        r113.f488824e = "网络信息文件生成失败";
        g9a.a.c(r113);
        return true;
    L59:
        this.f18367b = r112;
        g9a.a.b(new i9a.a("txt", r110.f570967c, this, null));
        return true;
    L20:
        e = move-exception;
        e.printStackTrace();
    L23:
        e = e;
    L33:
        e.printStackTrace();     // Catch: Throwable -> L42
        if (r108 != null) goto L66;
    L38:
        if (r107 == null) goto L55;
        r107.close();     // Catch: IOException -> L36
    L36:
        e = move-exception;
        e.printStackTrace();
    L55:
        r112 = null;
        goto L56
    L66:
        r108.close();     // Catch: IOException -> L36
        goto L38
    L27:
        e = e;
        r108 = null;
    L25:
        th = th;
    L44:
        if (r101 != 0) goto L62;
    L48:
        if (r107 == null) goto L52;
        r107.close();     // Catch: IOException -> L46
    L46:
        e = move-exception;
        e.printStackTrace();
    L52:
        throw th;
    L62:
        r101.close();     // Catch: IOException -> L46
        goto L48
    L42:
        th = th;
        r101 = r104;
    L31:
        e = e;
        r108 = null;
        r107 = null;
    L29:
        th = th;
        r107 = null;
    L53:
        e = move-exception;
        e.printStackTrace();
        goto L55
    }
}
