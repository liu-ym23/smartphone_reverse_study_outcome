package com.obric.appstore.network;

import com.obric.appstore.network.entity.HttpResp;
import kotlin.jvm.internal.q;
import okhttp3.Headers;
import okhttp3.ResponseBody;
import retrofit2.Response;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f10963a = null;

    static {
        f10963a = new c();
    }

    public c() {
    }

    public final b a(Response r10) {
        q.g(r10, "response");
        if (r10.f() == false) goto L19;
        HttpResp r11 = (HttpResp) r10.a();
        if (r11 != null) goto L8;
        return new a(-1, "server data is null");
    L8:
        if (r11.getCode() == 0) goto L29;
        String r12 = r11.getMsg();
        if (r12 != null) goto L13;
    L16:
        String r13 = "server: unknown error";
    L17:
        StringBuilder r14 = new StringBuilder();
        r14.append(r13);
        r14.append(", logid=");
        Headers r15 = r10.e();
        q.f(r15, "headers(...)");
        r14.append(ua.a.a(r15));
        r14.append(", url=");
        r14.append(r10.h().r().k());
        a r16 = new a(r11.getCode(), r14.toString());
    L30:
        return r16;
    L13:
        if (r12.length() == 0) goto L16;
        r13 = "server: " + r11.getMsg();
        goto L17
    L29:
        return new d(r11);
    L19:
        ResponseBody r17 = r10.d();
        if (r17 == null) goto L22;
        String r18 = r17.string();
    L23:
        if (r18 != null) goto L25;
    L26:
        r18 = r10.g();
    L27:
        StringBuilder r19 = new StringBuilder();
        r19.append("network err: logid=");
        Headers r20 = r10.e();
        q.f(r20, "headers(...)");
        r19.append(ua.a.a(r20));
        r19.append(", url=");
        r19.append(r10.h().r().k());
        r19.append(", msg=");
        r19.append(r18);
        r16 = new a(r10.b(), r19.toString());
        goto L30
    L25:
        if (r18.length() != 0) goto L27;
    L22:
        r18 = null;
        goto L23
    }
}
