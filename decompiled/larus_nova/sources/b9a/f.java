package b9a;

import com.bytedance.mira.oat.Dex2OatHelper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.entity.CloudMessageException;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class f extends a9a.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f18356b;

    @Override // a9a.a
    public final String f() {
        return CloudControlInf.UPLOAD;
    }

    public f() {
        this.f18356b = 0;
    }

    @Override // a9a.a
    public final boolean g(z8a.a r100) throws Exception {
        JSONObject r101 = r100.f570968d;
        if ((System.currentTimeMillis() - this.f18356b) >= 120000) goto L6;
        f9a.a.a(r100.f570967c, "2分钟不重复处理文件回捞", 0, null);
        return false;
    L6:
        this.f18356b = System.currentTimeMillis();
        String r102 = r101.optString("rootNode");
        String r103 = r101.optString("relativeFilename");
        if (r103.contains("../") == true) goto L53;
        if ("systemlib_so".equals(r102) == true) goto L11;
        PolarisFileWrapper r104 = com.monitor.cloudmessage.utils.a.f(r102, r103);
    L25:
        if (r104 == null) goto L51;
        f9a.a.a(r100.f570967c, "handling file upload:" + r104.getAbsolutePath(), 0, null);
        if (r104.exists() == false) goto L49;
        if (r104.canRead() == false) goto L47;
        if (r104.isDirectory() == true) goto L33;
    L37:
        f9a.b r105 = f9a.b.C5874b.f475989a;
        File r106 = r105.a();
        if (r106 == null) goto L45;
        PolarisFileWrapper r107 = new PolarisFileWrapper(r106, r100.f570967c + ChameleonResConstants.TEMP_SUFFIX);
        int r108 = com.monitor.cloudmessage.utils.a.f384389a;
        if (r107.exists() == false) goto L42;
        com.monitor.cloudmessage.utils.a.g(r107.getAbsolutePath());
    L42:
        r107.mkdirs();
        com.monitor.cloudmessage.utils.a.b(new PolarisFileWrapper(r107, "result.zip").getAbsolutePath(), new String[]{r104.getAbsolutePath()});
        r105.b(r100, r107, r101.optString("fileContentType", "unknown"));
        return true;
    L45:
        throw new CloudMessageException("pending目录因拿不到context而未设置");
    L33:
        if (com.bytedance.apm.util.b.c(r104) <= 134217728) goto L37;
        throw new CloudMessageException("回捞目录过大，禁止回捞");
    L47:
        throw new CloudMessageException("文件或目录无可读权限");
    L49:
        throw new CloudMessageException("文件或目录不存在");
    L51:
        throw new CloudMessageException("目录参数解析失败");
    L11:
        if (r103.endsWith(".so") == false) goto L13;
    L23:
        r104 = new PolarisFileWrapper(r103);
        goto L25
    L13:
        if (r103.endsWith(Dex2OatHelper.ODEX_SUFFIX) == true) goto L23;
        if (r103.endsWith(".jar") == true) goto L23;
        if (r103.endsWith(Dex2OatHelper.VDEX_SUFFIX) == true) goto L23;
        if (r103.endsWith(Dex2OatHelper.ART_SUFFIX) == true) goto L23;
        throw new CloudMessageException("非so, jar, odex, vdex, art 文件无权回捞");
    L53:
        throw new CloudMessageException("it's not allowed to use the form `../` to route in path");
    }
}
