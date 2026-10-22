package com.android.ttcjpaysdk.thirdparty.front.counter.manager;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/manager/GuideManager;", "", "()V", "CallBack", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GuideManager {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0006H&J \u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH&¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/manager/GuideManager$CallBack;", "", "getPwd", "", "getTrackInfoSource", "hideLoading", "", "isAnimVertical", "", "onToGuide", "performHeightAnimation", "unknownHeight", "", "isRemove", "isDoLayerAnimation", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface CallBack {
        String getPwd();

        String getTrackInfoSource();

        void hideLoading();

        boolean isAnimVertical();

        void onToGuide();

        void performHeightAnimation(int r100, boolean r101, boolean r102);
    }

    public GuideManager() {
    }
}
