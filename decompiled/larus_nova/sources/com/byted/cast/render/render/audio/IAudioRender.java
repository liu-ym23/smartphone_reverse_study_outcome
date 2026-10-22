package com.byted.cast.render.render.audio;

import com.byted.cast.render.render.IRender;

/* JADX INFO: loaded from: classes43.dex */
public interface IAudioRender extends IRender {
    void config_audio_parameters(int r100, int r101, int r102);

    float getMaxVol();

    float getMinVol();

    void setVolume(float r100);
}
