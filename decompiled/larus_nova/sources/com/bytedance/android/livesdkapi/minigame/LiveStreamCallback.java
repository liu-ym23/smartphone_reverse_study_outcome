package com.bytedance.android.livesdkapi.minigame;

import android.os.Bundle;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&J\u001a\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\b\u0010\u0016\u001a\u00020\u0003H&J$\u0010\u0017\u001a\u00020\u00032\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007H&¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/minigame/LiveStreamCallback;", "", "onAudioCaptureChanged", "", "status", "Ljava/util/ArrayList;", "Landroid/os/Bundle;", "Lkotlin/collections/ArrayList;", "onFpsInfo", "videoTransportRealFps", "", "onInfo", "videoTransportRealKbps", "onNetworkLow", "onNetworkStatus", "", "onReconnect", "onReconnected", "onStreamEnd", "code", "error", "Lcom/bytedance/android/livesdkapi/minigame/StreamErrorExtra;", "onStreamStart", "onVideoCaptureChanged", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface LiveStreamCallback {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void onNetworkStatus(LiveStreamCallback r100, int r101) {
        }
    }

    void onAudioCaptureChanged(ArrayList<Bundle> r100);

    void onFpsInfo(float r100);

    void onInfo(float r100);

    void onNetworkLow();

    void onNetworkStatus(int r100);

    void onReconnect();

    void onReconnected();

    void onStreamEnd(int r100, StreamErrorExtra r101);

    void onStreamStart();

    void onVideoCaptureChanged(ArrayList<Bundle> r100);
}
