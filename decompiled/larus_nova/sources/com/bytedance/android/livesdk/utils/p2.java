package com.bytedance.android.livesdk.utils;

import androidx.camera.video.AudioStats;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import kotlin.Pair;

/* JADX INFO: loaded from: classes11.dex */
public final class p2<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f159111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LiveData f159112b;

    public p2(MediatorLiveData r100, LiveData r101) {
        this.f159111a = r100;
        this.f159112b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Double r101 = (Double) r100;
        MediatorLiveData r102 = this.f159111a;
        Double r103 = (Double) this.f159112b.getValue();
        if (r103 != null) goto L5;
        r103 = Double.valueOf(q2.f159126a);
    L5:
        if (r101 == null) goto L7;
        double r104 = r101.doubleValue();
    L8:
        r102.setValue(new Pair(r103, Double.valueOf(r104)));
        return;
    L7:
        r104 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L8
    }
}
