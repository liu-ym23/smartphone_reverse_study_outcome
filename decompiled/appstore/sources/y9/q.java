package y9;

import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.upload.callback.IFileUploadCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class q extends x9.a implements IFileUploadCallback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public File f26187b;

    public q() {
        this.f26187b = null;
    }

    @Override // x9.a
    public String d() {
        return CloudControlInf.STAT;
    }

    @Override // x9.a
    public boolean e(w9.a r13) {
        JSONObject r10 = new JSONObject(r13.c());
        String r11 = r10.optString("type", "system_info");
        if (c(r10, r13) == false) goto L5;
        return true;
    L5:
        JSONObject r12 = new JSONObject();
        if ("all".equals(r11) == false) goto L9;
        r12.put("all", new z9.a().a());
    L14:
        File r14 = aa.h.a(v9.a.k().i(), r12);
        if (r14 != null) goto L18;
        i("系统信息文件生成失败", r13);
        return true;
    L18:
        this.f26187b = r14;
        ca.a.c(new da.a("json", 0, false, r13.b(), this, null));
        return true;
    L9:
        if ("stack_info".equals(r11) == true) goto L14;
        if ("system_info".equals(r11) == false) goto L14;
        r12.put("system_info", new z9.a().a());
        goto L14
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public List getUploadFileList() {
        ArrayList r10 = new ArrayList();
        File r11 = this.f26187b;
        if (r11 == null) goto L5;
        r10.add(r11.getAbsolutePath());
    L5:
        return r10;
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadBegin(String r10) {
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadEnd(String r10, boolean r11) {
    }
}
