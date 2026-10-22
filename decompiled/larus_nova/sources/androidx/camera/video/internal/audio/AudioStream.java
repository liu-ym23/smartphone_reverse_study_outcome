package androidx.camera.video.internal.audio;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public interface AudioStream {

    public interface AudioStreamCallback {

        /* JADX INFO: renamed from: androidx.camera.video.internal.audio.AudioStream$AudioStreamCallback$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onSilenceStateChanged(AudioStreamCallback r100, boolean r101) {
            }
        }

        void onSilenceStateChanged(boolean r100);
    }

    public static class AudioStreamException extends Exception {
        public AudioStreamException() {
        }

        public AudioStreamException(String r100) {
            super(r100);
        }

        public AudioStreamException(Throwable r100) {
            super(r100);
        }

        public AudioStreamException(String r100, Throwable r101) {
            super(r100, r101);
        }
    }

    public static abstract class PacketInfo {
        public PacketInfo() {
        }

        public abstract int getSizeInBytes();

        public abstract long getTimestampNs();

        public static PacketInfo of(int r100, long r101) {
            return new AutoValue_AudioStream_PacketInfo(r100, r101);
        }
    }

    PacketInfo read(ByteBuffer r100);

    void release();

    void setCallback(AudioStreamCallback r100, Executor r101);

    void start() throws AudioStreamException, IllegalStateException;

    void stop() throws IllegalStateException;
}
