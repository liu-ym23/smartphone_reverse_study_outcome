package com.android.server.pm;

import android.content.Context;
import com.android.server.art.ArtManagerLocal;

/* JADX INFO: loaded from: classes2.dex */
public interface ISparkDexoptManager {
    default boolean isEnabled() {
        return false;
    }

    default ISparkDexoptManager initialize(Context context, ArtManagerLocal artManagerLocal) {
        return this;
    }

    default void systemReady(boolean seedAfterOta) {
    }
}
