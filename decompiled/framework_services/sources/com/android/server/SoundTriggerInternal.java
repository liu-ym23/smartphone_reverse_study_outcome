package com.android.server;

import android.hardware.soundtrigger.IRecognitionStatusCallback;
import android.hardware.soundtrigger.SoundTrigger;
import android.media.permission.Identity;
import android.os.IBinder;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface SoundTriggerInternal {
    public static final int STATUS_ERROR = Integer.MIN_VALUE;
    public static final int STATUS_OK = 0;

    public interface Session {
        void detach();

        SoundTrigger.ModuleProperties getModuleProperties();

        int getParameter(int r1, int r2);

        SoundTrigger.ModelParamRange queryParameter(int r1, int r2);

        int setParameter(int r1, int r2, int r3);

        int startRecognition(int r1, SoundTrigger.KeyphraseSoundModel r2, IRecognitionStatusCallback r3, SoundTrigger.RecognitionConfig r4, boolean r5);

        int stopRecognition(int r1, IRecognitionStatusCallback r2);

        int unloadKeyphraseModel(int r1);
    }

    Session attach(IBinder r1, SoundTrigger.ModuleProperties r2, boolean r3);

    List<SoundTrigger.ModuleProperties> listModuleProperties(Identity r1);
}
