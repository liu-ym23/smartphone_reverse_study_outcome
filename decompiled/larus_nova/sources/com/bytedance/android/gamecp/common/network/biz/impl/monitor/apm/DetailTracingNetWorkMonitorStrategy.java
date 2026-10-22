package com.bytedance.android.gamecp.common.network.biz.impl.monitor.apm;

import android.text.TextUtils;
import androidx.core.util.Pools;
import com.bytedance.android.gamecp.base.network.exception.ApiException;
import com.bytedance.android.gamecp.base.network.exception.ApiServerException;
import com.bytedance.android.gamecp.base.network.exception.CustomApiServerException;
import com.bytedance.android.gamecp.base.network.exception.NetworkErrorException;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import mu.d;
import mu.f;

/* JADX INFO: loaded from: classes44.dex */
public final class DetailTracingNetWorkMonitorStrategy implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleNetLogPool f56655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f56656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f56657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f56658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f56659e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c<String, List<String>> f56660f;

    public static class SimpleNetLogPool extends Pools.SynchronizedPool<a> {
        public SimpleNetLogPool() {
            super(20);
        }

        public final a a() {
            a r100 = (a) super.acquire();
            if (r100 == null) goto L5;
            return r100;
        L5:
            return new a();
        }

        @Override // androidx.core.util.Pools.SynchronizedPool, androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public final /* bridge */ /* synthetic */ Object acquire() {
            return a();
        }

        public final boolean b(a r100) {
            r100.f56664d = "";
            r100.f56661a = "";
            r100.f56662b = "";
            r100.f56665e = 0;
            r100.f56666f = 0;
            r100.f56663c = "";
            return super.release(r100);
        }

        @Override // androidx.core.util.Pools.SynchronizedPool, androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public final /* bridge */ /* synthetic */ boolean release(Object r100) {
            return b((a) r100);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f56661a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f56662b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f56663c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f56664d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f56665e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f56666f;

        public a() {
        }

        public final String toString() {
            StringBuilder r100 = new StringBuilder("{\"path\":\"");
            r100.append(this.f56661a);
            String r101 = "";
            if ("0".equals(this.f56662b) == false) goto L5;
            String r102 = "";
        L6:
            r100.append(r102);
            if (TextUtils.isEmpty(this.f56663c) == false) goto L9;
            String r103 = "";
        L10:
            r100.append(r103);
            if (this.f56666f == 0) goto L14;
            r101 = "\", \"time\":\"" + this.f56666f;
        L14:
            r100.append(r101);
            r100.append("\", \"latency\":\"");
            r100.append(this.f56665e);
            r100.append("\", \"id\":\"");
            r100.append(this.f56664d);
            r100.append("\"}");
            return r100.toString();
        L9:
            r103 = "\", \"msg\":\"" + this.f56663c;
            goto L10
        L5:
            r102 = "\", \"code\":\"" + this.f56662b;
            goto L6
        }
    }

    @Override // mu.f
    public final void a(Request r100, Exception r101) {
        a r102 = this.f56655a.a();
        if ((r101 instanceof CustomApiServerException) == false) goto L6;
        CustomApiServerException r103 = (CustomApiServerException) r101;
        int r104 = r103.getErrorCode();
        r103.getXTtLogId();
        String r105 = "CustomApiServerException(" + r103.getErrorMsg() + ")";
    L18:
        r102.f56662b = "" + r104;
        r102.f56663c = r105;
        r102.f56661a = r100.getPath();
        r102.f56666f = System.currentTimeMillis();
        String r106 = r102.toString();
        c<String, List<String>> r107 = this.f56660f;
        if (r107 == null) goto L21;
        r107.a(r106);
    L21:
        this.f56655a.b(r102);
        return;
    L6:
        if ((r101 instanceof ApiServerException) == false) goto L9;
        ApiServerException r108 = (ApiServerException) r101;
        String r109 = "ApiServerException(" + r108.getErrorMsg() + ")";
        r104 = r108.getErrorCode();
        r105 = r109;
        goto L18
    L9:
        if ((r101 instanceof ApiException) == false) goto L12;
        ApiException r110 = (ApiException) r101;
        r104 = r110.getErrorCode();
        r105 = "ApiException(" + r110.getMessage() + ")";
        goto L18
    L12:
        if ((r101 instanceof NetworkErrorException) == false) goto L15;
        NetworkErrorException r111 = (NetworkErrorException) r101;
        r104 = r111.getStatusCode();
        r105 = "NetworkErrorException(" + r111.getMessage() + ")";
        goto L18
    L15:
        if ((r101 instanceof IOException) == false) goto L17;
        r105 = "IOException(" + r101.getMessage() + ")";
        r104 = 103;
        goto L18
    L17:
        r105 = r101.getMessage();
        r104 = -1;
        goto L18
    }

    @Override // mu.f
    public final void b(Request r100, SsResponse r101, long r102) {
        Iterator<String> r103 = this.f56659e.iterator();
    L4:
        if (r103.hasNext() == false) goto L12;
        String r104 = r103.next();
        if (r104 == null) goto L4;
        if (r100.getPath() == null) goto L4;
        if (r100.getPath().startsWith(r104) == false) goto L4;
        return;
    L12:
        Response r105 = r101.raw();
        if (r105 == null) goto L60;
        if (r100 == null) goto L61;
        a r106 = this.f56655a.a();
        r106.f56665e = r102;
        if (r105.getStatus() != 200) goto L19;
        String r107 = "0";
    L20:
        r106.f56662b = r107;
        List<Header> r108 = r105.getHeaders();
        if (r108 != null) goto L23;
    L32:
        r106.f56661a = r100.getPath();
        Object r109 = r101.body();
        if ((r109 instanceof com.bytedance.android.gamecp.base.network.response.b) == false) goto L36;
        r106.f56662b = "" + ((com.bytedance.android.gamecp.base.network.response.b) r109).statusCode;
    L39:
        if ((r109 instanceof ou.a) == false) goto L41;
        r106.f56662b = "" + ((ou.a) r109).statusCode;
    L41:
        String r110 = r106.toString();
        c<String, List<String>> r111 = this.f56660f;
        if (r111 == null) goto L44;
        r111.a(r110);
    L44:
        this.f56655a.b(r106);
        return;
    L36:
        if ((r109 instanceof com.bytedance.android.gamecp.base.network.response.a) == false) goto L39;
        r106.f56662b = "" + ((com.bytedance.android.gamecp.base.network.response.a) r109).statusCode;
        goto L39
    L23:
        if (r108.isEmpty() == true) goto L32;
        Iterator<Header> r112 = r108.iterator();
    L26:
        if (r112.hasNext() == false) goto L32;
        Header r113 = r112.next();
        if (r113 == null) goto L26;
        if ("x-tt-Logid".equalsIgnoreCase(r113.getName()) == false) goto L26;
        r106.f56664d = r113.getValue();
        goto L32
    L19:
        r107 = "http-" + r105.getStatus();
        goto L20
    L61:
        return;
    }

    public DetailTracingNetWorkMonitorStrategy(long r100, long r101, long r102, List<String> r103) {
        this.f56655a = new SimpleNetLogPool();
        this.f56659e = r103;
        this.f56656b = r100;
        this.f56657c = r101;
        this.f56658d = r102;
        this.f56660f = new c(r100, new mu.c(this), new d(this));
    }
}
