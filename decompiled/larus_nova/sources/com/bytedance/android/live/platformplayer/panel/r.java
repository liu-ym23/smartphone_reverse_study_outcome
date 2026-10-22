package com.bytedance.android.live.platformplayer.panel;

import com.bytedance.android.livesdkapi.player.PlayerTaskManager;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes46.dex */
public final class r<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f85784a;

    public r(s r100) {
        this.f85784a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        String r101 = (String) r100;
        if (r101 == null) goto L7;
        PlayerTaskManager.inst().commit(new q(this, r101));
        return;
    }
}
