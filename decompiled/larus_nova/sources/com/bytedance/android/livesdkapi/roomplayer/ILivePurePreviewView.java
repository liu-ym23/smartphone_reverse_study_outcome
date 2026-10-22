package com.bytedance.android.livesdkapi.roomplayer;

import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/ILivePurePreviewView;", "", "addStateListener", "", "listener", "Lcom/bytedance/android/livesdkapi/roomplayer/IPreviewStateListener;", "changeMuteState", ITTVideoEngineEventSource.KEY_MUTE, "", SendEventContainerMethodParamModel.EventKinds.onShow, "release", "stop", "stream", "jsonData", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePurePreviewView {
    void addStateListener(IPreviewStateListener r100);

    void changeMuteState(boolean r100);

    void onShow();

    void release();

    void stop();

    void stream(String r100);
}
