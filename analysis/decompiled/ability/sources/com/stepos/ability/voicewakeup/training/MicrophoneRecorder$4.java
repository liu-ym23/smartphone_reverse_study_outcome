package com.stepos.ability.voicewakeup.training;

import H4.n;
import H4.o;
import S7.k;
import android.media.AudioRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final /* synthetic */ class MicrophoneRecorder$4 extends FunctionReferenceImpl implements k {

    /* renamed from: a, reason: collision with root package name */
    public static final MicrophoneRecorder$4 f3348a = new MicrophoneRecorder$4();

    public MicrophoneRecorder$4() {
        super(1, o.class, "createTrainingAudioInput", "createTrainingAudioInput(I)Lcom/stepos/ability/voicewakeup/training/TrainingAudioInput;", 1);
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        int iIntValue = ((Number) obj).intValue();
        int minBufferSize = AudioRecord.getMinBufferSize(iIntValue, 16, 2);
        if (minBufferSize <= 0) {
            return null;
        }
        AudioRecord audioRecord = new AudioRecord(6, iIntValue, 16, 2, minBufferSize * 4);
        if (audioRecord.getState() == 1) {
            return new n(audioRecord);
        }
        audioRecord.release();
        return null;
    }
}
