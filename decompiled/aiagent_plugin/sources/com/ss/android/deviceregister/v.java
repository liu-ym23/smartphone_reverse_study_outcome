package com.ss.android.deviceregister;

import android.net.wifi.WifiInfo;
import android.telephony.SubscriptionInfo;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;

/* JADX INFO: compiled from: SensitiveApiCallback.java */
/* JADX INFO: loaded from: classes4.dex */
public interface v {
    String a();

    String a(WifiInfo r1);

    String a(SubscriptionInfo r1);

    byte[] a(NetworkInterface r1);

    String b();

    String b(WifiInfo r1);

    String c();

    String d();

    String e();

    String f();

    String g();

    String h();

    WifiInfo i();

    Enumeration<NetworkInterface> j();

    List<SubscriptionInfo> k();

    String l();

    String m();
}
