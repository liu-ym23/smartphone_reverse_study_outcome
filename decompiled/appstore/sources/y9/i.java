package y9;

import com.bytedance.apm.util.x;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.monitor.cloudmessage.upload.callback.IFileUploadCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class i extends x9.a implements IFileUploadCallback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public File f26181b;

    public i() {
        this.f26181b = null;
    }

    @Override // x9.a
    public String d() {
        return CloudControlInf.NET_FLOW;
    }

    @Override // x9.a
    public boolean e(w9.a r20) {
        JSONObject r10 = new JSONObject(r20.c());
        if (c(r10, r20) == false) goto L5;
        return true;
    L5:
        long r11 = r10.optLong("fetch_start_time", (System.currentTimeMillis() / 1000) - 18000);
        long r12 = r10.optLong("fetch_end_time", System.currentTimeMillis() / 1000);
        long r13 = r11 * 1000;
        long r14 = 1000 * r12;
        long r15 = x.c(v9.a.k().i(), r13, r14, 1);
        long r16 = x.c(v9.a.k().i(), r13, r14, 0);
        JSONObject r17 = new JSONObject();
        r17.put("netStatsWifi", r15);     // Catch: JSONException -> L8
        r17.put("netStatsMobile", r16);     // Catch: JSONException -> L8
        r17.put("netStatsTotal", r16 + r15);     // Catch: JSONException -> L8
    L10:
        File r18 = aa.d.a(v9.a.k().i(), r17);
        if (r18 != null) goto L14;
        i("网络流量信息文件生成失败", r20);
        return true;
    L14:
        this.f26181b = r18;
        ca.a.c(new da.a("json", 0, false, r20.b(), this, null));
        return true;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public List getUploadFileList() {
        ArrayList r10 = new ArrayList();
        File r11 = this.f26181b;
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
