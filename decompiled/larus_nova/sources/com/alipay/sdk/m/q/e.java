package com.alipay.sdk.m.q;

import android.content.Context;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class e extends com.alipay.sdk.m.p.e {
    @Override // com.alipay.sdk.m.p.e
    public String a(com.alipay.sdk.m.s.a r100, String r101, JSONObject r102) {
        return r101;
    }

    @Override // com.alipay.sdk.m.p.e
    public JSONObject a() {
        return null;
    }

    @Override // com.alipay.sdk.m.p.e
    public boolean c() {
        return false;
    }

    public e() {
    }

    @Override // com.alipay.sdk.m.p.e
    public Map<String, String> a(boolean r100, String r101) {
        return new HashMap();
    }

    @Override // com.alipay.sdk.m.p.e
    public com.alipay.sdk.m.p.b a(com.alipay.sdk.m.s.a r100, Context r101, String r102) throws Throwable {
        com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.A, "mdap post");
        byte[] r103 = com.alipay.sdk.m.n.b.a(r102.getBytes(Charset.forName("UTF-8")));
        HashMap r104 = new HashMap();
        r104.put("utdId", com.alipay.sdk.m.s.b.d().c());
        r104.put("logHeader", "RAW");
        r104.put("bizCode", com.alipay.sdk.m.u.e.f25809b);
        r104.put("productId", "alipaysdk_android");
        r104.put("Content-Encoding", "Gzip");
        r104.put("productVersion", "15.8.15");
        com.alipay.sdk.m.o.a.b r105 = com.alipay.sdk.m.o.a.a(r101, new com.alipay.sdk.m.o.a.C0489a(com.alipay.sdk.m.l.a.f25457e, r104, r103));
        com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.A, "mdap got " + r105);
        if (r105 == null) goto L15;
        boolean r106 = com.alipay.sdk.m.p.e.a(r105);
        byte[] r107 = r105.f25644c;     // Catch: Exception -> L11
        if (r106 == false) goto L8;
        r107 = com.alipay.sdk.m.n.b.b(r107);     // Catch: Exception -> L11
    L8:
        return new com.alipay.sdk.m.p.b("", new String(r107, Charset.forName("UTF-8")));
    L11:
        e = move-exception;
        com.alipay.sdk.m.u.e.a(e);
        return null;
    L15:
        throw new RuntimeException("Response is null");
    }
}
