package f9;

import android.content.Context;
import com.bytedance.ttnet.ITTNetDepend;
import com.bytedance.ttnet.TTNetInit;
import com.bytedanceos.common.BaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g implements ITTNetDepend {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile g f19543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String[] f19544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Map f19545c;

    static {
        f19544b = new String[]{"dm.toutiao.com", "dm.bytedance.com", "dm.pstatp.com"};
        HashMap r10 = new HashMap(6);
        f19545c = r10;
        r10.put("ib.snssdk.com", "ib");
        f19545c.put("security.snssdk.com", "si");
        f19545c.put("isub.snssdk.com", "isub");
        f19545c.put("ichannel.snssdk.com", "ichannel");
        f19545c.put("log.snssdk.com", "log");
        f19545c.put("mon.snssdk.com", "mon");
    }

    public g() {
    }

    public static g a() {
        if (f19543a != null) goto L16;
        monitor-enter(g.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f19543a != null) goto L11;
        f19543a = new g();     // Catch: Throwable -> L9
    L11:
        monitor-exit(g.class);     // Catch: Throwable -> L9
    L16:
        return f19543a;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public int checkHttpRequestException(Throwable r10, String[] r11) {
        return 0;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String executeGet(int r10, String r11) {
        return null;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String getApiIHostPrefix() {
        return "ib";
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public int getAppId() {
        return 508474;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String getCdnHostSuffix() {
        return ".pstatp.com";
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String[] getConfigServers() {
        return f19544b;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public Context getContext() {
        return BaseApplication.c();
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public ArrayList getCookieFlushPathList() {
        return null;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public Map getHostReverseMap() {
        return f19545c;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String getHostSuffix() {
        return ".snssdk.com";
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public int getProviderInt(Context r10, String r11, int r12) {
        return 0;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String getProviderString(Context r10, String r11, String r12) {
        return null;
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
        return false;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public boolean isPrivateApiAccessEnabled() {
        return false;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void mobOnEvent(Context r10, String r11, String r12, JSONObject r13) {
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void monitorLogSend(String r10, JSONObject r11) {
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void onAppConfigUpdated(Context r10, JSONObject r11) {
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void onColdStartFinish() {
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void onNetConfigUpdate(JSONObject r10, boolean r11) {
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void onShareCookieConfigUpdated(String r10) {
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void saveMapToProvider(Context r10, Map r11) {
    }
}
