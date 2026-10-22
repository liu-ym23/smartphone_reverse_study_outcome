package com.c.a.d.a;

import com.bytedance.security.zenmobile.io.SensitiveType;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: compiled from: FileUploadMessageHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends com.c.a.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f11910a;

    @Override // com.c.a.d.a
    public String b() {
        return "new_file";
    }

    public f() {
        this.f11910a = 0;
    }

    @Override // com.c.a.d.a
    public boolean d(com.c.a.c.a r8) {
        JSONObject r0 = r8.b();
        if ((System.currentTimeMillis() - this.f11910a) >= 120000) goto L6;
        com.c.a.g.a.a("2分钟不重复处理文件回捞", r8);
        return false;
    L6:
        this.f11910a = System.currentTimeMillis();
        String r7 = r0.optString("rootNode");
        String r1 = r0.optString("relativeFilename");
        if (r1.contains("../") == true) goto L50;
        if ("systemlib_so".equals(r7) == true) goto L11;
        File r9 = com.c.a.i.b.c(r7, r1);
    L25:
        if (r9 == null) goto L48;
        com.c.a.g.a.a("handling file upload:" + r9.getAbsolutePath(), r8);
        if (r9.exists() == false) goto L46;
        if (r9.canRead() == false) goto L44;
        if (r9.isDirectory() == true) goto L33;
    L37:
        File r2 = com.c.a.g.b.a().b();
        if (r2 == null) goto L42;
        File r3 = new File(r2, r8.d() + "_temp");
        com.c.a.i.b.a(r3);
        com.c.a.i.b.a(new File(r3, "result.zip").getAbsolutePath(), new String[]{r9.getAbsolutePath()});
        com.c.a.g.b.a().a(r8, r3, r0.optString("fileContentType", SensitiveType.UNKNOWN));
        return true;
    L42:
        throw new com.c.a.c.b("pending目录因拿不到context而未设置");
    L33:
        if (com.bytedance.apm.util.b.b(r9) <= 134217728) goto L37;
        throw new com.c.a.c.b("回捞目录过大，禁止回捞");
    L44:
        throw new com.c.a.c.b("文件或目录无可读权限");
    L46:
        throw new com.c.a.c.b("文件或目录不存在");
    L48:
        throw new com.c.a.c.b("目录参数解析失败");
    L11:
        if (r1.endsWith(".so") == false) goto L13;
    L23:
        r9 = new File(r1);
        goto L25
    L13:
        if (r1.endsWith(".odex") == true) goto L23;
        if (r1.endsWith(".jar") == true) goto L23;
        if (r1.endsWith(".vdex") == true) goto L23;
        if (r1.endsWith(".art") == true) goto L23;
        throw new com.c.a.c.b("非so, jar, odex, vdex, art 文件无权回捞");
    L50:
        throw new com.c.a.c.b("it's not allowed to use the form `../` to route in path");
    }
}
