package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.android.contacts.common.SimContactsConstants;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.HttpDnsUtil;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.HttpsURLConnClient;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.IPAddressUtils;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.Ipv6ConnectionManager;
import com.bytedance.ttnet.utils.MultiProcessFileUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class HttpDnsResolveCall implements Callable<Void> {
    private static final String DEVICE_PLATFORM = "android";
    private static final String HTTPDNS_SOURCE = "tt-ok";
    public static final String MSG_HTTPDDNS_COMPLETED_HOSTS_KEY = "httpdns_completed_hosts";
    public static final int MSG_HTTPDNS_COMPLETED = 3;
    private static final String TAG = "HttpDnsResolveCall";
    private DnsRecord.CacheStaleReason mCacheStaleReason;
    private List<String> mCallbackHostList;
    private List<String> mHostList;
    private final HostResolveManager mHostResolveManager;
    private String mHosts;
    private final WeakHandler mHttpDnsHanlder;
    private final String mSdkVersion;
    private int mType;

    static {
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Void call() throws Exception {
        return call2();
    }

    HttpDnsResolveCall(String r2, String r3, HostResolveManager r4, DnsRecord.CacheStaleReason r5, WeakHandler r6) {
        this.mHostList = new ArrayList();
        this.mCallbackHostList = new ArrayList();
        this.mType = 0;
        this.mHosts = r2;
        this.mSdkVersion = r3;
        this.mHostResolveManager = r4;
        this.mCacheStaleReason = r5;
        this.mHttpDnsHanlder = r6;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public Void call2() {
        String[] r0 = this.mHosts.split(SimContactsConstants.EMAIL_SEP);
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        String r3 = r0[r2];
        this.mHostList.add(r3);
        this.mCallbackHostList.add(r3);
        r2 = r2 + 1;
        goto L3
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d(TAG, "Start httpdns resolve for host : " + this.mHostList);
    L8:
        String r4 = HttpDns.getService().getHttpDnsDomain();
        if (HttpDns.getService().getHttpDnsDomainHardCodeIps().size() != 0) goto L12;
        this.mHostResolveManager.resetHttpDnsDomainFailedCnt();
    L12:
        if (HttpDnsUtil.isValidHost(r4) == true) goto L14;
    L18:
        String r5 = null;
    L19:
        if (r5 == null) goto L21;
        parseHttpDnsResponse(r5);
        this.mHostResolveManager.resetHttpDnsDomainFailedCnt();
    L37:
        Iterator<String> r6 = this.mHostList.iterator();
    L39:
        if (r6.hasNext() == false) goto L41;
        String r7 = r6.next();
        this.mHostResolveManager.removeHttpDnsResolvingFuture(r7);
        this.mHostResolveManager.removeHttpDnsCache(r7);
        goto L39
    L41:
        Message r8 = Message.obtain();
        r8.obj = this;
        r8.what = 3;
        Bundle r9 = new Bundle();
        r9.putStringArrayList(MSG_HTTPDDNS_COMPLETED_HOSTS_KEY, (ArrayList) this.mCallbackHostList);
        r8.setData(r9);
        this.mHttpDnsHanlder.sendMessage(r8);
        if (Logger.debug() == false) goto L44;
        Logger.d(TAG, "send message to collect result handler for host : " + this.mCallbackHostList);
    L44:
        return null;
    L21:
        Iterator<String> r10 = HttpDns.getService().getHttpDnsDomainHardCodeIps().iterator();
    L23:
        if (r10.hasNext() == false) goto L37;
        String r11 = r10.next();
        if (IPAddressUtils.isValidIpv4(r11) == true) goto L31;
        if (IPAddressUtils.isValidIpv6(r11) == true) goto L31;
        if (Logger.debug() == false) goto L23;
        Logger.d(TAG, "httpdns backup domian hardcode ip: " + r11 + " is invalid");
    L31:
        String r12 = doHttpDnsRequest(r11);
        if (r12 != null) goto L36;
        if (Logger.debug() == false) goto L23;
        Logger.d(TAG, "httpdns request failed use hardcode ip: " + r11 + " try next hardcode ip");
        goto L23
    L36:
        parseHttpDnsResponse(r12);
        goto L37
    L14:
        if (this.mHostResolveManager.getHttpDnsDomainFailedCnt().get() >= 2) goto L18;
        r5 = doHttpDnsRequest(r4);
        if (r5 != null) goto L19;
        this.mHostResolveManager.addHttpDnsDomainFailedCnt();
        goto L19
    }

    private String doHttpDnsRequest(String r5) {
        StringBuilder r0 = new StringBuilder("https://");
        if (Ipv6ConnectionManager.getIpv6GloballyReachable().get() == true) goto L5;
        this.mType = 1;
    L5:
        r0.append(r5).append("/q?host=").append(this.mHosts).append("&aid=").append(HttpDns.getService().getHttpDnsDepend().getAppId()).append("&okhttp_version=").append(this.mSdkVersion).append("&p=android&source=tt-ok&f=").append(this.mType).append("&reason=").append(this.mCacheStaleReason.ordinal() - 1);
        if (this.mHostResolveManager.getDetectedHardCodeipsCnt().get() >= 3) goto L9;
        r0.append("&refresh_bkup_ip=1");
        this.mHostResolveManager.setDetectedHardCodeipsCnt();
    L9:
        return HttpsURLConnClient.executeGet(r0.toString(), r5);
    }

    private void parseHttpDnsResponse(String r4) {
        if (Logger.debug() == false) goto L26;
        Logger.d(TAG, "parseHttpDnsResponse");
    L26:
        if (TextUtils.isEmpty(r4) == false) goto L8;
        return;
    L8:
        JSONObject r0 = new JSONObject(r4);     // Catch: JSONException -> L22
        if (this.mHostList.size() <= 1) goto L17;
        JSONArray r5 = r0.optJSONArray(MultiProcessFileUtils.KEY_DNS);     // Catch: JSONException -> L22
        if (r5 != null) goto L13;
        return;
    L13:
        int r1 = 0;
    L15:
        if (r1 >= r5.length()) goto L18;
        parseSingleHostHttpDnsResponse(r5.optJSONObject(r1));     // Catch: JSONException -> L22
        r1 = r1 + 1;     // Catch: JSONException -> L22
    L18:
        JSONArray r3 = r0.optJSONArray("httpdns_backup_ip");     // Catch: JSONException -> L22
        if (r3 == null) goto L29;
        HttpDns.getService().setHttpDnsHardCodeIps(r3);     // Catch: JSONException -> L22
        return;
    L29:
        return;
    L17:
        parseSingleHostHttpDnsResponse(r0);     // Catch: JSONException -> L22
    L23:
        if (Logger.debug() == false) goto L30;
        Logger.d(TAG, "httpdns server returned a invalid json response.");
        return;
    }

    private void parseSingleHostHttpDnsResponse(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        String r0 = r10.optString("host");
        if (Logger.debug() == false) goto L7;
        Logger.d(TAG, "parseSingleHostHttpDnsResponse for host " + r0);
    L7:
        int r7 = r10.optInt("ttl");
        JSONArray r11 = r10.optJSONArray("ips");
        ArrayList r5 = new ArrayList();
        ArrayList r6 = new ArrayList();
        if (r11 == null) goto L23;
        int r1 = 0;
    L11:
        if (r1 >= r11.length()) goto L23;
        String r2 = r11.optString(r1);
        if (IPAddressUtils.isValidIpv6(r2) == false) goto L16;
        r6.add(r2);
    L21:
        r1 = r1 + 1;
        goto L11
    L16:
        if (IPAddressUtils.isValidIpv4(r2) == false) goto L19;
        r5.add(r2);
        goto L21
    L19:
        if (Logger.debug() == false) goto L21;
        Logger.d(TAG, "httpdns server returned a invalid address: " + r2);
    L23:
        if (this.mHostList.contains(r0) == true) goto L25;
        return;
    L25:
        if (r5.size() <= 0) goto L27;
    L28:
        this.mHostResolveManager.addHttpDnsCache(r0, new DnsRecord(r0, System.currentTimeMillis(), r5, r6, r7));
        this.mHostResolveManager.removeHttpDnsResolvingFuture(r0);
        this.mHostList.remove(r0);
        return;
    L27:
        if (r6.size() > 0) goto L28;
    }
}
