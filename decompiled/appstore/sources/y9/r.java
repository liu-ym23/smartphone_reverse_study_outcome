package y9;

import android.text.TextUtils;
import com.bytedanceos.common.toolbox.ServerElements;
import com.monitor.cloudmessage.callback.ITemplateConsumer;
import com.monitor.cloudmessage.upload.callback.IFileUploadCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class r extends x9.a implements IFileUploadCallback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ITemplateConsumer f26188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public File f26189c;

    public r() {
        this.f26189c = null;
    }

    @Override // x9.a
    public String d() {
        return "custom";
    }

    @Override // x9.a
    public boolean e(w9.a r14) {
        String r10 = r14.c();
        if (this.f26188b != null) goto L6;
        return false;
    L6:
        JSONObject r11 = new JSONObject(r10);
        if (c(r11, r14) == false) goto L9;
        return true;
    L9:
        JSONObject r12 = r11.optJSONObject(ServerElements.TEMPLATE);
        if (r12 != null) goto L13;
        i("template字段异常", r14);
        return true;
    L13:
        r11.put("cloud_command_id", r14.b());
        String r13 = this.f26188b.handleTemplateMessage(r12);
        w9.b r15 = this.f26188b.getConsumerResult();
        if (r15.d() == true) goto L16;
        h(r15.b(), r15.c(), r14);
    L24:
        return true;
    L16:
        if (TextUtils.isEmpty(r13) == false) goto L18;
        r13 = "{\"result\" : \"no one handle it.\"}";
    L18:
        File r16 = aa.i.a(v9.a.k().i(), r13);
        if (r16 != null) goto L22;
        i("template文件生成异常", r14);
        return true;
    L22:
        this.f26189c = r16;
        ca.a.c(new da.a(r11.optString("fileContentType", "template_file_type"), 0, false, r14.b(), this, r15.c()));
        goto L24
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public List getUploadFileList() {
        ArrayList r10 = new ArrayList(1);
        File r11 = this.f26189c;
        if (r11 == null) goto L5;
        r10.add(r11.getAbsolutePath());
    L5:
        return r10;
    }

    public void k(ITemplateConsumer r10) {
        this.f26188b = r10;
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadBegin(String r10) {
    }

    @Override // com.monitor.cloudmessage.upload.callback.IFileUploadCallback
    public void notifyUploadEnd(String r10, boolean r11) {
    }
}
