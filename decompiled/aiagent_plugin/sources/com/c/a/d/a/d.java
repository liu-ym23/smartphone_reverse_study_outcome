package com.c.a.d.a;

import android.content.Context;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: DBMessageHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends com.c.a.d.a implements com.c.a.h.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f11908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f11909b;

    @Override // com.c.a.d.a
    public String b() {
        return MonitorConstants.DB;
    }

    public d() {
        this.f11908a = null;
        this.f11909b = false;
    }

    @Override // com.c.a.d.a
    public boolean d(com.c.a.c.a r14) {
        JSONObject r1 = new JSONObject(r14.a());
        if (a(r1, r14) == false) goto L6;
        return true;
    L6:
        if (this.f11909b == false) goto L9;
        e(r14);
        return true;
    L9:
        this.f11909b = true;
        File r2 = null;
        String r5 = r1.optString("db_name", "");     // Catch: Throwable -> L17
        r2 = com.c.a.e.b.a.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.c.a.a.a().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5);     // Catch: Throwable -> L17
    L11:
        this.f11909b = false;
        if (r2 != null) goto L15;
        a("Sqlite文件拷贝失败", r14);
        return true;
    L15:
        this.f11908a = r2;
        com.c.a.h.b.a r0 = new com.c.a.h.b.a(r1.optString("fileContentType", "default_db_file_type"), 0, false, r14.d(), this, null);
        r0.a(false);
        r0.b(true);
        com.c.a.h.a.a(r0);
        return true;
    }

    @Override // com.c.a.h.a.a
    public List<String> c() {
        ArrayList r0 = new ArrayList(1);
        File r2 = this.f11908a;
        if (r2 == null) goto L5;
        r0.add(r2.getAbsolutePath());
    L5:
        return r0;
    }

    private void e(com.c.a.c.a r7) {
        com.c.a.h.b.b r6 = new com.c.a.h.b.b(0, false, r7.d(), null);
        r6.a(0);
        r6.a("数据库文件正在处理中");
        com.c.a.h.a.a(r6);
    }
}
