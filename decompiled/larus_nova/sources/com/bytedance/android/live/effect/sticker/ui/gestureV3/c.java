package com.bytedance.android.live.effect.sticker.ui.gestureV3;

import com.ss.android.ugc.effectmanager.effect.listener.IIsTagNeedUpdatedListener;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements IIsTagNeedUpdatedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveGestureMagicAdapterVCD.a f68581a;

    @Override // com.ss.android.ugc.effectmanager.effect.listener.IIsTagNeedUpdatedListener
    public final void onTagNeedNotUpdate() {
        this.f68581a.f68556e.setVisibility(8);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.listener.IIsTagNeedUpdatedListener
    public final void onTagNeedUpdate() {
        this.f68581a.f68556e.setVisibility(0);
    }

    public c(LiveGestureMagicAdapterVCD.a r100) {
        this.f68581a = r100;
    }
}
