package com.obric.aiagent.ttnet.a;

import com.bytedance.ttnet.TTNetInit;
import d.a.ao;
import d.a.p;
import d.m;
import d.s;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: TTNetConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f22200a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<String> f22201b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, String> f22202c = null;

    private a() {
    }

    public final List<String> a() {
        return f22201b;
    }

    static {
        f22200a = new a();
        f22201b = p.b(new String[]{"tnc3-bjlgy.snssdk.com", "tnc3-alisc1.snssdk.com", "tnc3-aliec2.snssdk.com"});
        f22202c = ao.a(new m[]{s.a(TTNetInit.DOMAIN_HTTPDNS_KEY, "dig.bdurl.net"), s.a(TTNetInit.DOMAIN_NETLOG_KEY, "crash.snssdk.com"), s.a(TTNetInit.DOMAIN_BOE_KEY, ".boe-gateway.byted.org")});
    }

    public final Map<String, String> b() {
        return f22202c;
    }
}
