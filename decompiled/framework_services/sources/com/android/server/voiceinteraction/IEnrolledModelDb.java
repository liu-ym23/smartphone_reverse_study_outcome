package com.android.server.voiceinteraction;

import android.hardware.soundtrigger.SoundTrigger;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
public interface IEnrolledModelDb {
    boolean deleteKeyphraseSoundModel(int r1, int r2, String r3);

    void dump(PrintWriter r1);

    SoundTrigger.KeyphraseSoundModel getKeyphraseSoundModel(int r1, int r2, String r3);

    SoundTrigger.KeyphraseSoundModel getKeyphraseSoundModel(String r1, int r2, String r3);

    boolean updateKeyphraseSoundModel(SoundTrigger.KeyphraseSoundModel r1);
}
