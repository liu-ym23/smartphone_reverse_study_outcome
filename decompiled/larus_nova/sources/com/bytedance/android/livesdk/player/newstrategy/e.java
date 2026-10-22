package com.bytedance.android.livesdk.player.newstrategy;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.player.State;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerEventObserver;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements ILivePlayerEventObserver {
    public e() {
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerEventObserver
    public final void onPlayerCreate(ILivePlayerClient r100) {
        Intrinsics.checkNotNullParameter(r100, "player");
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerEventObserver
    public final void onRelease() {
        ILivePlayerEventObserver.DefaultImpls.onRelease(this);
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerEventObserver
    public final void onStallEnd() {
        ILivePlayerEventObserver.DefaultImpls.onStallEnd(this);
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerEventObserver
    public final void onStallStart() {
        ILivePlayerEventObserver.DefaultImpls.onStallStart(this);
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerEventObserver
    public final void onVideoRenderStall() {
        ILivePlayerEventObserver.DefaultImpls.onVideoRenderStall(this);
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerEventObserver
    public final void onForeground(State r100) {
        Intrinsics.checkNotNullParameter(r100, "curState");
        ILivePlayerEventObserver.DefaultImpls.onForeground(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerEventObserver
    public final void onPlaying(ILivePlayerClient r100) {
        Intrinsics.checkNotNullParameter(r100, "player");
        ILivePlayerEventObserver.DefaultImpls.onPlaying(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerEventObserver
    public final void onStreamTrafficOverUsed(ILivePlayerClient r100) {
        StringBuilder r101 = new StringBuilder("onStreamTrafficOverUsed,id:");
        if (r100 == null) goto L5;
        String r102 = r100.identifier();
    L6:
        r101.append(r102);
        ALogger.i("LiveTrafficUtil", r101.toString());
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerEventObserver
    public final void onMonitorLog(ILivePlayerClient r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "player");
        Intrinsics.checkNotNullParameter(r101, "message");
        ILivePlayerEventObserver.DefaultImpls.onMonitorLog(this, r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerEventObserver
    public final void onStreamPreparePlay(ILivePlayerClient r100, LiveRequest r101) {
        Intrinsics.checkNotNullParameter(r100, "player");
        Intrinsics.checkNotNullParameter(r101, "request");
        ILivePlayerEventObserver.DefaultImpls.onStreamPreparePlay(this, r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerEventObserver
    public final void onBackground(State r100, String r101, ILivePlayerScene r102) {
        Intrinsics.checkNotNullParameter(r100, "curState");
        Intrinsics.checkNotNullParameter(r101, "currentResolution");
        Intrinsics.checkNotNullParameter(r102, "scene");
        ILivePlayerEventObserver.DefaultImpls.onBackground(this, r100, r101, r102);
    }
}
