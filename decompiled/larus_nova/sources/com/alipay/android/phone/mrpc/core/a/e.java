package com.alipay.android.phone.mrpc.core.a;

import com.alipay.android.phone.mrpc.core.RpcException;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import java.util.ArrayList;
import java.util.Objects;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

/* JADX INFO: loaded from: classes28.dex */
public final class e extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f24999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f25000d;

    public e(int r100, String r101, Object r102) {
        super(r101, r102);
        this.f24999c = r100;
    }

    @Override // com.alipay.android.phone.mrpc.core.a.f
    public final void a(Object r100) {
        this.f25000d = r100;
    }

    @Override // com.alipay.android.phone.mrpc.core.a.f
    public final byte[] a() {
        ArrayList r100 = new ArrayList();     // Catch: Exception -> L19
        if (this.f25000d == null) goto L9;
        r100.add(new BasicNameValuePair("extParam", com.alipay.sdk.m.e.f.a(this.f25000d)));     // Catch: Exception -> L19
    L9:
        r100.add(new BasicNameValuePair("operationType", this.f24997a));     // Catch: Exception -> L19
        StringBuilder r101 = new StringBuilder();     // Catch: Exception -> L19
        r101.append(this.f24999c);     // Catch: Exception -> L19
        r100.add(new BasicNameValuePair("id", r101.toString()));     // Catch: Exception -> L19
        Objects.toString(this.f24998b);     // Catch: Exception -> L19
        Object r102 = this.f24998b;     // Catch: Exception -> L19
        if (r102 != null) goto L16;
        String r103 = "[]";
    L17:
        r100.add(new BasicNameValuePair("requestData", r103));     // Catch: Exception -> L19
        return URLEncodedUtils.format(r100, XML.CHARSET_UTF8).getBytes();
    L16:
        r103 = com.alipay.sdk.m.e.f.a(r102);     // Catch: Exception -> L19
    L19:
        e = move-exception;
        if (("request  =" + this.f24998b + ":" + e) != null) goto L23;
        String r104 = "";
    L25:
        throw new RpcException(9, r104, e);
    L23:
        r104 = e.getMessage();
        goto L25
    }
}
