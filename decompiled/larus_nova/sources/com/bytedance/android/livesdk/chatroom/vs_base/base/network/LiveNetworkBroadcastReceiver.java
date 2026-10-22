package com.bytedance.android.livesdk.chatroom.vs_base.base.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class LiveNetworkBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<Context> f117897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NetworkUtils.NetworkType f117898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<WeakReference<a>, Cert> f117899c;

    public interface a {
        void a(NetworkUtils.NetworkType r100);
    }

    static {
        TokenCert.with("bpea-livenetworkbroadcastceceiver_get_network_type");
    }

    public LiveNetworkBroadcastReceiver() {
        this.f117898b = NetworkUtils.NetworkType.NONE;
        this.f117899c = new HashMap();
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.getAction() != null) goto L6;
        return;
    L6:
        if (r101.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") == false) goto L24;
        NetworkUtils.NetworkType r102 = this.f117898b;
        Iterator r103 = ((HashMap) this.f117899c).entrySet().iterator();
    L9:
        if (r103.hasNext() == false) goto L25;
        Map.Entry r104 = (Map.Entry) r103.next();
        a r105 = (a) ((WeakReference) r104.getKey()).get();
        if (r105 == null) goto L9;
        NetworkUtils.NetworkType r106 = NetworkUtils.b(r100, (Cert) r104.getValue());
        this.f117898b = r106;
        if (r102 == r106) goto L9;
        r105.a(r106);
        goto L9
    L25:
        return;
    }
}
