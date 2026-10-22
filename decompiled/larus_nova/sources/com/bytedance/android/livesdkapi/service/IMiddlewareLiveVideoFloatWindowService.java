package com.bytedance.android.livesdkapi.service;

import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\fH&J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J$\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\fH&¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/IMiddlewareLiveVideoFloatWindowService;", "Lcom/bytedance/android/live/base/IService;", "addFloatManagerListenerForOuter", "", "listener", "Lcom/bytedance/android/livesdkapi/view/IVideoFloatManager$VideoFloatManagerListener;", "hideFloatWindow", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "rootView", "Landroid/widget/FrameLayout;", "isFloatOpen", "", "isFloatWindowShowing", "onFloatWindowInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "removeFloatManagerListenerForOuter", "showFloatWindow", "extra", "Lcom/bytedance/android/livesdkapi/model/InnerContextEntity$InnerFloatExtra;", "toggleLiveAudio", "open", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMiddlewareLiveVideoFloatWindowService extends IService {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void showFloatWindow$default(IMiddlewareLiveVideoFloatWindowService r100, Fragment r101, FrameLayout r102, InnerContextEntity.InnerFloatExtra r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L6;
            r103 = null;
        L6:
            r100.showFloatWindow(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showFloatWindow");
        }
    }

    void addFloatManagerListenerForOuter(IVideoFloatManager.VideoFloatManagerListener r100);

    void hideFloatWindow(Fragment r100, FrameLayout r101);

    boolean isFloatOpen();

    boolean isFloatWindowShowing();

    boolean onFloatWindowInterceptTouchEvent(Fragment r100, MotionEvent r101);

    void removeFloatManagerListenerForOuter(IVideoFloatManager.VideoFloatManagerListener r100);

    void showFloatWindow(Fragment r100, FrameLayout r101, InnerContextEntity.InnerFloatExtra r102);

    void toggleLiveAudio(boolean r100);
}
