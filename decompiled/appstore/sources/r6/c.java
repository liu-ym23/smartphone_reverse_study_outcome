package r6;

import com.bytedance.frameworks.baselib.network.http.IHttpClient;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.ttnet.HttpClient;

/* JADX INFO: loaded from: classes.dex */
public class c implements Client {
    public c() {
    }

    @Override // com.bytedance.retrofit2.client.Client
    public SsCall newSsCall(g6.b r10) {
        IHttpClient r11 = HttpClient.b(r10.D());
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.newSsCall(r10);
    }
}
