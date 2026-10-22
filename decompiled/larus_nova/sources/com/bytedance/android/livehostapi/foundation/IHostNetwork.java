package com.bytedance.android.livehostapi.foundation;

import android.content.Context;
import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.livehostapi.foundation.depend.LiveCall;
import com.bytedance.android.livesdkapi.listener.UploadProgressListener;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.bytedance.android.livesdkapi.network.ILiveRetrofitWrapper;
import com.bytedance.android.livesdkapi.ws.LiveWsBridge;
import com.bytedance.android.livesdkapi.ws.OnLiveWsMessageReceiveListener;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostNetwork extends IMiddlewareHostNetwork, IHostNetworkForSaas {
    ILiveRetrofitWrapper getRetrofitInstanceV2();

    @Override // com.bytedance.android.livehostapi.foundation.IMiddlewareHostNetwork
    LiveWsBridge registerWsChannel(Context r100, String r101, Map<String, String> r102, Map<String, String> r103, OnLiveWsMessageReceiveListener r104, int r105, String r106);

    LiveCall<HttpResponse> uploadLargeFile(int r100, String r101, List<NameValuePair> r102, File r103, UploadProgressListener r104) throws IOException;
}
