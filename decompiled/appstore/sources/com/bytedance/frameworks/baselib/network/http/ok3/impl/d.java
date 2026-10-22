package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public class d extends EventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f7319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EventListener f7320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f7321c;

    public d(EventListener r10, e r11) {
        this.f7321c = d.class.getSimpleName();
        this.f7320b = r10;
        this.f7319a = r11;
    }

    @Override // okhttp3.EventListener
    public void callEnd(Call r10) {
        super.callEnd(r10);
        EventListener r11 = this.f7320b;
        if (r11 == null) goto L5;
        r11.callEnd(r10);
    L5:
        this.f7319a.a();
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call r10, IOException r11) {
        super.callFailed(r10, r11);
        EventListener r12 = this.f7320b;
        if (r12 == null) goto L5;
        r12.callFailed(r10, r11);
    L5:
        this.f7319a.b(r11);
    }

    @Override // okhttp3.EventListener
    public void callStart(Call r10) {
        super.callStart(r10);
        EventListener r11 = this.f7320b;
        if (r11 == null) goto L5;
        r11.callStart(r10);
    L5:
        this.f7319a.c();
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call r10, InetSocketAddress r11, Proxy r12, Protocol r13) {
        super.connectEnd(r10, r11, r12, r13);
        EventListener r14 = this.f7320b;
        if (r14 == null) goto L5;
        r14.connectEnd(r10, r11, r12, r13);
    L5:
        this.f7319a.d(r12);
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call r10, InetSocketAddress r11, Proxy r12, Protocol r13, IOException r14) {
        super.connectFailed(r10, r11, r12, r13, r14);
        EventListener r15 = this.f7320b;
        if (r15 == null) goto L5;
        r15.connectFailed(r10, r11, r12, r13, r14);
    L5:
        this.f7319a.e(r11, r14);
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call r10, InetSocketAddress r11, Proxy r12) {
        super.connectStart(r10, r11, r12);
        EventListener r13 = this.f7320b;
        if (r13 == null) goto L5;
        r13.connectStart(r10, r11, r12);
    L5:
        this.f7319a.f();
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(Call r10, Connection r11) {
        super.connectionAcquired(r10, r11);
        EventListener r12 = this.f7320b;
        if (r12 == null) goto L5;
        r12.connectionAcquired(r10, r11);
    L5:
        this.f7319a.g(r11);
    }

    @Override // okhttp3.EventListener
    public void connectionReleased(Call r10, Connection r11) {
        super.connectionReleased(r10, r11);
        EventListener r12 = this.f7320b;
        if (r12 == null) goto L6;
        r12.connectionReleased(r10, r11);
        return;
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call r10, String r11, List r12) {
        super.dnsEnd(r10, r11, r12);
        EventListener r13 = this.f7320b;
        if (r13 == null) goto L5;
        r13.dnsEnd(r10, r11, r12);
    L5:
        this.f7319a.l();
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call r10, String r11) {
        super.dnsStart(r10, r11);
        EventListener r12 = this.f7320b;
        if (r12 == null) goto L5;
        r12.dnsStart(r10, r11);
    L5:
        this.f7319a.m();
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call r10, long r11) {
        super.requestBodyEnd(r10, r11);
        EventListener r12 = this.f7320b;
        if (r12 == null) goto L5;
        r12.requestBodyEnd(r10, r11);
    L5:
        this.f7319a.q(r11);
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(Call r10) {
        super.requestBodyStart(r10);
        EventListener r11 = this.f7320b;
        if (r11 == null) goto L5;
        r11.requestBodyStart(r10);
    L5:
        this.f7319a.r();
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call r10, Request r11) {
        super.requestHeadersEnd(r10, r11);
        EventListener r12 = this.f7320b;
        if (r12 == null) goto L5;
        r12.requestHeadersEnd(r10, r11);
    L5:
        this.f7319a.s(r11);
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call r10) {
        super.requestHeadersStart(r10);
        EventListener r11 = this.f7320b;
        if (r11 == null) goto L5;
        r11.requestHeadersStart(r10);
    L5:
        this.f7319a.t();
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call r10, long r11) {
        super.responseBodyEnd(r10, r11);
        EventListener r12 = this.f7320b;
        if (r12 == null) goto L5;
        r12.responseBodyEnd(r10, r11);
    L5:
        this.f7319a.u(r11);
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call r10) {
        super.responseBodyStart(r10);
        EventListener r11 = this.f7320b;
        if (r11 == null) goto L5;
        r11.responseBodyStart(r10);
    L5:
        this.f7319a.v();
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call r10, Response r11) {
        super.responseHeadersEnd(r10, r11);
        EventListener r12 = this.f7320b;
        if (r12 == null) goto L5;
        r12.responseHeadersEnd(r10, r11);
    L5:
        this.f7319a.w(r11);
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call r10) {
        super.responseHeadersStart(r10);
        EventListener r11 = this.f7320b;
        if (r11 == null) goto L5;
        r11.responseHeadersStart(r10);
    L5:
        this.f7319a.x();
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call r10, Handshake r11) {
        super.secureConnectEnd(r10, r11);
        EventListener r12 = this.f7320b;
        if (r12 == null) goto L5;
        r12.secureConnectEnd(r10, r11);
    L5:
        this.f7319a.y();
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call r10) {
        super.secureConnectStart(r10);
        EventListener r11 = this.f7320b;
        if (r11 == null) goto L5;
        r11.secureConnectStart(r10);
    L5:
        this.f7319a.z();
    }
}
