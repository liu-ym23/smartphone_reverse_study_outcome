package com.zyql.ai.selector.camera;

import android.media.AudioRecord;
import j6.C4771a;

/* loaded from: classes4.dex */
public class CheckPermission {
    public static final int STATE_NO_PERMISSION = -2;
    public static final int STATE_RECORDING = -1;
    public static final int STATE_SUCCESS = 1;

    public static int getRecordState() throws IllegalStateException {
        int minBufferSize = AudioRecord.getMinBufferSize(C4771a.SAMPLE_RATE, 16, 2);
        AudioRecord audioRecord = new AudioRecord(0, C4771a.SAMPLE_RATE, 16, 2, minBufferSize * 100);
        short[] sArr = new short[minBufferSize];
        try {
            audioRecord.startRecording();
            if (audioRecord.getRecordingState() != 3) {
                audioRecord.stop();
                audioRecord.release();
                return -1;
            }
            if (audioRecord.read(sArr, 0, minBufferSize) <= 0) {
                audioRecord.stop();
                audioRecord.release();
                return -2;
            }
            audioRecord.stop();
            audioRecord.release();
            return 1;
        } catch (Exception unused) {
            audioRecord.release();
            return -2;
        }
    }
}
