package b9a;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class q extends a9a.a implements h9a.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PolarisFileWrapper f18368b;

    @Override // a9a.a
    public final String f() {
        return CloudControlInf.STAT;
    }

    @Override // h9a.a
    public final List<String> a() {
        ArrayList r100 = new ArrayList();
        PolarisFileWrapper r101 = this.f18368b;
        if (r101 == null) goto L5;
        r100.add(r101.getAbsolutePath());
    L5:
        return r100;
    }

    public q() {
        this.f18368b = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.io.FileWriter] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.io.FileWriter] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v17, types: [com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper, java.io.FileWriter, java.io.Writer] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.io.BufferedWriter] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r5v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // a9a.a
    public final boolean g(z8a.a r100) throws Exception {
        JSONObject r101 = new JSONObject(r100.f570965a);
        String r102 = r101.optString("type", "system_info");
        if (a9a.a.e(r101, r100) == false) goto L5;
        return true;
    L5:
        JSONObject r103 = new JSONObject();
        ?? r104 = "all".equals(r102);
        if (r104 == 0) goto L9;
        r103.put("all", c9a.a.a());
    L14:
        ?? r105 = com.monitor.cloudmessage.utils.a.e(x8a.c.b().getContext()).getAbsolutePath();
        String r106 = r105 + File.separator + "stats.txt";
        ?? r107 = 0;
        r107 = 0;
        PolarisFileWrapper r108 = new PolarisFileWrapper(r105);     // Catch: Throwable -> L32 IOException -> L34
        if (r108.exists() == true) goto L18;
        r108.mkdirs();     // Catch: Throwable -> L32 IOException -> L34
    L18:
        r105 = new PolarisFileWriterWrapper(r106);     // Catch: Throwable -> L32 IOException -> L34
    L73:
        BufferedWriter r109 = new BufferedWriter(r105);     // Catch: Throwable -> L28 IOException -> L30
        r109.write(r103.toString());     // Catch: IOException -> L26 Throwable -> L51
        r109.close();     // Catch: IOException -> L23
        r105.close();     // Catch: IOException -> L23
    L25:
        PolarisFileWrapper r110 = new PolarisFileWrapper(r106);
        r105 = r105;
        r104 = r109;
    L46:
        if (r110 != null) goto L49;
        a9a.a.h("系统信息文件生成失败", r100);
        return true;
    L49:
        this.f18368b = r110;
        g9a.a.b(new i9a.a("json", r100.f570967c, this, null));
        return true;
    L23:
        e = move-exception;
        e.printStackTrace();
    L26:
        e = e;
    L36:
        e.printStackTrace();     // Catch: Throwable -> L51
        if (r109 != null) goto L62;
    L41:
        if (r105 == 0) goto L45;
        r105.close();     // Catch: IOException -> L39
    L39:
        e = move-exception;
        e.printStackTrace();
    L45:
        r110 = null;
        r105 = r105;
        r104 = r109;
        goto L46
    L62:
        r109.close();     // Catch: IOException -> L39
        goto L41
    L30:
        e = e;
        r109 = null;
    L28:
        th = th;
    L53:
        if (r107 != 0) goto L68;
    L57:
        if (r105 == 0) goto L61;
        r105.close();     // Catch: IOException -> L55
    L55:
        e = move-exception;
        e.printStackTrace();
    L61:
        throw th;
    L68:
        r107.close();     // Catch: IOException -> L55
    L51:
        th = th;
        r107 = r104;
    L34:
        e = e;
        r105 = 0;
        r109 = null;
    L32:
        th = th;
        r105 = 0;
        goto L53
    L9:
        if ("stack_info".equals(r102) == true) goto L14;
        if ("system_info".equals(r102) == false) goto L14;
        r103.put("system_info", c9a.a.a());
        goto L14
    }
}
