package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import okhttp3.Call;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.ad;
import okhttp3.v;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class OkHttp3EventListener extends okhttp3.r {
    private final String TAG;
    private final m mOkHttp3RequestLog;
    private final okhttp3.r mOriginEventListener;

    public OkHttp3EventListener(okhttp3.r r2, m r3) {
        this.TAG = OkHttp3EventListener.class.getSimpleName();
        this.mOriginEventListener = r2;
        this.mOkHttp3RequestLog = r3;
    }

    @Override // okhttp3.r
    public void callStart(okhttp3.e r3) {
        okhttp3.e r4 = (okhttp3.e) ZeusTransformUtils.wrapperContextForParams(r3, okhttp3.e.class, "com.obric.aiagent.plugin");
        super.callStart(r4);
        okhttp3.r r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.callStart(r4);
    L5:
        this.mOkHttp3RequestLog.b();
    }

    @Override // okhttp3.r
    public void dnsStart(okhttp3.e r3, String r4) {
        okhttp3.e r5 = (okhttp3.e) ZeusTransformUtils.wrapperContextForParams(r3, okhttp3.e.class, "com.obric.aiagent.plugin");
        super.dnsStart(r5, r4);
        okhttp3.r r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.dnsStart(r5, r4);
    L5:
        this.mOkHttp3RequestLog.c();
    }

    @Override // okhttp3.r
    public void dnsEnd(okhttp3.e r3, String r4, List<InetAddress> r5) {
        okhttp3.e r6 = (okhttp3.e) ZeusTransformUtils.wrapperContextForParams(r3, okhttp3.e.class, "com.obric.aiagent.plugin");
        List<InetAddress> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        super.dnsEnd(r6, r4, r7);
        okhttp3.r r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.dnsEnd(r6, r4, r7);
    L5:
        this.mOkHttp3RequestLog.d();
    }

    public void dnsEnd(okhttp3.e r3, String r4, List<InetAddress> r5, String r6) {
        okhttp3.e r7 = (okhttp3.e) ZeusTransformUtils.wrapperContextForParams(r3, okhttp3.e.class, "com.obric.aiagent.plugin");
        List<InetAddress> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        super.dnsEnd(r7, r4, r8, r6);
        okhttp3.r r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.dnsEnd(r7, r4, r8);
    L5:
        this.mOkHttp3RequestLog.a(r6);
    }

    @Override // okhttp3.r
    public void connectStart(okhttp3.e r3, InetSocketAddress r4, Proxy r5) {
        okhttp3.e r6 = (okhttp3.e) ZeusTransformUtils.wrapperContextForParams(r3, okhttp3.e.class, "com.obric.aiagent.plugin");
        super.connectStart(r6, r4, r5);
        okhttp3.r r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.connectStart(r6, r4, r5);
    L5:
        this.mOkHttp3RequestLog.e();
    }

    @Override // okhttp3.r
    public void secureConnectStart(okhttp3.e r3) {
        okhttp3.e r4 = (okhttp3.e) ZeusTransformUtils.wrapperContextForParams(r3, okhttp3.e.class, "com.obric.aiagent.plugin");
        super.secureConnectStart(r4);
        okhttp3.r r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.secureConnectStart(r4);
    L5:
        this.mOkHttp3RequestLog.f();
    }

    @Override // okhttp3.r
    public void secureConnectEnd(okhttp3.e r3, okhttp3.t r4) {
        okhttp3.e r5 = (okhttp3.e) ZeusTransformUtils.wrapperContextForParams(r3, okhttp3.e.class, "com.obric.aiagent.plugin");
        super.secureConnectEnd(r5, r4);
        okhttp3.r r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.secureConnectEnd(r5, r4);
    L5:
        this.mOkHttp3RequestLog.g();
    }

    @Override // okhttp3.r
    public void connectEnd(okhttp3.e r3, InetSocketAddress r4, Proxy r5, aa r6) {
        okhttp3.e r7 = (okhttp3.e) ZeusTransformUtils.wrapperContextForParams(r3, okhttp3.e.class, "com.obric.aiagent.plugin");
        super.connectEnd(r7, r4, r5, r6);
        okhttp3.r r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.connectEnd(r7, r4, r5, r6);
    L5:
        this.mOkHttp3RequestLog.a(r5);
    }

    @Override // okhttp3.r
    public void connectFailed(okhttp3.e r7, InetSocketAddress r8, Proxy r9, aa r10, IOException r11) {
        okhttp3.e r12 = (okhttp3.e) ZeusTransformUtils.wrapperContextForParams(r7, okhttp3.e.class, "com.obric.aiagent.plugin");
        super.connectFailed(r12, r8, r9, r10, r11);
        okhttp3.r r0 = this.mOriginEventListener;
        if (r0 == null) goto L6;
        r0.connectFailed(r12, r8, r9, r10, r11);
        return;
    }

    public void connectFailed(okhttp3.e r8, InetSocketAddress r9, Proxy r10, aa r11, IOException r12, String r13) {
        okhttp3.e r14 = (okhttp3.e) ZeusTransformUtils.wrapperContextForParams(r8, okhttp3.e.class, "com.obric.aiagent.plugin");
        super.connectFailed(r14, r9, r10, r11, r12, r13);
        okhttp3.r r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.connectFailed(r14, r9, r10, r11, r12);
    L5:
        this.mOkHttp3RequestLog.a(r9, r12, r13);
    }

    @Override // okhttp3.r
    public void connectionAcquired(okhttp3.e r3, okhttp3.j r4) {
        okhttp3.e r5 = (okhttp3.e) ZeusTransformUtils.wrapperContextForParams(r3, okhttp3.e.class, "com.obric.aiagent.plugin");
        okhttp3.j r6 = (okhttp3.j) ZeusTransformUtils.wrapperContextForParams(r4, okhttp3.j.class, "com.obric.aiagent.plugin");
        super.connectionAcquired(r5, r6);
        okhttp3.r r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.connectionAcquired(r5, r6);
    L5:
        this.mOkHttp3RequestLog.a(r6);
    }

    @Override // okhttp3.r
    public void connectionReleased(okhttp3.e r3, okhttp3.j r4) {
        okhttp3.e r5 = (okhttp3.e) ZeusTransformUtils.wrapperContextForParams(r3, okhttp3.e.class, "com.obric.aiagent.plugin");
        okhttp3.j r6 = (okhttp3.j) ZeusTransformUtils.wrapperContextForParams(r4, okhttp3.j.class, "com.obric.aiagent.plugin");
        super.connectionReleased(r5, r6);
        okhttp3.r r2 = this.mOriginEventListener;
        if (r2 == null) goto L6;
        r2.connectionReleased(r5, r6);
        return;
    }

    @Override // okhttp3.r
    public void requestHeadersStart(okhttp3.e r3) {
        okhttp3.e r4 = (okhttp3.e) ZeusTransformUtils.wrapperContextForParams(r3, okhttp3.e.class, "com.obric.aiagent.plugin");
        super.requestHeadersStart(r4);
        okhttp3.r r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.requestHeadersStart(r4);
    L5:
        this.mOkHttp3RequestLog.h();
    }

    @Override // okhttp3.r
    public void requestHeadersEnd(okhttp3.e r3, ab r4) {
        okhttp3.e r5 = (okhttp3.e) ZeusTransformUtils.wrapperContextForParams(r3, okhttp3.e.class, "com.obric.aiagent.plugin");
        super.requestHeadersEnd(r5, r4);
        okhttp3.r r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.requestHeadersEnd(r5, r4);
    L5:
        this.mOkHttp3RequestLog.a(r4);
    }

    @Override // okhttp3.r
    public void requestBodyStart(okhttp3.e r3) {
        okhttp3.e r4 = (okhttp3.e) ZeusTransformUtils.wrapperContextForParams(r3, okhttp3.e.class, "com.obric.aiagent.plugin");
        super.requestBodyStart(r4);
        okhttp3.r r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.requestBodyStart(r4);
    L5:
        this.mOkHttp3RequestLog.i();
    }

    @Override // okhttp3.r
    public void requestBodyEnd(okhttp3.e r3, long r4) {
        okhttp3.e r5 = (okhttp3.e) ZeusTransformUtils.wrapperContextForParams(r3, okhttp3.e.class, "com.obric.aiagent.plugin");
        super.requestBodyEnd(r5, r4);
        okhttp3.r r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.requestBodyEnd(r5, r4);
    L5:
        this.mOkHttp3RequestLog.a(r4);
    }

    @Override // okhttp3.r
    public void responseHeadersStart(okhttp3.e r3) {
        okhttp3.e r4 = (okhttp3.e) ZeusTransformUtils.wrapperContextForParams(r3, okhttp3.e.class, "com.obric.aiagent.plugin");
        super.responseHeadersStart(r4);
        okhttp3.r r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.responseHeadersStart(r4);
    L5:
        this.mOkHttp3RequestLog.j();
    }

    @Override // okhttp3.r
    public void responseHeadersEnd(okhttp3.e r3, ad r4) {
        okhttp3.e r5 = (okhttp3.e) ZeusTransformUtils.wrapperContextForParams(r3, okhttp3.e.class, "com.obric.aiagent.plugin");
        super.responseHeadersEnd(r5, r4);
        okhttp3.r r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.responseHeadersEnd(r5, r4);
    L5:
        this.mOkHttp3RequestLog.a(r4);
    }

    @Override // okhttp3.r
    public void responseBodyStart(okhttp3.e r3) {
        okhttp3.e r4 = (okhttp3.e) ZeusTransformUtils.wrapperContextForParams(r3, okhttp3.e.class, "com.obric.aiagent.plugin");
        super.responseBodyStart(r4);
        okhttp3.r r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.responseBodyStart(r4);
    L5:
        this.mOkHttp3RequestLog.k();
    }

    @Override // okhttp3.r
    public void responseBodyEnd(okhttp3.e r3, long r4) {
        okhttp3.e r5 = (okhttp3.e) ZeusTransformUtils.wrapperContextForParams(r3, okhttp3.e.class, "com.obric.aiagent.plugin");
        super.responseBodyEnd(r5, r4);
        okhttp3.r r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.responseBodyEnd(r5, r4);
    L5:
        this.mOkHttp3RequestLog.b(r4);
    }

    @Override // okhttp3.r
    public void callEnd(okhttp3.e r3) {
        okhttp3.e r4 = (okhttp3.e) ZeusTransformUtils.wrapperContextForParams(r3, okhttp3.e.class, "com.obric.aiagent.plugin");
        super.callEnd(r4);
        okhttp3.r r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.callEnd(r4);
    L5:
        this.mOkHttp3RequestLog.l();
    }

    @Override // okhttp3.r
    public void callFailed(okhttp3.e r3, IOException r4) {
        okhttp3.e r5 = (okhttp3.e) ZeusTransformUtils.wrapperContextForParams(r3, okhttp3.e.class, "com.obric.aiagent.plugin");
        super.callFailed(r5, r4);
        okhttp3.r r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.callFailed(r5, r4);
    L5:
        this.mOkHttp3RequestLog.a(r4);
    }

    public void callInSecureRedirect(okhttp3.e r3, JSONObject r4) {
        Call r5 = (okhttp3.e) ZeusTransformUtils.wrapperContextForParams(r3, okhttp3.e.class, "com.obric.aiagent.plugin");
        super.callInSecureRedirect(r5, r4);
        okhttp3.r r2 = this.mOriginEventListener;
        if (r2 == null) goto L5;
        r2.callInSecureRedirect(r5, r4);
    L5:
        com.bytedance.frameworks.baselib.network.http.ok3.a r6 = r.i();
        if (r6 == null) goto L9;
        r6.a(r4.toString(), "ttnet_insec_rect");
        return;
    }

    public v callRedirectDispatch(okhttp3.e r3, v r4, String r5, v r6) {
        okhttp3.e r7 = (okhttp3.e) ZeusTransformUtils.wrapperContextForParams(r3, okhttp3.e.class, "com.obric.aiagent.plugin");
        return com.bytedance.frameworks.baselib.network.http.ok3.impl.b.a.b.a().a(r4, r6, r5, this.mOkHttp3RequestLog);
    }
}
