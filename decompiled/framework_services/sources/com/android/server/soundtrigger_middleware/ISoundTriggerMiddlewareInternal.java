package com.android.server.soundtrigger_middleware;

import android.media.soundtrigger_middleware.ISoundTriggerCallback;
import android.media.soundtrigger_middleware.ISoundTriggerModule;
import android.media.soundtrigger_middleware.SoundTriggerModuleDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public interface ISoundTriggerMiddlewareInternal {
    ISoundTriggerModule attach(int r1, ISoundTriggerCallback r2, boolean r3);

    SoundTriggerModuleDescriptor[] listModules();
}
