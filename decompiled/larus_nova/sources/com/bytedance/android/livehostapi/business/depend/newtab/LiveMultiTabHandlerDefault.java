package com.bytedance.android.livehostapi.business.depend.newtab;

import android.os.Bundle;
import com.bytedance.android.live.base.model.moreliveentrance.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0016¨\u0006 "}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/newtab/LiveMultiTabHandlerDefault;", "Lcom/bytedance/android/livehostapi/business/depend/newtab/ILiveMultiTabDepend;", "", "canBackMultiTab", "canShowFloatWindow", "hasLiveMultiTab", "canStackRoom", "canInterceptDrawerSlideTips", "", "caller", "Landroid/os/Bundle;", "enterParams", "", "tryBootPreload", "Lcom/bytedance/android/live/base/model/moreliveentrance/b;", "entranceInfo", "dispatchMoreLiveEntranceItem", "floatWindowPauseWhenBackground", "canForceNotSharedLiveClient", "interceptLeftSlideOpenDrawer", "getMoreEntranceTitle", "canSkipCheckResumed", "useNewStop", "enableMoreEntranceMarqueeType", "", "marqueeDelayTime", "enableLiveTab", "whetherUnMuteClientWhenStop", "canFixAudioConflict", "hitNewLiveTabReverse", "<init>", "()V", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMultiTabHandlerDefault implements ILiveMultiTabDepend {
    public static final LiveMultiTabHandlerDefault INSTANCE = null;

    private LiveMultiTabHandlerDefault() {
    }

    @Override // com.bytedance.android.livehostapi.business.depend.newtab.ILiveMultiTabDepend
    public boolean canBackMultiTab() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.newtab.ILiveMultiTabDepend
    public boolean canFixAudioConflict() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.newtab.ILiveMultiTabDepend
    public boolean canForceNotSharedLiveClient() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.newtab.ILiveMultiTabDepend
    public boolean canInterceptDrawerSlideTips() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.newtab.ILiveMultiTabDepend
    public boolean canShowFloatWindow() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.newtab.ILiveMultiTabDepend
    public boolean canSkipCheckResumed() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.newtab.ILiveMultiTabDepend
    public boolean canStackRoom() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.newtab.ILiveMultiTabDepend
    public void dispatchMoreLiveEntranceItem(b r100) {
    }

    @Override // com.bytedance.android.livehostapi.business.depend.newtab.ILiveMultiTabDepend
    public boolean enableLiveTab() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.newtab.ILiveMultiTabDepend
    public boolean enableMoreEntranceMarqueeType() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.newtab.ILiveMultiTabDepend
    public boolean floatWindowPauseWhenBackground() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.newtab.ILiveMultiTabDepend
    public String getMoreEntranceTitle() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.newtab.ILiveMultiTabDepend
    public boolean hasLiveMultiTab() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.newtab.ILiveMultiTabDepend
    public boolean hitNewLiveTabReverse() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.newtab.ILiveMultiTabDepend
    public boolean interceptLeftSlideOpenDrawer() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.newtab.ILiveMultiTabDepend
    public long marqueeDelayTime() {
        return -1;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.newtab.ILiveMultiTabDepend
    public final /* synthetic */ long marqueeSingleInternalDuration() {
        return ILiveMultiTabDepend.CC.$default$marqueeSingleInternalDuration(this);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.newtab.ILiveMultiTabDepend
    public final /* synthetic */ int maxSingleRequestTime() {
        return ILiveMultiTabDepend.CC.$default$maxSingleRequestTime(this);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.newtab.ILiveMultiTabDepend
    public final /* synthetic */ int moreLiveTabRefreshStyle() {
        return ILiveMultiTabDepend.CC.$default$moreLiveTabRefreshStyle(this);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.newtab.ILiveMultiTabDepend
    public void tryBootPreload(String r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "caller");
    }

    @Override // com.bytedance.android.livehostapi.business.depend.newtab.ILiveMultiTabDepend
    public final /* synthetic */ boolean useNewShowStrategy() {
        return ILiveMultiTabDepend.CC.$default$useNewShowStrategy(this);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.newtab.ILiveMultiTabDepend
    public boolean useNewStop() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.newtab.ILiveMultiTabDepend
    public boolean whetherUnMuteClientWhenStop() {
        return false;
    }

    static {
        INSTANCE = new LiveMultiTabHandlerDefault();
    }
}
