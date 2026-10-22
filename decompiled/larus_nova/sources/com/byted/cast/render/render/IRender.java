package com.byted.cast.render.render;

import com.byted.cast.mediacommon.render.parameters.MediaParameter;

/* JADX INFO: loaded from: classes43.dex */
public interface IRender {
    Object getParameter(MediaParameter r100);

    void render(byte[] r100, int r101);

    void setParameter(MediaParameter r100, Object r101);

    boolean start();

    boolean stop();
}
