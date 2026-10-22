package com.bytedance.android.live.effect.sticker.ui.gestureV3;

import com.ss.android.ugc.effectmanager.effect.listener.IIsTagNeedUpdatedListener;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements IIsTagNeedUpdatedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveGestureMagicAdapterVCD.a f68582a;

    @Override // com.ss.android.ugc.effectmanager.effect.listener.IIsTagNeedUpdatedListener
    public final void onTagNeedNotUpdate() {
        this.f68582a.f68556e.setVisibility(8);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.listener.IIsTagNeedUpdatedListener
    public final void onTagNeedUpdate() {
        this.f68582a.f68556e.setVisibility(0);
    }

    public d(LiveGestureMagicAdapterVCD.a r100) {
        this.f68582a = r100;
    }
}
