package y9;

import com.monitor.cloudmessage.upload.callback.IFileUploadCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class j extends x9.a implements IFileUploadCallback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public File f26182b;

    public j() {
        this.f26182b = null;
    }

    @Override // x9.a
    public String d() {
        return "network";
    }

    @Override // x9.a
    public boolean e(w9.a r11) {
        if (c(new JSONObject(r11.c()), r11) == false) goto L5;
        return true;
    L5:
        File r10 = aa.e.a(v9.a.k().i(), new JSONObject(r11.c()));
        if (r10 != null) goto L9;
        i("网络信息文件生成失败", r11);
        return true;
    L9:
        this.f26182b = r10;
        ca.a.c(new da.a("json", 0, false, r11.b(), this, null));
        return true;
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public List getUploadFileList() {
        ArrayList r10 = new ArrayList(1);
        File r11 = this.f26182b;
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
