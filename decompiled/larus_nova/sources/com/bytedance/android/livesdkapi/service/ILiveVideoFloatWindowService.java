package com.bytedance.android.livesdkapi.service;

import android.app.Activity;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.floatview.IInnerFloatWindowSwitchManager;
import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u000f\u0010\b\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\nJ\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0007H&J\b\u0010\u000f\u001a\u00020\u0007H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\tH&J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH&J \u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH&J\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH&J\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH&J\b\u0010 \u001a\u00020\u0003H&J\b\u0010!\u001a\u00020\u0003H&J\b\u0010\"\u001a\u00020\u0003H&¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/ILiveVideoFloatWindowService;", "Lcom/bytedance/android/livesdkapi/service/IMiddlewareLiveVideoFloatWindowService;", "addVideoFloatManagerListener", "", "listener", "Lcom/bytedance/android/livesdkapi/view/IVideoFloatManager$VideoFloatManagerListener;", "checkWindowConflict", "", "getFloatWindowBottomMargin", "", "()Ljava/lang/Integer;", "getFloatWindowSwitchManager", "Lcom/bytedance/android/livesdkapi/floatview/IInnerFloatWindowSwitchManager;", "init", "isFloatWindowMute", "isPipOpen", "preloadVideoFloatWindowView", "activity", "Landroid/app/Activity;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/DialogFragment;", "rootView", "Landroid/widget/FrameLayout;", "removeVideoFloatManagerListener", "setFloatWindowBottomMargin", "bottomMargin", "specialHideFloatWindow", "Landroidx/fragment/app/Fragment;", "startShowFloat", "extra", "Lcom/bytedance/android/livesdkapi/model/InnerContextEntity$InnerFloatExtra;", "startShowFloatInNextLifecycle", "stopShowFloat", "stopShowFloatInNextLifecycle", "stopShowNow", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveVideoFloatWindowService extends IMiddlewareLiveVideoFloatWindowService {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void init(ILiveVideoFloatWindowService r100) {
        }
    }

    void addVideoFloatManagerListener(IVideoFloatManager.VideoFloatManagerListener r100);

    boolean checkWindowConflict();

    Integer getFloatWindowBottomMargin();

    IInnerFloatWindowSwitchManager getFloatWindowSwitchManager();

    void init();

    boolean isFloatWindowMute();

    boolean isPipOpen();

    void preloadVideoFloatWindowView(Activity r100);

    void preloadVideoFloatWindowView(DialogFragment r100, FrameLayout r101);

    void removeVideoFloatManagerListener(IVideoFloatManager.VideoFloatManagerListener r100);

    void setFloatWindowBottomMargin(int r100);

    void specialHideFloatWindow(Fragment r100, FrameLayout r101);

    void startShowFloat(Activity r100, InnerContextEntity.InnerFloatExtra r101);

    void startShowFloat(DialogFragment r100, FrameLayout r101, InnerContextEntity.InnerFloatExtra r102);

    void startShowFloatInNextLifecycle(Activity r100, InnerContextEntity.InnerFloatExtra r101);

    void startShowFloatInNextLifecycle(DialogFragment r100, InnerContextEntity.InnerFloatExtra r101);

    void stopShowFloat();

    void stopShowFloatInNextLifecycle();

    void stopShowNow();
}
