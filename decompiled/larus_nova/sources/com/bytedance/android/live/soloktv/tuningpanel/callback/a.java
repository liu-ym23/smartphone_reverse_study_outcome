package com.bytedance.android.live.soloktv.tuningpanel.callback;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class a<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SoloKtvTuningButtonOuterCallback f101570a;

    public a(SoloKtvTuningButtonOuterCallback r100) {
        this.f101570a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        SoloKtvTuningButtonOuterCallback r101 = this.f101570a;
        SoloKtvTuningButtonOuterCallback.f(r101, (Boolean) r100);
    }
}
