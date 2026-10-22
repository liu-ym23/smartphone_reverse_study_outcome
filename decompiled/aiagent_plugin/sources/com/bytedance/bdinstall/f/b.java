package com.bytedance.bdinstall.f;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;
import com.bytedance.bdinstall.an;
import com.bytedance.bdinstall.j.j;
import com.bytedance.bdinstall.t;
import com.bytedance.bdinstall.w;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: DefaultSensitiveInterceptor.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private an f6247a;

    public b() {
    }

    public void a(an r1) {
        this.f6247a = r1;
    }

    public String a() {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return "";
    L5:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6247a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getApplicationInfo().targetSdkVersion >= 26) goto L7;
        return "";
    L7:
        return Build.getSerial();
    }

    public String a(int r1) {
        return this.f6247a.ab().getImei(r1);
    }

    public String b(int r1) {
        return this.f6247a.ab().getMeid(r1);
    }

    public WifiInfo b() {
        return ((WifiManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6247a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("wifi"), WifiManager.class, "com.obric.aiagent.plugin")).getConnectionInfo();
    }

    public String a(WifiInfo r1) {
        if (r1 != null) goto L4;
        return "";
    L4:
        return r1.getSSID();
    }

    public String b(WifiInfo r1) {
        if (r1 != null) goto L4;
        return "";
    L4:
        return r1.getMacAddress();
    }

    public byte[] a(NetworkInterface r1) {
        if (r1 == null) goto L8;
        return r1.getHardwareAddress();
    L5:
        e = move-exception;
        e.printStackTrace();
    L8:
        return new byte[0];
    }

    public Enumeration<NetworkInterface> c() {
        return NetworkInterface.getNetworkInterfaces();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public List<SubscriptionInfo> d() {
        if (Build.VERSION.SDK_INT >= 22) goto L5;
        return null;
    L5:
        return SubscriptionManager.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6247a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getActiveSubscriptionInfoList();
    }

    public String a(SubscriptionInfo r2) {
        if (Build.VERSION.SDK_INT >= 22) goto L5;
        return "";
    L5:
        return r2.getIccId();
    }

    public String e() {
        return this.f6247a.ab().getDeviceId();
    }

    public String f() {
        return this.f6247a.ab().getSimSerialNumber();
    L4:
        t.a("getSSN , no permission, ignore");
        return "";
    }

    public String g() {
        return this.f6247a.ab().getNetworkOperator();
    }

    public String h() {
        return this.f6247a.ab().getNetworkOperatorName();
    }

    public String i() {
        return this.f6247a.ab().getSimCountryIso();
    }

    public String j() {
        return Locale.getDefault().getCountry();
    }

    public String k() {
        return l();
    }

    private String l() {
        if (TextUtils.isEmpty(j.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6247a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.f6247a).getString("device_id", "")) == false) goto L6;
        t.a("sdk not start. media id return null. ");
        return "";
    L6:
        Future r6 = w.a(new AnonymousClass1(this));
        return (String) ZeusTransformUtils.preCheckCast(r6.get(100, TimeUnit.MILLISECONDS), String.class, "com.obric.aiagent.plugin");
    L9:
        e = move-exception;
        t.b("media id get error", e);
        return "";
    }
}
