package com.bytedance.android.livesdkapi.depend.drawsomething;

import android.content.Context;

/* JADX INFO: loaded from: classes12.dex */
public interface ILiveGuessDrawParser {
    void parseSeiData(String r100);

    void start(Context r100, int r101, int r102, ILiveGuessDrawPanelController r103);

    void stop();
}
