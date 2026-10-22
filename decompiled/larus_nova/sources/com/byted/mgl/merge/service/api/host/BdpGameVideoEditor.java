package com.byted.mgl.merge.service.api.host;

import android.util.Size;

/* JADX INFO: loaded from: classes43.dex */
public interface BdpGameVideoEditor {
    int addAudioTrack(String r100, int r101, int r102, int r103, int r104);

    int addImageSticker(String r100, float r101, float r102, float r103, float r104);

    boolean cancel();

    boolean compile(String r100, Size r101, BdpGameVideoEditorListener r102);

    void destroy();

    int init(String[] r100, int[] r101, int[] r102, String[] r103, float[] r104);

    int prepare();

    int run(String r100, BdpGameVideoEditorListener r101);
}
