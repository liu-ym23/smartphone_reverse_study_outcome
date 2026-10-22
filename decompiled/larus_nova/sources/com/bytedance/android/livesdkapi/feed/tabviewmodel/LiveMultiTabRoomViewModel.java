package com.bytedance.android.livesdkapi.feed.tabviewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010*\u001a\u00020+J\u0006\u0010\u0010\u001a\u00020+J\b\u0010,\u001a\u00020+H\u0014J\u0006\u0010-\u001a\u00020+J\b\u0010$\u001a\u00020+H\u0002J\u0006\u0010&\u001a\u00020+J\u0006\u0010.\u001a\u00020+J\u000e\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020\u0005J\u000e\u00101\u001a\u00020+2\u0006\u0010\"\u001a\u00020\u0005J\u000e\u0010(\u001a\u00020+2\u0006\u00102\u001a\u00020\fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00118F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u000e\u0010!\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\u00118F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0013R\u000e\u0010#\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u00118F¢\u0006\u0006\u001a\u0004\b%\u0010\u0013R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u00118F¢\u0006\u0006\u001a\u0004\b'\u0010\u0013R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\f0\u00118F¢\u0006\u0006\u001a\u0004\b)\u0010\u0013¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/tabviewmodel/LiveMultiTabRoomViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_closeLiveRoom", "Landroidx/lifecycle/MutableLiveData;", "", "_drawerChange", "Lcom/bytedance/android/livesdkapi/feed/tabviewmodel/NextLiveData;", "_isTabExpand", "_onGuideReady", "_onSurfaceReady", "_showGuide", "", "cleanGuideUse", "getCleanGuideUse", "()Landroidx/lifecycle/MutableLiveData;", "closeLiveRoom", "Landroidx/lifecycle/LiveData;", "getCloseLiveRoom", "()Landroidx/lifecycle/LiveData;", "drawerChange", "getDrawerChange", "hasFirstEnter", "getHasFirstEnter", "()Z", "setHasFirstEnter", "(Z)V", "hasShowSlideTip", "getHasShowSlideTip", "setHasShowSlideTip", "hasTabChanged", "getHasTabChanged", "setHasTabChanged", "isFirstFrame", "isTabExpand", "isWidgetLoaded", "onGuideReady", "getOnGuideReady", "onSurfaceReady", "getOnSurfaceReady", "showGuide", "getShowGuide", "clearAll", "", "onCleared", LynxVideoManagerLite.EVENT_ON_FIRST_FRAME, "onWidgetLoaded", "setIsDrawerChange", "isChange", "setIsTabExpand", "type", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMultiTabRoomViewModel extends ViewModel {
    private MutableLiveData<Boolean> _closeLiveRoom;
    private NextLiveData<Boolean> _drawerChange;
    private MutableLiveData<Boolean> _isTabExpand;
    private NextLiveData<Boolean> _onGuideReady;
    private NextLiveData<Boolean> _onSurfaceReady;
    private NextLiveData<Integer> _showGuide;
    private final MutableLiveData<Boolean> cleanGuideUse;
    private boolean hasFirstEnter;
    private boolean hasShowSlideTip;
    private boolean hasTabChanged;
    private boolean isFirstFrame;
    private boolean isWidgetLoaded;

    public final void clearAll() {
        this.hasFirstEnter = false;
        this.hasTabChanged = false;
        this._isTabExpand = new MutableLiveData();
        this._drawerChange = new NextLiveData();
        this._showGuide = new NextLiveData();
        this._closeLiveRoom = new NextLiveData();
        this._onGuideReady = new NextLiveData();
        this._onSurfaceReady = new NextLiveData();
    }

    public final void onFirstFrame() {
        this.isFirstFrame = true;
        onGuideReady();
    }

    public final void onWidgetLoaded() {
        this.isWidgetLoaded = true;
        onGuideReady();
    }

    private final void onGuideReady() {
        if (this.isWidgetLoaded == true) goto L5;
        return;
    L5:
        if (this.isFirstFrame == false) goto L9;
        this._onGuideReady.setValue(Boolean.TRUE);
        this.isWidgetLoaded = false;
        this.isFirstFrame = false;
        return;
    }

    public final void closeLiveRoom() {
        this._closeLiveRoom.setValue(Boolean.TRUE);
    }

    public final void onSurfaceReady() {
        this._onSurfaceReady.setValue(Boolean.TRUE);
    }

    public LiveMultiTabRoomViewModel() {
        this._isTabExpand = new MutableLiveData();
        this._drawerChange = new NextLiveData();
        this._showGuide = new NextLiveData();
        this._onGuideReady = new NextLiveData();
        this._onSurfaceReady = new NextLiveData();
        this._closeLiveRoom = new MutableLiveData();
        this.cleanGuideUse = new MutableLiveData();
    }

    public final MutableLiveData<Boolean> getCleanGuideUse() {
        return this.cleanGuideUse;
    }

    public final LiveData<Boolean> getCloseLiveRoom() {
        return this._closeLiveRoom;
    }

    public final LiveData<Boolean> getDrawerChange() {
        return this._drawerChange;
    }

    public final boolean getHasFirstEnter() {
        return this.hasFirstEnter;
    }

    public final boolean getHasShowSlideTip() {
        return this.hasShowSlideTip;
    }

    public final boolean getHasTabChanged() {
        return this.hasTabChanged;
    }

    public final LiveData<Boolean> getOnGuideReady() {
        return this._onGuideReady;
    }

    public final LiveData<Boolean> getOnSurfaceReady() {
        return this._onSurfaceReady;
    }

    public final LiveData<Integer> getShowGuide() {
        return this._showGuide;
    }

    public final LiveData<Boolean> isTabExpand() {
        return this._isTabExpand;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
    }

    public final void setHasFirstEnter(boolean r100) {
        this.hasFirstEnter = r100;
    }

    public final void setHasShowSlideTip(boolean r100) {
        this.hasShowSlideTip = r100;
    }

    public final void setHasTabChanged(boolean r100) {
        this.hasTabChanged = r100;
    }

    public final void setIsDrawerChange(boolean r100) {
        this._drawerChange.setValue(Boolean.valueOf(r100));
    }

    public final void setIsTabExpand(boolean r100) {
        this._isTabExpand.setValue(Boolean.valueOf(r100));
    }

    public final void showGuide(int r100) {
        this._showGuide.setValue(Integer.valueOf(r100));
    }
}
