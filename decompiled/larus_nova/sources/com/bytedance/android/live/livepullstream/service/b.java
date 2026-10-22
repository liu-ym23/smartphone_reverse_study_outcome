package com.bytedance.android.live.livepullstream.service;

import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.livehostapi.foundation.depend.LiveCall;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import com.ss.videoarch.strategy.network.IHttpExecutor;
import java.util.List;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements IHttpExecutor {

    public static final class a extends BDNetworkTagContextProviderAdapter {
        @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
        public final int triggerType() {
            return 0;
        }

        public a() {
        }
    }

    public b() {
    }

    @Override // com.ss.videoarch.strategy.network.IHttpExecutor
    public final String executeGet(String r100) {
        INetworkService r101 = (INetworkService) k.f(INetworkService.class);
        if (r101 == null) goto L10;
        LiveCall<HttpResponse> r102 = r101.get(r100, null);
        if (r102 == null) goto L10;
        HttpResponse r103 = r102.execute();
        if (r103 == null) goto L10;
        byte[] r104 = r103.getBody();
        if (r104 == null) goto L10;
    L12:
        return new String(r104, Charsets.UTF_8);
    L10:
        r104 = new byte[0];
        goto L12
    }

    @Override // com.ss.videoarch.strategy.network.IHttpExecutor
    public final String executePost(String r100, byte[] r101, String r102, String r103) {
        List<NameValuePair> r104 = CollectionsKt.listOf(new NameValuePair(BDNetworkTagManager.KEY_BD_NETWORK_REQUEST_TAG, (String) BDNetworkTagManager.getInstance().buildBDNetworkTag(new a()).second));
        INetworkService r105 = (INetworkService) k.f(INetworkService.class);
        if (r105 == null) goto L10;
        LiveCall<HttpResponse> r106 = r105.post(r100, r104, r103, r101);
        if (r106 == null) goto L10;
        HttpResponse r107 = r106.execute();
        if (r107 == null) goto L10;
        byte[] r108 = r107.getBody();
        if (r108 == null) goto L10;
    L12:
        return new String(r108, Charsets.UTF_8);
    L10:
        r108 = new byte[0];
        goto L12
    }
}
