package com.bytedance.android.livesdk.utils;

import androidx.camera.video.AudioStats;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import kotlin.Pair;

/* JADX INFO: loaded from: classes11.dex */
public final class o2<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f159103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LiveData f159104b;

    public o2(MediatorLiveData r100, LiveData r101) {
        this.f159103a = r100;
        this.f159104b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Double r101 = (Double) r100;
        MediatorLiveData r102 = this.f159103a;
        if (r101 == null) goto L5;
        double r103 = r101.doubleValue();
    L6:
        Double r104 = Double.valueOf(r103);
        Double r105 = (Double) this.f159104b.getValue();
        if (r105 != null) goto L9;
        r105 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
    L9:
        r102.setValue(new Pair(r104, r105));
        return;
    L5:
        r103 = q2.f159126a;
        goto L6
    }
}
