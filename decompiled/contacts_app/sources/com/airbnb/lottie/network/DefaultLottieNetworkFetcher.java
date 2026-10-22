package com.airbnb.lottie.network;

import com.bytedance.retrofit2.HttpMethodContrants;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public class DefaultLottieNetworkFetcher implements LottieNetworkFetcher {
    public DefaultLottieNetworkFetcher() {
    }

    @Override // com.airbnb.lottie.network.LottieNetworkFetcher
    public LottieFetchResult fetchSync(String r1) throws IOException {
        HttpURLConnection r0 = (HttpURLConnection) new URL(r1).openConnection();
        r0.setRequestMethod(HttpMethodContrants.GET);
        r0.connect();
        return new DefaultLottieFetchResult(r0);
    }
}
