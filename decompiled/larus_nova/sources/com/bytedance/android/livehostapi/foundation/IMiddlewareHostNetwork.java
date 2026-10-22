package com.bytedance.android.livehostapi.foundation;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.livehostapi.foundation.base.IBaseHostNetwork;
import com.bytedance.android.livehostapi.foundation.depend.LiveCall;
import com.bytedance.android.livehostapi.foundation.depend.LiveCallback;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.bytedance.android.livesdkapi.ws.LiveWsBridge;
import com.bytedance.android.livesdkapi.ws.OnLiveWsMessageReceiveListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public interface IMiddlewareHostNetwork extends IService, IBaseHostNetwork {
    void asyncGet(String r100, List<NameValuePair> r101, LiveCallback<HttpResponse> r102) throws IOException;

    void asyncPost(String r100, List<NameValuePair> r101, String r102, byte[] r103, LiveCallback<HttpResponse> r104) throws IOException;

    InputStream doPost(String r100, String r101, Map<String, String> r102, Map<String, Object> r103);

    LiveCall<HttpResponse> downloadFile(boolean r100, int r101, String r102, List<NameValuePair> r103, Object r104) throws IOException;

    LiveCall<HttpResponse> downloadFileStreaming(boolean r100, int r101, String r102, List<NameValuePair> r103, Object r104) throws IOException;

    LiveCall<HttpResponse> get(String r100, List<NameValuePair> r101) throws IOException;

    LiveCall<HttpResponse> get(String r100, List<NameValuePair> r101, Boolean r102) throws IOException;

    Map<String, String> getCommonParams();

    String getHostDomain();

    LiveCall<HttpResponse> post(String r100, List<NameValuePair> r101, String r102, byte[] r103) throws IOException;

    LiveCall<HttpResponse> post(String r100, List<NameValuePair> r101, String r102, byte[] r103, Boolean r104) throws IOException;

    LiveWsBridge registerWsChannel(Context r100, String r101, Map<String, String> r102, Map<String, String> r103, OnLiveWsMessageReceiveListener r104, int r105, String r106);

    LiveCall<HttpResponse> uploadFile(int r100, String r101, List<NameValuePair> r102, String r103, byte[] r104, long r105, String r106) throws IOException;
}
