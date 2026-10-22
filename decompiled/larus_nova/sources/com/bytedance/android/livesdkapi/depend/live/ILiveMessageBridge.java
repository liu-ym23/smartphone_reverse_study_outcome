package com.bytedance.android.livesdkapi.depend.live;

import com.ss.ugc.live.sdk.msg.dispatch.f;
import kotlin.Metadata;
import vlc.b;
import ylc.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\n\u0010\t\u001a\u0004\u0018\u00010\bH&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/live/ILiveMessageBridge;", "", "Lcom/ss/ugc/live/sdk/msg/dispatch/f;", "createLiveMessageDecoder", "Lylc/a;", "createLiveWRDSDecoder", "Lslc/a;", "getZstdDepend", "Lvlc/b;", "getDebugInterceptor", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveMessageBridge {
    f createLiveMessageDecoder();

    a createLiveWRDSDecoder();

    b getDebugInterceptor();

    slc.a getZstdDepend();
}
