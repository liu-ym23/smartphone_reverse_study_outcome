package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.text.TextUtils;
import com.android.contacts.util.HanziToPinyin;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.DnsResult;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.HttpDns;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.Dns;
import okhttp3.ttnet.TTNetDns;
import okhttp3.ttnet.TTNetDnsResult;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class OkHttp3DnsParserInterceptor implements TTNetDns {
    private static volatile OkHttp3DnsParserInterceptor mInstance;
    private final String TAG;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.ok3.impl.OkHttp3DnsParserInterceptor$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$frameworks$baselib$network$http$ok3$impl$httpdns$DnsResult$Source = null;

        static {
            int[] r0 = new int[DnsResult.Source.values().length];
            $SwitchMap$com$bytedance$frameworks$baselib$network$http$ok3$impl$httpdns$DnsResult$Source = r0;
            r0[DnsResult.Source.HTTPDNS_CACHE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            $SwitchMap$com$bytedance$frameworks$baselib$network$http$ok3$impl$httpdns$DnsResult$Source[DnsResult.Source.LOCALDNS_CACHE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            $SwitchMap$com$bytedance$frameworks$baselib$network$http$ok3$impl$httpdns$DnsResult$Source[DnsResult.Source.HTTPDNS_REQUEST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            $SwitchMap$com$bytedance$frameworks$baselib$network$http$ok3$impl$httpdns$DnsResult$Source[DnsResult.Source.LOCALDNS_REQUEST.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            $SwitchMap$com$bytedance$frameworks$baselib$network$http$ok3$impl$httpdns$DnsResult$Source[DnsResult.Source.HTTPDNS_STALE_CACHE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            $SwitchMap$com$bytedance$frameworks$baselib$network$http$ok3$impl$httpdns$DnsResult$Source[DnsResult.Source.HARDCODE_IPS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$com$bytedance$frameworks$baselib$network$http$ok3$impl$httpdns$DnsResult$Source[DnsResult.Source.UNKNOWN.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public OkHttp3DnsParserInterceptor() {
        this.TAG = "OkHttp3DnsParserInterceptor";
    }

    public static OkHttp3DnsParserInterceptor inst() {
        if (mInstance != null) goto L15;
        monitor-enter(OkHttp3DnsParserInterceptor.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new OkHttp3DnsParserInterceptor();     // Catch: Throwable -> L11
    L9:
        monitor-exit(OkHttp3DnsParserInterceptor.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    @Override // okhttp3.ttnet.TTNetDns
    public TTNetDnsResult lookup(String r5, int r6) throws UnknownHostException {
        if (Logger.debug() == false) goto L5;
        Logger.d(this.TAG, "lookup address list for " + r5 + HanziToPinyin.Token.SEPARATOR + r6);
    L5:
        DnsResult r7 = HttpDns.getService().getHttpDnsResultForHostSyncBlock(r5);
        DnsResult.Source r0 = DnsResult.Source.UNKNOWN;
        List<InetAddress> r1 = new ArrayList();
        if (r7 != null) goto L8;
    L28:
        r1 = Dns.SYSTEM.lookup(r5);     // Catch: UnknownHostException -> L27
        r0 = DnsResult.Source.LOCALDNS_REQUEST;     // Catch: UnknownHostException -> L27
    L26:
        return new TTNetDnsResult(r1, constructDnsInfoJson(r1, r0));
    L8:
        if (r7.ipv4List.isEmpty() == true) goto L10;
    L11:
        Iterator<String> r2 = r7.ipv6List.iterator();
        Iterator<String> r3 = r7.ipv4List.iterator();
    L13:
        if (r2.hasNext() == true) goto L19;
        if (r3.hasNext() == true) goto L19;
        r0 = r7.source;
    L19:
        if (r2.hasNext() == false) goto L22;
        r1.add(InetAddress.getByName(r2.next()));
    L22:
        if (r3.hasNext() == false) goto L13;
        r1.add(InetAddress.getByName(r3.next()));
        goto L13
    L10:
        if (r7.ipv6List.isEmpty() == true) goto L28;
        goto L11
    }

    private String constructDnsInfoJson(List<InetAddress> r5, DnsResult.Source r6) {
        JSONObject r4 = new JSONObject();
        JSONArray r0 = new JSONArray();     // Catch: Exception -> L31
        Iterator<InetAddress> r7 = r5.iterator();     // Catch: Exception -> L31
    L5:
        if (r7.hasNext() == false) goto L11;
        InetAddress r1 = r7.next();     // Catch: Exception -> L31
        if (r1 == null) goto L5;
        if (TextUtils.isEmpty(r1.getHostAddress()) == true) goto L5;
        r0.put(r1.getHostAddress());     // Catch: Exception -> L31
        goto L5
    L11:
        r4.put("address_list", r0);     // Catch: Exception -> L31
        int r2 = 1;
        if (HttpDns.getService().isHttpDnsPrefer().get() == false) goto L14;
        int r3 = 1;
    L15:
        r4.put("httpdns_prefer", r3);     // Catch: Exception -> L31
        TTNetDnsSource r8 = TTNetDnsSource.NOT_SET;     // Catch: Exception -> L31
        TTNetDnsCacheSource r9 = TTNetDnsCacheSource.UNKNOWN;     // Catch: Exception -> L31
        switch(AnonymousClass1.$SwitchMap$com$bytedance$frameworks$baselib$network$http$ok3$impl$httpdns$DnsResult$Source[r6.ordinal()]) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            default: goto L24;
        };     // Catch: Exception -> L31
    L18:
        r8 = TTNetDnsSource.SERVE_FROM_HARDCODE_HOSTS;     // Catch: Exception -> L31
        goto L24
    L19:
        r8 = TTNetDnsSource.SERVE_FROM_CACHE;     // Catch: Exception -> L31
        r9 = TTNetDnsCacheSource.SOURCE_HTTPDNS;     // Catch: Exception -> L31
        boolean r10 = true;
    L25:
        r4.put("source", r8.mValue);     // Catch: Exception -> L31
        r4.put("cache_source", r9.mValue);     // Catch: Exception -> L31
        if (r10 == true) goto L29;
        r2 = 0;
    L29:
        r4.put("from_stale_cache", r2);     // Catch: Exception -> L31
    L34:
        return r4.toString();
    L20:
        r8 = TTNetDnsSource.SERVE_FROM_PROC_DNS_JOB;     // Catch: Exception -> L31
        goto L24
    L21:
        r8 = TTNetDnsSource.SERVE_FROM_HTTP_DNS_JOB;     // Catch: Exception -> L31
        goto L24
    L22:
        r8 = TTNetDnsSource.SERVE_FROM_CACHE;     // Catch: Exception -> L31
        r9 = TTNetDnsCacheSource.SOURCE_PROC;     // Catch: Exception -> L31
        goto L24
    L23:
        r8 = TTNetDnsSource.SERVE_FROM_CACHE;     // Catch: Exception -> L31
        r9 = TTNetDnsCacheSource.SOURCE_HTTPDNS;     // Catch: Exception -> L31
    L24:
        r10 = false;
        goto L25
    L14:
        r3 = 0;
    L31:
        e = move-exception;
        e.printStackTrace();
        goto L34
    }
}
