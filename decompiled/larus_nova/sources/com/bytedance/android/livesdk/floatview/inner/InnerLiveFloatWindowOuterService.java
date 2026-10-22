package com.bytedance.android.livesdk.floatview.inner;

import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.floatview.FloatWindowConfig;
import com.bytedance.android.livesdkapi.floatview.IInnerFloatWindowManager;
import com.bytedance.android.livesdkapi.floatview.IInnerFloatWindowSceneInterceptor;
import com.bytedance.android.livesdkapi.service.IInnerLiveFloatWindowService;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0012\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/floatview/inner/InnerLiveFloatWindowOuterService;", "Lcom/bytedance/android/livesdkapi/service/IInnerLiveFloatWindowService;", "()V", "addVideoFloatManagerListener", "", "listener", "Lcom/bytedance/android/livesdkapi/view/IVideoFloatManager$VideoFloatManagerListener;", "dismissFloatWindow", "reason", "", "floatWindowIsShowing", "", "getFloatWindowTag", "getManagers", "", "Lcom/bytedance/android/livesdkapi/floatview/IInnerFloatWindowManager;", "isContinueShowingWhenBackground", "removeVideoFloatManagerListener", "showLiveSteamFloatWindow", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "floatWindowConfig", "Lcom/bytedance/android/livesdkapi/floatview/FloatWindowConfig;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class InnerLiveFloatWindowOuterService implements IInnerLiveFloatWindowService {
    public InnerLiveFloatWindowOuterService() {
    }

    @Override // com.bytedance.android.livesdkapi.service.IInnerLiveFloatWindowService
    public boolean isContinueShowingWhenBackground() {
        if (LiveInfraSettingKeys.LIVE_ENABLE_INNER_FLOAT_WINDOW_TO_OUT.getValue().booleanValue() == true) goto L5;
        return false;
    L5:
        List<IInnerFloatWindowManager> r100 = getManagers();
        if (r100 != null) goto L8;
        return false;
    L8:
        Iterator<IInnerFloatWindowManager> r101 = r100.iterator();
    L10:
        if (r101.hasNext() == false) goto L34;
        IInnerFloatWindowManager r102 = r101.next();
        if (r102 != null) goto L14;
    L18:
        boolean r103 = false;
    L20:
        if (com.bytedance.android.livesdk.sharedpref.b.f158168k0.getValue().booleanValue() == false) goto L22;
    L23:
        if (r102 != null) goto L25;
    L27:
        boolean r104 = false;
    L28:
        if (r102 == null) goto L10;
        if (r102.floatWindowIsShowing() != true) goto L10;
        if (r103 == true) goto L10;
        if (r104 == true) goto L10;
        return true;
    L25:
        if (r102.hideWindowWhenToDesktop() != true) goto L27;
    L26:
        r104 = true;
        goto L28
    L22:
        if (LiveInfraSettingKeys.LIVE_ENABLE_INNER_FLOAT_WINDOW_TO_OUT.getValue().booleanValue() == false) goto L26;
    L14:
        if (r102.floatWindowEntityExists() != true) goto L18;
        if (r102.dismissWindowWhenToDesktop() != true) goto L18;
        r103 = true;
        goto L20
    L34:
        return false;
    }

    private final List<IInnerFloatWindowManager> getManagers() {
        if (TTLiveService.getLiveService() != null) goto L7;
        return null;
    L7:
        return b.f125164b;
    }

    @Override // com.bytedance.android.livesdkapi.service.IMiddlewareInnerLiveFloatWindowService
    public boolean floatWindowIsShowing() {
        List<IInnerFloatWindowManager> r100 = getManagers();
        if (r100 != null) goto L5;
        return false;
    L5:
        Iterator<IInnerFloatWindowManager> r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L13;
        IInnerFloatWindowManager r102 = r101.next();
        if (r102 == null) goto L7;
        if (r102.floatWindowIsShowing() != true) goto L7;
        return true;
    L13:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.service.IInnerLiveFloatWindowService
    public String getFloatWindowTag() {
        List<IInnerFloatWindowManager> r100 = getManagers();
        if (r100 != null) goto L5;
        return "";
    L5:
        Iterator<IInnerFloatWindowManager> r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L30;
        IInnerFloatWindowManager r102 = r101.next();
        if (r102 == null) goto L7;
        if (r102.floatWindowEntityExists() == false) goto L7;
        if ((r102 instanceof IInnerFloatWindowSceneInterceptor) == true) goto L15;
        r102 = null;
    L15:
        IInnerFloatWindowSceneInterceptor r103 = (IInnerFloatWindowSceneInterceptor) r102;
        if (r103 == null) goto L28;
        String r104 = r103.tag();
        if (r104 != null) goto L21;
        return "";
    L21:
        return r104;
    L28:
        return "";
    L30:
        return "";
    }

    @Override // com.bytedance.android.livesdkapi.service.IInnerLiveFloatWindowService
    public void addVideoFloatManagerListener(IVideoFloatManager.VideoFloatManagerListener r100) {
        List<IInnerFloatWindowManager> r101 = getManagers();
        if (r101 != null) goto L5;
        return;
    L5:
        Iterator<IInnerFloatWindowManager> r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        IInnerFloatWindowManager r103 = r102.next();
        if (r103 == null) goto L7;
        r103.addVideoFloatManagerListener(r100);
        goto L7
    }

    @Override // com.bytedance.android.livesdkapi.service.IInnerLiveFloatWindowService
    public void dismissFloatWindow(String r110) {
        Intrinsics.checkNotNullParameter(r110, "reason");
        List<IInnerFloatWindowManager> r100 = getManagers();
        if (r100 != null) goto L5;
        return;
    L5:
        Iterator<IInnerFloatWindowManager> r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L13;
        IInnerFloatWindowManager r102 = r101.next();
        if (r102 == null) goto L7;
        if (r102.floatWindowEntityExists() == false) goto L7;
        IInnerFloatWindowManager.DefaultImpls.dismissFloatWindow$default(r102, 0, null, false, 7, null);
        f.a(r110);
        goto L7
    }

    @Override // com.bytedance.android.livesdkapi.service.IInnerLiveFloatWindowService
    public void removeVideoFloatManagerListener(IVideoFloatManager.VideoFloatManagerListener r100) {
        List<IInnerFloatWindowManager> r101 = getManagers();
        if (r101 != null) goto L5;
        return;
    L5:
        Iterator<IInnerFloatWindowManager> r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        IInnerFloatWindowManager r103 = r102.next();
        if (r103 == null) goto L7;
        r103.removeVideoFloatManagerListener(r100);
        goto L7
    }

    @Override // com.bytedance.android.livesdkapi.service.IMiddlewareInnerLiveFloatWindowService
    public void showLiveSteamFloatWindow(IRoom r100, FloatWindowConfig r101) {
        Intrinsics.checkNotNullParameter(r101, "floatWindowConfig");
        List<IInnerFloatWindowManager> r102 = getManagers();
        if (r102 != null) goto L5;
        return;
    L5:
        Iterator<IInnerFloatWindowManager> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        IInnerFloatWindowManager r104 = r103.next();
        if ((r104 instanceof VideoWatchingInnerFloatWindowManager) == false) goto L7;
        ((VideoWatchingInnerFloatWindowManager) r104).showFloat(r100, r101);
        goto L7
    }
}
