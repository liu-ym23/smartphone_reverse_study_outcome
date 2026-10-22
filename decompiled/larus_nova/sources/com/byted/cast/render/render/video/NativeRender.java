package com.byted.cast.render.render.video;

import android.view.Surface;
import com.byted.cast.mediacommon.render.parameters.MediaParameter;
import com.byted.cast.render.utils.Logger;

/* JADX INFO: loaded from: classes43.dex */
public class NativeRender implements IVideoRender {
    private final String TAG;
    private int colorFormat;
    private String deviceName;
    private int height;
    private int sliceHeight;
    private int stride;
    private Surface surface;
    private final String userId;
    private int width;

    private native void native_config_video_parameters(String r100, int r101, int r102, int r103, int r104, int r105, Surface r106);

    private native void native_init(String r100, String r101, int r102);

    private native void native_isOpenDump(String r100, boolean r101);

    private native void native_render(String r100, byte[] r101, int r102);

    private native void native_setDumpPath(String r100, String r101);

    private native void native_start(String r100);

    private native void native_stop(String r100);

    @Override // com.byted.cast.render.render.IRender
    public Object getParameter(MediaParameter r100) {
        return null;
    }

    @Override // com.byted.cast.render.render.IRender
    public void setParameter(MediaParameter r100, Object r101) {
    }

    @Override // com.byted.cast.render.render.IRender
    public boolean start() {
        native_config_video_parameters(this.userId, this.width, this.height, this.stride, this.sliceHeight, this.colorFormat, this.surface);
        native_start(this.userId);
        Logger.i("NativeRender", "nativeRender start success");
        return true;
    }

    @Override // com.byted.cast.render.render.IRender
    public boolean stop() {
        native_stop(this.userId);
        Logger.i("NativeRender", "nativeRender stop success");
        return true;
    }

    @Override // com.byted.cast.render.render.video.IVideoRender
    public void isOpenDump(boolean r100) {
        native_isOpenDump(this.userId, r100);
    }

    @Override // com.byted.cast.render.render.video.IVideoRender
    public void setDumpPath(String r100) {
        native_setDumpPath(this.userId, r100);
    }

    @Override // com.byted.cast.render.render.video.IVideoRender
    public void setSurface(Surface r100) {
        this.surface = r100;
    }

    @Override // com.byted.cast.render.render.IRender
    public void render(byte[] r100, int r101) {
        native_render(this.userId, r100, r101);
    }

    public NativeRender(String r100, String r101, int r102) {
        this.TAG = "NativeRender";
        this.width = 0;
        this.height = 0;
        this.stride = 0;
        this.sliceHeight = 0;
        this.colorFormat = 19;
        this.userId = r100;
        this.deviceName = r101;
        native_init(r100, r101, r102);
    }

    @Override // com.byted.cast.render.render.video.IVideoRender
    public void config_video_parameters(int r100, int r101, int r102, int r103, int r104) {
        this.width = r100;
        this.height = r101;
        this.stride = r102;
        this.sliceHeight = r103;
        this.colorFormat = r104;
    }
}
