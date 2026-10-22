package y9;

import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.upload.callback.IFileUploadCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class d extends x9.a implements IFileUploadCallback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public File f26168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f26169c;

    public d() {
        this.f26168b = null;
        this.f26169c = false;
    }

    @Override // x9.a
    public String d() {
        return CloudControlInf.DB;
    }

    @Override // x9.a
    public boolean e(w9.a r14) {
        JSONObject r10 = new JSONObject(r14.c());
        if (c(r10, r14) == false) goto L6;
        return true;
    L6:
        if (this.f26169c == false) goto L9;
        k(r14);
        return true;
    L9:
        this.f26169c = true;
        String r11 = r10.optString("db_name", "");     // Catch: Throwable -> L12
        File r12 = aa.a.b(v9.a.k().i(), r11);     // Catch: Throwable -> L12
        this.f26169c = false;
    L13:
        if (r12 != null) goto L16;
        i("Sqlite文件拷贝失败", r14);
        return true;
    L16:
        this.f26168b = r12;
        da.a r13 = new da.a(r10.optString("fileContentType", "default_db_file_type"), 0, false, r14.b(), this, null);
        r13.r(false);
        r13.s(true);
        ca.a.c(r13);
        return true;
    L12:
        this.f26169c = false;
        r12 = null;
        goto L13
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public List getUploadFileList() {
        ArrayList r10 = new ArrayList(1);
        File r11 = this.f26168b;
        if (r11 == null) goto L5;
        r10.add(r11.getAbsolutePath());
    L5:
        return r10;
    }

    public final void k(w9.a r10) {
        da.b r11 = new da.b(0, false, r10.b(), null);
        r11.h(0);
        r11.i("数据库文件正在处理中");
        ca.a.d(r11);
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadBegin(String r10) {
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadEnd(String r10, boolean r11) {
    }
}
