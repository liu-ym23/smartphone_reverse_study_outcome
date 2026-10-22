package com.android.server.soundtrigger_middleware;

import android.media.soundtrigger.ModelParameterRange;
import android.media.soundtrigger.PhraseSoundModel;
import android.media.soundtrigger.Properties;
import android.media.soundtrigger.RecognitionConfig;
import android.media.soundtrigger.SoundModel;
import android.media.soundtrigger_middleware.PhraseRecognitionEventSys;
import android.media.soundtrigger_middleware.RecognitionEventSys;
import android.os.IBinder;

/* JADX INFO: loaded from: classes3.dex */
interface ISoundTriggerHal {

    public interface GlobalCallback {
        void onResourcesAvailable();
    }

    public interface ModelCallback {
        void modelUnloaded(int r1);

        void phraseRecognitionCallback(int r1, PhraseRecognitionEventSys r2);

        void recognitionCallback(int r1, RecognitionEventSys r2);
    }

    void clientAttached(IBinder r1);

    void clientDetached(IBinder r1);

    void detach();

    void flushCallbacks();

    void forceRecognitionEvent(int r1);

    int getModelParameter(int r1, int r2);

    Properties getProperties();

    String interfaceDescriptor();

    void linkToDeath(IBinder.DeathRecipient r1);

    int loadPhraseSoundModel(PhraseSoundModel r1, ModelCallback r2);

    int loadSoundModel(SoundModel r1, ModelCallback r2);

    ModelParameterRange queryParameter(int r1, int r2);

    void reboot();

    void registerCallback(GlobalCallback r1);

    void setModelParameter(int r1, int r2, int r3);

    void startRecognition(int r1, int r2, int r3, RecognitionConfig r4);

    void stopRecognition(int r1);

    void unlinkToDeath(IBinder.DeathRecipient r1);

    void unloadSoundModel(int r1);
}
