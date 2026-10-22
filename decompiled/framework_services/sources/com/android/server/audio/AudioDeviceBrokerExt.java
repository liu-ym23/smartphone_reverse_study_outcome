package com.android.server.audio;

/* JADX INFO: loaded from: classes.dex */
public class AudioDeviceBrokerExt {
    public static final String TAG = null;

    static {
        TAG = AudioDeviceBrokerExt.class.getSimpleName();
    }

    public AudioDeviceBrokerExt() {
    }

    public static AudioDeviceBrokerExt get(AudioDeviceBroker base) {
        return AudioDeviceBrokerExtProxy.get(base);
    }

    protected void init_onBegin(AudioService service, BtHelper btHelper) {
    }

    protected void updateActiveCommunicationDevice_onEnd() {
    }
}
