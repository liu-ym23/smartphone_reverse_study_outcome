package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.os.Bundle;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: LocalDnsResolveCall.java */
/* JADX INFO: loaded from: classes.dex */
public class j implements Callable<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d f8526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WeakHandler f8527d;

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Void call() {
        return call2();
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public Void call2() {
        long r0 = System.currentTimeMillis();
        ArrayList r9 = new ArrayList();
        ArrayList r10 = new ArrayList();
        InetAddress[] r2 = InetAddress.getAllByName(this.f8525b);     // Catch: UnknownHostException -> L24
        int r3 = r2.length;     // Catch: UnknownHostException -> L24
        int r4 = 0;
    L4:
        if (r4 >= r3) goto L16;
        InetAddress r5 = r2[r4];     // Catch: UnknownHostException -> L24
        if (ZeusTransformUtils.instanceOf(r5, Inet4Address.class) == false) goto L9;
        r9.add(r5.getHostAddress());     // Catch: UnknownHostException -> L24
    L14:
        r4 = r4 + 1;     // Catch: UnknownHostException -> L24
        goto L4
    L9:
        if (ZeusTransformUtils.instanceOf(r5, Inet6Address.class) == false) goto L12;
        r10.add(r5.getHostAddress());     // Catch: UnknownHostException -> L24
        goto L14
    L12:
        if (Logger.debug() == false) goto L14;
        Logger.d(this.f8524a, "local dns server returned a invalid address: " + r5.getHostAddress());     // Catch: UnknownHostException -> L24
        goto L14
    L16:
        if (Logger.debug() == false) goto L19;
        Logger.d(this.f8524a, "local dns resolved success for host: " + this.f8525b);     // Catch: UnknownHostException -> L24
    L19:
        if (r9.size() <= 0) goto L21;
    L22:
        this.f8526c.b(this.f8525b, new a(this.f8525b, System.currentTimeMillis(), r9, r10, e.getService().a().get()));     // Catch: UnknownHostException -> L24
    L27:
        if (e.getService().f().get() == true) goto L45;
        Message r6 = Message.obtain();
        r6.obj = this;
        r6.what = 1;
        Bundle r7 = new Bundle();
        r7.putString("localdns_completed_host", this.f8525b);
        r6.setData(r7);
        this.f8527d.sendMessage(r6);
        if (Logger.debug() == false) goto L31;
        Logger.d(this.f8524a, "send message to collect result handler for host : " + this.f8525b);
    L31:
        long r8 = System.currentTimeMillis() - r0;
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L43
        r1.put("host", this.f8525b);     // Catch: JSONException -> L43
        if (r9.size() == 0) goto L36;
    L38:
        r1.put("status", "succeed");     // Catch: JSONException -> L43
        ArrayList r11 = new ArrayList();     // Catch: JSONException -> L43
        r11.addAll(r10);     // Catch: JSONException -> L43
        r11.addAll(r9);     // Catch: JSONException -> L43
        r1.put("result", r11);     // Catch: JSONException -> L43
    L39:
        r1.put("rtt", r8);     // Catch: JSONException -> L43
        if (Logger.debug() == false) goto L45;
        Logger.d(this.f8524a, r1.toString());     // Catch: JSONException -> L43
        goto L45
    L36:
        if (r10.size() != 0) goto L38;
        r1.put("status", "failed");     // Catch: JSONException -> L43
        r1.put("result", "");     // Catch: JSONException -> L43
    L43:
        e = move-exception;
        e.printStackTrace();
    L45:
        this.f8526c.h(this.f8525b);
        return null;
    L21:
        if (r10.size() <= 0) goto L27;
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L27
    }
}
