package androidx.camera.video.internal.audio;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
interface AudioStreamFactory {
    AudioStream create(AudioSettings r100, Context r101) throws AudioStream.AudioStreamException;
}
