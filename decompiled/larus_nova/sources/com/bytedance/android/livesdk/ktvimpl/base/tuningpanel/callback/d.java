package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes10.dex */
public final class d<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KSongTuningButtonOuterCallback f143484a;

    public d(KSongTuningButtonOuterCallback r100) {
        this.f143484a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        this.f143484a.g();
    }
}
