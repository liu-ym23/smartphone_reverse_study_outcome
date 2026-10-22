package com.bytedance.android.live.saas.middleware.utuid.network;

import com.bytedance.common.utility.NetworkClient;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nd.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J0\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/utuid/network/NetworkUtUidImpl;", "Lnd/a;", "", "getSdkVersion", "url", "", "data", "", "requestHeaders", UGCMonitor.TYPE_POST, "<init>", "()V", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class NetworkUtUidImpl implements a {
    public NetworkUtUidImpl() {
    }

    @Override // nd.a
    public String getSdkVersion() {
        return String.valueOf(4210);
    }

    @Override // nd.a
    public String post(String r100, byte[] r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        NetworkClient.ReqContext r103 = new NetworkClient.ReqContext();
        r103.addCommonParams = true;
        return NetworkClient.getDefault().post(r100, r101, r102, r103);
    }
}
