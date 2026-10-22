package com.bytedance.android.live.broadcastgame.opengame.runtime;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class t<T> implements s<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<T> f60845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f60846b;

    public t() {
        this.f60845a = new ArrayList();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.s
    public final List<T> getListeners() {
        return this.f60845a;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.s
    public final void C(T r100) {
        this.f60846b = r100;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.s
    public final void registerListener(T r100) {
        if (((ArrayList) getListeners()).contains(r100) == true) goto L7;
        ((ArrayList) getListeners()).add(r100);
        return;
    }
}
