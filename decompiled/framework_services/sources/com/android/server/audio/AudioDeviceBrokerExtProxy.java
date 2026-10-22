package com.android.server.audio;

import android.prometheus.ext.core.ExtLoader;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AudioDeviceBrokerExtProxy extends AudioDeviceBrokerExt {
    private final List<AudioDeviceBrokerExt> mExts;

    public static AudioDeviceBrokerExtProxy get(AudioDeviceBroker base) {
        return new AudioDeviceBrokerExtProxy(base);
    }

    public AudioDeviceBrokerExtProxy(AudioDeviceBroker base) {
        this.mExts = ExtLoader.getAll(AudioDeviceBrokerExt.class, base);
    }

    @Override // com.android.server.audio.AudioDeviceBrokerExt
    protected void init_onBegin(AudioService service, BtHelper btHelper) {
        if (this.mExts != null) goto L5;
        return;
    L5:
        Iterator<AudioDeviceBrokerExt> r0 = this.mExts.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        AudioDeviceBrokerExt ext = r0.next();
        ext.init_onBegin(service, btHelper);
        goto L7
    }

    @Override // com.android.server.audio.AudioDeviceBrokerExt
    protected void updateActiveCommunicationDevice_onEnd() {
        if (this.mExts != null) goto L5;
        return;
    L5:
        Iterator<AudioDeviceBrokerExt> r0 = this.mExts.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        AudioDeviceBrokerExt ext = r0.next();
        ext.updateActiveCommunicationDevice_onEnd();
        goto L7
    }
}
