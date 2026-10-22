package b9a;

import android.content.Context;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.entity.CloudMessageException;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class c extends a9a.a {

    /* JADX INFO: loaded from: classes32.dex */
    public class a implements IConfigListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ z8a.a f18352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f18353b;

        @Override // com.bytedance.services.slardar.config.IConfigListener
        public final void onReady() {
        }

        public a(c r100, z8a.a r101) {
            this.f18353b = r100;
            this.f18352a = r101;
        }

        @Override // com.bytedance.services.slardar.config.IConfigListener
        public final void onRefresh(JSONObject r100, boolean r101) {
            c.i(this.f18353b, r100, this.f18352a);     // Catch: Exception -> L4 Throwable -> L6 CloudMessageException -> L8
        L10:
            ((IConfigManager) ServiceManager.getService(IConfigManager.class)).unregisterConfigListener(this);
            return;
        L6:
            th = move-exception;
            ((IConfigManager) ServiceManager.getService(IConfigManager.class)).unregisterConfigListener(this);
            throw th;
        L4:
            e = move-exception;
            StringWriter r102 = new StringWriter();     // Catch: Throwable -> L6
            e.printStackTrace(new PrintWriter(r102));     // Catch: Throwable -> L6
            String r103 = String.format("系统错误：%s", new Object[]{r102.toString()});     // Catch: Throwable -> L6
            c r104 = this.f18353b;     // Catch: Throwable -> L6
            z8a.a r105 = this.f18352a;     // Catch: Throwable -> L6
            r104.getClass();     // Catch: Throwable -> L6
            a9a.a.h(r103, r105);     // Catch: Throwable -> L6
        L8:
            e = move-exception;
            c r106 = this.f18353b;     // Catch: Throwable -> L6
            String r107 = e.getMessage();     // Catch: Throwable -> L6
            z8a.a r108 = this.f18352a;     // Catch: Throwable -> L6
            r106.getClass();     // Catch: Throwable -> L6
            a9a.a.h(r107, r108);     // Catch: Throwable -> L6
            goto L10
        }
    }

    @Override // a9a.a
    public final String f() {
        return CloudControlInf.CACHE;
    }

    public c() {
    }

    @Override // a9a.a
    public final boolean g(z8a.a r100) throws Exception {
        a r101 = new a(this, r100);
        ((IConfigManager) ServiceManager.getService(IConfigManager.class)).registerConfigListener(r101);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.BufferedWriter] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.FileWriter] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.FileWriter] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper, java.io.FileWriter, java.io.Writer] */
    /* JADX WARN: Type inference failed for: r5v9 */
    public static void i(c r100, JSONObject r101, z8a.a r102) throws Exception {
        r100.getClass();
        JSONObject r103 = r101.optJSONObject("performance_modules");
        if (r103 == null) goto L103;
        JSONObject r104 = r103.optJSONObject(UploadTypeInf.DISK);
        if (r104 == null) goto L104;
        List<String> r105 = com.bytedance.apm.util.o.b(r104, "compliance_relative_paths");
        ArrayList r106 = new ArrayList();
        ?? r107 = 0;
        BufferedWriter r108 = null;
        r108 = null;
        r107 = 0;
        if (xu3.e.b(r105) == true) goto L20;
        Context r109 = x8a.c.b().getContext();
        Iterator r110 = ((ArrayList) r105).iterator();
    L13:
        if (r110.hasNext() == false) goto L20;
        String r111 = (String) r110.next();
        if (r111.contains("internal") == true) goto L16;
        if (r111.contains("external") == false) goto L13;
        r106.add(r111.replace("external", r109.getExternalFilesDir(null).getParentFile().getAbsolutePath()));
        goto L13
    L16:
        r106.add(r111.replace("internal", r109.getFilesDir().getParentFile().getAbsolutePath()));
    L20:
        JSONObject r112 = r102.f570968d;
        PolarisFileWrapper r113 = com.monitor.cloudmessage.utils.a.f(r112.optString("rootNode"), r112.optString("relativeDirName"));
        if (r113 == null) goto L80;
        f9a.a.a(r102.f570967c, "handling dir upload:" + r113.getAbsolutePath(), 0, null);
        if (r113.exists() == false) goto L78;
        File r114 = f9a.b.C5874b.f475989a.a();
        if (r114 == null) goto L76;
        StringBuilder r115 = new StringBuilder();
        r115.append(r102.f570967c);
        ?? r116 = ChameleonResConstants.TEMP_SUFFIX;
        r115.append(ChameleonResConstants.TEMP_SUFFIX);
        PolarisFileWrapper r117 = new PolarisFileWrapper(r114, r115.toString());
        if (r117.exists() == false) goto L29;
        com.monitor.cloudmessage.utils.a.g(r117.getAbsolutePath());
    L29:
        r117.mkdirs();
        r116 = new PolarisFileWriterWrapper(new PolarisFileWrapper(r117, "dir_tree.txt"));     // Catch: Throwable -> L46 IOException -> L48
        BufferedWriter r118 = new BufferedWriter(r116);     // Catch: Throwable -> L42 IOException -> L44
        d9a.b.b(r113, r118, r106);     // Catch: Throwable -> L38 IOException -> L40
        r118.close();     // Catch: IOException -> L35
        r116.close();     // Catch: IOException -> L35
    L37:
        boolean r119 = true;
        r116 = r116;
    L60:
        r107 = "dir tree generate result ";
        ps3.b.a(new String[]{"dir tree generate result " + r119});
        if (r119 == false) goto L65;
        f9a.b.C5874b.f475989a.b(r102, r117, "log_dir_tree");
        return;
    L65:
        throw new CloudMessageException("目录树文件生成失败");
    L35:
        e = move-exception;
        e.printStackTrace();
        goto L37
    L40:
        e = e;
        r108 = r118;
    L50:
        e.printStackTrace();     // Catch: Throwable -> L42
        if (r108 != null) goto L88;
    L55:
        if (r116 == 0) goto L59;
        r116.close();     // Catch: IOException -> L53
    L53:
        e = move-exception;
        e.printStackTrace();
    L59:
        r119 = false;
        r116 = r116;
        goto L60
    L88:
        r108.close();     // Catch: IOException -> L53
    L38:
        th = th;
        r107 = r118;
    L66:
        if (r107 != 0) goto L81;
    L70:
        if (r116 == 0) goto L74;
        r116.close();     // Catch: IOException -> L68
    L68:
        e = move-exception;
        e.printStackTrace();
    L74:
        throw th;
    L81:
        r107.close();     // Catch: IOException -> L68
    L44:
        e = e;
        goto L50
    L42:
        th = th;
    L48:
        e = e;
        r116 = 0;
    L46:
        th = th;
        r116 = 0;
        goto L66
    L76:
        throw new CloudMessageException("pending目录因拿不到context而未设置");
    L78:
        throw new CloudMessageException("目录不存在");
    L80:
        throw new CloudMessageException("目录参数解析失败");
    L104:
        return;
    }
}
