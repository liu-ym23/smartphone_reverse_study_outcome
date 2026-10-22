package androidx.camera.video.internal.encoder;

/* JADX INFO: loaded from: classes2.dex */
public interface EncoderCallback {
    public static final EncoderCallback EMPTY = null;

    /* JADX INFO: renamed from: androidx.camera.video.internal.encoder.EncoderCallback$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onEncodePaused(EncoderCallback r100) {
        }
    }

    void onEncodeError(EncodeException r100);

    void onEncodePaused();

    void onEncodeStart();

    void onEncodeStop();

    void onEncodedData(EncodedData r100);

    void onOutputConfigUpdate(OutputConfig r100);

    static {
        EMPTY = new AnonymousClass1();
    }
}
