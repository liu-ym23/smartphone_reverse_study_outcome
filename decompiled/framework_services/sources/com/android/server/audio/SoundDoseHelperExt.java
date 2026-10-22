package com.android.server.audio;

import android.prometheus.ext.core.ExtLoader;
import android.prometheus.ext.core.ReflectionUtils;

/* JADX INFO: loaded from: classes.dex */
public class SoundDoseHelperExt {
    private static final String TAG = "AS.SoundDoseHelperExt";
    protected final SoundDoseHelper mBase;
    protected final ReflectionUtils mReflectionUtils;

    public static SoundDoseHelperExt get(SoundDoseHelper base) {
        return (SoundDoseHelperExt) ExtLoader.get(SoundDoseHelperExt.class, base);
    }

    public SoundDoseHelperExt(SoundDoseHelper base) {
        this.mBase = base;
        this.mReflectionUtils = new ReflectionUtils(this.mBase);
    }

    public SoundDoseHelperExt(Object base) {
        this((SoundDoseHelper) base);
    }

    public void init_onEnd(AudioService audioService) {
    }

    public void setAbsoluteVolumeForDevice(int streamType, int index, int device) {
    }
}
