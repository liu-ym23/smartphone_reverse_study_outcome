package y9;

import com.bytedance.librarian.LibrarianImpl;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.entity.CloudMessageException;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class f extends x9.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f26170b;

    public f() {
        this.f26170b = 0;
    }

    @Override // x9.a
    public String d() {
        return CloudControlInf.UPLOAD;
    }

    @Override // x9.a
    public boolean e(w9.a r10) {
        JSONObject r11 = r10.d();
        if ((System.currentTimeMillis() - this.f26170b) >= 120000) goto L6;
        ba.a.c("2分钟不重复处理文件回捞", r10);
        return false;
    L6:
        this.f26170b = System.currentTimeMillis();
        String r12 = r11.optString("rootNode");
        String r13 = r11.optString("relativeFilename");
        if (r13.contains("../") == true) goto L50;
        if ("systemlib_so".equals(r12) == true) goto L11;
        File r14 = com.monitor.cloudmessage.utils.b.j(r12, r13);
    L25:
        if (r14 == null) goto L48;
        ba.a.c("handling file upload:" + r14.getAbsolutePath(), r10);
        if (r14.exists() == false) goto L46;
        if (r14.canRead() == false) goto L44;
        if (r14.isDirectory() == true) goto L33;
    L37:
        File r15 = ba.b.b().c();
        if (r15 == null) goto L42;
        File r16 = new File(r15, r10.b() + "_temp");
        com.monitor.cloudmessage.utils.b.g(r16);
        com.monitor.cloudmessage.utils.b.b(new File(r16, "result.zip").getAbsolutePath(), new String[]{r14.getAbsolutePath()});
        ba.b.b().e(r10, r16, r11.optString("fileContentType", "unknown"));
        return true;
    L42:
        throw new CloudMessageException("pending目录因拿不到context而未设置");
    L33:
        if (com.bytedance.apm.util.b.e(r14) <= 134217728) goto L37;
        throw new CloudMessageException("回捞目录过大，禁止回捞");
    L44:
        throw new CloudMessageException("文件或目录无可读权限");
    L46:
        throw new CloudMessageException("文件或目录不存在");
    L48:
        throw new CloudMessageException("目录参数解析失败");
    L11:
        if (r13.endsWith(LibrarianImpl.Constants.SO_SUFFIX) == false) goto L13;
    L23:
        r14 = new File(r13);
        goto L25
    L13:
        if (r13.endsWith(".odex") == true) goto L23;
        if (r13.endsWith(".jar") == true) goto L23;
        if (r13.endsWith(".vdex") == true) goto L23;
        if (r13.endsWith(".art") == true) goto L23;
        throw new CloudMessageException("非so, jar, odex, vdex, art 文件无权回捞");
    L50:
        throw new CloudMessageException("it's not allowed to use the form `../` to route in path");
    }
}
