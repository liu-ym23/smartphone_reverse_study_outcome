package com.bytedance.android.livesdkapi.player;

import android.hardware.HardwareBuffer;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\u001c\u0010\u001c\u001a\u00020\u00042\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdkapi/player/LivePlayerEventListenerAdapter;", "Lcom/bytedance/android/livesdkapi/player/ILivePlayerEventListener;", "()V", "onBindRenderView", "", "renderView", "Lcom/bytedance/android/livesdkapi/view/IRenderView;", LynxVideoManagerLite.EVENT_ON_FIRST_FRAME, "onHWBDrawFrame", "hardwareBuffer", "Landroid/hardware/HardwareBuffer;", "roi", "", "colorSpace", "", "onMute", "onPlaying", "onPrepare", "onRelease", "onSei", "sei", "", "onStallEvent", "event", "onStartPul", "onStop", "onSurfaceReady", "onUnMute", "onVideoSizeChange", "size", "Lkotlin/Pair;", "openHardwareBufferOutput", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LivePlayerEventListenerAdapter implements ILivePlayerEventListener {
    public LivePlayerEventListenerAdapter() {
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public void onBindRenderView(IRenderView r100) {
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public void onFirstFrame() {
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public void onHWBDrawFrame(HardwareBuffer r100, int[] r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "hardwareBuffer");
        Intrinsics.checkNotNullParameter(r101, "roi");
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public void onMute() {
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public void onPlaying() {
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public void onPrepare() {
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public void onRelease() {
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public void onSei(String r100) {
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public void onStartPul() {
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public void onStop() {
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public void onSurfaceReady() {
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public void onUnMute() {
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public void onVideoSizeChange(Pair<Integer, Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "size");
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public void openHardwareBufferOutput() {
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public String onMuteIssueWarning() {
        return ILivePlayerEventListener.DefaultImpls.onMuteIssueWarning(this);
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public void onStallEvent(int r100) {
        ILivePlayerEventListener.DefaultImpls.onStallEvent(this, r100);
    }
}
