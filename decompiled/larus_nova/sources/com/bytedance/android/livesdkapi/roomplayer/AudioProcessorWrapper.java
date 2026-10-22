package com.bytedance.android.livesdkapi.roomplayer;

import com.ss.ttvideoengine.model.SubInfo;
import java.nio.ByteBuffer;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J(\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H&J/\u0010\u000b\u001a\u00020\u00042\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H&¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0007H&J\b\u0010\u0015\u001a\u00020\u0004H&¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/AudioProcessorWrapper;", "", "()V", "audioClose", "", "audioOpen", "samplerate", "", "channels", "duration", SubInfo.KEY_FORMAT, "audioProcess", "inout", "", "Ljava/nio/ByteBuffer;", "samples", "timestamp", "", "([Ljava/nio/ByteBuffer;IJ)V", "audioRelease", "reason", "audioUnbind", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AudioProcessorWrapper {
    public AudioProcessorWrapper() {
    }

    public abstract void audioClose();

    public abstract void audioOpen(int r100, int r101, int r102, int r103);

    public abstract void audioProcess(ByteBuffer[] r100, int r101, long r102);

    public abstract void audioRelease(int r100);

    public abstract void audioUnbind();
}
