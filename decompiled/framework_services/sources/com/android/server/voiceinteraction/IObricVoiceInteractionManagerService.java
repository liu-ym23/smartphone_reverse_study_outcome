package com.android.server.voiceinteraction;

import android.os.Bundle;
import com.obric.utils.IObricBase;

/* JADX INFO: loaded from: classes3.dex */
public interface IObricVoiceInteractionManagerService extends IObricBase {
    default int adjustSessionSourceFlags(Bundle args, int sourceFlags) {
        return sourceFlags | 3;
    }

    default void fillActiveServiceDisplayId(Bundle args) {
    }
}
