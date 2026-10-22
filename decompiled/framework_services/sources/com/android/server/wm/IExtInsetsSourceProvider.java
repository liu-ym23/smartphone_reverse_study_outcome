package com.android.server.wm;

import android.pico.utils.IExtBase;
import android.util.proto.ProtoOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public interface IExtInsetsSourceProvider extends IExtBase {
    void dumpWriteProto(ProtoOutputStream r1);

    default boolean shouldSkipImeSurfaceVisible() {
        return false;
    }

    default boolean adjustImeInitialVisible(WindowContainer imeParentWindow, InsetsControlTarget target, boolean initiallyVisible) {
        return initiallyVisible;
    }
}
