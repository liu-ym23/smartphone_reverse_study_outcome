package com.bytedance.android.livesdk.sharedpref;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes11.dex */
public class a {

    @SerializedName("dns_ttl")
    public long dnsTtl;

    @SerializedName("enable_http_dns")
    public boolean enableHttpDns;

    @SerializedName("enable_node_sort")
    public boolean enableNodeSort;

    @SerializedName("enable_ping")
    public boolean enablePing;

    @SerializedName("enable_tt_httpdns")
    public boolean enableTTDns;

    @SerializedName("pull_stream_host")
    public Map<String, Set<String>> pullStreamHosts;

    @SerializedName("push_stream_host")
    public Map<String, Set<String>> pushStreamHosts;

    public a() {
        this.pullStreamHosts = null;
        this.pushStreamHosts = null;
        this.dnsTtl = 0;
        this.enableHttpDns = true;
        this.enableNodeSort = true;
        this.enablePing = true;
        this.enableTTDns = false;
    }
}
