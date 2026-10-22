package y9;

import android.os.Debug;
import android.text.TextUtils;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.upload.callback.IFileUploadCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class g extends x9.a implements IFileUploadCallback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public File f26171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f26172c;

    public g() {
        this.f26171b = null;
        this.f26172c = 0;
    }

    @Override // x9.a
    public String d() {
        return CloudControlInf.HEAP_OOM;
    }

    @Override // x9.a
    public boolean e(w9.a r14) {
        JSONObject r10 = new JSONObject(r14.c());
        if (c(r10, r14) == false) goto L6;
        return true;
    L6:
        if ((System.currentTimeMillis() - this.f26172c) >= 300000) goto L8;
        return false;
    L8:
        this.f26172c = System.currentTimeMillis();
        boolean r11 = r10.optBoolean("isTryToCatch", false);
        String r12 = v9.a.j();
        String r13 = "本地未设置dumpFileName";
        if (TextUtils.isEmpty(r12) == false) goto L12;
        i("本地未设置dumpFileName", r14);
        return true;
    L12:
        if (r11 == true) goto L30;
    L17:
        File r15 = new File(r12);
        if (TextUtils.isEmpty(r12) == true) goto L22;
        r13 = null;
    L22:
        if (r15.exists() == true) goto L25;
        r13 = "dumpFile不存在";
    L25:
        if (TextUtils.isEmpty(r13) == true) goto L28;
        i(r13, r14);
        return true;
    L28:
        this.f26171b = r15;
        da.a r16 = new da.a("log_heap_oom", 0, false, r14.b(), this, null);
        r16.r(true);
        ca.a.c(r16);
        return true;
    L30:
        Debug.dumpHprofData(r12);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public List getUploadFileList() {
        ArrayList r10 = new ArrayList(1);
        File r11 = this.f26171b;
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
