package com.obric.aiagent.product.platform.api.memory;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: compiled from: IObricMemoryManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IObricMemoryManager {
    void doMemoryAction(int r1, Bundle r2);

    void doMemoryActionIfEnabled(int r1, Bundle r2, Context r3);

    void doScenePerceptionAction(int r1, Bundle r2);

    String getKEY_IMAGE_URI();

    String getKEY_PACKAGE();

    String getKEY_TEXT();

    String getKEY_TIMESTAMP();

    void registerMemoryActionCallback(ObricMemoryActionCallback r1);

    void registerScenePerceptionCallback(ObricScenePerceptionCallback r1);

    void registerSystemEventCallback(ObricSystemEventCallback r1);

    void reportScenePerceptionEvent(int r1, Bundle r2);

    void reportSystemEvent(int r1, int r2, Bundle r3);

    void unregisterMemoryActionCallback();

    void unregisterScenePerceptionCallback();

    void unregisterSystemEventCallback();
}
