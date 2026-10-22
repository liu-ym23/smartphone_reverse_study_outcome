package com.stepos.ailauncher.contract.api.speech;

import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/contract/api/speech/TtsListener;", "", "LY8/t;", "onPlayStarted", "()V", "onPlayStopped", "", "reason", "onStreamInterrupted", "(Ljava/lang/String;)V", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface TtsListener {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void onStreamInterrupted(TtsListener ttsListener, String reason) {
            p.i(reason, "reason");
            TtsListener.super.onStreamInterrupted(reason);
        }
    }

    void onPlayStarted();

    void onPlayStopped();

    default void onStreamInterrupted(String reason) {
        p.i(reason, "reason");
    }
}
