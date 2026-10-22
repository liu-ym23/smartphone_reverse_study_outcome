package com.android.server.soundtrigger_middleware;

/* JADX INFO: loaded from: classes3.dex */
class AudioSessionProviderImpl extends SoundTriggerMiddlewareImpl.AudioSessionProvider {
    @Override // com.android.server.soundtrigger_middleware.SoundTriggerMiddlewareImpl.AudioSessionProvider
    public native SoundTriggerMiddlewareImpl.AudioSessionProvider.AudioSession acquireSession();

    @Override // com.android.server.soundtrigger_middleware.SoundTriggerMiddlewareImpl.AudioSessionProvider
    public native void releaseSession(int r1);

    AudioSessionProviderImpl() {
    }
}
