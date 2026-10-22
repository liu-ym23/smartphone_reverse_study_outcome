package y9;

import com.bytedanceos.common.toolbox.ServerElements;
import com.monitor.cloudmessage.callback.IPluginConsumer;
import com.monitor.cloudmessage.consts.CloudControlInf;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class n extends x9.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IPluginConsumer f26185b;

    public n() {
    }

    @Override // x9.a
    public String d() {
        return CloudControlInf.PLUGIN;
    }

    @Override // x9.a
    public boolean e(w9.a r10) {
        JSONObject r11 = new JSONObject(r10.c());
        if (this.f26185b != null) goto L5;
        return false;
    L5:
        String r12 = r11.optString("packageName");
        int r13 = r11.optInt("versionCode");
        String r14 = r11.optString("url");
        String r15 = r11.optString(ServerElements.MD5);
        boolean r16 = r11.optBoolean("wifiOnly", false);
        this.f26185b.handlePluginMessage(r12, r13, r14, r15, r16);
        w9.b r17 = this.f26185b.getConsumerResult();
        if (r17.d() == false) goto L8;
        j(r10);
        return true;
    L8:
        h(r17.b(), r17.c(), r10);
        return true;
    }

    public void k(IPluginConsumer r10) {
        this.f26185b = r10;
    }
}
