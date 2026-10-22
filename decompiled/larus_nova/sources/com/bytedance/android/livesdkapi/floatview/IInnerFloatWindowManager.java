package com.bytedance.android.livesdkapi.floatview;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J(\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\fH&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\fH\u0016J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u0003H&¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/floatview/IInnerFloatWindowManager;", "Lcom/bytedance/android/live/base/IService;", "addVideoFloatManagerListener", "", "listener", "Lcom/bytedance/android/livesdkapi/view/IVideoFloatManager$VideoFloatManagerListener;", "dismissFloatWindow", "roomId", "", "reason", "", "needResetLinkerState", "", "dismissWindowWhenToDesktop", "floatWindowEntityExists", "floatWindowIsShowing", "hideFloatWindow", "hideWindowWhenToDesktop", "removeVideoFloatManagerListener", BasicTestActionHandler.TEST_ACTION_RESET, "showFloatWindow", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IInnerFloatWindowManager extends IService {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static boolean dismissWindowWhenToDesktop(IInnerFloatWindowManager r100) {
            return false;
        }

        public static boolean hideWindowWhenToDesktop(IInnerFloatWindowManager r100) {
            return false;
        }

        public static /* synthetic */ void dismissFloatWindow$default(IInnerFloatWindowManager r100, long r101, String r102, boolean r103, int r104, Object r105) {
            if (r105 != null) goto L15;
            if ((r104 & 1) == 0) goto L7;
            r101 = 0;
        L7:
            if ((r104 & 2) == 0) goto L10;
            r102 = null;
        L10:
            if ((r104 & 4) == 0) goto L12;
            r103 = true;
        L12:
            r100.dismissFloatWindow(r101, r102, r103);
            return;
        L15:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dismissFloatWindow");
        }
    }

    void addVideoFloatManagerListener(IVideoFloatManager.VideoFloatManagerListener r100);

    void dismissFloatWindow(long r100, String r101, boolean r102);

    boolean dismissWindowWhenToDesktop();

    boolean floatWindowEntityExists();

    boolean floatWindowIsShowing();

    void hideFloatWindow();

    boolean hideWindowWhenToDesktop();

    void removeVideoFloatManagerListener(IVideoFloatManager.VideoFloatManagerListener r100);

    void reset();

    void showFloatWindow();
}
