package com.stepos.ability.voicewakeup.service;

import android.content.Context;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class VoiceWakeupInit_Factory implements InterfaceC2137b {
    private final InterfaceC2137b contextProvider;

    private VoiceWakeupInit_Factory(InterfaceC2137b interfaceC2137b) {
        this.contextProvider = interfaceC2137b;
    }

    public static VoiceWakeupInit_Factory create(InterfaceC2137b interfaceC2137b) {
        return new VoiceWakeupInit_Factory(interfaceC2137b);
    }

    public static VoiceWakeupInit newInstance(Context context) {
        return new VoiceWakeupInit(context);
    }

    @Override // javax.inject.Provider
    public VoiceWakeupInit get() {
        return newInstance((Context) this.contextProvider.get());
    }
}
