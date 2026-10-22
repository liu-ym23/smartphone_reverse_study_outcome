package com.bytedance.android.livesdk.floatview;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.config.ql;
import com.bytedance.android.livesdk.config.rl;
import com.bytedance.android.livesdk.floatview.mob.VideoFloatWindowLogger;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.floatview.IInnerFloatWindowSwitchManager;
import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u0000 42\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b2\u00103J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\u0015\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016J\b\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0010H\u0016J\b\u0010 \u001a\u00020\u0010H\u0016J\b\u0010!\u001a\u00020\u0010H\u0016J\b\u0010\"\u001a\u00020\u0010H\u0016J\u0010\u0010%\u001a\u00020\f2\u0006\u0010$\u001a\u00020#H\u0016J\u0011\u0010&\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b&\u0010'J\u0012\u0010*\u001a\u00020\f2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010+\u001a\u00020\f2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\n\u0010-\u001a\u0004\u0018\u00010,H\u0016J\u0012\u0010.\u001a\u00020\f2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010/\u001a\u00020\f2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u0018\u00100\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u00100\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u00101\u001a\u00020\fH\u0016¨\u00066"}, d2 = {"Lcom/bytedance/android/livesdk/floatview/VideoFloatWindowOuterService;", "Lcom/bytedance/android/livesdkapi/service/ILiveVideoFloatWindowService;", "Lcom/bytedance/android/livesdk/floatview/NewVideoInnerFloatManager;", "getFloatManager", "Lcom/bytedance/android/livesdk/floatview/VideoFloatWindowManager;", "getOuterFloatManager", "Landroidx/fragment/app/Fragment;", WidgetService.PARAM_FRAGMENT, "Landroid/widget/FrameLayout;", "rootView", "Lcom/bytedance/android/livesdkapi/model/InnerContextEntity$InnerFloatExtra;", "extra", "", "showFloatWindow", "Landroid/view/MotionEvent;", "event", "", "onFloatWindowInterceptTouchEvent", "hideFloatWindow", "specialHideFloatWindow", "Landroidx/fragment/app/DialogFragment;", "startShowFloat", "Landroid/app/Activity;", "activity", "startShowFloatInNextLifecycle", "stopShowFloatInNextLifecycle", "stopShowFloat", "stopShowNow", "isPipOpen", "isFloatOpen", ITTVideoEngineEventSource.KEY_MUTE, "toggleLiveAudio", "checkWindowConflict", "isFloatWindowMute", "isFloatWindowShowing", "", "bottomMargin", "setFloatWindowBottomMargin", "getFloatWindowBottomMargin", "()Ljava/lang/Integer;", "Lcom/bytedance/android/livesdkapi/view/IVideoFloatManager$VideoFloatManagerListener;", "listener", "addVideoFloatManagerListener", "removeVideoFloatManagerListener", "Lcom/bytedance/android/livesdkapi/floatview/IInnerFloatWindowSwitchManager;", "getFloatWindowSwitchManager", "addFloatManagerListenerForOuter", "removeFloatManagerListenerForOuter", "preloadVideoFloatWindowView", "init", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class VideoFloatWindowOuterService implements ILiveVideoFloatWindowService {
    public static final a Companion = null;
    private static final String TAG = "VideoFloatWindowOuterService";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public VideoFloatWindowOuterService() {
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService
    public void init() {
        int r100 = px1.a.f530862a;
        String r101 = "init() >>> " + getFloatManager();
        Intrinsics.checkNotNullParameter(TAG, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        ALogger.d("ECFloatWindow_VideoFloatWindowOuterService", r101);
    }

    @Override // com.bytedance.android.livesdkapi.service.IMiddlewareLiveVideoFloatWindowService
    public boolean isFloatOpen() {
        boolean r100 = p.f125259a;
        return p.d(jc1.a.b());
    }

    private final NewVideoInnerFloatManager getFloatManager() {
        if (TTLiveService.getLiveService() != null) goto L6;
        return null;
    L6:
        q r100 = NewVideoInnerFloatManager.f125055p;
        return NewVideoInnerFloatManager.b.a();
    }

    private final VideoFloatWindowManager getOuterFloatManager() {
        if (TTLiveService.getLiveService() != null) goto L6;
        return null;
    L6:
        q r100 = VideoFloatWindowManager.f125075f;
        return VideoFloatWindowManager.b.a();
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService
    public boolean checkWindowConflict() {
        NewVideoInnerFloatManager r100 = getFloatManager();
        if (r100 == null) goto L14;
        int r101 = r100.f125063f;
        if (r101 != 2) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 != true) goto L15;
        return true;
    L15:
        return false;
    L7:
        if (r101 == 3) goto L10;
        r102 = false;
        goto L11
    L14:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService
    public Integer getFloatWindowBottomMargin() {
        NewVideoInnerFloatManager r100 = getFloatManager();
        ViewGroup.LayoutParams r101 = null;
        if (r100 == null) goto L20;
        VideoFloatWindowView r102 = r100.f125059b;
        if (r102 == null) goto L9;
        FrameLayout r103 = r102.getVideoContainer();
        if (r103 == null) goto L9;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
    L11:
        if ((r104 instanceof RelativeLayout.LayoutParams) == false) goto L14;
        r101 = r104;
    L14:
        RelativeLayout.LayoutParams r105 = (RelativeLayout.LayoutParams) r101;
        if (r105 == null) goto L17;
        int r106 = r105.bottomMargin;
    L19:
        return Integer.valueOf(r106);
    L17:
        r106 = (int) 86.0f;
    L9:
        r104 = null;
        goto L11
    L20:
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService
    public IInnerFloatWindowSwitchManager getFloatWindowSwitchManager() {
        if (TTLiveService.getLiveService() != null) goto L7;
        return null;
    L7:
        return com.bytedance.android.livesdk.floatview.inner.e.f125180a;
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService
    public boolean isFloatWindowMute() {
        NewVideoInnerFloatManager r100 = getFloatManager();
        if (r100 == null) goto L16;
        VideoFloatWindowView r101 = r100.f125059b;
        if (r101 == null) goto L11;
        LivePlayerView r102 = r101.getMLivePlayerView$livesdk_saasRelease();
        if (r102 == null) goto L11;
        ILivePlayerClient r103 = r102.getClient();
        if (r103 == null) goto L11;
        boolean r104 = r103.isMute();
    L13:
        if (r104 != true) goto L17;
        return true;
    L17:
        return false;
    L11:
        r104 = false;
        goto L13
    L16:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.service.IMiddlewareLiveVideoFloatWindowService
    public boolean isFloatWindowShowing() {
        if (getFloatManager() != null) goto L5;
    L7:
        return false;
    L5:
        if (NewVideoInnerFloatManager.j() != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService
    public boolean isPipOpen() {
        return p.f();
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService
    public void stopShowFloat() {
        NewVideoInnerFloatManager r100 = getFloatManager();
        if (r100 == null) goto L6;
        r100.s();
        return;
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService
    public void stopShowFloatInNextLifecycle() {
        NewVideoInnerFloatManager r100 = getFloatManager();
        if (r100 == null) goto L8;
        ALogger.i("NewVideoInnerFloatManager", "stopShowFloatInNextLifecycle, floatWindowCurrentState: " + r100.f125063f);
        if (r100.f125063f != 2) goto L9;
        r100.f125063f = 3;
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService
    public void stopShowNow() {
        NewVideoInnerFloatManager r100 = getFloatManager();
        if (r100 == null) goto L6;
        r100.r();
        return;
    }

    @Override // com.bytedance.android.livesdkapi.service.IMiddlewareLiveVideoFloatWindowService
    public void addFloatManagerListenerForOuter(IVideoFloatManager.VideoFloatManagerListener r100) {
        VideoFloatWindowManager r101 = getOuterFloatManager();
        if (r101 == null) goto L6;
        r101.addVideoFloatManagerListener(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService
    public void addVideoFloatManagerListener(IVideoFloatManager.VideoFloatManagerListener r100) {
        NewVideoInnerFloatManager r101 = getFloatManager();
        if (r101 == null) goto L10;
        if (r100 != null) goto L7;
        return;
    L7:
        if (((ArrayList) r101.f125061d).contains(r100) == true) goto L11;
        ((ArrayList) r101.f125061d).add(r100);
        ALogger.d("NewVideoInnerFloatManager", "add listener " + r100 + ", size: " + ((ArrayList) r101.f125061d).size());
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService
    public void preloadVideoFloatWindowView(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        NewVideoInnerFloatManager r101 = getFloatManager();
        if (r101 == null) goto L11;
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (LiveInfraSettingKeys.PRELOAD_COMMERCE_FLOAT_WINDOW_VIEW.getValue().booleanValue() == false) goto L12;
        FrameLayout r102 = ox1.d.a(r100, null).getRootView();
        if (r102 == null) goto L13;
        r101.f125060c = new VideoFloatWindowView(r102.getContext(), 1);
        return;
    L13:
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.service.IMiddlewareLiveVideoFloatWindowService
    public void removeFloatManagerListenerForOuter(IVideoFloatManager.VideoFloatManagerListener r100) {
        VideoFloatWindowManager r101 = getOuterFloatManager();
        if (r101 == null) goto L6;
        r101.removeVideoFloatManagerListener(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService
    public void removeVideoFloatManagerListener(IVideoFloatManager.VideoFloatManagerListener r100) {
        NewVideoInnerFloatManager r101 = getFloatManager();
        if (r101 == null) goto L10;
        if (r100 != null) goto L7;
        return;
    L7:
        if (((ArrayList) r101.f125061d).contains(r100) == false) goto L11;
        ((ArrayList) r101.f125061d).remove(r100);
        ALogger.d("NewVideoInnerFloatManager", "remove listener " + r100 + ", size: " + ((ArrayList) r101.f125061d).size());
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService
    public void setFloatWindowBottomMargin(int r100) {
        NewVideoInnerFloatManager r101 = getFloatManager();
        if (r101 == null) goto L18;
        if (r100 < 0) goto L21;
        VideoFloatWindowView r102 = r101.f125059b;
        if (r102 == null) goto L19;
        FrameLayout r103 = r102.getVideoContainer();
        if (r103 == null) goto L20;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        RelativeLayout.LayoutParams r105 = null;
        if ((r104 instanceof RelativeLayout.LayoutParams) == true) goto L13;
        r104 = null;
    L13:
        RelativeLayout.LayoutParams r106 = (RelativeLayout.LayoutParams) r104;
        if (r106 == null) goto L16;
        r106.bottomMargin = (int) t6.a(jc1.a.b(), r100);
        r106.topMargin = 0;
        Unit r107 = Unit.INSTANCE;
        r105 = r106;
    L16:
        r103.setLayoutParams(r105);
        return;
    L20:
        return;
    L19:
        return;
    L21:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.service.IMiddlewareLiveVideoFloatWindowService
    public void toggleLiveAudio(boolean r100) {
        NewVideoInnerFloatManager r101 = getFloatManager();
        if (r101 == null) goto L19;
        VideoFloatWindowView r102 = r101.f125059b;
        if (r102 == null) goto L20;
        ALogger.i("VideoFloatWindowView", "toggleLiveAudio: " + r100);
        r102.a(R.id.float_mute).setSelected(r100);
        r102.f125104t = Boolean.valueOf(r100);
        if (r100 == false) goto L13;
        LivePlayerView r103 = r102.f125093i;
        if (r103 == null) goto L21;
        ILivePlayerClient r104 = r103.getClient();
        if (r104 == null) goto L22;
        r104.mute("VideoFloatWindowView.toggleLiveAudio");
        return;
    L22:
        return;
    L21:
        return;
    L13:
        LivePlayerView r105 = r102.f125093i;
        if (r105 == null) goto L24;
        ILivePlayerClient r106 = r105.getClient();
        if (r106 == null) goto L25;
        r106.unmute("VideoFloatWindowView.toggleLiveAudio");
        return;
    L25:
        return;
    L24:
        return;
    L20:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdkapi.service.IMiddlewareLiveVideoFloatWindowService
    public void hideFloatWindow(Fragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        NewVideoInnerFloatManager r102 = getFloatManager();
        if (r102 == null) goto L10;
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        if ((r100 instanceof IVideoFloatManager.AutoFloatEnable) == true) goto L7;
        return;
    L7:
        if (((IVideoFloatManager.AutoFloatEnable) r100).isAutoFloatEnable() == false) goto L12;
        ALogger.i("NewVideoInnerFloatManager", "detachFragment by " + r100);
        r102.s();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.service.IMiddlewareLiveVideoFloatWindowService
    public boolean onFloatWindowInterceptTouchEvent(Fragment r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "event");
        NewVideoInnerFloatManager r102 = getFloatManager();
        if (r102 == null) goto L13;
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "event");
        if (r102.f125065h != r100.hashCode()) goto L16;
        VideoFloatWindowView r103 = r102.f125059b;
        if (r103 == null) goto L14;
        Intrinsics.checkNotNullParameter(r101, "event");
        Boolean r104 = Boolean.valueOf(((DragRelativeLayout) r103.a(R.id.float_drag_container)).a(r101));
        if (r104 != null) goto L12;
        return false;
    L12:
        return r104.booleanValue();
    L14:
        return false;
    L16:
        return false;
    L13:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService
    public void preloadVideoFloatWindowView(DialogFragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        NewVideoInnerFloatManager r102 = getFloatManager();
        if (r102 == null) goto L11;
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        if (LiveInfraSettingKeys.PRELOAD_COMMERCE_FLOAT_WINDOW_VIEW.getValue().booleanValue() == false) goto L12;
        FrameLayout r103 = ox1.d.b(r100, r101, null).getRootView();
        if (r103 == null) goto L13;
        r102.f125060c = new VideoFloatWindowView(r103.getContext(), 1);
        return;
    L13:
        return;
    L12:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService
    public void specialHideFloatWindow(Fragment r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        NewVideoInnerFloatManager r102 = getFloatManager();
        if (r102 == null) goto L14;
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        if ((r100 instanceof IVideoFloatManager.AutoFloatEnable) == true) goto L7;
        return;
    L7:
        if (((IVideoFloatManager.AutoFloatEnable) r100).isAutoFloatEnable() == false) goto L16;
        ALogger.i("NewVideoInnerFloatManager", "specialDetachFragment by " + r100 + ", floatWindowCurrentState = " + r102.f125063f);
        if (ql.f121065a.getValue().booleanValue() == true) goto L11;
    L12:
        r102.s();
        return;
    L11:
        if (r102.f125063f != 1) goto L12;
        return;
    L16:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService
    public void startShowFloat(Activity r100, InnerContextEntity.InnerFloatExtra r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "extra");
        NewVideoInnerFloatManager r102 = getFloatManager();
        if (r102 == null) goto L24;
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "extra");
        if (((List) r102.f125068k.getValue()).contains(r100.getClass().getSimpleName()) == true) goto L7;
        Lazy r103 = VideoFloatWindowLogger.f125239a;
        VideoFloatWindowLogger r104 = VideoFloatWindowLogger.a.a();
        String r105 = r100.getClass().getSimpleName();
        r104.getClass();
        VideoFloatWindowLogger.b(r105);
    L7:
        NewVideoInnerFloatManager.c(r101.getBusinessLine());
        NewVideoInnerFloatManager.g();
        boolean r106 = true;
        if (p.a() == true) goto L13;
        if ((!Intrinsics.areEqual(r101.getRequestPage(), "live_cloud_game")) == false) goto L13;
        ALogger.i("NewVideoInnerFloatManager", "isFloatInsideWindowOpen is false");
        return;
    L13:
        if (r101.getSkipCheckResumed() == true) goto L20;
        Activity r107 = ((IHostApp) jc1.k.n(IHostApp.class)).getTopActivity();
        Class<?> r108 = r100.getClass();
        if (r107 == null) goto L18;
        Class<?> r109 = r107.getClass();
    L19:
        r106 = Intrinsics.areEqual(r108, r109);
        goto L20
    L18:
        r109 = null;
    L20:
        if (r106 == true) goto L22;
        ALogger.i("NewVideoInnerFloatManager", "entity is not resumed");
        return;
    L22:
        ALogger.i("NewVideoInnerFloatManager", "startShowFloat by " + r100);
        r102.e();
        r102.f125067j = r101;
        InnerContextEntity r110 = ox1.d.a(r100, r101);
        r110.setRequestPage(r101.getRequestPage());
        ((ArrayList) r102.f125064g).add(r110);
        r102.f125063f = 2;
        r102.b(r110, (LifecycleOwner) r100);
        r102.f125065h = r100.hashCode();
        return;
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService
    public void startShowFloatInNextLifecycle(Activity r100, InnerContextEntity.InnerFloatExtra r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "extra");
        NewVideoInnerFloatManager r102 = getFloatManager();
        if (r102 == null) goto L12;
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "extra");
        if (((List) r102.f125068k.getValue()).contains(r100.getClass().getSimpleName()) == true) goto L7;
        Lazy r103 = VideoFloatWindowLogger.f125239a;
        VideoFloatWindowLogger r104 = VideoFloatWindowLogger.a.a();
        String r105 = r100.getClass().getSimpleName();
        r104.getClass();
        VideoFloatWindowLogger.b(r105);
    L7:
        NewVideoInnerFloatManager.c(r101.getBusinessLine());
        NewVideoInnerFloatManager.g();
        if (p.a() == true) goto L10;
        ALogger.i("NewVideoInnerFloatManager", "isFloatInsideWindowOpen is false");
        return;
    L10:
        ALogger.i("NewVideoInnerFloatManager", "startShowFloatInNextLifecycle by " + r100);
        r102.e();
        r102.f125063f = 1;
        r102.f125065h = r100.hashCode();
        r102.f125067j = r101;
        return;
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService
    public void startShowFloatInNextLifecycle(DialogFragment r100, InnerContextEntity.InnerFloatExtra r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "extra");
        NewVideoInnerFloatManager r102 = getFloatManager();
        if (r102 == null) goto L12;
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "extra");
        if (((List) r102.f125068k.getValue()).contains(r100.getClass().getSimpleName()) == true) goto L7;
        Lazy r103 = VideoFloatWindowLogger.f125239a;
        VideoFloatWindowLogger r104 = VideoFloatWindowLogger.a.a();
        String r105 = r100.getClass().getSimpleName();
        r104.getClass();
        VideoFloatWindowLogger.b(r105);
    L7:
        NewVideoInnerFloatManager.c(r101.getBusinessLine());
        NewVideoInnerFloatManager.g();
        if (p.a() == true) goto L10;
        ALogger.i("NewVideoInnerFloatManager", "isFloatInsideWindowOpen is false");
        return;
    L10:
        ALogger.i("NewVideoInnerFloatManager", "startShowFloatInNextLifecycle by " + r100);
        r102.e();
        r102.f125063f = 1;
        r102.f125065h = r100.hashCode();
        r102.f125067j = r101;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdkapi.service.IMiddlewareLiveVideoFloatWindowService
    public void showFloatWindow(Fragment r100, FrameLayout r101, InnerContextEntity.InnerFloatExtra r102) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        NewVideoInnerFloatManager r103 = getFloatManager();
        if (r103 == null) goto L24;
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        if (((List) r103.f125068k.getValue()).contains(r100.getClass().getSimpleName()) == true) goto L7;
        Lazy r104 = VideoFloatWindowLogger.f125239a;
        VideoFloatWindowLogger r105 = VideoFloatWindowLogger.a.a();
        String r106 = r100.getClass().getSimpleName();
        r105.getClass();
        VideoFloatWindowLogger.b(r106);
    L7:
        NewVideoInnerFloatManager.g();
        if (p.a() == true) goto L11;
        ALogger.i("NewVideoInnerFloatManager", "isFloatInsideWindowOpen is false");
        return;
    L11:
        if ((r100 instanceof IVideoFloatManager.AutoFloatEnable) == false) goto L26;
        IVideoFloatManager.AutoFloatEnable r107 = (IVideoFloatManager.AutoFloatEnable) r100;
        if (r107.isAutoFloatEnable() == false) goto L27;
        ALogger.i("NewVideoInnerFloatManager", "attachFragment by " + r100);
        r103.e();
        if (r102 != null) goto L17;
        InnerContextEntity.InnerFloatExtra r108 = new InnerContextEntity.InnerFloatExtra();
    L18:
        r108.setRequestPage(r107.getRequestPage());
        Unit r109 = Unit.INSTANCE;
        r103.f125067j = r108;
        InnerContextEntity r110 = new InnerContextEntity(r107, r101, true);
        r110.setRequestPage(r107.getRequestPage());
        r110.setDataSource(ox1.c.a(r102));
        if (r102 == null) goto L21;
        HashMap<String, String> r111 = r102.getMobParams();
    L22:
        r110.setMobParams(r111);
        r110.setEnterExtra(r103.f125067j);
        ((ArrayList) r103.f125064g).add(r110);
        r103.b(r110, r100);
        r103.f125063f = 3;
        r103.f125065h = r100.hashCode();
        return;
    L21:
        r111 = null;
        goto L22
    L17:
        r108 = r102;
        goto L18
    L27:
        return;
    L26:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService
    public void startShowFloat(DialogFragment r100, FrameLayout r101, InnerContextEntity.InnerFloatExtra r102) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        Intrinsics.checkNotNullParameter(r102, "extra");
        NewVideoInnerFloatManager r103 = getFloatManager();
        if (r103 == null) goto L19;
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        Intrinsics.checkNotNullParameter(r102, "extra");
        if (((List) r103.f125068k.getValue()).contains(r100.getClass().getSimpleName()) == true) goto L7;
        Lazy r104 = VideoFloatWindowLogger.f125239a;
        VideoFloatWindowLogger r105 = VideoFloatWindowLogger.a.a();
        String r106 = r100.getClass().getSimpleName();
        r105.getClass();
        VideoFloatWindowLogger.b(r106);
    L7:
        NewVideoInnerFloatManager.c(r102.getBusinessLine());
        NewVideoInnerFloatManager.g();
        if (p.a() == true) goto L13;
        if ((!Intrinsics.areEqual(r102.getRequestPage(), "live_cloud_game")) == false) goto L13;
        ALogger.i("NewVideoInnerFloatManager", "isFloatInsideWindowOpen is false");
        return;
    L13:
        if (r100.isResumed() == false) goto L15;
    L17:
        ALogger.i("NewVideoInnerFloatManager", "startShowFloat by " + r100);
        r103.e();
        r103.f125067j = r102;
        InnerContextEntity r107 = ox1.d.b(r100, r101, r102);
        r107.setRequestPage(r102.getRequestPage());
        ((ArrayList) r103.f125064g).add(r107);
        r103.f125063f = 2;
        r103.b(r107, r100);
        r103.f125065h = r100.hashCode();
        return;
    L15:
        if (rl.f121140a.getValue().booleanValue() == false) goto L17;
        ALogger.i("NewVideoInnerFloatManager", "entity is not resumed");
        return;
    }
}
