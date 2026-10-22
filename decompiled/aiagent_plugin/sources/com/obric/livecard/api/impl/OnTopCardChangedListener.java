package com.obric.livecard.api.impl;

import com.obric.livecard.api.entity.IslandSession;

/* JADX INFO: compiled from: OnTopCardChangedListener.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface OnTopCardChangedListener extends OnLiveCardServiceDiedListener {
    void onTopSessionChanged(IslandSession r1);
}
