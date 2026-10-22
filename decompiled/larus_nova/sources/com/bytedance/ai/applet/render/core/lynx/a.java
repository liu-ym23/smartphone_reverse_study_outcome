package com.bytedance.ai.applet.render.core.lynx;

import androidx.core.util.Consumer;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;

/* JADX INFO: loaded from: classes43.dex */
public interface a {
    void sendMessage(JavaOnlyMap r100, Long r101);

    void setMessageHandle(Consumer<ReadableMap> r100);
}
