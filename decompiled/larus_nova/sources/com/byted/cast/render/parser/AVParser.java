package com.byted.cast.render.parser;

import com.byted.cast.mediacommon.render.parameters.CodecId;
import com.ss.android.ttvecamera.TECameraUtils;

/* JADX INFO: loaded from: classes43.dex */
public class AVParser {
    private static final String TAG = "Parser";
    private CodecId codecId;
    private int height;
    private IMediaParserListener listener;
    private int width;

    public boolean release() {
        return true;
    }

    public void sendStream(byte[] r100) {
    }

    public AVParser() {
        this.width = TECameraUtils.CAPTURE_NORMAL;
        this.height = 1080;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setMediaParserListener(IMediaParserListener r100) {
        this.listener = r100;
    }

    public void setVideoCodecId(CodecId r100) {
        this.codecId = r100;
    }

    public void sendAudioPacket(byte[] r100, long r101) {
        this.listener.OnAudioPacketAvalibale(r100, r101);
    }

    public void sendVideoPacket(byte[] r100, long r101) {
        NAL r102 = new NAL(r100, r100.length, this.codecId);
        NAL.detectNALType(r102);
        if (r102.type != 7) goto L5;
        r101 = 0;
    L5:
        this.listener.OnVideoPacketAvalibale(r100, r101);
    }
}
