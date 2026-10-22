package com.bytedance.android.livehostapi.business.depend;

import com.bytedance.android.livesdkapi.eventbus.LiveRealStartEvent;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public interface IStartLiveVerifyCallback {
    public static final String TAG = "IStartLiveVerifyCallback";

    void agreeToStartLive(HashMap<String, String> r100);

    void onCancel();

    void onLiveVerfifyResult(LiveCertResult r100);

    void onStartVerifyPage();

    void onVerifyResult(LiveRealStartEvent r100);
}
