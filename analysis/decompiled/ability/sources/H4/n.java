package H4;

import android.media.AudioRecord;
import android.media.AudioTimestamp;
import com.stepos.ability.voicewakeup.training.TrainingAudioInput;

/* loaded from: classes3.dex */
public final class n implements TrainingAudioInput {

    /* renamed from: a, reason: collision with root package name */
    public final AudioTimestamp f746a = new AudioTimestamp();
    public final /* synthetic */ AudioRecord b;

    public n(AudioRecord audioRecord) {
        this.b = audioRecord;
    }

    @Override // com.stepos.ability.voicewakeup.training.TrainingAudioInput
    public final int read(short[] target, int i) {
        kotlin.jvm.internal.k.f(target, "target");
        return this.b.read(target, 0, i);
    }

    @Override // com.stepos.ability.voicewakeup.training.TrainingAudioInput
    public final void release() {
        this.b.release();
    }

    @Override // com.stepos.ability.voicewakeup.training.TrainingAudioInput
    public final boolean start() throws IllegalStateException {
        AudioRecord audioRecord = this.b;
        audioRecord.startRecording();
        return audioRecord.getRecordingState() == 3;
    }

    @Override // com.stepos.ability.voicewakeup.training.TrainingAudioInput
    public final void stop() throws IllegalStateException {
        this.b.stop();
    }

    @Override // com.stepos.ability.voicewakeup.training.TrainingAudioInput
    public final p timestamp() {
        AudioRecord audioRecord = this.b;
        AudioTimestamp audioTimestamp = this.f746a;
        if (audioRecord.getTimestamp(audioTimestamp, 0) == 0) {
            return new p(audioTimestamp.framePosition, audioTimestamp.nanoTime);
        }
        return null;
    }
}
