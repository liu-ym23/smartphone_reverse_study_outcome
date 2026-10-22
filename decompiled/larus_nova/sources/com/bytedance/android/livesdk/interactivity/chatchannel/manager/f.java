package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import android.os.Handler;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public final class f implements IPlayerActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChatChannelAnimManager.b f134300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IPlayerActionListener f134301b;

    @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
    public final /* synthetic */ void onFirstFrame() {
        IPlayerActionListener.CC.$default$onFirstFrame(this);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
    public final /* synthetic */ void onReportPlayMetrics(Map r100) {
        IPlayerActionListener.CC.$default$onReportPlayMetrics(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
    public final void onEnd() {
        ChatChannelAnimManager r100 = this.f134300a.f134179h;
        int r101 = ChatChannelAnimManager.f134162e;
        r100.getClass();
        ChatChannelAnimManager.e("onEnd");
        this.f134301b.onEnd();
        ChatChannelAnimManager.b r102 = this.f134300a;
        if (r102.f134174c == true) goto L5;
        r102.f134174c = true;
        Handler r103 = r102.f134179h.d();
        ChatChannelAnimManager.b r104 = this.f134300a;
        r103.postDelayed(r104.f134175d, r104.f134178g);
    L5:
        ChatChannelAnimManager.b r105 = this.f134300a;
        ChatChannelAnimManager.c(r105.f134179h, r105);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
    public final void onStart() {
        ChatChannelAnimManager r100 = this.f134300a.f134179h;
        int r101 = ChatChannelAnimManager.f134162e;
        r100.getClass();
        ChatChannelAnimManager.e(WidgetCostModule.TYPE_ON_START);
        this.f134301b.onStart();
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
    public final void onStop() {
        this.f134301b.onStop();
    }

    public f(ChatChannelAnimManager.b r100, IPlayerActionListener r101) {
        this.f134300a = r100;
        this.f134301b = r101;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
    public final void onFileLoaded(int r100, int r101) {
        this.f134301b.onFileLoaded(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
    public final void updateTextEffectPosition(float r100, float r101, float r102, float r103) {
        this.f134301b.updateTextEffectPosition(r100, r101, r102, r103);
    }
}
