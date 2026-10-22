package androidx.camera.video.internal.encoder;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public interface EncoderFactory {
    Encoder createEncoder(Executor r100, EncoderConfig r101) throws InvalidConfigException;
}
