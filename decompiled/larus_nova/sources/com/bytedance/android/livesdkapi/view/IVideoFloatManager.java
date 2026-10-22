package com.bytedance.android.livesdkapi.view;

import android.widget.RelativeLayout;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0006\u0007J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/view/IVideoFloatManager;", "", "layoutParams", "", "params", "Landroid/widget/RelativeLayout$LayoutParams;", "AutoFloatEnable", "VideoFloatManagerListener", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IVideoFloatManager {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/view/IVideoFloatManager$AutoFloatEnable;", "", VideoEventOneOutSync.END_TYPE_FINISH, "", "getRequestPage", "", "isAutoFloatEnable", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface AutoFloatEnable {
        void finish();

        String getRequestPage();

        boolean isAutoFloatEnable();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J(\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0016J(\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/view/IVideoFloatManager$VideoFloatManagerListener;", "", SendEventContainerMethodParamModel.EventKinds.onClick, "", "onClose", "byUser", "", "onMuteButtonClick", "isMute", "onReturnClick", SendEventContainerMethodParamModel.EventKinds.onShow, "left", "", "top", "width", "height", "onViewPositionChanged", "onViewReleased", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface VideoFloatManagerListener {

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
        public static final class DefaultImpls {
            public static void onClick(VideoFloatManagerListener r100) {
            }

            public static void onClose(VideoFloatManagerListener r100, boolean r101) {
            }

            public static void onMuteButtonClick(VideoFloatManagerListener r100, boolean r101) {
            }

            public static void onReturnClick(VideoFloatManagerListener r100) {
            }

            public static void onShow(VideoFloatManagerListener r100) {
            }

            public static void onShow(VideoFloatManagerListener r100, int r101, int r102, int r103, int r104) {
            }

            public static void onViewPositionChanged(VideoFloatManagerListener r100, int r101, int r102, int r103, int r104) {
            }

            public static void onViewReleased(VideoFloatManagerListener r100) {
            }
        }

        void onClick();

        void onClose(boolean r100);

        void onMuteButtonClick(boolean r100);

        void onReturnClick();

        void onShow();

        void onShow(int r100, int r101, int r102, int r103);

        void onViewPositionChanged(int r100, int r101, int r102, int r103);

        void onViewReleased();
    }

    void layoutParams(RelativeLayout.LayoutParams r100);
}
