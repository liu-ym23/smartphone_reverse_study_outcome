package y9;

import android.content.Context;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.entity.CloudMessageException;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class c extends x9.a {

    public class a implements IConfigListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w9.a f26166a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f26167b;

        public a(c r10, w9.a r11) {
            this.f26167b = r10;
            this.f26166a = r11;
        }

        @Override // com.bytedance.services.slardar.config.IConfigListener
        public void onReady() {
        }

        @Override // com.bytedance.services.slardar.config.IConfigListener
        public void onRefresh(JSONObject r10, boolean r11) {
            c.k(this.f26167b, r10, r11, this.f26166a);     // Catch: Throwable -> L5 Exception -> L7 CloudMessageException -> L9
        L4:
            ((IConfigManager) n5.b.a(IConfigManager.class)).unregisterConfigListener(this);
            return;
        L5:
            th = move-exception;
            ((IConfigManager) n5.b.a(IConfigManager.class)).unregisterConfigListener(this);
            throw th;
        L9:
            e = move-exception;
            c.l(this.f26167b, e.getMessage(), this.f26166a);     // Catch: Throwable -> L5
        L7:
            e = move-exception;
            String r12 = String.format("系统错误：%s", new Object[]{com.monitor.cloudmessage.utils.a.a(e)});     // Catch: Throwable -> L5
            c.m(this.f26167b, r12, this.f26166a);     // Catch: Throwable -> L5
            goto L4
        }
    }

    public c() {
    }

    public static /* synthetic */ void k(c r10, JSONObject r11, boolean r12, w9.a r13) {
        r10.n(r11, r12, r13);
    }

    public static /* synthetic */ void l(c r10, String r11, w9.a r12) {
        r10.i(r11, r12);
    }

    public static /* synthetic */ void m(c r10, String r11, w9.a r12) {
        r10.i(r11, r12);
    }

    @Override // x9.a
    public String d() {
        return CloudControlInf.CACHE;
    }

    @Override // x9.a
    public boolean e(w9.a r10) {
        a r11 = new a(this, r10);
        ((IConfigManager) n5.b.a(IConfigManager.class)).registerConfigListener(r11);
        return true;
    }

    public final void n(JSONObject r10, boolean r11, w9.a r12) {
        JSONObject r13 = r10.optJSONObject("performance_modules");
        if (r13 != null) goto L5;
        return;
    L5:
        JSONObject r14 = r13.optJSONObject("disk");
        if (r14 != null) goto L8;
        return;
    L8:
        List r15 = o(com.bytedance.apm.util.n.d(r14, "compliance_relative_paths"));
        JSONObject r16 = r12.d();
        File r17 = com.monitor.cloudmessage.utils.b.j(r16.optString("rootNode"), r16.optString("relativeDirName"));
        if (r17 == null) goto L25;
        ba.a.c("handling dir upload:" + r17.getAbsolutePath(), r12);
        if (r17.exists() == false) goto L23;
        File r18 = ba.b.b().c();
        if (r18 == null) goto L21;
        File r19 = new File(r18, r12.b() + "_temp");
        com.monitor.cloudmessage.utils.b.g(r19);
        boolean r20 = aa.b.d(r17, new File(r19, "dir_tree.txt"), r15);
        s1.c.b("cloudmessage", new String[]{"dir tree generate result " + r20});
        if (r20 == false) goto L19;
        ba.b.b().e(r12, r19, "log_dir_tree");
        return;
    L19:
        throw new CloudMessageException("目录树文件生成失败");
    L21:
        throw new CloudMessageException("pending目录因拿不到context而未设置");
    L23:
        throw new CloudMessageException("目录不存在");
    L25:
        throw new CloudMessageException("目录参数解析失败");
    }

    public final List o(List r10) {
        ArrayList r11 = new ArrayList();
        if (ListUtils.b(r10) == false) goto L5;
        return r11;
    L5:
        Context r12 = v9.a.k().i();
        Iterator r13 = r10.iterator();
    L7:
        if (r13.hasNext() == false) goto L14;
        String r14 = (String) r13.next();
        if (r14.contains("internal") == true) goto L10;
        if (r14.contains("external") == false) goto L7;
        r11.add(r14.replace("external", r12.getExternalFilesDir(null).getParentFile().getAbsolutePath()));
        goto L7
    L10:
        r11.add(r14.replace("internal", r12.getFilesDir().getParentFile().getAbsolutePath()));
        goto L7
    L14:
        return r11;
    }
}
