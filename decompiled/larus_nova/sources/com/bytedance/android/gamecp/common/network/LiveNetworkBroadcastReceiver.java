package com.bytedance.android.gamecp.common.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.android.gamecp.common.utils.NetworkUtils;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public class LiveNetworkBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<Context> f56620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NetworkUtils.NetworkType f56621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<WeakReference<a>, Cert> f56622c;

    public interface a {
        void a(NetworkUtils.NetworkType r100);
    }

    static {
        TokenCert.with("bpea-livenetworkbroadcastceceiver_get_network_type");
    }

    public LiveNetworkBroadcastReceiver() {
        this.f56621b = NetworkUtils.NetworkType.NONE;
        this.f56622c = new HashMap();
    }

    public final void a(a r100) {
        Iterator r101 = ((HashMap) this.f56622c).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L12;
        Map.Entry r102 = (Map.Entry) r101.next();
        if (r100.equals(((WeakReference) r102.getKey()).get()) == false) goto L4;
        Map<WeakReference<a>, Cert> r103 = this.f56622c;
        HashMap r104 = (HashMap) r103;
        r104.remove(r102.getKey());
        return;
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
        NetworkUtils.NetworkType r102 = this.f56621b;
        Iterator r103 = ((HashMap) this.f56622c).entrySet().iterator();
    L9:
        if (r103.hasNext() == false) goto L25;
        Map.Entry r104 = (Map.Entry) r103.next();
        a r105 = (a) ((WeakReference) r104.getKey()).get();
        if (r105 == null) goto L9;
        NetworkUtils.NetworkType r106 = NetworkUtils.b(r100, (Cert) r104.getValue());
        this.f56621b = r106;
        if (r102 == r106) goto L9;
        r105.a(r106);
        goto L9
    L25:
        return;
    }
}
