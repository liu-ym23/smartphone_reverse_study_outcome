package com.byted.mgl.merge.service.api.privacy.audio;

import android.media.AudioRecord;

/* JADX INFO: loaded from: classes43.dex */
public interface IPrivacyAudio {
    void release(AudioRecord r100, String r101) throws IllegalAccessException;

    void startRecording(AudioRecord r100, String r101) throws IllegalAccessException;

    void stop(AudioRecord r100, String r101) throws IllegalAccessException;
}
