package com.stepos.aiengine.algorithm.asr;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/aiengine/algorithm/asr/IAsrRealtimeRecognizer;", "", "Lcom/stepos/aiengine/algorithm/asr/AsrRealtimeRecognitionListener;", "listener", "", "openChannel", "(Lcom/stepos/aiengine/algorithm/asr/AsrRealtimeRecognitionListener;)Z", "", "pcmData", "", "sampleRate", "channelCount", "writePcmData", "([BII)Z", "LY8/t;", "closeChannel", "()V", "isOpen", "()Z", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IAsrRealtimeRecognizer {
    void closeChannel();

    boolean isOpen();

    boolean openChannel(AsrRealtimeRecognitionListener listener);

    boolean writePcmData(byte[] pcmData, int sampleRate, int channelCount);
}
