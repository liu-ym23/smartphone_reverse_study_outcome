package com.byted.cast.render.render.video;

import android.view.Surface;
import com.byted.cast.render.render.IRender;

/* JADX INFO: loaded from: classes43.dex */
public interface IVideoRender extends IRender {
    void config_video_parameters(int r100, int r101, int r102, int r103, int r104);

    void isOpenDump(boolean r100);

    void setDumpPath(String r100);

    void setSurface(Surface r100);
}
