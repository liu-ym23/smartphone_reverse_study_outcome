package com.byted.cast.common.api;

import android.media.AudioRecord;

/* JADX INFO: loaded from: classes39.dex */
public interface IAudioRecordAdapter {
    void releaseAudioRecord(AudioRecord r100);

    void startAudioRecord(AudioRecord r100);

    void stopAudioRecord(AudioRecord r100);
}
