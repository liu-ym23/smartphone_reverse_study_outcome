package y9;

import com.monitor.cloudmessage.upload.callback.IFileUploadCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class m extends x9.a implements IFileUploadCallback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public File f26184b;

    public m() {
        this.f26184b = null;
    }

    @Override // x9.a
    public String d() {
        return "permission";
    }

    @Override // x9.a
    public boolean e(w9.a r11) {
        if (c(new JSONObject(r11.c()), r11) == false) goto L5;
        return true;
    L5:
        File r10 = aa.f.b(v9.a.k().i());
        if (r10 != null) goto L9;
        da.b r12 = new da.b(0, false, r11.b(), null);
        r12.h(3);
        r12.i("网络信息文件生成失败");
        ca.a.d(r12);
        return true;
    L9:
        this.f26184b = r10;
        ca.a.c(new da.a("txt", 0, false, r11.b(), this, null));
        return true;
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public List getUploadFileList() {
        ArrayList r10 = new ArrayList(1);
        File r11 = this.f26184b;
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
