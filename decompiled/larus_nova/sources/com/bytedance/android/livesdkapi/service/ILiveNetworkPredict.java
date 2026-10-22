package com.bytedance.android.livesdkapi.service;

import com.bytedance.android.live.base.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u001a\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000fH&¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/ILiveNetworkPredict;", "Lcom/bytedance/android/live/base/IService;", "obtainLiveSpeed", "", "obtainNetPredict", "obtainNetPredictValue", "obtainPreviousStream", "obtainStreamPredict", "obtainSynthesizePredict", "obtainSynthesizePredictValue", "obtainVideoSpeed", "onStreamOvv", "", "detail", "msg", "", "onStreamQualityChanged", "behavior", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveNetworkPredict extends IService {
    int obtainLiveSpeed();

    int obtainNetPredict();

    int obtainNetPredictValue();

    int obtainPreviousStream();

    int obtainStreamPredict();

    int obtainSynthesizePredict();

    int obtainSynthesizePredictValue();

    int obtainVideoSpeed();

    void onStreamOvv(int r100, String r101);

    void onStreamQualityChanged(int r100, String r101);
}
