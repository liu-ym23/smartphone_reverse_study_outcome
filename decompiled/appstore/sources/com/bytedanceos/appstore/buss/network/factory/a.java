package com.bytedanceos.appstore.buss.network.factory;

import com.bytedanceos.appstore.buss.network.AssistantHttpResult;
import com.bytedanceos.appstore.buss.network.CmsHttpResult;
import com.bytedanceos.appstore.buss.network.HttpResult;
import com.bytedanceos.appstore.buss.network.HttpResultHead;
import com.bytedanceos.appstore.buss.network.ad.AdHttpResult;
import com.bytedanceos.appstore.buss.network.b;
import com.bytedanceos.appstore.buss.network.c;
import com.bytedanceos.appstore.buss.network.d;
import com.bytedanceos.appstore.buss.network.e;
import com.bytedanceos.appstore.buss.network.f;
import com.bytedanceos.appstore.buss.network.g;
import kotlin.jvm.internal.q;
import okhttp3.Headers;
import okhttp3.ResponseBody;
import retrofit2.Response;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8808a = null;

    static {
        f8808a = new a();
    }

    public a() {
    }

    public final b a(Response r10) {
        q.g(r10, "response");
        if (r10.f() == false) goto L19;
        HttpResult r11 = (HttpResult) r10.a();
        if (r11 == null) goto L29;
        HttpResultHead r12 = r11.getHead();
        if (r12.getCode() != 0) goto L11;
        b r13 = new c(r11);
    L30:
        return r13;
    L11:
        String r14 = r12.getMessage();
        if (r14 != null) goto L14;
    L17:
        String r15 = "server: unknown error";
    L18:
        StringBuilder r16 = new StringBuilder();
        r16.append(r15);
        r16.append(", logid=");
        Headers r17 = r10.e();
        q.f(r17, "headers(...)");
        r16.append(ua.a.a(r17));
        r16.append(", url=");
        r16.append(r10.h().r().k());
        r13 = new com.bytedanceos.appstore.buss.network.a(r12.getCode(), r16.toString());
        goto L30
    L14:
        if (r14.length() == 0) goto L17;
        r15 = "server: " + r12.getMessage();
        goto L18
    L29:
        return new com.bytedanceos.appstore.buss.network.a(-1, "server data is null");
    L19:
        ResponseBody r18 = r10.d();
        if (r18 == null) goto L22;
        String r19 = r18.string();
    L23:
        if (r19 != null) goto L25;
    L26:
        r19 = r10.g();
    L27:
        StringBuilder r20 = new StringBuilder();
        r20.append("network err: logid=");
        Headers r21 = r10.e();
        q.f(r21, "headers(...)");
        r20.append(ua.a.a(r21));
        r20.append(", url=");
        r20.append(r10.h().r().k());
        r20.append(", msg=");
        r20.append(r19);
        return new com.bytedanceos.appstore.buss.network.a(r10.b(), r20.toString());
    L25:
        if (r19.length() != 0) goto L27;
    L22:
        r19 = null;
        goto L23
    }

    public final com.bytedanceos.appstore.buss.network.ad.b b(Response r10) {
        q.g(r10, "response");
        if (r10.f() == false) goto L19;
        AdHttpResult r11 = (AdHttpResult) r10.a();
        if (r11 != null) goto L8;
        return new com.bytedanceos.appstore.buss.network.ad.a(-1, "server data is null");
    L8:
        if (r11.getCode() != 0) goto L11;
        com.bytedanceos.appstore.buss.network.ad.b r12 = new com.bytedanceos.appstore.buss.network.ad.c(r11);
    L30:
        return r12;
    L11:
        int r13 = r11.getCode();
        String r14 = r11.getErrinfo();
        if (r14 != null) goto L14;
    L17:
        String r15 = "server: unknown error";
    L18:
        r12 = new com.bytedanceos.appstore.buss.network.ad.a(r13, r15);
        goto L30
    L14:
        if (r14.length() == 0) goto L17;
        r15 = "server: " + r11.getErrinfo();
        goto L18
    L19:
        ResponseBody r16 = r10.d();
        if (r16 == null) goto L22;
        String r17 = r16.string();
    L23:
        if (r17 != null) goto L25;
    L26:
        r17 = r10.g();
    L27:
        StringBuilder r18 = new StringBuilder();
        r18.append("network err: logid=");
        Headers r19 = r10.e();
        q.f(r19, "headers(...)");
        r18.append(ua.a.a(r19));
        r18.append(", url=");
        r18.append(r10.h().r().k());
        r18.append(", msg=");
        r18.append(r17);
        return new com.bytedanceos.appstore.buss.network.ad.a(r10.b(), r18.toString());
    L25:
        if (r17.length() != 0) goto L27;
    L22:
        r17 = null;
        goto L23
    }

    public final e c(Response r10) {
        q.g(r10, "response");
        if (r10.f() == false) goto L19;
        AssistantHttpResult r11 = (AssistantHttpResult) r10.a();
        if (r11 != null) goto L8;
        return new d(-1, "server data is null");
    L8:
        if (r11.getCode() != 0) goto L11;
        e r12 = new f(r11);
    L37:
        return r12;
    L11:
        int r13 = r11.getCode();
        String r14 = r11.getMsg();
        if (r14 != null) goto L14;
    L17:
        String r15 = "server: unknown error";
    L18:
        r12 = new d(r13, r15);
        goto L37
    L14:
        if (r14.length() == 0) goto L17;
        r15 = "server: " + r11.getMsg();
        goto L18
    L19:
        ResponseBody r16 = r10.d();
        if (r16 == null) goto L22;
        String r17 = r16.string();
    L23:
        if (r17 != null) goto L25;
    L26:
        r17 = r10.g();
    L27:
        int r18 = r10.b();
        if (r17 != null) goto L30;
    L33:
        String r19 = "network: unknown error";
    L35:
        return new d(r18, r19);
    L30:
        if (r17.length() == 0) goto L33;
        r19 = "network: " + r17;
        goto L35
    L25:
        if (r17.length() != 0) goto L27;
    L22:
        r17 = null;
        goto L23
    }

    public final g d(Response r10) {
        q.g(r10, "response");
        String r11 = "server: unknown error";
        if (r10.f() == false) goto L18;
        CmsHttpResult r12 = (CmsHttpResult) r10.a();
        if (r12 != null) goto L8;
        return new g.a(-1, "server data is null");
    L8:
        if (r12.getCode() != 0) goto L11;
        g r13 = new g.c(r12.getCode(), r12.getMsg(), r12.getBody());
    L47:
        return r13;
    L11:
        int r14 = r12.getCode();
        String r15 = r12.getMsg();
        if (r15 != null) goto L14;
    L17:
        r13 = new g.a(r14, r11);
        goto L47
    L14:
        if (r15.length() == 0) goto L17;
        r11 = "server: " + r12.getMsg();
        goto L17
    L18:
        CmsHttpResult r16 = (CmsHttpResult) r10.a();
        String r17 = null;
        if (r16 == null) goto L21;
        String r18 = r16.getMsg();
    L22:
        if (r18 != null) goto L24;
    L25:
        CmsHttpResult r19 = (CmsHttpResult) r10.a();
        if (r19 == null) goto L28;
        r19.getMsg();
    L28:
        CmsHttpResult r20 = (CmsHttpResult) r10.a();
        if (r20 == null) goto L31;
        Integer r21 = Integer.valueOf(r20.getCode());
    L32:
        q.d(r21);
        int r22 = r21.intValue();
        CmsHttpResult r23 = (CmsHttpResult) r10.a();
        if (r23 == null) goto L35;
        String r24 = r23.getMsg();
    L36:
        if (r24 == null) goto L45;
        if (r24.length() == 0) goto L45;
        StringBuilder r25 = new StringBuilder();
        r25.append("server: ");
        CmsHttpResult r26 = (CmsHttpResult) r10.a();
        if (r26 == null) goto L43;
        r17 = r26.getMsg();
    L43:
        r25.append(r17);
        r11 = r25.toString();
    L45:
        return new g.a(r22, r11);
    L35:
        r24 = null;
        goto L36
    L31:
        r21 = null;
        goto L32
    L24:
        if (r18.length() != 0) goto L28;
    L21:
        r18 = null;
        goto L22
    }
}
