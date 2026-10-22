package com.bytedance.android.live.profit.player;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener;
import com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements IPlayerActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ITextureViewPlayerController f88321a;

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
        ALogger.i("EnterEffectProfilePreview", "onEnd");
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
    public final void onStart() {
        ALogger.i("EnterEffectProfilePreview", WidgetCostModule.TYPE_ON_START);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
    public final void onStop() {
        ALogger.i("EnterEffectProfilePreview", "onStop");
    }

    public b(ITextureViewPlayerController r100) {
        this.f88321a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
    public final void onFileLoaded(int r100, int r101) {
        ALogger.i("EnterEffectProfilePreview", "file loaded");
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
    public final void updateTextEffectPosition(float r100, float r101, float r102, float r103) {
        ALogger.i("EnterEffectProfilePreview", "update text effect position");
        View r104 = this.f88321a.getAlphaView();
        if (r104 == null) goto L8;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L9;
        r105.width = (int) r100;
        r105.height = (int) r101;
        r104.setLayoutParams(r105);
        return;
    L9:
        return;
    }
}
