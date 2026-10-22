package com.bytedance.android.livesdk.utils;

import androidx.camera.video.AudioStats;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.strategy.api.IStrategyService;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes11.dex */
public final class q2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final double f159126a = 0.0d;

    static {
        Double r100 = j40.p2.f497281a.getValue();
        if (r100 == null) goto L5;
        double r101 = r100.doubleValue();
    L6:
        f159126a = r101;
        return;
    L5:
        r101 = -1.0d;
        goto L6
    }

    @JvmStatic
    public static final MediatorLiveData a() {
        IStrategyService r100 = (IStrategyService) jc1.k.f(IStrategyService.class);
        if (r100 == null) goto L6;
        LiveData r101 = IStrategyService.a.a(r100, "inner_slide_angle", Double.valueOf(f159126a), false, 12);
        if (r101 == null) goto L6;
    L7:
        IStrategyService r102 = (IStrategyService) jc1.k.f(IStrategyService.class);
        Double r103 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        if (r102 == null) goto L11;
        LiveData r104 = IStrategyService.a.a(r102, "inner_slide_angle_area_factor", r103, false, 12);
        if (r104 == null) goto L11;
    L12:
        MediatorLiveData r105 = new MediatorLiveData();
        r105.addSource(r101, new o2(r105, r104));
        r105.addSource(r104, new p2(r105, r101));
        return r105;
    L11:
        r104 = new MutableLiveData();
        r104.setValue(r103);
    L6:
        r101 = new MutableLiveData();
        r101.setValue(Double.valueOf(f159126a));
        goto L7
    }
}
