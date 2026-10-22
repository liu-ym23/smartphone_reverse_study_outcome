package com.obric.livecard.api.impl;

import android.os.SystemClock;
import com.obric.livecard.api.ITopSessionChangedCallback;
import com.obric.livecard.api.entity.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OnTopCardChangedListener.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TopSessionChangedCallbackImpl extends ITopSessionChangedCallback.Stub implements OnLiveCardServiceDiedListener {
    private final OnTopCardChangedListener delegate;
    private final long tag;

    public TopSessionChangedCallbackImpl(OnTopCardChangedListener r3) {
        OnTopCardChangedListener r4 = (OnTopCardChangedListener) ZeusTransformUtils.wrapperContextForParams(r3, OnTopCardChangedListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "delegate");
        this.delegate = r4;
        this.tag = SystemClock.elapsedRealtime();
    }

    public final OnTopCardChangedListener getDelegate() {
        return this.delegate;
    }

    public final long getTag() {
        return this.tag;
    }

    @Override // com.obric.livecard.api.ITopSessionChangedCallback
    public long getId() {
        return this.tag;
    }

    @Override // com.obric.livecard.api.impl.OnLiveCardServiceDiedListener
    public void onServiceDied() {
        this.delegate.onServiceDied();
    }

    @Override // com.obric.livecard.api.ITopSessionChangedCallback
    public void onTopSessionChanged(IslandSession r1) {
        this.delegate.onTopSessionChanged(r1);
    }
}
