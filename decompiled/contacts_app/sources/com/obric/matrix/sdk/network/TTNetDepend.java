package com.obric.matrix.sdk.network;

import android.content.Context;
import com.bytedance.ttnet.ITTNetDepend;
import com.bytedance.ttnet.TTNetInit;
import com.obric.oui.material.MaterialConfigBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTNetDepend.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 82\u00020\u0001:\u00018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0002\u0010\fJ\u001a\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\u001c\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u0018H\u0016J\u0016\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u000bH\u0016J \u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J \u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J\n\u0010 \u001a\u0004\u0018\u00010\u000bH\u0016J\u0014\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001aH\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020#H\u0016J(\u0010%\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020*H\u0016J\u0018\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020*H\u0016J\u0018\u0010.\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010/\u001a\u00020*H\u0016J\b\u00100\u001a\u00020&H\u0016J\u0018\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020*2\u0006\u00103\u001a\u00020#H\u0016J\u0010\u00104\u001a\u00020&2\u0006\u00105\u001a\u00020\u000bH\u0016J&\u00106\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u00107\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0002\b\u0003\u0018\u00010\u001aH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/obric/matrix/sdk/network/TTNetDepend;", "Lcom/bytedance/ttnet/ITTNetDepend;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "checkHttpRequestException", "", "tr", "", "remoteIp", "", "", "(Ljava/lang/Throwable;[Ljava/lang/String;)I", "executeGet", "maxLength", "url", "getApiIHostPrefix", "getAppId", "getCdnHostSuffix", "getConfigServers", "()[Ljava/lang/String;", "getContext", "getCookieFlushPathList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getHostReverseMap", "", "getHostSuffix", "getProviderInt", "key", "defaultValue", "getProviderString", "getShareCookieMainDomain", "getTTNetServiceDomainMap", "isCronetPluginInstalled", "", "isPrivateApiAccessEnabled", "mobOnEvent", "", "eventName", "labelName", "extraJson", "Lorg/json/JSONObject;", "monitorLogSend", "logType", MaterialConfigBuilder.SERIALIZATION_FORMAT_JSON, "onAppConfigUpdated", "ext_json", "onColdStartFinish", "onNetConfigUpdate", "config", "localData", "onShareCookieConfigUpdated", "shareCookieHosts", "saveMapToProvider", "map", "Companion", "sdk_network_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TTNetDepend implements ITTNetDepend {
    public static final Companion Companion = null;
    private static final String TAG = "TTNetDepend";
    private final Context context;

    /* JADX INFO: compiled from: TTNetDepend.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/matrix/sdk/network/TTNetDepend$Companion;", "", "()V", "TAG", "", "sdk_network_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public int checkHttpRequestException(Throwable r1, String[] r2) {
        Intrinsics.checkNotNullParameter(r1, "tr");
        Intrinsics.checkNotNullParameter(r2, "remoteIp");
        return 0;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String executeGet(int r1, String r2) throws Exception {
        Intrinsics.checkNotNullParameter(r2, "url");
        return null;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String getApiIHostPrefix() {
        return null;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String getCdnHostSuffix() {
        return "byteimg.com";
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public ArrayList<String> getCookieFlushPathList() {
        return null;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public Map<String, String> getHostReverseMap() {
        return null;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String getHostSuffix() {
        return "snssdk.com";
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public int getProviderInt(Context r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "key");
        return 0;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String getProviderString(Context r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "defaultValue");
        return "";
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String getShareCookieMainDomain() {
        return null;
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
    public void mobOnEvent(Context r1, String r2, String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "labelName");
        Intrinsics.checkNotNullParameter(r4, "extraJson");
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void monitorLogSend(String r1, JSONObject r2) {
        Intrinsics.checkNotNullParameter(r1, "logType");
        Intrinsics.checkNotNullParameter(r2, MaterialConfigBuilder.SERIALIZATION_FORMAT_JSON);
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void onAppConfigUpdated(Context r1, JSONObject r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "ext_json");
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void onColdStartFinish() {
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void onNetConfigUpdate(JSONObject r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "config");
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void onShareCookieConfigUpdated(String r1) {
        Intrinsics.checkNotNullParameter(r1, "shareCookieHosts");
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void saveMapToProvider(Context r1, Map<String, ?> r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
    }

    public TTNetDepend(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.context = r2;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public Context getContext() {
        return this.context;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String[] getConfigServers() {
        return new String[]{"tnc0-aliec2.zijieapi.com", "tnc0-alisc1.zijieapi.com"};
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public int getAppId() {
        return NetworkSDKInit.INSTANCE.getConfig().getAppId();
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public Map<String, String> getTTNetServiceDomainMap() {
        HashMap r2 = new HashMap();
        r2.put(TTNetInit.DOMAIN_HTTPDNS_KEY, "dig.bdurl.net");
        r2.put(TTNetInit.DOMAIN_NETLOG_KEY, "crash.snssdk.com");
        r2.put(TTNetInit.DOMAIN_BOE_KEY, ".boe-gateway.byted.org");
        return r2;
    }
}
