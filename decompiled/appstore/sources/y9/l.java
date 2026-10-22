package y9;

import com.bytedanceos.common.toolbox.ServerElements;
import com.monitor.cloudmessage.callback.IPatchConsumer;
import com.monitor.cloudmessage.consts.CloudControlInf;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class l extends x9.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IPatchConsumer f26183b;

    public l() {
    }

    @Override // x9.a
    public String d() {
        return CloudControlInf.PATCH;
    }

    @Override // x9.a
    public boolean e(w9.a r10) {
        JSONObject r11 = new JSONObject(r10.c());
        if (this.f26183b != null) goto L7;
        return false;
    L7:
        if (c(r11, r10) == false) goto L9;
        return true;
    L9:
        String r12 = r11.optString("url");
        String r13 = r11.optString(ServerElements.MD5);
        this.f26183b.handlePatchMessage(r12, r13);
        w9.b r14 = this.f26183b.getConsumerResult();
        if (r14.d() == false) goto L12;
        j(r10);
    L13:
        return true;
    L12:
        h(r14.b(), r14.c(), r10);
        goto L13
    }

    public void k(IPatchConsumer r10) {
        this.f26183b = r10;
    }
}
