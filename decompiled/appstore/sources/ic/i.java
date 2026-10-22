package ic;

import android.content.Context;
import com.bytedance.ttnet.ITTNetDepend;
import com.bytedance.ttnet.TTNetInit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class i implements ITTNetDepend {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f20571b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f20572a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f20571b = new a(null);
    }

    public i(Context r10) {
        q.g(r10, "context");
        this.f20572a = r10;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public int checkHttpRequestException(Throwable r10, String[] r11) {
        q.g(r10, "tr");
        q.g(r11, "remoteIp");
        return 0;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String executeGet(int r10, String r11) {
        q.g(r11, "url");
        return null;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String getApiIHostPrefix() {
        return null;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public int getAppId() {
        return e.f20559a.a().a();
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String getCdnHostSuffix() {
        return "byteimg.com";
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String[] getConfigServers() {
        return new String[]{"tnc0-aliec2.zijieapi.com", "tnc0-alisc1.zijieapi.com"};
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public Context getContext() {
        return this.f20572a;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public ArrayList getCookieFlushPathList() {
        return null;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public Map getHostReverseMap() {
        return null;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String getHostSuffix() {
        return "snssdk.com";
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public int getProviderInt(Context r10, String r11, int r12) {
        q.g(r10, "context");
        q.g(r11, "key");
        return 0;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String getProviderString(Context r10, String r11, String r12) {
        q.g(r10, "context");
        q.g(r11, "key");
        q.g(r12, "defaultValue");
        return "";
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String getShareCookieMainDomain() {
        return null;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public Map getTTNetServiceDomainMap() {
        HashMap r10 = new HashMap();
        r10.put("httpdns", "dig.bdurl.net");
        r10.put(TTNetInit.DOMAIN_NETLOG_KEY, "crash.snssdk.com");
        r10.put(TTNetInit.DOMAIN_BOE_KEY, ".boe-gateway.byted.org");
        return r10;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public boolean isCronetPluginInstalled() {
        return true;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public boolean isPrivateApiAccessEnabled() {
        return true;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void mobOnEvent(Context r10, String r11, String r12, JSONObject r13) {
        q.g(r10, "context");
        q.g(r11, "eventName");
        q.g(r12, "labelName");
        q.g(r13, "extraJson");
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void monitorLogSend(String r10, JSONObject r11) {
        q.g(r10, "logType");
        q.g(r11, "json");
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void onAppConfigUpdated(Context r10, JSONObject r11) {
        q.g(r10, "context");
        q.g(r11, "ext_json");
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void onColdStartFinish() {
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void onNetConfigUpdate(JSONObject r10, boolean r11) {
        q.g(r10, "config");
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void onShareCookieConfigUpdated(String r10) {
        q.g(r10, "shareCookieHosts");
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void saveMapToProvider(Context r10, Map r11) {
        q.g(r10, "context");
    }
}
