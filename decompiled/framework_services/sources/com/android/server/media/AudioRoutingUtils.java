package com.android.server.media;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.audiopolicy.AudioProductStrategy;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
final class AudioRoutingUtils {
    static final AudioAttributes ATTRIBUTES_MEDIA = null;

    static {
        ATTRIBUTES_MEDIA = new AudioAttributes.Builder().setUsage(1).build();
    }

    static AudioProductStrategy getMediaAudioProductStrategy() {
        Iterator r0 = AudioManager.getAudioProductStrategies().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        AudioProductStrategy strategy = (AudioProductStrategy) r0.next();
        if (strategy.supportsAudioAttributes(ATTRIBUTES_MEDIA) == false) goto L4;
        return strategy;
    L9:
        return null;
    }

    private AudioRoutingUtils() {
    }
}
